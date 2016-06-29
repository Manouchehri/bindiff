package com.google.security.zynamics.zylib.types.trees;

import java.util.List;

public interface ITreeNode {
   void addChild(ITreeNode var1);

   List getChildren();

   Object getObject();

   ITreeNode getParent();

   void removeChild(ITreeNode var1);

   void setParent(ITreeNode var1);
}
