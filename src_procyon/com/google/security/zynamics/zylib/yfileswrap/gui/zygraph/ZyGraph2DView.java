package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import y.h.*;
import java.awt.*;

public class ZyGraph2DView extends ch implements IFineGrainedSloppyGraph2DView
{
    private static final long serialVersionUID = 9194672642118308276L;
    private double m_nodeSloppyThreshold;
    private double m_edgeSloppyThreshold;
    private int m_minEdgesForSloppyEdgeHiding;
    private double m_sloppyEdgeHidingThreshold;
    
    public ZyGraph2DView() {
        this.initDefaults();
    }
    
    public ZyGraph2DView(final bu bu) {
        super(bu);
        this.initDefaults();
    }
    
    private void initDefaults() {
        this.m_nodeSloppyThreshold = this.getPaintDetailThreshold();
        this.m_edgeSloppyThreshold = 0.2;
        this.m_minEdgesForSloppyEdgeHiding = 3000;
        this.m_sloppyEdgeHidingThreshold = 0.1;
        this.setPaintDetailThreshold(0.0);
    }
    
    @Override
    public boolean drawEdges() {
        return this.m_minEdgesForSloppyEdgeHiding >= this.getGraph2D().g() || this.m_sloppyEdgeHidingThreshold <= this.getZoom();
    }
    
    @Override
    public boolean isEdgeSloppyPaintMode() {
        return this.getZoom() < this.m_edgeSloppyThreshold;
    }
    
    @Override
    public boolean isNodeSloppyPaintMode() {
        return this.getZoom() < this.m_nodeSloppyThreshold;
    }
    
    public void setCrossCursor(final boolean b) {
        if (b) {
            super.setViewCursor(Cursor.getPredefinedCursor(13));
        }
        else {
            super.setViewCursor(Cursor.getDefaultCursor());
        }
    }
    
    @Override
    public void setEdgeSloppyThreshold(final double edgeSloppyThreshold) {
        this.m_edgeSloppyThreshold = edgeSloppyThreshold;
    }
    
    @Override
    public void setMinEdgesForSloppyEdgeHiding(final int minEdgesForSloppyEdgeHiding) {
        this.m_minEdgesForSloppyEdgeHiding = minEdgesForSloppyEdgeHiding;
    }
    
    @Override
    public void setNodeSloppyThreshold(final double nodeSloppyThreshold) {
        this.m_nodeSloppyThreshold = nodeSloppyThreshold;
    }
    
    @Override
    public void setSloppyEdgeHidingThreshold(final double sloppyEdgeHidingThreshold) {
        this.m_sloppyEdgeHidingThreshold = sloppyEdgeHidingThreshold;
    }
    
    @Override
    public void setViewCursor(final Cursor cursor) {
    }
}
