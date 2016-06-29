/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Monitor;
import java.util.concurrent.locks.Condition;
import javax.annotation.concurrent.GuardedBy;

@Beta
public abstract class Monitor$Guard {
    final Monitor monitor;
    final Condition condition;
    @GuardedBy(value="monitor.lock")
    int waiterCount = 0;
    @GuardedBy(value="monitor.lock")
    Monitor$Guard next;

    protected Monitor$Guard(Monitor monitor) {
        this.monitor = (Monitor)Preconditions.checkNotNull(monitor, "monitor");
        this.condition = Monitor.access$000(monitor).newCondition();
    }

    public abstract boolean isSatisfied();
}

