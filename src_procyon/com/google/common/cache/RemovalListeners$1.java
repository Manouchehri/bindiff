package com.google.common.cache;

import java.util.concurrent.*;

final class RemovalListeners$1 implements RemovalListener
{
    final /* synthetic */ Executor val$executor;
    final /* synthetic */ RemovalListener val$listener;
    
    RemovalListeners$1(final Executor val$executor, final RemovalListener val$listener) {
        this.val$executor = val$executor;
        this.val$listener = val$listener;
    }
    
    @Override
    public void onRemoval(final RemovalNotification removalNotification) {
        this.val$executor.execute(new RemovalListeners$1$1(this, removalNotification));
    }
}
