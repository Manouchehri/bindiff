package y.f.b;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.d.u;
import y.d.v;
import y.f.I;
import y.f.X;
import y.f.aE;
import y.f.aF;
import y.f.ae;
import y.f.ah;
import y.f.am;
import y.f.ax;
import y.f.ay;
import y.f.b.a;
import y.f.b.c;
import y.f.b.f;
import y.f.b.h;
import y.f.b.k;
import y.f.b.l;
import y.f.b.m;
import y.f.b.n;
import y.f.b.o;
import y.f.b.p;
import y.g.M;

public class j extends y.f.a {
   public static final Object a = "y.layout.grouping.RecursiveGroupLayouter.GROUP_NODE_LAYOUTER_DPKEY";
   public static final ah b = new o((k)null);
   private X c;
   private A d;
   private y.c.h e;
   private A f;
   private boolean g;
   private y.c.c h;
   private boolean i;
   private boolean n;
   private a o;
   private y.c.c p;
   private y.c.c q;
   private y.c.c r;
   private A s;
   private Map t;
   private Map u;
   private Map v;
   private Map w;
   private y.c.c x;
   private y.c.c y;
   private y.c.c z;
   private y.c.c A;
   private y.c.h B;
   private y.c.h C;
   private y.c.h D;
   private y.c.h E;
   private A F;
   private A G;
   private A H;

   public j() {
      this((ah)null, new h());
   }

   public j(ah var1) {
      this(var1, new h());
   }

   public j(ah var1, a var2) {
      this.g = false;
      this.i = false;
      this.n = true;
      this.a((ah)var1);
      this.o = var2;
   }

   public boolean b() {
      return this.n;
   }

   public void a(boolean var1) {
      this.n = var1;
   }

   private boolean a(q var1) {
      return this.h != null?this.h.b(var1) != null:true;
   }

   private void a(q var1, c var2) {
      int var6 = c.a;
      y var3 = new y(var2.b(var1));

      while(!var3.isEmpty()) {
         q var4 = var3.d();
         if(this.b(var4, var2) && !this.a(var4)) {
            var3.addAll(var2.b(var4));
         }

         t var5 = (t)this.s.b(var4);
         if(var5 != null) {
            this.c.a(var4, var5);
            if(var6 != 0) {
               break;
            }
         }
      }

   }

   private boolean b(q var1, c var2) {
      return var2.d(var1) && (this.b() || var2.e(var1));
   }

   private void a(q var1, Object var2, A var3, c var4) {
      int var8 = c.a;
      y var5 = var4.b(var1);
      x var6 = var5.a();

      while(var6.f()) {
         q var7 = var6.e();
         var3.a(var7, var2);
         if(this.b(var7, var4)) {
            label18: {
               if(this.a(var7)) {
                  this.a(var7, var7, var3, var4);
                  if(var8 == 0) {
                     break label18;
                  }
               }

               this.a(var7, var2, var3, var4);
            }
         }

         var6.g();
         if(var8 != 0) {
            break;
         }
      }

   }

   private ah b(q var1) {
      if(this.h != null && var1 != null) {
         ah var2 = (ah)this.h.b(var1);
         return var2;
      } else {
         return this.a();
      }
   }

   private void c() {
      int var5 = c.a;
      this.B = this.c.u();
      this.C = this.c.u();
      this.D = this.c.u();
      this.E = this.c.u();
      y.c.e var1 = this.c.p();

      while(true) {
         if(var1.f()) {
            y.c.d var2 = var1.a();
            Collection var3 = p.a(this.c, var2, true);
            Object var6 = p.a(this.c, var2, var3, true);
            Collection var4 = p.a(this.c, var2, false);
            Object var7 = p.a(this.c, var2, var4, false);
            if(var5 != 0) {
               break;
            }

            if(var2.e()) {
               if(var6 == null || ((Collection)var6).isEmpty()) {
                  var6 = new ArrayList(1);
               }

               if(var7 == null || ((Collection)var7).isEmpty()) {
                  var7 = new ArrayList(1);
               }

               p.a(this.c, var2, (Collection)var6, (Collection)var7);
            }

            this.D.a(var2, var6);
            this.E.a(var2, var7);
            if(var6 != null) {
               this.B.a(var2, new D((Collection)var6));
            }

            if(var7 != null) {
               this.C.a(var2, new D((Collection)var7));
            }

            var1.g();
            if(var5 == 0) {
               continue;
            }
         }

         this.c.a((Object)ax.a, (y.c.c)this.D);
         this.c.a((Object)ax.b, (y.c.c)this.E);
         break;
      }

      if(this.x != null) {
         this.c.d_(aF.a);
      }

      if(this.y != null) {
         this.c.d_(aF.b);
      }

   }

   private void d() {
      int var1;
      label27: {
         var1 = c.a;
         if(this.z != null) {
            this.c.a((Object)ax.a, (y.c.c)this.z);
            if(var1 == 0) {
               break label27;
            }
         }

         this.c.d_(ax.a);
      }

      label22: {
         this.c.a((y.c.h)this.D);
         if(this.A != null) {
            this.c.a((Object)ax.b, (y.c.c)this.A);
            if(var1 == 0) {
               break label22;
            }
         }

         this.c.d_(ax.b);
      }

      this.c.a((y.c.h)this.E);
      if(this.x != null) {
         this.c.a((Object)aF.a, (y.c.c)this.x);
      }

      if(this.y != null) {
         this.c.a((Object)aF.b, (y.c.c)this.y);
      }

      this.c.a((y.c.h)this.B);
      this.c.a((y.c.h)this.C);
   }

   public void c(X var1) {
      int var12 = c.a;
      this.c = var1;
      if(c.b((y.c.i)var1)) {
         this.h = var1.c(a);
         if(this.h != null) {
            var1.d_(a);
         }

         this.f = var1.t();
         x var2 = var1.o();

         while(var2.f()) {
            this.f.a(var2.e(), new m());
            var2.g();
            if(var12 != 0) {
               return;
            }

            if(var12 != 0) {
               break;
            }
         }

         c var13 = new c(var1);
         this.k();
         this.d = var1.t();
         A var3 = var1.t();
         Object var4 = new Object();
         this.a(var13.b(), var4, var3, var13);
         l var5 = new l(this, var1, var13);
         this.s = var1.t();
         if(this.i) {
            this.e();
         }

         this.f();
         this.i();
         this.c();
         this.F = var1.t();
         this.G = var1.t();
         x var6 = var1.o();

         label102: {
            while(var6.f()) {
               q var7 = var6.e();
               this.F.a(var7, var7.a());
               this.G.a(var7, new n());
               var6.g();
               if(var12 != 0) {
                  break label102;
               }

               if(var12 != 0) {
                  break;
               }
            }

            this.H = var1.t();
         }

         y.c.c var15 = var1.c(ay.a);
         if(var15 == null) {
            var1.a((Object)ay.a, (y.c.c)this.H);
         }

         this.e = var1.u();
         y var16 = var13.c(var13.b());
         y.c.p var8 = var16.l();

         Object var10000;
         label91: {
            while(var8 != null) {
               q var9 = (q)var8.c();
               var10000 = this;
               if(var12 != 0) {
                  break label91;
               }

               if(this.b(var9, var13) && this.a(var9)) {
                  ah var10 = this.b(var9);
                  var5.a(var9);
                  if(var10 != null) {
                     this.b(var13);
                     if(this.i) {
                        this.a(var9, var13);
                     }

                     this.a(var13);
                     var10.c(var1);
                     this.g();
                  }

                  label83: {
                     if(this.o != null) {
                        Rectangle2D var11 = this.o.a(var1, var9, var13.b(var9));
                        var1.d(var9);
                        var1.b(var9, var11.getWidth(), var11.getHeight());
                        var1.c(var9, var11.getX(), var11.getY());
                        if(var12 == 0) {
                           break label83;
                        }
                     }

                     var1.d(var9);
                  }

                  if(var10 != null) {
                     am var19 = var1.a((Object)var9);
                     this.d.a(var9, new Double(var19.getX(), var19.getY()));
                     this.c(var13);
                  }
               }

               var8 = var8.b();
               if(var12 != 0) {
                  break;
               }
            }

            var10000 = this.b((q)null);
         }

         Object var17 = var10000;
         var5.a(var13.b());
         if(var17 != null) {
            this.b(var13);
            if(this.i) {
               this.a(var13.b(), var13);
            }

            this.a(var13);
            ((ah)var17).c(var1);
            this.g();
            this.c(var13);
         }

         var5.a();
         if(var17 != null) {
            this.a(var13, var13.b(), 0.0D, 0.0D);
         }

         var1.a((y.c.h)this.e);
         this.e = null;
         this.d();
         this.j();
         this.h();
         y.c.f var18 = this.a((y.c.c)var3);
         this.a(var1, var18);
         if(var15 == null) {
            var1.d_(ay.a);
         }

         if(this.h != null) {
            var1.a((Object)a, (y.c.c)this.h);
         }

         var1.a((A)this.s);
         var1.a((A)this.F);
         var1.a((A)this.G);
         var1.a((A)this.H);
         var1.a((A)var3);
         var1.a((A)this.f);
         var1.a((A)this.d);
         this.d = null;
         var13.c();
         if(var12 == 0) {
            return;
         }
      }

      ah var14 = this.a();
      if(var14 != null) {
         var14.c(var1);
      }

   }

   private y.c.f a(y.c.c var1) {
      int var5 = c.a;
      y.c.f var2 = new y.c.f();
      y.c.e var3 = this.c.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(var1.b(var4.c()) != var1.b(var4.d())) {
            var2.add(var4);
         }

         var3.g();
         if(var5 != 0) {
            break;
         }
      }

      return var2;
   }

   protected void a(X var1, y.c.f var2) {
      int var7 = c.a;
      y.c.e var3 = var2.a();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         am var5 = var1.a((Object)var4.c());
         am var6 = var1.a((Object)var4.d());
         if(!a(var5, var1.p(var4)) || !a(var6, var1.q(var4))) {
            ae.a(var1, var4);
         }

         var3.g();
         if(var7 != 0) {
            break;
         }
      }

   }

   private static boolean a(am var0, t var1) {
      return var0.getX() - 0.1D < var1.a && var0.getX() + var0.getWidth() + 0.1D > var1.a && var0.getY() - 0.1D < var1.b && var0.getY() + var0.getHeight() + 0.1D > var1.b;
   }

   private void a(c var1, q var2, double var3, double var5) {
      int var14 = c.a;
      y.c.p var7 = var1.b(var2).k();

      while(var7 != null) {
         q var8 = (q)var7.c();
         am var9 = this.c.a((Object)var8);
         var9.setLocation(var9.getX() + var3, var9.getY() + var5);
         y.c.e var10 = var8.j();

         label98:
         while(true) {
            boolean var10000 = var10.f();

            label95:
            while(true) {
               y.c.d var11;
               q var12;
               label70: {
                  if(var10000) {
                     var11 = var10.a();
                     var10000 = this.e.d(var11);
                     if(var14 != 0) {
                        break label70;
                     }

                     if(!var10000) {
                        var12 = var11.a(var8);
                        if(var1.a(var12) == var2 || var1.a(var12, var1.a(var8)) != null) {
                           this.a(var11, var3, var5);
                           this.e.a(var11, true);
                        }
                     }

                     var10.g();
                     if(var14 == 0) {
                        continue label98;
                     }
                  }

                  var10000 = this.b(var8, var1);
               }

               if(!var10000) {
                  break label98;
               }

               var10 = var1.f(var8).a();

               q var13;
               while(true) {
                  if(var10.f()) {
                     var11 = var10.a();
                     var10000 = this.e.d(var11);
                     if(var14 != 0) {
                        break;
                     }

                     if(!var10000) {
                        var12 = var11.c();
                        var13 = var11.d();
                        if(var1.a(var12, var1.a(var13)) == null && var1.a(var13, var1.a(var12)) == null) {
                           this.a(var11, var3, var5);
                           this.e.a(var11, true);
                        }
                     }

                     var10.g();
                     if(var14 == 0) {
                        continue;
                     }
                  }

                  var10 = var1.g(var8).a();
                  var10000 = var10.f();
                  break;
               }

               while(true) {
                  if(!var10000) {
                     break label95;
                  }

                  var11 = var10.a();
                  var10000 = this.e.d(var11);
                  if(var14 != 0) {
                     break;
                  }

                  if(!var10000) {
                     var12 = var11.c();
                     var13 = var11.d();
                     if(var1.a(var12, var1.a(var13)) == null && var1.a(var13, var1.a(var12)) == null) {
                        this.a(var11, var3, var5);
                        this.e.a(var11, true);
                     }
                  }

                  var10.g();
                  if(var14 != 0) {
                     break label95;
                  }

                  var10000 = var10.f();
               }
            }

            label53: {
               Double var15 = (Double)this.d.b(var8);
               if(var15 == null) {
                  this.a(var1, var8, var3, var5);
                  if(var14 == 0) {
                     break label53;
                  }
               }

               this.a(var1, var8, var9.getX() - var15.x, var9.getY() - var15.y);
            }

            this.d.a(var8, (Object)null);
            break;
         }

         var7 = var7.a();
         if(var14 != 0) {
            break;
         }
      }

   }

   private void a(y.c.d var1, double var2, double var4) {
      int var9 = c.a;
      I var6 = this.c.b(var1);
      int var7 = 0;

      while(var7 < var6.pointCount()) {
         t var8 = var6.getPoint(var7);
         var6.setPoint(var7, var8.a + var2, var8.b + var4);
         ++var7;
         if(var9 != 0) {
            break;
         }
      }

   }

   public void a(a var1) {
      this.o = var1;
   }

   private void e() {
      int var3 = c.a;
      x var1 = this.c.o();

      while(var1.f()) {
         q var2 = var1.e();
         this.s.a(var2, this.c.l(var2));
         var1.g();
         if(var3 != 0) {
            break;
         }
      }

   }

   private void f() {
      this.r = this.c.c(f.d);
      this.p = this.c.c(f.b);
      this.q = this.c.c(f.c);
      this.c.d_(f.d);
      this.c.d_(f.b);
      this.c.d_(f.c);
   }

   private void g() {
      if(this.c.c(f.d) != null) {
         this.c.d_(f.d);
         this.c.d_(f.b);
         this.c.d_(f.c);
      }

   }

   private void a(c var1) {
      int var9 = c.a;
      A var2 = M.a();
      A var3 = M.a();
      boolean var4 = false;
      x var5 = this.c.o();

      boolean var10000;
      while(true) {
         if(var5.f()) {
            q var6 = var5.e();
            var10000 = this.b(var6, var1);
            if(var9 != 0) {
               break;
            }

            label35: {
               if(var10000 && !this.a(var6)) {
                  var4 = true;
                  var2.a(var6, true);
                  x var7 = var1.b(var6).a();

                  while(var7.f()) {
                     q var8 = var7.e();
                     var3.a(var8, this.p.b(var6));
                     var7.g();
                     if(var9 != 0) {
                        break label35;
                     }

                     if(var9 != 0) {
                        break;
                     }
                  }
               }

               var5.g();
            }

            if(var9 == 0) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      if(var10000) {
         this.c.a((Object)f.d, (y.c.c)var2);
         this.c.a((Object)f.c, (y.c.c)var3);
         this.c.a((Object)f.b, (y.c.c)(new k(this)));
      }

   }

   private void h() {
      this.c.a((Object)f.d, (y.c.c)this.r);
      this.c.a((Object)f.b, (y.c.c)this.p);
      this.c.a((Object)f.c, (y.c.c)this.q);
   }

   private void i() {
      int var3 = c.a;
      y.c.e var1 = this.c.p();

      while(var1.f()) {
         y.c.d var2 = var1.a();
         if(this.x != null && this.a(var2, this.x)) {
            this.v.put(var2, this.c.n(var2));
         }

         if(this.y != null && this.a(var2, this.y)) {
            this.w.put(var2, this.c.o(var2));
         }

         var1.g();
         if(var3 != 0) {
            break;
         }
      }

   }

   private void j() {
      int var4 = c.a;
      y.c.e var2 = this.c.p();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         t var1 = (t)this.v.get(var3);
         if(var1 != null && this.c.n(var3).compareTo(var1) != 0) {
            this.c.a(var3, var1);
         }

         var1 = (t)this.w.get(var3);
         if(var1 != null && this.c.o(var3).compareTo(var1) != 0) {
            this.c.b(var3, var1);
         }

         var2.g();
         if(var4 != 0) {
            break;
         }
      }

   }

   private void k() {
      this.t = new HashMap();
      this.u = new HashMap();
      this.v = new HashMap();
      this.w = new HashMap();
      this.x = this.c.c(aF.a);
      this.y = this.c.c(aF.b);
      this.z = this.c.c(ax.a);
      this.A = this.c.c(ax.b);
   }

   private D a(ax var1, t var2, y.c.d var3, boolean var4) {
      D var5 = new D();
      if(var1.b()) {
         var5.add(ax.a(var1.c() + var2.a, var1.d() + var2.b, var1.a(), var1.f()));
         if(c.a == 0) {
            return var5;
         }
      }

      q var6 = var4?var3.c():var3.d();
      m var7 = (m)this.f.b(var6);
      if(var1.a((int)1)) {
         var5.addAll(this.a(var3, var4, var2, var1.f(), var7.a));
      }

      if(var1.a((int)2)) {
         var5.addAll(this.b(var3, var4, var2, var1.f(), var7.b));
      }

      if(var1.a((int)8)) {
         var5.addAll(this.c(var3, var4, var2, var1.f(), var7.c));
      }

      if(var1.a((int)4)) {
         var5.addAll(this.d(var3, var4, var2, var1.f(), var7.d));
      }

      return var5;
   }

   private D a(q var1, y.c.d var2, t var3) {
      int var8 = c.a;
      D var10000;
      D var4;
      D var5;
      C var6;
      ax var7;
      if(var2.d() == var1) {
         var4 = (D)this.C.b(var2);
         if(var4 != null && !var4.isEmpty()) {
            var5 = new D();
            var6 = var4.m();

            while(true) {
               if(var6.f()) {
                  var7 = (ax)var6.d();
                  var10000 = var5;
                  if(var8 != 0) {
                     break;
                  }

                  var5.a(this.a(var7, var3, var2, false));
                  var6.g();
                  if(var8 == 0) {
                     continue;
                  }
               }

               var10000 = var5;
               break;
            }

            return var10000;
         } else {
            return this.g?this.a(var2, false, var3, 1.0D):null;
         }
      } else if(var2.c() != var1) {
         return null;
      } else {
         var4 = (D)this.B.b(var2);
         if(var4 != null && !var4.isEmpty()) {
            var5 = new D();
            var6 = var4.m();

            while(true) {
               if(var6.f()) {
                  var7 = (ax)var6.d();
                  var10000 = var5;
                  if(var8 != 0) {
                     break;
                  }

                  var5.a(this.a(var7, var3, var2, true));
                  var6.g();
                  if(var8 == 0) {
                     continue;
                  }
               }

               var10000 = var5;
               break;
            }

            return var10000;
         } else {
            return this.g?this.a(var2, true, var3, 1.0D):null;
         }
      }
   }

   private static t a(t var0, t var1) {
      return new t(var0.a() - var1.a(), var0.b() - var1.b());
   }

   private void a(y.d.y var1, v var2, m var3) {
      int var14 = c.a;
      int var4 = 0;
      y.d.m var5 = var2.a(var4);

      while(var4 < var2.h() - 1 && var1.a(var5.c()) && var1.a(var5.d())) {
         ++var4;
         var5 = var2.a(var4);
         if(var14 != 0) {
            break;
         }
      }

      if(var5 != null) {
         t var6 = var5.c();
         t var7 = var1.e();
         t var8 = new t(var7.a() + var1.a() * 0.5D, var7.b() + var1.b() * 0.5D);
         if(var1.a(var6)) {
            y.d.m var9 = new y.d.m(var7, new t(var7.a + var1.a(), var7.b));
            t var10 = y.d.m.a(var5, var9);
            if(var10 != null) {
               var3.a.add(a(var10, var8));
               return;
            }

            y.d.m var11 = new y.d.m(new t(var7.a, var7.b + var1.b()), new t(var7.a + var1.a(), var7.b + var1.b()));
            var10 = y.d.m.a(var5, var11);
            if(var10 != null) {
               var3.b.add(a(var10, var8));
               return;
            }

            y.d.m var12 = new y.d.m(new t(var7.a, var7.b), new t(var7.a, var7.b + var1.b()));
            var10 = y.d.m.a(var5, var12);
            if(var10 != null) {
               var3.c.add(a(var10, var8));
               return;
            }

            y.d.m var13 = new y.d.m(new t(var7.a + var1.a(), var7.b), new t(var7.a + var1.a(), var7.b + var1.b()));
            var10 = y.d.m.a(var5, var13);
            if(var10 != null) {
               var3.d.add(a(var10, var8));
               return;
            }
         }

         if(var6.b() <= var7.b()) {
            var3.a.add(a(var6, var8));
            if(var14 == 0) {
               return;
            }
         }

         if(var6.b() >= var7.b() + var1.b()) {
            var3.b.add(a(var6, var8));
            if(var14 == 0) {
               return;
            }
         }

         if(var6.a() <= var7.a()) {
            var3.c.add(a(var6, var8));
            if(var14 == 0) {
               return;
            }
         }

         if(var6.a() >= var7.a() + var1.a()) {
            var3.d.add(a(var6, var8));
         }

      }
   }

   private void a(y.c.d var1, boolean var2, v var3) {
      q var4 = var2?var1.c():var1.d();
      m var5 = (m)this.f.b(var4);
      y.d.y var6 = this.c.s(var4);
      if(!var2) {
         var3 = var3.g();
      }

      this.a(var6, var3, var5);
   }

   private boolean a(double var1, double var3) {
      return var1 + 2.0D > var3 && var1 - 2.0D < var3;
   }

   private D a(y.c.d var1, boolean var2, t var3, double var4, D var6) {
      n var7;
      D var8;
      int var9;
      int var26;
      label82: {
         var26 = c.a;
         var7 = (n)(var2?this.G.b(var1.c()):this.G.b(var1.d()));
         var8 = new D();
         int var10;
         if(var2) {
            var10 = this.F.a(var1.c());
            var9 = var10 % 2 == 0?var10 + 1:var10;
            if(var26 == 0) {
               break label82;
            }
         }

         var10 = this.F.a(var1.d());
         var9 = var10 % 2 == 0?var10 + 1:var10;
      }

      y.d.q var27 = var2?this.c.r(var1.c()):this.c.r(var1.d());
      C var11 = var6.m();
      double var12 = var11.f()?((t)var11.d()).a():java.lang.Double.MAX_VALUE;
      double var14 = var27.b() / 2.0D;
      double var16 = var27.a() / 2.0D;
      double var18 = var27.a() / (double)(var9 + 1);
      int var20 = (var9 - 1) / 2;
      int var21 = 0;

      label71:
      do {
         int var10000 = var21;

         double var22;
         label68:
         while(true) {
            if(var10000 >= var9) {
               break label71;
            }

            var22 = -var16 + var18 * (double)(var21 + 1);

            while(true) {
               if(var22 <= var12 + 2.0D) {
                  break label68;
               }

               var11.g();
               var10000 = var11.f();
               if(var26 != 0) {
                  break;
               }

               var12 = var10000 != 0?((t)var11.d()).a():java.lang.Double.MAX_VALUE;
               if(var26 != 0) {
                  break label68;
               }
            }
         }

         double var24 = var4;
         if(var21 != var20) {
            var24 = var4 + 1.0D;
         }

         if(this.a(var22, var12)) {
            var24 += 10.0D;
         }

         var8.add(ax.a(var22 + var3.a, -var14 + var3.b, 1, var24));
         ++var21;
      } while(var26 == 0);

      if(var7 != null) {
         var7.a = var8;
      }

      return var8;
   }

   private D b(y.c.d var1, boolean var2, t var3, double var4, D var6) {
      n var7;
      D var8;
      int var9;
      int var26;
      label82: {
         var26 = c.a;
         var7 = (n)(var2?this.G.b(var1.c()):this.G.b(var1.d()));
         var8 = new D();
         int var10;
         if(var2) {
            var10 = this.F.a(var1.c());
            var9 = var10 % 2 == 0?var10 + 1:var10;
            if(var26 == 0) {
               break label82;
            }
         }

         var10 = this.F.a(var1.d());
         var9 = var10 % 2 == 0?var10 + 1:var10;
      }

      y.d.q var27 = var2?this.c.r(var1.c()):this.c.r(var1.d());
      C var11 = var6.m();
      double var12 = var11.f()?((t)var11.d()).a():java.lang.Double.MAX_VALUE;
      double var14 = var27.b() / 2.0D;
      double var16 = var27.a() / 2.0D;
      double var18 = var27.a() / (double)(var9 + 1);
      int var20 = (var9 - 1) / 2;
      int var21 = 0;

      label71:
      do {
         int var10000 = var21;

         double var22;
         label68:
         while(true) {
            if(var10000 >= var9) {
               break label71;
            }

            var22 = -var16 + var18 * (double)(var21 + 1);

            while(true) {
               if(var22 <= var12 + 2.0D) {
                  break label68;
               }

               var11.g();
               var10000 = var11.f();
               if(var26 != 0) {
                  break;
               }

               var12 = var10000 != 0?((t)var11.d()).a():java.lang.Double.MAX_VALUE;
               if(var26 != 0) {
                  break label68;
               }
            }
         }

         double var24 = var4;
         if(var21 != var20) {
            var24 = var4 + 1.0D;
         }

         if(this.a(var22, var12)) {
            var24 += 10.0D;
         }

         var8.add(ax.a(var22 + var3.a, var14 + var3.b, 2, var24));
         ++var21;
      } while(var26 == 0);

      if(var7 != null) {
         var7.b = var8;
      }

      return var8;
   }

   private D c(y.c.d var1, boolean var2, t var3, double var4, D var6) {
      n var7;
      D var8;
      int var9;
      int var26;
      label82: {
         var26 = c.a;
         var7 = (n)(var2?this.G.b(var1.c()):this.G.b(var1.d()));
         var8 = new D();
         int var10;
         if(var2) {
            var10 = this.F.a(var1.c());
            var9 = var10 % 2 == 0?var10 + 1:var10;
            if(var26 == 0) {
               break label82;
            }
         }

         var10 = this.F.a(var1.d());
         var9 = var10 % 2 == 0?var10 + 1:var10;
      }

      y.d.q var27 = var2?this.c.r(var1.c()):this.c.r(var1.d());
      C var11 = var6.m();
      double var12 = var11.f()?((t)var11.d()).b():java.lang.Double.MAX_VALUE;
      double var14 = var27.b() / 2.0D;
      double var16 = var27.a() / 2.0D;
      double var18 = var27.b() / (double)(var9 + 1);
      int var20 = (var9 - 1) / 2;
      int var21 = 0;

      label71:
      do {
         int var10000 = var21;

         double var22;
         label68:
         while(true) {
            if(var10000 >= var9) {
               break label71;
            }

            var22 = -var14 + var18 * (double)(var21 + 1);

            while(true) {
               if(var22 <= var12 + 2.0D) {
                  break label68;
               }

               var11.g();
               var10000 = var11.f();
               if(var26 != 0) {
                  break;
               }

               var12 = var10000 != 0?((t)var11.d()).b():java.lang.Double.MAX_VALUE;
               if(var26 != 0) {
                  break label68;
               }
            }
         }

         double var24 = var4;
         if(var21 != var20) {
            var24 = var4 + 1.0D;
         }

         if(this.a(var22, var12)) {
            var24 += 10.0D;
         }

         var8.add(ax.a(-var16 + var3.a, var22 + var3.b, 8, var24));
         ++var21;
      } while(var26 == 0);

      if(var7 != null) {
         var7.c = var8;
      }

      return var8;
   }

   private D d(y.c.d var1, boolean var2, t var3, double var4, D var6) {
      n var7;
      D var8;
      int var9;
      int var26;
      label82: {
         var26 = c.a;
         var7 = (n)(var2?this.G.b(var1.c()):this.G.b(var1.d()));
         var8 = new D();
         int var10;
         if(var2) {
            var10 = this.F.a(var1.c());
            var9 = var10 % 2 == 0?var10 + 1:var10;
            if(var26 == 0) {
               break label82;
            }
         }

         var10 = this.F.a(var1.d());
         var9 = var10 % 2 == 0?var10 + 1:var10;
      }

      y.d.q var27 = var2?this.c.r(var1.c()):this.c.r(var1.d());
      C var11 = var6.m();
      double var12 = var11.f()?((t)var11.d()).b():java.lang.Double.MAX_VALUE;
      double var14 = var27.b() / 2.0D;
      double var16 = var27.a() / 2.0D;
      double var18 = var27.b() / (double)(var9 + 1);
      int var20 = (var9 - 1) / 2;
      int var21 = 0;

      do {
         int var10000 = var21;

         double var22;
         label68:
         while(true) {
            if(var10000 >= var9) {
               return var7 != null?(var7.d = var8):var8;
            }

            var22 = -var14 + var18 * (double)(var21 + 1);

            while(true) {
               if(var22 <= var12 + 2.0D) {
                  break label68;
               }

               var11.g();
               var10000 = var11.f();
               if(var26 != 0) {
                  break;
               }

               var12 = var10000 != 0?((t)var11.d()).b():java.lang.Double.MAX_VALUE;
               if(var26 != 0) {
                  break label68;
               }
            }
         }

         double var24 = var4;
         if(var21 != var20) {
            var24 = var4 + 1.0D;
         }

         if(this.a(var22, var12)) {
            var24 += 10.0D;
         }

         var8.add(ax.a(var16 + var3.a, var22 + var3.b, 4, var24));
         ++var21;
      } while(var26 == 0);

      return var7 != null?(var7.d = var8):var8;
   }

   private D a(y.c.d var1, boolean var2, t var3, double var4) {
      q var6 = var2?var1.c():var1.d();
      m var7 = (m)this.f.b(var6);
      this.a(var1, var2, var3, var4, var7.a);
      this.b(var1, var2, var3, var4, var7.b);
      this.c(var1, var2, var3, var4, var7.c);
      this.d(var1, var2, var3, var4, var7.d);
      n var8 = (n)(var2?this.G.b(var1.c()):this.G.b(var1.d()));
      return var8 != null?var8.a():null;
   }

   private ay a(q var1, int var2) {
      int var15 = c.a;
      ay var3 = new ay();
      if(var2 == 0) {
         return var3;
      } else {
         y.d.q var4 = this.c.r(var1);
         int var5 = var2 % 2 == 0?var2 + 1:var2;
         double var6 = var4.b() / 2.0D;
         double var8 = var4.a() / 2.0D;
         double var10 = var4.a() / (double)(var5 + 1);
         int var12 = 0;

         double var13;
         while(true) {
            if(var12 < var5) {
               var13 = -var8 + var10 * (double)(var12 + 1);
               var3.a(ax.a(var13, -var6, 1));
               var3.a(ax.a(var13, var6, 2));
               ++var12;
               if(var15 != 0) {
                  break;
               }

               if(var15 == 0) {
                  continue;
               }
            }

            var10 = var4.b() / (double)(var5 + 1);
            break;
         }

         var12 = 0;

         ay var10000;
         while(true) {
            if(var12 < var5) {
               var13 = -var6 + var10 * (double)(var12 + 1);
               var3.a(ax.a(-var8, var13, 8));
               var10000 = var3;
               if(var15 != 0) {
                  break;
               }

               var3.a(ax.a(var8, var13, 4));
               ++var12;
               if(var15 == 0) {
                  continue;
               }
            }

            var10000 = var3;
            break;
         }

         return var10000;
      }
   }

   private void b(c var1) {
      int var15 = c.a;
      x var2 = this.c.o();

      while(var2.f()) {
         label552: {
            q var3 = var2.e();
            D var4 = new D();
            if(this.b(var3, var1) && this.a(var3)) {
               t var5 = this.c.l(var3);
               int var6 = 0;
               y.c.e var7 = var1.f(var3).a();

               label547:
               while(true) {
                  y.c.d var8;
                  t var9;
                  t var10;
                  t var11;
                  t var12;
                  D var13;
                  D var14;
                  q var10000;
                  q var18;
                  t var19;
                  if(var7.f()) {
                     var8 = var7.a();
                     var10000 = var8.d();
                     if(var15 == 0) {
                        if(var10000 != var3) {
                           var9 = this.c.l(var8.d());
                           var10 = new t(var9.a - var5.a, var9.b - var5.b);
                           if(var8.c().e() != null) {
                              this.u.put(var8, var8.d());
                              var11 = this.c.q(var8);
                              var12 = this.a(var1, var8.d(), var3);
                              var13 = this.a(var8.d(), var8, t.b(var12, var10));
                              if(var13 != null) {
                                 this.E.a(var8, var13);
                                 var4.addAll(var13);
                                 if(var15 != 0) {
                                    ++var6;
                                 }
                              } else {
                                 ++var6;
                              }

                              this.a(var8, var8.c(), var3);
                              this.c.d(var8, new t(var11.a + var12.a, var11.b + var12.b));
                              if(var8.a() == null) {
                                 this.c.e(var8);
                                 if(var15 != 0) {
                                    var18 = var1.a(var8.c(), var1.a(var3));
                                    if(var18 != null && var18.e() != null) {
                                       this.u.put(var8, var8.d());
                                       var12 = this.c.q(var8);
                                       var19 = this.a(var1, var8.d(), var3);
                                       var14 = this.a(var8.d(), var8, t.b(var19, var10));
                                       if(var14 != null) {
                                          this.E.a(var8, var14);
                                          var4.addAll(var14);
                                          if(var15 != 0) {
                                             ++var6;
                                          }
                                       } else {
                                          ++var6;
                                       }

                                       this.a(var8, var8.c(), var3);
                                       this.c.d(var8, new t(var12.a + var19.a, var12.b + var19.b));
                                    }

                                    var7.g();
                                    if(var15 == 0) {
                                       continue;
                                    }

                                    var7 = var1.g(var3).a();
                                    if(!var7.f()) {
                                       break;
                                    }
                                 } else {
                                    var7.g();
                                    if(var15 == 0) {
                                       continue;
                                    }

                                    var7 = var1.g(var3).a();
                                    if(!var7.f()) {
                                       break;
                                    }
                                 }
                              } else {
                                 var7.g();
                                 if(var15 == 0) {
                                    continue;
                                 }

                                 var7 = var1.g(var3).a();
                                 if(!var7.f()) {
                                    break;
                                 }
                              }
                           } else {
                              var18 = var1.a(var8.c(), var1.a(var3));
                              if(var18 != null && var18.e() != null) {
                                 this.u.put(var8, var8.d());
                                 var12 = this.c.q(var8);
                                 var19 = this.a(var1, var8.d(), var3);
                                 var14 = this.a(var8.d(), var8, t.b(var19, var10));
                                 if(var14 != null) {
                                    this.E.a(var8, var14);
                                    var4.addAll(var14);
                                    if(var15 != 0) {
                                       ++var6;
                                    }
                                 } else {
                                    ++var6;
                                 }

                                 this.a(var8, var8.c(), var3);
                                 this.c.d(var8, new t(var12.a + var19.a, var12.b + var19.b));
                              }

                              var7.g();
                              if(var15 == 0) {
                                 continue;
                              }

                              var7 = var1.g(var3).a();
                              if(!var7.f()) {
                                 break;
                              }
                           }
                        } else {
                           var7.g();
                           if(var15 == 0) {
                              continue;
                           }

                           var7 = var1.g(var3).a();
                           if(!var7.f()) {
                              break;
                           }
                        }
                     } else if(var10000 != var3) {
                        var9 = this.c.l(var8.c());
                        var10 = new t(var9.a - var5.a, var9.b - var5.b);
                        if(var8.d().e() != null) {
                           this.t.put(var8, var8.c());
                           var11 = this.c.p(var8);
                           var12 = this.a(var1, var8.c(), var3);
                           var13 = this.a(var8.c(), var8, t.b(var12, var10));
                           if(var13 != null) {
                              this.D.a(var8, var13);
                              var4.addAll(var13);
                              if(var15 != 0) {
                                 ++var6;
                              }
                           } else {
                              ++var6;
                           }

                           this.a(var8, var3, var8.d());
                           this.c.c(var8, new t(var11.a + var12.a, var11.b + var12.b));
                           if(var8.a() == null) {
                              this.c.e(var8);
                              if(var15 != 0) {
                                 var18 = var1.a(var8.d(), var1.a(var3));
                                 if(var18 != null && var18.e() != null) {
                                    this.t.put(var8, var8.c());
                                    var12 = this.c.p(var8);
                                    var19 = this.a(var1, var8.c(), var3);
                                    var14 = this.a(var8.c(), var8, t.b(var19, var10));
                                    if(var14 != null) {
                                       this.D.a(var8, var14);
                                       var4.addAll(var14);
                                       if(var15 != 0) {
                                          ++var6;
                                       }
                                    } else {
                                       ++var6;
                                    }

                                    this.a(var8, var3, var8.d());
                                    this.c.c(var8, new t(var12.a + var19.a, var12.b + var19.b));
                                 }

                                 var7.g();
                                 if(var15 != 0 || !var7.f()) {
                                    break;
                                 }
                              } else {
                                 var7.g();
                                 if(var15 != 0 || !var7.f()) {
                                    break;
                                 }
                              }
                           } else {
                              var7.g();
                              if(var15 != 0 || !var7.f()) {
                                 break;
                              }
                           }
                        } else {
                           var18 = var1.a(var8.d(), var1.a(var3));
                           if(var18 != null && var18.e() != null) {
                              this.t.put(var8, var8.c());
                              var12 = this.c.p(var8);
                              var19 = this.a(var1, var8.c(), var3);
                              var14 = this.a(var8.c(), var8, t.b(var19, var10));
                              if(var14 != null) {
                                 this.D.a(var8, var14);
                                 var4.addAll(var14);
                                 if(var15 != 0) {
                                    ++var6;
                                 }
                              } else {
                                 ++var6;
                              }

                              this.a(var8, var3, var8.d());
                              this.c.c(var8, new t(var12.a + var19.a, var12.b + var19.b));
                           }

                           var7.g();
                           if(var15 != 0 || !var7.f()) {
                              break;
                           }
                        }
                     } else {
                        var7.g();
                        if(var15 != 0 || !var7.f()) {
                           break;
                        }
                     }
                  } else {
                     var7 = var1.g(var3).a();
                     if(!var7.f()) {
                        break;
                     }
                  }

                  while(true) {
                     while(true) {
                        var8 = var7.a();
                        var10000 = var8.c();
                        if(var15 == 0) {
                           if(var10000 != var3) {
                              var9 = this.c.l(var8.c());
                              var10 = new t(var9.a - var5.a, var9.b - var5.b);
                              if(var8.d().e() != null) {
                                 this.t.put(var8, var8.c());
                                 var11 = this.c.p(var8);
                                 var12 = this.a(var1, var8.c(), var3);
                                 var13 = this.a(var8.c(), var8, t.b(var12, var10));
                                 if(var13 != null) {
                                    this.D.a(var8, var13);
                                    var4.addAll(var13);
                                    if(var15 != 0) {
                                       ++var6;
                                    }
                                 } else {
                                    ++var6;
                                 }

                                 this.a(var8, var3, var8.d());
                                 this.c.c(var8, new t(var11.a + var12.a, var11.b + var12.b));
                                 if(var8.a() == null) {
                                    this.c.e(var8);
                                    if(var15 != 0) {
                                       var18 = var1.a(var8.d(), var1.a(var3));
                                       if(var18 != null && var18.e() != null) {
                                          this.t.put(var8, var8.c());
                                          var12 = this.c.p(var8);
                                          var19 = this.a(var1, var8.c(), var3);
                                          var14 = this.a(var8.c(), var8, t.b(var19, var10));
                                          if(var14 != null) {
                                             this.D.a(var8, var14);
                                             var4.addAll(var14);
                                             if(var15 != 0) {
                                                ++var6;
                                             }
                                          } else {
                                             ++var6;
                                          }

                                          this.a(var8, var3, var8.d());
                                          this.c.c(var8, new t(var12.a + var19.a, var12.b + var19.b));
                                       }

                                       var7.g();
                                       if(var15 != 0 || !var7.f()) {
                                          break label547;
                                       }
                                    } else {
                                       var7.g();
                                       if(var15 != 0 || !var7.f()) {
                                          break label547;
                                       }
                                    }
                                 } else {
                                    var7.g();
                                    if(var15 != 0 || !var7.f()) {
                                       break label547;
                                    }
                                 }
                              } else {
                                 var18 = var1.a(var8.d(), var1.a(var3));
                                 if(var18 != null && var18.e() != null) {
                                    this.t.put(var8, var8.c());
                                    var12 = this.c.p(var8);
                                    var19 = this.a(var1, var8.c(), var3);
                                    var14 = this.a(var8.c(), var8, t.b(var19, var10));
                                    if(var14 != null) {
                                       this.D.a(var8, var14);
                                       var4.addAll(var14);
                                       if(var15 != 0) {
                                          ++var6;
                                       }
                                    } else {
                                       ++var6;
                                    }

                                    this.a(var8, var3, var8.d());
                                    this.c.c(var8, new t(var12.a + var19.a, var12.b + var19.b));
                                 }

                                 var7.g();
                                 if(var15 != 0 || !var7.f()) {
                                    break label547;
                                 }
                              }
                           } else {
                              var7.g();
                              if(var15 != 0 || !var7.f()) {
                                 break label547;
                              }
                           }
                        } else if(var15 == 0) {
                           if(var10000 != var3) {
                              var9 = this.c.l(var8.d());
                              var10 = new t(var9.a - var5.a, var9.b - var5.b);
                              if(var8.c().e() != null) {
                                 this.u.put(var8, var8.d());
                                 var11 = this.c.q(var8);
                                 var12 = this.a(var1, var8.d(), var3);
                                 var13 = this.a(var8.d(), var8, t.b(var12, var10));
                                 if(var13 != null) {
                                    this.E.a(var8, var13);
                                    var4.addAll(var13);
                                    if(var15 != 0) {
                                       ++var6;
                                    }
                                 } else {
                                    ++var6;
                                 }

                                 this.a(var8, var8.c(), var3);
                                 this.c.d(var8, new t(var11.a + var12.a, var11.b + var12.b));
                                 if(var8.a() == null) {
                                    this.c.e(var8);
                                    if(var15 != 0) {
                                       var18 = var1.a(var8.c(), var1.a(var3));
                                       if(var18 != null && var18.e() != null) {
                                          this.u.put(var8, var8.d());
                                          var12 = this.c.q(var8);
                                          var19 = this.a(var1, var8.d(), var3);
                                          var14 = this.a(var8.d(), var8, t.b(var19, var10));
                                          if(var14 != null) {
                                             this.E.a(var8, var14);
                                             var4.addAll(var14);
                                             if(var15 != 0) {
                                                ++var6;
                                             }
                                          } else {
                                             ++var6;
                                          }

                                          this.a(var8, var8.c(), var3);
                                          this.c.d(var8, new t(var12.a + var19.a, var12.b + var19.b));
                                       }

                                       var7.g();
                                       if(var15 == 0) {
                                          continue label547;
                                       }

                                       var7 = var1.g(var3).a();
                                       if(!var7.f()) {
                                          break label547;
                                       }
                                    } else {
                                       var7.g();
                                       if(var15 == 0) {
                                          continue label547;
                                       }

                                       var7 = var1.g(var3).a();
                                       if(!var7.f()) {
                                          break label547;
                                       }
                                    }
                                 } else {
                                    var7.g();
                                    if(var15 == 0) {
                                       continue label547;
                                    }

                                    var7 = var1.g(var3).a();
                                    if(!var7.f()) {
                                       break label547;
                                    }
                                 }
                              } else {
                                 var18 = var1.a(var8.c(), var1.a(var3));
                                 if(var18 != null && var18.e() != null) {
                                    this.u.put(var8, var8.d());
                                    var12 = this.c.q(var8);
                                    var19 = this.a(var1, var8.d(), var3);
                                    var14 = this.a(var8.d(), var8, t.b(var19, var10));
                                    if(var14 != null) {
                                       this.E.a(var8, var14);
                                       var4.addAll(var14);
                                       if(var15 != 0) {
                                          ++var6;
                                       }
                                    } else {
                                       ++var6;
                                    }

                                    this.a(var8, var8.c(), var3);
                                    this.c.d(var8, new t(var12.a + var19.a, var12.b + var19.b));
                                 }

                                 var7.g();
                                 if(var15 == 0) {
                                    continue label547;
                                 }

                                 var7 = var1.g(var3).a();
                                 if(!var7.f()) {
                                    break label547;
                                 }
                              }
                           } else {
                              var7.g();
                              if(var15 == 0) {
                                 continue label547;
                              }

                              var7 = var1.g(var3).a();
                              if(!var7.f()) {
                                 break label547;
                              }
                           }
                        } else if(var10000 != var3) {
                           var9 = this.c.l(var8.c());
                           var10 = new t(var9.a - var5.a, var9.b - var5.b);
                           if(var8.d().e() != null) {
                              this.t.put(var8, var8.c());
                              var11 = this.c.p(var8);
                              var12 = this.a(var1, var8.c(), var3);
                              var13 = this.a(var8.c(), var8, t.b(var12, var10));
                              if(var13 != null) {
                                 this.D.a(var8, var13);
                                 var4.addAll(var13);
                                 if(var15 != 0) {
                                    ++var6;
                                 }
                              } else {
                                 ++var6;
                              }

                              this.a(var8, var3, var8.d());
                              this.c.c(var8, new t(var11.a + var12.a, var11.b + var12.b));
                              if(var8.a() == null) {
                                 this.c.e(var8);
                                 if(var15 != 0) {
                                    var18 = var1.a(var8.d(), var1.a(var3));
                                    if(var18 != null && var18.e() != null) {
                                       this.t.put(var8, var8.c());
                                       var12 = this.c.p(var8);
                                       var19 = this.a(var1, var8.c(), var3);
                                       var14 = this.a(var8.c(), var8, t.b(var19, var10));
                                       if(var14 != null) {
                                          this.D.a(var8, var14);
                                          var4.addAll(var14);
                                          if(var15 != 0) {
                                             ++var6;
                                          }
                                       } else {
                                          ++var6;
                                       }

                                       this.a(var8, var3, var8.d());
                                       this.c.c(var8, new t(var12.a + var19.a, var12.b + var19.b));
                                    }

                                    var7.g();
                                    if(var15 != 0 || !var7.f()) {
                                       break label547;
                                    }
                                 } else {
                                    var7.g();
                                    if(var15 != 0 || !var7.f()) {
                                       break label547;
                                    }
                                 }
                              } else {
                                 var7.g();
                                 if(var15 != 0 || !var7.f()) {
                                    break label547;
                                 }
                              }
                           } else {
                              var18 = var1.a(var8.d(), var1.a(var3));
                              if(var18 != null && var18.e() != null) {
                                 this.t.put(var8, var8.c());
                                 var12 = this.c.p(var8);
                                 var19 = this.a(var1, var8.c(), var3);
                                 var14 = this.a(var8.c(), var8, t.b(var19, var10));
                                 if(var14 != null) {
                                    this.D.a(var8, var14);
                                    var4.addAll(var14);
                                    if(var15 != 0) {
                                       ++var6;
                                    }
                                 } else {
                                    ++var6;
                                 }

                                 this.a(var8, var3, var8.d());
                                 this.c.c(var8, new t(var12.a + var19.a, var12.b + var19.b));
                              }

                              var7.g();
                              if(var15 != 0 || !var7.f()) {
                                 break label547;
                              }
                           }
                        } else {
                           var7.g();
                           if(var15 != 0 || !var7.f()) {
                              break label547;
                           }
                        }
                     }
                  }
               }

               if(!var4.isEmpty()) {
                  ay var17 = this.a(var3, var6);
                  C var16 = var4.m();

                  while(var16.f()) {
                     var17.a((ax)var16.d());
                     var16.g();
                     if(var15 != 0) {
                        break label552;
                     }

                     if(var15 != 0) {
                        break;
                     }
                  }

                  this.H.a(var3, var17);
               }
            }

            var2.g();
         }

         if(var15 != 0) {
            break;
         }
      }

   }

   private void a(y.c.d var1, q var2, q var3) {
      boolean var4 = false;
      q var5 = var1.c();
      if(var5.e() == null) {
         this.c.d(var5);
         var4 = true;
      }

      boolean var6 = false;
      q var7 = var1.d();
      if(var7.e() == null) {
         this.c.d(var7);
         var6 = true;
      }

      boolean var8 = false;
      if(var1.a() == null) {
         this.c.e(var1);
         var8 = true;
      }

      this.c.a(var1, var2, var3);
      if(var8) {
         this.c.d(var1);
      }

      if(var4) {
         this.c.c(var5);
      }

      if(var6) {
         this.c.c(var7);
      }

   }

   private static v a(v var0, t var1) {
      int var6 = c.a;
      if(var1 == null) {
         var1 = new t(0.0D, 0.0D);
      }

      t[] var2 = new t[var0.h()];
      int var3 = 0;
      u var4 = var0.b();

      while(var4.f()) {
         t var5 = var4.a();
         var2[var3++] = new t(var5.a - var1.a, var5.b - var1.b);
         var4.g();
         if(var6 != 0) {
            break;
         }
      }

      return new v(var2);
   }

   private void c(c var1) {
      int var9 = c.a;
      y.c.f var2 = new y.c.f(this.c.p());
      y.c.e var3 = var2.a();

      while(true) {
         q var10000;
         y.c.d var4;
         q var5;
         t var6;
         t var7;
         v var8;
         if(var3.f()) {
            var4 = var3.a();
            var5 = (q)this.t.get(var4);
            var10000 = var5;
            if(var9 == 0) {
               label34: {
                  if(var5 != null) {
                     var6 = this.c.p(var4);
                     var7 = this.a(var1, var5, var1.a(var4.c()));
                     var8 = a(this.c.l(var4), var7);
                     this.a(var4, var5, var4.d());
                     this.c.c(var4, new t(var6.a - var7.a, var6.b - var7.b));
                     this.a(var4, true, var8);
                     if(var4.a() == null) {
                        break label34;
                     }

                     this.c.d(var4);
                     if(var9 == 0) {
                        break label34;
                     }
                  }

                  this.a(var4, true, a((v)this.c.l(var4), (t)null));
               }

               var3.g();
               if(var9 == 0) {
                  continue;
               }

               var3 = var2.a();
               if(!var3.f()) {
                  break;
               }

               var4 = var3.a();
               var5 = (q)this.u.get(var4);
               var10000 = var5;
            }
         } else {
            var3 = var2.a();
            if(!var3.f()) {
               break;
            }

            var4 = var3.a();
            var5 = (q)this.u.get(var4);
            var10000 = var5;
         }

         while(true) {
            if(var10000 != null) {
               var6 = this.c.q(var4);
               var7 = this.a(var1, var5, var1.a(var4.d()));
               var8 = a(this.c.l(var4), var7);
               this.a(var4, var4.c(), var5);
               this.c.d(var4, new t(var6.a - var7.a, var6.b - var7.b));
               this.a(var4, false, var8);
               if(var4.a() != null) {
                  this.c.d(var4);
                  if(var9 != 0) {
                     this.a(var4, false, a((v)this.c.l(var4), (t)null));
                     var3.g();
                     if(var9 != 0) {
                        return;
                     }
                  } else {
                     var3.g();
                     if(var9 != 0) {
                        return;
                     }
                  }
               } else {
                  var3.g();
                  if(var9 != 0) {
                     return;
                  }
               }
            } else {
               this.a(var4, false, a((v)this.c.l(var4), (t)null));
               var3.g();
               if(var9 != 0) {
                  return;
               }
            }

            if(!var3.f()) {
               return;
            }

            var4 = var3.a();
            var5 = (q)this.u.get(var4);
            var10000 = var5;
         }
      }

   }

   private boolean a(y.c.d var1, y.c.c var2) {
      aE var3 = (aE)var2.b(var1);
      return var3 != null?var3.a():false;
   }

   private t c(q var1) {
      t var2 = null;
      am var3 = this.c.a((Object)var1);
      if(this.d != null) {
         Double var4 = (Double)this.d.b(var1);
         if(var4 != null) {
            var2 = new t(var3.getX() - var4.x, var3.getY() - var4.y);
         }
      }

      return var2 != null?var2:new t();
   }

   private t a(c var1, q var2, q var3) {
      int var6 = c.a;
      t var4 = new t();
      if(this.d != null) {
         q var5 = var1.a(var2);

         while(var5 != null && var5 != var3) {
            var4 = t.b(var4, this.c(var5));
            var5 = var1.a(var5);
            if(var6 != 0) {
               break;
            }
         }
      }

      return var4;
   }

   static boolean a(j var0, q var1) {
      return var0.a(var1);
   }

   static boolean a(j var0, q var1, c var2) {
      return var0.b(var1, var2);
   }

   static y.c.c a(j var0) {
      return var0.p;
   }
}
