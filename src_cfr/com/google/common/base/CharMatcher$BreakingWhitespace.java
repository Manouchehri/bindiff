/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;

final class CharMatcher$BreakingWhitespace
extends CharMatcher {
    static final CharMatcher INSTANCE = new CharMatcher$BreakingWhitespace();

    private CharMatcher$BreakingWhitespace() {
    }

    @Override
    public boolean matches(char c2) {
        switch (c2) {
            case '\t': 
            case '\n': 
            case '\u000b': 
            case '\f': 
            case '\r': 
            case ' ': 
            case '\u0085': 
            case '\u1680': 
            case '\u2028': 
            case '\u2029': 
            case '\u205f': 
            case '\u3000': {
                return true;
            }
            case '\u2007': {
                return false;
            }
        }
        if (c2 < '\u2000') return false;
        if (c2 > '\u200a') return false;
        return true;
    }

    @Override
    public String toString() {
        return "CharMatcher.breakingWhitespace()";
    }
}

