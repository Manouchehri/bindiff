package com.google.common.util.concurrent;

import java.lang.ref.*;
import java.util.logging.*;
import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;

final class ServiceManager$ServiceListener extends Service$Listener
{
    final Service service;
    final WeakReference state;
    
    ServiceManager$ServiceListener(final Service service, final WeakReference state) {
        this.service = service;
        this.state = state;
    }
    
    @Override
    public void starting() {
        final ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState != null) {
            serviceManager$ServiceManagerState.transitionService(this.service, Service$State.NEW, Service$State.STARTING);
            if (!(this.service instanceof ServiceManager$NoOpService)) {
                ServiceManager.logger.log(Level.FINE, "Starting {0}.", this.service);
            }
        }
    }
    
    @Override
    public void running() {
        final ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState != null) {
            serviceManager$ServiceManagerState.transitionService(this.service, Service$State.STARTING, Service$State.RUNNING);
        }
    }
    
    @Override
    public void stopping(final Service$State service$State) {
        final ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState != null) {
            serviceManager$ServiceManagerState.transitionService(this.service, service$State, Service$State.STOPPING);
        }
    }
    
    @Override
    public void terminated(final Service$State service$State) {
        final ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState != null) {
            if (!(this.service instanceof ServiceManager$NoOpService)) {
                ServiceManager.logger.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[] { this.service, service$State });
            }
            serviceManager$ServiceManagerState.transitionService(this.service, service$State, Service$State.TERMINATED);
        }
    }
    
    @Override
    public void failed(final Service$State service$State, final Throwable t) {
        final ServiceManager$ServiceManagerState serviceManager$ServiceManagerState = (ServiceManager$ServiceManagerState)this.state.get();
        if (serviceManager$ServiceManagerState != null) {
            if (!(this.service instanceof ServiceManager$NoOpService) && service$State != Service$State.STARTING) {
                final Logger access$200 = ServiceManager.logger;
                final Level severe = Level.SEVERE;
                final String value = String.valueOf(this.service);
                final String value2 = String.valueOf(service$State);
                access$200.log(severe, new StringBuilder(34 + String.valueOf(value).length() + String.valueOf(value2).length()).append("Service ").append(value).append(" has failed in the ").append(value2).append(" state.").toString(), t);
            }
            serviceManager$ServiceManagerState.transitionService(this.service, service$State, Service$State.FAILED);
        }
    }
}
