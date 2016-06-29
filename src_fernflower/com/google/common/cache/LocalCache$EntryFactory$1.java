package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$StrongEntry;
import javax.annotation.Nullable;

enum LocalCache$EntryFactory$1 {
   LocalCache$ReferenceEntry newEntry(LocalCache$Segment var1, Object var2, int var3, @Nullable LocalCache$ReferenceEntry var4) {
      return new LocalCache$StrongEntry(var2, var3, var4);
   }
}
