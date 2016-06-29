package org.ibex.nestedvm;

public class Runtime$ErrnoException extends Exception {
   public int errno;

   public Runtime$ErrnoException(int var1) {
      super("Errno: " + var1);
      this.errno = var1;
   }
}
