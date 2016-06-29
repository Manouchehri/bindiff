/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.PlotChangeListener;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.Zoomable;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class CombinedRangeCategoryPlot
extends CategoryPlot
implements Serializable,
Cloneable,
PlotChangeListener,
Zoomable,
PublicCloneable {
    private static final long serialVersionUID = 7260210007554504515L;
    private List subplots = new ArrayList();
    private int totalWeight = 0;
    private double gap = 5.0;
    private transient Rectangle2D[] subplotArea;

    public CombinedRangeCategoryPlot() {
        this(new NumberAxis());
    }

    public CombinedRangeCategoryPlot(ValueAxis valueAxis) {
        super(null, null, valueAxis, null);
    }

    public double getGap() {
        return this.gap;
    }

    public void setGap(double d2) {
        this.gap = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void add(CategoryPlot categoryPlot) {
        this.add(categoryPlot, 1);
    }

    public void add(CategoryPlot categoryPlot, int n2) {
        if (categoryPlot == null) {
            throw new IllegalArgumentException("Null 'subplot' argument.");
        }
        if (n2 <= 0) {
            throw new IllegalArgumentException("Require weight >= 1.");
        }
        categoryPlot.setParent(this);
        categoryPlot.setWeight(n2);
        categoryPlot.setInsets(new RectangleInsets(0.0, 0.0, 0.0, 0.0));
        categoryPlot.setRangeAxis(null);
        categoryPlot.setOrientation(this.getOrientation());
        categoryPlot.addChangeListener(this);
        this.subplots.add(categoryPlot);
        this.totalWeight += n2;
        ValueAxis valueAxis = this.getRangeAxis();
        if (valueAxis != null) {
            valueAxis.configure();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void remove(CategoryPlot categoryPlot) {
        ValueAxis valueAxis;
        if (categoryPlot == null) {
            throw new IllegalArgumentException(" Null 'subplot' argument.");
        }
        int n2 = -1;
        int n3 = this.subplots.size();
        for (int i2 = 0; n2 == -1 && i2 < n3; ++i2) {
            if (this.subplots.get(i2) != categoryPlot) continue;
            n2 = i2;
        }
        if (n2 == -1) return;
        this.subplots.remove(n2);
        categoryPlot.setParent(null);
        categoryPlot.removeChangeListener(this);
        this.totalWeight -= categoryPlot.getWeight();
        ValueAxis valueAxis2 = this.getRangeAxis();
        if (valueAxis2 != null) {
            valueAxis2.configure();
        }
        if ((valueAxis = this.getRangeAxis(1)) != null) {
            valueAxis.configure();
        }
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
        this.subplotArea = new Rectangle2D[n2];
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
            CategoryPlot categoryPlot = (CategoryPlot)this.subplots.get(n3);
            if (plotOrientation == PlotOrientation.VERTICAL) {
                double d5 = d4 * (double)categoryPlot.getWeight() / (double)this.totalWeight;
                this.subplotArea[n3] = new Rectangle2D.Double(d2, d3, d5, valueAxis.getHeight());
                d2 = d2 + d5 + this.gap;
            } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                double d6 = d4 * (double)categoryPlot.getWeight() / (double)this.totalWeight;
                this.subplotArea[n3] = new Rectangle2D.Double(d2, d3, valueAxis.getWidth(), d6);
                d3 = d3 + d6 + this.gap;
            }
            AxisSpace axisSpace3 = categoryPlot.calculateDomainAxisSpace(graphics2D, this.subplotArea[n3], null);
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
            CategoryPlot categoryPlot = (CategoryPlot)this.subplots.get(n2);
            PlotRenderingInfo plotRenderingInfo2 = null;
            if (plotRenderingInfo != null) {
                plotRenderingInfo2 = new PlotRenderingInfo(plotRenderingInfo.getOwner());
                plotRenderingInfo.addSubplotInfo(plotRenderingInfo2);
            }
            categoryPlot.draw(graphics2D, this.subplotArea[n2], null, plotState, plotRenderingInfo2);
            ++n2;
        } while (true);
    }

    @Override
    public void setOrientation(PlotOrientation plotOrientation) {
        super.setOrientation(plotOrientation);
        Iterator iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            CategoryPlot categoryPlot = (CategoryPlot)iterator.next();
            categoryPlot.setOrientation(plotOrientation);
        }
    }

    @Override
    public Range getDataRange(ValueAxis valueAxis) {
        Range range = null;
        if (this.subplots == null) return range;
        Iterator iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            CategoryPlot categoryPlot = (CategoryPlot)iterator.next();
            range = Range.combine(range, categoryPlot.getDataRange(valueAxis));
        }
        return range;
    }

    @Override
    public LegendItemCollection getLegendItems() {
        LegendItemCollection legendItemCollection = this.getFixedLegendItems();
        if (legendItemCollection != null) return legendItemCollection;
        legendItemCollection = new LegendItemCollection();
        if (this.subplots == null) return legendItemCollection;
        Iterator iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            CategoryPlot categoryPlot = (CategoryPlot)iterator.next();
            LegendItemCollection legendItemCollection2 = categoryPlot.getLegendItems();
            legendItemCollection.addAll(legendItemCollection2);
        }
        return legendItemCollection;
    }

    protected void setFixedDomainAxisSpaceForSubplots(AxisSpace axisSpace) {
        Iterator iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            CategoryPlot categoryPlot = (CategoryPlot)iterator.next();
            categoryPlot.setFixedDomainAxisSpace(axisSpace);
        }
    }

    @Override
    public void handleClick(int n2, int n3, PlotRenderingInfo plotRenderingInfo) {
        Rectangle2D rectangle2D = plotRenderingInfo.getDataArea();
        if (!rectangle2D.contains(n2, n3)) return;
        int n4 = 0;
        while (n4 < this.subplots.size()) {
            CategoryPlot categoryPlot = (CategoryPlot)this.subplots.get(n4);
            PlotRenderingInfo plotRenderingInfo2 = plotRenderingInfo.getSubplotInfo(n4);
            categoryPlot.handleClick(n2, n3, plotRenderingInfo2);
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
        if (!(object instanceof CombinedRangeCategoryPlot)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        CombinedRangeCategoryPlot combinedRangeCategoryPlot = (CombinedRangeCategoryPlot)object;
        if (!ObjectUtilities.equal(this.subplots, combinedRangeCategoryPlot.subplots)) {
            return false;
        }
        if (this.totalWeight != combinedRangeCategoryPlot.totalWeight) {
            return false;
        }
        if (this.gap == combinedRangeCategoryPlot.gap) return true;
        return false;
    }

    @Override
    public Object clone() {
        CombinedRangeCategoryPlot combinedRangeCategoryPlot = (CombinedRangeCategoryPlot)super.clone();
        combinedRangeCategoryPlot.subplots = (List)ObjectUtilities.deepClone(this.subplots);
        Object object = combinedRangeCategoryPlot.subplots.iterator();
        do {
            if (!object.hasNext()) {
                object = combinedRangeCategoryPlot.getRangeAxis();
                if (object == null) return combinedRangeCategoryPlot;
                object.configure();
                return combinedRangeCategoryPlot;
            }
            Plot plot = (Plot)object.next();
            plot.setParent(combinedRangeCategoryPlot);
        } while (true);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        ValueAxis valueAxis = this.getRangeAxis();
        if (valueAxis == null) return;
        valueAxis.configure();
    }
}

