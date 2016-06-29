package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;

public class MultiEdgeHider
{
    public static void hideMultipleEdgesInternal(final AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.iterate(new MultiEdgeHider$1());
    }
    
    public static void hideMultipleEdgesInternal(final ZyGraphNode zyGraphNode) {
        if (!zyGraphNode.isVisible() || zyGraphNode.getRawNode() instanceof IGroupNode) {
            return;
        }
        final HashSet<Object> set = new HashSet<Object>();
        for (final IViewEdge viewEdge : zyGraphNode.getRawNode().getOutgoingEdges()) {
            final Object target = viewEdge.getTarget();
            if (set.contains(target)) {
                viewEdge.setVisible(false);
            }
            else {
                set.add(target);
            }
        }
        final HashSet<Object> set2 = new HashSet<Object>();
        for (final IViewEdge viewEdge2 : zyGraphNode.getRawNode().getIncomingEdges()) {
            if (set2.contains(viewEdge2.getSource())) {
                viewEdge2.setVisible(false);
            }
            else {
                set2.add(viewEdge2.getSource());
            }
        }
    }
    
    public static void unhideMultipleEdgesInternal(final AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.iterateEdges(new MultiEdgeHider$2());
    }
}
