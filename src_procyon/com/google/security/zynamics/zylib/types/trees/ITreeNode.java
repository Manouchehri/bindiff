package com.google.security.zynamics.zylib.types.trees;

import java.util.*;

public interface ITreeNode
{
    void addChild(final ITreeNode p0);
    
    List getChildren();
    
    Object getObject();
    
    ITreeNode getParent();
    
    void removeChild(final ITreeNode p0);
    
    void setParent(final ITreeNode p0);
}
