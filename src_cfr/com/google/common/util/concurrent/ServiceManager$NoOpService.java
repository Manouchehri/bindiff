/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ServiceManager$1;

final class ServiceManager$NoOpService
extends AbstractService {
    private ServiceManager$NoOpService() {
    }

    @Override
    protected void doStart() {
        this.notifyStarted();
    }

    @Override
    protected void doStop() {
        this.notifyStopped();
    }

    /* synthetic */ ServiceManager$NoOpService(ServiceManager$1 serviceManager$1) {
        this();
    }
}

