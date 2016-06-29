/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.GraphType;
import com.google.security.zynamics.zylib.disassembly.IViewListener;
import com.google.security.zynamics.zylib.disassembly.ViewType;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;

public interface IView {
    public void addListener(IViewListener var1);

    public boolean close();

    public int getEdgeCount();

    public IDirectedGraph getGraph();

    public GraphType getGraphType();

    public String getName();

    public int getNodeCount();

    public ViewType getType();

    public boolean isLoaded();

    public void removeListener(IViewListener var1);
}

