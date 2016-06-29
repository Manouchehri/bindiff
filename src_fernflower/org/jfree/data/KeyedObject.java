package org.jfree.data;

import java.io.Serializable;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class KeyedObject implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 2677930479256885863L;
   private Comparable key;
   private Object object;

   public KeyedObject(Comparable var1, Object var2) {
      this.key = var1;
      this.object = var2;
   }

   public Comparable getKey() {
      return this.key;
   }

   public Object getObject() {
      return this.object;
   }

   public void setObject(Object var1) {
      this.object = var1;
   }

   public Object clone() {
      KeyedObject var1 = (KeyedObject)super.clone();
      if(this.object instanceof PublicCloneable) {
         PublicCloneable var2 = (PublicCloneable)this.object;
         var1.object = var2.clone();
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof KeyedObject)) {
         return false;
      } else {
         KeyedObject var2 = (KeyedObject)var1;
         return !ObjectUtilities.equal(this.key, var2.key)?false:ObjectUtilities.equal(this.object, var2.object);
      }
   }
}
