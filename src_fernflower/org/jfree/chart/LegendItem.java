package org.jfree.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D.Float;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.AttributedString;
import java.text.CharacterIterator;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.util.AttributedStringUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.ShapeUtilities;

public class LegendItem implements Serializable {
   private static final long serialVersionUID = -797214582948827144L;
   private int datasetIndex;
   private int series;
   private String label;
   private transient AttributedString attributedLabel;
   private String description;
   private String toolTipText;
   private String urlText;
   private boolean shapeVisible;
   private transient Shape shape;
   private boolean shapeFilled;
   private transient Paint fillPaint;
   private GradientPaintTransformer fillPaintTransformer;
   private boolean shapeOutlineVisible;
   private transient Paint outlinePaint;
   private transient Stroke outlineStroke;
   private boolean lineVisible;
   private transient Shape line;
   private transient Stroke lineStroke;
   private transient Paint linePaint;
   private static final Shape UNUSED_SHAPE = new Float();
   private static final Stroke UNUSED_STROKE = new BasicStroke(0.0F);

   public LegendItem(String var1, String var2, String var3, String var4, Shape var5, Paint var6) {
      this((String)var1, var2, var3, var4, true, var5, true, var6, false, Color.black, UNUSED_STROKE, false, UNUSED_SHAPE, UNUSED_STROKE, Color.black);
   }

   public LegendItem(String var1, String var2, String var3, String var4, Shape var5, Paint var6, Stroke var7, Paint var8) {
      this((String)var1, var2, var3, var4, true, var5, true, var6, true, var8, var7, false, UNUSED_SHAPE, UNUSED_STROKE, Color.black);
   }

   public LegendItem(String var1, String var2, String var3, String var4, Shape var5, Stroke var6, Paint var7) {
      this((String)var1, var2, var3, var4, false, UNUSED_SHAPE, false, Color.black, false, Color.black, UNUSED_STROKE, true, var5, var6, var7);
   }

   public LegendItem(String var1, String var2, String var3, String var4, boolean var5, Shape var6, boolean var7, Paint var8, boolean var9, Paint var10, Stroke var11, boolean var12, Shape var13, Stroke var14, Paint var15) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'label\' argument.");
      } else if(var8 == null) {
         throw new IllegalArgumentException("Null \'fillPaint\' argument.");
      } else if(var14 == null) {
         throw new IllegalArgumentException("Null \'lineStroke\' argument.");
      } else if(var10 == null) {
         throw new IllegalArgumentException("Null \'outlinePaint\' argument.");
      } else if(var11 == null) {
         throw new IllegalArgumentException("Null \'outlineStroke\' argument.");
      } else {
         this.label = var1;
         this.attributedLabel = null;
         this.description = var2;
         this.shapeVisible = var5;
         this.shape = var6;
         this.shapeFilled = var7;
         this.fillPaint = var8;
         this.fillPaintTransformer = new StandardGradientPaintTransformer();
         this.shapeOutlineVisible = var9;
         this.outlinePaint = var10;
         this.outlineStroke = var11;
         this.lineVisible = var12;
         this.line = var13;
         this.lineStroke = var14;
         this.linePaint = var15;
         this.toolTipText = var3;
         this.urlText = var4;
      }
   }

   public LegendItem(AttributedString var1, String var2, String var3, String var4, Shape var5, Paint var6) {
      this((AttributedString)var1, var2, var3, var4, true, var5, true, var6, false, Color.black, UNUSED_STROKE, false, UNUSED_SHAPE, UNUSED_STROKE, Color.black);
   }

   public LegendItem(AttributedString var1, String var2, String var3, String var4, Shape var5, Paint var6, Stroke var7, Paint var8) {
      this((AttributedString)var1, var2, var3, var4, true, var5, true, var6, true, var8, var7, false, UNUSED_SHAPE, UNUSED_STROKE, Color.black);
   }

   public LegendItem(AttributedString var1, String var2, String var3, String var4, Shape var5, Stroke var6, Paint var7) {
      this((AttributedString)var1, var2, var3, var4, false, UNUSED_SHAPE, false, Color.black, false, Color.black, UNUSED_STROKE, true, var5, var6, var7);
   }

   public LegendItem(AttributedString var1, String var2, String var3, String var4, boolean var5, Shape var6, boolean var7, Paint var8, boolean var9, Paint var10, Stroke var11, boolean var12, Shape var13, Stroke var14, Paint var15) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'label\' argument.");
      } else if(var8 == null) {
         throw new IllegalArgumentException("Null \'fillPaint\' argument.");
      } else if(var14 == null) {
         throw new IllegalArgumentException("Null \'lineStroke\' argument.");
      } else if(var10 == null) {
         throw new IllegalArgumentException("Null \'outlinePaint\' argument.");
      } else if(var11 == null) {
         throw new IllegalArgumentException("Null \'outlineStroke\' argument.");
      } else {
         this.label = this.characterIteratorToString(var1.getIterator());
         this.attributedLabel = var1;
         this.description = var2;
         this.shapeVisible = var5;
         this.shape = var6;
         this.shapeFilled = var7;
         this.fillPaint = var8;
         this.shapeOutlineVisible = var9;
         this.outlinePaint = var10;
         this.outlineStroke = var11;
         this.lineVisible = var12;
         this.line = var13;
         this.lineStroke = var14;
         this.linePaint = var15;
         this.toolTipText = var3;
         this.urlText = var4;
      }
   }

   private String characterIteratorToString(CharacterIterator var1) {
      int var2 = var1.getEndIndex();
      int var3 = var1.getBeginIndex();
      int var4 = var2 - var3;
      if(var4 <= 0) {
         return "";
      } else {
         char[] var5 = new char[var4];
         int var6 = 0;

         for(char var7 = var1.first(); var7 != '\uffff'; var7 = var1.next()) {
            var5[var6] = var7;
            ++var6;
         }

         return new String(var5);
      }
   }

   public int getDatasetIndex() {
      return this.datasetIndex;
   }

   public void setDatasetIndex(int var1) {
      this.datasetIndex = var1;
   }

   public int getSeriesIndex() {
      return this.series;
   }

   public void setSeriesIndex(int var1) {
      this.series = var1;
   }

   public String getLabel() {
      return this.label;
   }

   public AttributedString getAttributedLabel() {
      return this.attributedLabel;
   }

   public String getDescription() {
      return this.description;
   }

   public String getToolTipText() {
      return this.toolTipText;
   }

   public String getURLText() {
      return this.urlText;
   }

   public boolean isShapeVisible() {
      return this.shapeVisible;
   }

   public Shape getShape() {
      return this.shape;
   }

   public boolean isShapeFilled() {
      return this.shapeFilled;
   }

   public Paint getFillPaint() {
      return this.fillPaint;
   }

   public boolean isShapeOutlineVisible() {
      return this.shapeOutlineVisible;
   }

   public Stroke getLineStroke() {
      return this.lineStroke;
   }

   public Paint getLinePaint() {
      return this.linePaint;
   }

   public Paint getOutlinePaint() {
      return this.outlinePaint;
   }

   public Stroke getOutlineStroke() {
      return this.outlineStroke;
   }

   public boolean isLineVisible() {
      return this.lineVisible;
   }

   public Shape getLine() {
      return this.line;
   }

   public GradientPaintTransformer getFillPaintTransformer() {
      return this.fillPaintTransformer;
   }

   public void setFillPaintTransformer(GradientPaintTransformer var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'transformer\' attribute.");
      } else {
         this.fillPaintTransformer = var1;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof LegendItem)) {
         return false;
      } else {
         LegendItem var2 = (LegendItem)var1;
         return this.datasetIndex != var2.datasetIndex?false:(this.series != var2.series?false:(!this.label.equals(var2.label)?false:(!AttributedStringUtilities.equal(this.attributedLabel, var2.attributedLabel)?false:(!ObjectUtilities.equal(this.description, var2.description)?false:(this.shapeVisible != var2.shapeVisible?false:(!ShapeUtilities.equal(this.shape, var2.shape)?false:(this.shapeFilled != var2.shapeFilled?false:(!this.fillPaint.equals(var2.fillPaint)?false:(!ObjectUtilities.equal(this.fillPaintTransformer, var2.fillPaintTransformer)?false:(this.shapeOutlineVisible != var2.shapeOutlineVisible?false:(!this.outlineStroke.equals(var2.outlineStroke)?false:(!this.outlinePaint.equals(var2.outlinePaint)?false:(!this.lineVisible == var2.lineVisible?false:(!ShapeUtilities.equal(this.line, var2.line)?false:(!this.lineStroke.equals(var2.lineStroke)?false:this.linePaint.equals(var2.linePaint))))))))))))))));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeAttributedString(this.attributedLabel, var1);
      SerialUtilities.writeShape(this.shape, var1);
      SerialUtilities.writePaint(this.fillPaint, var1);
      SerialUtilities.writeStroke(this.outlineStroke, var1);
      SerialUtilities.writePaint(this.outlinePaint, var1);
      SerialUtilities.writeShape(this.line, var1);
      SerialUtilities.writeStroke(this.lineStroke, var1);
      SerialUtilities.writePaint(this.linePaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.attributedLabel = SerialUtilities.readAttributedString(var1);
      this.shape = SerialUtilities.readShape(var1);
      this.fillPaint = SerialUtilities.readPaint(var1);
      this.outlineStroke = SerialUtilities.readStroke(var1);
      this.outlinePaint = SerialUtilities.readPaint(var1);
      this.line = SerialUtilities.readShape(var1);
      this.lineStroke = SerialUtilities.readStroke(var1);
      this.linePaint = SerialUtilities.readPaint(var1);
   }
}
