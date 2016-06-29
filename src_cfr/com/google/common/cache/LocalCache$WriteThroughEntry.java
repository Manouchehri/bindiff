/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import java.util.Map;
import javax.annotation.Nullable;

final class LocalCache$WriteThroughEntry
implements Map.Entry {
    final Object key;
    Object value;
    final /* synthetic */ LocalCache this$0;

    LocalCache$WriteThroughEntry(LocalCache localCache, Object object, Object object2) {
        this.this$0 = localCache;
        this.key = object;
        this.value = object2;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        if (!this.key.equals(entry.getKey())) return false;
        if (!this.value.equals(entry.getValue())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode() ^ this.value.hashCode();
    }

    public Object setValue(Object object) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        String string = String.valueOf(this.getKey());
        String string2 = String.valueOf(this.getValue());
        return new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append("=").append(string2).toString();
    }
}

