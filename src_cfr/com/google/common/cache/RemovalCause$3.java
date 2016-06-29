/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalCause$1;

final class RemovalCause$3
extends RemovalCause {
    RemovalCause$3(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    boolean wasEvicted() {
        return true;
    }
}

