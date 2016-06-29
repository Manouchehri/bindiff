package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.util.concurrent.Service;

@GoogleInternal
final class ServiceManager$FailedService extends Throwable {
   ServiceManager$FailedService(Service var1) {
      super(var1.toString(), var1.failureCause(), false, false);
   }
}
