/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public final class SuperViewEdge
extends CViewEdge {
    private final CombinedViewEdge combinedEdge;

    public SuperViewEdge(CombinedViewEdge combinedViewEdge, SuperViewNode superViewNode, SuperViewNode superViewNode2) {
        super(-1, superViewNode, superViewNode2, EdgeType.DUMMY, 0.0, 0.0, 0.0, 0.0, Color.BLACK, false, true, new ArrayList());
        this.combinedEdge = (CombinedViewEdge)Preconditions.checkNotNull(combinedViewEdge);
        SuperViewNode.link(superViewNode, superViewNode2);
        superViewNode.addOutgoingEdge(this);
        superViewNode2.addIncomingEdge(this);
    }

    public CombinedViewEdge getCombinedEdge() {
        return this.combinedEdge;
    }

    public SingleViewEdge getSingleEdge(ESide eSide) {
        SingleViewEdge singleViewEdge;
        if (eSide == ESide.PRIMARY) {
            singleViewEdge = this.combinedEdge.getPrimaryEdge();
            return singleViewEdge;
        }
        singleViewEdge = this.combinedEdge.getSecondaryEdge();
        return singleViewEdge;
    }
}

