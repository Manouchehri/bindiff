/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSetMultimap$Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$State;
import com.google.common.util.concurrent.ServiceManager;
import com.google.common.util.concurrent.ServiceManager$FailedService;
import com.google.common.util.concurrent.ServiceManager$Listener;
import com.google.common.util.concurrent.ServiceManager$NoOpService;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState$1;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState$2;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState$3;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState$4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import javax.annotation.concurrent.GuardedBy;

final class ServiceManager$ServiceManagerState {
    final Monitor monitor = new Monitor();
    @GuardedBy(value="monitor")
    final SetMultimap servicesByState = MultimapBuilder.enumKeys(Service$State.class).linkedHashSetValues().build();
    @GuardedBy(value="monitor")
    final Multiset states = this.servicesByState.keys();
    @GuardedBy(value="monitor")
    final Map startupTimers = Maps.newIdentityHashMap();
    @GuardedBy(value="monitor")
    boolean ready;
    @GuardedBy(value="monitor")
    boolean transitioned;
    final int numberOfServices;
    final Monitor$Guard awaitHealthGuard;
    final Monitor$Guard stoppedGuard;
    @GuardedBy(value="monitor")
    final List listeners;

    ServiceManager$ServiceManagerState(ImmutableCollection immutableCollection) {
        this.awaitHealthGuard = new ServiceManager$ServiceManagerState$1(this, this.monitor);
        this.stoppedGuard = new ServiceManager$ServiceManagerState$2(this, this.monitor);
        this.listeners = Collections.synchronizedList(new ArrayList());
        this.numberOfServices = immutableCollection.size();
        this.servicesByState.putAll((Object)Service$State.NEW, immutableCollection);
    }

    void tryStartTiming(Service service) {
        this.monitor.enter();
        try {
            Stopwatch stopwatch = (Stopwatch)this.startupTimers.get(service);
            if (stopwatch != null) return;
            this.startupTimers.put(service, Stopwatch.createStarted());
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void markReady() {
        this.monitor.enter();
        try {
            Object object2;
            if (!this.transitioned) {
                this.ready = true;
                return;
            }
            ArrayList arrayList = Lists.newArrayList();
            for (Object object2 : this.servicesByState().values()) {
                if (object2.state() == Service$State.NEW) continue;
                arrayList.add(object2);
            }
            String string = String.valueOf("Services started transitioning asynchronously before the ServiceManager was constructed: ");
            object2 = String.valueOf(arrayList);
            throw new IllegalArgumentException(new StringBuilder(0 + String.valueOf(string).length() + String.valueOf(object2).length()).append(string).append((String)object2).toString());
        }
        finally {
            this.monitor.leave();
        }
    }

    void addListener(ServiceManager$Listener serviceManager$Listener, Executor executor) {
        Preconditions.checkNotNull(serviceManager$Listener, "listener");
        Preconditions.checkNotNull(executor, "executor");
        this.monitor.enter();
        try {
            if (this.stoppedGuard.isSatisfied()) return;
            this.listeners.add(new ListenerCallQueue(serviceManager$Listener, executor));
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    void awaitHealthy() {
        this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
        try {
            this.checkHealthy();
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void awaitHealthy(long l2, TimeUnit timeUnit) {
        this.monitor.enter();
        try {
            if (!this.monitor.waitForUninterruptibly(this.awaitHealthGuard, l2, timeUnit)) {
                String string = String.valueOf("Timeout waiting for the services to become healthy. The following services have not started: ");
                String string2 = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.in(ImmutableSet.of((Object)Service$State.NEW, (Object)Service$State.STARTING))));
                throw new TimeoutException(new StringBuilder(0 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(string2).toString());
            }
            this.checkHealthy();
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    void awaitStopped() {
        this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
        this.monitor.leave();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void awaitStopped(long l2, TimeUnit timeUnit) {
        this.monitor.enter();
        try {
            if (this.monitor.waitForUninterruptibly(this.stoppedGuard, l2, timeUnit)) return;
            String string = String.valueOf("Timeout waiting for the services to stop. The following services have not stopped: ");
            String string2 = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service$State.TERMINATED, Service$State.FAILED)))));
            throw new TimeoutException(new StringBuilder(0 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(string2).toString());
        }
        finally {
            this.monitor.leave();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    ImmutableMultimap servicesByState() {
        ImmutableSetMultimap$Builder immutableSetMultimap$Builder = ImmutableSetMultimap.builder();
        this.monitor.enter();
        try {
            Iterator iterator = this.servicesByState.entries().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                if (entry.getValue() instanceof ServiceManager$NoOpService) continue;
                immutableSetMultimap$Builder.put(entry);
            }
            return immutableSetMultimap$Builder.build();
        }
        finally {
            this.monitor.leave();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    ImmutableMap startupTimes() {
        ArrayList arrayList;
        this.monitor.enter();
        try {
            arrayList = Lists.newArrayListWithCapacity(this.startupTimers.size());
            for (Map.Entry entry : this.startupTimers.entrySet()) {
                Service service = (Service)entry.getKey();
                Stopwatch stopwatch = (Stopwatch)entry.getValue();
                if (stopwatch.isRunning() || service instanceof ServiceManager$NoOpService) continue;
                arrayList.add(Maps.immutableEntry(service, stopwatch.elapsed(TimeUnit.MILLISECONDS)));
            }
        }
        finally {
            this.monitor.leave();
        }
        Collections.sort(arrayList, Ordering.natural().onResultOf(new ServiceManager$ServiceManagerState$3(this)));
        return ImmutableMap.copyOf(arrayList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void transitionService(Service service, Service$State service$State, Service$State service$State2) {
        Preconditions.checkNotNull(service);
        Preconditions.checkArgument(service$State != service$State2);
        this.monitor.enter();
        try {
            this.transitioned = true;
            if (!this.ready) {
                return;
            }
            Preconditions.checkState(this.servicesByState.remove((Object)service$State, service), "Service %s not at the expected location in the state map %s", new Object[]{service, service$State});
            Preconditions.checkState(this.servicesByState.put((Object)service$State2, service), "Service %s in the state map unexpectedly at %s", new Object[]{service, service$State2});
            Stopwatch stopwatch = (Stopwatch)this.startupTimers.get(service);
            if (stopwatch == null) {
                stopwatch = Stopwatch.createStarted();
                this.startupTimers.put(service, stopwatch);
            }
            if (service$State2.compareTo(Service$State.RUNNING) >= 0 && stopwatch.isRunning()) {
                stopwatch.stop();
                if (!(service instanceof ServiceManager$NoOpService)) {
                    ServiceManager.access$200().log(Level.FINE, "Started {0} in {1}.", new Object[]{service, stopwatch});
                }
            }
            if (service$State2 == Service$State.FAILED) {
                this.fireFailedListeners(service);
            }
            if (this.states.count((Object)Service$State.RUNNING) == this.numberOfServices) {
                this.fireHealthyListeners();
                return;
            }
            if (this.states.count((Object)Service$State.TERMINATED) + this.states.count((Object)Service$State.FAILED) != this.numberOfServices) return;
            this.fireStoppedListeners();
            return;
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
    }

    @GuardedBy(value="monitor")
    void fireStoppedListeners() {
        ServiceManager.access$300().enqueueOn(this.listeners);
    }

    @GuardedBy(value="monitor")
    void fireHealthyListeners() {
        ServiceManager.access$400().enqueueOn(this.listeners);
    }

    @GuardedBy(value="monitor")
    void fireFailedListeners(Service service) {
        String string = String.valueOf(service);
        new ServiceManager$ServiceManagerState$4(this, new StringBuilder(18 + String.valueOf(string).length()).append("failed({service=").append(string).append("})").toString(), service).enqueueOn(this.listeners);
    }

    void executeListeners() {
        Preconditions.checkState(!this.monitor.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
        int n2 = 0;
        while (n2 < this.listeners.size()) {
            ((ListenerCallQueue)this.listeners.get(n2)).execute();
            ++n2;
        }
    }

    @GuardedBy(value="monitor")
    void checkHealthy() {
        if (this.states.count((Object)Service$State.RUNNING) == this.numberOfServices) return;
        Object object = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.equalTo((Object)Service$State.RUNNING))));
        IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(79 + String.valueOf(object).length()).append("Expected to be healthy after starting. The following services are not running: ").append((String)object).toString());
        object = this.servicesByState.get((Object)Service$State.FAILED).iterator();
        while (object.hasNext()) {
            Service service = (Service)object.next();
            illegalStateException.addSuppressed(new ServiceManager$FailedService(service));
        }
        throw illegalStateException;
    }
}

