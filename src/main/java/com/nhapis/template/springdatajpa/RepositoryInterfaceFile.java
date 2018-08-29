package com.nhapis.template.springdatajpa;

import com.nhapis.base.JavaFile;
import com.nhapis.util.Common;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 牛虹
 * @time 2017年9月27日 下午3:24:38
 */
public class RepositoryInterfaceFile extends JavaFile {
    private String model;

    private static final String classType = "Repository";

    public RepositoryInterfaceFile(String fileDir, String mainPackage, String curPackage, String model) {
        super(fileDir, Common.getClassName(model, classType).append(".java").toString(), mainPackage + "." + curPackage, INTERFACE_TYPE, Common.getClassName(model, classType).toString());
        this.model = model;
        List<String> imports = new LinkedList<>();
        List<String> classAnnotations = new LinkedList<>();
        List<String> extendss = new LinkedList<>();
        List<String> implementss = new LinkedList<>();
        List<JavaFile.Field> fields = new LinkedList<>();
        List<Method> methods = new LinkedList<>();

        //imports
        imports.add(Common.getImportName(mainPackage, model).toString());
        imports.add("org.springframework.data.jpa.repository.JpaRepository");
        imports.add("org.springframework.data.jpa.repository.JpaSpecificationExecutor");

        //classAnnotations none

        //extendss
        StringBuilder extendsi = new StringBuilder();
        extendsi.append("JpaRepository<");
        extendsi.append(Common.getModelClass(model,Common.modelAppend));
        extendsi.append(",Integer>");
        extendss.add(extendsi.toString());
        extendsi = new StringBuilder();
        extendsi.append("JpaSpecificationExecutor<");
        extendsi.append(Common.getModelClass(model,Common.modelAppend));
        extendsi.append(">");
        extendss.add(extendsi.toString());

        //implementss none

        //fields none

        //methods none

        super.init(imports, classAnnotations, extendss, implementss, fields, methods);
    }
}
