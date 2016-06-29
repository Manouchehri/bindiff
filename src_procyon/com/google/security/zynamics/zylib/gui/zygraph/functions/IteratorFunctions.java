package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;

public class IteratorFunctions
{
    public static void iterateInvisible(final AbstractZyGraph abstractZyGraph, final IEdgeCallback edgeCallback) {
        Preconditions.checkNotNull(edgeCallback, (Object)"Error: Callback argument can't be null");
        abstractZyGraph.iterateEdges(new IteratorFunctions$1(edgeCallback));
    }
    
    public static void iterateInvisible(final AbstractZyGraph abstractZyGraph, final INodeCallback nodeCallback) {
        Preconditions.checkNotNull(nodeCallback, (Object)"Error: Callback argument can't be null");
        abstractZyGraph.iterate(new IteratorFunctions$2(nodeCallback));
    }
    
    public static void iterateSelected(final AbstractZyGraph abstractZyGraph, final INodeCallback nodeCallback) {
        Preconditions.checkNotNull(nodeCallback, (Object)"Error: Callback argument can't be null");
        abstractZyGraph.iterate(new IteratorFunctions$3(nodeCallback));
    }
    
    public static void iterateVisible(final AbstractZyGraph abstractZyGraph, final IEdgeCallback edgeCallback) {
        Preconditions.checkNotNull(edgeCallback, (Object)"Error: Callback argument can't be null");
        abstractZyGraph.iterateEdges(new IteratorFunctions$4(edgeCallback));
    }
    
    public static void iterateVisible(final AbstractZyGraph abstractZyGraph, final INodeCallback nodeCallback) {
        Preconditions.checkNotNull(nodeCallback, (Object)"Error: Callback argument can't be null");
        abstractZyGraph.iterate(new IteratorFunctions$5(nodeCallback));
    }
}
