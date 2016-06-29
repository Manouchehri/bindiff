/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.graphs;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.types.graphs.algorithms.LengauerTarjan;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import com.google.security.zynamics.zylib.types.trees.Tree;
import com.google.security.zynamics.zylib.types.trees.TreeAlgorithms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GraphAlgorithms {
    private GraphAlgorithms() {
    }

    private static void getPredecessors(IGraphNode iGraphNode, Set set, Set set2) {
        Iterator iterator = iGraphNode.getParents().iterator();
        while (iterator.hasNext()) {
            IGraphNode iGraphNode2 = (IGraphNode)iterator.next();
            if (set2.contains(iGraphNode2)) continue;
            set2.add(iGraphNode2);
            set.add(iGraphNode2);
            GraphAlgorithms.getPredecessors(iGraphNode2, set, set2);
        }
    }

    private static void getPredecessorsInternal(IGraphNode iGraphNode, int n2, List list, Set set) {
        if (n2 <= 0) {
            return;
        }
        Iterator iterator = iGraphNode.getParents().iterator();
        while (iterator.hasNext()) {
            IGraphNode iGraphNode2 = (IGraphNode)iterator.next();
            if (set.contains(iGraphNode2)) continue;
            set.add(iGraphNode2);
            list.add(iGraphNode2);
            GraphAlgorithms.getPredecessorsInternal(iGraphNode2, n2 - 1, list, set);
        }
    }

    private static void getSuccessors(IGraphNode iGraphNode, Set set, Set set2) {
        Iterator iterator = iGraphNode.getChildren().iterator();
        while (iterator.hasNext()) {
            IGraphNode iGraphNode2 = (IGraphNode)iterator.next();
            if (set2.contains(iGraphNode2)) continue;
            set2.add(iGraphNode2);
            set.add(iGraphNode2);
            GraphAlgorithms.getSuccessors(iGraphNode2, set, set2);
        }
    }

    private static void getSuccessorsInternal(IGraphNode iGraphNode, int n2, List list, HashSet hashSet) {
        if (n2 <= 0) {
            return;
        }
        Iterator iterator = iGraphNode.getChildren().iterator();
        while (iterator.hasNext()) {
            IGraphNode iGraphNode2 = (IGraphNode)iterator.next();
            if (hashSet.contains(iGraphNode2)) continue;
            hashSet.add(iGraphNode2);
            list.add(iGraphNode2);
            GraphAlgorithms.getSuccessorsInternal(iGraphNode2, n2 - 1, list, hashSet);
        }
    }

    public static Collection collectChildren(IGraphNode iGraphNode, INodeFilter iNodeFilter) {
        Preconditions.checkNotNull(iGraphNode, "Error: Node argument can't be null");
        return GraphAlgorithms.collectNodes(iGraphNode.getChildren(), iNodeFilter);
    }

    public static Collection collectNodes(Collection collection, INodeFilter iNodeFilter) {
        Preconditions.checkNotNull(collection, "Error: Nodes argument can't be null");
        Preconditions.checkNotNull(iNodeFilter, "Error: Filter argument can't be null");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (!iNodeFilter.qualifies(e2)) continue;
            arrayList.add(e2);
        }
        return arrayList;
    }

    public static Collection collectParents(IGraphNode iGraphNode, INodeFilter iNodeFilter) {
        Preconditions.checkNotNull(iGraphNode, "Error: Node argument can't be null");
        return GraphAlgorithms.collectNodes(iGraphNode.getParents(), iNodeFilter);
    }

    public static HashMap getBackEdges(IDirectedGraph iDirectedGraph, IGraphNode iGraphNode) {
        Preconditions.checkNotNull(iDirectedGraph, "Error: Graph argument can not be null");
        Preconditions.checkNotNull(iGraphNode, "Error: Root Node argument can not be null");
        HashMap hashMap = new HashMap();
        Pair pair = LengauerTarjan.calculate(iDirectedGraph, iGraphNode);
        HashMap hashMap2 = (HashMap)pair.second();
        HashMap hashMap3 = TreeAlgorithms.getDominateRelation(((Tree)pair.first()).getRootNode());
        Iterator iterator = iDirectedGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            IGraphNode iGraphNode2 = (IGraphNode)iterator.next();
            ArrayList<IGraphNode> arrayList = new ArrayList<IGraphNode>();
            Set set = (Set)hashMap3.get(hashMap2.get(iGraphNode2));
            if (set != null) {
                for (IGraphNode iGraphNode3 : iGraphNode2.getChildren()) {
                    if (!set.contains(hashMap2.get(iGraphNode3))) continue;
                    arrayList.add(iGraphNode3);
                }
            }
            hashMap.put(iGraphNode2, arrayList);
        }
        return hashMap;
    }

    public static ArrayList getGraphLoops(IDirectedGraph iDirectedGraph) {
        Object object2;
        IGraphNode iGraphNode = null;
        ArrayList<Set> arrayList = new ArrayList<Set>();
        for (Object object2 : iDirectedGraph.getNodes()) {
            if (object2.getParents().size() != 0) continue;
            iGraphNode = object2;
            break;
        }
        if (iGraphNode == null) {
            return null;
        }
        HashMap hashMap = GraphAlgorithms.getBackEdges(iDirectedGraph, iGraphNode);
        object2 = iDirectedGraph.getNodes().iterator();
        block1 : while (object2.hasNext()) {
            IGraphNode iGraphNode2 = (IGraphNode)object2.next();
            ArrayList arrayList2 = (ArrayList)hashMap.get(iGraphNode2);
            Iterator iterator = arrayList2.iterator();
            do {
                if (!iterator.hasNext()) continue block1;
                IGraphNode iGraphNode3 = (IGraphNode)iterator.next();
                arrayList.add(GraphAlgorithms.getLoopNodes(iGraphNode2, iGraphNode3));
            } while (true);
            break;
        }
        return arrayList;
    }

    public static Set getLoopNodes(IGraphNode iGraphNode, IGraphNode iGraphNode2) {
        Object object3;
        Object object2;
        if (iGraphNode == iGraphNode2) {
            ArrayList<IGraphNode> arrayList = new ArrayList<IGraphNode>();
            arrayList.add(iGraphNode);
            return new HashSet(arrayList);
        }
        ArrayList<IGraphNode> arrayList = new ArrayList<IGraphNode>();
        arrayList.add(iGraphNode2);
        HashSet<Object> hashSet = new HashSet<Object>(arrayList);
        Stack<Object> stack = new Stack<Object>();
        stack.push(iGraphNode);
        while (!stack.empty()) {
            object2 = (IGraphNode)stack.pop();
            hashSet.add(object2);
            for (Object object3 : object2.getParents()) {
                if (hashSet.contains(object3)) continue;
                hashSet.add(object3);
                stack.push(object3);
            }
        }
        object2 = new ArrayList();
        HashSet hashSet2 = new HashSet(object2);
        object3 = new Stack<IGraphNode>();
        object3.push((IGraphNode)iGraphNode2);
        block2 : do {
            if (object3.empty()) {
                hashSet.retainAll(hashSet2);
                return hashSet;
            }
            IGraphNode iGraphNode3 = (IGraphNode)object3.pop();
            hashSet2.add(iGraphNode3);
            Iterator iterator = iGraphNode3.getChildren().iterator();
            do {
                if (!iterator.hasNext()) continue block2;
                IGraphNode iGraphNode4 = (IGraphNode)iterator.next();
                if (hashSet2.contains(iGraphNode4)) continue;
                hashSet2.add(iGraphNode4);
                object3.push(iGraphNode4);
            } while (true);
            break;
        } while (true);
    }

    public static Collection getPredecessors(Collection collection) {
        Preconditions.checkNotNull(collection, "Error: Nodes argument can't be null");
        HashSet hashSet = new HashSet();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            IGraphNode iGraphNode = (IGraphNode)iterator.next();
            hashSet.addAll(GraphAlgorithms.getPredecessors(iGraphNode));
        }
        return hashSet;
    }

    public static Set getPredecessors(IGraphNode iGraphNode) {
        Preconditions.checkNotNull(iGraphNode, "Error: Start node can't be null");
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        GraphAlgorithms.getPredecessors(iGraphNode, hashSet, hashSet2);
        return hashSet;
    }

    public static Set getPredecessorsUpToNode(IGraphNode iGraphNode, IGraphNode iGraphNode2) {
        Preconditions.checkNotNull(iGraphNode, "Error: endNode argument can not be null");
        Preconditions.checkNotNull(iGraphNode2, "Error: startNode argument can not be null");
        HashSet hashSet = Sets.newHashSet();
        HashSet hashSet2 = Sets.newHashSet();
        hashSet2.add(iGraphNode2);
        GraphAlgorithms.getPredecessors(iGraphNode, hashSet, hashSet2);
        return hashSet;
    }

    public static List getPredecessors(Iterable iterable, int n2) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            IGraphNode iGraphNode = (IGraphNode)iterator.next();
            arrayList.addAll(GraphAlgorithms.getPredecessors(iGraphNode, n2));
        }
        return arrayList;
    }

    public static List getPredecessors(IGraphNode iGraphNode, int n2) {
        ArrayList arrayList = new ArrayList();
        GraphAlgorithms.getPredecessorsInternal(iGraphNode, n2, arrayList, new HashSet());
        return arrayList;
    }

    public static Collection getSuccessors(Collection collection) {
        Preconditions.checkNotNull(collection, "Error: Nodes argument can't be null");
        HashSet hashSet = new HashSet();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            IGraphNode iGraphNode = (IGraphNode)iterator.next();
            hashSet.addAll(GraphAlgorithms.getSuccessors(iGraphNode));
        }
        return hashSet;
    }

    public static Set getSuccessors(IGraphNode iGraphNode) {
        Preconditions.checkNotNull(iGraphNode, "Error: Start node can't be null");
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        GraphAlgorithms.getSuccessors(iGraphNode, hashSet, hashSet2);
        return hashSet;
    }

    public static Set getSuccessorsDownToNode(IGraphNode iGraphNode, IGraphNode iGraphNode2) {
        Preconditions.checkNotNull(iGraphNode, "Error: parent node can't be null");
        Preconditions.checkNotNull(iGraphNode2, "Error: maximumChildNode argument can not be null");
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        GraphAlgorithms.getSuccessors(iGraphNode, hashSet, hashSet2);
        return hashSet;
    }

    public static List getSuccessors(Iterable iterable, int n2) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            IGraphNode iGraphNode = (IGraphNode)iterator.next();
            arrayList.addAll(GraphAlgorithms.getSuccessors(iGraphNode, n2));
        }
        return arrayList;
    }

    public static List getSuccessors(IGraphNode iGraphNode, int n2) {
        ArrayList arrayList = new ArrayList();
        GraphAlgorithms.getSuccessorsInternal(iGraphNode, n2, arrayList, new HashSet());
        return arrayList;
    }

    public static boolean isRootNode(IGraphNode iGraphNode) {
        if (iGraphNode.getParents().size() != 0) return false;
        return true;
    }
}

