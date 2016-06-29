package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings;

import y.f.*;

public interface ILayoutSettings
{
    boolean getAnimateLayout();
    
    int getAnimateLayoutEdgeThreshold();
    
    int getAnimateLayoutNodeThreshold();
    
    boolean getAutomaticLayouting();
    
    c getCurrentLayouter();
}
