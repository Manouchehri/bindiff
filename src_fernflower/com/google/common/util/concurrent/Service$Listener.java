package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.Service$State;

@Beta
public abstract class Service$Listener {
   public void starting() {
   }

   public void running() {
   }

   public void stopping(Service$State var1) {
   }

   public void terminated(Service$State var1) {
   }

   public void failed(Service$State var1, Throwable var2) {
   }
}
