package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$AsMap$EntrySet;
import com.google.j2objc.annotations.Weak;
import java.util.Collection;
import java.util.Set;

final class Multimaps$AsMap extends Maps$ViewCachingAbstractMap {
   @Weak
   private final Multimap multimap;

   Multimaps$AsMap(Multimap var1) {
      this.multimap = (Multimap)Preconditions.checkNotNull(var1);
   }

   public int size() {
      return this.multimap.keySet().size();
   }

   protected Set createEntrySet() {
      return new Multimaps$AsMap$EntrySet(this);
   }

   void removeValuesForKey(Object var1) {
      this.multimap.keySet().remove(var1);
   }

   public Collection get(Object var1) {
      return this.containsKey(var1)?this.multimap.get(var1):null;
   }

   public Collection remove(Object var1) {
      return this.containsKey(var1)?this.multimap.removeAll(var1):null;
   }

   public Set keySet() {
      return this.multimap.keySet();
   }

   public boolean isEmpty() {
      return this.multimap.isEmpty();
   }

   public boolean containsKey(Object var1) {
      return this.multimap.containsKey(var1);
   }

   public void clear() {
      this.multimap.clear();
   }

   // $FF: synthetic method
   static Multimap access$200(Multimaps$AsMap var0) {
      return var0.multimap;
   }
}
