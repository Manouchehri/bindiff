package com.google.security.zynamics.zylib.types.trees;

import java.util.*;

public class BreadthFirstIterator implements Iterator
{
    private final Queue m_path;
    
    public BreadthFirstIterator(final ITreeNode treeNode) {
        this.m_path = new LinkedList();
        final Iterator<ITreeNode> iterator = treeNode.getChildren().iterator();
        while (iterator.hasNext()) {
            this.m_path.add(iterator.next());
        }
    }
    
    @Override
    public boolean hasNext() {
        return !this.m_path.isEmpty();
    }
    
    @Override
    public ITreeNode next() {
        final ITreeNode treeNode = this.m_path.remove();
        final Iterator iterator = treeNode.getChildren().iterator();
        while (iterator.hasNext()) {
            this.m_path.add(iterator.next());
        }
        return treeNode;
    }
    
    @Override
    public void remove() {
    }
}
