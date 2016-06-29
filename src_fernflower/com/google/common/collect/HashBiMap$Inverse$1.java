package com.google.common.collect;

import com.google.common.collect.HashBiMap$Inverse;
import com.google.common.collect.HashBiMap$Inverse$1$1;
import com.google.common.collect.Maps$EntrySet;
import java.util.Iterator;
import java.util.Map;

class HashBiMap$Inverse$1 extends Maps$EntrySet {
   // $FF: synthetic field
   final HashBiMap$Inverse this$1;

   HashBiMap$Inverse$1(HashBiMap$Inverse var1) {
      this.this$1 = var1;
   }

   Map map() {
      return this.this$1;
   }

   public Iterator iterator() {
      return new HashBiMap$Inverse$1$1(this);
   }
}
