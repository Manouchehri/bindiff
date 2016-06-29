package y.f.c;

import java.util.Map;
import y.f.c.K;
import y.f.c.a;
import y.f.c.am;
import y.f.c.ap;
import y.f.c.az;
import y.f.c.v;
import y.f.c.y;
import y.f.c.z;

class x {
   private static y a = new y(0.0D, 0.0D, 0.0D, 0.0D);
   private y.f.X b;
   private y.c.A c;
   private y.c.A d;
   private y.c.h e;
   private y.c.A f;
   private y.c.c g;
   private y.c.h h;
   private y.c.c i;
   private boolean j = true;
   private boolean k;
   private boolean l;
   private y.c.D m;
   private boolean n = false;
   private double o = 20.0D;
   private double p = 0.5D;
   private ap q;
   private am r;
   private az s;
   private y.c.A t;
   private y.c.A u;
   private y.c.A v;
   private y.c.A w;
   private y.c.A x;
   private y.c.c y;
   private y.c.c z;
   private y.c.h A;
   private y.c.h B;
   private Map C;
   private y.c.h D;
   private y.c.h E;
   private y.c.A F;
   private y.c.A G;
   private y.c.h H;
   private y.c.h I;
   private y.c.D J;
   private boolean K = false;
   private boolean L = true;
   private static final y.f.aE M = y.f.aE.a((byte)2);
   private static final y.f.aE N = y.f.aE.a((byte)1);
   private double O;
   private double P;

   public x(y.f.X var1, y.c.A var2, y.c.A var3, y.c.h var4, y.c.D var5) {
      this.b = var1;
      this.J = var5;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.F = K.a((y.c.i)var1);
      this.k = var1.c(y.f.aF.a) != null || var1.c(y.f.aF.b) != null;
      this.l = var1.c(y.f.aF.c) != null || var1.c(y.f.aF.d) != null;
      if(this.k || this.l) {
         this.g();
      }

      if(this.l) {
         this.D = var1.u();
         this.E = var1.u();
         this.s = new az(var1, var2, var5, var3, this.D, this.E, this.A, this.B);
      }

      this.q = new ap(var1, this.F, var2, var5, var3, var4, this.A, this.B);
      this.q.a(this.L);
      this.r = new am(var1, this);
   }

   public void a(boolean var1) {
      this.K = var1;
   }

   public void b(boolean var1) {
      this.L = var1;
      this.q.a(var1);
   }

   public void a(y.c.A var1, y.c.c var2, y.c.h var3, y.c.c var4) {
      this.f = var1;
      this.h = var3;
      this.g = var2;
      this.i = var4;
      if(this.s != null) {
         this.s.a(var1, var2, var3, var4);
      }

      if(this.q != null) {
         this.q.a(var1, var2, var3, var4);
      }

   }

   public void a(double var1) {
      this.o = var1;
      this.q.a(var1);
      this.r.a(var1);
   }

   public double a() {
      return this.o;
   }

   public void c(boolean var1) {
      this.n = var1;
   }

   public void b() {
      label39: {
         boolean var5 = a.i;
         if(this.k) {
            y.c.e var1 = this.b.p();

            do {
               if(!var1.f()) {
                  break label39;
               }

               y.c.d var2 = var1.a();
               y.f.aE var3 = this.a(var2);
               if(var5) {
                  return;
               }

               if(var3 == null || !var3.a()) {
                  this.b.a(var2, y.d.t.c);
               }

               y.f.aE var4 = this.b(var2);
               if(var4 == null || !var4.a()) {
                  this.b.b(var2, y.d.t.c);
               }

               var1.g();
            } while(!var5);
         }

         y.f.ae.c(this.b);
      }

      this.r.a();
   }

   public int a(int var1, y.c.f var2) {
      x var10000;
      label27: {
         boolean var6 = a.i;
         if(this.k) {
            y.c.p var3 = var2.k();

            while(var3 != null) {
               y.c.d var4 = (y.c.d)var3.c();
               y.d.t var5 = this.b.n(var4);
               this.b.a(var4, this.b.o(var4));
               this.b.b(var4, var5);
               var10000 = this;
               if(var6) {
                  break label27;
               }

               if(this.A != null && this.B != null) {
                  this.A.a(var4, this.z.b(var4));
                  this.B.a(var4, this.y.b(var4));
               }

               var3 = var3.a();
               if(var6) {
                  break;
               }
            }
         }

         var10000 = this;
      }

      var10000.q.b();
      return var1;
   }

   public int a(int var1) {
      if(this.s != null) {
         var1 = this.d(var1);
      }

      return var1;
   }

   public int b(int var1) {
      this.i();
      return var1;
   }

   public int c(int var1) {
      var1 = this.q.a(var1);
      return var1;
   }

   public y.c.y[] a(y.c.y[] var1) {
      y.c.D var2 = new y.c.D(var1);
      this.q.a(var2);
      this.r.b();
      this.r.d();
      this.r.a();
      return (y.c.y[])var2.toArray(new y.c.y[var2.size()]);
   }

   public y.c.y[] b(y.c.y[] var1) {
      y.c.D var2 = new y.c.D(var1);
      this.i();
      this.q.b(var2);
      if(this.s != null) {
         this.s.b(var2);
      }

      this.j();
      this.a(var2);
      return (y.c.y[])var2.toArray(new y.c.y[var2.size()]);
   }

   public y.c.y[] c(y.c.y[] var1) {
      return var1;
   }

   public void d(y.c.y[] var1) {
      this.l();
      this.k();
   }

   public void c() {
   }

   public void d() {
      if(this.s != null && this.s.a()) {
         this.s.b();
      }

   }

   public void e() {
      if(this.q != null) {
         this.q.e();
         this.q = null;
      }

      if(this.r != null) {
         this.r.c();
         this.r = null;
      }

      if(this.s != null) {
         this.s.c();
         this.b.a((y.c.h)this.D);
         this.b.a((y.c.h)this.E);
         this.D = this.E = null;
         this.s = null;
      }

      if(this.x != null) {
         this.b.a((y.c.A)this.x);
         this.x = null;
      }

      this.h();
      this.c = null;
      this.J = null;
      this.G = null;
      this.x = null;
      this.H = null;
      this.I = null;
      this.m = null;
      this.b = null;
      this.F = null;
      this.h = null;
      this.i = null;
      this.f = null;
      this.g = null;
   }

   private int d(int var1) {
      boolean var7 = a.i;
      y.c.c var2 = this.b.c(y.f.aF.c);
      y.c.c var3 = this.b.c(y.f.aF.d);
      y.c.e var4 = this.b.p();

      int var10000;
      while(true) {
         if(var4.f()) {
            y.c.d var5 = var4.a();
            var10000 = this.e.d(var5);
            if(var7) {
               break;
            }

            label68: {
               if(var10000 != 0) {
                  if(var2 != null) {
                     this.E.a(var5, var2.b(var5));
                  }

                  if(var3 == null) {
                     break label68;
                  }

                  this.D.a(var5, var3.b(var5));
                  if(!var7) {
                     break label68;
                  }
               }

               if(var2 != null) {
                  this.D.a(var5, var2.b(var5));
               }

               if(var3 != null) {
                  this.E.a(var5, var3.b(var5));
               }
            }

            var4.g();
            if(!var7) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      y.c.y[] var8 = new y.c.y[var10000];
      int var9 = var8.length - 1;

      while(var9 >= 0) {
         var8[var9] = new y.c.y();
         --var9;
         if(var7) {
            break;
         }
      }

      y.c.x var10 = this.b.o();

      while(true) {
         if(var10.f()) {
            y.c.q var6 = var10.e();
            var8[this.c.a(var6)].add(var6);
            var10.g();
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         if(this.s != null) {
            y.c.D var11 = new y.c.D(var8);
            this.s.a(var11);
            return var11.size();
         }
         break;
      }

      return var8.length;
   }

   private void g() {
      boolean var3 = a.i;
      if(this.A == null) {
         this.A = this.b.u();
      }

      if(this.B == null) {
         this.B = this.b.u();
      }

      this.y = this.b.c(y.f.aF.a);
      this.z = this.b.c(y.f.aF.b);
      this.b.a((Object)y.f.aF.a, (y.c.c)this.A);
      this.b.a((Object)y.f.aF.b, (y.c.c)this.B);
      if(this.y != null || this.z != null) {
         y.c.e var1 = this.b.p();

         while(var1.f()) {
            y.c.d var2 = var1.a();
            if(this.y != null) {
               this.A.a(var2, this.y.b(var2));
            }

            if(this.z != null) {
               this.B.a(var2, this.z.b(var2));
            }

            var1.g();
            if(var3) {
               break;
            }
         }
      }

   }

   private void h() {
      this.b.d_(y.f.aF.a);
      if(this.y != null) {
         this.b.a((Object)y.f.aF.a, (y.c.c)this.y);
         this.y = null;
      }

      this.b.d_(y.f.aF.b);
      if(this.z != null) {
         this.b.a((Object)y.f.aF.b, (y.c.c)this.z);
         this.z = null;
      }

      if(this.A != null) {
         this.b.a((y.c.h)this.A);
         this.A = null;
      }

      if(this.B != null) {
         this.b.a((y.c.h)this.B);
         this.B = null;
      }

   }

   private void i() {
      boolean var6 = a.i;
      if(this.k) {
         y.c.e var1 = this.b.p();

         while(var1.f()) {
            label42: {
               y.c.d var2 = var1.a();
               boolean var3 = this.d.b(var2.c()) != null;
               boolean var4 = this.d.b(var2.d()) != null;
               y.c.d var5;
               if(var3 && !var4) {
                  var5 = (y.c.d)this.d.b(var2.c());
                  if(this.B.b(var2) != null) {
                     break label42;
                  }

                  this.B.a(var2, this.B.b(var5));
                  if(!var6) {
                     break label42;
                  }
               }

               if(!var3 && var4) {
                  var5 = (y.c.d)this.d.b(var2.d());
                  if(this.A.b(var2) == null) {
                     this.A.a(var2, this.A.b(var5));
                  }
               }
            }

            var1.g();
            if(var6) {
               break;
            }
         }

      }
   }

   private void a(y.c.D param1) {
      // $FF: Couldn't be decompiled
   }

   private void a(y.c.q var1, double var2, double var4, double var6, double var8) {
      if(this.v != null) {
         this.v.a(var1, var2);
      }

      if(this.w != null) {
         this.w.a(var1, var4);
      }

      if(this.t != null) {
         this.t.a(var1, var6);
      }

      if(this.t != null) {
         this.t.a(var1, var6);
      }

      if(this.u != null) {
         this.u.a(var1, var8);
      }

   }

   private void j() {
      this.t = this.b.t();
      this.u = this.b.t();
      this.b.a((Object)v.j, (y.c.c)this.t);
      this.b.a((Object)v.e_, (y.c.c)this.u);
      this.v = this.b.t();
      this.w = this.b.t();
   }

   private void k() {
      if(this.t != null) {
         this.b.d_(v.j);
         this.b.a((y.c.A)this.t);
         this.t = null;
      }

      if(this.u != null) {
         this.b.d_(v.e_);
         this.b.a((y.c.A)this.u);
         this.u = null;
      }

      if(this.v != null) {
         this.b.a((y.c.A)this.v);
         this.v = null;
      }

      if(this.w != null) {
         this.b.a((y.c.A)this.w);
         this.w = null;
      }

   }

   public double a(double var1, int var3) {
      return var3 <= 1?0.0D:var1 / ((double)(var3 - 1) + 2.0D * this.p);
   }

   public double a(double var1, int var3, double var4) {
      return var3 <= 1?var1 * 0.5D:(var1 - var4 * (double)(var3 - 1)) * 0.5D;
   }

   private void l() {
      // $FF: Couldn't be decompiled
   }

   private void a(y.c.q var1, z var2, double var3) {
      boolean var14 = a.i;
      y.c.p var5 = var2.l.k();

      while(var5 != null) {
         y.c.D var7;
         y.c.q var8;
         double var9;
         double var11;
         label17: {
            y.c.d var6 = (y.c.d)var5.c();
            var7 = this.c(var6);
            var8 = var6.c();
            var9 = this.b.p(var6).a;
            this.b.a(var6, var1, var6.d());
            if(this.d(var6)) {
               this.b.a(var6, (y.d.t)this.H.b(var6));
               var11 = this.b.p(var6).b;
               if(!var14) {
                  break label17;
               }
            }

            y.d.t var13 = var2.c(var2.a(), 0.0D);
            this.b.c(var6, var13);
            var11 = var13.b;
         }

         var7.a((Object)(new y.d.t(var9, var3)));
         var7.a((Object)(new y.d.t(var9, var11)));
         this.b.a((y.c.q)var8);
         var5 = var5.a();
         if(var14) {
            break;
         }
      }

   }

   private void b(y.c.q var1, z var2, double var3) {
      boolean var14 = a.i;
      y.c.p var5 = var2.l.k();

      while(var5 != null) {
         y.c.D var7;
         y.c.q var8;
         double var9;
         double var11;
         label17: {
            y.c.d var6 = (y.c.d)var5.c();
            var7 = this.c(var6);
            var8 = var6.d();
            var9 = this.b.q(var6).a;
            this.b.a(var6, var6.c(), var1);
            if(this.e(var6)) {
               this.b.b(var6, (y.d.t)this.I.b(var6));
               var11 = this.b.q(var6).b;
               if(!var14) {
                  break label17;
               }
            }

            y.d.t var13 = var2.c(var2.a(), 0.0D);
            this.b.d(var6, var13);
            var11 = var13.b;
         }

         var7.b((Object)(new y.d.t(var9, var3)));
         var7.b((Object)(new y.d.t(var9, var11)));
         this.b.a((y.c.q)var8);
         var5 = var5.a();
         if(var14) {
            break;
         }
      }

   }

   private void c(y.c.q var1, z var2, double var3) {
      boolean var16 = a.i;
      y.c.p var5 = var2.l.k();

      while(var5 != null) {
         y.c.D var7;
         y.c.q var8;
         double var9;
         double var11;
         double var13;
         label17: {
            y.c.d var6 = (y.c.d)var5.c();
            var7 = this.c(var6);
            var13 = var2.e(0.0D, var2.b());
            var8 = var6.c();
            var9 = this.b.p(var6).a;
            this.b.a(var6, var1, var6.d());
            if(this.d(var6)) {
               this.b.a(var6, (y.d.t)this.H.b(var6));
               var11 = this.b.p(var6).a;
               if(!var16) {
                  break label17;
               }
            }

            y.d.t var15 = var2.c(var2.a(), 0.0D);
            this.b.c(var6, var15);
            var11 = var15.a;
         }

         var7.a((Object)(new y.d.t(var9, var3)));
         var7.a((Object)(new y.d.t(var9, var13)));
         var7.a((Object)(new y.d.t(var11, var13)));
         this.b.a((y.c.q)var8);
         var5 = var5.a();
         if(var16) {
            break;
         }
      }

   }

   private void d(y.c.q var1, z var2, double var3) {
      boolean var16 = a.i;
      y.c.p var5 = var2.l.k();

      while(var5 != null) {
         y.c.D var7;
         y.c.q var8;
         double var9;
         double var11;
         double var13;
         label17: {
            y.c.d var6 = (y.c.d)var5.c();
            var7 = this.c(var6);
            var13 = var2.e(0.0D, var2.b());
            var8 = var6.d();
            var9 = this.b.q(var6).a;
            this.b.a(var6, var6.c(), var1);
            if(this.e(var6)) {
               this.b.b(var6, (y.d.t)this.I.b(var6));
               var11 = this.b.q(var6).a;
               if(!var16) {
                  break label17;
               }
            }

            y.d.t var15 = var2.c(var2.a(), 0.0D);
            this.b.d(var6, var15);
            var11 = var15.a;
         }

         var7.b((Object)(new y.d.t(var9, var3)));
         var7.b((Object)(new y.d.t(var9, var13)));
         var7.b((Object)(new y.d.t(var11, var13)));
         this.b.a((y.c.q)var8);
         var5 = var5.a();
         if(var16) {
            break;
         }
      }

   }

   private y.c.D c(y.c.d var1) {
      y.c.D var2 = (y.c.D)this.C.get(var1);
      if(var2 == null) {
         var2 = new y.c.D();
         this.C.put(var1, var2);
      }

      return var2;
   }

   private void a(z var1, y.c.q var2) {
      boolean var6 = a.i;
      boolean var3 = false;
      y.c.p var4 = var1.l.k();

      while(var4 != null) {
         y.c.d var5 = (y.c.d)var4.c();
         if(!this.b.f(var5)) {
            this.b.e(var5);
            var3 = true;
         }

         label30: {
            if(var5.c() == var2) {
               if(this.d(var5)) {
                  break label30;
               }

               this.b.c(var5, var1.c(var1.a(), 0.0D));
               if(!var6) {
                  break label30;
               }
            }

            if(!this.e(var5)) {
               this.b.d(var5, var1.c(var1.a(), 0.0D));
            }
         }

         if(var3) {
            var3 = false;
            this.b.d(var5);
         }

         var4 = var4.a();
         if(var6) {
            break;
         }
      }

   }

   private void b(z var1, y.c.q var2) {
      boolean var15 = a.i;
      if(var1.l.size() >= 1) {
         int[] var3 = new int[1];
         double[] var4 = new double[2];
         double var5 = var1.g;
         double var7 = var1.f();
         Object var9 = null;
         y.c.p var10 = this.a(var1.l.k(), var2, var3);
         int var11 = var3[0] - (var10 != null?0:1);
         var4[0] = var5;
         var4[1] = var7;
         this.a((y.c.p)var9, var10, var1, var2, var4);
         if(var11 > 0) {
            var1.j = (var4[1] - var4[0]) / (double)var11;
         }

         var1.d(var4[0]);
         boolean var12 = false;
         y.c.p var13 = var1.l.k();

         while(var13 != null) {
            y.c.d var14 = (y.c.d)var13.c();
            if(!this.b.f(var14)) {
               this.b.e(var14);
               var12 = true;
            }

            label83: {
               if(var14.c() == var2) {
                  if(this.d(var14)) {
                     var10 = this.a(var13.a(), var2, var3);
                     var11 = var3[0] + (var13 != null?1:0) + (var10 != null?1:0) - 1;
                     var4[0] = var5;
                     var4[1] = var7;
                     this.a(var13, var10, var1, var2, var4);
                     if(var11 <= 0) {
                        break label83;
                     }

                     var1.j = (var4[1] - var4[0]) / (double)var11;
                     var1.d(var4[0] + var1.j);
                     if(!var15) {
                        break label83;
                     }
                  }

                  this.b.c(var14, var1.c(var1.a(), 0.0D));
                  if(!var15) {
                     break label83;
                  }
               }

               if(this.e(var14)) {
                  var10 = this.a(var13.a(), var2, var3);
                  var11 = var3[0] + (var13 != null?1:0) + (var10 != null?1:0) - 1;
                  var4[0] = var5;
                  var4[1] = var7;
                  this.a(var13, var10, var1, var2, var4);
                  if(var11 <= 0) {
                     break label83;
                  }

                  var1.j = (var4[1] - var4[0]) / (double)var11;
                  var1.d(var4[0] + var1.j);
                  if(!var15) {
                     break label83;
                  }
               }

               this.b.d(var14, var1.c(var1.a(), 0.0D));
            }

            if(var12) {
               var12 = false;
               this.b.d(var14);
            }

            var13 = var13.a();
            if(var15) {
               break;
            }
         }

      }
   }

   private void a(y.c.p var1, y.c.p var2, z var3, y.c.q var4, double[] var5) {
      y.c.d var6;
      y.d.t var7;
      if(var2 != null) {
         var6 = (y.c.d)var2.c();
         var7 = var4 == var6.c()?this.b.p(var6):this.b.q(var6);
         var5[1] = var3.d(var7.a, var7.b);
      }

      if(var1 != null) {
         var6 = (y.c.d)var1.c();
         var7 = var4 == var6.c()?this.b.p(var6):this.b.q(var6);
         var5[0] = var3.d(var7.a, var7.b);
      }

   }

   private y.c.p a(y.c.p var1, y.c.q var2, int[] var3) {
      if(var1 == null) {
         var3[0] = 0;
         return null;
      } else {
         y.c.d var4 = (y.c.d)var1.c();
         boolean var5 = var4.c() == var2?this.d(var4):this.e(var4);
         if(var5) {
            var3[0] = 0;
            return var1;
         } else {
            int var6 = 0;

            do {
               if(var5) {
                  return null;
               }

               var1 = var1.a();
               ++var6;
               if(var1 == null) {
                  var3[0] = var6;
                  return null;
               }

               var4 = (y.c.d)var1.c();
               var5 = var4.c() == var2?this.d(var4):this.e(var4);
            } while(!var5);

            var3[0] = var6;
            return var1;
         }
      }
   }

   public y.c.f f() {
      return this.q.d();
   }

   y.f.aE a(y.c.d var1) {
      return this.A == null?M:(y.f.aE)this.A.b(var1);
   }

   y.f.aE b(y.c.d var1) {
      return this.B == null?N:(y.f.aE)this.B.b(var1);
   }

   private boolean d(y.c.d var1) {
      if(var1 == null) {
         return false;
      } else {
         y.f.aE var2 = this.a(var1);
         return var2 != null && var2.a();
      }
   }

   private boolean e(y.c.d var1) {
      if(var1 == null) {
         return false;
      } else {
         y.f.aE var2 = this.b(var1);
         return var2 != null && var2.a();
      }
   }

   static int a(byte var0, int var1) {
      switch(var0) {
      case 0:
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         return var1;
      case 1:
         return 0;
      case 2:
         return 2;
      case 4:
         return 1;
      case 8:
         return 3;
      }
   }

   public void b(double var1) {
      this.O = var1;
      this.q.b(var1);
      this.r.b(var1);
   }

   public void c(double var1) {
      this.P = var1;
   }
}
