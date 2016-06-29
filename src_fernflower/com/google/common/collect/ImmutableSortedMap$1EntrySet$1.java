package com.google.common.collect;

import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap$1EntrySet;
import com.google.common.collect.Maps;
import java.util.Map.Entry;

class ImmutableSortedMap$1EntrySet$1 extends ImmutableAsList {
   // $FF: synthetic field
   final ImmutableSortedMap$1EntrySet this$1;

   ImmutableSortedMap$1EntrySet$1(ImmutableSortedMap$1EntrySet var1) {
      this.this$1 = var1;
   }

   public Entry get(int var1) {
      return Maps.immutableEntry(ImmutableSortedMap.access$200(this.this$1.this$0).asList().get(var1), ImmutableSortedMap.access$300(this.this$1.this$0).get(var1));
   }

   ImmutableCollection delegateCollection() {
      return this.this$1;
   }
}
