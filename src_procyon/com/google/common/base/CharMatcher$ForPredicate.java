package com.google.common.base;

final class CharMatcher$ForPredicate extends CharMatcher
{
    private final Predicate predicate;
    
    CharMatcher$ForPredicate(final Predicate predicate) {
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }
    
    @Override
    public boolean matches(final char c) {
        return this.predicate.apply(c);
    }
    
    @Override
    public boolean apply(final Character c) {
        return this.predicate.apply(Preconditions.checkNotNull(c));
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.predicate);
        return new StringBuilder(26 + String.valueOf(value).length()).append("CharMatcher.forPredicate(").append(value).append(")").toString();
    }
}
