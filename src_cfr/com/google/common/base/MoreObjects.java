/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects$1;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Preconditions;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class MoreObjects {
    @CheckReturnValue
    public static Object firstNonNull(@Nullable Object object, @Nullable Object object2) {
        Object object3;
        if (object != null) {
            object3 = object;
            return object3;
        }
        object3 = Preconditions.checkNotNull(object2);
        return object3;
    }

    @CheckReturnValue
    public static MoreObjects$ToStringHelper toStringHelper(Object object) {
        return new MoreObjects$ToStringHelper(object.getClass().getSimpleName(), null);
    }

    @CheckReturnValue
    public static MoreObjects$ToStringHelper toStringHelper(Class class_) {
        return new MoreObjects$ToStringHelper(class_.getSimpleName(), null);
    }

    @CheckReturnValue
    public static MoreObjects$ToStringHelper toStringHelper(String string) {
        return new MoreObjects$ToStringHelper(string, null);
    }

    private MoreObjects() {
    }
}

