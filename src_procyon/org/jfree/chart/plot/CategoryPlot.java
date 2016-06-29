package org.jfree.chart.plot;

import org.jfree.data.category.*;
import org.jfree.ui.*;
import org.jfree.chart.event.*;
import java.util.*;
import org.jfree.chart.annotations.*;
import org.jfree.chart.*;
import java.awt.*;
import org.jfree.data.general.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.axis.*;
import java.awt.geom.*;
import org.jfree.data.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class CategoryPlot extends Plot implements Serializable, Cloneable, RendererChangeListener, ValueAxisPlot, Zoomable, PublicCloneable
{
    private static final long serialVersionUID = -3537691700434728188L;
    public static final boolean DEFAULT_DOMAIN_GRIDLINES_VISIBLE = false;
    public static final boolean DEFAULT_RANGE_GRIDLINES_VISIBLE = true;
    public static final Stroke DEFAULT_GRIDLINE_STROKE;
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
        this(null, null, null, null);
    }
    
    public CategoryPlot(final CategoryDataset categoryDataset, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryItemRenderer categoryItemRenderer) {
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
        (this.datasets = new ObjectList()).set(0, categoryDataset);
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
        this.domainGridlineStroke = CategoryPlot.DEFAULT_GRIDLINE_STROKE;
        this.domainGridlinePaint = CategoryPlot.DEFAULT_GRIDLINE_PAINT;
        this.rangeGridlinesVisible = true;
        this.rangeGridlineStroke = CategoryPlot.DEFAULT_GRIDLINE_STROKE;
        this.rangeGridlinePaint = CategoryPlot.DEFAULT_GRIDLINE_PAINT;
        this.foregroundDomainMarkers = new HashMap();
        this.backgroundDomainMarkers = new HashMap();
        this.foregroundRangeMarkers = new HashMap();
        this.backgroundRangeMarkers = new HashMap();
        this.addRangeMarker(new ValueMarker(0.0, new Color(0.8f, 0.8f, 0.8f, 0.5f), new BasicStroke(1.0f), new Color(0.85f, 0.85f, 0.95f, 0.5f), new BasicStroke(1.0f), 0.6f), Layer.BACKGROUND);
        this.anchorValue = 0.0;
        this.rangeCrosshairVisible = false;
        this.rangeCrosshairValue = 0.0;
        this.rangeCrosshairStroke = CategoryPlot.DEFAULT_CROSSHAIR_STROKE;
        this.rangeCrosshairPaint = CategoryPlot.DEFAULT_CROSSHAIR_PAINT;
        this.annotations = new ArrayList();
    }
    
    public String getPlotType() {
        return CategoryPlot.localizationResources.getString("Category_Plot");
    }
    
    public PlotOrientation getOrientation() {
        return this.orientation;
    }
    
    public void setOrientation(final PlotOrientation orientation) {
        if (orientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        this.orientation = orientation;
        this.notifyListeners(new PlotChangeEvent(this));
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
    
    public CategoryAxis getDomainAxis() {
        return this.getDomainAxis(0);
    }
    
    public CategoryAxis getDomainAxis(final int n) {
        CategoryAxis domainAxis = null;
        if (n < this.domainAxes.size()) {
            domainAxis = (CategoryAxis)this.domainAxes.get(n);
        }
        if (domainAxis == null) {
            final Plot parent = this.getParent();
            if (parent instanceof CategoryPlot) {
                domainAxis = ((CategoryPlot)parent).getDomainAxis(n);
            }
        }
        return domainAxis;
    }
    
    public void setDomainAxis(final CategoryAxis categoryAxis) {
        this.setDomainAxis(0, categoryAxis);
    }
    
    public void setDomainAxis(final int n, final CategoryAxis categoryAxis) {
        this.setDomainAxis(n, categoryAxis, true);
    }
    
    public void setDomainAxis(final int n, final CategoryAxis categoryAxis, final boolean b) {
        final CategoryAxis categoryAxis2 = (CategoryAxis)this.domainAxes.get(n);
        if (categoryAxis2 != null) {
            categoryAxis2.removeChangeListener(this);
        }
        if (categoryAxis != null) {
            categoryAxis.setPlot(this);
        }
        this.domainAxes.set(n, categoryAxis);
        if (categoryAxis != null) {
            categoryAxis.configure();
            categoryAxis.addChangeListener(this);
        }
        if (b) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void setDomainAxes(final CategoryAxis[] array) {
        for (int i = 0; i < array.length; ++i) {
            this.setDomainAxis(i, array[i], false);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public int getDomainAxisIndex(final CategoryAxis categoryAxis) {
        return this.domainAxes.indexOf(categoryAxis);
    }
    
    public AxisLocation getDomainAxisLocation() {
        return this.getDomainAxisLocation(0);
    }
    
    public AxisLocation getDomainAxisLocation(final int n) {
        AxisLocation opposite = null;
        if (n < this.domainAxisLocations.size()) {
            opposite = (AxisLocation)this.domainAxisLocations.get(n);
        }
        if (opposite == null) {
            opposite = AxisLocation.getOpposite(this.getDomainAxisLocation(0));
        }
        return opposite;
    }
    
    public void setDomainAxisLocation(final AxisLocation axisLocation) {
        this.setDomainAxisLocation(0, axisLocation, true);
    }
    
    public void setDomainAxisLocation(final AxisLocation axisLocation, final boolean b) {
        this.setDomainAxisLocation(0, axisLocation, b);
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
    
    public RectangleEdge getDomainAxisEdge() {
        return this.getDomainAxisEdge(0);
    }
    
    public RectangleEdge getDomainAxisEdge(final int n) {
        final AxisLocation domainAxisLocation = this.getDomainAxisLocation(n);
        RectangleEdge rectangleEdge;
        if (domainAxisLocation != null) {
            rectangleEdge = Plot.resolveDomainAxisLocation(domainAxisLocation, this.orientation);
        }
        else {
            rectangleEdge = RectangleEdge.opposite(this.getDomainAxisEdge(0));
        }
        return rectangleEdge;
    }
    
    public int getDomainAxisCount() {
        return this.domainAxes.size();
    }
    
    public void clearDomainAxes() {
        for (int i = 0; i < this.domainAxes.size(); ++i) {
            final CategoryAxis categoryAxis = (CategoryAxis)this.domainAxes.get(i);
            if (categoryAxis != null) {
                categoryAxis.removeChangeListener(this);
            }
        }
        this.domainAxes.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void configureDomainAxes() {
        for (int i = 0; i < this.domainAxes.size(); ++i) {
            final CategoryAxis categoryAxis = (CategoryAxis)this.domainAxes.get(i);
            if (categoryAxis != null) {
                categoryAxis.configure();
            }
        }
    }
    
    public ValueAxis getRangeAxis() {
        return this.getRangeAxis(0);
    }
    
    public ValueAxis getRangeAxis(final int n) {
        ValueAxis rangeAxis = null;
        if (n < this.rangeAxes.size()) {
            rangeAxis = (ValueAxis)this.rangeAxes.get(n);
        }
        if (rangeAxis == null) {
            final Plot parent = this.getParent();
            if (parent instanceof CategoryPlot) {
                rangeAxis = ((CategoryPlot)parent).getRangeAxis(n);
            }
        }
        return rangeAxis;
    }
    
    public void setRangeAxis(final ValueAxis valueAxis) {
        this.setRangeAxis(0, valueAxis);
    }
    
    public void setRangeAxis(final int n, final ValueAxis valueAxis) {
        this.setRangeAxis(n, valueAxis, true);
    }
    
    public void setRangeAxis(final int n, final ValueAxis valueAxis, final boolean b) {
        final ValueAxis valueAxis2 = (ValueAxis)this.rangeAxes.get(n);
        if (valueAxis2 != null) {
            valueAxis2.removeChangeListener(this);
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
    
    public AxisLocation getRangeAxisLocation() {
        return this.getRangeAxisLocation(0);
    }
    
    public AxisLocation getRangeAxisLocation(final int n) {
        AxisLocation opposite = null;
        if (n < this.rangeAxisLocations.size()) {
            opposite = (AxisLocation)this.rangeAxisLocations.get(n);
        }
        if (opposite == null) {
            opposite = AxisLocation.getOpposite(this.getRangeAxisLocation(0));
        }
        return opposite;
    }
    
    public void setRangeAxisLocation(final AxisLocation axisLocation) {
        this.setRangeAxisLocation(axisLocation, true);
    }
    
    public void setRangeAxisLocation(final AxisLocation axisLocation, final boolean b) {
        this.setRangeAxisLocation(0, axisLocation, b);
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
    
    public RectangleEdge getRangeAxisEdge() {
        return this.getRangeAxisEdge(0);
    }
    
    public RectangleEdge getRangeAxisEdge(final int n) {
        RectangleEdge rectangleEdge = Plot.resolveRangeAxisLocation(this.getRangeAxisLocation(n), this.orientation);
        if (rectangleEdge == null) {
            rectangleEdge = RectangleEdge.opposite(this.getRangeAxisEdge(0));
        }
        return rectangleEdge;
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
    
    public CategoryDataset getDataset() {
        return this.getDataset(0);
    }
    
    public CategoryDataset getDataset(final int n) {
        CategoryDataset categoryDataset = null;
        if (this.datasets.size() > n) {
            categoryDataset = (CategoryDataset)this.datasets.get(n);
        }
        return categoryDataset;
    }
    
    public void setDataset(final CategoryDataset categoryDataset) {
        this.setDataset(0, categoryDataset);
    }
    
    public void setDataset(final int n, final CategoryDataset categoryDataset) {
        final CategoryDataset categoryDataset2 = (CategoryDataset)this.datasets.get(n);
        if (categoryDataset2 != null) {
            categoryDataset2.removeChangeListener(this);
        }
        this.datasets.set(n, categoryDataset);
        if (categoryDataset != null) {
            categoryDataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, categoryDataset));
    }
    
    public int getDatasetCount() {
        return this.datasets.size();
    }
    
    public void mapDatasetToDomainAxis(final int n, final int n2) {
        this.datasetToDomainAxisMap.set(n, new Integer(n2));
        this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(n)));
    }
    
    public CategoryAxis getDomainAxisForDataset(final int n) {
        CategoryAxis categoryAxis = this.getDomainAxis();
        final Integer n2 = (Integer)this.datasetToDomainAxisMap.get(n);
        if (n2 != null) {
            categoryAxis = this.getDomainAxis(n2);
        }
        return categoryAxis;
    }
    
    public void mapDatasetToRangeAxis(final int n, final int n2) {
        this.datasetToRangeAxisMap.set(n, new Integer(n2));
        this.datasetChanged(new DatasetChangeEvent(this, this.getDataset(n)));
    }
    
    public ValueAxis getRangeAxisForDataset(final int n) {
        ValueAxis valueAxis = this.getRangeAxis();
        final Integer n2 = (Integer)this.datasetToRangeAxisMap.get(n);
        if (n2 != null) {
            valueAxis = this.getRangeAxis(n2);
        }
        return valueAxis;
    }
    
    public CategoryItemRenderer getRenderer() {
        return this.getRenderer(0);
    }
    
    public CategoryItemRenderer getRenderer(final int n) {
        CategoryItemRenderer categoryItemRenderer = null;
        if (this.renderers.size() > n) {
            categoryItemRenderer = (CategoryItemRenderer)this.renderers.get(n);
        }
        return categoryItemRenderer;
    }
    
    public void setRenderer(final CategoryItemRenderer categoryItemRenderer) {
        this.setRenderer(0, categoryItemRenderer, true);
    }
    
    public void setRenderer(final CategoryItemRenderer categoryItemRenderer, final boolean b) {
        this.setRenderer(0, categoryItemRenderer, b);
    }
    
    public void setRenderer(final int n, final CategoryItemRenderer categoryItemRenderer) {
        this.setRenderer(n, categoryItemRenderer, true);
    }
    
    public void setRenderer(final int n, final CategoryItemRenderer categoryItemRenderer, final boolean b) {
        final CategoryItemRenderer categoryItemRenderer2 = (CategoryItemRenderer)this.renderers.get(n);
        if (categoryItemRenderer2 != null) {
            categoryItemRenderer2.removeChangeListener(this);
        }
        this.renderers.set(n, categoryItemRenderer);
        if (categoryItemRenderer != null) {
            categoryItemRenderer.setPlot(this);
            categoryItemRenderer.addChangeListener(this);
        }
        this.configureDomainAxes();
        this.configureRangeAxes();
        if (b) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void setRenderers(final CategoryItemRenderer[] array) {
        for (int i = 0; i < array.length; ++i) {
            this.setRenderer(i, array[i], false);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public CategoryItemRenderer getRendererForDataset(final CategoryDataset categoryDataset) {
        CategoryItemRenderer categoryItemRenderer = null;
        for (int i = 0; i < this.datasets.size(); ++i) {
            if (this.datasets.get(i) == categoryDataset) {
                categoryItemRenderer = (CategoryItemRenderer)this.renderers.get(i);
                break;
            }
        }
        return categoryItemRenderer;
    }
    
    public int getIndexOf(final CategoryItemRenderer categoryItemRenderer) {
        return this.renderers.indexOf(categoryItemRenderer);
    }
    
    public DatasetRenderingOrder getDatasetRenderingOrder() {
        return this.renderingOrder;
    }
    
    public void setDatasetRenderingOrder(final DatasetRenderingOrder renderingOrder) {
        if (renderingOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.renderingOrder = renderingOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public SortOrder getColumnRenderingOrder() {
        return this.columnRenderingOrder;
    }
    
    public void setColumnRenderingOrder(final SortOrder columnRenderingOrder) {
        if (columnRenderingOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.columnRenderingOrder = columnRenderingOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public SortOrder getRowRenderingOrder() {
        return this.rowRenderingOrder;
    }
    
    public void setRowRenderingOrder(final SortOrder rowRenderingOrder) {
        if (rowRenderingOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.rowRenderingOrder = rowRenderingOrder;
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
    
    public CategoryAnchor getDomainGridlinePosition() {
        return this.domainGridlinePosition;
    }
    
    public void setDomainGridlinePosition(final CategoryAnchor domainGridlinePosition) {
        if (domainGridlinePosition == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        this.domainGridlinePosition = domainGridlinePosition;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getDomainGridlineStroke() {
        return this.domainGridlineStroke;
    }
    
    public void setDomainGridlineStroke(final Stroke domainGridlineStroke) {
        if (domainGridlineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' not permitted.");
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
    
    public LegendItemCollection getFixedLegendItems() {
        return this.fixedLegendItems;
    }
    
    public void setFixedLegendItems(final LegendItemCollection fixedLegendItems) {
        this.fixedLegendItems = fixedLegendItems;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public LegendItemCollection getLegendItems() {
        LegendItemCollection fixedLegendItems = this.fixedLegendItems;
        if (fixedLegendItems == null) {
            fixedLegendItems = new LegendItemCollection();
            for (int size = this.datasets.size(), i = 0; i < size; ++i) {
                final CategoryDataset dataset = this.getDataset(i);
                if (dataset != null) {
                    final CategoryItemRenderer renderer = this.getRenderer(i);
                    if (renderer != null) {
                        for (int rowCount = dataset.getRowCount(), j = 0; j < rowCount; ++j) {
                            final LegendItem legendItem = renderer.getLegendItem(i, j);
                            if (legendItem != null) {
                                fixedLegendItems.add(legendItem);
                            }
                        }
                    }
                }
            }
        }
        return fixedLegendItems;
    }
    
    public void handleClick(final int n, final int n2, final PlotRenderingInfo plotRenderingInfo) {
        if (plotRenderingInfo.getDataArea().contains(n, n2)) {
            double n3 = 0.0;
            if (this.orientation == PlotOrientation.HORIZONTAL) {
                n3 = n;
            }
            else if (this.orientation == PlotOrientation.VERTICAL) {
                n3 = n2;
            }
            final double java2DToValue = this.getRangeAxis().java2DToValue(n3, plotRenderingInfo.getDataArea(), Plot.resolveRangeAxisLocation(this.getRangeAxisLocation(), this.orientation));
            this.setAnchorValue(java2DToValue);
            this.setRangeCrosshairValue(java2DToValue);
        }
    }
    
    public void zoom(final double n) {
        if (n > 0.0) {
            final double n2 = this.getRangeAxis().getRange().getLength() * n;
            this.getRangeAxis().setRange(this.anchorValue - n2 / 2.0, this.anchorValue + n2 / 2.0);
        }
        else {
            this.getRangeAxis().setAutoRange(true);
        }
    }
    
    public void datasetChanged(final DatasetChangeEvent datasetChangeEvent) {
        for (int size = this.rangeAxes.size(), i = 0; i < size; ++i) {
            final ValueAxis rangeAxis = this.getRangeAxis(i);
            if (rangeAxis != null) {
                rangeAxis.configure();
            }
        }
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
        final Plot parent = this.getParent();
        if (parent != null) {
            if (!(parent instanceof RendererChangeListener)) {
                throw new RuntimeException("The renderer has changed and I don't know what to do!");
            }
            ((RendererChangeListener)parent).rendererChanged(rendererChangeEvent);
        }
        else {
            this.configureRangeAxes();
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void addDomainMarker(final CategoryMarker categoryMarker) {
        this.addDomainMarker(categoryMarker, Layer.FOREGROUND);
    }
    
    public void addDomainMarker(final CategoryMarker categoryMarker, final Layer layer) {
        this.addDomainMarker(0, categoryMarker, layer);
    }
    
    public void addDomainMarker(final int n, final CategoryMarker categoryMarker, final Layer layer) {
        if (categoryMarker == null) {
            throw new IllegalArgumentException("Null 'marker' not permitted.");
        }
        if (layer == null) {
            throw new IllegalArgumentException("Null 'layer' not permitted.");
        }
        if (layer == Layer.FOREGROUND) {
            Collection<CategoryMarker> collection = this.foregroundDomainMarkers.get(new Integer(n));
            if (collection == null) {
                collection = new ArrayList<CategoryMarker>();
                this.foregroundDomainMarkers.put(new Integer(n), collection);
            }
            collection.add(categoryMarker);
        }
        else if (layer == Layer.BACKGROUND) {
            Collection<CategoryMarker> collection2 = this.backgroundDomainMarkers.get(new Integer(n));
            if (collection2 == null) {
                collection2 = new ArrayList<CategoryMarker>();
                this.backgroundDomainMarkers.put(new Integer(n), collection2);
            }
            collection2.add(categoryMarker);
        }
        categoryMarker.addChangeListener(this);
        this.notifyListeners(new PlotChangeEvent(this));
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
    
    public Collection getDomainMarkers(final Layer layer) {
        return this.getDomainMarkers(0, layer);
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
        if (this.foregroundDomainMarkers != null) {
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
    
    public void addRangeMarker(final Marker marker) {
        this.addRangeMarker(marker, Layer.FOREGROUND);
    }
    
    public void addRangeMarker(final Marker marker, final Layer layer) {
        this.addRangeMarker(0, marker, layer);
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
    
    public Collection getRangeMarkers(final Layer layer) {
        return this.getRangeMarkers(0, layer);
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
    
    public List getAnnotations() {
        return this.annotations;
    }
    
    public void addAnnotation(final CategoryAnnotation categoryAnnotation) {
        if (categoryAnnotation == null) {
            throw new IllegalArgumentException("Null 'annotation' argument.");
        }
        this.annotations.add(categoryAnnotation);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean removeAnnotation(final CategoryAnnotation categoryAnnotation) {
        if (categoryAnnotation == null) {
            throw new IllegalArgumentException("Null 'annotation' argument.");
        }
        final boolean remove = this.annotations.remove(categoryAnnotation);
        if (remove) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
        return remove;
    }
    
    public void clearAnnotations() {
        this.annotations.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    protected AxisSpace calculateDomainAxisSpace(final Graphics2D graphics2D, final Rectangle2D rectangle2D, AxisSpace axisSpace) {
        if (axisSpace == null) {
            axisSpace = new AxisSpace();
        }
        if (this.fixedDomainAxisSpace != null) {
            if (this.orientation == PlotOrientation.HORIZONTAL) {
                axisSpace.ensureAtLeast(this.fixedDomainAxisSpace.getLeft(), RectangleEdge.LEFT);
                axisSpace.ensureAtLeast(this.fixedDomainAxisSpace.getRight(), RectangleEdge.RIGHT);
            }
            else if (this.orientation == PlotOrientation.VERTICAL) {
                axisSpace.ensureAtLeast(this.fixedDomainAxisSpace.getTop(), RectangleEdge.TOP);
                axisSpace.ensureAtLeast(this.fixedDomainAxisSpace.getBottom(), RectangleEdge.BOTTOM);
            }
        }
        else {
            final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(this.getDomainAxisLocation(), this.orientation);
            if (this.drawSharedDomainAxis) {
                axisSpace = this.getDomainAxis().reserveSpace(graphics2D, this, rectangle2D, resolveDomainAxisLocation, axisSpace);
            }
            for (int i = 0; i < this.domainAxes.size(); ++i) {
                final Axis axis = (Axis)this.domainAxes.get(i);
                if (axis != null) {
                    axisSpace = axis.reserveSpace(graphics2D, this, rectangle2D, this.getDomainAxisEdge(i), axisSpace);
                }
            }
        }
        return axisSpace;
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
    
    protected AxisSpace calculateAxisSpace(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        return this.calculateDomainAxisSpace(graphics2D, rectangle2D, this.calculateRangeAxisSpace(graphics2D, rectangle2D, new AxisSpace()));
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D plotArea, final Point2D point2D, final PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        final boolean b = plotArea.getWidth() <= 10.0;
        final boolean b2 = plotArea.getHeight() <= 10.0;
        if (b || b2) {
            return;
        }
        if (plotRenderingInfo == null) {
            plotRenderingInfo = new PlotRenderingInfo(null);
        }
        plotRenderingInfo.setPlotArea(plotArea);
        this.getInsets().trim(plotArea);
        final Rectangle2D shrink = this.calculateAxisSpace(graphics2D, plotArea).shrink(plotArea, null);
        this.axisOffset.trim(shrink);
        plotRenderingInfo.setDataArea(shrink);
        if (this.getRenderer() != null) {
            this.getRenderer().drawBackground(graphics2D, this, shrink);
        }
        else {
            this.drawBackground(graphics2D, shrink);
        }
        final Map drawAxes = this.drawAxes(graphics2D, plotArea, shrink, plotRenderingInfo);
        final Shape clip = graphics2D.getClip();
        graphics2D.clip(shrink);
        this.drawDomainGridlines(graphics2D, shrink);
        AxisState axisState = drawAxes.get(this.getRangeAxis());
        if (axisState == null && plotState != null) {
            axisState = plotState.getSharedAxisStates().get(this.getRangeAxis());
        }
        if (axisState != null) {
            this.drawRangeGridlines(graphics2D, shrink, axisState.getTicks());
        }
        for (int i = 0; i < this.renderers.size(); ++i) {
            this.drawDomainMarkers(graphics2D, shrink, i, Layer.BACKGROUND);
        }
        for (int j = 0; j < this.renderers.size(); ++j) {
            this.drawRangeMarkers(graphics2D, shrink, j, Layer.BACKGROUND);
        }
        boolean b3 = false;
        final Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        if (this.getDatasetRenderingOrder() == DatasetRenderingOrder.FORWARD) {
            for (int k = 0; k < this.datasets.size(); ++k) {
                b3 = (this.render(graphics2D, shrink, k, plotRenderingInfo) || b3);
            }
        }
        else {
            for (int l = this.datasets.size() - 1; l >= 0; --l) {
                b3 = (this.render(graphics2D, shrink, l, plotRenderingInfo) || b3);
            }
        }
        for (int n = 0; n < this.renderers.size(); ++n) {
            this.drawDomainMarkers(graphics2D, shrink, n, Layer.FOREGROUND);
        }
        for (int n2 = 0; n2 < this.renderers.size(); ++n2) {
            this.drawRangeMarkers(graphics2D, shrink, n2, Layer.FOREGROUND);
        }
        this.drawAnnotations(graphics2D, shrink);
        graphics2D.setClip(clip);
        graphics2D.setComposite(composite);
        if (!b3) {
            this.drawNoDataMessage(graphics2D, shrink);
        }
        if (this.isRangeCrosshairVisible()) {
            this.drawRangeCrosshair(graphics2D, shrink, this.getOrientation(), this.getRangeCrosshairValue(), this.getRangeAxis(), this.getRangeCrosshairStroke(), this.getRangeCrosshairPaint());
        }
        if (this.getRenderer() != null) {
            this.getRenderer().drawOutline(graphics2D, this, shrink);
        }
        else {
            this.drawOutline(graphics2D, shrink);
        }
    }
    
    protected Map drawAxes(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final PlotRenderingInfo plotRenderingInfo) {
        final AxisCollection collection = new AxisCollection();
        for (int i = 0; i < this.domainAxes.size(); ++i) {
            final CategoryAxis categoryAxis = (CategoryAxis)this.domainAxes.get(i);
            if (categoryAxis != null) {
                collection.add(categoryAxis, this.getDomainAxisEdge(i));
            }
        }
        for (int j = 0; j < this.rangeAxes.size(); ++j) {
            final ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(j);
            if (valueAxis != null) {
                collection.add(valueAxis, this.getRangeAxisEdge(j));
            }
        }
        final HashMap<Axis, AxisState> hashMap = new HashMap<Axis, AxisState>();
        double cursor = rectangle2D2.getMinY() - this.axisOffset.calculateTopOutset(rectangle2D2.getHeight());
        for (final Axis axis : collection.getAxesAtTop()) {
            if (axis != null) {
                final AxisState draw = axis.draw(graphics2D, cursor, rectangle2D, rectangle2D2, RectangleEdge.TOP, plotRenderingInfo);
                cursor = draw.getCursor();
                hashMap.put(axis, draw);
            }
        }
        double cursor2 = rectangle2D2.getMaxY() + this.axisOffset.calculateBottomOutset(rectangle2D2.getHeight());
        for (final Axis axis2 : collection.getAxesAtBottom()) {
            if (axis2 != null) {
                final AxisState draw2 = axis2.draw(graphics2D, cursor2, rectangle2D, rectangle2D2, RectangleEdge.BOTTOM, plotRenderingInfo);
                cursor2 = draw2.getCursor();
                hashMap.put(axis2, draw2);
            }
        }
        double cursor3 = rectangle2D2.getMinX() - this.axisOffset.calculateLeftOutset(rectangle2D2.getWidth());
        for (final Axis axis3 : collection.getAxesAtLeft()) {
            if (axis3 != null) {
                final AxisState draw3 = axis3.draw(graphics2D, cursor3, rectangle2D, rectangle2D2, RectangleEdge.LEFT, plotRenderingInfo);
                cursor3 = draw3.getCursor();
                hashMap.put(axis3, draw3);
            }
        }
        double cursor4 = rectangle2D2.getMaxX() + this.axisOffset.calculateRightOutset(rectangle2D2.getWidth());
        for (final Axis axis4 : collection.getAxesAtRight()) {
            if (axis4 != null) {
                final AxisState draw4 = axis4.draw(graphics2D, cursor4, rectangle2D, rectangle2D2, RectangleEdge.RIGHT, plotRenderingInfo);
                cursor4 = draw4.getCursor();
                hashMap.put(axis4, draw4);
            }
        }
        return hashMap;
    }
    
    public boolean render(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final int n, final PlotRenderingInfo plotRenderingInfo) {
        boolean b = false;
        final CategoryDataset dataset = this.getDataset(n);
        final CategoryItemRenderer renderer = this.getRenderer(n);
        final CategoryAxis domainAxisForDataset = this.getDomainAxisForDataset(n);
        final ValueAxis rangeAxisForDataset = this.getRangeAxisForDataset(n);
        if (!DatasetUtilities.isEmptyOrNull(dataset) && renderer != null) {
            b = true;
            final CategoryItemRendererState initialise = renderer.initialise(graphics2D, rectangle2D, this, n, plotRenderingInfo);
            final int columnCount = dataset.getColumnCount();
            final int rowCount = dataset.getRowCount();
            for (int passCount = renderer.getPassCount(), i = 0; i < passCount; ++i) {
                if (this.columnRenderingOrder == SortOrder.ASCENDING) {
                    for (int j = 0; j < columnCount; ++j) {
                        if (this.rowRenderingOrder == SortOrder.ASCENDING) {
                            for (int k = 0; k < rowCount; ++k) {
                                renderer.drawItem(graphics2D, initialise, rectangle2D, this, domainAxisForDataset, rangeAxisForDataset, dataset, k, j, i);
                            }
                        }
                        else {
                            for (int l = rowCount - 1; l >= 0; --l) {
                                renderer.drawItem(graphics2D, initialise, rectangle2D, this, domainAxisForDataset, rangeAxisForDataset, dataset, l, j, i);
                            }
                        }
                    }
                }
                else {
                    for (int n2 = columnCount - 1; n2 >= 0; --n2) {
                        if (this.rowRenderingOrder == SortOrder.ASCENDING) {
                            for (int n3 = 0; n3 < rowCount; ++n3) {
                                renderer.drawItem(graphics2D, initialise, rectangle2D, this, domainAxisForDataset, rangeAxisForDataset, dataset, n3, n2, i);
                            }
                        }
                        else {
                            for (int n4 = rowCount - 1; n4 >= 0; --n4) {
                                renderer.drawItem(graphics2D, initialise, rectangle2D, this, domainAxisForDataset, rangeAxisForDataset, dataset, n4, n2, i);
                            }
                        }
                    }
                }
            }
        }
        return b;
    }
    
    protected void drawDomainGridlines(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        if (this.isDomainGridlinesVisible()) {
            final CategoryAnchor domainGridlinePosition = this.getDomainGridlinePosition();
            final RectangleEdge domainAxisEdge = this.getDomainAxisEdge();
            final Stroke domainGridlineStroke = this.getDomainGridlineStroke();
            final Paint domainGridlinePaint = this.getDomainGridlinePaint();
            if (domainGridlineStroke != null && domainGridlinePaint != null) {
                final CategoryDataset dataset = this.getDataset();
                if (dataset != null) {
                    final CategoryAxis domainAxis = this.getDomainAxis();
                    if (domainAxis != null) {
                        for (int columnCount = dataset.getColumnCount(), i = 0; i < columnCount; ++i) {
                            final double categoryJava2DCoordinate = domainAxis.getCategoryJava2DCoordinate(domainGridlinePosition, i, columnCount, rectangle2D, domainAxisEdge);
                            final CategoryItemRenderer renderer = this.getRenderer();
                            if (renderer != null) {
                                renderer.drawDomainGridline(graphics2D, this, rectangle2D, categoryJava2DCoordinate);
                            }
                        }
                    }
                }
            }
        }
    }
    
    protected void drawRangeGridlines(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final List list) {
        if (this.isRangeGridlinesVisible()) {
            final Stroke rangeGridlineStroke = this.getRangeGridlineStroke();
            final Paint rangeGridlinePaint = this.getRangeGridlinePaint();
            if (rangeGridlineStroke != null && rangeGridlinePaint != null && this.getRangeAxis() != null) {
                for (final ValueTick valueTick : list) {
                    final CategoryItemRenderer renderer = this.getRenderer();
                    if (renderer != null) {
                        renderer.drawRangeGridline(graphics2D, this, this.getRangeAxis(), rectangle2D, valueTick.getValue());
                    }
                }
            }
        }
    }
    
    protected void drawAnnotations(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        if (this.getAnnotations() != null) {
            final Iterator<CategoryAnnotation> iterator = this.getAnnotations().iterator();
            while (iterator.hasNext()) {
                iterator.next().draw(graphics2D, this, rectangle2D, this.getDomainAxis(), this.getRangeAxis());
            }
        }
    }
    
    protected void drawDomainMarkers(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final int n, final Layer layer) {
        final CategoryItemRenderer renderer = this.getRenderer(n);
        if (renderer == null) {
            return;
        }
        final Collection domainMarkers = this.getDomainMarkers(n, layer);
        final CategoryAxis domainAxisForDataset = this.getDomainAxisForDataset(n);
        if (domainMarkers != null && domainAxisForDataset != null) {
            final Iterator<CategoryMarker> iterator = domainMarkers.iterator();
            while (iterator.hasNext()) {
                renderer.drawDomainMarker(graphics2D, this, domainAxisForDataset, iterator.next(), rectangle2D);
            }
        }
    }
    
    protected void drawRangeMarkers(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final int n, final Layer layer) {
        final CategoryItemRenderer renderer = this.getRenderer(n);
        if (renderer == null) {
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
    
    protected void drawRangeLine(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n, final Stroke stroke, final Paint paint) {
        final double valueToJava2D = this.getRangeAxis().valueToJava2D(n, rectangle2D, this.getRangeAxisEdge());
        Shape shape = null;
        if (this.orientation == PlotOrientation.HORIZONTAL) {
            shape = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
        }
        else if (this.orientation == PlotOrientation.VERTICAL) {
            shape = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
        }
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.draw(shape);
    }
    
    protected void drawRangeCrosshair(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotOrientation plotOrientation, final double n, final ValueAxis valueAxis, final Stroke stroke, final Paint paint) {
        if (!valueAxis.getRange().contains(n)) {
            return;
        }
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
    
    public Range getDataRange(final ValueAxis valueAxis) {
        Range combine = null;
        final ArrayList<CategoryDataset> list = new ArrayList<CategoryDataset>();
        final int index = this.rangeAxes.indexOf(valueAxis);
        if (index >= 0) {
            list.addAll((Collection<?>)this.datasetsMappedToRangeAxis(index));
        }
        else if (valueAxis == this.getRangeAxis()) {
            list.addAll((Collection<?>)this.datasetsMappedToRangeAxis(0));
        }
        for (final CategoryDataset categoryDataset : list) {
            final CategoryItemRenderer rendererForDataset = this.getRendererForDataset(categoryDataset);
            if (rendererForDataset != null) {
                combine = Range.combine(combine, rendererForDataset.findRangeBounds(categoryDataset));
            }
        }
        return combine;
    }
    
    private List datasetsMappedToDomainAxis(final int n) {
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < this.datasets.size(); ++i) {
            final Object value = this.datasets.get(i);
            if (value != null) {
                final Integer n2 = (Integer)this.datasetToDomainAxisMap.get(i);
                if (n2 == null) {
                    if (n == 0) {
                        list.add(value);
                    }
                }
                else if (n2 == n) {
                    list.add(value);
                }
            }
        }
        return list;
    }
    
    private List datasetsMappedToRangeAxis(final int n) {
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < this.datasets.size(); ++i) {
            final Object value = this.datasets.get(i);
            if (value != null) {
                final Integer n2 = (Integer)this.datasetToRangeAxisMap.get(i);
                if (n2 == null) {
                    if (n == 0) {
                        list.add(value);
                    }
                }
                else if (n2 == n) {
                    list.add(value);
                }
            }
        }
        return list;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public void setWeight(final int weight) {
        this.weight = weight;
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
    
    public List getCategories() {
        List<Object> unmodifiableList = null;
        if (this.getDataset() != null) {
            unmodifiableList = Collections.unmodifiableList((List<?>)this.getDataset().getColumnKeys());
        }
        return unmodifiableList;
    }
    
    public List getCategoriesForAxis(final CategoryAxis categoryAxis) {
        final ArrayList list = new ArrayList<Comparable>();
        for (final CategoryDataset categoryDataset : this.datasetsMappedToDomainAxis(this.domainAxes.indexOf(categoryAxis))) {
            for (int i = 0; i < categoryDataset.getColumnCount(); ++i) {
                final Comparable columnKey = categoryDataset.getColumnKey(i);
                if (!list.contains(columnKey)) {
                    list.add(columnKey);
                }
            }
        }
        return list;
    }
    
    public boolean getDrawSharedDomainAxis() {
        return this.drawSharedDomainAxis;
    }
    
    public void setDrawSharedDomainAxis(final boolean drawSharedDomainAxis) {
        this.drawSharedDomainAxis = drawSharedDomainAxis;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isDomainZoomable() {
        return false;
    }
    
    public boolean isRangeZoomable() {
        return true;
    }
    
    public void zoomDomainAxes(final double n, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
    }
    
    public void zoomDomainAxes(final double n, final double n2, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
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
    
    public double getAnchorValue() {
        return this.anchorValue;
    }
    
    public void setAnchorValue(final double n) {
        this.setAnchorValue(n, true);
    }
    
    public void setAnchorValue(final double anchorValue, final boolean b) {
        this.anchorValue = anchorValue;
        if (b) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CategoryPlot)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CategoryPlot categoryPlot = (CategoryPlot)o;
        return this.orientation == categoryPlot.orientation && ObjectUtilities.equal(this.axisOffset, categoryPlot.axisOffset) && this.domainAxes.equals(categoryPlot.domainAxes) && this.domainAxisLocations.equals(categoryPlot.domainAxisLocations) && this.drawSharedDomainAxis == categoryPlot.drawSharedDomainAxis && this.rangeAxes.equals(categoryPlot.rangeAxes) && this.rangeAxisLocations.equals(categoryPlot.rangeAxisLocations) && ObjectUtilities.equal(this.datasetToDomainAxisMap, categoryPlot.datasetToDomainAxisMap) && ObjectUtilities.equal(this.datasetToRangeAxisMap, categoryPlot.datasetToRangeAxisMap) && ObjectUtilities.equal(this.renderers, categoryPlot.renderers) && this.renderingOrder == categoryPlot.renderingOrder && this.columnRenderingOrder == categoryPlot.columnRenderingOrder && this.rowRenderingOrder == categoryPlot.rowRenderingOrder && this.domainGridlinesVisible == categoryPlot.domainGridlinesVisible && this.domainGridlinePosition == categoryPlot.domainGridlinePosition && ObjectUtilities.equal(this.domainGridlineStroke, categoryPlot.domainGridlineStroke) && PaintUtilities.equal(this.domainGridlinePaint, categoryPlot.domainGridlinePaint) && this.rangeGridlinesVisible == categoryPlot.rangeGridlinesVisible && ObjectUtilities.equal(this.rangeGridlineStroke, categoryPlot.rangeGridlineStroke) && PaintUtilities.equal(this.rangeGridlinePaint, categoryPlot.rangeGridlinePaint) && this.anchorValue == categoryPlot.anchorValue && this.rangeCrosshairVisible == categoryPlot.rangeCrosshairVisible && this.rangeCrosshairValue == categoryPlot.rangeCrosshairValue && ObjectUtilities.equal(this.rangeCrosshairStroke, categoryPlot.rangeCrosshairStroke) && PaintUtilities.equal(this.rangeCrosshairPaint, categoryPlot.rangeCrosshairPaint) && this.rangeCrosshairLockedOnData == categoryPlot.rangeCrosshairLockedOnData && ObjectUtilities.equal(this.foregroundRangeMarkers, categoryPlot.foregroundRangeMarkers) && ObjectUtilities.equal(this.backgroundRangeMarkers, categoryPlot.backgroundRangeMarkers) && ObjectUtilities.equal(this.annotations, categoryPlot.annotations) && this.weight == categoryPlot.weight && ObjectUtilities.equal(this.fixedDomainAxisSpace, categoryPlot.fixedDomainAxisSpace) && ObjectUtilities.equal(this.fixedRangeAxisSpace, categoryPlot.fixedRangeAxisSpace);
    }
    
    public Object clone() {
        final CategoryPlot categoryPlot = (CategoryPlot)super.clone();
        categoryPlot.domainAxes = new ObjectList();
        for (int i = 0; i < this.domainAxes.size(); ++i) {
            final CategoryAxis categoryAxis = (CategoryAxis)this.domainAxes.get(i);
            if (categoryAxis != null) {
                categoryPlot.setDomainAxis(i, (CategoryAxis)categoryAxis.clone());
            }
        }
        categoryPlot.domainAxisLocations = (ObjectList)this.domainAxisLocations.clone();
        categoryPlot.rangeAxes = new ObjectList();
        for (int j = 0; j < this.rangeAxes.size(); ++j) {
            final ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(j);
            if (valueAxis != null) {
                categoryPlot.setRangeAxis(j, (ValueAxis)valueAxis.clone());
            }
        }
        categoryPlot.rangeAxisLocations = (ObjectList)this.rangeAxisLocations.clone();
        categoryPlot.datasets = (ObjectList)this.datasets.clone();
        for (int k = 0; k < categoryPlot.datasets.size(); ++k) {
            final CategoryDataset dataset = categoryPlot.getDataset(k);
            if (dataset != null) {
                dataset.addChangeListener(categoryPlot);
            }
        }
        categoryPlot.datasetToDomainAxisMap = (ObjectList)this.datasetToDomainAxisMap.clone();
        categoryPlot.datasetToRangeAxisMap = (ObjectList)this.datasetToRangeAxisMap.clone();
        categoryPlot.renderers = (ObjectList)this.renderers.clone();
        if (this.fixedDomainAxisSpace != null) {
            categoryPlot.fixedDomainAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedDomainAxisSpace);
        }
        if (this.fixedRangeAxisSpace != null) {
            categoryPlot.fixedRangeAxisSpace = (AxisSpace)ObjectUtilities.clone(this.fixedRangeAxisSpace);
        }
        return categoryPlot;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.domainGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.domainGridlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.rangeGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.rangeGridlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.rangeCrosshairStroke, objectOutputStream);
        SerialUtilities.writePaint(this.rangeCrosshairPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.domainGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.domainGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.rangeGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.rangeGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.rangeCrosshairStroke = SerialUtilities.readStroke(objectInputStream);
        this.rangeCrosshairPaint = SerialUtilities.readPaint(objectInputStream);
        for (int i = 0; i < this.domainAxes.size(); ++i) {
            final CategoryAxis categoryAxis = (CategoryAxis)this.domainAxes.get(i);
            if (categoryAxis != null) {
                categoryAxis.setPlot(this);
                categoryAxis.addChangeListener(this);
            }
        }
        for (int j = 0; j < this.rangeAxes.size(); ++j) {
            final ValueAxis valueAxis = (ValueAxis)this.rangeAxes.get(j);
            if (valueAxis != null) {
                valueAxis.setPlot(this);
                valueAxis.addChangeListener(this);
            }
        }
        for (int size = this.datasets.size(), k = 0; k < size; ++k) {
            final Dataset dataset = (Dataset)this.datasets.get(k);
            if (dataset != null) {
                dataset.addChangeListener(this);
            }
        }
        for (int size2 = this.renderers.size(), l = 0; l < size2; ++l) {
            final CategoryItemRenderer categoryItemRenderer = (CategoryItemRenderer)this.renderers.get(l);
            if (categoryItemRenderer != null) {
                categoryItemRenderer.addChangeListener(this);
            }
        }
    }
    
    static {
        DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5f, 0, 2, 0.0f, new float[] { 2.0f, 2.0f }, 0.0f);
        DEFAULT_GRIDLINE_PAINT = Color.lightGray;
        DEFAULT_VALUE_LABEL_FONT = new Font("SansSerif", 0, 10);
        DEFAULT_CROSSHAIR_STROKE = CategoryPlot.DEFAULT_GRIDLINE_STROKE;
        DEFAULT_CROSSHAIR_PAINT = Color.blue;
        CategoryPlot.localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    }
}
