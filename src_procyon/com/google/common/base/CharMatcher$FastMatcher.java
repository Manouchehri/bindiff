package com.google.common.base;

abstract class CharMatcher$FastMatcher extends CharMatcher
{
    @Override
    public final CharMatcher precomputed() {
        return this;
    }
    
    @Override
    public CharMatcher negate() {
        return new CharMatcher$NegatedFastMatcher(this);
    }
}
