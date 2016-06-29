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

class ay extends ab {
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
      this.b = var1.d().f().g();
      this.h = this.b > 0;
      if(this.h) {
         this.c = var1.c().c();
         this.d = var1.c().d();
         this.e = var1.f().g();
         this.f = var1.g().g();
      }

   }

   protected double a(f var1) {
      double var2 = 0.0D;
      if(this.h && var1.b() != null && this.a(var1.b(), var1.a())) {
         var2 += (double)this.b;
      }

      return var2;
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      double var6 = 0.0D;
      if(this.h && this.a(var1, var2)) {
         var6 = (double)this.b;
      }

      double[] var8 = new double[var3.length];
      if(var6 > 0.0D) {
         Arrays.fill(var8, var6);
      }

      this.b("punish minimal node to edge distance", var6, false);
      return var8;
   }

   private boolean a(f var1, R var2) {
      R var3 = var1.a();
      List var4 = this.b(var3);
      List var5 = this.a(var3);
      List var6 = this.a(var2);
      y.c.q var7 = this.a(var5, var6, var4);
      if(var7 != null && !this.a(var7) && !this.b(var7)) {
         return true;
      } else {
         List var8 = this.b(var2);
         y.c.q var9 = this.b(var5, var6, var8);
         if(var9 == null) {
            return false;
         } else {
            boolean var10 = this.a(var9) || this.b(var9);
            return !var10?false:this.d(var1);
         }
      }
   }

   private boolean d(f var1) {
      int var6 = ab.a;
      boolean var2 = true;
      boolean var3 = true;
      f var4 = var1;

      boolean var10000;
      while(true) {
         if(!var2) {
            var10000 = var3;
            if(var6 != 0) {
               return !var10000 && !var3;
            }

            if(!var3) {
               break;
            }
         }

         if(var4 != null) {
            R var5 = var4.a();
            var2 &= this.b().b(var5) || this.a(var5).contains(this.c);
            var3 &= this.b().d(var5) || this.a(var5).contains(this.d);
            var4 = var4.b();
            if(var6 == 0) {
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
      double var3 = this.a().c().l();
      y.d.y var5 = this.a().a().s(var2);
      y.d.y var6 = new y.d.y(var5.c() - var3, var5.d() - var3, var5.a() + 2.0D * var3, var5.b() + 2.0D * var3);
      return var6.b(var1);
   }

   private y.c.q a(List var1, List var2, List var3) {
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         y.c.q var5 = (y.c.q)var4.next();
         if(!this.g.d(var5) && !var1.contains(var5)) {
            if(!var3.contains(var5)) {
               return var5;
            }

            if(var3.contains(this.c) && var2.size() > 1) {
               return var5;
            }
         }
      }

      return null;
   }

   private y.c.q b(List var1, List var2, List var3) {
      Iterator var4 = var1.iterator();

      y.c.q var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (y.c.q)var4.next();
      } while(this.g.d(var5) || var2.contains(var5) || var3.contains(var5));

      return var5;
   }

   private List a(R var1) {
      return (List)var1.a(T.b);
   }

   private List b(R var1) {
      return (List)var1.a(T.a);
   }
}
