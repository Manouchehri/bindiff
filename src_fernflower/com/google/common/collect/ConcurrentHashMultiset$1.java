package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class ConcurrentHashMultiset$1 extends ForwardingSet {
   // $FF: synthetic field
   final Set val$delegate;
   // $FF: synthetic field
   final ConcurrentHashMultiset this$0;

   ConcurrentHashMultiset$1(ConcurrentHashMultiset var1, Set var2) {
      this.this$0 = var1;
      this.val$delegate = var2;
   }

   protected Set delegate() {
      return this.val$delegate;
   }

   public boolean contains(@Nullable Object var1) {
      return var1 != null && Collections2.safeContains(this.val$delegate, var1);
   }

   public boolean containsAll(Collection var1) {
      return this.standardContainsAll(var1);
   }

   public boolean remove(Object var1) {
      return var1 != null && Collections2.safeRemove(this.val$delegate, var1);
   }

   public boolean removeAll(Collection var1) {
      return this.standardRemoveAll(var1);
   }
}
