package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.TreeTraverser$1;
import com.google.common.collect.TreeTraverser$2;
import com.google.common.collect.TreeTraverser$3;
import com.google.common.collect.TreeTraverser$PostOrderIterator;
import com.google.common.collect.TreeTraverser$PreOrderIterator;
import com.google.common.collect.UnmodifiableIterator;

@Beta
@GwtCompatible(
   emulated = true
)
public abstract class TreeTraverser {
   public abstract Iterable children(Object var1);

   public final FluentIterable preOrderTraversal(Object var1) {
      Preconditions.checkNotNull(var1);
      return new TreeTraverser$1(this, var1);
   }

   UnmodifiableIterator preOrderIterator(Object var1) {
      return new TreeTraverser$PreOrderIterator(this, var1);
   }

   public final FluentIterable postOrderTraversal(Object var1) {
      Preconditions.checkNotNull(var1);
      return new TreeTraverser$2(this, var1);
   }

   UnmodifiableIterator postOrderIterator(Object var1) {
      return new TreeTraverser$PostOrderIterator(this, var1);
   }

   public final FluentIterable breadthFirstTraversal(Object var1) {
      Preconditions.checkNotNull(var1);
      return new TreeTraverser$3(this, var1);
   }
}
