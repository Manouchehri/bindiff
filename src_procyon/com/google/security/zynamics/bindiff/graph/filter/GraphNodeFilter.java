package com.google.security.zynamics.bindiff.graph.filter;

import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;

public class GraphNodeFilter
{
    private static int internalFilterNodes(final Collection collection, final GraphNodeFilter$Criterium graphNodeFilter$Criterium, final Collection collection2) {
        Preconditions.checkNotNull(graphNodeFilter$Criterium);
        int n = 0;
        for (final ZyGraphNode zyGraphNode : collection) {
            boolean b = false;
            switch (GraphNodeFilter$1.$SwitchMap$com$google$security$zynamics$bindiff$graph$filter$GraphNodeFilter$Criterium[graphNodeFilter$Criterium.ordinal()]) {
                case 1: {
                    b = zyGraphNode.isVisible();
                    break;
                }
                case 2: {
                    b = !zyGraphNode.isVisible();
                    break;
                }
                case 3: {
                    b = zyGraphNode.isSelected();
                    break;
                }
                case 4: {
                    b = (zyGraphNode.isSelected() && zyGraphNode.isVisible());
                    break;
                }
                case 5: {
                    b = (!zyGraphNode.isSelected() && zyGraphNode.isVisible());
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid node filter criterium");
                }
            }
            if (b) {
                ++n;
                if (collection2 == null) {
                    continue;
                }
                collection2.add(zyGraphNode);
            }
        }
        return n;
    }
    
    private static int internalFilterNodes(final AbstractZyGraph abstractZyGraph, final GraphNodeFilter$Criterium graphNodeFilter$Criterium, final Collection collection) {
        return internalFilterNodes(abstractZyGraph.getNodes(), graphNodeFilter$Criterium, collection);
    }
    
    public static List filterNodes(final AbstractZyGraph abstractZyGraph, final GraphNodeFilter$Criterium graphNodeFilter$Criterium) {
        final ArrayList list = new ArrayList();
        internalFilterNodes(abstractZyGraph, graphNodeFilter$Criterium, list);
        return list;
    }
    
    public static int filterNodesCountOnly(final AbstractZyGraph abstractZyGraph, final GraphNodeFilter$Criterium graphNodeFilter$Criterium) {
        return internalFilterNodes(abstractZyGraph, graphNodeFilter$Criterium, null);
    }
    
    public static List filterNodes(final Collection collection, final GraphNodeFilter$Criterium graphNodeFilter$Criterium) {
        final ArrayList list = new ArrayList();
        internalFilterNodes(collection, graphNodeFilter$Criterium, list);
        return list;
    }
}
