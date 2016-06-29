package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.wrappers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.common.base.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.common.collect.*;

public final class ProximityRangeCalculator
{
    private static Set getGroupMembers(final IGroupNode groupNode) {
        final HashSet<ViewNodeAdapter> set = new HashSet<ViewNodeAdapter>();
        final Iterator<IViewNode> iterator = groupNode.getElements().iterator();
        while (iterator.hasNext()) {
            set.add(new ViewNodeAdapter(iterator.next()));
        }
        return set;
    }
    
    private static Set getParentGroups(final ZyGraphNode zyGraphNode) {
        final HashSet<ViewNodeAdapter> set = new HashSet<ViewNodeAdapter>();
        for (IGroupNode groupNode = zyGraphNode.getRawNode().getParentGroup(); groupNode != null; groupNode = groupNode.getParentGroup()) {
            set.add(new ViewNodeAdapter(groupNode));
        }
        return set;
    }
    
    private static List getPredecessors(final Iterable iterable, final int n) {
        final ArrayList list = new ArrayList();
        final Iterator<ViewNodeAdapter> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.addAll(getPredecessors(iterator.next(), n));
        }
        return list;
    }
    
    private static Set getPredecessors(final ViewNodeAdapter viewNodeAdapter, final int n) {
        final HashSet set = new HashSet();
        getPredecessorsInternal(viewNodeAdapter, n, set, new HashSet());
        return set;
    }
    
    private static void getPredecessorsInternal(final ViewNodeAdapter viewNodeAdapter, final int n, final Set set, final Set set2) {
        for (final ViewNodeAdapter viewNodeAdapter2 : viewNodeAdapter.getParents()) {
            if (n <= 0 && !(viewNodeAdapter2.getNode() instanceof ITextNode)) {
                continue;
            }
            if (viewNodeAdapter2.getNode().getParentGroup() != null) {
                IGroupNode groupNode = viewNodeAdapter2.getNode().getParentGroup();
                while (groupNode != null) {
                    if (!visited(set2, groupNode)) {
                        final ViewNodeAdapter viewNodeAdapter3 = new ViewNodeAdapter(groupNode);
                        set2.add(viewNodeAdapter3);
                        set.add(viewNodeAdapter3);
                        groupNode = groupNode.getParentGroup();
                    }
                    else {
                        groupNode = null;
                    }
                }
            }
            set2.add(viewNodeAdapter2);
            set.add(viewNodeAdapter2);
            getSuccessorsInternal(viewNodeAdapter2, -1, set, new HashSet());
            getPredecessorsInternal(viewNodeAdapter2, n - 1, set, set2);
        }
    }
    
    private static int getRealDepth(final int n) {
        return (n == -1) ? Integer.MAX_VALUE : n;
    }
    
    private static List getSuccessors(final Iterable iterable, final int n) {
        final ArrayList list = new ArrayList();
        final Iterator<ViewNodeAdapter> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.addAll(getSuccessors(iterator.next(), n));
        }
        return list;
    }
    
    private static Set getSuccessors(final ViewNodeAdapter viewNodeAdapter, final int n) {
        final HashSet set = new HashSet();
        getSuccessorsInternal(viewNodeAdapter, n, set, new HashSet());
        return set;
    }
    
    private static void getSuccessorsInternal(final ViewNodeAdapter viewNodeAdapter, final int n, final Set set, final HashSet set2) {
        for (final ViewNodeAdapter viewNodeAdapter2 : viewNodeAdapter.getChildren()) {
            if (n <= 0 && !(viewNodeAdapter2.getNode() instanceof ITextNode)) {
                continue;
            }
            if (viewNodeAdapter2.getNode().getParentGroup() != null) {
                IGroupNode groupNode = viewNodeAdapter2.getNode().getParentGroup();
                while (groupNode != null) {
                    if (!visited(set2, groupNode)) {
                        final ViewNodeAdapter viewNodeAdapter3 = new ViewNodeAdapter(groupNode);
                        set2.add(viewNodeAdapter3);
                        set.add(viewNodeAdapter3);
                        groupNode = groupNode.getParentGroup();
                    }
                    else {
                        groupNode = null;
                    }
                }
            }
            if (NodeHelpers.getVisibleNode(viewNodeAdapter2.getNode()) != viewNodeAdapter2.getNode()) {
                continue;
            }
            set2.add(viewNodeAdapter2);
            set.add(viewNodeAdapter2);
            getPredecessorsInternal(viewNodeAdapter2, -1, set, new HashSet());
            getSuccessorsInternal(viewNodeAdapter2, n - 1, set, set2);
        }
    }
    
    private static boolean visited(final Set set, final IGroupNode groupNode) {
        return CollectionHelpers.any(set, new ProximityRangeCalculator$1(groupNode));
    }
    
    public static Set getNeighbors(final AbstractZyGraph abstractZyGraph, final Collection collection, final int n, final int n2) {
        Preconditions.checkNotNull(abstractZyGraph, (Object)"Graph argument can not be null");
        Preconditions.checkNotNull(collection, (Object)"Nodes argument can not be null");
        final LinkedHashSet set = new LinkedHashSet(collection);
        for (final ZyGraphNode zyGraphNode : collection) {
            final ArrayList<ZyGraphNode> list = new ArrayList<ZyGraphNode>();
            list.add(zyGraphNode);
            final List wrap = ViewNodeAdapter.wrap(Lists.newArrayList(GraphConverters.convert(list)));
            final List predecessors = getPredecessors(wrap, getRealDepth(n2));
            final List successors = getSuccessors(wrap, getRealDepth(n));
            set.addAll(ViewNodeAdapter.unwrap(abstractZyGraph, getParentGroups(zyGraphNode)));
            if (zyGraphNode.getRawNode() instanceof IGroupNode && zyGraphNode.isSelected()) {
                set.addAll(ViewNodeAdapter.unwrap(abstractZyGraph, getGroupMembers((IGroupNode)zyGraphNode.getRawNode())));
            }
            set.addAll(ViewNodeAdapter.unwrap(abstractZyGraph, predecessors));
            set.addAll(ViewNodeAdapter.unwrap(abstractZyGraph, successors));
        }
        return set;
    }
}
