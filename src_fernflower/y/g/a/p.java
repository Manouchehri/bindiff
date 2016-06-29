package y.g.a;

import y.g.a.d;
import y.g.a.q;

class p {
   private q[] a;
   private int b;
   private int c;

   public p(int var1) {
      this.a = new q[var1 + 2];
      this.b = 0;
      this.c = var1;
   }

   public q a(int var1, Object var2) {
      if(this.b == this.c) {
         this.c += 1024;
         q[] var3 = new q[this.c + 2];
         System.arraycopy(this.a, 0, var3, 0, this.a.length);
         this.a = var3;
      }

      ++this.b;
      q var4 = new q(var1, var2, this.b);
      this.a(this.b, var4);
      return var4;
   }

   public void a() {
      boolean var2 = d.a;
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

   public void a(int var1, q var2) {
      boolean var5 = d.a;
      this.a[0] = var2;
      int var3 = var1 / 2;
      q var4 = this.a[var3];

      while(true) {
         if(var4.a > var2.a) {
            this.a[var1] = var4;
            var4.c = var1;
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
         var2.c = var1;
         this.a[0] = null;
         break;
      }

   }

   public void b(int var1, q var2) {
      boolean var5 = d.a;
      int var3 = var1 << 1;
      this.a[this.b + 1] = this.a[this.b];

      while(true) {
         if(var3 <= this.b) {
            q var4 = this.a[var3];
            if(var5) {
               break;
            }

            if(var3 < this.b && this.a[var3 + 1].a < var4.a) {
               ++var3;
               var4 = this.a[var3];
            }

            if(var2.a > var4.a) {
               this.a[var1] = var4;
               var4.c = var1;
               var1 = var3;
               var3 <<= 1;
               if(!var5) {
                  continue;
               }
            }
         }

         this.a[var1] = var2;
         var2.c = var1;
         this.a[this.b + 1] = null;
         break;
      }

   }

   public void a(q var1) {
      q var2 = this.a[this.b];
      this.a[this.b] = null;
      --this.b;
      if(var1 != var2) {
         if(var2.a > var1.a) {
            this.b(var1.c, var2);
            if(!d.a) {
               return;
            }
         }

         this.a(var1.c, var2);
      }

   }

   public void a(q var1, int var2) {
      var1.a = var2;
      this.a(var1.c, var1);
   }

   public void b(q var1, int var2) {
      var1.a = var2;
      this.b(var1.c, var1);
   }

   public void c(q var1, int var2) {
      if(var2 < var1.a) {
         this.a(var1, var2);
         if(!d.a) {
            return;
         }
      }

      this.b(var1, var2);
   }

   public q b() {
      return this.a[1];
   }

   public boolean c() {
      return this.b == 0;
   }
}
