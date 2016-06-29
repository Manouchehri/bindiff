/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat;
import com.google.common.base.CaseFormat$1;
import com.google.common.base.CharMatcher;

final class CaseFormat$5
extends CaseFormat {
    CaseFormat$5(String string2, int n3, CharMatcher charMatcher, String string3) {
        super(string, n2, (CharMatcher)((Object)string2), (String)n3, null);
    }

    @Override
    String normalizeWord(String string) {
        return Ascii.toUpperCase(string);
    }

    @Override
    String convert(CaseFormat caseFormat, String string) {
        if (caseFormat == LOWER_HYPHEN) {
            return Ascii.toLowerCase(string.replace('_', '-'));
        }
        if (caseFormat != LOWER_UNDERSCORE) return super.convert(caseFormat, string);
        return Ascii.toLowerCase(string);
    }
}

