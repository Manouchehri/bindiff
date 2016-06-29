/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GraphConverters {
    public static Collection convert(AbstractZyGraph abstractZyGraph, Collection collection) {
        ArrayList<ZyGraphNode> arrayList = new ArrayList<ZyGraphNode>();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            IViewNode iViewNode = (IViewNode)iterator.next();
            arrayList.add(abstractZyGraph.getNode(iViewNode));
        }
        return arrayList;
    }

    public static List convert(Collection collection) {
        ArrayList<IViewNode> arrayList = new ArrayList<IViewNode>();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            IViewNode iViewNode = zyGraphNode.getRawNode();
            arrayList.add(iViewNode);
        }
        return arrayList;
    }
}

