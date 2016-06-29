/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$KeySet$1;
import com.google.common.collect.Hashing;
import com.google.common.collect.Maps$KeySet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

final class HashBiMap$KeySet
extends Maps$KeySet {
    final /* synthetic */ HashBiMap this$0;

    HashBiMap$KeySet(HashBiMap hashBiMap) {
        this.this$0 = hashBiMap;
        super(hashBiMap);
    }

    @Override
    public Iterator iterator() {
        return new HashBiMap$KeySet$1(this);
    }

    @Override
    public boolean remove(@Nullable Object object) {
        HashBiMap$BiEntry hashBiMap$BiEntry = HashBiMap.access$300(this.this$0, object, Hashing.smearedHash(object));
        if (hashBiMap$BiEntry == null) {
            return false;
        }
        HashBiMap.access$200(this.this$0, hashBiMap$BiEntry);
        hashBiMap$BiEntry.prevInKeyInsertionOrder = null;
        hashBiMap$BiEntry.nextInKeyInsertionOrder = null;
        return true;
    }
}

