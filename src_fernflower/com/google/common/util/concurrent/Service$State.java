package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.Service$1;

@Beta
public enum Service$State {
   NEW,
   STARTING,
   RUNNING,
   STOPPING,
   TERMINATED,
   FAILED;

   private Service$State() {
   }

   abstract boolean isTerminal();

   // $FF: synthetic method
   Service$State(Service$1 var3) {
      this();
   }
}
