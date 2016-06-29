package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class AbstractBlock implements Serializable, Cloneable {
   private static final long serialVersionUID = 7689852412141274563L;
   private String id = null;
   private RectangleInsets margin;
   private BlockFrame frame;
   private RectangleInsets padding;
   private double width = 0.0D;
   private double height = 0.0D;
   private transient Rectangle2D bounds = new Float();

   protected AbstractBlock() {
      this.margin = RectangleInsets.ZERO_INSETS;
      this.frame = BlockBorder.NONE;
      this.padding = RectangleInsets.ZERO_INSETS;
   }

   public String getID() {
      return this.id;
   }

   public void setID(String var1) {
      this.id = var1;
   }

   public double getWidth() {
      return this.width;
   }

   public void setWidth(double var1) {
      this.width = var1;
   }

   public double getHeight() {
      return this.height;
   }

   public void setHeight(double var1) {
      this.height = var1;
   }

   public RectangleInsets getMargin() {
      return this.margin;
   }

   public void setMargin(RectangleInsets var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'margin\' argument.");
      } else {
         this.margin = var1;
      }
   }

   public void setMargin(double var1, double var3, double var5, double var7) {
      this.setMargin(new RectangleInsets(var1, var3, var5, var7));
   }

   public BlockBorder getBorder() {
      return this.frame instanceof BlockBorder?(BlockBorder)this.frame:null;
   }

   public void setBorder(BlockBorder var1) {
      this.setFrame(var1);
   }

   public void setBorder(double var1, double var3, double var5, double var7) {
      this.setFrame(new BlockBorder(var1, var3, var5, var7));
   }

   public BlockFrame getFrame() {
      return this.frame;
   }

   public void setFrame(BlockFrame var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'frame\' argument.");
      } else {
         this.frame = var1;
      }
   }

   public RectangleInsets getPadding() {
      return this.padding;
   }

   public void setPadding(RectangleInsets var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'padding\' argument.");
      } else {
         this.padding = var1;
      }
   }

   public void setPadding(double var1, double var3, double var5, double var7) {
      this.setPadding(new RectangleInsets(var1, var3, var5, var7));
   }

   public double getContentXOffset() {
      return this.margin.getLeft() + this.frame.getInsets().getLeft() + this.padding.getLeft();
   }

   public double getContentYOffset() {
      return this.margin.getTop() + this.frame.getInsets().getTop() + this.padding.getTop();
   }

   public Size2D arrange(Graphics2D var1) {
      return this.arrange(var1, RectangleConstraint.NONE);
   }

   public Size2D arrange(Graphics2D var1, RectangleConstraint var2) {
      Size2D var3 = new Size2D(this.getWidth(), this.getHeight());
      return var2.calculateConstrainedSize(var3);
   }

   public Rectangle2D getBounds() {
      return this.bounds;
   }

   public void setBounds(Rectangle2D var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'bounds\' argument.");
      } else {
         this.bounds = var1;
      }
   }

   protected double trimToContentWidth(double var1) {
      double var3 = this.margin.trimWidth(var1);
      var3 = this.frame.getInsets().trimWidth(var3);
      var3 = this.padding.trimWidth(var3);
      return Math.max(var3, 0.0D);
   }

   protected double trimToContentHeight(double var1) {
      double var3 = this.margin.trimHeight(var1);
      var3 = this.frame.getInsets().trimHeight(var3);
      var3 = this.padding.trimHeight(var3);
      return Math.max(var3, 0.0D);
   }

   protected RectangleConstraint toContentConstraint(RectangleConstraint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'c\' argument.");
      } else if(var1.equals(RectangleConstraint.NONE)) {
         return var1;
      } else {
         double var2 = var1.getWidth();
         Range var4 = var1.getWidthRange();
         double var5 = var1.getHeight();
         Range var7 = var1.getHeightRange();
         double var8 = this.trimToContentWidth(var2);
         double var10 = this.trimToContentHeight(var5);
         Range var12 = this.trimToContentWidth(var4);
         Range var13 = this.trimToContentHeight(var7);
         return new RectangleConstraint(var8, var12, var1.getWidthConstraintType(), var10, var13, var1.getHeightConstraintType());
      }
   }

   private Range trimToContentWidth(Range var1) {
      if(var1 == null) {
         return null;
      } else {
         double var2 = 0.0D;
         double var4 = Double.POSITIVE_INFINITY;
         if(var1.getLowerBound() > 0.0D) {
            var2 = this.trimToContentWidth(var1.getLowerBound());
         }

         if(var1.getUpperBound() < Double.POSITIVE_INFINITY) {
            var4 = this.trimToContentWidth(var1.getUpperBound());
         }

         return new Range(var2, var4);
      }
   }

   private Range trimToContentHeight(Range var1) {
      if(var1 == null) {
         return null;
      } else {
         double var2 = 0.0D;
         double var4 = Double.POSITIVE_INFINITY;
         if(var1.getLowerBound() > 0.0D) {
            var2 = this.trimToContentHeight(var1.getLowerBound());
         }

         if(var1.getUpperBound() < Double.POSITIVE_INFINITY) {
            var4 = this.trimToContentHeight(var1.getUpperBound());
         }

         return new Range(var2, var4);
      }
   }

   protected double calculateTotalWidth(double var1) {
      double var3 = this.padding.extendWidth(var1);
      var3 = this.frame.getInsets().extendWidth(var3);
      var3 = this.margin.extendWidth(var3);
      return var3;
   }

   protected double calculateTotalHeight(double var1) {
      double var3 = this.padding.extendHeight(var1);
      var3 = this.frame.getInsets().extendHeight(var3);
      var3 = this.margin.extendHeight(var3);
      return var3;
   }

   protected Rectangle2D trimMargin(Rectangle2D var1) {
      this.margin.trim(var1);
      return var1;
   }

   protected Rectangle2D trimBorder(Rectangle2D var1) {
      this.frame.getInsets().trim(var1);
      return var1;
   }

   protected Rectangle2D trimPadding(Rectangle2D var1) {
      this.padding.trim(var1);
      return var1;
   }

   protected void drawBorder(Graphics2D var1, Rectangle2D var2) {
      this.frame.draw(var1, var2);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AbstractBlock)) {
         return false;
      } else {
         AbstractBlock var2 = (AbstractBlock)var1;
         return !ObjectUtilities.equal(this.id, var2.id)?false:(!this.frame.equals(var2.frame)?false:(!this.bounds.equals(var2.bounds)?false:(!this.margin.equals(var2.margin)?false:(!this.padding.equals(var2.padding)?false:(this.height != var2.height?false:this.width == var2.width)))));
      }
   }

   public Object clone() {
      AbstractBlock var1 = (AbstractBlock)super.clone();
      var1.bounds = (Rectangle2D)ShapeUtilities.clone(this.bounds);
      if(this.frame instanceof PublicCloneable) {
         PublicCloneable var2 = (PublicCloneable)this.frame;
         var1.frame = (BlockFrame)var2.clone();
      }

      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeShape(this.bounds, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.bounds = (Rectangle2D)SerialUtilities.readShape(var1);
   }
}
