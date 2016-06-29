package org.jfree.util;

import org.jfree.util.AbstractObjectList;

public class BooleanList extends AbstractObjectList {
   private static final long serialVersionUID = -8543170333219422042L;

   public Boolean getBoolean(int var1) {
      return (Boolean)this.get(var1);
   }

   public void setBoolean(int var1, Boolean var2) {
      this.set(var1, var2);
   }

   public boolean equals(Object var1) {
      return var1 instanceof BooleanList?super.equals(var1):false;
   }

   public int hashCode() {
      return super.hashCode();
   }
}
