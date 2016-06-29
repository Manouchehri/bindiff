package com.google.common.base;

import javax.annotation.*;

enum BinaryPredicates$Identity implements BinaryPredicate
{
    Identity("Identity", 0);
    
    private BinaryPredicates$Identity(final String s, final int n) {
    }
    
    @Override
    public boolean apply(@Nullable final Object o, @Nullable final Object o2) {
        return o == o2;
    }
}
