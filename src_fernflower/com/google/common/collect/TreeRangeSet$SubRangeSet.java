package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import com.google.common.collect.TreeRangeSet$1;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound;
import javax.annotation.Nullable;

final class TreeRangeSet$SubRangeSet extends TreeRangeSet {
   private final Range restriction;
   // $FF: synthetic field
   final TreeRangeSet this$0;

   TreeRangeSet$SubRangeSet(TreeRangeSet var1, Range var2) {
      super(new TreeRangeSet$SubRangeSetRangesByLowerBound(Range.all(), var2, var1.rangesByLowerBound, (TreeRangeSet$1)null), (TreeRangeSet$1)null);
      this.this$0 = var1;
      this.restriction = var2;
   }

   public boolean encloses(Range var1) {
      if(!this.restriction.isEmpty() && this.restriction.encloses(var1)) {
         Range var2 = TreeRangeSet.access$600(this.this$0, var1);
         return var2 != null && !var2.intersection(this.restriction).isEmpty();
      } else {
         return false;
      }
   }

   @Nullable
   public Range rangeContaining(Comparable var1) {
      if(!this.restriction.contains(var1)) {
         return null;
      } else {
         Range var2 = this.this$0.rangeContaining(var1);
         return var2 == null?null:var2.intersection(this.restriction);
      }
   }

   public void add(Range var1) {
      Preconditions.checkArgument(this.restriction.encloses(var1), "Cannot add range %s to subRangeSet(%s)", new Object[]{var1, this.restriction});
      super.add(var1);
   }

   public void remove(Range var1) {
      if(var1.isConnected(this.restriction)) {
         this.this$0.remove(var1.intersection(this.restriction));
      }

   }

   public boolean contains(Comparable var1) {
      return this.restriction.contains(var1) && this.this$0.contains(var1);
   }

   public void clear() {
      this.this$0.remove(this.restriction);
   }

   public RangeSet subRangeSet(Range var1) {
      return (RangeSet)(var1.encloses(this.restriction)?this:(var1.isConnected(this.restriction)?new TreeRangeSet$SubRangeSet(this, this.restriction.intersection(var1)):ImmutableRangeSet.of()));
   }
}
