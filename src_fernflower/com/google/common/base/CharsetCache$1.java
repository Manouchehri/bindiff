package com.google.common.base;

import com.google.common.base.CharsetCache;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class CharsetCache$1 extends LinkedHashMap {
   // $FF: synthetic field
   final int val$missCacheSize;
   // $FF: synthetic field
   final CharsetCache this$0;

   CharsetCache$1(CharsetCache var1, int var2, float var3, boolean var4, int var5) {
      super(var2, var3, var4);
      this.this$0 = var1;
      this.val$missCacheSize = var5;
   }

   protected boolean removeEldestEntry(Entry var1) {
      return this.size() > this.val$missCacheSize;
   }
}
