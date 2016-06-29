package com.google.security.zynamics.zylib.types.trees;

import java.util.*;
import com.google.common.collect.*;

public class TreeAlgorithms
{
    public static boolean dominates(final ITreeNode treeNode, final ITreeNode treeNode2, final ITreeNode treeNode3) {
        if (treeNode.getObject() == treeNode3) {
            return false;
        }
        if (treeNode.getObject() == treeNode2) {
            return true;
        }
        final Iterator<ITreeNode> iterator = treeNode.getChildren().iterator();
        while (iterator.hasNext()) {
            if (!dominates(iterator.next(), treeNode2, treeNode3)) {
                return false;
            }
        }
        return true;
    }
    
    public static HashMap getDominateRelation(final ITreeNode treeNode) {
        final HashMap<ITreeNode, HashSet<ITreeNode>> hashMap = new HashMap<ITreeNode, HashSet<ITreeNode>>();
        final HashSet<ITreeNode> set = new HashSet<ITreeNode>();
        set.add(treeNode);
        hashMap.put(treeNode, set);
        final DepthFirstIterator depthFirstIterator = new DepthFirstIterator(treeNode);
        while (depthFirstIterator.hasNext()) {
            final ITreeNode next = depthFirstIterator.next();
            final ITreeNode parent = next.getParent();
            final HashSet hashSet = Sets.newHashSet(hashMap.get(parent));
            hashSet.add(parent);
            hashSet.add(next);
            hashMap.put(next, hashSet);
        }
        return hashMap;
    }
}
