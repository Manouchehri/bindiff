/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.filter;

import com.google.security.zynamics.bindiff.graph.filter.GraphEdgeFilter$1;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.ArrayList;
import java.util.Collection;

public class GraphEdgeFilter {
    public static Collection filterInvisibleEdges(AbstractZyGraph abstractZyGraph) {
        ArrayList arrayList = new ArrayList();
        abstractZyGraph.iterateEdges(new GraphEdgeFilter$1(arrayList));
        return arrayList;
    }
}

