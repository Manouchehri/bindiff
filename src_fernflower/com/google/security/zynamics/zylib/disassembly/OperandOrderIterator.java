package com.google.security.zynamics.zylib.disassembly;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.disassembly.ExpressionType;
import com.google.security.zynamics.zylib.disassembly.IOperandTreeNode;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.Stack;

public class OperandOrderIterator {
   private final Stack m_traversalStack = new Stack();
   private final IOperandTreeNode m_root;
   private boolean m_started = false;

   public OperandOrderIterator(IOperandTreeNode var1) {
      Preconditions.checkNotNull(var1, "Internal Error: Root node can\'t be null");
      this.m_root = var1;
   }

   private void pushLongestPathFrom(IOperandTreeNode var1) {
      IOperandTreeNode var2 = var1;

      while(true) {
         this.m_traversalStack.push(new Pair(var2, Integer.valueOf(0)));
         if(var2.getChildren().size() <= 1 || var2.getType() == ExpressionType.EXPRESSION_LIST) {
            return;
         }

         var2 = (IOperandTreeNode)var2.getChildren().get(0);
      }
   }

   public IOperandTreeNode current() {
      return (IOperandTreeNode)((Pair)this.m_traversalStack.lastElement()).first();
   }

   public boolean next() {
      if(!this.m_started) {
         this.pushLongestPathFrom(this.m_root);
         this.m_started = true;
      } else {
         if(this.m_traversalStack.empty()) {
            throw new RuntimeException("Internal Error: Traversal already finished");
         }

         Pair var1 = (Pair)this.m_traversalStack.pop();
         IOperandTreeNode var2 = (IOperandTreeNode)var1.first();
         int var3 = ((Integer)var1.second()).intValue();
         if(var3 < var2.getChildren().size()) {
            if(((IOperandTreeNode)var1.first()).getChildren().size() > 1) {
               this.m_traversalStack.add(var1);
            }

            this.pushLongestPathFrom((IOperandTreeNode)var2.getChildren().get(var3));
            return true;
         }

         if(this.m_traversalStack.empty()) {
            return false;
         }

         do {
            Pair var4 = (Pair)this.m_traversalStack.pop();
            if(((Integer)var4.second()).intValue() < ((IOperandTreeNode)var4.first()).getChildren().size() - 1) {
               this.m_traversalStack.push(new Pair(var4.first(), Integer.valueOf(((Integer)var4.second()).intValue() + 1)));
               return true;
            }
         } while(!this.m_traversalStack.empty());
      }

      return !this.m_traversalStack.empty();
   }
}
