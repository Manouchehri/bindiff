package com.google.security.zynamics.zylib.gui.zygraph.wrappers;

import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.lists.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;

public class ViewNodeAdapter implements IGraphNode
{
    private final IViewNode m_viewNode;
    
    public ViewNodeAdapter(final IViewNode viewNode) {
        Preconditions.checkNotNull(viewNode, (Object)"Error: View node argument can not be null");
        this.m_viewNode = viewNode;
    }
    
    private static Collection convert(final AbstractZyGraph abstractZyGraph, final Collection collection) {
        final ArrayList<ZyGraphNode> list = new ArrayList<ZyGraphNode>();
        final Iterator<IViewNode> iterator = collection.iterator();
        while (iterator.hasNext()) {
            list.add(abstractZyGraph.getNode(iterator.next()));
        }
        return list;
    }
    
    public static Collection unwrap(final AbstractZyGraph abstractZyGraph, final Collection collection) {
        final FilledList list = new FilledList();
        final Iterator<ViewNodeAdapter> iterator = collection.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().getNode());
        }
        return convert(abstractZyGraph, list);
    }
    
    public static List wrap(final List list) {
        final ArrayList<ViewNodeAdapter> list2 = new ArrayList<ViewNodeAdapter>();
        final Iterator<IViewNode> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(new ViewNodeAdapter(iterator.next()));
        }
        return list2;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof ViewNodeAdapter && ((ViewNodeAdapter)o).getNode() == this.getNode();
    }
    
    @Override
    public List getChildren() {
        final List outgoingEdges = this.m_viewNode.getOutgoingEdges();
        final ArrayList<Object> list = new ArrayList<Object>();
        final Iterator<IViewEdge> iterator = outgoingEdges.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().getTarget());
        }
        return wrap(list);
    }
    
    public IViewNode getNode() {
        return this.m_viewNode;
    }
    
    @Override
    public List getParents() {
        final List incomingEdges = this.m_viewNode.getIncomingEdges();
        final ArrayList<Object> list = new ArrayList<Object>();
        final Iterator<IViewEdge> iterator = incomingEdges.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().getSource());
        }
        return wrap(list);
    }
    
    @Override
    public int hashCode() {
        return this.m_viewNode.hashCode();
    }
}
