package y.f.f.b;

import y.c.q;
import y.f.O;
import y.f.U;
import y.f.X;
import y.f.ae;
import y.f.f.a.b.w;
import y.f.f.b.b;
import y.f.f.b.c;
import y.f.f.b.d;
import y.f.f.b.e;
import y.f.f.b.h;
import y.f.f.b.k;
import y.f.f.b.m;
import y.f.f.b.o;
import y.f.f.b.p;
import y.f.f.d.C;
import y.f.f.d.t;
import y.f.h.D;
import y.g.M;
import y.g.al;

public class a extends y.f.c {
   protected D n = null;
   protected boolean o = false;
   protected boolean p = false;
   protected boolean q = true;
   protected boolean r = false;
   protected boolean s = false;
   protected int t;
   protected y.f.h.o u;
   protected b v;
   protected p w;
   protected d x;
   protected e y;
   protected y.f.e z = null;
   private y.f.f.a.b.a A;
   private m B = null;
   private al C = new al();
   private y.f.f.a D = new y.f.f.a();

   public a() {
      this.f(false);
      this.b(false);
      this.z = new y.f.e();
      this.d(this.z);
      this.e(true);
      this.y = new e();
      this.c(false);
   }

   public void a(y.f.f.a var1) {
      this.D = var1;
   }

   public void a(y.f.f.a.b.a var1) {
      this.A = var1;
   }

   public void a(int var1) {
      this.z.a((double)var1);
      this.t = var1;
   }

   public void g(boolean var1) {
      this.p = var1;
   }

   public void h(boolean var1) {
      this.q = var1;
   }

   public boolean a() {
      return this.r;
   }

   public void i(boolean var1) {
      this.r = var1;
   }

   public boolean n() {
      return this.s;
   }

   public void j(boolean var1) {
      this.s = var1;
   }

   public void a(y.f.h.o var1) {
      this.u = var1;
   }

   public y.f.h.o o() {
      return this.u;
   }

   public void a(b var1) {
      this.v = var1;
   }

   public void a(p var1) {
      this.w = var1;
   }

   public p p() {
      return this.w;
   }

   public void a(d var1) {
      this.x = var1;
   }

   public void a(e var1) {
      this.y = var1;
   }

   public boolean b(X var1) {
      return true;
   }

   private boolean q() {
      boolean var1 = false;
      if(this.p() instanceof t) {
         t var2 = (t)this.p();
         if(var2.c() == 0) {
            var1 = true;
         }
      }

      return var1;
   }

   protected void a(O var1, Object var2) {
   }

   protected void b(O var1, Object var2) {
   }

   private y.f.f.a a(y.c.d var1, h var2) {
      D var3 = (D)var2.b();
      y.c.d var4 = var3.n(var1)?var3.d(var3.h(var1)):var3.d(var1);
      if(var4 != null && var1.a() != null) {
         y.c.c var5 = var1.a().c(y.f.f.c.n);
         if(var5 != null && var5.b(var4) != null) {
            return (y.f.f.a)var5.b(var4);
         }
      }

      return this.D;
   }

   public void a(X var1) {
      int var23 = h.a;
      y.g.o.a(this, 1, "---->> Starting Layout algorithm:");
      this.B = new m();
      al var2 = new al();
      this.a((y.c.i)var1);
      if(var1.h() == 0) {
         var1.a(var1.o().e(), 0.0D, 0.0D);
      } else {
         y.c.f var3 = new y.c.f(var1.p());
         h var4 = null;
         D var5 = this.o?this.n:new D(var1);
         C var6 = new C();
         if(this.n() && this.q()) {
            var6.a(var1, this.t);
         }

         if(this.a()) {
            y.c.c var7 = var1.c(U.a);
            if(var7 != null) {
               this.y.a(var5, var7, this.t);
            }
         }

         y.a.a.a("before phase 1");
         c var24 = new c();
         k var8 = new k();
         var8.a((double)this.t);
         if(!this.o) {
            if(this.q) {
               var24.a((y.c.i)var1);
            }

            if(this.p) {
               var8.a((y.c.i)var1);
            }

            this.C.e();
            this.u.a(var5);
            if(var1.h() != 0) {
               this.u.c();
            }

            this.B.b = (int)this.C.d();
            this.B.o = var5.a();
            this.a((y.c.i)var1);
         }

         y.a.a.a("before phase 2");
         if(this.x != null) {
            this.x.a(this.t);
            this.x.a(var5);
            this.x.a();
            var5 = this.x.b();
            if(this.y instanceof y.f.f.a.b.f) {
               y.c.c var9 = var1.c(U.a);
               if(var9 != null) {
                  ((y.f.f.a.b.f)this.y).a(this.A, var5, var9, var3);
               }
            }

            var4 = new h(var5);
         } else {
            var4 = new h(var5);
         }

         this.C.e();
         this.v.a(var4);
         if(var4.a().h() != 0) {
            this.v.a();
         }

         this.B.f = (int)this.C.d();
         if(!this.o) {
            if(this.p) {
               var8.a(var4);
               var8.a();
            }

            if(this.q) {
               var24.a(var4);
               var24.a();
            }
         }

         this.B.p = this.v.b();
         this.a((y.c.i)var1);
         y.a.a.a("before phase 3");
         y.c.d[] var25 = var4.a().n();
         int var10 = 0;

         h var10000;
         while(true) {
            if(var10 < var25.length) {
               y.c.d var11 = var25[var10];
               var10000 = var4;
               if(var23 != 0) {
                  break;
               }

               if(!var4.c(var11)) {
                  var4.n(var11);
               }

               ++var10;
               if(var23 == 0) {
                  continue;
               }
            }

            var10000 = var4;
            break;
         }

         X var26 = (X)var10000.a();
         y.c.h var27 = M.b();
         y.c.e var12 = var26.p();

         y.c.d var13;
         y.f.f.a var14;
         boolean var29;
         while(true) {
            if(var12.f()) {
               var13 = var12.a();
               var29 = var4.c(var13);
               if(var23 != 0) {
                  break;
               }

               if(!var29) {
                  var14 = this.a(var13, var4);
                  if(var14 != null) {
                     var27.a(var13, var14.d());
                  }
               }

               var12.g();
               if(var23 == 0) {
                  continue;
               }
            }

            var29 = this.a();
            break;
         }

         if(var29) {
            this.y.a(var27);
            this.y.a(var4);
            this.y.b();
         }

         var12 = var26.p();

         while(true) {
            if(var12.f()) {
               var13 = var12.a();
               var29 = var4.c(var13);
               if(var23 != 0) {
                  break;
               }

               if(!var29) {
                  var14 = (y.f.f.a)var27.b(var13);
                  if(var14 != null) {
                     int var20;
                     label190: {
                        int var15 = this.a(var13, var26, var4);
                        int var16 = (int)Math.ceil(((double)var15 + var14.c()) / (double)this.t);
                        int var17 = (int)Math.ceil(((double)var15 + var14.a()) / (double)this.t);
                        int var18 = (int)Math.ceil(((double)var15 + var14.b()) / (double)this.t);
                        int var19 = (int)Math.ceil(((double)var15 + var14.b() + var14.a()) / (double)this.t);
                        var20 = Math.max(var16, var4.i(var13));
                        boolean var21 = this.a(var13.c(), var4);
                        boolean var22 = this.a(var13.d(), var4);
                        if(var21 && var22 && var20 < var19) {
                           var20 = var19;
                           if(var23 == 0) {
                              break label190;
                           }
                        }

                        if(var21 && var20 < var17) {
                           var20 = var17;
                           if(var23 == 0) {
                              break label190;
                           }
                        }

                        if(var22 && var20 < var18) {
                           var20 = var18;
                        }
                     }

                     var4.b(var13, var20);
                     var4.b(var4.a(var13), var20);
                  }
               }

               var12.g();
               if(var23 == 0) {
                  continue;
               }
            }

            this.C.e();
            ae.a(var1);
            this.w.a(this.t);
            this.w.a(var4);
            this.w.a(this.B);
            this.w.a();
            this.B.g = (int)this.C.d();
            var29 = this.a();
            break;
         }

         if(var29) {
            this.y.a(var6);
            var4.j();
            this.y.c();
         }

         if(this.x != null) {
            this.x.c();
         }

         if(this.r) {
            this.y.a();
         }

         if(this.o) {
            var4.k();
         }

         if(!this.o) {
            this.u.a();
         }

         var4.q();
         this.a((y.c.i)var1);
         if(this.n()) {
            var6.a();
         }

         if(this.u instanceof y.f.h.c) {
            y.f.h.c var28 = (y.f.h.c)this.u;
            this.B.c = var28.b();
            this.B.d = var28.d();
            this.B.e = var28.e();
         }

         this.B.a = (int)var2.d();
         y.g.o.a(this, 1, "---> Total running time of the algorithm: " + var2);
         y.g.o.a(this, 1, "<<---- Leaving algorithm");
      }
   }

   private boolean a(q var1, h var2) {
      return var2.d(var1)?true:(this.o() instanceof w?((w)this.o()).b().f(var1):false);
   }

   private int a(y.c.d var1, X var2, h var3) {
      y.c.d var10000;
      y.c.d var10001;
      int var4;
      y.c.e var5;
      y.c.d var6;
      q var7;
      o var8;
      boolean var9;
      int var10;
      label84: {
         var10 = h.a;
         var4 = 0;
         if(var3.g(var1.c())) {
            var5 = var1.c().l();

            while(var5.f()) {
               var6 = var5.a();
               var7 = var6.d();
               var10000 = var6;
               var10001 = var1;
               if(var10 != 0) {
                  break label84;
               }

               if(var6 != var1 && var3.d(var7)) {
                  var8 = var3.h(var6);
                  var9 = !o.a.a(var8)?o.c.a(var8):true;
                  var4 = (int)((double)var4 + (var9?var2.p(var7) * 0.5D:var2.q(var7) * 0.5D));
               }

               var5.g();
               if(var10 != 0) {
                  break;
               }
            }
         }

         if(!var3.g(var1.d())) {
            return var4;
         }

         var5 = var1.d().k();
         if(!var5.f()) {
            return var4;
         }

         var6 = var5.a();
         var7 = var6.c();
         var10000 = var6;
         var10001 = var1;
      }

      while(true) {
         if(var10000 != var10001 && var3.d(var7)) {
            var8 = var3.h(var6);
            var9 = o.a.a(var8) || o.c.a(var8);
            var4 = (int)((double)var4 + (var9?var2.p(var7) * 0.5D:var2.q(var7) * 0.5D));
         }

         var5.g();
         if(var10 != 0 || !var5.f()) {
            return var4;
         }

         var6 = var5.a();
         var7 = var6.c();
         var10000 = var6;
         var10001 = var1;
      }
   }

   private void a(y.c.i var1) {
      y.g.o.a(this, "Node Map Count: " + var1.v().length);
      y.g.o.a(this, "Edge Map Count: " + var1.w().length);
   }
}
