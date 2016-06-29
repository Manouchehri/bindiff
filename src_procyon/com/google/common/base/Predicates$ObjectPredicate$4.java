package com.google.common.base;

import javax.annotation.*;

enum Predicates$ObjectPredicate$4
{
    Predicates$ObjectPredicate$4(final String s, final int n) {
    }
    
    @Override
    public boolean apply(@Nullable final Object o) {
        return o != null;
    }
    
    @Override
    public String toString() {
        return "Predicates.notNull()";
    }
}
