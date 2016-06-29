/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$1;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.Hashing;

class HashBiMap$1$MapEntry
extends AbstractMapEntry {
    HashBiMap$BiEntry delegate;
    final /* synthetic */ HashBiMap$1 this$1;

    HashBiMap$1$MapEntry(HashBiMap$1 var1_1, HashBiMap$BiEntry biEntry) {
        this.this$1 = var1_1;
        this.delegate = biEntry;
    }

    @Override
    public Object getKey() {
        return this.delegate.key;
    }

    @Override
    public Object getValue() {
        return this.delegate.value;
    }

    @Override
    public Object setValue(Object object) {
        Object object2 = this.delegate.value;
        int n2 = Hashing.smearedHash(object);
        if (n2 == this.delegate.valueHash && Objects.equal(object, object2)) {
            return object;
        }
        Preconditions.checkArgument(HashBiMap.access$400(this.this$1.this$0, object, n2) == null, "value already present: %s", object);
        HashBiMap.access$200(this.this$1.this$0, this.delegate);
        HashBiMap$BiEntry hashBiMap$BiEntry = new HashBiMap$BiEntry(this.delegate.key, this.delegate.keyHash, object, n2);
        HashBiMap.access$500(this.this$1.this$0, hashBiMap$BiEntry, this.delegate);
        this.delegate.prevInKeyInsertionOrder = null;
        this.delegate.nextInKeyInsertionOrder = null;
        this.this$1.expectedModCount = HashBiMap.access$100(this.this$1.this$0);
        if (this.this$1.toRemove == this.delegate) {
            this.this$1.toRemove = hashBiMap$BiEntry;
        }
        this.delegate = hashBiMap$BiEntry;
        return object2;
    }
}

