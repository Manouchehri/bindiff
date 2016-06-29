package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.sorters.*;
import java.util.*;

public class CombinedGraphSearcher extends GraphSearcher
{
    @Override
    public void search(final List list, final List list2, final String lastSearchString) {
        this.setLastSearchString(lastSearchString);
    }
    
    public void setObjectResults(final CombinedGraph combinedGraph, final List list, final List list2) {
        final HashSet<CombinedDiffNode> set = new HashSet<CombinedDiffNode>();
        final HashSet set2 = new HashSet();
        set2.addAll(list);
        set2.addAll(list2);
        for (final CombinedDiffNode combinedDiffNode : combinedGraph.getNodes()) {
            if (set2.contains(combinedDiffNode.getPrimaryDiffNode())) {
                set.add(combinedDiffNode);
            }
            else {
                if (!set2.contains(combinedDiffNode.getSecondaryDiffNode())) {
                    continue;
                }
                set.add(combinedDiffNode);
            }
        }
        for (final CombinedDiffEdge combinedDiffEdge : combinedGraph.getEdges()) {
            if (set2.contains(combinedDiffEdge.getPrimaryDiffEdge())) {
                set.add((CombinedDiffNode)combinedDiffEdge);
            }
            else {
                if (!set2.contains(combinedDiffEdge.getSecondaryDiffEdge())) {
                    continue;
                }
                set.add((CombinedDiffNode)combinedDiffEdge);
            }
        }
        this.setObjectResult(SearchResultSorter.getSortedList(set, ESide.PRIMARY));
    }
}
