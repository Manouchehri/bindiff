/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions;
import com.google.security.zynamics.zylib.gui.zygraph.functions.NodeFunctions$1;
import com.google.security.zynamics.zylib.gui.zygraph.functions.NodeFunctions$2;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.ArrayList;
import java.util.List;

public class NodeFunctions {
    public static List getInvisibleNodes(AbstractZyGraph abstractZyGraph) {
        ArrayList arrayList = new ArrayList();
        IteratorFunctions.iterateInvisible(abstractZyGraph, new NodeFunctions$1(arrayList));
        return arrayList;
    }

    public static List getVisibleNodes(AbstractZyGraph abstractZyGraph) {
        ArrayList arrayList = new ArrayList();
        IteratorFunctions.iterateVisible(abstractZyGraph, new NodeFunctions$2(arrayList));
        return arrayList;
    }
}

