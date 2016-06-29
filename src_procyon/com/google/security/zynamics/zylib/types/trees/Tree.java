package com.google.security.zynamics.zylib.types.trees;

public class Tree
{
    private final ITreeNode m_rootNode;
    
    public Tree(final ITreeNode rootNode) {
        this.m_rootNode = rootNode;
    }
    
    public ITreeNode getRootNode() {
        return this.m_rootNode;
    }
}
