package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

enum MoreExecutors$DirectExecutor implements Executor {
   INSTANCE;

   public void execute(Runnable var1) {
      var1.run();
   }
}
