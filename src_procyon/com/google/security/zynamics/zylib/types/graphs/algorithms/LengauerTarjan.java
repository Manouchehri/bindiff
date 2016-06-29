package com.google.security.zynamics.zylib.types.graphs.algorithms;

import com.google.security.zynamics.zylib.general.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import java.util.*;
import com.google.security.zynamics.zylib.types.trees.*;
import com.google.security.zynamics.zylib.types.graphs.*;

public final class LengauerTarjan
{
    private static int depthFirstSearch(final IGraphNode graphNode, final IGraphNode graphNode2, final HashMap hashMap, final HashMap hashMap2, final HashMap hashMap3, int n) {
        hashMap3.put(graphNode2, graphNode);
        hashMap2.put(n, graphNode2);
        hashMap.put(graphNode2, n);
        ++n;
        final Stack<Pair> stack = new Stack<Pair>();
        final Iterator<IGraphNode> iterator = Lists.reverse(graphNode2.getChildren()).iterator();
        while (iterator.hasNext()) {
            stack.push(new Pair(iterator.next(), graphNode2));
        }
        while (!stack.empty()) {
            final Pair pair = stack.pop();
            final IGraphNode graphNode3 = (IGraphNode)pair.first();
            final IGraphNode graphNode4 = (IGraphNode)pair.second();
            if (hashMap.get(graphNode3) == -1) {
                hashMap.put(graphNode3, n);
                hashMap2.put(n, graphNode3);
                hashMap3.put(graphNode3, graphNode4);
                ++n;
                final Iterator iterator2 = Lists.reverse(graphNode3.getChildren()).iterator();
                while (iterator2.hasNext()) {
                    stack.push(new Pair(iterator2.next(), graphNode3));
                }
            }
        }
        return n - 1;
    }
    
    private static IGraphNode getAncestorWithLowestSemi(final IGraphNode graphNode, final HashMap hashMap, final HashMap hashMap2, final HashMap hashMap3, final HashMap hashMap4) {
        final IGraphNode graphNode2 = hashMap3.get(graphNode);
        if (hashMap3.get(graphNode2) != null) {
            final IGraphNode ancestorWithLowestSemi = getAncestorWithLowestSemi(graphNode2, hashMap, hashMap2, hashMap3, hashMap4);
            hashMap3.put(graphNode, hashMap3.get(graphNode2));
            if (hashMap.get(hashMap2.get(ancestorWithLowestSemi)) < hashMap.get(hashMap2.get(hashMap4.get(graphNode)))) {
                hashMap4.put(graphNode, ancestorWithLowestSemi);
            }
        }
        return hashMap4.get(graphNode);
    }
    
    private static void link(final IGraphNode graphNode, final IGraphNode graphNode2, final HashMap hashMap, final HashMap hashMap2) {
        hashMap.put(graphNode2, graphNode);
        hashMap2.put(graphNode2, graphNode2);
    }
    
    public static Pair calculate(final Collection collection, final IGraphNode graphNode) {
        Preconditions.checkNotNull(collection, (Object)"Error: Nodes argument can not be null");
        if (collection.size() == 0) {
            return new Pair(null, null);
        }
        Preconditions.checkNotNull(graphNode, (Object)"Error: Root node argument can not be null");
        Preconditions.checkArgument(collection.contains(graphNode), (Object)"Error: Root node is not part of the graph");
        int n = 0;
        final Iterator<IGraphNode> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getParents().size() == 0) {
                ++n;
            }
        }
        if (n > 1) {
            throw new MalformedGraphException("Error: Can not calculate dominator trees for graphs with more than one entry node");
        }
        final HashMap<IGraphNode, HashSet<IGraphNode>> hashMap = new HashMap<IGraphNode, HashSet<IGraphNode>>();
        final HashMap<IGraphNode, IGraphNode> hashMap2 = new HashMap<IGraphNode, IGraphNode>();
        final HashMap hashMap3 = new HashMap();
        final HashMap<IGraphNode, IGraphNode> hashMap4 = new HashMap<IGraphNode, IGraphNode>();
        final HashMap<IGraphNode, Object> hashMap5 = new HashMap<IGraphNode, Object>();
        final HashMap<IGraphNode, IGraphNode> hashMap6 = new HashMap<IGraphNode, IGraphNode>();
        final HashMap<Object, IGraphNode> hashMap7 = new HashMap<Object, IGraphNode>();
        final HashMap<Object, IGraphNode> hashMap8 = new HashMap<Object, IGraphNode>();
        final HashMap<IGraphNode, Integer> hashMap9 = new HashMap<IGraphNode, Integer>();
        for (final IGraphNode graphNode2 : collection) {
            hashMap.put(graphNode2, new HashSet<IGraphNode>());
            hashMap9.put(graphNode2, -1);
            hashMap4.put(graphNode2, null);
            hashMap5.put(graphNode2, null);
            hashMap2.put(graphNode2, null);
            hashMap6.put(graphNode2, null);
        }
        int i;
        int n2;
        for (n2 = (i = depthFirstSearch(null, graphNode, hashMap9, hashMap7, hashMap8, 0)); i >= 1; --i) {
            final IGraphNode graphNode3 = hashMap7.get(i);
            IGraphNode graphNode5;
            final IGraphNode graphNode4 = graphNode5 = hashMap8.get(graphNode3);
            for (final IGraphNode graphNode6 : graphNode3.getParents()) {
                IGraphNode graphNode7;
                if (hashMap9.get(graphNode6) <= hashMap9.get(graphNode3)) {
                    graphNode7 = graphNode6;
                }
                else {
                    graphNode7 = hashMap4.get(getAncestorWithLowestSemi(graphNode6, hashMap9, hashMap4, hashMap5, hashMap3));
                }
                if (hashMap9.get(graphNode7) < hashMap9.get(graphNode5)) {
                    graphNode5 = graphNode7;
                }
            }
            hashMap4.put(graphNode3, graphNode5);
            hashMap.get(graphNode5).add(graphNode3);
            link(graphNode4, graphNode3, hashMap5, hashMap3);
            for (final IGraphNode graphNode8 : hashMap.get(graphNode4)) {
                final IGraphNode ancestorWithLowestSemi = getAncestorWithLowestSemi(graphNode8, hashMap9, hashMap4, hashMap5, hashMap3);
                if (hashMap4.get(ancestorWithLowestSemi) == hashMap4.get(graphNode8)) {
                    hashMap2.put(graphNode8, graphNode4);
                }
                else {
                    hashMap6.put(graphNode8, ancestorWithLowestSemi);
                }
            }
            hashMap.get(graphNode4).clear();
        }
        for (int j = 1; j <= n2; ++j) {
            final IGraphNode graphNode9 = hashMap7.get(j);
            if (hashMap6.get(graphNode9) != null) {
                hashMap2.put(graphNode9, hashMap2.get(hashMap6.get(graphNode9)));
            }
        }
        ITreeNode treeNode = null;
        final HashMap<IGraphNode, TreeNode> hashMap10 = new HashMap<IGraphNode, TreeNode>();
        for (final Map.Entry<IGraphNode, IGraphNode> entry : hashMap2.entrySet()) {
            final TreeNode treeNode2 = new TreeNode(entry.getKey());
            hashMap10.put(entry.getKey(), treeNode2);
            if (entry.getValue() == null) {
                treeNode = treeNode2;
            }
        }
        for (final Map.Entry<IGraphNode, IGraphNode> entry2 : hashMap2.entrySet()) {
            final IGraphNode graphNode10 = entry2.getKey();
            final IGraphNode graphNode11 = entry2.getValue();
            if (graphNode11 != null) {
                hashMap10.get(graphNode11).addChild(hashMap10.get(graphNode10));
                hashMap10.get(graphNode10).setParent(hashMap10.get(graphNode11));
            }
        }
        return new Pair(new Tree(treeNode), hashMap10);
    }
    
    public static Pair calculate(final IDirectedGraph directedGraph, final IGraphNode graphNode) {
        Preconditions.checkNotNull(directedGraph, (Object)"Error: Graph argument can not be null");
        Preconditions.checkNotNull(graphNode, (Object)"Error: Root node argument can not be null");
        if (directedGraph.nodeCount() == 0) {
            return new Pair(null, null);
        }
        return calculate(directedGraph.getNodes(), graphNode);
    }
}
