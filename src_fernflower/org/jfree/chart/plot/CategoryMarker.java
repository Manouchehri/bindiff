package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.Serializable;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.plot.Marker;
import org.jfree.ui.LengthAdjustmentType;

public class CategoryMarker extends Marker implements Serializable, Cloneable {
   private Comparable key;
   private boolean drawAsLine;

   public CategoryMarker(Comparable var1) {
      this(var1, Color.gray, new BasicStroke(1.0F));
   }

   public CategoryMarker(Comparable var1, Paint var2, Stroke var3) {
      this(var1, var2, var3, var2, var3, 1.0F);
   }

   public CategoryMarker(Comparable var1, Paint var2, Stroke var3, Paint var4, Stroke var5, float var6) {
      super(var2, var3, var4, var5, var6);
      this.drawAsLine = false;
      this.key = var1;
      this.setLabelOffsetType(LengthAdjustmentType.EXPAND);
   }

   public Comparable getKey() {
      return this.key;
   }

   public void setKey(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         this.key = var1;
         this.notifyListeners(new MarkerChangeEvent(this));
      }
   }

   public boolean getDrawAsLine() {
      return this.drawAsLine;
   }

   public void setDrawAsLine(boolean var1) {
      this.drawAsLine = var1;
      this.notifyListeners(new MarkerChangeEvent(this));
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(!(var1 instanceof CategoryMarker)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         CategoryMarker var2 = (CategoryMarker)var1;
         return !this.key.equals(var2.key)?false:this.drawAsLine == var2.drawAsLine;
      }
   }
}
