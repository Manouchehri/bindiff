package com.google.common.collect;

import com.google.common.collect.TreeMultiset$AvlNode;
import javax.annotation.Nullable;

enum TreeMultiset$Aggregate$2 {
   int nodeAggregate(TreeMultiset$AvlNode var1) {
      return 1;
   }

   long treeAggregate(@Nullable TreeMultiset$AvlNode var1) {
      return var1 == null?0L:(long)TreeMultiset$AvlNode.access$400(var1);
   }
}
