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
import java.awt.geom.Line2D.Double;
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
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.annotations.CategoryAnnotation;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.AxisCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.axis.ValueTick;
import org.jfree.chart.event.ChartChangeEventType;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.plot.CategoryMarker;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.Zoomable;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectList;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.SortOrder;

public class CategoryPlot extends Plot implements Serializable, Cloneable, RendererChangeListener, ValueAxisPlot, Zoomable, PublicCloneable {
   private static final long serialVersionUID = -3537691700434728188L;
   public static final boolean DEFAULT_DOMAIN_GRIDLINES_VISIBLE = false;
   public static final boolean DEFAULT_RANGE_GRIDLINES_VISIBLE = true;
   public static final Stroke DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5F, 0, 2, 0.0F, new float[]{2.0F, 2.0F}, 0.0F);
   public static final Paint DEFAULT_GRIDLINE_PAINT;
   public static final Font DEFAULT_VALUE_LABEL_FONT;
   public static final boolean DEFAULT_CROSSHAIR_VISIBLE = false;
   public static final Stroke DEFAULT_CROSSHAIR_STROKE;
   public static final Paint DEFAULT_CROSSHAIR_PAINT;
   protected static ResourceBundle localizationResources;
   private PlotOrientation orientation;
   private RectangleInsets axisOffset;
   private ObjectList domainAxes;
   private ObjectList domainAxisLocations;
   private boolean drawSharedDomainAxis;
   private ObjectList rangeAxes;
   private ObjectList rangeAxisLocations;
   private ObjectList datasets;
   private ObjectList datasetToDomainAxisMap;
   private ObjectList datasetToRangeAxisMap;
   private ObjectList renderers;
   private DatasetRenderingOrder renderingOrder;
   private SortOrder columnRenderingOrder;
   private SortOrder rowRenderingOrder;
   private boolean domainGridlinesVisible;
   private CategoryAnchor domainGridlinePosition;
   private transient Stroke domainGridlineStroke;
   private transient Paint domainGridlinePaint;
   private boolean rangeGridlinesVisible;
   private transient Stroke rangeGridlineStroke;
   private transient Paint rangeGridlinePaint;
   private double anchorValue;
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
   private int weight;
   private AxisSpace fixedDomainAxisSpace;
   private AxisSpace fixedRangeAxisSpace;
   private LegendItemCollection fixedLegendItems;

   public CategoryPlot() {
      this((CategoryDataset)null, (CategoryAxis)null, (ValueAxis)null, (CategoryItemRenderer)null);
   }

   public CategoryPlot(CategoryDataset var1, CategoryAxis var2, ValueAxis var3, CategoryItemRenderer var4) {
      this.renderingOrder = DatasetRenderingOrder.REVERSE;
      this.columnRenderingOrder = SortOrder.ASCENDING;
      this.rowRenderingOrder = SortOrder.ASCENDING;
      this.rangeCrosshairLockedOnData = true;
      this.orientation = PlotOrientation.VERTICAL;
      this.domainAxes = new ObjectList();
      this.domainAxisLocations = new ObjectList();
      this.rangeAxes = new ObjectList();
      this.rangeAxisLocations = new ObjectList();
      this.datasetToDomainAxisMap = new ObjectList();
      this.datasetToRangeAxisMap = new ObjectList();
      this.renderers = new ObjectList();
      this.datasets = new ObjectList();
      this.datasets.set(0, var1);
      if(var1 != null) {
         var1.addChangeListener(this);
      }

      this.axisOffset = RectangleInsets.ZERO_INSETS;
      this.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT, false);
      this.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT, false);
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

      this.drawSharedDomainAxis = false;
      this.rangeAxes.set(0, var3);
      this.mapDatasetToRangeAxis(0, 0);
      if(var3 != null) {
         var3.setPlot(this);
         var3.addChangeListener(this);
      }

      this.configureDomainAxes();
      this.configureRangeAxes();
      this.domainGridlinesVisible = false;
      this.domainGridlinePosition = CategoryAnchor.MIDDLE;
      this.domainGridlineStroke = DEFAULT_GRIDLINE_STROKE;
      this.domainGridlinePaint = DEFAULT_GRIDLINE_PAINT;
      this.rangeGridlinesVisible = true;
      this.rangeGridlineStroke = DEFAULT_GRIDLINE_STROKE;
      this.rangeGridlinePaint = DEFAULT_GRIDLINE_PAINT;
      this.foregroundDomainMarkers = new HashMap();
      this.backgroundDomainMarkers = new HashMap();
      this.foregroundRangeMarkers = new HashMap();
      this.backgroundRangeMarkers = new HashMap();
      ValueMarker var5 = new ValueMarker(0.0D, new Color(0.8F, 0.8F, 0.8F, 0.5F), new BasicStroke(1.0F), new Color(0.85F, 0.85F, 0.95F, 0.5F), new BasicStroke(1.0F), 0.6F);
      this.addRangeMarker(var5, Layer.BACKGROUND);
      this.anchorValue = 0.0D;
      this.rangeCrosshairVisible = false;
      this.rangeCrosshairValue = 0.0D;
      this.rangeCrosshairStroke = DEFAULT_CROSSHAIR_STROKE;
      this.rangeCrosshairPaint = DEFAULT_CROSSHAIR_PAINT;
      this.annotations = new ArrayList();
   }

   public String getPlotType() {
      return localizationResources.getString("Category_Plot");
   }

   public PlotOrientation getOrientation() {
      return this.orientation;
   }

   public void setOrientation(PlotOrientation var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         this.orientation = var1;
         this.notifyListeners(new PlotChangeEvent(this));
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

   public CategoryAxis getDomainAxis() {
      return this.getDomainAxis(0);
   }

   public CategoryAxis getDomainAxis(int var1) {
      CategoryAxis var2 = null;
      if(var1 < this.domainAxes.size()) {
         var2 = (CategoryAxis)this.domainAxes.get(var1);
      }

      if(var2 == null) {
         Plot var3 = this.getParent();
         if(var3 instanceof CategoryPlot) {
            CategoryPlot var4 = (CategoryPlot)var3;
            var2 = var4.getDomainAxis(var1);
         }
      }

      return var2;
   }

   public void setDomainAxis(CategoryAxis var1) {
      this.setDomainAxis(0, var1);
   }

   public void setDomainAxis(int var1, CategoryAxis var2) {
      this.setDomainAxis(var1, var2, true);
   }

   public void setDomainAxis(int var1, CategoryAxis var2, boolean var3) {
      CategoryAxis var4 = (CategoryAxis)this.domainAxes.get(var1);
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

   public void setDomainAxes(CategoryAxis[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.setDomainAxis(var2, var1[var2], false);
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public int getDomainAxisIndex(CategoryAxis var1) {
      return this.domainAxes.indexOf(var1);
   }

   public AxisLocation getDomainAxisLocation() {
      return this.getDomainAxisLocation(0);
   }

   public AxisLocation getDomainAxisLocation(int var1) {
      AxisLocation var2 = null;
      if(var1 < this.domainAxisLocations.size()) {
         var2 = (AxisLocation)this.domainAxisLocations.get(var1);
      }

      if(var2 == null) {
         var2 = AxisLocation.getOpposite(this.getDomainAxisLocation(0));
      }

      return var2;
   }

   public void setDomainAxisLocation(AxisLocation var1) {
      this.setDomainAxisLocation(0, var1, true);
   }

   public void setDomainAxisLocation(AxisLocation var1, boolean var2) {
      this.setDomainAxisLocation(0, var1, var2);
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

   public RectangleEdge getDomainAxisEdge() {
      return this.getDomainAxisEdge(0);
   }

   public RectangleEdge getDomainAxisEdge(int var1) {
      RectangleEdge var2 = null;
      AxisLocation var3 = this.getDomainAxisLocation(var1);
      if(var3 != null) {
         var2 = Plot.resolveDomainAxisLocation(var3, this.orientation);
      } else {
         var2 = RectangleEdge.opposite(this.getDomainAxisEdge(0));
      }

      return var2;
   }

   public int getDomainAxisCount() {
      return this.domainAxes.size();
   }

   public void clearDomainAxes() {
      for(int var1 = 0; var1 < this.domainAxes.size(); ++var1) {
         CategoryAxis var2 = (CategoryAxis)this.domainAxes.get(var1);
         if(var2 != null) {
            var2.removeChangeListener(this);
         }
      }

      this.domainAxes.clear();
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void configureDomainAxes() {
      for(int var1 = 0; var1 < this.domainAxes.size(); ++var1) {
         CategoryAxis var2 = (CategoryAxis)this.domainAxes.get(var1);
         if(var2 != null) {
            var2.configure();
         }
      }

   }

   public ValueAxis getRangeAxis() {
      return this.getRangeAxis(0);
   }

   public ValueAxis getRangeAxis(int var1) {
      ValueAxis var2 = null;
      if(var1 < this.rangeAxes.size()) {
         var2 = (ValueAxis)this.rangeAxes.get(var1);
      }

      if(var2 == null) {
         Plot var3 = this.getParent();
         if(var3 instanceof CategoryPlot) {
            CategoryPlot var4 = (CategoryPlot)var3;
            var2 = var4.getRangeAxis(var1);
         }
      }

      return var2;
   }

   public void setRangeAxis(ValueAxis var1) {
      this.setRangeAxis(0, var1);
   }

   public void setRangeAxis(int var1, ValueAxis var2) {
      this.setRangeAxis(var1, var2, true);
   }

   public void setRangeAxis(int var1, ValueAxis var2, boolean var3) {
      ValueAxis var4 = (ValueAxis)this.rangeAxes.get(var1);
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

   public AxisLocation getRangeAxisLocation() {
      return this.getRangeAxisLocation(0);
   }

   public AxisLocation getRangeAxisLocation(int var1) {
      AxisLocation var2 = null;
      if(var1 < this.rangeAxisLocations.size()) {
         var2 = (AxisLocation)this.rangeAxisLocations.get(var1);
      }

      if(var2 == null) {
         var2 = AxisLocation.getOpposite(this.getRangeAxisLocation(0));
      }

      return var2;
   }

   public void setRangeAxisLocation(AxisLocation var1) {
      this.setRangeAxisLocation(var1, true);
   }

   public void setRangeAxisLocation(AxisLocation var1, boolean var2) {
      this.setRangeAxisLocation(0, var1, var2);
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

   public RectangleEdge getRangeAxisEdge() {
      return this.getRangeAxisEdge(0);
   }

   public RectangleEdge getRangeAxisEdge(int var1) {
      AxisLocation var2 = this.getRangeAxisLocation(var1);
      RectangleEdge var3 = Plot.resolveRangeAxisLocation(var2, this.orientation);
      if(var3 == null) {
         var3 = RectangleEdge.opposite(this.getRangeAxisEdge(0));
      }

      return var3;
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

   public CategoryDataset getDataset() {
      return this.getDataset(0);
   }

   public CategoryDataset getDataset(int var1) {
      CategoryDataset var2 = null;
      if(this.datasets.size() > var1) {
         var2 = (CategoryDataset)this.datasets.get(var1);
      }

      return var2;
   }

   public void setDataset(CategoryDataset var1) {
      this.setDataset(0, var1);
   }

   public void setDataset(int var1, CategoryDataset var2) {
      CategoryDataset var3 = (CategoryDataset)this.datasets.get(var1);
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

   public void mapDatasetToDomainAxis(int var1, int var2) {
      this.datasetToDomainAxisMap.set(var1, new Integer(var2));
      this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(var1)));
   }

   public CategoryAxis getDomainAxisForDataset(int var1) {
      CategoryAxis var2 = this.getDomainAxis();
      Integer var3 = (Integer)this.datasetToDomainAxisMap.get(var1);
      if(var3 != null) {
         var2 = this.getDomainAxis(var3.intValue());
      }

      return var2;
   }

   public void mapDatasetToRangeAxis(int var1, int var2) {
      this.datasetToRangeAxisMap.set(var1, new Integer(var2));
      this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(var1)));
   }

   public ValueAxis getRangeAxisForDataset(int var1) {
      ValueAxis var2 = this.getRangeAxis();
      Integer var3 = (Integer)this.datasetToRangeAxisMap.get(var1);
      if(var3 != null) {
         var2 = this.getRangeAxis(var3.intValue());
      }

      return var2;
   }

   public CategoryItemRenderer getRenderer() {
      return this.getRenderer(0);
   }

   public CategoryItemRenderer getRenderer(int var1) {
      CategoryItemRenderer var2 = null;
      if(this.renderers.size() > var1) {
         var2 = (CategoryItemRenderer)this.renderers.get(var1);
      }

      return var2;
   }

   public void setRenderer(CategoryItemRenderer var1) {
      this.setRenderer(0, var1, true);
   }

   public void setRenderer(CategoryItemRenderer var1, boolean var2) {
      this.setRenderer(0, var1, var2);
   }

   public void setRenderer(int var1, CategoryItemRenderer var2) {
      this.setRenderer(var1, var2, true);
   }

   public void setRenderer(int var1, CategoryItemRenderer var2, boolean var3) {
      CategoryItemRenderer var4 = (CategoryItemRenderer)this.renderers.get(var1);
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

   public void setRenderers(CategoryItemRenderer[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.setRenderer(var2, var1[var2], false);
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public CategoryItemRenderer getRendererForDataset(CategoryDataset var1) {
      CategoryItemRenderer var2 = null;

      for(int var3 = 0; var3 < this.datasets.size(); ++var3) {
         if(this.datasets.get(var3) == var1) {
            var2 = (CategoryItemRenderer)this.renderers.get(var3);
            break;
         }
      }

      return var2;
   }

   public int getIndexOf(CategoryItemRenderer var1) {
      return this.renderers.indexOf(var1);
   }

   public DatasetRenderingOrder getDatasetRenderingOrder() {
      return this.renderingOrder;
   }

   public void setDatasetRenderingOrder(DatasetRenderingOrder var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'order\' argument.");
      } else {
         this.renderingOrder = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public SortOrder getColumnRenderingOrder() {
      return this.columnRenderingOrder;
   }

   public void setColumnRenderingOrder(SortOrder var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'order\' argument.");
      } else {
         this.columnRenderingOrder = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public SortOrder getRowRenderingOrder() {
      return this.rowRenderingOrder;
   }

   public void setRowRenderingOrder(SortOrder var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'order\' argument.");
      } else {
         this.rowRenderingOrder = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
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

   public CategoryAnchor getDomainGridlinePosition() {
      return this.domainGridlinePosition;
   }

   public void setDomainGridlinePosition(CategoryAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'position\' argument.");
      } else {
         this.domainGridlinePosition = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Stroke getDomainGridlineStroke() {
      return this.domainGridlineStroke;
   }

   public void setDomainGridlineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' not permitted.");
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

   public LegendItemCollection getFixedLegendItems() {
      return this.fixedLegendItems;
   }

   public void setFixedLegendItems(LegendItemCollection var1) {
      this.fixedLegendItems = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public LegendItemCollection getLegendItems() {
      LegendItemCollection var1 = this.fixedLegendItems;
      if(var1 == null) {
         var1 = new LegendItemCollection();
         int var2 = this.datasets.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            CategoryDataset var4 = this.getDataset(var3);
            if(var4 != null) {
               CategoryItemRenderer var5 = this.getRenderer(var3);
               if(var5 != null) {
                  int var6 = var4.getRowCount();

                  for(int var7 = 0; var7 < var6; ++var7) {
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

   public void handleClick(int var1, int var2, PlotRenderingInfo var3) {
      Rectangle2D var4 = var3.getDataArea();
      if(var4.contains((double)var1, (double)var2)) {
         double var5 = 0.0D;
         if(this.orientation == PlotOrientation.HORIZONTAL) {
            var5 = (double)var1;
         } else if(this.orientation == PlotOrientation.VERTICAL) {
            var5 = (double)var2;
         }

         RectangleEdge var7 = Plot.resolveRangeAxisLocation(this.getRangeAxisLocation(), this.orientation);
         double var8 = this.getRangeAxis().java2DToValue(var5, var3.getDataArea(), var7);
         this.setAnchorValue(var8);
         this.setRangeCrosshairValue(var8);
      }

   }

   public void zoom(double var1) {
      if(var1 > 0.0D) {
         double var3 = this.getRangeAxis().getRange().getLength();
         double var5 = var3 * var1;
         this.getRangeAxis().setRange(this.anchorValue - var5 / 2.0D, this.anchorValue + var5 / 2.0D);
      } else {
         this.getRangeAxis().setAutoRange(true);
      }

   }

   public void datasetChanged(DatasetChangeEvent var1) {
      int var2 = this.rangeAxes.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         ValueAxis var4 = this.getRangeAxis(var3);
         if(var4 != null) {
            var4.configure();
         }
      }

      if(this.getParent() != null) {
         this.getParent().datasetChanged(var1);
      } else {
         PlotChangeEvent var5 = new PlotChangeEvent(this);
         var5.setType(ChartChangeEventType.DATASET_UPDATED);
         this.notifyListeners(var5);
      }

   }

   public void rendererChanged(RendererChangeEvent var1) {
      Plot var2 = this.getParent();
      if(var2 != null) {
         if(!(var2 instanceof RendererChangeListener)) {
            throw new RuntimeException("The renderer has changed and I don\'t know what to do!");
         }

         RendererChangeListener var3 = (RendererChangeListener)var2;
         var3.rendererChanged(var1);
      } else {
         this.configureRangeAxes();
         PlotChangeEvent var4 = new PlotChangeEvent(this);
         this.notifyListeners(var4);
      }

   }

   public void addDomainMarker(CategoryMarker var1) {
      this.addDomainMarker(var1, Layer.FOREGROUND);
   }

   public void addDomainMarker(CategoryMarker var1, Layer var2) {
      this.addDomainMarker(0, var1, var2);
   }

   public void addDomainMarker(int var1, CategoryMarker var2, Layer var3) {
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

   public Collection getDomainMarkers(Layer var1) {
      return this.getDomainMarkers(0, var1);
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

      if(this.foregroundDomainMarkers != null) {
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

   public void addRangeMarker(Marker var1) {
      this.addRangeMarker(var1, Layer.FOREGROUND);
   }

   public void addRangeMarker(Marker var1, Layer var2) {
      this.addRangeMarker(0, var1, var2);
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

   public Collection getRangeMarkers(Layer var1) {
      return this.getRangeMarkers(0, var1);
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

   public List getAnnotations() {
      return this.annotations;
   }

   public void addAnnotation(CategoryAnnotation var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'annotation\' argument.");
      } else {
         this.annotations.add(var1);
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean removeAnnotation(CategoryAnnotation var1) {
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

   public void clearAnnotations() {
      this.annotations.clear();
      this.notifyListeners(new PlotChangeEvent(this));
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
         RectangleEdge var4 = Plot.resolveDomainAxisLocation(this.getDomainAxisLocation(), this.orientation);
         if(this.drawSharedDomainAxis) {
            var3 = this.getDomainAxis().reserveSpace(var1, this, var2, var4, var3);
         }

         for(int var5 = 0; var5 < this.domainAxes.size(); ++var5) {
            Axis var6 = (Axis)this.domainAxes.get(var5);
            if(var6 != null) {
               RectangleEdge var7 = this.getDomainAxisEdge(var5);
               var3 = var6.reserveSpace(var1, this, var2, var7, var3);
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

   protected AxisSpace calculateAxisSpace(Graphics2D var1, Rectangle2D var2) {
      AxisSpace var3 = new AxisSpace();
      var3 = this.calculateRangeAxisSpace(var1, var2, var3);
      var3 = this.calculateDomainAxisSpace(var1, var2, var3);
      return var3;
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      boolean var6 = var2.getWidth() <= 10.0D;
      boolean var7 = var2.getHeight() <= 10.0D;
      if(!var6 && !var7) {
         if(var5 == null) {
            var5 = new PlotRenderingInfo((ChartRenderingInfo)null);
         }

         var5.setPlotArea(var2);
         RectangleInsets var8 = this.getInsets();
         var8.trim(var2);
         AxisSpace var9 = this.calculateAxisSpace(var1, var2);
         Rectangle2D var10 = var9.shrink(var2, (Rectangle2D)null);
         this.axisOffset.trim(var10);
         var5.setDataArea(var10);
         if(this.getRenderer() != null) {
            this.getRenderer().drawBackground(var1, this, var10);
         } else {
            this.drawBackground(var1, var10);
         }

         Map var11 = this.drawAxes(var1, var2, var10, var5);
         Shape var12 = var1.getClip();
         var1.clip(var10);
         this.drawDomainGridlines(var1, var10);
         AxisState var13 = (AxisState)var11.get(this.getRangeAxis());
         if(var13 == null && var4 != null) {
            var13 = (AxisState)var4.getSharedAxisStates().get(this.getRangeAxis());
         }

         if(var13 != null) {
            this.drawRangeGridlines(var1, var10, var13.getTicks());
         }

         int var14;
         for(var14 = 0; var14 < this.renderers.size(); ++var14) {
            this.drawDomainMarkers(var1, var10, var14, Layer.BACKGROUND);
         }

         for(var14 = 0; var14 < this.renderers.size(); ++var14) {
            this.drawRangeMarkers(var1, var10, var14, Layer.BACKGROUND);
         }

         boolean var18 = false;
         Composite var15 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
         DatasetRenderingOrder var16 = this.getDatasetRenderingOrder();
         int var17;
         if(var16 == DatasetRenderingOrder.FORWARD) {
            for(var17 = 0; var17 < this.datasets.size(); ++var17) {
               var18 = this.render(var1, var10, var17, var5) || var18;
            }
         } else {
            for(var17 = this.datasets.size() - 1; var17 >= 0; --var17) {
               var18 = this.render(var1, var10, var17, var5) || var18;
            }
         }

         for(var17 = 0; var17 < this.renderers.size(); ++var17) {
            this.drawDomainMarkers(var1, var10, var17, Layer.FOREGROUND);
         }

         for(var17 = 0; var17 < this.renderers.size(); ++var17) {
            this.drawRangeMarkers(var1, var10, var17, Layer.FOREGROUND);
         }

         this.drawAnnotations(var1, var10);
         var1.setClip(var12);
         var1.setComposite(var15);
         if(!var18) {
            this.drawNoDataMessage(var1, var10);
         }

         if(this.isRangeCrosshairVisible()) {
            this.drawRangeCrosshair(var1, var10, this.getOrientation(), this.getRangeCrosshairValue(), this.getRangeAxis(), this.getRangeCrosshairStroke(), this.getRangeCrosshairPaint());
         }

         if(this.getRenderer() != null) {
            this.getRenderer().drawOutline(var1, this, var10);
         } else {
            this.drawOutline(var1, var10);
         }

      }
   }

   protected Map drawAxes(Graphics2D var1, Rectangle2D var2, Rectangle2D var3, PlotRenderingInfo var4) {
      AxisCollection var5 = new AxisCollection();

      int var6;
      for(var6 = 0; var6 < this.domainAxes.size(); ++var6) {
         CategoryAxis var7 = (CategoryAxis)this.domainAxes.get(var6);
         if(var7 != null) {
            var5.add(var7, this.getDomainAxisEdge(var6));
         }
      }

      for(var6 = 0; var6 < this.rangeAxes.size(); ++var6) {
         ValueAxis var13 = (ValueAxis)this.rangeAxes.get(var6);
         if(var13 != null) {
            var5.add(var13, this.getRangeAxisEdge(var6));
         }
      }

      HashMap var12 = new HashMap();
      double var14 = var3.getMinY() - this.axisOffset.calculateTopOutset(var3.getHeight());
      Iterator var9 = var5.getAxesAtTop().iterator();

      Axis var10;
      AxisState var11;
      while(var9.hasNext()) {
         var10 = (Axis)var9.next();
         if(var10 != null) {
            var11 = var10.draw(var1, var14, var2, var3, RectangleEdge.TOP, var4);
            var14 = var11.getCursor();
            var12.put(var10, var11);
         }
      }

      var14 = var3.getMaxY() + this.axisOffset.calculateBottomOutset(var3.getHeight());
      var9 = var5.getAxesAtBottom().iterator();

      while(var9.hasNext()) {
         var10 = (Axis)var9.next();
         if(var10 != null) {
            var11 = var10.draw(var1, var14, var2, var3, RectangleEdge.BOTTOM, var4);
            var14 = var11.getCursor();
            var12.put(var10, var11);
         }
      }

      var14 = var3.getMinX() - this.axisOffset.calculateLeftOutset(var3.getWidth());
      var9 = var5.getAxesAtLeft().iterator();

      while(var9.hasNext()) {
         var10 = (Axis)var9.next();
         if(var10 != null) {
            var11 = var10.draw(var1, var14, var2, var3, RectangleEdge.LEFT, var4);
            var14 = var11.getCursor();
            var12.put(var10, var11);
         }
      }

      var14 = var3.getMaxX() + this.axisOffset.calculateRightOutset(var3.getWidth());
      var9 = var5.getAxesAtRight().iterator();

      while(var9.hasNext()) {
         var10 = (Axis)var9.next();
         if(var10 != null) {
            var11 = var10.draw(var1, var14, var2, var3, RectangleEdge.RIGHT, var4);
            var14 = var11.getCursor();
            var12.put(var10, var11);
         }
      }

      return var12;
   }

   public boolean render(Graphics2D var1, Rectangle2D var2, int var3, PlotRenderingInfo var4) {
      boolean var5 = false;
      CategoryDataset var6 = this.getDataset(var3);
      CategoryItemRenderer var7 = this.getRenderer(var3);
      CategoryAxis var8 = this.getDomainAxisForDataset(var3);
      ValueAxis var9 = this.getRangeAxisForDataset(var3);
      boolean var10 = !DatasetUtilities.isEmptyOrNull(var6);
      if(var10 && var7 != null) {
         var5 = true;
         CategoryItemRendererState var11 = var7.initialise(var1, var2, this, var3, var4);
         int var12 = var6.getColumnCount();
         int var13 = var6.getRowCount();
         int var14 = var7.getPassCount();

         for(int var15 = 0; var15 < var14; ++var15) {
            int var16;
            int var17;
            if(this.columnRenderingOrder == SortOrder.ASCENDING) {
               for(var16 = 0; var16 < var12; ++var16) {
                  if(this.rowRenderingOrder == SortOrder.ASCENDING) {
                     for(var17 = 0; var17 < var13; ++var17) {
                        var7.drawItem(var1, var11, var2, this, var8, var9, var6, var17, var16, var15);
                     }
                  } else {
                     for(var17 = var13 - 1; var17 >= 0; --var17) {
                        var7.drawItem(var1, var11, var2, this, var8, var9, var6, var17, var16, var15);
                     }
                  }
               }
            } else {
               for(var16 = var12 - 1; var16 >= 0; --var16) {
                  if(this.rowRenderingOrder == SortOrder.ASCENDING) {
                     for(var17 = 0; var17 < var13; ++var17) {
                        var7.drawItem(var1, var11, var2, this, var8, var9, var6, var17, var16, var15);
                     }
                  } else {
                     for(var17 = var13 - 1; var17 >= 0; --var17) {
                        var7.drawItem(var1, var11, var2, this, var8, var9, var6, var17, var16, var15);
                     }
                  }
               }
            }
         }
      }

      return var5;
   }

   protected void drawDomainGridlines(Graphics2D var1, Rectangle2D var2) {
      if(this.isDomainGridlinesVisible()) {
         CategoryAnchor var3 = this.getDomainGridlinePosition();
         RectangleEdge var4 = this.getDomainAxisEdge();
         Stroke var5 = this.getDomainGridlineStroke();
         Paint var6 = this.getDomainGridlinePaint();
         if(var5 != null && var6 != null) {
            CategoryDataset var7 = this.getDataset();
            if(var7 != null) {
               CategoryAxis var8 = this.getDomainAxis();
               if(var8 != null) {
                  int var9 = var7.getColumnCount();

                  for(int var10 = 0; var10 < var9; ++var10) {
                     double var11 = var8.getCategoryJava2DCoordinate(var3, var10, var9, var2, var4);
                     CategoryItemRenderer var13 = this.getRenderer();
                     if(var13 != null) {
                        var13.drawDomainGridline(var1, this, var2, var11);
                     }
                  }
               }
            }
         }
      }

   }

   protected void drawRangeGridlines(Graphics2D var1, Rectangle2D var2, List var3) {
      if(this.isRangeGridlinesVisible()) {
         Stroke var4 = this.getRangeGridlineStroke();
         Paint var5 = this.getRangeGridlinePaint();
         if(var4 != null && var5 != null) {
            ValueAxis var6 = this.getRangeAxis();
            if(var6 != null) {
               Iterator var7 = var3.iterator();

               while(var7.hasNext()) {
                  ValueTick var8 = (ValueTick)var7.next();
                  CategoryItemRenderer var9 = this.getRenderer();
                  if(var9 != null) {
                     var9.drawRangeGridline(var1, this, this.getRangeAxis(), var2, var8.getValue());
                  }
               }
            }
         }
      }

   }

   protected void drawAnnotations(Graphics2D var1, Rectangle2D var2) {
      if(this.getAnnotations() != null) {
         Iterator var3 = this.getAnnotations().iterator();

         while(var3.hasNext()) {
            CategoryAnnotation var4 = (CategoryAnnotation)var3.next();
            var4.draw(var1, this, var2, this.getDomainAxis(), this.getRangeAxis());
         }
      }

   }

   protected void drawDomainMarkers(Graphics2D var1, Rectangle2D var2, int var3, Layer var4) {
      CategoryItemRenderer var5 = this.getRenderer(var3);
      if(var5 != null) {
         Collection var6 = this.getDomainMarkers(var3, var4);
         CategoryAxis var7 = this.getDomainAxisForDataset(var3);
         if(var6 != null && var7 != null) {
            Iterator var8 = var6.iterator();

            while(var8.hasNext()) {
               CategoryMarker var9 = (CategoryMarker)var8.next();
               var5.drawDomainMarker(var1, this, var7, var9, var2);
            }
         }

      }
   }

   protected void drawRangeMarkers(Graphics2D var1, Rectangle2D var2, int var3, Layer var4) {
      CategoryItemRenderer var5 = this.getRenderer(var3);
      if(var5 != null) {
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

   protected void drawRangeLine(Graphics2D var1, Rectangle2D var2, double var3, Stroke var5, Paint var6) {
      double var7 = this.getRangeAxis().valueToJava2D(var3, var2, this.getRangeAxisEdge());
      Double var9 = null;
      if(this.orientation == PlotOrientation.HORIZONTAL) {
         var9 = new Double(var7, var2.getMinY(), var7, var2.getMaxY());
      } else if(this.orientation == PlotOrientation.VERTICAL) {
         var9 = new Double(var2.getMinX(), var7, var2.getMaxX(), var7);
      }

      var1.setStroke(var5);
      var1.setPaint(var6);
      var1.draw(var9);
   }

   protected void drawRangeCrosshair(Graphics2D var1, Rectangle2D var2, PlotOrientation var3, double var4, ValueAxis var6, Stroke var7, Paint var8) {
      if(var6.getRange().contains(var4)) {
         Double var9 = null;
         double var10;
         if(var3 == PlotOrientation.HORIZONTAL) {
            var10 = var6.valueToJava2D(var4, var2, RectangleEdge.BOTTOM);
            var9 = new Double(var10, var2.getMinY(), var10, var2.getMaxY());
         } else {
            var10 = var6.valueToJava2D(var4, var2, RectangleEdge.LEFT);
            var9 = new Double(var2.getMinX(), var10, var2.getMaxX(), var10);
         }

         var1.setStroke(var7);
         var1.setPaint(var8);
         var1.draw(var9);
      }
   }

   public Range getDataRange(ValueAxis var1) {
      Range var2 = null;
      ArrayList var3 = new ArrayList();
      int var4 = this.rangeAxes.indexOf(var1);
      if(var4 >= 0) {
         var3.addAll(this.datasetsMappedToRangeAxis(var4));
      } else if(var1 == this.getRangeAxis()) {
         var3.addAll(this.datasetsMappedToRangeAxis(0));
      }

      Iterator var5 = var3.iterator();

      while(var5.hasNext()) {
         CategoryDataset var6 = (CategoryDataset)var5.next();
         CategoryItemRenderer var7 = this.getRendererForDataset(var6);
         if(var7 != null) {
            var2 = Range.combine(var2, var7.findRangeBounds(var6));
         }
      }

      return var2;
   }

   private List datasetsMappedToDomainAxis(int var1) {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < this.datasets.size(); ++var3) {
         Object var4 = this.datasets.get(var3);
         if(var4 != null) {
            Integer var5 = (Integer)this.datasetToDomainAxisMap.get(var3);
            if(var5 == null) {
               if(var1 == 0) {
                  var2.add(var4);
               }
            } else if(var5.intValue() == var1) {
               var2.add(var4);
            }
         }
      }

      return var2;
   }

   private List datasetsMappedToRangeAxis(int var1) {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < this.datasets.size(); ++var3) {
         Object var4 = this.datasets.get(var3);
         if(var4 != null) {
            Integer var5 = (Integer)this.datasetToRangeAxisMap.get(var3);
            if(var5 == null) {
               if(var1 == 0) {
                  var2.add(var4);
               }
            } else if(var5.intValue() == var1) {
               var2.add(var4);
            }
         }
      }

      return var2;
   }

   public int getWeight() {
      return this.weight;
   }

   public void setWeight(int var1) {
      this.weight = var1;
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

   public List getCategories() {
      List var1 = null;
      if(this.getDataset() != null) {
         var1 = Collections.unmodifiableList(this.getDataset().getColumnKeys());
      }

      return var1;
   }

   public List getCategoriesForAxis(CategoryAxis var1) {
      ArrayList var2 = new ArrayList();
      int var3 = this.domainAxes.indexOf(var1);
      List var4 = this.datasetsMappedToDomainAxis(var3);
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         CategoryDataset var6 = (CategoryDataset)var5.next();

         for(int var7 = 0; var7 < var6.getColumnCount(); ++var7) {
            Comparable var8 = var6.getColumnKey(var7);
            if(!var2.contains(var8)) {
               var2.add(var8);
            }
         }
      }

      return var2;
   }

   public boolean getDrawSharedDomainAxis() {
      return this.drawSharedDomainAxis;
   }

   public void setDrawSharedDomainAxis(boolean var1) {
      this.drawSharedDomainAxis = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public boolean isDomainZoomable() {
      return false;
   }

   public boolean isRangeZoomable() {
      return true;
   }

   public void zoomDomainAxes(double var1, PlotRenderingInfo var3, Point2D var4) {
   }

   public void zoomDomainAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6) {
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

   public double getAnchorValue() {
      return this.anchorValue;
   }

   public void setAnchorValue(double var1) {
      this.setAnchorValue(var1, true);
   }

   public void setAnchorValue(double var1, boolean var3) {
      this.anchorValue = var1;
      if(var3) {
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CategoryPlot)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         CategoryPlot var2 = (CategoryPlot)var1;
         return this.orientation != var2.orientation?false:(!ObjectUtilities.equal(this.axisOffset, var2.axisOffset)?false:(!this.domainAxes.equals(var2.domainAxes)?false:(!this.domainAxisLocations.equals(var2.domainAxisLocations)?false:(this.drawSharedDomainAxis != var2.drawSharedDomainAxis?false:(!this.rangeAxes.equals(var2.rangeAxes)?false:(!this.rangeAxisLocations.equals(var2.rangeAxisLocations)?false:(!ObjectUtilities.equal(this.datasetToDomainAxisMap, var2.datasetToDomainAxisMap)?false:(!ObjectUtilities.equal(this.datasetToRangeAxisMap, var2.datasetToRangeAxisMap)?false:(!ObjectUtilities.equal(this.renderers, var2.renderers)?false:(this.renderingOrder != var2.renderingOrder?false:(this.columnRenderingOrder != var2.columnRenderingOrder?false:(this.rowRenderingOrder != var2.rowRenderingOrder?false:(this.domainGridlinesVisible != var2.domainGridlinesVisible?false:(this.domainGridlinePosition != var2.domainGridlinePosition?false:(!ObjectUtilities.equal(this.domainGridlineStroke, var2.domainGridlineStroke)?false:(!PaintUtilities.equal(this.domainGridlinePaint, var2.domainGridlinePaint)?false:(this.rangeGridlinesVisible != var2.rangeGridlinesVisible?false:(!ObjectUtilities.equal(this.rangeGridlineStroke, var2.rangeGridlineStroke)?false:(!PaintUtilities.equal(this.rangeGridlinePaint, var2.rangeGridlinePaint)?false:(this.anchorValue != var2.anchorValue?false:(this.rangeCrosshairVisible != var2.rangeCrosshairVisible?false:(this.rangeCrosshairValue != var2.rangeCrosshairValue?false:(!ObjectUtilities.equal(this.rangeCrosshairStroke, var2.rangeCrosshairStroke)?false:(!PaintUtilities.equal(this.rangeCrosshairPaint, var2.rangeCrosshairPaint)?false:(this.rangeCrosshairLockedOnData != var2.rangeCrosshairLockedOnData?false:(!ObjectUtilities.equal(this.foregroundRangeMarkers, var2.foregroundRangeMarkers)?false:(!ObjectUtilities.equal(this.backgroundRangeMarkers, var2.backgroundRangeMarkers)?false:(!ObjectUtilities.equal(this.annotations, var2.annotations)?false:(this.weight != var2.weight?false:(!ObjectUtilities.equal(this.fixedDomainAxisSpace, var2.fixedDomainAxisSpace)?false:ObjectUtilities.equal(this.fixedRangeAxisSpace, var2.fixedRangeAxisSpace)))))))))))))))))))))))))))))));
      }
   }

   public Object clone() {
      CategoryPlot var1 = (CategoryPlot)super.clone();
      var1.domainAxes = new ObjectList();

      int var2;
      for(var2 = 0; var2 < this.domainAxes.size(); ++var2) {
         CategoryAxis var3 = (CategoryAxis)this.domainAxes.get(var2);
         if(var3 != null) {
            CategoryAxis var4 = (CategoryAxis)var3.clone();
            var1.setDomainAxis(var2, var4);
         }
      }

      var1.domainAxisLocations = (ObjectList)this.domainAxisLocations.clone();
      var1.rangeAxes = new ObjectList();

      for(var2 = 0; var2 < this.rangeAxes.size(); ++var2) {
         ValueAxis var5 = (ValueAxis)this.rangeAxes.get(var2);
         if(var5 != null) {
            ValueAxis var7 = (ValueAxis)var5.clone();
            var1.setRangeAxis(var2, var7);
         }
      }

      var1.rangeAxisLocations = (ObjectList)this.rangeAxisLocations.clone();
      var1.datasets = (ObjectList)this.datasets.clone();

      for(var2 = 0; var2 < var1.datasets.size(); ++var2) {
         CategoryDataset var6 = var1.getDataset(var2);
         if(var6 != null) {
            var6.addChangeListener(var1);
         }
      }

      var1.datasetToDomainAxisMap = (ObjectList)this.datasetToDomainAxisMap.clone();
      var1.datasetToRangeAxisMap = (ObjectList)this.datasetToRangeAxisMap.clone();
      var1.renderers = (ObjectList)this.renderers.clone();
      if(this.fixedDomainAxisSpace != null) {
         var1.fixedDomainAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedDomainAxisSpace);
      }

      if(this.fixedRangeAxisSpace != null) {
         var1.fixedRangeAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedRangeAxisSpace);
      }

      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeStroke(this.domainGridlineStroke, var1);
      SerialUtilities.writePaint(this.domainGridlinePaint, var1);
      SerialUtilities.writeStroke(this.rangeGridlineStroke, var1);
      SerialUtilities.writePaint(this.rangeGridlinePaint, var1);
      SerialUtilities.writeStroke(this.rangeCrosshairStroke, var1);
      SerialUtilities.writePaint(this.rangeCrosshairPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.domainGridlineStroke = SerialUtilities.readStroke(var1);
      this.domainGridlinePaint = SerialUtilities.readPaint(var1);
      this.rangeGridlineStroke = SerialUtilities.readStroke(var1);
      this.rangeGridlinePaint = SerialUtilities.readPaint(var1);
      this.rangeCrosshairStroke = SerialUtilities.readStroke(var1);
      this.rangeCrosshairPaint = SerialUtilities.readPaint(var1);

      int var2;
      for(var2 = 0; var2 < this.domainAxes.size(); ++var2) {
         CategoryAxis var3 = (CategoryAxis)this.domainAxes.get(var2);
         if(var3 != null) {
            var3.setPlot(this);
            var3.addChangeListener(this);
         }
      }

      for(var2 = 0; var2 < this.rangeAxes.size(); ++var2) {
         ValueAxis var6 = (ValueAxis)this.rangeAxes.get(var2);
         if(var6 != null) {
            var6.setPlot(this);
            var6.addChangeListener(this);
         }
      }

      var2 = this.datasets.size();

      int var7;
      for(var7 = 0; var7 < var2; ++var7) {
         Dataset var4 = (Dataset)this.datasets.get(var7);
         if(var4 != null) {
            var4.addChangeListener(this);
         }
      }

      var7 = this.renderers.size();

      for(int var8 = 0; var8 < var7; ++var8) {
         CategoryItemRenderer var5 = (CategoryItemRenderer)this.renderers.get(var8);
         if(var5 != null) {
            var5.addChangeListener(this);
         }
      }

   }

   static {
      DEFAULT_GRIDLINE_PAINT = Color.lightGray;
      DEFAULT_VALUE_LABEL_FONT = new Font("SansSerif", 0, 10);
      DEFAULT_CROSSHAIR_STROKE = DEFAULT_GRIDLINE_STROKE;
      DEFAULT_CROSSHAIR_PAINT = Color.blue;
      localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
   }
}
