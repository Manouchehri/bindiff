package com.google.common.collect;

import com.google.common.annotations.*;

@GwtIncompatible("To be supported")
enum GenericMapMaker$NullListener implements MapMaker$RemovalListener
{
    INSTANCE("INSTANCE", 0);
    
    private GenericMapMaker$NullListener(final String s, final int n) {
    }
    
    @Override
    public void onRemoval(final MapMaker$RemovalNotification mapMaker$RemovalNotification) {
    }
}
