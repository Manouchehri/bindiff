/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Collection;

final class GraphSelectionUpdater$1
implements IEdgeCallback {
    final /* synthetic */ Collection val$edgesToSelect;

    GraphSelectionUpdater$1(Collection collection) {
        this.val$edgesToSelect = collection;
    }

    public IterationMode nextEdge(ZyGraphEdge zyGraphEdge) {
        if (!zyGraphEdge.getSource().getRawNode().isSelected()) {
            if (!zyGraphEdge.getTarget().getRawNode().isSelected()) return IterationMode.CONTINUE;
        }
        this.val$edgesToSelect.add(zyGraphEdge);
        return IterationMode.CONTINUE;
    }
}

