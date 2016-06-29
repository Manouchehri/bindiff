/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Enums;
import com.google.common.base.Optional;
import java.lang.ref.WeakReference;

@GwtCompatible(emulated=1)
final class Platform {
    private Platform() {
    }

    static long systemNanoTime() {
        return System.nanoTime();
    }

    static CharMatcher precomputeCharMatcher(CharMatcher charMatcher) {
        return charMatcher.precomputedInternal();
    }

    static Optional getEnumIfPresent(Class class_, String string) {
        Optional optional;
        WeakReference weakReference = (WeakReference)Enums.getEnumConstants(class_).get(string);
        if (weakReference == null) {
            optional = Optional.absent();
            return optional;
        }
        optional = Optional.of(class_.cast(weakReference.get()));
        return optional;
    }
}

