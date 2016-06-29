/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;

final class BoundType$1
extends BoundType {
    BoundType$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    BoundType flip() {
        return CLOSED;
    }
}

