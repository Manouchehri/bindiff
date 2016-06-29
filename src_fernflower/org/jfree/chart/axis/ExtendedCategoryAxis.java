package org.jfree.chart.axis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextBlock;
import org.jfree.text.TextFragment;
import org.jfree.text.TextLine;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;

public class ExtendedCategoryAxis extends CategoryAxis {
   private Map sublabels = new HashMap();
   private Font sublabelFont = new Font("SansSerif", 0, 10);
   private transient Paint sublabelPaint;

   public ExtendedCategoryAxis(String var1) {
      super(var1);
      this.sublabelPaint = Color.black;
   }

   public Font getSubLabelFont() {
      return this.sublabelFont;
   }

   public void setSubLabelFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.sublabelFont = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Paint getSubLabelPaint() {
      return this.sublabelPaint;
   }

   public void setSubLabelPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.sublabelPaint = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public void addSubLabel(Comparable var1, String var2) {
      this.sublabels.put(var1, var2);
   }

   protected TextBlock createLabel(Comparable var1, float var2, RectangleEdge var3, Graphics2D var4) {
      TextBlock var5 = super.createLabel(var1, var2, var3, var4);
      String var6 = (String)this.sublabels.get(var1);
      if(var6 != null) {
         TextLine var7;
         if(var3 != RectangleEdge.TOP && var3 != RectangleEdge.BOTTOM) {
            if(var3 == RectangleEdge.LEFT || var3 == RectangleEdge.RIGHT) {
               var7 = var5.getLastLine();
               if(var7 != null) {
                  var7.addFragment(new TextFragment("  " + var6, this.sublabelFont, this.sublabelPaint));
               }
            }
         } else {
            var7 = new TextLine(var6, this.sublabelFont, this.sublabelPaint);
            var5.addLine(var7);
         }
      }

      return var5;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ExtendedCategoryAxis)) {
         return false;
      } else {
         ExtendedCategoryAxis var2 = (ExtendedCategoryAxis)var1;
         return !this.sublabelFont.equals(var2.sublabelFont)?false:(!PaintUtilities.equal(this.sublabelPaint, var2.sublabelPaint)?false:(!this.sublabels.equals(var2.sublabels)?false:super.equals(var1)));
      }
   }

   public Object clone() {
      ExtendedCategoryAxis var1 = (ExtendedCategoryAxis)super.clone();
      var1.sublabels = new HashMap(this.sublabels);
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.sublabelPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.sublabelPaint = SerialUtilities.readPaint(var1);
   }
}
