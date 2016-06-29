package org.jfree.chart;

import java.awt.geom.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.entity.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.awt.*;
import java.io.*;

public class ChartRenderingInfo implements Serializable, Cloneable
{
    private static final long serialVersionUID = 2751952018173406822L;
    private transient Rectangle2D chartArea;
    private PlotRenderingInfo plotInfo;
    private EntityCollection entities;
    
    public ChartRenderingInfo() {
        this(new StandardEntityCollection());
    }
    
    public ChartRenderingInfo(final EntityCollection entities) {
        this.chartArea = new Rectangle2D.Double();
        this.plotInfo = new PlotRenderingInfo(this);
        this.entities = entities;
    }
    
    public Rectangle2D getChartArea() {
        return this.chartArea;
    }
    
    public void setChartArea(final Rectangle2D rect) {
        this.chartArea.setRect(rect);
    }
    
    public EntityCollection getEntityCollection() {
        return this.entities;
    }
    
    public void setEntityCollection(final EntityCollection entities) {
        this.entities = entities;
    }
    
    public void clear() {
        this.chartArea.setRect(0.0, 0.0, 0.0, 0.0);
        this.plotInfo = new PlotRenderingInfo(this);
        if (this.entities != null) {
            this.entities.clear();
        }
    }
    
    public PlotRenderingInfo getPlotInfo() {
        return this.plotInfo;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ChartRenderingInfo)) {
            return false;
        }
        final ChartRenderingInfo chartRenderingInfo = (ChartRenderingInfo)o;
        return ObjectUtilities.equal(this.chartArea, chartRenderingInfo.chartArea) && ObjectUtilities.equal(this.plotInfo, chartRenderingInfo.plotInfo) && ObjectUtilities.equal(this.entities, chartRenderingInfo.entities);
    }
    
    public Object clone() {
        final ChartRenderingInfo chartRenderingInfo = (ChartRenderingInfo)super.clone();
        if (this.chartArea != null) {
            chartRenderingInfo.chartArea = (Rectangle2D)this.chartArea.clone();
        }
        if (this.entities instanceof PublicCloneable) {
            chartRenderingInfo.entities = (EntityCollection)((PublicCloneable)this.entities).clone();
        }
        return chartRenderingInfo;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.chartArea, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.chartArea = (Rectangle2D)SerialUtilities.readShape(objectInputStream);
    }
}
