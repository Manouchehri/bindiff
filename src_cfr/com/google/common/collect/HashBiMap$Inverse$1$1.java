/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse;
import com.google.common.collect.HashBiMap$Inverse$1;
import com.google.common.collect.HashBiMap$Inverse$1$1$InverseEntry;
import com.google.common.collect.HashBiMap$Itr;
import java.util.Map;

class HashBiMap$Inverse$1$1
extends HashBiMap$Itr {
    final /* synthetic */ HashBiMap$Inverse$1 this$2;

    HashBiMap$Inverse$1$1(HashBiMap$Inverse$1 hashBiMap$Inverse$1) {
        this.this$2 = hashBiMap$Inverse$1;
        super(hashBiMap$Inverse$1.this$1.this$0);
    }

    @Override
    Map.Entry output(HashBiMap$BiEntry hashBiMap$BiEntry) {
        return new HashBiMap$Inverse$1$1$InverseEntry(this, hashBiMap$BiEntry);
    }
}

