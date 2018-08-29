package com.nhapis.template.service;

import com.nhapis.base.JavaFile;
import com.nhapis.util.Common;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 牛虹
 * @time 2017年10月8日 下午2:57:31
 */
public class ServiceClassFile extends JavaFile {
    private String model;
    private static final String classType = "ServiceImpl";

    public ServiceClassFile(String fileDir, String mainPackage, String curPackage, String model) {
        super(fileDir, Common.getClassName(model,classType).append(".java").toString(), mainPackage + "." + curPackage, CLASS_TYPE, Common.getClassName(model,classType).toString());
        this.model = model;
        List<String> imports = new LinkedList<>();
        List<String> classAnnotations = new LinkedList<>();
        List<String> extendss = new LinkedList<>();
        List<String> implementss = new LinkedList<>();
        List<JavaFile.Field> fields = new LinkedList<>();
        List<Method> methods = new LinkedList<>();

        //imports
        imports.add(Common.getImportName(mainPackage, model).toString());
        imports.add(new StringBuilder().append(mainPackage).append(".").append("service").append(".").append(Common.getModelClass(model,"")).append("Service").toString());
        imports.add(new StringBuilder().append(mainPackage).append(".").append("repository").append(".").append(Common.getModelClass(model,"")).append("Repository").toString());
        imports.add("java.util.List");
        imports.add("org.springframework.beans.factory.annotation.Autowired");
        imports.add("org.springframework.data.domain.Page");
        imports.add("org.springframework.data.domain.PageRequest");
        imports.add("org.springframework.data.domain.Pageable");
        imports.add("org.springframework.stereotype.Service");
        imports.add("org.springframework.transaction.annotation.Isolation");
        imports.add("org.springframework.transaction.annotation.Propagation");
        imports.add("org.springframework.transaction.annotation.Transactional");

        //classAnnotations
        classAnnotations.add("Service");

        //extendss none

        //implementss
        implementss.add(new StringBuilder().append(Common.getModelClass(model,"")).append("Service").toString());

        //fields
        List<String> fannotations = new LinkedList<>();
        fannotations.add("Autowired");
        String fmodifier = "private";
        String ftype = new StringBuilder().append(Common.getModelClass(model,"")).append("Repository").toString();
        String fname = Common.getModelName(model).append("Repository").toString();
        String value = null;
        Field field = new Field(fannotations, fmodifier, ftype, fname, value);
        fields.add(field);

        //methods
        List<String> mannotations = new LinkedList<>();
        mannotations.add("Override");
        mannotations.add("Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)");
        String mmodifier = "public";
        String resultType;
        String name;
        String args;
        List<String> exceptions = null;
        String methodBody = null;
        //add

        resultType = Common.getModelClass(model,Common.modelAppend).toString();
        name = "add";
        args = Common.getModelClass(model,Common.modelAppend).append(" ").append(Common.getModelName(model)).toString();
        methodBody = buildMethod(new String[]{
                new StringBuilder()
                        .append("return ")
                        .append(Common.getModelName(model)
                                .append("Repository"))
                        .append(".save(")
                        .append(Common.getModelName(model))
                        .append(");")
                        .toString()
        });
        Method method = new Method(mannotations, mmodifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);
        //delete
        resultType = "void";
        name = "delete";
        args = "Integer id";
        methodBody = buildMethod(new String[]{
                new StringBuilder()
                        .append(Common.getModelName(model)
                                .append("Repository"))
                        .append(".delete(id);")
                        .toString()
        });
        method = new Method(mannotations, mmodifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);
        //update
        resultType = Common.getModelClass(model,Common.modelAppend).toString();
        name = "update";
        args = Common.getModelClass(model,Common.modelAppend).append(" ").append(Common.getModelName(model)).toString();
        methodBody = buildMethod(new String[]{
                new StringBuilder()
                        .append("return ")
                        .append(Common.getModelName(model).append("Repository"))
                        .append(".saveAndFlush(")
                        .append(Common.getModelName(model))
                        .append(");")
                        .toString()
        });
        method = new Method(mannotations, mmodifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);
        //get
        resultType = Common.getModelClass(model,Common.modelAppend).toString();
        name = "get";
        args = "Integer id";
        methodBody = buildMethod(new String[]{
                new StringBuilder()
                        .append("return ")
                        .append(Common.getModelName(model).append("Repository"))
                        .append(".findOne(id);")
                        .toString()
        });
        method = new Method(mannotations, mmodifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);
        //getAll
        resultType = new StringBuilder("List<").append(Common.getModelClass(model,Common.modelAppend).toString()).append(">").toString();
        name = "getAll";
        args = null;
        methodBody = buildMethod(new String[]{
                new StringBuilder()
                        .append("return ")
                        .append(Common.getModelName(model).append("Repository"))
                        .append(".findAll();")
                        .toString()
        });
        method = new Method(mannotations, mmodifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);
        //getPage
        resultType = new StringBuilder("Page<").append(Common.getModelClass(model,Common.modelAppend).toString()).append(">").toString();
        name = "getPage";
        args = "Integer page, Integer rows";
        methodBody = buildMethod(new String[]{
                new StringBuilder()
                        .append("Pageable pageable = new PageRequest(page-1, rows);")
                        .toString(),
                new StringBuilder()
                        .append("return ")
                        .append(Common.getModelName(model).append("Repository"))
                        .append(".findAll(pageable);")
                        .toString()
        });
        method = new Method(mannotations, mmodifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);

        super.init(imports, classAnnotations, extendss, implementss, fields, methods);
    }

    private static String buildMethod(String[] lines) {
        StringBuilder method = new StringBuilder();
        if (lines != null) {
            for (String line : lines) {
                method
                        .append("\t\t")
                        .append(line)
                        .append("\n");
            }
        }
        return method.toString();
    }
}
