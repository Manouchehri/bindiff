package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.UnixRuntime$Pipe$Reader;
import org.ibex.nestedvm.UnixRuntime$Pipe$Writer;

class UnixRuntime$Pipe {
   private final byte[] pipebuf = new byte[2048];
   private int readPos;
   private int writePos;
   public final Runtime$FD reader = new UnixRuntime$Pipe$Reader(this);
   public final Runtime$FD writer = new UnixRuntime$Pipe$Writer(this);

   static int access$100(UnixRuntime$Pipe var0) {
      return var0.writePos;
   }

   static int access$200(UnixRuntime$Pipe var0) {
      return var0.readPos;
   }

   static byte[] access$300(UnixRuntime$Pipe var0) {
      return var0.pipebuf;
   }

   static int access$212(UnixRuntime$Pipe var0, int var1) {
      return var0.readPos += var1;
   }

   static int access$202(UnixRuntime$Pipe var0, int var1) {
      return var0.readPos = var1;
   }

   static int access$102(UnixRuntime$Pipe var0, int var1) {
      return var0.writePos = var1;
   }

   static int access$112(UnixRuntime$Pipe var0, int var1) {
      return var0.writePos += var1;
   }
}
