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

class aX extends ab {
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
      this.c = var1.c().c();
      this.d = var1.c().d();
      this.e = var1.f().g();
      this.f = var1.g().g();
      this.b = var1.d().f().h();
      this.h = this.b > 0;
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
         this.b("punish minimal group node to edge distance", 0.0D, false);
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

         this.b("punish minimal group node to edge distance", var6, false);
         return var8;
      }
   }

   private boolean a(R var1) {
      Iterator var2 = this.b(var1).iterator();

      y.c.q var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (y.c.q)var2.next();
      } while(!this.g.d(var3) || var3 == this.c);

      return true;
   }

   private boolean a(f var1, R var2) {
      R var3 = var1.a();
      List var4 = this.c(var3);
      List var5 = this.b(var3);
      List var6 = this.b(var2);
      y.c.q var7 = this.a(var5, var6, var4);
      if(var7 != null && !this.a(var7)) {
         return true;
      } else {
         List var8 = this.c(var2);
         y.c.q var9 = this.b(var5, var6, var8);
         if(var9 != null) {
            boolean var10 = this.b(var9);
            boolean var11 = this.a(var9);
            boolean var12 = !var11 || var11 && var9 == this.c || var10 && var9 == this.d;
            if(!var12) {
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
      double var3 = this.a().c().l();
      y.d.y var5 = this.a().a().s(var2);
      y.d.y var6 = new y.d.y(var5.c() - var3, var5.d() - var3, var5.a() + 2.0D * var3, var5.b() + 2.0D * var3);
      return var6.b(var1);
   }

   private y.c.q a(List var1, List var2, List var3) {
      Iterator var4 = var2.iterator();

      y.c.q var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (y.c.q)var4.next();
      } while(!this.g.d(var5) || var1.contains(var5) || var3.contains(var5));

      return var5;
   }

   private y.c.q b(List var1, List var2, List var3) {
      Iterator var4 = var1.iterator();

      y.c.q var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (y.c.q)var4.next();
      } while(!this.g.d(var5) || var2.contains(var5) || var3.contains(var5));

      return var5;
   }

   private List b(R var1) {
      return (List)var1.a(T.b);
   }

   private List c(R var1) {
      return (List)var1.a(T.a);
   }
}
