package y.f.i.a;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.f;
import y.f.i.a.v;

class aY extends ab {
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
      this.b = var1.d().f().d();
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
            boolean var6 = this.a(var4);
            boolean var7 = this.a(var5);
            if(var6 || var7) {
               var2 += (double)this.b;
            }
         }

         return var2;
      }
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      if(!this.h) {
         this.b("punish group node crossing", 0.0D, false);
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

         this.b("punish group node crossing", var6, false);
         return var8;
      }
   }

   private boolean a(R var1) {
      int var4 = ab.a;
      Iterator var2 = this.b(var1).iterator();

      boolean var10000;
      while(true) {
         if(!var2.hasNext()) {
            var10000 = false;
            break;
         }

         y.c.q var3 = (y.c.q)var2.next();
         if(this.g.d(var3)) {
            var10000 = this.c(var3);
            if(var4 != 0) {
               break;
            }

            if(!var10000) {
               return true;
            }
         }
      }

      return var10000;
   }

   private boolean a(f var1, R var2) {
      R var3 = var1.a();
      List var4 = this.b(var3);
      List var5 = this.b(var2);
      y.c.q var6 = this.a(var4, var5);
      if(var6 != null && !this.a(var6)) {
         return true;
      } else {
         y.c.q var7 = this.b(var4, var5);
         if(var7 != null) {
            boolean var8 = this.b(var7);
            boolean var9 = this.a(var7);
            boolean var10 = !var9 || var9 && var7 == this.c || var8 && var7 == this.d;
            if(!var10) {
               return true;
            }
         }

         return false;
      }
   }

   private boolean a(y.c.q var1) {
      return this.a(this.f, var1);
   }

   private boolean b(y.c.q var1) {
      return this.a(this.e, var1);
   }

   private boolean a(y.d.y var1, y.c.q var2) {
      y.d.y var3 = this.a().a().s(var2);
      y.d.y var4 = new y.d.y(var3.c() - 1.0E-6D, var3.d() - 1.0E-6D, var3.a() + 2.0E-6D, var3.b() + 2.0E-6D);
      return var4.b(var1);
   }

   private y.c.q a(List var1, List var2) {
      Iterator var3 = var2.iterator();

      y.c.q var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (y.c.q)var3.next();
      } while(!this.g.d(var4) || var1.contains(var4));

      return var4;
   }

   private y.c.q b(List var1, List var2) {
      Iterator var3 = var1.iterator();

      y.c.q var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (y.c.q)var3.next();
      } while(!this.g.d(var4) || var2.contains(var4));

      return var4;
   }

   private boolean c(y.c.q var1) {
      return this.a(var1, this.b().c().c());
   }

   private boolean a(y.c.q var1, y.c.q var2) {
      int var4 = ab.a;
      y.c.q var3 = var2;

      while(var3 != this.g.b()) {
         if(var3 == var1) {
            return true;
         }

         var3 = this.g.a(var3);
         if(var4 != 0) {
            break;
         }
      }

      return false;
   }

   private List b(R var1) {
      return (List)var1.a(T.a);
   }
}
