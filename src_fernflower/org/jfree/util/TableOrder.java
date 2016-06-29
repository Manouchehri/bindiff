package org.jfree.util;

import java.io.Serializable;

public final class TableOrder implements Serializable {
   private static final long serialVersionUID = 525193294068177057L;
   public static final TableOrder BY_ROW = new TableOrder("TableOrder.BY_ROW");
   public static final TableOrder BY_COLUMN = new TableOrder("TableOrder.BY_COLUMN");
   private String name;

   private TableOrder(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof TableOrder)) {
         return false;
      } else {
         TableOrder var2 = (TableOrder)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(BY_ROW)?BY_ROW:(this.equals(BY_COLUMN)?BY_COLUMN:null);
   }
}
