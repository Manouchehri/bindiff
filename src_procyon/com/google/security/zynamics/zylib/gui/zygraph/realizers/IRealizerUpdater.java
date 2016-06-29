package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;

public interface IRealizerUpdater
{
    void dispose();
    
    void generateContent(final IZyNodeRealizer p0, final ZyLabelContent p1);
    
    void setRealizer(final IZyNodeRealizer p0);
}
