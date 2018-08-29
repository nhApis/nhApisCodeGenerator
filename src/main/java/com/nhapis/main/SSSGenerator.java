package com.nhapis.main;

import com.nhapis.template.common.PojoClassFile;
import com.nhapis.template.common.PomXmlResourceFile;
import com.nhapis.template.common.ResultClassFile;
import com.nhapis.template.service.ServiceClassFile;
import com.nhapis.template.service.ServiceInterfaceFile;
import com.nhapis.template.spring.ApplicationClassFile;
import com.nhapis.template.spring.ApplicationYmlResourceFile;
import com.nhapis.template.springdatajpa.RepositoryInterfaceFile;
import com.nhapis.template.springmvc.ControllerClassFile;

/**
 * @author 牛虹
 * @time 2018年07月26日 下午12:07:26
 */
public class SSSGenerator {
    public static void main(String[] args) throws Exception {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("BaseDir:");
//		String baseDir = scanner.next();
        String baseDir = "d:/gener";

//		System.out.print("ProjectName:");
//		String projectName = scanner.next();
        String projectName = "argus-new";


        String resourcesDir = "src/main/resources";
        String javaDir = "src/main/java";
//		System.out.print("PackageDir:");
//		String packageDir = scanner.next();
        String packageDir = "com.nhapis.argus.er.message";

        PomXmlResourceFile pxrf = new PomXmlResourceFile(baseDir + "/" + projectName);
        pxrf.generate();

        ApplicationYmlResourceFile ayrf = new ApplicationYmlResourceFile(baseDir + "/" + projectName + "/" + resourcesDir);
        ayrf.generate();

        ApplicationClassFile acf = new ApplicationClassFile(baseDir + "/" + projectName + "/" + javaDir + "/" + packageDir, toPackage(packageDir));
        acf.generate();

        ResultClassFile rcf = new ResultClassFile(baseDir + "/" + projectName + "/" + javaDir + "/" + packageDir + "/util", toPackage(packageDir), "util");
        rcf.personalGenerate();
        String model;
        String tableName;
        while (true) {
//			System.out.print("PojoName(input \"exit\" to exit):");
            model = "Message";
            tableName = "ga_messages";


//			model = scanner.next();
//			if(model.equals("exit")) {
//				break;
//			}
            PojoClassFile pcf = new PojoClassFile(baseDir + "/" + projectName + "/" + javaDir + "/" + packageDir + "/model", toPackage(packageDir), "model", model, tableName);
            pcf.generate();
            RepositoryInterfaceFile rif = new RepositoryInterfaceFile(baseDir + "/" + projectName + "/" + javaDir + "/" + packageDir + "/repository", toPackage(packageDir), "repository", model);
            rif.generate();
            ServiceInterfaceFile sif = new ServiceInterfaceFile(baseDir + "/" + projectName + "/" + javaDir + "/" + packageDir + "/service", toPackage(packageDir), "service", model);
            sif.generate();
            ServiceClassFile scf = new ServiceClassFile(baseDir + "/" + projectName + "/" + javaDir + "/" + packageDir + "/service/impl", toPackage(packageDir), "service.impl", model);
            scf.generate();
            ControllerClassFile ccf = new ControllerClassFile(baseDir + "/" + projectName + "/" + javaDir + "/" + packageDir + "/controller", toPackage(packageDir), "controller", model);
            ccf.generate();

            break;
        }

        System.out.println("代码生成成功!");
    }

    private static String toPackage(String packageDir) {
        return packageDir.replaceAll("/", ".");
    }
}
