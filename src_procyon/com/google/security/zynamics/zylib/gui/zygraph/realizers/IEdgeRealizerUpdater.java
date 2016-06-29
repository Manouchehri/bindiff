package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;

public interface IEdgeRealizerUpdater
{
    ZyLabelContent generateContent(final ZyEdgeRealizer p0);
    
    void setRealizer(final ZyEdgeRealizer p0);
}
