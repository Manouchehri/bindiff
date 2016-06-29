package com.google.common.cache;

enum CacheBuilder$NullListener implements RemovalListener
{
    INSTANCE("INSTANCE", 0);
    
    private CacheBuilder$NullListener(final String s, final int n) {
    }
    
    @Override
    public void onRemoval(final RemovalNotification removalNotification) {
    }
}
