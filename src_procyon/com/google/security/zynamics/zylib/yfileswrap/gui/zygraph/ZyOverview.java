package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import y.h.*;

public class ZyOverview extends fD implements IFineGrainedSloppyGraph2DView
{
    private int _minEdgesForSloppyEdgeHiding;
    
    public ZyOverview(final ch ch) {
        super(ch);
        this.setPaintDetailThreshold(0.0);
        this.setMinEdgesForSloppyEdgeHiding(1000);
    }
    
    @Override
    public boolean drawEdges() {
        return this.getGraph2D().g() < this._minEdgesForSloppyEdgeHiding;
    }
    
    @Override
    public boolean isEdgeSloppyPaintMode() {
        return true;
    }
    
    @Override
    public boolean isNodeSloppyPaintMode() {
        return true;
    }
    
    @Override
    public void setEdgeSloppyThreshold(final double n) {
    }
    
    @Override
    public void setMinEdgesForSloppyEdgeHiding(final int minEdgesForSloppyEdgeHiding) {
        this._minEdgesForSloppyEdgeHiding = minEdgesForSloppyEdgeHiding;
    }
    
    @Override
    public void setNodeSloppyThreshold(final double n) {
    }
    
    @Override
    public void setSloppyEdgeHidingThreshold(final double n) {
    }
}
