package org.jfree.util;

import java.io.Serializable;
import java.util.Comparator;

public class ClassComparator implements Serializable, Comparator {
   private static final long serialVersionUID = -5225335361837391120L;

   public int compare(Object var1, Object var2) {
      Class var3 = (Class)var1;
      Class var4 = (Class)var2;
      if(var3.equals(var2)) {
         return 0;
      } else if(var3.isAssignableFrom(var4)) {
         return -1;
      } else if(!var4.isAssignableFrom(var4)) {
         throw new IllegalArgumentException("The classes share no relation");
      } else {
         return 1;
      }
   }

   public boolean isComparable(Class var1, Class var2) {
      return var1.isAssignableFrom(var2) || var2.isAssignableFrom(var1);
   }
}
