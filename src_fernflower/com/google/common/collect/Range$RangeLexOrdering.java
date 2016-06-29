package com.google.common.collect;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.Range$1;
import java.io.Serializable;

class Range$RangeLexOrdering extends Ordering implements Serializable {
   private static final long serialVersionUID = 0L;

   private Range$RangeLexOrdering() {
   }

   public int compare(Range var1, Range var2) {
      return ComparisonChain.start().compare((Comparable)var1.lowerBound, (Comparable)var2.lowerBound).compare((Comparable)var1.upperBound, (Comparable)var2.upperBound).result();
   }

   // $FF: synthetic method
   Range$RangeLexOrdering(Range$1 var1) {
      this();
   }
}
