package y.f.d;

import y.f.Q;
import y.f.d.a;
import y.f.d.i;
import y.f.d.r;

class k {
   private y.c.y a;
   private y.c.f b;
   private y.c.D c;
   private final i d;

   public k(i var1) {
      this.d = var1;
      this.a = new y.c.y();
      this.b = new y.c.f();
      this.c = new y.c.D();
   }

   public void a(y.c.q var1) {
      this.a.add(var1);
   }

   public void a(y.c.d var1) {
      this.b.add(var1);
   }

   public void a(r var1) {
      this.c.add(var1);
   }

   public String toString() {
      int var4 = a.f;
      r[] var1 = this.a();
      StringBuffer var2 = new StringBuffer();
      int var3 = 0;

      StringBuffer var10000;
      while(true) {
         if(var3 < var1.length) {
            var10000 = var2.append(var1[var3].toString() + "\n");
            if(var4 != 0) {
               break;
            }

            ++var3;
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000.toString();
   }

   public r[] a() {
      int var4 = a.f;
      r[] var1 = new r[this.c.size()];
      int var2 = 0;
      y.c.C var3 = this.c.m();

      r[] var10000;
      while(true) {
         if(var3.f()) {
            var10000 = var1;
            if(var4 != 0) {
               break;
            }

            var1[var2++] = (r)var3.d();
            var3.g();
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public void b() {
      int var7 = a.f;
      int var1 = 0;
      y.c.C var2 = this.c.m();

      while(var2.f()) {
         r var3 = (r)var2.d();
         y.c.C var4 = var3.b().m();

         while(true) {
            if(var4.f()) {
               Q var5 = (Q)var4.d();
               y.c.q var6 = (y.c.q)this.d.o.get(var5);
               this.d.p.a(var6, var1);
               var4.g();
               if(var7 != 0) {
                  break;
               }

               if(var7 == 0) {
                  continue;
               }
            }

            ++var1;
            var2.g();
            break;
         }

         if(var7 != 0) {
            break;
         }
      }

   }

   public void c() {
      int var2 = a.f;
      y.c.x var1 = this.d.i.o();

      while(true) {
         if(var1.f()) {
            this.d.i.c(var1.e());
            var1.g();
            if(var2 != 0) {
               break;
            }

            if(var2 == 0) {
               continue;
            }
         }

         var1 = this.a.a();
         break;
      }

      k var10000;
      while(true) {
         if(var1.f()) {
            var10000 = this;
            if(var2 != 0) {
               break;
            }

            this.d.i.d(var1.e());
            var1.g();
            if(var2 == 0) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var3 = var10000.b.a();

      while(var3.f()) {
         this.d.i.e(var3.a());
         var3.g();
         if(var2 != 0) {
            break;
         }
      }

   }
}
