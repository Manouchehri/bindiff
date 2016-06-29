package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$SocketFStat;
import org.ibex.nestedvm.Runtime$TerminalFD;

class Runtime$TerminalFD$1 extends Runtime$SocketFStat {
   private final Runtime$TerminalFD this$0;

   Runtime$TerminalFD$1(Runtime$TerminalFD var1) {
      this.this$0 = var1;
   }

   public int type() {
      return 8192;
   }

   public int mode() {
      return 384;
   }
}
