/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.ITreeNode;

public class TreeHelpers {
    private TreeHelpers() {
    }

    public static boolean isAncestor(ITreeNode iTreeNode, ITreeNode iTreeNode2) {
        if (iTreeNode == null) {
            return false;
        }
        if (iTreeNode2 != iTreeNode) return TreeHelpers.isAncestor(iTreeNode.getParent(), iTreeNode2);
        return true;
    }
}

