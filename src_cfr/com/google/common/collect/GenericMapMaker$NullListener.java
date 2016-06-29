/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMaker$RemovalNotification;

@GwtIncompatible(value="To be supported")
enum GenericMapMaker$NullListener implements MapMaker$RemovalListener
{
    INSTANCE;
    

    private GenericMapMaker$NullListener() {
    }

    @Override
    public void onRemoval(MapMaker.RemovalNotification removalNotification) {
    }
}

