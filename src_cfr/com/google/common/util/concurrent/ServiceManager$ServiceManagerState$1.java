/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.Multiset;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service$State;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;

class ServiceManager$ServiceManagerState$1
extends Monitor$Guard {
    final /* synthetic */ ServiceManager$ServiceManagerState this$0;

    ServiceManager$ServiceManagerState$1(ServiceManager$ServiceManagerState serviceManager$ServiceManagerState, Monitor monitor) {
        this.this$0 = serviceManager$ServiceManagerState;
        super(monitor);
    }

    @Override
    public boolean isSatisfied() {
        if (this.this$0.states.count((Object)Service$State.RUNNING) == this.this$0.numberOfServices) return true;
        if (this.this$0.states.contains((Object)Service$State.STOPPING)) return true;
        if (this.this$0.states.contains((Object)Service$State.TERMINATED)) return true;
        if (this.this$0.states.contains((Object)Service$State.FAILED)) return true;
        return false;
    }
}

