package com.google.common.base;

final class CharMatcher$JavaLetter extends CharMatcher
{
    static final CharMatcher$JavaLetter INSTANCE;
    
    @Override
    public boolean matches(final char c) {
        return Character.isLetter(c);
    }
    
    @Override
    public String toString() {
        return "CharMatcher.javaLetter()";
    }
    
    static {
        INSTANCE = new CharMatcher$JavaLetter();
    }
}
