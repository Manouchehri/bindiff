package com.google.security.zynamics.zylib.types.trees;

import java.util.*;

public class TreeNode implements ITreeNode
{
    private ITreeNode m_parent;
    private final List m_children;
    private final Object m_object;
    
    public TreeNode(final Object object) {
        this.m_parent = null;
        this.m_children = new ArrayList();
        this.m_object = object;
    }
    
    @Override
    public void addChild(final ITreeNode treeNode) {
        this.m_children.add(treeNode);
    }
    
    @Override
    public List getChildren() {
        return new ArrayList(this.m_children);
    }
    
    @Override
    public Object getObject() {
        return this.m_object;
    }
    
    @Override
    public ITreeNode getParent() {
        return this.m_parent;
    }
    
    @Override
    public void removeChild(final ITreeNode treeNode) {
        this.m_children.remove(treeNode);
    }
    
    @Override
    public void setParent(final ITreeNode parent) {
        this.m_parent = parent;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.m_object.toString());
        return new StringBuilder(2 + String.valueOf(value).length()).append("<").append(value).append(">").toString();
    }
}
