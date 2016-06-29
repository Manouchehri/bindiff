package org.jfree.chart.renderer;

import org.jfree.chart.plot.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.*;

public class RendererState
{
    private PlotRenderingInfo info;
    
    public RendererState(final PlotRenderingInfo info) {
        this.info = info;
    }
    
    public PlotRenderingInfo getInfo() {
        return this.info;
    }
    
    public EntityCollection getEntityCollection() {
        EntityCollection entityCollection = null;
        if (this.info != null) {
            final ChartRenderingInfo owner = this.info.getOwner();
            if (owner != null) {
                entityCollection = owner.getEntityCollection();
            }
        }
        return entityCollection;
    }
}
