/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners$1;
import com.google.common.cache.RemovalNotification;

class RemovalListeners$1$1
implements Runnable {
    final /* synthetic */ RemovalNotification val$notification;
    final /* synthetic */ RemovalListeners$1 this$0;

    RemovalListeners$1$1(RemovalListeners$1 var1_1, RemovalNotification removalNotification) {
        this.this$0 = var1_1;
        this.val$notification = removalNotification;
    }

    @Override
    public void run() {
        this.this$0.val$listener.onRemoval(this.val$notification);
    }
}

