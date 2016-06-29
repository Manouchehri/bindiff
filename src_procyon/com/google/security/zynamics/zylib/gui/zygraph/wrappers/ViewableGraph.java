package com.google.security.zynamics.zylib.gui.zygraph.wrappers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.functions.*;

public class ViewableGraph implements IViewableGraph
{
    private final AbstractZyGraph m_graph;
    
    private ViewableGraph(final AbstractZyGraph graph) {
        this.m_graph = graph;
    }
    
    public static ViewableGraph wrap(final AbstractZyGraph abstractZyGraph) {
        return new ViewableGraph(abstractZyGraph);
    }
    
    @Override
    public void iterateInvisible(final INodeCallback nodeCallback) {
        IteratorFunctions.iterateInvisible(this.m_graph, nodeCallback);
    }
    
    @Override
    public void iterateVisible(final INodeCallback nodeCallback) {
        IteratorFunctions.iterateVisible(this.m_graph, nodeCallback);
    }
}
