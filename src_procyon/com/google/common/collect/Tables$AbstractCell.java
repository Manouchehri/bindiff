package com.google.common.collect;

import com.google.common.base.*;

abstract class Tables$AbstractCell implements Table$Cell
{
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Table$Cell) {
            final Table$Cell table$Cell = (Table$Cell)o;
            return Objects.equal(this.getRowKey(), table$Cell.getRowKey()) && Objects.equal(this.getColumnKey(), table$Cell.getColumnKey()) && Objects.equal(this.getValue(), table$Cell.getValue());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.getRowKey(), this.getColumnKey(), this.getValue());
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.getRowKey());
        final String value2 = String.valueOf(this.getColumnKey());
        final String value3 = String.valueOf(this.getValue());
        return new StringBuilder(4 + String.valueOf(value).length() + String.valueOf(value2).length() + String.valueOf(value3).length()).append("(").append(value).append(",").append(value2).append(")=").append(value3).toString();
    }
}
