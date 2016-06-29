/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableEntry;
import javax.annotation.Nullable;

final class HashBiMap$BiEntry
extends ImmutableEntry {
    final int keyHash;
    final int valueHash;
    @Nullable
    HashBiMap$BiEntry nextInKToVBucket;
    @Nullable
    HashBiMap$BiEntry nextInVToKBucket;
    @Nullable
    HashBiMap$BiEntry nextInKeyInsertionOrder;
    @Nullable
    HashBiMap$BiEntry prevInKeyInsertionOrder;

    HashBiMap$BiEntry(Object object, int n2, Object object2, int n3) {
        super(object, object2);
        this.keyHash = n2;
        this.valueHash = n3;
    }
}

