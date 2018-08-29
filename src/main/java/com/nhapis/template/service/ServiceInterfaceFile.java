package com.nhapis.template.service;

import com.nhapis.base.JavaFile;
import com.nhapis.util.Common;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 牛虹
 * @time 2017年10月8日 下午2:22:28
 */
public class ServiceInterfaceFile extends JavaFile {
    private String model;
    private static final String classType = "Service";

    public ServiceInterfaceFile(String fileDir, String mainPackage, String curPackage, String model) {
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
        imports.add("java.util.List");
        imports.add("org.springframework.data.domain.Page");

        //classAnnotations none

        //extendss none

        //implementss none

        //fields none

        //methods
        List<String> annotations = null;
        //接口层.可以不加public 修饰
        String modifier = "";
        String resultType;
        String name;
        String args;
        List<String> exceptions = null;
        String methodBody = null;
        //add
        resultType = Common.getModelClass(model,Common.modelAppend).toString();
        name = "add";
        args = Common.getModelClass(model,Common.modelAppend).append(" ").append(Common.getModelName(model)).toString();
        Method method = new Method(annotations, modifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);
        //delete
        resultType = "void";
        name = "delete";
        args = "Integer id";
        method = new Method(annotations, modifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);
        //update
        resultType = Common.getModelClass(model,Common.modelAppend).toString();
        name = "update";
        args = Common.getModelClass(model,Common.modelAppend).append(" ").append(Common.getModelName(model)).toString();
        method = new Method(annotations, modifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);
        //get
        resultType = Common.getModelClass(model,Common.modelAppend).toString();
        name = "get";
        args = "Integer id";
        method = new Method(annotations, modifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);
        //getAll
        resultType = new StringBuilder("List<").append(Common.getModelClass(model,Common.modelAppend).toString()).append(">").toString();
        name = "getAll";
        args = "";
        method = new Method(annotations, modifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);
        //getPage
        resultType = new StringBuilder("Page<").append(Common.getModelClass(model,Common.modelAppend).toString()).append(">").toString();
        name = "getPage";
        args = "Integer page, Integer rows";
        method = new Method(annotations, modifier, resultType, name, args, exceptions, methodBody);
        methods.add(method);

        super.init(imports, classAnnotations, extendss, implementss, fields, methods);
    }
}
