package org.jfree.data;

import java.io.Serializable;
import org.jfree.util.ObjectUtilities;

public class ComparableObjectItem implements Serializable, Cloneable, Comparable {
   private static final long serialVersionUID = 2751513470325494890L;
   private Comparable x;
   private Object obj;

   public ComparableObjectItem(Comparable var1, Object var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'x\' argument.");
      } else {
         this.x = var1;
         this.obj = var2;
      }
   }

   protected Comparable getComparable() {
      return this.x;
   }

   protected Object getObject() {
      return this.obj;
   }

   protected void setObject(Object var1) {
      this.obj = var1;
   }

   public int compareTo(Object var1) {
      if(var1 instanceof ComparableObjectItem) {
         ComparableObjectItem var3 = (ComparableObjectItem)var1;
         return this.x.compareTo(var3.x);
      } else {
         byte var2 = 1;
         return var2;
      }
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ComparableObjectItem)) {
         return false;
      } else {
         ComparableObjectItem var2 = (ComparableObjectItem)var1;
         return !this.x.equals(var2.x)?false:ObjectUtilities.equal(this.obj, var2.obj);
      }
   }

   public int hashCode() {
      int var1 = this.x.hashCode();
      var1 = 29 * var1 + (this.obj != null?this.obj.hashCode():0);
      return var1;
   }
}
