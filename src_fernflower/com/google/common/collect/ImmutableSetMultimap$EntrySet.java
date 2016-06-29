package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class ImmutableSetMultimap$EntrySet extends ImmutableSet {
   @Weak
   private final transient ImmutableSetMultimap multimap;

   ImmutableSetMultimap$EntrySet(ImmutableSetMultimap var1) {
      this.multimap = var1;
   }

   public boolean contains(@Nullable Object var1) {
      if(var1 instanceof Entry) {
         Entry var2 = (Entry)var1;
         return this.multimap.containsEntry(var2.getKey(), var2.getValue());
      } else {
         return false;
      }
   }

   public int size() {
      return this.multimap.size();
   }

   public UnmodifiableIterator iterator() {
      return this.multimap.entryIterator();
   }

   boolean isPartialView() {
      return false;
   }
}
