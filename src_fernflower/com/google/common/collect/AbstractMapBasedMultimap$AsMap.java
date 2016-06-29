package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap$AsMapEntries;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap$AsMapIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$AsMap extends Maps$ViewCachingAbstractMap {
   final transient Map submap;
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$AsMap(AbstractMapBasedMultimap var1, Map var2) {
      this.this$0 = var1;
      this.submap = var2;
   }

   protected Set createEntrySet() {
      return new AbstractMapBasedMultimap$AsMap$AsMapEntries(this);
   }

   public boolean containsKey(Object var1) {
      return Maps.safeContainsKey(this.submap, var1);
   }

   public Collection get(Object var1) {
      Collection var2 = (Collection)Maps.safeGet(this.submap, var1);
      return var2 == null?null:this.this$0.wrapCollection(var1, var2);
   }

   public Set keySet() {
      return this.this$0.keySet();
   }

   public int size() {
      return this.submap.size();
   }

   public Collection remove(Object var1) {
      Collection var2 = (Collection)this.submap.remove(var1);
      if(var2 == null) {
         return null;
      } else {
         Collection var3 = this.this$0.createCollection();
         var3.addAll(var2);
         AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) - var2.size());
         var2.clear();
         return var3;
      }
   }

   public boolean equals(@Nullable Object var1) {
      return this == var1 || this.submap.equals(var1);
   }

   public int hashCode() {
      return this.submap.hashCode();
   }

   public String toString() {
      return this.submap.toString();
   }

   public void clear() {
      if(this.submap == AbstractMapBasedMultimap.access$000(this.this$0)) {
         this.this$0.clear();
      } else {
         Iterators.clear(new AbstractMapBasedMultimap$AsMap$AsMapIterator(this));
      }

   }

   Entry wrapEntry(Entry var1) {
      Object var2 = var1.getKey();
      return Maps.immutableEntry(var2, this.this$0.wrapCollection(var2, (Collection)var1.getValue()));
   }
}
