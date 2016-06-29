/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.BoundType$1;

final class BoundType$2
extends BoundType {
    BoundType$2(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    BoundType flip() {
        return OPEN;
    }
}

