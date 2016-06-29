/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions$1;
import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions$2;
import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions$3;
import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions$4;
import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions$5;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;

public class IteratorFunctions {
    public static void iterateInvisible(AbstractZyGraph abstractZyGraph, IEdgeCallback iEdgeCallback) {
        Preconditions.checkNotNull(iEdgeCallback, "Error: Callback argument can't be null");
        abstractZyGraph.iterateEdges(new IteratorFunctions$1(iEdgeCallback));
    }

    public static void iterateInvisible(AbstractZyGraph abstractZyGraph, INodeCallback iNodeCallback) {
        Preconditions.checkNotNull(iNodeCallback, "Error: Callback argument can't be null");
        abstractZyGraph.iterate(new IteratorFunctions$2(iNodeCallback));
    }

    public static void iterateSelected(AbstractZyGraph abstractZyGraph, INodeCallback iNodeCallback) {
        Preconditions.checkNotNull(iNodeCallback, "Error: Callback argument can't be null");
        abstractZyGraph.iterate(new IteratorFunctions$3(iNodeCallback));
    }

    public static void iterateVisible(AbstractZyGraph abstractZyGraph, IEdgeCallback iEdgeCallback) {
        Preconditions.checkNotNull(iEdgeCallback, "Error: Callback argument can't be null");
        abstractZyGraph.iterateEdges(new IteratorFunctions$4(iEdgeCallback));
    }

    public static void iterateVisible(AbstractZyGraph abstractZyGraph, INodeCallback iNodeCallback) {
        Preconditions.checkNotNull(iNodeCallback, "Error: Callback argument can't be null");
        abstractZyGraph.iterate(new IteratorFunctions$5(iNodeCallback));
    }
}

