package com.google.common.base;

final class CharMatcher$JavaLowerCase extends CharMatcher
{
    static final CharMatcher$JavaLowerCase INSTANCE;
    
    @Override
    public boolean matches(final char c) {
        return Character.isLowerCase(c);
    }
    
    @Override
    public String toString() {
        return "CharMatcher.javaLowerCase()";
    }
    
    static {
        INSTANCE = new CharMatcher$JavaLowerCase();
    }
}
