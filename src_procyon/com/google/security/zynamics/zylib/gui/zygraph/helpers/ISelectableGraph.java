package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.util.*;

public interface ISelectableGraph
{
    void iterateSelected(final INodeCallback p0);
    
    void selectNodes(final Collection p0, final boolean p1);
    
    void selectNodes(final Collection p0, final Collection p1);
}
