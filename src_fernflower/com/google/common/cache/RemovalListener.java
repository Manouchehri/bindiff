package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.RemovalNotification;

@GwtCompatible
public interface RemovalListener {
   void onRemoval(RemovalNotification var1);
}
