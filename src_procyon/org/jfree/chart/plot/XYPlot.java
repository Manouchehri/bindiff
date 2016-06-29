package org.jfree.chart.plot;

import org.jfree.data.xy.*;
import org.jfree.ui.*;
import org.jfree.chart.annotations.*;
import java.awt.*;
import org.jfree.chart.axis.*;
import org.jfree.data.general.*;
import org.jfree.chart.renderer.xy.*;
import java.util.*;
import java.awt.geom.*;
import org.jfree.data.*;
import org.jfree.chart.event.*;
import org.jfree.chart.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class XYPlot extends Plot implements Serializable, Cloneable, RendererChangeListener, ValueAxisPlot, Zoomable, PublicCloneable
{
    private static final long serialVersionUID = 7044148245716569264L;
    public static final Stroke DEFAULT_GRIDLINE_STROKE;
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
        this(null, null, null, null);
    }
    
    public XYPlot(final XYDataset xyDataset, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYItemRenderer xyItemRenderer) {
        this.quadrantOrigin = new Point2D.Double(0.0, 0.0);
        this.quadrantPaint = new Paint[] { null, null, null, null };
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
        this.datasets.set(0, xyDataset);
        if (xyDataset != null) {
            xyDataset.addChangeListener(this);
        }
        this.renderers.set(0, xyItemRenderer);
        if (xyItemRenderer != null) {
            xyItemRenderer.setPlot(this);
            xyItemRenderer.addChangeListener(this);
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
        this.domainGridlineStroke = XYPlot.DEFAULT_GRIDLINE_STROKE;
        this.domainGridlinePaint = XYPlot.DEFAULT_GRIDLINE_PAINT;
        this.domainZeroBaselineVisible = false;
        this.domainZeroBaselinePaint = Color.black;
        this.domainZeroBaselineStroke = new BasicStroke(0.5f);
        this.rangeGridlinesVisible = true;
        this.rangeGridlineStroke = XYPlot.DEFAULT_GRIDLINE_STROKE;
        this.rangeGridlinePaint = XYPlot.DEFAULT_GRIDLINE_PAINT;
        this.rangeZeroBaselineVisible = false;
        this.rangeZeroBaselinePaint = Color.black;
        this.rangeZeroBaselineStroke = new BasicStroke(0.5f);
        this.domainCrosshairVisible = false;
        this.domainCrosshairValue = 0.0;
        this.domainCrosshairStroke = XYPlot.DEFAULT_CROSSHAIR_STROKE;
        this.domainCrosshairPaint = XYPlot.DEFAULT_CROSSHAIR_PAINT;
        this.rangeCrosshairVisible = false;
        this.rangeCrosshairValue = 0.0;
        this.rangeCrosshairStroke = XYPlot.DEFAULT_CROSSHAIR_STROKE;
        this.rangeCrosshairPaint = XYPlot.DEFAULT_CROSSHAIR_PAINT;
        this.annotations = new ArrayList();
    }
    
    public String getPlotType() {
        return XYPlot.localizationResources.getString("XY_Plot");
    }
    
    public PlotOrientation getOrientation() {
        return this.orientation;
    }
    
    public void setOrientation(final PlotOrientation orientation) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        if (orientation != this.orientation) {
            this.orientation = orientation;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public RectangleInsets getAxisOffset() {
        return this.axisOffset;
    }
    
    public void setAxisOffset(final RectangleInsets axisOffset) {
        if (axisOffset == null) {
            throw new IllegalArgumentException("Null 'offset' argument.");
        }
        this.axisOffset = axisOffset;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public ValueAxis getDomainAxis() {
        return this.getDomainAxis(0);
    }
    
    public ValueAxis getDomainAxis(final int n) {
        ValueAxis domainAxis = null;
        if (n < this.domainAxes.size()) {
            domainAxis = (ValueAxis)this.domainAxes.get(n);
        }
        if (domainAxis == null) {
            final Plot parent = this.getParent();
            if (parent instanceof XYPlot) {
                domainAxis = ((XYPlot)parent).getDomainAxis(n);
            }
        }
        return domainAxis;
    }
    
    public void setDomainAxis(final ValueAxis valueAxis) {
        this.setDomainAxis(0, valueAxis);
    }
    
    public void setDomainAxis(final int n, final ValueAxis valueAxis) {
        this.setDomainAxis(n, valueAxis, true);
    }
    
    public void setDomainAxis(final int n, final ValueAxis valueAxis, final boolean b) {
        final ValueAxis domainAxis = this.getDomainAxis(n);
        if (domainAxis != null) {
            domainAxis.removeChangeListener(this);
        }
        if (valueAxis != null) {
            valueAxis.setPlot(this);
        }
        this.domainAxes.set(n, valueAxis);
        if (valueAxis != null) {
            valueAxis.configure();
            valueAxis.addChangeListener(this);
        }
        if (b) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void setDomainAxes(final ValueAxis[] array) {
        for (int i = 0; i < array.length; ++i) {
            this.setDomainAxis(i, array[i], false);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public AxisLocation getDomainAxisLocation() {
        return (AxisLocation)this.domainAxisLocations.get(0);
    }
    
    public void setDomainAxisLocation(final AxisLocation axisLocation) {
        this.setDomainAxisLocation(0, axisLocation, true);
    }
    
    public void setDomainAxisLocation(final AxisLocation axisLocation, final boolean b) {
        this.setDomainAxisLocation(0, axisLocation, b);
    }
    
    public RectangleEdge getDomainAxisEdge() {
        return Plot.resolveDomainAxisLocation(this.getDomainAxisLocation(), this.orientation);
    }
    
    public int getDomainAxisCount() {
        return this.domainAxes.size();
    }
    
    public void clearDomainAxes() {
        for (int i = 0; i < this.domainAxes.size(); ++i) {
            final ValueAxis valueAxis = (ValueAxis)this.domainAxes.get(i);
            if (valueAxis != null) {
                valueAxis.removeChangeListener(this);
            }
        }
        this.domainAxes.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void configureDomainAxes() {
        for (int i = 0; i < this.domainAxes.size(); ++i) {
            final ValueAxis valueAxis = (ValueAxis)this.domainAxes.get(i);
            if (valueAxis != null) {
                valueAxis.configure();
            }
        }
    }
    
    public AxisLocation getDomainAxisLocation(final int n) {
        AxisLocation opposite = null;
        if (n < this.domainAxisLocations.size()) {
            opposite = (AxisLocation)this.domainAxisLocations.get(n);
        }
        if (opposite == null) {
            opposite = AxisLocation.getOpposite(this.getDomainAxisLocation());
        }
        return opposite;
    }
    
    public void setDomainAxisLocation(final int n, final AxisLocation axisLocation) {
        this.setDomainAxisLocation(n, axisLocation, true);
    }
    
    public void setDomainAxisLocation(final int n, final AxisLocation axisLocation, final boolean b) {
        if (n == 0 && axisLocation == null) {
            throw new IllegalArgumentException("Null 'location' for index 0 not permitted.");
        }
        this.domainAxisLocations.set(n, axisLocation);
        if (b) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public RectangleEdge getDomainAxisEdge(final int n) {
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(this.getDomainAxisLocation(n), this.orientation);
        if (rectangleEdge == null) {
            rectangleEdge = RectangleEdge.opposite(this.getDomainAxisEdge());
        }
        return rectangleEdge;
    }
    
    public ValueAxis getRangeAxis() {
        return this.getRangeAxis(0);
    }
    
    public void setRangeAxis(final ValueAxis valueAxis) {
        if (valueAxis != null) {
            valueAxis.setPlot(this);
        }
        final ValueAxis rangeAxis = this.getRangeAxis();
        if (rangeAxis != null) {
            rangeAxis.removeChangeListener(this);
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
    
    public void setRangeAxisLocation(final AxisLocation axisLocation) {
        this.setRangeAxisLocation(0, axisLocation, true);
    }
    
    public void setRangeAxisLocation(final AxisLocation axisLocation, final boolean b) {
        this.setRangeAxisLocation(0, axisLocation, b);
    }
    
    public RectangleEdge getRangeAxisEdge() {
        return Plot.resolveRangeAxisLocation(this.getRangeAxisLocation(), this.orientation);
    }
    
    public ValueAxis getRangeAxis(final int n) {
        ValueAxis rangeAxis = null;
        if (n < this.rangeAxes.size()) {
            rangeAxis = (ValueAxis)this.rangeAxes.get(n);
        }
        if (rangeAxis == null) {
            final Plot parent = this.getParent();
            if (parent instanceof XYPlot) {
                rangeAxis = ((XYPlot)parent).getRangeAxis(n);
            }
        }
        return rangeAxis;
    }
    
    public void setRangeAxis(final int n, final ValueAxis valueAxis) {
        this.setRangeAxis(n, valueAxis, true);
    }
    
    public void setRangeAxis(final int n, final ValueAxis valueAxis, final boolean b) {
        final ValueAxis rangeAxis = this.getRangeAxis(n);
        if (rangeAxis != null) {
            rangeAxis.removeChangeListener(this);
        }
        if (valueAxis != null) {
            valueAxis.setPlot(this);
        }
        this.rangeAxes.set(n, valueAxis);
        if (valueAxis != null) {
            valueAxis.configure();
            valueAxis.addChangeListener(this);
        }
        if (b) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void setRangeAxes(final ValueAxis[] array) {
        for (int i = 0; i < array.length; ++i) {
            this.setRangeAxis(i, array[i], false);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public int getRangeAxisCount() {
        return this.rangeAxes.size();
    }
    
    public void clearRangeAxes() {
        for (int i = 0; i < this.rangeAxes.size(); ++i) {
            final ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(i);
            if (valueAxis != null) {
                valueAxis.removeChangeListener(this);
            }
        }
        this.rangeAxes.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void configureRangeAxes() {
        for (int i = 0; i < this.rangeAxes.size(); ++i) {
            final ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(i);
            if (valueAxis != null) {
                valueAxis.configure();
            }
        }
    }
    
    public AxisLocation getRangeAxisLocation(final int n) {
        AxisLocation opposite = null;
        if (n < this.rangeAxisLocations.size()) {
            opposite = (AxisLocation)this.rangeAxisLocations.get(n);
        }
        if (opposite == null) {
            opposite = AxisLocation.getOpposite(this.getRangeAxisLocation());
        }
        return opposite;
    }
    
    public void setRangeAxisLocation(final int n, final AxisLocation axisLocation) {
        this.setRangeAxisLocation(n, axisLocation, true);
    }
    
    public void setRangeAxisLocation(final int n, final AxisLocation axisLocation, final boolean b) {
        if (n == 0 && axisLocation == null) {
            throw new IllegalArgumentException("Null 'location' for index 0 not permitted.");
        }
        this.rangeAxisLocations.set(n, axisLocation);
        if (b) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public RectangleEdge getRangeAxisEdge(final int n) {
        RectangleEdge rectangleEdge = Plot.resolveRangeAxisLocation(this.getRangeAxisLocation(n), this.orientation);
        if (rectangleEdge == null) {
            rectangleEdge = RectangleEdge.opposite(this.getRangeAxisEdge());
        }
        return rectangleEdge;
    }
    
    public XYDataset getDataset() {
        return this.getDataset(0);
    }
    
    public XYDataset getDataset(final int n) {
        XYDataset xyDataset = null;
        if (this.datasets.size() > n) {
            xyDataset = (XYDataset)this.datasets.get(n);
        }
        return xyDataset;
    }
    
    public void setDataset(final XYDataset xyDataset) {
        this.setDataset(0, xyDataset);
    }
    
    public void setDataset(final int n, final XYDataset xyDataset) {
        final XYDataset dataset = this.getDataset(n);
        if (dataset != null) {
            dataset.removeChangeListener(this);
        }
        this.datasets.set(n, xyDataset);
        if (xyDataset != null) {
            xyDataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, xyDataset));
    }
    
    public int getDatasetCount() {
        return this.datasets.size();
    }
    
    public int indexOf(final XYDataset xyDataset) {
        int n = -1;
        for (int i = 0; i < this.datasets.size(); ++i) {
            if (xyDataset == this.datasets.get(i)) {
                n = i;
                break;
            }
        }
        return n;
    }
    
    public void mapDatasetToDomainAxis(final int n, final int n2) {
        this.datasetToDomainAxisMap.put(new Integer(n), new Integer(n2));
        this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(n)));
    }
    
    public void mapDatasetToRangeAxis(final int n, final int n2) {
        this.datasetToRangeAxisMap.put(new Integer(n), new Integer(n2));
        this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(n)));
    }
    
    public XYItemRenderer getRenderer() {
        return this.getRenderer(0);
    }
    
    public XYItemRenderer getRenderer(final int n) {
        XYItemRenderer xyItemRenderer = null;
        if (this.renderers.size() > n) {
            xyItemRenderer = (XYItemRenderer)this.renderers.get(n);
        }
        return xyItemRenderer;
    }
    
    public void setRenderer(final XYItemRenderer xyItemRenderer) {
        this.setRenderer(0, xyItemRenderer);
    }
    
    public void setRenderer(final int n, final XYItemRenderer xyItemRenderer) {
        this.setRenderer(n, xyItemRenderer, true);
    }
    
    public void setRenderer(final int n, final XYItemRenderer xyItemRenderer, final boolean b) {
        final XYItemRenderer renderer = this.getRenderer(n);
        if (renderer != null) {
            renderer.removeChangeListener(this);
        }
        this.renderers.set(n, xyItemRenderer);
        if (xyItemRenderer != null) {
            xyItemRenderer.setPlot(this);
            xyItemRenderer.addChangeListener(this);
        }
        this.configureDomainAxes();
        this.configureRangeAxes();
        if (b) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void setRenderers(final XYItemRenderer[] array) {
        for (int i = 0; i < array.length; ++i) {
            this.setRenderer(i, array[i], false);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public DatasetRenderingOrder getDatasetRenderingOrder() {
        return this.datasetRenderingOrder;
    }
    
    public void setDatasetRenderingOrder(final DatasetRenderingOrder datasetRenderingOrder) {
        if (datasetRenderingOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.datasetRenderingOrder = datasetRenderingOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public SeriesRenderingOrder getSeriesRenderingOrder() {
        return this.seriesRenderingOrder;
    }
    
    public void setSeriesRenderingOrder(final SeriesRenderingOrder seriesRenderingOrder) {
        if (seriesRenderingOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.seriesRenderingOrder = seriesRenderingOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public int getIndexOf(final XYItemRenderer xyItemRenderer) {
        return this.renderers.indexOf(xyItemRenderer);
    }
    
    public XYItemRenderer getRendererForDataset(final XYDataset xyDataset) {
        XYItemRenderer renderer = null;
        int i = 0;
        while (i < this.datasets.size()) {
            if (this.datasets.get(i) == xyDataset) {
                renderer = (XYItemRenderer)this.renderers.get(i);
                if (renderer == null) {
                    renderer = this.getRenderer();
                    break;
                }
                break;
            }
            else {
                ++i;
            }
        }
        return renderer;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public void setWeight(final int weight) {
        this.weight = weight;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isDomainGridlinesVisible() {
        return this.domainGridlinesVisible;
    }
    
    public void setDomainGridlinesVisible(final boolean domainGridlinesVisible) {
        if (this.domainGridlinesVisible != domainGridlinesVisible) {
            this.domainGridlinesVisible = domainGridlinesVisible;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Stroke getDomainGridlineStroke() {
        return this.domainGridlineStroke;
    }
    
    public void setDomainGridlineStroke(final Stroke domainGridlineStroke) {
        if (domainGridlineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.domainGridlineStroke = domainGridlineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getDomainGridlinePaint() {
        return this.domainGridlinePaint;
    }
    
    public void setDomainGridlinePaint(final Paint domainGridlinePaint) {
        if (domainGridlinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.domainGridlinePaint = domainGridlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isRangeGridlinesVisible() {
        return this.rangeGridlinesVisible;
    }
    
    public void setRangeGridlinesVisible(final boolean rangeGridlinesVisible) {
        if (this.rangeGridlinesVisible != rangeGridlinesVisible) {
            this.rangeGridlinesVisible = rangeGridlinesVisible;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Stroke getRangeGridlineStroke() {
        return this.rangeGridlineStroke;
    }
    
    public void setRangeGridlineStroke(final Stroke rangeGridlineStroke) {
        if (rangeGridlineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.rangeGridlineStroke = rangeGridlineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getRangeGridlinePaint() {
        return this.rangeGridlinePaint;
    }
    
    public void setRangeGridlinePaint(final Paint rangeGridlinePaint) {
        if (rangeGridlinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.rangeGridlinePaint = rangeGridlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isDomainZeroBaselineVisible() {
        return this.domainZeroBaselineVisible;
    }
    
    public void setDomainZeroBaselineVisible(final boolean domainZeroBaselineVisible) {
        this.domainZeroBaselineVisible = domainZeroBaselineVisible;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getDomainZeroBaselineStroke() {
        return this.domainZeroBaselineStroke;
    }
    
    public void setDomainZeroBaselineStroke(final Stroke domainZeroBaselineStroke) {
        if (domainZeroBaselineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.domainZeroBaselineStroke = domainZeroBaselineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getDomainZeroBaselinePaint() {
        return this.domainZeroBaselinePaint;
    }
    
    public void setDomainZeroBaselinePaint(final Paint domainZeroBaselinePaint) {
        if (domainZeroBaselinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.domainZeroBaselinePaint = domainZeroBaselinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isRangeZeroBaselineVisible() {
        return this.rangeZeroBaselineVisible;
    }
    
    public void setRangeZeroBaselineVisible(final boolean rangeZeroBaselineVisible) {
        this.rangeZeroBaselineVisible = rangeZeroBaselineVisible;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getRangeZeroBaselineStroke() {
        return this.rangeZeroBaselineStroke;
    }
    
    public void setRangeZeroBaselineStroke(final Stroke rangeZeroBaselineStroke) {
        if (rangeZeroBaselineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.rangeZeroBaselineStroke = rangeZeroBaselineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getRangeZeroBaselinePaint() {
        return this.rangeZeroBaselinePaint;
    }
    
    public void setRangeZeroBaselinePaint(final Paint rangeZeroBaselinePaint) {
        if (rangeZeroBaselinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.rangeZeroBaselinePaint = rangeZeroBaselinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getDomainTickBandPaint() {
        return this.domainTickBandPaint;
    }
    
    public void setDomainTickBandPaint(final Paint domainTickBandPaint) {
        this.domainTickBandPaint = domainTickBandPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getRangeTickBandPaint() {
        return this.rangeTickBandPaint;
    }
    
    public void setRangeTickBandPaint(final Paint rangeTickBandPaint) {
        this.rangeTickBandPaint = rangeTickBandPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Point2D getQuadrantOrigin() {
        return this.quadrantOrigin;
    }
    
    public void setQuadrantOrigin(final Point2D quadrantOrigin) {
        if (quadrantOrigin == null) {
            throw new IllegalArgumentException("Null 'origin' argument.");
        }
        this.quadrantOrigin = quadrantOrigin;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getQuadrantPaint(final int n) {
        if (n < 0 || n > 3) {
            throw new IllegalArgumentException("The index should be in the range 0 to 3.");
        }
        return this.quadrantPaint[n];
    }
    
    public void setQuadrantPaint(final int n, final Paint paint) {
        if (n < 0 || n > 3) {
            throw new IllegalArgumentException("The index should be in the range 0 to 3.");
        }
        this.quadrantPaint[n] = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void addDomainMarker(final Marker marker) {
        this.addDomainMarker(marker, Layer.FOREGROUND);
    }
    
    public void addDomainMarker(final Marker marker, final Layer layer) {
        this.addDomainMarker(0, marker, layer);
    }
    
    public void clearDomainMarkers() {
        if (this.backgroundDomainMarkers != null) {
            final Iterator<Integer> iterator = this.backgroundDomainMarkers.keySet().iterator();
            while (iterator.hasNext()) {
                this.clearDomainMarkers(iterator.next());
            }
            this.backgroundDomainMarkers.clear();
        }
        if (this.foregroundDomainMarkers != null) {
            final Iterator<Integer> iterator2 = this.foregroundDomainMarkers.keySet().iterator();
            while (iterator2.hasNext()) {
                this.clearDomainMarkers(iterator2.next());
            }
            this.foregroundDomainMarkers.clear();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void clearDomainMarkers(final int n) {
        final Integer n2 = new Integer(n);
        if (this.backgroundDomainMarkers != null) {
            final Collection<Marker> collection = this.backgroundDomainMarkers.get(n2);
            if (collection != null) {
                final Iterator<Marker> iterator = collection.iterator();
                while (iterator.hasNext()) {
                    iterator.next().removeChangeListener(this);
                }
                collection.clear();
            }
        }
        if (this.foregroundRangeMarkers != null) {
            final Collection<Marker> collection2 = this.foregroundDomainMarkers.get(n2);
            if (collection2 != null) {
                final Iterator<Marker> iterator2 = collection2.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().removeChangeListener(this);
                }
                collection2.clear();
            }
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void addDomainMarker(final int n, final Marker marker, final Layer layer) {
        if (marker == null) {
            throw new IllegalArgumentException("Null 'marker' not permitted.");
        }
        if (layer == null) {
            throw new IllegalArgumentException("Null 'layer' not permitted.");
        }
        if (layer == Layer.FOREGROUND) {
            Collection<Marker> collection = this.foregroundDomainMarkers.get(new Integer(n));
            if (collection == null) {
                collection = new ArrayList<Marker>();
                this.foregroundDomainMarkers.put(new Integer(n), collection);
            }
            collection.add(marker);
        }
        else if (layer == Layer.BACKGROUND) {
            Collection<Marker> collection2 = this.backgroundDomainMarkers.get(new Integer(n));
            if (collection2 == null) {
                collection2 = new ArrayList<Marker>();
                this.backgroundDomainMarkers.put(new Integer(n), collection2);
            }
            collection2.add(marker);
        }
        marker.addChangeListener(this);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void addRangeMarker(final Marker marker) {
        this.addRangeMarker(marker, Layer.FOREGROUND);
    }
    
    public void addRangeMarker(final Marker marker, final Layer layer) {
        this.addRangeMarker(0, marker, layer);
    }
    
    public void clearRangeMarkers() {
        if (this.backgroundRangeMarkers != null) {
            final Iterator<Integer> iterator = this.backgroundRangeMarkers.keySet().iterator();
            while (iterator.hasNext()) {
                this.clearRangeMarkers(iterator.next());
            }
            this.backgroundRangeMarkers.clear();
        }
        if (this.foregroundRangeMarkers != null) {
            final Iterator<Integer> iterator2 = this.foregroundRangeMarkers.keySet().iterator();
            while (iterator2.hasNext()) {
                this.clearRangeMarkers(iterator2.next());
            }
            this.foregroundRangeMarkers.clear();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void addRangeMarker(final int n, final Marker marker, final Layer layer) {
        if (layer == Layer.FOREGROUND) {
            Collection<Marker> collection = this.foregroundRangeMarkers.get(new Integer(n));
            if (collection == null) {
                collection = new ArrayList<Marker>();
                this.foregroundRangeMarkers.put(new Integer(n), collection);
            }
            collection.add(marker);
        }
        else if (layer == Layer.BACKGROUND) {
            Collection<Marker> collection2 = this.backgroundRangeMarkers.get(new Integer(n));
            if (collection2 == null) {
                collection2 = new ArrayList<Marker>();
                this.backgroundRangeMarkers.put(new Integer(n), collection2);
            }
            collection2.add(marker);
        }
        marker.addChangeListener(this);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void clearRangeMarkers(final int n) {
        final Integer n2 = new Integer(n);
        if (this.backgroundRangeMarkers != null) {
            final Collection<Marker> collection = this.backgroundRangeMarkers.get(n2);
            if (collection != null) {
                final Iterator<Marker> iterator = collection.iterator();
                while (iterator.hasNext()) {
                    iterator.next().removeChangeListener(this);
                }
                collection.clear();
            }
        }
        if (this.foregroundRangeMarkers != null) {
            final Collection<Marker> collection2 = this.foregroundRangeMarkers.get(n2);
            if (collection2 != null) {
                final Iterator<Marker> iterator2 = collection2.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().removeChangeListener(this);
                }
                collection2.clear();
            }
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void addAnnotation(final XYAnnotation xyAnnotation) {
        if (xyAnnotation == null) {
            throw new IllegalArgumentException("Null 'annotation' argument.");
        }
        this.annotations.add(xyAnnotation);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean removeAnnotation(final XYAnnotation xyAnnotation) {
        if (xyAnnotation == null) {
            throw new IllegalArgumentException("Null 'annotation' argument.");
        }
        final boolean remove = this.annotations.remove(xyAnnotation);
        if (remove) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
        return remove;
    }
    
    public List getAnnotations() {
        return new ArrayList(this.annotations);
    }
    
    public void clearAnnotations() {
        this.annotations.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    protected AxisSpace calculateAxisSpace(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        return this.calculateRangeAxisSpace(graphics2D, rectangle2D, this.calculateDomainAxisSpace(graphics2D, rectangle2D, new AxisSpace()));
    }
    
    protected AxisSpace calculateDomainAxisSpace(final Graphics2D graphics2D, final Rectangle2D rectangle2D, AxisSpace reserveSpace) {
        if (reserveSpace == null) {
            reserveSpace = new AxisSpace();
        }
        if (this.fixedDomainAxisSpace != null) {
            if (this.orientation == PlotOrientation.HORIZONTAL) {
                reserveSpace.ensureAtLeast(this.fixedDomainAxisSpace.getLeft(), RectangleEdge.LEFT);
                reserveSpace.ensureAtLeast(this.fixedDomainAxisSpace.getRight(), RectangleEdge.RIGHT);
            }
            else if (this.orientation == PlotOrientation.VERTICAL) {
                reserveSpace.ensureAtLeast(this.fixedDomainAxisSpace.getTop(), RectangleEdge.TOP);
                reserveSpace.ensureAtLeast(this.fixedDomainAxisSpace.getBottom(), RectangleEdge.BOTTOM);
            }
        }
        else {
            for (int i = 0; i < this.domainAxes.size(); ++i) {
                final Axis axis = (Axis)this.domainAxes.get(i);
                if (axis != null) {
                    reserveSpace = axis.reserveSpace(graphics2D, this, rectangle2D, this.getDomainAxisEdge(i), reserveSpace);
                }
            }
        }
        return reserveSpace;
    }
    
    protected AxisSpace calculateRangeAxisSpace(final Graphics2D graphics2D, final Rectangle2D rectangle2D, AxisSpace reserveSpace) {
        if (reserveSpace == null) {
            reserveSpace = new AxisSpace();
        }
        if (this.fixedRangeAxisSpace != null) {
            if (this.orientation == PlotOrientation.HORIZONTAL) {
                reserveSpace.ensureAtLeast(this.fixedRangeAxisSpace.getTop(), RectangleEdge.TOP);
                reserveSpace.ensureAtLeast(this.fixedRangeAxisSpace.getBottom(), RectangleEdge.BOTTOM);
            }
            else if (this.orientation == PlotOrientation.VERTICAL) {
                reserveSpace.ensureAtLeast(this.fixedRangeAxisSpace.getLeft(), RectangleEdge.LEFT);
                reserveSpace.ensureAtLeast(this.fixedRangeAxisSpace.getRight(), RectangleEdge.RIGHT);
            }
        }
        else {
            for (int i = 0; i < this.rangeAxes.size(); ++i) {
                final Axis axis = (Axis)this.rangeAxes.get(i);
                if (axis != null) {
                    reserveSpace = axis.reserveSpace(graphics2D, this, rectangle2D, this.getRangeAxisEdge(i), reserveSpace);
                }
            }
        }
        return reserveSpace;
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D plotArea, Point2D anchor, final PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        final boolean b = plotArea.getWidth() <= 10.0;
        final boolean b2 = plotArea.getHeight() <= 10.0;
        if (b || b2) {
            return;
        }
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(plotArea);
        }
        this.getInsets().trim(plotArea);
        final Rectangle2D shrink = this.calculateAxisSpace(graphics2D, plotArea).shrink(plotArea, null);
        this.axisOffset.trim(shrink);
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setDataArea(shrink);
        }
        this.drawBackground(graphics2D, shrink);
        final Map drawAxes = this.drawAxes(graphics2D, plotArea, shrink, plotRenderingInfo);
        final PlotOrientation orientation = this.getOrientation();
        if (anchor != null && !shrink.contains(anchor)) {
            anchor = null;
        }
        final CrosshairState crosshairState = new CrosshairState();
        crosshairState.setCrosshairDistance(Double.POSITIVE_INFINITY);
        crosshairState.setAnchor(anchor);
        crosshairState.setAnchorX(Double.NaN);
        crosshairState.setAnchorY(Double.NaN);
        if (anchor != null) {
            final ValueAxis domainAxis = this.getDomainAxis();
            if (domainAxis != null) {
                double anchorX;
                if (orientation == PlotOrientation.VERTICAL) {
                    anchorX = domainAxis.java2DToValue(anchor.getX(), shrink, this.getDomainAxisEdge());
                }
                else {
                    anchorX = domainAxis.java2DToValue(anchor.getY(), shrink, this.getDomainAxisEdge());
                }
                crosshairState.setAnchorX(anchorX);
            }
            final ValueAxis rangeAxis = this.getRangeAxis();
            if (rangeAxis != null) {
                double anchorY;
                if (orientation == PlotOrientation.VERTICAL) {
                    anchorY = rangeAxis.java2DToValue(anchor.getY(), shrink, this.getRangeAxisEdge());
                }
                else {
                    anchorY = rangeAxis.java2DToValue(anchor.getX(), shrink, this.getRangeAxisEdge());
                }
                crosshairState.setAnchorY(anchorY);
            }
        }
        crosshairState.setCrosshairX(this.getDomainCrosshairValue());
        crosshairState.setCrosshairY(this.getRangeCrosshairValue());
        final Shape clip = graphics2D.getClip();
        final Composite composite = graphics2D.getComposite();
        graphics2D.clip(shrink);
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        AxisState axisState = drawAxes.get(this.getDomainAxis());
        if (axisState == null && plotState != null) {
            axisState = plotState.getSharedAxisStates().get(this.getDomainAxis());
        }
        AxisState axisState2 = drawAxes.get(this.getRangeAxis());
        if (axisState2 == null && plotState != null) {
            axisState2 = plotState.getSharedAxisStates().get(this.getRangeAxis());
        }
        if (axisState != null) {
            this.drawDomainTickBands(graphics2D, shrink, axisState.getTicks());
        }
        if (axisState2 != null) {
            this.drawRangeTickBands(graphics2D, shrink, axisState2.getTicks());
        }
        if (axisState != null) {
            this.drawDomainGridlines(graphics2D, shrink, axisState.getTicks());
            this.drawZeroDomainBaseline(graphics2D, shrink);
        }
        if (axisState2 != null) {
            this.drawRangeGridlines(graphics2D, shrink, axisState2.getTicks());
            this.drawZeroRangeBaseline(graphics2D, shrink);
        }
        for (int i = 0; i < this.renderers.size(); ++i) {
            this.drawDomainMarkers(graphics2D, shrink, i, Layer.BACKGROUND);
        }
        for (int j = 0; j < this.renderers.size(); ++j) {
            this.drawRangeMarkers(graphics2D, shrink, j, Layer.BACKGROUND);
        }
        int n = 0;
        final DatasetRenderingOrder datasetRenderingOrder = this.getDatasetRenderingOrder();
        if (datasetRenderingOrder == DatasetRenderingOrder.FORWARD) {
            final int size = this.renderers.size();
            for (int k = 0; k < size; ++k) {
                final XYItemRenderer renderer = this.getRenderer(k);
                if (renderer != null) {
                    renderer.drawAnnotations(graphics2D, shrink, this.getDomainAxisForDataset(k), this.getRangeAxisForDataset(k), Layer.BACKGROUND, plotRenderingInfo);
                }
            }
            for (int l = 0; l < this.getDatasetCount(); ++l) {
                n = ((this.render(graphics2D, shrink, l, plotRenderingInfo, crosshairState) || n != 0) ? 1 : 0);
            }
            for (int n2 = 0; n2 < size; ++n2) {
                final XYItemRenderer renderer2 = this.getRenderer(n2);
                if (renderer2 != null) {
                    renderer2.drawAnnotations(graphics2D, shrink, this.getDomainAxisForDataset(n2), this.getRangeAxisForDataset(n2), Layer.FOREGROUND, plotRenderingInfo);
                }
            }
        }
        else if (datasetRenderingOrder == DatasetRenderingOrder.REVERSE) {
            final int size2 = this.renderers.size();
            for (int n3 = size2 - 1; n3 >= 0; --n3) {
                final XYItemRenderer renderer3 = this.getRenderer(n3);
                if (n3 < this.getDatasetCount()) {
                    if (renderer3 != null) {
                        renderer3.drawAnnotations(graphics2D, shrink, this.getDomainAxisForDataset(n3), this.getRangeAxisForDataset(n3), Layer.BACKGROUND, plotRenderingInfo);
                    }
                }
            }
            for (int n4 = this.getDatasetCount() - 1; n4 >= 0; --n4) {
                n = ((this.render(graphics2D, shrink, n4, plotRenderingInfo, crosshairState) || n != 0) ? 1 : 0);
            }
            for (int n5 = size2 - 1; n5 >= 0; --n5) {
                final XYItemRenderer renderer4 = this.getRenderer(n5);
                if (n5 < this.getDatasetCount()) {
                    if (renderer4 != null) {
                        renderer4.drawAnnotations(graphics2D, shrink, this.getDomainAxisForDataset(n5), this.getRangeAxisForDataset(n5), Layer.FOREGROUND, plotRenderingInfo);
                    }
                }
            }
        }
        final int domainAxisIndex = crosshairState.getDomainAxisIndex();
        final ValueAxis domainAxis2 = this.getDomainAxis(domainAxisIndex);
        final RectangleEdge domainAxisEdge = this.getDomainAxisEdge(domainAxisIndex);
        if (!this.domainCrosshairLockedOnData && anchor != null) {
            double crosshairX;
            if (orientation == PlotOrientation.VERTICAL) {
                crosshairX = domainAxis2.java2DToValue(anchor.getX(), shrink, domainAxisEdge);
            }
            else {
                crosshairX = domainAxis2.java2DToValue(anchor.getY(), shrink, domainAxisEdge);
            }
            crosshairState.setCrosshairX(crosshairX);
        }
        this.setDomainCrosshairValue(crosshairState.getCrosshairX(), false);
        if (this.isDomainCrosshairVisible()) {
            this.drawDomainCrosshair(graphics2D, shrink, orientation, this.getDomainCrosshairValue(), domainAxis2, this.getDomainCrosshairStroke(), this.getDomainCrosshairPaint());
        }
        final int rangeAxisIndex = crosshairState.getRangeAxisIndex();
        final ValueAxis rangeAxis2 = this.getRangeAxis(rangeAxisIndex);
        final RectangleEdge rangeAxisEdge = this.getRangeAxisEdge(rangeAxisIndex);
        if (!this.rangeCrosshairLockedOnData && anchor != null) {
            double crosshairY;
            if (orientation == PlotOrientation.VERTICAL) {
                crosshairY = rangeAxis2.java2DToValue(anchor.getY(), shrink, rangeAxisEdge);
            }
            else {
                crosshairY = rangeAxis2.java2DToValue(anchor.getX(), shrink, rangeAxisEdge);
            }
            crosshairState.setCrosshairY(crosshairY);
        }
        this.setRangeCrosshairValue(crosshairState.getCrosshairY(), false);
        if (this.isRangeCrosshairVisible()) {
            this.drawRangeCrosshair(graphics2D, shrink, orientation, this.getRangeCrosshairValue(), rangeAxis2, this.getRangeCrosshairStroke(), this.getRangeCrosshairPaint());
        }
        if (n == 0) {
            this.drawNoDataMessage(graphics2D, shrink);
        }
        for (int n6 = 0; n6 < this.renderers.size(); ++n6) {
            this.drawDomainMarkers(graphics2D, shrink, n6, Layer.FOREGROUND);
        }
        for (int n7 = 0; n7 < this.renderers.size(); ++n7) {
            this.drawRangeMarkers(graphics2D, shrink, n7, Layer.FOREGROUND);
        }
        this.drawAnnotations(graphics2D, shrink, plotRenderingInfo);
        graphics2D.setClip(clip);
        graphics2D.setComposite(composite);
        this.drawOutline(graphics2D, shrink);
    }
    
    public void drawBackground(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        this.fillBackground(graphics2D, rectangle2D);
        this.drawQuadrants(graphics2D, rectangle2D);
        this.drawBackgroundImage(graphics2D, rectangle2D);
    }
    
    protected void drawQuadrants(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        boolean b = false;
        final ValueAxis domainAxis = this.getDomainAxis();
        final double x = this.quadrantOrigin.getX();
        final double valueToJava2D = domainAxis.valueToJava2D(x, rectangle2D, this.getDomainAxisEdge());
        final ValueAxis rangeAxis = this.getRangeAxis();
        final double y = this.quadrantOrigin.getY();
        final double valueToJava2D2 = rangeAxis.valueToJava2D(y, rectangle2D, this.getRangeAxisEdge());
        final double lowerBound = domainAxis.getLowerBound();
        final double valueToJava2D3 = domainAxis.valueToJava2D(lowerBound, rectangle2D, this.getDomainAxisEdge());
        final double upperBound = domainAxis.getUpperBound();
        final double valueToJava2D4 = domainAxis.valueToJava2D(upperBound, rectangle2D, this.getDomainAxisEdge());
        final double lowerBound2 = rangeAxis.getLowerBound();
        final double valueToJava2D5 = rangeAxis.valueToJava2D(lowerBound2, rectangle2D, this.getRangeAxisEdge());
        final double upperBound2 = rangeAxis.getUpperBound();
        final double valueToJava2D6 = rangeAxis.valueToJava2D(upperBound2, rectangle2D, this.getRangeAxisEdge());
        final Rectangle2D[] array = { null, null, null, null };
        if (this.quadrantPaint[0] != null && x > lowerBound && y < upperBound2) {
            if (this.orientation == PlotOrientation.HORIZONTAL) {
                array[0] = new Rectangle2D.Double(Math.min(valueToJava2D6, valueToJava2D2), Math.min(valueToJava2D3, valueToJava2D), Math.abs(valueToJava2D2 - valueToJava2D6), Math.abs(valueToJava2D - valueToJava2D3));
            }
            else {
                array[0] = new Rectangle2D.Double(Math.min(valueToJava2D3, valueToJava2D), Math.min(valueToJava2D6, valueToJava2D2), Math.abs(valueToJava2D - valueToJava2D3), Math.abs(valueToJava2D2 - valueToJava2D6));
            }
            b = true;
        }
        if (this.quadrantPaint[1] != null && x < upperBound && y < upperBound2) {
            if (this.orientation == PlotOrientation.HORIZONTAL) {
                array[1] = new Rectangle2D.Double(Math.min(valueToJava2D6, valueToJava2D2), Math.min(valueToJava2D4, valueToJava2D), Math.abs(valueToJava2D2 - valueToJava2D6), Math.abs(valueToJava2D - valueToJava2D4));
            }
            else {
                array[1] = new Rectangle2D.Double(Math.min(valueToJava2D, valueToJava2D4), Math.min(valueToJava2D6, valueToJava2D2), Math.abs(valueToJava2D - valueToJava2D4), Math.abs(valueToJava2D2 - valueToJava2D6));
            }
            b = true;
        }
        if (this.quadrantPaint[2] != null && x > lowerBound && y > lowerBound2) {
            if (this.orientation == PlotOrientation.HORIZONTAL) {
                array[2] = new Rectangle2D.Double(Math.min(valueToJava2D5, valueToJava2D2), Math.min(valueToJava2D3, valueToJava2D), Math.abs(valueToJava2D2 - valueToJava2D5), Math.abs(valueToJava2D - valueToJava2D3));
            }
            else {
                array[2] = new Rectangle2D.Double(Math.min(valueToJava2D3, valueToJava2D), Math.min(valueToJava2D5, valueToJava2D2), Math.abs(valueToJava2D - valueToJava2D3), Math.abs(valueToJava2D2 - valueToJava2D5));
            }
            b = true;
        }
        if (this.quadrantPaint[3] != null && x < upperBound && y > lowerBound2) {
            if (this.orientation == PlotOrientation.HORIZONTAL) {
                array[3] = new Rectangle2D.Double(Math.min(valueToJava2D5, valueToJava2D2), Math.min(valueToJava2D4, valueToJava2D), Math.abs(valueToJava2D2 - valueToJava2D5), Math.abs(valueToJava2D - valueToJava2D4));
            }
            else {
                array[3] = new Rectangle2D.Double(Math.min(valueToJava2D, valueToJava2D4), Math.min(valueToJava2D5, valueToJava2D2), Math.abs(valueToJava2D - valueToJava2D4), Math.abs(valueToJava2D2 - valueToJava2D5));
            }
            b = true;
        }
        if (b) {
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, this.getBackgroundAlpha()));
            for (int i = 0; i < 4; ++i) {
                if (this.quadrantPaint[i] != null && array[i] != null) {
                    graphics2D.setPaint(this.quadrantPaint[i]);
                    graphics2D.fill(array[i]);
                }
            }
            graphics2D.setComposite(composite);
        }
    }
    
    public void drawDomainTickBands(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final List list) {
        if (this.getDomainTickBandPaint() != null) {
            boolean b = false;
            final ValueAxis domainAxis = this.getDomainAxis();
            double lowerBound = domainAxis.getLowerBound();
            final Iterator<ValueTick> iterator = list.iterator();
            while (iterator.hasNext()) {
                final double value = iterator.next().getValue();
                if (b) {
                    this.getRenderer().fillDomainGridBand(graphics2D, this, domainAxis, rectangle2D, lowerBound, value);
                }
                lowerBound = value;
                b = !b;
            }
            final double upperBound = domainAxis.getUpperBound();
            if (b) {
                this.getRenderer().fillDomainGridBand(graphics2D, this, domainAxis, rectangle2D, lowerBound, upperBound);
            }
        }
    }
    
    public void drawRangeTickBands(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final List list) {
        if (this.getRangeTickBandPaint() != null) {
            boolean b = false;
            final ValueAxis rangeAxis = this.getRangeAxis();
            double lowerBound = rangeAxis.getLowerBound();
            final Iterator<ValueTick> iterator = list.iterator();
            while (iterator.hasNext()) {
                final double value = iterator.next().getValue();
                if (b) {
                    this.getRenderer().fillRangeGridBand(graphics2D, this, rangeAxis, rectangle2D, lowerBound, value);
                }
                lowerBound = value;
                b = !b;
            }
            final double upperBound = rangeAxis.getUpperBound();
            if (b) {
                this.getRenderer().fillRangeGridBand(graphics2D, this, rangeAxis, rectangle2D, lowerBound, upperBound);
            }
        }
    }
    
    protected Map drawAxes(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final PlotRenderingInfo plotRenderingInfo) {
        final AxisCollection collection = new AxisCollection();
        for (int i = 0; i < this.domainAxes.size(); ++i) {
            final ValueAxis valueAxis = (ValueAxis)this.domainAxes.get(i);
            if (valueAxis != null) {
                collection.add(valueAxis, this.getDomainAxisEdge(i));
            }
        }
        for (int j = 0; j < this.rangeAxes.size(); ++j) {
            final ValueAxis valueAxis2 = (ValueAxis)this.rangeAxes.get(j);
            if (valueAxis2 != null) {
                collection.add(valueAxis2, this.getRangeAxisEdge(j));
            }
        }
        final HashMap<ValueAxis, AxisState> hashMap = new HashMap<ValueAxis, AxisState>();
        double cursor = rectangle2D2.getMinY() - this.axisOffset.calculateTopOutset(rectangle2D2.getHeight());
        for (final ValueAxis valueAxis3 : collection.getAxesAtTop()) {
            final AxisState draw = valueAxis3.draw(graphics2D, cursor, rectangle2D, rectangle2D2, RectangleEdge.TOP, plotRenderingInfo);
            cursor = draw.getCursor();
            hashMap.put(valueAxis3, draw);
        }
        double cursor2 = rectangle2D2.getMaxY() + this.axisOffset.calculateBottomOutset(rectangle2D2.getHeight());
        for (final ValueAxis valueAxis4 : collection.getAxesAtBottom()) {
            final AxisState draw2 = valueAxis4.draw(graphics2D, cursor2, rectangle2D, rectangle2D2, RectangleEdge.BOTTOM, plotRenderingInfo);
            cursor2 = draw2.getCursor();
            hashMap.put(valueAxis4, draw2);
        }
        double cursor3 = rectangle2D2.getMinX() - this.axisOffset.calculateLeftOutset(rectangle2D2.getWidth());
        for (final ValueAxis valueAxis5 : collection.getAxesAtLeft()) {
            final AxisState draw3 = valueAxis5.draw(graphics2D, cursor3, rectangle2D, rectangle2D2, RectangleEdge.LEFT, plotRenderingInfo);
            cursor3 = draw3.getCursor();
            hashMap.put(valueAxis5, draw3);
        }
        double cursor4 = rectangle2D2.getMaxX() + this.axisOffset.calculateRightOutset(rectangle2D2.getWidth());
        for (final ValueAxis valueAxis6 : collection.getAxesAtRight()) {
            final AxisState draw4 = valueAxis6.draw(graphics2D, cursor4, rectangle2D, rectangle2D2, RectangleEdge.RIGHT, plotRenderingInfo);
            cursor4 = draw4.getCursor();
            hashMap.put(valueAxis6, draw4);
        }
        return hashMap;
    }
    
    public boolean render(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final int n, final PlotRenderingInfo plotRenderingInfo, final CrosshairState crosshairState) {
        boolean b = false;
        final XYDataset dataset = this.getDataset(n);
        if (!DatasetUtilities.isEmptyOrNull(dataset)) {
            b = true;
            final ValueAxis domainAxisForDataset = this.getDomainAxisForDataset(n);
            final ValueAxis rangeAxisForDataset = this.getRangeAxisForDataset(n);
            XYItemRenderer xyItemRenderer = this.getRenderer(n);
            if (xyItemRenderer == null) {
                xyItemRenderer = this.getRenderer();
                if (xyItemRenderer == null) {
                    return b;
                }
            }
            final XYItemRendererState initialise = xyItemRenderer.initialise(graphics2D, rectangle2D, this, dataset, plotRenderingInfo);
            final int passCount = xyItemRenderer.getPassCount();
            if (this.getSeriesRenderingOrder() == SeriesRenderingOrder.REVERSE) {
                for (int i = 0; i < passCount; ++i) {
                    for (int j = dataset.getSeriesCount() - 1; j >= 0; --j) {
                        for (int itemCount = dataset.getItemCount(j), k = 0; k < itemCount; ++k) {
                            xyItemRenderer.drawItem(graphics2D, initialise, rectangle2D, plotRenderingInfo, this, domainAxisForDataset, rangeAxisForDataset, dataset, j, k, crosshairState, i);
                        }
                    }
                }
            }
            else {
                for (int l = 0; l < passCount; ++l) {
                    for (int seriesCount = dataset.getSeriesCount(), n2 = 0; n2 < seriesCount; ++n2) {
                        for (int itemCount2 = dataset.getItemCount(n2), n3 = 0; n3 < itemCount2; ++n3) {
                            xyItemRenderer.drawItem(graphics2D, initialise, rectangle2D, plotRenderingInfo, this, domainAxisForDataset, rangeAxisForDataset, dataset, n2, n3, crosshairState, l);
                        }
                    }
                }
            }
        }
        return b;
    }
    
    public ValueAxis getDomainAxisForDataset(final int n) {
        if (n < 0 || n >= this.getDatasetCount()) {
            throw new IllegalArgumentException("Index 'index' out of bounds.");
        }
        final Integer n2 = this.datasetToDomainAxisMap.get(new Integer(n));
        ValueAxis valueAxis;
        if (n2 != null) {
            valueAxis = this.getDomainAxis(n2);
        }
        else {
            valueAxis = this.getDomainAxis(0);
        }
        return valueAxis;
    }
    
    public ValueAxis getRangeAxisForDataset(final int n) {
        if (n < 0 || n >= this.getDatasetCount()) {
            throw new IllegalArgumentException("Index 'index' out of bounds.");
        }
        final Integer n2 = this.datasetToRangeAxisMap.get(new Integer(n));
        ValueAxis valueAxis;
        if (n2 != null) {
            valueAxis = this.getRangeAxis(n2);
        }
        else {
            valueAxis = this.getRangeAxis(0);
        }
        return valueAxis;
    }
    
    protected void drawDomainGridlines(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final List list) {
        if (this.getRenderer() == null) {
            return;
        }
        if (this.isDomainGridlinesVisible()) {
            final Stroke domainGridlineStroke = this.getDomainGridlineStroke();
            final Paint domainGridlinePaint = this.getDomainGridlinePaint();
            if (domainGridlineStroke != null && domainGridlinePaint != null) {
                final Iterator<ValueTick> iterator = list.iterator();
                while (iterator.hasNext()) {
                    this.getRenderer().drawDomainGridLine(graphics2D, this, this.getDomainAxis(), rectangle2D, iterator.next().getValue());
                }
            }
        }
    }
    
    protected void drawRangeGridlines(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final List list) {
        if (this.getRenderer() == null) {
            return;
        }
        if (this.isRangeGridlinesVisible()) {
            final Stroke rangeGridlineStroke = this.getRangeGridlineStroke();
            final Paint rangeGridlinePaint = this.getRangeGridlinePaint();
            if (this.getRangeAxis() != null) {
                for (final ValueTick valueTick : list) {
                    if (valueTick.getValue() != 0.0 || !this.isRangeZeroBaselineVisible()) {
                        this.getRenderer().drawRangeLine(graphics2D, this, this.getRangeAxis(), rectangle2D, valueTick.getValue(), rangeGridlinePaint, rangeGridlineStroke);
                    }
                }
            }
        }
    }
    
    protected void drawZeroDomainBaseline(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        if (this.isDomainZeroBaselineVisible()) {
            final XYItemRenderer renderer = this.getRenderer();
            if (renderer instanceof AbstractXYItemRenderer) {
                ((AbstractXYItemRenderer)renderer).drawDomainLine(graphics2D, this, this.getDomainAxis(), rectangle2D, 0.0, this.domainZeroBaselinePaint, this.domainZeroBaselineStroke);
            }
        }
    }
    
    protected void drawZeroRangeBaseline(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        if (this.isRangeZeroBaselineVisible()) {
            this.getRenderer().drawRangeLine(graphics2D, this, this.getRangeAxis(), rectangle2D, 0.0, this.rangeZeroBaselinePaint, this.rangeZeroBaselineStroke);
        }
    }
    
    public void drawAnnotations(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo) {
        final Iterator<XYAnnotation> iterator = this.annotations.iterator();
        while (iterator.hasNext()) {
            iterator.next().draw(graphics2D, this, rectangle2D, this.getDomainAxis(), this.getRangeAxis(), 0, plotRenderingInfo);
        }
    }
    
    protected void drawDomainMarkers(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final int n, final Layer layer) {
        final XYItemRenderer renderer = this.getRenderer(n);
        if (renderer == null) {
            return;
        }
        if (n >= this.getDatasetCount()) {
            return;
        }
        final Collection domainMarkers = this.getDomainMarkers(n, layer);
        final ValueAxis domainAxisForDataset = this.getDomainAxisForDataset(n);
        if (domainMarkers != null && domainAxisForDataset != null) {
            final Iterator<Marker> iterator = domainMarkers.iterator();
            while (iterator.hasNext()) {
                renderer.drawDomainMarker(graphics2D, this, domainAxisForDataset, iterator.next(), rectangle2D);
            }
        }
    }
    
    protected void drawRangeMarkers(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final int n, final Layer layer) {
        final XYItemRenderer renderer = this.getRenderer(n);
        if (renderer == null) {
            return;
        }
        if (n >= this.getDatasetCount()) {
            return;
        }
        final Collection rangeMarkers = this.getRangeMarkers(n, layer);
        final ValueAxis rangeAxisForDataset = this.getRangeAxisForDataset(n);
        if (rangeMarkers != null && rangeAxisForDataset != null) {
            final Iterator<Marker> iterator = rangeMarkers.iterator();
            while (iterator.hasNext()) {
                renderer.drawRangeMarker(graphics2D, this, rangeAxisForDataset, iterator.next(), rectangle2D);
            }
        }
    }
    
    public Collection getDomainMarkers(final Layer layer) {
        return this.getDomainMarkers(0, layer);
    }
    
    public Collection getRangeMarkers(final Layer layer) {
        return this.getRangeMarkers(0, layer);
    }
    
    public Collection getDomainMarkers(final int n, final Layer layer) {
        Object unmodifiableCollection = null;
        final Integer n2 = new Integer(n);
        if (layer == Layer.FOREGROUND) {
            unmodifiableCollection = this.foregroundDomainMarkers.get(n2);
        }
        else if (layer == Layer.BACKGROUND) {
            unmodifiableCollection = this.backgroundDomainMarkers.get(n2);
        }
        if (unmodifiableCollection != null) {
            unmodifiableCollection = Collections.unmodifiableCollection((Collection<?>)unmodifiableCollection);
        }
        return (Collection)unmodifiableCollection;
    }
    
    public Collection getRangeMarkers(final int n, final Layer layer) {
        Object unmodifiableCollection = null;
        final Integer n2 = new Integer(n);
        if (layer == Layer.FOREGROUND) {
            unmodifiableCollection = this.foregroundRangeMarkers.get(n2);
        }
        else if (layer == Layer.BACKGROUND) {
            unmodifiableCollection = this.backgroundRangeMarkers.get(n2);
        }
        if (unmodifiableCollection != null) {
            unmodifiableCollection = Collections.unmodifiableCollection((Collection<?>)unmodifiableCollection);
        }
        return (Collection)unmodifiableCollection;
    }
    
    protected void drawHorizontalLine(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n, final Stroke stroke, final Paint paint) {
        ValueAxis valueAxis = this.getRangeAxis();
        if (this.getOrientation() == PlotOrientation.HORIZONTAL) {
            valueAxis = this.getDomainAxis();
        }
        if (valueAxis.getRange().contains(n)) {
            final double valueToJava2D = valueAxis.valueToJava2D(n, rectangle2D, RectangleEdge.LEFT);
            final Line2D.Double double1 = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
            graphics2D.setStroke(stroke);
            graphics2D.setPaint(paint);
            graphics2D.draw(double1);
        }
    }
    
    protected void drawDomainCrosshair(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotOrientation plotOrientation, final double n, final ValueAxis valueAxis, final Stroke stroke, final Paint paint) {
        if (valueAxis.getRange().contains(n)) {
            Serializable s;
            if (plotOrientation == PlotOrientation.VERTICAL) {
                final double valueToJava2D = valueAxis.valueToJava2D(n, rectangle2D, RectangleEdge.BOTTOM);
                s = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
            }
            else {
                final double valueToJava2D2 = valueAxis.valueToJava2D(n, rectangle2D, RectangleEdge.LEFT);
                s = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D2, rectangle2D.getMaxX(), valueToJava2D2);
            }
            graphics2D.setStroke(stroke);
            graphics2D.setPaint(paint);
            graphics2D.draw((Shape)s);
        }
    }
    
    protected void drawVerticalLine(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n, final Stroke stroke, final Paint paint) {
        ValueAxis valueAxis = this.getDomainAxis();
        if (this.getOrientation() == PlotOrientation.HORIZONTAL) {
            valueAxis = this.getRangeAxis();
        }
        if (valueAxis.getRange().contains(n)) {
            final double valueToJava2D = valueAxis.valueToJava2D(n, rectangle2D, RectangleEdge.BOTTOM);
            final Line2D.Double double1 = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
            graphics2D.setStroke(stroke);
            graphics2D.setPaint(paint);
            graphics2D.draw(double1);
        }
    }
    
    protected void drawRangeCrosshair(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotOrientation plotOrientation, final double n, final ValueAxis valueAxis, final Stroke stroke, final Paint paint) {
        if (valueAxis.getRange().contains(n)) {
            Serializable s;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                final double valueToJava2D = valueAxis.valueToJava2D(n, rectangle2D, RectangleEdge.BOTTOM);
                s = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
            }
            else {
                final double valueToJava2D2 = valueAxis.valueToJava2D(n, rectangle2D, RectangleEdge.LEFT);
                s = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D2, rectangle2D.getMaxX(), valueToJava2D2);
            }
            graphics2D.setStroke(stroke);
            graphics2D.setPaint(paint);
            graphics2D.draw((Shape)s);
        }
    }
    
    public void handleClick(final int n, final int n2, final PlotRenderingInfo plotRenderingInfo) {
        if (plotRenderingInfo.getDataArea().contains(n, n2)) {
            final ValueAxis domainAxis = this.getDomainAxis();
            if (domainAxis != null) {
                this.setDomainCrosshairValue(domainAxis.java2DToValue(n, plotRenderingInfo.getDataArea(), this.getDomainAxisEdge()));
            }
            final ValueAxis rangeAxis = this.getRangeAxis();
            if (rangeAxis != null) {
                this.setRangeCrosshairValue(rangeAxis.java2DToValue(n2, plotRenderingInfo.getDataArea(), this.getRangeAxisEdge()));
            }
        }
    }
    
    private List getDatasetsMappedToDomainAxis(final Integer n) {
        if (n == null) {
            throw new IllegalArgumentException("Null 'axisIndex' argument.");
        }
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < this.datasets.size(); ++i) {
            final Integer n2 = this.datasetToDomainAxisMap.get(new Integer(i));
            if (n2 == null) {
                if (n.equals(XYPlot.ZERO)) {
                    list.add(this.datasets.get(i));
                }
            }
            else if (n2.equals(n)) {
                list.add(this.datasets.get(i));
            }
        }
        return list;
    }
    
    private List getDatasetsMappedToRangeAxis(final Integer n) {
        if (n == null) {
            throw new IllegalArgumentException("Null 'axisIndex' argument.");
        }
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < this.datasets.size(); ++i) {
            final Integer n2 = this.datasetToRangeAxisMap.get(new Integer(i));
            if (n2 == null) {
                if (n.equals(XYPlot.ZERO)) {
                    list.add(this.datasets.get(i));
                }
            }
            else if (n2.equals(n)) {
                list.add(this.datasets.get(i));
            }
        }
        return list;
    }
    
    public int getDomainAxisIndex(final ValueAxis valueAxis) {
        int n = this.domainAxes.indexOf(valueAxis);
        if (n < 0) {
            final Plot parent = this.getParent();
            if (parent instanceof XYPlot) {
                n = ((XYPlot)parent).getDomainAxisIndex(valueAxis);
            }
        }
        return n;
    }
    
    public int getRangeAxisIndex(final ValueAxis valueAxis) {
        int n = this.rangeAxes.indexOf(valueAxis);
        if (n < 0) {
            final Plot parent = this.getParent();
            if (parent instanceof XYPlot) {
                n = ((XYPlot)parent).getRangeAxisIndex(valueAxis);
            }
        }
        return n;
    }
    
    public Range getDataRange(final ValueAxis valueAxis) {
        Range range = null;
        final ArrayList<XYDataset> list = new ArrayList<XYDataset>();
        boolean b = true;
        final int domainAxisIndex = this.getDomainAxisIndex(valueAxis);
        if (domainAxisIndex >= 0) {
            b = true;
            list.addAll((Collection<?>)this.getDatasetsMappedToDomainAxis(new Integer(domainAxisIndex)));
        }
        final int rangeAxisIndex = this.getRangeAxisIndex(valueAxis);
        if (rangeAxisIndex >= 0) {
            b = false;
            list.addAll((Collection<?>)this.getDatasetsMappedToRangeAxis(new Integer(rangeAxisIndex)));
        }
        for (final XYDataset xyDataset : list) {
            if (xyDataset != null) {
                final XYItemRenderer rendererForDataset = this.getRendererForDataset(xyDataset);
                if (b) {
                    if (rendererForDataset != null) {
                        range = Range.combine(range, rendererForDataset.findDomainBounds(xyDataset));
                    }
                    else {
                        range = Range.combine(range, DatasetUtilities.findDomainBounds(xyDataset));
                    }
                }
                else if (rendererForDataset != null) {
                    range = Range.combine(range, rendererForDataset.findRangeBounds(xyDataset));
                }
                else {
                    range = Range.combine(range, DatasetUtilities.findRangeBounds(xyDataset));
                }
            }
        }
        return range;
    }
    
    public void datasetChanged(final DatasetChangeEvent datasetChangeEvent) {
        this.configureDomainAxes();
        this.configureRangeAxes();
        if (this.getParent() != null) {
            this.getParent().datasetChanged(datasetChangeEvent);
        }
        else {
            final PlotChangeEvent plotChangeEvent = new PlotChangeEvent(this);
            plotChangeEvent.setType(ChartChangeEventType.DATASET_UPDATED);
            this.notifyListeners(plotChangeEvent);
        }
    }
    
    public void rendererChanged(final RendererChangeEvent rendererChangeEvent) {
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isDomainCrosshairVisible() {
        return this.domainCrosshairVisible;
    }
    
    public void setDomainCrosshairVisible(final boolean domainCrosshairVisible) {
        if (this.domainCrosshairVisible != domainCrosshairVisible) {
            this.domainCrosshairVisible = domainCrosshairVisible;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public boolean isDomainCrosshairLockedOnData() {
        return this.domainCrosshairLockedOnData;
    }
    
    public void setDomainCrosshairLockedOnData(final boolean domainCrosshairLockedOnData) {
        if (this.domainCrosshairLockedOnData != domainCrosshairLockedOnData) {
            this.domainCrosshairLockedOnData = domainCrosshairLockedOnData;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public double getDomainCrosshairValue() {
        return this.domainCrosshairValue;
    }
    
    public void setDomainCrosshairValue(final double n) {
        this.setDomainCrosshairValue(n, true);
    }
    
    public void setDomainCrosshairValue(final double domainCrosshairValue, final boolean b) {
        this.domainCrosshairValue = domainCrosshairValue;
        if (this.isDomainCrosshairVisible() && b) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Stroke getDomainCrosshairStroke() {
        return this.domainCrosshairStroke;
    }
    
    public void setDomainCrosshairStroke(final Stroke domainCrosshairStroke) {
        if (domainCrosshairStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.domainCrosshairStroke = domainCrosshairStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getDomainCrosshairPaint() {
        return this.domainCrosshairPaint;
    }
    
    public void setDomainCrosshairPaint(final Paint domainCrosshairPaint) {
        if (domainCrosshairPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.domainCrosshairPaint = domainCrosshairPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isRangeCrosshairVisible() {
        return this.rangeCrosshairVisible;
    }
    
    public void setRangeCrosshairVisible(final boolean rangeCrosshairVisible) {
        if (this.rangeCrosshairVisible != rangeCrosshairVisible) {
            this.rangeCrosshairVisible = rangeCrosshairVisible;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public boolean isRangeCrosshairLockedOnData() {
        return this.rangeCrosshairLockedOnData;
    }
    
    public void setRangeCrosshairLockedOnData(final boolean rangeCrosshairLockedOnData) {
        if (this.rangeCrosshairLockedOnData != rangeCrosshairLockedOnData) {
            this.rangeCrosshairLockedOnData = rangeCrosshairLockedOnData;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public double getRangeCrosshairValue() {
        return this.rangeCrosshairValue;
    }
    
    public void setRangeCrosshairValue(final double n) {
        this.setRangeCrosshairValue(n, true);
    }
    
    public void setRangeCrosshairValue(final double rangeCrosshairValue, final boolean b) {
        this.rangeCrosshairValue = rangeCrosshairValue;
        if (this.isRangeCrosshairVisible() && b) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Stroke getRangeCrosshairStroke() {
        return this.rangeCrosshairStroke;
    }
    
    public void setRangeCrosshairStroke(final Stroke rangeCrosshairStroke) {
        if (rangeCrosshairStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.rangeCrosshairStroke = rangeCrosshairStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getRangeCrosshairPaint() {
        return this.rangeCrosshairPaint;
    }
    
    public void setRangeCrosshairPaint(final Paint rangeCrosshairPaint) {
        if (rangeCrosshairPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.rangeCrosshairPaint = rangeCrosshairPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public AxisSpace getFixedDomainAxisSpace() {
        return this.fixedDomainAxisSpace;
    }
    
    public void setFixedDomainAxisSpace(final AxisSpace fixedDomainAxisSpace) {
        this.fixedDomainAxisSpace = fixedDomainAxisSpace;
    }
    
    public AxisSpace getFixedRangeAxisSpace() {
        return this.fixedRangeAxisSpace;
    }
    
    public void setFixedRangeAxisSpace(final AxisSpace fixedRangeAxisSpace) {
        this.fixedRangeAxisSpace = fixedRangeAxisSpace;
    }
    
    public void zoomDomainAxes(final double n, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        for (int i = 0; i < this.domainAxes.size(); ++i) {
            final ValueAxis valueAxis = (ValueAxis)this.domainAxes.get(i);
            if (valueAxis != null) {
                valueAxis.resizeRange(n);
            }
        }
    }
    
    public void zoomDomainAxes(final double n, final double n2, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        for (int i = 0; i < this.domainAxes.size(); ++i) {
            final ValueAxis valueAxis = (ValueAxis)this.domainAxes.get(i);
            if (valueAxis != null) {
                valueAxis.zoomRange(n, n2);
            }
        }
    }
    
    public void zoomRangeAxes(final double n, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        for (int i = 0; i < this.rangeAxes.size(); ++i) {
            final ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(i);
            if (valueAxis != null) {
                valueAxis.resizeRange(n);
            }
        }
    }
    
    public void zoomRangeAxes(final double n, final double n2, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        for (int i = 0; i < this.rangeAxes.size(); ++i) {
            final ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(i);
            if (valueAxis != null) {
                valueAxis.zoomRange(n, n2);
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
        int seriesCount = 0;
        final XYDataset dataset = this.getDataset();
        if (dataset != null) {
            seriesCount = dataset.getSeriesCount();
        }
        return seriesCount;
    }
    
    public LegendItemCollection getFixedLegendItems() {
        return this.fixedLegendItems;
    }
    
    public void setFixedLegendItems(final LegendItemCollection fixedLegendItems) {
        this.fixedLegendItems = fixedLegendItems;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public LegendItemCollection getLegendItems() {
        if (this.fixedLegendItems != null) {
            return this.fixedLegendItems;
        }
        final LegendItemCollection collection = new LegendItemCollection();
        for (int size = this.datasets.size(), i = 0; i < size; ++i) {
            final XYDataset dataset = this.getDataset(i);
            if (dataset != null) {
                XYItemRenderer xyItemRenderer = this.getRenderer(i);
                if (xyItemRenderer == null) {
                    xyItemRenderer = this.getRenderer(0);
                }
                if (xyItemRenderer != null) {
                    for (int seriesCount = dataset.getSeriesCount(), j = 0; j < seriesCount; ++j) {
                        if (xyItemRenderer.isSeriesVisible(j) && xyItemRenderer.isSeriesVisibleInLegend(j)) {
                            final LegendItem legendItem = xyItemRenderer.getLegendItem(i, j);
                            if (legendItem != null) {
                                collection.add(legendItem);
                            }
                        }
                    }
                }
            }
        }
        return collection;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYPlot)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final XYPlot xyPlot = (XYPlot)o;
        if (this.weight != xyPlot.weight) {
            return false;
        }
        if (this.orientation != xyPlot.orientation) {
            return false;
        }
        if (!this.domainAxes.equals(xyPlot.domainAxes)) {
            return false;
        }
        if (!this.domainAxisLocations.equals(xyPlot.domainAxisLocations)) {
            return false;
        }
        if (this.rangeCrosshairLockedOnData != xyPlot.rangeCrosshairLockedOnData) {
            return false;
        }
        if (this.domainGridlinesVisible != xyPlot.domainGridlinesVisible) {
            return false;
        }
        if (this.rangeGridlinesVisible != xyPlot.rangeGridlinesVisible) {
            return false;
        }
        if (this.domainZeroBaselineVisible != xyPlot.domainZeroBaselineVisible) {
            return false;
        }
        if (this.rangeZeroBaselineVisible != xyPlot.rangeZeroBaselineVisible) {
            return false;
        }
        if (this.domainCrosshairVisible != xyPlot.domainCrosshairVisible) {
            return false;
        }
        if (this.domainCrosshairValue != xyPlot.domainCrosshairValue) {
            return false;
        }
        if (this.domainCrosshairLockedOnData != xyPlot.domainCrosshairLockedOnData) {
            return false;
        }
        if (this.rangeCrosshairVisible != xyPlot.rangeCrosshairVisible) {
            return false;
        }
        if (this.rangeCrosshairValue != xyPlot.rangeCrosshairValue) {
            return false;
        }
        if (!ObjectUtilities.equal(this.axisOffset, xyPlot.axisOffset)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.renderers, xyPlot.renderers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeAxes, xyPlot.rangeAxes)) {
            return false;
        }
        if (!this.rangeAxisLocations.equals(xyPlot.rangeAxisLocations)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.datasetToDomainAxisMap, xyPlot.datasetToDomainAxisMap)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.datasetToRangeAxisMap, xyPlot.datasetToRangeAxisMap)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.domainGridlineStroke, xyPlot.domainGridlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.domainGridlinePaint, xyPlot.domainGridlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeGridlineStroke, xyPlot.rangeGridlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.rangeGridlinePaint, xyPlot.rangeGridlinePaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.domainZeroBaselinePaint, xyPlot.domainZeroBaselinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.domainZeroBaselineStroke, xyPlot.domainZeroBaselineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.rangeZeroBaselinePaint, xyPlot.rangeZeroBaselinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeZeroBaselineStroke, xyPlot.rangeZeroBaselineStroke)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.domainCrosshairStroke, xyPlot.domainCrosshairStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.domainCrosshairPaint, xyPlot.domainCrosshairPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeCrosshairStroke, xyPlot.rangeCrosshairStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.rangeCrosshairPaint, xyPlot.rangeCrosshairPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.foregroundDomainMarkers, xyPlot.foregroundDomainMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundDomainMarkers, xyPlot.backgroundDomainMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.foregroundRangeMarkers, xyPlot.foregroundRangeMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundRangeMarkers, xyPlot.backgroundRangeMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.foregroundDomainMarkers, xyPlot.foregroundDomainMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundDomainMarkers, xyPlot.backgroundDomainMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.foregroundRangeMarkers, xyPlot.foregroundRangeMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundRangeMarkers, xyPlot.backgroundRangeMarkers)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.annotations, xyPlot.annotations)) {
            return false;
        }
        if (!this.quadrantOrigin.equals(xyPlot.quadrantOrigin)) {
            return false;
        }
        for (int i = 0; i < 4; ++i) {
            if (!PaintUtilities.equal(this.quadrantPaint[i], xyPlot.quadrantPaint[i])) {
                return false;
            }
        }
        return true;
    }
    
    public Object clone() {
        final XYPlot xyPlot = (XYPlot)super.clone();
        xyPlot.domainAxes = (ObjectList)ObjectUtilities.clone(this.domainAxes);
        for (int i = 0; i < this.domainAxes.size(); ++i) {
            final ValueAxis valueAxis = (ValueAxis)this.domainAxes.get(i);
            if (valueAxis != null) {
                final ValueAxis valueAxis2 = (ValueAxis)valueAxis.clone();
                xyPlot.domainAxes.set(i, valueAxis2);
                valueAxis2.setPlot(xyPlot);
                valueAxis2.addChangeListener(xyPlot);
            }
        }
        xyPlot.domainAxisLocations = (ObjectList)this.domainAxisLocations.clone();
        xyPlot.rangeAxes = (ObjectList)ObjectUtilities.clone(this.rangeAxes);
        for (int j = 0; j < this.rangeAxes.size(); ++j) {
            final ValueAxis valueAxis3 = (ValueAxis)this.rangeAxes.get(j);
            if (valueAxis3 != null) {
                final ValueAxis valueAxis4 = (ValueAxis)valueAxis3.clone();
                xyPlot.rangeAxes.set(j, valueAxis4);
                valueAxis4.setPlot(xyPlot);
                valueAxis4.addChangeListener(xyPlot);
            }
        }
        xyPlot.rangeAxisLocations = (ObjectList)ObjectUtilities.clone(this.rangeAxisLocations);
        xyPlot.datasets = (ObjectList)ObjectUtilities.clone(this.datasets);
        for (int k = 0; k < xyPlot.datasets.size(); ++k) {
            final XYDataset dataset = this.getDataset(k);
            if (dataset != null) {
                dataset.addChangeListener(xyPlot);
            }
        }
        (xyPlot.datasetToDomainAxisMap = new TreeMap()).putAll(this.datasetToDomainAxisMap);
        (xyPlot.datasetToRangeAxisMap = new TreeMap()).putAll(this.datasetToRangeAxisMap);
        xyPlot.renderers = (ObjectList)ObjectUtilities.clone(this.renderers);
        for (int l = 0; l < this.renderers.size(); ++l) {
            final XYItemRenderer xyItemRenderer = (XYItemRenderer)this.renderers.get(l);
            if (xyItemRenderer instanceof PublicCloneable) {
                xyPlot.renderers.set(l, ((PublicCloneable)xyItemRenderer).clone());
            }
        }
        xyPlot.foregroundDomainMarkers = (Map)ObjectUtilities.clone(this.foregroundDomainMarkers);
        xyPlot.backgroundDomainMarkers = (Map)ObjectUtilities.clone(this.backgroundDomainMarkers);
        xyPlot.foregroundRangeMarkers = (Map)ObjectUtilities.clone(this.foregroundRangeMarkers);
        xyPlot.backgroundRangeMarkers = (Map)ObjectUtilities.clone(this.backgroundRangeMarkers);
        xyPlot.annotations = (List)ObjectUtilities.deepClone(this.annotations);
        if (this.fixedDomainAxisSpace != null) {
            xyPlot.fixedDomainAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedDomainAxisSpace);
        }
        if (this.fixedRangeAxisSpace != null) {
            xyPlot.fixedRangeAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedRangeAxisSpace);
        }
        xyPlot.quadrantOrigin = (Point2D)ObjectUtilities.clone(this.quadrantOrigin);
        xyPlot.quadrantPaint = this.quadrantPaint.clone();
        return xyPlot;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
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
        for (int i = 0; i < 4; ++i) {
            SerialUtilities.writePaint(this.quadrantPaint[i], objectOutputStream);
        }
        SerialUtilities.writeStroke(this.domainZeroBaselineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.domainZeroBaselinePaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
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
        for (int i = 0; i < 4; ++i) {
            this.quadrantPaint[i] = SerialUtilities.readPaint(objectInputStream);
        }
        this.domainZeroBaselineStroke = SerialUtilities.readStroke(objectInputStream);
        this.domainZeroBaselinePaint = SerialUtilities.readPaint(objectInputStream);
        for (int size = this.domainAxes.size(), j = 0; j < size; ++j) {
            final Axis axis = (Axis)this.domainAxes.get(j);
            if (axis != null) {
                axis.setPlot(this);
                axis.addChangeListener(this);
            }
        }
        for (int size2 = this.rangeAxes.size(), k = 0; k < size2; ++k) {
            final Axis axis2 = (Axis)this.rangeAxes.get(k);
            if (axis2 != null) {
                axis2.setPlot(this);
                axis2.addChangeListener(this);
            }
        }
        for (int size3 = this.datasets.size(), l = 0; l < size3; ++l) {
            final Dataset dataset = (Dataset)this.datasets.get(l);
            if (dataset != null) {
                dataset.addChangeListener(this);
            }
        }
        for (int size4 = this.renderers.size(), n = 0; n < size4; ++n) {
            final XYItemRenderer xyItemRenderer = (XYItemRenderer)this.renderers.get(n);
            if (xyItemRenderer != null) {
                xyItemRenderer.addChangeListener(this);
            }
        }
    }
    
    static {
        DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5f, 0, 2, 0.0f, new float[] { 2.0f, 2.0f }, 0.0f);
        DEFAULT_GRIDLINE_PAINT = Color.lightGray;
        DEFAULT_CROSSHAIR_STROKE = XYPlot.DEFAULT_GRIDLINE_STROKE;
        DEFAULT_CROSSHAIR_PAINT = Color.blue;
        XYPlot.localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    }
}
