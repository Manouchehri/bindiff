package y.f.f.d;

import y.f.S;
import y.f.X;
import y.f.aG;
import y.f.am;
import y.f.f.d.A;
import y.f.f.d.B;
import y.f.f.d.E;
import y.f.f.d.J;
import y.f.f.d.K;
import y.f.f.d.M;
import y.f.f.d.c;
import y.f.f.d.d;
import y.f.f.d.f;
import y.f.f.d.o;
import y.f.f.d.s;
import y.f.f.d.z;

public class y {
   private static int q = 0;
   private static boolean r = false;
   protected y.c.i a;
   protected y.f.f.b.h b;
   protected M c;
   protected y.c.i d;
   protected y.f.v e;
   protected K f;
   protected boolean g = true;
   protected y.c.D h;
   protected int i;
   private boolean s = false;
   protected y.c.A j;
   protected y.c.h k;
   protected y.c.h l;
   protected y.c.h m;
   protected int n = -1;
   protected int o = -1;
   protected int p;

   public y(y.f.f.b.h var1, short var2, int var3) {
      this.a = var1.a();
      this.b = var1;
      this.i = var3;
      if(this.i < 1) {
         throw new IllegalArgumentException("Invalid grid distance !");
      } else {
         this.c = this.a(var2);
         if(this.c == null) {
            throw new IllegalArgumentException("Invalid node model !");
         } else {
            this.g = this.c.a();
         }
      }
   }

   protected M a(short var1) {
      switch(var1) {
      case 0:
         return new d(this.i);
      case 1:
         return new E(this.i);
      case 2:
         return new J(this.i);
      case 3:
         return new c();
      case 4:
         return new s();
      default:
         return null;
      }
   }

   public static void a(boolean var0) {
      if(var0) {
         q = 1;
         r = true;
         if(!o.p) {
            return;
         }
      }

      q = 0;
      r = false;
   }

   public void b(boolean var1) {
      this.s = var1;
   }

   public K a() {
      return this.f;
   }

   public y.c.D b() {
      return this.h;
   }

   public void c() {
      boolean var23 = o.p;
      this.c.a(this.b);
      y.c.A var1 = this.a.t();
      y.f.h.p var2 = this.b.d();
      y.c.d var3 = var2.a().a();
      double var4 = 30.0D;
      y.c.h var6 = this.a.u();
      this.d = new y.c.i();
      if(r) {
         this.e = new y.f.v();
      }

      this.f = new K(this.d);
      this.j = this.a.t();
      this.h();
      this.k = this.a.u();
      this.l = this.a.u();
      this.i();
      this.a((y.f.f.b.h)this.b, (y.f.f.b.h)this.f);
      boolean[] var7 = this.b.p();
      y.g.o.a(this, 3, "-----> Create edges for nodes:");
      y.c.x var8 = this.a.o();

      y.c.e var9;
      y.c.q var10;
      y var10000;
      while(true) {
         if(var8.f()) {
            var9 = null;
            var10 = var8.e();
            y.c.q[] var11 = new y.c.q[4];
            A var12 = (A)this.j.b(var10);
            var11[0] = var12.a();
            var11[1] = var12.d();
            var11[2] = var12.c();
            var11[3] = var12.b();
            var10000 = this;
            if(var23) {
               break;
            }

            y.c.d var13 = this.a(var10);
            if(var13 != null) {
               var9 = var10.a(var13);
            }

            y.c.d var31 = var13;

            label171:
            while(true) {
               y.c.d var14 = var31;
               int var15 = 0;

               while(true) {
                  if(var15 >= 4) {
                     break label171;
                  }

                  var31 = var13;
                  if(var23) {
                     break;
                  }

                  boolean var16 = var13 != null;
                  y.c.q var17 = var11[var15];
                  int var18 = q;

                  int var10001;
                  int var32;
                  label161: {
                     while(var16) {
                        var32 = this.b.g(var14);
                        var10001 = var15;
                        if(var23) {
                           break label161;
                        }

                        if(var32 == var15) {
                           y.c.q var19 = (y.c.q)this.k.b(var14);
                           y.c.q var20 = (y.c.q)this.l.b(var14);
                           y.c.d var21 = this.a(var10, var17, var19, var15, var4, var18);
                           var1.a(var10, var21);
                           var17 = (y.c.q)this.k.b(var14);
                           y.c.d var22 = this.d.a(var19, var20);
                           if(var7[var14.b()]) {
                              this.f.s(var22);
                           }

                           label154: {
                              this.f.a(var22, this.b.e(var14));
                              this.f.b(var22, 1.0D);
                              if(this.b.j(var14)) {
                                 this.f.b(var22, Math.max(this.b.i(var14), 1));
                                 if(!var23) {
                                    break label154;
                                 }
                              }

                              this.f.b(var22, 1);
                           }

                           this.f.c(var22, this.b.l(var14));
                           this.f.d(var22, this.b.m(var14));
                           var6.a(var14, var22);
                           var9.b();
                           var14 = var9.a();
                           if(var14 != var13) {
                              continue;
                           }

                           var16 = false;
                           if(!var23) {
                              continue;
                           }
                        }

                        var16 = false;
                        if(var23) {
                           break;
                        }
                     }

                     var32 = var15;
                     var10001 = 3;
                  }

                  label166: {
                     if(var32 == var10001) {
                        this.a(var10, var17, var11[0], 3, var4, q);
                        if(!var23) {
                           break label166;
                        }
                     }

                     this.a(var10, var17, var11[var15 + 1], var15, var4, q);
                  }

                  ++var15;
                  if(var23) {
                     break label171;
                  }
               }
            }

            var8.g();
            if(!var23) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var24 = var10000.a.p();

      y.c.d var28;
      Object var33;
      while(true) {
         if(var24.f()) {
            y.c.d var26 = var24.a();
            var33 = var26.d();
            if(var23) {
               break;
            }

            if(((y.c.q)var33).d() < var26.c().d()) {
               var28 = this.b.a(var26);
               this.f.a((y.c.d)var6.b(var26), (y.c.d)var6.b(var28));
            }

            var24.g();
            if(!var23) {
               continue;
            }
         }

         y.g.o.a(this, 3, "Create Faces:");
         this.f.f();
         this.k();
         var33 = var6.b(var3);
         break;
      }

      y.c.d var25 = (y.c.d)var33;
      this.f.a(this.f.b(var25));
      this.h = new y.c.D();
      y.c.x var27 = this.a.o();

      while(true) {
         if(var27.f()) {
            var10 = var27.e();
            var10000 = this;
            if(var23) {
               break;
            }

            if(this.c.a(var10)) {
               y.c.d var29 = (y.c.d)var1.b(var10);
               y.f.h.p var30 = this.f.b(var29);
               this.h.add(var30);
            }

            var27.g();
            if(!var23) {
               continue;
            }
         }

         this.j();
         var10000 = this;
         break;
      }

      var9 = var10000.d.p();

      label186: {
         boolean var34;
         while(true) {
            if(var9.f()) {
               var28 = var9.a();
               var34 = this.f.g(var28.c());
               if(var23) {
                  break;
               }

               if(var34 && this.f.g(var28.d()) && !this.f.j(var28)) {
                  this.f.b(var28, 0);
               }

               var9.g();
               if(!var23) {
                  continue;
               }
            }

            y.g.o.a(this, 3, "-----> Center Edges:");
            this.m = this.a.u();
            var9 = this.a.p();
            var34 = var9.f();
            break;
         }

         while(var34) {
            this.m.a(var9.a(), 0.0D);
            var9.g();
            if(var23) {
               break label186;
            }

            if(var23) {
               break;
            }

            var34 = var9.f();
         }

         this.d();
         this.a.a(var6);
         this.a.a(var1);
      }

      if(y.c.i.g) {
         o.p = !var23;
      }

   }

   private void a(y.f.f.b.h var1, y.f.f.b.h var2) {
      boolean var5 = o.p;
      y.c.C var3 = var1.i();

      while(var3.f()) {
         y.f.f.b.n var4 = (y.f.f.b.n)var3.d();
         var2.a(this.a(var4));
         var3.g();
         if(var5) {
            break;
         }
      }

   }

   private y.f.f.b.n a(y.f.f.b.n var1) {
      boolean var8 = o.p;
      y.c.q var2 = var1.a();
      y.c.q var3 = var1.b();
      A var5 = (A)this.j.b(var2);
      A var6 = (A)this.j.b(var3);
      y.f.f.b.o var7 = var1.e();
      y.f.f.b.n var4;
      if(var7 == y.f.f.b.o.c) {
         var4 = new y.f.f.b.n(var5.b(), var6.a(), var1.c(), var1.d(), var7);
         if(!var8) {
            return var4;
         }
      }

      if(var7 == y.f.f.b.o.a) {
         var4 = new y.f.f.b.n(var5.a(), var6.b(), var1.c(), var1.d(), var7);
         if(!var8) {
            return var4;
         }
      }

      if(var7 == y.f.f.b.o.b) {
         var4 = new y.f.f.b.n(var5.d(), var6.a(), var1.c(), var1.d(), var7);
         if(!var8) {
            return var4;
         }
      }

      var4 = new y.f.f.b.n(var5.a(), var6.d(), var1.c(), var1.d(), var7);
      return var4;
   }

   protected void d() {
      if(this.c.c()) {
         this.m();
         if(!o.p) {
            return;
         }
      }

      this.l();
   }

   private void h() {
      boolean var8 = o.p;
      y.c.x var1 = this.a.o();

      while(var1.f()) {
         label29: {
            y.c.q var2 = var1.e();
            if(!this.c.a(var2)) {
               y.c.q var3 = this.d.d();
               if(this.b.d(var2)) {
                  this.f.c(var3);
               }

               if(this.b.g(var2)) {
                  this.f.f(var3);
               }

               if(this.b.b(var2)) {
                  this.f.c(var3);
               }

               this.j.a(var2, new z(var3));
               if(!var8) {
                  break label29;
               }
            }

            B var9 = new B();
            y.c.q var4 = this.d.d();
            this.f.l(var4);
            var9.a(var4);
            y.c.q var5 = this.d.d();
            this.f.l(var5);
            var9.d(var5);
            y.c.q var6 = this.d.d();
            this.f.l(var6);
            var9.c(var6);
            y.c.q var7 = this.d.d();
            this.f.l(var7);
            var9.b(var7);
            this.j.a(var2, var9);
         }

         var1.g();
         if(var8) {
            break;
         }
      }

   }

   protected y.c.d a(y.c.q var1) {
      boolean var8 = o.p;
      if(var1.c() == 0) {
         return null;
      } else {
         short[] var2 = new short[]{(short)0, (short)0, (short)0, (short)0};
         int var3 = 4;
         y.c.d var5 = null;
         y.c.e var6 = var1.l();

         int var10000;
         int var10001;
         while(true) {
            if(var6.f()) {
               var5 = var6.a();
               int var7 = this.b.g(var5);
               var2[var7] = 1;
               var10000 = var7;
               var10001 = var3;
               if(var8) {
                  break;
               }

               if(var7 < var3) {
                  var3 = var7;
               }

               var6.g();
               if(!var8) {
                  continue;
               }
            }

            var10000 = var2[0] + var2[1] + var2[2] + var2[3];
            var10001 = 1;
            break;
         }

         boolean var4;
         y.c.d var9;
         if(var10000 != var10001) {
            var6 = var1.l();
            var4 = true;

            label70:
            while(true) {
               if(var4) {
                  var5 = var6.a();
                  var10000 = this.b.g(var5);
                  if(!var8) {
                     if(var10000 != var3) {
                        var4 = false;
                     }

                     var6.b();
                     if(!var8) {
                        continue;
                     }

                     var4 = true;
                  } else {
                     if(var10000 == var3) {
                        var4 = false;
                     }

                     var6.b();
                     if(var8) {
                        break;
                     }
                  }
               } else {
                  var4 = true;
               }

               while(true) {
                  if(!var4) {
                     break label70;
                  }

                  var9 = var6.a();
                  if(var8) {
                     return var9;
                  }

                  var5 = var9;
                  if(this.b.g(var5) == var3) {
                     var4 = false;
                  }

                  var6.b();
                  if(var8) {
                     break label70;
                  }
               }
            }

            var9 = var5;
            return var9;
         } else {
            var4 = true;
            var6 = var1.l();

            while(true) {
               if(var4) {
                  var9 = var6.a();
                  if(var8) {
                     break;
                  }

                  var5 = var9;
                  if(this.b.d(var5) == 4) {
                     var4 = false;
                  }

                  var6.b();
                  if(!var8) {
                     continue;
                  }
               }

               var9 = var5;
               break;
            }

            return var9;
         }
      }
   }

   private y.c.d a(y.c.q var1, y.c.q var2, y.c.q var3, int var4, double var5, int var7) {
      if(var2.equals(var3)) {
         return null;
      } else {
         y.f.f.b.o var9;
         y.c.d var10;
         y.c.d var12;
         label14: {
            y.f.f.b.o var8 = y.f.f.b.o.a(var4).a();
            var9 = y.f.f.b.o.a(var4).b();
            var10 = this.d.a(var2, var3);
            this.f.a(var10, var8.toString());
            this.f.b(var10, var5);
            this.f.b(var10, var7);
            y.c.e var11 = var3.l();
            if(!var11.f()) {
               var12 = this.d.a(var3, var2);
               if(!o.p) {
                  break label14;
               }
            }

            var11.g();
            y.c.d var13 = var11.a();
            var12 = this.d.a(var3, var13, var2, (y.c.d)null, 1, 0);
         }

         this.f.a(var12, var9.toString());
         this.f.b(var12, var5);
         this.f.b(var12, var7);
         this.f.a(var10, var12);
         return var12;
      }
   }

   private void i() {
      boolean var8 = o.p;
      y.c.x var1 = this.a.o();

      y var12;
      label58:
      while(true) {
         boolean var10000 = var1.f();

         label55:
         while(var10000) {
            y.c.q var2 = var1.e();
            int[] var3 = this.b.h(var2);
            var12 = this;
            if(var8) {
               break label58;
            }

            y.c.d var4 = this.a(var2);
            int var5 = 0;

            while(var5 < 4) {
               var10000 = false;
               if(var8) {
                  continue label55;
               }

               int var6 = 0;

               while(true) {
                  if(var6 < var3[var5]) {
                     y.c.q var7 = this.a(var4);
                     this.k.a(var4, var7);
                     var4 = this.b.b().j(var4);
                     ++var6;
                     if(var8) {
                        break;
                     }

                     if(!var8) {
                        continue;
                     }
                  }

                  ++var5;
                  break;
               }

               if(var8) {
                  break;
               }
            }

            var1.g();
            if(!var8) {
               continue label58;
            }
            break;
         }

         var12 = this;
         break;
      }

      y.c.e var9 = var12.a.p();

      while(var9.f()) {
         y.c.d var10 = var9.a();
         y.c.d var11 = this.b.a(var10);
         this.l.a(var10, this.k.b(var11));
         this.l.a(var11, this.k.b(var10));
         var9.g();
         if(var8) {
            break;
         }
      }

   }

   private y.c.q a(y.c.d var1) {
      y.c.q var2;
      if(!this.c.a(var1.c())) {
         A var3 = (A)this.j.b(var1.c());
         var2 = var3.a();
         if(!o.p) {
            return var2;
         }
      }

      var2 = this.d.d();
      this.f.e(var2);
      return var2;
   }

   private void j() {
      boolean var9 = o.p;
      y.c.x var1 = this.a.o();

      while(var1.f()) {
         y.c.q var2 = var1.e();
         if(this.c.a(var2)) {
            A var3 = (A)this.j.b(var2);
            y.c.q var4 = var3.a();
            y.c.q var5 = var3.c();
            int var6 = this.c.d(var2)?0:1;
            y.f.f.b.n var7 = new y.f.f.b.n(var4, var5, this.c.b(var2), var6, y.f.f.b.o.b);
            this.f.a(var7);
            y.f.f.b.n var8 = new y.f.f.b.n(var4, var5, this.c.c(var2), var6, y.f.f.b.o.c);
            this.f.a(var8);
         }

         var1.g();
         if(var9) {
            break;
         }
      }

   }

   private void k() {
      boolean var10 = o.p;
      y.f.h.q var1 = this.f.c();

      label24:
      while(var1.f()) {
         y.f.h.p var2 = var1.a();
         y.c.e var3 = var2.a();
         y.c.d var4 = var3.a();
         var3.g();
         y.c.d var5 = var3.a();

         while(true) {
            y.c.d var6 = var3.a();
            y.f.f.b.o var7 = this.f.h(var4).c();
            int var8 = var7.f();
            int var9 = this.f.g(var6);
            this.f.a(var6, y.f.f.b.o.a(var9 - var8).f());
            var4 = var6;
            var3.b();

            while(var3.a() == var5) {
               var1.g();
               if(!var10) {
                  if(var10) {
                     return;
                  }
                  continue label24;
               }
            }
         }
      }

   }

   private void l() {
      boolean var19 = o.p;
      y.g.o.a(this, 1, "Do not center edges !");
      y.c.x var1 = this.a.o();

      do {
         int var10000 = var1.f();

         label60:
         while(true) {
            if(var10000 == 0) {
               return;
            }

            y.c.q var2 = var1.e();
            if(!this.c.a(var2)) {
               break;
            }

            int[][] var3 = this.b.i(var2);
            int var4 = 0;

            while(true) {
               if(var4 >= 4) {
                  break label60;
               }

               y.f.f.b.o var5 = y.f.f.b.o.a(var4);
               int[] var6 = var3[var4];
               int var7 = var6[0] + var6[1] + var6[2];
               var10000 = var7;
               if(var19) {
                  break;
               }

               if(var7 != 0) {
                  y.c.f var8 = new y.c.f();
                  y.c.f var9 = new y.c.f();
                  y.c.d var20 = this.a(var2, var5, var8, var9, var6);

                  label55:
                  while(true) {
                     y.c.d var10 = var20;
                     y.c.f var11 = new y.c.f();
                     var11.a(var8.a());
                     var11.add(var10);
                     var11.a(var9.a());
                     int var12 = var5.e()?62:95;
                     y.c.d var13 = null;
                     y.c.e var14 = var11.a();

                     while(true) {
                        if(!var14.f()) {
                           break label55;
                        }

                        y.c.d var15 = var13;
                        var13 = var14.a();
                        var20 = var15;
                        if(var19) {
                           break;
                        }

                        if(var15 != null) {
                           y.c.q var16 = (y.c.q)this.k.b(var15);
                           y.c.q var17 = (y.c.q)this.k.b(var13);
                           y.f.f.b.n var18 = new y.f.f.b.n(var16, var17, 1, 1, y.f.f.b.o.a((char)var12));
                           this.f.a(var18);
                        }

                        var14.g();
                        if(var19) {
                           break label55;
                        }
                     }
                  }
               }

               ++var4;
               if(var19) {
                  break label60;
               }
            }
         }

         var1.g();
      } while(!var19);

   }

   private void m() {
      boolean var30 = o.p;
      y.c.c var1 = this.b.a().c(y.f.f.b.e.a);
      y.c.c var2 = this.b.a().c((Object)"MIN_DIST_DP_KEY");
      boolean var3 = this.c instanceof d && var1 != null;
      y.c.x var4 = this.a.o();

      do {
         int var10000 = var4.f();

         label125:
         while(true) {
            if(var10000 == 0) {
               return;
            }

            y.c.q var5 = var4.e();
            if(!this.c.a(var5)) {
               break;
            }

            A var6 = (A)this.j.b(var5);
            int[][] var7 = this.b.i(var5);
            int var8 = 0;

            while(true) {
               if(var8 >= 4) {
                  break label125;
               }

               y.f.f.b.o var9 = y.f.f.b.o.a(var8);
               int[] var10 = var7[var8];
               int var11 = var10[0] + var10[1] + var10[2];
               var10000 = var11;
               if(var30) {
                  break;
               }

               if(var11 != 0) {
                  y.c.f var12 = new y.c.f();
                  y.c.f var13 = new y.c.f();
                  y.c.d var14 = this.a(var5, var9, var12, var13, var10);
                  var13.n();
                  int var15 = 0;
                  int var16 = 0;
                  if(var9.e()) {
                     var16 = this.c.e(var5);
                     var15 = this.c.b(var5);
                  }

                  if(var9.d()) {
                     var16 = this.c.f(var5);
                     var15 = this.c.c(var5);
                  }

                  int var17 = (int)this.c.b();
                  int var18 = (int)Math.ceil((double)var16 / (double)var17);
                  int var19 = var16;
                  int var20 = var16;
                  int var21 = var18;
                  int var22 = var18;
                  if(var2 != null && this.b.d(var5)) {
                     f var23 = (f)var2.b(var5);
                     if(var23 != null) {
                        label145: {
                           double var24 = (double)this.i / (double)var17;
                           if(var9.e()) {
                              var19 = var16 + (int)Math.floor((double)var23.c() / var24);
                              var20 = var16 + (int)Math.floor((double)var23.d() / var24);
                              if(!var30) {
                                 break label145;
                              }
                           }

                           if(var9.d()) {
                              var19 += (int)Math.floor((double)var23.a() / var24);
                              var20 += (int)Math.floor((double)var23.b() / var24);
                           }
                        }
                     }

                     var21 = (int)Math.ceil((double)var19 / (double)var17);
                     var22 = (int)Math.ceil((double)var20 / (double)var17);
                  }

                  int var31 = (int)Math.floor((double)(var15 - var21 - var22) * 0.5D);
                  this.a(var12, var6, var15, var31, var17, var20 + var19, var21, true);
                  if(var14 != null) {
                     label105: {
                        if(var3 && var1.b(var5) != null) {
                           int var28;
                           int var29;
                           label95: {
                              S var32 = (S)var1.b(var5);
                              aG var25 = var32.f();
                              y.f.f.b.o var26 = this.b.c(var14)?var9.c():var9;
                              boolean var27 = var26 == y.f.f.b.o.a || var26 == y.f.f.b.o.b;
                              var28 = var31 + var18;
                              var29 = var31 + var18;
                              if(!var25.l() && !var25.m()) {
                                 var28 = var27?0:2 * var28;
                                 var29 = var27?2 * var29:0;
                                 if(!var30) {
                                    break label95;
                                 }
                              }

                              if(var25.l()) {
                                 var28 = var27?2 * var28:0;
                                 var29 = var27?0:2 * var29;
                              }
                           }

                           this.a(var14, var6, var28, var29);
                           if(!var30) {
                              break label105;
                           }
                        }

                        this.a(var14, var6, var31 + var21, var31 + var22);
                     }
                  }

                  this.a(var13, var6, var15, var31, var17, var20 + var19, var21, false);
               }

               ++var8;
               if(var30) {
                  break label125;
               }
            }
         }

         var4.g();
      } while(!var30);

   }

   private void a(y.c.f var1, A var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      boolean var22 = o.p;
      int var9 = var1.size();
      if(var9 != 0) {
         int var10;
         int[] var11;
         double var12;
         int var15;
         int var16;
         label91: {
            var10 = var8?1:-1;
            var11 = new int[var4 + 1];
            var12 = 1.0D;
            if(var4 > 0) {
               int var14 = (int)Math.ceil((double)var9 / (double)var4);
               var15 = var14 * var4 - var9;
               var11[0] = (int)Math.ceil((double)var14 * 0.5D);
               var11[var4] = (int)Math.floor((double)var14 * 0.5D);
               var16 = 1;

               label71: {
                  while(var16 < var4) {
                     var11[var16] = var14;
                     ++var16;
                     if(var22) {
                        break label71;
                     }

                     if(var22) {
                        break;
                     }
                  }

                  var16 = 0;
               }

               label81: {
                  while(var16 < var15) {
                     --var11[var16];
                     ++var16;
                     if(var22) {
                        break label81;
                     }

                     if(var22) {
                        break;
                     }
                  }

                  var12 = (double)var5 / (double)var14;
               }

               if(!var22) {
                  break label91;
               }
            }

            var11[0] = var9;
            if(var3 == 0) {
               var12 = 0.0D;
               if(!var22) {
                  break label91;
               }
            }

            var12 = (double)(var3 * var5 - var6) / ((double)var9 * 2.0D);
         }

         y.c.e var23 = var1.a();
         var15 = var7 + var4;
         var16 = 0;

         while(var16 < var11.length) {
            double var17 = 0.0D;
            if(var16 > 0) {
               var17 = (double)(-((int)Math.ceil((double)(var11[var16] - 1) / 2.0D))) * var12;
            }

            if(var16 == var11.length - 1) {
               var17 = (double)(-var11[var16]) * var12;
            }

            int var19 = 0;

            while(true) {
               if(var19 < var11[var16]) {
                  y.c.d var20 = var23.a();
                  int var21 = var15 - var10 * (var4 - var16);
                  this.a(var20, var2, var21, var3 - var21);
                  var23.g();
                  this.m.a(var20, (double)var10 * var17);
                  this.m.a(this.b.a(var20), (double)var10 * var17);
                  var17 += var12;
                  ++var19;
                  if(var22) {
                     break;
                  }

                  if(!var22) {
                     continue;
                  }
               }

               ++var16;
               break;
            }

            if(var22) {
               break;
            }
         }

      }
   }

   private void a(y.c.d var1, A var2, int var3, int var4) {
      y.f.f.b.n var5 = null;
      y.f.f.b.n var6 = null;
      y.c.q var7 = (y.c.q)this.k.b(var1);
      y.f.f.b.o var8 = this.b.h(var1);
      if(var8.a(y.f.f.b.o.d)) {
         var5 = new y.f.f.b.n(var2.a(), var7, var3, 1, y.f.f.b.o.c);
         var6 = new y.f.f.b.n(var7, var2.b(), var4, 1, y.f.f.b.o.c);
      }

      if(var8.a(y.f.f.b.o.b)) {
         var5 = new y.f.f.b.n(var2.d(), var7, var3, 1, y.f.f.b.o.c);
         var6 = new y.f.f.b.n(var7, var2.c(), var4, 1, y.f.f.b.o.c);
      }

      if(var8.a(y.f.f.b.o.a)) {
         var5 = new y.f.f.b.n(var2.a(), var7, var3, 1, y.f.f.b.o.b);
         var6 = new y.f.f.b.n(var7, var2.d(), var4, 1, y.f.f.b.o.b);
      }

      if(var8.a(y.f.f.b.o.c)) {
         var5 = new y.f.f.b.n(var2.b(), var7, var3, 1, y.f.f.b.o.b);
         var6 = new y.f.f.b.n(var7, var2.c(), var4, 1, y.f.f.b.o.b);
      }

      this.f.a(var5);
      this.f.a(var6);
   }

   protected y.c.d a(y.c.q var1, y.f.f.b.o var2, y.c.f var3, y.c.f var4, int[] var5) {
      boolean var13 = o.p;
      var3.clear();
      var4.clear();
      y.c.d var6 = null;
      y.c.e var7 = var1.a(this.a(var1));
      int var8 = 0;
      int var9 = var5[0] + var5[1] + var5[2];
      if(var9 == 0) {
         return null;
      } else {
         y.c.f var10 = new y.c.f();
         y.c.f var11 = new y.c.f();

         boolean var10000;
         while(true) {
            if(var8 < var9) {
               y.c.d var12 = var7.a();
               var10000 = this.b.h(var12).a(var2);
               if(var13) {
                  break;
               }

               if(var10000) {
                  label70: {
                     if(var8 < var5[2]) {
                        var10.add(var12);
                        if(!var13) {
                           break label70;
                        }
                     }

                     if(var8 == var5[2] && var5[1] == 1) {
                        var6 = var12;
                        if(!var13) {
                           break label70;
                        }
                     }

                     var11.add(var12);
                  }

                  ++var8;
               }

               var7.b();
               if(!var13) {
                  continue;
               }
            }

            var10000 = var2.a(y.f.f.b.o.d);
            break;
         }

         label74: {
            if(var10000 || var2.a(y.f.f.b.o.c)) {
               var10.n();
               var11.n();
               var3.a(var11.a());
               var4.a(var10.a());
               if(!var13) {
                  break label74;
               }
            }

            var3.a(var10.a());
            var4.a(var11.a());
         }

         if(var6 == null) {
            if(var3.size() > var4.size()) {
               var6 = var3.c();
               var3.h(var3.l());
               if(!var13) {
                  return var6;
               }
            }

            var6 = var4.b();
            var4.h(var4.k());
         }

         return var6;
      }
   }

   public void a(y.c.A var1, X var2) {
      boolean var29 = o.p;
      y.g.o.a(this, "Grid: " + this.i);
      double var3 = (double)this.i;
      double var5 = (double)this.i;
      int var7 = Integer.MAX_VALUE;
      int var8 = Integer.MIN_VALUE;
      int var9 = Integer.MAX_VALUE;
      int var10 = Integer.MIN_VALUE;
      y.c.x var11 = this.d.o();

      y.c.q var12;
      y.d.t var13;
      while(true) {
         if(var11.f()) {
            var12 = var11.e();
            var13 = (y.d.t)var1.b(var12);
            var7 = Math.min(var7, (int)var13.a());
            var8 = Math.max(var8, (int)var13.a());
            var9 = Math.min(var9, (int)var13.b());
            var10 = Math.max(var10, (int)var13.b());
            var11.g();
            if(var29) {
               break;
            }

            if(!var29) {
               continue;
            }
         }

         this.n = var8 - var7;
         this.o = var10 - var9;
         this.p = 0;
         break;
      }

      y.c.e var30 = this.a.p();

      y.d.t var14;
      boolean var10000;
      y.c.d var32;
      while(true) {
         if(var30.f()) {
            var32 = var30.a();
            var13 = (y.d.t)var1.b(this.k.b(var32));
            var14 = (y.d.t)var1.b(this.l.b(var32));
            var10000 = this.b.h(var32).a(y.f.f.b.o.b);
            if(var29) {
               break;
            }

            if(var10000) {
               this.p = (int)((double)this.p + (var14.a() - var13.a()));
            }

            if(this.b.h(var32).a(y.f.f.b.o.c)) {
               this.p = (int)((double)this.p + (var14.b() - var13.b()));
            }

            var30.g();
            if(!var29) {
               continue;
            }
         }

         var10000 = r;
         break;
      }

      y.d.t var15;
      y.c.q var34;
      label120: {
         if(var10000) {
            y.c.A var31 = this.d.t();
            y.c.x var33 = this.d.o();

            while(var33.f()) {
               var34 = var33.e();
               var14 = (y.d.t)var1.b(var34);
               var15 = new y.d.t(var14.a() * var3, var14.b() * var5);
               y.f.x var16 = new y.f.x();
               var16.setSize(20.0D, 20.0D);
               var16.a(var15.a(), var15.b());
               this.e.a(var34, (am)var16);
               var31.a(var34, "" + var34.d());
               var33.g();
               if(var29) {
                  break label120;
               }

               if(var29) {
                  break;
               }
            }

            this.d.a(var31);
         }

         y.g.o.a(this, 3, "Merging nodes:");
      }

      var11 = this.a.o();

      while(true) {
         if(var11.f()) {
            var12 = var11.e();
            A var35 = (A)this.j.b(var12);
            var14 = (y.d.t)var1.b(var35.a());
            var15 = (y.d.t)var1.b(var35.c());
            double var38 = (var15.a() - var14.a()) * var3;
            double var18 = (var15.b() - var14.b()) * var5;
            var10000 = this.b.d(var12);
            if(var29) {
               break;
            }

            if(!var10000) {
               var2.b(var12, 0.0D, 0.0D);
            }

            if(this.g) {
               var2.a(var12, new y.d.q(var38 + var3 / 2.0D, var18 + var5 / 2.0D));
            }

            y.d.q var20 = var2.r(var12);
            double var21 = var20.a();
            double var23 = var20.b();
            double var25 = var14.a() * var3 + (var38 - var21) / 2.0D;
            double var27 = var14.b() * var5 + (var18 - var23) / 2.0D;
            var2.b(var12, new y.d.t(var25, var27));
            var11.g();
            if(!var29) {
               continue;
            }
         }

         var10000 = this.s;
         break;
      }

      if(var10000) {
         this.a(var2);
      }

      var30 = this.a.p();

      y var39;
      while(true) {
         if(var30.f()) {
            var32 = var30.a();
            var34 = var32.c();
            y.c.q var36 = var32.d();
            double var37 = 0.0D;
            double var17 = 0.0D;
            var39 = this;
            if(var29) {
               break;
            }

            label89: {
               if(this.b.h(var32).e()) {
                  var37 = this.m.c(var32) * (double)this.i / this.c.b();
                  if(!var29) {
                     break label89;
                  }
               }

               var17 = this.m.c(var32) * (double)this.i / this.c.b();
            }

            y.d.t var19 = (y.d.t)var1.b(this.k.b(var32));
            y.d.t var40 = new y.d.t(var19.a() * var3 + var37, var19.b() * var5 + var17);
            y.d.t var41 = (y.d.t)var1.b(this.l.b(var32));
            y.d.t var22 = new y.d.t(var41.a() * var3 + var37, var41.b() * var5 + var17);
            if(!this.g) {
               if(this.b.h(var32).a(y.f.f.b.o.d)) {
                  var40 = new y.d.t(var2.m(var34), var40.b());
                  var22 = new y.d.t(var2.m(var36) + var2.p(var36), var22.b());
               }

               if(this.b.h(var32).a(y.f.f.b.o.b)) {
                  var40 = new y.d.t(var2.m(var34) + var2.p(var34), var40.b());
                  var22 = new y.d.t(var2.m(var36), var22.b());
               }

               if(this.b.h(var32).a(y.f.f.b.o.a)) {
                  var40 = new y.d.t(var40.a(), var2.n(var34));
                  var22 = new y.d.t(var22.a(), var2.n(var36) + var2.q(var36));
               }

               if(this.b.h(var32).a(y.f.f.b.o.c)) {
                  var40 = new y.d.t(var40.a(), var2.n(var34) + var2.q(var34));
                  var22 = new y.d.t(var22.a(), var2.n(var36));
               }
            }

            label83: {
               if(this.b.d(var34)) {
                  var2.c(var32, var40);
                  if(!var29) {
                     break label83;
                  }
               }

               var2.a(var34, var40);
            }

            label78: {
               if(this.b.d(var36)) {
                  var2.d(var32, var22);
                  if(!var29) {
                     break label78;
                  }
               }

               var2.a(var36, var22);
            }

            var30.g();
            if(!var29) {
               continue;
            }
         }

         this.a.a(this.j);
         this.a.a(this.m);
         this.a.a(this.k);
         this.a.a(this.l);
         var39 = this;
         break;
      }

      var39.c.d();
   }

   private void a(X var1) {
      boolean var18 = o.p;
      y.c.f var2 = new y.c.f();
      y.f.h.D var3 = (y.f.h.D)this.b.b();
      y.c.e var4 = this.a.p();

      y.c.d var5;
      boolean var10000;
      while(true) {
         if(var4.f()) {
            var5 = var4.a();
            var10000 = var3.n(var5);
            if(var18) {
               break;
            }

            if(!var10000 && this.a(var5, var1) && var3.e(var5.c()) && var3.e(var5.d())) {
               var2.add(var5);
            }

            var4.g();
            if(!var18) {
               continue;
            }
         }

         var4 = var2.a();
         var10000 = var4.f();
         break;
      }

      while(var10000) {
         var5 = var4.a();
         y.c.e var6 = var5.c().k();
         y.c.d var19 = var6.a();

         label123:
         while(var19 != null) {
            if(var3.n(var6.a())) {
               var6.b();
            }

            y.c.d var7 = var6.a();
            y.c.d var8 = var3.h(var7);
            var6 = var5.d().l();
            if(var6.a() == null) {
               break;
            }

            if(var3.n(var6.a())) {
               var6.b();
            }

            y.c.d var9 = var6.a();
            y.c.d var10 = var3.h(var9);
            if(var3.f(var7.c()) && var3.f(var9.d()) || !var3.f(var7.c()) && !var3.f(var9.d())) {
               break;
            }

            if(!var3.f(var7.c())) {
               var7 = var9;
               var8 = var10;
            }

            var3.h(var5.c());
            y.c.d var11 = var3.h(var5.d());
            var3.e(var11);
            y.c.d var12 = var3.h(var11);
            this.m.a(var11, this.m.c(var7));
            this.m.a(var12, this.m.c(var7));
            this.b.a(var11, this.b.e(var7));
            this.b.a(var12, this.b.e(var8));
            this.k.a(var11, this.k.b(var7));
            this.l.a(var11, this.l.b(var7));
            this.l.a(var12, this.k.b(var7));
            this.k.a(var12, this.l.b(var7));
            y.c.d var13 = var11;

            y.c.d var14;
            y.c.e var15;
            y.c.d var16;
            y.c.d var17;
            label141: {
               label104:
               while(var3.b(var13.c())) {
                  var14 = var3.d(var13);
                  var15 = var13.c().a(var13);
                  var15.b();
                  var19 = var15.a();
                  if(var18) {
                     var13 = var19;
                     break label141;
                  }

                  var16 = var19;

                  while(var3.d(var3.h(var16)) != var14) {
                     var15.b();
                     var16 = var15.a();
                     if(var18) {
                        continue label104;
                     }

                     if(var18) {
                        break;
                     }
                  }

                  var17 = var3.h(var16);
                  this.m.a(var17, this.m.c(var7));
                  this.m.a(var16, this.m.c(var7));
                  var13 = var17;
                  if(var18) {
                     break;
                  }
               }

               var13 = var11;
            }

            while(true) {
               label119:
               while(true) {
                  if(!var3.b(var13.d())) {
                     break label123;
                  }

                  var14 = var3.d(var13);
                  var15 = var13.d().a(var13);
                  var15.b();
                  var19 = var15.a();
                  if(var18) {
                     continue label123;
                  }

                  var16 = var19;

                  while(true) {
                     if(var3.d(var16) == var14) {
                        break label119;
                     }

                     var15.b();
                     var16 = var15.a();
                     if(var18) {
                        break;
                     }

                     if(var18) {
                        break label119;
                     }
                  }
               }

               var17 = var3.h(var16);
               this.m.a(var16, this.m.c(var7));
               this.m.a(var17, this.m.c(var7));
               var13 = var16;
               if(var18) {
                  break label123;
               }
            }
         }

         var4.g();
         if(var18) {
            break;
         }

         var10000 = var4.f();
      }

   }

   private boolean a(y.c.d var1, X var2) {
      return var2.m(var1.c()) == var2.m(var1.d()) && var2.n(var1.c()) == var2.n(var1.d());
   }

   public int e() {
      return this.n;
   }

   public int f() {
      return this.o;
   }

   public int g() {
      return this.p;
   }
}
