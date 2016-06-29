/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.trees;

import java.util.List;

public interface ITreeNode {
    public void addChild(ITreeNode var1);

    public List getChildren();

    public Object getObject();

    public ITreeNode getParent();

    public void removeChild(ITreeNode var1);

    public void setParent(ITreeNode var1);
}

