package com.google.security.zynamics.bindiff.graph.sorters;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import java.util.*;

public class SearchResultSorter
{
    private static Map getAddrPairToObjectMap(final Collection collection) {
        final HashMap<Pair, SingleDiffEdge> hashMap = new HashMap<Pair, SingleDiffEdge>();
        for (final SuperDiffNode next : collection) {
            Object o = null;
            Object o2 = null;
            if (next instanceof SuperDiffNode) {
                final SingleViewNode primaryRawNode = next.getPrimaryRawNode();
                if (primaryRawNode != null) {
                    o = primaryRawNode.getAddress();
                }
                final SingleViewNode secondaryRawNode = next.getSecondaryRawNode();
                if (secondaryRawNode != null) {
                    o2 = secondaryRawNode.getAddress();
                }
            }
            else if (next instanceof CombinedDiffNode) {
                final SingleViewNode primaryRawNode2 = ((CombinedDiffNode)next).getPrimaryRawNode();
                if (primaryRawNode2 != null) {
                    o = primaryRawNode2.getAddress();
                }
                final SingleViewNode secondaryRawNode2 = ((CombinedDiffNode)next).getSecondaryRawNode();
                if (secondaryRawNode2 != null) {
                    o2 = secondaryRawNode2.getAddress();
                }
            }
            else if (next instanceof SingleDiffNode) {
                final SingleDiffNode singleDiffNode = (SingleDiffNode)next;
                if (singleDiffNode.getSide() == ESide.PRIMARY) {
                    o = singleDiffNode.getRawNode().getAddress();
                }
                else {
                    o2 = singleDiffNode.getRawNode().getAddress();
                }
            }
            else if (next instanceof SuperDiffEdge) {
                final SuperDiffEdge superDiffEdge = (SuperDiffEdge)next;
                final SingleViewNode primaryRawNode3 = ((SuperDiffNode)superDiffEdge.getSource()).getPrimaryRawNode();
                if (primaryRawNode3 != null) {
                    o = primaryRawNode3.getAddress();
                }
                final SingleViewNode secondaryRawNode3 = ((SuperDiffNode)superDiffEdge.getSource()).getSecondaryRawNode();
                if (secondaryRawNode3 != null) {
                    o2 = secondaryRawNode3.getAddress();
                }
            }
            else if (next instanceof CombinedDiffEdge) {
                final CombinedDiffEdge combinedDiffEdge = (CombinedDiffEdge)next;
                final SingleViewNode primaryRawNode4 = ((CombinedDiffNode)combinedDiffEdge.getSource()).getPrimaryRawNode();
                if (primaryRawNode4 != null) {
                    o = primaryRawNode4.getAddress();
                }
                final SingleViewNode secondaryRawNode4 = ((CombinedDiffNode)combinedDiffEdge.getSource()).getSecondaryRawNode();
                if (secondaryRawNode4 != null) {
                    o2 = secondaryRawNode4.getAddress();
                }
            }
            else if (next instanceof SingleDiffEdge) {
                final SingleDiffEdge singleDiffEdge = (SingleDiffEdge)next;
                if (singleDiffEdge.getSide() == ESide.PRIMARY) {
                    o = ((SingleDiffNode)singleDiffEdge.getSource()).getRawNode().getAddress();
                }
                else {
                    o2 = ((SingleDiffNode)singleDiffEdge.getSource()).getRawNode().getAddress();
                }
            }
            hashMap.put(new Pair(o, o2), (SingleDiffEdge)next);
        }
        return hashMap;
    }
    
    public static List getSortedList(final Collection collection, final ESide eSide) {
        final ArrayList<Object> list = new ArrayList<Object>();
        final Map addrPairToObjectMap = getAddrPairToObjectMap(collection);
        final Iterator iterator = AddressPairSorter.getSortedList(addrPairToObjectMap.keySet(), eSide).iterator();
        while (iterator.hasNext()) {
            list.add(addrPairToObjectMap.get(iterator.next()));
        }
        return list;
    }
}
