/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$EntrySet;
import com.google.common.collect.AbstractBiMap$EntrySet$1;
import com.google.common.collect.ForwardingMapEntry;
import java.util.Map;

class AbstractBiMap$EntrySet$1$1
extends ForwardingMapEntry {
    final /* synthetic */ Map.Entry val$finalEntry;
    final /* synthetic */ AbstractBiMap$EntrySet$1 this$2;

    AbstractBiMap$EntrySet$1$1(AbstractBiMap$EntrySet$1 var1_1, Map.Entry entry) {
        this.this$2 = var1_1;
        this.val$finalEntry = entry;
    }

    @Override
    protected Map.Entry delegate() {
        return this.val$finalEntry;
    }

    @Override
    public Object setValue(Object object) {
        Preconditions.checkState(this.this$2.this$1.contains(this), "entry no longer in map");
        if (Objects.equal(object, this.getValue())) {
            return object;
        }
        Preconditions.checkArgument(!this.this$2.this$1.this$0.containsValue(object), "value already present: %s", object);
        Object object2 = this.val$finalEntry.setValue(object);
        Preconditions.checkState(Objects.equal(object, this.this$2.this$1.this$0.get(this.getKey())), "entry no longer in map");
        AbstractBiMap.access$600(this.this$2.this$1.this$0, this.getKey(), true, object2, object);
        return object2;
    }
}

