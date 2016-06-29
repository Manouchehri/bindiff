package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.BinaryTreeTraverser$1;
import com.google.common.collect.BinaryTreeTraverser$2;
import com.google.common.collect.BinaryTreeTraverser$PostOrderIterator;
import com.google.common.collect.BinaryTreeTraverser$PreOrderIterator;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Deque;

@Beta
@GwtCompatible(
   emulated = true
)
public abstract class BinaryTreeTraverser extends TreeTraverser {
   public abstract Optional leftChild(Object var1);

   public abstract Optional rightChild(Object var1);

   public final Iterable children(Object var1) {
      Preconditions.checkNotNull(var1);
      return new BinaryTreeTraverser$1(this, var1);
   }

   UnmodifiableIterator preOrderIterator(Object var1) {
      return new BinaryTreeTraverser$PreOrderIterator(this, var1);
   }

   UnmodifiableIterator postOrderIterator(Object var1) {
      return new BinaryTreeTraverser$PostOrderIterator(this, var1);
   }

   public final FluentIterable inOrderTraversal(Object var1) {
      Preconditions.checkNotNull(var1);
      return new BinaryTreeTraverser$2(this, var1);
   }

   private static void pushIfPresent(Deque var0, Optional var1) {
      if(var1.isPresent()) {
         var0.addLast(var1.get());
      }

   }

   // $FF: synthetic method
   static void access$000(Deque var0, Optional var1) {
      pushIfPresent(var0, var1);
   }
}
