/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.edges;

import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdgeListener;
import java.awt.Color;

public abstract class ViewEdgeListenerAdapter
implements IViewEdgeListener {
    @Override
    public void addedBend(IViewEdge iViewEdge, CBend cBend) {
    }

    @Override
    public void changedColor(CViewEdge cViewEdge, Color color) {
    }

    @Override
    public void changedSelection(IViewEdge iViewEdge, boolean bl2) {
    }

    @Override
    public void changedSourceX(CViewEdge cViewEdge, double d2) {
    }

    @Override
    public void changedSourceY(CViewEdge cViewEdge, double d2) {
    }

    @Override
    public void changedTargetX(CViewEdge cViewEdge, double d2) {
    }

    @Override
    public void changedTargetY(CViewEdge cViewEdge, double d2) {
    }

    @Override
    public void changedType(CViewEdge cViewEdge, EdgeType edgeType) {
    }

    @Override
    public void changedVisibility(IViewEdge iViewEdge, boolean bl2) {
    }

    @Override
    public void clearedBends(IViewEdge iViewEdge) {
    }

    @Override
    public void insertedBend(IViewEdge iViewEdge, int n2, CBend cBend) {
    }

    @Override
    public void removedBend(CViewEdge cViewEdge, int n2, CBend cBend) {
    }
}

