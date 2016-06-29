package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SocketFStat;
import org.ibex.nestedvm.UnixRuntime$Pipe;

public class UnixRuntime$Pipe$Reader extends Runtime$FD {
   private final UnixRuntime$Pipe this$0;

   public UnixRuntime$Pipe$Reader(UnixRuntime$Pipe var1) {
      this.this$0 = var1;
   }

   protected Runtime$FStat _fstat() {
      return new Runtime$SocketFStat();
   }

   public int read(byte[] var1, int var2, int var3) {
      if(var3 == 0) {
         return 0;
      } else {
         UnixRuntime$Pipe var4 = this.this$0;
         synchronized(this.this$0) {
            while(UnixRuntime$Pipe.access$100(this.this$0) != -1 && UnixRuntime$Pipe.access$200(this.this$0) == UnixRuntime$Pipe.access$100(this.this$0)) {
               try {
                  this.this$0.wait();
               } catch (InterruptedException var7) {
                  ;
               }
            }

            if(UnixRuntime$Pipe.access$100(this.this$0) == -1) {
               return 0;
            } else {
               var3 = Math.min(var3, UnixRuntime$Pipe.access$100(this.this$0) - UnixRuntime$Pipe.access$200(this.this$0));
               System.arraycopy(UnixRuntime$Pipe.access$300(this.this$0), UnixRuntime$Pipe.access$200(this.this$0), var1, var2, var3);
               UnixRuntime$Pipe.access$212(this.this$0, var3);
               if(UnixRuntime$Pipe.access$200(this.this$0) == UnixRuntime$Pipe.access$100(this.this$0)) {
                  this.this$0.notify();
               }

               return var3;
            }
         }
      }
   }

   public int flags() {
      return 0;
   }

   public void _close() {
      UnixRuntime$Pipe var1 = this.this$0;
      synchronized(this.this$0) {
         UnixRuntime$Pipe.access$202(this.this$0, -1);
         this.this$0.notify();
      }
   }
}
