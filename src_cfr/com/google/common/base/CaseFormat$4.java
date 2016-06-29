/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CaseFormat;
import com.google.common.base.CaseFormat$1;
import com.google.common.base.CharMatcher;

final class CaseFormat$4
extends CaseFormat {
    CaseFormat$4(String string2, int n3, CharMatcher charMatcher, String string3) {
        super(string, n2, (CharMatcher)((Object)string2), (String)n3, null);
    }

    @Override
    String normalizeWord(String string) {
        return CaseFormat.access$100(string);
    }
}

