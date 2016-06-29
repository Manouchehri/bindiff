package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Float;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.PaintMap;
import org.jfree.chart.StrokeMap;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.PieSectionEntity;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PieLabelDistributor;
import org.jfree.chart.plot.PieLabelRecord;
import org.jfree.chart.plot.PiePlotState;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.PieDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.G2TextMeasurer;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBox;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.Rotation;
import org.jfree.util.ShapeUtilities;

public class PiePlot extends Plot implements Serializable, Cloneable {
   private static final long serialVersionUID = -795612466005590431L;
   public static final double DEFAULT_INTERIOR_GAP = 0.25D;
   public static final double MAX_INTERIOR_GAP = 0.4D;
   public static final double DEFAULT_START_ANGLE = 90.0D;
   public static final Font DEFAULT_LABEL_FONT = new Font("SansSerif", 0, 10);
   public static final Paint DEFAULT_LABEL_PAINT;
   public static final Paint DEFAULT_LABEL_BACKGROUND_PAINT;
   public static final Paint DEFAULT_LABEL_OUTLINE_PAINT;
   public static final Stroke DEFAULT_LABEL_OUTLINE_STROKE;
   public static final Paint DEFAULT_LABEL_SHADOW_PAINT;
   public static final double DEFAULT_MINIMUM_ARC_ANGLE_TO_DRAW = 1.0E-5D;
   private PieDataset dataset;
   private int pieIndex;
   private double interiorGap;
   private boolean circular;
   private double startAngle;
   private Rotation direction;
   private transient Paint sectionPaint;
   private PaintMap sectionPaintMap;
   private transient Paint baseSectionPaint;
   private boolean sectionOutlinesVisible;
   private transient Paint sectionOutlinePaint;
   private PaintMap sectionOutlinePaintMap;
   private transient Paint baseSectionOutlinePaint;
   private transient Stroke sectionOutlineStroke;
   private StrokeMap sectionOutlineStrokeMap;
   private transient Stroke baseSectionOutlineStroke;
   private transient Paint shadowPaint;
   private double shadowXOffset;
   private double shadowYOffset;
   private Map explodePercentages;
   private PieSectionLabelGenerator labelGenerator;
   private Font labelFont;
   private transient Paint labelPaint;
   private transient Paint labelBackgroundPaint;
   private transient Paint labelOutlinePaint;
   private transient Stroke labelOutlineStroke;
   private transient Paint labelShadowPaint;
   private double maximumLabelWidth;
   private double labelGap;
   private boolean labelLinksVisible;
   private double labelLinkMargin;
   private transient Paint labelLinkPaint;
   private transient Stroke labelLinkStroke;
   private PieToolTipGenerator toolTipGenerator;
   private PieURLGenerator urlGenerator;
   private PieSectionLabelGenerator legendLabelGenerator;
   private PieSectionLabelGenerator legendLabelToolTipGenerator;
   private PieURLGenerator legendLabelURLGenerator;
   private boolean ignoreNullValues;
   private boolean ignoreZeroValues;
   private transient Shape legendItemShape;
   private double minimumArcAngleToDraw;
   protected static ResourceBundle localizationResources;

   public PiePlot() {
      this((PieDataset)null);
   }

   public PiePlot(PieDataset var1) {
      this.shadowPaint = Color.gray;
      this.shadowXOffset = 4.0D;
      this.shadowYOffset = 4.0D;
      this.maximumLabelWidth = 0.2D;
      this.labelGap = 0.05D;
      this.labelLinkMargin = 0.05D;
      this.labelLinkPaint = Color.black;
      this.labelLinkStroke = new BasicStroke(0.5F);
      this.dataset = var1;
      if(var1 != null) {
         var1.addChangeListener(this);
      }

      this.pieIndex = 0;
      this.interiorGap = 0.25D;
      this.circular = true;
      this.startAngle = 90.0D;
      this.direction = Rotation.CLOCKWISE;
      this.minimumArcAngleToDraw = 1.0E-5D;
      this.sectionPaint = null;
      this.sectionPaintMap = new PaintMap();
      this.baseSectionPaint = Color.gray;
      this.sectionOutlinesVisible = true;
      this.sectionOutlinePaint = null;
      this.sectionOutlinePaintMap = new PaintMap();
      this.baseSectionOutlinePaint = DEFAULT_OUTLINE_PAINT;
      this.sectionOutlineStroke = null;
      this.sectionOutlineStrokeMap = new StrokeMap();
      this.baseSectionOutlineStroke = DEFAULT_OUTLINE_STROKE;
      this.explodePercentages = new TreeMap();
      this.labelGenerator = new StandardPieSectionLabelGenerator();
      this.labelFont = DEFAULT_LABEL_FONT;
      this.labelPaint = DEFAULT_LABEL_PAINT;
      this.labelBackgroundPaint = DEFAULT_LABEL_BACKGROUND_PAINT;
      this.labelOutlinePaint = DEFAULT_LABEL_OUTLINE_PAINT;
      this.labelOutlineStroke = DEFAULT_LABEL_OUTLINE_STROKE;
      this.labelShadowPaint = DEFAULT_LABEL_SHADOW_PAINT;
      this.labelLinksVisible = true;
      this.toolTipGenerator = null;
      this.urlGenerator = null;
      this.legendLabelGenerator = new StandardPieSectionLabelGenerator();
      this.legendLabelToolTipGenerator = null;
      this.legendLabelURLGenerator = null;
      this.legendItemShape = Plot.DEFAULT_LEGEND_ITEM_CIRCLE;
      this.ignoreNullValues = false;
      this.ignoreZeroValues = false;
   }

   public PieDataset getDataset() {
      return this.dataset;
   }

   public void setDataset(PieDataset var1) {
      PieDataset var2 = this.dataset;
      if(var2 != null) {
         var2.removeChangeListener(this);
      }

      this.dataset = var1;
      if(var1 != null) {
         this.setDatasetGroup(var1.getGroup());
         var1.addChangeListener(this);
      }

      DatasetChangeEvent var3 = new DatasetChangeEvent(this, var1);
      this.datasetChanged(var3);
   }

   public int getPieIndex() {
      return this.pieIndex;
   }

   public void setPieIndex(int var1) {
      this.pieIndex = var1;
   }

   public double getStartAngle() {
      return this.startAngle;
   }

   public void setStartAngle(double var1) {
      this.startAngle = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Rotation getDirection() {
      return this.direction;
   }

   public void setDirection(Rotation var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'direction\' argument.");
      } else {
         this.direction = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public double getInteriorGap() {
      return this.interiorGap;
   }

   public void setInteriorGap(double var1) {
      if(var1 >= 0.0D && var1 <= 0.4D) {
         if(this.interiorGap != var1) {
            this.interiorGap = var1;
            this.notifyListeners(new PlotChangeEvent(this));
         }

      } else {
         throw new IllegalArgumentException("Invalid \'percent\' (" + var1 + ") argument.");
      }
   }

   public boolean isCircular() {
      return this.circular;
   }

   public void setCircular(boolean var1) {
      this.setCircular(var1, true);
   }

   public void setCircular(boolean var1, boolean var2) {
      this.circular = var1;
      if(var2) {
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public boolean getIgnoreNullValues() {
      return this.ignoreNullValues;
   }

   public void setIgnoreNullValues(boolean var1) {
      this.ignoreNullValues = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public boolean getIgnoreZeroValues() {
      return this.ignoreZeroValues;
   }

   public void setIgnoreZeroValues(boolean var1) {
      this.ignoreZeroValues = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   protected Paint lookupSectionPaint(Comparable var1) {
      return this.lookupSectionPaint(var1, false);
   }

   protected Paint lookupSectionPaint(Comparable var1, boolean var2) {
      Paint var3 = this.getSectionPaint();
      if(var3 != null) {
         return var3;
      } else {
         var3 = this.sectionPaintMap.getPaint(var1);
         if(var3 != null) {
            return var3;
         } else {
            if(var2) {
               DrawingSupplier var4 = this.getDrawingSupplier();
               if(var4 != null) {
                  var3 = var4.getNextPaint();
                  this.sectionPaintMap.put(var1, var3);
               } else {
                  var3 = this.baseSectionPaint;
               }
            } else {
               var3 = this.baseSectionPaint;
            }

            return var3;
         }
      }
   }

   public Paint getSectionPaint() {
      return this.sectionPaint;
   }

   public void setSectionPaint(Paint var1) {
      this.sectionPaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   protected Comparable getSectionKey(int var1) {
      Object var2 = null;
      if(this.dataset != null && var1 >= 0 && var1 < this.dataset.getItemCount()) {
         var2 = this.dataset.getKey(var1);
      }

      if(var2 == null) {
         var2 = new Integer(var1);
      }

      return (Comparable)var2;
   }

   public Paint getSectionPaint(Comparable var1) {
      return this.sectionPaintMap.getPaint(var1);
   }

   public void setSectionPaint(Comparable var1, Paint var2) {
      this.sectionPaintMap.put(var1, var2);
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getBaseSectionPaint() {
      return this.baseSectionPaint;
   }

   public void setBaseSectionPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.baseSectionPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean getSectionOutlinesVisible() {
      return this.sectionOutlinesVisible;
   }

   public void setSectionOutlinesVisible(boolean var1) {
      this.sectionOutlinesVisible = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   protected Paint lookupSectionOutlinePaint(Comparable var1) {
      return this.lookupSectionOutlinePaint(var1, false);
   }

   protected Paint lookupSectionOutlinePaint(Comparable var1, boolean var2) {
      Paint var3 = this.getSectionOutlinePaint();
      if(var3 != null) {
         return var3;
      } else {
         var3 = this.sectionOutlinePaintMap.getPaint(var1);
         if(var3 != null) {
            return var3;
         } else {
            if(var2) {
               DrawingSupplier var4 = this.getDrawingSupplier();
               if(var4 != null) {
                  var3 = var4.getNextOutlinePaint();
                  this.sectionOutlinePaintMap.put(var1, var3);
               } else {
                  var3 = this.baseSectionOutlinePaint;
               }
            } else {
               var3 = this.baseSectionOutlinePaint;
            }

            return var3;
         }
      }
   }

   public Paint getSectionOutlinePaint() {
      return this.sectionOutlinePaint;
   }

   public void setSectionOutlinePaint(Paint var1) {
      this.sectionOutlinePaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getSectionOutlinePaint(Comparable var1) {
      return this.sectionOutlinePaintMap.getPaint(var1);
   }

   public void setSectionOutlinePaint(Comparable var1, Paint var2) {
      this.sectionOutlinePaintMap.put(var1, var2);
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getBaseSectionOutlinePaint() {
      return this.baseSectionOutlinePaint;
   }

   public void setBaseSectionOutlinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.baseSectionOutlinePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   protected Stroke lookupSectionOutlineStroke(Comparable var1) {
      return this.lookupSectionOutlineStroke(var1, false);
   }

   protected Stroke lookupSectionOutlineStroke(Comparable var1, boolean var2) {
      Stroke var3 = this.getSectionOutlineStroke();
      if(var3 != null) {
         return var3;
      } else {
         var3 = this.sectionOutlineStrokeMap.getStroke(var1);
         if(var3 != null) {
            return var3;
         } else {
            if(var2) {
               DrawingSupplier var4 = this.getDrawingSupplier();
               if(var4 != null) {
                  var3 = var4.getNextOutlineStroke();
                  this.sectionOutlineStrokeMap.put(var1, var3);
               } else {
                  var3 = this.baseSectionOutlineStroke;
               }
            } else {
               var3 = this.baseSectionOutlineStroke;
            }

            return var3;
         }
      }
   }

   public Stroke getSectionOutlineStroke() {
      return this.sectionOutlineStroke;
   }

   public void setSectionOutlineStroke(Stroke var1) {
      this.sectionOutlineStroke = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Stroke getSectionOutlineStroke(Comparable var1) {
      return this.sectionOutlineStrokeMap.getStroke(var1);
   }

   public void setSectionOutlineStroke(Comparable var1, Stroke var2) {
      this.sectionOutlineStrokeMap.put(var1, var2);
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Stroke getBaseSectionOutlineStroke() {
      return this.baseSectionOutlineStroke;
   }

   public void setBaseSectionOutlineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.baseSectionOutlineStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getShadowPaint() {
      return this.shadowPaint;
   }

   public void setShadowPaint(Paint var1) {
      this.shadowPaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getShadowXOffset() {
      return this.shadowXOffset;
   }

   public void setShadowXOffset(double var1) {
      this.shadowXOffset = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getShadowYOffset() {
      return this.shadowYOffset;
   }

   public void setShadowYOffset(double var1) {
      this.shadowYOffset = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getExplodePercent(Comparable var1) {
      double var2 = 0.0D;
      if(this.explodePercentages != null) {
         Number var4 = (Number)this.explodePercentages.get(var1);
         if(var4 != null) {
            var2 = var4.doubleValue();
         }
      }

      return var2;
   }

   public void setExplodePercent(Comparable var1, double var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         if(this.explodePercentages == null) {
            this.explodePercentages = new TreeMap();
         }

         this.explodePercentages.put(var1, new Double(var2));
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public double getMaximumExplodePercent() {
      double var1 = 0.0D;
      Iterator var3 = this.dataset.getKeys().iterator();

      while(var3.hasNext()) {
         Comparable var4 = (Comparable)var3.next();
         Number var5 = (Number)this.explodePercentages.get(var4);
         if(var5 != null) {
            var1 = Math.max(var1, var5.doubleValue());
         }
      }

      return var1;
   }

   public PieSectionLabelGenerator getLabelGenerator() {
      return this.labelGenerator;
   }

   public void setLabelGenerator(PieSectionLabelGenerator var1) {
      this.labelGenerator = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getLabelGap() {
      return this.labelGap;
   }

   public void setLabelGap(double var1) {
      this.labelGap = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getMaximumLabelWidth() {
      return this.maximumLabelWidth;
   }

   public void setMaximumLabelWidth(double var1) {
      this.maximumLabelWidth = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public boolean getLabelLinksVisible() {
      return this.labelLinksVisible;
   }

   public void setLabelLinksVisible(boolean var1) {
      this.labelLinksVisible = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getLabelLinkMargin() {
      return this.labelLinkMargin;
   }

   public void setLabelLinkMargin(double var1) {
      this.labelLinkMargin = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getLabelLinkPaint() {
      return this.labelLinkPaint;
   }

   public void setLabelLinkPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.labelLinkPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Stroke getLabelLinkStroke() {
      return this.labelLinkStroke;
   }

   public void setLabelLinkStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.labelLinkStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Font getLabelFont() {
      return this.labelFont;
   }

   public void setLabelFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.labelFont = var1;
         this.notifyListeners(new PlotChangeEvent(this));
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
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getLabelBackgroundPaint() {
      return this.labelBackgroundPaint;
   }

   public void setLabelBackgroundPaint(Paint var1) {
      this.labelBackgroundPaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getLabelOutlinePaint() {
      return this.labelOutlinePaint;
   }

   public void setLabelOutlinePaint(Paint var1) {
      this.labelOutlinePaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Stroke getLabelOutlineStroke() {
      return this.labelOutlineStroke;
   }

   public void setLabelOutlineStroke(Stroke var1) {
      this.labelOutlineStroke = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getLabelShadowPaint() {
      return this.labelShadowPaint;
   }

   public void setLabelShadowPaint(Paint var1) {
      this.labelShadowPaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public PieToolTipGenerator getToolTipGenerator() {
      return this.toolTipGenerator;
   }

   public void setToolTipGenerator(PieToolTipGenerator var1) {
      this.toolTipGenerator = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public PieURLGenerator getURLGenerator() {
      return this.urlGenerator;
   }

   public void setURLGenerator(PieURLGenerator var1) {
      this.urlGenerator = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getMinimumArcAngleToDraw() {
      return this.minimumArcAngleToDraw;
   }

   public void setMinimumArcAngleToDraw(double var1) {
      this.minimumArcAngleToDraw = var1;
   }

   public Shape getLegendItemShape() {
      return this.legendItemShape;
   }

   public void setLegendItemShape(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'shape\' argument.");
      } else {
         this.legendItemShape = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public PieSectionLabelGenerator getLegendLabelGenerator() {
      return this.legendLabelGenerator;
   }

   public void setLegendLabelGenerator(PieSectionLabelGenerator var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'generator\' argument.");
      } else {
         this.legendLabelGenerator = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public PieSectionLabelGenerator getLegendLabelToolTipGenerator() {
      return this.legendLabelToolTipGenerator;
   }

   public void setLegendLabelToolTipGenerator(PieSectionLabelGenerator var1) {
      this.legendLabelToolTipGenerator = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public PieURLGenerator getLegendLabelURLGenerator() {
      return this.legendLabelURLGenerator;
   }

   public void setLegendLabelURLGenerator(PieURLGenerator var1) {
      this.legendLabelURLGenerator = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public PiePlotState initialise(Graphics2D var1, Rectangle2D var2, PiePlot var3, Integer var4, PlotRenderingInfo var5) {
      PiePlotState var6 = new PiePlotState(var5);
      var6.setPassesRequired(2);
      var6.setTotal(DatasetUtilities.calculatePieDatasetTotal(var3.getDataset()));
      var6.setLatestAngle(var3.getStartAngle());
      return var6;
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      RectangleInsets var6 = this.getInsets();
      var6.trim(var2);
      if(var5 != null) {
         var5.setPlotArea(var2);
         var5.setDataArea(var2);
      }

      this.drawBackground(var1, var2);
      this.drawOutline(var1, var2);
      Shape var7 = var1.getClip();
      var1.clip(var2);
      Composite var8 = var1.getComposite();
      var1.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
      if(!DatasetUtilities.isEmptyOrNull(this.dataset)) {
         this.drawPie(var1, var2, var5);
      } else {
         this.drawNoDataMessage(var1, var2);
      }

      var1.setClip(var7);
      var1.setComposite(var8);
      this.drawOutline(var1, var2);
   }

   protected void drawPie(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3) {
      PiePlotState var4 = this.initialise(var1, var2, this, (Integer)null, var3);
      double var5 = 0.0D;
      if(this.labelGenerator != null) {
         var5 = this.labelGap + this.maximumLabelWidth + this.labelLinkMargin;
      }

      double var7 = var2.getWidth() * (this.interiorGap + var5);
      double var9 = var2.getHeight() * this.interiorGap;
      double var11 = var2.getX() + var7 / 2.0D;
      double var13 = var2.getY() + var9 / 2.0D;
      double var15 = var2.getWidth() - var7;
      double var17 = var2.getHeight() - var9;
      if(this.circular) {
         double var19 = Math.min(var15, var17) / 2.0D;
         var11 = (var11 + var11 + var15) / 2.0D - var19;
         var13 = (var13 + var13 + var17) / 2.0D - var19;
         var15 = 2.0D * var19;
         var17 = 2.0D * var19;
      }

      java.awt.geom.Rectangle2D.Double var45 = new java.awt.geom.Rectangle2D.Double(var11, var13, var15, var17);
      var4.setLinkArea(var45);
      double var20 = var45.getWidth() * this.labelLinkMargin;
      double var22 = var45.getHeight() * this.labelLinkMargin;
      java.awt.geom.Rectangle2D.Double var24 = new java.awt.geom.Rectangle2D.Double(var11 + var20 / 2.0D, var13 + var22 / 2.0D, var15 - var20, var17 - var22);
      var4.setExplodedPieArea(var24);
      double var25 = this.getMaximumExplodePercent();
      double var27 = var25 / (1.0D + var25);
      double var29 = var24.getWidth() * var27;
      double var31 = var24.getHeight() * var27;
      java.awt.geom.Rectangle2D.Double var33 = new java.awt.geom.Rectangle2D.Double(var24.getX() + var29 / 2.0D, var24.getY() + var31 / 2.0D, var24.getWidth() - var29, var24.getHeight() - var31);
      var4.setPieArea(var33);
      var4.setPieCenterX(var33.getCenterX());
      var4.setPieCenterY(var33.getCenterY());
      var4.setPieWRadius(var33.getWidth() / 2.0D);
      var4.setPieHRadius(var33.getHeight() / 2.0D);
      if(this.dataset != null && this.dataset.getKeys().size() > 0) {
         List var34 = this.dataset.getKeys();
         double var35 = DatasetUtilities.calculatePieDatasetTotal(this.dataset);
         int var37 = var4.getPassesRequired();

         for(int var38 = 0; var38 < var37; ++var38) {
            double var39 = 0.0D;

            for(int var41 = 0; var41 < var34.size(); ++var41) {
               Number var42 = this.dataset.getValue(var41);
               if(var42 != null) {
                  double var43 = var42.doubleValue();
                  if(var43 > 0.0D) {
                     var39 += var43;
                     this.drawItem(var1, var41, var24, var4, var38);
                  }
               }
            }
         }

         this.drawLabels(var1, var34, var35, var2, var45, var4);
      } else {
         this.drawNoDataMessage(var1, var2);
      }

   }

   protected void drawItem(Graphics2D var1, int var2, Rectangle2D var3, PiePlotState var4, int var5) {
      Number var6 = this.dataset.getValue(var2);
      if(var6 != null) {
         double var7 = var6.doubleValue();
         double var9 = 0.0D;
         double var11 = 0.0D;
         if(this.direction == Rotation.CLOCKWISE) {
            var9 = var4.getLatestAngle();
            var11 = var9 - var7 / var4.getTotal() * 360.0D;
         } else {
            if(this.direction != Rotation.ANTICLOCKWISE) {
               throw new IllegalStateException("Rotation type not recognised.");
            }

            var9 = var4.getLatestAngle();
            var11 = var9 + var7 / var4.getTotal() * 360.0D;
         }

         double var13 = var11 - var9;
         if(Math.abs(var13) > this.getMinimumArcAngleToDraw()) {
            double var15 = 0.0D;
            double var17 = this.getMaximumExplodePercent();
            if(var17 > 0.0D) {
               var15 = this.getExplodePercent(var2) / var17;
            }

            Rectangle2D var19 = this.getArcBounds(var4.getPieArea(), var4.getExplodedPieArea(), var9, var13, var15);
            java.awt.geom.Arc2D.Double var20 = new java.awt.geom.Arc2D.Double(var19, var9, var13, 2);
            if(var5 == 0) {
               if(this.shadowPaint != null) {
                  Shape var21 = ShapeUtilities.createTranslatedShape(var20, (double)((float)this.shadowXOffset), (double)((float)this.shadowYOffset));
                  var1.setPaint(this.shadowPaint);
                  var1.fill(var21);
               }
            } else if(var5 == 1) {
               Comparable var29 = this.getSectionKey(var2);
               Paint var22 = this.lookupSectionPaint(var29, true);
               var1.setPaint(var22);
               var1.fill(var20);
               Paint var23 = this.lookupSectionOutlinePaint(var29);
               Stroke var24 = this.lookupSectionOutlineStroke(var29);
               if(this.sectionOutlinesVisible) {
                  var1.setPaint(var23);
                  var1.setStroke(var24);
                  var1.draw(var20);
               }

               if(var4.getInfo() != null) {
                  EntityCollection var25 = var4.getEntityCollection();
                  if(var25 != null) {
                     String var26 = null;
                     if(this.toolTipGenerator != null) {
                        var26 = this.toolTipGenerator.generateToolTip(this.dataset, var29);
                     }

                     String var27 = null;
                     if(this.urlGenerator != null) {
                        var27 = this.urlGenerator.generateURL(this.dataset, var29, this.pieIndex);
                     }

                     PieSectionEntity var28 = new PieSectionEntity(var20, this.dataset, this.pieIndex, var2, var29, var26, var27);
                     var25.add(var28);
                  }
               }
            }
         }

         var4.setLatestAngle(var11);
      }
   }

   protected void drawLabels(Graphics2D var1, List var2, double var3, Rectangle2D var5, Rectangle2D var6, PiePlotState var7) {
      Composite var8 = var1.getComposite();
      var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
      DefaultKeyedValues var9 = new DefaultKeyedValues();
      DefaultKeyedValues var10 = new DefaultKeyedValues();
      double var11 = 0.0D;
      Iterator var13 = var2.iterator();

      while(var13.hasNext()) {
         Comparable var14 = (Comparable)var13.next();
         boolean var15 = true;
         double var16 = 0.0D;
         Number var18 = this.dataset.getValue(var14);
         if(var18 == null) {
            var15 = !this.ignoreNullValues;
         } else {
            var16 = var18.doubleValue();
            var15 = this.ignoreZeroValues?var16 > 0.0D:var16 >= 0.0D;
         }

         if(var15) {
            var11 += var16;
            double var19 = this.startAngle + this.direction.getFactor() * (var11 - var16 / 2.0D) * 360.0D / var3;
            if(Math.cos(Math.toRadians(var19)) < 0.0D) {
               var9.addValue(var14, new Double(var19));
            } else {
               var10.addValue(var14, new Double(var19));
            }
         }
      }

      var1.setFont(this.getLabelFont());
      float var21 = (float)(this.getMaximumLabelWidth() * var5.getWidth());
      if(this.labelGenerator != null) {
         this.drawLeftLabels(var9, var1, var5, var6, var21, var7);
         this.drawRightLabels(var10, var1, var5, var6, var21, var7);
      }

      var1.setComposite(var8);
   }

   protected void drawLeftLabels(KeyedValues var1, Graphics2D var2, Rectangle2D var3, Rectangle2D var4, float var5, PiePlotState var6) {
      PieLabelDistributor var7 = new PieLabelDistributor(var1.getItemCount());
      double var8 = var3.getWidth() * this.labelGap;
      double var10 = var6.getLinkArea().getHeight() / 2.0D;

      int var12;
      for(var12 = 0; var12 < var1.getItemCount(); ++var12) {
         String var13 = this.labelGenerator.generateSectionLabel(this.dataset, var1.getKey(var12));
         if(var13 != null) {
            TextBlock var14 = TextUtilities.createTextBlock(var13, this.labelFont, this.labelPaint, var5, new G2TextMeasurer(var2));
            TextBox var15 = new TextBox(var14);
            var15.setBackgroundPaint(this.labelBackgroundPaint);
            var15.setOutlinePaint(this.labelOutlinePaint);
            var15.setOutlineStroke(this.labelOutlineStroke);
            var15.setShadowPaint(this.labelShadowPaint);
            double var16 = Math.toRadians(var1.getValue(var12).doubleValue());
            double var18 = var6.getPieCenterY() - Math.sin(var16) * var10;
            double var20 = var15.getHeight(var2);
            var7.addPieLabelRecord(new PieLabelRecord(var1.getKey(var12), var16, var18, var15, var20, var8 / 2.0D + var8 / 2.0D * -Math.cos(var16), 0.9D + this.getExplodePercent(this.dataset.getIndex(var1.getKey(var12)))));
         }
      }

      var7.distributeLabels(var3.getMinY(), var3.getHeight());

      for(var12 = 0; var12 < var7.getItemCount(); ++var12) {
         this.drawLeftLabel(var2, var6, var7.getPieLabelRecord(var12));
      }

   }

   protected void drawRightLabels(KeyedValues var1, Graphics2D var2, Rectangle2D var3, Rectangle2D var4, float var5, PiePlotState var6) {
      PieLabelDistributor var7 = new PieLabelDistributor(var1.getItemCount());
      double var8 = var3.getWidth() * this.labelGap;
      double var10 = var6.getLinkArea().getHeight() / 2.0D;

      int var12;
      for(var12 = 0; var12 < var1.getItemCount(); ++var12) {
         String var13 = this.labelGenerator.generateSectionLabel(this.dataset, var1.getKey(var12));
         if(var13 != null) {
            TextBlock var14 = TextUtilities.createTextBlock(var13, this.labelFont, this.labelPaint, var5, new G2TextMeasurer(var2));
            TextBox var15 = new TextBox(var14);
            var15.setBackgroundPaint(this.labelBackgroundPaint);
            var15.setOutlinePaint(this.labelOutlinePaint);
            var15.setOutlineStroke(this.labelOutlineStroke);
            var15.setShadowPaint(this.labelShadowPaint);
            double var16 = Math.toRadians(var1.getValue(var12).doubleValue());
            double var18 = var6.getPieCenterY() - Math.sin(var16) * var10;
            double var20 = var15.getHeight(var2);
            var7.addPieLabelRecord(new PieLabelRecord(var1.getKey(var12), var16, var18, var15, var20, var8 / 2.0D + var8 / 2.0D * Math.cos(var16), 0.9D + this.getExplodePercent(this.dataset.getIndex(var1.getKey(var12)))));
         }
      }

      var7.distributeLabels(var3.getMinY(), var3.getHeight());

      for(var12 = 0; var12 < var7.getItemCount(); ++var12) {
         this.drawRightLabel(var2, var6, var7.getPieLabelRecord(var12));
      }

   }

   public LegendItemCollection getLegendItems() {
      LegendItemCollection var1 = new LegendItemCollection();
      if(this.dataset == null) {
         return var1;
      } else {
         List var2 = this.dataset.getKeys();
         int var3 = 0;
         Shape var4 = this.getLegendItemShape();
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            Comparable var6 = (Comparable)var5.next();
            Number var7 = this.dataset.getValue(var6);
            boolean var8 = true;
            if(var7 == null) {
               var8 = !this.ignoreNullValues;
            } else {
               double var9 = var7.doubleValue();
               if(var9 == 0.0D) {
                  var8 = !this.ignoreZeroValues;
               } else {
                  var8 = var9 > 0.0D;
               }
            }

            if(var8) {
               String var17 = this.legendLabelGenerator.generateSectionLabel(this.dataset, var6);
               String var11 = null;
               if(this.legendLabelToolTipGenerator != null) {
                  var11 = this.legendLabelToolTipGenerator.generateSectionLabel(this.dataset, var6);
               }

               String var12 = null;
               if(this.legendLabelURLGenerator != null) {
                  var12 = this.legendLabelURLGenerator.generateURL(this.dataset, var6, this.pieIndex);
               }

               Paint var13 = this.lookupSectionPaint(var6, true);
               Paint var14 = this.lookupSectionOutlinePaint(var6);
               Stroke var15 = this.lookupSectionOutlineStroke(var6);
               LegendItem var16 = new LegendItem(var17, var17, var11, var12, true, var4, true, var13, true, var14, var15, false, new Float(), new BasicStroke(), Color.black);
               var1.add(var16);
               ++var3;
            } else {
               ++var3;
            }
         }

         return var1;
      }
   }

   public String getPlotType() {
      return localizationResources.getString("Pie_Plot");
   }

   public void zoom(double var1) {
   }

   protected Rectangle2D getArcBounds(Rectangle2D var1, Rectangle2D var2, double var3, double var5, double var7) {
      if(var7 == 0.0D) {
         return var1;
      } else {
         java.awt.geom.Arc2D.Double var9 = new java.awt.geom.Arc2D.Double(var1, var3, var5 / 2.0D, 0);
         Point2D var10 = var9.getEndPoint();
         java.awt.geom.Arc2D.Double var11 = new java.awt.geom.Arc2D.Double(var2, var3, var5 / 2.0D, 0);
         Point2D var12 = var11.getEndPoint();
         double var13 = (var10.getX() - var12.getX()) * var7;
         double var15 = (var10.getY() - var12.getY()) * var7;
         return new java.awt.geom.Rectangle2D.Double(var1.getX() - var13, var1.getY() - var15, var1.getWidth(), var1.getHeight());
      }
   }

   protected void drawLeftLabel(Graphics2D var1, PiePlotState var2, PieLabelRecord var3) {
      double var4 = var2.getLinkArea().getMinX();
      double var6 = var4 - var3.getGap();
      double var8 = var3.getAllocatedY();
      if(this.labelLinksVisible) {
         double var10 = var3.getAngle();
         double var12 = var2.getPieCenterX() + Math.cos(var10) * var2.getPieWRadius() * var3.getLinkPercent();
         double var14 = var2.getPieCenterY() - Math.sin(var10) * var2.getPieHRadius() * var3.getLinkPercent();
         double var16 = var2.getPieCenterX() + Math.cos(var10) * var2.getLinkArea().getWidth() / 2.0D;
         double var18 = var2.getPieCenterY() - Math.sin(var10) * var2.getLinkArea().getHeight() / 2.0D;
         var1.setPaint(this.labelLinkPaint);
         var1.setStroke(this.labelLinkStroke);
         var1.draw(new java.awt.geom.Line2D.Double(var12, var14, var16, var18));
         var1.draw(new java.awt.geom.Line2D.Double(var4, var18, var16, var18));
         var1.draw(new java.awt.geom.Line2D.Double(var4, var18, var6, var8));
      }

      TextBox var22 = var3.getLabel();
      var22.draw(var1, (float)var6, (float)var8, RectangleAnchor.RIGHT);
   }

   protected void drawRightLabel(Graphics2D var1, PiePlotState var2, PieLabelRecord var3) {
      double var4 = var2.getLinkArea().getMaxX();
      double var6 = var4 + var3.getGap();
      double var8 = var3.getAllocatedY();
      if(this.labelLinksVisible) {
         double var10 = var3.getAngle();
         double var12 = var2.getPieCenterX() + Math.cos(var10) * var2.getPieWRadius() * var3.getLinkPercent();
         double var14 = var2.getPieCenterY() - Math.sin(var10) * var2.getPieHRadius() * var3.getLinkPercent();
         double var16 = var2.getPieCenterX() + Math.cos(var10) * var2.getLinkArea().getWidth() / 2.0D;
         double var18 = var2.getPieCenterY() - Math.sin(var10) * var2.getLinkArea().getHeight() / 2.0D;
         var1.setPaint(this.labelLinkPaint);
         var1.setStroke(this.labelLinkStroke);
         var1.draw(new java.awt.geom.Line2D.Double(var12, var14, var16, var18));
         var1.draw(new java.awt.geom.Line2D.Double(var4, var18, var16, var18));
         var1.draw(new java.awt.geom.Line2D.Double(var4, var18, var6, var8));
      }

      TextBox var22 = var3.getLabel();
      var22.draw(var1, (float)var6, (float)var8, RectangleAnchor.LEFT);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof PiePlot)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         PiePlot var2 = (PiePlot)var1;
         return this.pieIndex != var2.pieIndex?false:(this.interiorGap != var2.interiorGap?false:(this.circular != var2.circular?false:(this.startAngle != var2.startAngle?false:(this.direction != var2.direction?false:(this.ignoreZeroValues != var2.ignoreZeroValues?false:(this.ignoreNullValues != var2.ignoreNullValues?false:(!PaintUtilities.equal(this.sectionPaint, var2.sectionPaint)?false:(!ObjectUtilities.equal(this.sectionPaintMap, var2.sectionPaintMap)?false:(!PaintUtilities.equal(this.baseSectionPaint, var2.baseSectionPaint)?false:(this.sectionOutlinesVisible != var2.sectionOutlinesVisible?false:(!PaintUtilities.equal(this.sectionOutlinePaint, var2.sectionOutlinePaint)?false:(!ObjectUtilities.equal(this.sectionOutlinePaintMap, var2.sectionOutlinePaintMap)?false:(!PaintUtilities.equal(this.baseSectionOutlinePaint, var2.baseSectionOutlinePaint)?false:(!ObjectUtilities.equal(this.sectionOutlineStroke, var2.sectionOutlineStroke)?false:(!ObjectUtilities.equal(this.sectionOutlineStrokeMap, var2.sectionOutlineStrokeMap)?false:(!ObjectUtilities.equal(this.baseSectionOutlineStroke, var2.baseSectionOutlineStroke)?false:(!PaintUtilities.equal(this.shadowPaint, var2.shadowPaint)?false:(this.shadowXOffset != var2.shadowXOffset?false:(this.shadowYOffset != var2.shadowYOffset?false:(!ObjectUtilities.equal(this.explodePercentages, var2.explodePercentages)?false:(!ObjectUtilities.equal(this.labelGenerator, var2.labelGenerator)?false:(!ObjectUtilities.equal(this.labelFont, var2.labelFont)?false:(!PaintUtilities.equal(this.labelPaint, var2.labelPaint)?false:(!PaintUtilities.equal(this.labelBackgroundPaint, var2.labelBackgroundPaint)?false:(!PaintUtilities.equal(this.labelOutlinePaint, var2.labelOutlinePaint)?false:(!ObjectUtilities.equal(this.labelOutlineStroke, var2.labelOutlineStroke)?false:(!PaintUtilities.equal(this.labelShadowPaint, var2.labelShadowPaint)?false:(this.maximumLabelWidth != var2.maximumLabelWidth?false:(this.labelGap != var2.labelGap?false:(this.labelLinkMargin != var2.labelLinkMargin?false:(this.labelLinksVisible != var2.labelLinksVisible?false:(!PaintUtilities.equal(this.labelLinkPaint, var2.labelLinkPaint)?false:(!ObjectUtilities.equal(this.labelLinkStroke, var2.labelLinkStroke)?false:(!ObjectUtilities.equal(this.toolTipGenerator, var2.toolTipGenerator)?false:(!ObjectUtilities.equal(this.urlGenerator, var2.urlGenerator)?false:(this.minimumArcAngleToDraw != var2.minimumArcAngleToDraw?false:(!ShapeUtilities.equal(this.legendItemShape, var2.legendItemShape)?false:(!ObjectUtilities.equal(this.legendLabelGenerator, var2.legendLabelGenerator)?false:(!ObjectUtilities.equal(this.legendLabelToolTipGenerator, var2.legendLabelToolTipGenerator)?false:ObjectUtilities.equal(this.legendLabelURLGenerator, var2.legendLabelURLGenerator))))))))))))))))))))))))))))))))))))))));
      }
   }

   public Object clone() {
      PiePlot var1 = (PiePlot)super.clone();
      if(var1.dataset != null) {
         var1.dataset.addChangeListener(var1);
      }

      if(this.urlGenerator instanceof PublicCloneable) {
         var1.urlGenerator = (PieURLGenerator)ObjectUtilities.clone(this.urlGenerator);
      }

      var1.legendItemShape = ShapeUtilities.clone(this.legendItemShape);
      if(this.legendLabelGenerator != null) {
         var1.legendLabelGenerator = (PieSectionLabelGenerator)ObjectUtilities.clone(this.legendLabelGenerator);
      }

      if(this.legendLabelToolTipGenerator != null) {
         var1.legendLabelToolTipGenerator = (PieSectionLabelGenerator)ObjectUtilities.clone(this.legendLabelToolTipGenerator);
      }

      if(this.legendLabelURLGenerator instanceof PublicCloneable) {
         var1.legendLabelURLGenerator = (PieURLGenerator)ObjectUtilities.clone(this.legendLabelURLGenerator);
      }

      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.sectionPaint, var1);
      SerialUtilities.writePaint(this.baseSectionPaint, var1);
      SerialUtilities.writePaint(this.sectionOutlinePaint, var1);
      SerialUtilities.writePaint(this.baseSectionOutlinePaint, var1);
      SerialUtilities.writeStroke(this.sectionOutlineStroke, var1);
      SerialUtilities.writeStroke(this.baseSectionOutlineStroke, var1);
      SerialUtilities.writePaint(this.shadowPaint, var1);
      SerialUtilities.writePaint(this.labelPaint, var1);
      SerialUtilities.writePaint(this.labelBackgroundPaint, var1);
      SerialUtilities.writePaint(this.labelOutlinePaint, var1);
      SerialUtilities.writeStroke(this.labelOutlineStroke, var1);
      SerialUtilities.writePaint(this.labelShadowPaint, var1);
      SerialUtilities.writePaint(this.labelLinkPaint, var1);
      SerialUtilities.writeStroke(this.labelLinkStroke, var1);
      SerialUtilities.writeShape(this.legendItemShape, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.sectionPaint = SerialUtilities.readPaint(var1);
      this.baseSectionPaint = SerialUtilities.readPaint(var1);
      this.sectionOutlinePaint = SerialUtilities.readPaint(var1);
      this.baseSectionOutlinePaint = SerialUtilities.readPaint(var1);
      this.sectionOutlineStroke = SerialUtilities.readStroke(var1);
      this.baseSectionOutlineStroke = SerialUtilities.readStroke(var1);
      this.shadowPaint = SerialUtilities.readPaint(var1);
      this.labelPaint = SerialUtilities.readPaint(var1);
      this.labelBackgroundPaint = SerialUtilities.readPaint(var1);
      this.labelOutlinePaint = SerialUtilities.readPaint(var1);
      this.labelOutlineStroke = SerialUtilities.readStroke(var1);
      this.labelShadowPaint = SerialUtilities.readPaint(var1);
      this.labelLinkPaint = SerialUtilities.readPaint(var1);
      this.labelLinkStroke = SerialUtilities.readStroke(var1);
      this.legendItemShape = SerialUtilities.readShape(var1);
   }

   public Paint getSectionPaint(int var1) {
      Comparable var2 = this.getSectionKey(var1);
      return this.getSectionPaint(var2);
   }

   public void setSectionPaint(int var1, Paint var2) {
      Comparable var3 = this.getSectionKey(var1);
      this.setSectionPaint(var3, var2);
   }

   public Paint getSectionOutlinePaint(int var1) {
      Comparable var2 = this.getSectionKey(var1);
      return this.getSectionOutlinePaint(var2);
   }

   public void setSectionOutlinePaint(int var1, Paint var2) {
      Comparable var3 = this.getSectionKey(var1);
      this.setSectionOutlinePaint(var3, var2);
   }

   public Stroke getSectionOutlineStroke(int var1) {
      Comparable var2 = this.getSectionKey(var1);
      return this.getSectionOutlineStroke(var2);
   }

   public void setSectionOutlineStroke(int var1, Stroke var2) {
      Comparable var3 = this.getSectionKey(var1);
      this.setSectionOutlineStroke(var3, var2);
   }

   public double getExplodePercent(int var1) {
      Comparable var2 = this.getSectionKey(var1);
      return this.getExplodePercent(var2);
   }

   public void setExplodePercent(int var1, double var2) {
      Comparable var4 = this.getSectionKey(var1);
      this.setExplodePercent(var4, var2);
   }

   static {
      DEFAULT_LABEL_PAINT = Color.black;
      DEFAULT_LABEL_BACKGROUND_PAINT = new Color(255, 255, 192);
      DEFAULT_LABEL_OUTLINE_PAINT = Color.black;
      DEFAULT_LABEL_OUTLINE_STROKE = new BasicStroke(0.5F);
      DEFAULT_LABEL_SHADOW_PAINT = Color.lightGray;
      localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
   }
}
