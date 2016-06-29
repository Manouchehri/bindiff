package org.jfree.util;

import java.awt.Shape;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.io.SerialUtilities;
import org.jfree.util.AbstractObjectList;

public class ShapeList extends AbstractObjectList {
   public Shape getShape(int var1) {
      return (Shape)this.get(var1);
   }

   public void setShape(int var1, Shape var2) {
      this.set(var1, var2);
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      return var1 == null?false:(var1 == this?true:(var1 instanceof ShapeList?super.equals(var1):false));
   }

   public int hashCode() {
      return super.hashCode();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      int var2 = this.size();
      var1.writeInt(var2);

      for(int var3 = 0; var3 < var2; ++var3) {
         Shape var4 = this.getShape(var3);
         if(var4 != null) {
            var1.writeInt(var3);
            SerialUtilities.writeShape(var4, var1);
         } else {
            var1.writeInt(-1);
         }
      }

   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = var1.readInt();
         if(var4 != -1) {
            this.setShape(var4, SerialUtilities.readShape(var1));
         }
      }

   }
}
