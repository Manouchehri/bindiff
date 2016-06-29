/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.Service;

@Beta
public abstract class ServiceManager$Listener {
    public void healthy() {
    }

    public void stopped() {
    }

    public void failure(Service service) {
    }
}

