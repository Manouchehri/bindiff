package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractIdleService$1;
import com.google.common.util.concurrent.AbstractIdleService$2;
import com.google.common.util.concurrent.AbstractIdleService$3;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Beta
public abstract class AbstractIdleService implements Service {
   private final Supplier threadNameSupplier = new AbstractIdleService$1(this);
   private final Service delegate = new AbstractIdleService$2(this);

   protected abstract void startUp();

   protected abstract void shutDown();

   protected Executor executor() {
      return new AbstractIdleService$3(this);
   }

   public String toString() {
      String var1 = this.serviceName();
      String var2 = String.valueOf(this.state());
      return (new StringBuilder(3 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(" [").append(var2).append("]").toString();
   }

   public final boolean isRunning() {
      return this.delegate.isRunning();
   }

   public final Service$State state() {
      return this.delegate.state();
   }

   public final void addListener(Service$Listener var1, Executor var2) {
      this.delegate.addListener(var1, var2);
   }

   public final Throwable failureCause() {
      return this.delegate.failureCause();
   }

   public final Service startAsync() {
      this.delegate.startAsync();
      return this;
   }

   public final Service stopAsync() {
      this.delegate.stopAsync();
      return this;
   }

   public final void awaitRunning() {
      this.delegate.awaitRunning();
   }

   public final void awaitRunning(long var1, TimeUnit var3) {
      this.delegate.awaitRunning(var1, var3);
   }

   public final void awaitTerminated() {
      this.delegate.awaitTerminated();
   }

   public final void awaitTerminated(long var1, TimeUnit var3) {
      this.delegate.awaitTerminated(var1, var3);
   }

   protected String serviceName() {
      return this.getClass().getSimpleName();
   }

   // $FF: synthetic method
   static Supplier access$000(AbstractIdleService var0) {
      return var0.threadNameSupplier;
   }
}
