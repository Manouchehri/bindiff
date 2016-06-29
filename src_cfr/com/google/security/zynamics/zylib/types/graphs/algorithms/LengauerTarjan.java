/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.graphs.algorithms;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.types.graphs.algorithms.MalformedGraphException;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import com.google.security.zynamics.zylib.types.trees.Tree;
import com.google.security.zynamics.zylib.types.trees.TreeNode;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class LengauerTarjan {
    /*
     * Unable to fully structure code
     */
    private static int depthFirstSearch(IGraphNode var0, IGraphNode var1_1, HashMap var2_2, HashMap var3_3, HashMap var4_4, int var5_5) {
        var4_4.put(var1_1, var0);
        var3_3.put(var5_5, var1_1);
        var2_2.put(var1_1, var5_5);
        ++var5_5;
        var6_6 = new Stack<Pair>();
        for (IGraphNode var8_8 : Lists.reverse(var1_1.getChildren())) {
            var6_6.push(new Pair(var8_8, var1_1));
        }
        block1 : do lbl-1000: // 3 sources:
        {
            if (var6_6.empty() != false) return var5_5 - 1;
            var7_7 = (Pair)var6_6.pop();
            var8_8 = (IGraphNode)var7_7.first();
            var9_9 = (IGraphNode)var7_7.second();
            if ((Integer)var2_2.get(var8_8) != -1) ** GOTO lbl-1000
            var2_2.put(var8_8, var5_5);
            var3_3.put(var5_5, var8_8);
            var4_4.put(var8_8, var9_9);
            ++var5_5;
            var10_10 = Lists.reverse(var8_8.getChildren()).iterator();
            do {
                if (!var10_10.hasNext()) continue block1;
                var11_11 = (IGraphNode)var10_10.next();
                var6_6.push(new Pair(var11_11, var8_8));
            } while (true);
            break;
        } while (true);
    }

    private static IGraphNode getAncestorWithLowestSemi(IGraphNode iGraphNode, HashMap hashMap, HashMap hashMap2, HashMap hashMap3, HashMap hashMap4) {
        IGraphNode iGraphNode2 = (IGraphNode)hashMap3.get(iGraphNode);
        if (hashMap3.get(iGraphNode2) == null) return (IGraphNode)hashMap4.get(iGraphNode);
        IGraphNode iGraphNode3 = LengauerTarjan.getAncestorWithLowestSemi(iGraphNode2, hashMap, hashMap2, hashMap3, hashMap4);
        hashMap3.put(iGraphNode, hashMap3.get(iGraphNode2));
        if ((Integer)hashMap.get(hashMap2.get(iGraphNode3)) >= (Integer)hashMap.get(hashMap2.get(hashMap4.get(iGraphNode)))) return (IGraphNode)hashMap4.get(iGraphNode);
        hashMap4.put(iGraphNode, iGraphNode3);
        return (IGraphNode)hashMap4.get(iGraphNode);
    }

    private static void link(IGraphNode iGraphNode, IGraphNode iGraphNode2, HashMap hashMap, HashMap hashMap2) {
        hashMap.put(iGraphNode2, iGraphNode);
        hashMap2.put(iGraphNode2, iGraphNode2);
    }

    public static Pair calculate(Collection collection, IGraphNode iGraphNode) {
        int n2;
        Object object22;
        Preconditions.checkNotNull(collection, "Error: Nodes argument can not be null");
        if (collection.size() == 0) {
            return new Pair(null, null);
        }
        Preconditions.checkNotNull(iGraphNode, "Error: Root node argument can not be null");
        Preconditions.checkArgument(collection.contains(iGraphNode), "Error: Root node is not part of the graph");
        int n3 = 0;
        for (Object object22 : collection) {
            if (object22.getParents().size() != 0) continue;
            ++n3;
        }
        if (n3 > 1) {
            throw new MalformedGraphException("Error: Can not calculate dominator trees for graphs with more than one entry node");
        }
        HashMap hashMap = new HashMap();
        object22 = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap<Object, Object> hashMap3 = new HashMap<Object, Object>();
        HashMap<IGraphNode, Object> hashMap4 = new HashMap<IGraphNode, Object>();
        HashMap<IGraphNode, IGraphNode> hashMap5 = new HashMap<IGraphNode, IGraphNode>();
        HashMap hashMap6 = new HashMap();
        HashMap hashMap7 = new HashMap();
        HashMap<IGraphNode, Integer> hashMap8 = new HashMap<IGraphNode, Integer>();
        for (IGraphNode iGraphNode2 : collection) {
            hashMap.put(iGraphNode2, new HashSet());
            hashMap8.put(iGraphNode2, -1);
            hashMap3.put(iGraphNode2, null);
            hashMap4.put(iGraphNode2, null);
            object22.put(iGraphNode2, null);
            hashMap5.put(iGraphNode2, null);
        }
        int n4 = n2 = LengauerTarjan.depthFirstSearch(null, iGraphNode, hashMap8, hashMap6, hashMap7, 0);
        do {
            IGraphNode iGraphNode3;
            Iterator iterator;
            void iterator32;
            Iterator iterator2;
            Object object3;
            IGraphNode iGraphNode42;
            if (n4 >= 1) {
                object3 = (IGraphNode)hashMap6.get(n4);
                Iterator iterator3 = iterator2 = (IGraphNode)hashMap7.get(object3);
                iterator = object3.getParents().iterator();
            } else {
                for (n4 = 1; n4 <= n2; ++n4) {
                    object3 = (IGraphNode)hashMap6.get(n4);
                    if (hashMap5.get(object3) == null) continue;
                    object22.put(object3, object22.get(hashMap5.get(object3)));
                }
                Iterator iterator4 = null;
                object3 = new HashMap();
                for (Map.Entry entry : object22.entrySet()) {
                    iterator = new TreeNode(entry.getKey());
                    object3.put(entry.getKey(), iterator);
                    if (entry.getValue() != null) continue;
                    iterator4 = iterator;
                }
                iterator2 = object22.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map.Entry entry2 = iterator2.next();
                    iterator = (IGraphNode)entry2.getKey();
                    iGraphNode42 = (IGraphNode)entry2.getValue();
                    if (iGraphNode42 == null) continue;
                    ((ITreeNode)object3.get(iGraphNode42)).addChild((ITreeNode)object3.get(iterator));
                    ((ITreeNode)object3.get(iterator)).setParent((ITreeNode)object3.get(iGraphNode42));
                }
                return new Pair(new Tree((ITreeNode)((Object)iterator4)), object3);
            }
            while (iterator.hasNext()) {
                iGraphNode42 = (IGraphNode)iterator.next();
                iGraphNode3 = null;
                iGraphNode3 = (Integer)hashMap8.get(iGraphNode42) <= (Integer)hashMap8.get(object3) ? iGraphNode42 : (IGraphNode)hashMap3.get(LengauerTarjan.getAncestorWithLowestSemi(iGraphNode42, hashMap8, hashMap3, hashMap4, hashMap2));
                if ((Integer)hashMap8.get(iGraphNode3) >= (Integer)hashMap8.get(iterator32)) continue;
                IGraphNode iGraphNode5 = iGraphNode3;
            }
            hashMap3.put(object3, iterator32);
            ((Set)hashMap.get(iterator32)).add(object3);
            LengauerTarjan.link(iterator2, (IGraphNode)object3, hashMap4, hashMap2);
            for (IGraphNode iGraphNode42 : (Set)hashMap.get(iterator2)) {
                iGraphNode3 = LengauerTarjan.getAncestorWithLowestSemi(iGraphNode42, hashMap8, hashMap3, hashMap4, hashMap2);
                if (hashMap3.get(iGraphNode3) == hashMap3.get(iGraphNode42)) {
                    object22.put(iGraphNode42, iterator2);
                    continue;
                }
                hashMap5.put(iGraphNode42, iGraphNode3);
            }
            ((Set)hashMap.get(iterator2)).clear();
            --n4;
        } while (true);
    }

    public static Pair calculate(IDirectedGraph iDirectedGraph, IGraphNode iGraphNode) {
        Preconditions.checkNotNull(iDirectedGraph, "Error: Graph argument can not be null");
        Preconditions.checkNotNull(iGraphNode, "Error: Root node argument can not be null");
        if (iDirectedGraph.nodeCount() != 0) return LengauerTarjan.calculate(iDirectedGraph.getNodes(), iGraphNode);
        return new Pair(null, null);
    }
}

