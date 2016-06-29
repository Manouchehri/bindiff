package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class MeterInterval implements Serializable {
   private static final long serialVersionUID = 1530982090622488257L;
   private String label;
   private Range range;
   private transient Paint outlinePaint;
   private transient Stroke outlineStroke;
   private transient Paint backgroundPaint;

   public MeterInterval(String var1, Range var2) {
      this(var1, var2, Color.yellow, new BasicStroke(2.0F), (Paint)null);
   }

   public MeterInterval(String var1, Range var2, Paint var3, Stroke var4, Paint var5) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'label\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'range\' argument.");
      } else {
         this.label = var1;
         this.range = var2;
         this.outlinePaint = var3;
         this.outlineStroke = var4;
         this.backgroundPaint = var5;
      }
   }

   public String getLabel() {
      return this.label;
   }

   public Range getRange() {
      return this.range;
   }

   public Paint getBackgroundPaint() {
      return this.backgroundPaint;
   }

   public Paint getOutlinePaint() {
      return this.outlinePaint;
   }

   public Stroke getOutlineStroke() {
      return this.outlineStroke;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof MeterInterval)) {
         return false;
      } else {
         MeterInterval var2 = (MeterInterval)var1;
         return !this.label.equals(var2.label)?false:(!this.range.equals(var2.range)?false:(!PaintUtilities.equal(this.outlinePaint, var2.outlinePaint)?false:(!ObjectUtilities.equal(this.outlineStroke, var2.outlineStroke)?false:PaintUtilities.equal(this.backgroundPaint, var2.backgroundPaint))));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.outlinePaint, var1);
      SerialUtilities.writeStroke(this.outlineStroke, var1);
      SerialUtilities.writePaint(this.backgroundPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.outlinePaint = SerialUtilities.readPaint(var1);
      this.outlineStroke = SerialUtilities.readStroke(var1);
      this.backgroundPaint = SerialUtilities.readPaint(var1);
   }
}
