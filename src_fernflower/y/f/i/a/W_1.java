package y.f.i.a;

import y.f.i.a.Y;
import y.f.i.a.ab;

class W extends Y {
   private int a = 10;
   private long b = 50L;
   private long c;
   private long d;
   private long e;
   private long f;
   private final long g;
   private long h;

   W(long var1, long var3) {
      this.c = this.b;
      this.d = this.e = var1;
      this.f = var3;
      this.g = var3 - var1;
   }

   protected boolean a(long var1) {
      if(var1 != this.c) {
         return false;
      } else {
         long var3;
         label18: {
            this.h = var1;
            var3 = System.currentTimeMillis();
            long var5 = var3 - this.d;
            long var7 = Math.max((long)this.a, (this.f - var3) / 2L);
            if(var5 == 0L) {
               this.b *= var7;
               if(ab.a == 0) {
                  break label18;
               }
            }

            this.b = Math.max(1L, (long)((double)var7 / (double)var5 * (double)this.b));
         }

         this.c = var1 + this.b;
         this.d = var3;
         if(var3 >= this.f) {
            this.f = var3 + this.g;
            return true;
         } else {
            return false;
         }
      }
   }
}
