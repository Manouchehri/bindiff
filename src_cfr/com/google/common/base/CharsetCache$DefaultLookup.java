/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharsetCache$1;
import com.google.common.base.Function;
import java.nio.charset.Charset;

class CharsetCache$DefaultLookup
implements Function {
    private CharsetCache$DefaultLookup() {
    }

    public Charset apply(String string) {
        return Charset.forName(string);
    }

    /* synthetic */ CharsetCache$DefaultLookup(CharsetCache$1 charsetCache$1) {
        this();
    }
}

