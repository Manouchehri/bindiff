package com.google.common.base;

final class CharMatcher$Ascii extends CharMatcher$NamedFastMatcher
{
    static final CharMatcher$Ascii INSTANCE;
    
    CharMatcher$Ascii() {
        super("CharMatcher.ascii()");
    }
    
    @Override
    public boolean matches(final char c) {
        return c <= '\u007f';
    }
    
    static {
        INSTANCE = new CharMatcher$Ascii();
    }
}
