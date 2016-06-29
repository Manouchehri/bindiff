/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Map;

class ImmutableMap$SerializedForm
implements Serializable {
    private final Object[] keys;
    private final Object[] values;
    private static final long serialVersionUID = 0;

    ImmutableMap$SerializedForm(ImmutableMap immutableMap) {
        this.keys = new Object[immutableMap.size()];
        this.values = new Object[immutableMap.size()];
        int n2 = 0;
        UnmodifiableIterator unmodifiableIterator = immutableMap.entrySet().iterator();
        while (unmodifiableIterator.hasNext()) {
            Map.Entry entry = (Map.Entry)unmodifiableIterator.next();
            this.keys[n2] = entry.getKey();
            this.values[n2] = entry.getValue();
            ++n2;
        }
    }

    Object readResolve() {
        ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(this.keys.length);
        return this.createMap(immutableMap$Builder);
    }

    Object createMap(ImmutableMap$Builder immutableMap$Builder) {
        int n2 = 0;
        while (n2 < this.keys.length) {
            immutableMap$Builder.put(this.keys[n2], this.values[n2]);
            ++n2;
        }
        return immutableMap$Builder.build();
    }
}

