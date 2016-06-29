package y.f.h;

import y.f.h.M;
import y.f.h.N;

class L {
   private M[] a;
   private int b;
   private int c;

   L(int var1) {
      this.a = new M[var1 + 2];
      this.b = 0;
      this.c = var1;
   }

   public M a(int var1, y.c.q var2, M var3, int var4) {
      if(this.b == this.c) {
         this.c += 1024;
         M[] var5 = new M[this.c + 2];
         System.arraycopy(this.a, 0, var5, 0, this.a.length);
         this.a = var5;
      }

      M var6;
      label14: {
         ++this.b;
         if(var3 == null) {
            var6 = new M(var1, var2, this.b, var4);
            if(!N.d) {
               break label14;
            }
         }

         var6 = var3;
         var3.a = var1;
         var3.b = var2;
         var3.d = this.b;
         var3.c = var4;
      }

      this.a(this.b, var6);
      return var6;
   }

   public void a() {
      boolean var2 = N.d;
      int var1 = 1;

      while(true) {
         if(var1 <= this.b) {
            this.a[var1] = null;
            ++var1;
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         this.b = 0;
         break;
      }

   }

   public void a(int var1, M var2) {
      boolean var5 = N.d;
      this.a[0] = var2;
      int var3 = var1 / 2;
      M var4 = this.a[var3];

      while(true) {
         if(var4.a > var2.a) {
            this.a[var1] = var4;
            var4.d = var1;
            var1 = var3;
            var3 >>= 1;
            var4 = this.a[var3];
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         this.a[var1] = var2;
         var2.d = var1;
         break;
      }

   }

   public void b(int var1, M var2) {
      boolean var5 = N.d;
      int var3 = var1 << 1;
      this.a[this.b + 1] = this.a[this.b];

      while(true) {
         if(var3 <= this.b) {
            M var4 = this.a[var3];
            if(var5) {
               break;
            }

            if(var3 < this.b && this.a[var3 + 1].a < var4.a) {
               ++var3;
               var4 = this.a[var3];
            }

            if(var2.a > var4.a) {
               this.a[var1] = var4;
               var4.d = var1;
               var1 = var3;
               var3 <<= 1;
               if(!var5) {
                  continue;
               }
            }
         }

         this.a[var1] = var2;
         var2.d = var1;
         break;
      }

   }

   public void a(M var1) {
      M var2 = this.a[this.b];
      this.a[this.b] = null;
      --this.b;
      if(var1 != var2) {
         if(var2.a > var1.a) {
            this.b(var1.d, var2);
            if(!N.d) {
               return;
            }
         }

         this.a(var1.d, var2);
      }

   }

   public void a(M var1, int var2) {
      var1.a = var2;
      this.a(var1.d, var1);
   }

   public M b() {
      return this.a[1];
   }

   public boolean c() {
      return this.b == 0;
   }
}
