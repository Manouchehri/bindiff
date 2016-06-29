/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.SwingInvoker;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import y.f.O;
import y.h.ch;
import y.h.dj;

final class LayoutFunctions$1
extends SwingInvoker {
    final /* synthetic */ dj val$layoutMorpher;
    final /* synthetic */ AbstractZyGraph val$graph;
    final /* synthetic */ O val$morpherLayout;

    LayoutFunctions$1(dj dj2, AbstractZyGraph abstractZyGraph, O o2) {
        this.val$layoutMorpher = dj2;
        this.val$graph = abstractZyGraph;
        this.val$morpherLayout = o2;
    }

    @Override
    protected void operation() {
        this.val$layoutMorpher.execute(this.val$graph.getView(), this.val$morpherLayout);
    }
}

