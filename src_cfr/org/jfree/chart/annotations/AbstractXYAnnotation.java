/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.annotations;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYAnnotationEntity;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.util.ObjectUtilities;

public abstract class AbstractXYAnnotation
implements XYAnnotation {
    private String toolTipText = null;
    private String url = null;

    protected AbstractXYAnnotation() {
    }

    public String getToolTipText() {
        return this.toolTipText;
    }

    public void setToolTipText(String string) {
        this.toolTipText = string;
    }

    public String getURL() {
        return this.url;
    }

    public void setURL(String string) {
        this.url = string;
    }

    @Override
    public abstract void draw(Graphics2D var1, XYPlot var2, Rectangle2D var3, ValueAxis var4, ValueAxis var5, int var6, PlotRenderingInfo var7);

    protected void addEntity(PlotRenderingInfo plotRenderingInfo, Shape shape, int n2, String string, String string2) {
        if (plotRenderingInfo == null) {
            return;
        }
        EntityCollection entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        if (entityCollection == null) {
            return;
        }
        XYAnnotationEntity xYAnnotationEntity = new XYAnnotationEntity(shape, n2, string, string2);
        entityCollection.add(xYAnnotationEntity);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AbstractXYAnnotation)) {
            return false;
        }
        AbstractXYAnnotation abstractXYAnnotation = (AbstractXYAnnotation)object;
        if (!ObjectUtilities.equal(this.toolTipText, abstractXYAnnotation.toolTipText)) {
            return false;
        }
        if (ObjectUtilities.equal(this.url, abstractXYAnnotation.url)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 193;
        if (this.toolTipText != null) {
            n2 = 37 * n2 + this.toolTipText.hashCode();
        }
        if (this.url == null) return n2;
        return 37 * n2 + this.url.hashCode();
    }
}

