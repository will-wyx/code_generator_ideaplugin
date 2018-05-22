package com.wyx.service;

import com.wyx.FreeMarkerUtil;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import com.wyx.model.OriginEntity;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperService {
    private String projectPath;

    public MapperService(String projectPath) {
        this.projectPath = projectPath;
    }

    public void createMapper(List<OriginEntity> columns) {
        try {
            Template mapperTemplate = FreeMarkerUtil.getTemplate("mapper.ftl");
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("namespace", "ns");
            dataMap.put("map_id", "mi");
            dataMap.put("model_type", "mt");
            dataMap.put("table_name", "tn");
            dataMap.put("columns", columns);
            File mapperFile = new File(projectPath + "/M.xml");
            FileOutputStream fos = new FileOutputStream(mapperFile);
            Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
            mapperTemplate.process(dataMap, out);
        } catch (IOException | TemplateException e1) {
            e1.printStackTrace();
        }
    }
}
