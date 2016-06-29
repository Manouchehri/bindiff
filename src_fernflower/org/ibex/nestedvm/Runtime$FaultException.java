package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$ExecutionException;

public class Runtime$FaultException extends Runtime$ExecutionException {
   public final int addr;
   public final RuntimeException cause;

   public Runtime$FaultException(int var1) {
      super("fault at: " + Runtime.toHex(var1));
      this.addr = var1;
      this.cause = null;
   }

   public Runtime$FaultException(RuntimeException var1) {
      super(var1.toString());
      this.addr = -1;
      this.cause = var1;
   }
}
