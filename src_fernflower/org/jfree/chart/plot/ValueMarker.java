package org.jfree.chart.plot;

import java.awt.Paint;
import java.awt.Stroke;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.plot.Marker;

public class ValueMarker extends Marker {
   private double value;

   public ValueMarker(double var1) {
      this.value = var1;
   }

   public ValueMarker(double var1, Paint var3, Stroke var4) {
      this(var1, var3, var4, var3, var4, 1.0F);
   }

   public ValueMarker(double var1, Paint var3, Stroke var4, Paint var5, Stroke var6, float var7) {
      super(var3, var4, var3, var4, var7);
      this.value = var1;
   }

   public double getValue() {
      return this.value;
   }

   public void setValue(double var1) {
      this.value = var1;
      this.notifyListeners(new MarkerChangeEvent(this));
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!super.equals(var1)) {
         return false;
      } else if(!(var1 instanceof ValueMarker)) {
         return false;
      } else {
         ValueMarker var2 = (ValueMarker)var1;
         return this.value == var2.value;
      }
   }
}
