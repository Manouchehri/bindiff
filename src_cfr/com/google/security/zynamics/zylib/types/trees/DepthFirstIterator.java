/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.trees;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DepthFirstIterator
implements Iterator {
    private final Stack m_path = new Stack();

    public DepthFirstIterator(ITreeNode iTreeNode) {
        Preconditions.checkNotNull(iTreeNode, "Error: Root node argument can not be null");
        Iterator iterator = iTreeNode.getChildren().iterator();
        while (iterator.hasNext()) {
            ITreeNode iTreeNode2 = (ITreeNode)iterator.next();
            this.m_path.add(iTreeNode2);
        }
    }

    @Override
    public boolean hasNext() {
        if (this.m_path.isEmpty()) return false;
        return true;
    }

    public ITreeNode next() {
        ITreeNode iTreeNode = (ITreeNode)this.m_path.pop();
        Iterator iterator = iTreeNode.getChildren().iterator();
        while (iterator.hasNext()) {
            ITreeNode iTreeNode2 = (ITreeNode)iterator.next();
            this.m_path.add(iTreeNode2);
        }
        return iTreeNode;
    }

    @Override
    public void remove() {
    }
}

