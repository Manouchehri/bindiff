package com.google.common.base;

final class CharMatcher$JavaUpperCase extends CharMatcher
{
    static final CharMatcher$JavaUpperCase INSTANCE;
    
    @Override
    public boolean matches(final char c) {
        return Character.isUpperCase(c);
    }
    
    @Override
    public String toString() {
        return "CharMatcher.javaUpperCase()";
    }
    
    static {
        INSTANCE = new CharMatcher$JavaUpperCase();
    }
}
