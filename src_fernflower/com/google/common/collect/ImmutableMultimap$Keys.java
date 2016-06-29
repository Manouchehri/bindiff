package com.google.common.collect;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class ImmutableMultimap$Keys extends ImmutableMultiset {
   // $FF: synthetic field
   final ImmutableMultimap this$0;

   ImmutableMultimap$Keys(ImmutableMultimap var1) {
      this.this$0 = var1;
   }

   public boolean contains(@Nullable Object var1) {
      return this.this$0.containsKey(var1);
   }

   public int count(@Nullable Object var1) {
      Collection var2 = (Collection)this.this$0.map.get(var1);
      return var2 == null?0:var2.size();
   }

   public Set elementSet() {
      return this.this$0.keySet();
   }

   public int size() {
      return this.this$0.size();
   }

   Multiset$Entry getEntry(int var1) {
      Entry var2 = (Entry)this.this$0.map.entrySet().asList().get(var1);
      return Multisets.immutableEntry(var2.getKey(), ((Collection)var2.getValue()).size());
   }

   boolean isPartialView() {
      return true;
   }
}
