package com.wyx.model;

import com.wyx.Utils;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;

public class OriginEntity {

    private String name;
    private String jdbcType;
    private String property;
    private String javaType;
    private String upperProperty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String type) {
        this.jdbcType = type.toUpperCase();
        TypeEnum typeEnum = TypeEnum.valueOf(jdbcType);
        javaType = typeEnum.getValue();
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public OriginEntity(String name, String type, String property) {
        this.name = name;
        this.jdbcType = type;
        this.property = property;
    }

    public OriginEntity(ColumnDefinition columnDefinition) {
        String type = columnDefinition.getColDataType().getDataType();
        setJdbcType(type);
        this.name = columnDefinition.getColumnName();
        this.upperProperty = Utils.toCamelCase(this.name);
        this.property = Utils.tocamelCase(this.name);
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getUpperProperty() {
        return upperProperty;
    }

    public void setUpperProperty(String upperProperty) {
        this.upperProperty = upperProperty;
    }
}
