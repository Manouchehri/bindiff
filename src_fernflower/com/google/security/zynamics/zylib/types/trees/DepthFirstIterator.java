package com.google.security.zynamics.zylib.types.trees;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.Iterator;
import java.util.Stack;

public class DepthFirstIterator implements Iterator {
   private final Stack m_path = new Stack();

   public DepthFirstIterator(ITreeNode var1) {
      Preconditions.checkNotNull(var1, "Error: Root node argument can not be null");
      Iterator var2 = var1.getChildren().iterator();

      while(var2.hasNext()) {
         ITreeNode var3 = (ITreeNode)var2.next();
         this.m_path.add(var3);
      }

   }

   public boolean hasNext() {
      return !this.m_path.isEmpty();
   }

   public ITreeNode next() {
      ITreeNode var1 = (ITreeNode)this.m_path.pop();
      Iterator var2 = var1.getChildren().iterator();

      while(var2.hasNext()) {
         ITreeNode var3 = (ITreeNode)var2.next();
         this.m_path.add(var3);
      }

      return var1;
   }

   public void remove() {
   }
}
