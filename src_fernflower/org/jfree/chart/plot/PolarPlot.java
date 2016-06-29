package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.chart.plot.Zoomable;
import org.jfree.chart.renderer.PolarItemRenderer;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class PolarPlot extends Plot implements Serializable, Cloneable, RendererChangeListener, ValueAxisPlot, Zoomable {
   private static final long serialVersionUID = 3794383185924179525L;
   private static final int MARGIN = 20;
   private static final double ANNOTATION_MARGIN = 7.0D;
   public static final Stroke DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5F, 0, 2, 0.0F, new float[]{2.0F, 2.0F}, 0.0F);
   public static final Paint DEFAULT_GRIDLINE_PAINT;
   protected static ResourceBundle localizationResources;
   private List angleTicks;
   private ValueAxis axis;
   private XYDataset dataset;
   private PolarItemRenderer renderer;
   private boolean angleLabelsVisible;
   private Font angleLabelFont;
   private transient Paint angleLabelPaint;
   private boolean angleGridlinesVisible;
   private transient Stroke angleGridlineStroke;
   private transient Paint angleGridlinePaint;
   private boolean radiusGridlinesVisible;
   private transient Stroke radiusGridlineStroke;
   private transient Paint radiusGridlinePaint;
   private List cornerTextItems;

   public PolarPlot() {
      this((XYDataset)null, (ValueAxis)null, (PolarItemRenderer)null);
   }

   public PolarPlot(XYDataset var1, ValueAxis var2, PolarItemRenderer var3) {
      this.angleLabelsVisible = true;
      this.angleLabelFont = new Font("SansSerif", 0, 12);
      this.angleLabelPaint = Color.black;
      this.cornerTextItems = new ArrayList();
      this.dataset = var1;
      if(this.dataset != null) {
         this.dataset.addChangeListener(this);
      }

      this.angleTicks = new ArrayList();
      this.angleTicks.add(new NumberTick(new Double(0.0D), "0", TextAnchor.CENTER, TextAnchor.CENTER, 0.0D));
      this.angleTicks.add(new NumberTick(new Double(45.0D), "45", TextAnchor.CENTER, TextAnchor.CENTER, 0.0D));
      this.angleTicks.add(new NumberTick(new Double(90.0D), "90", TextAnchor.CENTER, TextAnchor.CENTER, 0.0D));
      this.angleTicks.add(new NumberTick(new Double(135.0D), "135", TextAnchor.CENTER, TextAnchor.CENTER, 0.0D));
      this.angleTicks.add(new NumberTick(new Double(180.0D), "180", TextAnchor.CENTER, TextAnchor.CENTER, 0.0D));
      this.angleTicks.add(new NumberTick(new Double(225.0D), "225", TextAnchor.CENTER, TextAnchor.CENTER, 0.0D));
      this.angleTicks.add(new NumberTick(new Double(270.0D), "270", TextAnchor.CENTER, TextAnchor.CENTER, 0.0D));
      this.angleTicks.add(new NumberTick(new Double(315.0D), "315", TextAnchor.CENTER, TextAnchor.CENTER, 0.0D));
      this.axis = var2;
      if(this.axis != null) {
         this.axis.setPlot(this);
         this.axis.addChangeListener(this);
      }

      this.renderer = var3;
      if(this.renderer != null) {
         this.renderer.setPlot(this);
         this.renderer.addChangeListener(this);
      }

      this.angleGridlinesVisible = true;
      this.angleGridlineStroke = DEFAULT_GRIDLINE_STROKE;
      this.angleGridlinePaint = DEFAULT_GRIDLINE_PAINT;
      this.radiusGridlinesVisible = true;
      this.radiusGridlineStroke = DEFAULT_GRIDLINE_STROKE;
      this.radiusGridlinePaint = DEFAULT_GRIDLINE_PAINT;
   }

   public void addCornerTextItem(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'text\' argument.");
      } else {
         this.cornerTextItems.add(var1);
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public void removeCornerTextItem(String var1) {
      boolean var2 = this.cornerTextItems.remove(var1);
      if(var2) {
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public void clearCornerTextItems() {
      if(this.cornerTextItems.size() > 0) {
         this.cornerTextItems.clear();
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public String getPlotType() {
      return localizationResources.getString("Polar_Plot");
   }

   public ValueAxis getAxis() {
      return this.axis;
   }

   public void setAxis(ValueAxis var1) {
      if(var1 != null) {
         var1.setPlot(this);
      }

      if(this.axis != null) {
         this.axis.removeChangeListener(this);
      }

      this.axis = var1;
      if(this.axis != null) {
         this.axis.configure();
         this.axis.addChangeListener(this);
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public XYDataset getDataset() {
      return this.dataset;
   }

   public void setDataset(XYDataset var1) {
      XYDataset var2 = this.dataset;
      if(var2 != null) {
         var2.removeChangeListener(this);
      }

      this.dataset = var1;
      if(this.dataset != null) {
         this.setDatasetGroup(this.dataset.getGroup());
         this.dataset.addChangeListener(this);
      }

      DatasetChangeEvent var3 = new DatasetChangeEvent(this, this.dataset);
      this.datasetChanged(var3);
   }

   public PolarItemRenderer getRenderer() {
      return this.renderer;
   }

   public void setRenderer(PolarItemRenderer var1) {
      if(this.renderer != null) {
         this.renderer.removeChangeListener(this);
      }

      this.renderer = var1;
      if(this.renderer != null) {
         this.renderer.setPlot(this);
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public boolean isAngleLabelsVisible() {
      return this.angleLabelsVisible;
   }

   public void setAngleLabelsVisible(boolean var1) {
      if(this.angleLabelsVisible != var1) {
         this.angleLabelsVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Font getAngleLabelFont() {
      return this.angleLabelFont;
   }

   public void setAngleLabelFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.angleLabelFont = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getAngleLabelPaint() {
      return this.angleLabelPaint;
   }

   public void setAngleLabelPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.angleLabelPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean isAngleGridlinesVisible() {
      return this.angleGridlinesVisible;
   }

   public void setAngleGridlinesVisible(boolean var1) {
      if(this.angleGridlinesVisible != var1) {
         this.angleGridlinesVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Stroke getAngleGridlineStroke() {
      return this.angleGridlineStroke;
   }

   public void setAngleGridlineStroke(Stroke var1) {
      this.angleGridlineStroke = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getAngleGridlinePaint() {
      return this.angleGridlinePaint;
   }

   public void setAngleGridlinePaint(Paint var1) {
      this.angleGridlinePaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public boolean isRadiusGridlinesVisible() {
      return this.radiusGridlinesVisible;
   }

   public void setRadiusGridlinesVisible(boolean var1) {
      if(this.radiusGridlinesVisible != var1) {
         this.radiusGridlinesVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Stroke getRadiusGridlineStroke() {
      return this.radiusGridlineStroke;
   }

   public void setRadiusGridlineStroke(Stroke var1) {
      this.radiusGridlineStroke = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getRadiusGridlinePaint() {
      return this.radiusGridlinePaint;
   }

   public void setRadiusGridlinePaint(Paint var1) {
      this.radiusGridlinePaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      boolean var6 = var2.getWidth() <= 10.0D;
      boolean var7 = var2.getHeight() <= 10.0D;
      if(!var6 && !var7) {
         if(var5 != null) {
            var5.setPlotArea(var2);
         }

         RectangleInsets var8 = this.getInsets();
         var8.trim(var2);
         if(var5 != null) {
            var5.setDataArea(var2);
         }

         this.drawBackground(var1, var2);
         double var10 = Math.min(var2.getWidth() / 2.0D, var2.getHeight() / 2.0D) - 20.0D;
         java.awt.geom.Rectangle2D.Double var12 = new java.awt.geom.Rectangle2D.Double(var2.getCenterX(), var2.getCenterY(), var10, var10);
         AxisState var13 = this.drawAxis(var1, var2, var12);
         if(this.renderer != null) {
            Shape var14 = var1.getClip();
            Composite var15 = var1.getComposite();
            var1.clip(var2);
            var1.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
            this.drawGridlines(var1, var2, this.angleTicks, var13.getTicks());
            this.render(var1, var2, var5);
            var1.setClip(var14);
            var1.setComposite(var15);
         }

         this.drawOutline(var1, var2);
         this.drawCornerTextItems(var1, var2);
      }
   }

   protected void drawCornerTextItems(Graphics2D var1, Rectangle2D var2) {
      if(!this.cornerTextItems.isEmpty()) {
         var1.setColor(Color.black);
         double var3 = 0.0D;
         double var5 = 0.0D;

         Rectangle2D var10;
         for(Iterator var7 = this.cornerTextItems.iterator(); var7.hasNext(); var5 += var10.getHeight()) {
            String var8 = (String)var7.next();
            FontMetrics var9 = var1.getFontMetrics();
            var10 = TextUtilities.getTextBounds(var8, var1, var9);
            var3 = Math.max(var3, var10.getWidth());
         }

         double var18 = 14.0D;
         double var19 = 7.0D;
         var3 += var18;
         var5 += var19;
         double var11 = var2.getMaxX() - var3;
         double var13 = var2.getMaxY() - var5;
         var1.drawRect((int)var11, (int)var13, (int)var3, (int)var5);
         var11 += 7.0D;
         Iterator var15 = this.cornerTextItems.iterator();

         while(var15.hasNext()) {
            String var16 = (String)var15.next();
            Rectangle2D var17 = TextUtilities.getTextBounds(var16, var1, var1.getFontMetrics());
            var13 += var17.getHeight();
            var1.drawString(var16, (int)var11, (int)var13);
         }

      }
   }

   protected AxisState drawAxis(Graphics2D var1, Rectangle2D var2, Rectangle2D var3) {
      return this.axis.draw(var1, var3.getMinY(), var2, var3, RectangleEdge.TOP, (PlotRenderingInfo)null);
   }

   protected void render(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3) {
      if(!DatasetUtilities.isEmptyOrNull(this.dataset)) {
         int var4 = this.dataset.getSeriesCount();

         for(int var5 = 0; var5 < var4; ++var5) {
            this.renderer.drawSeries(var1, var2, var3, this, this.dataset, var5);
         }
      } else {
         this.drawNoDataMessage(var1, var2);
      }

   }

   protected void drawGridlines(Graphics2D var1, Rectangle2D var2, List var3, List var4) {
      if(this.renderer != null) {
         Stroke var5;
         Paint var6;
         if(this.isAngleGridlinesVisible()) {
            var5 = this.getAngleGridlineStroke();
            var6 = this.getAngleGridlinePaint();
            if(var5 != null && var6 != null) {
               this.renderer.drawAngularGridLines(var1, this, var3, var2);
            }
         }

         if(this.isRadiusGridlinesVisible()) {
            var5 = this.getRadiusGridlineStroke();
            var6 = this.getRadiusGridlinePaint();
            if(var5 != null && var6 != null) {
               this.renderer.drawRadialGridLines(var1, this, this.axis, var4, var2);
            }
         }

      }
   }

   public void zoom(double var1) {
      if(var1 > 0.0D) {
         double var3 = this.getMaxRadius();
         double var5 = var3 * var1;
         this.axis.setUpperBound(var5);
         this.getAxis().setAutoRange(false);
      } else {
         this.getAxis().setAutoRange(true);
      }

   }

   public Range getDataRange(ValueAxis var1) {
      Range var2 = null;
      if(this.dataset != null) {
         var2 = Range.combine(var2, DatasetUtilities.findRangeBounds(this.dataset));
      }

      return var2;
   }

   public void datasetChanged(DatasetChangeEvent var1) {
      if(this.axis != null) {
         this.axis.configure();
      }

      if(this.getParent() != null) {
         this.getParent().datasetChanged(var1);
      } else {
         super.datasetChanged(var1);
      }

   }

   public void rendererChanged(RendererChangeEvent var1) {
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public int getSeriesCount() {
      int var1 = 0;
      if(this.dataset != null) {
         var1 = this.dataset.getSeriesCount();
      }

      return var1;
   }

   public LegendItemCollection getLegendItems() {
      LegendItemCollection var1 = new LegendItemCollection();
      if(this.dataset != null && this.renderer != null) {
         int var2 = this.dataset.getSeriesCount();

         for(int var3 = 0; var3 < var2; ++var3) {
            LegendItem var4 = this.renderer.getLegendItem(var3);
            var1.add(var4);
         }
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof PolarPlot)) {
         return false;
      } else {
         PolarPlot var2 = (PolarPlot)var1;
         return !ObjectUtilities.equal(this.axis, var2.axis)?false:(!ObjectUtilities.equal(this.renderer, var2.renderer)?false:(this.angleGridlinesVisible != var2.angleGridlinesVisible?false:(this.angleLabelsVisible != var2.angleLabelsVisible?false:(!this.angleLabelFont.equals(var2.angleLabelFont)?false:(!PaintUtilities.equal(this.angleLabelPaint, var2.angleLabelPaint)?false:(!ObjectUtilities.equal(this.angleGridlineStroke, var2.angleGridlineStroke)?false:(!PaintUtilities.equal(this.angleGridlinePaint, var2.angleGridlinePaint)?false:(this.radiusGridlinesVisible != var2.radiusGridlinesVisible?false:(!ObjectUtilities.equal(this.radiusGridlineStroke, var2.radiusGridlineStroke)?false:(!PaintUtilities.equal(this.radiusGridlinePaint, var2.radiusGridlinePaint)?false:(!this.cornerTextItems.equals(var2.cornerTextItems)?false:super.equals(var1))))))))))));
      }
   }

   public Object clone() {
      PolarPlot var1 = (PolarPlot)super.clone();
      if(this.axis != null) {
         var1.axis = (ValueAxis)ObjectUtilities.clone(this.axis);
         var1.axis.setPlot(var1);
         var1.axis.addChangeListener(var1);
      }

      if(var1.dataset != null) {
         var1.dataset.addChangeListener(var1);
      }

      if(this.renderer != null) {
         var1.renderer = (PolarItemRenderer)ObjectUtilities.clone(this.renderer);
      }

      var1.cornerTextItems = new ArrayList(this.cornerTextItems);
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeStroke(this.angleGridlineStroke, var1);
      SerialUtilities.writePaint(this.angleGridlinePaint, var1);
      SerialUtilities.writeStroke(this.radiusGridlineStroke, var1);
      SerialUtilities.writePaint(this.radiusGridlinePaint, var1);
      SerialUtilities.writePaint(this.angleLabelPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.angleGridlineStroke = SerialUtilities.readStroke(var1);
      this.angleGridlinePaint = SerialUtilities.readPaint(var1);
      this.radiusGridlineStroke = SerialUtilities.readStroke(var1);
      this.radiusGridlinePaint = SerialUtilities.readPaint(var1);
      this.angleLabelPaint = SerialUtilities.readPaint(var1);
      if(this.axis != null) {
         this.axis.setPlot(this);
         this.axis.addChangeListener(this);
      }

      if(this.dataset != null) {
         this.dataset.addChangeListener(this);
      }

   }

   public void zoomDomainAxes(double var1, PlotRenderingInfo var3, Point2D var4) {
   }

   public void zoomDomainAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6) {
   }

   public void zoomRangeAxes(double var1, PlotRenderingInfo var3, Point2D var4) {
      this.zoom(var1);
   }

   public void zoomRangeAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6) {
      this.zoom((var3 + var1) / 2.0D);
   }

   public boolean isDomainZoomable() {
      return false;
   }

   public boolean isRangeZoomable() {
      return true;
   }

   public PlotOrientation getOrientation() {
      return PlotOrientation.HORIZONTAL;
   }

   public double getMaxRadius() {
      return this.axis.getUpperBound();
   }

   public Point translateValueThetaRadiusToJava2D(double var1, double var3, Rectangle2D var5) {
      double var6 = Math.toRadians(var1 - 90.0D);
      double var8 = var5.getMinX() + 20.0D;
      double var10 = var5.getMaxX() - 20.0D;
      double var12 = var5.getMinY() + 20.0D;
      double var14 = var5.getMaxY() - 20.0D;
      double var16 = var10 - var8;
      double var18 = var14 - var12;
      double var20 = Math.min(var16, var18);
      double var22 = var8 + var16 / 2.0D;
      double var24 = var12 + var18 / 2.0D;
      double var26 = this.axis.getLowerBound();
      double var28 = this.getMaxRadius();
      double var30 = Math.max(var3, var26);
      double var32 = var20 / 2.0D * Math.cos(var6);
      double var34 = var20 / 2.0D * Math.sin(var6);
      float var36 = (float)(var22 + var32 * (var30 - var26) / (var28 - var26));
      float var37 = (float)(var24 + var34 * (var30 - var26) / (var28 - var26));
      int var38 = Math.round(var36);
      int var39 = Math.round(var37);
      Point var40 = new Point(var38, var39);
      return var40;
   }

   static {
      DEFAULT_GRIDLINE_PAINT = Color.gray;
      localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
   }
}
