package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.ITreeNode;

public class Tree {
   private final ITreeNode m_rootNode;

   public Tree(ITreeNode var1) {
      this.m_rootNode = var1;
   }

   public ITreeNode getRootNode() {
      return this.m_rootNode;
   }
}
