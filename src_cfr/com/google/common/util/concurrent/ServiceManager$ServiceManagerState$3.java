/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;
import java.util.Map;

class ServiceManager$ServiceManagerState$3
implements Function {
    final /* synthetic */ ServiceManager$ServiceManagerState this$0;

    ServiceManager$ServiceManagerState$3(ServiceManager$ServiceManagerState serviceManager$ServiceManagerState) {
        this.this$0 = serviceManager$ServiceManagerState;
    }

    public Long apply(Map.Entry entry) {
        return (Long)entry.getValue();
    }
}

