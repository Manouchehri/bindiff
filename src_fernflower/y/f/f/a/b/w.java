package y.f.f.a.b;

import y.f.f.a.b.E;
import y.f.f.a.b.a;
import y.f.f.a.b.g;
import y.f.f.a.b.l;
import y.f.f.a.b.m;
import y.f.f.a.b.r;
import y.f.f.a.b.u;
import y.f.f.a.b.x;
import y.f.f.a.b.y;
import y.f.f.a.b.z;

public class w implements y.f.h.o {
   private y.c.i a;
   private y.f.f.a.a.p b;
   private y.f.h.D c;
   private a d;
   private y.c.f e;
   private y.c.f f;
   private int g = 0;
   private boolean h = true;
   private boolean i = false;

   public w(a var1, y.c.f var2) {
      this.a(var1);
      this.e = var2;
   }

   public void a() {
   }

   public void a(a var1) {
      this.d = var1;
      this.a = this.d.d();
      this.b = this.d.b();
   }

   public void a(y.f.h.D var1) {
      this.c = var1;
   }

   public a b() {
      return this.d;
   }

   public void a(int var1) {
      this.g = var1;
   }

   public void a(boolean var1) {
      this.h = var1;
   }

   public void b(boolean var1) {
      this.i = var1;
   }

   private y.c.f d() {
      boolean var5 = a.c;
      y.c.f var1 = new y.c.f();
      y.c.f[] var2 = y.a.h.d(this.a);
      int var3 = 0;

      y.c.f var10000;
      while(true) {
         if(var3 < var2.length) {
            y.c.f var4 = var2[var3];
            var10000 = var4;
            if(var5) {
               break;
            }

            if(var4.size() > 1) {
               var1.a(var4);
            }

            ++var3;
            if(!var5) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public void c() {
      boolean var7 = a.c;
      y.c.d[] var1 = this.c.g().n();
      this.d.a(this.c);
      y.c.f var2 = this.d();
      l var3 = this.e();
      var3.a(this.d);
      this.f = var3.a();
      if(this.g == 1) {
         this.b(this.f);
      }

      y.c.f var4 = m.a(this.d);
      r.a(this.d);
      this.d.g();
      y var5 = new y(this.d);
      var5.a(this.h);
      var5.a(this.f);
      var5.a();
      if(this.i) {
         u var6 = new u(this.d);
         var6.a(var2);
      }

      this.d.h();
      z.a(this.d, this.e);
      int var8 = 0;

      while(var8 < var1.length) {
         this.a(var1[var8], this.d.d(var1[var8]));
         ++var8;
         if(var7) {
            y.c.i.g = !y.c.i.g;
            break;
         }
      }

   }

   private y.c.f a(y.c.f var1) {
      boolean var5 = a.c;
      if(var1 == null) {
         return null;
      } else {
         y.c.f var2 = new y.c.f();
         y.c.e var3 = var1.a();

         while(var3.f()) {
            y.c.d var4 = var3.a();
            if(!this.d.p(var4)) {
               var2.add(var4);
            }

            var3.g();
            if(var5) {
               break;
            }
         }

         return var2;
      }
   }

   private void a(y.c.d var1, y.c.f var2) {
      boolean var9 = a.c;
      y.c.h var3 = (y.c.h)this.a.c(y.f.f.b.n);
      y.f.f.a var4 = (y.f.f.a)var3.b(var1);
      y.c.f var5 = this.a(var2);
      if(var4 != null && var5 != null) {
         int var6 = 0;
         y.c.e var7 = var5.a();

         while(var7.f()) {
            y.f.f.a var8 = var4.d();
            if(var6 > 0) {
               var8.a(0.0D);
            }

            if(var6 < var5.size() - 1) {
               var8.b(0.0D);
            }

            var3.a(var7.a(), var8);
            var7.g();
            ++var6;
            if(var9) {
               break;
            }
         }
      }

   }

   private l e() {
      switch(this.g) {
      case 0:
         return new x();
      case 1:
         return new g();
      default:
         throw new RuntimeException("Bad subgraph algorithm!");
      }
   }

   private void b(y.c.f var1) {
      boolean var5 = a.c;
      this.d.g();
      if(E.b(this.a, this.b)) {
         this.d.h();
      } else {
         y.c.d[] var2 = this.a.n();
         int var3 = 0;

         w var10000;
         while(true) {
            if(var3 < var2.length) {
               y.c.d var4 = var2[var3];
               var10000 = this;
               if(var5) {
                  break;
               }

               if(this.d.a(var4)) {
                  this.a.a(var4);
               }

               ++var3;
               if(!var5) {
                  continue;
               }
            }

            var10000 = this;
            break;
         }

         y.c.e var6 = var10000.f.a();

         while(true) {
            if(var6.f()) {
               this.a.e(var6.a());
               var6.g();
               if(var5) {
                  break;
               }

               if(!var5) {
                  continue;
               }
            }

            this.f = null;
            this.a(0);
            break;
         }

         l var7 = this.e();
         var7.a(this.d);
         this.f = var7.a();
      }
   }
}
