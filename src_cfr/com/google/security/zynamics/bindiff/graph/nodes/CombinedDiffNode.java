/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import y.c.q;

public class CombinedDiffNode
extends ZyGraphNode
implements IGraphNode {
    private final SuperDiffNode superDiffNode;
    private final SingleDiffNode primaryDiffNode;
    private final SingleDiffNode secondaryDiffNode;
    private final List parents = new ArrayList();
    private final List children = new ArrayList();

    public CombinedDiffNode(q q2, IZyNodeRealizer iZyNodeRealizer, CombinedViewNode combinedViewNode, SuperDiffNode superDiffNode) {
        super(q2, iZyNodeRealizer, combinedViewNode);
        Preconditions.checkNotNull(superDiffNode);
        this.superDiffNode = superDiffNode;
        this.primaryDiffNode = superDiffNode.getPrimaryDiffNode();
        this.secondaryDiffNode = superDiffNode.getSecondaryDiffNode();
    }

    public static void link(CombinedDiffNode combinedDiffNode, CombinedDiffNode combinedDiffNode2) {
        combinedDiffNode.children.add(combinedDiffNode2);
        combinedDiffNode2.parents.add(combinedDiffNode);
    }

    public static void unlink(CombinedDiffNode combinedDiffNode, CombinedDiffNode combinedDiffNode2) {
        combinedDiffNode.children.remove(combinedDiffNode2);
        combinedDiffNode2.parents.remove(combinedDiffNode);
    }

    @Override
    public List getChildren() {
        return new ArrayList(this.children);
    }

    @Override
    public List getParents() {
        return new ArrayList(this.parents);
    }

    @Override
    public CombinedViewNode getRawNode() {
        return (CombinedViewNode)super.getRawNode();
    }

    public SingleDiffNode getPrimaryDiffNode() {
        return this.primaryDiffNode;
    }

    public SingleViewNode getPrimaryRawNode() {
        if (this.primaryDiffNode == null) return null;
        SingleViewNode singleViewNode = this.primaryDiffNode.getRawNode();
        return singleViewNode;
    }

    public SingleDiffNode getSecondaryDiffNode() {
        return this.secondaryDiffNode;
    }

    public SingleViewNode getSecondaryRawNode() {
        if (this.secondaryDiffNode == null) return null;
        SingleViewNode singleViewNode = this.secondaryDiffNode.getRawNode();
        return singleViewNode;
    }

    public SuperDiffNode getSuperDiffNode() {
        return this.superDiffNode;
    }

    public SuperViewNode getSuperRawNode() {
        return this.superDiffNode.getRawNode();
    }
}

