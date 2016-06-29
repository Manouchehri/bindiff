/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.wrappers;

import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.Collection;

public class SelectableGraph
implements ISelectableGraph {
    private final AbstractZyGraph m_graph;

    private SelectableGraph(AbstractZyGraph abstractZyGraph) {
        this.m_graph = abstractZyGraph;
    }

    public static SelectableGraph wrap(AbstractZyGraph abstractZyGraph) {
        return new SelectableGraph(abstractZyGraph);
    }

    @Override
    public void iterateSelected(INodeCallback iNodeCallback) {
        IteratorFunctions.iterateSelected(this.m_graph, iNodeCallback);
    }

    @Override
    public void selectNodes(Collection collection, boolean bl2) {
        this.m_graph.selectNodes(collection, bl2);
    }

    @Override
    public void selectNodes(Collection collection, Collection collection2) {
        this.m_graph.selectNodes(collection, collection2);
    }
}

