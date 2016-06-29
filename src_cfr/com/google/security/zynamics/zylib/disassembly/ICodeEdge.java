/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;

public interface ICodeEdge {
    public Object getSource();

    public Object getTarget();

    public EdgeType getType();
}

