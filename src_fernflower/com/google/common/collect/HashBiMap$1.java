package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$1$MapEntry;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Itr;
import java.util.Map.Entry;

class HashBiMap$1 extends HashBiMap$Itr {
   // $FF: synthetic field
   final HashBiMap this$0;

   HashBiMap$1(HashBiMap var1) {
      super(var1);
      this.this$0 = var1;
   }

   Entry output(HashBiMap$BiEntry var1) {
      return new HashBiMap$1$MapEntry(this, var1);
   }
}
