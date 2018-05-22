package com.wyx.model;

public enum TypeEnum {
    CHAR("String"),
    VARCHAR("String"),
    LONGVARCHAR("String"),
    NUMERIC("java.math.BigDecimal"),
    DECIMAL("java.math.BigDecimal"),
    BIT("boolean"),
    BOOLEAN("boolean"),
    TINYINT("byte"),
    SMALLINT("short"),
    INTEGER("int"),
    INT("int"),
    BIGINT("long"),
    REAL("float"),
    FLOAT("double"),
    DOUBLE("double"),
    BINARY("byte[]"),
    VARBINARY("byte[]"),
    LONGVARBINARY("byte[]"),
    DATE("java.sql.Date"),
    DATETIME("java.sql.Date"),
    TIME("java.sql.Time"),
    TIMESTAMP("java.sql.Timestamp"),
    CLOB("Clob"),
    BLOB("Blob"),
    ARRAY("Array"),
    DISTINCT("mapping of underlying type"),
    STRUCT("Struct"),
    REF("Ref"),
    DATALINK("java.net.URL");
    private final String value;

    TypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
