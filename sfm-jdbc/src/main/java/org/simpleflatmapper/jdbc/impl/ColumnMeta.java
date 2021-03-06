package org.simpleflatmapper.jdbc.impl;

import org.simpleflatmapper.jdbc.JdbcColumnKey;
import org.simpleflatmapper.map.property.AutoGeneratedProperty;

public class ColumnMeta {
    private final String column;
    private final int sqlType;
    private final boolean key;
    private final AutoGeneratedProperty generated;

    public ColumnMeta(String column, int sqlType, boolean key, AutoGeneratedProperty generated) {
        this.column = column;
        this.sqlType = sqlType;
        this.key = key;
        this.generated = generated;
    }

    public String getColumn() {
        return column;
    }

    public int getSqlType() {
        return sqlType;
    }

    public boolean isKey() {
        return key;
    }

    public boolean isGenerated() {
        return generated != null;
    }

    public JdbcColumnKey toJdbcColumnKey(int index) {
        return new JdbcColumnKey(column, index, sqlType);
    }

    public boolean isInsertable() {
        return generated == null || generated.getExpression() != null;
    }

    public String getInsertExpression() {
        return generated == null ? "?" : generated.getExpression();
    }
}
