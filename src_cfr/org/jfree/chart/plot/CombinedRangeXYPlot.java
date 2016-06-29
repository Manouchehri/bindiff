/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.PlotChangeListener;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.Zoomable;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.Range;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class CombinedRangeXYPlot
extends XYPlot
implements Serializable,
Cloneable,
PlotChangeListener,
Zoomable,
PublicCloneable {
    private static final long serialVersionUID = -5177814085082031168L;
    private List subplots = new ArrayList();
    private int totalWeight = 0;
    private double gap = 5.0;
    private transient Rectangle2D[] subplotAreas;

    public CombinedRangeXYPlot() {
        this(new NumberAxis());
    }

    public CombinedRangeXYPlot(ValueAxis valueAxis) {
        super(null, null, valueAxis, null);
    }

    @Override
    public String getPlotType() {
        return localizationResources.getString("Combined_Range_XYPlot");
    }

    public double getGap() {
        return this.gap;
    }

    public void setGap(double d2) {
        this.gap = d2;
    }

    public void add(XYPlot xYPlot) {
        this.add(xYPlot, 1);
    }

    public void add(XYPlot xYPlot, int n2) {
        if (n2 <= 0) {
            String string = "The 'weight' must be positive.";
            throw new IllegalArgumentException(string);
        }
        xYPlot.setParent(this);
        xYPlot.setWeight(n2);
        xYPlot.setInsets(new RectangleInsets(0.0, 0.0, 0.0, 0.0));
        xYPlot.setRangeAxis(null);
        xYPlot.addChangeListener(this);
        this.subplots.add(xYPlot);
        this.totalWeight += n2;
        this.configureRangeAxes();
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void remove(XYPlot xYPlot) {
        if (xYPlot == null) {
            throw new IllegalArgumentException(" Null 'subplot' argument.");
        }
        int n2 = -1;
        int n3 = this.subplots.size();
        for (int i2 = 0; n2 == -1 && i2 < n3; ++i2) {
            if (this.subplots.get(i2) != xYPlot) continue;
            n2 = i2;
        }
        if (n2 == -1) return;
        xYPlot.setParent(null);
        xYPlot.removeChangeListener(this);
        this.totalWeight -= xYPlot.getWeight();
        this.configureRangeAxes();
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public List getSubplots() {
        return Collections.unmodifiableList(this.subplots);
    }

    @Override
    protected AxisSpace calculateAxisSpace(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        ValueAxis valueAxis;
        AxisSpace axisSpace = new AxisSpace();
        PlotOrientation plotOrientation = this.getOrientation();
        AxisSpace axisSpace2 = this.getFixedRangeAxisSpace();
        if (axisSpace2 != null) {
            if (plotOrientation == PlotOrientation.VERTICAL) {
                axisSpace.setLeft(axisSpace2.getLeft());
                axisSpace.setRight(axisSpace2.getRight());
            } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                axisSpace.setTop(axisSpace2.getTop());
                axisSpace.setBottom(axisSpace2.getBottom());
            }
        } else {
            valueAxis = this.getRangeAxis();
            RectangleEdge rectangleEdge = Plot.resolveRangeAxisLocation(this.getRangeAxisLocation(), plotOrientation);
            if (valueAxis != null) {
                axisSpace = valueAxis.reserveSpace(graphics2D, this, rectangle2D, rectangleEdge, axisSpace);
            }
        }
        valueAxis = axisSpace.shrink(rectangle2D, null);
        int n2 = this.subplots.size();
        this.subplotAreas = new Rectangle2D[n2];
        double d2 = valueAxis.getX();
        double d3 = valueAxis.getY();
        double d4 = 0.0;
        if (plotOrientation == PlotOrientation.VERTICAL) {
            d4 = valueAxis.getWidth() - this.gap * (double)(n2 - 1);
        } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d4 = valueAxis.getHeight() - this.gap * (double)(n2 - 1);
        }
        int n3 = 0;
        while (n3 < n2) {
            XYPlot xYPlot = (XYPlot)this.subplots.get(n3);
            if (plotOrientation == PlotOrientation.VERTICAL) {
                double d5 = d4 * (double)xYPlot.getWeight() / (double)this.totalWeight;
                this.subplotAreas[n3] = new Rectangle2D.Double(d2, d3, d5, valueAxis.getHeight());
                d2 = d2 + d5 + this.gap;
            } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                double d6 = d4 * (double)xYPlot.getWeight() / (double)this.totalWeight;
                this.subplotAreas[n3] = new Rectangle2D.Double(d2, d3, valueAxis.getWidth(), d6);
                d3 = d3 + d6 + this.gap;
            }
            AxisSpace axisSpace3 = xYPlot.calculateDomainAxisSpace(graphics2D, this.subplotAreas[n3], null);
            axisSpace.ensureAtLeast(axisSpace3);
            ++n3;
        }
        return axisSpace;
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
        }
        RectangleInsets rectangleInsets = this.getInsets();
        rectangleInsets.trim(rectangle2D);
        AxisSpace axisSpace = this.calculateAxisSpace(graphics2D, rectangle2D);
        Rectangle2D rectangle2D2 = axisSpace.shrink(rectangle2D, null);
        this.setFixedDomainAxisSpaceForSubplots(axisSpace);
        ValueAxis valueAxis = this.getRangeAxis();
        RectangleEdge rectangleEdge = this.getRangeAxisEdge();
        double d2 = RectangleEdge.coordinate(rectangle2D2, rectangleEdge);
        AxisState axisState = valueAxis.draw(graphics2D, d2, rectangle2D, rectangle2D2, rectangleEdge, plotRenderingInfo);
        if (plotState == null) {
            plotState = new PlotState();
        }
        plotState.getSharedAxisStates().put(valueAxis, axisState);
        int n2 = 0;
        do {
            if (n2 >= this.subplots.size()) {
                if (plotRenderingInfo == null) return;
                plotRenderingInfo.setDataArea(rectangle2D2);
                return;
            }
            XYPlot xYPlot = (XYPlot)this.subplots.get(n2);
            PlotRenderingInfo plotRenderingInfo2 = null;
            if (plotRenderingInfo != null) {
                plotRenderingInfo2 = new PlotRenderingInfo(plotRenderingInfo.getOwner());
                plotRenderingInfo.addSubplotInfo(plotRenderingInfo2);
            }
            xYPlot.draw(graphics2D, this.subplotAreas[n2], point2D, plotState, plotRenderingInfo2);
            ++n2;
        } while (true);
    }

    @Override
    public LegendItemCollection getLegendItems() {
        LegendItemCollection legendItemCollection = this.getFixedLegendItems();
        if (legendItemCollection != null) return legendItemCollection;
        legendItemCollection = new LegendItemCollection();
        if (this.subplots == null) return legendItemCollection;
        Iterator iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            XYPlot xYPlot = (XYPlot)iterator.next();
            LegendItemCollection legendItemCollection2 = xYPlot.getLegendItems();
            legendItemCollection.addAll(legendItemCollection2);
        }
        return legendItemCollection;
    }

    @Override
    public void zoomDomainAxes(double d2, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        XYPlot xYPlot = this.findSubplot(plotRenderingInfo, point2D);
        if (xYPlot == null) return;
        xYPlot.zoomDomainAxes(d2, plotRenderingInfo, point2D);
    }

    @Override
    public void zoomDomainAxes(double d2, double d3, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        XYPlot xYPlot = this.findSubplot(plotRenderingInfo, point2D);
        if (xYPlot == null) return;
        xYPlot.zoomDomainAxes(d2, d3, plotRenderingInfo, point2D);
    }

    public XYPlot findSubplot(PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        XYPlot xYPlot = null;
        int n2 = plotRenderingInfo.getSubplotIndex(point2D);
        if (n2 < 0) return xYPlot;
        return (XYPlot)this.subplots.get(n2);
    }

    @Override
    public void setRenderer(XYItemRenderer xYItemRenderer) {
        super.setRenderer(xYItemRenderer);
        Iterator iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            XYPlot xYPlot = (XYPlot)iterator.next();
            xYPlot.setRenderer(xYItemRenderer);
        }
    }

    @Override
    public void setOrientation(PlotOrientation plotOrientation) {
        super.setOrientation(plotOrientation);
        Iterator iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            XYPlot xYPlot = (XYPlot)iterator.next();
            xYPlot.setOrientation(plotOrientation);
        }
    }

    @Override
    public Range getDataRange(ValueAxis valueAxis) {
        Range range = null;
        if (this.subplots == null) return range;
        Iterator iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            XYPlot xYPlot = (XYPlot)iterator.next();
            range = Range.combine(range, xYPlot.getDataRange(valueAxis));
        }
        return range;
    }

    protected void setFixedDomainAxisSpaceForSubplots(AxisSpace axisSpace) {
        Iterator iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            XYPlot xYPlot = (XYPlot)iterator.next();
            xYPlot.setFixedDomainAxisSpace(axisSpace);
        }
    }

    @Override
    public void handleClick(int n2, int n3, PlotRenderingInfo plotRenderingInfo) {
        Rectangle2D rectangle2D = plotRenderingInfo.getDataArea();
        if (!rectangle2D.contains(n2, n3)) return;
        int n4 = 0;
        while (n4 < this.subplots.size()) {
            XYPlot xYPlot = (XYPlot)this.subplots.get(n4);
            PlotRenderingInfo plotRenderingInfo2 = plotRenderingInfo.getSubplotInfo(n4);
            xYPlot.handleClick(n2, n3, plotRenderingInfo2);
            ++n4;
        }
    }

    @Override
    public void plotChanged(PlotChangeEvent plotChangeEvent) {
        this.notifyListeners(plotChangeEvent);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CombinedRangeXYPlot)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        CombinedRangeXYPlot combinedRangeXYPlot = (CombinedRangeXYPlot)object;
        if (!ObjectUtilities.equal(this.subplots, combinedRangeXYPlot.subplots)) {
            return false;
        }
        if (this.totalWeight != combinedRangeXYPlot.totalWeight) {
            return false;
        }
        if (this.gap == combinedRangeXYPlot.gap) return true;
        return false;
    }

    @Override
    public Object clone() {
        CombinedRangeXYPlot combinedRangeXYPlot = (CombinedRangeXYPlot)super.clone();
        combinedRangeXYPlot.subplots = (List)ObjectUtilities.deepClone(this.subplots);
        Object object = combinedRangeXYPlot.subplots.iterator();
        do {
            if (!object.hasNext()) {
                object = combinedRangeXYPlot.getRangeAxis();
                if (object == null) return combinedRangeXYPlot;
                object.configure();
                return combinedRangeXYPlot;
            }
            Plot plot = (Plot)object.next();
            plot.setParent(combinedRangeXYPlot);
        } while (true);
    }
}

