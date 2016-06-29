package com.google.common.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

enum CacheBuilder$NullListener implements RemovalListener {
   INSTANCE;

   public void onRemoval(RemovalNotification var1) {
   }
}
