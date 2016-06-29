/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.sorters.SearchResultSorter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CombinedGraphSearcher
extends GraphSearcher {
    @Override
    public void search(List list, List list2, String string) {
        this.setLastSearchString(string);
    }

    public void setObjectResults(CombinedGraph combinedGraph, List list, List list2) {
        Object object;
        Object object2;
        HashSet<Object> hashSet = new HashSet<Object>();
        HashSet hashSet2 = new HashSet();
        hashSet2.addAll(list);
        hashSet2.addAll(list2);
        for (Object object32 : combinedGraph.getNodes()) {
            object2 = object32.getPrimaryDiffNode();
            if (hashSet2.contains(object2)) {
                hashSet.add(object32);
                continue;
            }
            object = object32.getSecondaryDiffNode();
            if (!hashSet2.contains(object)) continue;
            hashSet.add(object32);
        }
        Object object4 = combinedGraph.getEdges().iterator();
        do {
            Object object32;
            if (!object4.hasNext()) {
                object4 = SearchResultSorter.getSortedList(hashSet, ESide.PRIMARY);
                this.setObjectResult((List)object4);
                return;
            }
            object32 = (CombinedDiffEdge)object4.next();
            object2 = object32.getPrimaryDiffEdge();
            if (hashSet2.contains(object2)) {
                hashSet.add(object32);
                continue;
            }
            object = object32.getSecondaryDiffEdge();
            if (!hashSet2.contains(object)) continue;
            hashSet.add(object32);
        } while (true);
    }
}

