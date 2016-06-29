/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.common.base.Preconditions;

public class CodeDisplayCoordinate {
    private int rowIndex;
    private int columnIndex;
    private int lineIndex;
    private int fieldIndex;

    public CodeDisplayCoordinate(int n2, int n3, int n4, int n5) {
        this.rowIndex = n2;
        this.lineIndex = n3;
        this.columnIndex = n4;
        this.fieldIndex = n5;
    }

    CodeDisplayCoordinate(CodeDisplayCoordinate codeDisplayCoordinate) {
        this.rowIndex = codeDisplayCoordinate.getRow();
        this.lineIndex = codeDisplayCoordinate.getLine();
        this.columnIndex = codeDisplayCoordinate.getColumn();
        this.fieldIndex = codeDisplayCoordinate.getFieldIndex();
    }

    public int getRow() {
        return this.rowIndex;
    }

    public int getColumn() {
        return this.columnIndex;
    }

    public int getLine() {
        return this.lineIndex;
    }

    public int getFieldIndex() {
        return this.fieldIndex;
    }

    public void setRow(int n2) {
        Preconditions.checkArgument(n2 >= 0, "Row should be >= 0: %s", n2);
        this.rowIndex = n2;
    }

    public void setColumn(int n2) {
        Preconditions.checkArgument(n2 >= 0, "Column should be >= 0: %s", n2);
        this.columnIndex = n2;
    }

    public void setLine(int n2) {
        Preconditions.checkArgument(n2 >= 0, "Line should be >= 0: %s", n2);
        this.lineIndex = n2;
    }

    public void setFieldIndex(int n2) {
        Preconditions.checkArgument(n2 >= 0, "Index should be >= 0: %s", n2);
        this.fieldIndex = n2;
    }

    public String toString() {
        String string = String.valueOf(Integer.toString(this.rowIndex));
        String string2 = String.valueOf(Integer.toString(this.columnIndex));
        String string3 = String.valueOf(Integer.toString(this.lineIndex));
        String string4 = String.valueOf(Integer.toString(this.fieldIndex));
        return new StringBuilder(24 + String.valueOf(string).length() + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string4).length()).append("Row: ").append(string).append(", Column: ").append(string2).append(", Line: ").append(string3).append(",").append(string4).toString();
    }
}

