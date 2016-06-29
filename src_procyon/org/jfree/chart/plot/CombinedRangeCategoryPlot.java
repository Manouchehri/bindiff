package org.jfree.chart.plot;

import org.jfree.data.category.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.event.*;
import java.awt.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.data.*;
import org.jfree.chart.*;
import org.jfree.util.*;
import java.util.*;
import java.io.*;

public class CombinedRangeCategoryPlot extends CategoryPlot implements Serializable, Cloneable, PlotChangeListener, Zoomable, PublicCloneable
{
    private static final long serialVersionUID = 7260210007554504515L;
    private List subplots;
    private int totalWeight;
    private double gap;
    private transient Rectangle2D[] subplotArea;
    
    public CombinedRangeCategoryPlot() {
        this(new NumberAxis());
    }
    
    public CombinedRangeCategoryPlot(final ValueAxis valueAxis) {
        super(null, null, valueAxis, null);
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
        if (weight <= 0) {
            throw new IllegalArgumentException("Require weight >= 1.");
        }
        categoryPlot.setParent(this);
        categoryPlot.setWeight(weight);
        categoryPlot.setInsets(new RectangleInsets(0.0, 0.0, 0.0, 0.0));
        categoryPlot.setRangeAxis(null);
        categoryPlot.setOrientation(this.getOrientation());
        categoryPlot.addChangeListener(this);
        this.subplots.add(categoryPlot);
        this.totalWeight += weight;
        final ValueAxis rangeAxis = this.getRangeAxis();
        if (rangeAxis != null) {
            rangeAxis.configure();
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void remove(final CategoryPlot categoryPlot) {
        if (categoryPlot == null) {
            throw new IllegalArgumentException(" Null 'subplot' argument.");
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
            final ValueAxis rangeAxis = this.getRangeAxis();
            if (rangeAxis != null) {
                rangeAxis.configure();
            }
            final ValueAxis rangeAxis2 = this.getRangeAxis(1);
            if (rangeAxis2 != null) {
                rangeAxis2.configure();
            }
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public List getSubplots() {
        return Collections.unmodifiableList((List<?>)this.subplots);
    }
    
    protected AxisSpace calculateAxisSpace(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        AxisSpace reserveSpace = new AxisSpace();
        final PlotOrientation orientation = this.getOrientation();
        final AxisSpace fixedRangeAxisSpace = this.getFixedRangeAxisSpace();
        if (fixedRangeAxisSpace != null) {
            if (orientation == PlotOrientation.VERTICAL) {
                reserveSpace.setLeft(fixedRangeAxisSpace.getLeft());
                reserveSpace.setRight(fixedRangeAxisSpace.getRight());
            }
            else if (orientation == PlotOrientation.HORIZONTAL) {
                reserveSpace.setTop(fixedRangeAxisSpace.getTop());
                reserveSpace.setBottom(fixedRangeAxisSpace.getBottom());
            }
        }
        else {
            final ValueAxis rangeAxis = this.getRangeAxis();
            final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(this.getRangeAxisLocation(), orientation);
            if (rangeAxis != null) {
                reserveSpace = rangeAxis.reserveSpace(graphics2D, this, rectangle2D, resolveRangeAxisLocation, reserveSpace);
            }
        }
        final Rectangle2D shrink = reserveSpace.shrink(rectangle2D, null);
        final int size = this.subplots.size();
        this.subplotArea = new Rectangle2D[size];
        double x = shrink.getX();
        double y = shrink.getY();
        double n = 0.0;
        if (orientation == PlotOrientation.VERTICAL) {
            n = shrink.getWidth() - this.gap * (size - 1);
        }
        else if (orientation == PlotOrientation.HORIZONTAL) {
            n = shrink.getHeight() - this.gap * (size - 1);
        }
        for (int i = 0; i < size; ++i) {
            final CategoryPlot categoryPlot = this.subplots.get(i);
            if (orientation == PlotOrientation.VERTICAL) {
                final double n2 = n * categoryPlot.getWeight() / this.totalWeight;
                this.subplotArea[i] = new Rectangle2D.Double(x, y, n2, shrink.getHeight());
                x = x + n2 + this.gap;
            }
            else if (orientation == PlotOrientation.HORIZONTAL) {
                final double n3 = n * categoryPlot.getWeight() / this.totalWeight;
                this.subplotArea[i] = new Rectangle2D.Double(x, y, shrink.getWidth(), n3);
                y = y + n3 + this.gap;
            }
            reserveSpace.ensureAtLeast(categoryPlot.calculateDomainAxisSpace(graphics2D, this.subplotArea[i], null));
        }
        return reserveSpace;
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D plotArea, final Point2D point2D, PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(plotArea);
        }
        this.getInsets().trim(plotArea);
        final AxisSpace calculateAxisSpace = this.calculateAxisSpace(graphics2D, plotArea);
        final Rectangle2D shrink = calculateAxisSpace.shrink(plotArea, null);
        this.setFixedDomainAxisSpaceForSubplots(calculateAxisSpace);
        final ValueAxis rangeAxis = this.getRangeAxis();
        final RectangleEdge rangeAxisEdge = this.getRangeAxisEdge();
        final AxisState draw = rangeAxis.draw(graphics2D, RectangleEdge.coordinate(shrink, rangeAxisEdge), plotArea, shrink, rangeAxisEdge, plotRenderingInfo);
        if (plotState == null) {
            plotState = new PlotState();
        }
        plotState.getSharedAxisStates().put(rangeAxis, draw);
        for (int i = 0; i < this.subplots.size(); ++i) {
            final CategoryPlot categoryPlot = this.subplots.get(i);
            PlotRenderingInfo plotRenderingInfo2 = null;
            if (plotRenderingInfo != null) {
                plotRenderingInfo2 = new PlotRenderingInfo(plotRenderingInfo.getOwner());
                plotRenderingInfo.addSubplotInfo(plotRenderingInfo2);
            }
            categoryPlot.draw(graphics2D, this.subplotArea[i], null, plotState, plotRenderingInfo2);
        }
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setDataArea(shrink);
        }
    }
    
    public void setOrientation(final PlotOrientation plotOrientation) {
        super.setOrientation(plotOrientation);
        final Iterator<CategoryPlot> iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            iterator.next().setOrientation(plotOrientation);
        }
    }
    
    public Range getDataRange(final ValueAxis valueAxis) {
        Range combine = null;
        if (this.subplots != null) {
            final Iterator<CategoryPlot> iterator = this.subplots.iterator();
            while (iterator.hasNext()) {
                combine = Range.combine(combine, iterator.next().getDataRange(valueAxis));
            }
        }
        return combine;
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
    
    protected void setFixedDomainAxisSpaceForSubplots(final AxisSpace fixedDomainAxisSpace) {
        final Iterator<CategoryPlot> iterator = this.subplots.iterator();
        while (iterator.hasNext()) {
            iterator.next().setFixedDomainAxisSpace(fixedDomainAxisSpace);
        }
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
        if (!(o instanceof CombinedRangeCategoryPlot)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CombinedRangeCategoryPlot combinedRangeCategoryPlot = (CombinedRangeCategoryPlot)o;
        return ObjectUtilities.equal(this.subplots, combinedRangeCategoryPlot.subplots) && this.totalWeight == combinedRangeCategoryPlot.totalWeight && this.gap == combinedRangeCategoryPlot.gap;
    }
    
    public Object clone() {
        final CombinedRangeCategoryPlot parent = (CombinedRangeCategoryPlot)super.clone();
        parent.subplots = (List)ObjectUtilities.deepClone(this.subplots);
        final Iterator iterator = parent.subplots.iterator();
        while (iterator.hasNext()) {
            iterator.next().setParent(parent);
        }
        final ValueAxis rangeAxis = parent.getRangeAxis();
        if (rangeAxis != null) {
            rangeAxis.configure();
        }
        return parent;
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        final ValueAxis rangeAxis = this.getRangeAxis();
        if (rangeAxis != null) {
            rangeAxis.configure();
        }
    }
}
