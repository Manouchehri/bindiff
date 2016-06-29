package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$1;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import javax.annotation.Nullable;

final class ImmutableMap$MapViewOfValuesAsSingletonSets extends ImmutableMap$IteratorBasedImmutableMap {
   // $FF: synthetic field
   final ImmutableMap this$0;

   private ImmutableMap$MapViewOfValuesAsSingletonSets(ImmutableMap var1) {
      this.this$0 = var1;
   }

   public int size() {
      return this.this$0.size();
   }

   public ImmutableSet keySet() {
      return this.this$0.keySet();
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.this$0.containsKey(var1);
   }

   public ImmutableSet get(@Nullable Object var1) {
      Object var2 = this.this$0.get(var1);
      return var2 == null?null:ImmutableSet.of(var2);
   }

   boolean isPartialView() {
      return this.this$0.isPartialView();
   }

   public int hashCode() {
      return this.this$0.hashCode();
   }

   boolean isHashCodeFast() {
      return this.this$0.isHashCodeFast();
   }

   UnmodifiableIterator entryIterator() {
      UnmodifiableIterator var1 = this.this$0.entrySet().iterator();
      return new ImmutableMap$MapViewOfValuesAsSingletonSets$1(this, var1);
   }

   // $FF: synthetic method
   ImmutableMap$MapViewOfValuesAsSingletonSets(ImmutableMap var1, ImmutableMap$1 var2) {
      this(var1);
   }
}
