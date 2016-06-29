package org.jfree.chart.block;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.chart.block.AbstractBlock;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockResult;
import org.jfree.chart.block.EntityBlockParams;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.text.TextUtilities;
import org.jfree.ui.Size2D;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class LabelBlock extends AbstractBlock implements Block, PublicCloneable {
   private String text;
   private TextBlock label;
   private Font font;
   private String toolTipText;
   private String urlText;
   public static final Paint DEFAULT_PAINT;
   private transient Paint paint;

   public LabelBlock(String var1) {
      this(var1, new Font("SansSerif", 0, 10), DEFAULT_PAINT);
   }

   public LabelBlock(String var1, Font var2) {
      this(var1, var2, DEFAULT_PAINT);
   }

   public LabelBlock(String var1, Font var2, Paint var3) {
      this.text = var1;
      this.paint = var3;
      this.label = TextUtilities.createTextBlock(var1, var2, this.paint);
      this.font = var2;
      this.toolTipText = null;
      this.urlText = null;
   }

   public Font getFont() {
      return this.font;
   }

   public void setFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.font = var1;
         this.label = TextUtilities.createTextBlock(this.text, var1, this.paint);
      }
   }

   public Paint getPaint() {
      return this.paint;
   }

   public void setPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.paint = var1;
         this.label = TextUtilities.createTextBlock(this.text, this.font, this.paint);
      }
   }

   public String getToolTipText() {
      return this.toolTipText;
   }

   public void setToolTipText(String var1) {
      this.toolTipText = var1;
   }

   public String getURLText() {
      return this.urlText;
   }

   public void setURLText(String var1) {
      this.urlText = var1;
   }

   public Size2D arrange(Graphics2D var1, RectangleConstraint var2) {
      var1.setFont(this.font);
      Size2D var3 = this.label.calculateDimensions(var1);
      return new Size2D(this.calculateTotalWidth(var3.getWidth()), this.calculateTotalHeight(var3.getHeight()));
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      this.draw(var1, var2, (Object)null);
   }

   public Object draw(Graphics2D var1, Rectangle2D var2, Object var3) {
      var2 = this.trimMargin(var2);
      this.drawBorder(var1, var2);
      var2 = this.trimBorder(var2);
      var2 = this.trimPadding(var2);
      EntityBlockParams var4 = null;
      StandardEntityCollection var5 = null;
      Shape var6 = null;
      if(var3 instanceof EntityBlockParams) {
         var4 = (EntityBlockParams)var3;
         if(var4.getGenerateEntities()) {
            var5 = new StandardEntityCollection();
            var6 = (Shape)var2.clone();
         }
      }

      var1.setPaint(this.paint);
      var1.setFont(this.font);
      this.label.draw(var1, (float)var2.getX(), (float)var2.getY(), TextBlockAnchor.TOP_LEFT);
      BlockResult var7 = null;
      if(var4 != null && var5 != null && (this.toolTipText != null || this.urlText != null)) {
         ChartEntity var8 = new ChartEntity(var6, this.toolTipText, this.urlText);
         var5.add(var8);
         var7 = new BlockResult();
         var7.setEntityCollection(var5);
      }

      return var7;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof LabelBlock)) {
         return false;
      } else {
         LabelBlock var2 = (LabelBlock)var1;
         return !this.text.equals(var2.text)?false:(!this.font.equals(var2.font)?false:(!PaintUtilities.equal(this.paint, var2.paint)?false:(!ObjectUtilities.equal(this.toolTipText, var2.toolTipText)?false:(!ObjectUtilities.equal(this.urlText, var2.urlText)?false:super.equals(var1)))));
      }
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
   }

   static {
      DEFAULT_PAINT = Color.black;
   }
}
