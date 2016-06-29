package org.jfree.chart.axis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
import javax.swing.event.EventListenerList;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.event.AxisChangeListener;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public abstract class Axis implements Serializable, Cloneable {
   private static final long serialVersionUID = 7719289504573298271L;
   public static final boolean DEFAULT_AXIS_VISIBLE = true;
   public static final Font DEFAULT_AXIS_LABEL_FONT = new Font("SansSerif", 0, 12);
   public static final Paint DEFAULT_AXIS_LABEL_PAINT;
   public static final RectangleInsets DEFAULT_AXIS_LABEL_INSETS;
   public static final Paint DEFAULT_AXIS_LINE_PAINT;
   public static final Stroke DEFAULT_AXIS_LINE_STROKE;
   public static final boolean DEFAULT_TICK_LABELS_VISIBLE = true;
   public static final Font DEFAULT_TICK_LABEL_FONT;
   public static final Paint DEFAULT_TICK_LABEL_PAINT;
   public static final RectangleInsets DEFAULT_TICK_LABEL_INSETS;
   public static final boolean DEFAULT_TICK_MARKS_VISIBLE = true;
   public static final Stroke DEFAULT_TICK_MARK_STROKE;
   public static final Paint DEFAULT_TICK_MARK_PAINT;
   public static final float DEFAULT_TICK_MARK_INSIDE_LENGTH = 0.0F;
   public static final float DEFAULT_TICK_MARK_OUTSIDE_LENGTH = 2.0F;
   private boolean visible;
   private String label;
   private Font labelFont;
   private transient Paint labelPaint;
   private RectangleInsets labelInsets;
   private double labelAngle;
   private boolean axisLineVisible;
   private transient Stroke axisLineStroke;
   private transient Paint axisLinePaint;
   private boolean tickLabelsVisible;
   private Font tickLabelFont;
   private transient Paint tickLabelPaint;
   private RectangleInsets tickLabelInsets;
   private boolean tickMarksVisible;
   private float tickMarkInsideLength;
   private float tickMarkOutsideLength;
   private transient Stroke tickMarkStroke;
   private transient Paint tickMarkPaint;
   private double fixedDimension;
   private transient Plot plot;
   private transient EventListenerList listenerList;
   static Class class$org$jfree$chart$event$AxisChangeListener;

   protected Axis(String var1) {
      this.label = var1;
      this.visible = true;
      this.labelFont = DEFAULT_AXIS_LABEL_FONT;
      this.labelPaint = DEFAULT_AXIS_LABEL_PAINT;
      this.labelInsets = DEFAULT_AXIS_LABEL_INSETS;
      this.labelAngle = 0.0D;
      this.axisLineVisible = true;
      this.axisLinePaint = DEFAULT_AXIS_LINE_PAINT;
      this.axisLineStroke = DEFAULT_AXIS_LINE_STROKE;
      this.tickLabelsVisible = true;
      this.tickLabelFont = DEFAULT_TICK_LABEL_FONT;
      this.tickLabelPaint = DEFAULT_TICK_LABEL_PAINT;
      this.tickLabelInsets = DEFAULT_TICK_LABEL_INSETS;
      this.tickMarksVisible = true;
      this.tickMarkStroke = DEFAULT_TICK_MARK_STROKE;
      this.tickMarkPaint = DEFAULT_TICK_MARK_PAINT;
      this.tickMarkInsideLength = 0.0F;
      this.tickMarkOutsideLength = 2.0F;
      this.plot = null;
      this.listenerList = new EventListenerList();
   }

   public boolean isVisible() {
      return this.visible;
   }

   public void setVisible(boolean var1) {
      if(var1 != this.visible) {
         this.visible = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   public String getLabel() {
      return this.label;
   }

   public void setLabel(String var1) {
      String var2 = this.label;
      if(var2 != null) {
         if(!var2.equals(var1)) {
            this.label = var1;
            this.notifyListeners(new AxisChangeEvent(this));
         }
      } else if(var1 != null) {
         this.label = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   public Font getLabelFont() {
      return this.labelFont;
   }

   public void setLabelFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         if(!this.labelFont.equals(var1)) {
            this.labelFont = var1;
            this.notifyListeners(new AxisChangeEvent(this));
         }

      }
   }

   public Paint getLabelPaint() {
      return this.labelPaint;
   }

   public void setLabelPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.labelPaint = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public RectangleInsets getLabelInsets() {
      return this.labelInsets;
   }

   public void setLabelInsets(RectangleInsets var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'insets\' argument.");
      } else {
         if(!var1.equals(this.labelInsets)) {
            this.labelInsets = var1;
            this.notifyListeners(new AxisChangeEvent(this));
         }

      }
   }

   public double getLabelAngle() {
      return this.labelAngle;
   }

   public void setLabelAngle(double var1) {
      this.labelAngle = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public boolean isAxisLineVisible() {
      return this.axisLineVisible;
   }

   public void setAxisLineVisible(boolean var1) {
      this.axisLineVisible = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public Paint getAxisLinePaint() {
      return this.axisLinePaint;
   }

   public void setAxisLinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.axisLinePaint = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Stroke getAxisLineStroke() {
      return this.axisLineStroke;
   }

   public void setAxisLineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.axisLineStroke = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public boolean isTickLabelsVisible() {
      return this.tickLabelsVisible;
   }

   public void setTickLabelsVisible(boolean var1) {
      if(var1 != this.tickLabelsVisible) {
         this.tickLabelsVisible = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   public Font getTickLabelFont() {
      return this.tickLabelFont;
   }

   public void setTickLabelFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         if(!this.tickLabelFont.equals(var1)) {
            this.tickLabelFont = var1;
            this.notifyListeners(new AxisChangeEvent(this));
         }

      }
   }

   public Paint getTickLabelPaint() {
      return this.tickLabelPaint;
   }

   public void setTickLabelPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.tickLabelPaint = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public RectangleInsets getTickLabelInsets() {
      return this.tickLabelInsets;
   }

   public void setTickLabelInsets(RectangleInsets var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'insets\' argument.");
      } else {
         if(!this.tickLabelInsets.equals(var1)) {
            this.tickLabelInsets = var1;
            this.notifyListeners(new AxisChangeEvent(this));
         }

      }
   }

   public boolean isTickMarksVisible() {
      return this.tickMarksVisible;
   }

   public void setTickMarksVisible(boolean var1) {
      if(var1 != this.tickMarksVisible) {
         this.tickMarksVisible = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   public float getTickMarkInsideLength() {
      return this.tickMarkInsideLength;
   }

   public void setTickMarkInsideLength(float var1) {
      this.tickMarkInsideLength = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public float getTickMarkOutsideLength() {
      return this.tickMarkOutsideLength;
   }

   public void setTickMarkOutsideLength(float var1) {
      this.tickMarkOutsideLength = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public Stroke getTickMarkStroke() {
      return this.tickMarkStroke;
   }

   public void setTickMarkStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         if(!this.tickMarkStroke.equals(var1)) {
            this.tickMarkStroke = var1;
            this.notifyListeners(new AxisChangeEvent(this));
         }

      }
   }

   public Paint getTickMarkPaint() {
      return this.tickMarkPaint;
   }

   public void setTickMarkPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.tickMarkPaint = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Plot getPlot() {
      return this.plot;
   }

   public void setPlot(Plot var1) {
      this.plot = var1;
      this.configure();
   }

   public double getFixedDimension() {
      return this.fixedDimension;
   }

   public void setFixedDimension(double var1) {
      this.fixedDimension = var1;
   }

   public abstract void configure();

   public abstract AxisSpace reserveSpace(Graphics2D var1, Plot var2, Rectangle2D var3, RectangleEdge var4, AxisSpace var5);

   public abstract AxisState draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6, PlotRenderingInfo var7);

   public abstract List refreshTicks(Graphics2D var1, AxisState var2, Rectangle2D var3, RectangleEdge var4);

   public void addChangeListener(AxisChangeListener var1) {
      this.listenerList.add(class$org$jfree$chart$event$AxisChangeListener == null?(class$org$jfree$chart$event$AxisChangeListener = class$("org.jfree.chart.event.AxisChangeListener")):class$org$jfree$chart$event$AxisChangeListener, var1);
   }

   public void removeChangeListener(AxisChangeListener var1) {
      this.listenerList.remove(class$org$jfree$chart$event$AxisChangeListener == null?(class$org$jfree$chart$event$AxisChangeListener = class$("org.jfree.chart.event.AxisChangeListener")):class$org$jfree$chart$event$AxisChangeListener, var1);
   }

   public boolean hasListener(EventListener var1) {
      List var2 = Arrays.asList(this.listenerList.getListenerList());
      return var2.contains(var1);
   }

   protected void notifyListeners(AxisChangeEvent var1) {
      Object[] var2 = this.listenerList.getListenerList();

      for(int var3 = var2.length - 2; var3 >= 0; var3 -= 2) {
         if(var2[var3] == (class$org$jfree$chart$event$AxisChangeListener == null?(class$org$jfree$chart$event$AxisChangeListener = class$("org.jfree.chart.event.AxisChangeListener")):class$org$jfree$chart$event$AxisChangeListener)) {
            ((AxisChangeListener)var2[var3 + 1]).axisChanged(var1);
         }
      }

   }

   protected Rectangle2D getLabelEnclosure(Graphics2D var1, RectangleEdge var2) {
      Object var3 = new Double();
      String var4 = this.getLabel();
      if(var4 != null && !var4.equals("")) {
         FontMetrics var5 = var1.getFontMetrics(this.getLabelFont());
         Rectangle2D var6 = TextUtilities.getTextBounds(var4, var1, var5);
         RectangleInsets var7 = this.getLabelInsets();
         var6 = var7.createOutsetRectangle(var6);
         double var8 = this.getLabelAngle();
         if(var2 == RectangleEdge.LEFT || var2 == RectangleEdge.RIGHT) {
            --var8;
         }

         double var10 = var6.getCenterX();
         double var12 = var6.getCenterY();
         AffineTransform var14 = AffineTransform.getRotateInstance(var8, var10, var12);
         Shape var15 = var14.createTransformedShape(var6);
         var3 = var15.getBounds2D();
      }

      return (Rectangle2D)var3;
   }

   protected AxisState drawLabel(String var1, Graphics2D var2, Rectangle2D var3, Rectangle2D var4, RectangleEdge var5, AxisState var6) {
      if(var6 == null) {
         throw new IllegalArgumentException("Null \'state\' argument.");
      } else if(var1 != null && !var1.equals("")) {
         Font var7 = this.getLabelFont();
         RectangleInsets var8 = this.getLabelInsets();
         var2.setFont(var7);
         var2.setPaint(this.getLabelPaint());
         FontMetrics var9 = var2.getFontMetrics();
         Rectangle2D var10 = TextUtilities.getTextBounds(var1, var2, var9);
         AffineTransform var11;
         Shape var12;
         double var13;
         double var15;
         if(var5 == RectangleEdge.TOP) {
            var11 = AffineTransform.getRotateInstance(this.getLabelAngle(), var10.getCenterX(), var10.getCenterY());
            var12 = var11.createTransformedShape(var10);
            var10 = var12.getBounds2D();
            var13 = var4.getCenterX();
            var15 = var6.getCursor() - var8.getBottom() - var10.getHeight() / 2.0D;
            TextUtilities.drawRotatedString(var1, var2, (float)var13, (float)var15, TextAnchor.CENTER, this.getLabelAngle(), TextAnchor.CENTER);
            var6.cursorUp(var8.getTop() + var10.getHeight() + var8.getBottom());
         } else if(var5 == RectangleEdge.BOTTOM) {
            var11 = AffineTransform.getRotateInstance(this.getLabelAngle(), var10.getCenterX(), var10.getCenterY());
            var12 = var11.createTransformedShape(var10);
            var10 = var12.getBounds2D();
            var13 = var4.getCenterX();
            var15 = var6.getCursor() + var8.getTop() + var10.getHeight() / 2.0D;
            TextUtilities.drawRotatedString(var1, var2, (float)var13, (float)var15, TextAnchor.CENTER, this.getLabelAngle(), TextAnchor.CENTER);
            var6.cursorDown(var8.getTop() + var10.getHeight() + var8.getBottom());
         } else if(var5 == RectangleEdge.LEFT) {
            var11 = AffineTransform.getRotateInstance(this.getLabelAngle() - 1.5707963267948966D, var10.getCenterX(), var10.getCenterY());
            var12 = var11.createTransformedShape(var10);
            var10 = var12.getBounds2D();
            var13 = var6.getCursor() - var8.getRight() - var10.getWidth() / 2.0D;
            var15 = var4.getCenterY();
            TextUtilities.drawRotatedString(var1, var2, (float)var13, (float)var15, TextAnchor.CENTER, this.getLabelAngle() - 1.5707963267948966D, TextAnchor.CENTER);
            var6.cursorLeft(var8.getLeft() + var10.getWidth() + var8.getRight());
         } else if(var5 == RectangleEdge.RIGHT) {
            var11 = AffineTransform.getRotateInstance(this.getLabelAngle() + 1.5707963267948966D, var10.getCenterX(), var10.getCenterY());
            var12 = var11.createTransformedShape(var10);
            var10 = var12.getBounds2D();
            var13 = var6.getCursor() + var8.getLeft() + var10.getWidth() / 2.0D;
            var15 = var4.getY() + var4.getHeight() / 2.0D;
            TextUtilities.drawRotatedString(var1, var2, (float)var13, (float)var15, TextAnchor.CENTER, this.getLabelAngle() + 1.5707963267948966D, TextAnchor.CENTER);
            var6.cursorRight(var8.getLeft() + var10.getWidth() + var8.getRight());
         }

         return var6;
      } else {
         return var6;
      }
   }

   protected void drawAxisLine(Graphics2D var1, double var2, Rectangle2D var4, RectangleEdge var5) {
      java.awt.geom.Line2D.Double var6 = null;
      if(var5 == RectangleEdge.TOP) {
         var6 = new java.awt.geom.Line2D.Double(var4.getX(), var2, var4.getMaxX(), var2);
      } else if(var5 == RectangleEdge.BOTTOM) {
         var6 = new java.awt.geom.Line2D.Double(var4.getX(), var2, var4.getMaxX(), var2);
      } else if(var5 == RectangleEdge.LEFT) {
         var6 = new java.awt.geom.Line2D.Double(var2, var4.getY(), var2, var4.getMaxY());
      } else if(var5 == RectangleEdge.RIGHT) {
         var6 = new java.awt.geom.Line2D.Double(var2, var4.getY(), var2, var4.getMaxY());
      }

      var1.setPaint(this.axisLinePaint);
      var1.setStroke(this.axisLineStroke);
      var1.draw(var6);
   }

   public Object clone() {
      Axis var1 = (Axis)super.clone();
      var1.plot = null;
      var1.listenerList = new EventListenerList();
      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Axis)) {
         return false;
      } else {
         Axis var2 = (Axis)var1;
         return this.visible != var2.visible?false:(!ObjectUtilities.equal(this.label, var2.label)?false:(!ObjectUtilities.equal(this.labelFont, var2.labelFont)?false:(!PaintUtilities.equal(this.labelPaint, var2.labelPaint)?false:(!ObjectUtilities.equal(this.labelInsets, var2.labelInsets)?false:(this.labelAngle != var2.labelAngle?false:(this.axisLineVisible != var2.axisLineVisible?false:(!ObjectUtilities.equal(this.axisLineStroke, var2.axisLineStroke)?false:(!PaintUtilities.equal(this.axisLinePaint, var2.axisLinePaint)?false:(this.tickLabelsVisible != var2.tickLabelsVisible?false:(!ObjectUtilities.equal(this.tickLabelFont, var2.tickLabelFont)?false:(!PaintUtilities.equal(this.tickLabelPaint, var2.tickLabelPaint)?false:(!ObjectUtilities.equal(this.tickLabelInsets, var2.tickLabelInsets)?false:(this.tickMarksVisible != var2.tickMarksVisible?false:(this.tickMarkInsideLength != var2.tickMarkInsideLength?false:(this.tickMarkOutsideLength != var2.tickMarkOutsideLength?false:(!PaintUtilities.equal(this.tickMarkPaint, var2.tickMarkPaint)?false:(!ObjectUtilities.equal(this.tickMarkStroke, var2.tickMarkStroke)?false:this.fixedDimension == var2.fixedDimension)))))))))))))))));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.labelPaint, var1);
      SerialUtilities.writePaint(this.tickLabelPaint, var1);
      SerialUtilities.writeStroke(this.axisLineStroke, var1);
      SerialUtilities.writePaint(this.axisLinePaint, var1);
      SerialUtilities.writeStroke(this.tickMarkStroke, var1);
      SerialUtilities.writePaint(this.tickMarkPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.labelPaint = SerialUtilities.readPaint(var1);
      this.tickLabelPaint = SerialUtilities.readPaint(var1);
      this.axisLineStroke = SerialUtilities.readStroke(var1);
      this.axisLinePaint = SerialUtilities.readPaint(var1);
      this.tickMarkStroke = SerialUtilities.readStroke(var1);
      this.tickMarkPaint = SerialUtilities.readPaint(var1);
      this.listenerList = new EventListenerList();
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      DEFAULT_AXIS_LABEL_PAINT = Color.black;
      DEFAULT_AXIS_LABEL_INSETS = new RectangleInsets(3.0D, 3.0D, 3.0D, 3.0D);
      DEFAULT_AXIS_LINE_PAINT = Color.gray;
      DEFAULT_AXIS_LINE_STROKE = new BasicStroke(1.0F);
      DEFAULT_TICK_LABEL_FONT = new Font("SansSerif", 0, 10);
      DEFAULT_TICK_LABEL_PAINT = Color.black;
      DEFAULT_TICK_LABEL_INSETS = new RectangleInsets(2.0D, 4.0D, 2.0D, 4.0D);
      DEFAULT_TICK_MARK_STROKE = new BasicStroke(1.0F);
      DEFAULT_TICK_MARK_PAINT = Color.gray;
   }
}
