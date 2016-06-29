package com.google.common.collect;

import com.google.common.collect.ImmutableEntry;
import javax.annotation.Nullable;

final class HashBiMap$BiEntry extends ImmutableEntry {
   final int keyHash;
   final int valueHash;
   @Nullable
   HashBiMap$BiEntry nextInKToVBucket;
   @Nullable
   HashBiMap$BiEntry nextInVToKBucket;
   @Nullable
   HashBiMap$BiEntry nextInKeyInsertionOrder;
   @Nullable
   HashBiMap$BiEntry prevInKeyInsertionOrder;

   HashBiMap$BiEntry(Object var1, int var2, Object var3, int var4) {
      super(var1, var3);
      this.keyHash = var2;
      this.valueHash = var4;
   }
}
