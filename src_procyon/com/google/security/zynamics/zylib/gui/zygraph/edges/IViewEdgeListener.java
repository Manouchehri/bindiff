package com.google.security.zynamics.zylib.gui.zygraph.edges;

import java.awt.*;

public interface IViewEdgeListener
{
    void addedBend(final IViewEdge p0, final CBend p1);
    
    void changedColor(final CViewEdge p0, final Color p1);
    
    void changedSelection(final IViewEdge p0, final boolean p1);
    
    void changedSourceX(final CViewEdge p0, final double p1);
    
    void changedSourceY(final CViewEdge p0, final double p1);
    
    void changedTargetX(final CViewEdge p0, final double p1);
    
    void changedTargetY(final CViewEdge p0, final double p1);
    
    void changedType(final CViewEdge p0, final EdgeType p1);
    
    void changedVisibility(final IViewEdge p0, final boolean p1);
    
    void clearedBends(final IViewEdge p0);
    
    void insertedBend(final IViewEdge p0, final int p1, final CBend p2);
    
    void removedBend(final CViewEdge p0, final int p1, final CBend p2);
}
