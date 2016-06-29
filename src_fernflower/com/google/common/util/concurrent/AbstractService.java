package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractService$1;
import com.google.common.util.concurrent.AbstractService$10;
import com.google.common.util.concurrent.AbstractService$2;
import com.google.common.util.concurrent.AbstractService$3;
import com.google.common.util.concurrent.AbstractService$4;
import com.google.common.util.concurrent.AbstractService$5;
import com.google.common.util.concurrent.AbstractService$6;
import com.google.common.util.concurrent.AbstractService$7;
import com.google.common.util.concurrent.AbstractService$8;
import com.google.common.util.concurrent.AbstractService$9;
import com.google.common.util.concurrent.AbstractService$StateSnapshot;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

@Beta
public abstract class AbstractService implements Service {
   private static final ListenerCallQueue$Callback STARTING_CALLBACK = new AbstractService$1("starting()");
   private static final ListenerCallQueue$Callback RUNNING_CALLBACK = new AbstractService$2("running()");
   private static final ListenerCallQueue$Callback STOPPING_FROM_STARTING_CALLBACK;
   private static final ListenerCallQueue$Callback STOPPING_FROM_RUNNING_CALLBACK;
   private static final ListenerCallQueue$Callback TERMINATED_FROM_NEW_CALLBACK;
   private static final ListenerCallQueue$Callback TERMINATED_FROM_RUNNING_CALLBACK;
   private static final ListenerCallQueue$Callback TERMINATED_FROM_STOPPING_CALLBACK;
   private final Monitor monitor = new Monitor();
   private final Monitor$Guard isStartable;
   private final Monitor$Guard isStoppable;
   private final Monitor$Guard hasReachedRunning;
   private final Monitor$Guard isStopped;
   @GuardedBy("monitor")
   private final List listeners;
   @GuardedBy("monitor")
   private volatile AbstractService$StateSnapshot snapshot;

   private static ListenerCallQueue$Callback terminatedCallback(Service$State var0) {
      String var1 = String.valueOf(var0);
      return new AbstractService$3((new StringBuilder(21 + String.valueOf(var1).length())).append("terminated({from = ").append(var1).append("})").toString(), var0);
   }

   private static ListenerCallQueue$Callback stoppingCallback(Service$State var0) {
      String var1 = String.valueOf(var0);
      return new AbstractService$4((new StringBuilder(19 + String.valueOf(var1).length())).append("stopping({from = ").append(var1).append("})").toString(), var0);
   }

   protected AbstractService() {
      this.isStartable = new AbstractService$5(this, this.monitor);
      this.isStoppable = new AbstractService$6(this, this.monitor);
      this.hasReachedRunning = new AbstractService$7(this, this.monitor);
      this.isStopped = new AbstractService$8(this, this.monitor);
      this.listeners = Collections.synchronizedList(new ArrayList());
      this.snapshot = new AbstractService$StateSnapshot(Service$State.NEW);
   }

   protected abstract void doStart();

   protected abstract void doStop();

   public final Service startAsync() {
      if(this.monitor.enterIf(this.isStartable)) {
         try {
            this.snapshot = new AbstractService$StateSnapshot(Service$State.STARTING);
            this.starting();
            this.doStart();
         } catch (Throwable var5) {
            this.notifyFailed(var5);
         } finally {
            this.monitor.leave();
            this.executeListeners();
         }

         return this;
      } else {
         String var1 = String.valueOf(this);
         throw new IllegalStateException((new StringBuilder(33 + String.valueOf(var1).length())).append("Service ").append(var1).append(" has already been started").toString());
      }
   }

   public final Service stopAsync() {
      if(this.monitor.enterIf(this.isStoppable)) {
         try {
            Service$State var1 = this.state();
            String var2;
            switch(AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[var1.ordinal()]) {
            case 1:
               this.snapshot = new AbstractService$StateSnapshot(Service$State.TERMINATED);
               this.terminated(Service$State.NEW);
               break;
            case 2:
               this.snapshot = new AbstractService$StateSnapshot(Service$State.STARTING, true, (Throwable)null);
               this.stopping(Service$State.STARTING);
               break;
            case 3:
               this.snapshot = new AbstractService$StateSnapshot(Service$State.STOPPING);
               this.stopping(Service$State.RUNNING);
               this.doStop();
               break;
            case 4:
            case 5:
            case 6:
               var2 = String.valueOf(var1);
               throw new AssertionError((new StringBuilder(45 + String.valueOf(var2).length())).append("isStoppable is incorrectly implemented, saw: ").append(var2).toString());
            default:
               var2 = String.valueOf(var1);
               throw new AssertionError((new StringBuilder(18 + String.valueOf(var2).length())).append("Unexpected state: ").append(var2).toString());
            }
         } catch (Throwable var6) {
            this.notifyFailed(var6);
         } finally {
            this.monitor.leave();
            this.executeListeners();
         }
      }

      return this;
   }

   public final void awaitRunning() {
      this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);

      try {
         this.checkCurrentState(Service$State.RUNNING);
      } finally {
         this.monitor.leave();
      }

   }

   public final void awaitRunning(long var1, TimeUnit var3) {
      if(this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, var1, var3)) {
         try {
            this.checkCurrentState(Service$State.RUNNING);
         } finally {
            this.monitor.leave();
         }

      } else {
         String var4 = String.valueOf(this);
         String var5 = String.valueOf(this.state());
         throw new TimeoutException((new StringBuilder(66 + String.valueOf(var4).length() + String.valueOf(var5).length())).append("Timed out waiting for ").append(var4).append(" to reach the RUNNING state. ").append("Current state: ").append(var5).toString());
      }
   }

   public final void awaitTerminated() {
      this.monitor.enterWhenUninterruptibly(this.isStopped);

      try {
         this.checkCurrentState(Service$State.TERMINATED);
      } finally {
         this.monitor.leave();
      }

   }

   public final void awaitTerminated(long var1, TimeUnit var3) {
      if(this.monitor.enterWhenUninterruptibly(this.isStopped, var1, var3)) {
         try {
            this.checkCurrentState(Service$State.TERMINATED);
         } finally {
            this.monitor.leave();
         }

      } else {
         String var4 = String.valueOf(this);
         String var5 = String.valueOf(this.state());
         throw new TimeoutException((new StringBuilder(65 + String.valueOf(var4).length() + String.valueOf(var5).length())).append("Timed out waiting for ").append(var4).append(" to reach a terminal state. ").append("Current state: ").append(var5).toString());
      }
   }

   @GuardedBy("monitor")
   private void checkCurrentState(Service$State var1) {
      Service$State var2 = this.state();
      if(var2 != var1) {
         String var3;
         if(var2 == Service$State.FAILED) {
            var3 = String.valueOf(var1);
            throw new IllegalStateException((new StringBuilder(55 + String.valueOf(var3).length())).append("Expected the service to be ").append(var3).append(", but the service has FAILED").toString(), this.failureCause());
         } else {
            var3 = String.valueOf(var1);
            String var4 = String.valueOf(var2);
            throw new IllegalStateException((new StringBuilder(37 + String.valueOf(var3).length() + String.valueOf(var4).length())).append("Expected the service to be ").append(var3).append(", but was ").append(var4).toString());
         }
      }
   }

   protected final void notifyStarted() {
      this.monitor.enter();

      try {
         if(this.snapshot.state != Service$State.STARTING) {
            String var2 = String.valueOf(this.snapshot.state);
            IllegalStateException var1 = new IllegalStateException((new StringBuilder(43 + String.valueOf(var2).length())).append("Cannot notifyStarted() when the service is ").append(var2).toString());
            this.notifyFailed(var1);
            throw var1;
         }

         if(this.snapshot.shutdownWhenStartupFinishes) {
            this.snapshot = new AbstractService$StateSnapshot(Service$State.STOPPING);
            this.doStop();
         } else {
            this.snapshot = new AbstractService$StateSnapshot(Service$State.RUNNING);
            this.running();
         }
      } finally {
         this.monitor.leave();
         this.executeListeners();
      }

   }

   protected final void notifyStopped() {
      this.monitor.enter();

      try {
         Service$State var1 = this.snapshot.state;
         if(var1 != Service$State.STOPPING && var1 != Service$State.RUNNING) {
            String var3 = String.valueOf(var1);
            IllegalStateException var2 = new IllegalStateException((new StringBuilder(43 + String.valueOf(var3).length())).append("Cannot notifyStopped() when the service is ").append(var3).toString());
            this.notifyFailed(var2);
            throw var2;
         }

         this.snapshot = new AbstractService$StateSnapshot(Service$State.TERMINATED);
         this.terminated(var1);
      } finally {
         this.monitor.leave();
         this.executeListeners();
      }

   }

   protected final void notifyFailed(Throwable var1) {
      Preconditions.checkNotNull(var1);
      this.monitor.enter();

      try {
         Service$State var2 = this.state();
         String var3;
         switch(AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[var2.ordinal()]) {
         case 1:
         case 5:
            var3 = String.valueOf(var2);
            throw new IllegalStateException((new StringBuilder(22 + String.valueOf(var3).length())).append("Failed while in state:").append(var3).toString(), var1);
         case 2:
         case 3:
         case 4:
            this.snapshot = new AbstractService$StateSnapshot(Service$State.FAILED, false, var1);
            this.failed(var2, var1);
         case 6:
            break;
         default:
            var3 = String.valueOf(var2);
            throw new AssertionError((new StringBuilder(18 + String.valueOf(var3).length())).append("Unexpected state: ").append(var3).toString());
         }
      } finally {
         this.monitor.leave();
         this.executeListeners();
      }

   }

   public final boolean isRunning() {
      return this.state() == Service$State.RUNNING;
   }

   public final Service$State state() {
      return this.snapshot.externalState();
   }

   public final Throwable failureCause() {
      return this.snapshot.failureCause();
   }

   public final void addListener(Service$Listener var1, Executor var2) {
      Preconditions.checkNotNull(var1, "listener");
      Preconditions.checkNotNull(var2, "executor");
      this.monitor.enter();

      try {
         if(!this.state().isTerminal()) {
            this.listeners.add(new ListenerCallQueue(var1, var2));
         }
      } finally {
         this.monitor.leave();
      }

   }

   public String toString() {
      String var1 = String.valueOf(this.getClass().getSimpleName());
      String var2 = String.valueOf(this.state());
      return (new StringBuilder(3 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(" [").append(var2).append("]").toString();
   }

   private void executeListeners() {
      if(!this.monitor.isOccupiedByCurrentThread()) {
         for(int var1 = 0; var1 < this.listeners.size(); ++var1) {
            ((ListenerCallQueue)this.listeners.get(var1)).execute();
         }
      }

   }

   @GuardedBy("monitor")
   private void starting() {
      STARTING_CALLBACK.enqueueOn(this.listeners);
   }

   @GuardedBy("monitor")
   private void running() {
      RUNNING_CALLBACK.enqueueOn(this.listeners);
   }

   @GuardedBy("monitor")
   private void stopping(Service$State var1) {
      if(var1 == Service$State.STARTING) {
         STOPPING_FROM_STARTING_CALLBACK.enqueueOn(this.listeners);
      } else {
         if(var1 != Service$State.RUNNING) {
            throw new AssertionError();
         }

         STOPPING_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
      }

   }

   @GuardedBy("monitor")
   private void terminated(Service$State var1) {
      switch(AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[var1.ordinal()]) {
      case 1:
         TERMINATED_FROM_NEW_CALLBACK.enqueueOn(this.listeners);
         break;
      case 2:
      case 5:
      case 6:
      default:
         throw new AssertionError();
      case 3:
         TERMINATED_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
         break;
      case 4:
         TERMINATED_FROM_STOPPING_CALLBACK.enqueueOn(this.listeners);
      }

   }

   @GuardedBy("monitor")
   private void failed(Service$State var1, Throwable var2) {
      String var3 = String.valueOf(var1);
      String var4 = String.valueOf(var2);
      (new AbstractService$9(this, (new StringBuilder(27 + String.valueOf(var3).length() + String.valueOf(var4).length())).append("failed({from = ").append(var3).append(", cause = ").append(var4).append("})").toString(), var1, var2)).enqueueOn(this.listeners);
   }

   static {
      STOPPING_FROM_STARTING_CALLBACK = stoppingCallback(Service$State.STARTING);
      STOPPING_FROM_RUNNING_CALLBACK = stoppingCallback(Service$State.RUNNING);
      TERMINATED_FROM_NEW_CALLBACK = terminatedCallback(Service$State.NEW);
      TERMINATED_FROM_RUNNING_CALLBACK = terminatedCallback(Service$State.RUNNING);
      TERMINATED_FROM_STOPPING_CALLBACK = terminatedCallback(Service$State.STOPPING);
   }
}
