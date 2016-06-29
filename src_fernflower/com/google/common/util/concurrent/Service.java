package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Beta
public interface Service {
   Service startAsync();

   boolean isRunning();

   Service$State state();

   Service stopAsync();

   void awaitRunning();

   void awaitRunning(long var1, TimeUnit var3);

   void awaitTerminated();

   void awaitTerminated(long var1, TimeUnit var3);

   Throwable failureCause();

   void addListener(Service$Listener var1, Executor var2);
}
