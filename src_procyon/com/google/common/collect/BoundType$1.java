package com.google.common.collect;

enum BoundType$1
{
    BoundType$1(final String s, final int n) {
    }
    
    @Override
    BoundType flip() {
        return BoundType$1.CLOSED;
    }
}
