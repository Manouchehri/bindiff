package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.*;

final class Striped$4 implements Supplier
{
    final /* synthetic */ int val$permits;
    
    Striped$4(final int val$permits) {
        this.val$permits = val$permits;
    }
    
    @Override
    public Semaphore get() {
        return new Semaphore(this.val$permits, false);
    }
}
