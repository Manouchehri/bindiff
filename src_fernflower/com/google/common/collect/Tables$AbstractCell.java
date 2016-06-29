package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Table$Cell;

abstract class Tables$AbstractCell implements Table$Cell {
   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Table$Cell)) {
         return false;
      } else {
         Table$Cell var2 = (Table$Cell)var1;
         return Objects.equal(this.getRowKey(), var2.getRowKey()) && Objects.equal(this.getColumnKey(), var2.getColumnKey()) && Objects.equal(this.getValue(), var2.getValue());
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.getRowKey(), this.getColumnKey(), this.getValue()});
   }

   public String toString() {
      String var1 = String.valueOf(this.getRowKey());
      String var2 = String.valueOf(this.getColumnKey());
      String var3 = String.valueOf(this.getValue());
      return (new StringBuilder(4 + String.valueOf(var1).length() + String.valueOf(var2).length() + String.valueOf(var3).length())).append("(").append(var1).append(",").append(var2).append(")=").append(var3).toString();
   }
}
