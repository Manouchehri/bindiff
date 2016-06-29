package org.jfree.chart.plot;

import java.io.*;
import org.jfree.data.category.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.event.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.*;
import org.jfree.util.*;
import java.util.*;

public class CombinedDomainCategoryPlot extends CategoryPlot implements Serializable, Cloneable, PlotChangeListener, Zoomable, PublicCloneable
{
    private static final long serialVersionUID = 8207194522653701572L;
    private List subplots;
    private int totalWeight;
    private double gap;
    private transient Rectangle2D[] subplotAreas;
    
    public CombinedDomainCategoryPlot() {
        this(new CategoryAxis());
    }
    
    public CombinedDomainCategoryPlot(final CategoryAxis categoryAxis) {
        super(null, categoryAxis, null, null);
        this.subplots = new ArrayList();
        this.totalWeight = 0;
        this.gap = 5.0;
    }
    
    public double getGap() {
        return this.gap;
    }
    
    public void setGap(final double gap) {
        this.gap = gap;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void add(final CategoryPlot categoryPlot) {
        this.add(categoryPlot, 1);
    }
    
    public void add(final CategoryPlot categoryPlot, final int weight) {
        if (categoryPlot == null) {
            throw new IllegalArgumentException("Null 'subplot' argument.");
        }
        if (weight < 1) {
            throw new IllegalArgumentException("Require weight >= 1.");
        }
        categoryPlot.setParent(this);
        categoryPlot.setWeight(weight);
        categoryPlot.setInsets(new RectangleInsets(0.0, 0.0, 0.0, 0.0));
        categoryPlot.setDomainAxis(null);
        categoryPlot.setOrientation(this.getOrientation());
        categoryPlot.addChangeListener(this);
        this.subplots.add(categoryPlot);
        this.totalWeight += weight;
        final CategoryAxis domainAxis = this.getDomainAxis();
        if (domainAxis != null) {
            domainAxis.configure();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void remove(final CategoryPlot categoryPlot) {
        if (categoryPlot == null) {
            throw new IllegalArgumentException("Null 'subplot' argument.");
        }
        int n = -1;
        for (int size = this.subplots.size(), n2 = 0; n == -1 && n2 < size; ++n2) {
            if (this.subplots.get(n2) == categoryPlot) {
                n = n2;
            }
        }
        if (n != -1) {
            this.subplots.remove(n);
            categoryPlot.setParent(null);
            categoryPlot.removeChangeListener(this);
            this.totalWeight -= categoryPlot.getWeight();
            final CategoryAxis domainAxis = this.getDomainAxis();
            if (domainAxis != null) {
                domainAxis.configure();
            }
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public List getSubplots() {
        return Collections.unmodifiableList((List<?>)this.subplots);
    }
    
    public CategoryPlot findSubplot(final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        CategoryPlot categoryPlot = null;
        final int subplotIndex = plotRenderingInfo.getSubplotIndex(point2D);
        if (subplotIndex >= 0) {
            categoryPlot = (CategoryPlot)this.subplots.get(subplotIndex);
        }
        return categoryPlot;
    }
    
    public void zoomRangeAxes(final double n, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        final CategoryPlot subplot = this.findSubplot(plotRenderingInfo, point2D);
        if (subplot != null) {
            subplot.zoomRangeAxes(n, plotRenderingInfo, point2D);
        }
    }
    
    public void zoomRangeAxes(final double n, final double n2, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        final CategoryPlot subplot = this.findSubplot(plotRenderingInfo, point2D);
        if (subplot != null) {
            subplot.zoomRangeAxes(n, n2, plotRenderingInfo, point2D);
        }
    }
    
    protected AxisSpace calculateAxisSpace(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        AxisSpace axisSpace = new AxisSpace();
        final PlotOrientation orientation = this.getOrientation();
        final AxisSpace fixedDomainAxisSpace = this.getFixedDomainAxisSpace();
        if (fixedDomainAxisSpace != null) {
            if (orientation == PlotOrientation.HORIZONTAL) {
                axisSpace.setLeft(fixedDomainAxisSpace.getLeft());
                axisSpace.setRight(fixedDomainAxisSpace.getRight());
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                axisSpace.setTop(fixedDomainAxisSpace.getTop());
                axisSpace.setBottom(fixedDomainAxisSpace.getBottom());
            }
        }
        else {
            final CategoryAxis domainAxis = this.getDomainAxis();
            final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(this.getDomainAxisLocation(), orientation);
            if (domainAxis != null) {
                axisSpace = domainAxis.reserveSpace(graphics2D, this, rectangle2D, resolveDomainAxisLocation, axisSpace);
            }
            else if (this.getDrawSharedDomainAxis()) {
                axisSpace = this.getDomainAxis().reserveSpace(graphics2D, this, rectangle2D, resolveDomainAxisLocation, axisSpace);
            }
        }
        final Rectangle2D shrink = axisSpace.shrink(rectangle2D, null);
        final int size = this.subplots.size();
        this.subplotAreas = new Rectangle2D[size];
        double x = shrink.getX();
        double y = shrink.getY();
        double n = 0.0;
        if (orientation == PlotOrientation.HORIZONTAL) {
            n = shrink.getWidth() - this.gap * (size - 1);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            n = shrink.getHeight() - this.gap * (size - 1);
        }
        for (int i = 0; i < size; ++i) {
            final CategoryPlot categoryPlot = this.subplots.get(i);
            if (orientation == PlotOrientation.HORIZONTAL) {
                final double n2 = n * categoryPlot.getWeight() / this.totalWeight;
                this.subplotAreas[i] = new Rectangle2D.Double(x, y, n2, shrink.getHeight());
                x = x + n2 + this.gap;
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                final double n3 = n * categoryPlot.getWeight() / this.totalWeight;
                this.subplotAreas[i] = new Rectangle2D.Double(x, y, shrink.getWidth(), n3);
                y = y + n3 + this.gap;
            }
            axisSpace.ensureAtLeast(categoryPlot.calculateRangeAxisSpace(graphics2D, this.subplotAreas[i], null));
        }
        return axisSpace;
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D plotArea, final Point2D point2D, PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(plotArea);
        }
        final RectangleInsets insets = this.getInsets();
        plotArea.setRect(plotArea.getX() + insets.getLeft(), plotArea.getY() + insets.getTop(), plotArea.getWidth() - insets.getLeft() - insets.getRight(), plotArea.getHeight() - insets.getTop() - insets.getBottom());
        this.setFixedRangeAxisSpaceForSubplots(null);
        final AxisSpace calculateAxisSpace = this.calculateAxisSpace(graphics2D, plotArea);
        final Rectangle2D shrink = calculateAxisSpace.shrink(plotArea, null);
        this.setFixedRangeAxisSpaceForSubplots(calculateAxisSpace);
        final CategoryAxis domainAxis = this.getDomainAxis();
        final RectangleEdge domainAxisEdge = this.getDomainAxisEdge();
        final AxisState draw = domainAxis.draw(graphics2D, RectangleEdge.coordinate(shrink, domainAxisEdge), plotArea, shrink, domainAxisEdge, plotRenderingInfo);
        if (plotState == null) {
            plotState = new PlotState();
        }
        plotState.getSharedAxisStates().put(domainAxis, draw);
        for (int i = 0; i < this.subplots.size(); ++i) {
            final CategoryPlot categoryPlot = this.subplots.get(i);
            PlotRenderingInfo plotRenderingInfo2 = null;
            if (plotRenderingInfo != null) {
                plotRenderingInfo2 = new PlotRenderingInfo(plotRenderingInfo.getOwner());
                plotRenderingInfo.addSubplotInfo(plotRenderingInfo2);
            }
            categoryPlot.draw(graphics2D, this.subplotAreas[i], null, plotState, plotRenderingInfo2);
        }
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setDataArea(shrink);
        }
    }
    
    protected void setFixedRangeAxisSpaceForSubplots(final AxisSpace fixedRangeAxisSpace) {
        final Iterator<CategoryPlot> iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            iterator.next().setFixedRangeAxisSpace(fixedRangeAxisSpace);
        }
    }
    
    public void setOrientation(final PlotOrientation plotOrientation) {
        super.setOrientation(plotOrientation);
        final Iterator<CategoryPlot> iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            iterator.next().setOrientation(plotOrientation);
        }
    }
    
    public LegendItemCollection getLegendItems() {
        LegendItemCollection fixedLegendItems = this.getFixedLegendItems();
        if (fixedLegendItems == null) {
            fixedLegendItems = new LegendItemCollection();
            if (this.subplots != null) {
                final Iterator<CategoryPlot> iterator = this.subplots.iterator();
                while (iterator.hasNext()) {
                    fixedLegendItems.addAll(iterator.next().getLegendItems());
                }
            }
        }
        return fixedLegendItems;
    }
    
    public List getCategories() {
        final ArrayList<Object> list = new ArrayList<Object>();
        if (this.subplots != null) {
            final Iterator<CategoryPlot> iterator = this.subplots.iterator();
            while (iterator.hasNext()) {
                for (final Comparable<?> comparable : iterator.next().getCategories()) {
                    if (!list.contains(comparable)) {
                        list.add(comparable);
                    }
                }
            }
        }
        return Collections.unmodifiableList((List<?>)list);
    }
    
    public List getCategoriesForAxis(final CategoryAxis categoryAxis) {
        return this.getCategories();
    }
    
    public void handleClick(final int n, final int n2, final PlotRenderingInfo plotRenderingInfo) {
        if (plotRenderingInfo.getDataArea().contains(n, n2)) {
            for (int i = 0; i < this.subplots.size(); ++i) {
                ((CategoryPlot)this.subplots.get(i)).handleClick(n, n2, plotRenderingInfo.getSubplotInfo(i));
            }
        }
    }
    
    public void plotChanged(final PlotChangeEvent plotChangeEvent) {
        this.notifyListeners(plotChangeEvent);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CombinedDomainCategoryPlot)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CombinedDomainCategoryPlot combinedDomainCategoryPlot = (CombinedDomainCategoryPlot)o;
        return ObjectUtilities.equal(this.subplots, combinedDomainCategoryPlot.subplots) && this.totalWeight == combinedDomainCategoryPlot.totalWeight && this.gap == combinedDomainCategoryPlot.gap;
    }
    
    public Object clone() {
        final CombinedDomainCategoryPlot parent = (CombinedDomainCategoryPlot)super.clone();
        parent.subplots = (List)ObjectUtilities.deepClone(this.subplots);
        final Iterator iterator = parent.subplots.iterator();
        while (iterator.hasNext()) {
            iterator.next().setParent(parent);
        }
        return parent;
    }
}
