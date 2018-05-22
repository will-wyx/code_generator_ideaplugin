<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE ${r'mapper'} PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${namespace}">
    <resultMap id="${map_id}" type="${model_type}">
    <#list columns as column>
        <id column="${column.name}" jdbcType="${column.jdbcType}" property="${column.property}"/>
    </#list>
    </resultMap>
    <delete id="baseDeleteById" parameterType="java.lang.String">
        delete from ${table_name} where id = ${r'#{id,jdbcType=CHAR}'}
    </delete>
    <select id="baseFindById" parameterType="java.lang.String" resultMap="BaseResultMap">
        select
        <#list columns as column>
            ${column.name}<#if column_has_next>, </#if>
        </#list>
        from ${table_name}
        where id = ${r'#{id,jdbcType=CHAR}'}
    </select>
</mapper>