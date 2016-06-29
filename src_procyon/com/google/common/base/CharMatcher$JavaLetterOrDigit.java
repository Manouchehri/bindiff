package com.google.common.base;

final class CharMatcher$JavaLetterOrDigit extends CharMatcher
{
    static final CharMatcher$JavaLetterOrDigit INSTANCE;
    
    @Override
    public boolean matches(final char c) {
        return Character.isLetterOrDigit(c);
    }
    
    @Override
    public String toString() {
        return "CharMatcher.javaLetterOrDigit()";
    }
    
    static {
        INSTANCE = new CharMatcher$JavaLetterOrDigit();
    }
}
