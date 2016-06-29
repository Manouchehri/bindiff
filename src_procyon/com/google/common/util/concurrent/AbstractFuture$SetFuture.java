package com.google.common.util.concurrent;

import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import com.google.common.annotations.*;
import com.google.errorprone.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.concurrent.*;
import java.util.logging.*;

final class AbstractFuture$SetFuture implements Runnable
{
    final ListenableFuture future;
    final /* synthetic */ AbstractFuture this$0;
    
    AbstractFuture$SetFuture(final AbstractFuture this$0, final ListenableFuture future) {
        this.this$0 = this$0;
        this.future = future;
    }
    
    @Override
    public void run() {
        if (this.this$0.value != this) {
            return;
        }
        this.this$0.completeWithFuture(this.future, this);
    }
}
