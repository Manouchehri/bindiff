package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import java.util.Map.Entry;

class ImmutableMultimap$EntryCollection extends ImmutableCollection {
   @Weak
   final ImmutableMultimap multimap;
   private static final long serialVersionUID = 0L;

   ImmutableMultimap$EntryCollection(ImmutableMultimap var1) {
      this.multimap = var1;
   }

   public UnmodifiableIterator iterator() {
      return this.multimap.entryIterator();
   }

   boolean isPartialView() {
      return this.multimap.isPartialView();
   }

   public int size() {
      return this.multimap.size();
   }

   public boolean contains(Object var1) {
      if(var1 instanceof Entry) {
         Entry var2 = (Entry)var1;
         return this.multimap.containsEntry(var2.getKey(), var2.getValue());
      } else {
         return false;
      }
   }
}
