package com.google.common.base;

import javax.annotation.*;

enum BinaryPredicates$AlwaysFalse implements BinaryPredicate
{
    AlwaysFalse("AlwaysFalse", 0);
    
    private BinaryPredicates$AlwaysFalse(final String s, final int n) {
    }
    
    @Override
    public boolean apply(@Nullable final Object o, @Nullable final Object o2) {
        return false;
    }
}
