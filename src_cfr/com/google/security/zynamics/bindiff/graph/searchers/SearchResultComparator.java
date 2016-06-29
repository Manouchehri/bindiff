/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import java.util.Comparator;

public class SearchResultComparator
implements Comparator {
    public int compare(SearchResult searchResult, SearchResult searchResult2) {
        Object object;
        Object object2;
        SingleViewNode singleViewNode;
        Object object3 = searchResult.getObject();
        if (object3 == (object = searchResult2.getObject())) {
            if (searchResult.getLine() > searchResult2.getLine()) {
                return 1;
            }
            if (searchResult.getLine() >= searchResult2.getLine()) return 0;
            return -1;
        }
        IAddress iAddress = null;
        IAddress iAddress2 = null;
        if (object3 instanceof SingleDiffNode) {
            object2 = ((SingleDiffNode)object3).getRawNode();
            iAddress = object2.getAddress();
        } else if (object3 instanceof SingleDiffEdge) {
            object2 = (SingleViewEdge)((SingleDiffEdge)object3).getRawEdge();
            singleViewNode = (SingleViewNode)object2.getSource();
            iAddress = singleViewNode.getAddress();
        }
        if (object instanceof SingleDiffNode) {
            object2 = ((SingleDiffNode)object).getRawNode();
            iAddress2 = object2.getAddress();
        } else if (object instanceof SingleDiffEdge) {
            object2 = (SingleViewEdge)((SingleDiffEdge)object).getRawEdge();
            singleViewNode = (SingleViewNode)object2.getSource();
            iAddress2 = singleViewNode.getAddress();
        }
        if (iAddress == null) throw new IllegalStateException("Address cannot be null");
        if (iAddress2 != null) return iAddress.compareTo(iAddress2);
        throw new IllegalStateException("Address cannot be null");
    }
}

