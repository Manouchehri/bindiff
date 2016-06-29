package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.common.base.*;

public class CodeDisplayCoordinate
{
    private int rowIndex;
    private int columnIndex;
    private int lineIndex;
    private int fieldIndex;
    
    public CodeDisplayCoordinate(final int rowIndex, final int lineIndex, final int columnIndex, final int fieldIndex) {
        this.rowIndex = rowIndex;
        this.lineIndex = lineIndex;
        this.columnIndex = columnIndex;
        this.fieldIndex = fieldIndex;
    }
    
    CodeDisplayCoordinate(final CodeDisplayCoordinate codeDisplayCoordinate) {
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
    
    public void setRow(final int rowIndex) {
        Preconditions.checkArgument(rowIndex >= 0, "Row should be >= 0: %s", rowIndex);
        this.rowIndex = rowIndex;
    }
    
    public void setColumn(final int columnIndex) {
        Preconditions.checkArgument(columnIndex >= 0, "Column should be >= 0: %s", columnIndex);
        this.columnIndex = columnIndex;
    }
    
    public void setLine(final int lineIndex) {
        Preconditions.checkArgument(lineIndex >= 0, "Line should be >= 0: %s", lineIndex);
        this.lineIndex = lineIndex;
    }
    
    public void setFieldIndex(final int fieldIndex) {
        Preconditions.checkArgument(fieldIndex >= 0, "Index should be >= 0: %s", fieldIndex);
        this.fieldIndex = fieldIndex;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(Integer.toString(this.rowIndex));
        final String value2 = String.valueOf(Integer.toString(this.columnIndex));
        final String value3 = String.valueOf(Integer.toString(this.lineIndex));
        final String value4 = String.valueOf(Integer.toString(this.fieldIndex));
        return new StringBuilder(24 + String.valueOf(value).length() + String.valueOf(value2).length() + String.valueOf(value3).length() + String.valueOf(value4).length()).append("Row: ").append(value).append(", Column: ").append(value2).append(", Line: ").append(value3).append(",").append(value4).toString();
    }
}
