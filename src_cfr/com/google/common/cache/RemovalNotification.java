/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.cache.RemovalCause;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public final class RemovalNotification
implements Map.Entry {
    @Nullable
    private final Object key;
    @Nullable
    private final Object value;
    private final RemovalCause cause;
    private static final long serialVersionUID = 0;

    public static RemovalNotification create(@Nullable Object object, @Nullable Object object2, RemovalCause removalCause) {
        return new RemovalNotification(object, object2, removalCause);
    }

    private RemovalNotification(@Nullable Object object, @Nullable Object object2, RemovalCause removalCause) {
        this.key = object;
        this.value = object2;
        this.cause = (RemovalCause)((Object)Preconditions.checkNotNull((Object)removalCause));
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }

    @Nullable
    public Object getKey() {
        return this.key;
    }

    @Nullable
    public Object getValue() {
        return this.value;
    }

    public final Object setValue(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        if (!Objects.equal(this.getKey(), entry.getKey())) return false;
        if (!Objects.equal(this.getValue(), entry.getValue())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int n2;
        Object object = this.getKey();
        Object object2 = this.getValue();
        int n3 = object == null ? 0 : object.hashCode();
        if (object2 == null) {
            n2 = 0;
            return n3 ^ n2;
        }
        n2 = object2.hashCode();
        return n3 ^ n2;
    }

    public String toString() {
        String string = String.valueOf(this.getKey());
        String string2 = String.valueOf(this.getValue());
        return new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append("=").append(string2).toString();
    }
}

