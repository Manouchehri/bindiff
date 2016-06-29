package y.f.f.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.aG;
import y.f.aI;
import y.f.f.a.b;
import y.f.f.a.c;
import y.f.f.a.f;
import y.f.f.a.n;
import y.f.f.a.a.p;
import y.f.f.a.b.E;
import y.f.f.a.b.w;
import y.f.f.a.b.z;
import y.f.f.d.t;
import y.g.M;

public class a extends y.f.c {
   private p n;
   private y.f.f.a.b.a o;
   private X p;
   private int q;
   private int r;
   private boolean s;
   private boolean t;
   private y.c.f u;
   private y v;
   private y.f.f.a w;
   private boolean x;

   public void a(y.f.f.a var1) {
      this.w = var1;
   }

   public int a() {
      return this.q;
   }

   public boolean b(X var1) {
      return true;
   }

   public void a(X var1) {
      boolean var13 = f.a;
      this.p = var1;
      this.v = new y();
      this.u = new y.c.f();
      this.v.a(this.p.o());
      this.u.a(this.p.p());
      y.c.c var2 = this.p.c(y.f.f.b.n);
      y.c.h var3 = M.b();
      y.c.e var4 = this.p.p();

      while(true) {
         if(var4.f()) {
            y.c.d var5 = var4.a();
            y.f.f.a var6 = this.a(var5);
            if(var13) {
               break;
            }

            if(var6 != null) {
               var3.a(var5, var6.d());
            }

            var4.g();
            if(!var13) {
               continue;
            }

            y.c.i.g = !y.c.i.g;
         }

         this.p.a((Object)y.f.f.b.n, (y.c.c)var3);
         break;
      }

      y.c.h var14;
      label122: {
         var14 = this.p.u();
         y.c.c var15 = this.p.c(U.a);
         if(var15 != null) {
            y.c.e var16 = var1.p();

            while(var16.f()) {
               y.c.d var7 = var16.a();
               S[] var8 = (S[])var15.b(var7);
               if(var13) {
                  break label122;
               }

               if(var8 != null) {
                  ArrayList var9 = a((Object[])var8);
                  y.g.e.a((List)var9, new b());
                  var14.a(var7, var9);
               }

               var16.g();
               if(var13) {
                  break;
               }
            }
         }

         if(this.n == null) {
            this.n = y.f.f.a.a.i.a(this.p);
         }
      }

      label109: {
         y.c.c var17 = this.p.c(y.f.b.f.f);
         if(var17 != null) {
            y.f.b.c var18 = new y.f.b.c(this.p);
            x var21 = this.p.o();

            while(var21.f()) {
               q var24 = var21.e();
               y.f.f.a.a.b var10 = this.n.a(var24);
               if(var13) {
                  break label109;
               }

               if(var10 != null && var10.d() && var18.d(var24)) {
                  y.d.q var11 = (y.d.q)var17.b(var24);
                  y.d.q var12 = this.p.r(var24);
                  if(var11 != null) {
                     this.p.b(var24, Math.max(var12.a, var11.a), Math.max(var12.b, var11.b));
                  }
               }

               var21.g();
               if(var13) {
                  break;
               }
            }

            var18.c();
         }

         this.o = new y.f.f.a.b.a(this.p, this.n);
      }

      y.c.e var19 = this.o.d().p();

      while(true) {
         if(var19.f()) {
            this.o.m(var19.a());
            var19.g();
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         this.a(var14, var3);
         break;
      }

      y.c.f var20 = E.a(this.o.d(), this.o.b());
      y.c.e var22 = var20.a();

      while(true) {
         if(var22.f()) {
            this.o.s(var22.a());
            var22.g();
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         z.a(this.o, var14, var3);
         break;
      }

      label76: {
         y.f.f.b.a var23 = new y.f.f.b.a();
         var23.a(this.q);
         var23.a(this.w);
         var23.e(false);
         var23.a(this.o);
         w var25 = new w(this.o, this.u);
         var25.a(this.r);
         var25.b(this.t);
         var25.a(this.s);
         var23.a((y.f.h.o)var25);
         var23.d(false);
         f var26 = new f(this.o, this.u);
         var23.a((y.f.f.b.d)var26);
         c var27 = new c();
         var27.a(this.n);
         var27.a(this.o);
         var23.a((y.f.f.b.b)var27);
         n var28 = new n();
         var28.b(this.x?1:3);
         this.p.a((Object)t.a, (y.c.c)y.g.q.a((Object)(new Integer(5))));
         var23.a((y.f.f.b.p)var28);
         var23.j(this.p.c(U.b) != null);
         var23.i(this.p.c(U.a) != null);
         var23.a((y.f.f.b.e)(new y.f.f.a.b.f(var14)));
         var23.g(false);
         var23.h(false);
         var23.a(false);
         var23.c(this.p);
         this.n();
         this.o.a();
         (new aI()).c(this.p);
         if(var2 != null) {
            this.p.a((Object)y.f.f.b.n, (y.c.c)var2);
            if(!var13) {
               break label76;
            }
         }

         this.p.d_(y.f.f.b.n);
      }

      this.n = null;
      this.o = null;
      this.p = null;
      this.u = null;
      this.v = null;
   }

   private static ArrayList a(Object[] var0) {
      boolean var3 = f.a;
      ArrayList var1 = new ArrayList(var0.length);
      int var2 = 0;

      ArrayList var10000;
      while(true) {
         if(var2 < var0.length) {
            var10000 = var1;
            if(var3) {
               break;
            }

            var1.add(var0[var2]);
            ++var2;
            if(!var3) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   void n() {
      boolean var4 = f.a;
      y.c.e var1 = this.p.p();

      while(var1.f()) {
         y.c.d var2 = var1.a();
         y.c.f var3 = this.o.x(var2);
         if(var3 != null) {
            this.p.a((q)var3.b().d());
         }

         var1.g();
         if(var4) {
            break;
         }
      }

   }

   private void a(y.c.h var1, y.c.h var2) {
      boolean var14 = f.a;
      y.c.e var3 = this.p.p();
      var3.j();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(var4.c() != var4.d()) {
            label20: {
               y.f.f.a.a.b var5 = this.n.a(var4.c());
               y.f.f.a.a.b var6 = this.n.a(var4.d());
               y.f.f.a.a.b var7 = (y.f.f.a.a.b)y.f.f.a.a.n.d(var5, var6);
               y.f.f.a.a.b var8;
               q var9;
               y.f.f.a.a.b var10;
               y.c.d var11;
               y.c.d var12;
               y.c.f var13;
               if(var7 == var5) {
                  var8 = (y.f.f.a.a.b)var5.c();
                  var9 = this.p.d();
                  this.p.b(var9, 0.0D, 0.0D);
                  var10 = this.n.a(var8, var9);
                  var8.a(var10);
                  var11 = this.p.a((q)var4.c(), (q)var9);
                  var12 = this.p.a((q)var9, (q)var4.d());
                  var13 = new y.c.f();
                  var13.b(var11);
                  var13.b(var12);
                  this.a(var4, var13, var1, false);
                  this.a(var4, var13, var2);
                  this.o.b(var4, var13);
                  this.p.d(var4);
                  if(!var14) {
                     break label20;
                  }
               }

               if(var7 == var6) {
                  var8 = (y.f.f.a.a.b)var6.c();
                  var9 = this.p.d();
                  this.p.b(var9, 0.0D, 0.0D);
                  var10 = this.n.a(var8, var9);
                  var8.a(var10);
                  var11 = this.p.a((q)var4.c(), (q)var9);
                  var12 = this.p.a((q)var9, (q)var4.d());
                  var13 = new y.c.f();
                  var13.b(var11);
                  var13.b(var12);
                  this.a(var4, var13, var1, false);
                  this.a(var4, var13, var2);
                  this.o.b(var4, var13);
                  this.p.d(var4);
               }
            }
         }

         var3.h();
         if(var14) {
            break;
         }
      }

   }

   private void a(y.c.d var1, y.c.f var2, y.c.h var3, boolean var4) {
      boolean var11 = f.a;
      ArrayList var5 = (ArrayList)var3.b(var1);
      if(var5 != null && !var5.isEmpty()) {
         ArrayList var6 = new ArrayList();
         ArrayList var7 = new ArrayList();
         Iterator var8 = var5.iterator();

         while(true) {
            if(var8.hasNext()) {
               S var9 = (S)var8.next();
               aG var10 = var9.f();
               if(var11) {
                  break;
               }

               if(var4) {
                  if(var10.i()) {
                     var6.add(var9);
                     if(!var11) {
                        continue;
                     }
                  }

                  var7.add(var9);
                  if(!var11) {
                     continue;
                  }
               }

               if(!var10.i() && !var10.j()) {
                  var7.add(var9);
                  if(!var11) {
                     continue;
                  }
               }

               var6.add(var9);
               if(!var11) {
                  continue;
               }
            }

            var3.a(var2.b(), var6);
            var3.a(var2.c(), var7);
            break;
         }

      }
   }

   private y.f.f.a a(y.c.d var1) {
      y.c.c var2 = this.p.c(y.f.f.b.n);
      return var2 != null && var2.b(var1) != null?(y.f.f.a)var2.b(var1):this.w;
   }

   private void a(y.c.d var1, y.c.f var2, y.c.h var3) {
      boolean var13 = f.a;
      y.f.f.a var4 = (y.f.f.a)var3.b(var1);
      if(var4 != null) {
         int var5 = 0;
         y.c.e var6 = var2.a();

         while(var6.f()) {
            label41: {
               y.c.d var7 = var6.a();
               y.f.f.a var8 = (y.f.f.a)var3.b(var7);
               if(var8 != null) {
                  double var9 = Math.max(var8.c(), var4.c());
                  var8.c(var9);
                  double var11;
                  if(var5 == 0) {
                     var11 = Math.max(var8.a(), var4.a());
                     var8.a(var11);
                  }

                  if(var5 != var2.size() - 1) {
                     break label41;
                  }

                  var11 = Math.max(var8.b(), var4.b());
                  var8.b(var11);
                  if(!var13) {
                     break label41;
                  }
               }

               var8 = var4.d();
               if(var5 > 0) {
                  var8.a(0.0D);
               }

               if(var5 < var2.size() - 1) {
                  var8.b(0.0D);
               }

               var3.a(var7, var8);
            }

            var6.g();
            ++var5;
            if(var13) {
               break;
            }
         }
      }

   }
}
