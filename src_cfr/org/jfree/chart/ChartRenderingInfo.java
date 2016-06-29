/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class ChartRenderingInfo
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 2751952018173406822L;
    private transient Rectangle2D chartArea = new Rectangle2D.Double();
    private PlotRenderingInfo plotInfo;
    private EntityCollection entities;

    public ChartRenderingInfo() {
        this(new StandardEntityCollection());
    }

    public ChartRenderingInfo(EntityCollection entityCollection) {
        this.plotInfo = new PlotRenderingInfo(this);
        this.entities = entityCollection;
    }

    public Rectangle2D getChartArea() {
        return this.chartArea;
    }

    public void setChartArea(Rectangle2D rectangle2D) {
        this.chartArea.setRect(rectangle2D);
    }

    public EntityCollection getEntityCollection() {
        return this.entities;
    }

    public void setEntityCollection(EntityCollection entityCollection) {
        this.entities = entityCollection;
    }

    public void clear() {
        this.chartArea.setRect(0.0, 0.0, 0.0, 0.0);
        this.plotInfo = new PlotRenderingInfo(this);
        if (this.entities == null) return;
        this.entities.clear();
    }

    public PlotRenderingInfo getPlotInfo() {
        return this.plotInfo;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ChartRenderingInfo)) {
            return false;
        }
        ChartRenderingInfo chartRenderingInfo = (ChartRenderingInfo)object;
        if (!ObjectUtilities.equal(this.chartArea, chartRenderingInfo.chartArea)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.plotInfo, chartRenderingInfo.plotInfo)) {
            return false;
        }
        if (ObjectUtilities.equal(this.entities, chartRenderingInfo.entities)) return true;
        return false;
    }

    public Object clone() {
        ChartRenderingInfo chartRenderingInfo = (ChartRenderingInfo)super.clone();
        if (this.chartArea != null) {
            chartRenderingInfo.chartArea = (Rectangle2D)this.chartArea.clone();
        }
        if (!(this.entities instanceof PublicCloneable)) return chartRenderingInfo;
        PublicCloneable publicCloneable = (PublicCloneable)((Object)this.entities);
        chartRenderingInfo.entities = (EntityCollection)publicCloneable.clone();
        return chartRenderingInfo;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.chartArea, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.chartArea = (Rectangle2D)SerialUtilities.readShape(objectInputStream);
    }
}

