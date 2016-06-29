package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import com.google.common.util.concurrent.ServiceManager;
import com.google.common.util.concurrent.ServiceManager$NoOpService;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;
import java.lang.ref.WeakReference;
import java.util.logging.Level;
import java.util.logging.Logger;

final class ServiceManager$ServiceListener extends Service$Listener {
   final Service service;
   final WeakReference state;

   ServiceManager$ServiceListener(Service var1, WeakReference var2) {
      this.service = var1;
      this.state = var2;
   }

   public void starting() {
      ServiceManager$ServiceManagerState var1 = (ServiceManager$ServiceManagerState)this.state.get();
      if(var1 != null) {
         var1.transitionService(this.service, Service$State.NEW, Service$State.STARTING);
         if(!(this.service instanceof ServiceManager$NoOpService)) {
            ServiceManager.access$200().log(Level.FINE, "Starting {0}.", this.service);
         }
      }

   }

   public void running() {
      ServiceManager$ServiceManagerState var1 = (ServiceManager$ServiceManagerState)this.state.get();
      if(var1 != null) {
         var1.transitionService(this.service, Service$State.STARTING, Service$State.RUNNING);
      }

   }

   public void stopping(Service$State var1) {
      ServiceManager$ServiceManagerState var2 = (ServiceManager$ServiceManagerState)this.state.get();
      if(var2 != null) {
         var2.transitionService(this.service, var1, Service$State.STOPPING);
      }

   }

   public void terminated(Service$State var1) {
      ServiceManager$ServiceManagerState var2 = (ServiceManager$ServiceManagerState)this.state.get();
      if(var2 != null) {
         if(!(this.service instanceof ServiceManager$NoOpService)) {
            ServiceManager.access$200().log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.service, var1});
         }

         var2.transitionService(this.service, var1, Service$State.TERMINATED);
      }

   }

   public void failed(Service$State var1, Throwable var2) {
      ServiceManager$ServiceManagerState var3 = (ServiceManager$ServiceManagerState)this.state.get();
      if(var3 != null) {
         if(!(this.service instanceof ServiceManager$NoOpService) && var1 != Service$State.STARTING) {
            Logger var10000 = ServiceManager.access$200();
            Level var10001 = Level.SEVERE;
            String var4 = String.valueOf(this.service);
            String var5 = String.valueOf(var1);
            var10000.log(var10001, (new StringBuilder(34 + String.valueOf(var4).length() + String.valueOf(var5).length())).append("Service ").append(var4).append(" has failed in the ").append(var5).append(" state.").toString(), var2);
         }

         var3.transitionService(this.service, var1, Service$State.FAILED);
      }

   }
}
