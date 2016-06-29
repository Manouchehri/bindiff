package com.google.security.zynamics.zylib.gui.zygraph.wrappers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.functions.*;
import java.util.*;

public class SelectableGraph implements ISelectableGraph
{
    private final AbstractZyGraph m_graph;
    
    private SelectableGraph(final AbstractZyGraph graph) {
        this.m_graph = graph;
    }
    
    public static SelectableGraph wrap(final AbstractZyGraph abstractZyGraph) {
        return new SelectableGraph(abstractZyGraph);
    }
    
    @Override
    public void iterateSelected(final INodeCallback nodeCallback) {
        IteratorFunctions.iterateSelected(this.m_graph, nodeCallback);
    }
    
    @Override
    public void selectNodes(final Collection collection, final boolean b) {
        this.m_graph.selectNodes(collection, b);
    }
    
    @Override
    public void selectNodes(final Collection collection, final Collection collection2) {
        this.m_graph.selectNodes(collection, collection2);
    }
}
