/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TreeNode
implements ITreeNode {
    private ITreeNode m_parent = null;
    private final List m_children = new ArrayList();
    private final Object m_object;

    public TreeNode(Object object) {
        this.m_object = object;
    }

    @Override
    public void addChild(ITreeNode iTreeNode) {
        this.m_children.add(iTreeNode);
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
    public void removeChild(ITreeNode iTreeNode) {
        this.m_children.remove(iTreeNode);
    }

    @Override
    public void setParent(ITreeNode iTreeNode) {
        this.m_parent = iTreeNode;
    }

    public String toString() {
        String string = String.valueOf(this.m_object.toString());
        return new StringBuilder(2 + String.valueOf(string).length()).append("<").append(string).append(">").toString();
    }
}

