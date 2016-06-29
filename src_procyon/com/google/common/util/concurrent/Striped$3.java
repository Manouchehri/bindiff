package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.*;

final class Striped$3 implements Supplier
{
    final /* synthetic */ int val$permits;
    
    Striped$3(final int val$permits) {
        this.val$permits = val$permits;
    }
    
    @Override
    public Semaphore get() {
        return new Striped$PaddedSemaphore(this.val$permits);
    }
}
