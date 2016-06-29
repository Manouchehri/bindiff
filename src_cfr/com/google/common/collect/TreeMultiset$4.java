/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;

class TreeMultiset$4 {
    static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType;

    static {
        $SwitchMap$com$google$common$collect$BoundType = new int[BoundType.values().length];
        try {
            TreeMultiset$4.$SwitchMap$com$google$common$collect$BoundType[BoundType.OPEN.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            TreeMultiset$4.$SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
    }
}

