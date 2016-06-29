package com.google.common.util.concurrent;

import java.util.concurrent.atomic.*;
import com.google.common.base.*;
import java.util.concurrent.*;

class JdkFutureAdapters$ListenableFutureAdapter$1 implements Runnable
{
    final /* synthetic */ JdkFutureAdapters$ListenableFutureAdapter this$0;
    
    JdkFutureAdapters$ListenableFutureAdapter$1(final JdkFutureAdapters$ListenableFutureAdapter this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        try {
            Uninterruptibles.getUninterruptibly(this.this$0.delegate);
        }
        catch (Error error) {
            throw error;
        }
        catch (Throwable t) {}
        this.this$0.executionList.execute();
    }
}
