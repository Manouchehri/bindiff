/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import com.google.common.util.concurrent.ServiceManager$1;
import com.google.common.util.concurrent.ServiceManager$2;
import com.google.common.util.concurrent.ServiceManager$EmptyServiceManagerWarning;
import com.google.common.util.concurrent.ServiceManager$Listener;
import com.google.common.util.concurrent.ServiceManager$NoOpService;
import com.google.common.util.concurrent.ServiceManager$ServiceListener;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public final class ServiceManager {
    private static final Logger logger = Logger.getLogger(ServiceManager.class.getName());
    private static final ListenerCallQueue$Callback HEALTHY_CALLBACK = new ServiceManager$1("healthy()");
    private static final ListenerCallQueue$Callback STOPPED_CALLBACK = new ServiceManager$2("stopped()");
    private final ServiceManager$ServiceManagerState state;
    private final ImmutableList services;

    public ServiceManager(Iterable iterable) {
        ImmutableList immutableList = ImmutableList.copyOf(iterable);
        if (immutableList.isEmpty()) {
            logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new ServiceManager$EmptyServiceManagerWarning(null));
            immutableList = ImmutableList.of(new ServiceManager$NoOpService(null));
        }
        this.state = new ServiceManager$ServiceManagerState(immutableList);
        this.services = immutableList;
        WeakReference<ServiceManager$ServiceManagerState> weakReference = new WeakReference<ServiceManager$ServiceManagerState>(this.state);
        UnmodifiableIterator unmodifiableIterator = immutableList.iterator();
        do {
            if (!unmodifiableIterator.hasNext()) {
                this.state.markReady();
                return;
            }
            Service service = (Service)unmodifiableIterator.next();
            service.addListener(new ServiceManager$ServiceListener(service, weakReference), MoreExecutors.directExecutor());
            Preconditions.checkArgument(service.state() == Service$State.NEW, "Can only manage NEW services, %s", service);
        } while (true);
    }

    public void addListener(ServiceManager$Listener serviceManager$Listener, Executor executor) {
        this.state.addListener(serviceManager$Listener, executor);
    }

    public void addListener(ServiceManager$Listener serviceManager$Listener) {
        this.state.addListener(serviceManager$Listener, MoreExecutors.directExecutor());
    }

    public ServiceManager startAsync() {
        for (Service service2 : this.services) {
            Service$State service$State = service2.state();
            Preconditions.checkState(service$State == Service$State.NEW, "Service %s is %s, cannot start it.", new Object[]{service2, service$State});
        }
        UnmodifiableIterator unmodifiableIterator = this.services.iterator();
        while (unmodifiableIterator.hasNext()) {
            Service service2;
            service2 = (Service)unmodifiableIterator.next();
            try {
                this.state.tryStartTiming(service2);
                service2.startAsync();
            }
            catch (IllegalStateException var3_4) {
                String string = String.valueOf(service2);
                logger.log(Level.WARNING, new StringBuilder(24 + String.valueOf(string).length()).append("Unable to start Service ").append(string).toString(), var3_4);
                continue;
            }
        }
        return this;
    }

    public void awaitHealthy() {
        this.state.awaitHealthy();
    }

    public void awaitHealthy(long l2, TimeUnit timeUnit) {
        this.state.awaitHealthy(l2, timeUnit);
    }

    public ServiceManager stopAsync() {
        UnmodifiableIterator unmodifiableIterator = this.services.iterator();
        while (unmodifiableIterator.hasNext()) {
            Service service = (Service)unmodifiableIterator.next();
            service.stopAsync();
        }
        return this;
    }

    public void awaitStopped() {
        this.state.awaitStopped();
    }

    public void awaitStopped(long l2, TimeUnit timeUnit) {
        this.state.awaitStopped(l2, timeUnit);
    }

    public boolean isHealthy() {
        Service service;
        UnmodifiableIterator unmodifiableIterator = this.services.iterator();
        do {
            if (!unmodifiableIterator.hasNext()) return true;
        } while ((service = (Service)unmodifiableIterator.next()).isRunning());
        return false;
    }

    public ImmutableMultimap servicesByState() {
        return this.state.servicesByState();
    }

    public ImmutableMap startupTimes() {
        return this.state.startupTimes();
    }

    public String toString() {
        return MoreObjects.toStringHelper(ServiceManager.class).add("services", Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(ServiceManager$NoOpService.class)))).toString();
    }

    static /* synthetic */ Logger access$200() {
        return logger;
    }

    static /* synthetic */ ListenerCallQueue$Callback access$300() {
        return STOPPED_CALLBACK;
    }

    static /* synthetic */ ListenerCallQueue$Callback access$400() {
        return HEALTHY_CALLBACK;
    }
}

