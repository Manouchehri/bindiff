/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet$EntrySetSerializedForm;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
abstract class ImmutableMapEntrySet
extends ImmutableSet {
    ImmutableMapEntrySet() {
    }

    abstract ImmutableMap map();

    @Override
    public int size() {
        return this.map().size();
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        Object object2 = this.map().get(entry.getKey());
        if (object2 == null) return false;
        if (!object2.equals(entry.getValue())) return false;
        return true;
    }

    @Override
    boolean isPartialView() {
        return this.map().isPartialView();
    }

    @GwtIncompatible(value="not used in GWT")
    @Override
    boolean isHashCodeFast() {
        return this.map().isHashCodeFast();
    }

    @Override
    public int hashCode() {
        return this.map().hashCode();
    }

    @GwtIncompatible(value="serialization")
    @Override
    Object writeReplace() {
        return new ImmutableMapEntrySet$EntrySetSerializedForm(this.map());
    }
}

