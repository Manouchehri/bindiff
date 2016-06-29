package org.jfree.chart.renderer;

import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PaintUtilities;

class LookupPaintScale$PaintItem implements Serializable, Comparable {
   Number value;
   transient Paint paint;
   private final LookupPaintScale this$0;

   public LookupPaintScale$PaintItem(LookupPaintScale var1, Number var2, Paint var3) {
      this.this$0 = var1;
      this.value = var2;
      this.paint = var3;
   }

   public int compareTo(Object var1) {
      LookupPaintScale$PaintItem var2 = (LookupPaintScale$PaintItem)var1;
      double var3 = this.value.doubleValue();
      double var5 = var2.value.doubleValue();
      return var3 > var5?1:(var3 < var5?-1:0);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof LookupPaintScale$PaintItem)) {
         return false;
      } else {
         LookupPaintScale$PaintItem var2 = (LookupPaintScale$PaintItem)var1;
         return !this.value.equals(var2.value)?false:PaintUtilities.equal(this.paint, var2.paint);
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
   }
}
