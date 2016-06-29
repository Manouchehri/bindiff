package com.google.common.base;

import javax.annotation.*;

enum BinaryPredicates$AlwaysTrue implements BinaryPredicate
{
    AlwaysTrue("AlwaysTrue", 0);
    
    private BinaryPredicates$AlwaysTrue(final String s, final int n) {
    }
    
    @Override
    public boolean apply(@Nullable final Object o, @Nullable final Object o2) {
        return true;
    }
}
