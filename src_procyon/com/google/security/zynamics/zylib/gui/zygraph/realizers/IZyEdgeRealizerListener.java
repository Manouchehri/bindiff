package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;

public interface IZyEdgeRealizerListener
{
    void addedBend(final double p0, final double p1);
    
    void bendChanged(final int p0, final double p1, final double p2);
    
    void changedLocation(final ZyEdgeRealizer p0);
    
    void changedVisibility(final ZyEdgeRealizer p0);
    
    void clearedBends();
    
    void insertedBend(final int p0, final double p1, final double p2);
    
    void regenerated(final ZyEdgeRealizer p0);
    
    void removedBend(final ZyEdgeRealizer p0, final int p1);
}
