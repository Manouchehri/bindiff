/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse;
import com.google.common.collect.HashBiMap$Inverse$InverseKeySet;
import com.google.common.collect.HashBiMap$Itr;

class HashBiMap$Inverse$InverseKeySet$1
extends HashBiMap$Itr {
    final /* synthetic */ HashBiMap$Inverse$InverseKeySet this$2;

    HashBiMap$Inverse$InverseKeySet$1(HashBiMap$Inverse$InverseKeySet hashBiMap$Inverse$InverseKeySet) {
        this.this$2 = hashBiMap$Inverse$InverseKeySet;
        super(hashBiMap$Inverse$InverseKeySet.this$1.this$0);
    }

    @Override
    Object output(HashBiMap$BiEntry hashBiMap$BiEntry) {
        return hashBiMap$BiEntry.value;
    }
}

