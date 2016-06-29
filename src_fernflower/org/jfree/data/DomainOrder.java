package org.jfree.data;

import java.io.Serializable;

public final class DomainOrder implements Serializable {
   private static final long serialVersionUID = 4902774943512072627L;
   public static final DomainOrder NONE = new DomainOrder("DomainOrder.NONE");
   public static final DomainOrder ASCENDING = new DomainOrder("DomainOrder.ASCENDING");
   public static final DomainOrder DESCENDING = new DomainOrder("DomainOrder.DESCENDING");
   private String name;

   private DomainOrder(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof DomainOrder)) {
         return false;
      } else {
         DomainOrder var2 = (DomainOrder)var1;
         return this.name.equals(var2.toString());
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(ASCENDING)?ASCENDING:(this.equals(DESCENDING)?DESCENDING:(this.equals(NONE)?NONE:null));
   }
}
