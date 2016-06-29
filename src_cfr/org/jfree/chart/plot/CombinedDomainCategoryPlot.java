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
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.CategoryAxis;
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
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class CombinedDomainCategoryPlot
extends CategoryPlot
implements Serializable,
Cloneable,
PlotChangeListener,
Zoomable,
PublicCloneable {
    private static final long serialVersionUID = 8207194522653701572L;
    private List subplots = new ArrayList();
    private int totalWeight = 0;
    private double gap = 5.0;
    private transient Rectangle2D[] subplotAreas;

    public CombinedDomainCategoryPlot() {
        this(new CategoryAxis());
    }

    public CombinedDomainCategoryPlot(CategoryAxis categoryAxis) {
        super(null, categoryAxis, null, null);
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
        if (n2 < 1) {
            throw new IllegalArgumentException("Require weight >= 1.");
        }
        categoryPlot.setParent(this);
        categoryPlot.setWeight(n2);
        categoryPlot.setInsets(new RectangleInsets(0.0, 0.0, 0.0, 0.0));
        categoryPlot.setDomainAxis(null);
        categoryPlot.setOrientation(this.getOrientation());
        categoryPlot.addChangeListener(this);
        this.subplots.add(categoryPlot);
        this.totalWeight += n2;
        CategoryAxis categoryAxis = this.getDomainAxis();
        if (categoryAxis != null) {
            categoryAxis.configure();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void remove(CategoryPlot categoryPlot) {
        if (categoryPlot == null) {
            throw new IllegalArgumentException("Null 'subplot' argument.");
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
        CategoryAxis categoryAxis = this.getDomainAxis();
        if (categoryAxis != null) {
            categoryAxis.configure();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public List getSubplots() {
        return Collections.unmodifiableList(this.subplots);
    }

    public CategoryPlot findSubplot(PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        CategoryPlot categoryPlot = null;
        int n2 = plotRenderingInfo.getSubplotIndex(point2D);
        if (n2 < 0) return categoryPlot;
        return (CategoryPlot)this.subplots.get(n2);
    }

    @Override
    public void zoomRangeAxes(double d2, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        CategoryPlot categoryPlot = this.findSubplot(plotRenderingInfo, point2D);
        if (categoryPlot == null) return;
        categoryPlot.zoomRangeAxes(d2, plotRenderingInfo, point2D);
    }

    @Override
    public void zoomRangeAxes(double d2, double d3, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        CategoryPlot categoryPlot = this.findSubplot(plotRenderingInfo, point2D);
        if (categoryPlot == null) return;
        categoryPlot.zoomRangeAxes(d2, d3, plotRenderingInfo, point2D);
    }

    @Override
    protected AxisSpace calculateAxisSpace(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        CategoryAxis categoryAxis;
        AxisSpace axisSpace = new AxisSpace();
        PlotOrientation plotOrientation = this.getOrientation();
        AxisSpace axisSpace2 = this.getFixedDomainAxisSpace();
        if (axisSpace2 != null) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                axisSpace.setLeft(axisSpace2.getLeft());
                axisSpace.setRight(axisSpace2.getRight());
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                axisSpace.setTop(axisSpace2.getTop());
                axisSpace.setBottom(axisSpace2.getBottom());
            }
        } else {
            categoryAxis = this.getDomainAxis();
            RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(this.getDomainAxisLocation(), plotOrientation);
            if (categoryAxis != null) {
                axisSpace = categoryAxis.reserveSpace(graphics2D, this, rectangle2D, rectangleEdge, axisSpace);
            } else if (this.getDrawSharedDomainAxis()) {
                axisSpace = this.getDomainAxis().reserveSpace(graphics2D, this, rectangle2D, rectangleEdge, axisSpace);
            }
        }
        categoryAxis = axisSpace.shrink(rectangle2D, null);
        int n2 = this.subplots.size();
        this.subplotAreas = new Rectangle2D[n2];
        double d2 = categoryAxis.getX();
        double d3 = categoryAxis.getY();
        double d4 = 0.0;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d4 = categoryAxis.getWidth() - this.gap * (double)(n2 - 1);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d4 = categoryAxis.getHeight() - this.gap * (double)(n2 - 1);
        }
        int n3 = 0;
        while (n3 < n2) {
            CategoryPlot categoryPlot = (CategoryPlot)this.subplots.get(n3);
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                double d5 = d4 * (double)categoryPlot.getWeight() / (double)this.totalWeight;
                this.subplotAreas[n3] = new Rectangle2D.Double(d2, d3, d5, categoryAxis.getHeight());
                d2 = d2 + d5 + this.gap;
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                double d6 = d4 * (double)categoryPlot.getWeight() / (double)this.totalWeight;
                this.subplotAreas[n3] = new Rectangle2D.Double(d2, d3, categoryAxis.getWidth(), d6);
                d3 = d3 + d6 + this.gap;
            }
            AxisSpace axisSpace3 = categoryPlot.calculateRangeAxisSpace(graphics2D, this.subplotAreas[n3], null);
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
        rectangle2D.setRect(rectangle2D.getX() + rectangleInsets.getLeft(), rectangle2D.getY() + rectangleInsets.getTop(), rectangle2D.getWidth() - rectangleInsets.getLeft() - rectangleInsets.getRight(), rectangle2D.getHeight() - rectangleInsets.getTop() - rectangleInsets.getBottom());
        this.setFixedRangeAxisSpaceForSubplots(null);
        AxisSpace axisSpace = this.calculateAxisSpace(graphics2D, rectangle2D);
        Rectangle2D rectangle2D2 = axisSpace.shrink(rectangle2D, null);
        this.setFixedRangeAxisSpaceForSubplots(axisSpace);
        CategoryAxis categoryAxis = this.getDomainAxis();
        RectangleEdge rectangleEdge = this.getDomainAxisEdge();
        double d2 = RectangleEdge.coordinate(rectangle2D2, rectangleEdge);
        AxisState axisState = categoryAxis.draw(graphics2D, d2, rectangle2D, rectangle2D2, rectangleEdge, plotRenderingInfo);
        if (plotState == null) {
            plotState = new PlotState();
        }
        plotState.getSharedAxisStates().put(categoryAxis, axisState);
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
            categoryPlot.draw(graphics2D, this.subplotAreas[n2], null, plotState, plotRenderingInfo2);
            ++n2;
        } while (true);
    }

    protected void setFixedRangeAxisSpaceForSubplots(AxisSpace axisSpace) {
        Iterator iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            CategoryPlot categoryPlot = (CategoryPlot)iterator.next();
            categoryPlot.setFixedRangeAxisSpace(axisSpace);
        }
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

    @Override
    public List getCategories() {
        ArrayList<Comparable> arrayList = new ArrayList<Comparable>();
        if (this.subplots == null) return Collections.unmodifiableList(arrayList);
        Iterator iterator = this.subplots.iterator();
        block0 : while (iterator.hasNext()) {
            CategoryPlot categoryPlot = (CategoryPlot)iterator.next();
            List list = categoryPlot.getCategories();
            Iterator iterator2 = list.iterator();
            do {
                if (!iterator2.hasNext()) continue block0;
                Comparable comparable = (Comparable)iterator2.next();
                if (arrayList.contains(comparable)) continue;
                arrayList.add(comparable);
            } while (true);
            break;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override
    public List getCategoriesForAxis(CategoryAxis categoryAxis) {
        return this.getCategories();
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
        if (!(object instanceof CombinedDomainCategoryPlot)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        CombinedDomainCategoryPlot combinedDomainCategoryPlot = (CombinedDomainCategoryPlot)object;
        if (!ObjectUtilities.equal(this.subplots, combinedDomainCategoryPlot.subplots)) {
            return false;
        }
        if (this.totalWeight != combinedDomainCategoryPlot.totalWeight) {
            return false;
        }
        if (this.gap == combinedDomainCategoryPlot.gap) return true;
        return false;
    }

    @Override
    public Object clone() {
        CombinedDomainCategoryPlot combinedDomainCategoryPlot = (CombinedDomainCategoryPlot)super.clone();
        combinedDomainCategoryPlot.subplots = (List)ObjectUtilities.deepClone(this.subplots);
        Iterator iterator = combinedDomainCategoryPlot.subplots.iterator();
        while (iterator.hasNext()) {
            Plot plot = (Plot)iterator.next();
            plot.setParent(combinedDomainCategoryPlot);
        }
        return combinedDomainCategoryPlot;
    }
}

