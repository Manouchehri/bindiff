package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.*;
import com.google.security.zynamics.zylib.gui.zygraph.settings.*;

public abstract class AbstractZyGraphSettings
{
    public abstract IDisplaySettings getDisplaySettings();
    
    public abstract ILayoutSettings getLayoutSettings();
    
    public abstract IMouseSettings getMouseSettings();
    
    public abstract IProximitySettings getProximitySettings();
}
