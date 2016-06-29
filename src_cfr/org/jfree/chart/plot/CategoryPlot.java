/*
 * Decompiled with CFR 0_115.
 */
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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
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
import org.jfree.chart.event.AxisChangeListener;
import org.jfree.chart.event.ChartChangeEventType;
import org.jfree.chart.event.MarkerChangeListener;
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
import org.jfree.data.general.DatasetChangeListener;
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

public class CategoryPlot
extends Plot
implements Serializable,
Cloneable,
RendererChangeListener,
ValueAxisPlot,
Zoomable,
PublicCloneable {
    private static final long serialVersionUID = -3537691700434728188L;
    public static final boolean DEFAULT_DOMAIN_GRIDLINES_VISIBLE = false;
    public static final boolean DEFAULT_RANGE_GRIDLINES_VISIBLE = true;
    public static final Stroke DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5f, 0, 2, 0.0f, new float[]{2.0f, 2.0f}, 0.0f);
    public static final Paint DEFAULT_GRIDLINE_PAINT = Color.lightGray;
    public static final Font DEFAULT_VALUE_LABEL_FONT = new Font("SansSerif", 0, 10);
    public static final boolean DEFAULT_CROSSHAIR_VISIBLE = false;
    public static final Stroke DEFAULT_CROSSHAIR_STROKE = DEFAULT_GRIDLINE_STROKE;
    public static final Paint DEFAULT_CROSSHAIR_PAINT = Color.blue;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    private PlotOrientation orientation = PlotOrientation.VERTICAL;
    private RectangleInsets axisOffset;
    private ObjectList domainAxes = new ObjectList();
    private ObjectList domainAxisLocations = new ObjectList();
    private boolean drawSharedDomainAxis;
    private ObjectList rangeAxes = new ObjectList();
    private ObjectList rangeAxisLocations = new ObjectList();
    private ObjectList datasets = new ObjectList();
    private ObjectList datasetToDomainAxisMap = new ObjectList();
    private ObjectList datasetToRangeAxisMap = new ObjectList();
    private ObjectList renderers = new ObjectList();
    private DatasetRenderingOrder renderingOrder = DatasetRenderingOrder.REVERSE;
    private SortOrder columnRenderingOrder = SortOrder.ASCENDING;
    private SortOrder rowRenderingOrder = SortOrder.ASCENDING;
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
    private boolean rangeCrosshairLockedOnData = true;
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
        this(null, null, null, null);
    }

    public CategoryPlot(CategoryDataset categoryDataset, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryItemRenderer categoryItemRenderer) {
        this.datasets.set(0, categoryDataset);
        if (categoryDataset != null) {
            categoryDataset.addChangeListener(this);
        }
        this.axisOffset = RectangleInsets.ZERO_INSETS;
        this.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT, false);
        this.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT, false);
        this.renderers.set(0, categoryItemRenderer);
        if (categoryItemRenderer != null) {
            categoryItemRenderer.setPlot(this);
            categoryItemRenderer.addChangeListener(this);
        }
        this.domainAxes.set(0, categoryAxis);
        this.mapDatasetToDomainAxis(0, 0);
        if (categoryAxis != null) {
            categoryAxis.setPlot(this);
            categoryAxis.addChangeListener(this);
        }
        this.drawSharedDomainAxis = false;
        this.rangeAxes.set(0, valueAxis);
        this.mapDatasetToRangeAxis(0, 0);
        if (valueAxis != null) {
            valueAxis.setPlot(this);
            valueAxis.addChangeListener(this);
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
        ValueMarker valueMarker = new ValueMarker(0.0, new Color(0.8f, 0.8f, 0.8f, 0.5f), new BasicStroke(1.0f), new Color(0.85f, 0.85f, 0.95f, 0.5f), new BasicStroke(1.0f), 0.6f);
        this.addRangeMarker(valueMarker, Layer.BACKGROUND);
        this.anchorValue = 0.0;
        this.rangeCrosshairVisible = false;
        this.rangeCrosshairValue = 0.0;
        this.rangeCrosshairStroke = DEFAULT_CROSSHAIR_STROKE;
        this.rangeCrosshairPaint = DEFAULT_CROSSHAIR_PAINT;
        this.annotations = new ArrayList();
    }

    @Override
    public String getPlotType() {
        return localizationResources.getString("Category_Plot");
    }

    @Override
    public PlotOrientation getOrientation() {
        return this.orientation;
    }

    public void setOrientation(PlotOrientation plotOrientation) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        this.orientation = plotOrientation;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public RectangleInsets getAxisOffset() {
        return this.axisOffset;
    }

    public void setAxisOffset(RectangleInsets rectangleInsets) {
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'offset' argument.");
        }
        this.axisOffset = rectangleInsets;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public CategoryAxis getDomainAxis() {
        return this.getDomainAxis(0);
    }

    public CategoryAxis getDomainAxis(int n2) {
        Plot plot;
        CategoryAxis categoryAxis = null;
        if (n2 < this.domainAxes.size()) {
            categoryAxis = (CategoryAxis)this.domainAxes.get(n2);
            if (categoryAxis != null) return categoryAxis;
        }
        if (!((plot = this.getParent()) instanceof CategoryPlot)) return categoryAxis;
        CategoryPlot categoryPlot = (CategoryPlot)plot;
        return categoryPlot.getDomainAxis(n2);
    }

    public void setDomainAxis(CategoryAxis categoryAxis) {
        this.setDomainAxis(0, categoryAxis);
    }

    public void setDomainAxis(int n2, CategoryAxis categoryAxis) {
        this.setDomainAxis(n2, categoryAxis, true);
    }

    public void setDomainAxis(int n2, CategoryAxis categoryAxis, boolean bl2) {
        CategoryAxis categoryAxis2 = (CategoryAxis)this.domainAxes.get(n2);
        if (categoryAxis2 != null) {
            categoryAxis2.removeChangeListener(this);
        }
        if (categoryAxis != null) {
            categoryAxis.setPlot(this);
        }
        this.domainAxes.set(n2, categoryAxis);
        if (categoryAxis != null) {
            categoryAxis.configure();
            categoryAxis.addChangeListener(this);
        }
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setDomainAxes(CategoryAxis[] arrcategoryAxis) {
        int n2 = 0;
        do {
            if (n2 >= arrcategoryAxis.length) {
                this.notifyListeners(new PlotChangeEvent(this));
                return;
            }
            this.setDomainAxis(n2, arrcategoryAxis[n2], false);
            ++n2;
        } while (true);
    }

    public int getDomainAxisIndex(CategoryAxis categoryAxis) {
        return this.domainAxes.indexOf(categoryAxis);
    }

    public AxisLocation getDomainAxisLocation() {
        return this.getDomainAxisLocation(0);
    }

    public AxisLocation getDomainAxisLocation(int n2) {
        AxisLocation axisLocation = null;
        if (n2 >= this.domainAxisLocations.size()) return AxisLocation.getOpposite(this.getDomainAxisLocation(0));
        axisLocation = (AxisLocation)this.domainAxisLocations.get(n2);
        if (axisLocation != null) return axisLocation;
        return AxisLocation.getOpposite(this.getDomainAxisLocation(0));
    }

    public void setDomainAxisLocation(AxisLocation axisLocation) {
        this.setDomainAxisLocation(0, axisLocation, true);
    }

    public void setDomainAxisLocation(AxisLocation axisLocation, boolean bl2) {
        this.setDomainAxisLocation(0, axisLocation, bl2);
    }

    public void setDomainAxisLocation(int n2, AxisLocation axisLocation) {
        this.setDomainAxisLocation(n2, axisLocation, true);
    }

    public void setDomainAxisLocation(int n2, AxisLocation axisLocation, boolean bl2) {
        if (n2 == 0 && axisLocation == null) {
            throw new IllegalArgumentException("Null 'location' for index 0 not permitted.");
        }
        this.domainAxisLocations.set(n2, axisLocation);
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public RectangleEdge getDomainAxisEdge() {
        return this.getDomainAxisEdge(0);
    }

    public RectangleEdge getDomainAxisEdge(int n2) {
        RectangleEdge rectangleEdge = null;
        AxisLocation axisLocation = this.getDomainAxisLocation(n2);
        if (axisLocation == null) return RectangleEdge.opposite(this.getDomainAxisEdge(0));
        return Plot.resolveDomainAxisLocation(axisLocation, this.orientation);
    }

    public int getDomainAxisCount() {
        return this.domainAxes.size();
    }

    public void clearDomainAxes() {
        int n2 = 0;
        do {
            if (n2 >= this.domainAxes.size()) {
                this.domainAxes.clear();
                this.notifyListeners(new PlotChangeEvent(this));
                return;
            }
            CategoryAxis categoryAxis = (CategoryAxis)this.domainAxes.get(n2);
            if (categoryAxis != null) {
                categoryAxis.removeChangeListener(this);
            }
            ++n2;
        } while (true);
    }

    public void configureDomainAxes() {
        int n2 = 0;
        while (n2 < this.domainAxes.size()) {
            CategoryAxis categoryAxis = (CategoryAxis)this.domainAxes.get(n2);
            if (categoryAxis != null) {
                categoryAxis.configure();
            }
            ++n2;
        }
    }

    public ValueAxis getRangeAxis() {
        return this.getRangeAxis(0);
    }

    public ValueAxis getRangeAxis(int n2) {
        Plot plot;
        ValueAxis valueAxis = null;
        if (n2 < this.rangeAxes.size()) {
            valueAxis = (ValueAxis)this.rangeAxes.get(n2);
            if (valueAxis != null) return valueAxis;
        }
        if (!((plot = this.getParent()) instanceof CategoryPlot)) return valueAxis;
        CategoryPlot categoryPlot = (CategoryPlot)plot;
        return categoryPlot.getRangeAxis(n2);
    }

    public void setRangeAxis(ValueAxis valueAxis) {
        this.setRangeAxis(0, valueAxis);
    }

    public void setRangeAxis(int n2, ValueAxis valueAxis) {
        this.setRangeAxis(n2, valueAxis, true);
    }

    public void setRangeAxis(int n2, ValueAxis valueAxis, boolean bl2) {
        ValueAxis valueAxis2 = (ValueAxis)this.rangeAxes.get(n2);
        if (valueAxis2 != null) {
            valueAxis2.removeChangeListener(this);
        }
        if (valueAxis != null) {
            valueAxis.setPlot(this);
        }
        this.rangeAxes.set(n2, valueAxis);
        if (valueAxis != null) {
            valueAxis.configure();
            valueAxis.addChangeListener(this);
        }
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setRangeAxes(ValueAxis[] arrvalueAxis) {
        int n2 = 0;
        do {
            if (n2 >= arrvalueAxis.length) {
                this.notifyListeners(new PlotChangeEvent(this));
                return;
            }
            this.setRangeAxis(n2, arrvalueAxis[n2], false);
            ++n2;
        } while (true);
    }

    public AxisLocation getRangeAxisLocation() {
        return this.getRangeAxisLocation(0);
    }

    public AxisLocation getRangeAxisLocation(int n2) {
        AxisLocation axisLocation = null;
        if (n2 >= this.rangeAxisLocations.size()) return AxisLocation.getOpposite(this.getRangeAxisLocation(0));
        axisLocation = (AxisLocation)this.rangeAxisLocations.get(n2);
        if (axisLocation != null) return axisLocation;
        return AxisLocation.getOpposite(this.getRangeAxisLocation(0));
    }

    public void setRangeAxisLocation(AxisLocation axisLocation) {
        this.setRangeAxisLocation(axisLocation, true);
    }

    public void setRangeAxisLocation(AxisLocation axisLocation, boolean bl2) {
        this.setRangeAxisLocation(0, axisLocation, bl2);
    }

    public void setRangeAxisLocation(int n2, AxisLocation axisLocation) {
        this.setRangeAxisLocation(n2, axisLocation, true);
    }

    public void setRangeAxisLocation(int n2, AxisLocation axisLocation, boolean bl2) {
        if (n2 == 0 && axisLocation == null) {
            throw new IllegalArgumentException("Null 'location' for index 0 not permitted.");
        }
        this.rangeAxisLocations.set(n2, axisLocation);
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public RectangleEdge getRangeAxisEdge() {
        return this.getRangeAxisEdge(0);
    }

    public RectangleEdge getRangeAxisEdge(int n2) {
        AxisLocation axisLocation = this.getRangeAxisLocation(n2);
        RectangleEdge rectangleEdge = Plot.resolveRangeAxisLocation(axisLocation, this.orientation);
        if (rectangleEdge != null) return rectangleEdge;
        return RectangleEdge.opposite(this.getRangeAxisEdge(0));
    }

    public int getRangeAxisCount() {
        return this.rangeAxes.size();
    }

    public void clearRangeAxes() {
        int n2 = 0;
        do {
            if (n2 >= this.rangeAxes.size()) {
                this.rangeAxes.clear();
                this.notifyListeners(new PlotChangeEvent(this));
                return;
            }
            ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(n2);
            if (valueAxis != null) {
                valueAxis.removeChangeListener(this);
            }
            ++n2;
        } while (true);
    }

    public void configureRangeAxes() {
        int n2 = 0;
        while (n2 < this.rangeAxes.size()) {
            ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(n2);
            if (valueAxis != null) {
                valueAxis.configure();
            }
            ++n2;
        }
    }

    public CategoryDataset getDataset() {
        return this.getDataset(0);
    }

    public CategoryDataset getDataset(int n2) {
        CategoryDataset categoryDataset = null;
        if (this.datasets.size() <= n2) return categoryDataset;
        return (CategoryDataset)this.datasets.get(n2);
    }

    public void setDataset(CategoryDataset categoryDataset) {
        this.setDataset(0, categoryDataset);
    }

    public void setDataset(int n2, CategoryDataset categoryDataset) {
        CategoryDataset categoryDataset2 = (CategoryDataset)this.datasets.get(n2);
        if (categoryDataset2 != null) {
            categoryDataset2.removeChangeListener(this);
        }
        this.datasets.set(n2, categoryDataset);
        if (categoryDataset != null) {
            categoryDataset.addChangeListener(this);
        }
        DatasetChangeEvent datasetChangeEvent = new DatasetChangeEvent(this, categoryDataset);
        this.datasetChanged(datasetChangeEvent);
    }

    public int getDatasetCount() {
        return this.datasets.size();
    }

    public void mapDatasetToDomainAxis(int n2, int n3) {
        this.datasetToDomainAxisMap.set(n2, new Integer(n3));
        this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(n2)));
    }

    public CategoryAxis getDomainAxisForDataset(int n2) {
        CategoryAxis categoryAxis = this.getDomainAxis();
        Integer n3 = (Integer)this.datasetToDomainAxisMap.get(n2);
        if (n3 == null) return categoryAxis;
        return this.getDomainAxis(n3);
    }

    public void mapDatasetToRangeAxis(int n2, int n3) {
        this.datasetToRangeAxisMap.set(n2, new Integer(n3));
        this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(n2)));
    }

    public ValueAxis getRangeAxisForDataset(int n2) {
        ValueAxis valueAxis = this.getRangeAxis();
        Integer n3 = (Integer)this.datasetToRangeAxisMap.get(n2);
        if (n3 == null) return valueAxis;
        return this.getRangeAxis(n3);
    }

    public CategoryItemRenderer getRenderer() {
        return this.getRenderer(0);
    }

    public CategoryItemRenderer getRenderer(int n2) {
        CategoryItemRenderer categoryItemRenderer = null;
        if (this.renderers.size() <= n2) return categoryItemRenderer;
        return (CategoryItemRenderer)this.renderers.get(n2);
    }

    public void setRenderer(CategoryItemRenderer categoryItemRenderer) {
        this.setRenderer(0, categoryItemRenderer, true);
    }

    public void setRenderer(CategoryItemRenderer categoryItemRenderer, boolean bl2) {
        this.setRenderer(0, categoryItemRenderer, bl2);
    }

    public void setRenderer(int n2, CategoryItemRenderer categoryItemRenderer) {
        this.setRenderer(n2, categoryItemRenderer, true);
    }

    public void setRenderer(int n2, CategoryItemRenderer categoryItemRenderer, boolean bl2) {
        CategoryItemRenderer categoryItemRenderer2 = (CategoryItemRenderer)this.renderers.get(n2);
        if (categoryItemRenderer2 != null) {
            categoryItemRenderer2.removeChangeListener(this);
        }
        this.renderers.set(n2, categoryItemRenderer);
        if (categoryItemRenderer != null) {
            categoryItemRenderer.setPlot(this);
            categoryItemRenderer.addChangeListener(this);
        }
        this.configureDomainAxes();
        this.configureRangeAxes();
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setRenderers(CategoryItemRenderer[] arrcategoryItemRenderer) {
        int n2 = 0;
        do {
            if (n2 >= arrcategoryItemRenderer.length) {
                this.notifyListeners(new PlotChangeEvent(this));
                return;
            }
            this.setRenderer(n2, arrcategoryItemRenderer[n2], false);
            ++n2;
        } while (true);
    }

    public CategoryItemRenderer getRendererForDataset(CategoryDataset categoryDataset) {
        CategoryItemRenderer categoryItemRenderer = null;
        int n2 = 0;
        while (n2 < this.datasets.size()) {
            if (this.datasets.get(n2) == categoryDataset) {
                return (CategoryItemRenderer)this.renderers.get(n2);
            }
            ++n2;
        }
        return categoryItemRenderer;
    }

    public int getIndexOf(CategoryItemRenderer categoryItemRenderer) {
        return this.renderers.indexOf(categoryItemRenderer);
    }

    public DatasetRenderingOrder getDatasetRenderingOrder() {
        return this.renderingOrder;
    }

    public void setDatasetRenderingOrder(DatasetRenderingOrder datasetRenderingOrder) {
        if (datasetRenderingOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.renderingOrder = datasetRenderingOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public SortOrder getColumnRenderingOrder() {
        return this.columnRenderingOrder;
    }

    public void setColumnRenderingOrder(SortOrder sortOrder) {
        if (sortOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.columnRenderingOrder = sortOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public SortOrder getRowRenderingOrder() {
        return this.rowRenderingOrder;
    }

    public void setRowRenderingOrder(SortOrder sortOrder) {
        if (sortOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.rowRenderingOrder = sortOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isDomainGridlinesVisible() {
        return this.domainGridlinesVisible;
    }

    public void setDomainGridlinesVisible(boolean bl2) {
        if (this.domainGridlinesVisible == bl2) return;
        this.domainGridlinesVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public CategoryAnchor getDomainGridlinePosition() {
        return this.domainGridlinePosition;
    }

    public void setDomainGridlinePosition(CategoryAnchor categoryAnchor) {
        if (categoryAnchor == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        this.domainGridlinePosition = categoryAnchor;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getDomainGridlineStroke() {
        return this.domainGridlineStroke;
    }

    public void setDomainGridlineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' not permitted.");
        }
        this.domainGridlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getDomainGridlinePaint() {
        return this.domainGridlinePaint;
    }

    public void setDomainGridlinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.domainGridlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isRangeGridlinesVisible() {
        return this.rangeGridlinesVisible;
    }

    public void setRangeGridlinesVisible(boolean bl2) {
        if (this.rangeGridlinesVisible == bl2) return;
        this.rangeGridlinesVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getRangeGridlineStroke() {
        return this.rangeGridlineStroke;
    }

    public void setRangeGridlineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.rangeGridlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getRangeGridlinePaint() {
        return this.rangeGridlinePaint;
    }

    public void setRangeGridlinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.rangeGridlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public LegendItemCollection getFixedLegendItems() {
        return this.fixedLegendItems;
    }

    public void setFixedLegendItems(LegendItemCollection legendItemCollection) {
        this.fixedLegendItems = legendItemCollection;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public LegendItemCollection getLegendItems() {
        LegendItemCollection legendItemCollection = this.fixedLegendItems;
        if (legendItemCollection != null) return legendItemCollection;
        legendItemCollection = new LegendItemCollection();
        int n2 = this.datasets.size();
        int n3 = 0;
        while (n3 < n2) {
            CategoryItemRenderer categoryItemRenderer;
            CategoryDataset categoryDataset = this.getDataset(n3);
            if (categoryDataset != null && (categoryItemRenderer = this.getRenderer(n3)) != null) {
                int n4 = categoryDataset.getRowCount();
                for (int i2 = 0; i2 < n4; ++i2) {
                    LegendItem legendItem = categoryItemRenderer.getLegendItem(n3, i2);
                    if (legendItem == null) continue;
                    legendItemCollection.add(legendItem);
                }
            }
            ++n3;
        }
        return legendItemCollection;
    }

    @Override
    public void handleClick(int n2, int n3, PlotRenderingInfo plotRenderingInfo) {
        Rectangle2D rectangle2D = plotRenderingInfo.getDataArea();
        if (!rectangle2D.contains(n2, n3)) return;
        double d2 = 0.0;
        if (this.orientation == PlotOrientation.HORIZONTAL) {
            d2 = n2;
        } else if (this.orientation == PlotOrientation.VERTICAL) {
            d2 = n3;
        }
        RectangleEdge rectangleEdge = Plot.resolveRangeAxisLocation(this.getRangeAxisLocation(), this.orientation);
        double d3 = this.getRangeAxis().java2DToValue(d2, plotRenderingInfo.getDataArea(), rectangleEdge);
        this.setAnchorValue(d3);
        this.setRangeCrosshairValue(d3);
    }

    @Override
    public void zoom(double d2) {
        if (d2 > 0.0) {
            double d3 = this.getRangeAxis().getRange().getLength();
            double d4 = d3 * d2;
            this.getRangeAxis().setRange(this.anchorValue - d4 / 2.0, this.anchorValue + d4 / 2.0);
            return;
        }
        this.getRangeAxis().setAutoRange(true);
    }

    @Override
    public void datasetChanged(DatasetChangeEvent datasetChangeEvent) {
        int n2 = this.rangeAxes.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ValueAxis valueAxis = this.getRangeAxis(i2);
            if (valueAxis == null) continue;
            valueAxis.configure();
        }
        if (this.getParent() != null) {
            this.getParent().datasetChanged(datasetChangeEvent);
            return;
        }
        PlotChangeEvent plotChangeEvent = new PlotChangeEvent(this);
        plotChangeEvent.setType(ChartChangeEventType.DATASET_UPDATED);
        this.notifyListeners(plotChangeEvent);
    }

    @Override
    public void rendererChanged(RendererChangeEvent rendererChangeEvent) {
        Plot plot = this.getParent();
        if (plot != null) {
            if (!(plot instanceof RendererChangeListener)) throw new RuntimeException("The renderer has changed and I don't know what to do!");
            RendererChangeListener rendererChangeListener = (RendererChangeListener)((Object)plot);
            rendererChangeListener.rendererChanged(rendererChangeEvent);
            return;
        }
        this.configureRangeAxes();
        PlotChangeEvent plotChangeEvent = new PlotChangeEvent(this);
        this.notifyListeners(plotChangeEvent);
    }

    public void addDomainMarker(CategoryMarker categoryMarker) {
        this.addDomainMarker(categoryMarker, Layer.FOREGROUND);
    }

    public void addDomainMarker(CategoryMarker categoryMarker, Layer layer) {
        this.addDomainMarker(0, categoryMarker, layer);
    }

    public void addDomainMarker(int n2, CategoryMarker categoryMarker, Layer layer) {
        if (categoryMarker == null) {
            throw new IllegalArgumentException("Null 'marker' not permitted.");
        }
        if (layer == null) {
            throw new IllegalArgumentException("Null 'layer' not permitted.");
        }
        if (layer == Layer.FOREGROUND) {
            ArrayList<CategoryMarker> arrayList = (ArrayList<CategoryMarker>)this.foregroundDomainMarkers.get(new Integer(n2));
            if (arrayList == null) {
                arrayList = new ArrayList<CategoryMarker>();
                this.foregroundDomainMarkers.put(new Integer(n2), arrayList);
            }
            arrayList.add(categoryMarker);
        } else if (layer == Layer.BACKGROUND) {
            ArrayList<CategoryMarker> arrayList = (ArrayList<CategoryMarker>)this.backgroundDomainMarkers.get(new Integer(n2));
            if (arrayList == null) {
                arrayList = new ArrayList<CategoryMarker>();
                this.backgroundDomainMarkers.put(new Integer(n2), arrayList);
            }
            arrayList.add(categoryMarker);
        }
        categoryMarker.addChangeListener(this);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void clearDomainMarkers() {
        Set set;
        if (this.backgroundDomainMarkers != null) {
            set = this.backgroundDomainMarkers.keySet();
            for (Integer n2 : set) {
                this.clearDomainMarkers(n2);
            }
            this.backgroundDomainMarkers.clear();
        }
        if (this.foregroundDomainMarkers != null) {
            set = this.foregroundDomainMarkers.keySet();
            for (Integer n2 : set) {
                this.clearDomainMarkers(n2);
            }
            this.foregroundDomainMarkers.clear();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Collection getDomainMarkers(Layer layer) {
        return this.getDomainMarkers(0, layer);
    }

    public Collection getDomainMarkers(int n2, Layer layer) {
        Collection collection = null;
        Integer n3 = new Integer(n2);
        if (layer == Layer.FOREGROUND) {
            collection = (Collection)this.foregroundDomainMarkers.get(n3);
        } else if (layer == Layer.BACKGROUND) {
            collection = (Collection)this.backgroundDomainMarkers.get(n3);
        }
        if (collection == null) return collection;
        return Collections.unmodifiableCollection(collection);
    }

    public void clearDomainMarkers(int n2) {
        Collection collection;
        Integer n3 = new Integer(n2);
        if (this.backgroundDomainMarkers != null && (collection = (Collection)this.backgroundDomainMarkers.get(n3)) != null) {
            for (Marker marker : collection) {
                marker.removeChangeListener(this);
            }
            collection.clear();
        }
        if (this.foregroundDomainMarkers != null && (collection = (Collection)this.foregroundDomainMarkers.get(n3)) != null) {
            for (Marker marker : collection) {
                marker.removeChangeListener(this);
            }
            collection.clear();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void addRangeMarker(Marker marker) {
        this.addRangeMarker(marker, Layer.FOREGROUND);
    }

    public void addRangeMarker(Marker marker, Layer layer) {
        this.addRangeMarker(0, marker, layer);
    }

    public void addRangeMarker(int n2, Marker marker, Layer layer) {
        if (layer == Layer.FOREGROUND) {
            ArrayList<Marker> arrayList = (ArrayList<Marker>)this.foregroundRangeMarkers.get(new Integer(n2));
            if (arrayList == null) {
                arrayList = new ArrayList<Marker>();
                this.foregroundRangeMarkers.put(new Integer(n2), arrayList);
            }
            arrayList.add(marker);
        } else if (layer == Layer.BACKGROUND) {
            ArrayList<Marker> arrayList = (ArrayList<Marker>)this.backgroundRangeMarkers.get(new Integer(n2));
            if (arrayList == null) {
                arrayList = new ArrayList<Marker>();
                this.backgroundRangeMarkers.put(new Integer(n2), arrayList);
            }
            arrayList.add(marker);
        }
        marker.addChangeListener(this);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void clearRangeMarkers() {
        Set set;
        if (this.backgroundRangeMarkers != null) {
            set = this.backgroundRangeMarkers.keySet();
            for (Integer n2 : set) {
                this.clearRangeMarkers(n2);
            }
            this.backgroundRangeMarkers.clear();
        }
        if (this.foregroundRangeMarkers != null) {
            set = this.foregroundRangeMarkers.keySet();
            for (Integer n2 : set) {
                this.clearRangeMarkers(n2);
            }
            this.foregroundRangeMarkers.clear();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Collection getRangeMarkers(Layer layer) {
        return this.getRangeMarkers(0, layer);
    }

    public Collection getRangeMarkers(int n2, Layer layer) {
        Collection collection = null;
        Integer n3 = new Integer(n2);
        if (layer == Layer.FOREGROUND) {
            collection = (Collection)this.foregroundRangeMarkers.get(n3);
        } else if (layer == Layer.BACKGROUND) {
            collection = (Collection)this.backgroundRangeMarkers.get(n3);
        }
        if (collection == null) return collection;
        return Collections.unmodifiableCollection(collection);
    }

    public void clearRangeMarkers(int n2) {
        Collection collection;
        Integer n3 = new Integer(n2);
        if (this.backgroundRangeMarkers != null && (collection = (Collection)this.backgroundRangeMarkers.get(n3)) != null) {
            for (Marker marker : collection) {
                marker.removeChangeListener(this);
            }
            collection.clear();
        }
        if (this.foregroundRangeMarkers != null && (collection = (Collection)this.foregroundRangeMarkers.get(n3)) != null) {
            for (Marker marker : collection) {
                marker.removeChangeListener(this);
            }
            collection.clear();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isRangeCrosshairVisible() {
        return this.rangeCrosshairVisible;
    }

    public void setRangeCrosshairVisible(boolean bl2) {
        if (this.rangeCrosshairVisible == bl2) return;
        this.rangeCrosshairVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isRangeCrosshairLockedOnData() {
        return this.rangeCrosshairLockedOnData;
    }

    public void setRangeCrosshairLockedOnData(boolean bl2) {
        if (this.rangeCrosshairLockedOnData == bl2) return;
        this.rangeCrosshairLockedOnData = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getRangeCrosshairValue() {
        return this.rangeCrosshairValue;
    }

    public void setRangeCrosshairValue(double d2) {
        this.setRangeCrosshairValue(d2, true);
    }

    public void setRangeCrosshairValue(double d2, boolean bl2) {
        this.rangeCrosshairValue = d2;
        if (!this.isRangeCrosshairVisible()) return;
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getRangeCrosshairStroke() {
        return this.rangeCrosshairStroke;
    }

    public void setRangeCrosshairStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.rangeCrosshairStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getRangeCrosshairPaint() {
        return this.rangeCrosshairPaint;
    }

    public void setRangeCrosshairPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.rangeCrosshairPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public List getAnnotations() {
        return this.annotations;
    }

    public void addAnnotation(CategoryAnnotation categoryAnnotation) {
        if (categoryAnnotation == null) {
            throw new IllegalArgumentException("Null 'annotation' argument.");
        }
        this.annotations.add(categoryAnnotation);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean removeAnnotation(CategoryAnnotation categoryAnnotation) {
        if (categoryAnnotation == null) {
            throw new IllegalArgumentException("Null 'annotation' argument.");
        }
        boolean bl2 = this.annotations.remove(categoryAnnotation);
        if (!bl2) return bl2;
        this.notifyListeners(new PlotChangeEvent(this));
        return bl2;
    }

    public void clearAnnotations() {
        this.annotations.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }

    protected AxisSpace calculateDomainAxisSpace(Graphics2D graphics2D, Rectangle2D rectangle2D, AxisSpace axisSpace) {
        if (axisSpace == null) {
            axisSpace = new AxisSpace();
        }
        if (this.fixedDomainAxisSpace != null) {
            if (this.orientation == PlotOrientation.HORIZONTAL) {
                axisSpace.ensureAtLeast(this.fixedDomainAxisSpace.getLeft(), RectangleEdge.LEFT);
                axisSpace.ensureAtLeast(this.fixedDomainAxisSpace.getRight(), RectangleEdge.RIGHT);
                return axisSpace;
            }
            if (this.orientation != PlotOrientation.VERTICAL) return axisSpace;
            axisSpace.ensureAtLeast(this.fixedDomainAxisSpace.getTop(), RectangleEdge.TOP);
            axisSpace.ensureAtLeast(this.fixedDomainAxisSpace.getBottom(), RectangleEdge.BOTTOM);
            return axisSpace;
        }
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(this.getDomainAxisLocation(), this.orientation);
        if (this.drawSharedDomainAxis) {
            axisSpace = this.getDomainAxis().reserveSpace(graphics2D, this, rectangle2D, rectangleEdge, axisSpace);
        }
        int n2 = 0;
        while (n2 < this.domainAxes.size()) {
            Axis axis = (Axis)this.domainAxes.get(n2);
            if (axis != null) {
                RectangleEdge rectangleEdge2 = this.getDomainAxisEdge(n2);
                axisSpace = axis.reserveSpace(graphics2D, this, rectangle2D, rectangleEdge2, axisSpace);
            }
            ++n2;
        }
        return axisSpace;
    }

    protected AxisSpace calculateRangeAxisSpace(Graphics2D graphics2D, Rectangle2D rectangle2D, AxisSpace axisSpace) {
        if (axisSpace == null) {
            axisSpace = new AxisSpace();
        }
        if (this.fixedRangeAxisSpace != null) {
            if (this.orientation == PlotOrientation.HORIZONTAL) {
                axisSpace.ensureAtLeast(this.fixedRangeAxisSpace.getTop(), RectangleEdge.TOP);
                axisSpace.ensureAtLeast(this.fixedRangeAxisSpace.getBottom(), RectangleEdge.BOTTOM);
                return axisSpace;
            }
            if (this.orientation != PlotOrientation.VERTICAL) return axisSpace;
            axisSpace.ensureAtLeast(this.fixedRangeAxisSpace.getLeft(), RectangleEdge.LEFT);
            axisSpace.ensureAtLeast(this.fixedRangeAxisSpace.getRight(), RectangleEdge.RIGHT);
            return axisSpace;
        }
        int n2 = 0;
        while (n2 < this.rangeAxes.size()) {
            Axis axis = (Axis)this.rangeAxes.get(n2);
            if (axis != null) {
                RectangleEdge rectangleEdge = this.getRangeAxisEdge(n2);
                axisSpace = axis.reserveSpace(graphics2D, this, rectangle2D, rectangleEdge, axisSpace);
            }
            ++n2;
        }
        return axisSpace;
    }

    protected AxisSpace calculateAxisSpace(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        AxisSpace axisSpace = new AxisSpace();
        axisSpace = this.calculateRangeAxisSpace(graphics2D, rectangle2D, axisSpace);
        return this.calculateDomainAxisSpace(graphics2D, rectangle2D, axisSpace);
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        int n2;
        int n3;
        boolean bl2 = rectangle2D.getWidth() <= 10.0;
        if (rectangle2D.getHeight() > 10.0) return;
        boolean bl3 = true;
        boolean bl4 = bl3;
        if (bl2) return;
        if (bl4) {
            return;
        }
        if (plotRenderingInfo == null) {
            plotRenderingInfo = new PlotRenderingInfo(null);
        }
        plotRenderingInfo.setPlotArea(rectangle2D);
        RectangleInsets rectangleInsets = this.getInsets();
        rectangleInsets.trim(rectangle2D);
        AxisSpace axisSpace = this.calculateAxisSpace(graphics2D, rectangle2D);
        Rectangle2D rectangle2D2 = axisSpace.shrink(rectangle2D, null);
        this.axisOffset.trim(rectangle2D2);
        plotRenderingInfo.setDataArea(rectangle2D2);
        if (this.getRenderer() != null) {
            this.getRenderer().drawBackground(graphics2D, this, rectangle2D2);
        } else {
            this.drawBackground(graphics2D, rectangle2D2);
        }
        Map map = this.drawAxes(graphics2D, rectangle2D, rectangle2D2, plotRenderingInfo);
        Shape shape = graphics2D.getClip();
        graphics2D.clip(rectangle2D2);
        this.drawDomainGridlines(graphics2D, rectangle2D2);
        AxisState axisState = (AxisState)map.get(this.getRangeAxis());
        if (axisState == null && plotState != null) {
            axisState = (AxisState)plotState.getSharedAxisStates().get(this.getRangeAxis());
        }
        if (axisState != null) {
            this.drawRangeGridlines(graphics2D, rectangle2D2, axisState.getTicks());
        }
        for (n2 = 0; n2 < this.renderers.size(); ++n2) {
            this.drawDomainMarkers(graphics2D, rectangle2D2, n2, Layer.BACKGROUND);
        }
        for (n2 = 0; n2 < this.renderers.size(); ++n2) {
            this.drawRangeMarkers(graphics2D, rectangle2D2, n2, Layer.BACKGROUND);
        }
        n2 = 0;
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        DatasetRenderingOrder datasetRenderingOrder = this.getDatasetRenderingOrder();
        if (datasetRenderingOrder == DatasetRenderingOrder.FORWARD) {
            for (n3 = 0; n3 < this.datasets.size(); ++n3) {
                n2 = this.render(graphics2D, rectangle2D2, n3, plotRenderingInfo) || n2 != 0 ? 1 : 0;
            }
        } else {
            for (n3 = this.datasets.size() - 1; n3 >= 0; --n3) {
                n2 = this.render(graphics2D, rectangle2D2, n3, plotRenderingInfo) || n2 != 0 ? 1 : 0;
            }
        }
        for (n3 = 0; n3 < this.renderers.size(); ++n3) {
            this.drawDomainMarkers(graphics2D, rectangle2D2, n3, Layer.FOREGROUND);
        }
        for (n3 = 0; n3 < this.renderers.size(); ++n3) {
            this.drawRangeMarkers(graphics2D, rectangle2D2, n3, Layer.FOREGROUND);
        }
        this.drawAnnotations(graphics2D, rectangle2D2);
        graphics2D.setClip(shape);
        graphics2D.setComposite(composite);
        if (n2 == 0) {
            this.drawNoDataMessage(graphics2D, rectangle2D2);
        }
        if (this.isRangeCrosshairVisible()) {
            this.drawRangeCrosshair(graphics2D, rectangle2D2, this.getOrientation(), this.getRangeCrosshairValue(), this.getRangeAxis(), this.getRangeCrosshairStroke(), this.getRangeCrosshairPaint());
        }
        if (this.getRenderer() != null) {
            this.getRenderer().drawOutline(graphics2D, this, rectangle2D2);
            return;
        }
        this.drawOutline(graphics2D, rectangle2D2);
    }

    protected Map drawAxes(Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, PlotRenderingInfo plotRenderingInfo) {
        int n2;
        AxisState axisState;
        AxisCollection axisCollection = new AxisCollection();
        for (n2 = 0; n2 < this.domainAxes.size(); ++n2) {
            CategoryAxis categoryAxis = (CategoryAxis)this.domainAxes.get(n2);
            if (categoryAxis == null) continue;
            axisCollection.add(categoryAxis, this.getDomainAxisEdge(n2));
        }
        for (n2 = 0; n2 < this.rangeAxes.size(); ++n2) {
            ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(n2);
            if (valueAxis == null) continue;
            axisCollection.add(valueAxis, this.getRangeAxisEdge(n2));
        }
        HashMap<Axis, AxisState> hashMap = new HashMap<Axis, AxisState>();
        double d2 = rectangle2D2.getMinY() - this.axisOffset.calculateTopOutset(rectangle2D2.getHeight());
        for (Axis axis222 : axisCollection.getAxesAtTop()) {
            double d3;
            if (axis222 == null) continue;
            axisState = axis222.draw(graphics2D, d3, rectangle2D, rectangle2D2, RectangleEdge.TOP, plotRenderingInfo);
            d3 = axisState.getCursor();
            hashMap.put(axis222, axisState);
        }
        double d4 = rectangle2D2.getMaxY() + this.axisOffset.calculateBottomOutset(rectangle2D2.getHeight());
        for (Axis axis222 : axisCollection.getAxesAtBottom()) {
            double d5;
            if (axis222 == null) continue;
            axisState = axis222.draw(graphics2D, d5, rectangle2D, rectangle2D2, RectangleEdge.BOTTOM, plotRenderingInfo);
            d5 = axisState.getCursor();
            hashMap.put(axis222, axisState);
        }
        double d6 = rectangle2D2.getMinX() - this.axisOffset.calculateLeftOutset(rectangle2D2.getWidth());
        for (Axis axis222 : axisCollection.getAxesAtLeft()) {
            double d7;
            if (axis222 == null) continue;
            axisState = axis222.draw(graphics2D, d7, rectangle2D, rectangle2D2, RectangleEdge.LEFT, plotRenderingInfo);
            d7 = axisState.getCursor();
            hashMap.put(axis222, axisState);
        }
        double d8 = rectangle2D2.getMaxX() + this.axisOffset.calculateRightOutset(rectangle2D2.getWidth());
        Iterator iterator = axisCollection.getAxesAtRight().iterator();
        while (iterator.hasNext()) {
            Axis axis222;
            double d9;
            axis222 = (Axis)iterator.next();
            if (axis222 == null) continue;
            axisState = axis222.draw(graphics2D, d9, rectangle2D, rectangle2D2, RectangleEdge.RIGHT, plotRenderingInfo);
            d9 = axisState.getCursor();
            hashMap.put(axis222, axisState);
        }
        return hashMap;
    }

    public boolean render(Graphics2D graphics2D, Rectangle2D rectangle2D, int n2, PlotRenderingInfo plotRenderingInfo) {
        boolean bl2 = false;
        CategoryDataset categoryDataset = this.getDataset(n2);
        CategoryItemRenderer categoryItemRenderer = this.getRenderer(n2);
        CategoryAxis categoryAxis = this.getDomainAxisForDataset(n2);
        ValueAxis valueAxis = this.getRangeAxisForDataset(n2);
        if (DatasetUtilities.isEmptyOrNull(categoryDataset)) return bl2;
        boolean bl3 = true;
        boolean bl4 = bl3;
        if (!bl4) return bl2;
        if (categoryItemRenderer == null) return bl2;
        bl2 = true;
        CategoryItemRendererState categoryItemRendererState = categoryItemRenderer.initialise(graphics2D, rectangle2D, this, n2, plotRenderingInfo);
        int n3 = categoryDataset.getColumnCount();
        int n4 = categoryDataset.getRowCount();
        int n5 = categoryItemRenderer.getPassCount();
        int n6 = 0;
        while (n6 < n5) {
            int n7;
            int n8;
            if (this.columnRenderingOrder == SortOrder.ASCENDING) {
                for (n7 = 0; n7 < n3; ++n7) {
                    if (this.rowRenderingOrder == SortOrder.ASCENDING) {
                        for (n8 = 0; n8 < n4; ++n8) {
                            categoryItemRenderer.drawItem(graphics2D, categoryItemRendererState, rectangle2D, this, categoryAxis, valueAxis, categoryDataset, n8, n7, n6);
                        }
                        continue;
                    }
                    for (n8 = n4 - 1; n8 >= 0; --n8) {
                        categoryItemRenderer.drawItem(graphics2D, categoryItemRendererState, rectangle2D, this, categoryAxis, valueAxis, categoryDataset, n8, n7, n6);
                    }
                }
            } else {
                for (n7 = n3 - 1; n7 >= 0; --n7) {
                    if (this.rowRenderingOrder == SortOrder.ASCENDING) {
                        for (n8 = 0; n8 < n4; ++n8) {
                            categoryItemRenderer.drawItem(graphics2D, categoryItemRendererState, rectangle2D, this, categoryAxis, valueAxis, categoryDataset, n8, n7, n6);
                        }
                        continue;
                    }
                    for (n8 = n4 - 1; n8 >= 0; --n8) {
                        categoryItemRenderer.drawItem(graphics2D, categoryItemRendererState, rectangle2D, this, categoryAxis, valueAxis, categoryDataset, n8, n7, n6);
                    }
                }
            }
            ++n6;
        }
        return bl2;
    }

    protected void drawDomainGridlines(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        if (!this.isDomainGridlinesVisible()) return;
        CategoryAnchor categoryAnchor = this.getDomainGridlinePosition();
        RectangleEdge rectangleEdge = this.getDomainAxisEdge();
        Stroke stroke = this.getDomainGridlineStroke();
        Paint paint = this.getDomainGridlinePaint();
        if (stroke == null) return;
        if (paint == null) return;
        CategoryDataset categoryDataset = this.getDataset();
        if (categoryDataset == null) return;
        CategoryAxis categoryAxis = this.getDomainAxis();
        if (categoryAxis == null) return;
        int n2 = categoryDataset.getColumnCount();
        int n3 = 0;
        while (n3 < n2) {
            double d2 = categoryAxis.getCategoryJava2DCoordinate(categoryAnchor, n3, n2, rectangle2D, rectangleEdge);
            CategoryItemRenderer categoryItemRenderer = this.getRenderer();
            if (categoryItemRenderer != null) {
                categoryItemRenderer.drawDomainGridline(graphics2D, this, rectangle2D, d2);
            }
            ++n3;
        }
    }

    protected void drawRangeGridlines(Graphics2D graphics2D, Rectangle2D rectangle2D, List list) {
        if (!this.isRangeGridlinesVisible()) return;
        Stroke stroke = this.getRangeGridlineStroke();
        Paint paint = this.getRangeGridlinePaint();
        if (stroke == null) return;
        if (paint == null) return;
        ValueAxis valueAxis = this.getRangeAxis();
        if (valueAxis == null) return;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ValueTick valueTick = (ValueTick)iterator.next();
            CategoryItemRenderer categoryItemRenderer = this.getRenderer();
            if (categoryItemRenderer == null) continue;
            categoryItemRenderer.drawRangeGridline(graphics2D, this, this.getRangeAxis(), rectangle2D, valueTick.getValue());
        }
    }

    protected void drawAnnotations(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        if (this.getAnnotations() == null) return;
        Iterator iterator = this.getAnnotations().iterator();
        while (iterator.hasNext()) {
            CategoryAnnotation categoryAnnotation = (CategoryAnnotation)iterator.next();
            categoryAnnotation.draw(graphics2D, this, rectangle2D, this.getDomainAxis(), this.getRangeAxis());
        }
    }

    protected void drawDomainMarkers(Graphics2D graphics2D, Rectangle2D rectangle2D, int n2, Layer layer) {
        CategoryItemRenderer categoryItemRenderer = this.getRenderer(n2);
        if (categoryItemRenderer == null) {
            return;
        }
        Collection collection = this.getDomainMarkers(n2, layer);
        CategoryAxis categoryAxis = this.getDomainAxisForDataset(n2);
        if (collection == null) return;
        if (categoryAxis == null) return;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            CategoryMarker categoryMarker = (CategoryMarker)iterator.next();
            categoryItemRenderer.drawDomainMarker(graphics2D, this, categoryAxis, categoryMarker, rectangle2D);
        }
    }

    protected void drawRangeMarkers(Graphics2D graphics2D, Rectangle2D rectangle2D, int n2, Layer layer) {
        CategoryItemRenderer categoryItemRenderer = this.getRenderer(n2);
        if (categoryItemRenderer == null) {
            return;
        }
        Collection collection = this.getRangeMarkers(n2, layer);
        ValueAxis valueAxis = this.getRangeAxisForDataset(n2);
        if (collection == null) return;
        if (valueAxis == null) return;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Marker marker = (Marker)iterator.next();
            categoryItemRenderer.drawRangeMarker(graphics2D, this, valueAxis, marker, rectangle2D);
        }
    }

    protected void drawRangeLine(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2, Stroke stroke, Paint paint) {
        double d3 = this.getRangeAxis().valueToJava2D(d2, rectangle2D, this.getRangeAxisEdge());
        Line2D.Double double_ = null;
        if (this.orientation == PlotOrientation.HORIZONTAL) {
            double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
        } else if (this.orientation == PlotOrientation.VERTICAL) {
            double_ = new Line2D.Double(rectangle2D.getMinX(), d3, rectangle2D.getMaxX(), d3);
        }
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.draw(double_);
    }

    protected void drawRangeCrosshair(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotOrientation plotOrientation, double d2, ValueAxis valueAxis, Stroke stroke, Paint paint) {
        if (!valueAxis.getRange().contains(d2)) {
            return;
        }
        Line2D.Double double_ = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double d3 = valueAxis.valueToJava2D(d2, rectangle2D, RectangleEdge.BOTTOM);
            double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
        } else {
            double d4 = valueAxis.valueToJava2D(d2, rectangle2D, RectangleEdge.LEFT);
            double_ = new Line2D.Double(rectangle2D.getMinX(), d4, rectangle2D.getMaxX(), d4);
        }
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.draw(double_);
    }

    @Override
    public Range getDataRange(ValueAxis valueAxis) {
        Range range = null;
        ArrayList arrayList = new ArrayList();
        int n2 = this.rangeAxes.indexOf(valueAxis);
        if (n2 >= 0) {
            arrayList.addAll(this.datasetsMappedToRangeAxis(n2));
        } else if (valueAxis == this.getRangeAxis()) {
            arrayList.addAll(this.datasetsMappedToRangeAxis(0));
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            CategoryDataset categoryDataset = (CategoryDataset)iterator.next();
            CategoryItemRenderer categoryItemRenderer = this.getRendererForDataset(categoryDataset);
            if (categoryItemRenderer == null) continue;
            range = Range.combine(range, categoryItemRenderer.findRangeBounds(categoryDataset));
        }
        return range;
    }

    private List datasetsMappedToDomainAxis(int n2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n3 = 0;
        while (n3 < this.datasets.size()) {
            Object object = this.datasets.get(n3);
            if (object != null) {
                Integer n4 = (Integer)this.datasetToDomainAxisMap.get(n3);
                if (n4 == null) {
                    if (n2 == 0) {
                        arrayList.add(object);
                    }
                } else if (n4 == n2) {
                    arrayList.add(object);
                }
            }
            ++n3;
        }
        return arrayList;
    }

    private List datasetsMappedToRangeAxis(int n2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n3 = 0;
        while (n3 < this.datasets.size()) {
            Object object = this.datasets.get(n3);
            if (object != null) {
                Integer n4 = (Integer)this.datasetToRangeAxisMap.get(n3);
                if (n4 == null) {
                    if (n2 == 0) {
                        arrayList.add(object);
                    }
                } else if (n4 == n2) {
                    arrayList.add(object);
                }
            }
            ++n3;
        }
        return arrayList;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int n2) {
        this.weight = n2;
    }

    public AxisSpace getFixedDomainAxisSpace() {
        return this.fixedDomainAxisSpace;
    }

    public void setFixedDomainAxisSpace(AxisSpace axisSpace) {
        this.fixedDomainAxisSpace = axisSpace;
    }

    public AxisSpace getFixedRangeAxisSpace() {
        return this.fixedRangeAxisSpace;
    }

    public void setFixedRangeAxisSpace(AxisSpace axisSpace) {
        this.fixedRangeAxisSpace = axisSpace;
    }

    public List getCategories() {
        List list = null;
        if (this.getDataset() == null) return list;
        return Collections.unmodifiableList(this.getDataset().getColumnKeys());
    }

    public List getCategoriesForAxis(CategoryAxis categoryAxis) {
        ArrayList<Comparable> arrayList = new ArrayList<Comparable>();
        int n2 = this.domainAxes.indexOf(categoryAxis);
        List list = this.datasetsMappedToDomainAxis(n2);
        Iterator iterator = list.iterator();
        block0 : while (iterator.hasNext()) {
            CategoryDataset categoryDataset = (CategoryDataset)iterator.next();
            int n3 = 0;
            do {
                if (n3 >= categoryDataset.getColumnCount()) continue block0;
                Comparable comparable = categoryDataset.getColumnKey(n3);
                if (!arrayList.contains(comparable)) {
                    arrayList.add(comparable);
                }
                ++n3;
            } while (true);
            break;
        }
        return arrayList;
    }

    public boolean getDrawSharedDomainAxis() {
        return this.drawSharedDomainAxis;
    }

    public void setDrawSharedDomainAxis(boolean bl2) {
        this.drawSharedDomainAxis = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public boolean isDomainZoomable() {
        return false;
    }

    @Override
    public boolean isRangeZoomable() {
        return true;
    }

    @Override
    public void zoomDomainAxes(double d2, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
    }

    @Override
    public void zoomDomainAxes(double d2, double d3, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
    }

    @Override
    public void zoomRangeAxes(double d2, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        int n2 = 0;
        while (n2 < this.rangeAxes.size()) {
            ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(n2);
            if (valueAxis != null) {
                valueAxis.resizeRange(d2);
            }
            ++n2;
        }
    }

    @Override
    public void zoomRangeAxes(double d2, double d3, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        int n2 = 0;
        while (n2 < this.rangeAxes.size()) {
            ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(n2);
            if (valueAxis != null) {
                valueAxis.zoomRange(d2, d3);
            }
            ++n2;
        }
    }

    public double getAnchorValue() {
        return this.anchorValue;
    }

    public void setAnchorValue(double d2) {
        this.setAnchorValue(d2, true);
    }

    public void setAnchorValue(double d2, boolean bl2) {
        this.anchorValue = d2;
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CategoryPlot)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        CategoryPlot categoryPlot = (CategoryPlot)object;
        if (this.orientation != categoryPlot.orientation) {
            return false;
        }
        if (!ObjectUtilities.equal(this.axisOffset, categoryPlot.axisOffset)) {
            return false;
        }
        if (!this.domainAxes.equals(categoryPlot.domainAxes)) {
            return false;
        }
        if (!this.domainAxisLocations.equals(categoryPlot.domainAxisLocations)) {
            return false;
        }
        if (this.drawSharedDomainAxis != categoryPlot.drawSharedDomainAxis) {
            return false;
        }
        if (!this.rangeAxes.equals(categoryPlot.rangeAxes)) {
            return false;
        }
        if (!this.rangeAxisLocations.equals(categoryPlot.rangeAxisLocations)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.datasetToDomainAxisMap, categoryPlot.datasetToDomainAxisMap)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.datasetToRangeAxisMap, categoryPlot.datasetToRangeAxisMap)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.renderers, categoryPlot.renderers)) {
            return false;
        }
        if (this.renderingOrder != categoryPlot.renderingOrder) {
            return false;
        }
        if (this.columnRenderingOrder != categoryPlot.columnRenderingOrder) {
            return false;
        }
        if (this.rowRenderingOrder != categoryPlot.rowRenderingOrder) {
            return false;
        }
        if (this.domainGridlinesVisible != categoryPlot.domainGridlinesVisible) {
            return false;
        }
        if (this.domainGridlinePosition != categoryPlot.domainGridlinePosition) {
            return false;
        }
        if (!ObjectUtilities.equal(this.domainGridlineStroke, categoryPlot.domainGridlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.domainGridlinePaint, categoryPlot.domainGridlinePaint)) {
            return false;
        }
        if (this.rangeGridlinesVisible != categoryPlot.rangeGridlinesVisible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeGridlineStroke, categoryPlot.rangeGridlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.rangeGridlinePaint, categoryPlot.rangeGridlinePaint)) {
            return false;
        }
        if (this.anchorValue != categoryPlot.anchorValue) {
            return false;
        }
        if (this.rangeCrosshairVisible != categoryPlot.rangeCrosshairVisible) {
            return false;
        }
        if (this.rangeCrosshairValue != categoryPlot.rangeCrosshairValue) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeCrosshairStroke, categoryPlot.rangeCrosshairStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.rangeCrosshairPaint, categoryPlot.rangeCrosshairPaint)) {
            return false;
        }
        if (this.rangeCrosshairLockedOnData != categoryPlot.rangeCrosshairLockedOnData) {
            return false;
        }
        if (!ObjectUtilities.equal(this.foregroundRangeMarkers, categoryPlot.foregroundRangeMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundRangeMarkers, categoryPlot.backgroundRangeMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.annotations, categoryPlot.annotations)) {
            return false;
        }
        if (this.weight != categoryPlot.weight) {
            return false;
        }
        if (!ObjectUtilities.equal(this.fixedDomainAxisSpace, categoryPlot.fixedDomainAxisSpace)) {
            return false;
        }
        if (ObjectUtilities.equal(this.fixedRangeAxisSpace, categoryPlot.fixedRangeAxisSpace)) return true;
        return false;
    }

    @Override
    public Object clone() {
        Object object;
        int n2;
        CategoryPlot categoryPlot = (CategoryPlot)super.clone();
        categoryPlot.domainAxes = new ObjectList();
        for (n2 = 0; n2 < this.domainAxes.size(); ++n2) {
            object = (CategoryAxis)this.domainAxes.get(n2);
            if (object == null) continue;
            CategoryAxis categoryAxis = (CategoryAxis)object.clone();
            categoryPlot.setDomainAxis(n2, categoryAxis);
        }
        categoryPlot.domainAxisLocations = (ObjectList)this.domainAxisLocations.clone();
        categoryPlot.rangeAxes = new ObjectList();
        for (n2 = 0; n2 < this.rangeAxes.size(); ++n2) {
            object = (ValueAxis)this.rangeAxes.get(n2);
            if (object == null) continue;
            ValueAxis valueAxis = (ValueAxis)object.clone();
            categoryPlot.setRangeAxis(n2, valueAxis);
        }
        categoryPlot.rangeAxisLocations = (ObjectList)this.rangeAxisLocations.clone();
        categoryPlot.datasets = (ObjectList)this.datasets.clone();
        for (n2 = 0; n2 < categoryPlot.datasets.size(); ++n2) {
            object = categoryPlot.getDataset(n2);
            if (object == null) continue;
            object.addChangeListener(categoryPlot);
        }
        categoryPlot.datasetToDomainAxisMap = (ObjectList)this.datasetToDomainAxisMap.clone();
        categoryPlot.datasetToRangeAxisMap = (ObjectList)this.datasetToRangeAxisMap.clone();
        categoryPlot.renderers = (ObjectList)this.renderers.clone();
        if (this.fixedDomainAxisSpace != null) {
            categoryPlot.fixedDomainAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedDomainAxisSpace);
        }
        if (this.fixedRangeAxisSpace == null) return categoryPlot;
        categoryPlot.fixedRangeAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedRangeAxisSpace);
        return categoryPlot;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.domainGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.domainGridlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.rangeGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.rangeGridlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.rangeCrosshairStroke, objectOutputStream);
        SerialUtilities.writePaint(this.rangeCrosshairPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int n2;
        int n3;
        Axis axis;
        objectInputStream.defaultReadObject();
        this.domainGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.domainGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.rangeGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.rangeGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.rangeCrosshairStroke = SerialUtilities.readStroke(objectInputStream);
        this.rangeCrosshairPaint = SerialUtilities.readPaint(objectInputStream);
        for (n3 = 0; n3 < this.domainAxes.size(); ++n3) {
            axis = (CategoryAxis)this.domainAxes.get(n3);
            if (axis == null) continue;
            axis.setPlot(this);
            axis.addChangeListener(this);
        }
        for (n3 = 0; n3 < this.rangeAxes.size(); ++n3) {
            axis = (ValueAxis)this.rangeAxes.get(n3);
            if (axis == null) continue;
            axis.setPlot(this);
            axis.addChangeListener(this);
        }
        n3 = this.datasets.size();
        for (n2 = 0; n2 < n3; ++n2) {
            Dataset dataset = (Dataset)this.datasets.get(n2);
            if (dataset == null) continue;
            dataset.addChangeListener(this);
        }
        n2 = this.renderers.size();
        int n4 = 0;
        while (n4 < n2) {
            CategoryItemRenderer categoryItemRenderer = (CategoryItemRenderer)this.renderers.get(n4);
            if (categoryItemRenderer != null) {
                categoryItemRenderer.addChangeListener(this);
            }
            ++n4;
        }
    }
}

