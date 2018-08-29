package com.nhapis.util;

public class Common {

    public static final String modelAppend = "Bean";

    /**
     * 有些需在扩展名,有些不需要
     * @param model
     * @param isAppend
     * @return
     */
    public static StringBuilder getModelClass(String model, String isAppend) {
        StringBuilder modelClass = new StringBuilder();
        modelClass.append((model.charAt(0) + "").toUpperCase());
        modelClass.append(model.toLowerCase().substring(1));
        //生成的类名  nhApis
        modelClass.append(isAppend);
        return modelClass;
    }

    /**
     * 引入包
     * @param packagei
     * @param model
     * @return
     */
    public static StringBuilder getImportName(String packagei, String model) {
        StringBuilder importName = new StringBuilder();
        importName.append(packagei);
        importName.append(".model.");
        importName.append(Common.getModelClass(model, modelAppend));
        return importName;
    }

    /**
     * 其它类名
     * @param model
     * @param classType
     * @return
     */
    public static StringBuilder getClassName(String model, String classType) {
        StringBuilder className = new StringBuilder();
        className.append(Common.getModelClass(model, ""));
        className.append(classType);
        return className;
    }

    /**
     * 请求层
     * @param model
     * @return
     */
    public static StringBuilder getModelName(String model) {
        StringBuilder modelName = new StringBuilder(model.toLowerCase());
        modelName.append("_model");
        return modelName;
    }
}
