package com.google.common.cache;

enum ShimAsyncCache$LoadWhen
{
    NOT_PENDING_OR_AVAILABLE("NOT_PENDING_OR_AVAILABLE", 0), 
    ALWAYS("ALWAYS", 1);
    
    private ShimAsyncCache$LoadWhen(final String s, final int n) {
    }
}
