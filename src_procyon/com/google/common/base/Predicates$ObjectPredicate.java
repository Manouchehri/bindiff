package com.google.common.base;

enum Predicates$ObjectPredicate implements Predicate
{
    ALWAYS_TRUE("ALWAYS_TRUE", 0), 
    ALWAYS_FALSE("ALWAYS_FALSE", 1), 
    IS_NULL("IS_NULL", 2), 
    NOT_NULL("NOT_NULL", 3);
    
    private Predicates$ObjectPredicate(final String s, final int n) {
    }
    
    Predicate withNarrowedType() {
        return this;
    }
}
