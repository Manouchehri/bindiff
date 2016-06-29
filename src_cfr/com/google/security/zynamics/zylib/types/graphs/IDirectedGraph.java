/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.graphs;

import java.util.List;

public interface IDirectedGraph
extends Iterable {
    public int edgeCount();

    public List getEdges();

    public List getNodes();

    public int nodeCount();
}

