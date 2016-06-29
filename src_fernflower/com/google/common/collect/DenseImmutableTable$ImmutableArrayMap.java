package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap$1;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import javax.annotation.Nullable;

abstract class DenseImmutableTable$ImmutableArrayMap extends ImmutableMap$IteratorBasedImmutableMap {
   private final int size;

   DenseImmutableTable$ImmutableArrayMap(int var1) {
      this.size = var1;
   }

   abstract ImmutableMap keyToIndex();

   private boolean isFull() {
      return this.size == this.keyToIndex().size();
   }

   Object getKey(int var1) {
      return this.keyToIndex().keySet().asList().get(var1);
   }

   @Nullable
   abstract Object getValue(int var1);

   ImmutableSet createKeySet() {
      return this.isFull()?this.keyToIndex().keySet():super.createKeySet();
   }

   public int size() {
      return this.size;
   }

   public Object get(@Nullable Object var1) {
      Integer var2 = (Integer)this.keyToIndex().get(var1);
      return var2 == null?null:this.getValue(var2.intValue());
   }

   UnmodifiableIterator entryIterator() {
      return new DenseImmutableTable$ImmutableArrayMap$1(this);
   }
}
