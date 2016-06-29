package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import java.util.*;

public class SelectionFunctions
{
    public static void invertSelection(final AbstractZyGraph abstractZyGraph) {
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        abstractZyGraph.iterate(new SelectionFunctions$1(list2, list));
        abstractZyGraph.selectNodes(list, list2);
    }
}
