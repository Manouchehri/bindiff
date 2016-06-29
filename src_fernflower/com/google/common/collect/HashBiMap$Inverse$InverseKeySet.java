package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse;
import com.google.common.collect.HashBiMap$Inverse$InverseKeySet$1;
import com.google.common.collect.Hashing;
import com.google.common.collect.Maps$KeySet;
import java.util.Iterator;
import javax.annotation.Nullable;

final class HashBiMap$Inverse$InverseKeySet extends Maps$KeySet {
   // $FF: synthetic field
   final HashBiMap$Inverse this$1;

   HashBiMap$Inverse$InverseKeySet(HashBiMap$Inverse var1) {
      super(var1);
      this.this$1 = var1;
   }

   public boolean remove(@Nullable Object var1) {
      HashBiMap$BiEntry var2 = HashBiMap.access$400(this.this$1.this$0, var1, Hashing.smearedHash(var1));
      if(var2 == null) {
         return false;
      } else {
         HashBiMap.access$200(this.this$1.this$0, var2);
         return true;
      }
   }

   public Iterator iterator() {
      return new HashBiMap$Inverse$InverseKeySet$1(this);
   }
}
