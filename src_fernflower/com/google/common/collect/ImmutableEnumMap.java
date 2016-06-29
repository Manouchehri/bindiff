package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableEnumMap$1;
import com.google.common.collect.ImmutableEnumMap$EnumSerializedForm;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.EnumMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
final class ImmutableEnumMap extends ImmutableMap$IteratorBasedImmutableMap {
   private final transient EnumMap delegate;

   static ImmutableMap asImmutable(EnumMap var0) {
      switch(var0.size()) {
      case 0:
         return ImmutableMap.of();
      case 1:
         Entry var1 = (Entry)Iterables.getOnlyElement(var0.entrySet());
         return ImmutableMap.of(var1.getKey(), var1.getValue());
      default:
         return new ImmutableEnumMap(var0);
      }
   }

   private ImmutableEnumMap(EnumMap var1) {
      this.delegate = var1;
      Preconditions.checkArgument(!var1.isEmpty());
   }

   UnmodifiableIterator keyIterator() {
      return Iterators.unmodifiableIterator(this.delegate.keySet().iterator());
   }

   public int size() {
      return this.delegate.size();
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.delegate.containsKey(var1);
   }

   public Object get(Object var1) {
      return this.delegate.get(var1);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else {
         if(var1 instanceof ImmutableEnumMap) {
            var1 = ((ImmutableEnumMap)var1).delegate;
         }

         return this.delegate.equals(var1);
      }
   }

   UnmodifiableIterator entryIterator() {
      return Maps.unmodifiableEntryIterator(this.delegate.entrySet().iterator());
   }

   boolean isPartialView() {
      return false;
   }

   Object writeReplace() {
      return new ImmutableEnumMap$EnumSerializedForm(this.delegate);
   }

   // $FF: synthetic method
   ImmutableEnumMap(EnumMap var1, ImmutableEnumMap$1 var2) {
      this(var1);
   }
}
