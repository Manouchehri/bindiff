package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.ITreeNode;

public class TreeHelpers {
   public static boolean isAncestor(ITreeNode var0, ITreeNode var1) {
      return var0 == null?false:(var1 == var0?true:isAncestor(var0.getParent(), var1));
   }
}
