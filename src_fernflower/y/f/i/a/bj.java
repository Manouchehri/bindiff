package y.f.i.a;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.H;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.V;
import y.f.i.a.aU;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.bR;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.x;

class bj extends ab implements H, bR {
   private y.d.y b;
   private M c;
   private M d;
   private M e;
   private M f;
   private M g;
   private M h;
   private int i;
   private int j;
   private double k;
   private double l;
   private boolean m;
   private boolean n;
   private boolean[] o;
   private List[] p;
   private aU q;

   protected void c() {
      super.c();
      this.b = null;
      this.c = null;
      this.d = null;
      this.g = null;
      this.h = null;
      this.e = null;
      this.f = null;
      this.o = null;
      this.p = null;
      this.q = null;
   }

   protected void b(aa var1) {
      int var11 = ab.a;
      super.b(var1);
      y.f.X var2 = this.a().a();
      y.c.d var3 = var1.c();
      x var4 = var1.d();
      this.i = var4.f().k();
      this.k = var4.a();
      this.l = var4.b();
      this.j = Math.min(this.i, 2 * var4.f().a());
      this.n = this.i > 0 && (this.l > 0.0D || this.k > 0.0D);
      if(this.n) {
         y.d.y var5;
         if(this.k > 0.0D) {
            var5 = var2.s(var3.c());
            this.c = new M(var5.c() - this.k, var5.c() + var5.a() + this.k);
            this.d = new M(var5.d() - this.k, var5.d() + var5.b() + this.k);
            this.b = new y.d.y(this.c.a(), this.d.a(), this.c.d(), this.d.d());
         }

         if(this.l > 0.0D) {
            label77: {
               var5 = var2.s(var3.d());
               this.g = new M(var5.c(), var5.c() + var5.a());
               this.h = new M(var5.d(), var5.d() + var5.b());
               this.e = new M(var5.c() - this.l, var5.c() + var5.a() + this.l);
               this.f = new M(var5.d() - this.l, var5.d() + var5.b() + this.l);
               this.o = new boolean[4];
               this.p = new List[4];
               this.q = this.a().a(var3);
               List var6 = this.q.a(false);
               if(var6 == null || var6.size() == 0) {
                  Arrays.fill(this.o, true);
                  if(var11 == 0) {
                     break label77;
                  }
               }

               Iterator var7 = var6.iterator();

               label48:
               do {
                  y.f.ax var8;
                  y.f.y var9;
                  do {
                     do {
                        if(!var7.hasNext()) {
                           break label48;
                        }

                        var8 = (y.f.ax)var7.next();
                        if(var8.a() == 255) {
                           Arrays.fill(this.o, true);
                           if(var11 == 0) {
                              break label48;
                           }
                        }

                        var9 = this.a(var8.a());
                     } while(var9 == null);

                     if(var8.b()) {
                        break;
                     }

                     this.o[var9.f()] = true;
                  } while(var11 == 0);

                  Object var10 = this.p[var9.f()];
                  if(var10 == null) {
                     var10 = new y.c.D();
                     this.p[var9.f()] = (List)var10;
                  }

                  ((List)var10).add(var8);
               } while(var11 == 0);
            }
         }

         V var12 = var1.a();
         var12.a((H)this);
         var12.a((bR)this);
      }
   }

   private y.f.y a(int var1) {
      switch(var1) {
      case 1:
         return y.f.y.c;
      case 2:
         return y.f.y.a;
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         return null;
      case 4:
         return y.f.y.d;
      case 8:
         return y.f.y.b;
      }
   }

   protected void c(aa var1) {
      super.c(var1);
      this.f(var1);
   }

   protected void d(aa var1) {
      super.d(var1);
      this.f(var1);
   }

   private void f(aa var1) {
      if(this.n) {
         V var2 = var1.a();
         var2.b((H)this);
         var2.b((bR)this);
      }

   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      if(!this.n) {
         this.b("minimal first/last segment length penalty", 0.0D, false);
         return new double[var3.length];
      } else {
         this.m = this.k > 0.0D && var1.c() != null && !var1.i() && P.a(this.b, var1.c());
         return super.a(var1, var2, var3, var4, var5);
      }
   }

   protected double a(f var1, R var2, P var3, v var4, double var5) {
      int var12 = ab.a;
      double var7 = 0.0D;
      if(this.m && this.k > 0.0D) {
         label60: {
            P var9 = var1.c();
            double var10 = var9 != null?(var9.a()?var1.a().l():var1.a().m()):0.0D;
            if(var4.c() == 1) {
               if(!(var3.a()?this.c:this.d).a(var3.f())) {
                  break label60;
               }

               var7 = (double)this.i;
               if(var12 == 0) {
                  break label60;
               }
            }

            if(var4.c() == 2) {
               if(!var3.e().a(var3.a()?this.d:this.c, 1.0E-6D)) {
                  break label60;
               }

               var7 = (double)this.i;
               if(var12 == 0) {
                  break label60;
               }
            }

            if(var4.c() == 3 && this.b.a(var1.a().g()) + var10 < this.k) {
               var7 = (double)this.i;
            }
         }
      }

      if(this.l > 0.0D && this.b().d(var2) && this.a(var1, var4, var3)) {
         var7 += (double)this.i;
      }

      this.a("minimal first/last segment length penalty", var7, false);
      return var7;
   }

   private boolean a(f var1, v var2, P var3) {
      int var9 = ab.a;
      v var4 = var2;
      f var5 = var1;

      label57: {
         v var10000;
         while(true) {
            if(var5 != null) {
               var10000 = var4;
               if(var9 != 0) {
                  break;
               }

               if(var4 != null && var4.c() == 0) {
                  var4 = var5.j();
                  var5 = var5.b();
                  if(var9 == 0) {
                     continue;
                  }
               }
            }

            if(var5 == null) {
               break label57;
            }

            var10000 = var4;
            break;
         }

         if(var10000 != null) {
            switch(var4.c()) {
            case 1:
            case 3:
               R var7 = var5.a();
               M var8 = var3.a()?new M(var7.h(), var7.j()):new M(var7.i(), var7.k());
               return var8.b(var3.f()) + var8.d() < this.l;
            case 2:
               P var10 = var5.c();
               return var10.e().b(var3.f()) + var10.d() < this.l;
            default:
               return true;
            }
         }
      }

      M var6 = var3.a()?new M(this.b().f().h(), this.b().f().j()):new M(this.b().f().i(), this.b().f().k());
      return var6.b(var3.f()) < this.l;
   }

   protected double b(f var1) {
      if(this.l > 0.0D && this.j > 0 && !this.b().d(var1.a()) && this.d(var1) && this.e(var1)) {
         y.f.y var2 = var1.d();
         P var3 = var1.c();
         M var4 = var2.d()?this.h:this.g;
         double var5 = 0.0D;
         M var7 = M.a(var3.e(), var4);
         if(var7 != null && var7.d() > 0.0D) {
            if(this.a(var1, var7)) {
               return 0.0D;
            }

            if(this.f(var1)) {
               var5 = (double)this.i;
            }
         }

         boolean var8 = var2 == y.f.y.b || var2 == y.f.y.a;
         int var9;
         if(var8 && var3.b() < var4.a() || !var8 && var3.c() > var4.b()) {
            var9 = var2.a().f();
            if(this.o[var9] || this.p[var9] != null) {
               var5 = (double)this.j;
            }
         }

         if(!var8 && var3.b() < var4.a() || var8 && var3.c() > var4.b()) {
            var9 = var2.b().f();
            if(this.o[var9] || this.p[var9] != null) {
               var5 = (double)this.j;
            }
         }

         this.a("HEUR minimal first/last segment length penalty", var5, true);
         return var5;
      } else {
         return 0.0D;
      }
   }

   private boolean d(f var1) {
      y.f.y var2 = var1.d();
      M var3 = var2.d()?this.g:this.h;
      return var2 != y.f.y.b && var2 != y.f.y.c?var1.c().f() >= var3.a():var1.c().f() <= var3.b();
   }

   private boolean e(f var1) {
      M var2 = var1.d().d()?this.f:this.e;
      return var1.c().e().c(var2);
   }

   private boolean a(f var1, M var2) {
      int var10 = ab.a;
      int var3 = var1.d().f();
      if(this.o[var3]) {
         return true;
      } else if(this.p[var3] == null) {
         return false;
      } else {
         List var4 = this.p[var3];
         Iterator var5 = var4.iterator();

         boolean var10000;
         while(true) {
            if(var5.hasNext()) {
               y.f.ax var6 = (y.f.ax)var5.next();
               y.d.t var7 = this.q.a(var6, false);
               double var8 = var1.d().e()?var7.a():var7.b();
               if(!var2.a(var8)) {
                  continue;
               }

               var10000 = true;
               if(var10 == 0) {
                  return true;
               }
               break;
            }

            var10000 = false;
            break;
         }

         return var10000;
      }
   }

   private boolean f(f var1) {
      if(this.p[var1.d().f()] == null) {
         return false;
      } else {
         M var2 = var1.d().d()?this.e:this.f;
         return var2.a(var1.c().f());
      }
   }

   public void a(f var1, R var2, P var3, List var4, aa var5) {
      if(this.n) {
         boolean var6 = !var3.a();
         P var7 = var1.c();
         if(!var1.i() && var7 != null && this.k > 0.0D) {
            y.f.y var9 = V.a(var1, var2);
            P var8;
            if(var9 == var1.d() && (var6?this.d:this.c).a(var3.f()) && !var3.e().c(var7.e())) {
               var8 = P.a(var7, var3);
               if(var8 == null) {
                  return;
               }

               var4.add(var8);
            }

            if(var7.a() == var6) {
               M var10 = this.a(var3.e(), var6?this.c:this.d);
               if(var10 != null) {
                  var8 = new P(var10.a(), var10.b(), var3.f(), var3.a());
                  var4.add(var8);
               }
            }
         }

      }
   }

   private M a(M var1, M var2) {
      M var3 = null;
      if(var1.a(var2, 1.0E-6D) && !var1.c(var2)) {
         if(var1.a() < var2.a()) {
            var3 = new M(var1.a(), var2.a());
         } else {
            var3 = new M(var2.b(), var1.b());
         }
      }

      return var3;
   }

   public void a(f var1, aa var2, byte var3) {
      int var5 = ab.a;
      if(this.k > 0.0D && var3 != 0) {
         f var4 = var1.b();
         if(var4 == null || var4.c() == null) {
            var1.c(false);
            if(var5 == 0) {
               return;
            }
         }

         if(var4.i()) {
            var1.c(true);
            if(var5 == 0) {
               return;
            }
         }

         if(var4.d() != var1.d() || !var4.c().b(var1.c())) {
            var1.c(true);
            if(var5 == 0) {
               return;
            }
         }

         var1.c(false);
      }

   }
}
