package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime;

public final class UnixRuntime$ForkedProcess extends Thread {
   private final UnixRuntime initial;

   public UnixRuntime$ForkedProcess(UnixRuntime var1) {
      this.initial = var1;
      this.start();
   }

   public void run() {
      UnixRuntime.executeAndExec(this.initial);
   }
}
