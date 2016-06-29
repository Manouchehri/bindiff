/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstIterator
implements Iterator {
    private final Queue m_path = new LinkedList();

    public BreadthFirstIterator(ITreeNode iTreeNode) {
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
        ITreeNode iTreeNode = (ITreeNode)this.m_path.remove();
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

