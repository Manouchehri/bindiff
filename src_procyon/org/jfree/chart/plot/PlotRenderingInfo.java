package org.jfree.chart.plot;

import org.jfree.chart.*;
import java.util.*;
import java.awt.geom.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.awt.*;
import java.io.*;

public class PlotRenderingInfo implements Serializable, Cloneable
{
    private static final long serialVersionUID = 8446720134379617220L;
    private ChartRenderingInfo owner;
    private transient Rectangle2D plotArea;
    private transient Rectangle2D dataArea;
    private List subplotInfo;
    
    public PlotRenderingInfo(final ChartRenderingInfo owner) {
        this.owner = owner;
        this.dataArea = new Rectangle2D.Double();
        this.subplotInfo = new ArrayList();
    }
    
    public ChartRenderingInfo getOwner() {
        return this.owner;
    }
    
    public Rectangle2D getPlotArea() {
        return this.plotArea;
    }
    
    public void setPlotArea(final Rectangle2D plotArea) {
        this.plotArea = plotArea;
    }
    
    public Rectangle2D getDataArea() {
        return this.dataArea;
    }
    
    public void setDataArea(final Rectangle2D dataArea) {
        this.dataArea = dataArea;
    }
    
    public int getSubplotCount() {
        return this.subplotInfo.size();
    }
    
    public void addSubplotInfo(final PlotRenderingInfo plotRenderingInfo) {
        this.subplotInfo.add(plotRenderingInfo);
    }
    
    public PlotRenderingInfo getSubplotInfo(final int n) {
        return this.subplotInfo.get(n);
    }
    
    public int getSubplotIndex(final Point2D point2D) {
        for (int subplotCount = this.getSubplotCount(), i = 0; i < subplotCount; ++i) {
            if (this.getSubplotInfo(i).getDataArea().contains(point2D)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlotRenderingInfo)) {
            return false;
        }
        final PlotRenderingInfo plotRenderingInfo = (PlotRenderingInfo)o;
        return ObjectUtilities.equal(this.dataArea, plotRenderingInfo.dataArea) && ObjectUtilities.equal(this.plotArea, plotRenderingInfo.plotArea) && ObjectUtilities.equal(this.subplotInfo, plotRenderingInfo.subplotInfo);
    }
    
    public Object clone() {
        final PlotRenderingInfo plotRenderingInfo = (PlotRenderingInfo)super.clone();
        if (this.plotArea != null) {
            plotRenderingInfo.plotArea = (Rectangle2D)this.plotArea.clone();
        }
        if (this.dataArea != null) {
            plotRenderingInfo.dataArea = (Rectangle2D)this.dataArea.clone();
        }
        plotRenderingInfo.subplotInfo = new ArrayList(this.subplotInfo.size());
        for (int i = 0; i < this.subplotInfo.size(); ++i) {
            plotRenderingInfo.subplotInfo.add(((PlotRenderingInfo)this.subplotInfo.get(i)).clone());
        }
        return plotRenderingInfo;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.dataArea, objectOutputStream);
        SerialUtilities.writeShape(this.plotArea, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.dataArea = (Rectangle2D)SerialUtilities.readShape(objectInputStream);
        this.plotArea = (Rectangle2D)SerialUtilities.readShape(objectInputStream);
    }
}
