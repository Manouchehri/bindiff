package org.ibex.nestedvm;

import org.ibex.nestedvm.Interpreter;
import org.ibex.nestedvm.Runtime;

public class Interpreter$DebugShutdownHook implements Runnable {
   private final Interpreter this$0;

   public Interpreter$DebugShutdownHook(Interpreter var1) {
      this.this$0 = var1;
   }

   public void run() {
      int var1 = Interpreter.access$000(this.this$0);
      if(this.this$0.getState() == 0) {
         System.err.print("\nCPU Executing " + Runtime.toHex(var1) + ": " + this.this$0.sourceLine(var1) + "\n");
      }

   }
}
