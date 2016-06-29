package y.f.f.d;

import y.f.f.d.o;
import y.f.f.d.u;

class I {
   private u[] a;
   private int b;

   public I(int var1) {
      this.a = new u[var1 + 2];
      this.b = 0;
   }

   public void a(int var1, u var2) {
      ++this.b;
      var2.a = var1;
      var2.d = this.b;
      this.b(this.b, var2);
   }

   public void a() {
      boolean var2 = o.p;
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

   public void b(int var1, u var2) {
      boolean var5 = o.p;
      this.a[0] = var2;
      int var3 = var1 / 2;
      u var4 = this.a[var3];

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

   public void c(int var1, u var2) {
      boolean var5 = o.p;
      int var3 = var1 << 1;
      this.a[this.b + 1] = this.a[this.b];

      while(true) {
         if(var3 <= this.b) {
            u var4 = this.a[var3];
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

   public void a(u var1) {
      u var2 = this.a[this.b];
      this.a[this.b] = null;
      --this.b;
      if(var1 != var2) {
         if(var2.a > var1.a) {
            this.c(var1.d, var2);
            if(!o.p) {
               return;
            }
         }

         this.b(var1.d, var2);
      }

   }

   public void a(u var1, int var2) {
      var1.a = var2;
      this.b(var1.d, var1);
   }

   public u b() {
      return this.a[1];
   }

   public boolean c() {
      return this.b == 0;
   }
}
