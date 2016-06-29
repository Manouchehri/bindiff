/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;

public class PlotRenderingInfo
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 8446720134379617220L;
    private ChartRenderingInfo owner;
    private transient Rectangle2D plotArea;
    private transient Rectangle2D dataArea;
    private List subplotInfo;

    public PlotRenderingInfo(ChartRenderingInfo chartRenderingInfo) {
        this.owner = chartRenderingInfo;
        this.dataArea = new Rectangle2D.Double();
        this.subplotInfo = new ArrayList();
    }

    public ChartRenderingInfo getOwner() {
        return this.owner;
    }

    public Rectangle2D getPlotArea() {
        return this.plotArea;
    }

    public void setPlotArea(Rectangle2D rectangle2D) {
        this.plotArea = rectangle2D;
    }

    public Rectangle2D getDataArea() {
        return this.dataArea;
    }

    public void setDataArea(Rectangle2D rectangle2D) {
        this.dataArea = rectangle2D;
    }

    public int getSubplotCount() {
        return this.subplotInfo.size();
    }

    public void addSubplotInfo(PlotRenderingInfo plotRenderingInfo) {
        this.subplotInfo.add(plotRenderingInfo);
    }

    public PlotRenderingInfo getSubplotInfo(int n2) {
        return (PlotRenderingInfo)this.subplotInfo.get(n2);
    }

    public int getSubplotIndex(Point2D point2D) {
        int n2 = this.getSubplotCount();
        int n3 = 0;
        while (n3 < n2) {
            PlotRenderingInfo plotRenderingInfo = this.getSubplotInfo(n3);
            Rectangle2D rectangle2D = plotRenderingInfo.getDataArea();
            if (rectangle2D.contains(point2D)) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlotRenderingInfo)) {
            return false;
        }
        PlotRenderingInfo plotRenderingInfo = (PlotRenderingInfo)object;
        if (!ObjectUtilities.equal(this.dataArea, plotRenderingInfo.dataArea)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.plotArea, plotRenderingInfo.plotArea)) {
            return false;
        }
        if (ObjectUtilities.equal(this.subplotInfo, plotRenderingInfo.subplotInfo)) return true;
        return false;
    }

    public Object clone() {
        PlotRenderingInfo plotRenderingInfo = (PlotRenderingInfo)super.clone();
        if (this.plotArea != null) {
            plotRenderingInfo.plotArea = (Rectangle2D)this.plotArea.clone();
        }
        if (this.dataArea != null) {
            plotRenderingInfo.dataArea = (Rectangle2D)this.dataArea.clone();
        }
        plotRenderingInfo.subplotInfo = new ArrayList(this.subplotInfo.size());
        int n2 = 0;
        while (n2 < this.subplotInfo.size()) {
            PlotRenderingInfo plotRenderingInfo2 = (PlotRenderingInfo)this.subplotInfo.get(n2);
            plotRenderingInfo.subplotInfo.add(plotRenderingInfo2.clone());
            ++n2;
        }
        return plotRenderingInfo;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.dataArea, objectOutputStream);
        SerialUtilities.writeShape(this.plotArea, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.dataArea = (Rectangle2D)SerialUtilities.readShape(objectInputStream);
        this.plotArea = (Rectangle2D)SerialUtilities.readShape(objectInputStream);
    }
}

