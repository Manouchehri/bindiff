package com.google.common.collect;

import com.google.common.collect.ImmutableSet$Indexed;
import com.google.common.collect.RegularImmutableMultiset;
import com.google.common.collect.RegularImmutableMultiset$1;
import javax.annotation.Nullable;

final class RegularImmutableMultiset$ElementSet extends ImmutableSet$Indexed {
   // $FF: synthetic field
   final RegularImmutableMultiset this$0;

   private RegularImmutableMultiset$ElementSet(RegularImmutableMultiset var1) {
      this.this$0 = var1;
   }

   Object get(int var1) {
      return RegularImmutableMultiset.access$100(this.this$0)[var1].getElement();
   }

   public boolean contains(@Nullable Object var1) {
      return this.this$0.contains(var1);
   }

   boolean isPartialView() {
      return true;
   }

   public int size() {
      return RegularImmutableMultiset.access$100(this.this$0).length;
   }

   // $FF: synthetic method
   RegularImmutableMultiset$ElementSet(RegularImmutableMultiset var1, RegularImmutableMultiset$1 var2) {
      this(var1);
   }
}
