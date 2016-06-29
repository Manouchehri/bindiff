package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
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

   public ServiceManager(Iterable var1) {
      ImmutableList var2 = ImmutableList.copyOf(var1);
      if(var2.isEmpty()) {
         logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new ServiceManager$EmptyServiceManagerWarning((ServiceManager$1)null));
         var2 = ImmutableList.of(new ServiceManager$NoOpService((ServiceManager$1)null));
      }

      this.state = new ServiceManager$ServiceManagerState(var2);
      this.services = var2;
      WeakReference var3 = new WeakReference(this.state);
      UnmodifiableIterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Service var5 = (Service)var4.next();
         var5.addListener(new ServiceManager$ServiceListener(var5, var3), MoreExecutors.directExecutor());
         Preconditions.checkArgument(var5.state() == Service$State.NEW, "Can only manage NEW services, %s", new Object[]{var5});
      }

      this.state.markReady();
   }

   public void addListener(ServiceManager$Listener var1, Executor var2) {
      this.state.addListener(var1, var2);
   }

   public void addListener(ServiceManager$Listener var1) {
      this.state.addListener(var1, MoreExecutors.directExecutor());
   }

   public ServiceManager startAsync() {
      UnmodifiableIterator var1 = this.services.iterator();

      Service var2;
      while(var1.hasNext()) {
         var2 = (Service)var1.next();
         Service$State var3 = var2.state();
         Preconditions.checkState(var3 == Service$State.NEW, "Service %s is %s, cannot start it.", new Object[]{var2, var3});
      }

      var1 = this.services.iterator();

      while(var1.hasNext()) {
         var2 = (Service)var1.next();

         try {
            this.state.tryStartTiming(var2);
            var2.startAsync();
         } catch (IllegalStateException var5) {
            Logger var10000 = logger;
            Level var10001 = Level.WARNING;
            String var4 = String.valueOf(var2);
            var10000.log(var10001, (new StringBuilder(24 + String.valueOf(var4).length())).append("Unable to start Service ").append(var4).toString(), var5);
         }
      }

      return this;
   }

   public void awaitHealthy() {
      this.state.awaitHealthy();
   }

   public void awaitHealthy(long var1, TimeUnit var3) {
      this.state.awaitHealthy(var1, var3);
   }

   public ServiceManager stopAsync() {
      UnmodifiableIterator var1 = this.services.iterator();

      while(var1.hasNext()) {
         Service var2 = (Service)var1.next();
         var2.stopAsync();
      }

      return this;
   }

   public void awaitStopped() {
      this.state.awaitStopped();
   }

   public void awaitStopped(long var1, TimeUnit var3) {
      this.state.awaitStopped(var1, var3);
   }

   public boolean isHealthy() {
      UnmodifiableIterator var1 = this.services.iterator();

      Service var2;
      do {
         if(!var1.hasNext()) {
            return true;
         }

         var2 = (Service)var1.next();
      } while(var2.isRunning());

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

   // $FF: synthetic method
   static Logger access$200() {
      return logger;
   }

   // $FF: synthetic method
   static ListenerCallQueue$Callback access$300() {
      return STOPPED_CALLBACK;
   }

   // $FF: synthetic method
   static ListenerCallQueue$Callback access$400() {
      return HEALTHY_CALLBACK;
   }
}
