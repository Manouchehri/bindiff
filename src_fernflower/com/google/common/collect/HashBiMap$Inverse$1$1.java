package com.google.common.collect;

import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse$1;
import com.google.common.collect.HashBiMap$Inverse$1$1$InverseEntry;
import com.google.common.collect.HashBiMap$Itr;
import java.util.Map.Entry;

class HashBiMap$Inverse$1$1 extends HashBiMap$Itr {
   // $FF: synthetic field
   final HashBiMap$Inverse$1 this$2;

   HashBiMap$Inverse$1$1(HashBiMap$Inverse$1 var1) {
      super(var1.this$1.this$0);
      this.this$2 = var1;
   }

   Entry output(HashBiMap$BiEntry var1) {
      return new HashBiMap$Inverse$1$1$InverseEntry(this, var1);
   }
}
