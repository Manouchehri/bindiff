/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphConverters;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ITextNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityRangeCalculator$1;
import com.google.security.zynamics.zylib.gui.zygraph.wrappers.ViewNodeAdapter;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class ProximityRangeCalculator {
    private static Set getGroupMembers(IGroupNode iGroupNode) {
        HashSet<ViewNodeAdapter> hashSet = new HashSet<ViewNodeAdapter>();
        Iterator iterator = iGroupNode.getElements().iterator();
        while (iterator.hasNext()) {
            IViewNode iViewNode = (IViewNode)iterator.next();
            hashSet.add(new ViewNodeAdapter(iViewNode));
        }
        return hashSet;
    }

    private static Set getParentGroups(ZyGraphNode zyGraphNode) {
        HashSet<ViewNodeAdapter> hashSet = new HashSet<ViewNodeAdapter>();
        IGroupNode iGroupNode = zyGraphNode.getRawNode().getParentGroup();
        while (iGroupNode != null) {
            hashSet.add(new ViewNodeAdapter(iGroupNode));
            iGroupNode = iGroupNode.getParentGroup();
        }
        return hashSet;
    }

    private static List getPredecessors(Iterable iterable, int n2) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            ViewNodeAdapter viewNodeAdapter = (ViewNodeAdapter)iterator.next();
            arrayList.addAll(ProximityRangeCalculator.getPredecessors(viewNodeAdapter, n2));
        }
        return arrayList;
    }

    private static Set getPredecessors(ViewNodeAdapter viewNodeAdapter, int n2) {
        HashSet hashSet = new HashSet();
        ProximityRangeCalculator.getPredecessorsInternal(viewNodeAdapter, n2, hashSet, new HashSet());
        return hashSet;
    }

    private static void getPredecessorsInternal(ViewNodeAdapter viewNodeAdapter, int n2, Set set, Set set2) {
        Iterator iterator = viewNodeAdapter.getParents().iterator();
        while (iterator.hasNext()) {
            ViewNodeAdapter viewNodeAdapter2 = (ViewNodeAdapter)iterator.next();
            if (n2 <= 0 && !(viewNodeAdapter2.getNode() instanceof ITextNode)) continue;
            if (viewNodeAdapter2.getNode().getParentGroup() != null) {
                IGroupNode iGroupNode = viewNodeAdapter2.getNode().getParentGroup();
                while (iGroupNode != null) {
                    if (!ProximityRangeCalculator.visited(set2, iGroupNode)) {
                        ViewNodeAdapter viewNodeAdapter3 = new ViewNodeAdapter(iGroupNode);
                        set2.add(viewNodeAdapter3);
                        set.add(viewNodeAdapter3);
                        iGroupNode = iGroupNode.getParentGroup();
                        continue;
                    }
                    iGroupNode = null;
                }
            }
            set2.add(viewNodeAdapter2);
            set.add(viewNodeAdapter2);
            ProximityRangeCalculator.getSuccessorsInternal(viewNodeAdapter2, -1, set, new HashSet());
            ProximityRangeCalculator.getPredecessorsInternal(viewNodeAdapter2, n2 - 1, set, set2);
        }
    }

    private static int getRealDepth(int n2) {
        if (n2 == -1) {
            return Integer.MAX_VALUE;
        }
        int n3 = n2;
        return n3;
    }

    private static List getSuccessors(Iterable iterable, int n2) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            ViewNodeAdapter viewNodeAdapter = (ViewNodeAdapter)iterator.next();
            arrayList.addAll(ProximityRangeCalculator.getSuccessors(viewNodeAdapter, n2));
        }
        return arrayList;
    }

    private static Set getSuccessors(ViewNodeAdapter viewNodeAdapter, int n2) {
        HashSet hashSet = new HashSet();
        ProximityRangeCalculator.getSuccessorsInternal(viewNodeAdapter, n2, hashSet, new HashSet());
        return hashSet;
    }

    private static void getSuccessorsInternal(ViewNodeAdapter viewNodeAdapter, int n2, Set set, HashSet hashSet) {
        Iterator iterator = viewNodeAdapter.getChildren().iterator();
        while (iterator.hasNext()) {
            ViewNodeAdapter viewNodeAdapter2 = (ViewNodeAdapter)iterator.next();
            if (n2 <= 0 && !(viewNodeAdapter2.getNode() instanceof ITextNode)) continue;
            if (viewNodeAdapter2.getNode().getParentGroup() != null) {
                IGroupNode iGroupNode = viewNodeAdapter2.getNode().getParentGroup();
                while (iGroupNode != null) {
                    if (!ProximityRangeCalculator.visited(hashSet, iGroupNode)) {
                        ViewNodeAdapter viewNodeAdapter3 = new ViewNodeAdapter(iGroupNode);
                        hashSet.add(viewNodeAdapter3);
                        set.add(viewNodeAdapter3);
                        iGroupNode = iGroupNode.getParentGroup();
                        continue;
                    }
                    iGroupNode = null;
                }
            }
            if (NodeHelpers.getVisibleNode(viewNodeAdapter2.getNode()) != viewNodeAdapter2.getNode()) continue;
            hashSet.add(viewNodeAdapter2);
            set.add(viewNodeAdapter2);
            ProximityRangeCalculator.getPredecessorsInternal(viewNodeAdapter2, -1, set, new HashSet());
            ProximityRangeCalculator.getSuccessorsInternal(viewNodeAdapter2, n2 - 1, set, hashSet);
        }
    }

    private static boolean visited(Set set, IGroupNode iGroupNode) {
        return CollectionHelpers.any(set, new ProximityRangeCalculator$1(iGroupNode));
    }

    public static Set getNeighbors(AbstractZyGraph abstractZyGraph, Collection collection, int n2, int n3) {
        Preconditions.checkNotNull(abstractZyGraph, "Graph argument can not be null");
        Preconditions.checkNotNull(collection, "Nodes argument can not be null");
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            ArrayList<ZyGraphNode> arrayList = new ArrayList<ZyGraphNode>();
            arrayList.add(zyGraphNode);
            List list = GraphConverters.convert(arrayList);
            List list2 = ViewNodeAdapter.wrap(Lists.newArrayList(list));
            List list3 = ProximityRangeCalculator.getPredecessors(list2, ProximityRangeCalculator.getRealDepth(n3));
            List list4 = ProximityRangeCalculator.getSuccessors(list2, ProximityRangeCalculator.getRealDepth(n2));
            linkedHashSet.addAll(ViewNodeAdapter.unwrap(abstractZyGraph, ProximityRangeCalculator.getParentGroups(zyGraphNode)));
            if (zyGraphNode.getRawNode() instanceof IGroupNode && zyGraphNode.isSelected()) {
                linkedHashSet.addAll(ViewNodeAdapter.unwrap(abstractZyGraph, ProximityRangeCalculator.getGroupMembers((IGroupNode)zyGraphNode.getRawNode())));
            }
            linkedHashSet.addAll(ViewNodeAdapter.unwrap(abstractZyGraph, list3));
            linkedHashSet.addAll(ViewNodeAdapter.unwrap(abstractZyGraph, list4));
        }
        return linkedHashSet;
    }
}

