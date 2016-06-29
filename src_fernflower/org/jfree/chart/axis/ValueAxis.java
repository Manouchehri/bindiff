package org.jfree.chart.axis;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.font.LineMetrics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.Tick;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueTick;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public abstract class ValueAxis extends Axis implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 3698345477322391456L;
   public static final Range DEFAULT_RANGE = new Range(0.0D, 1.0D);
   public static final boolean DEFAULT_AUTO_RANGE = true;
   public static final boolean DEFAULT_INVERTED = false;
   public static final double DEFAULT_AUTO_RANGE_MINIMUM_SIZE = 1.0E-8D;
   public static final double DEFAULT_LOWER_MARGIN = 0.05D;
   public static final double DEFAULT_UPPER_MARGIN = 0.05D;
   public static final double DEFAULT_LOWER_BOUND = 0.0D;
   public static final double DEFAULT_UPPER_BOUND = 1.0D;
   public static final boolean DEFAULT_AUTO_TICK_UNIT_SELECTION = true;
   public static final int MAXIMUM_TICK_COUNT = 500;
   private boolean positiveArrowVisible = false;
   private boolean negativeArrowVisible = false;
   private transient Shape upArrow;
   private transient Shape downArrow;
   private transient Shape leftArrow;
   private transient Shape rightArrow;
   private boolean inverted;
   private Range range;
   private boolean autoRange;
   private double autoRangeMinimumSize;
   private Range defaultAutoRange;
   private double upperMargin;
   private double lowerMargin;
   private double fixedAutoRange;
   private boolean autoTickUnitSelection;
   private TickUnitSource standardTickUnits;
   private int autoTickIndex;
   private boolean verticalTickLabels;

   protected ValueAxis(String var1, TickUnitSource var2) {
      super(var1);
      this.range = DEFAULT_RANGE;
      this.autoRange = true;
      this.defaultAutoRange = DEFAULT_RANGE;
      this.inverted = false;
      this.autoRangeMinimumSize = 1.0E-8D;
      this.lowerMargin = 0.05D;
      this.upperMargin = 0.05D;
      this.fixedAutoRange = 0.0D;
      this.autoTickUnitSelection = true;
      this.standardTickUnits = var2;
      Polygon var3 = new Polygon();
      var3.addPoint(0, 0);
      var3.addPoint(-2, 2);
      var3.addPoint(2, 2);
      this.upArrow = var3;
      Polygon var4 = new Polygon();
      var4.addPoint(0, 0);
      var4.addPoint(-2, -2);
      var4.addPoint(2, -2);
      this.downArrow = var4;
      Polygon var5 = new Polygon();
      var5.addPoint(0, 0);
      var5.addPoint(-2, -2);
      var5.addPoint(-2, 2);
      this.rightArrow = var5;
      Polygon var6 = new Polygon();
      var6.addPoint(0, 0);
      var6.addPoint(2, -2);
      var6.addPoint(2, 2);
      this.leftArrow = var6;
      this.verticalTickLabels = false;
   }

   public boolean isVerticalTickLabels() {
      return this.verticalTickLabels;
   }

   public void setVerticalTickLabels(boolean var1) {
      if(this.verticalTickLabels != var1) {
         this.verticalTickLabels = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   public boolean isPositiveArrowVisible() {
      return this.positiveArrowVisible;
   }

   public void setPositiveArrowVisible(boolean var1) {
      this.positiveArrowVisible = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public boolean isNegativeArrowVisible() {
      return this.negativeArrowVisible;
   }

   public void setNegativeArrowVisible(boolean var1) {
      this.negativeArrowVisible = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public Shape getUpArrow() {
      return this.upArrow;
   }

   public void setUpArrow(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'arrow\' argument.");
      } else {
         this.upArrow = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Shape getDownArrow() {
      return this.downArrow;
   }

   public void setDownArrow(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'arrow\' argument.");
      } else {
         this.downArrow = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Shape getLeftArrow() {
      return this.leftArrow;
   }

   public void setLeftArrow(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'arrow\' argument.");
      } else {
         this.leftArrow = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Shape getRightArrow() {
      return this.rightArrow;
   }

   public void setRightArrow(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'arrow\' argument.");
      } else {
         this.rightArrow = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   protected void drawAxisLine(Graphics2D var1, double var2, Rectangle2D var4, RectangleEdge var5) {
      Double var6 = null;
      if(var5 == RectangleEdge.TOP) {
         var6 = new Double(var4.getX(), var2, var4.getMaxX(), var2);
      } else if(var5 == RectangleEdge.BOTTOM) {
         var6 = new Double(var4.getX(), var2, var4.getMaxX(), var2);
      } else if(var5 == RectangleEdge.LEFT) {
         var6 = new Double(var2, var4.getY(), var2, var4.getMaxY());
      } else if(var5 == RectangleEdge.RIGHT) {
         var6 = new Double(var2, var4.getY(), var2, var4.getMaxY());
      }

      var1.setPaint(this.getAxisLinePaint());
      var1.setStroke(this.getAxisLineStroke());
      var1.draw(var6);
      boolean var7 = false;
      boolean var8 = false;
      if(this.positiveArrowVisible) {
         if(this.inverted) {
            var8 = true;
         } else {
            var7 = true;
         }
      }

      if(this.negativeArrowVisible) {
         if(this.inverted) {
            var7 = true;
         } else {
            var8 = true;
         }
      }

      double var9;
      double var11;
      Shape var13;
      AffineTransform var14;
      Shape var15;
      if(var7) {
         var9 = 0.0D;
         var11 = 0.0D;
         var13 = null;
         if(var5 != RectangleEdge.TOP && var5 != RectangleEdge.BOTTOM) {
            if(var5 == RectangleEdge.LEFT || var5 == RectangleEdge.RIGHT) {
               var9 = var2;
               var11 = var4.getMinY();
               var13 = this.upArrow;
            }
         } else {
            var9 = var4.getMaxX();
            var11 = var2;
            var13 = this.rightArrow;
         }

         var14 = new AffineTransform();
         var14.setToTranslation(var9, var11);
         var15 = var14.createTransformedShape(var13);
         var1.fill(var15);
         var1.draw(var15);
      }

      if(var8) {
         var9 = 0.0D;
         var11 = 0.0D;
         var13 = null;
         if(var5 != RectangleEdge.TOP && var5 != RectangleEdge.BOTTOM) {
            if(var5 == RectangleEdge.LEFT || var5 == RectangleEdge.RIGHT) {
               var9 = var2;
               var11 = var4.getMaxY();
               var13 = this.downArrow;
            }
         } else {
            var9 = var4.getMinX();
            var11 = var2;
            var13 = this.leftArrow;
         }

         var14 = new AffineTransform();
         var14.setToTranslation(var9, var11);
         var15 = var14.createTransformedShape(var13);
         var1.fill(var15);
         var1.draw(var15);
      }

   }

   protected float[] calculateAnchorPoint(ValueTick var1, double var2, Rectangle2D var4, RectangleEdge var5) {
      RectangleInsets var6 = this.getTickLabelInsets();
      float[] var7 = new float[2];
      if(var5 == RectangleEdge.TOP) {
         var7[0] = (float)this.valueToJava2D(var1.getValue(), var4, var5);
         var7[1] = (float)(var2 - var6.getBottom() - 2.0D);
      } else if(var5 == RectangleEdge.BOTTOM) {
         var7[0] = (float)this.valueToJava2D(var1.getValue(), var4, var5);
         var7[1] = (float)(var2 + var6.getTop() + 2.0D);
      } else if(var5 == RectangleEdge.LEFT) {
         var7[0] = (float)(var2 - var6.getLeft() - 2.0D);
         var7[1] = (float)this.valueToJava2D(var1.getValue(), var4, var5);
      } else if(var5 == RectangleEdge.RIGHT) {
         var7[0] = (float)(var2 + var6.getRight() + 2.0D);
         var7[1] = (float)this.valueToJava2D(var1.getValue(), var4, var5);
      }

      return var7;
   }

   protected AxisState drawTickMarksAndLabels(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6) {
      AxisState var7 = new AxisState(var2);
      if(this.isAxisLineVisible()) {
         this.drawAxisLine(var1, var2, var5, var6);
      }

      double var8 = (double)this.getTickMarkOutsideLength();
      double var10 = (double)this.getTickMarkInsideLength();
      List var12 = this.refreshTicks(var1, var7, var5, var6);
      var7.setTicks(var12);
      var1.setFont(this.getTickLabelFont());
      Iterator var13 = var12.iterator();

      while(var13.hasNext()) {
         ValueTick var14 = (ValueTick)var13.next();
         if(this.isTickLabelsVisible()) {
            var1.setPaint(this.getTickLabelPaint());
            float[] var15 = this.calculateAnchorPoint(var14, var2, var5, var6);
            TextUtilities.drawRotatedString(var14.getText(), var1, var15[0], var15[1], var14.getTextAnchor(), var14.getAngle(), var14.getRotationAnchor());
         }

         if(this.isTickMarksVisible()) {
            float var18 = (float)this.valueToJava2D(var14.getValue(), var5, var6);
            Double var16 = null;
            var1.setStroke(this.getTickMarkStroke());
            var1.setPaint(this.getTickMarkPaint());
            if(var6 == RectangleEdge.LEFT) {
               var16 = new Double(var2 - var8, (double)var18, var2 + var10, (double)var18);
            } else if(var6 == RectangleEdge.RIGHT) {
               var16 = new Double(var2 + var8, (double)var18, var2 - var10, (double)var18);
            } else if(var6 == RectangleEdge.TOP) {
               var16 = new Double((double)var18, var2 - var8, (double)var18, var2 + var10);
            } else if(var6 == RectangleEdge.BOTTOM) {
               var16 = new Double((double)var18, var2 + var8, (double)var18, var2 - var10);
            }

            var1.draw(var16);
         }
      }

      double var17 = 0.0D;
      if(this.isTickLabelsVisible()) {
         if(var6 == RectangleEdge.LEFT) {
            var17 += this.findMaximumTickLabelWidth(var12, var1, var4, this.isVerticalTickLabels());
            var7.cursorLeft(var17);
         } else if(var6 == RectangleEdge.RIGHT) {
            var17 = this.findMaximumTickLabelWidth(var12, var1, var4, this.isVerticalTickLabels());
            var7.cursorRight(var17);
         } else if(var6 == RectangleEdge.TOP) {
            var17 = this.findMaximumTickLabelHeight(var12, var1, var4, this.isVerticalTickLabels());
            var7.cursorUp(var17);
         } else if(var6 == RectangleEdge.BOTTOM) {
            var17 = this.findMaximumTickLabelHeight(var12, var1, var4, this.isVerticalTickLabels());
            var7.cursorDown(var17);
         }
      }

      return var7;
   }

   public AxisSpace reserveSpace(Graphics2D var1, Plot var2, Rectangle2D var3, RectangleEdge var4, AxisSpace var5) {
      if(var5 == null) {
         var5 = new AxisSpace();
      }

      if(!this.isVisible()) {
         return var5;
      } else {
         double var6 = this.getFixedDimension();
         if(var6 > 0.0D) {
            var5.ensureAtLeast(var6, var4);
         }

         double var8 = 0.0D;
         double var10 = 0.0D;
         if(this.isTickLabelsVisible()) {
            var1.setFont(this.getTickLabelFont());
            List var12 = this.refreshTicks(var1, new AxisState(), var3, var4);
            if(RectangleEdge.isTopOrBottom(var4)) {
               var8 = this.findMaximumTickLabelHeight(var12, var1, var3, this.isVerticalTickLabels());
            } else if(RectangleEdge.isLeftOrRight(var4)) {
               var10 = this.findMaximumTickLabelWidth(var12, var1, var3, this.isVerticalTickLabels());
            }
         }

         Rectangle2D var17 = this.getLabelEnclosure(var1, var4);
         double var13 = 0.0D;
         double var15 = 0.0D;
         if(RectangleEdge.isTopOrBottom(var4)) {
            var13 = var17.getHeight();
            var5.add(var13 + var8, var4);
         } else if(RectangleEdge.isLeftOrRight(var4)) {
            var15 = var17.getWidth();
            var5.add(var15 + var10, var4);
         }

         return var5;
      }
   }

   protected double findMaximumTickLabelHeight(List var1, Graphics2D var2, Rectangle2D var3, boolean var4) {
      RectangleInsets var5 = this.getTickLabelInsets();
      Font var6 = this.getTickLabelFont();
      double var7 = 0.0D;
      if(var4) {
         FontMetrics var9 = var2.getFontMetrics(var6);
         Iterator var10 = var1.iterator();

         while(var10.hasNext()) {
            Tick var11 = (Tick)var10.next();
            Rectangle2D var12 = TextUtilities.getTextBounds(var11.getText(), var2, var9);
            if(var12.getWidth() + var5.getTop() + var5.getBottom() > var7) {
               var7 = var12.getWidth() + var5.getTop() + var5.getBottom();
            }
         }
      } else {
         LineMetrics var13 = var6.getLineMetrics("ABCxyz", var2.getFontRenderContext());
         var7 = (double)var13.getHeight() + var5.getTop() + var5.getBottom();
      }

      return var7;
   }

   protected double findMaximumTickLabelWidth(List var1, Graphics2D var2, Rectangle2D var3, boolean var4) {
      RectangleInsets var5 = this.getTickLabelInsets();
      Font var6 = this.getTickLabelFont();
      double var7 = 0.0D;
      if(!var4) {
         FontMetrics var9 = var2.getFontMetrics(var6);
         Iterator var10 = var1.iterator();

         while(var10.hasNext()) {
            Tick var11 = (Tick)var10.next();
            Rectangle2D var12 = TextUtilities.getTextBounds(var11.getText(), var2, var9);
            if(var12.getWidth() + var5.getLeft() + var5.getRight() > var7) {
               var7 = var12.getWidth() + var5.getLeft() + var5.getRight();
            }
         }
      } else {
         LineMetrics var13 = var6.getLineMetrics("ABCxyz", var2.getFontRenderContext());
         var7 = (double)var13.getHeight() + var5.getTop() + var5.getBottom();
      }

      return var7;
   }

   public boolean isInverted() {
      return this.inverted;
   }

   public void setInverted(boolean var1) {
      if(this.inverted != var1) {
         this.inverted = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   public boolean isAutoRange() {
      return this.autoRange;
   }

   public void setAutoRange(boolean var1) {
      this.setAutoRange(var1, true);
   }

   protected void setAutoRange(boolean var1, boolean var2) {
      if(this.autoRange != var1) {
         this.autoRange = var1;
         if(this.autoRange) {
            this.autoAdjustRange();
         }

         if(var2) {
            this.notifyListeners(new AxisChangeEvent(this));
         }
      }

   }

   public double getAutoRangeMinimumSize() {
      return this.autoRangeMinimumSize;
   }

   public void setAutoRangeMinimumSize(double var1) {
      this.setAutoRangeMinimumSize(var1, true);
   }

   public void setAutoRangeMinimumSize(double var1, boolean var3) {
      if(var1 <= 0.0D) {
         throw new IllegalArgumentException("NumberAxis.setAutoRangeMinimumSize(double): must be > 0.0.");
      } else {
         if(this.autoRangeMinimumSize != var1) {
            this.autoRangeMinimumSize = var1;
            if(this.autoRange) {
               this.autoAdjustRange();
            }

            if(var3) {
               this.notifyListeners(new AxisChangeEvent(this));
            }
         }

      }
   }

   public Range getDefaultAutoRange() {
      return this.defaultAutoRange;
   }

   public void setDefaultAutoRange(Range var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'range\' argument.");
      } else {
         this.defaultAutoRange = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public double getLowerMargin() {
      return this.lowerMargin;
   }

   public void setLowerMargin(double var1) {
      this.lowerMargin = var1;
      if(this.isAutoRange()) {
         this.autoAdjustRange();
      }

      this.notifyListeners(new AxisChangeEvent(this));
   }

   public double getUpperMargin() {
      return this.upperMargin;
   }

   public void setUpperMargin(double var1) {
      this.upperMargin = var1;
      if(this.isAutoRange()) {
         this.autoAdjustRange();
      }

      this.notifyListeners(new AxisChangeEvent(this));
   }

   public double getFixedAutoRange() {
      return this.fixedAutoRange;
   }

   public void setFixedAutoRange(double var1) {
      this.fixedAutoRange = var1;
      if(this.isAutoRange()) {
         this.autoAdjustRange();
      }

      this.notifyListeners(new AxisChangeEvent(this));
   }

   public double getLowerBound() {
      return this.range.getLowerBound();
   }

   public void setLowerBound(double var1) {
      if(this.range.getUpperBound() > var1) {
         this.setRange(new Range(var1, this.range.getUpperBound()));
      } else {
         this.setRange(new Range(var1, var1 + 1.0D));
      }

   }

   public double getUpperBound() {
      return this.range.getUpperBound();
   }

   public void setUpperBound(double var1) {
      if(this.range.getLowerBound() < var1) {
         this.setRange(new Range(this.range.getLowerBound(), var1));
      } else {
         this.setRange(var1 - 1.0D, var1);
      }

   }

   public Range getRange() {
      return this.range;
   }

   public void setRange(Range var1) {
      this.setRange(var1, true, true);
   }

   public void setRange(Range var1, boolean var2, boolean var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'range\' argument.");
      } else {
         if(var2) {
            this.autoRange = false;
         }

         this.range = var1;
         if(var3) {
            this.notifyListeners(new AxisChangeEvent(this));
         }

      }
   }

   public void setRange(double var1, double var3) {
      this.setRange(new Range(var1, var3));
   }

   public void setRangeWithMargins(Range var1) {
      this.setRangeWithMargins(var1, true, true);
   }

   public void setRangeWithMargins(Range var1, boolean var2, boolean var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'range\' argument.");
      } else {
         this.setRange(Range.expand(var1, this.getLowerMargin(), this.getUpperMargin()), var2, var3);
      }
   }

   public void setRangeWithMargins(double var1, double var3) {
      this.setRangeWithMargins(new Range(var1, var3));
   }

   public void setRangeAboutValue(double var1, double var3) {
      this.setRange(new Range(var1 - var3 / 2.0D, var1 + var3 / 2.0D));
   }

   public boolean isAutoTickUnitSelection() {
      return this.autoTickUnitSelection;
   }

   public void setAutoTickUnitSelection(boolean var1) {
      this.setAutoTickUnitSelection(var1, true);
   }

   public void setAutoTickUnitSelection(boolean var1, boolean var2) {
      if(this.autoTickUnitSelection != var1) {
         this.autoTickUnitSelection = var1;
         if(var2) {
            this.notifyListeners(new AxisChangeEvent(this));
         }
      }

   }

   public TickUnitSource getStandardTickUnits() {
      return this.standardTickUnits;
   }

   public void setStandardTickUnits(TickUnitSource var1) {
      this.standardTickUnits = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public abstract double valueToJava2D(double var1, Rectangle2D var3, RectangleEdge var4);

   public double lengthToJava2D(double var1, Rectangle2D var3, RectangleEdge var4) {
      double var5 = this.valueToJava2D(0.0D, var3, var4);
      double var7 = this.valueToJava2D(var1, var3, var4);
      return Math.abs(var7 - var5);
   }

   public abstract double java2DToValue(double var1, Rectangle2D var3, RectangleEdge var4);

   protected abstract void autoAdjustRange();

   public void centerRange(double var1) {
      double var3 = this.range.getCentralValue();
      Range var5 = new Range(this.range.getLowerBound() + var1 - var3, this.range.getUpperBound() + var1 - var3);
      this.setRange(var5);
   }

   public void resizeRange(double var1) {
      this.resizeRange(var1, this.range.getCentralValue());
   }

   public void resizeRange(double var1, double var3) {
      if(var1 > 0.0D) {
         double var5 = this.range.getLength() * var1 / 2.0D;
         Range var7 = new Range(var3 - var5, var3 + var5);
         this.setRange(var7);
      } else {
         this.setAutoRange(true);
      }

   }

   public void zoomRange(double var1, double var3) {
      double var5 = this.range.getLowerBound();
      double var7 = this.range.getLength();
      Range var9 = null;
      if(this.isInverted()) {
         var9 = new Range(var5 + var7 * (1.0D - var3), var5 + var7 * (1.0D - var1));
      } else {
         var9 = new Range(var5 + var7 * var1, var5 + var7 * var3);
      }

      this.setRange(var9);
   }

   protected int getAutoTickIndex() {
      return this.autoTickIndex;
   }

   protected void setAutoTickIndex(int var1) {
      this.autoTickIndex = var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ValueAxis)) {
         return false;
      } else {
         ValueAxis var2 = (ValueAxis)var1;
         return this.positiveArrowVisible != var2.positiveArrowVisible?false:(this.negativeArrowVisible != var2.negativeArrowVisible?false:(this.inverted != var2.inverted?false:(!ObjectUtilities.equal(this.range, var2.range)?false:(this.autoRange != var2.autoRange?false:(this.autoRangeMinimumSize != var2.autoRangeMinimumSize?false:(!this.defaultAutoRange.equals(var2.defaultAutoRange)?false:(this.upperMargin != var2.upperMargin?false:(this.lowerMargin != var2.lowerMargin?false:(this.fixedAutoRange != var2.fixedAutoRange?false:(this.autoTickUnitSelection != var2.autoTickUnitSelection?false:(!ObjectUtilities.equal(this.standardTickUnits, var2.standardTickUnits)?false:(this.verticalTickLabels != var2.verticalTickLabels?false:super.equals(var1)))))))))))));
      }
   }

   public Object clone() {
      ValueAxis var1 = (ValueAxis)super.clone();
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeShape(this.upArrow, var1);
      SerialUtilities.writeShape(this.downArrow, var1);
      SerialUtilities.writeShape(this.leftArrow, var1);
      SerialUtilities.writeShape(this.rightArrow, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.upArrow = SerialUtilities.readShape(var1);
      this.downArrow = SerialUtilities.readShape(var1);
      this.leftArrow = SerialUtilities.readShape(var1);
      this.rightArrow = SerialUtilities.readShape(var1);
   }
}
