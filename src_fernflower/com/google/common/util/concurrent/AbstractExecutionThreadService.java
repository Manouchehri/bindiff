package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1;
import com.google.common.util.concurrent.AbstractExecutionThreadService$2;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Beta
public abstract class AbstractExecutionThreadService implements Service {
   private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
   private final Service delegate = new AbstractExecutionThreadService$1(this);

   protected void startUp() {
   }

   protected abstract void run();

   protected void shutDown() {
   }

   protected void triggerShutdown() {
   }

   protected Executor executor() {
      return new AbstractExecutionThreadService$2(this);
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
   static Logger access$000() {
      return logger;
   }
}
