package org.jfree.chart.axis;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.chart.axis.CategoryTick;
import org.jfree.chart.entity.CategoryLabelEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.io.SerialUtilities;
import org.jfree.text.G2TextMeasurer;
import org.jfree.text.TextBlock;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.ShapeUtilities;

public class CategoryAxis extends Axis implements Serializable, Cloneable {
   private static final long serialVersionUID = 5886554608114265863L;
   public static final double DEFAULT_AXIS_MARGIN = 0.05D;
   public static final double DEFAULT_CATEGORY_MARGIN = 0.2D;
   private double lowerMargin;
   private double upperMargin;
   private double categoryMargin;
   private int maximumCategoryLabelLines;
   private float maximumCategoryLabelWidthRatio;
   private int categoryLabelPositionOffset;
   private CategoryLabelPositions categoryLabelPositions;
   private Map tickLabelFontMap;
   private transient Map tickLabelPaintMap;
   private Map categoryLabelToolTips;

   public CategoryAxis() {
      this((String)null);
   }

   public CategoryAxis(String var1) {
      super(var1);
      this.lowerMargin = 0.05D;
      this.upperMargin = 0.05D;
      this.categoryMargin = 0.2D;
      this.maximumCategoryLabelLines = 1;
      this.maximumCategoryLabelWidthRatio = 0.0F;
      this.setTickMarksVisible(false);
      this.categoryLabelPositionOffset = 4;
      this.categoryLabelPositions = CategoryLabelPositions.STANDARD;
      this.tickLabelFontMap = new HashMap();
      this.tickLabelPaintMap = new HashMap();
      this.categoryLabelToolTips = new HashMap();
   }

   public double getLowerMargin() {
      return this.lowerMargin;
   }

   public void setLowerMargin(double var1) {
      this.lowerMargin = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public double getUpperMargin() {
      return this.upperMargin;
   }

   public void setUpperMargin(double var1) {
      this.upperMargin = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public double getCategoryMargin() {
      return this.categoryMargin;
   }

   public void setCategoryMargin(double var1) {
      this.categoryMargin = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public int getMaximumCategoryLabelLines() {
      return this.maximumCategoryLabelLines;
   }

   public void setMaximumCategoryLabelLines(int var1) {
      this.maximumCategoryLabelLines = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public float getMaximumCategoryLabelWidthRatio() {
      return this.maximumCategoryLabelWidthRatio;
   }

   public void setMaximumCategoryLabelWidthRatio(float var1) {
      this.maximumCategoryLabelWidthRatio = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public int getCategoryLabelPositionOffset() {
      return this.categoryLabelPositionOffset;
   }

   public void setCategoryLabelPositionOffset(int var1) {
      this.categoryLabelPositionOffset = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public CategoryLabelPositions getCategoryLabelPositions() {
      return this.categoryLabelPositions;
   }

   public void setCategoryLabelPositions(CategoryLabelPositions var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'positions\' argument.");
      } else {
         this.categoryLabelPositions = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Font getTickLabelFont(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'category\' argument.");
      } else {
         Font var2 = (Font)this.tickLabelFontMap.get(var1);
         if(var2 == null) {
            var2 = this.getTickLabelFont();
         }

         return var2;
      }
   }

   public void setTickLabelFont(Comparable var1, Font var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'category\' argument.");
      } else {
         if(var2 == null) {
            this.tickLabelFontMap.remove(var1);
         } else {
            this.tickLabelFontMap.put(var1, var2);
         }

         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Paint getTickLabelPaint(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'category\' argument.");
      } else {
         Paint var2 = (Paint)this.tickLabelPaintMap.get(var1);
         if(var2 == null) {
            var2 = this.getTickLabelPaint();
         }

         return var2;
      }
   }

   public void setTickLabelPaint(Comparable var1, Paint var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'category\' argument.");
      } else {
         if(var2 == null) {
            this.tickLabelPaintMap.remove(var1);
         } else {
            this.tickLabelPaintMap.put(var1, var2);
         }

         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public void addCategoryLabelToolTip(Comparable var1, String var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'category\' argument.");
      } else {
         this.categoryLabelToolTips.put(var1, var2);
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public String getCategoryLabelToolTip(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'category\' argument.");
      } else {
         return (String)this.categoryLabelToolTips.get(var1);
      }
   }

   public void removeCategoryLabelToolTip(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'category\' argument.");
      } else {
         this.categoryLabelToolTips.remove(var1);
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public void clearCategoryLabelToolTips() {
      this.categoryLabelToolTips.clear();
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public double getCategoryJava2DCoordinate(CategoryAnchor var1, int var2, int var3, Rectangle2D var4, RectangleEdge var5) {
      double var6 = 0.0D;
      if(var1 == CategoryAnchor.START) {
         var6 = this.getCategoryStart(var2, var3, var4, var5);
      } else if(var1 == CategoryAnchor.MIDDLE) {
         var6 = this.getCategoryMiddle(var2, var3, var4, var5);
      } else if(var1 == CategoryAnchor.END) {
         var6 = this.getCategoryEnd(var2, var3, var4, var5);
      }

      return var6;
   }

   public double getCategoryStart(int var1, int var2, Rectangle2D var3, RectangleEdge var4) {
      double var5 = 0.0D;
      if(var4 != RectangleEdge.TOP && var4 != RectangleEdge.BOTTOM) {
         if(var4 == RectangleEdge.LEFT || var4 == RectangleEdge.RIGHT) {
            var5 = var3.getMinY() + var3.getHeight() * this.getLowerMargin();
         }
      } else {
         var5 = var3.getX() + var3.getWidth() * this.getLowerMargin();
      }

      double var7 = this.calculateCategorySize(var2, var3, var4);
      double var9 = this.calculateCategoryGapSize(var2, var3, var4);
      var5 += (double)var1 * (var7 + var9);
      return var5;
   }

   public double getCategoryMiddle(int var1, int var2, Rectangle2D var3, RectangleEdge var4) {
      return this.getCategoryStart(var1, var2, var3, var4) + this.calculateCategorySize(var2, var3, var4) / 2.0D;
   }

   public double getCategoryEnd(int var1, int var2, Rectangle2D var3, RectangleEdge var4) {
      return this.getCategoryStart(var1, var2, var3, var4) + this.calculateCategorySize(var2, var3, var4);
   }

   protected double calculateCategorySize(int var1, Rectangle2D var2, RectangleEdge var3) {
      double var4 = 0.0D;
      double var6 = 0.0D;
      if(var3 != RectangleEdge.TOP && var3 != RectangleEdge.BOTTOM) {
         if(var3 == RectangleEdge.LEFT || var3 == RectangleEdge.RIGHT) {
            var6 = var2.getHeight();
         }
      } else {
         var6 = var2.getWidth();
      }

      if(var1 > 1) {
         var4 = var6 * (1.0D - this.getLowerMargin() - this.getUpperMargin() - this.getCategoryMargin());
         var4 /= (double)var1;
      } else {
         var4 = var6 * (1.0D - this.getLowerMargin() - this.getUpperMargin());
      }

      return var4;
   }

   protected double calculateCategoryGapSize(int var1, Rectangle2D var2, RectangleEdge var3) {
      double var4 = 0.0D;
      double var6 = 0.0D;
      if(var3 != RectangleEdge.TOP && var3 != RectangleEdge.BOTTOM) {
         if(var3 == RectangleEdge.LEFT || var3 == RectangleEdge.RIGHT) {
            var6 = var2.getHeight();
         }
      } else {
         var6 = var2.getWidth();
      }

      if(var1 > 1) {
         var4 = var6 * this.getCategoryMargin() / (double)(var1 - 1);
      }

      return var4;
   }

   public AxisSpace reserveSpace(Graphics2D var1, Plot var2, Rectangle2D var3, RectangleEdge var4, AxisSpace var5) {
      if(var5 == null) {
         var5 = new AxisSpace();
      }

      if(!this.isVisible()) {
         return var5;
      } else {
         double var6 = 0.0D;
         double var8 = 0.0D;
         if(this.isTickLabelsVisible()) {
            var1.setFont(this.getTickLabelFont());
            AxisState var10 = new AxisState();
            this.refreshTicks(var1, var10, var3, var4);
            if(var4 == RectangleEdge.TOP) {
               var6 = var10.getMax();
            } else if(var4 == RectangleEdge.BOTTOM) {
               var6 = var10.getMax();
            } else if(var4 == RectangleEdge.LEFT) {
               var8 = var10.getMax();
            } else if(var4 == RectangleEdge.RIGHT) {
               var8 = var10.getMax();
            }
         }

         Rectangle2D var15 = this.getLabelEnclosure(var1, var4);
         double var11 = 0.0D;
         double var13 = 0.0D;
         if(RectangleEdge.isTopOrBottom(var4)) {
            var11 = var15.getHeight();
            var5.add(var11 + var6 + (double)this.categoryLabelPositionOffset, var4);
         } else if(RectangleEdge.isLeftOrRight(var4)) {
            var13 = var15.getWidth();
            var5.add(var13 + var8 + (double)this.categoryLabelPositionOffset, var4);
         }

         return var5;
      }
   }

   public void configure() {
   }

   public AxisState draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6, PlotRenderingInfo var7) {
      if(!this.isVisible()) {
         return new AxisState(var2);
      } else {
         if(this.isAxisLineVisible()) {
            this.drawAxisLine(var1, var2, var5, var6);
         }

         AxisState var8 = new AxisState(var2);
         var8 = this.drawCategoryLabels(var1, var4, var5, var6, var8, var7);
         var8 = this.drawLabel(this.getLabel(), var1, var4, var5, var6, var8);
         return var8;
      }
   }

   protected AxisState drawCategoryLabels(Graphics2D var1, Rectangle2D var2, RectangleEdge var3, AxisState var4, PlotRenderingInfo var5) {
      return this.drawCategoryLabels(var1, var2, var2, var3, var4, var5);
   }

   protected AxisState drawCategoryLabels(Graphics2D var1, Rectangle2D var2, Rectangle2D var3, RectangleEdge var4, AxisState var5, PlotRenderingInfo var6) {
      if(var5 == null) {
         throw new IllegalArgumentException("Null \'state\' argument.");
      } else {
         if(this.isTickLabelsVisible()) {
            List var7 = this.refreshTicks(var1, var5, var2, var4);
            var5.setTicks(var7);
            int var8 = 0;

            for(Iterator var9 = var7.iterator(); var9.hasNext(); ++var8) {
               CategoryTick var10 = (CategoryTick)var9.next();
               var1.setFont(this.getTickLabelFont(var10.getCategory()));
               var1.setPaint(this.getTickLabelPaint(var10.getCategory()));
               CategoryLabelPosition var11 = this.categoryLabelPositions.getLabelPosition(var4);
               double var12 = 0.0D;
               double var14 = 0.0D;
               double var16 = 0.0D;
               double var18 = 0.0D;
               if(var4 == RectangleEdge.TOP) {
                  var12 = this.getCategoryStart(var8, var7.size(), var3, var4);
                  var14 = this.getCategoryEnd(var8, var7.size(), var3, var4);
                  var18 = var5.getCursor() - (double)this.categoryLabelPositionOffset;
                  var16 = var18 - var5.getMax();
               } else if(var4 == RectangleEdge.BOTTOM) {
                  var12 = this.getCategoryStart(var8, var7.size(), var3, var4);
                  var14 = this.getCategoryEnd(var8, var7.size(), var3, var4);
                  var16 = var5.getCursor() + (double)this.categoryLabelPositionOffset;
                  var18 = var16 + var5.getMax();
               } else if(var4 == RectangleEdge.LEFT) {
                  var16 = this.getCategoryStart(var8, var7.size(), var3, var4);
                  var18 = this.getCategoryEnd(var8, var7.size(), var3, var4);
                  var14 = var5.getCursor() - (double)this.categoryLabelPositionOffset;
                  var12 = var14 - var5.getMax();
               } else if(var4 == RectangleEdge.RIGHT) {
                  var16 = this.getCategoryStart(var8, var7.size(), var3, var4);
                  var18 = this.getCategoryEnd(var8, var7.size(), var3, var4);
                  var12 = var5.getCursor() + (double)this.categoryLabelPositionOffset;
                  var14 = var12 - var5.getMax();
               }

               Double var20 = new Double(var12, var16, var14 - var12, var18 - var16);
               Point2D var21 = RectangleAnchor.coordinates(var20, var11.getCategoryAnchor());
               TextBlock var22 = var10.getLabel();
               var22.draw(var1, (float)var21.getX(), (float)var21.getY(), var11.getLabelAnchor(), (float)var21.getX(), (float)var21.getY(), var11.getAngle());
               Shape var23 = var22.calculateBounds(var1, (float)var21.getX(), (float)var21.getY(), var11.getLabelAnchor(), (float)var21.getX(), (float)var21.getY(), var11.getAngle());
               if(var6 != null && var6.getOwner() != null) {
                  EntityCollection var24 = var6.getOwner().getEntityCollection();
                  if(var24 != null) {
                     String var25 = this.getCategoryLabelToolTip(var10.getCategory());
                     var24.add(new CategoryLabelEntity(var10.getCategory(), var23, var25, (String)null));
                  }
               }
            }

            double var26;
            if(var4.equals(RectangleEdge.TOP)) {
               var26 = var5.getMax() + (double)this.categoryLabelPositionOffset;
               var5.cursorUp(var26);
            } else if(var4.equals(RectangleEdge.BOTTOM)) {
               var26 = var5.getMax() + (double)this.categoryLabelPositionOffset;
               var5.cursorDown(var26);
            } else if(var4 == RectangleEdge.LEFT) {
               var26 = var5.getMax() + (double)this.categoryLabelPositionOffset;
               var5.cursorLeft(var26);
            } else if(var4 == RectangleEdge.RIGHT) {
               var26 = var5.getMax() + (double)this.categoryLabelPositionOffset;
               var5.cursorRight(var26);
            }
         }

         return var5;
      }
   }

   public List refreshTicks(Graphics2D var1, AxisState var2, Rectangle2D var3, RectangleEdge var4) {
      ArrayList var5 = new ArrayList();
      if(var3.getHeight() > 0.0D && var3.getWidth() >= 0.0D) {
         CategoryPlot var6 = (CategoryPlot)this.getPlot();
         List var7 = var6.getCategoriesForAxis(this);
         double var8 = 0.0D;
         if(var7 != null) {
            CategoryLabelPosition var10 = this.categoryLabelPositions.getLabelPosition(var4);
            float var11 = this.maximumCategoryLabelWidthRatio;
            if((double)var11 <= 0.0D) {
               var11 = var10.getWidthRatio();
            }

            float var12 = 0.0F;
            if(var10.getWidthType() == CategoryLabelWidthType.CATEGORY) {
               var12 = (float)this.calculateCategorySize(var7.size(), var3, var4);
            } else if(RectangleEdge.isLeftOrRight(var4)) {
               var12 = (float)var3.getWidth();
            } else {
               var12 = (float)var3.getHeight();
            }

            int var13 = 0;

            for(Iterator var14 = var7.iterator(); var14.hasNext(); ++var13) {
               Comparable var15 = (Comparable)var14.next();
               TextBlock var16 = this.createLabel(var15, var12 * var11, var4, var1);
               if(var4 != RectangleEdge.TOP && var4 != RectangleEdge.BOTTOM) {
                  if(var4 == RectangleEdge.LEFT || var4 == RectangleEdge.RIGHT) {
                     var8 = Math.max(var8, this.calculateTextBlockWidth(var16, var10, var1));
                  }
               } else {
                  var8 = Math.max(var8, this.calculateTextBlockHeight(var16, var10, var1));
               }

               CategoryTick var17 = new CategoryTick(var15, var16, var10.getLabelAnchor(), var10.getRotationAnchor(), var10.getAngle());
               var5.add(var17);
            }
         }

         var2.setMax(var8);
         return var5;
      } else {
         return var5;
      }
   }

   protected TextBlock createLabel(Comparable var1, float var2, RectangleEdge var3, Graphics2D var4) {
      TextBlock var5 = TextUtilities.createTextBlock(var1.toString(), this.getTickLabelFont(var1), this.getTickLabelPaint(var1), var2, this.maximumCategoryLabelLines, new G2TextMeasurer(var4));
      return var5;
   }

   protected double calculateTextBlockWidth(TextBlock var1, CategoryLabelPosition var2, Graphics2D var3) {
      RectangleInsets var4 = this.getTickLabelInsets();
      Size2D var5 = var1.calculateDimensions(var3);
      Double var6 = new Double(0.0D, 0.0D, var5.getWidth(), var5.getHeight());
      Shape var7 = ShapeUtilities.rotateShape(var6, var2.getAngle(), 0.0F, 0.0F);
      double var8 = var7.getBounds2D().getWidth() + var4.getTop() + var4.getBottom();
      return var8;
   }

   protected double calculateTextBlockHeight(TextBlock var1, CategoryLabelPosition var2, Graphics2D var3) {
      RectangleInsets var4 = this.getTickLabelInsets();
      Size2D var5 = var1.calculateDimensions(var3);
      Double var6 = new Double(0.0D, 0.0D, var5.getWidth(), var5.getHeight());
      Shape var7 = ShapeUtilities.rotateShape(var6, var2.getAngle(), 0.0F, 0.0F);
      double var8 = var7.getBounds2D().getHeight() + var4.getTop() + var4.getBottom();
      return var8;
   }

   public Object clone() {
      CategoryAxis var1 = (CategoryAxis)super.clone();
      var1.tickLabelFontMap = new HashMap(this.tickLabelFontMap);
      var1.tickLabelPaintMap = new HashMap(this.tickLabelPaintMap);
      var1.categoryLabelToolTips = new HashMap(this.categoryLabelToolTips);
      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CategoryAxis)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         CategoryAxis var2 = (CategoryAxis)var1;
         return var2.lowerMargin != this.lowerMargin?false:(var2.upperMargin != this.upperMargin?false:(var2.categoryMargin != this.categoryMargin?false:(var2.maximumCategoryLabelWidthRatio != this.maximumCategoryLabelWidthRatio?false:(var2.categoryLabelPositionOffset != this.categoryLabelPositionOffset?false:(!ObjectUtilities.equal(var2.categoryLabelPositions, this.categoryLabelPositions)?false:(!ObjectUtilities.equal(var2.categoryLabelToolTips, this.categoryLabelToolTips)?false:(!ObjectUtilities.equal(this.tickLabelFontMap, var2.tickLabelFontMap)?false:this.equalPaintMaps(this.tickLabelPaintMap, var2.tickLabelPaintMap))))))));
      }
   }

   public int hashCode() {
      return this.getLabel() != null?this.getLabel().hashCode():0;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.writePaintMap(this.tickLabelPaintMap, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.tickLabelPaintMap = this.readPaintMap(var1);
   }

   private Map readPaintMap(ObjectInputStream var1) {
      boolean var2 = var1.readBoolean();
      if(var2) {
         return null;
      } else {
         HashMap var3 = new HashMap();
         int var4 = var1.readInt();

         for(int var5 = 0; var5 < var4; ++var5) {
            Comparable var6 = (Comparable)var1.readObject();
            Paint var7 = SerialUtilities.readPaint(var1);
            var3.put(var6, var7);
         }

         return var3;
      }
   }

   private void writePaintMap(Map var1, ObjectOutputStream var2) {
      if(var1 == null) {
         var2.writeBoolean(true);
      } else {
         var2.writeBoolean(false);
         Set var3 = var1.keySet();
         int var4 = var3.size();
         var2.writeInt(var4);
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            Comparable var6 = (Comparable)var5.next();
            var2.writeObject(var6);
            SerialUtilities.writePaint((Paint)var1.get(var6), var2);
         }
      }

   }

   private boolean equalPaintMaps(Map var1, Map var2) {
      if(var1.size() != var2.size()) {
         return false;
      } else {
         Set var3 = var1.keySet();
         Iterator var4 = var3.iterator();

         Paint var6;
         Paint var7;
         do {
            if(!var4.hasNext()) {
               return true;
            }

            Comparable var5 = (Comparable)var4.next();
            var6 = (Paint)var1.get(var5);
            var7 = (Paint)var2.get(var5);
         } while(PaintUtilities.equal(var6, var7));

         return false;
      }
   }
}
