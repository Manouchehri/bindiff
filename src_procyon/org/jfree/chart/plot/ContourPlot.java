package org.jfree.chart.plot;

import java.io.*;
import org.jfree.data.contour.*;
import org.jfree.ui.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.annotations.*;
import java.awt.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.entity.*;
import java.awt.geom.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import org.jfree.data.xy.*;
import java.beans.*;
import org.jfree.chart.event.*;
import org.jfree.util.*;
import java.util.*;

public class ContourPlot extends Plot implements PropertyChangeListener, Serializable, Cloneable, ContourValuePlot, ValueAxisPlot
{
    private static final long serialVersionUID = 7861072556590502247L;
    protected static final RectangleInsets DEFAULT_INSETS;
    private ValueAxis domainAxis;
    private ValueAxis rangeAxis;
    private ContourDataset dataset;
    private ColorBar colorBar;
    private RectangleEdge colorBarLocation;
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
    private double dataAreaRatio;
    private List domainMarkers;
    private List rangeMarkers;
    private List annotations;
    private ContourToolTipGenerator toolTipGenerator;
    private XYURLGenerator urlGenerator;
    private boolean renderAsPoints;
    private double ptSizePct;
    private transient ClipPath clipPath;
    private transient Paint missingPaint;
    protected static ResourceBundle localizationResources;
    
    public ContourPlot() {
        this(null, null, null, null);
    }
    
    public ContourPlot(final ContourDataset dataset, final ValueAxis domainAxis, final ValueAxis rangeAxis, final ColorBar colorBar) {
        this.colorBar = null;
        this.domainCrosshairLockedOnData = true;
        this.rangeCrosshairLockedOnData = true;
        this.dataAreaRatio = 0.0;
        this.renderAsPoints = false;
        this.ptSizePct = 0.05;
        this.clipPath = null;
        this.missingPaint = null;
        this.dataset = dataset;
        if (dataset != null) {
            dataset.addChangeListener(this);
        }
        if ((this.domainAxis = domainAxis) != null) {
            domainAxis.setPlot(this);
            domainAxis.addChangeListener(this);
        }
        if ((this.rangeAxis = rangeAxis) != null) {
            rangeAxis.setPlot(this);
            rangeAxis.addChangeListener(this);
        }
        if ((this.colorBar = colorBar) != null) {
            colorBar.getAxis().setPlot(this);
            colorBar.getAxis().addChangeListener(this);
            colorBar.configure(this);
        }
        this.colorBarLocation = RectangleEdge.LEFT;
        this.toolTipGenerator = new StandardContourToolTipGenerator();
    }
    
    public RectangleEdge getColorBarLocation() {
        return this.colorBarLocation;
    }
    
    public void setColorBarLocation(final RectangleEdge colorBarLocation) {
        this.colorBarLocation = colorBarLocation;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public ContourDataset getDataset() {
        return this.dataset;
    }
    
    public void setDataset(final ContourDataset dataset) {
        final ContourDataset dataset2 = this.dataset;
        if (dataset2 != null) {
            dataset2.removeChangeListener(this);
        }
        if ((this.dataset = dataset) != null) {
            this.setDatasetGroup(dataset.getGroup());
            dataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, dataset));
    }
    
    public ValueAxis getDomainAxis() {
        return this.domainAxis;
    }
    
    public void setDomainAxis(final ValueAxis domainAxis) {
        if (this.isCompatibleDomainAxis(domainAxis)) {
            if (domainAxis != null) {
                domainAxis.setPlot(this);
                domainAxis.addChangeListener(this);
            }
            if (this.domainAxis != null) {
                this.domainAxis.removeChangeListener(this);
            }
            this.domainAxis = domainAxis;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public ValueAxis getRangeAxis() {
        return this.rangeAxis;
    }
    
    public void setRangeAxis(final ValueAxis rangeAxis) {
        if (rangeAxis != null) {
            rangeAxis.setPlot(this);
            rangeAxis.addChangeListener(this);
        }
        if (this.rangeAxis != null) {
            this.rangeAxis.removeChangeListener(this);
        }
        this.rangeAxis = rangeAxis;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void setColorBarAxis(final ColorBar colorBar) {
        this.colorBar = colorBar;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getDataAreaRatio() {
        return this.dataAreaRatio;
    }
    
    public void setDataAreaRatio(final double dataAreaRatio) {
        this.dataAreaRatio = dataAreaRatio;
    }
    
    public void addDomainMarker(final Marker marker) {
        if (this.domainMarkers == null) {
            this.domainMarkers = new ArrayList();
        }
        this.domainMarkers.add(marker);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void clearDomainMarkers() {
        if (this.domainMarkers != null) {
            this.domainMarkers.clear();
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void addRangeMarker(final Marker marker) {
        if (this.rangeMarkers == null) {
            this.rangeMarkers = new ArrayList();
        }
        this.rangeMarkers.add(marker);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void clearRangeMarkers() {
        if (this.rangeMarkers != null) {
            this.rangeMarkers.clear();
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void addAnnotation(final XYAnnotation xyAnnotation) {
        if (this.annotations == null) {
            this.annotations = new ArrayList();
        }
        this.annotations.add(xyAnnotation);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void clearAnnotations() {
        if (this.annotations != null) {
            this.annotations.clear();
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public boolean isCompatibleDomainAxis(final ValueAxis valueAxis) {
        return true;
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D plotArea, final Point2D point2D, final PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        final boolean b = plotArea.getWidth() <= 10.0;
        final boolean b2 = plotArea.getHeight() <= 10.0;
        if (b || b2) {
            return;
        }
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(plotArea);
        }
        this.getInsets().trim(plotArea);
        final AxisSpace reserveSpace = this.rangeAxis.reserveSpace(graphics2D, this, plotArea, RectangleEdge.LEFT, this.domainAxis.reserveSpace(graphics2D, this, plotArea, RectangleEdge.BOTTOM, new AxisSpace()));
        final AxisSpace reserveSpace2 = this.colorBar.reserveSpace(graphics2D, this, plotArea, reserveSpace.shrink(plotArea, null), this.colorBarLocation, new AxisSpace());
        final Rectangle2D shrink = reserveSpace2.shrink(plotArea, null);
        final Rectangle2D shrink2 = reserveSpace.shrink(shrink, null);
        final Rectangle2D reserved = reserveSpace2.reserved(plotArea, this.colorBarLocation);
        if (this.getDataAreaRatio() != 0.0) {
            final double dataAreaRatio = this.getDataAreaRatio();
            final Rectangle2D rectangle2D = (Rectangle2D)shrink2.clone();
            double height = rectangle2D.getHeight();
            double width = rectangle2D.getWidth();
            if (dataAreaRatio > 0.0) {
                if (width * dataAreaRatio <= height) {
                    height = dataAreaRatio * width;
                }
                else {
                    width = height / dataAreaRatio;
                }
            }
            else {
                final double n = this.getRangeAxis().getRange().getLength() / this.getDomainAxis().getRange().getLength() * (dataAreaRatio * -1.0);
                if (width * n <= height) {
                    height = n * width;
                }
                else {
                    width = height / n;
                }
            }
            shrink2.setRect(rectangle2D.getX() + rectangle2D.getWidth() / 2.0 - width / 2.0, rectangle2D.getY(), width, height);
        }
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setDataArea(shrink2);
        }
        final CrosshairState crosshairState = new CrosshairState();
        crosshairState.setCrosshairDistance(Double.POSITIVE_INFINITY);
        this.drawBackground(graphics2D, shrink2);
        final double maxY = shrink2.getMaxY();
        if (this.domainAxis != null) {
            this.domainAxis.draw(graphics2D, maxY, shrink, shrink2, RectangleEdge.BOTTOM, plotRenderingInfo);
        }
        if (this.rangeAxis != null) {
            this.rangeAxis.draw(graphics2D, shrink2.getMinX(), shrink, shrink2, RectangleEdge.LEFT, plotRenderingInfo);
        }
        if (this.colorBar != null) {
            this.colorBar.draw(graphics2D, 0.0, shrink, shrink2, reserved, this.colorBarLocation);
        }
        final Shape clip = graphics2D.getClip();
        final Composite composite = graphics2D.getComposite();
        graphics2D.clip(shrink2);
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        this.render(graphics2D, shrink2, plotRenderingInfo, crosshairState);
        if (this.domainMarkers != null) {
            final Iterator<Marker> iterator = (Iterator<Marker>)this.domainMarkers.iterator();
            while (iterator.hasNext()) {
                this.drawDomainMarker(graphics2D, this, this.getDomainAxis(), iterator.next(), shrink2);
            }
        }
        if (this.rangeMarkers != null) {
            final Iterator<Marker> iterator2 = (Iterator<Marker>)this.rangeMarkers.iterator();
            while (iterator2.hasNext()) {
                this.drawRangeMarker(graphics2D, this, this.getRangeAxis(), iterator2.next(), shrink2);
            }
        }
        graphics2D.setClip(clip);
        graphics2D.setComposite(composite);
        this.drawOutline(graphics2D, shrink2);
    }
    
    public void render(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final CrosshairState crosshairState) {
        final ContourDataset dataset = this.getDataset();
        if (dataset != null) {
            final ColorBar colorBar = this.getColorBar();
            if (this.clipPath != null) {
                final GeneralPath draw = this.getClipPath().draw(graphics2D, rectangle2D, this.domainAxis, this.rangeAxis);
                if (this.clipPath.isClip()) {
                    graphics2D.clip(draw);
                }
            }
            if (this.renderAsPoints) {
                this.pointRenderer(graphics2D, rectangle2D, plotRenderingInfo, this, this.domainAxis, this.rangeAxis, colorBar, dataset, crosshairState);
            }
            else {
                this.contourRenderer(graphics2D, rectangle2D, plotRenderingInfo, this, this.domainAxis, this.rangeAxis, colorBar, dataset, crosshairState);
            }
            this.setDomainCrosshairValue(crosshairState.getCrosshairX(), false);
            if (this.isDomainCrosshairVisible()) {
                this.drawVerticalLine(graphics2D, rectangle2D, this.getDomainCrosshairValue(), this.getDomainCrosshairStroke(), this.getDomainCrosshairPaint());
            }
            this.setRangeCrosshairValue(crosshairState.getCrosshairY(), false);
            if (this.isRangeCrosshairVisible()) {
                this.drawHorizontalLine(graphics2D, rectangle2D, this.getRangeCrosshairValue(), this.getRangeCrosshairStroke(), this.getRangeCrosshairPaint());
            }
        }
        else if (this.clipPath != null) {
            this.getClipPath().draw(graphics2D, rectangle2D, this.domainAxis, this.rangeAxis);
        }
    }
    
    public void contourRenderer(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final ContourPlot contourPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final ColorBar colorBar, final ContourDataset contourDataset, final CrosshairState crosshairState) {
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        final Object renderingHint = graphics2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        final Number[] xValues = contourDataset.getXValues();
        final Number[] yValues = contourDataset.getYValues();
        final Number[] zValues = contourDataset.getZValues();
        final double[] array = new double[xValues.length];
        final double[] array2 = new double[yValues.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = xValues[i].doubleValue();
            array2[i] = yValues[i].doubleValue();
        }
        final int[] indexX = contourDataset.indexX();
        final int[] xIndices = contourDataset.getXIndices();
        final boolean inverted = ((NumberAxis)valueAxis2).isInverted();
        boolean inverted2 = false;
        if (valueAxis instanceof NumberAxis) {
            inverted2 = ((NumberAxis)valueAxis).isInverted();
        }
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        double n4 = 0.0;
        final int n5 = indexX[indexX.length - 1];
        for (int j = 0; j < array.length; ++j) {
            final int n6 = indexX[j];
            double n10;
            double n11;
            if (xIndices[n6] == j) {
                double n7;
                double n8;
                if (n6 == 0) {
                    final double valueToJava2D;
                    n7 = (valueToJava2D = valueAxis.valueToJava2D(array[j], rectangle2D, RectangleEdge.BOTTOM));
                    final double valueToJava2D2 = valueAxis.valueToJava2D(array[xIndices[n6 + 1]], rectangle2D, RectangleEdge.BOTTOM);
                    n8 = Math.abs(0.5 * (n7 - valueToJava2D));
                    n2 = Math.abs(0.5 * (n7 - valueToJava2D2));
                }
                else if (n6 == n5) {
                    n7 = valueAxis.valueToJava2D(array[j], rectangle2D, RectangleEdge.BOTTOM);
                    final double valueToJava2D3 = valueAxis.valueToJava2D(array[xIndices[n6 - 1]], rectangle2D, RectangleEdge.BOTTOM);
                    final double n9 = n7;
                    n8 = Math.abs(0.5 * (n7 - valueToJava2D3));
                    n2 = Math.abs(0.5 * (n7 - n9));
                }
                else {
                    n7 = valueAxis.valueToJava2D(array[j], rectangle2D, RectangleEdge.BOTTOM);
                    final double valueToJava2D4 = valueAxis.valueToJava2D(array[xIndices[n6 + 1]], rectangle2D, RectangleEdge.BOTTOM);
                    n8 = n2;
                    n2 = Math.abs(0.5 * (n7 - valueToJava2D4));
                }
                if (inverted2) {
                    n = n7 - n2;
                }
                else {
                    n = n7 - n8;
                }
                n3 = n8 + n2;
                final double valueToJava2D5;
                n10 = (valueToJava2D5 = valueAxis2.valueToJava2D(array2[j], rectangle2D, RectangleEdge.LEFT));
                if (j + 1 == array2.length) {
                    continue;
                }
                final double valueToJava2D6 = valueAxis2.valueToJava2D(array2[j + 1], rectangle2D, RectangleEdge.LEFT);
                n11 = Math.abs(0.5 * (n10 - valueToJava2D5));
                n4 = Math.abs(0.5 * (n10 - valueToJava2D6));
            }
            else if ((n6 < xIndices.length - 1 && xIndices[n6 + 1] - 1 == j) || j == array.length - 1) {
                n10 = valueAxis2.valueToJava2D(array2[j], rectangle2D, RectangleEdge.LEFT);
                final double valueToJava2D7 = valueAxis2.valueToJava2D(array2[j - 1], rectangle2D, RectangleEdge.LEFT);
                final double n12 = n10;
                n11 = Math.abs(0.5 * (n10 - valueToJava2D7));
                n4 = Math.abs(0.5 * (n10 - n12));
            }
            else {
                n10 = valueAxis2.valueToJava2D(array2[j], rectangle2D, RectangleEdge.LEFT);
                final double valueToJava2D8 = valueAxis2.valueToJava2D(array2[j + 1], rectangle2D, RectangleEdge.LEFT);
                n11 = n4;
                n4 = Math.abs(0.5 * (n10 - valueToJava2D8));
            }
            double n13;
            if (inverted) {
                n13 = n10 - n11;
            }
            else {
                n13 = n10 - n4;
            }
            double1.setRect(n, n13, n3, n11 + n4);
            if (zValues[j] != null) {
                graphics2D.setPaint(colorBar.getPaint(zValues[j].doubleValue()));
                graphics2D.fill(double1);
            }
            else if (this.missingPaint != null) {
                graphics2D.setPaint(this.missingPaint);
                graphics2D.fill(double1);
            }
            final Rectangle2D.Double double2 = double1;
            if (entityCollection != null) {
                String generateToolTip = "";
                if (this.getToolTipGenerator() != null) {
                    generateToolTip = this.toolTipGenerator.generateToolTip(contourDataset, j);
                }
                final ContourEntity contourEntity = new ContourEntity((Shape)double2.clone(), generateToolTip, null);
                contourEntity.setIndex(j);
                entityCollection.add(contourEntity);
            }
            if (contourPlot.isDomainCrosshairLockedOnData()) {
                if (contourPlot.isRangeCrosshairLockedOnData()) {
                    crosshairState.updateCrosshairPoint(array[j], array2[j], n, n13, PlotOrientation.VERTICAL);
                }
                else {
                    crosshairState.updateCrosshairX(n);
                }
            }
            else if (contourPlot.isRangeCrosshairLockedOnData()) {
                crosshairState.updateCrosshairY(n13);
            }
        }
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, renderingHint);
    }
    
    public void pointRenderer(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final ContourPlot contourPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final ColorBar colorBar, final ContourDataset contourDataset, final CrosshairState crosshairState) {
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        final Ellipse2D.Double double1 = new Ellipse2D.Double();
        final Object renderingHint = graphics2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        final Number[] xValues = contourDataset.getXValues();
        final Number[] yValues = contourDataset.getYValues();
        final Number[] zValues = contourDataset.getZValues();
        final double[] array = new double[xValues.length];
        final double[] array2 = new double[yValues.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = xValues[i].doubleValue();
            array2[i] = yValues[i].doubleValue();
        }
        final double n = rectangle2D.getWidth() * this.ptSizePct;
        for (int j = 0; j < array.length; ++j) {
            final double n2 = valueAxis.valueToJava2D(array[j], rectangle2D, RectangleEdge.BOTTOM) - 0.5 * n;
            final double n3 = valueAxis2.valueToJava2D(array2[j], rectangle2D, RectangleEdge.LEFT) - 0.5 * n;
            double1.setFrame(n2, n3, n, n);
            if (zValues[j] != null) {
                graphics2D.setPaint(colorBar.getPaint(zValues[j].doubleValue()));
                graphics2D.fill(double1);
            }
            else if (this.missingPaint != null) {
                graphics2D.setPaint(this.missingPaint);
                graphics2D.fill(double1);
            }
            final Ellipse2D.Double double2 = double1;
            if (entityCollection != null) {
                String generateToolTip = null;
                if (this.getToolTipGenerator() != null) {
                    generateToolTip = this.toolTipGenerator.generateToolTip(contourDataset, j);
                }
                final ContourEntity contourEntity = new ContourEntity((Shape)double2.clone(), generateToolTip, null);
                contourEntity.setIndex(j);
                entityCollection.add(contourEntity);
            }
            if (contourPlot.isDomainCrosshairLockedOnData()) {
                if (contourPlot.isRangeCrosshairLockedOnData()) {
                    crosshairState.updateCrosshairPoint(array[j], array2[j], n2, n3, PlotOrientation.VERTICAL);
                }
                else {
                    crosshairState.updateCrosshairX(n2);
                }
            }
            else if (contourPlot.isRangeCrosshairLockedOnData()) {
                crosshairState.updateCrosshairY(n3);
            }
        }
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, renderingHint);
    }
    
    protected void drawVerticalLine(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n, final Stroke stroke, final Paint paint) {
        final double valueToJava2D = this.getDomainAxis().valueToJava2D(n, rectangle2D, RectangleEdge.BOTTOM);
        final Line2D.Double double1 = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.draw(double1);
    }
    
    protected void drawHorizontalLine(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n, final Stroke stroke, final Paint paint) {
        final double valueToJava2D = this.getRangeAxis().valueToJava2D(n, rectangle2D, RectangleEdge.LEFT);
        final Line2D.Double double1 = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.draw(double1);
    }
    
    public void handleClick(final int n, final int n2, final PlotRenderingInfo plotRenderingInfo) {
    }
    
    public void zoom(final double n) {
        if (n <= 0.0) {
            this.getRangeAxis().setAutoRange(true);
            this.getDomainAxis().setAutoRange(true);
        }
    }
    
    public String getPlotType() {
        return ContourPlot.localizationResources.getString("Contour_Plot");
    }
    
    public Range getDataRange(final ValueAxis valueAxis) {
        if (this.dataset == null) {
            return null;
        }
        Range range = null;
        if (valueAxis == this.getDomainAxis()) {
            range = DatasetUtilities.findDomainBounds(this.dataset);
        }
        else if (valueAxis == this.getRangeAxis()) {
            range = DatasetUtilities.findRangeBounds(this.dataset);
        }
        return range;
    }
    
    public Range getContourDataRange() {
        Range visibleRange = null;
        final ContourDataset dataset = this.getDataset();
        if (dataset != null) {
            visibleRange = this.visibleRange(dataset, this.getDomainAxis().getRange(), this.getRangeAxis().getRange());
        }
        return visibleRange;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void datasetChanged(final DatasetChangeEvent datasetChangeEvent) {
        if (this.domainAxis != null) {
            this.domainAxis.configure();
        }
        if (this.rangeAxis != null) {
            this.rangeAxis.configure();
        }
        if (this.colorBar != null) {
            this.colorBar.configure(this);
        }
        super.datasetChanged(datasetChangeEvent);
    }
    
    public ColorBar getColorBar() {
        return this.colorBar;
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
        this.domainCrosshairStroke = domainCrosshairStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getDomainCrosshairPaint() {
        return this.domainCrosshairPaint;
    }
    
    public void setDomainCrosshairPaint(final Paint domainCrosshairPaint) {
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
        this.rangeCrosshairStroke = rangeCrosshairStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getRangeCrosshairPaint() {
        return this.rangeCrosshairPaint;
    }
    
    public void setRangeCrosshairPaint(final Paint rangeCrosshairPaint) {
        this.rangeCrosshairPaint = rangeCrosshairPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public ContourToolTipGenerator getToolTipGenerator() {
        return this.toolTipGenerator;
    }
    
    public void setToolTipGenerator(final ContourToolTipGenerator toolTipGenerator) {
        this.toolTipGenerator = toolTipGenerator;
    }
    
    public XYURLGenerator getURLGenerator() {
        return this.urlGenerator;
    }
    
    public void setURLGenerator(final XYURLGenerator urlGenerator) {
        this.urlGenerator = urlGenerator;
    }
    
    public void drawDomainMarker(final Graphics2D graphics2D, final ContourPlot contourPlot, final ValueAxis valueAxis, final Marker marker, final Rectangle2D rectangle2D) {
        if (marker instanceof ValueMarker) {
            final double value = ((ValueMarker)marker).getValue();
            if (!valueAxis.getRange().contains(value)) {
                return;
            }
            final double valueToJava2D = valueAxis.valueToJava2D(value, rectangle2D, RectangleEdge.BOTTOM);
            final Line2D.Double double1 = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
            final Paint outlinePaint = marker.getOutlinePaint();
            final Stroke outlineStroke = marker.getOutlineStroke();
            graphics2D.setPaint((outlinePaint != null) ? outlinePaint : Plot.DEFAULT_OUTLINE_PAINT);
            graphics2D.setStroke((outlineStroke != null) ? outlineStroke : Plot.DEFAULT_OUTLINE_STROKE);
            graphics2D.draw(double1);
        }
    }
    
    public void drawRangeMarker(final Graphics2D graphics2D, final ContourPlot contourPlot, final ValueAxis valueAxis, final Marker marker, final Rectangle2D rectangle2D) {
        if (marker instanceof ValueMarker) {
            final double value = ((ValueMarker)marker).getValue();
            if (!valueAxis.getRange().contains(value)) {
                return;
            }
            final double valueToJava2D = valueAxis.valueToJava2D(value, rectangle2D, RectangleEdge.LEFT);
            final Line2D.Double double1 = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
            final Paint outlinePaint = marker.getOutlinePaint();
            final Stroke outlineStroke = marker.getOutlineStroke();
            graphics2D.setPaint((outlinePaint != null) ? outlinePaint : Plot.DEFAULT_OUTLINE_PAINT);
            graphics2D.setStroke((outlineStroke != null) ? outlineStroke : Plot.DEFAULT_OUTLINE_STROKE);
            graphics2D.draw(double1);
        }
    }
    
    public ClipPath getClipPath() {
        return this.clipPath;
    }
    
    public void setClipPath(final ClipPath clipPath) {
        this.clipPath = clipPath;
    }
    
    public double getPtSizePct() {
        return this.ptSizePct;
    }
    
    public boolean isRenderAsPoints() {
        return this.renderAsPoints;
    }
    
    public void setPtSizePct(final double ptSizePct) {
        this.ptSizePct = ptSizePct;
    }
    
    public void setRenderAsPoints(final boolean renderAsPoints) {
        this.renderAsPoints = renderAsPoints;
    }
    
    public void axisChanged(final AxisChangeEvent axisChangeEvent) {
        final Object source = axisChangeEvent.getSource();
        if (source.equals(this.rangeAxis) || source.equals(this.domainAxis)) {
            final ColorBar colorBar = this.colorBar;
            if (this.colorBar.getAxis().isAutoRange()) {
                colorBar.getAxis().configure();
            }
        }
        super.axisChanged(axisChangeEvent);
    }
    
    public Range visibleRange(final ContourDataset contourDataset, final Range range, final Range range2) {
        return contourDataset.getZValueRange(range, range2);
    }
    
    public Paint getMissingPaint() {
        return this.missingPaint;
    }
    
    public void setMissingPaint(final Paint missingPaint) {
        this.missingPaint = missingPaint;
    }
    
    public void zoomDomainAxes(final double n, final double n2, final double n3) {
    }
    
    public void zoomDomainAxes(final double n, final double n2, final double n3, final double n4) {
    }
    
    public void zoomRangeAxes(final double n, final double n2, final double n3) {
    }
    
    public void zoomRangeAxes(final double n, final double n2, final double n3, final double n4) {
    }
    
    public boolean isDomainZoomable() {
        return false;
    }
    
    public boolean isRangeZoomable() {
        return false;
    }
    
    public Object clone() {
        final ContourPlot contourPlot = (ContourPlot)super.clone();
        if (this.domainAxis != null) {
            (contourPlot.domainAxis = (ValueAxis)this.domainAxis.clone()).setPlot(contourPlot);
            contourPlot.domainAxis.addChangeListener(contourPlot);
        }
        if (this.rangeAxis != null) {
            (contourPlot.rangeAxis = (ValueAxis)this.rangeAxis.clone()).setPlot(contourPlot);
            contourPlot.rangeAxis.addChangeListener(contourPlot);
        }
        if (contourPlot.dataset != null) {
            contourPlot.dataset.addChangeListener(contourPlot);
        }
        if (this.colorBar != null) {
            contourPlot.colorBar = (ColorBar)this.colorBar.clone();
        }
        contourPlot.domainMarkers = (List)ObjectUtilities.deepClone(this.domainMarkers);
        contourPlot.rangeMarkers = (List)ObjectUtilities.deepClone(this.rangeMarkers);
        contourPlot.annotations = (List)ObjectUtilities.deepClone(this.annotations);
        if (this.clipPath != null) {
            contourPlot.clipPath = (ClipPath)this.clipPath.clone();
        }
        return contourPlot;
    }
    
    static {
        DEFAULT_INSETS = new RectangleInsets(2.0, 2.0, 100.0, 10.0);
        ContourPlot.localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    }
}
