package com.google.common.base;

final class CharMatcher$JavaDigit extends CharMatcher
{
    static final CharMatcher$JavaDigit INSTANCE;
    
    @Override
    public boolean matches(final char c) {
        return Character.isDigit(c);
    }
    
    @Override
    public String toString() {
        return "CharMatcher.javaDigit()";
    }
    
    static {
        INSTANCE = new CharMatcher$JavaDigit();
    }
}
