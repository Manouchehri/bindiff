package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

final class TreeTraverser$PostOrderNode {
   final Object root;
   final Iterator childIterator;

   TreeTraverser$PostOrderNode(Object var1, Iterator var2) {
      this.root = Preconditions.checkNotNull(var1);
      this.childIterator = (Iterator)Preconditions.checkNotNull(var2);
   }
}
