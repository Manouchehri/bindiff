package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$KeySet$1;
import com.google.common.collect.Hashing;
import com.google.common.collect.Maps$KeySet;
import java.util.Iterator;
import javax.annotation.Nullable;

final class HashBiMap$KeySet extends Maps$KeySet {
   // $FF: synthetic field
   final HashBiMap this$0;

   HashBiMap$KeySet(HashBiMap var1) {
      super(var1);
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return new HashBiMap$KeySet$1(this);
   }

   public boolean remove(@Nullable Object var1) {
      HashBiMap$BiEntry var2 = HashBiMap.access$300(this.this$0, var1, Hashing.smearedHash(var1));
      if(var2 == null) {
         return false;
      } else {
         HashBiMap.access$200(this.this$0, var2);
         var2.prevInKeyInsertionOrder = null;
         var2.nextInKeyInsertionOrder = null;
         return true;
      }
   }
}
