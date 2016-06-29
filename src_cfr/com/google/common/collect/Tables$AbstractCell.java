/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Table$Cell;

abstract class Tables$AbstractCell
implements Table$Cell {
    Tables$AbstractCell() {
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Table$Cell)) return false;
        Table$Cell table$Cell = (Table$Cell)object;
        if (!Objects.equal(this.getRowKey(), table$Cell.getRowKey())) return false;
        if (!Objects.equal(this.getColumnKey(), table$Cell.getColumnKey())) return false;
        if (!Objects.equal(this.getValue(), table$Cell.getValue())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getRowKey(), this.getColumnKey(), this.getValue());
    }

    public String toString() {
        String string = String.valueOf(this.getRowKey());
        String string2 = String.valueOf(this.getColumnKey());
        String string3 = String.valueOf(this.getValue());
        return new StringBuilder(4 + String.valueOf(string).length() + String.valueOf(string2).length() + String.valueOf(string3).length()).append("(").append(string).append(",").append(string2).append(")=").append(string3).toString();
    }
}

