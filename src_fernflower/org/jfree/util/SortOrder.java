package org.jfree.util;

import java.io.Serializable;

public final class SortOrder implements Serializable {
   private static final long serialVersionUID = -2124469847758108312L;
   public static final SortOrder ASCENDING = new SortOrder("SortOrder.ASCENDING");
   public static final SortOrder DESCENDING = new SortOrder("SortOrder.DESCENDING");
   private String name;

   private SortOrder(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof SortOrder)) {
         return false;
      } else {
         SortOrder var2 = (SortOrder)var1;
         return this.name.equals(var2.toString());
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(ASCENDING)?ASCENDING:(this.equals(DESCENDING)?DESCENDING:null);
   }
}
