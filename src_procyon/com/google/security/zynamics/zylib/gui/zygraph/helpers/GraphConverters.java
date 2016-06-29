package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import java.util.*;

public class GraphConverters
{
    public static Collection convert(final AbstractZyGraph abstractZyGraph, final Collection collection) {
        final ArrayList<ZyGraphNode> list = new ArrayList<ZyGraphNode>();
        final Iterator<IViewNode> iterator = collection.iterator();
        while (iterator.hasNext()) {
            list.add(abstractZyGraph.getNode(iterator.next()));
        }
        return list;
    }
    
    public static List convert(final Collection collection) {
        final ArrayList<IViewNode> list = new ArrayList<IViewNode>();
        final Iterator<ZyGraphNode> iterator = collection.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().getRawNode());
        }
        return list;
    }
}
