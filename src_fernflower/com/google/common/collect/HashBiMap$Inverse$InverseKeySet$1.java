package com.google.common.collect;

import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse$InverseKeySet;
import com.google.common.collect.HashBiMap$Itr;

class HashBiMap$Inverse$InverseKeySet$1 extends HashBiMap$Itr {
   // $FF: synthetic field
   final HashBiMap$Inverse$InverseKeySet this$2;

   HashBiMap$Inverse$InverseKeySet$1(HashBiMap$Inverse$InverseKeySet var1) {
      super(var1.this$1.this$0);
      this.this$2 = var1;
   }

   Object output(HashBiMap$BiEntry var1) {
      return var1.value;
   }
}
