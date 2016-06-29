package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.logging.*;
import java.lang.ref.*;
import java.util.concurrent.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;

@Beta
public final class ServiceManager
{
    private static final Logger logger;
    private static final ListenerCallQueue$Callback HEALTHY_CALLBACK;
    private static final ListenerCallQueue$Callback STOPPED_CALLBACK;
    private final ServiceManager$ServiceManagerState state;
    private final ImmutableList services;
    
    public ServiceManager(final Iterable iterable) {
        ImmutableList services = ImmutableList.copyOf(iterable);
        if (services.isEmpty()) {
            ServiceManager.logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new ServiceManager$EmptyServiceManagerWarning((ServiceManager$1)null));
            services = ImmutableList.of(new ServiceManager$NoOpService(null));
        }
        this.state = new ServiceManager$ServiceManagerState(services);
        this.services = services;
        final WeakReference weakReference = new WeakReference((T)this.state);
        for (final Service service : services) {
            service.addListener(new ServiceManager$ServiceListener(service, weakReference), MoreExecutors.directExecutor());
            Preconditions.checkArgument(service.state() == Service$State.NEW, "Can only manage NEW services, %s", service);
        }
        this.state.markReady();
    }
    
    public void addListener(final ServiceManager$Listener serviceManager$Listener, final Executor executor) {
        this.state.addListener(serviceManager$Listener, executor);
    }
    
    public void addListener(final ServiceManager$Listener serviceManager$Listener) {
        this.state.addListener(serviceManager$Listener, MoreExecutors.directExecutor());
    }
    
    public ServiceManager startAsync() {
        for (final Service service : this.services) {
            final Service$State state = service.state();
            Preconditions.checkState(state == Service$State.NEW, "Service %s is %s, cannot start it.", service, state);
        }
        for (final Service service2 : this.services) {
            try {
                this.state.tryStartTiming(service2);
                service2.startAsync();
            }
            catch (IllegalStateException ex) {
                final Logger logger = ServiceManager.logger;
                final Level warning = Level.WARNING;
                final String value = String.valueOf(service2);
                logger.log(warning, new StringBuilder(24 + String.valueOf(value).length()).append("Unable to start Service ").append(value).toString(), ex);
            }
        }
        return this;
    }
    
    public void awaitHealthy() {
        this.state.awaitHealthy();
    }
    
    public void awaitHealthy(final long n, final TimeUnit timeUnit) {
        this.state.awaitHealthy(n, timeUnit);
    }
    
    public ServiceManager stopAsync() {
        final UnmodifiableIterator iterator = this.services.iterator();
        while (iterator.hasNext()) {
            iterator.next().stopAsync();
        }
        return this;
    }
    
    public void awaitStopped() {
        this.state.awaitStopped();
    }
    
    public void awaitStopped(final long n, final TimeUnit timeUnit) {
        this.state.awaitStopped(n, timeUnit);
    }
    
    public boolean isHealthy() {
        final UnmodifiableIterator iterator = this.services.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isRunning()) {
                return false;
            }
        }
        return true;
    }
    
    public ImmutableMultimap servicesByState() {
        return this.state.servicesByState();
    }
    
    public ImmutableMap startupTimes() {
        return this.state.startupTimes();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(ServiceManager.class).add("services", Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(ServiceManager$NoOpService.class)))).toString();
    }
    
    static {
        logger = Logger.getLogger(ServiceManager.class.getName());
        HEALTHY_CALLBACK = new ServiceManager$1("healthy()");
        STOPPED_CALLBACK = new ServiceManager$2("stopped()");
    }
}
