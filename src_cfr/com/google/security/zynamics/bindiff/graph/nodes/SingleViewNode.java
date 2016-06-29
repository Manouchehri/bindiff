/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class SingleViewNode
extends CViewNode
implements IGraphNode {
    private final IAddress address;
    private final List children = new ArrayList();
    private final List parents = new ArrayList();

    public SingleViewNode(IAddress iAddress, int n2, double d2, double d3, Color color, Color color2, boolean bl2, boolean bl3) {
        super(n2, d2, d3, 0.0, 0.0, color, color2, bl2, bl3);
        Preconditions.checkNotNull(iAddress);
        this.address = iAddress;
    }

    public static void link(SingleViewNode singleViewNode, SingleViewNode singleViewNode2) {
        singleViewNode.getChildren().add(singleViewNode2);
        singleViewNode2.getParents().add(singleViewNode);
    }

    public static void unlink(SingleViewNode singleViewNode, SingleViewNode singleViewNode2) {
        singleViewNode.getChildren().remove(singleViewNode2);
        singleViewNode2.getParents().remove(singleViewNode);
    }

    public IAddress getAddress() {
        return this.address;
    }

    @Override
    public List getChildren() {
        return this.children;
    }

    @Override
    public List getIncomingEdges() {
        return super.getIncomingEdges();
    }

    public abstract EMatchState getMatchState();

    @Override
    public List getOutgoingEdges() {
        return super.getOutgoingEdges();
    }

    @Override
    public IGroupNode getParentGroup() {
        return null;
    }

    @Override
    public List getParents() {
        return this.parents;
    }

    public abstract ESide getSide();
}

