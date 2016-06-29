package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.Serializable;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.plot.Marker;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.util.ObjectUtilities;

public class IntervalMarker extends Marker implements Serializable, Cloneable {
   private static final long serialVersionUID = -1762344775267627916L;
   private double startValue;
   private double endValue;
   private GradientPaintTransformer gradientPaintTransformer;

   public IntervalMarker(double var1, double var3) {
      this(var1, var3, Color.gray, new BasicStroke(0.5F), Color.gray, new BasicStroke(0.5F), 0.8F);
   }

   public IntervalMarker(double var1, double var3, Paint var5, Stroke var6, Paint var7, Stroke var8, float var9) {
      super(var5, var6, var7, var8, var9);
      this.startValue = var1;
      this.endValue = var3;
      this.gradientPaintTransformer = null;
      this.setLabelOffsetType(LengthAdjustmentType.CONTRACT);
   }

   public double getStartValue() {
      return this.startValue;
   }

   public void setStartValue(double var1) {
      this.startValue = var1;
      this.notifyListeners(new MarkerChangeEvent(this));
   }

   public double getEndValue() {
      return this.endValue;
   }

   public void setEndValue(double var1) {
      this.endValue = var1;
      this.notifyListeners(new MarkerChangeEvent(this));
   }

   public GradientPaintTransformer getGradientPaintTransformer() {
      return this.gradientPaintTransformer;
   }

   public void setGradientPaintTransformer(GradientPaintTransformer var1) {
      this.gradientPaintTransformer = var1;
      this.notifyListeners(new MarkerChangeEvent(this));
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof IntervalMarker)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         IntervalMarker var2 = (IntervalMarker)var1;
         return this.startValue != var2.startValue?false:(this.endValue != var2.endValue?false:ObjectUtilities.equal(this.gradientPaintTransformer, var2.gradientPaintTransformer));
      }
   }

   public Object clone() {
      return super.clone();
   }
}
