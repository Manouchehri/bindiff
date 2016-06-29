package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;

public interface IZyNodeRealizerListener
{
    void changedLocation(final IZyNodeRealizer p0, final double p1, final double p2);
    
    void changedSelection(final IZyNodeRealizer p0);
    
    void changedSize(final IZyNodeRealizer p0, final double p1, final double p2);
    
    void changedVisibility(final IZyNodeRealizer p0);
    
    void regenerated(final IZyNodeRealizer p0);
}
