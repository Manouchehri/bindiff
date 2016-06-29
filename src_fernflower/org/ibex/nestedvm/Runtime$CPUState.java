package org.ibex.nestedvm;

public class Runtime$CPUState {
   public int[] r = new int[32];
   public int[] f = new int[32];
   public int hi;
   public int lo;
   public int fcsr;
   public int pc;

   public Runtime$CPUState dup() {
      Runtime$CPUState var1 = new Runtime$CPUState();
      var1.hi = this.hi;
      var1.lo = this.lo;
      var1.fcsr = this.fcsr;
      var1.pc = this.pc;

      for(int var2 = 0; var2 < 32; ++var2) {
         var1.r[var2] = this.r[var2];
         var1.f[var2] = this.f[var2];
      }

      return var1;
   }
}
