package com.google.common.collect;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Sets;
import com.google.common.collect.TreeRangeSet;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

final class TreeRangeSet$AsRanges extends ForwardingCollection implements Set {
   final Collection delegate;
   // $FF: synthetic field
   final TreeRangeSet this$0;

   TreeRangeSet$AsRanges(TreeRangeSet var1, Collection var2) {
      this.this$0 = var1;
      this.delegate = var2;
   }

   protected Collection delegate() {
      return this.delegate;
   }

   public int hashCode() {
      return Sets.hashCodeImpl(this);
   }

   public boolean equals(@Nullable Object var1) {
      return Sets.equalsImpl(this, var1);
   }
}
