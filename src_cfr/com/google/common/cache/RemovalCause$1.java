/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.RemovalCause;

final class RemovalCause$1
extends RemovalCause {
    RemovalCause$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    boolean wasEvicted() {
        return false;
    }
}

