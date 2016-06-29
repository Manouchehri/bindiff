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
final class Present
extends Optional {
    private final Object reference;
    private static final long serialVersionUID = 0;

    Present(Object object) {
        this.reference = object;
    }

    @Override
    public boolean isPresent() {
        return true;
    }

    @Override
    public Object get() {
        return this.reference;
    }

    @Override
    public Object or(Object object) {
        Preconditions.checkNotNull(object, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override
    public Optional or(Optional optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @Override
    public Object or(Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        return this.reference;
    }

    @Override
    public Object orNull() {
        return this.reference;
    }

    @Override
    public Set asSet() {
        return Collections.singleton(this.reference);
    }

    @Override
    public Optional transform(Function function) {
        return new Present(Preconditions.checkNotNull(function.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Present)) return false;
        Present present = (Present)object;
        return this.reference.equals(present.reference);
    }

    @Override
    public int hashCode() {
        return 1502476572 + this.reference.hashCode();
    }

    @Override
    public String toString() {
        String string = String.valueOf(this.reference);
        return new StringBuilder(13 + String.valueOf(string).length()).append("Optional.of(").append(string).append(")").toString();
    }
}

