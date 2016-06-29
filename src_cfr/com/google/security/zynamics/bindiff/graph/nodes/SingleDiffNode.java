/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
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

public class SingleDiffNode
extends ZyGraphNode
implements IGraphNode {
    private CombinedDiffNode combinedDiffNode;
    private SuperDiffNode superDiffNode;
    private SingleDiffNode otherSideDiffNode;
    private final ESide side;
    private final List parents = new ArrayList();
    private final List children = new ArrayList();

    public SingleDiffNode(q q2, IZyNodeRealizer iZyNodeRealizer, SingleViewNode singleViewNode, ESide eSide) {
        super(q2, iZyNodeRealizer, singleViewNode);
        this.side = (ESide)((Object)Preconditions.checkNotNull((Object)eSide));
    }

    public static void link(SingleDiffNode singleDiffNode, SingleDiffNode singleDiffNode2) {
        singleDiffNode.children.add(singleDiffNode2);
        singleDiffNode2.parents.add(singleDiffNode);
    }

    public static void unlink(SingleDiffNode singleDiffNode, SingleDiffNode singleDiffNode2) {
        singleDiffNode.children.remove(singleDiffNode2);
        singleDiffNode2.parents.remove(singleDiffNode);
    }

    @Override
    public List getChildren() {
        return new ArrayList(this.children);
    }

    public CombinedDiffNode getCombinedDiffNode() {
        return this.combinedDiffNode;
    }

    public CombinedViewNode getCombinedRawNode() {
        return this.combinedDiffNode.getRawNode();
    }

    public SingleDiffNode getOtherSideDiffNode() {
        return this.otherSideDiffNode;
    }

    public SingleViewNode getOtherSideRawNode() {
        if (this.otherSideDiffNode == null) return null;
        SingleViewNode singleViewNode = this.otherSideDiffNode.getRawNode();
        return singleViewNode;
    }

    @Override
    public List getParents() {
        return new ArrayList(this.parents);
    }

    @Override
    public SingleViewNode getRawNode() {
        return (SingleViewNode)super.getRawNode();
    }

    public ESide getSide() {
        return this.side;
    }

    public SuperDiffNode getSuperDiffNode() {
        return this.superDiffNode;
    }

    public SuperViewNode getSuperRawNode() {
        return this.superDiffNode.getRawNode();
    }

    public void setCombinedDiffNode(CombinedDiffNode combinedDiffNode) {
        Preconditions.checkNotNull(combinedDiffNode);
        this.combinedDiffNode = combinedDiffNode;
        this.superDiffNode = combinedDiffNode.getSuperDiffNode();
        this.otherSideDiffNode = this.side == ESide.PRIMARY ? combinedDiffNode.getSecondaryDiffNode() : combinedDiffNode.getPrimaryDiffNode();
    }
}

