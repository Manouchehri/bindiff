package org.ibex.nestedvm;

import java.io.InputStream;
import java.io.OutputStream;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$InputOutputStreamFD;
import org.ibex.nestedvm.Runtime$TerminalFD$1;

class Runtime$TerminalFD extends Runtime$InputOutputStreamFD {
   public Runtime$TerminalFD(InputStream var1) {
      this(var1, (OutputStream)null);
   }

   public Runtime$TerminalFD(OutputStream var1) {
      this((InputStream)null, var1);
   }

   public Runtime$TerminalFD(InputStream var1, OutputStream var2) {
      super(var1, var2);
   }

   public void _close() {
   }

   public Runtime$FStat _fstat() {
      return new Runtime$TerminalFD$1(this);
   }
}
