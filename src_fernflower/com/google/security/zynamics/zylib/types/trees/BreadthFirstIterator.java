package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstIterator implements Iterator {
   private final Queue m_path = new LinkedList();

   public BreadthFirstIterator(ITreeNode var1) {
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
      ITreeNode var1 = (ITreeNode)this.m_path.remove();
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
