/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
final class Platform {
    static boolean isInstanceOfThrowableClass(@Nullable Throwable throwable, Class class_) {
        return class_.isInstance(throwable);
    }

    private Platform() {
    }
}

