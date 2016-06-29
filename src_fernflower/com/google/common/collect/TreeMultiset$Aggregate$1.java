package com.google.common.collect;

import com.google.common.collect.TreeMultiset$AvlNode;
import javax.annotation.Nullable;

enum TreeMultiset$Aggregate$1 {
   int nodeAggregate(TreeMultiset$AvlNode var1) {
      return TreeMultiset$AvlNode.access$200(var1);
   }

   long treeAggregate(@Nullable TreeMultiset$AvlNode var1) {
      return var1 == null?0L:TreeMultiset$AvlNode.access$300(var1);
   }
}
