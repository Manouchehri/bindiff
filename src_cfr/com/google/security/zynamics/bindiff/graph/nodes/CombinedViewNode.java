/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class CombinedViewNode
extends CViewNode
implements IGraphNode {
    private final List children = new ArrayList();
    private final List parents = new ArrayList();

    public CombinedViewNode() {
        super(-1, 0.0, 0.0, 0.0, 0.0, Color.WHITE, Color.BLACK, false, true);
    }

    public static void link(CombinedViewNode combinedViewNode, CombinedViewNode combinedViewNode2) {
        combinedViewNode.getChildren().add(combinedViewNode2);
        combinedViewNode2.getParents().add(combinedViewNode);
    }

    public static void unlink(CombinedViewNode combinedViewNode, CombinedViewNode combinedViewNode2) {
        combinedViewNode.getChildren().remove(combinedViewNode2);
        combinedViewNode2.getParents().remove(combinedViewNode);
    }

    public abstract IAddress getAddress(ESide var1);

    @Override
    public List getChildren() {
        return this.children;
    }

    @Override
    public List getIncomingEdges() {
        return super.getIncomingEdges();
    }

    public EMatchState getMatchState() {
        if (this.getRawNode(ESide.PRIMARY) == null) {
            return EMatchState.SECONDRAY_UNMATCHED;
        }
        if (this.getRawNode(ESide.SECONDARY) != null) return EMatchState.MATCHED;
        return EMatchState.PRIMARY_UNMATCHED;
    }

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

    public abstract SingleViewNode getRawNode(ESide var1);
}

