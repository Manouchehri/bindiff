package y.f.d;

import java.util.HashMap;
import java.util.Map;
import y.f.Q;
import y.f.R;
import y.f.X;
import y.f.aH;
import y.f.aj;
import y.f.d.A;
import y.f.d.C;
import y.f.d.a;
import y.f.d.j;
import y.f.d.k;
import y.f.d.l;
import y.f.d.r;
import y.f.d.u;
import y.g.M;
import y.g.al;

public abstract class i extends a {
   y.c.h g;
   private static final double[][] q = new double[][]{{5.0D, 1.0D, 1.0D, 8.0D, 3.0D, 5.0D, 2.0D, 5.0D}, {5.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 1.0D, 5.0D}, {1.0D, 1.0D, 1.0D, 8.0D, 3.0D, 1.0D, 1.0D, 5.0D}, {1.0D, 5.0D, 1.0D, 1.0D, 1.0D, 1.0D, 0.0D, 5.0D}};
   private byte r = 0;
   private boolean s = true;
   private y.f.b.c t = null;
   private double u = 0.1D;
   protected X h;
   protected y.c.i i;
   protected y.c.A n;
   protected Map o;
   protected y.c.A p;

   public byte c() {
      return this.r;
   }

   void c(X var1, r[] var2) {
      int var11 = a.f;
      this.h = var1;
      this.o = new HashMap();
      this.t = new y.f.b.c(var1);
      aH var3 = this.b();
      boolean var4 = this.b;

      try {
         if(this.r != 4) {
            this.a(this.d(var2));
         }

         label71: {
            this.b(var2);
            if(this.s) {
               k[] var5 = this.e(var2);
               int var6 = 0;

               do {
                  if(var6 >= var5.length) {
                     break label71;
                  }

                  var5[var6].c();
                  var5[var6].b();
                  r[] var7 = var5[var6].a();
                  y.c.y var8 = this.a(var7);
                  this.a(var7, var8);
                  ++var6;
                  if(var11 != 0) {
                     return;
                  }
               } while(var11 == 0);
            }

            y.c.y var14 = this.a(var2);
            this.a(var2, var14);
         }

         this.i.j();
         this.h = null;
      } finally {
         this.a(var3);
         this.b = var4;
         this.t.c();
      }

   }

   void a(X var1, y.c.c var2, int var3) {
      u var4;
      label29: {
         int var7 = a.f;
         var4 = new u();
         int var5 = var1.f() + var1.h() + var3;
         if(var5 > 5000) {
            var4.c(20.0D);
            if(var7 == 0) {
               break label29;
            }
         }

         if(var5 > 1000) {
            var4.c(10.0D);
            if(var7 == 0) {
               break label29;
            }
         }

         var4.c(5.0D);
      }

      var4.b(35.0D);
      var4.a(5.0D);
      var4.b(true);
      var4.c(true);
      boolean var6 = this.r == 0 || this.r == 4;
      var4.a(var6);
      var4.a(var1, var2);
   }

   void b(r[] var1) {
      this.i = new y.c.i();
      this.g = this.i.u();
      this.n = this.i.t();
      this.p = this.i.t();
      this.c(var1);
      this.d();
   }

   private k[] e(r[] var1) {
      int var13 = a.f;
      y.c.A var2 = this.i.t();
      y.c.q[] var3 = new y.c.q[var1.length];
      int var4 = 0;

      while(var4 < var1.length) {
         var3[var4] = this.i.d();
         var2.a(var3[var4], true);
         ++var4;
         if(var13 != 0) {
            break;
         }
      }

      y.c.x var14 = this.i.o();

      int var10000;
      while(true) {
         if(var14.f()) {
            y.c.q var5 = var14.e();
            var10000 = var2.d(var5);
            if(var13 != 0) {
               break;
            }

            if(var10000 == 0) {
               int var6 = this.p.a(var5);
               this.i.a(var3[var6], var5);
            }

            var14.g();
            if(var13 == 0) {
               continue;
            }
         }

         var10000 = this.i.f();
         break;
      }

      y.c.A var15 = M.a(new int[var10000]);
      int var16 = y.a.h.a(this.i, var15);
      k[] var17 = new k[var16];
      int var7 = 0;

      while(var7 < var16) {
         var17[var7] = new k(this);
         ++var7;
         if(var13 != 0) {
            break;
         }
      }

      int[] var18 = new int[var1.length];
      y.c.x var8 = this.i.o();

      int var10;
      byte var21;
      label76:
      while(true) {
         var10000 = var8.f();

         label73:
         while(var10000 != 0) {
            y.c.q var9 = var8.e();
            var21 = var2.d(var9);
            if(var13 != 0) {
               break label76;
            }

            if(var21 == 0) {
               var10 = var15.a(var9);
               var18[this.p.a(var9)] = var10;
               var17[var10].a(var9);
               y.c.e var11 = var9.l();

               while(var11.f()) {
                  y.c.d var12 = var11.a();
                  var10000 = var15.a(var12.d());
                  if(var13 != 0) {
                     continue label73;
                  }

                  if(var10000 == var10) {
                     var17[var10].a(var12);
                  }

                  var11.g();
                  if(var13 != 0) {
                     break;
                  }
               }
            }

            var8.g();
            if(var13 == 0) {
               continue label76;
            }
            break;
         }

         this.i.a(var2);
         var21 = 0;
         break;
      }

      int var19 = var21;

      while(true) {
         if(var19 < var1.length) {
            r var20 = var1[var19];
            var10 = var18[var19];
            var17[var10].a(var20);
            ++var19;
            if(var13 != 0) {
               break;
            }

            if(var13 == 0) {
               continue;
            }
         }

         var19 = 0;
         break;
      }

      while(var19 < var3.length) {
         this.i.a(var3[var19]);
         ++var19;
         if(var13 != 0) {
            break;
         }
      }

      return var17;
   }

   abstract y.c.y a(r[] var1);

   void a(r[] var1, y.c.y var2) {
      int var6 = a.f;
      y.c.x var3 = var2.a();

      while(var3.f()) {
         r var4 = var1[this.p.a(var3.e())];
         Q var5 = (Q)this.n.b(var3.e());
         var5.g();
         var4.a(true);
         var3.g();
         if(var6 != 0) {
            break;
         }
      }

      int var7 = 0;

      while(var7 < var1.length) {
         if(!var1[var7].c()) {
            var1[var7].a();
         }

         ++var7;
         if(var6 != 0) {
            break;
         }
      }

   }

   void c(r[] var1) {
      int var7 = a.f;
      int var2 = 0;

      while(var2 < var1.length) {
         label28: {
            y.c.D var3 = var1[var2].b();
            if(var3 != null) {
               y.c.C var4 = var3.m();

               while(var4.f()) {
                  Q var5 = (Q)var4.d();
                  y.c.q var6 = this.i.d();
                  this.n.a(var6, var5);
                  this.o.put(var5, var6);
                  this.p.a(var6, var2);
                  var4.g();
                  if(var7 != 0) {
                     break label28;
                  }

                  if(var7 != 0) {
                     break;
                  }
               }
            }

            ++var2;
         }

         if(var7 != 0) {
            break;
         }
      }

   }

   protected void d() {
      al var1 = new al();
      y.g.o.a(this, "create edges in conflict graph");
      this.d(this.h);
      y.g.o.a(this, "Time: " + var1);
   }

   protected y.c.A e() {
      int var5 = a.f;
      y.c.A var1 = this.i.t();
      y.c.x var2 = this.i.o();

      y.c.A var10000;
      while(true) {
         if(var2.f()) {
            y.c.q var3 = var2.e();
            Q var4 = (Q)this.n.b(var3);
            var10000 = var1;
            if(var5 != 0) {
               break;
            }

            var1.a(var3, this.a(var4) - var4.k());
            var2.g();
            if(var5 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   private void d(X var1) {
      int var8 = a.f;
      y.c.D var2 = new y.c.D();
      y.c.x var3 = var1.o();

      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            var2.add(new j(var4, var1.s(var4), (byte)0));
            var3.g();
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         y.c.e var9 = var1.p();

         Object var10000;
         label62: {
            while(var9.f()) {
               y.c.d var10 = var9.a();
               var10000 = var1;
               if(var8 != 0) {
                  break label62;
               }

               y.c.C var5 = var1.l(var10).a();
               y.d.t var6 = (y.d.t)var5.d();
               var5.g();

               while(true) {
                  if(var5.f()) {
                     y.d.t var7 = (y.d.t)var5.d();
                     var2.add(new j(var10, new y.d.m(var6, var7), (byte)1));
                     var6 = var7;
                     var5.g();
                     if(var8 != 0) {
                        break;
                     }

                     if(var8 == 0) {
                        continue;
                     }
                  }

                  var9.g();
                  break;
               }

               if(var8 != 0) {
                  break;
               }
            }

            var10000 = this.i;
         }

         var3 = ((y.c.i)var10000).o();
         break;
      }

      while(true) {
         if(var3.f()) {
            Q var11 = (Q)this.n.b(var3.e());
            R var12 = var11.e();
            if(var8 != 0) {
               break;
            }

            label78: {
               if(var12 instanceof y.f.C) {
                  y.c.d var13 = var1.a((y.f.C)var12);
                  var2.add(new j(var13, var11, (byte)2));
                  if(var8 == 0) {
                     break label78;
                  }
               }

               if(var12 instanceof aj) {
                  y.c.q var14 = var1.a((aj)var12);
                  var2.add(new j(var14, var11, (byte)2));
                  if(var8 == 0) {
                     break label78;
                  }
               }

               var2.add(new j((Object)null, var11, (byte)2));
            }

            var3.g();
            if(var8 == 0) {
               continue;
            }
         }

         y.d.f.a(var2, new l(this));
         break;
      }

   }

   double f() {
      return q[this.r][2];
   }

   aH d(r[] var1) {
      A var2 = new A(var1, this.h);
      var2.b(q[this.r][0]);
      var2.d(q[this.r][1]);
      var2.f(q[this.r][4]);
      var2.e(q[this.r][3]);
      var2.g(q[this.r][5]);
      var2.c(q[this.r][6]);
      var2.h(q[this.r][7]);
      if(this.b) {
         var2.a(this.b());
         var2.a(this.u);
      }

      return var2;
   }

   protected void a(Q var1, Q var2, y.c.d var3) {
      if(this.r != 4) {
         double var4 = C.a(var1.d(), var2.d());
         this.g.a(var3, var4);
      }

   }

   protected void a(Q var1, y.c.q var2, y.d.y var3) {
      if(this.r != 4 && (this.t == null || !this.t.d(var2)) && y.d.n.a(var1.d(), var3, 0.001D)) {
         A var4 = (A)this.b();
         var4.a(var1, var2, var3);
      }

   }

   protected void a(Q var1, y.c.d var2, y.d.m var3) {
      if(this.r != 4 && y.d.n.a(var1.d(), var3, 0.001D)) {
         A var4 = (A)this.b();
         var4.a(var1, var2, var3);
      }

   }
}
