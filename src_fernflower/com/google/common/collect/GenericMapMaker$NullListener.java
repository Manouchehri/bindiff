package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMaker$RemovalNotification;

@GwtIncompatible("To be supported")
enum GenericMapMaker$NullListener implements MapMaker$RemovalListener {
   INSTANCE;

   public void onRemoval(MapMaker$RemovalNotification var1) {
   }
}
