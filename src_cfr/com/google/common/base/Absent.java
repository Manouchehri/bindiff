/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
final class Absent
extends Optional {
    static final Absent INSTANCE = new Absent();
    private static final long serialVersionUID = 0;

    static Optional withType() {
        return INSTANCE;
    }

    private Absent() {
    }

    @Override
    public boolean isPresent() {
        return false;
    }

    @Override
    public Object get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override
    public Object or(Object object) {
        return Preconditions.checkNotNull(object, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override
    public Optional or(Optional optional) {
        return (Optional)Preconditions.checkNotNull(optional);
    }

    @Override
    public Object or(Supplier supplier) {
        return Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }

    @Nullable
    @Override
    public Object orNull() {
        return null;
    }

    @Override
    public Set asSet() {
        return Collections.emptySet();
    }

    @Override
    public Optional transform(Function function) {
        Preconditions.checkNotNull(function);
        return Optional.absent();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object != this) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 2040732332;
    }

    @Override
    public String toString() {
        return "Optional.absent()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

