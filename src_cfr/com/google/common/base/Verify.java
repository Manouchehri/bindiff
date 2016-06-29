/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.VerifyException;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class Verify {
    public static void verify(boolean bl2) {
        if (bl2) return;
        throw new VerifyException();
    }

    public static /* varargs */ void verify(boolean bl2, @Nullable String string, @Nullable Object ... arrobject) {
        if (bl2) return;
        throw new VerifyException(Preconditions.format(string, arrobject));
    }

    public static Object verifyNotNull(@Nullable Object object) {
        return Verify.verifyNotNull(object, "expected a non-null reference", new Object[0]);
    }

    public static /* varargs */ Object verifyNotNull(@Nullable Object object, @Nullable String string, @Nullable Object ... arrobject) {
        Verify.verify(object != null, string, arrobject);
        return object;
    }

    private Verify() {
    }
}

