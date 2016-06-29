/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible
final class CollectPreconditions {
    CollectPreconditions() {
    }

    static void checkEntryNotNull(Object object, Object object2) {
        if (object == null) {
            String string = String.valueOf(object2);
            throw new NullPointerException(new StringBuilder(24 + String.valueOf(string).length()).append("null key in entry: null=").append(string).toString());
        }
        if (object2 != null) return;
        String string = String.valueOf(object);
        throw new NullPointerException(new StringBuilder(26 + String.valueOf(string).length()).append("null value in entry: ").append(string).append("=null").toString());
    }

    static int checkNonnegative(int n2, String string) {
        if (n2 >= 0) return n2;
        throw new IllegalArgumentException(new StringBuilder(40 + String.valueOf(string).length()).append(string).append(" cannot be negative but was: ").append(n2).toString());
    }

    static void checkRemove(boolean bl2) {
        Preconditions.checkState(bl2, "no calls to next() since the last call to remove()");
    }
}

