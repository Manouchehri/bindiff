package com.google.common.collect;

import com.google.common.collect.TreeMultiset$1;
import com.google.common.collect.TreeMultiset$AvlNode;
import javax.annotation.Nullable;

enum TreeMultiset$Aggregate {
   SIZE,
   DISTINCT;

   private TreeMultiset$Aggregate() {
   }

   abstract int nodeAggregate(TreeMultiset$AvlNode var1);

   abstract long treeAggregate(@Nullable TreeMultiset$AvlNode var1);

   // $FF: synthetic method
   TreeMultiset$Aggregate(TreeMultiset$1 var3) {
      this();
   }
}
