/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects$1;
import com.google.common.base.Objects$ToStringHelper;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class Objects {
    private Objects() {
    }

    @CheckReturnValue
    public static boolean equal(@Nullable Object object, @Nullable Object object2) {
        if (object == object2) return true;
        if (object == null) return false;
        if (!object.equals(object2)) return false;
        return true;
    }

    @CheckReturnValue
    public static /* varargs */ int hashCode(@Nullable Object ... arrobject) {
        return Arrays.hashCode(arrobject);
    }

    @CheckReturnValue
    @Deprecated
    public static Objects$ToStringHelper toStringHelper(Object object) {
        return new Objects$ToStringHelper(object.getClass().getSimpleName(), null);
    }

    @CheckReturnValue
    @Deprecated
    public static Objects$ToStringHelper toStringHelper(Class class_) {
        return new Objects$ToStringHelper(class_.getSimpleName(), null);
    }

    @CheckReturnValue
    @Deprecated
    public static Objects$ToStringHelper toStringHelper(String string) {
        return new Objects$ToStringHelper(string, null);
    }

    @CheckReturnValue
    @Deprecated
    public static Object firstNonNull(@Nullable Object object, @Nullable Object object2) {
        return MoreObjects.firstNonNull(object, object2);
    }
}

