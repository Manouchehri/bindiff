/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.wrappers;

import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IViewableGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;

public class ViewableGraph
implements IViewableGraph {
    private final AbstractZyGraph m_graph;

    private ViewableGraph(AbstractZyGraph abstractZyGraph) {
        this.m_graph = abstractZyGraph;
    }

    public static ViewableGraph wrap(AbstractZyGraph abstractZyGraph) {
        return new ViewableGraph(abstractZyGraph);
    }

    @Override
    public void iterateInvisible(INodeCallback iNodeCallback) {
        IteratorFunctions.iterateInvisible(this.m_graph, iNodeCallback);
    }

    @Override
    public void iterateVisible(INodeCallback iNodeCallback) {
        IteratorFunctions.iterateVisible(this.m_graph, iNodeCallback);
    }
}

