package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;
import java.util.Map.Entry;

class ServiceManager$ServiceManagerState$3 implements Function {
   // $FF: synthetic field
   final ServiceManager$ServiceManagerState this$0;

   ServiceManager$ServiceManagerState$3(ServiceManager$ServiceManagerState var1) {
      this.this$0 = var1;
   }

   public Long apply(Entry var1) {
      return (Long)var1.getValue();
   }
}
