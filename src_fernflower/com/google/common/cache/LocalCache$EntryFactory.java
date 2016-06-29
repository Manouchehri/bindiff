package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$Strength;
import javax.annotation.Nullable;

enum LocalCache$EntryFactory {
   STRONG,
   STRONG_ACCESS,
   STRONG_WRITE,
   STRONG_ACCESS_WRITE,
   WEAK,
   WEAK_ACCESS,
   WEAK_WRITE,
   WEAK_ACCESS_WRITE;

   static final int ACCESS_MASK = 1;
   static final int WRITE_MASK = 2;
   static final int WEAK_MASK = 4;
   static final LocalCache$EntryFactory[] factories;

   private LocalCache$EntryFactory() {
   }

   static LocalCache$EntryFactory getFactory(LocalCache$Strength var0, boolean var1, boolean var2) {
      int var3 = (var0 == LocalCache$Strength.WEAK?4:0) | (var1?1:0) | (var2?2:0);
      return factories[var3];
   }

   abstract LocalCache$ReferenceEntry newEntry(LocalCache$Segment var1, Object var2, int var3, @Nullable LocalCache$ReferenceEntry var4);

   LocalCache$ReferenceEntry copyEntry(LocalCache$Segment var1, LocalCache$ReferenceEntry var2, LocalCache$ReferenceEntry var3) {
      return this.newEntry(var1, var2.getKey(), var2.getHash(), var3);
   }

   void copyAccessEntry(LocalCache$ReferenceEntry var1, LocalCache$ReferenceEntry var2) {
      var2.setAccessTime(var1.getAccessTime());
      LocalCache.connectAccessOrder(var1.getPreviousInAccessQueue(), var2);
      LocalCache.connectAccessOrder(var2, var1.getNextInAccessQueue());
      LocalCache.nullifyAccessOrder(var1);
   }

   void copyWriteEntry(LocalCache$ReferenceEntry var1, LocalCache$ReferenceEntry var2) {
      var2.setWriteTime(var1.getWriteTime());
      LocalCache.connectWriteOrder(var1.getPreviousInWriteQueue(), var2);
      LocalCache.connectWriteOrder(var2, var1.getNextInWriteQueue());
      LocalCache.nullifyWriteOrder(var1);
   }

   // $FF: synthetic method
   LocalCache$EntryFactory(LocalCache$1 var3) {
      this();
   }

   static {
      factories = new LocalCache$EntryFactory[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};
   }
}
