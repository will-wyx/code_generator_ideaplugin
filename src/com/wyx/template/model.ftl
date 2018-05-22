package ${package_name}.model;

public class ${model_name} extends Entity {
<#list columns as column>
    private ${column.javaType} ${column.property};
    public ${column.javaType} get${column.upperProperty}() {
        return this.${column.property};
    }
    public void set${column.upperProperty}(${column.javaType} value) {
        this.${column.property} = value;
    }

</#list>
}