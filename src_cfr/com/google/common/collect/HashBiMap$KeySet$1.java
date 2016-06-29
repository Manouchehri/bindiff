/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Itr;
import com.google.common.collect.HashBiMap$KeySet;

class HashBiMap$KeySet$1
extends HashBiMap$Itr {
    final /* synthetic */ HashBiMap$KeySet this$1;

    HashBiMap$KeySet$1(HashBiMap$KeySet hashBiMap$KeySet) {
        this.this$1 = hashBiMap$KeySet;
        super(hashBiMap$KeySet.this$0);
    }

    @Override
    Object output(HashBiMap$BiEntry hashBiMap$BiEntry) {
        return hashBiMap$BiEntry.key;
    }
}

