/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.ITreeNode;

public class Tree {
    private final ITreeNode m_rootNode;

    public Tree(ITreeNode iTreeNode) {
        this.m_rootNode = iTreeNode;
    }

    public ITreeNode getRootNode() {
        return this.m_rootNode;
    }
}

