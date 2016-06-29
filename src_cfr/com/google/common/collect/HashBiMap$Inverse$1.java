/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.HashBiMap$Inverse;
import com.google.common.collect.HashBiMap$Inverse$1$1;
import com.google.common.collect.Maps$EntrySet;
import java.util.Iterator;
import java.util.Map;

class HashBiMap$Inverse$1
extends Maps$EntrySet {
    final /* synthetic */ HashBiMap$Inverse this$1;

    HashBiMap$Inverse$1(HashBiMap$Inverse hashBiMap$Inverse) {
        this.this$1 = hashBiMap$Inverse;
    }

    @Override
    Map map() {
        return this.this$1;
    }

    @Override
    public Iterator iterator() {
        return new HashBiMap$Inverse$1$1(this);
    }
}

