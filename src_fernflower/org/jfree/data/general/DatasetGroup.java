package org.jfree.data.general;

import java.io.Serializable;

public class DatasetGroup implements Serializable, Cloneable {
   private static final long serialVersionUID = -3640642179674185688L;
   private String id;

   public DatasetGroup() {
      this.id = "NOID";
   }

   public DatasetGroup(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'id\' argument.");
      } else {
         this.id = var1;
      }
   }

   public String getID() {
      return this.id;
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof DatasetGroup)) {
         return false;
      } else {
         DatasetGroup var2 = (DatasetGroup)var1;
         return this.id.equals(var2.id);
      }
   }
}
