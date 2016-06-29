/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$1;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse$1;
import com.google.common.collect.HashBiMap$Inverse$InverseKeySet;
import com.google.common.collect.HashBiMap$InverseSerializedForm;
import com.google.common.collect.Hashing;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

final class HashBiMap$Inverse
extends AbstractMap
implements BiMap,
Serializable {
    final /* synthetic */ HashBiMap this$0;

    private HashBiMap$Inverse(HashBiMap hashBiMap) {
        this.this$0 = hashBiMap;
    }

    BiMap forward() {
        return this.this$0;
    }

    @Override
    public int size() {
        return HashBiMap.access$700(this.this$0);
    }

    @Override
    public void clear() {
        this.forward().clear();
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.forward().containsValue(object);
    }

    public Object get(@Nullable Object object) {
        return Maps.keyOrNull(HashBiMap.access$400(this.this$0, object, Hashing.smearedHash(object)));
    }

    @Override
    public Object put(@Nullable Object object, @Nullable Object object2) {
        return HashBiMap.access$800(this.this$0, object, object2, false);
    }

    @Override
    public Object forcePut(@Nullable Object object, @Nullable Object object2) {
        return HashBiMap.access$800(this.this$0, object, object2, true);
    }

    public Object remove(@Nullable Object object) {
        HashBiMap$BiEntry hashBiMap$BiEntry = HashBiMap.access$400(this.this$0, object, Hashing.smearedHash(object));
        if (hashBiMap$BiEntry == null) {
            return null;
        }
        HashBiMap.access$200(this.this$0, hashBiMap$BiEntry);
        hashBiMap$BiEntry.prevInKeyInsertionOrder = null;
        hashBiMap$BiEntry.nextInKeyInsertionOrder = null;
        return hashBiMap$BiEntry.key;
    }

    @Override
    public BiMap inverse() {
        return this.forward();
    }

    public Set keySet() {
        return new HashBiMap$Inverse$InverseKeySet(this);
    }

    @Override
    public Set values() {
        return this.forward().keySet();
    }

    public Set entrySet() {
        return new HashBiMap$Inverse$1(this);
    }

    Object writeReplace() {
        return new HashBiMap$InverseSerializedForm(this.this$0);
    }

    /* synthetic */ HashBiMap$Inverse(HashBiMap hashBiMap, HashBiMap$1 hashBiMap$1) {
        this(hashBiMap);
    }
}

