/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.edges;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class CombinedViewEdge
extends CViewEdge {
    public CombinedViewEdge(CombinedViewNode combinedViewNode, CombinedViewNode combinedViewNode2) {
        super(-1, combinedViewNode, combinedViewNode2, EdgeType.DUMMY, 0.0, 0.0, 0.0, 0.0, Color.BLACK, false, true, new ArrayList());
        CombinedViewNode.link(combinedViewNode, combinedViewNode2);
        combinedViewNode.addOutgoingEdge(this);
        combinedViewNode2.addIncomingEdge(this);
    }

    public abstract EMatchState getMatchState();

    public abstract SingleViewEdge getPrimaryEdge();

    public abstract SingleViewEdge getSecondaryEdge();
}

