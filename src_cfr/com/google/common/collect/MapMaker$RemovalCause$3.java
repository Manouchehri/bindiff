/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMaker$1;
import com.google.common.collect.MapMaker$RemovalCause;

final class MapMaker$RemovalCause$3
extends MapMaker$RemovalCause {
    MapMaker$RemovalCause$3(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    boolean wasEvicted() {
        return true;
    }
}

