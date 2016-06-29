/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
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
import org.jfree.chart.event.AxisChangeListener;
import org.jfree.chart.event.ChartChangeEventType;
import org.jfree.chart.event.MarkerChangeListener;
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
import org.jfree.data.general.DatasetChangeListener;
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

public class XYPlot
extends Plot
implements Serializable,
Cloneable,
RendererChangeListener,
ValueAxisPlot,
Zoomable,
PublicCloneable {
    private static final long serialVersionUID = 7044148245716569264L;
    public static final Stroke DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5f, 0, 2, 0.0f, new float[]{2.0f, 2.0f}, 0.0f);
    public static final Paint DEFAULT_GRIDLINE_PAINT = Color.lightGray;
    public static final boolean DEFAULT_CROSSHAIR_VISIBLE = false;
    public static final Stroke DEFAULT_CROSSHAIR_STROKE = DEFAULT_GRIDLINE_STROKE;
    public static final Paint DEFAULT_CROSSHAIR_PAINT = Color.blue;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    private PlotOrientation orientation = PlotOrientation.VERTICAL;
    private RectangleInsets axisOffset = RectangleInsets.ZERO_INSETS;
    private ObjectList domainAxes = new ObjectList();
    private ObjectList domainAxisLocations = new ObjectList();
    private ObjectList rangeAxes = new ObjectList();
    private ObjectList rangeAxisLocations = new ObjectList();
    private ObjectList datasets = new ObjectList();
    private ObjectList renderers = new ObjectList();
    private Map datasetToDomainAxisMap = new TreeMap();
    private Map datasetToRangeAxisMap = new TreeMap();
    private transient Point2D quadrantOrigin = new Point2D.Double(0.0, 0.0);
    private transient Paint[] quadrantPaint = new Paint[]{null, null, null, null};
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
    private boolean domainCrosshairLockedOnData = true;
    private boolean rangeCrosshairVisible;
    private double rangeCrosshairValue;
    private transient Stroke rangeCrosshairStroke;
    private transient Paint rangeCrosshairPaint;
    private boolean rangeCrosshairLockedOnData = true;
    private Map foregroundDomainMarkers = new HashMap();
    private Map backgroundDomainMarkers = new HashMap();
    private Map foregroundRangeMarkers = new HashMap();
    private Map backgroundRangeMarkers = new HashMap();
    private List annotations;
    private transient Paint domainTickBandPaint;
    private transient Paint rangeTickBandPaint;
    private AxisSpace fixedDomainAxisSpace;
    private AxisSpace fixedRangeAxisSpace;
    private DatasetRenderingOrder datasetRenderingOrder = DatasetRenderingOrder.REVERSE;
    private SeriesRenderingOrder seriesRenderingOrder = SeriesRenderingOrder.REVERSE;
    private int weight = 1;
    private LegendItemCollection fixedLegendItems;

    public XYPlot() {
        this(null, null, null, null);
    }

    public XYPlot(XYDataset xYDataset, ValueAxis valueAxis, ValueAxis valueAxis2, XYItemRenderer xYItemRenderer) {
        this.datasets.set(0, xYDataset);
        if (xYDataset != null) {
            xYDataset.addChangeListener(this);
        }
        this.renderers.set(0, xYItemRenderer);
        if (xYItemRenderer != null) {
            xYItemRenderer.setPlot(this);
            xYItemRenderer.addChangeListener(this);
        }
        this.domainAxes.set(0, valueAxis);
        this.mapDatasetToDomainAxis(0, 0);
        if (valueAxis != null) {
            valueAxis.setPlot(this);
            valueAxis.addChangeListener(this);
        }
        this.domainAxisLocations.set(0, AxisLocation.BOTTOM_OR_LEFT);
        this.rangeAxes.set(0, valueAxis2);
        this.mapDatasetToRangeAxis(0, 0);
        if (valueAxis2 != null) {
            valueAxis2.setPlot(this);
            valueAxis2.addChangeListener(this);
        }
        this.rangeAxisLocations.set(0, AxisLocation.BOTTOM_OR_LEFT);
        this.configureDomainAxes();
        this.configureRangeAxes();
        this.domainGridlinesVisible = true;
        this.domainGridlineStroke = DEFAULT_GRIDLINE_STROKE;
        this.domainGridlinePaint = DEFAULT_GRIDLINE_PAINT;
        this.domainZeroBaselineVisible = false;
        this.domainZeroBaselinePaint = Color.black;
        this.domainZeroBaselineStroke = new BasicStroke(0.5f);
        this.rangeGridlinesVisible = true;
        this.rangeGridlineStroke = DEFAULT_GRIDLINE_STROKE;
        this.rangeGridlinePaint = DEFAULT_GRIDLINE_PAINT;
        this.rangeZeroBaselineVisible = false;
        this.rangeZeroBaselinePaint = Color.black;
        this.rangeZeroBaselineStroke = new BasicStroke(0.5f);
        this.domainCrosshairVisible = false;
        this.domainCrosshairValue = 0.0;
        this.domainCrosshairStroke = DEFAULT_CROSSHAIR_STROKE;
        this.domainCrosshairPaint = DEFAULT_CROSSHAIR_PAINT;
        this.rangeCrosshairVisible = false;
        this.rangeCrosshairValue = 0.0;
        this.rangeCrosshairStroke = DEFAULT_CROSSHAIR_STROKE;
        this.rangeCrosshairPaint = DEFAULT_CROSSHAIR_PAINT;
        this.annotations = new ArrayList();
    }

    @Override
    public String getPlotType() {
        return localizationResources.getString("XY_Plot");
    }

    @Override
    public PlotOrientation getOrientation() {
        return this.orientation;
    }

    public void setOrientation(PlotOrientation plotOrientation) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        if (plotOrientation == this.orientation) return;
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

    public ValueAxis getDomainAxis() {
        return this.getDomainAxis(0);
    }

    public ValueAxis getDomainAxis(int n2) {
        Plot plot;
        ValueAxis valueAxis = null;
        if (n2 < this.domainAxes.size()) {
            valueAxis = (ValueAxis)this.domainAxes.get(n2);
            if (valueAxis != null) return valueAxis;
        }
        if (!((plot = this.getParent()) instanceof XYPlot)) return valueAxis;
        XYPlot xYPlot = (XYPlot)plot;
        return xYPlot.getDomainAxis(n2);
    }

    public void setDomainAxis(ValueAxis valueAxis) {
        this.setDomainAxis(0, valueAxis);
    }

    public void setDomainAxis(int n2, ValueAxis valueAxis) {
        this.setDomainAxis(n2, valueAxis, true);
    }

    public void setDomainAxis(int n2, ValueAxis valueAxis, boolean bl2) {
        ValueAxis valueAxis2 = this.getDomainAxis(n2);
        if (valueAxis2 != null) {
            valueAxis2.removeChangeListener(this);
        }
        if (valueAxis != null) {
            valueAxis.setPlot(this);
        }
        this.domainAxes.set(n2, valueAxis);
        if (valueAxis != null) {
            valueAxis.configure();
            valueAxis.addChangeListener(this);
        }
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setDomainAxes(ValueAxis[] arrvalueAxis) {
        int n2 = 0;
        do {
            if (n2 >= arrvalueAxis.length) {
                this.notifyListeners(new PlotChangeEvent(this));
                return;
            }
            this.setDomainAxis(n2, arrvalueAxis[n2], false);
            ++n2;
        } while (true);
    }

    public AxisLocation getDomainAxisLocation() {
        return (AxisLocation)this.domainAxisLocations.get(0);
    }

    public void setDomainAxisLocation(AxisLocation axisLocation) {
        this.setDomainAxisLocation(0, axisLocation, true);
    }

    public void setDomainAxisLocation(AxisLocation axisLocation, boolean bl2) {
        this.setDomainAxisLocation(0, axisLocation, bl2);
    }

    public RectangleEdge getDomainAxisEdge() {
        return Plot.resolveDomainAxisLocation(this.getDomainAxisLocation(), this.orientation);
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
            ValueAxis valueAxis = (ValueAxis)this.domainAxes.get(n2);
            if (valueAxis != null) {
                valueAxis.removeChangeListener(this);
            }
            ++n2;
        } while (true);
    }

    public void configureDomainAxes() {
        int n2 = 0;
        while (n2 < this.domainAxes.size()) {
            ValueAxis valueAxis = (ValueAxis)this.domainAxes.get(n2);
            if (valueAxis != null) {
                valueAxis.configure();
            }
            ++n2;
        }
    }

    public AxisLocation getDomainAxisLocation(int n2) {
        AxisLocation axisLocation = null;
        if (n2 >= this.domainAxisLocations.size()) return AxisLocation.getOpposite(this.getDomainAxisLocation());
        axisLocation = (AxisLocation)this.domainAxisLocations.get(n2);
        if (axisLocation != null) return axisLocation;
        return AxisLocation.getOpposite(this.getDomainAxisLocation());
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

    public RectangleEdge getDomainAxisEdge(int n2) {
        AxisLocation axisLocation = this.getDomainAxisLocation(n2);
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(axisLocation, this.orientation);
        if (rectangleEdge != null) return rectangleEdge;
        return RectangleEdge.opposite(this.getDomainAxisEdge());
    }

    public ValueAxis getRangeAxis() {
        return this.getRangeAxis(0);
    }

    public void setRangeAxis(ValueAxis valueAxis) {
        ValueAxis valueAxis2;
        if (valueAxis != null) {
            valueAxis.setPlot(this);
        }
        if ((valueAxis2 = this.getRangeAxis()) != null) {
            valueAxis2.removeChangeListener(this);
        }
        this.rangeAxes.set(0, valueAxis);
        if (valueAxis != null) {
            valueAxis.configure();
            valueAxis.addChangeListener(this);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public AxisLocation getRangeAxisLocation() {
        return (AxisLocation)this.rangeAxisLocations.get(0);
    }

    public void setRangeAxisLocation(AxisLocation axisLocation) {
        this.setRangeAxisLocation(0, axisLocation, true);
    }

    public void setRangeAxisLocation(AxisLocation axisLocation, boolean bl2) {
        this.setRangeAxisLocation(0, axisLocation, bl2);
    }

    public RectangleEdge getRangeAxisEdge() {
        return Plot.resolveRangeAxisLocation(this.getRangeAxisLocation(), this.orientation);
    }

    public ValueAxis getRangeAxis(int n2) {
        Plot plot;
        ValueAxis valueAxis = null;
        if (n2 < this.rangeAxes.size()) {
            valueAxis = (ValueAxis)this.rangeAxes.get(n2);
            if (valueAxis != null) return valueAxis;
        }
        if (!((plot = this.getParent()) instanceof XYPlot)) return valueAxis;
        XYPlot xYPlot = (XYPlot)plot;
        return xYPlot.getRangeAxis(n2);
    }

    public void setRangeAxis(int n2, ValueAxis valueAxis) {
        this.setRangeAxis(n2, valueAxis, true);
    }

    public void setRangeAxis(int n2, ValueAxis valueAxis, boolean bl2) {
        ValueAxis valueAxis2 = this.getRangeAxis(n2);
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

    public AxisLocation getRangeAxisLocation(int n2) {
        AxisLocation axisLocation = null;
        if (n2 >= this.rangeAxisLocations.size()) return AxisLocation.getOpposite(this.getRangeAxisLocation());
        axisLocation = (AxisLocation)this.rangeAxisLocations.get(n2);
        if (axisLocation != null) return axisLocation;
        return AxisLocation.getOpposite(this.getRangeAxisLocation());
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

    public RectangleEdge getRangeAxisEdge(int n2) {
        AxisLocation axisLocation = this.getRangeAxisLocation(n2);
        RectangleEdge rectangleEdge = Plot.resolveRangeAxisLocation(axisLocation, this.orientation);
        if (rectangleEdge != null) return rectangleEdge;
        return RectangleEdge.opposite(this.getRangeAxisEdge());
    }

    public XYDataset getDataset() {
        return this.getDataset(0);
    }

    public XYDataset getDataset(int n2) {
        XYDataset xYDataset = null;
        if (this.datasets.size() <= n2) return xYDataset;
        return (XYDataset)this.datasets.get(n2);
    }

    public void setDataset(XYDataset xYDataset) {
        this.setDataset(0, xYDataset);
    }

    public void setDataset(int n2, XYDataset xYDataset) {
        XYDataset xYDataset2 = this.getDataset(n2);
        if (xYDataset2 != null) {
            xYDataset2.removeChangeListener(this);
        }
        this.datasets.set(n2, xYDataset);
        if (xYDataset != null) {
            xYDataset.addChangeListener(this);
        }
        DatasetChangeEvent datasetChangeEvent = new DatasetChangeEvent(this, xYDataset);
        this.datasetChanged(datasetChangeEvent);
    }

    public int getDatasetCount() {
        return this.datasets.size();
    }

    public int indexOf(XYDataset xYDataset) {
        int n2 = -1;
        int n3 = 0;
        while (n3 < this.datasets.size()) {
            if (xYDataset == this.datasets.get(n3)) {
                return n3;
            }
            ++n3;
        }
        return n2;
    }

    public void mapDatasetToDomainAxis(int n2, int n3) {
        this.datasetToDomainAxisMap.put(new Integer(n2), new Integer(n3));
        this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(n2)));
    }

    public void mapDatasetToRangeAxis(int n2, int n3) {
        this.datasetToRangeAxisMap.put(new Integer(n2), new Integer(n3));
        this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(n2)));
    }

    public XYItemRenderer getRenderer() {
        return this.getRenderer(0);
    }

    public XYItemRenderer getRenderer(int n2) {
        XYItemRenderer xYItemRenderer = null;
        if (this.renderers.size() <= n2) return xYItemRenderer;
        return (XYItemRenderer)this.renderers.get(n2);
    }

    public void setRenderer(XYItemRenderer xYItemRenderer) {
        this.setRenderer(0, xYItemRenderer);
    }

    public void setRenderer(int n2, XYItemRenderer xYItemRenderer) {
        this.setRenderer(n2, xYItemRenderer, true);
    }

    public void setRenderer(int n2, XYItemRenderer xYItemRenderer, boolean bl2) {
        XYItemRenderer xYItemRenderer2 = this.getRenderer(n2);
        if (xYItemRenderer2 != null) {
            xYItemRenderer2.removeChangeListener(this);
        }
        this.renderers.set(n2, xYItemRenderer);
        if (xYItemRenderer != null) {
            xYItemRenderer.setPlot(this);
            xYItemRenderer.addChangeListener(this);
        }
        this.configureDomainAxes();
        this.configureRangeAxes();
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setRenderers(XYItemRenderer[] arrxYItemRenderer) {
        int n2 = 0;
        do {
            if (n2 >= arrxYItemRenderer.length) {
                this.notifyListeners(new PlotChangeEvent(this));
                return;
            }
            this.setRenderer(n2, arrxYItemRenderer[n2], false);
            ++n2;
        } while (true);
    }

    public DatasetRenderingOrder getDatasetRenderingOrder() {
        return this.datasetRenderingOrder;
    }

    public void setDatasetRenderingOrder(DatasetRenderingOrder datasetRenderingOrder) {
        if (datasetRenderingOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.datasetRenderingOrder = datasetRenderingOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public SeriesRenderingOrder getSeriesRenderingOrder() {
        return this.seriesRenderingOrder;
    }

    public void setSeriesRenderingOrder(SeriesRenderingOrder seriesRenderingOrder) {
        if (seriesRenderingOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.seriesRenderingOrder = seriesRenderingOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public int getIndexOf(XYItemRenderer xYItemRenderer) {
        return this.renderers.indexOf(xYItemRenderer);
    }

    public XYItemRenderer getRendererForDataset(XYDataset xYDataset) {
        XYItemRenderer xYItemRenderer = null;
        int n2 = 0;
        while (n2 < this.datasets.size()) {
            if (this.datasets.get(n2) == xYDataset) {
                xYItemRenderer = (XYItemRenderer)this.renderers.get(n2);
                if (xYItemRenderer != null) return xYItemRenderer;
                return this.getRenderer();
            }
            ++n2;
        }
        return xYItemRenderer;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int n2) {
        this.weight = n2;
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

    public Stroke getDomainGridlineStroke() {
        return this.domainGridlineStroke;
    }

    public void setDomainGridlineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
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

    public boolean isDomainZeroBaselineVisible() {
        return this.domainZeroBaselineVisible;
    }

    public void setDomainZeroBaselineVisible(boolean bl2) {
        this.domainZeroBaselineVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getDomainZeroBaselineStroke() {
        return this.domainZeroBaselineStroke;
    }

    public void setDomainZeroBaselineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.domainZeroBaselineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getDomainZeroBaselinePaint() {
        return this.domainZeroBaselinePaint;
    }

    public void setDomainZeroBaselinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.domainZeroBaselinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isRangeZeroBaselineVisible() {
        return this.rangeZeroBaselineVisible;
    }

    public void setRangeZeroBaselineVisible(boolean bl2) {
        this.rangeZeroBaselineVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getRangeZeroBaselineStroke() {
        return this.rangeZeroBaselineStroke;
    }

    public void setRangeZeroBaselineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.rangeZeroBaselineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getRangeZeroBaselinePaint() {
        return this.rangeZeroBaselinePaint;
    }

    public void setRangeZeroBaselinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.rangeZeroBaselinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getDomainTickBandPaint() {
        return this.domainTickBandPaint;
    }

    public void setDomainTickBandPaint(Paint paint) {
        this.domainTickBandPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getRangeTickBandPaint() {
        return this.rangeTickBandPaint;
    }

    public void setRangeTickBandPaint(Paint paint) {
        this.rangeTickBandPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Point2D getQuadrantOrigin() {
        return this.quadrantOrigin;
    }

    public void setQuadrantOrigin(Point2D point2D) {
        if (point2D == null) {
            throw new IllegalArgumentException("Null 'origin' argument.");
        }
        this.quadrantOrigin = point2D;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getQuadrantPaint(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("The index should be in the range 0 to 3.");
        if (n2 <= 3) return this.quadrantPaint[n2];
        throw new IllegalArgumentException("The index should be in the range 0 to 3.");
    }

    public void setQuadrantPaint(int n2, Paint paint) {
        if (n2 < 0) throw new IllegalArgumentException("The index should be in the range 0 to 3.");
        if (n2 > 3) {
            throw new IllegalArgumentException("The index should be in the range 0 to 3.");
        }
        this.quadrantPaint[n2] = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void addDomainMarker(Marker marker) {
        this.addDomainMarker(marker, Layer.FOREGROUND);
    }

    public void addDomainMarker(Marker marker, Layer layer) {
        this.addDomainMarker(0, marker, layer);
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

    public void clearDomainMarkers(int n2) {
        Collection collection;
        Integer n3 = new Integer(n2);
        if (this.backgroundDomainMarkers != null && (collection = (Collection)this.backgroundDomainMarkers.get(n3)) != null) {
            for (Marker marker : collection) {
                marker.removeChangeListener(this);
            }
            collection.clear();
        }
        if (this.foregroundRangeMarkers != null && (collection = (Collection)this.foregroundDomainMarkers.get(n3)) != null) {
            for (Marker marker : collection) {
                marker.removeChangeListener(this);
            }
            collection.clear();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void addDomainMarker(int n2, Marker marker, Layer layer) {
        if (marker == null) {
            throw new IllegalArgumentException("Null 'marker' not permitted.");
        }
        if (layer == null) {
            throw new IllegalArgumentException("Null 'layer' not permitted.");
        }
        if (layer == Layer.FOREGROUND) {
            ArrayList<Marker> arrayList = (ArrayList<Marker>)this.foregroundDomainMarkers.get(new Integer(n2));
            if (arrayList == null) {
                arrayList = new ArrayList<Marker>();
                this.foregroundDomainMarkers.put(new Integer(n2), arrayList);
            }
            arrayList.add(marker);
        } else if (layer == Layer.BACKGROUND) {
            ArrayList<Marker> arrayList = (ArrayList<Marker>)this.backgroundDomainMarkers.get(new Integer(n2));
            if (arrayList == null) {
                arrayList = new ArrayList<Marker>();
                this.backgroundDomainMarkers.put(new Integer(n2), arrayList);
            }
            arrayList.add(marker);
        }
        marker.addChangeListener(this);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void addRangeMarker(Marker marker) {
        this.addRangeMarker(marker, Layer.FOREGROUND);
    }

    public void addRangeMarker(Marker marker, Layer layer) {
        this.addRangeMarker(0, marker, layer);
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

    public void addAnnotation(XYAnnotation xYAnnotation) {
        if (xYAnnotation == null) {
            throw new IllegalArgumentException("Null 'annotation' argument.");
        }
        this.annotations.add(xYAnnotation);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean removeAnnotation(XYAnnotation xYAnnotation) {
        if (xYAnnotation == null) {
            throw new IllegalArgumentException("Null 'annotation' argument.");
        }
        boolean bl2 = this.annotations.remove(xYAnnotation);
        if (!bl2) return bl2;
        this.notifyListeners(new PlotChangeEvent(this));
        return bl2;
    }

    public List getAnnotations() {
        return new ArrayList(this.annotations);
    }

    public void clearAnnotations() {
        this.annotations.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }

    protected AxisSpace calculateAxisSpace(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        AxisSpace axisSpace = new AxisSpace();
        axisSpace = this.calculateDomainAxisSpace(graphics2D, rectangle2D, axisSpace);
        return this.calculateRangeAxisSpace(graphics2D, rectangle2D, axisSpace);
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
        int n2 = 0;
        while (n2 < this.domainAxes.size()) {
            Axis axis = (Axis)this.domainAxes.get(n2);
            if (axis != null) {
                RectangleEdge rectangleEdge = this.getDomainAxisEdge(n2);
                axisSpace = axis.reserveSpace(graphics2D, this, rectangle2D, rectangleEdge, axisSpace);
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

    /*
     * Unable to fully structure code
     */
    @Override
    public void draw(Graphics2D var1_1, Rectangle2D var2_2, Point2D var3_3, PlotState var4_4, PlotRenderingInfo var5_5) {
        var6_6 = var2_2.getWidth() <= 10.0;
        if (var2_2.getHeight() > 10.0) return;
        v0 = true;
        var7_7 = v0;
        if (var6_6 != false) return;
        if (var7_7) {
            return;
        }
        if (var5_5 != null) {
            var5_5.setPlotArea(var2_2);
        }
        var8_8 = this.getInsets();
        var8_8.trim(var2_2);
        var9_9 = this.calculateAxisSpace(var1_1, var2_2);
        var10_10 = var9_9.shrink(var2_2, null);
        this.axisOffset.trim(var10_10);
        if (var5_5 != null) {
            var5_5.setDataArea(var10_10);
        }
        this.drawBackground(var1_1, var10_10);
        var11_11 = this.drawAxes(var1_1, var2_2, var10_10, var5_5);
        var12_12 = this.getOrientation();
        if (var3_3 != null && !var10_10.contains(var3_3)) {
            var3_3 = null;
        }
        var13_13 = new CrosshairState();
        var13_13.setCrosshairDistance(Double.POSITIVE_INFINITY);
        var13_13.setAnchor(var3_3);
        var13_13.setAnchorX(Double.NaN);
        var13_13.setAnchorY(Double.NaN);
        if (var3_3 != null) {
            var14_14 = this.getDomainAxis();
            if (var14_14 != null) {
                var15_15 = var12_12 == PlotOrientation.VERTICAL ? var14_14.java2DToValue(var3_3.getX(), var10_10, this.getDomainAxisEdge()) : var14_14.java2DToValue(var3_3.getY(), var10_10, this.getDomainAxisEdge());
                var13_13.setAnchorX(var15_15);
            }
            if ((var15_16 = this.getRangeAxis()) != null) {
                var16_17 = var12_12 == PlotOrientation.VERTICAL ? var15_16.java2DToValue(var3_3.getY(), var10_10, this.getRangeAxisEdge()) : var15_16.java2DToValue(var3_3.getX(), var10_10, this.getRangeAxisEdge());
                var13_13.setAnchorY(var16_17);
            }
        }
        var13_13.setCrosshairX(this.getDomainCrosshairValue());
        var13_13.setCrosshairY(this.getRangeCrosshairValue());
        var14_14 = var1_1.getClip();
        var15_16 = var1_1.getComposite();
        var1_1.clip(var10_10);
        var1_1.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        var16_18 = (AxisState)var11_11.get(this.getDomainAxis());
        if (var16_18 == null && var4_4 != null) {
            var16_18 = (AxisState)var4_4.getSharedAxisStates().get(this.getDomainAxis());
        }
        if ((var17_19 = (AxisState)var11_11.get(this.getRangeAxis())) == null && var4_4 != null) {
            var17_19 = (AxisState)var4_4.getSharedAxisStates().get(this.getRangeAxis());
        }
        if (var16_18 != null) {
            this.drawDomainTickBands(var1_1, var10_10, var16_18.getTicks());
        }
        if (var17_19 != null) {
            this.drawRangeTickBands(var1_1, var10_10, var17_19.getTicks());
        }
        if (var16_18 != null) {
            this.drawDomainGridlines(var1_1, var10_10, var16_18.getTicks());
            this.drawZeroDomainBaseline(var1_1, var10_10);
        }
        if (var17_19 != null) {
            this.drawRangeGridlines(var1_1, var10_10, var17_19.getTicks());
            this.drawZeroRangeBaseline(var1_1, var10_10);
        }
        for (var18_20 = 0; var18_20 < this.renderers.size(); ++var18_20) {
            this.drawDomainMarkers(var1_1, var10_10, var18_20, Layer.BACKGROUND);
        }
        for (var18_20 = 0; var18_20 < this.renderers.size(); ++var18_20) {
            this.drawRangeMarkers(var1_1, var10_10, var18_20, Layer.BACKGROUND);
        }
        var18_20 = 0;
        var19_21 = this.getDatasetRenderingOrder();
        if (var19_21 != DatasetRenderingOrder.FORWARD) ** GOTO lbl74
        var20_22 = this.renderers.size();
        for (var21_23 = 0; var21_23 < var20_22; ++var21_23) {
            var22_25 = this.getRenderer(var21_23);
            if (var22_25 == null) continue;
            var23_26 /* !! */  = this.getDomainAxisForDataset(var21_23);
            var24_37 = this.getRangeAxisForDataset(var21_23);
            var22_25.drawAnnotations(var1_1, var10_10, var23_26 /* !! */ , var24_37, Layer.BACKGROUND, var5_5);
        }
        ** GOTO lbl77
lbl74: // 1 sources:
        if (var19_21 != DatasetRenderingOrder.REVERSE) ** GOTO lbl105
        var20_22 = this.renderers.size();
        ** GOTO lbl88
lbl77: // 2 sources:
        for (var21_23 = 0; var21_23 < this.getDatasetCount(); ++var21_23) {
            var18_20 = this.render(var1_1, var10_10, var21_23, var5_5, var13_13) != false || var18_20 != 0 ? 1 : 0;
        }
        for (var21_23 = 0; var21_23 < var20_22; ++var21_23) {
            var22_25 = this.getRenderer(var21_23);
            if (var22_25 == null) continue;
            var23_28 = this.getDomainAxisForDataset(var21_23);
            var24_37 = this.getRangeAxisForDataset(var21_23);
            var22_25.drawAnnotations(var1_1, var10_10, var23_28, var24_37, Layer.FOREGROUND, var5_5);
        }
        ** GOTO lbl105
lbl88: // 3 sources:
        for (var21_23 = var20_22 - 1; var21_23 >= 0; --var21_23) {
            var22_25 = this.getRenderer(var21_23);
            if (var21_23 >= this.getDatasetCount() || var22_25 == null) continue;
            var23_29 = this.getDomainAxisForDataset(var21_23);
            var24_37 = this.getRangeAxisForDataset(var21_23);
            var22_25.drawAnnotations(var1_1, var10_10, var23_29, var24_37, Layer.BACKGROUND, var5_5);
        }
        for (var21_23 = this.getDatasetCount() - 1; var21_23 >= 0; --var21_23) {
            var18_20 = this.render(var1_1, var10_10, var21_23, var5_5, var13_13) != false || var18_20 != 0 ? 1 : 0;
        }
        for (var21_23 = var20_22 - 1; var21_23 >= 0; --var21_23) {
            var22_25 = this.getRenderer(var21_23);
            if (var21_23 >= this.getDatasetCount() || var22_25 == null) continue;
            var23_31 = this.getDomainAxisForDataset(var21_23);
            var24_37 = this.getRangeAxisForDataset(var21_23);
            var22_25.drawAnnotations(var1_1, var10_10, var23_31, var24_37, Layer.FOREGROUND, var5_5);
        }
lbl105: // 3 sources:
        var20_22 = var13_13.getDomainAxisIndex();
        var21_24 = this.getDomainAxis(var20_22);
        var22_25 = this.getDomainAxisEdge(var20_22);
        if (!this.domainCrosshairLockedOnData && var3_3 != null) {
            if (var12_12 == PlotOrientation.VERTICAL) {
                var23_33 = var21_24.java2DToValue(var3_3.getX(), var10_10, (RectangleEdge)var22_25);
            } else {
                var23_34 = var21_24.java2DToValue(var3_3.getY(), var10_10, (RectangleEdge)var22_25);
            }
            var13_13.setCrosshairX((double)var23_35);
        }
        this.setDomainCrosshairValue(var13_13.getCrosshairX(), false);
        if (this.isDomainCrosshairVisible()) {
            var23_26 /* !! */  = (ValueAxis)this.getDomainCrosshairValue();
            var25_38 = this.getDomainCrosshairPaint();
            var26_39 = this.getDomainCrosshairStroke();
            this.drawDomainCrosshair(var1_1, var10_10, var12_12, (double)var23_26 /* !! */ , var21_24, var26_39, (Paint)var25_38);
        }
        var23_36 = var13_13.getRangeAxisIndex();
        var24_37 = this.getRangeAxis(var23_36);
        var25_38 = this.getRangeAxisEdge(var23_36);
        if (!this.rangeCrosshairLockedOnData && var3_3 != null) {
            var26_40 = var12_12 == PlotOrientation.VERTICAL ? var24_37.java2DToValue(var3_3.getY(), var10_10, (RectangleEdge)var25_38) : var24_37.java2DToValue(var3_3.getX(), var10_10, (RectangleEdge)var25_38);
            var13_13.setCrosshairY(var26_40);
        }
        this.setRangeCrosshairValue(var13_13.getCrosshairY(), false);
        if (this.isRangeCrosshairVisible()) {
            var26_41 = this.getRangeCrosshairValue();
            var28_43 = this.getRangeCrosshairPaint();
            var29_44 = this.getRangeCrosshairStroke();
            this.drawRangeCrosshair(var1_1, var10_10, var12_12, var26_41, var24_37, var29_44, var28_43);
        }
        if (var18_20 == 0) {
            this.drawNoDataMessage(var1_1, var10_10);
        }
        for (var26_42 = 0; var26_42 < this.renderers.size(); ++var26_42) {
            this.drawDomainMarkers(var1_1, var10_10, var26_42, Layer.FOREGROUND);
        }
        var26_42 = 0;
        do {
            if (var26_42 >= this.renderers.size()) {
                this.drawAnnotations(var1_1, var10_10, var5_5);
                var1_1.setClip((Shape)var14_14);
                var1_1.setComposite((Composite)var15_16);
                this.drawOutline(var1_1, var10_10);
                return;
            }
            this.drawRangeMarkers(var1_1, var10_10, var26_42, Layer.FOREGROUND);
            ++var26_42;
        } while (true);
    }

    @Override
    public void drawBackground(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        this.fillBackground(graphics2D, rectangle2D);
        this.drawQuadrants(graphics2D, rectangle2D);
        this.drawBackgroundImage(graphics2D, rectangle2D);
    }

    protected void drawQuadrants(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        boolean bl2 = false;
        ValueAxis valueAxis = this.getDomainAxis();
        double d2 = this.quadrantOrigin.getX();
        double d3 = valueAxis.valueToJava2D(d2, rectangle2D, this.getDomainAxisEdge());
        ValueAxis valueAxis2 = this.getRangeAxis();
        double d4 = this.quadrantOrigin.getY();
        double d5 = valueAxis2.valueToJava2D(d4, rectangle2D, this.getRangeAxisEdge());
        double d6 = valueAxis.getLowerBound();
        double d7 = valueAxis.valueToJava2D(d6, rectangle2D, this.getDomainAxisEdge());
        double d8 = valueAxis.getUpperBound();
        double d9 = valueAxis.valueToJava2D(d8, rectangle2D, this.getDomainAxisEdge());
        double d10 = valueAxis2.getLowerBound();
        double d11 = valueAxis2.valueToJava2D(d10, rectangle2D, this.getRangeAxisEdge());
        double d12 = valueAxis2.getUpperBound();
        double d13 = valueAxis2.valueToJava2D(d12, rectangle2D, this.getRangeAxisEdge());
        Rectangle2D[] arrrectangle2D = new Rectangle2D[]{null, null, null, null};
        if (this.quadrantPaint[0] != null && d2 > d6 && d4 < d12) {
            arrrectangle2D[0] = this.orientation == PlotOrientation.HORIZONTAL ? new Rectangle2D.Double(Math.min(d13, d5), Math.min(d7, d3), Math.abs(d5 - d13), Math.abs(d3 - d7)) : new Rectangle2D.Double(Math.min(d7, d3), Math.min(d13, d5), Math.abs(d3 - d7), Math.abs(d5 - d13));
            bl2 = true;
        }
        if (this.quadrantPaint[1] != null && d2 < d8 && d4 < d12) {
            arrrectangle2D[1] = this.orientation == PlotOrientation.HORIZONTAL ? new Rectangle2D.Double(Math.min(d13, d5), Math.min(d9, d3), Math.abs(d5 - d13), Math.abs(d3 - d9)) : new Rectangle2D.Double(Math.min(d3, d9), Math.min(d13, d5), Math.abs(d3 - d9), Math.abs(d5 - d13));
            bl2 = true;
        }
        if (this.quadrantPaint[2] != null && d2 > d6 && d4 > d10) {
            arrrectangle2D[2] = this.orientation == PlotOrientation.HORIZONTAL ? new Rectangle2D.Double(Math.min(d11, d5), Math.min(d7, d3), Math.abs(d5 - d11), Math.abs(d3 - d7)) : new Rectangle2D.Double(Math.min(d7, d3), Math.min(d11, d5), Math.abs(d3 - d7), Math.abs(d5 - d11));
            bl2 = true;
        }
        if (this.quadrantPaint[3] != null) {
            if (d2 < d8 && d4 > d10) {
                arrrectangle2D[3] = this.orientation == PlotOrientation.HORIZONTAL ? new Rectangle2D.Double(Math.min(d11, d5), Math.min(d9, d3), Math.abs(d5 - d11), Math.abs(d3 - d9)) : new Rectangle2D.Double(Math.min(d3, d9), Math.min(d11, d5), Math.abs(d3 - d9), Math.abs(d5 - d11));
                bl2 = true;
            }
            if (!bl2) return;
        }
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getBackgroundAlpha()));
        int n2 = 0;
        do {
            if (n2 >= 4) {
                graphics2D.setComposite(composite);
                return;
            }
            if (this.quadrantPaint[n2] != null && arrrectangle2D[n2] != null) {
                graphics2D.setPaint(this.quadrantPaint[n2]);
                graphics2D.fill(arrrectangle2D[n2]);
            }
            ++n2;
        } while (true);
    }

    public void drawDomainTickBands(Graphics2D graphics2D, Rectangle2D rectangle2D, List list) {
        Paint paint = this.getDomainTickBandPaint();
        if (paint == null) return;
        boolean bl2 = false;
        ValueAxis valueAxis = this.getDomainAxis();
        double d2 = valueAxis.getLowerBound();
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) {
                double d3 = valueAxis.getUpperBound();
                if (!bl2) return;
                this.getRenderer().fillDomainGridBand(graphics2D, this, valueAxis, rectangle2D, d2, d3);
                return;
            }
            ValueTick valueTick = (ValueTick)iterator.next();
            double d4 = valueTick.getValue();
            if (bl2) {
                this.getRenderer().fillDomainGridBand(graphics2D, this, valueAxis, rectangle2D, d2, d4);
            }
            d2 = d4;
            bl2 = !bl2;
        } while (true);
    }

    public void drawRangeTickBands(Graphics2D graphics2D, Rectangle2D rectangle2D, List list) {
        Paint paint = this.getRangeTickBandPaint();
        if (paint == null) return;
        boolean bl2 = false;
        ValueAxis valueAxis = this.getRangeAxis();
        double d2 = valueAxis.getLowerBound();
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) {
                double d3 = valueAxis.getUpperBound();
                if (!bl2) return;
                this.getRenderer().fillRangeGridBand(graphics2D, this, valueAxis, rectangle2D, d2, d3);
                return;
            }
            ValueTick valueTick = (ValueTick)iterator.next();
            double d4 = valueTick.getValue();
            if (bl2) {
                this.getRenderer().fillRangeGridBand(graphics2D, this, valueAxis, rectangle2D, d2, d4);
            }
            d2 = d4;
            bl2 = !bl2;
        } while (true);
    }

    protected Map drawAxes(Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, PlotRenderingInfo plotRenderingInfo) {
        int n2;
        AxisState axisState;
        ValueAxis valueAxis;
        AxisCollection axisCollection = new AxisCollection();
        for (n2 = 0; n2 < this.domainAxes.size(); ++n2) {
            valueAxis = (ValueAxis)this.domainAxes.get(n2);
            if (valueAxis == null) continue;
            axisCollection.add(valueAxis, this.getDomainAxisEdge(n2));
        }
        for (n2 = 0; n2 < this.rangeAxes.size(); ++n2) {
            valueAxis = (ValueAxis)this.rangeAxes.get(n2);
            if (valueAxis == null) continue;
            axisCollection.add(valueAxis, this.getRangeAxisEdge(n2));
        }
        HashMap<ValueAxis, AxisState> hashMap = new HashMap<ValueAxis, AxisState>();
        double d2 = rectangle2D2.getMinY() - this.axisOffset.calculateTopOutset(rectangle2D2.getHeight());
        for (ValueAxis valueAxis2222 : axisCollection.getAxesAtTop()) {
            axisState = valueAxis2222.draw(graphics2D, d2, rectangle2D, rectangle2D2, RectangleEdge.TOP, plotRenderingInfo);
            d2 = axisState.getCursor();
            hashMap.put(valueAxis2222, axisState);
        }
        d2 = rectangle2D2.getMaxY() + this.axisOffset.calculateBottomOutset(rectangle2D2.getHeight());
        for (ValueAxis valueAxis2222 : axisCollection.getAxesAtBottom()) {
            axisState = valueAxis2222.draw(graphics2D, d2, rectangle2D, rectangle2D2, RectangleEdge.BOTTOM, plotRenderingInfo);
            d2 = axisState.getCursor();
            hashMap.put(valueAxis2222, axisState);
        }
        d2 = rectangle2D2.getMinX() - this.axisOffset.calculateLeftOutset(rectangle2D2.getWidth());
        for (ValueAxis valueAxis2222 : axisCollection.getAxesAtLeft()) {
            axisState = valueAxis2222.draw(graphics2D, d2, rectangle2D, rectangle2D2, RectangleEdge.LEFT, plotRenderingInfo);
            d2 = axisState.getCursor();
            hashMap.put(valueAxis2222, axisState);
        }
        d2 = rectangle2D2.getMaxX() + this.axisOffset.calculateRightOutset(rectangle2D2.getWidth());
        Iterator iterator = axisCollection.getAxesAtRight().iterator();
        while (iterator.hasNext()) {
            ValueAxis valueAxis2222;
            valueAxis2222 = (ValueAxis)iterator.next();
            axisState = valueAxis2222.draw(graphics2D, d2, rectangle2D, rectangle2D2, RectangleEdge.RIGHT, plotRenderingInfo);
            d2 = axisState.getCursor();
            hashMap.put(valueAxis2222, axisState);
        }
        return hashMap;
    }

    public boolean render(Graphics2D graphics2D, Rectangle2D rectangle2D, int n2, PlotRenderingInfo plotRenderingInfo, CrosshairState crosshairState) {
        boolean bl2 = false;
        XYDataset xYDataset = this.getDataset(n2);
        if (DatasetUtilities.isEmptyOrNull(xYDataset)) return bl2;
        bl2 = true;
        ValueAxis valueAxis = this.getDomainAxisForDataset(n2);
        ValueAxis valueAxis2 = this.getRangeAxisForDataset(n2);
        XYItemRenderer xYItemRenderer = this.getRenderer(n2);
        if (xYItemRenderer == null && (xYItemRenderer = this.getRenderer()) == null) {
            return bl2;
        }
        XYItemRendererState xYItemRendererState = xYItemRenderer.initialise(graphics2D, rectangle2D, this, xYDataset, plotRenderingInfo);
        int n3 = xYItemRenderer.getPassCount();
        SeriesRenderingOrder seriesRenderingOrder = this.getSeriesRenderingOrder();
        if (seriesRenderingOrder == SeriesRenderingOrder.REVERSE) {
            int n4 = 0;
            while (n4 < n3) {
                int n5 = xYDataset.getSeriesCount();
                for (int i2 = n5 - 1; i2 >= 0; --i2) {
                    int n6 = xYDataset.getItemCount(i2);
                    for (int i3 = 0; i3 < n6; ++i3) {
                        xYItemRenderer.drawItem(graphics2D, xYItemRendererState, rectangle2D, plotRenderingInfo, this, valueAxis, valueAxis2, xYDataset, i2, i3, crosshairState, n4);
                    }
                }
                ++n4;
            }
            return bl2;
        }
        int n7 = 0;
        while (n7 < n3) {
            int n8 = xYDataset.getSeriesCount();
            for (int i4 = 0; i4 < n8; ++i4) {
                int n9 = xYDataset.getItemCount(i4);
                for (int i5 = 0; i5 < n9; ++i5) {
                    xYItemRenderer.drawItem(graphics2D, xYItemRendererState, rectangle2D, plotRenderingInfo, this, valueAxis, valueAxis2, xYDataset, i4, i5, crosshairState, n7);
                }
            }
            ++n7;
        }
        return bl2;
    }

    public ValueAxis getDomainAxisForDataset(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Index 'index' out of bounds.");
        if (n2 >= this.getDatasetCount()) {
            throw new IllegalArgumentException("Index 'index' out of bounds.");
        }
        ValueAxis valueAxis = null;
        Integer n3 = (Integer)this.datasetToDomainAxisMap.get(new Integer(n2));
        if (n3 == null) return this.getDomainAxis(0);
        return this.getDomainAxis(n3);
    }

    public ValueAxis getRangeAxisForDataset(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Index 'index' out of bounds.");
        if (n2 >= this.getDatasetCount()) {
            throw new IllegalArgumentException("Index 'index' out of bounds.");
        }
        ValueAxis valueAxis = null;
        Integer n3 = (Integer)this.datasetToRangeAxisMap.get(new Integer(n2));
        if (n3 == null) return this.getRangeAxis(0);
        return this.getRangeAxis(n3);
    }

    protected void drawDomainGridlines(Graphics2D graphics2D, Rectangle2D rectangle2D, List list) {
        if (this.getRenderer() == null) {
            return;
        }
        if (!this.isDomainGridlinesVisible()) return;
        Stroke stroke = this.getDomainGridlineStroke();
        Paint paint = this.getDomainGridlinePaint();
        if (stroke == null) return;
        if (paint == null) return;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ValueTick valueTick = (ValueTick)iterator.next();
            this.getRenderer().drawDomainGridLine(graphics2D, this, this.getDomainAxis(), rectangle2D, valueTick.getValue());
        }
    }

    protected void drawRangeGridlines(Graphics2D graphics2D, Rectangle2D rectangle2D, List list) {
        if (this.getRenderer() == null) {
            return;
        }
        if (!this.isRangeGridlinesVisible()) return;
        Stroke stroke = this.getRangeGridlineStroke();
        Paint paint = this.getRangeGridlinePaint();
        ValueAxis valueAxis = this.getRangeAxis();
        if (valueAxis == null) return;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ValueTick valueTick = (ValueTick)iterator.next();
            if (valueTick.getValue() == 0.0 && this.isRangeZeroBaselineVisible()) continue;
            this.getRenderer().drawRangeLine(graphics2D, this, this.getRangeAxis(), rectangle2D, valueTick.getValue(), paint, stroke);
        }
    }

    protected void drawZeroDomainBaseline(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        if (!this.isDomainZeroBaselineVisible()) return;
        XYItemRenderer xYItemRenderer = this.getRenderer();
        if (!(xYItemRenderer instanceof AbstractXYItemRenderer)) return;
        AbstractXYItemRenderer abstractXYItemRenderer = (AbstractXYItemRenderer)xYItemRenderer;
        abstractXYItemRenderer.drawDomainLine(graphics2D, this, this.getDomainAxis(), rectangle2D, 0.0, this.domainZeroBaselinePaint, this.domainZeroBaselineStroke);
    }

    protected void drawZeroRangeBaseline(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        if (!this.isRangeZeroBaselineVisible()) return;
        this.getRenderer().drawRangeLine(graphics2D, this, this.getRangeAxis(), rectangle2D, 0.0, this.rangeZeroBaselinePaint, this.rangeZeroBaselineStroke);
    }

    public void drawAnnotations(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo) {
        Iterator iterator = this.annotations.iterator();
        while (iterator.hasNext()) {
            XYAnnotation xYAnnotation = (XYAnnotation)iterator.next();
            ValueAxis valueAxis = this.getDomainAxis();
            ValueAxis valueAxis2 = this.getRangeAxis();
            xYAnnotation.draw(graphics2D, this, rectangle2D, valueAxis, valueAxis2, 0, plotRenderingInfo);
        }
    }

    protected void drawDomainMarkers(Graphics2D graphics2D, Rectangle2D rectangle2D, int n2, Layer layer) {
        XYItemRenderer xYItemRenderer = this.getRenderer(n2);
        if (xYItemRenderer == null) {
            return;
        }
        if (n2 >= this.getDatasetCount()) {
            return;
        }
        Collection collection = this.getDomainMarkers(n2, layer);
        ValueAxis valueAxis = this.getDomainAxisForDataset(n2);
        if (collection == null) return;
        if (valueAxis == null) return;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Marker marker = (Marker)iterator.next();
            xYItemRenderer.drawDomainMarker(graphics2D, this, valueAxis, marker, rectangle2D);
        }
    }

    protected void drawRangeMarkers(Graphics2D graphics2D, Rectangle2D rectangle2D, int n2, Layer layer) {
        XYItemRenderer xYItemRenderer = this.getRenderer(n2);
        if (xYItemRenderer == null) {
            return;
        }
        if (n2 >= this.getDatasetCount()) {
            return;
        }
        Collection collection = this.getRangeMarkers(n2, layer);
        ValueAxis valueAxis = this.getRangeAxisForDataset(n2);
        if (collection == null) return;
        if (valueAxis == null) return;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Marker marker = (Marker)iterator.next();
            xYItemRenderer.drawRangeMarker(graphics2D, this, valueAxis, marker, rectangle2D);
        }
    }

    public Collection getDomainMarkers(Layer layer) {
        return this.getDomainMarkers(0, layer);
    }

    public Collection getRangeMarkers(Layer layer) {
        return this.getRangeMarkers(0, layer);
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

    protected void drawHorizontalLine(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2, Stroke stroke, Paint paint) {
        ValueAxis valueAxis = this.getRangeAxis();
        if (this.getOrientation() == PlotOrientation.HORIZONTAL) {
            valueAxis = this.getDomainAxis();
        }
        if (!valueAxis.getRange().contains(d2)) return;
        double d3 = valueAxis.valueToJava2D(d2, rectangle2D, RectangleEdge.LEFT);
        Line2D.Double double_ = new Line2D.Double(rectangle2D.getMinX(), d3, rectangle2D.getMaxX(), d3);
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.draw(double_);
    }

    protected void drawDomainCrosshair(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotOrientation plotOrientation, double d2, ValueAxis valueAxis, Stroke stroke, Paint paint) {
        if (!valueAxis.getRange().contains(d2)) return;
        Line2D.Double double_ = null;
        if (plotOrientation == PlotOrientation.VERTICAL) {
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

    protected void drawVerticalLine(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2, Stroke stroke, Paint paint) {
        ValueAxis valueAxis = this.getDomainAxis();
        if (this.getOrientation() == PlotOrientation.HORIZONTAL) {
            valueAxis = this.getRangeAxis();
        }
        if (!valueAxis.getRange().contains(d2)) return;
        double d3 = valueAxis.valueToJava2D(d2, rectangle2D, RectangleEdge.BOTTOM);
        Line2D.Double double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.draw(double_);
    }

    protected void drawRangeCrosshair(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotOrientation plotOrientation, double d2, ValueAxis valueAxis, Stroke stroke, Paint paint) {
        if (!valueAxis.getRange().contains(d2)) return;
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
    public void handleClick(int n2, int n3, PlotRenderingInfo plotRenderingInfo) {
        ValueAxis valueAxis;
        Rectangle2D rectangle2D = plotRenderingInfo.getDataArea();
        if (!rectangle2D.contains(n2, n3)) return;
        ValueAxis valueAxis2 = this.getDomainAxis();
        if (valueAxis2 != null) {
            double d2 = valueAxis2.java2DToValue(n2, plotRenderingInfo.getDataArea(), this.getDomainAxisEdge());
            this.setDomainCrosshairValue(d2);
        }
        if ((valueAxis = this.getRangeAxis()) == null) return;
        double d3 = valueAxis.java2DToValue(n3, plotRenderingInfo.getDataArea(), this.getRangeAxisEdge());
        this.setRangeCrosshairValue(d3);
    }

    private List getDatasetsMappedToDomainAxis(Integer n2) {
        if (n2 == null) {
            throw new IllegalArgumentException("Null 'axisIndex' argument.");
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n3 = 0;
        while (n3 < this.datasets.size()) {
            Integer n4 = (Integer)this.datasetToDomainAxisMap.get(new Integer(n3));
            if (n4 == null) {
                if (n2.equals(ZERO)) {
                    arrayList.add(this.datasets.get(n3));
                }
            } else if (n4.equals(n2)) {
                arrayList.add(this.datasets.get(n3));
            }
            ++n3;
        }
        return arrayList;
    }

    private List getDatasetsMappedToRangeAxis(Integer n2) {
        if (n2 == null) {
            throw new IllegalArgumentException("Null 'axisIndex' argument.");
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n3 = 0;
        while (n3 < this.datasets.size()) {
            Integer n4 = (Integer)this.datasetToRangeAxisMap.get(new Integer(n3));
            if (n4 == null) {
                if (n2.equals(ZERO)) {
                    arrayList.add(this.datasets.get(n3));
                }
            } else if (n4.equals(n2)) {
                arrayList.add(this.datasets.get(n3));
            }
            ++n3;
        }
        return arrayList;
    }

    public int getDomainAxisIndex(ValueAxis valueAxis) {
        int n2 = this.domainAxes.indexOf(valueAxis);
        if (n2 >= 0) return n2;
        Plot plot = this.getParent();
        if (!(plot instanceof XYPlot)) return n2;
        XYPlot xYPlot = (XYPlot)plot;
        return xYPlot.getDomainAxisIndex(valueAxis);
    }

    public int getRangeAxisIndex(ValueAxis valueAxis) {
        int n2 = this.rangeAxes.indexOf(valueAxis);
        if (n2 >= 0) return n2;
        Plot plot = this.getParent();
        if (!(plot instanceof XYPlot)) return n2;
        XYPlot xYPlot = (XYPlot)plot;
        return xYPlot.getRangeAxisIndex(valueAxis);
    }

    @Override
    public Range getDataRange(ValueAxis valueAxis) {
        int n2;
        Range range = null;
        ArrayList arrayList = new ArrayList();
        boolean bl2 = true;
        int n3 = this.getDomainAxisIndex(valueAxis);
        if (n3 >= 0) {
            bl2 = true;
            arrayList.addAll(this.getDatasetsMappedToDomainAxis(new Integer(n3)));
        }
        if ((n2 = this.getRangeAxisIndex(valueAxis)) >= 0) {
            bl2 = false;
            arrayList.addAll(this.getDatasetsMappedToRangeAxis(new Integer(n2)));
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            XYDataset xYDataset = (XYDataset)iterator.next();
            if (xYDataset == null) continue;
            XYItemRenderer xYItemRenderer = this.getRendererForDataset(xYDataset);
            if (bl2) {
                if (xYItemRenderer != null) {
                    range = Range.combine(range, xYItemRenderer.findDomainBounds(xYDataset));
                    continue;
                }
                range = Range.combine(range, DatasetUtilities.findDomainBounds(xYDataset));
                continue;
            }
            if (xYItemRenderer != null) {
                range = Range.combine(range, xYItemRenderer.findRangeBounds(xYDataset));
                continue;
            }
            range = Range.combine(range, DatasetUtilities.findRangeBounds(xYDataset));
        }
        return range;
    }

    @Override
    public void datasetChanged(DatasetChangeEvent datasetChangeEvent) {
        this.configureDomainAxes();
        this.configureRangeAxes();
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
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isDomainCrosshairVisible() {
        return this.domainCrosshairVisible;
    }

    public void setDomainCrosshairVisible(boolean bl2) {
        if (this.domainCrosshairVisible == bl2) return;
        this.domainCrosshairVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isDomainCrosshairLockedOnData() {
        return this.domainCrosshairLockedOnData;
    }

    public void setDomainCrosshairLockedOnData(boolean bl2) {
        if (this.domainCrosshairLockedOnData == bl2) return;
        this.domainCrosshairLockedOnData = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getDomainCrosshairValue() {
        return this.domainCrosshairValue;
    }

    public void setDomainCrosshairValue(double d2) {
        this.setDomainCrosshairValue(d2, true);
    }

    public void setDomainCrosshairValue(double d2, boolean bl2) {
        this.domainCrosshairValue = d2;
        if (!this.isDomainCrosshairVisible()) return;
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getDomainCrosshairStroke() {
        return this.domainCrosshairStroke;
    }

    public void setDomainCrosshairStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.domainCrosshairStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getDomainCrosshairPaint() {
        return this.domainCrosshairPaint;
    }

    public void setDomainCrosshairPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.domainCrosshairPaint = paint;
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

    @Override
    public void zoomDomainAxes(double d2, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        int n2 = 0;
        while (n2 < this.domainAxes.size()) {
            ValueAxis valueAxis = (ValueAxis)this.domainAxes.get(n2);
            if (valueAxis != null) {
                valueAxis.resizeRange(d2);
            }
            ++n2;
        }
    }

    @Override
    public void zoomDomainAxes(double d2, double d3, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        int n2 = 0;
        while (n2 < this.domainAxes.size()) {
            ValueAxis valueAxis = (ValueAxis)this.domainAxes.get(n2);
            if (valueAxis != null) {
                valueAxis.zoomRange(d2, d3);
            }
            ++n2;
        }
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

    @Override
    public boolean isDomainZoomable() {
        return true;
    }

    @Override
    public boolean isRangeZoomable() {
        return true;
    }

    public int getSeriesCount() {
        int n2 = 0;
        XYDataset xYDataset = this.getDataset();
        if (xYDataset == null) return n2;
        return xYDataset.getSeriesCount();
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
        if (this.fixedLegendItems != null) {
            return this.fixedLegendItems;
        }
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        int n2 = this.datasets.size();
        int n3 = 0;
        while (n3 < n2) {
            XYDataset xYDataset = this.getDataset(n3);
            if (xYDataset != null) {
                XYItemRenderer xYItemRenderer = this.getRenderer(n3);
                if (xYItemRenderer == null) {
                    xYItemRenderer = this.getRenderer(0);
                }
                if (xYItemRenderer != null) {
                    int n4 = xYDataset.getSeriesCount();
                    for (int i2 = 0; i2 < n4; ++i2) {
                        LegendItem legendItem;
                        if (!xYItemRenderer.isSeriesVisible(i2) || !xYItemRenderer.isSeriesVisibleInLegend(i2) || (legendItem = xYItemRenderer.getLegendItem(n3, i2)) == null) continue;
                        legendItemCollection.add(legendItem);
                    }
                }
            }
            ++n3;
        }
        return legendItemCollection;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYPlot)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        XYPlot xYPlot = (XYPlot)object;
        if (this.weight != xYPlot.weight) {
            return false;
        }
        if (this.orientation != xYPlot.orientation) {
            return false;
        }
        if (!this.domainAxes.equals(xYPlot.domainAxes)) {
            return false;
        }
        if (!this.domainAxisLocations.equals(xYPlot.domainAxisLocations)) {
            return false;
        }
        if (this.rangeCrosshairLockedOnData != xYPlot.rangeCrosshairLockedOnData) {
            return false;
        }
        if (this.domainGridlinesVisible != xYPlot.domainGridlinesVisible) {
            return false;
        }
        if (this.rangeGridlinesVisible != xYPlot.rangeGridlinesVisible) {
            return false;
        }
        if (this.domainZeroBaselineVisible != xYPlot.domainZeroBaselineVisible) {
            return false;
        }
        if (this.rangeZeroBaselineVisible != xYPlot.rangeZeroBaselineVisible) {
            return false;
        }
        if (this.domainCrosshairVisible != xYPlot.domainCrosshairVisible) {
            return false;
        }
        if (this.domainCrosshairValue != xYPlot.domainCrosshairValue) {
            return false;
        }
        if (this.domainCrosshairLockedOnData != xYPlot.domainCrosshairLockedOnData) {
            return false;
        }
        if (this.rangeCrosshairVisible != xYPlot.rangeCrosshairVisible) {
            return false;
        }
        if (this.rangeCrosshairValue != xYPlot.rangeCrosshairValue) {
            return false;
        }
        if (!ObjectUtilities.equal(this.axisOffset, xYPlot.axisOffset)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.renderers, xYPlot.renderers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeAxes, xYPlot.rangeAxes)) {
            return false;
        }
        if (!this.rangeAxisLocations.equals(xYPlot.rangeAxisLocations)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.datasetToDomainAxisMap, xYPlot.datasetToDomainAxisMap)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.datasetToRangeAxisMap, xYPlot.datasetToRangeAxisMap)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.domainGridlineStroke, xYPlot.domainGridlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.domainGridlinePaint, xYPlot.domainGridlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeGridlineStroke, xYPlot.rangeGridlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.rangeGridlinePaint, xYPlot.rangeGridlinePaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.domainZeroBaselinePaint, xYPlot.domainZeroBaselinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.domainZeroBaselineStroke, xYPlot.domainZeroBaselineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.rangeZeroBaselinePaint, xYPlot.rangeZeroBaselinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeZeroBaselineStroke, xYPlot.rangeZeroBaselineStroke)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.domainCrosshairStroke, xYPlot.domainCrosshairStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.domainCrosshairPaint, xYPlot.domainCrosshairPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeCrosshairStroke, xYPlot.rangeCrosshairStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.rangeCrosshairPaint, xYPlot.rangeCrosshairPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.foregroundDomainMarkers, xYPlot.foregroundDomainMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundDomainMarkers, xYPlot.backgroundDomainMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.foregroundRangeMarkers, xYPlot.foregroundRangeMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundRangeMarkers, xYPlot.backgroundRangeMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.foregroundDomainMarkers, xYPlot.foregroundDomainMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundDomainMarkers, xYPlot.backgroundDomainMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.foregroundRangeMarkers, xYPlot.foregroundRangeMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundRangeMarkers, xYPlot.backgroundRangeMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.annotations, xYPlot.annotations)) {
            return false;
        }
        if (!this.quadrantOrigin.equals(xYPlot.quadrantOrigin)) {
            return false;
        }
        int n2 = 0;
        while (n2 < 4) {
            if (!PaintUtilities.equal(this.quadrantPaint[n2], xYPlot.quadrantPaint[n2])) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    @Override
    public Object clone() {
        int n2;
        PublicCloneable publicCloneable;
        Object object;
        XYPlot xYPlot = (XYPlot)super.clone();
        xYPlot.domainAxes = (ObjectList)ObjectUtilities.clone(this.domainAxes);
        for (n2 = 0; n2 < this.domainAxes.size(); ++n2) {
            object = (ValueAxis)this.domainAxes.get(n2);
            if (object == null) continue;
            publicCloneable = (ValueAxis)object.clone();
            xYPlot.domainAxes.set(n2, publicCloneable);
            publicCloneable.setPlot(xYPlot);
            publicCloneable.addChangeListener(xYPlot);
        }
        xYPlot.domainAxisLocations = (ObjectList)this.domainAxisLocations.clone();
        xYPlot.rangeAxes = (ObjectList)ObjectUtilities.clone(this.rangeAxes);
        for (n2 = 0; n2 < this.rangeAxes.size(); ++n2) {
            object = (ValueAxis)this.rangeAxes.get(n2);
            if (object == null) continue;
            publicCloneable = (ValueAxis)object.clone();
            xYPlot.rangeAxes.set(n2, publicCloneable);
            publicCloneable.setPlot(xYPlot);
            publicCloneable.addChangeListener(xYPlot);
        }
        xYPlot.rangeAxisLocations = (ObjectList)ObjectUtilities.clone(this.rangeAxisLocations);
        xYPlot.datasets = (ObjectList)ObjectUtilities.clone(this.datasets);
        for (n2 = 0; n2 < xYPlot.datasets.size(); ++n2) {
            object = this.getDataset(n2);
            if (object == null) continue;
            object.addChangeListener(xYPlot);
        }
        xYPlot.datasetToDomainAxisMap = new TreeMap();
        xYPlot.datasetToDomainAxisMap.putAll(this.datasetToDomainAxisMap);
        xYPlot.datasetToRangeAxisMap = new TreeMap();
        xYPlot.datasetToRangeAxisMap.putAll(this.datasetToRangeAxisMap);
        xYPlot.renderers = (ObjectList)ObjectUtilities.clone(this.renderers);
        for (n2 = 0; n2 < this.renderers.size(); ++n2) {
            object = (XYItemRenderer)this.renderers.get(n2);
            if (!(object instanceof PublicCloneable)) continue;
            publicCloneable = (PublicCloneable)object;
            xYPlot.renderers.set(n2, publicCloneable.clone());
        }
        xYPlot.foregroundDomainMarkers = (Map)ObjectUtilities.clone(this.foregroundDomainMarkers);
        xYPlot.backgroundDomainMarkers = (Map)ObjectUtilities.clone(this.backgroundDomainMarkers);
        xYPlot.foregroundRangeMarkers = (Map)ObjectUtilities.clone(this.foregroundRangeMarkers);
        xYPlot.backgroundRangeMarkers = (Map)ObjectUtilities.clone(this.backgroundRangeMarkers);
        xYPlot.annotations = (List)ObjectUtilities.deepClone(this.annotations);
        if (this.fixedDomainAxisSpace != null) {
            xYPlot.fixedDomainAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedDomainAxisSpace);
        }
        if (this.fixedRangeAxisSpace != null) {
            xYPlot.fixedRangeAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedRangeAxisSpace);
        }
        xYPlot.quadrantOrigin = (Point2D)ObjectUtilities.clone(this.quadrantOrigin);
        xYPlot.quadrantPaint = (Paint[])this.quadrantPaint.clone();
        return xYPlot;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.domainGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.domainGridlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.rangeGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.rangeGridlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.rangeZeroBaselineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.rangeZeroBaselinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.domainCrosshairStroke, objectOutputStream);
        SerialUtilities.writePaint(this.domainCrosshairPaint, objectOutputStream);
        SerialUtilities.writeStroke(this.rangeCrosshairStroke, objectOutputStream);
        SerialUtilities.writePaint(this.rangeCrosshairPaint, objectOutputStream);
        SerialUtilities.writePaint(this.domainTickBandPaint, objectOutputStream);
        SerialUtilities.writePaint(this.rangeTickBandPaint, objectOutputStream);
        SerialUtilities.writePoint2D(this.quadrantOrigin, objectOutputStream);
        int n2 = 0;
        do {
            if (n2 >= 4) {
                SerialUtilities.writeStroke(this.domainZeroBaselineStroke, objectOutputStream);
                SerialUtilities.writePaint(this.domainZeroBaselinePaint, objectOutputStream);
                return;
            }
            SerialUtilities.writePaint(this.quadrantPaint[n2], objectOutputStream);
            ++n2;
        } while (true);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int n2;
        int n3;
        int n4;
        int n5;
        objectInputStream.defaultReadObject();
        this.domainGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.domainGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.rangeGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.rangeGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.rangeZeroBaselineStroke = SerialUtilities.readStroke(objectInputStream);
        this.rangeZeroBaselinePaint = SerialUtilities.readPaint(objectInputStream);
        this.domainCrosshairStroke = SerialUtilities.readStroke(objectInputStream);
        this.domainCrosshairPaint = SerialUtilities.readPaint(objectInputStream);
        this.rangeCrosshairStroke = SerialUtilities.readStroke(objectInputStream);
        this.rangeCrosshairPaint = SerialUtilities.readPaint(objectInputStream);
        this.domainTickBandPaint = SerialUtilities.readPaint(objectInputStream);
        this.rangeTickBandPaint = SerialUtilities.readPaint(objectInputStream);
        this.quadrantOrigin = SerialUtilities.readPoint2D(objectInputStream);
        this.quadrantPaint = new Paint[4];
        for (n2 = 0; n2 < 4; ++n2) {
            this.quadrantPaint[n2] = SerialUtilities.readPaint(objectInputStream);
        }
        this.domainZeroBaselineStroke = SerialUtilities.readStroke(objectInputStream);
        this.domainZeroBaselinePaint = SerialUtilities.readPaint(objectInputStream);
        n2 = this.domainAxes.size();
        for (n5 = 0; n5 < n2; ++n5) {
            Axis axis = (Axis)this.domainAxes.get(n5);
            if (axis == null) continue;
            axis.setPlot(this);
            axis.addChangeListener(this);
        }
        n5 = this.rangeAxes.size();
        for (n3 = 0; n3 < n5; ++n3) {
            Axis axis = (Axis)this.rangeAxes.get(n3);
            if (axis == null) continue;
            axis.setPlot(this);
            axis.addChangeListener(this);
        }
        n3 = this.datasets.size();
        for (n4 = 0; n4 < n3; ++n4) {
            Dataset dataset = (Dataset)this.datasets.get(n4);
            if (dataset == null) continue;
            dataset.addChangeListener(this);
        }
        n4 = this.renderers.size();
        int n6 = 0;
        while (n6 < n4) {
            XYItemRenderer xYItemRenderer = (XYItemRenderer)this.renderers.get(n6);
            if (xYItemRenderer != null) {
                xYItemRenderer.addChangeListener(this);
            }
            ++n6;
        }
    }
}

