package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import java.io.Serializable;

final class HashBiMap$InverseSerializedForm implements Serializable {
   private final HashBiMap bimap;

   HashBiMap$InverseSerializedForm(HashBiMap var1) {
      this.bimap = var1;
   }

   Object readResolve() {
      return this.bimap.inverse();
   }
}
