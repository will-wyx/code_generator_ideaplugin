package com.wyx.service;

import com.wyx.FreeMarkerUtil;
import com.wyx.model.OriginEntity;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelService {
    private String projectPath;

    public ModelService(String projectPath) {
        this.projectPath = projectPath;
    }

    public void createMapper(List<OriginEntity> columns) {
        try {
            Template mapperTemplate = FreeMarkerUtil.getTemplate("model.ftl");
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("package_name", "pn");
            dataMap.put("model_name", "mn");
            dataMap.put("columns", columns);
            File mapperFile = new File(projectPath + "/M.java");
            FileOutputStream fos = new FileOutputStream(mapperFile);
            Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
            mapperTemplate.process(dataMap, out);
        } catch (IOException | TemplateException e1) {
            e1.printStackTrace();
        }
    }
}
