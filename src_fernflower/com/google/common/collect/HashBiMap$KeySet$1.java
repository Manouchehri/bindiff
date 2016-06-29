package com.google.common.collect;

import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Itr;
import com.google.common.collect.HashBiMap$KeySet;

class HashBiMap$KeySet$1 extends HashBiMap$Itr {
   // $FF: synthetic field
   final HashBiMap$KeySet this$1;

   HashBiMap$KeySet$1(HashBiMap$KeySet var1) {
      super(var1.this$0);
      this.this$1 = var1;
   }

   Object output(HashBiMap$BiEntry var1) {
      return var1.key;
   }
}
