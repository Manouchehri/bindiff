/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.WellBehavedMap;
import com.google.common.collect.WellBehavedMap$EntrySet;
import com.google.common.collect.WellBehavedMap$EntrySet$1;

class WellBehavedMap$EntrySet$1$1
extends AbstractMapEntry {
    final /* synthetic */ Object val$key;
    final /* synthetic */ WellBehavedMap$EntrySet$1 this$2;

    WellBehavedMap$EntrySet$1$1(WellBehavedMap$EntrySet$1 var1_1, Object object) {
        this.this$2 = var1_1;
        this.val$key = object;
    }

    @Override
    public Object getKey() {
        return this.val$key;
    }

    @Override
    public Object getValue() {
        return this.this$2.this$1.this$0.get(this.val$key);
    }

    @Override
    public Object setValue(Object object) {
        return this.this$2.this$1.this$0.put(this.val$key, object);
    }
}

