/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse;
import com.google.common.collect.HashBiMap$Inverse$1;
import com.google.common.collect.HashBiMap$Inverse$1$1;
import com.google.common.collect.Hashing;

class HashBiMap$Inverse$1$1$InverseEntry
extends AbstractMapEntry {
    HashBiMap$BiEntry delegate;
    final /* synthetic */ HashBiMap$Inverse$1$1 this$3;

    HashBiMap$Inverse$1$1$InverseEntry(HashBiMap$Inverse$1$1 var1_1, HashBiMap$BiEntry hashBiMap$BiEntry) {
        this.this$3 = var1_1;
        this.delegate = hashBiMap$BiEntry;
    }

    @Override
    public Object getKey() {
        return this.delegate.value;
    }

    @Override
    public Object getValue() {
        return this.delegate.key;
    }

    @Override
    public Object setValue(Object object) {
        HashBiMap$BiEntry hashBiMap$BiEntry;
        Object object2 = this.delegate.key;
        int n2 = Hashing.smearedHash(object);
        if (n2 == this.delegate.keyHash && Objects.equal(object, object2)) {
            return object;
        }
        Preconditions.checkArgument(HashBiMap.access$300(this.this$3.this$2.this$1.this$0, object, n2) == null, "value already present: %s", object);
        HashBiMap.access$200(this.this$3.this$2.this$1.this$0, this.delegate);
        this.delegate = hashBiMap$BiEntry = new HashBiMap$BiEntry(object, n2, this.delegate.value, this.delegate.valueHash);
        HashBiMap.access$500(this.this$3.this$2.this$1.this$0, hashBiMap$BiEntry, null);
        this.this$3.expectedModCount = HashBiMap.access$100(this.this$3.this$2.this$1.this$0);
        return object2;
    }
}

