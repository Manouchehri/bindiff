/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse;
import com.google.common.collect.HashBiMap$Inverse$InverseKeySet$1;
import com.google.common.collect.Hashing;
import com.google.common.collect.Maps$KeySet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

final class HashBiMap$Inverse$InverseKeySet
extends Maps$KeySet {
    final /* synthetic */ HashBiMap$Inverse this$1;

    HashBiMap$Inverse$InverseKeySet(HashBiMap$Inverse hashBiMap$Inverse) {
        this.this$1 = hashBiMap$Inverse;
        super(hashBiMap$Inverse);
    }

    @Override
    public boolean remove(@Nullable Object object) {
        HashBiMap$BiEntry hashBiMap$BiEntry = HashBiMap.access$400(this.this$1.this$0, object, Hashing.smearedHash(object));
        if (hashBiMap$BiEntry == null) {
            return false;
        }
        HashBiMap.access$200(this.this$1.this$0, hashBiMap$BiEntry);
        return true;
    }

    @Override
    public Iterator iterator() {
        return new HashBiMap$Inverse$InverseKeySet$1(this);
    }
}

