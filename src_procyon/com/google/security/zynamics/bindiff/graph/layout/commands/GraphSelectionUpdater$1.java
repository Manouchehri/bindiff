package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import java.util.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.types.common.*;

final class GraphSelectionUpdater$1 implements IEdgeCallback
{
    final /* synthetic */ Collection val$edgesToSelect;
    
    GraphSelectionUpdater$1(final Collection val$edgesToSelect) {
        this.val$edgesToSelect = val$edgesToSelect;
    }
    
    public IterationMode nextEdge(final ZyGraphEdge zyGraphEdge) {
        if (zyGraphEdge.getSource().getRawNode().isSelected() || zyGraphEdge.getTarget().getRawNode().isSelected()) {
            this.val$edgesToSelect.add(zyGraphEdge);
        }
        return IterationMode.CONTINUE;
    }
}
