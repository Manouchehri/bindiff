/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.edges;

import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class SingleViewEdge
extends CViewEdge {
    public SingleViewEdge(SingleViewNode singleViewNode, SingleViewNode singleViewNode2) {
        super(-1, singleViewNode, singleViewNode2, EdgeType.DUMMY, 0.0, 0.0, 0.0, 0.0, Color.BLACK, false, true, new ArrayList());
        SingleViewNode.link(singleViewNode, singleViewNode2);
        singleViewNode.addOutgoingEdge(this);
        singleViewNode2.addIncomingEdge(this);
    }
}

