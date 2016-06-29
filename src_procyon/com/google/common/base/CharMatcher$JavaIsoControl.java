package com.google.common.base;

final class CharMatcher$JavaIsoControl extends CharMatcher$NamedFastMatcher
{
    static final CharMatcher$JavaIsoControl INSTANCE;
    
    private CharMatcher$JavaIsoControl() {
        super("CharMatcher.javaIsoControl()");
    }
    
    @Override
    public boolean matches(final char c) {
        return c <= '\u001f' || (c >= '\u007f' && c <= '\u009f');
    }
    
    static {
        INSTANCE = new CharMatcher$JavaIsoControl();
    }
}
