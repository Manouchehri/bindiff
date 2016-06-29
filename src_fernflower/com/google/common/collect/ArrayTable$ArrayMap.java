package com.google.common.collect;

import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap$1;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

abstract class ArrayTable$ArrayMap extends Maps$IteratorBasedAbstractMap {
   private final ImmutableMap keyIndex;

   private ArrayTable$ArrayMap(ImmutableMap var1) {
      this.keyIndex = var1;
   }

   public Set keySet() {
      return this.keyIndex.keySet();
   }

   Object getKey(int var1) {
      return this.keyIndex.keySet().asList().get(var1);
   }

   abstract String getKeyRole();

   @Nullable
   abstract Object getValue(int var1);

   @Nullable
   abstract Object setValue(int var1, Object var2);

   public int size() {
      return this.keyIndex.size();
   }

   public boolean isEmpty() {
      return this.keyIndex.isEmpty();
   }

   Iterator entryIterator() {
      return new ArrayTable$ArrayMap$1(this, this.size());
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.keyIndex.containsKey(var1);
   }

   public Object get(@Nullable Object var1) {
      Integer var2 = (Integer)this.keyIndex.get(var1);
      return var2 == null?null:this.getValue(var2.intValue());
   }

   public Object put(Object var1, Object var2) {
      Integer var3 = (Integer)this.keyIndex.get(var1);
      if(var3 == null) {
         String var4 = this.getKeyRole();
         String var5 = String.valueOf(var1);
         String var6 = String.valueOf(this.keyIndex.keySet());
         throw new IllegalArgumentException((new StringBuilder(9 + String.valueOf(var4).length() + String.valueOf(var5).length() + String.valueOf(var6).length())).append(var4).append(" ").append(var5).append(" not in ").append(var6).toString());
      } else {
         return this.setValue(var3.intValue(), var2);
      }
   }

   public Object remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   // $FF: synthetic method
   ArrayTable$ArrayMap(ImmutableMap var1, ArrayTable$1 var2) {
      this(var1);
   }
}
