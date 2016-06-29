package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.sorters.*;
import java.util.*;

public class SuperGraphSearcher extends GraphSearcher
{
    @Override
    public void search(final List list, final List list2, final String lastSearchString) {
        this.setLastSearchString(lastSearchString);
    }
    
    public void setObjectResults(final SuperGraph superGraph, final List list, final List list2) {
        final HashSet<SuperDiffNode> set = new HashSet<SuperDiffNode>();
        final HashSet set2 = new HashSet();
        set2.addAll(list);
        set2.addAll(list2);
        for (final SuperDiffNode superDiffNode : superGraph.getNodes()) {
            if (set2.contains(superDiffNode.getPrimaryDiffNode())) {
                set.add(superDiffNode);
            }
            else {
                if (!set2.contains(superDiffNode.getSecondaryDiffNode())) {
                    continue;
                }
                set.add(superDiffNode);
            }
        }
        for (final SuperDiffEdge superDiffEdge : superGraph.getEdges()) {
            if (set2.contains(superDiffEdge.getPrimaryDiffEdge())) {
                set.add((SuperDiffNode)superDiffEdge);
            }
            else {
                if (!set2.contains(superDiffEdge.getSecondaryDiffEdge())) {
                    continue;
                }
                set.add((SuperDiffNode)superDiffEdge);
            }
        }
        this.setObjectResult(SearchResultSorter.getSortedList(set, ESide.PRIMARY));
    }
}
