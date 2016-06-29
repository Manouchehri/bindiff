package com.google.security.zynamics.zylib.gui.zygraph.helpers;

public interface IViewableGraph
{
    void iterateInvisible(final INodeCallback p0);
    
    void iterateVisible(final INodeCallback p0);
}
