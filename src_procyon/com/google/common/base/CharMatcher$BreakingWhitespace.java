package com.google.common.base;

final class CharMatcher$BreakingWhitespace extends CharMatcher
{
    static final CharMatcher INSTANCE;
    
    @Override
    public boolean matches(final char c) {
        switch (c) {
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
            default: {
                return c >= '\u2000' && c <= '\u200a';
            }
        }
    }
    
    @Override
    public String toString() {
        return "CharMatcher.breakingWhitespace()";
    }
    
    static {
        INSTANCE = new CharMatcher$BreakingWhitespace();
    }
}
