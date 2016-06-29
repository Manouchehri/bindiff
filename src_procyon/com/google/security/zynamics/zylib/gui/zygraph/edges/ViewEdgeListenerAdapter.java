package com.google.security.zynamics.zylib.gui.zygraph.edges;

import java.awt.*;

public abstract class ViewEdgeListenerAdapter implements IViewEdgeListener
{
    @Override
    public void addedBend(final IViewEdge viewEdge, final CBend cBend) {
    }
    
    @Override
    public void changedColor(final CViewEdge cViewEdge, final Color color) {
    }
    
    @Override
    public void changedSelection(final IViewEdge viewEdge, final boolean b) {
    }
    
    @Override
    public void changedSourceX(final CViewEdge cViewEdge, final double n) {
    }
    
    @Override
    public void changedSourceY(final CViewEdge cViewEdge, final double n) {
    }
    
    @Override
    public void changedTargetX(final CViewEdge cViewEdge, final double n) {
    }
    
    @Override
    public void changedTargetY(final CViewEdge cViewEdge, final double n) {
    }
    
    @Override
    public void changedType(final CViewEdge cViewEdge, final EdgeType edgeType) {
    }
    
    @Override
    public void changedVisibility(final IViewEdge viewEdge, final boolean b) {
    }
    
    @Override
    public void clearedBends(final IViewEdge viewEdge) {
    }
    
    @Override
    public void insertedBend(final IViewEdge viewEdge, final int n, final CBend cBend) {
    }
    
    @Override
    public void removedBend(final CViewEdge cViewEdge, final int n, final CBend cBend) {
    }
}
