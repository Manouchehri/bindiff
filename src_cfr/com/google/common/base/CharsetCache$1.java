/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharsetCache;
import java.util.LinkedHashMap;
import java.util.Map;

class CharsetCache$1
extends LinkedHashMap {
    final /* synthetic */ int val$missCacheSize;
    final /* synthetic */ CharsetCache this$0;

    CharsetCache$1(CharsetCache charsetCache, int n2, float f2, boolean bl2, int n3) {
        this.this$0 = charsetCache;
        this.val$missCacheSize = n3;
        super(n2, f2, bl2);
    }

    protected boolean removeEldestEntry(Map.Entry entry) {
        if (this.size() <= this.val$missCacheSize) return false;
        return true;
    }
}

