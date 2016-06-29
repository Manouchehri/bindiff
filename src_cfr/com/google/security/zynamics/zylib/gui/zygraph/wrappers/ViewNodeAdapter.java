/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.wrappers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.types.lists.FilledList;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ViewNodeAdapter
implements IGraphNode {
    private final IViewNode m_viewNode;

    public ViewNodeAdapter(IViewNode iViewNode) {
        Preconditions.checkNotNull(iViewNode, "Error: View node argument can not be null");
        this.m_viewNode = iViewNode;
    }

    private static Collection convert(AbstractZyGraph abstractZyGraph, Collection collection) {
        ArrayList<ZyGraphNode> arrayList = new ArrayList<ZyGraphNode>();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            IViewNode iViewNode = (IViewNode)iterator.next();
            arrayList.add(abstractZyGraph.getNode(iViewNode));
        }
        return arrayList;
    }

    public static Collection unwrap(AbstractZyGraph abstractZyGraph, Collection collection) {
        FilledList filledList = new FilledList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            ViewNodeAdapter viewNodeAdapter = (ViewNodeAdapter)iterator.next();
            filledList.add(viewNodeAdapter.getNode());
        }
        return ViewNodeAdapter.convert(abstractZyGraph, filledList);
    }

    public static List wrap(List list) {
        ArrayList<ViewNodeAdapter> arrayList = new ArrayList<ViewNodeAdapter>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IViewNode iViewNode = (IViewNode)iterator.next();
            arrayList.add(new ViewNodeAdapter(iViewNode));
        }
        return arrayList;
    }

    public boolean equals(Object object) {
        if (!(object instanceof ViewNodeAdapter)) return false;
        if (((ViewNodeAdapter)object).getNode() != this.getNode()) return false;
        return true;
    }

    @Override
    public List getChildren() {
        List list = this.m_viewNode.getOutgoingEdges();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IViewEdge iViewEdge = (IViewEdge)iterator.next();
            arrayList.add(iViewEdge.getTarget());
        }
        return ViewNodeAdapter.wrap(arrayList);
    }

    public IViewNode getNode() {
        return this.m_viewNode;
    }

    @Override
    public List getParents() {
        List list = this.m_viewNode.getIncomingEdges();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IViewEdge iViewEdge = (IViewEdge)iterator.next();
            arrayList.add(iViewEdge.getSource());
        }
        return ViewNodeAdapter.wrap(arrayList);
    }

    public int hashCode() {
        return this.m_viewNode.hashCode();
    }
}

