package com.google.common.cache;

enum CacheBuilder$OneWeigher implements Weigher
{
    INSTANCE("INSTANCE", 0);
    
    private CacheBuilder$OneWeigher(final String s, final int n) {
    }
    
    @Override
    public int weigh(final Object o, final Object o2) {
        return 1;
    }
}
