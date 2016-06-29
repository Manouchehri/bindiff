/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$1$MapEntry;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Itr;
import java.util.Map;

class HashBiMap$1
extends HashBiMap$Itr {
    final /* synthetic */ HashBiMap this$0;

    HashBiMap$1(HashBiMap hashBiMap) {
        this.this$0 = hashBiMap;
        super(hashBiMap);
    }

    @Override
    Map.Entry output(HashBiMap$BiEntry hashBiMap$BiEntry) {
        return new HashBiMap$1$MapEntry(this, hashBiMap$BiEntry);
    }
}

