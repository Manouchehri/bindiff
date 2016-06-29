/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import y.c.q;

public class SuperDiffNode
extends ZyGraphNode
implements IGraphNode {
    private final SingleDiffNode primaryDiffNode;
    private final SingleDiffNode secondaryDiffNode;
    private CombinedDiffNode combinedDiffNode;
    private final List parents = new ArrayList();
    private final List children = new ArrayList();

    public SuperDiffNode(q q2, IZyNodeRealizer iZyNodeRealizer, SuperViewNode superViewNode, SingleDiffNode singleDiffNode, SingleDiffNode singleDiffNode2) {
        super(q2, iZyNodeRealizer, superViewNode);
        Preconditions.checkArgument(singleDiffNode != null || singleDiffNode2 != null, "Primary diff node and secondary diff node cannot be both be null.");
        this.primaryDiffNode = singleDiffNode;
        this.secondaryDiffNode = singleDiffNode2;
    }

    public static void link(SuperDiffNode superDiffNode, SuperDiffNode superDiffNode2) {
        superDiffNode.children.add(superDiffNode2);
        superDiffNode2.parents.add(superDiffNode);
    }

    public static void unlink(SuperDiffNode superDiffNode, SuperDiffNode superDiffNode2) {
        superDiffNode.children.remove(superDiffNode2);
        superDiffNode2.parents.remove(superDiffNode);
    }

    @Override
    public SuperViewNode getRawNode() {
        return (SuperViewNode)super.getRawNode();
    }

    @Override
    public List getChildren() {
        return new ArrayList(this.children);
    }

    public CombinedDiffNode getCombinedDiffNode() {
        return this.combinedDiffNode;
    }

    public CombinedViewNode getCombinedRawNode() {
        if (this.combinedDiffNode == null) return null;
        CombinedViewNode combinedViewNode = this.combinedDiffNode.getRawNode();
        return combinedViewNode;
    }

    @Override
    public List getParents() {
        return new ArrayList(this.parents);
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

    public void setCombinedDiffNode(CombinedDiffNode combinedDiffNode) {
        Preconditions.checkNotNull(combinedDiffNode);
        this.combinedDiffNode = combinedDiffNode;
    }
}

