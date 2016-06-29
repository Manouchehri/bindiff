package com.google.common.base;

abstract class CharMatcher$NamedFastMatcher extends CharMatcher$FastMatcher
{
    private final String description;
    
    CharMatcher$NamedFastMatcher(final String s) {
        this.description = (String)Preconditions.checkNotNull(s);
    }
    
    @Override
    public final String toString() {
        return this.description;
    }
}
