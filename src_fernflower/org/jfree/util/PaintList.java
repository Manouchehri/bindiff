package org.jfree.util;

import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.io.SerialUtilities;
import org.jfree.util.AbstractObjectList;
import org.jfree.util.PaintUtilities;

public class PaintList extends AbstractObjectList {
   public Paint getPaint(int var1) {
      return (Paint)this.get(var1);
   }

   public void setPaint(int var1, Paint var2) {
      this.set(var1, var2);
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else {
         if(var1 instanceof PaintList) {
            PaintList var2 = (PaintList)var1;
            int var3 = this.size();

            for(int var4 = 0; var4 < var3; ++var4) {
               if(!PaintUtilities.equal(this.getPaint(var4), var2.getPaint(var4))) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public int hashCode() {
      return super.hashCode();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      int var2 = this.size();
      var1.writeInt(var2);

      for(int var3 = 0; var3 < var2; ++var3) {
         Paint var4 = this.getPaint(var3);
         if(var4 != null) {
            var1.writeInt(var3);
            SerialUtilities.writePaint(var4, var1);
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
            this.setPaint(var4, SerialUtilities.readPaint(var1));
         }
      }

   }
}
