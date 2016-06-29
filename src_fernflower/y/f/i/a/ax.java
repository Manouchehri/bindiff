package y.f.i.a;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.aU;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.f;
import y.f.i.a.v;

class ax extends ab {
   private int b;
   private y.c.q c;
   private y.c.q d;
   private y.d.y e;
   private y.d.y f;
   private y.f.b.c g;
   private boolean h;

   protected void c() {
      super.c();
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = null;
      this.g = null;
   }

   protected void a(Z var1) {
      super.a(var1);
      this.g = var1.b();
   }

   protected void b(aa var1) {
      super.b(var1);
      this.b = var1.d().f().c();
      this.h = this.b > 0;
      if(this.h) {
         this.c = var1.c().c();
         this.d = var1.c().d();
         this.e = var1.f().g();
         this.f = var1.g().g();
      }

   }

   protected double a(f var1) {
      if(!this.h) {
         return 0.0D;
      } else {
         double var2 = 0.0D;
         if(var1.b() != null) {
            R var4 = var1.a();
            R var5 = var1.b().a();
            y.c.D var6 = new y.c.D(this.a(var5));
            y.c.D var7 = new y.c.D(this.a(var4));
            if(this.a(var1.b(), var6, var7)) {
               var2 += (double)this.b;
            }
         }

         return var2;
      }
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      if(!this.h) {
         this.b("punish node crossing", 0.0D, false);
         return new double[var3.length];
      } else {
         double var6 = 0.0D;
         if(this.a(var1, var2)) {
            var6 = (double)this.b;
         }

         double[] var8 = new double[var3.length];
         if(var6 > 0.0D) {
            Arrays.fill(var8, var6);
         }

         this.b("punish node crossing", var6, false);
         return var8;
      }
   }

   private boolean a(f var1, R var2) {
      R var3 = var1.a();
      List var4 = this.a(var3);
      List var5 = this.a(var2);
      return this.a(var1, var4, var5);
   }

   private boolean a(f var1, List var2, List var3) {
      y.c.q var4 = this.a(var2, var3);
      if(var4 != null && !this.a(var4) && !this.b(var4)) {
         return true;
      } else {
         y.c.q var5 = this.b(var2, var3);
         if(var5 == null) {
            return false;
         } else {
            boolean var6 = this.a(var5) || this.b(var5);
            return !var6?false:this.d(var1);
         }
      }
   }

   private boolean d(f var1) {
      int var5 = ab.a;
      boolean var2 = true;
      boolean var3 = true;
      f var4 = var1;

      boolean var10000;
      while(true) {
         if(!var2) {
            var10000 = var3;
            if(var5 != 0) {
               return !var10000 && !var3;
            }

            if(!var3) {
               break;
            }
         }

         if(var4 != null) {
            var2 &= this.b().b(var4.a());
            var3 &= this.b().d(var4.a());
            var4 = var4.b();
            if(var5 == 0) {
               continue;
            }
         }
         break;
      }

      var10000 = var2;
      return !var10000 && !var3;
   }

   private boolean a(y.c.q var1) {
      return this.a(this.f, var1);
   }

   private boolean b(y.c.q var1) {
      int var8 = ab.a;
      aU var2 = this.a().a(this.b().c());
      List var3 = var2.b(false);
      boolean var10000;
      if(!var3.isEmpty()) {
         y.d.y var4 = this.a().a().s(var1);
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            y.f.ax var6 = (y.f.ax)var5.next();
            y.d.t var7 = var2.a(var6, false);
            if(var4.a(var7)) {
               var10000 = true;
               if(var8 == 0) {
                  return true;
               }

               return var10000;
            }
         }
      }

      var10000 = false;
      return var10000;
   }

   private boolean a(y.d.y var1, y.c.q var2) {
      y.d.y var3 = this.a().a().s(var2);
      y.d.y var4 = new y.d.y(var3.c() - 1.0E-6D, var3.d() - 1.0E-6D, var3.a() + 2.0E-6D, var3.b() + 2.0E-6D);
      return var4.b(var1);
   }

   private y.c.q a(List var1, List var2) {
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         y.c.q var4 = (y.c.q)var3.next();
         if(!this.g.d(var4)) {
            if(!var1.contains(var4)) {
               return var4;
            }

            if(var1.contains(this.b().c().c())) {
               return var4;
            }
         }
      }

      return null;
   }

   private y.c.q b(List var1, List var2) {
      Iterator var3 = var1.iterator();

      y.c.q var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (y.c.q)var3.next();
      } while(this.g.d(var4) || var2.contains(var4));

      return var4;
   }

   private List a(R var1) {
      return (List)var1.a(T.a);
   }
}
