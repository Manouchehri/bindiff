package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SocketFStat;
import org.ibex.nestedvm.UnixRuntime$Pipe;

public class UnixRuntime$Pipe$Writer extends Runtime$FD {
   private final UnixRuntime$Pipe this$0;

   public UnixRuntime$Pipe$Writer(UnixRuntime$Pipe var1) {
      this.this$0 = var1;
   }

   protected Runtime$FStat _fstat() {
      return new Runtime$SocketFStat();
   }

   public int write(byte[] var1, int var2, int var3) {
      if(var3 == 0) {
         return 0;
      } else {
         UnixRuntime$Pipe var4 = this.this$0;
         synchronized(this.this$0) {
            if(UnixRuntime$Pipe.access$200(this.this$0) == -1) {
               throw new Runtime$ErrnoException(32);
            } else {
               if(UnixRuntime$Pipe.access$300(this.this$0).length - UnixRuntime$Pipe.access$100(this.this$0) < Math.min(var3, 512)) {
                  while(UnixRuntime$Pipe.access$200(this.this$0) != -1 && UnixRuntime$Pipe.access$200(this.this$0) != UnixRuntime$Pipe.access$100(this.this$0)) {
                     try {
                        this.this$0.wait();
                     } catch (InterruptedException var7) {
                        ;
                     }
                  }

                  if(UnixRuntime$Pipe.access$200(this.this$0) == -1) {
                     throw new Runtime$ErrnoException(32);
                  }

                  UnixRuntime$Pipe.access$202(this.this$0, UnixRuntime$Pipe.access$102(this.this$0, 0));
               }

               var3 = Math.min(var3, UnixRuntime$Pipe.access$300(this.this$0).length - UnixRuntime$Pipe.access$100(this.this$0));
               System.arraycopy(var1, var2, UnixRuntime$Pipe.access$300(this.this$0), UnixRuntime$Pipe.access$100(this.this$0), var3);
               if(UnixRuntime$Pipe.access$200(this.this$0) == UnixRuntime$Pipe.access$100(this.this$0)) {
                  this.this$0.notify();
               }

               UnixRuntime$Pipe.access$112(this.this$0, var3);
               return var3;
            }
         }
      }
   }

   public int flags() {
      return 1;
   }

   public void _close() {
      UnixRuntime$Pipe var1 = this.this$0;
      synchronized(this.this$0) {
         UnixRuntime$Pipe.access$102(this.this$0, -1);
         this.this$0.notify();
      }
   }
}
