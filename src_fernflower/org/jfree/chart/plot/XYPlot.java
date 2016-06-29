package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.AxisCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.axis.ValueTick;
import org.jfree.chart.event.ChartChangeEventType;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.SeriesRenderingOrder;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.chart.plot.Zoomable;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectList;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class XYPlot extends Plot implements Serializable, Cloneable, RendererChangeListener, ValueAxisPlot, Zoomable, PublicCloneable {
   private static final long serialVersionUID = 7044148245716569264L;
   public static final Stroke DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5F, 0, 2, 0.0F, new float[]{2.0F, 2.0F}, 0.0F);
   public static final Paint DEFAULT_GRIDLINE_PAINT;
   public static final boolean DEFAULT_CROSSHAIR_VISIBLE = false;
   public static final Stroke DEFAULT_CROSSHAIR_STROKE;
   public static final Paint DEFAULT_CROSSHAIR_PAINT;
   protected static ResourceBundle localizationResources;
   private PlotOrientation orientation;
   private RectangleInsets axisOffset;
   private ObjectList domainAxes;
   private ObjectList domainAxisLocations;
   private ObjectList rangeAxes;
   private ObjectList rangeAxisLocations;
   private ObjectList datasets;
   private ObjectList renderers;
   private Map datasetToDomainAxisMap;
   private Map datasetToRangeAxisMap;
   private transient Point2D quadrantOrigin;
   private transient Paint[] quadrantPaint;
   private boolean domainGridlinesVisible;
   private transient Stroke domainGridlineStroke;
   private transient Paint domainGridlinePaint;
   private boolean rangeGridlinesVisible;
   private transient Stroke rangeGridlineStroke;
   private transient Paint rangeGridlinePaint;
   private boolean domainZeroBaselineVisible;
   private transient Stroke domainZeroBaselineStroke;
   private transient Paint domainZeroBaselinePaint;
   private boolean rangeZeroBaselineVisible;
   private transient Stroke rangeZeroBaselineStroke;
   private transient Paint rangeZeroBaselinePaint;
   private boolean domainCrosshairVisible;
   private double domainCrosshairValue;
   private transient Stroke domainCrosshairStroke;
   private transient Paint domainCrosshairPaint;
   private boolean domainCrosshairLockedOnData;
   private boolean rangeCrosshairVisible;
   private double rangeCrosshairValue;
   private transient Stroke rangeCrosshairStroke;
   private transient Paint rangeCrosshairPaint;
   private boolean rangeCrosshairLockedOnData;
   private Map foregroundDomainMarkers;
   private Map backgroundDomainMarkers;
   private Map foregroundRangeMarkers;
   private Map backgroundRangeMarkers;
   private List annotations;
   private transient Paint domainTickBandPaint;
   private transient Paint rangeTickBandPaint;
   private AxisSpace fixedDomainAxisSpace;
   private AxisSpace fixedRangeAxisSpace;
   private DatasetRenderingOrder datasetRenderingOrder;
   private SeriesRenderingOrder seriesRenderingOrder;
   private int weight;
   private LegendItemCollection fixedLegendItems;

   public XYPlot() {
      this((XYDataset)null, (ValueAxis)null, (ValueAxis)null, (XYItemRenderer)null);
   }

   public XYPlot(XYDataset var1, ValueAxis var2, ValueAxis var3, XYItemRenderer var4) {
      this.quadrantOrigin = new Double(0.0D, 0.0D);
      this.quadrantPaint = new Paint[]{null, null, null, null};
      this.domainCrosshairLockedOnData = true;
      this.rangeCrosshairLockedOnData = true;
      this.datasetRenderingOrder = DatasetRenderingOrder.REVERSE;
      this.seriesRenderingOrder = SeriesRenderingOrder.REVERSE;
      this.orientation = PlotOrientation.VERTICAL;
      this.weight = 1;
      this.axisOffset = RectangleInsets.ZERO_INSETS;
      this.domainAxes = new ObjectList();
      this.domainAxisLocations = new ObjectList();
      this.foregroundDomainMarkers = new HashMap();
      this.backgroundDomainMarkers = new HashMap();
      this.rangeAxes = new ObjectList();
      this.rangeAxisLocations = new ObjectList();
      this.foregroundRangeMarkers = new HashMap();
      this.backgroundRangeMarkers = new HashMap();
      this.datasets = new ObjectList();
      this.renderers = new ObjectList();
      this.datasetToDomainAxisMap = new TreeMap();
      this.datasetToRangeAxisMap = new TreeMap();
      this.datasets.set(0, var1);
      if(var1 != null) {
         var1.addChangeListener(this);
      }

      this.renderers.set(0, var4);
      if(var4 != null) {
         var4.setPlot(this);
         var4.addChangeListener(this);
      }

      this.domainAxes.set(0, var2);
      this.mapDatasetToDomainAxis(0, 0);
      if(var2 != null) {
         var2.setPlot(this);
         var2.addChangeListener(this);
      }

      this.domainAxisLocations.set(0, AxisLocation.BOTTOM_OR_LEFT);
      this.rangeAxes.set(0, var3);
      this.mapDatasetToRangeAxis(0, 0);
      if(var3 != null) {
         var3.setPlot(this);
         var3.addChangeListener(this);
      }

      this.rangeAxisLocations.set(0, AxisLocation.BOTTOM_OR_LEFT);
      this.configureDomainAxes();
      this.configureRangeAxes();
      this.domainGridlinesVisible = true;
      this.domainGridlineStroke = DEFAULT_GRIDLINE_STROKE;
      this.domainGridlinePaint = DEFAULT_GRIDLINE_PAINT;
      this.domainZeroBaselineVisible = false;
      this.domainZeroBaselinePaint = Color.black;
      this.domainZeroBaselineStroke = new BasicStroke(0.5F);
      this.rangeGridlinesVisible = true;
      this.rangeGridlineStroke = DEFAULT_GRIDLINE_STROKE;
      this.rangeGridlinePaint = DEFAULT_GRIDLINE_PAINT;
      this.rangeZeroBaselineVisible = false;
      this.rangeZeroBaselinePaint = Color.black;
      this.rangeZeroBaselineStroke = new BasicStroke(0.5F);
      this.domainCrosshairVisible = false;
      this.domainCrosshairValue = 0.0D;
      this.domainCrosshairStroke = DEFAULT_CROSSHAIR_STROKE;
      this.domainCrosshairPaint = DEFAULT_CROSSHAIR_PAINT;
      this.rangeCrosshairVisible = false;
      this.rangeCrosshairValue = 0.0D;
      this.rangeCrosshairStroke = DEFAULT_CROSSHAIR_STROKE;
      this.rangeCrosshairPaint = DEFAULT_CROSSHAIR_PAINT;
      this.annotations = new ArrayList();
   }

   public String getPlotType() {
      return localizationResources.getString("XY_Plot");
   }

   public PlotOrientation getOrientation() {
      return this.orientation;
   }

   public void setOrientation(PlotOrientation var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         if(var1 != this.orientation) {
            this.orientation = var1;
            this.notifyListeners(new PlotChangeEvent(this));
         }

      }
   }

   public RectangleInsets getAxisOffset() {
      return this.axisOffset;
   }

   public void setAxisOffset(RectangleInsets var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'offset\' argument.");
      } else {
         this.axisOffset = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public ValueAxis getDomainAxis() {
      return this.getDomainAxis(0);
   }

   public ValueAxis getDomainAxis(int var1) {
      ValueAxis var2 = null;
      if(var1 < this.domainAxes.size()) {
         var2 = (ValueAxis)this.domainAxes.get(var1);
      }

      if(var2 == null) {
         Plot var3 = this.getParent();
         if(var3 instanceof XYPlot) {
            XYPlot var4 = (XYPlot)var3;
            var2 = var4.getDomainAxis(var1);
         }
      }

      return var2;
   }

   public void setDomainAxis(ValueAxis var1) {
      this.setDomainAxis(0, var1);
   }

   public void setDomainAxis(int var1, ValueAxis var2) {
      this.setDomainAxis(var1, var2, true);
   }

   public void setDomainAxis(int var1, ValueAxis var2, boolean var3) {
      ValueAxis var4 = this.getDomainAxis(var1);
      if(var4 != null) {
         var4.removeChangeListener(this);
      }

      if(var2 != null) {
         var2.setPlot(this);
      }

      this.domainAxes.set(var1, var2);
      if(var2 != null) {
         var2.configure();
         var2.addChangeListener(this);
      }

      if(var3) {
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public void setDomainAxes(ValueAxis[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.setDomainAxis(var2, var1[var2], false);
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public AxisLocation getDomainAxisLocation() {
      return (AxisLocation)this.domainAxisLocations.get(0);
   }

   public void setDomainAxisLocation(AxisLocation var1) {
      this.setDomainAxisLocation(0, var1, true);
   }

   public void setDomainAxisLocation(AxisLocation var1, boolean var2) {
      this.setDomainAxisLocation(0, var1, var2);
   }

   public RectangleEdge getDomainAxisEdge() {
      return Plot.resolveDomainAxisLocation(this.getDomainAxisLocation(), this.orientation);
   }

   public int getDomainAxisCount() {
      return this.domainAxes.size();
   }

   public void clearDomainAxes() {
      for(int var1 = 0; var1 < this.domainAxes.size(); ++var1) {
         ValueAxis var2 = (ValueAxis)this.domainAxes.get(var1);
         if(var2 != null) {
            var2.removeChangeListener(this);
         }
      }

      this.domainAxes.clear();
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void configureDomainAxes() {
      for(int var1 = 0; var1 < this.domainAxes.size(); ++var1) {
         ValueAxis var2 = (ValueAxis)this.domainAxes.get(var1);
         if(var2 != null) {
            var2.configure();
         }
      }

   }

   public AxisLocation getDomainAxisLocation(int var1) {
      AxisLocation var2 = null;
      if(var1 < this.domainAxisLocations.size()) {
         var2 = (AxisLocation)this.domainAxisLocations.get(var1);
      }

      if(var2 == null) {
         var2 = AxisLocation.getOpposite(this.getDomainAxisLocation());
      }

      return var2;
   }

   public void setDomainAxisLocation(int var1, AxisLocation var2) {
      this.setDomainAxisLocation(var1, var2, true);
   }

   public void setDomainAxisLocation(int var1, AxisLocation var2, boolean var3) {
      if(var1 == 0 && var2 == null) {
         throw new IllegalArgumentException("Null \'location\' for index 0 not permitted.");
      } else {
         this.domainAxisLocations.set(var1, var2);
         if(var3) {
            this.notifyListeners(new PlotChangeEvent(this));
         }

      }
   }

   public RectangleEdge getDomainAxisEdge(int var1) {
      AxisLocation var2 = this.getDomainAxisLocation(var1);
      RectangleEdge var3 = Plot.resolveDomainAxisLocation(var2, this.orientation);
      if(var3 == null) {
         var3 = RectangleEdge.opposite(this.getDomainAxisEdge());
      }

      return var3;
   }

   public ValueAxis getRangeAxis() {
      return this.getRangeAxis(0);
   }

   public void setRangeAxis(ValueAxis var1) {
      if(var1 != null) {
         var1.setPlot(this);
      }

      ValueAxis var2 = this.getRangeAxis();
      if(var2 != null) {
         var2.removeChangeListener(this);
      }

      this.rangeAxes.set(0, var1);
      if(var1 != null) {
         var1.configure();
         var1.addChangeListener(this);
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public AxisLocation getRangeAxisLocation() {
      return (AxisLocation)this.rangeAxisLocations.get(0);
   }

   public void setRangeAxisLocation(AxisLocation var1) {
      this.setRangeAxisLocation(0, var1, true);
   }

   public void setRangeAxisLocation(AxisLocation var1, boolean var2) {
      this.setRangeAxisLocation(0, var1, var2);
   }

   public RectangleEdge getRangeAxisEdge() {
      return Plot.resolveRangeAxisLocation(this.getRangeAxisLocation(), this.orientation);
   }

   public ValueAxis getRangeAxis(int var1) {
      ValueAxis var2 = null;
      if(var1 < this.rangeAxes.size()) {
         var2 = (ValueAxis)this.rangeAxes.get(var1);
      }

      if(var2 == null) {
         Plot var3 = this.getParent();
         if(var3 instanceof XYPlot) {
            XYPlot var4 = (XYPlot)var3;
            var2 = var4.getRangeAxis(var1);
         }
      }

      return var2;
   }

   public void setRangeAxis(int var1, ValueAxis var2) {
      this.setRangeAxis(var1, var2, true);
   }

   public void setRangeAxis(int var1, ValueAxis var2, boolean var3) {
      ValueAxis var4 = this.getRangeAxis(var1);
      if(var4 != null) {
         var4.removeChangeListener(this);
      }

      if(var2 != null) {
         var2.setPlot(this);
      }

      this.rangeAxes.set(var1, var2);
      if(var2 != null) {
         var2.configure();
         var2.addChangeListener(this);
      }

      if(var3) {
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public void setRangeAxes(ValueAxis[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.setRangeAxis(var2, var1[var2], false);
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public int getRangeAxisCount() {
      return this.rangeAxes.size();
   }

   public void clearRangeAxes() {
      for(int var1 = 0; var1 < this.rangeAxes.size(); ++var1) {
         ValueAxis var2 = (ValueAxis)this.rangeAxes.get(var1);
         if(var2 != null) {
            var2.removeChangeListener(this);
         }
      }

      this.rangeAxes.clear();
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void configureRangeAxes() {
      for(int var1 = 0; var1 < this.rangeAxes.size(); ++var1) {
         ValueAxis var2 = (ValueAxis)this.rangeAxes.get(var1);
         if(var2 != null) {
            var2.configure();
         }
      }

   }

   public AxisLocation getRangeAxisLocation(int var1) {
      AxisLocation var2 = null;
      if(var1 < this.rangeAxisLocations.size()) {
         var2 = (AxisLocation)this.rangeAxisLocations.get(var1);
      }

      if(var2 == null) {
         var2 = AxisLocation.getOpposite(this.getRangeAxisLocation());
      }

      return var2;
   }

   public void setRangeAxisLocation(int var1, AxisLocation var2) {
      this.setRangeAxisLocation(var1, var2, true);
   }

   public void setRangeAxisLocation(int var1, AxisLocation var2, boolean var3) {
      if(var1 == 0 && var2 == null) {
         throw new IllegalArgumentException("Null \'location\' for index 0 not permitted.");
      } else {
         this.rangeAxisLocations.set(var1, var2);
         if(var3) {
            this.notifyListeners(new PlotChangeEvent(this));
         }

      }
   }

   public RectangleEdge getRangeAxisEdge(int var1) {
      AxisLocation var2 = this.getRangeAxisLocation(var1);
      RectangleEdge var3 = Plot.resolveRangeAxisLocation(var2, this.orientation);
      if(var3 == null) {
         var3 = RectangleEdge.opposite(this.getRangeAxisEdge());
      }

      return var3;
   }

   public XYDataset getDataset() {
      return this.getDataset(0);
   }

   public XYDataset getDataset(int var1) {
      XYDataset var2 = null;
      if(this.datasets.size() > var1) {
         var2 = (XYDataset)this.datasets.get(var1);
      }

      return var2;
   }

   public void setDataset(XYDataset var1) {
      this.setDataset(0, var1);
   }

   public void setDataset(int var1, XYDataset var2) {
      XYDataset var3 = this.getDataset(var1);
      if(var3 != null) {
         var3.removeChangeListener(this);
      }

      this.datasets.set(var1, var2);
      if(var2 != null) {
         var2.addChangeListener(this);
      }

      DatasetChangeEvent var4 = new DatasetChangeEvent(this, var2);
      this.datasetChanged(var4);
   }

   public int getDatasetCount() {
      return this.datasets.size();
   }

   public int indexOf(XYDataset var1) {
      int var2 = -1;

      for(int var3 = 0; var3 < this.datasets.size(); ++var3) {
         if(var1 == this.datasets.get(var3)) {
            var2 = var3;
            break;
         }
      }

      return var2;
   }

   public void mapDatasetToDomainAxis(int var1, int var2) {
      this.datasetToDomainAxisMap.put(new Integer(var1), new Integer(var2));
      this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(var1)));
   }

   public void mapDatasetToRangeAxis(int var1, int var2) {
      this.datasetToRangeAxisMap.put(new Integer(var1), new Integer(var2));
      this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(var1)));
   }

   public XYItemRenderer getRenderer() {
      return this.getRenderer(0);
   }

   public XYItemRenderer getRenderer(int var1) {
      XYItemRenderer var2 = null;
      if(this.renderers.size() > var1) {
         var2 = (XYItemRenderer)this.renderers.get(var1);
      }

      return var2;
   }

   public void setRenderer(XYItemRenderer var1) {
      this.setRenderer(0, var1);
   }

   public void setRenderer(int var1, XYItemRenderer var2) {
      this.setRenderer(var1, var2, true);
   }

   public void setRenderer(int var1, XYItemRenderer var2, boolean var3) {
      XYItemRenderer var4 = this.getRenderer(var1);
      if(var4 != null) {
         var4.removeChangeListener(this);
      }

      this.renderers.set(var1, var2);
      if(var2 != null) {
         var2.setPlot(this);
         var2.addChangeListener(this);
      }

      this.configureDomainAxes();
      this.configureRangeAxes();
      if(var3) {
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public void setRenderers(XYItemRenderer[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.setRenderer(var2, var1[var2], false);
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public DatasetRenderingOrder getDatasetRenderingOrder() {
      return this.datasetRenderingOrder;
   }

   public void setDatasetRenderingOrder(DatasetRenderingOrder var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'order\' argument.");
      } else {
         this.datasetRenderingOrder = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public SeriesRenderingOrder getSeriesRenderingOrder() {
      return this.seriesRenderingOrder;
   }

   public void setSeriesRenderingOrder(SeriesRenderingOrder var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'order\' argument.");
      } else {
         this.seriesRenderingOrder = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public int getIndexOf(XYItemRenderer var1) {
      return this.renderers.indexOf(var1);
   }

   public XYItemRenderer getRendererForDataset(XYDataset var1) {
      XYItemRenderer var2 = null;

      for(int var3 = 0; var3 < this.datasets.size(); ++var3) {
         if(this.datasets.get(var3) == var1) {
            var2 = (XYItemRenderer)this.renderers.get(var3);
            if(var2 == null) {
               var2 = this.getRenderer();
            }
            break;
         }
      }

      return var2;
   }

   public int getWeight() {
      return this.weight;
   }

   public void setWeight(int var1) {
      this.weight = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public boolean isDomainGridlinesVisible() {
      return this.domainGridlinesVisible;
   }

   public void setDomainGridlinesVisible(boolean var1) {
      if(this.domainGridlinesVisible != var1) {
         this.domainGridlinesVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Stroke getDomainGridlineStroke() {
      return this.domainGridlineStroke;
   }

   public void setDomainGridlineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.domainGridlineStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getDomainGridlinePaint() {
      return this.domainGridlinePaint;
   }

   public void setDomainGridlinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.domainGridlinePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean isRangeGridlinesVisible() {
      return this.rangeGridlinesVisible;
   }

   public void setRangeGridlinesVisible(boolean var1) {
      if(this.rangeGridlinesVisible != var1) {
         this.rangeGridlinesVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Stroke getRangeGridlineStroke() {
      return this.rangeGridlineStroke;
   }

   public void setRangeGridlineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.rangeGridlineStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getRangeGridlinePaint() {
      return this.rangeGridlinePaint;
   }

   public void setRangeGridlinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.rangeGridlinePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean isDomainZeroBaselineVisible() {
      return this.domainZeroBaselineVisible;
   }

   public void setDomainZeroBaselineVisible(boolean var1) {
      this.domainZeroBaselineVisible = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Stroke getDomainZeroBaselineStroke() {
      return this.domainZeroBaselineStroke;
   }

   public void setDomainZeroBaselineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.domainZeroBaselineStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getDomainZeroBaselinePaint() {
      return this.domainZeroBaselinePaint;
   }

   public void setDomainZeroBaselinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.domainZeroBaselinePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean isRangeZeroBaselineVisible() {
      return this.rangeZeroBaselineVisible;
   }

   public void setRangeZeroBaselineVisible(boolean var1) {
      this.rangeZeroBaselineVisible = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Stroke getRangeZeroBaselineStroke() {
      return this.rangeZeroBaselineStroke;
   }

   public void setRangeZeroBaselineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.rangeZeroBaselineStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getRangeZeroBaselinePaint() {
      return this.rangeZeroBaselinePaint;
   }

   public void setRangeZeroBaselinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.rangeZeroBaselinePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getDomainTickBandPaint() {
      return this.domainTickBandPaint;
   }

   public void setDomainTickBandPaint(Paint var1) {
      this.domainTickBandPaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getRangeTickBandPaint() {
      return this.rangeTickBandPaint;
   }

   public void setRangeTickBandPaint(Paint var1) {
      this.rangeTickBandPaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Point2D getQuadrantOrigin() {
      return this.quadrantOrigin;
   }

   public void setQuadrantOrigin(Point2D var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'origin\' argument.");
      } else {
         this.quadrantOrigin = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getQuadrantPaint(int var1) {
      if(var1 >= 0 && var1 <= 3) {
         return this.quadrantPaint[var1];
      } else {
         throw new IllegalArgumentException("The index should be in the range 0 to 3.");
      }
   }

   public void setQuadrantPaint(int var1, Paint var2) {
      if(var1 >= 0 && var1 <= 3) {
         this.quadrantPaint[var1] = var2;
         this.notifyListeners(new PlotChangeEvent(this));
      } else {
         throw new IllegalArgumentException("The index should be in the range 0 to 3.");
      }
   }

   public void addDomainMarker(Marker var1) {
      this.addDomainMarker(var1, Layer.FOREGROUND);
   }

   public void addDomainMarker(Marker var1, Layer var2) {
      this.addDomainMarker(0, var1, var2);
   }

   public void clearDomainMarkers() {
      Set var1;
      Iterator var2;
      Integer var3;
      if(this.backgroundDomainMarkers != null) {
         var1 = this.backgroundDomainMarkers.keySet();
         var2 = var1.iterator();

         while(var2.hasNext()) {
            var3 = (Integer)var2.next();
            this.clearDomainMarkers(var3.intValue());
         }

         this.backgroundDomainMarkers.clear();
      }

      if(this.foregroundDomainMarkers != null) {
         var1 = this.foregroundDomainMarkers.keySet();
         var2 = var1.iterator();

         while(var2.hasNext()) {
            var3 = (Integer)var2.next();
            this.clearDomainMarkers(var3.intValue());
         }

         this.foregroundDomainMarkers.clear();
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void clearDomainMarkers(int var1) {
      Integer var2 = new Integer(var1);
      Collection var3;
      Iterator var4;
      Marker var5;
      if(this.backgroundDomainMarkers != null) {
         var3 = (Collection)this.backgroundDomainMarkers.get(var2);
         if(var3 != null) {
            var4 = var3.iterator();

            while(var4.hasNext()) {
               var5 = (Marker)var4.next();
               var5.removeChangeListener(this);
            }

            var3.clear();
         }
      }

      if(this.foregroundRangeMarkers != null) {
         var3 = (Collection)this.foregroundDomainMarkers.get(var2);
         if(var3 != null) {
            var4 = var3.iterator();

            while(var4.hasNext()) {
               var5 = (Marker)var4.next();
               var5.removeChangeListener(this);
            }

            var3.clear();
         }
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void addDomainMarker(int var1, Marker var2, Layer var3) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'marker\' not permitted.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'layer\' not permitted.");
      } else {
         Object var4;
         if(var3 == Layer.FOREGROUND) {
            var4 = (Collection)this.foregroundDomainMarkers.get(new Integer(var1));
            if(var4 == null) {
               var4 = new ArrayList();
               this.foregroundDomainMarkers.put(new Integer(var1), var4);
            }

            ((Collection)var4).add(var2);
         } else if(var3 == Layer.BACKGROUND) {
            var4 = (Collection)this.backgroundDomainMarkers.get(new Integer(var1));
            if(var4 == null) {
               var4 = new ArrayList();
               this.backgroundDomainMarkers.put(new Integer(var1), var4);
            }

            ((Collection)var4).add(var2);
         }

         var2.addChangeListener(this);
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public void addRangeMarker(Marker var1) {
      this.addRangeMarker(var1, Layer.FOREGROUND);
   }

   public void addRangeMarker(Marker var1, Layer var2) {
      this.addRangeMarker(0, var1, var2);
   }

   public void clearRangeMarkers() {
      Set var1;
      Iterator var2;
      Integer var3;
      if(this.backgroundRangeMarkers != null) {
         var1 = this.backgroundRangeMarkers.keySet();
         var2 = var1.iterator();

         while(var2.hasNext()) {
            var3 = (Integer)var2.next();
            this.clearRangeMarkers(var3.intValue());
         }

         this.backgroundRangeMarkers.clear();
      }

      if(this.foregroundRangeMarkers != null) {
         var1 = this.foregroundRangeMarkers.keySet();
         var2 = var1.iterator();

         while(var2.hasNext()) {
            var3 = (Integer)var2.next();
            this.clearRangeMarkers(var3.intValue());
         }

         this.foregroundRangeMarkers.clear();
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void addRangeMarker(int var1, Marker var2, Layer var3) {
      Object var4;
      if(var3 == Layer.FOREGROUND) {
         var4 = (Collection)this.foregroundRangeMarkers.get(new Integer(var1));
         if(var4 == null) {
            var4 = new ArrayList();
            this.foregroundRangeMarkers.put(new Integer(var1), var4);
         }

         ((Collection)var4).add(var2);
      } else if(var3 == Layer.BACKGROUND) {
         var4 = (Collection)this.backgroundRangeMarkers.get(new Integer(var1));
         if(var4 == null) {
            var4 = new ArrayList();
            this.backgroundRangeMarkers.put(new Integer(var1), var4);
         }

         ((Collection)var4).add(var2);
      }

      var2.addChangeListener(this);
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void clearRangeMarkers(int var1) {
      Integer var2 = new Integer(var1);
      Collection var3;
      Iterator var4;
      Marker var5;
      if(this.backgroundRangeMarkers != null) {
         var3 = (Collection)this.backgroundRangeMarkers.get(var2);
         if(var3 != null) {
            var4 = var3.iterator();

            while(var4.hasNext()) {
               var5 = (Marker)var4.next();
               var5.removeChangeListener(this);
            }

            var3.clear();
         }
      }

      if(this.foregroundRangeMarkers != null) {
         var3 = (Collection)this.foregroundRangeMarkers.get(var2);
         if(var3 != null) {
            var4 = var3.iterator();

            while(var4.hasNext()) {
               var5 = (Marker)var4.next();
               var5.removeChangeListener(this);
            }

            var3.clear();
         }
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void addAnnotation(XYAnnotation var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'annotation\' argument.");
      } else {
         this.annotations.add(var1);
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean removeAnnotation(XYAnnotation var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'annotation\' argument.");
      } else {
         boolean var2 = this.annotations.remove(var1);
         if(var2) {
            this.notifyListeners(new PlotChangeEvent(this));
         }

         return var2;
      }
   }

   public List getAnnotations() {
      return new ArrayList(this.annotations);
   }

   public void clearAnnotations() {
      this.annotations.clear();
      this.notifyListeners(new PlotChangeEvent(this));
   }

   protected AxisSpace calculateAxisSpace(Graphics2D var1, Rectangle2D var2) {
      AxisSpace var3 = new AxisSpace();
      var3 = this.calculateDomainAxisSpace(var1, var2, var3);
      var3 = this.calculateRangeAxisSpace(var1, var2, var3);
      return var3;
   }

   protected AxisSpace calculateDomainAxisSpace(Graphics2D var1, Rectangle2D var2, AxisSpace var3) {
      if(var3 == null) {
         var3 = new AxisSpace();
      }

      if(this.fixedDomainAxisSpace != null) {
         if(this.orientation == PlotOrientation.HORIZONTAL) {
            var3.ensureAtLeast(this.fixedDomainAxisSpace.getLeft(), RectangleEdge.LEFT);
            var3.ensureAtLeast(this.fixedDomainAxisSpace.getRight(), RectangleEdge.RIGHT);
         } else if(this.orientation == PlotOrientation.VERTICAL) {
            var3.ensureAtLeast(this.fixedDomainAxisSpace.getTop(), RectangleEdge.TOP);
            var3.ensureAtLeast(this.fixedDomainAxisSpace.getBottom(), RectangleEdge.BOTTOM);
         }
      } else {
         for(int var4 = 0; var4 < this.domainAxes.size(); ++var4) {
            Axis var5 = (Axis)this.domainAxes.get(var4);
            if(var5 != null) {
               RectangleEdge var6 = this.getDomainAxisEdge(var4);
               var3 = var5.reserveSpace(var1, this, var2, var6, var3);
            }
         }
      }

      return var3;
   }

   protected AxisSpace calculateRangeAxisSpace(Graphics2D var1, Rectangle2D var2, AxisSpace var3) {
      if(var3 == null) {
         var3 = new AxisSpace();
      }

      if(this.fixedRangeAxisSpace != null) {
         if(this.orientation == PlotOrientation.HORIZONTAL) {
            var3.ensureAtLeast(this.fixedRangeAxisSpace.getTop(), RectangleEdge.TOP);
            var3.ensureAtLeast(this.fixedRangeAxisSpace.getBottom(), RectangleEdge.BOTTOM);
         } else if(this.orientation == PlotOrientation.VERTICAL) {
            var3.ensureAtLeast(this.fixedRangeAxisSpace.getLeft(), RectangleEdge.LEFT);
            var3.ensureAtLeast(this.fixedRangeAxisSpace.getRight(), RectangleEdge.RIGHT);
         }
      } else {
         for(int var4 = 0; var4 < this.rangeAxes.size(); ++var4) {
            Axis var5 = (Axis)this.rangeAxes.get(var4);
            if(var5 != null) {
               RectangleEdge var6 = this.getRangeAxisEdge(var4);
               var3 = var5.reserveSpace(var1, this, var2, var6, var3);
            }
         }
      }

      return var3;
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
         AxisSpace var9 = this.calculateAxisSpace(var1, var2);
         Rectangle2D var10 = var9.shrink(var2, (Rectangle2D)null);
         this.axisOffset.trim(var10);
         if(var5 != null) {
            var5.setDataArea(var10);
         }

         this.drawBackground(var1, var10);
         Map var11 = this.drawAxes(var1, var2, var10, var5);
         PlotOrientation var12 = this.getOrientation();
         if(var3 != null && !var10.contains(var3)) {
            var3 = null;
         }

         CrosshairState var13 = new CrosshairState();
         var13.setCrosshairDistance(java.lang.Double.POSITIVE_INFINITY);
         var13.setAnchor(var3);
         var13.setAnchorX(java.lang.Double.NaN);
         var13.setAnchorY(java.lang.Double.NaN);
         if(var3 != null) {
            ValueAxis var14 = this.getDomainAxis();
            if(var14 != null) {
               double var15;
               if(var12 == PlotOrientation.VERTICAL) {
                  var15 = var14.java2DToValue(var3.getX(), var10, this.getDomainAxisEdge());
               } else {
                  var15 = var14.java2DToValue(var3.getY(), var10, this.getDomainAxisEdge());
               }

               var13.setAnchorX(var15);
            }

            ValueAxis var31 = this.getRangeAxis();
            if(var31 != null) {
               double var16;
               if(var12 == PlotOrientation.VERTICAL) {
                  var16 = var31.java2DToValue(var3.getY(), var10, this.getRangeAxisEdge());
               } else {
                  var16 = var31.java2DToValue(var3.getX(), var10, this.getRangeAxisEdge());
               }

               var13.setAnchorY(var16);
            }
         }

         var13.setCrosshairX(this.getDomainCrosshairValue());
         var13.setCrosshairY(this.getRangeCrosshairValue());
         Shape var30 = var1.getClip();
         Composite var32 = var1.getComposite();
         var1.clip(var10);
         var1.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
         AxisState var33 = (AxisState)var11.get(this.getDomainAxis());
         if(var33 == null && var4 != null) {
            var33 = (AxisState)var4.getSharedAxisStates().get(this.getDomainAxis());
         }

         AxisState var17 = (AxisState)var11.get(this.getRangeAxis());
         if(var17 == null && var4 != null) {
            var17 = (AxisState)var4.getSharedAxisStates().get(this.getRangeAxis());
         }

         if(var33 != null) {
            this.drawDomainTickBands(var1, var10, var33.getTicks());
         }

         if(var17 != null) {
            this.drawRangeTickBands(var1, var10, var17.getTicks());
         }

         if(var33 != null) {
            this.drawDomainGridlines(var1, var10, var33.getTicks());
            this.drawZeroDomainBaseline(var1, var10);
         }

         if(var17 != null) {
            this.drawRangeGridlines(var1, var10, var17.getTicks());
            this.drawZeroRangeBaseline(var1, var10);
         }

         int var18;
         for(var18 = 0; var18 < this.renderers.size(); ++var18) {
            this.drawDomainMarkers(var1, var10, var18, Layer.BACKGROUND);
         }

         for(var18 = 0; var18 < this.renderers.size(); ++var18) {
            this.drawRangeMarkers(var1, var10, var18, Layer.BACKGROUND);
         }

         boolean var34 = false;
         DatasetRenderingOrder var19 = this.getDatasetRenderingOrder();
         int var20;
         int var21;
         XYItemRenderer var22;
         ValueAxis var23;
         ValueAxis var24;
         if(var19 == DatasetRenderingOrder.FORWARD) {
            var20 = this.renderers.size();

            for(var21 = 0; var21 < var20; ++var21) {
               var22 = this.getRenderer(var21);
               if(var22 != null) {
                  var23 = this.getDomainAxisForDataset(var21);
                  var24 = this.getRangeAxisForDataset(var21);
                  var22.drawAnnotations(var1, var10, var23, var24, Layer.BACKGROUND, var5);
               }
            }

            for(var21 = 0; var21 < this.getDatasetCount(); ++var21) {
               var34 = this.render(var1, var10, var21, var5, var13) || var34;
            }

            for(var21 = 0; var21 < var20; ++var21) {
               var22 = this.getRenderer(var21);
               if(var22 != null) {
                  var23 = this.getDomainAxisForDataset(var21);
                  var24 = this.getRangeAxisForDataset(var21);
                  var22.drawAnnotations(var1, var10, var23, var24, Layer.FOREGROUND, var5);
               }
            }
         } else if(var19 == DatasetRenderingOrder.REVERSE) {
            var20 = this.renderers.size();

            for(var21 = var20 - 1; var21 >= 0; --var21) {
               var22 = this.getRenderer(var21);
               if(var21 < this.getDatasetCount() && var22 != null) {
                  var23 = this.getDomainAxisForDataset(var21);
                  var24 = this.getRangeAxisForDataset(var21);
                  var22.drawAnnotations(var1, var10, var23, var24, Layer.BACKGROUND, var5);
               }
            }

            for(var21 = this.getDatasetCount() - 1; var21 >= 0; --var21) {
               var34 = this.render(var1, var10, var21, var5, var13) || var34;
            }

            for(var21 = var20 - 1; var21 >= 0; --var21) {
               var22 = this.getRenderer(var21);
               if(var21 < this.getDatasetCount() && var22 != null) {
                  var23 = this.getDomainAxisForDataset(var21);
                  var24 = this.getRangeAxisForDataset(var21);
                  var22.drawAnnotations(var1, var10, var23, var24, Layer.FOREGROUND, var5);
               }
            }
         }

         var20 = var13.getDomainAxisIndex();
         ValueAxis var37 = this.getDomainAxis(var20);
         RectangleEdge var35 = this.getDomainAxisEdge(var20);
         double var36;
         if(!this.domainCrosshairLockedOnData && var3 != null) {
            if(var12 == PlotOrientation.VERTICAL) {
               var36 = var37.java2DToValue(var3.getX(), var10, var35);
            } else {
               var36 = var37.java2DToValue(var3.getY(), var10, var35);
            }

            var13.setCrosshairX(var36);
         }

         this.setDomainCrosshairValue(var13.getCrosshairX(), false);
         if(this.isDomainCrosshairVisible()) {
            var36 = this.getDomainCrosshairValue();
            Paint var25 = this.getDomainCrosshairPaint();
            Stroke var26 = this.getDomainCrosshairStroke();
            this.drawDomainCrosshair(var1, var10, var12, var36, var37, var26, var25);
         }

         int var39 = var13.getRangeAxisIndex();
         var24 = this.getRangeAxis(var39);
         RectangleEdge var38 = this.getRangeAxisEdge(var39);
         double var40;
         if(!this.rangeCrosshairLockedOnData && var3 != null) {
            if(var12 == PlotOrientation.VERTICAL) {
               var40 = var24.java2DToValue(var3.getY(), var10, var38);
            } else {
               var40 = var24.java2DToValue(var3.getX(), var10, var38);
            }

            var13.setCrosshairY(var40);
         }

         this.setRangeCrosshairValue(var13.getCrosshairY(), false);
         if(this.isRangeCrosshairVisible()) {
            var40 = this.getRangeCrosshairValue();
            Paint var28 = this.getRangeCrosshairPaint();
            Stroke var29 = this.getRangeCrosshairStroke();
            this.drawRangeCrosshair(var1, var10, var12, var40, var24, var29, var28);
         }

         if(!var34) {
            this.drawNoDataMessage(var1, var10);
         }

         int var41;
         for(var41 = 0; var41 < this.renderers.size(); ++var41) {
            this.drawDomainMarkers(var1, var10, var41, Layer.FOREGROUND);
         }

         for(var41 = 0; var41 < this.renderers.size(); ++var41) {
            this.drawRangeMarkers(var1, var10, var41, Layer.FOREGROUND);
         }

         this.drawAnnotations(var1, var10, var5);
         var1.setClip(var30);
         var1.setComposite(var32);
         this.drawOutline(var1, var10);
      }
   }

   public void drawBackground(Graphics2D var1, Rectangle2D var2) {
      this.fillBackground(var1, var2);
      this.drawQuadrants(var1, var2);
      this.drawBackgroundImage(var1, var2);
   }

   protected void drawQuadrants(Graphics2D var1, Rectangle2D var2) {
      boolean var3 = false;
      ValueAxis var4 = this.getDomainAxis();
      double var5 = this.quadrantOrigin.getX();
      double var7 = var4.valueToJava2D(var5, var2, this.getDomainAxisEdge());
      ValueAxis var9 = this.getRangeAxis();
      double var10 = this.quadrantOrigin.getY();
      double var12 = var9.valueToJava2D(var10, var2, this.getRangeAxisEdge());
      double var14 = var4.getLowerBound();
      double var16 = var4.valueToJava2D(var14, var2, this.getDomainAxisEdge());
      double var18 = var4.getUpperBound();
      double var20 = var4.valueToJava2D(var18, var2, this.getDomainAxisEdge());
      double var22 = var9.getLowerBound();
      double var24 = var9.valueToJava2D(var22, var2, this.getRangeAxisEdge());
      double var26 = var9.getUpperBound();
      double var28 = var9.valueToJava2D(var26, var2, this.getRangeAxisEdge());
      Rectangle2D[] var30 = new Rectangle2D[]{null, null, null, null};
      if(this.quadrantPaint[0] != null && var5 > var14 && var10 < var26) {
         if(this.orientation == PlotOrientation.HORIZONTAL) {
            var30[0] = new java.awt.geom.Rectangle2D.Double(Math.min(var28, var12), Math.min(var16, var7), Math.abs(var12 - var28), Math.abs(var7 - var16));
         } else {
            var30[0] = new java.awt.geom.Rectangle2D.Double(Math.min(var16, var7), Math.min(var28, var12), Math.abs(var7 - var16), Math.abs(var12 - var28));
         }

         var3 = true;
      }

      if(this.quadrantPaint[1] != null && var5 < var18 && var10 < var26) {
         if(this.orientation == PlotOrientation.HORIZONTAL) {
            var30[1] = new java.awt.geom.Rectangle2D.Double(Math.min(var28, var12), Math.min(var20, var7), Math.abs(var12 - var28), Math.abs(var7 - var20));
         } else {
            var30[1] = new java.awt.geom.Rectangle2D.Double(Math.min(var7, var20), Math.min(var28, var12), Math.abs(var7 - var20), Math.abs(var12 - var28));
         }

         var3 = true;
      }

      if(this.quadrantPaint[2] != null && var5 > var14 && var10 > var22) {
         if(this.orientation == PlotOrientation.HORIZONTAL) {
            var30[2] = new java.awt.geom.Rectangle2D.Double(Math.min(var24, var12), Math.min(var16, var7), Math.abs(var12 - var24), Math.abs(var7 - var16));
         } else {
            var30[2] = new java.awt.geom.Rectangle2D.Double(Math.min(var16, var7), Math.min(var24, var12), Math.abs(var7 - var16), Math.abs(var12 - var24));
         }

         var3 = true;
      }

      if(this.quadrantPaint[3] != null && var5 < var18 && var10 > var22) {
         if(this.orientation == PlotOrientation.HORIZONTAL) {
            var30[3] = new java.awt.geom.Rectangle2D.Double(Math.min(var24, var12), Math.min(var20, var7), Math.abs(var12 - var24), Math.abs(var7 - var20));
         } else {
            var30[3] = new java.awt.geom.Rectangle2D.Double(Math.min(var7, var20), Math.min(var24, var12), Math.abs(var7 - var20), Math.abs(var12 - var24));
         }

         var3 = true;
      }

      if(var3) {
         Composite var31 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, this.getBackgroundAlpha()));

         for(int var32 = 0; var32 < 4; ++var32) {
            if(this.quadrantPaint[var32] != null && var30[var32] != null) {
               var1.setPaint(this.quadrantPaint[var32]);
               var1.fill(var30[var32]);
            }
         }

         var1.setComposite(var31);
      }

   }

   public void drawDomainTickBands(Graphics2D var1, Rectangle2D var2, List var3) {
      Paint var4 = this.getDomainTickBandPaint();
      if(var4 != null) {
         boolean var5 = false;
         ValueAxis var6 = this.getDomainAxis();
         double var7 = var6.getLowerBound();

         for(Iterator var9 = var3.iterator(); var9.hasNext(); var5 = !var5) {
            ValueTick var10 = (ValueTick)var9.next();
            double var11 = var10.getValue();
            if(var5) {
               this.getRenderer().fillDomainGridBand(var1, this, var6, var2, var7, var11);
            }

            var7 = var11;
         }

         double var13 = var6.getUpperBound();
         if(var5) {
            this.getRenderer().fillDomainGridBand(var1, this, var6, var2, var7, var13);
         }
      }

   }

   public void drawRangeTickBands(Graphics2D var1, Rectangle2D var2, List var3) {
      Paint var4 = this.getRangeTickBandPaint();
      if(var4 != null) {
         boolean var5 = false;
         ValueAxis var6 = this.getRangeAxis();
         double var7 = var6.getLowerBound();

         for(Iterator var9 = var3.iterator(); var9.hasNext(); var5 = !var5) {
            ValueTick var10 = (ValueTick)var9.next();
            double var11 = var10.getValue();
            if(var5) {
               this.getRenderer().fillRangeGridBand(var1, this, var6, var2, var7, var11);
            }

            var7 = var11;
         }

         double var13 = var6.getUpperBound();
         if(var5) {
            this.getRenderer().fillRangeGridBand(var1, this, var6, var2, var7, var13);
         }
      }

   }

   protected Map drawAxes(Graphics2D var1, Rectangle2D var2, Rectangle2D var3, PlotRenderingInfo var4) {
      AxisCollection var5 = new AxisCollection();

      int var6;
      ValueAxis var7;
      for(var6 = 0; var6 < this.domainAxes.size(); ++var6) {
         var7 = (ValueAxis)this.domainAxes.get(var6);
         if(var7 != null) {
            var5.add(var7, this.getDomainAxisEdge(var6));
         }
      }

      for(var6 = 0; var6 < this.rangeAxes.size(); ++var6) {
         var7 = (ValueAxis)this.rangeAxes.get(var6);
         if(var7 != null) {
            var5.add(var7, this.getRangeAxisEdge(var6));
         }
      }

      HashMap var12 = new HashMap();
      double var13 = var3.getMinY() - this.axisOffset.calculateTopOutset(var3.getHeight());
      Iterator var9 = var5.getAxesAtTop().iterator();

      ValueAxis var10;
      AxisState var11;
      while(var9.hasNext()) {
         var10 = (ValueAxis)var9.next();
         var11 = var10.draw(var1, var13, var2, var3, RectangleEdge.TOP, var4);
         var13 = var11.getCursor();
         var12.put(var10, var11);
      }

      var13 = var3.getMaxY() + this.axisOffset.calculateBottomOutset(var3.getHeight());
      var9 = var5.getAxesAtBottom().iterator();

      while(var9.hasNext()) {
         var10 = (ValueAxis)var9.next();
         var11 = var10.draw(var1, var13, var2, var3, RectangleEdge.BOTTOM, var4);
         var13 = var11.getCursor();
         var12.put(var10, var11);
      }

      var13 = var3.getMinX() - this.axisOffset.calculateLeftOutset(var3.getWidth());
      var9 = var5.getAxesAtLeft().iterator();

      while(var9.hasNext()) {
         var10 = (ValueAxis)var9.next();
         var11 = var10.draw(var1, var13, var2, var3, RectangleEdge.LEFT, var4);
         var13 = var11.getCursor();
         var12.put(var10, var11);
      }

      var13 = var3.getMaxX() + this.axisOffset.calculateRightOutset(var3.getWidth());
      var9 = var5.getAxesAtRight().iterator();

      while(var9.hasNext()) {
         var10 = (ValueAxis)var9.next();
         var11 = var10.draw(var1, var13, var2, var3, RectangleEdge.RIGHT, var4);
         var13 = var11.getCursor();
         var12.put(var10, var11);
      }

      return var12;
   }

   public boolean render(Graphics2D var1, Rectangle2D var2, int var3, PlotRenderingInfo var4, CrosshairState var5) {
      boolean var6 = false;
      XYDataset var7 = this.getDataset(var3);
      if(!DatasetUtilities.isEmptyOrNull(var7)) {
         var6 = true;
         ValueAxis var8 = this.getDomainAxisForDataset(var3);
         ValueAxis var9 = this.getRangeAxisForDataset(var3);
         XYItemRenderer var10 = this.getRenderer(var3);
         if(var10 == null) {
            var10 = this.getRenderer();
            if(var10 == null) {
               return var6;
            }
         }

         XYItemRendererState var11 = var10.initialise(var1, var2, this, var7, var4);
         int var12 = var10.getPassCount();
         SeriesRenderingOrder var13 = this.getSeriesRenderingOrder();
         int var14;
         int var15;
         int var16;
         int var17;
         int var18;
         if(var13 == SeriesRenderingOrder.REVERSE) {
            for(var14 = 0; var14 < var12; ++var14) {
               var15 = var7.getSeriesCount();

               for(var16 = var15 - 1; var16 >= 0; --var16) {
                  var17 = var7.getItemCount(var16);

                  for(var18 = 0; var18 < var17; ++var18) {
                     var10.drawItem(var1, var11, var2, var4, this, var8, var9, var7, var16, var18, var5, var14);
                  }
               }
            }
         } else {
            for(var14 = 0; var14 < var12; ++var14) {
               var15 = var7.getSeriesCount();

               for(var16 = 0; var16 < var15; ++var16) {
                  var17 = var7.getItemCount(var16);

                  for(var18 = 0; var18 < var17; ++var18) {
                     var10.drawItem(var1, var11, var2, var4, this, var8, var9, var7, var16, var18, var5, var14);
                  }
               }
            }
         }
      }

      return var6;
   }

   public ValueAxis getDomainAxisForDataset(int var1) {
      if(var1 >= 0 && var1 < this.getDatasetCount()) {
         ValueAxis var2 = null;
         Integer var3 = (Integer)this.datasetToDomainAxisMap.get(new Integer(var1));
         if(var3 != null) {
            var2 = this.getDomainAxis(var3.intValue());
         } else {
            var2 = this.getDomainAxis(0);
         }

         return var2;
      } else {
         throw new IllegalArgumentException("Index \'index\' out of bounds.");
      }
   }

   public ValueAxis getRangeAxisForDataset(int var1) {
      if(var1 >= 0 && var1 < this.getDatasetCount()) {
         ValueAxis var2 = null;
         Integer var3 = (Integer)this.datasetToRangeAxisMap.get(new Integer(var1));
         if(var3 != null) {
            var2 = this.getRangeAxis(var3.intValue());
         } else {
            var2 = this.getRangeAxis(0);
         }

         return var2;
      } else {
         throw new IllegalArgumentException("Index \'index\' out of bounds.");
      }
   }

   protected void drawDomainGridlines(Graphics2D var1, Rectangle2D var2, List var3) {
      if(this.getRenderer() != null) {
         if(this.isDomainGridlinesVisible()) {
            Stroke var4 = this.getDomainGridlineStroke();
            Paint var5 = this.getDomainGridlinePaint();
            if(var4 != null && var5 != null) {
               Iterator var6 = var3.iterator();

               while(var6.hasNext()) {
                  ValueTick var7 = (ValueTick)var6.next();
                  this.getRenderer().drawDomainGridLine(var1, this, this.getDomainAxis(), var2, var7.getValue());
               }
            }
         }

      }
   }

   protected void drawRangeGridlines(Graphics2D var1, Rectangle2D var2, List var3) {
      if(this.getRenderer() != null) {
         if(this.isRangeGridlinesVisible()) {
            Stroke var4 = this.getRangeGridlineStroke();
            Paint var5 = this.getRangeGridlinePaint();
            ValueAxis var6 = this.getRangeAxis();
            if(var6 != null) {
               Iterator var7 = var3.iterator();

               while(true) {
                  ValueTick var8;
                  do {
                     if(!var7.hasNext()) {
                        return;
                     }

                     var8 = (ValueTick)var7.next();
                  } while(var8.getValue() == 0.0D && this.isRangeZeroBaselineVisible());

                  this.getRenderer().drawRangeLine(var1, this, this.getRangeAxis(), var2, var8.getValue(), var5, var4);
               }
            }
         }

      }
   }

   protected void drawZeroDomainBaseline(Graphics2D var1, Rectangle2D var2) {
      if(this.isDomainZeroBaselineVisible()) {
         XYItemRenderer var3 = this.getRenderer();
         if(var3 instanceof AbstractXYItemRenderer) {
            AbstractXYItemRenderer var4 = (AbstractXYItemRenderer)var3;
            var4.drawDomainLine(var1, this, this.getDomainAxis(), var2, 0.0D, this.domainZeroBaselinePaint, this.domainZeroBaselineStroke);
         }
      }

   }

   protected void drawZeroRangeBaseline(Graphics2D var1, Rectangle2D var2) {
      if(this.isRangeZeroBaselineVisible()) {
         this.getRenderer().drawRangeLine(var1, this, this.getRangeAxis(), var2, 0.0D, this.rangeZeroBaselinePaint, this.rangeZeroBaselineStroke);
      }

   }

   public void drawAnnotations(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3) {
      Iterator var4 = this.annotations.iterator();

      while(var4.hasNext()) {
         XYAnnotation var5 = (XYAnnotation)var4.next();
         ValueAxis var6 = this.getDomainAxis();
         ValueAxis var7 = this.getRangeAxis();
         var5.draw(var1, this, var2, var6, var7, 0, var3);
      }

   }

   protected void drawDomainMarkers(Graphics2D var1, Rectangle2D var2, int var3, Layer var4) {
      XYItemRenderer var5 = this.getRenderer(var3);
      if(var5 != null) {
         if(var3 < this.getDatasetCount()) {
            Collection var6 = this.getDomainMarkers(var3, var4);
            ValueAxis var7 = this.getDomainAxisForDataset(var3);
            if(var6 != null && var7 != null) {
               Iterator var8 = var6.iterator();

               while(var8.hasNext()) {
                  Marker var9 = (Marker)var8.next();
                  var5.drawDomainMarker(var1, this, var7, var9, var2);
               }
            }

         }
      }
   }

   protected void drawRangeMarkers(Graphics2D var1, Rectangle2D var2, int var3, Layer var4) {
      XYItemRenderer var5 = this.getRenderer(var3);
      if(var5 != null) {
         if(var3 < this.getDatasetCount()) {
            Collection var6 = this.getRangeMarkers(var3, var4);
            ValueAxis var7 = this.getRangeAxisForDataset(var3);
            if(var6 != null && var7 != null) {
               Iterator var8 = var6.iterator();

               while(var8.hasNext()) {
                  Marker var9 = (Marker)var8.next();
                  var5.drawRangeMarker(var1, this, var7, var9, var2);
               }
            }

         }
      }
   }

   public Collection getDomainMarkers(Layer var1) {
      return this.getDomainMarkers(0, var1);
   }

   public Collection getRangeMarkers(Layer var1) {
      return this.getRangeMarkers(0, var1);
   }

   public Collection getDomainMarkers(int var1, Layer var2) {
      Collection var3 = null;
      Integer var4 = new Integer(var1);
      if(var2 == Layer.FOREGROUND) {
         var3 = (Collection)this.foregroundDomainMarkers.get(var4);
      } else if(var2 == Layer.BACKGROUND) {
         var3 = (Collection)this.backgroundDomainMarkers.get(var4);
      }

      if(var3 != null) {
         var3 = Collections.unmodifiableCollection(var3);
      }

      return var3;
   }

   public Collection getRangeMarkers(int var1, Layer var2) {
      Collection var3 = null;
      Integer var4 = new Integer(var1);
      if(var2 == Layer.FOREGROUND) {
         var3 = (Collection)this.foregroundRangeMarkers.get(var4);
      } else if(var2 == Layer.BACKGROUND) {
         var3 = (Collection)this.backgroundRangeMarkers.get(var4);
      }

      if(var3 != null) {
         var3 = Collections.unmodifiableCollection(var3);
      }

      return var3;
   }

   protected void drawHorizontalLine(Graphics2D var1, Rectangle2D var2, double var3, Stroke var5, Paint var6) {
      ValueAxis var7 = this.getRangeAxis();
      if(this.getOrientation() == PlotOrientation.HORIZONTAL) {
         var7 = this.getDomainAxis();
      }

      if(var7.getRange().contains(var3)) {
         double var8 = var7.valueToJava2D(var3, var2, RectangleEdge.LEFT);
         java.awt.geom.Line2D.Double var10 = new java.awt.geom.Line2D.Double(var2.getMinX(), var8, var2.getMaxX(), var8);
         var1.setStroke(var5);
         var1.setPaint(var6);
         var1.draw(var10);
      }

   }

   protected void drawDomainCrosshair(Graphics2D var1, Rectangle2D var2, PlotOrientation var3, double var4, ValueAxis var6, Stroke var7, Paint var8) {
      if(var6.getRange().contains(var4)) {
         java.awt.geom.Line2D.Double var9 = null;
         double var10;
         if(var3 == PlotOrientation.VERTICAL) {
            var10 = var6.valueToJava2D(var4, var2, RectangleEdge.BOTTOM);
            var9 = new java.awt.geom.Line2D.Double(var10, var2.getMinY(), var10, var2.getMaxY());
         } else {
            var10 = var6.valueToJava2D(var4, var2, RectangleEdge.LEFT);
            var9 = new java.awt.geom.Line2D.Double(var2.getMinX(), var10, var2.getMaxX(), var10);
         }

         var1.setStroke(var7);
         var1.setPaint(var8);
         var1.draw(var9);
      }

   }

   protected void drawVerticalLine(Graphics2D var1, Rectangle2D var2, double var3, Stroke var5, Paint var6) {
      ValueAxis var7 = this.getDomainAxis();
      if(this.getOrientation() == PlotOrientation.HORIZONTAL) {
         var7 = this.getRangeAxis();
      }

      if(var7.getRange().contains(var3)) {
         double var8 = var7.valueToJava2D(var3, var2, RectangleEdge.BOTTOM);
         java.awt.geom.Line2D.Double var10 = new java.awt.geom.Line2D.Double(var8, var2.getMinY(), var8, var2.getMaxY());
         var1.setStroke(var5);
         var1.setPaint(var6);
         var1.draw(var10);
      }

   }

   protected void drawRangeCrosshair(Graphics2D var1, Rectangle2D var2, PlotOrientation var3, double var4, ValueAxis var6, Stroke var7, Paint var8) {
      if(var6.getRange().contains(var4)) {
         java.awt.geom.Line2D.Double var9 = null;
         double var10;
         if(var3 == PlotOrientation.HORIZONTAL) {
            var10 = var6.valueToJava2D(var4, var2, RectangleEdge.BOTTOM);
            var9 = new java.awt.geom.Line2D.Double(var10, var2.getMinY(), var10, var2.getMaxY());
         } else {
            var10 = var6.valueToJava2D(var4, var2, RectangleEdge.LEFT);
            var9 = new java.awt.geom.Line2D.Double(var2.getMinX(), var10, var2.getMaxX(), var10);
         }

         var1.setStroke(var7);
         var1.setPaint(var8);
         var1.draw(var9);
      }

   }

   public void handleClick(int var1, int var2, PlotRenderingInfo var3) {
      Rectangle2D var4 = var3.getDataArea();
      if(var4.contains((double)var1, (double)var2)) {
         ValueAxis var5 = this.getDomainAxis();
         if(var5 != null) {
            double var6 = var5.java2DToValue((double)var1, var3.getDataArea(), this.getDomainAxisEdge());
            this.setDomainCrosshairValue(var6);
         }

         ValueAxis var9 = this.getRangeAxis();
         if(var9 != null) {
            double var7 = var9.java2DToValue((double)var2, var3.getDataArea(), this.getRangeAxisEdge());
            this.setRangeCrosshairValue(var7);
         }
      }

   }

   private List getDatasetsMappedToDomainAxis(Integer var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'axisIndex\' argument.");
      } else {
         ArrayList var2 = new ArrayList();

         for(int var3 = 0; var3 < this.datasets.size(); ++var3) {
            Integer var4 = (Integer)this.datasetToDomainAxisMap.get(new Integer(var3));
            if(var4 == null) {
               if(var1.equals(ZERO)) {
                  var2.add(this.datasets.get(var3));
               }
            } else if(var4.equals(var1)) {
               var2.add(this.datasets.get(var3));
            }
         }

         return var2;
      }
   }

   private List getDatasetsMappedToRangeAxis(Integer var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'axisIndex\' argument.");
      } else {
         ArrayList var2 = new ArrayList();

         for(int var3 = 0; var3 < this.datasets.size(); ++var3) {
            Integer var4 = (Integer)this.datasetToRangeAxisMap.get(new Integer(var3));
            if(var4 == null) {
               if(var1.equals(ZERO)) {
                  var2.add(this.datasets.get(var3));
               }
            } else if(var4.equals(var1)) {
               var2.add(this.datasets.get(var3));
            }
         }

         return var2;
      }
   }

   public int getDomainAxisIndex(ValueAxis var1) {
      int var2 = this.domainAxes.indexOf(var1);
      if(var2 < 0) {
         Plot var3 = this.getParent();
         if(var3 instanceof XYPlot) {
            XYPlot var4 = (XYPlot)var3;
            var2 = var4.getDomainAxisIndex(var1);
         }
      }

      return var2;
   }

   public int getRangeAxisIndex(ValueAxis var1) {
      int var2 = this.rangeAxes.indexOf(var1);
      if(var2 < 0) {
         Plot var3 = this.getParent();
         if(var3 instanceof XYPlot) {
            XYPlot var4 = (XYPlot)var3;
            var2 = var4.getRangeAxisIndex(var1);
         }
      }

      return var2;
   }

   public Range getDataRange(ValueAxis var1) {
      Range var2 = null;
      ArrayList var3 = new ArrayList();
      boolean var4 = true;
      int var5 = this.getDomainAxisIndex(var1);
      if(var5 >= 0) {
         var4 = true;
         var3.addAll(this.getDatasetsMappedToDomainAxis(new Integer(var5)));
      }

      int var6 = this.getRangeAxisIndex(var1);
      if(var6 >= 0) {
         var4 = false;
         var3.addAll(this.getDatasetsMappedToRangeAxis(new Integer(var6)));
      }

      Iterator var7 = var3.iterator();

      while(var7.hasNext()) {
         XYDataset var8 = (XYDataset)var7.next();
         if(var8 != null) {
            XYItemRenderer var9 = this.getRendererForDataset(var8);
            if(var4) {
               if(var9 != null) {
                  var2 = Range.combine(var2, var9.findDomainBounds(var8));
               } else {
                  var2 = Range.combine(var2, DatasetUtilities.findDomainBounds(var8));
               }
            } else if(var9 != null) {
               var2 = Range.combine(var2, var9.findRangeBounds(var8));
            } else {
               var2 = Range.combine(var2, DatasetUtilities.findRangeBounds(var8));
            }
         }
      }

      return var2;
   }

   public void datasetChanged(DatasetChangeEvent var1) {
      this.configureDomainAxes();
      this.configureRangeAxes();
      if(this.getParent() != null) {
         this.getParent().datasetChanged(var1);
      } else {
         PlotChangeEvent var2 = new PlotChangeEvent(this);
         var2.setType(ChartChangeEventType.DATASET_UPDATED);
         this.notifyListeners(var2);
      }

   }

   public void rendererChanged(RendererChangeEvent var1) {
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public boolean isDomainCrosshairVisible() {
      return this.domainCrosshairVisible;
   }

   public void setDomainCrosshairVisible(boolean var1) {
      if(this.domainCrosshairVisible != var1) {
         this.domainCrosshairVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public boolean isDomainCrosshairLockedOnData() {
      return this.domainCrosshairLockedOnData;
   }

   public void setDomainCrosshairLockedOnData(boolean var1) {
      if(this.domainCrosshairLockedOnData != var1) {
         this.domainCrosshairLockedOnData = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public double getDomainCrosshairValue() {
      return this.domainCrosshairValue;
   }

   public void setDomainCrosshairValue(double var1) {
      this.setDomainCrosshairValue(var1, true);
   }

   public void setDomainCrosshairValue(double var1, boolean var3) {
      this.domainCrosshairValue = var1;
      if(this.isDomainCrosshairVisible() && var3) {
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Stroke getDomainCrosshairStroke() {
      return this.domainCrosshairStroke;
   }

   public void setDomainCrosshairStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.domainCrosshairStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getDomainCrosshairPaint() {
      return this.domainCrosshairPaint;
   }

   public void setDomainCrosshairPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.domainCrosshairPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean isRangeCrosshairVisible() {
      return this.rangeCrosshairVisible;
   }

   public void setRangeCrosshairVisible(boolean var1) {
      if(this.rangeCrosshairVisible != var1) {
         this.rangeCrosshairVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public boolean isRangeCrosshairLockedOnData() {
      return this.rangeCrosshairLockedOnData;
   }

   public void setRangeCrosshairLockedOnData(boolean var1) {
      if(this.rangeCrosshairLockedOnData != var1) {
         this.rangeCrosshairLockedOnData = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public double getRangeCrosshairValue() {
      return this.rangeCrosshairValue;
   }

   public void setRangeCrosshairValue(double var1) {
      this.setRangeCrosshairValue(var1, true);
   }

   public void setRangeCrosshairValue(double var1, boolean var3) {
      this.rangeCrosshairValue = var1;
      if(this.isRangeCrosshairVisible() && var3) {
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Stroke getRangeCrosshairStroke() {
      return this.rangeCrosshairStroke;
   }

   public void setRangeCrosshairStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.rangeCrosshairStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getRangeCrosshairPaint() {
      return this.rangeCrosshairPaint;
   }

   public void setRangeCrosshairPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.rangeCrosshairPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public AxisSpace getFixedDomainAxisSpace() {
      return this.fixedDomainAxisSpace;
   }

   public void setFixedDomainAxisSpace(AxisSpace var1) {
      this.fixedDomainAxisSpace = var1;
   }

   public AxisSpace getFixedRangeAxisSpace() {
      return this.fixedRangeAxisSpace;
   }

   public void setFixedRangeAxisSpace(AxisSpace var1) {
      this.fixedRangeAxisSpace = var1;
   }

   public void zoomDomainAxes(double var1, PlotRenderingInfo var3, Point2D var4) {
      for(int var5 = 0; var5 < this.domainAxes.size(); ++var5) {
         ValueAxis var6 = (ValueAxis)this.domainAxes.get(var5);
         if(var6 != null) {
            var6.resizeRange(var1);
         }
      }

   }

   public void zoomDomainAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6) {
      for(int var7 = 0; var7 < this.domainAxes.size(); ++var7) {
         ValueAxis var8 = (ValueAxis)this.domainAxes.get(var7);
         if(var8 != null) {
            var8.zoomRange(var1, var3);
         }
      }

   }

   public void zoomRangeAxes(double var1, PlotRenderingInfo var3, Point2D var4) {
      for(int var5 = 0; var5 < this.rangeAxes.size(); ++var5) {
         ValueAxis var6 = (ValueAxis)this.rangeAxes.get(var5);
         if(var6 != null) {
            var6.resizeRange(var1);
         }
      }

   }

   public void zoomRangeAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6) {
      for(int var7 = 0; var7 < this.rangeAxes.size(); ++var7) {
         ValueAxis var8 = (ValueAxis)this.rangeAxes.get(var7);
         if(var8 != null) {
            var8.zoomRange(var1, var3);
         }
      }

   }

   public boolean isDomainZoomable() {
      return true;
   }

   public boolean isRangeZoomable() {
      return true;
   }

   public int getSeriesCount() {
      int var1 = 0;
      XYDataset var2 = this.getDataset();
      if(var2 != null) {
         var1 = var2.getSeriesCount();
      }

      return var1;
   }

   public LegendItemCollection getFixedLegendItems() {
      return this.fixedLegendItems;
   }

   public void setFixedLegendItems(LegendItemCollection var1) {
      this.fixedLegendItems = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public LegendItemCollection getLegendItems() {
      if(this.fixedLegendItems != null) {
         return this.fixedLegendItems;
      } else {
         LegendItemCollection var1 = new LegendItemCollection();
         int var2 = this.datasets.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            XYDataset var4 = this.getDataset(var3);
            if(var4 != null) {
               XYItemRenderer var5 = this.getRenderer(var3);
               if(var5 == null) {
                  var5 = this.getRenderer(0);
               }

               if(var5 != null) {
                  int var6 = var4.getSeriesCount();

                  for(int var7 = 0; var7 < var6; ++var7) {
                     if(var5.isSeriesVisible(var7) && var5.isSeriesVisibleInLegend(var7)) {
                        LegendItem var8 = var5.getLegendItem(var3, var7);
                        if(var8 != null) {
                           var1.add(var8);
                        }
                     }
                  }
               }
            }
         }

         return var1;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYPlot)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         XYPlot var2 = (XYPlot)var1;
         if(this.weight != var2.weight) {
            return false;
         } else if(this.orientation != var2.orientation) {
            return false;
         } else if(!this.domainAxes.equals(var2.domainAxes)) {
            return false;
         } else if(!this.domainAxisLocations.equals(var2.domainAxisLocations)) {
            return false;
         } else if(this.rangeCrosshairLockedOnData != var2.rangeCrosshairLockedOnData) {
            return false;
         } else if(this.domainGridlinesVisible != var2.domainGridlinesVisible) {
            return false;
         } else if(this.rangeGridlinesVisible != var2.rangeGridlinesVisible) {
            return false;
         } else if(this.domainZeroBaselineVisible != var2.domainZeroBaselineVisible) {
            return false;
         } else if(this.rangeZeroBaselineVisible != var2.rangeZeroBaselineVisible) {
            return false;
         } else if(this.domainCrosshairVisible != var2.domainCrosshairVisible) {
            return false;
         } else if(this.domainCrosshairValue != var2.domainCrosshairValue) {
            return false;
         } else if(this.domainCrosshairLockedOnData != var2.domainCrosshairLockedOnData) {
            return false;
         } else if(this.rangeCrosshairVisible != var2.rangeCrosshairVisible) {
            return false;
         } else if(this.rangeCrosshairValue != var2.rangeCrosshairValue) {
            return false;
         } else if(!ObjectUtilities.equal(this.axisOffset, var2.axisOffset)) {
            return false;
         } else if(!ObjectUtilities.equal(this.renderers, var2.renderers)) {
            return false;
         } else if(!ObjectUtilities.equal(this.rangeAxes, var2.rangeAxes)) {
            return false;
         } else if(!this.rangeAxisLocations.equals(var2.rangeAxisLocations)) {
            return false;
         } else if(!ObjectUtilities.equal(this.datasetToDomainAxisMap, var2.datasetToDomainAxisMap)) {
            return false;
         } else if(!ObjectUtilities.equal(this.datasetToRangeAxisMap, var2.datasetToRangeAxisMap)) {
            return false;
         } else if(!ObjectUtilities.equal(this.domainGridlineStroke, var2.domainGridlineStroke)) {
            return false;
         } else if(!PaintUtilities.equal(this.domainGridlinePaint, var2.domainGridlinePaint)) {
            return false;
         } else if(!ObjectUtilities.equal(this.rangeGridlineStroke, var2.rangeGridlineStroke)) {
            return false;
         } else if(!PaintUtilities.equal(this.rangeGridlinePaint, var2.rangeGridlinePaint)) {
            return false;
         } else if(!PaintUtilities.equal(this.domainZeroBaselinePaint, var2.domainZeroBaselinePaint)) {
            return false;
         } else if(!ObjectUtilities.equal(this.domainZeroBaselineStroke, var2.domainZeroBaselineStroke)) {
            return false;
         } else if(!PaintUtilities.equal(this.rangeZeroBaselinePaint, var2.rangeZeroBaselinePaint)) {
            return false;
         } else if(!ObjectUtilities.equal(this.rangeZeroBaselineStroke, var2.rangeZeroBaselineStroke)) {
            return false;
         } else if(!ObjectUtilities.equal(this.domainCrosshairStroke, var2.domainCrosshairStroke)) {
            return false;
         } else if(!PaintUtilities.equal(this.domainCrosshairPaint, var2.domainCrosshairPaint)) {
            return false;
         } else if(!ObjectUtilities.equal(this.rangeCrosshairStroke, var2.rangeCrosshairStroke)) {
            return false;
         } else if(!PaintUtilities.equal(this.rangeCrosshairPaint, var2.rangeCrosshairPaint)) {
            return false;
         } else if(!ObjectUtilities.equal(this.foregroundDomainMarkers, var2.foregroundDomainMarkers)) {
            return false;
         } else if(!ObjectUtilities.equal(this.backgroundDomainMarkers, var2.backgroundDomainMarkers)) {
            return false;
         } else if(!ObjectUtilities.equal(this.foregroundRangeMarkers, var2.foregroundRangeMarkers)) {
            return false;
         } else if(!ObjectUtilities.equal(this.backgroundRangeMarkers, var2.backgroundRangeMarkers)) {
            return false;
         } else if(!ObjectUtilities.equal(this.foregroundDomainMarkers, var2.foregroundDomainMarkers)) {
            return false;
         } else if(!ObjectUtilities.equal(this.backgroundDomainMarkers, var2.backgroundDomainMarkers)) {
            return false;
         } else if(!ObjectUtilities.equal(this.foregroundRangeMarkers, var2.foregroundRangeMarkers)) {
            return false;
         } else if(!ObjectUtilities.equal(this.backgroundRangeMarkers, var2.backgroundRangeMarkers)) {
            return false;
         } else if(!ObjectUtilities.equal(this.annotations, var2.annotations)) {
            return false;
         } else if(!this.quadrantOrigin.equals(var2.quadrantOrigin)) {
            return false;
         } else {
            for(int var3 = 0; var3 < 4; ++var3) {
               if(!PaintUtilities.equal(this.quadrantPaint[var3], var2.quadrantPaint[var3])) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public Object clone() {
      XYPlot var1 = (XYPlot)super.clone();
      var1.domainAxes = (ObjectList)ObjectUtilities.clone(this.domainAxes);

      int var2;
      ValueAxis var3;
      ValueAxis var4;
      for(var2 = 0; var2 < this.domainAxes.size(); ++var2) {
         var3 = (ValueAxis)this.domainAxes.get(var2);
         if(var3 != null) {
            var4 = (ValueAxis)var3.clone();
            var1.domainAxes.set(var2, var4);
            var4.setPlot(var1);
            var4.addChangeListener(var1);
         }
      }

      var1.domainAxisLocations = (ObjectList)this.domainAxisLocations.clone();
      var1.rangeAxes = (ObjectList)ObjectUtilities.clone(this.rangeAxes);

      for(var2 = 0; var2 < this.rangeAxes.size(); ++var2) {
         var3 = (ValueAxis)this.rangeAxes.get(var2);
         if(var3 != null) {
            var4 = (ValueAxis)var3.clone();
            var1.rangeAxes.set(var2, var4);
            var4.setPlot(var1);
            var4.addChangeListener(var1);
         }
      }

      var1.rangeAxisLocations = (ObjectList)ObjectUtilities.clone(this.rangeAxisLocations);
      var1.datasets = (ObjectList)ObjectUtilities.clone(this.datasets);

      for(var2 = 0; var2 < var1.datasets.size(); ++var2) {
         XYDataset var5 = this.getDataset(var2);
         if(var5 != null) {
            var5.addChangeListener(var1);
         }
      }

      var1.datasetToDomainAxisMap = new TreeMap();
      var1.datasetToDomainAxisMap.putAll(this.datasetToDomainAxisMap);
      var1.datasetToRangeAxisMap = new TreeMap();
      var1.datasetToRangeAxisMap.putAll(this.datasetToRangeAxisMap);
      var1.renderers = (ObjectList)ObjectUtilities.clone(this.renderers);

      for(var2 = 0; var2 < this.renderers.size(); ++var2) {
         XYItemRenderer var6 = (XYItemRenderer)this.renderers.get(var2);
         if(var6 instanceof PublicCloneable) {
            PublicCloneable var7 = (PublicCloneable)var6;
            var1.renderers.set(var2, var7.clone());
         }
      }

      var1.foregroundDomainMarkers = (Map)ObjectUtilities.clone(this.foregroundDomainMarkers);
      var1.backgroundDomainMarkers = (Map)ObjectUtilities.clone(this.backgroundDomainMarkers);
      var1.foregroundRangeMarkers = (Map)ObjectUtilities.clone(this.foregroundRangeMarkers);
      var1.backgroundRangeMarkers = (Map)ObjectUtilities.clone(this.backgroundRangeMarkers);
      var1.annotations = (List)ObjectUtilities.deepClone(this.annotations);
      if(this.fixedDomainAxisSpace != null) {
         var1.fixedDomainAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedDomainAxisSpace);
      }

      if(this.fixedRangeAxisSpace != null) {
         var1.fixedRangeAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedRangeAxisSpace);
      }

      var1.quadrantOrigin = (Point2D)ObjectUtilities.clone(this.quadrantOrigin);
      var1.quadrantPaint = (Paint[])((Paint[])this.quadrantPaint.clone());
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeStroke(this.domainGridlineStroke, var1);
      SerialUtilities.writePaint(this.domainGridlinePaint, var1);
      SerialUtilities.writeStroke(this.rangeGridlineStroke, var1);
      SerialUtilities.writePaint(this.rangeGridlinePaint, var1);
      SerialUtilities.writeStroke(this.rangeZeroBaselineStroke, var1);
      SerialUtilities.writePaint(this.rangeZeroBaselinePaint, var1);
      SerialUtilities.writeStroke(this.domainCrosshairStroke, var1);
      SerialUtilities.writePaint(this.domainCrosshairPaint, var1);
      SerialUtilities.writeStroke(this.rangeCrosshairStroke, var1);
      SerialUtilities.writePaint(this.rangeCrosshairPaint, var1);
      SerialUtilities.writePaint(this.domainTickBandPaint, var1);
      SerialUtilities.writePaint(this.rangeTickBandPaint, var1);
      SerialUtilities.writePoint2D(this.quadrantOrigin, var1);

      for(int var2 = 0; var2 < 4; ++var2) {
         SerialUtilities.writePaint(this.quadrantPaint[var2], var1);
      }

      SerialUtilities.writeStroke(this.domainZeroBaselineStroke, var1);
      SerialUtilities.writePaint(this.domainZeroBaselinePaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.domainGridlineStroke = SerialUtilities.readStroke(var1);
      this.domainGridlinePaint = SerialUtilities.readPaint(var1);
      this.rangeGridlineStroke = SerialUtilities.readStroke(var1);
      this.rangeGridlinePaint = SerialUtilities.readPaint(var1);
      this.rangeZeroBaselineStroke = SerialUtilities.readStroke(var1);
      this.rangeZeroBaselinePaint = SerialUtilities.readPaint(var1);
      this.domainCrosshairStroke = SerialUtilities.readStroke(var1);
      this.domainCrosshairPaint = SerialUtilities.readPaint(var1);
      this.rangeCrosshairStroke = SerialUtilities.readStroke(var1);
      this.rangeCrosshairPaint = SerialUtilities.readPaint(var1);
      this.domainTickBandPaint = SerialUtilities.readPaint(var1);
      this.rangeTickBandPaint = SerialUtilities.readPaint(var1);
      this.quadrantOrigin = SerialUtilities.readPoint2D(var1);
      this.quadrantPaint = new Paint[4];

      int var2;
      for(var2 = 0; var2 < 4; ++var2) {
         this.quadrantPaint[var2] = SerialUtilities.readPaint(var1);
      }

      this.domainZeroBaselineStroke = SerialUtilities.readStroke(var1);
      this.domainZeroBaselinePaint = SerialUtilities.readPaint(var1);
      var2 = this.domainAxes.size();

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         Axis var4 = (Axis)this.domainAxes.get(var3);
         if(var4 != null) {
            var4.setPlot(this);
            var4.addChangeListener(this);
         }
      }

      var3 = this.rangeAxes.size();

      int var8;
      for(var8 = 0; var8 < var3; ++var8) {
         Axis var5 = (Axis)this.rangeAxes.get(var8);
         if(var5 != null) {
            var5.setPlot(this);
            var5.addChangeListener(this);
         }
      }

      var8 = this.datasets.size();

      int var9;
      for(var9 = 0; var9 < var8; ++var9) {
         Dataset var6 = (Dataset)this.datasets.get(var9);
         if(var6 != null) {
            var6.addChangeListener(this);
         }
      }

      var9 = this.renderers.size();

      for(int var10 = 0; var10 < var9; ++var10) {
         XYItemRenderer var7 = (XYItemRenderer)this.renderers.get(var10);
         if(var7 != null) {
            var7.addChangeListener(this);
         }
      }

   }

   static {
      DEFAULT_GRIDLINE_PAINT = Color.lightGray;
      DEFAULT_CROSSHAIR_STROKE = DEFAULT_GRIDLINE_STROKE;
      DEFAULT_CROSSHAIR_PAINT = Color.blue;
      localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
   }
}
