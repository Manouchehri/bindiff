package com.google.security.zynamics.bindiff.graph.searchers;

import java.util.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class SearchResultComparator implements Comparator
{
    public int compare(final SearchResult searchResult, final SearchResult searchResult2) {
        final Object object = searchResult.getObject();
        final Object object2 = searchResult2.getObject();
        if (object == object2) {
            if (searchResult.getLine() > searchResult2.getLine()) {
                return 1;
            }
            if (searchResult.getLine() < searchResult2.getLine()) {
                return -1;
            }
            return 0;
        }
        else {
            Comparable<IAddress> comparable = null;
            IAddress address = null;
            if (object instanceof SingleDiffNode) {
                comparable = (Comparable<IAddress>)((SingleDiffNode)object).getRawNode().getAddress();
            }
            else if (object instanceof SingleDiffEdge) {
                comparable = (Comparable<IAddress>)((SingleViewNode)((SingleViewEdge)((SingleDiffEdge)object).getRawEdge()).getSource()).getAddress();
            }
            if (object2 instanceof SingleDiffNode) {
                address = ((SingleDiffNode)object2).getRawNode().getAddress();
            }
            else if (object2 instanceof SingleDiffEdge) {
                address = ((SingleViewNode)((SingleViewEdge)((SingleDiffEdge)object2).getRawEdge()).getSource()).getAddress();
            }
            if (comparable == null || address == null) {
                throw new IllegalStateException("Address cannot be null");
            }
            return comparable.compareTo(address);
        }
    }
}
