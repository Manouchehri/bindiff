/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.MultiEdgeHider$1;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.MultiEdgeHider$2;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MultiEdgeHider {
    public static void hideMultipleEdgesInternal(AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.iterate(new MultiEdgeHider$1());
    }

    public static void hideMultipleEdgesInternal(ZyGraphNode zyGraphNode) {
        Object object;
        Object object22;
        if (!zyGraphNode.isVisible()) return;
        if (zyGraphNode.getRawNode() instanceof IGroupNode) {
            return;
        }
        HashSet<Object> hashSet = new HashSet<Object>();
        for (Object object22 : zyGraphNode.getRawNode().getOutgoingEdges()) {
            object = object22.getTarget();
            if (hashSet.contains(object)) {
                object22.setVisible(false);
                continue;
            }
            hashSet.add(object);
        }
        HashSet hashSet2 = new HashSet();
        object22 = zyGraphNode.getRawNode().getIncomingEdges().iterator();
        while (object22.hasNext()) {
            object = (IViewEdge)object22.next();
            if (hashSet2.contains(object.getSource())) {
                object.setVisible(false);
                continue;
            }
            hashSet2.add(object.getSource());
        }
    }

    public static void unhideMultipleEdgesInternal(AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.iterateEdges(new MultiEdgeHider$2());
    }
}

