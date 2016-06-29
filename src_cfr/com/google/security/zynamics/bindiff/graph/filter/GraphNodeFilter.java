/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.filter;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$1;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GraphNodeFilter {
    private GraphNodeFilter() {
    }

    /*
     * Unable to fully structure code
     */
    private static int internalFilterNodes(Collection var0, GraphNodeFilter$Criterium var1_1, Collection var2_2) {
        Preconditions.checkNotNull((Object)var1_1);
        var3_3 = 0;
        var5_4 = var0.iterator();
        block7 : while (var5_4.hasNext() != false) {
            var6_6 = (ZyGraphNode)var5_4.next();
            switch (GraphNodeFilter$1.$SwitchMap$com$google$security$zynamics$bindiff$graph$filter$GraphNodeFilter$Criterium[var1_1.ordinal()]) {
                case 1: {
                    var4_5 = var6_6.isVisible();
                    ** break;
                }
                case 2: {
                    var4_5 = var6_6.isVisible() == false;
                    ** break;
                }
                case 3: {
                    var4_5 = var6_6.isSelected();
                    ** break;
                }
                case 4: {
                    var4_5 = var6_6.isSelected() != false && var6_6.isVisible() != false;
                    ** break;
                }
                case 5: {
                    var4_5 = var6_6.isSelected() == false && var6_6.isVisible() != false;
                    ** break;
lbl22: // 5 sources:
                    if (!var4_5) continue block7;
                    ++var3_3;
                    if (var2_2 == null) continue block7;
                    var2_2.add(var6_6);
                    continue block7;
                }
            }
        }
        return var3_3;
        throw new IllegalArgumentException("Invalid node filter criterium");
    }

    private static int internalFilterNodes(AbstractZyGraph abstractZyGraph, GraphNodeFilter$Criterium graphNodeFilter$Criterium, Collection collection) {
        return GraphNodeFilter.internalFilterNodes(abstractZyGraph.getNodes(), graphNodeFilter$Criterium, collection);
    }

    public static List filterNodes(AbstractZyGraph abstractZyGraph, GraphNodeFilter$Criterium graphNodeFilter$Criterium) {
        ArrayList arrayList = new ArrayList();
        GraphNodeFilter.internalFilterNodes(abstractZyGraph, graphNodeFilter$Criterium, arrayList);
        return arrayList;
    }

    public static int filterNodesCountOnly(AbstractZyGraph abstractZyGraph, GraphNodeFilter$Criterium graphNodeFilter$Criterium) {
        return GraphNodeFilter.internalFilterNodes(abstractZyGraph, graphNodeFilter$Criterium, null);
    }

    public static List filterNodes(Collection collection, GraphNodeFilter$Criterium graphNodeFilter$Criterium) {
        ArrayList arrayList = new ArrayList();
        GraphNodeFilter.internalFilterNodes(collection, graphNodeFilter$Criterium, arrayList);
        return arrayList;
    }
}

