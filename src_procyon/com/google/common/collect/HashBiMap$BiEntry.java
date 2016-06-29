package com.google.common.collect;

import javax.annotation.*;

final class HashBiMap$BiEntry extends ImmutableEntry
{
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
    
    HashBiMap$BiEntry(final Object o, final int keyHash, final Object o2, final int valueHash) {
        super(o, o2);
        this.keyHash = keyHash;
        this.valueHash = valueHash;
    }
}
