package com.google.security.zynamics.zylib.types.graphs;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.types.graphs.algorithms.*;
import com.google.security.zynamics.zylib.types.trees.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;
import com.google.common.collect.*;

public class GraphAlgorithms
{
    private static void getPredecessors(final IGraphNode graphNode, final Set set, final Set set2) {
        for (final IGraphNode graphNode2 : graphNode.getParents()) {
            if (set2.contains(graphNode2)) {
                continue;
            }
            set2.add(graphNode2);
            set.add(graphNode2);
            getPredecessors(graphNode2, set, set2);
        }
    }
    
    private static void getPredecessorsInternal(final IGraphNode graphNode, final int n, final List list, final Set set) {
        if (n <= 0) {
            return;
        }
        for (final IGraphNode graphNode2 : graphNode.getParents()) {
            if (set.contains(graphNode2)) {
                continue;
            }
            set.add(graphNode2);
            list.add(graphNode2);
            getPredecessorsInternal(graphNode2, n - 1, list, set);
        }
    }
    
    private static void getSuccessors(final IGraphNode graphNode, final Set set, final Set set2) {
        for (final IGraphNode graphNode2 : graphNode.getChildren()) {
            if (set2.contains(graphNode2)) {
                continue;
            }
            set2.add(graphNode2);
            set.add(graphNode2);
            getSuccessors(graphNode2, set, set2);
        }
    }
    
    private static void getSuccessorsInternal(final IGraphNode graphNode, final int n, final List list, final HashSet set) {
        if (n <= 0) {
            return;
        }
        for (final IGraphNode graphNode2 : graphNode.getChildren()) {
            if (set.contains(graphNode2)) {
                continue;
            }
            set.add(graphNode2);
            list.add(graphNode2);
            getSuccessorsInternal(graphNode2, n - 1, list, set);
        }
    }
    
    public static Collection collectChildren(final IGraphNode graphNode, final INodeFilter nodeFilter) {
        Preconditions.checkNotNull(graphNode, (Object)"Error: Node argument can't be null");
        return collectNodes(graphNode.getChildren(), nodeFilter);
    }
    
    public static Collection collectNodes(final Collection collection, final INodeFilter nodeFilter) {
        Preconditions.checkNotNull(collection, (Object)"Error: Nodes argument can't be null");
        Preconditions.checkNotNull(nodeFilter, (Object)"Error: Filter argument can't be null");
        final ArrayList<Object> list = new ArrayList<Object>();
        for (final Object next : collection) {
            if (nodeFilter.qualifies(next)) {
                list.add(next);
            }
        }
        return list;
    }
    
    public static Collection collectParents(final IGraphNode graphNode, final INodeFilter nodeFilter) {
        Preconditions.checkNotNull(graphNode, (Object)"Error: Node argument can't be null");
        return collectNodes(graphNode.getParents(), nodeFilter);
    }
    
    public static HashMap getBackEdges(final IDirectedGraph directedGraph, final IGraphNode graphNode) {
        Preconditions.checkNotNull(directedGraph, (Object)"Error: Graph argument can not be null");
        Preconditions.checkNotNull(graphNode, (Object)"Error: Root Node argument can not be null");
        final HashMap<IGraphNode, ArrayList<IGraphNode>> hashMap = new HashMap<IGraphNode, ArrayList<IGraphNode>>();
        final Pair calculate = LengauerTarjan.calculate(directedGraph, graphNode);
        final HashMap hashMap2 = (HashMap)calculate.second();
        final HashMap dominateRelation = TreeAlgorithms.getDominateRelation(((Tree)calculate.first()).getRootNode());
        for (final IGraphNode graphNode2 : directedGraph.getNodes()) {
            final ArrayList<IGraphNode> list = new ArrayList<IGraphNode>();
            final Set set = dominateRelation.get(hashMap2.get(graphNode2));
            if (set != null) {
                for (final IGraphNode graphNode3 : graphNode2.getChildren()) {
                    if (set.contains(hashMap2.get(graphNode3))) {
                        list.add(graphNode3);
                    }
                }
            }
            hashMap.put(graphNode2, list);
        }
        return hashMap;
    }
    
    public static ArrayList getGraphLoops(final IDirectedGraph directedGraph) {
        IGraphNode graphNode = null;
        final ArrayList<Set> list = new ArrayList<Set>();
        for (final IGraphNode graphNode2 : directedGraph.getNodes()) {
            if (graphNode2.getParents().size() == 0) {
                graphNode = graphNode2;
                break;
            }
        }
        if (graphNode == null) {
            return null;
        }
        final HashMap backEdges = getBackEdges(directedGraph, graphNode);
        for (final IGraphNode graphNode3 : directedGraph.getNodes()) {
            final Iterator<IGraphNode> iterator3 = backEdges.get(graphNode3).iterator();
            while (iterator3.hasNext()) {
                list.add(getLoopNodes(graphNode3, iterator3.next()));
            }
        }
        return list;
    }
    
    public static Set getLoopNodes(final IGraphNode graphNode, final IGraphNode graphNode2) {
        if (graphNode == graphNode2) {
            final ArrayList<IGraphNode> list = new ArrayList<IGraphNode>();
            list.add(graphNode);
            return new HashSet(list);
        }
        final ArrayList<IGraphNode> list2 = new ArrayList<IGraphNode>();
        list2.add(graphNode2);
        final HashSet set = new HashSet<IGraphNode>(list2);
        final Stack<IGraphNode> stack = new Stack<IGraphNode>();
        stack.push(graphNode);
        while (!stack.empty()) {
            final IGraphNode graphNode3 = stack.pop();
            set.add(graphNode3);
            for (final IGraphNode graphNode4 : graphNode3.getParents()) {
                if (!set.contains(graphNode4)) {
                    set.add(graphNode4);
                    stack.push(graphNode4);
                }
            }
        }
        final HashSet<Object> set2 = new HashSet<Object>(new ArrayList<Object>());
        final Stack<IGraphNode> stack2 = new Stack<IGraphNode>();
        stack2.push(graphNode2);
        while (!stack2.empty()) {
            final IGraphNode graphNode5 = stack2.pop();
            set2.add(graphNode5);
            for (final IGraphNode graphNode6 : graphNode5.getChildren()) {
                if (!set2.contains(graphNode6)) {
                    set2.add(graphNode6);
                    stack2.push(graphNode6);
                }
            }
        }
        set.retainAll(set2);
        return set;
    }
    
    public static Collection getPredecessors(final Collection collection) {
        Preconditions.checkNotNull(collection, (Object)"Error: Nodes argument can't be null");
        final HashSet set = new HashSet();
        final Iterator<IGraphNode> iterator = collection.iterator();
        while (iterator.hasNext()) {
            set.addAll(getPredecessors(iterator.next()));
        }
        return set;
    }
    
    public static Set getPredecessors(final IGraphNode graphNode) {
        Preconditions.checkNotNull(graphNode, (Object)"Error: Start node can't be null");
        final HashSet set = new HashSet();
        getPredecessors(graphNode, set, new HashSet());
        return set;
    }
    
    public static Set getPredecessorsUpToNode(final IGraphNode graphNode, final IGraphNode graphNode2) {
        Preconditions.checkNotNull(graphNode, (Object)"Error: endNode argument can not be null");
        Preconditions.checkNotNull(graphNode2, (Object)"Error: startNode argument can not be null");
        final HashSet hashSet = Sets.newHashSet();
        final HashSet hashSet2 = Sets.newHashSet();
        hashSet2.add(graphNode2);
        getPredecessors(graphNode, hashSet, hashSet2);
        return hashSet;
    }
    
    public static List getPredecessors(final Iterable iterable, final int n) {
        final ArrayList list = new ArrayList();
        final Iterator<IGraphNode> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.addAll(getPredecessors(iterator.next(), n));
        }
        return list;
    }
    
    public static List getPredecessors(final IGraphNode graphNode, final int n) {
        final ArrayList list = new ArrayList();
        getPredecessorsInternal(graphNode, n, list, new HashSet());
        return list;
    }
    
    public static Collection getSuccessors(final Collection collection) {
        Preconditions.checkNotNull(collection, (Object)"Error: Nodes argument can't be null");
        final HashSet set = new HashSet();
        final Iterator<IGraphNode> iterator = collection.iterator();
        while (iterator.hasNext()) {
            set.addAll(getSuccessors(iterator.next()));
        }
        return set;
    }
    
    public static Set getSuccessors(final IGraphNode graphNode) {
        Preconditions.checkNotNull(graphNode, (Object)"Error: Start node can't be null");
        final HashSet set = new HashSet();
        getSuccessors(graphNode, set, new HashSet());
        return set;
    }
    
    public static Set getSuccessorsDownToNode(final IGraphNode graphNode, final IGraphNode graphNode2) {
        Preconditions.checkNotNull(graphNode, (Object)"Error: parent node can't be null");
        Preconditions.checkNotNull(graphNode2, (Object)"Error: maximumChildNode argument can not be null");
        final HashSet set = new HashSet();
        getSuccessors(graphNode, set, new HashSet());
        return set;
    }
    
    public static List getSuccessors(final Iterable iterable, final int n) {
        final ArrayList list = new ArrayList();
        final Iterator<IGraphNode> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.addAll(getSuccessors(iterator.next(), n));
        }
        return list;
    }
    
    public static List getSuccessors(final IGraphNode graphNode, final int n) {
        final ArrayList list = new ArrayList();
        getSuccessorsInternal(graphNode, n, list, new HashSet());
        return list;
    }
    
    public static boolean isRootNode(final IGraphNode graphNode) {
        return graphNode.getParents().size() == 0;
    }
}
