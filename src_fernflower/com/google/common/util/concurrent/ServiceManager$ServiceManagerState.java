package com.google.common.util.concurrent;

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
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
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
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import javax.annotation.concurrent.GuardedBy;

final class ServiceManager$ServiceManagerState {
   final Monitor monitor = new Monitor();
   @GuardedBy("monitor")
   final SetMultimap servicesByState = MultimapBuilder.enumKeys(Service$State.class).linkedHashSetValues().build();
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

   ServiceManager$ServiceManagerState(ImmutableCollection var1) {
      this.states = this.servicesByState.keys();
      this.startupTimers = Maps.newIdentityHashMap();
      this.awaitHealthGuard = new ServiceManager$ServiceManagerState$1(this, this.monitor);
      this.stoppedGuard = new ServiceManager$ServiceManagerState$2(this, this.monitor);
      this.listeners = Collections.synchronizedList(new ArrayList());
      this.numberOfServices = var1.size();
      this.servicesByState.putAll(Service$State.NEW, var1);
   }

   void tryStartTiming(Service var1) {
      this.monitor.enter();

      try {
         Stopwatch var2 = (Stopwatch)this.startupTimers.get(var1);
         if(var2 == null) {
            this.startupTimers.put(var1, Stopwatch.createStarted());
         }
      } finally {
         this.monitor.leave();
      }

   }

   void markReady() {
      this.monitor.enter();

      try {
         if(this.transitioned) {
            ArrayList var1 = Lists.newArrayList();
            UnmodifiableIterator var2 = this.servicesByState().values().iterator();

            while(var2.hasNext()) {
               Service var3 = (Service)var2.next();
               if(var3.state() != Service$State.NEW) {
                  var1.add(var3);
               }
            }

            String var7 = String.valueOf("Services started transitioning asynchronously before the ServiceManager was constructed: ");
            String var8 = String.valueOf(var1);
            throw new IllegalArgumentException((new StringBuilder(0 + String.valueOf(var7).length() + String.valueOf(var8).length())).append(var7).append(var8).toString());
         }

         this.ready = true;
      } finally {
         this.monitor.leave();
      }

   }

   void addListener(ServiceManager$Listener var1, Executor var2) {
      Preconditions.checkNotNull(var1, "listener");
      Preconditions.checkNotNull(var2, "executor");
      this.monitor.enter();

      try {
         if(!this.stoppedGuard.isSatisfied()) {
            this.listeners.add(new ListenerCallQueue(var1, var2));
         }
      } finally {
         this.monitor.leave();
      }

   }

   void awaitHealthy() {
      this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);

      try {
         this.checkHealthy();
      } finally {
         this.monitor.leave();
      }

   }

   void awaitHealthy(long var1, TimeUnit var3) {
      this.monitor.enter();

      try {
         if(!this.monitor.waitForUninterruptibly(this.awaitHealthGuard, var1, var3)) {
            String var4 = String.valueOf("Timeout waiting for the services to become healthy. The following services have not started: ");
            String var5 = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.in(ImmutableSet.of(Service$State.NEW, Service$State.STARTING))));
            throw new TimeoutException((new StringBuilder(0 + String.valueOf(var4).length() + String.valueOf(var5).length())).append(var4).append(var5).toString());
         }

         this.checkHealthy();
      } finally {
         this.monitor.leave();
      }

   }

   void awaitStopped() {
      this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
      this.monitor.leave();
   }

   void awaitStopped(long var1, TimeUnit var3) {
      this.monitor.enter();

      try {
         if(!this.monitor.waitForUninterruptibly(this.stoppedGuard, var1, var3)) {
            String var4 = String.valueOf("Timeout waiting for the services to stop. The following services have not stopped: ");
            String var5 = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service$State.TERMINATED, Service$State.FAILED)))));
            throw new TimeoutException((new StringBuilder(0 + String.valueOf(var4).length() + String.valueOf(var5).length())).append(var4).append(var5).toString());
         }
      } finally {
         this.monitor.leave();
      }

   }

   ImmutableMultimap servicesByState() {
      ImmutableSetMultimap$Builder var1 = ImmutableSetMultimap.builder();
      this.monitor.enter();

      try {
         Iterator var2 = this.servicesByState.entries().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            if(!(var3.getValue() instanceof ServiceManager$NoOpService)) {
               var1.put(var3);
            }
         }
      } finally {
         this.monitor.leave();
      }

      return var1.build();
   }

   ImmutableMap startupTimes() {
      this.monitor.enter();

      ArrayList var1;
      try {
         var1 = Lists.newArrayListWithCapacity(this.startupTimers.size());
         Iterator var2 = this.startupTimers.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            Service var4 = (Service)var3.getKey();
            Stopwatch var5 = (Stopwatch)var3.getValue();
            if(!var5.isRunning() && !(var4 instanceof ServiceManager$NoOpService)) {
               var1.add(Maps.immutableEntry(var4, Long.valueOf(var5.elapsed(TimeUnit.MILLISECONDS))));
            }
         }
      } finally {
         this.monitor.leave();
      }

      Collections.sort(var1, Ordering.natural().onResultOf(new ServiceManager$ServiceManagerState$3(this)));
      return ImmutableMap.copyOf((Iterable)var1);
   }

   void transitionService(Service var1, Service$State var2, Service$State var3) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(var2 != var3);
      this.monitor.enter();

      try {
         this.transitioned = true;
         if(!this.ready) {
            return;
         }

         Preconditions.checkState(this.servicesByState.remove(var2, var1), "Service %s not at the expected location in the state map %s", new Object[]{var1, var2});
         Preconditions.checkState(this.servicesByState.put(var3, var1), "Service %s in the state map unexpectedly at %s", new Object[]{var1, var3});
         Stopwatch var4 = (Stopwatch)this.startupTimers.get(var1);
         if(var4 == null) {
            var4 = Stopwatch.createStarted();
            this.startupTimers.put(var1, var4);
         }

         if(var3.compareTo(Service$State.RUNNING) >= 0 && var4.isRunning()) {
            var4.stop();
            if(!(var1 instanceof ServiceManager$NoOpService)) {
               ServiceManager.access$200().log(Level.FINE, "Started {0} in {1}.", new Object[]{var1, var4});
            }
         }

         if(var3 == Service$State.FAILED) {
            this.fireFailedListeners(var1);
         }

         if(this.states.count(Service$State.RUNNING) == this.numberOfServices) {
            this.fireHealthyListeners();
         } else if(this.states.count(Service$State.TERMINATED) + this.states.count(Service$State.FAILED) == this.numberOfServices) {
            this.fireStoppedListeners();
         }
      } finally {
         this.monitor.leave();
         this.executeListeners();
      }

   }

   @GuardedBy("monitor")
   void fireStoppedListeners() {
      ServiceManager.access$300().enqueueOn(this.listeners);
   }

   @GuardedBy("monitor")
   void fireHealthyListeners() {
      ServiceManager.access$400().enqueueOn(this.listeners);
   }

   @GuardedBy("monitor")
   void fireFailedListeners(Service var1) {
      String var2 = String.valueOf(var1);
      (new ServiceManager$ServiceManagerState$4(this, (new StringBuilder(18 + String.valueOf(var2).length())).append("failed({service=").append(var2).append("})").toString(), var1)).enqueueOn(this.listeners);
   }

   void executeListeners() {
      Preconditions.checkState(!this.monitor.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");

      for(int var1 = 0; var1 < this.listeners.size(); ++var1) {
         ((ListenerCallQueue)this.listeners.get(var1)).execute();
      }

   }

   @GuardedBy("monitor")
   void checkHealthy() {
      if(this.states.count(Service$State.RUNNING) != this.numberOfServices) {
         String var2 = String.valueOf(Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.equalTo(Service$State.RUNNING))));
         IllegalStateException var1 = new IllegalStateException((new StringBuilder(79 + String.valueOf(var2).length())).append("Expected to be healthy after starting. The following services are not running: ").append(var2).toString());
         Iterator var4 = this.servicesByState.get(Service$State.FAILED).iterator();

         while(var4.hasNext()) {
            Service var3 = (Service)var4.next();
            var1.addSuppressed(new ServiceManager$FailedService(var3));
         }

         throw var1;
      }
   }
}
