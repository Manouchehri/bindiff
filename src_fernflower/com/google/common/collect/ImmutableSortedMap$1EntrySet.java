package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap$1EntrySet$1;
import com.google.common.collect.UnmodifiableIterator;

class ImmutableSortedMap$1EntrySet extends ImmutableMapEntrySet {
   // $FF: synthetic field
   final ImmutableSortedMap this$0;

   ImmutableSortedMap$1EntrySet(ImmutableSortedMap var1) {
      this.this$0 = var1;
   }

   public UnmodifiableIterator iterator() {
      return this.asList().iterator();
   }

   ImmutableList createAsList() {
      return new ImmutableSortedMap$1EntrySet$1(this);
   }

   ImmutableMap map() {
      return this.this$0;
   }
}
