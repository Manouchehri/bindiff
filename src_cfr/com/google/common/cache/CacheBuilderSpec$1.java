/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$Strength;

class CacheBuilderSpec$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$common$cache$LocalCache$Strength;

    static {
        $SwitchMap$com$google$common$cache$LocalCache$Strength = new int[LocalCache$Strength.values().length];
        try {
            CacheBuilderSpec$1.$SwitchMap$com$google$common$cache$LocalCache$Strength[LocalCache$Strength.WEAK.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            CacheBuilderSpec$1.$SwitchMap$com$google$common$cache$LocalCache$Strength[LocalCache$Strength.SOFT.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
    }
}

