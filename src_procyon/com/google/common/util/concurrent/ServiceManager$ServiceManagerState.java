package com.google.common.util.concurrent;

import javax.annotation.concurrent.*;
import java.util.concurrent.*;
import java.util.*;
import com.google.common.annotations.*;
import java.util.logging.*;
import java.lang.ref.*;
import com.google.common.base.*;
import com.google.common.collect.*;

final class ServiceManager$ServiceManagerState
{
    final Monitor monitor;
    @GuardedBy("monitor")
    final SetMultimap servicesByState;
    @GuardedBy("monitor")
    final Multiset states;
    @GuardedBy("monitor")
    final Map startupTimers;
    @GuardedBy("monitor")
    boolean ready;
    @GuardedBy("monitor")
    boolean transitioned;
    final int numberOfServices;
    final Monitor$Guard awaitHealthGuard;
    final Monitor$Guard stoppedGuard;
    @GuardedBy("monitor")
    final List listeners;
    
    ServiceManager$ServiceManagerState(final ImmutableCollection collection) {
        this.monitor = new Monitor();
        this.servicesByState = MultimapBuilder.enumKeys(Service$State.class).linkedHashSetValues().build();
        this.states = this.servicesByState.keys();
        this.startupTimers = Maps.newIdentityHashMap();
        this.awaitHealthGuard = new ServiceManager$ServiceManagerState$1(this, this.monitor);
        this.stoppedGuard = new ServiceManager$ServiceManagerState$2(this, this.monitor);
        this.listeners = Collections.synchronizedList(new ArrayList<Object>());
        this.numberOfServices = collection.size();
        this.servicesByState.putAll(Service$State.NEW, collection);
    }
    
    void tryStartTiming(final Service service) {
        this.monitor.enter();
        try {
            if (this.startupTimers.get(service) == null) {
                this.startupTimers.put(service, Stopwatch.createStarted());
            }
        }
        finally {
            this.monitor.leave();
        }
    }
    
    void markReady() {
        this.monitor.enter();
        try {
            if (this.transitioned) {
                final ArrayList arrayList = Lists.newArrayList();
                for (final Service service : this.servicesByState().values()) {
                    if (service.state() != Service$State.NEW) {
                        arrayList.add(service);
                    }
                }
                final String value = String.valueOf("Services started transitioning asynchronously before the ServiceManager was constructed: ");
                final String value2 = String.valueOf(arrayList);
                throw new IllegalArgumentException(new StringBuilder(0 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(value2).toString());
            }
            this.ready = true;
        }
        finally {
            this.monitor.leave();
        }
    }
    
    void addListener(final ServiceManager$Listener serviceManager$Listener, final Executor executor) {
        Preconditions.checkNotNull(serviceManager$Listener, (Object)"listener");
        Preconditions.checkNotNull(executor, (Object)"executor");
        this.monitor.enter();
        try {
            if (!this.stoppedGuard.isSatisfied()) {
                this.listeners.add(new ListenerCallQueue(serviceManager$Listener, executor));
            }
        }
        finally {
            this.monitor.leave();
        }
    }
    
    void awaitHealthy() {
        this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
        try {
            this.checkHealthy();
        }
        finally {
            this.monitor.leave();
        }
    }
    
    void awaitHealthy(final long n, final TimeUnit timeUnit) {
        this.monitor.enter();
        try {
            if (!this.monitor.waitForUninterruptibly(this.awaitHealthGuard, n, timeUnit)) {
                final String value = String.valueOf("Timeout waiting for the services to become healthy. The following services have not started: ");
                final String value2 = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.in(ImmutableSet.of(Service$State.NEW, Service$State.STARTING))));
                throw new TimeoutException(new StringBuilder(0 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(value2).toString());
            }
            this.checkHealthy();
        }
        finally {
            this.monitor.leave();
        }
    }
    
    void awaitStopped() {
        this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
        this.monitor.leave();
    }
    
    void awaitStopped(final long n, final TimeUnit timeUnit) {
        this.monitor.enter();
        try {
            if (!this.monitor.waitForUninterruptibly(this.stoppedGuard, n, timeUnit)) {
                final String value = String.valueOf("Timeout waiting for the services to stop. The following services have not stopped: ");
                final String value2 = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service$State.TERMINATED, Service$State.FAILED)))));
                throw new TimeoutException(new StringBuilder(0 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(value2).toString());
            }
        }
        finally {
            this.monitor.leave();
        }
    }
    
    ImmutableMultimap servicesByState() {
        final ImmutableSetMultimap$Builder builder = ImmutableSetMultimap.builder();
        this.monitor.enter();
        try {
            for (final Map.Entry entry : this.servicesByState.entries()) {
                if (!(entry.getValue() instanceof ServiceManager$NoOpService)) {
                    builder.put((Map.Entry)entry);
                }
            }
        }
        finally {
            this.monitor.leave();
        }
        return builder.build();
    }
    
    ImmutableMap startupTimes() {
        this.monitor.enter();
        ArrayList arrayListWithCapacity;
        try {
            arrayListWithCapacity = Lists.newArrayListWithCapacity(this.startupTimers.size());
            for (final Map.Entry<Service, V> entry : this.startupTimers.entrySet()) {
                final Service service = entry.getKey();
                final Stopwatch stopwatch = (Stopwatch)entry.getValue();
                if (!stopwatch.isRunning() && !(service instanceof ServiceManager$NoOpService)) {
                    arrayListWithCapacity.add(Maps.immutableEntry(service, stopwatch.elapsed(TimeUnit.MILLISECONDS)));
                }
            }
        }
        finally {
            this.monitor.leave();
        }
        Collections.sort((List<Object>)arrayListWithCapacity, Ordering.natural().onResultOf(new ServiceManager$ServiceManagerState$3(this)));
        return ImmutableMap.copyOf(arrayListWithCapacity);
    }
    
    void transitionService(final Service service, final Service$State service$State, final Service$State service$State2) {
        Preconditions.checkNotNull(service);
        Preconditions.checkArgument(service$State != service$State2);
        this.monitor.enter();
        try {
            this.transitioned = true;
            if (!this.ready) {
                return;
            }
            Preconditions.checkState(this.servicesByState.remove(service$State, service), "Service %s not at the expected location in the state map %s", service, service$State);
            Preconditions.checkState(this.servicesByState.put(service$State2, service), "Service %s in the state map unexpectedly at %s", service, service$State2);
            Stopwatch started = this.startupTimers.get(service);
            if (started == null) {
                started = Stopwatch.createStarted();
                this.startupTimers.put(service, started);
            }
            if (service$State2.compareTo(Service$State.RUNNING) >= 0 && started.isRunning()) {
                started.stop();
                if (!(service instanceof ServiceManager$NoOpService)) {
                    ServiceManager.logger.log(Level.FINE, "Started {0} in {1}.", new Object[] { service, started });
                }
            }
            if (service$State2 == Service$State.FAILED) {
                this.fireFailedListeners(service);
            }
            if (this.states.count(Service$State.RUNNING) == this.numberOfServices) {
                this.fireHealthyListeners();
            }
            else if (this.states.count(Service$State.TERMINATED) + this.states.count(Service$State.FAILED) == this.numberOfServices) {
                this.fireStoppedListeners();
            }
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
    }
    
    @GuardedBy("monitor")
    void fireStoppedListeners() {
        ServiceManager.STOPPED_CALLBACK.enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    void fireHealthyListeners() {
        ServiceManager.HEALTHY_CALLBACK.enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    void fireFailedListeners(final Service service) {
        final String value = String.valueOf(service);
        new ServiceManager$ServiceManagerState$4(this, new StringBuilder(18 + String.valueOf(value).length()).append("failed({service=").append(value).append("})").toString(), service).enqueueOn(this.listeners);
    }
    
    void executeListeners() {
        Preconditions.checkState(!this.monitor.isOccupiedByCurrentThread(), (Object)"It is incorrect to execute listeners with the monitor held.");
        for (int i = 0; i < this.listeners.size(); ++i) {
            ((ListenerCallQueue)this.listeners.get(i)).execute();
        }
    }
    
    @GuardedBy("monitor")
    void checkHealthy() {
        if (this.states.count(Service$State.RUNNING) != this.numberOfServices) {
            final String value = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.equalTo(Service$State.RUNNING))));
            final IllegalStateException ex = new IllegalStateException(new StringBuilder(79 + String.valueOf(value).length()).append("Expected to be healthy after starting. The following services are not running: ").append(value).toString());
            final Iterator<Service> iterator = this.servicesByState.get((Object)Service$State.FAILED).iterator();
            while (iterator.hasNext()) {
                ex.addSuppressed(new ServiceManager$FailedService(iterator.next()));
            }
            throw ex;
        }
    }
}
