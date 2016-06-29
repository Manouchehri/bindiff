/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional$1;
import com.google.common.base.Preconditions;
import com.google.common.base.Present;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible(serializable=1)
public abstract class Optional
implements Serializable {
    private static final long serialVersionUID = 0;

    public static Optional absent() {
        return Absent.withType();
    }

    public static Optional of(Object object) {
        return new Present(Preconditions.checkNotNull(object));
    }

    public static Optional fromNullable(@Nullable Object object) {
        Optional optional;
        if (object == null) {
            optional = Optional.absent();
            return optional;
        }
        optional = new Present(object);
        return optional;
    }

    Optional() {
    }

    public abstract boolean isPresent();

    public abstract Object get();

    public abstract Object or(Object var1);

    public abstract Optional or(Optional var1);

    @Beta
    public abstract Object or(Supplier var1);

    @Nullable
    public abstract Object orNull();

    public abstract Set asSet();

    public abstract Optional transform(Function var1);

    public abstract boolean equals(@Nullable Object var1);

    public abstract int hashCode();

    public abstract String toString();

    @Beta
    public static Iterable presentInstances(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        return new Optional$1(iterable);
    }
}

