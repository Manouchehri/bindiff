package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.common.base.Preconditions;

public class CodeDisplayCoordinate {
   private int rowIndex;
   private int columnIndex;
   private int lineIndex;
   private int fieldIndex;

   public CodeDisplayCoordinate(int var1, int var2, int var3, int var4) {
      this.rowIndex = var1;
      this.lineIndex = var2;
      this.columnIndex = var3;
      this.fieldIndex = var4;
   }

   CodeDisplayCoordinate(CodeDisplayCoordinate var1) {
      this.rowIndex = var1.getRow();
      this.lineIndex = var1.getLine();
      this.columnIndex = var1.getColumn();
      this.fieldIndex = var1.getFieldIndex();
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

   public void setRow(int var1) {
      Preconditions.checkArgument(var1 >= 0, "Row should be >= 0: %s", new Object[]{Integer.valueOf(var1)});
      this.rowIndex = var1;
   }

   public void setColumn(int var1) {
      Preconditions.checkArgument(var1 >= 0, "Column should be >= 0: %s", new Object[]{Integer.valueOf(var1)});
      this.columnIndex = var1;
   }

   public void setLine(int var1) {
      Preconditions.checkArgument(var1 >= 0, "Line should be >= 0: %s", new Object[]{Integer.valueOf(var1)});
      this.lineIndex = var1;
   }

   public void setFieldIndex(int var1) {
      Preconditions.checkArgument(var1 >= 0, "Index should be >= 0: %s", new Object[]{Integer.valueOf(var1)});
      this.fieldIndex = var1;
   }

   public String toString() {
      String var1 = String.valueOf(Integer.toString(this.rowIndex));
      String var2 = String.valueOf(Integer.toString(this.columnIndex));
      String var3 = String.valueOf(Integer.toString(this.lineIndex));
      String var4 = String.valueOf(Integer.toString(this.fieldIndex));
      return (new StringBuilder(24 + String.valueOf(var1).length() + String.valueOf(var2).length() + String.valueOf(var3).length() + String.valueOf(var4).length())).append("Row: ").append(var1).append(", Column: ").append(var2).append(", Line: ").append(var3).append(",").append(var4).toString();
   }
}
