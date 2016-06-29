package com.google.security.zynamics.zylib.types.trees;

import java.util.*;
import com.google.common.base.*;

public class DepthFirstIterator implements Iterator
{
    private final Stack m_path;
    
    public DepthFirstIterator(final ITreeNode treeNode) {
        this.m_path = new Stack();
        Preconditions.checkNotNull(treeNode, (Object)"Error: Root node argument can not be null");
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
        final ITreeNode treeNode = this.m_path.pop();
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
