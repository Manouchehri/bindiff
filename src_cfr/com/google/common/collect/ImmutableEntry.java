/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapEntry;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
class ImmutableEntry
extends AbstractMapEntry
implements Serializable {
    final Object key;
    final Object value;
    private static final long serialVersionUID = 0;

    ImmutableEntry(@Nullable Object object, @Nullable Object object2) {
        this.key = object;
        this.value = object2;
    }

    @Nullable
    @Override
    public final Object getKey() {
        return this.key;
    }

    @Nullable
    @Override
    public final Object getValue() {
        return this.value;
    }

    @Override
    public final Object setValue(Object object) {
        throw new UnsupportedOperationException();
    }
}

