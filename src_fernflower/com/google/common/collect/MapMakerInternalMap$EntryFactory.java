package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$1;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$Strength;
import javax.annotation.Nullable;

enum MapMakerInternalMap$EntryFactory {
   STRONG,
   STRONG_EXPIRABLE,
   STRONG_EVICTABLE,
   STRONG_EXPIRABLE_EVICTABLE,
   WEAK,
   WEAK_EXPIRABLE,
   WEAK_EVICTABLE,
   WEAK_EXPIRABLE_EVICTABLE;

   static final int EXPIRABLE_MASK = 1;
   static final int EVICTABLE_MASK = 2;
   static final MapMakerInternalMap$EntryFactory[][] factories;

   private MapMakerInternalMap$EntryFactory() {
   }

   static MapMakerInternalMap$EntryFactory getFactory(MapMakerInternalMap$Strength var0, boolean var1, boolean var2) {
      int var3 = (var1?1:0) | (var2?2:0);
      return factories[var0.ordinal()][var3];
   }

   abstract MapMakerInternalMap$ReferenceEntry newEntry(MapMakerInternalMap$Segment var1, Object var2, int var3, @Nullable MapMakerInternalMap$ReferenceEntry var4);

   MapMakerInternalMap$ReferenceEntry copyEntry(MapMakerInternalMap$Segment var1, MapMakerInternalMap$ReferenceEntry var2, MapMakerInternalMap$ReferenceEntry var3) {
      return this.newEntry(var1, var2.getKey(), var2.getHash(), var3);
   }

   void copyExpirableEntry(MapMakerInternalMap$ReferenceEntry var1, MapMakerInternalMap$ReferenceEntry var2) {
      var2.setExpirationTime(var1.getExpirationTime());
      MapMakerInternalMap.connectExpirables(var1.getPreviousExpirable(), var2);
      MapMakerInternalMap.connectExpirables(var2, var1.getNextExpirable());
      MapMakerInternalMap.nullifyExpirable(var1);
   }

   void copyEvictableEntry(MapMakerInternalMap$ReferenceEntry var1, MapMakerInternalMap$ReferenceEntry var2) {
      MapMakerInternalMap.connectEvictables(var1.getPreviousEvictable(), var2);
      MapMakerInternalMap.connectEvictables(var2, var1.getNextEvictable());
      MapMakerInternalMap.nullifyEvictable(var1);
   }

   // $FF: synthetic method
   MapMakerInternalMap$EntryFactory(MapMakerInternalMap$1 var3) {
      this();
   }

   static {
      factories = new MapMakerInternalMap$EntryFactory[][]{{STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE}, new MapMakerInternalMap$EntryFactory[0], {WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE}};
   }
}
