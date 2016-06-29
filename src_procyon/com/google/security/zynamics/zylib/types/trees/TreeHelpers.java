package com.google.security.zynamics.zylib.types.trees;

public class TreeHelpers
{
    public static boolean isAncestor(final ITreeNode treeNode, final ITreeNode treeNode2) {
        return treeNode != null && (treeNode2 == treeNode || isAncestor(treeNode.getParent(), treeNode2));
    }
}
