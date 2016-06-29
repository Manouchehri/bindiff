package com.google.security.zynamics.zylib.gui.zygraph;

public interface IFineGrainedSloppyGraph2DView
{
    boolean drawEdges();
    
    boolean isEdgeSloppyPaintMode();
    
    boolean isNodeSloppyPaintMode();
    
    void setEdgeSloppyThreshold(final double p0);
    
    void setMinEdgesForSloppyEdgeHiding(final int p0);
    
    void setNodeSloppyThreshold(final double p0);
    
    void setSloppyEdgeHidingThreshold(final double p0);
}
