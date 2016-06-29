package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ServiceManager$1;

final class ServiceManager$NoOpService extends AbstractService {
   private ServiceManager$NoOpService() {
   }

   protected void doStart() {
      this.notifyStarted();
   }

   protected void doStop() {
      this.notifyStopped();
   }

   // $FF: synthetic method
   ServiceManager$NoOpService(ServiceManager$1 var1) {
      this();
   }
}
