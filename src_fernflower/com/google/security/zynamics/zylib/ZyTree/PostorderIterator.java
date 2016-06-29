package com.google.security.zynamics.zylib.ZyTree;

import com.google.security.zynamics.zylib.ZyTree.IZyTreeNode;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.Stack;

public class PostorderIterator {
   private final Stack traversalStack = new Stack();
   private final IZyTreeNode m_root;
   private boolean m_started = false;

   public PostorderIterator(IZyTreeNode var1) {
      this.m_root = var1;
   }

   private void pushLongestPathFrom(IZyTreeNode var1) {
      IZyTreeNode var2 = var1;

      while(true) {
         this.traversalStack.push(new Pair(var2, Integer.valueOf(0)));
         if(var2.getChildren().size() == 0) {
            return;
         }

         var2 = (IZyTreeNode)var2.getChildren().get(0);
      }
   }

   public IZyTreeNode current() {
      return (IZyTreeNode)((Pair)this.traversalStack.lastElement()).first();
   }

   public boolean next() {
      if(!this.m_started) {
         this.pushLongestPathFrom(this.m_root);
         this.m_started = true;
         return !this.traversalStack.empty();
      } else if(this.traversalStack.empty()) {
         throw new RuntimeException("Internal Error: Traversal already finished");
      } else {
         while(!this.traversalStack.empty()) {
            Pair var1 = (Pair)this.traversalStack.pop();
            int var2 = ((Integer)var1.second()).intValue() + 1;
            if(var2 <= ((IZyTreeNode)var1.first()).getChildren().size()) {
               if(var2 == ((IZyTreeNode)var1.first()).getChildren().size()) {
                  this.traversalStack.push(new Pair(var1.first(), Integer.valueOf(var2)));
                  return true;
               }

               this.traversalStack.push(new Pair(var1.first(), Integer.valueOf(var2)));
               this.pushLongestPathFrom((IZyTreeNode)((IZyTreeNode)var1.first()).getChildren().get(var2));
               return true;
            }
         }

         return false;
      }
   }
}
