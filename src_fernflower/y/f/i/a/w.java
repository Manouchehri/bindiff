package y.f.i.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.U;
import y.f.i.a.Z;
import y.f.i.a.aU;
import y.f.i.a.ab;
import y.f.i.a.ah;
import y.f.i.a.ai;
import y.f.i.a.f;
import y.f.i.a.g;
import y.f.i.a.v;
import y.f.i.a.x;
import y.f.i.a.y;

public class w {
   private final y.c.d d;
   private final Z e;
   private final boolean f;
   private ai[] g;
   private final List h;
   private final Map i;
   R[] a;
   R[] b;
   R[] c;
   private y.d.t j;
   private y.d.t k;

   w(y.c.d var1, Z var2) {
      int var9 = ab.a;
      super();
      this.i = new HashMap();
      this.e = var2;
      this.d = var1;
      this.f = true;
      this.h = Collections.EMPTY_LIST;
      y.f.X var3 = var2.a();
      if(y.b(var1, var3)) {
         y.d.m[] var4 = y.c(var1, var3);
         this.g = new ai[var4.length];
         int var5 = 0;

         do {
            if(var5 >= var4.length) {
               return;
            }

            this.g[var5] = new ai(var1, var5, var4[var5]);
            ++var5;
         } while(var9 == 0);
      }

      ArrayList var10 = new ArrayList();
      y.d.v var11 = var3.l(var1);
      int var6 = var11.h() - 1;
      int var7 = 0;

      byte var10000;
      label35: {
         while(var7 < var6) {
            y.d.m var8 = var11.a(var7);
            var10000 = this.a(var8);
            if(var9 != 0) {
               break label35;
            }

            if(var10000 != 0) {
               var10.add(var8);
            }

            ++var7;
            if(var9 != 0) {
               break;
            }
         }

         this.g = new ai[var10.size()];
         var10000 = 0;
      }

      var7 = var10000;

      while(var7 < var10.size()) {
         this.g[var7] = new ai(var1, var7, (y.d.m)var10.get(var7));
         ++var7;
         if(var9 != 0) {
            break;
         }
      }

   }

   void a() {
      int var8 = ab.a;
      HashSet var1 = new HashSet();
      int var2 = 0;

      w var10000;
      while(true) {
         if(var2 < this.g.length) {
            var10000 = this;
            if(var8 != 0) {
               break;
            }

            ai var3 = this.g[var2];
            double var4 = var3.e();
            M var6 = new M(var4, var4);
            var3.b(var6);
            ah var7 = var3.k();
            if(var7 != null && var1.add(var7)) {
               var7.a(var6);
               var7.c().b(var6);
            }

            ++var2;
            if(var8 == 0) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      Iterator var9 = var10000.d().iterator();

      while(var9.hasNext()) {
         ((v)var9.next()).a(this);
         if(var8 != 0) {
            break;
         }
      }

   }

   private boolean a(y.d.m var1) {
      return var1.b() || var1.a();
   }

   public w(U var1, Z var2) {
      this.i = new HashMap();
      this.e = var2;
      this.d = var1.a();
      this.f = false;
      this.h = this.a(var1);
      y.c.D var3 = this.a(this.h);
      this.b((List)var3);
      this.a(this.g);
   }

   w(y.c.d var1, List var2, Z var3) {
      this.i = new HashMap();
      this.e = var3;
      this.d = var1;
      this.f = false;
      this.h = null;
      this.b(var2);
   }

   public boolean b() {
      return this.f;
   }

   private void a(ai[] var1) {
      if(var1.length > 1) {
         x var2 = this.e.c().a(this.d);
         ai var3 = var1[1];
         y.d.y var4 = this.e.a().s(this.d.c());
         this.a(var3, var4, var2.a());
         ai var5 = var1[var1.length - 2];
         y.d.y var6 = this.e.a().s(this.d.d());
         this.a(var5, var6, var2.b());
      }

   }

   private void a(ai var1, y.d.y var2, double var3) {
      M var5 = var1.g()?new M(var2.c(), var2.c() + var2.a()):new M(var2.d(), var2.d() + var2.b());
      M var6 = new M(var5.a() - var3, var5.b() + var3);
      M var7 = var1.c();
      if(var6.a(var7, 1.0E-6D)) {
         double var8;
         if(var7.a() < var5.a() + 1.0E-6D) {
            var8 = Math.max(var7.a(), var6.a());
            var1.b(new M(var7.a(), var8));
            if(ab.a == 0) {
               return;
            }
         }

         var8 = Math.min(var6.b(), var7.b());
         var1.b(new M(var8, var7.b()));
      }

   }

   private List a(U var1) {
      int var18 = ab.a;
      if(var1.b() == 0) {
         return Collections.EMPTY_LIST;
      } else {
         y.c.D var2 = new y.c.D();
         f var3 = null;
         P var4 = null;
         int var5 = var1.b() - 1;

         while(var5 >= 0) {
            f var6;
            P var8;
            label57: {
               var6 = var1.a(var5);
               R var7 = var6.a();
               var8 = var6.c();
               v var10;
               if(var5 == 0) {
                  var10 = new v(this.d, var7, (P)null, var4, (y.f.y)null, var3.d(), 0);
                  var2.add(0, var10);
                  this.i.put(var6, var10);
                  if(var18 == 0) {
                     break label57;
                  }
               }

               if(var3 != null) {
                  y.f.y var19 = var6.d();
                  y.f.y var11 = var3.d();
                  if(var19 == var11 && var8.b(var4)) {
                     var8 = P.a(var4, var6.c());
                  }

                  v var12 = new v(this.d, var7, var8, var4, var19, var11, 0);
                  var2.add(0, var12);
                  this.i.put(var6, var12);
                  if(var18 == 0) {
                     break label57;
                  }
               }

               aU var9 = this.e.a(this.d);
               if(var9 != null) {
                  List var20 = var9.a(var9.a(var1, false));
                  if(!var20.isEmpty()) {
                     boolean var21 = var6.d().e();
                     y.f.ax var22 = (y.f.ax)var20.get(0);
                     y.d.t var13 = var9.a(var22, false);
                     double var14 = var21?var13.a():var13.b();
                     double var16 = var8.f();
                     var8 = new P(var14, var14, var16, !var21);
                  }
               }

               var10 = new v(this.d, var7, var8, (P)null, var6.d(), (y.f.y)null, 0);
               var2.add(0, var10);
               this.i.put(var6, var10);
            }

            var4 = var8;
            var3 = var6;
            --var5;
            if(var18 != 0) {
               break;
            }
         }

         return var2;
      }
   }

   private y.c.D a(List var1) {
      int var7 = ab.a;
      int var2 = 0;
      y.c.D var3 = new y.c.D();
      Iterator var4 = var1.iterator();

      y.c.D var10000;
      while(true) {
         if(var4.hasNext()) {
            v var5 = (v)var4.next();
            var5.a(var2);
            y.c.D var6 = var5.m();
            var10000 = var3;
            if(var7 != 0) {
               break;
            }

            var3.addAll(var6);
            var2 = var5.e();
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   private void b(List var1) {
      int var14 = ab.a;
      ai[] var2 = new ai[((g)var1.get(var1.size() - 1)).j() + 1];
      this.a = new R[var2.length - 1];
      this.b = new R[var2.length - 1];
      this.c = new R[var2.length - 1];
      y.f.y var3 = null;
      int var4 = -1;
      g var5 = null;
      M var6 = null;
      M var7 = null;
      ArrayList var8 = new ArrayList();
      Iterator var9 = var1.iterator();

      int var10000;
      while(true) {
         if(var9.hasNext()) {
            g var10 = (g)var9.next();
            var10000 = var4;
            if(var14 != 0) {
               break;
            }

            label100: {
               if(var4 != var10.j()) {
                  if(var5 != null) {
                     y.f.y var11 = var10.h();
                     ai var12 = new ai(var5.i(), var4, var5.h(), var5.c(), var6, var7, var8);
                     var8 = new ArrayList();
                     var2[var4] = var12;
                     if(var3 != null && var11.c() == var3) {
                        label114: {
                           if(y.f.y.c == var3 || y.f.y.b == var3) {
                              var12.a((byte)-1);
                              if(var14 == 0) {
                                 break label114;
                              }
                           }

                           var12.a((byte)1);
                        }
                     }

                     var3 = var5.h();
                  }

                  var5 = var10;
                  var7 = var10.b();
                  var6 = var10.a();
                  ++var4;
                  if(var14 == 0) {
                     break label100;
                  }
               }

               var6 = var10.a() == null?var6:(var6 == null?var10.a():M.b(var6, var10.a()));
               var7 = M.b(var7, var10.b());
            }

            var8.add(var10);
            if(var14 == 0) {
               continue;
            }
         }

         if(var5 != null) {
            var2[var2.length - 1] = new ai(var5.i(), var2.length - 1, var5.h(), var5.c(), var6, var7, var8);
         }

         var10000 = 0;
         break;
      }

      int var15 = var10000;

      while(true) {
         if(var15 < var2.length - 1) {
            ai var16 = var2[var15];
            ai var17 = var2[var15 + 1];
            R var18 = var17.b(0).l();
            this.a[var15] = var18;
            if(var14 != 0) {
               break;
            }

            g var13;
            if(var16.l() > 1) {
               label106: {
                  var13 = var16.b(var16.l() - 2);
                  if(var13.g()) {
                     this.c[var15] = var13.l();
                     if(var14 == 0) {
                        break label106;
                     }
                  }

                  this.b[var15] = var13.l();
               }
            }

            if(var17.l() > 1) {
               label107: {
                  var13 = var17.b(1);
                  if(var13.g()) {
                     this.c[var15] = var13.l();
                     if(var14 == 0) {
                        break label107;
                     }
                  }

                  this.b[var15] = var13.l();
               }
            }

            ++var15;
            if(var14 == 0) {
               continue;
            }
         }

         this.g = var2;
         break;
      }

   }

   public y.c.d c() {
      return this.d;
   }

   public List d() {
      return this.h;
   }

   public v a(f var1) {
      return (v)this.i.get(var1);
   }

   public ai a(int var1) {
      return var1 >= this.g.length?null:this.g[var1];
   }

   public ai a(ai var1) {
      return var1.j() > 0?this.a(var1.j() - 1):null;
   }

   public ai b(ai var1) {
      return this.a(var1.j() + 1);
   }

   public int e() {
      return this.g.length;
   }

   public String toString() {
      int var3 = ab.a;
      StringBuffer var1 = new StringBuffer();
      int var2 = 0;

      StringBuffer var10000;
      while(true) {
         if(var2 < this.g.length) {
            var10000 = var1.append(this.g[var2].h().toString());
            if(var3 != 0) {
               break;
            }

            ++var2;
            if(var3 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000.toString();
   }

   public void a(y.d.t var1) {
      this.j = var1;
      ai var2 = this.g[0];
      var2.a(true);
      if(var2.f()) {
         if(var2.g() && Math.abs(var2.e() - var1.a) > 1.0E-6D || !var2.g() && Math.abs(var2.e() - var1.b) > 1.0E-6D) {
            throw new IllegalArgumentException("Port location (" + var1.a() + ", " + var1.b() + ") contradict the fixed location " + var2.e() + " of the first segment");
         }
      } else {
         var2.a(var2.g()?var1.a:var1.b);
      }

   }

   public void b(y.d.t var1) {
      this.k = var1;
      ai var2 = this.g[this.e() - 1];
      var2.a(true);
      if(var2.f()) {
         if(var2.g() && Math.abs(var2.e() - var1.a) > 1.0E-6D || !var2.g() && Math.abs(var2.e() - var1.b) > 1.0E-6D) {
            throw new IllegalArgumentException("Port location (" + var1.a() + ", " + var1.b() + ") contradict the fixed location " + var2.e() + " of the first segment");
         }
      } else {
         var2.a(var2.g()?var1.a:var1.b);
      }

   }

   private y.d.t h() {
      if(this.j != null) {
         return this.j;
      } else {
         y.d.y var1 = this.e.a().s(this.d.c());
         ai var2 = this.g[0];
         return y.f.y.c == var2.h()?new y.d.t(var2.e(), var1.d() + var1.b()):(y.f.y.a == var2.h()?new y.d.t(var2.e(), var1.d()):(y.f.y.d == var2.h()?new y.d.t(var1.c(), var2.e()):new y.d.t(var1.c() + var1.a(), var2.e())));
      }
   }

   private y.d.t i() {
      if(this.k != null) {
         return this.k;
      } else {
         y.d.y var1 = this.e.a().s(this.d.d());
         ai var2 = this.g[this.g.length - 1];
         return y.f.y.c == var2.h()?new y.d.t(var2.e(), var1.d()):(y.f.y.a == var2.h()?new y.d.t(var2.e(), var1.d() + var1.b()):(y.f.y.d == var2.h()?new y.d.t(var1.c() + var1.a(), var2.e()):new y.d.t(var1.c(), var2.e())));
      }
   }

   public y.d.m[] f() {
      int var6 = ab.a;
      y.d.m[] var1 = new y.d.m[this.e()];
      y.d.t var2 = null;
      int var3 = 0;
      Iterator var4 = this.g().iterator();

      while(var4.hasNext()) {
         y.d.t var5 = (y.d.t)var4.next();
         if(var2 != null) {
            var1[var3++] = new y.d.m(var2, var5);
         }

         var2 = var5;
         if(var6 != 0) {
            break;
         }
      }

      return var1;
   }

   public y.c.D g() {
      y.c.D var1 = new y.c.D();
      var1.add(this.h());
      var1.a(this.j());
      var1.add(this.i());
      return var1;
   }

   private y.c.D j() {
      int var9 = ab.a;
      y.c.D var1 = new y.c.D();
      if(this.g.length <= 1) {
         return var1;
      } else if(!this.k()) {
         throw new RuntimeException("found segments without fixed locations!");
      } else {
         ai var2 = this.g[0];
         double var3 = var2.e();
         double var5 = var2.e();
         int var7 = 1;

         while(var7 < this.g.length) {
            label25: {
               ai var8 = this.g[var7];
               if(var8.g()) {
                  var3 = var8.e();
                  if(var9 == 0) {
                     break label25;
                  }
               }

               var5 = var8.e();
            }

            var1.add(new y.d.t(var3, var5));
            ++var7;
            if(var9 != 0) {
               break;
            }
         }

         return var1;
      }
   }

   private boolean k() {
      int var3 = ab.a;
      int var1 = 0;

      boolean var10000;
      while(true) {
         if(var1 < this.g.length) {
            ai var2 = this.g[var1];
            var10000 = var2.f();
            if(var3 != 0) {
               break;
            }

            if(!var10000) {
               return false;
            }

            ++var1;
            if(var3 == 0) {
               continue;
            }
         }

         var10000 = true;
         break;
      }

      return var10000;
   }

   void a(ai var1, ai var2) {
      int var8 = ab.a;
      boolean var3 = var1.j() < var2.j();
      int var4 = var3?var1.j():var2.j();
      ai[] var5 = new ai[this.g.length + 2];
      int var6 = 0;

      while(true) {
         if(var6 < var4) {
            var5[var6] = this.g[var6];
            ++var6;
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         var5[var4] = var3?var1:var2;
         break;
      }

      var5[var4 + 1] = var3?var2:var1;
      var6 = var4;

      while(true) {
         if(var6 < this.g.length) {
            ai var7 = this.g[var6];
            var7.a(var6 + 2);
            var5[var6 + 2] = var7;
            ++var6;
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         this.g = var5;
         break;
      }

   }
}
