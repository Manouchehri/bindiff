package y.f.i.a;

import y.f.i.a.ab;
import y.f.i.a.bD;

class bE {
   private int a;
   private bD b;

   public bE(int var1) {
      this(var1, (bD)null);
   }

   public bE(int var1, bD var2) {
      this.a = var1;
      this.b = var2;
   }

   public int a() {
      return this.a;
   }

   public bD b() {
      return this.b;
   }

   public boolean c() {
      return this.b != null;
   }

   public void a(bD var1) {
      int var5 = ab.a;
      if(this.b == null) {
         this.b = var1;
         if(var5 == 0) {
            return;
         }
      }

      if(var1 != null && this.b.a(var1)) {
         int var2 = this.b.c();
         int var3 = var1.c();
         int var4 = Math.min(var2, var3);
         this.a += var4;
         if(var3 > var4) {
            this.b = new bD(bD.c(var1), bD.d(var1), bD.b(var1), var3 - var4);
            if(var5 == 0) {
               return;
            }
         }

         if(var2 > var4) {
            this.b.a(var2 - var4);
            if(var5 == 0) {
               return;
            }
         }

         this.b = null;
      }

   }
}
