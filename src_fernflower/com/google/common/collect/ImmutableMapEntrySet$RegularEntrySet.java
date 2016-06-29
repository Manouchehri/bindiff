package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import java.util.Map.Entry;

final class ImmutableMapEntrySet$RegularEntrySet extends ImmutableMapEntrySet {
   @Weak
   private final transient ImmutableMap map;
   private final transient Entry[] entries;

   ImmutableMapEntrySet$RegularEntrySet(ImmutableMap var1, Entry[] var2) {
      this.map = var1;
      this.entries = var2;
   }

   ImmutableMap map() {
      return this.map;
   }

   public UnmodifiableIterator iterator() {
      return this.asList().iterator();
   }

   ImmutableList createAsList() {
      return new RegularImmutableAsList(this, this.entries);
   }
}
