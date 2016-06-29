/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.trees;

import com.google.common.collect.Sets;
import com.google.security.zynamics.zylib.types.trees.DepthFirstIterator;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TreeAlgorithms {
    public static boolean dominates(ITreeNode iTreeNode, ITreeNode iTreeNode2, ITreeNode iTreeNode3) {
        ITreeNode iTreeNode4;
        if (iTreeNode.getObject() == iTreeNode3) {
            return false;
        }
        if (iTreeNode.getObject() == iTreeNode2) {
            return true;
        }
        Iterator iterator = iTreeNode.getChildren().iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (TreeAlgorithms.dominates(iTreeNode4 = (ITreeNode)iterator.next(), iTreeNode2, iTreeNode3));
        return false;
    }

    public static HashMap getDominateRelation(ITreeNode iTreeNode) {
        HashMap<ITreeNode, HashSet> hashMap = new HashMap<ITreeNode, HashSet>();
        HashSet<ITreeNode> hashSet = new HashSet<ITreeNode>();
        hashSet.add(iTreeNode);
        hashMap.put(iTreeNode, hashSet);
        DepthFirstIterator depthFirstIterator = new DepthFirstIterator(iTreeNode);
        while (depthFirstIterator.hasNext()) {
            ITreeNode iTreeNode2 = depthFirstIterator.next();
            ITreeNode iTreeNode3 = iTreeNode2.getParent();
            HashSet hashSet2 = Sets.newHashSet((Iterable)hashMap.get(iTreeNode3));
            hashSet2.add(iTreeNode3);
            hashSet2.add(iTreeNode2);
            hashMap.put(iTreeNode2, hashSet2);
        }
        return hashMap;
    }
}

