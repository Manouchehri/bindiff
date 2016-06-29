/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets$SetView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CGraphSelector$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import y.a.b;
import y.c.A;
import y.c.i;
import y.c.q;
import y.c.y;
import y.h.bu;

public class CGraphSelector {
    public static void selectNode(AbstractZyGraph abstractZyGraph, ZyGraphNode zyGraphNode, boolean bl2) {
        ArrayList<ZyGraphNode> arrayList = new ArrayList<ZyGraphNode>();
        ArrayList<ZyGraphNode> arrayList2 = new ArrayList<ZyGraphNode>();
        Iterator iterator = abstractZyGraph.getNodes().iterator();
        do {
            if (!iterator.hasNext()) {
                abstractZyGraph.selectNodes(arrayList, arrayList2);
                return;
            }
            ZyGraphNode zyGraphNode2 = (ZyGraphNode)iterator.next();
            if (zyGraphNode2 == zyGraphNode) {
                if (zyGraphNode.isSelected()) {
                    arrayList2.add(zyGraphNode2);
                    continue;
                }
                arrayList.add(zyGraphNode2);
                continue;
            }
            if (zyGraphNode2.isSelected() && bl2) {
                arrayList.add(zyGraphNode2);
                continue;
            }
            arrayList2.add(zyGraphNode2);
        } while (true);
    }

    public static void selectPath(AbstractZyGraph abstractZyGraph, ArrayList arrayList, ZyGraphNode zyGraphNode) {
        y[] arry;
        y[] arry4;
        y[] arry2;
        y[] arry22;
        CGraphSelector$1 cGraphSelector$1 = new CGraphSelector$1();
        Collection collection = Collections2.transform(arrayList, cGraphSelector$1);
        y y2 = new y(collection.iterator());
        y y3 = new y(zyGraphNode.getNode());
        HashSet hashSet = new HashSet();
        for (y y4 : arry2 = b.a((i)abstractZyGraph.getGraph(), y2, 2, abstractZyGraph.getGraph().t(), 0)) {
            hashSet.addAll(y4);
        }
        y[] arry6 = new HashSet();
        for (y arry52 : arry4 = b.a((i)abstractZyGraph.getGraph(), y3, 1, abstractZyGraph.getGraph().t(), 0)) {
            arry6.addAll(arry52);
        }
        Sets$SetView sets$SetView = Sets.intersection(hashSet, (Set)arry6);
        if (!sets$SetView.isEmpty()) {
            Iterator iterator = sets$SetView.iterator();
            while (iterator.hasNext()) {
                q q2 = (q)iterator.next();
                abstractZyGraph.getGraph().a(q2, true);
            }
        }
        HashSet hashSet2 = new HashSet();
        for (y iterator : arry22 = b.a((i)abstractZyGraph.getGraph(), y2, 1, abstractZyGraph.getGraph().t(), 0)) {
            hashSet2.addAll(iterator);
        }
        HashSet hashSet3 = new HashSet();
        for (y y5 : arry = b.a((i)abstractZyGraph.getGraph(), y3, 2, abstractZyGraph.getGraph().t(), 0)) {
            hashSet3.addAll(y5);
        }
        Sets$SetView sets$SetView2 = Sets.intersection(hashSet2, hashSet3);
        if (sets$SetView2.isEmpty()) return;
        Iterator iterator2 = sets$SetView2.iterator();
        while (iterator2.hasNext()) {
            q q2 = (q)iterator2.next();
            abstractZyGraph.getGraph().a(q2, true);
        }
    }
}

