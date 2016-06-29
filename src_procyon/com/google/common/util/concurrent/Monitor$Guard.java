package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import javax.annotation.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.*;
import com.google.common.base.*;

@Beta
public abstract class Monitor$Guard
{
    final Monitor monitor;
    final Condition condition;
    @GuardedBy("monitor.lock")
    int waiterCount;
    @GuardedBy("monitor.lock")
    Monitor$Guard next;
    
    protected Monitor$Guard(final Monitor monitor) {
        this.waiterCount = 0;
        this.monitor = (Monitor)Preconditions.checkNotNull(monitor, (Object)"monitor");
        this.condition = monitor.lock.newCondition();
    }
    
    public abstract boolean isSatisfied();
}
