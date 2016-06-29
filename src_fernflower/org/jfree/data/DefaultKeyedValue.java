package org.jfree.data;

import java.io.Serializable;
import org.jfree.data.KeyedValue;
import org.jfree.util.PublicCloneable;

public class DefaultKeyedValue implements Serializable, Cloneable, KeyedValue, PublicCloneable {
   private static final long serialVersionUID = -7388924517460437712L;
   private Comparable key;
   private Number value;

   public DefaultKeyedValue(Comparable var1, Number var2) {
      this.key = var1;
      this.value = var2;
   }

   public Comparable getKey() {
      return this.key;
   }

   public Number getValue() {
      return this.value;
   }

   public synchronized void setValue(Number var1) {
      this.value = var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof DefaultKeyedValue)) {
         return false;
      } else {
         DefaultKeyedValue var2 = (DefaultKeyedValue)var1;
         if(this.key != null) {
            if(!this.key.equals(var2.key)) {
               return false;
            }
         } else if(var2.key != null) {
            return false;
         }

         if(this.value != null) {
            if(!this.value.equals(var2.value)) {
               return false;
            }
         } else if(var2.value != null) {
            return false;
         }

         return true;
      }
   }

   public int hashCode() {
      int var1 = this.key != null?this.key.hashCode():0;
      var1 = 29 * var1 + (this.value != null?this.value.hashCode():0);
      return var1;
   }

   public Object clone() {
      DefaultKeyedValue var1 = (DefaultKeyedValue)super.clone();
      return var1;
   }
}
