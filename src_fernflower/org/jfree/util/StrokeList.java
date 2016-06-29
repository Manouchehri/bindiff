package org.jfree.util;

import java.awt.Stroke;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.io.SerialUtilities;
import org.jfree.util.AbstractObjectList;

public class StrokeList extends AbstractObjectList {
   public Stroke getStroke(int var1) {
      return (Stroke)this.get(var1);
   }

   public void setStroke(int var1, Stroke var2) {
      this.set(var1, var2);
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      return var1 == null?false:(var1 == this?true:(var1 instanceof StrokeList?super.equals(var1):false));
   }

   public int hashCode() {
      return super.hashCode();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      int var2 = this.size();
      var1.writeInt(var2);

      for(int var3 = 0; var3 < var2; ++var3) {
         Stroke var4 = this.getStroke(var3);
         if(var4 != null) {
            var1.writeInt(var3);
            SerialUtilities.writeStroke(var4, var1);
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
            this.setStroke(var4, SerialUtilities.readStroke(var1));
         }
      }

   }
}
