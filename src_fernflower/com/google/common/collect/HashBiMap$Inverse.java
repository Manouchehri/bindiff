package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$1;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse$1;
import com.google.common.collect.HashBiMap$Inverse$InverseKeySet;
import com.google.common.collect.HashBiMap$InverseSerializedForm;
import com.google.common.collect.Hashing;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Set;
import javax.annotation.Nullable;

final class HashBiMap$Inverse extends AbstractMap implements BiMap, Serializable {
   // $FF: synthetic field
   final HashBiMap this$0;

   private HashBiMap$Inverse(HashBiMap var1) {
      this.this$0 = var1;
   }

   BiMap forward() {
      return this.this$0;
   }

   public int size() {
      return HashBiMap.access$700(this.this$0);
   }

   public void clear() {
      this.forward().clear();
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.forward().containsValue(var1);
   }

   public Object get(@Nullable Object var1) {
      return Maps.keyOrNull(HashBiMap.access$400(this.this$0, var1, Hashing.smearedHash(var1)));
   }

   public Object put(@Nullable Object var1, @Nullable Object var2) {
      return HashBiMap.access$800(this.this$0, var1, var2, false);
   }

   public Object forcePut(@Nullable Object var1, @Nullable Object var2) {
      return HashBiMap.access$800(this.this$0, var1, var2, true);
   }

   public Object remove(@Nullable Object var1) {
      HashBiMap$BiEntry var2 = HashBiMap.access$400(this.this$0, var1, Hashing.smearedHash(var1));
      if(var2 == null) {
         return null;
      } else {
         HashBiMap.access$200(this.this$0, var2);
         var2.prevInKeyInsertionOrder = null;
         var2.nextInKeyInsertionOrder = null;
         return var2.key;
      }
   }

   public BiMap inverse() {
      return this.forward();
   }

   public Set keySet() {
      return new HashBiMap$Inverse$InverseKeySet(this);
   }

   public Set values() {
      return this.forward().keySet();
   }

   public Set entrySet() {
      return new HashBiMap$Inverse$1(this);
   }

   Object writeReplace() {
      return new HashBiMap$InverseSerializedForm(this.this$0);
   }

   // $FF: synthetic method
   HashBiMap$Inverse(HashBiMap var1, HashBiMap$1 var2) {
      this(var1);
   }
}
