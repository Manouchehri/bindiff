/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import com.google.common.util.concurrent.ServiceManager;
import com.google.common.util.concurrent.ServiceManager$NoOpService;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;
import java.lang.ref.WeakReference;
import java.util.logging.Level;

final class ServiceManager$ServiceListener
extends Service$Listener {
    final Service service;
    final WeakReference state;

    ServiceManager$ServiceListener(Service service, WeakReference weakReference) {
        this.service = service;
        this.state = weakReference;
    }

    @Override
    public void starting() {
        ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState == null) return;
        serviceManager$ServiceManagerState.transitionService(this.service, Service$State.NEW, Service$State.STARTING);
        if (this.service instanceof ServiceManager$NoOpService) return;
        ServiceManager.access$200().log(Level.FINE, "Starting {0}.", this.service);
    }

    @Override
    public void running() {
        ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState == null) return;
        serviceManager$ServiceManagerState.transitionService(this.service, Service$State.STARTING, Service$State.RUNNING);
    }

    @Override
    public void stopping(Service$State service$State) {
        ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState == null) return;
        serviceManager$ServiceManagerState.transitionService(this.service, service$State, Service$State.STOPPING);
    }

    @Override
    public void terminated(Service$State service$State) {
        ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState == null) return;
        if (!(this.service instanceof ServiceManager$NoOpService)) {
            ServiceManager.access$200().log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.service, service$State});
        }
        serviceManager$ServiceManagerState.transitionService(this.service, service$State, Service$State.TERMINATED);
    }

    @Override
    public void failed(Service$State service$State, Throwable throwable) {
        ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState == null) return;
        if (!(this.service instanceof ServiceManager$NoOpService) && service$State != Service$State.STARTING) {
            String string = String.valueOf(this.service);
            String string2 = String.valueOf((Object)service$State);
            ServiceManager.access$200().log(Level.SEVERE, new StringBuilder(34 + String.valueOf(string).length() + String.valueOf(string2).length()).append("Service ").append(string).append(" has failed in the ").append(string2).append(" state.").toString(), throwable);
        }
        serviceManager$ServiceManagerState.transitionService(this.service, service$State, Service$State.FAILED);
    }
}

