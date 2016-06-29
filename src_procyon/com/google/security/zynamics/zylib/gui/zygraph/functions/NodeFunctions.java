package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;

public class NodeFunctions
{
    public static List getInvisibleNodes(final AbstractZyGraph abstractZyGraph) {
        final ArrayList list = new ArrayList();
        IteratorFunctions.iterateInvisible(abstractZyGraph, new NodeFunctions$1(list));
        return list;
    }
    
    public static List getVisibleNodes(final AbstractZyGraph abstractZyGraph) {
        final ArrayList list = new ArrayList();
        IteratorFunctions.iterateVisible(abstractZyGraph, new NodeFunctions$2(list));
        return list;
    }
}
