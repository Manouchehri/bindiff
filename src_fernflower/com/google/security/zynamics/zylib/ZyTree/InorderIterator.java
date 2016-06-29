package com.google.security.zynamics.zylib.ZyTree;

import com.google.security.zynamics.zylib.ZyTree.IZyTreeNode;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.Stack;

public class InorderIterator {
   private final Stack traversalStack = new Stack();
   private final IZyTreeNode m_root;
   private boolean m_started = false;

   public InorderIterator(IZyTreeNode var1) {
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
      } else {
         if(this.traversalStack.empty()) {
            throw new RuntimeException("Internal Error: Traversal already finished");
         }

         Pair var1 = (Pair)this.traversalStack.pop();
         IZyTreeNode var2 = (IZyTreeNode)var1.first();
         int var3 = ((Integer)var1.second()).intValue();
         if(this.traversalStack.empty()) {
            if(var3 == var2.getChildren().size()) {
               return false;
            }

            if(var2.getChildren().size() == 0) {
               throw new RuntimeException("Error");
            }

            if(var2.getChildren().size() == 1) {
               this.pushLongestPathFrom((IZyTreeNode)((IZyTreeNode)var1.first()).getChildren().get(var3));
            } else {
               this.traversalStack.push(new Pair(((IZyTreeNode)var1.first()).getChildren().get(var3), Integer.valueOf(0)));
            }
         } else if(var3 == var2.getChildren().size()) {
            Pair var4 = (Pair)this.traversalStack.pop();
            this.traversalStack.push(new Pair(var4.first(), Integer.valueOf(((Integer)var4.second()).intValue() + 1)));
         } else {
            if(var2.getChildren().size() == 0) {
               throw new RuntimeException("Error");
            }

            if(var2.getChildren().size() == 1) {
               this.pushLongestPathFrom((IZyTreeNode)((IZyTreeNode)var1.first()).getChildren().get(var3));
            } else {
               this.traversalStack.push(new Pair(((IZyTreeNode)var1.first()).getChildren().get(var3), Integer.valueOf(0)));
            }
         }
      }

      return !this.traversalStack.empty();
   }
}
