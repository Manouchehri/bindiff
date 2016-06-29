/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners$1$1;
import com.google.common.cache.RemovalNotification;
import java.util.concurrent.Executor;

final class RemovalListeners$1
implements RemovalListener {
    final /* synthetic */ Executor val$executor;
    final /* synthetic */ RemovalListener val$listener;

    RemovalListeners$1(Executor executor, RemovalListener removalListener) {
        this.val$executor = executor;
        this.val$listener = removalListener;
    }

    @Override
    public void onRemoval(RemovalNotification removalNotification) {
        this.val$executor.execute(new RemovalListeners$1$1(this, removalNotification));
    }
}

