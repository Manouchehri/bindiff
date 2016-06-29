package com.google.common.base;

import javax.annotation.*;

enum Functions$IdentityFunction implements Function
{
    INSTANCE("INSTANCE", 0);
    
    private Functions$IdentityFunction(final String s, final int n) {
    }
    
    @Nullable
    @Override
    public Object apply(@Nullable final Object o) {
        return o;
    }
    
    @Override
    public String toString() {
        return "Functions.identity()";
    }
}
