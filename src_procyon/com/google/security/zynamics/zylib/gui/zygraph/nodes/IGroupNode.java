package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import java.util.*;

public interface IGroupNode extends IViewNode
{
    void addElement(final IViewNode p0);
    
    List getElements();
    
    boolean isCollapsed();
    
    void setCollapsed(final boolean p0);
}
