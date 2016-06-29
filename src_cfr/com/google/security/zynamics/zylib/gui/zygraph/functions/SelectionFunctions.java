/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.functions.SelectionFunctions$1;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.ArrayList;
import java.util.Collection;

public class SelectionFunctions {
    public static void invertSelection(AbstractZyGraph abstractZyGraph) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        abstractZyGraph.iterate(new SelectionFunctions$1(arrayList2, arrayList));
        abstractZyGraph.selectNodes(arrayList, arrayList2);
    }
}

