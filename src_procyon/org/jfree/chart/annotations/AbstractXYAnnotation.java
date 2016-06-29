package org.jfree.chart.annotations;

import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.util.*;

public abstract class AbstractXYAnnotation implements XYAnnotation
{
    private String toolTipText;
    private String url;
    
    protected AbstractXYAnnotation() {
        this.toolTipText = null;
        this.url = null;
    }
    
    public String getToolTipText() {
        return this.toolTipText;
    }
    
    public void setToolTipText(final String toolTipText) {
        this.toolTipText = toolTipText;
    }
    
    public String getURL() {
        return this.url;
    }
    
    public void setURL(final String url) {
        this.url = url;
    }
    
    public abstract void draw(final Graphics2D p0, final XYPlot p1, final Rectangle2D p2, final ValueAxis p3, final ValueAxis p4, final int p5, final PlotRenderingInfo p6);
    
    protected void addEntity(final PlotRenderingInfo plotRenderingInfo, final Shape shape, final int n, final String s, final String s2) {
        if (plotRenderingInfo == null) {
            return;
        }
        final EntityCollection entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        if (entityCollection == null) {
            return;
        }
        entityCollection.add(new XYAnnotationEntity(shape, n, s, s2));
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AbstractXYAnnotation)) {
            return false;
        }
        final AbstractXYAnnotation abstractXYAnnotation = (AbstractXYAnnotation)o;
        return ObjectUtilities.equal(this.toolTipText, abstractXYAnnotation.toolTipText) && ObjectUtilities.equal(this.url, abstractXYAnnotation.url);
    }
    
    public int hashCode() {
        int n = 193;
        if (this.toolTipText != null) {
            n = 37 * n + this.toolTipText.hashCode();
        }
        if (this.url != null) {
            n = 37 * n + this.url.hashCode();
        }
        return n;
    }
}
