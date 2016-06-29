package y.f.i.a;

import java.util.List;
import y.f.i.a.M;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.bR;
import y.f.i.a.f;

class bk extends ab implements bR {
   private boolean b;
   private double c;
   private M d;
   private M e;
   private M f;
   private M g;
   private int h;

   protected void a(Z var1) {
      super.a(var1);
      this.c = this.a().c().l();
   }

   protected void c() {
      super.c();
      this.d = null;
      this.e = null;
      this.f = null;
      this.g = null;
   }

   protected void b(aa var1) {
      this.b = this.d();
      if(this.b) {
         y.d.y var2 = var1.g().g();
         this.d = new M(var2.c(), var2.c() + var2.a());
         this.e = new M(var2.d(), var2.d() + var2.b());
         this.f = new M(var2.c() - this.c, var2.c() + var2.a() + this.c);
         this.g = new M(var2.d() - this.c, var2.d() + var2.b() + this.c);
         this.h = Math.min(var1.d().f().g(), 2 * var1.d().f().a());
         var1.a().a((bR)this);
      }

   }

   protected void c(aa var1) {
      super.c(var1);
      if(this.b) {
         this.b().a().b((bR)this);
      }

   }

   protected void d(aa var1) {
      super.d(var1);
      if(this.b) {
         this.b().a().b((bR)this);
      }

   }

   protected double b(f var1) {
      if(this.b && (var1.b() == null || !var1.b().g()) && this.a(var1.a()) && this.d(var1) && this.e(var1)) {
         this.a("HEUR Punish intersecting source and target", (double)this.h, true);
         return (double)this.h;
      } else {
         return 0.0D;
      }
   }

   private boolean d(f var1) {
      y.f.y var2 = var1.d();
      M var3 = var2.d()?this.d:this.e;
      return var2 != y.f.y.b && var2 != y.f.y.c?var1.c().f() >= var3.a():var1.c().f() <= var3.b();
   }

   private boolean e(f var1) {
      M var2 = var1.d().d()?this.g:this.f;
      return var1.c().e().c(var2);
   }

   public void a(f var1, aa var2, byte var3) {
      if(this.b) {
         if(var3 == 1 || var3 == 2) {
            f var4 = var1.b();
            if(var4 != null && var4.g()) {
               var1.b(true);
               if(ab.a == 0) {
                  return;
               }
            }

            if(!this.a(var1.a())) {
               var1.b(true);
            }
         }

      }
   }

   protected boolean c(f var1) {
      boolean var2 = var1.j() != null;
      return (!this.b || var1.g()) && var2;
   }

   private boolean d() {
      y.d.y var1 = this.b().f().g();
      y.d.y var2 = this.b().g().g();
      return var1.c + var1.a > var2.c - 1.0E-6D && var1.d + var1.b > var2.d - 1.0E-6D && var1.c < var2.c + var2.a + 1.0E-6D && var1.d < var2.d + var2.b + 1.0E-6D;
   }

   private boolean a(R var1) {
      List var2 = this.b(var1);
      List var3 = this.c(var1);
      y.c.q var4 = this.b().c().d();
      return var2.contains(var4) || var3.contains(var4);
   }

   private List b(R var1) {
      return (List)var1.a(T.b);
   }

   private List c(R var1) {
      return (List)var1.a(T.a);
   }
}
