/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.sorters;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.sorters.AddressPairSorter;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchResultSorter {
    private static Map getAddrPairToObjectMap(Collection collection) {
        HashMap hashMap = new HashMap();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            SingleViewNode singleViewNode;
            Object object;
            SingleViewNode singleViewNode2;
            Object e2 = iterator.next();
            IAddress iAddress = null;
            IAddress iAddress2 = null;
            if (e2 instanceof SuperDiffNode) {
                object = ((SuperDiffNode)e2).getPrimaryRawNode();
                if (object != null) {
                    iAddress = object.getAddress();
                }
                if ((singleViewNode2 = ((SuperDiffNode)e2).getSecondaryRawNode()) != null) {
                    iAddress2 = singleViewNode2.getAddress();
                }
            } else if (e2 instanceof CombinedDiffNode) {
                object = ((CombinedDiffNode)e2).getPrimaryRawNode();
                if (object != null) {
                    iAddress = object.getAddress();
                }
                if ((singleViewNode2 = ((CombinedDiffNode)e2).getSecondaryRawNode()) != null) {
                    iAddress2 = singleViewNode2.getAddress();
                }
            } else if (e2 instanceof SingleDiffNode) {
                object = (SingleDiffNode)e2;
                if (object.getSide() == ESide.PRIMARY) {
                    iAddress = object.getRawNode().getAddress();
                } else {
                    iAddress2 = object.getRawNode().getAddress();
                }
            } else if (e2 instanceof SuperDiffEdge) {
                object = (SuperDiffEdge)e2;
                singleViewNode2 = ((SuperDiffNode)object.getSource()).getPrimaryRawNode();
                if (singleViewNode2 != null) {
                    iAddress = singleViewNode2.getAddress();
                }
                if ((singleViewNode = ((SuperDiffNode)object.getSource()).getSecondaryRawNode()) != null) {
                    iAddress2 = singleViewNode.getAddress();
                }
            } else if (e2 instanceof CombinedDiffEdge) {
                object = (CombinedDiffEdge)e2;
                singleViewNode2 = ((CombinedDiffNode)object.getSource()).getPrimaryRawNode();
                if (singleViewNode2 != null) {
                    iAddress = singleViewNode2.getAddress();
                }
                if ((singleViewNode = ((CombinedDiffNode)object.getSource()).getSecondaryRawNode()) != null) {
                    iAddress2 = singleViewNode.getAddress();
                }
            } else if (e2 instanceof SingleDiffEdge) {
                object = (SingleDiffEdge)e2;
                if (object.getSide() == ESide.PRIMARY) {
                    iAddress = ((SingleDiffNode)object.getSource()).getRawNode().getAddress();
                } else {
                    iAddress2 = ((SingleDiffNode)object.getSource()).getRawNode().getAddress();
                }
            }
            object = new Pair(iAddress, iAddress2);
            hashMap.put(object, e2);
        }
        return hashMap;
    }

    public static List getSortedList(Collection collection, ESide eSide) {
        ArrayList arrayList = new ArrayList();
        Map map = SearchResultSorter.getAddrPairToObjectMap(collection);
        List list = AddressPairSorter.getSortedList(map.keySet(), eSide);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Pair pair = (Pair)iterator.next();
            Object v2 = map.get(pair);
            arrayList.add(v2);
        }
        return arrayList;
    }
}

