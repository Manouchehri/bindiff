package org.jfree.data.xy;

import java.io.Serializable;
import org.jfree.util.ObjectUtilities;

public class XYDataItem implements Serializable, Cloneable, Comparable {
   private static final long serialVersionUID = 2751513470325494890L;
   private Number x;
   private Number y;

   public XYDataItem(Number var1, Number var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'x\' argument.");
      } else {
         this.x = var1;
         this.y = var2;
      }
   }

   public XYDataItem(double var1, double var3) {
      this(new Double(var1), new Double(var3));
   }

   public Number getX() {
      return this.x;
   }

   public Number getY() {
      return this.y;
   }

   public void setY(double var1) {
      this.setY(new Double(var1));
   }

   public void setY(Number var1) {
      this.y = var1;
   }

   public int compareTo(Object var1) {
      byte var2;
      if(var1 instanceof XYDataItem) {
         XYDataItem var3 = (XYDataItem)var1;
         double var4 = this.x.doubleValue() - var3.getX().doubleValue();
         if(var4 > 0.0D) {
            var2 = 1;
         } else if(var4 < 0.0D) {
            var2 = -1;
         } else {
            var2 = 0;
         }
      } else {
         var2 = 1;
      }

      return var2;
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYDataItem)) {
         return false;
      } else {
         XYDataItem var2 = (XYDataItem)var1;
         return !this.x.equals(var2.x)?false:ObjectUtilities.equal(this.y, var2.y);
      }
   }

   public int hashCode() {
      int var1 = this.x.hashCode();
      var1 = 29 * var1 + (this.y != null?this.y.hashCode():0);
      return var1;
   }
}
