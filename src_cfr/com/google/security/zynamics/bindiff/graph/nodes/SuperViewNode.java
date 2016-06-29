/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SuperViewNode
extends CViewNode
implements IGraphNode {
    private final List children = new ArrayList();
    private final List parents = new ArrayList();
    private final CombinedViewNode combinedNode;

    public SuperViewNode(CombinedViewNode combinedViewNode) {
        super(-1, 0.0, 0.0, 0.0, 0.0, Color.WHITE, Color.BLACK, false, true);
        Preconditions.checkNotNull(combinedViewNode);
        this.combinedNode = combinedViewNode;
    }

    public static void link(SuperViewNode superViewNode, SuperViewNode superViewNode2) {
        superViewNode.getChildren().add(superViewNode2);
        superViewNode2.getParents().add(superViewNode);
    }

    public static void unlink(SuperViewNode superViewNode, SuperViewNode superViewNode2) {
        superViewNode.getChildren().remove(superViewNode2);
        superViewNode2.getParents().remove(superViewNode);
    }

    @Override
    public List getChildren() {
        return this.children;
    }

    public CombinedViewNode getCombinedNode() {
        return this.combinedNode;
    }

    @Override
    public IGroupNode getParentGroup() {
        return null;
    }

    @Override
    public List getParents() {
        return this.parents;
    }

    public void removeNode() {
        for (SuperViewEdge superViewEdge2 : this.getIncomingEdges()) {
            SuperViewNode.unlink((SuperViewNode)superViewEdge2.getSource(), (SuperViewNode)superViewEdge2.getTarget());
            ((SuperViewNode)superViewEdge2.getSource()).removeOutgoingEdge(superViewEdge2);
            ((SuperViewNode)superViewEdge2.getTarget()).removeIncomingEdge(superViewEdge2);
        }
        Iterator iterator = this.getOutgoingEdges().iterator();
        while (iterator.hasNext()) {
            SuperViewEdge superViewEdge2;
            superViewEdge2 = (SuperViewEdge)iterator.next();
            SuperViewNode.unlink((SuperViewNode)superViewEdge2.getSource(), (SuperViewNode)superViewEdge2.getTarget());
            ((SuperViewNode)superViewEdge2.getSource()).removeOutgoingEdge(superViewEdge2);
            ((SuperViewNode)superViewEdge2.getTarget()).removeIncomingEdge(superViewEdge2);
        }
    }
}

