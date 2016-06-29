package com.google.common.base;

class CharMatcher$NegatedFastMatcher extends CharMatcher$Negated
{
    CharMatcher$NegatedFastMatcher(final CharMatcher charMatcher) {
        super(charMatcher);
    }
    
    @Override
    public final CharMatcher precomputed() {
        return this;
    }
}
