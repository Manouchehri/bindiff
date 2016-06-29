package com.google.common.base;

import javax.annotation.*;

enum BinaryPredicates$Equality implements BinaryPredicate
{
    Equality("Equality", 0);
    
    private BinaryPredicates$Equality(final String s, final int n) {
    }
    
    @Override
    public boolean apply(@Nullable final Object o, @Nullable final Object o2) {
        return Objects.equal(o, o2);
    }
}
