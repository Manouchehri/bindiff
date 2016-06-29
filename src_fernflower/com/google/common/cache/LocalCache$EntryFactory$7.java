package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$WeakWriteEntry;
import javax.annotation.Nullable;

enum LocalCache$EntryFactory$7 {
   LocalCache$ReferenceEntry newEntry(LocalCache$Segment var1, Object var2, int var3, @Nullable LocalCache$ReferenceEntry var4) {
      return new LocalCache$WeakWriteEntry(var1.keyReferenceQueue, var2, var3, var4);
   }

   LocalCache$ReferenceEntry copyEntry(LocalCache$Segment var1, LocalCache$ReferenceEntry var2, LocalCache$ReferenceEntry var3) {
      LocalCache$ReferenceEntry var4 = super.copyEntry(var1, var2, var3);
      this.copyWriteEntry(var2, var4);
      return var4;
   }
}
