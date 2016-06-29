package y.f.g;

import java.awt.geom.Rectangle2D.Double;
import java.util.Iterator;
import java.util.SortedSet;
import y.f.X;
import y.f.g.d;
import y.f.g.p;
import y.f.g.q;
import y.f.g.r;
import y.f.g.t;
import y.f.g.u;
import y.f.g.w;
import y.f.g.y;

class n {
   private X a;
   private double b = 10.0D;
   private int c = Integer.MAX_VALUE;
   private int d = 10;
   private int e = 15;
   private int f = 200;
   private boolean g = false;
   private y.f.b.c h;
   private y.c.D i;
   private boolean j = true;
   private boolean k = false;
   private boolean l = false;
   private long m = 1000L;
   private long n;
   private boolean o = true;
   private boolean p = false;
   private boolean q = true;
   private boolean r = true;

   public void a(boolean var1) {
      this.r = var1;
   }

   public void b(boolean var1) {
      this.q = var1;
   }

   public void c(boolean var1) {
      this.p = var1;
   }

   public void a(int var1) {
      this.f = var1;
   }

   public void d(boolean var1) {
      this.o = var1;
   }

   public boolean a() {
      return this.j;
   }

   public void a(long var1) {
      this.m = var1;
   }

   public boolean b() {
      return this.k;
   }

   public boolean c() {
      return this.l;
   }

   public void b(int var1) {
      this.e = var1;
   }

   public boolean d() {
      return this.g;
   }

   public void c(int var1) {
      this.c = var1;
   }

   private int a(y var1) {
      int var2 = this.c == Integer.MAX_VALUE?Integer.MAX_VALUE:(int)Math.floor((double)this.c / this.b);
      if(var1 != null) {
         var2 = Math.min(var2, var1.c());
      }

      return var2;
   }

   public void a(X var1, y.c.c var2, y.c.c var3, y.c.y var4, y var5, SortedSet var6, boolean var7) {
      boolean var12 = d.d;
      this.n = System.currentTimeMillis();
      this.a = var1;
      if(var1.c(y.f.b.f.d) != null) {
         this.h = new y.f.b.c(var1);
      }

      this.i = new y.c.D();
      this.i.add(new w(this, var4, var4, false, var3));
      y.c.y var8 = new y.c.y();
      y.c.x var9 = var1.o();

      boolean var10000;
      while(true) {
         if(var9.f()) {
            y.c.q var10 = var9.e();
            var10000 = var2.d(var10);
            if(var12) {
               break;
            }

            if(var10000) {
               var8.add(var10);
            }

            var9.g();
            if(!var12) {
               continue;
            }
         }

         this.i.add(new w(this, var8, var8, true, var3));
         var10000 = this.c();
         break;
      }

      if(!var10000 || !this.a() || !this.b()) {
         y.c.C var13 = this.i.m();

         while(var13.f()) {
            w var14 = (w)var13.d();
            if(var12) {
               return;
            }

            if(!var14.b() && this.e()) {
               label64: {
                  if(var6 != null && !var6.isEmpty()) {
                     q var11 = this.a(var14, var5, var6, var7);
                     if(var11 != null) {
                        if(!this.o || var11 == null) {
                           break label64;
                        }

                        this.a(var14, var11);
                        if(!var12) {
                           break label64;
                        }
                     }

                     this.b(var14, var5);
                     if(!var12) {
                        break label64;
                     }
                  }

                  this.b(var14, var5);
               }

               if(this.o && !this.g) {
                  this.a(var14, var5);
               }
            }

            var13.g();
            if(var12) {
               break;
            }
         }
      }

      if(this.h != null) {
         this.h.c();
         this.h = null;
      }

   }

   private void a(w var1, q var2) {
      boolean var8 = d.d;
      y.d.y var3 = var1.a();
      y.d.t var4 = new y.d.t(var3.c + 0.5D * var3.a, var3.d + 0.5D * var3.b);
      if(!var2.d.isEmpty()) {
         y.c.C var5 = var2.d.m();

         while(var5.f()) {
            label18: {
               u var6 = (u)var5.d();
               y.d.m var7 = var6.m();
               if(var7.c().a() == var7.d().a()) {
                  var1.a(var7.c().a() - var4.a(), 0.0D);
                  if(!var8) {
                     break label18;
                  }
               }

               var1.a(0.0D, var7.c().b() - var4.b());
            }

            var5.g();
            if(var8) {
               break;
            }
         }
      }

   }

   private void a(w var1, y var2) {
      boolean var7 = d.d;
      if(var2 != null && var2.a != null && !var2.c) {
         y.d.y var3 = var2.a;
         y.d.t var4 = new y.d.t(var3.c + 0.5D * var3.a, var3.d + 0.5D * var3.b);
         y.d.y var5 = var1.a();
         y.d.t var6 = new y.d.t(var5.c + 0.5D * var5.a, var5.d + 0.5D * var5.b);
         if(!var3.b(var5)) {
            label47: {
               if(var3.a() < var5.a()) {
                  var1.a(var4.a - var6.a, 0.0D);
                  if(!var7) {
                     break label47;
                  }
               }

               if(var3.c > var5.c) {
                  var1.a(var3.c - var5.c, 0.0D);
                  if(!var7) {
                     break label47;
                  }
               }

               if(var3.c + var3.a < var5.c + var5.a) {
                  var1.a(var3.c + var3.a - var5.c - var5.a, 0.0D);
               }
            }

            if(var3.b() < var5.b()) {
               var1.a(0.0D, var4.b - var6.b);
               if(!var7) {
                  return;
               }
            }

            if(var3.d > var5.d) {
               var1.a(0.0D, var3.d - var5.d);
               if(!var7) {
                  return;
               }
            }

            if(var3.d + var3.b < var5.d + var5.b) {
               var1.a(0.0D, var3.d + var3.b - var5.d - var5.b);
            }
         }

      }
   }

   private boolean e() {
      return System.currentTimeMillis() - this.n < this.m;
   }

   private q a(w var1, y var2, SortedSet var3, boolean var4) {
      y.d.y var5 = var1.a();
      double var6 = this.b;
      if(this.q) {
         this.b = (double)((int)Math.ceil(Math.sqrt((var5.b() + (double)(2 * this.e)) * (var5.a() + (double)(2 * this.e)) / 150.0D)));
      }

      if(var2 != null) {
         var2.a(var5, this.b);
         if(!this.g && (var2 == null || !var2.c) && var2.b()) {
            return null;
         }
      }

      y.d.t var8 = new y.d.t(var5.c + 0.5D * var5.a, var5.d + 0.5D * var5.b);
      y.c.D var9 = this.a((y)null, (w)var1);
      r var10 = this.a(var9, false);
      y.c.D var11 = this.a(var1);
      r var12 = this.a(var11, true);
      int var13 = (int)Math.floor(var8.a / this.b);
      int var14 = (int)Math.floor(var8.b / this.b);
      int var15 = (int)Math.max(1.0D, Math.ceil((double)this.d / this.b));
      int var16 = this.a(var2);
      y.c.D[] var17 = this.a(var16, var3, var13, var14);
      y.c.D var18 = this.a(var17[1]);
      boolean var19 = !this.g && (var2 == null || !var2.c) && (var12.a * var12.b < 150 || this.q);
      q var20 = var12.a(var10, var13, var14, var15, var16, var19, var2, var17[0], var18, var4);
      if(var20 != null) {
         var1.a((double)var12.a() * this.b, (double)var12.b() * this.b);
      }

      if(this.q) {
         this.b = var6;
      }

      return var20;
   }

   private y.c.D[] a(int var1, SortedSet var2, int var3, int var4) {
      boolean var23 = d.d;
      y.c.D[] var5 = new y.c.D[]{new y.c.D(), new y.c.D()};
      int var6 = 0;
      int var7 = 0;
      Iterator var8 = var2.iterator();

      while(var8.hasNext()) {
         y.d.m var9;
         boolean var10;
         label85: {
            var9 = (y.d.m)var8.next();
            var10 = false;
            if(var9.c().a() == var9.d().a()) {
               ++var7;
               var10 = var7 < 100;
               if(!var23) {
                  break label85;
               }
            }

            if(var9.c().b() == var9.d().b()) {
               ++var6;
               var10 = var6 < 100;
               if(!var23) {
                  break label85;
               }
            }

            throw new RuntimeException("found non horizontal/vertical line segment!");
         }

         if(var10) {
            u var11;
            double var12;
            double var14;
            double var16;
            double var18;
            label63: {
               var11 = a(var9, this.b);
               var12 = Math.min(var11.c().a, var11.d().a);
               var14 = Math.max(var11.c().a, var11.d().a);
               var16 = Math.min(var11.c().b, var11.d().b);
               var18 = Math.max(var11.c().b, var11.d().b);
               if(var1 < Integer.MAX_VALUE) {
                  boolean var20 = (double)(var3 - var1) > var14 || (double)(var3 + var1) < var12 || (double)(var4 - var1) > var18 || (double)(var4 + var1) < var16;
                  if(var20) {
                     break label63;
                  }

                  var5[0].add(var11);
                  if(!var23) {
                     break label63;
                  }
               }

               var5[0].add(var11);
            }

            double var24 = Math.floor((double)this.f / this.b);
            boolean var22 = (double)var3 - var24 > var14 || (double)var3 + var24 < var12 || (double)var4 - var24 > var18 || (double)var4 + var24 < var16;
            if(!var22) {
               var5[1].add(var11);
               if(!var23) {
                  continue;
               }
               break;
            }
         }
      }

      return var5;
   }

   private y.c.D a(y.c.D var1) {
      p var2 = new p(this);
      y.d.f.a(var1, var2);
      return var2.a();
   }

   private boolean b(w var1, y var2) {
      double var3 = this.b;
      y.d.y var5 = var1.a();
      if(this.q) {
         this.b = (double)((int)Math.ceil(Math.sqrt((var5.b() + (double)(2 * this.e)) * (var5.a() + (double)(2 * this.e)) / 150.0D)));
      }

      if(var2 != null) {
         var2.a(var5, this.b);
         if(!this.g && (var2 == null || !var2.c) && var2.b()) {
            return false;
         }
      }

      boolean var16;
      label42: {
         y.d.t var6 = new y.d.t(var5.c + 0.5D * var5.a, var5.d + 0.5D * var5.b);
         y.c.D var7 = this.a(var2, var1);
         r var8 = this.a(var7, false);
         y.c.D var9 = this.a(var1);
         r var10 = this.a(var9, true);
         int var11 = (int)Math.floor(var6.a / this.b);
         int var12 = (int)Math.floor(var6.b / this.b);
         int var13 = (int)Math.max(1.0D, Math.ceil((double)this.d / this.b));
         int var14 = this.a(var2);
         boolean var15 = !this.g && (var2 == null || !var2.c) && (var10.a * var10.b < 150 || this.q);
         var16 = var10.a(var8, var11, var12, var13, var14, var2, var15);
         if(var16) {
            var1.a((double)var10.a() * this.b, (double)var10.b() * this.b);
            if(!d.d) {
               break label42;
            }
         }

         if(var2 != null && (this.g || var2.c)) {
            var14 = this.a((y)null);
            var7 = this.a((y)null, (w)var1);
            var8 = this.a(var7, false);
            var2.a(false);
            var16 = var10.a(var8, var11, var12, var13, var14, var2, false);
            var2.a(true);
            if(var16) {
               var1.a((double)var10.a() * this.b, (double)var10.b() * this.b);
            }
         }
      }

      if(this.q) {
         this.b = var3;
      }

      return var16;
   }

   static u a(y.d.m var0, double var1) {
      int var3 = var0 instanceof u?((u)var0).l():100;
      y.d.t var4 = var0.c();
      y.d.t var5 = var0.d();
      y.d.t var6 = new y.d.t((double)((int)Math.floor(var4.a / var1)), (double)((int)Math.floor(var4.b / var1)));
      y.d.t var7 = new y.d.t((double)((int)Math.floor(var5.a / var1)), (double)((int)Math.floor(var5.b / var1)));
      return new u(var6, var7, var3, var0);
   }

   private y.c.D a(y var1, w var2) {
      boolean var9 = d.d;
      y.c.D var3 = new y.c.D();
      y.d.y var4 = var1 == null?null:var1.a;
      y.c.C var5 = this.i.m();

      do {
         boolean var10000 = var5.f();

         label71:
         while(true) {
            if(!var10000) {
               return var3;
            }

            w var6 = (w)var5.d();
            if(var6 == var2) {
               break;
            }

            y.c.C var7 = var6.c().m();

            while(true) {
               if(!var7.f()) {
                  break label71;
               }

               t var8 = (t)var7.d();
               var10000 = this.a();
               if(var9) {
                  break;
               }

               label81: {
                  if(!var10000 && var8.a()) {
                     if(var4 != null && !var8.a(var4)) {
                        break label81;
                     }

                     var3.add(var8);
                     if(!var9) {
                        break label81;
                     }
                  }

                  if(!this.c() && var8.c == 1) {
                     if(var4 != null && !var8.a(var4)) {
                        break label81;
                     }

                     var3.add(var8);
                     if(!var9) {
                        break label81;
                     }
                  }

                  if(!this.b() && var8.c == 0 && (var4 == null || var8.a(var4))) {
                     var3.add(var8);
                  }
               }

               var7.g();
               if(var9) {
                  break label71;
               }
            }
         }

         var5.g();
      } while(!var9);

      return var3;
   }

   private y.c.D a(w var1) {
      boolean var5 = d.d;
      y.c.D var2 = new y.c.D();
      y.c.C var3 = var1.c().m();

      while(var3.f()) {
         label39: {
            t var4 = (t)var3.d();
            if(!this.a() && var4.a()) {
               var2.add(var4);
               if(!var5) {
                  break label39;
               }
            }

            if(!this.c() && var4.c == 1) {
               var2.add(var4);
               if(!var5) {
                  break label39;
               }
            }

            if(!this.b() && var4.c == 0) {
               var2.add(var4);
            }
         }

         var3.g();
         if(var5) {
            break;
         }
      }

      return var2;
   }

   private r a(y.c.D var1, boolean var2) {
      boolean var14 = d.d;
      int var3 = Integer.MAX_VALUE;
      int var4 = Integer.MIN_VALUE;
      int var5 = Integer.MAX_VALUE;
      int var6 = Integer.MIN_VALUE;
      Double var7 = new Double();
      y.c.C var8 = var1.m();

      while(true) {
         if(var8.f()) {
            t var9 = (t)var8.d();
            if(var14) {
               break;
            }

            label87: {
               label97: {
                  if(var9.c == 1) {
                     y.d.v var10 = this.a.l((y.c.d)var9.a);
                     y.d.s var11 = var10.j();

                     do {
                        if(!var11.f()) {
                           break label97;
                        }

                        y.d.m var12 = var11.a();
                        var3 = Math.min(var3, (int)Math.floor(var12.c().a / this.b));
                        var4 = Math.max(var4, (int)Math.floor(var12.c().a / this.b));
                        var5 = Math.min(var5, (int)Math.floor(var12.c().b / this.b));
                        var6 = Math.max(var6, (int)Math.floor(var12.c().b / this.b));
                        var3 = Math.min(var3, (int)Math.floor(var12.d().a / this.b));
                        var4 = Math.max(var4, (int)Math.floor(var12.d().a / this.b));
                        var5 = Math.min(var5, (int)Math.floor(var12.d().b / this.b));
                        var6 = Math.max(var6, (int)Math.floor(var12.d().b / this.b));
                        var11.g();
                        if(var14) {
                           break label87;
                        }
                     } while(!var14);
                  }

                  y.d.y var17;
                  if(var2 && var9.c == 0) {
                     var17 = var9.h();
                     var7.setFrame(var17.c() - (double)this.e, var17.d() - (double)this.e, var17.a() + (double)(2 * this.e), var17.b() + (double)(2 * this.e));
                     var3 = Math.min((int)Math.floor(var7.x / this.b), var3);
                     var5 = Math.min((int)Math.floor(var7.y / this.b), var5);
                     var4 = Math.max((int)Math.floor((var7.x + var7.width) / this.b), var4);
                     var6 = Math.max((int)Math.floor((var7.y + var7.height) / this.b), var6);
                     if(!var14) {
                        break label97;
                     }
                  }

                  var17 = var9.h();
                  var7.setFrame(var17.c(), var17.d(), var17.a(), var17.b());
                  var3 = Math.min((int)Math.floor(var7.x / this.b), var3);
                  var5 = Math.min((int)Math.floor(var7.y / this.b), var5);
                  var4 = Math.max((int)Math.floor((var7.x + var7.width) / this.b), var4);
                  var6 = Math.max((int)Math.floor((var7.y + var7.height) / this.b), var6);
               }

               var8.g();
            }

            if(!var14) {
               continue;
            }
         }

         var3 -= 2;
         var5 -= 2;
         var4 += 2;
         var6 += 2;
         break;
      }

      r var15 = new r(this, var3, var5, var4 - var3, var6 - var5);
      y.c.C var16 = var1.m();

      byte var10000;
      while(true) {
         if(var16.f()) {
            t var18 = (t)var16.d();
            var10000 = var18.c;
            if(var14) {
               break;
            }

            label59: {
               label100: {
                  if(var10000 == 1) {
                     y.d.v var19 = this.a.l((y.c.d)var18.a);
                     y.d.s var21 = var19.j();

                     do {
                        if(!var21.f()) {
                           break label100;
                        }

                        y.d.m var13 = var21.a();
                        a(var15, var13.c().a, var13.c().b, var13.d().a, var13.d().b, this.b);
                        var21.g();
                        if(var14) {
                           break label59;
                        }
                     } while(!var14);
                  }

                  y.d.y var20;
                  if(var2 && var18.c == 0) {
                     var20 = var18.h();
                     var7.setFrame(var20.c() - (double)this.e, var20.d() - (double)this.e, var20.a() + (double)(2 * this.e), var20.b() + (double)(2 * this.e));
                     var15.a((int)Math.floor(var7.x / this.b), (int)Math.floor(var7.y / this.b), 1 + (int)Math.floor((var7.x + var7.width) / this.b), 1 + (int)Math.floor((var7.y + var7.height) / this.b));
                     if(!var14) {
                        break label100;
                     }
                  }

                  var20 = var18.h();
                  var7.setFrame(var20.c(), var20.d(), var20.a(), var20.b());
                  var15.a((int)Math.floor(var7.x / this.b), (int)Math.floor(var7.y / this.b), 1 + (int)Math.floor((var7.x + var7.width) / this.b), 1 + (int)Math.floor((var7.y + var7.height) / this.b));
               }

               var16.g();
            }

            if(!var14) {
               continue;
            }
         }

         var10000 = this.r;
         break;
      }

      if(var10000 == 0) {
         var15.c();
      }

      return var15;
   }

   static void a(r var0, double var1, double var3, double var5, double var7, double var9) {
      double var11;
      double var13;
      double var15;
      boolean var36;
      label171: {
         var36 = d.d;
         var11 = var5 - var1;
         var13 = var7 - var3;
         var15 = 0.1D;
         if(var9 > 1.0D) {
            int var17 = 1 + (int)Math.rint(var9);

            while(var17 > 0) {
               var15 /= 10.0D;
               var17 /= 10;
               if(var36) {
                  break label171;
               }

               if(var36) {
                  break;
               }
            }
         }

         var15 = Math.min(var15, 1.0E-5D);
      }

      int var19;
      double var37;
      label159: {
         var37 = 0.1D;
         if(var9 > 1.0D) {
            var19 = 1 + (int)Math.rint(var9);

            while(var19 > 0) {
               var37 /= 10.0D;
               var19 /= 10;
               if(var36) {
                  break label159;
               }

               if(var36) {
                  break;
               }
            }
         }

         var37 = Math.min(var37, 1.0E-5D);
         var19 = (int)Math.floor(var1 / var9);
      }

      int var20 = (int)Math.floor(var3 / var9);
      int var21 = (int)Math.floor(var5 / var9);
      int var22 = (int)Math.floor(var7 / var9);
      int var23 = var21 - var19;
      int var24 = var22 - var20;
      if(var23 == 0 || Math.abs(var11) < var15) {
         var0.a(var19, Math.min(var20, var22), var19 + 1, Math.max(var20, var22) + 1);
         if(!var36) {
            return;
         }
      }

      if(var24 == 0 || Math.abs(var13) < var37) {
         var0.a(Math.min(var19, var21), var20, Math.max(var19, var21) + 1, var20 + 1);
         if(!var36) {
            return;
         }
      }

      int var10000;
      int var10001;
      double var25;
      double var27;
      double var29;
      double var31;
      int var33;
      int var34;
      int var35;
      if(Math.abs(var11) > Math.abs(var13)) {
         if(var19 > var21) {
            var25 = var13 / var11;
            var27 = var7;
            var29 = (Math.floor(var5 / var9) + 1.0D - (double)var21) * var25 + var7;
            var31 = var9 * var25;
            var33 = var21;

            while(true) {
               if(var33 < var19) {
                  var34 = (int)Math.floor(var27 / var9);
                  var35 = (int)Math.floor(var29 / var9);
                  var0.a(var33, var34, true);
                  var10000 = var34;
                  var10001 = var35;
                  if(var36) {
                     break;
                  }

                  if(var34 != var35 && var33 < var19) {
                     var0.a(var33, var35, true);
                  }

                  var27 = var29;
                  var29 += var31;
                  ++var33;
                  if(!var36) {
                     continue;
                  }
               }

               var33 = (int)Math.floor(var27 / var9);
               var0.a(var19, var33, true);
               var10000 = var33;
               var10001 = var20;
               break;
            }

            if(var10000 == var10001) {
               return;
            }

            var0.a(var19, var20, true);
            if(!var36) {
               return;
            }
         }

         var25 = var13 / var11;
         var27 = var3;
         var29 = (Math.floor(var1 / var9) + 1.0D - (double)var19) * var25 + var3;
         var31 = var9 * var25;
         var33 = var19;

         label115: {
            while(var33 < var21) {
               var34 = (int)Math.floor(var27 / var9);
               var35 = (int)Math.floor(var29 / var9);
               var0.a(var33, var34, true);
               var10000 = var34;
               var10001 = var35;
               if(var36) {
                  break label115;
               }

               if(var34 != var35) {
                  var0.a(var33, var35, true);
               }

               var27 = var29;
               var29 += var31;
               ++var33;
               if(var36) {
                  break;
               }
            }

            var33 = (int)Math.floor(var27 / var9);
            var0.a(var21, var33, true);
            var10000 = var33;
            var10001 = var22;
         }

         if(var10000 == var10001) {
            return;
         }

         var0.a(var21, var22, true);
         if(!var36) {
            return;
         }
      }

      if(var20 > var22) {
         var25 = var11 / var13;
         var27 = var5;
         var29 = (Math.floor(var7 / var9) + 1.0D - (double)var22) * var25 + var5;
         var31 = var9 * var25;
         var33 = var22;

         label94: {
            while(var33 < var20) {
               var34 = (int)Math.floor(var27 / var9);
               var35 = (int)Math.floor(var29 / var9);
               var0.a(var34, var33, true);
               var10000 = var34;
               var10001 = var35;
               if(var36) {
                  break label94;
               }

               if(var34 != var35) {
                  var0.a(var35, var33, true);
               }

               var27 = var29;
               var29 += var31;
               ++var33;
               if(var36) {
                  break;
               }
            }

            var33 = (int)Math.floor(var27 / var9);
            var0.a(var33, var20, true);
            var10000 = var33;
            var10001 = var19;
         }

         if(var10000 == var10001) {
            return;
         }

         var0.a(var19, var20, true);
         if(!var36) {
            return;
         }
      }

      var25 = var11 / var13;
      var27 = var1;
      var29 = (Math.floor(var3 / var9) + 1.0D - (double)var20) * var25 + var1;
      var31 = var9 * var25;
      var33 = var20;

      label78: {
         while(var33 < var22) {
            var34 = (int)Math.floor(var27 / var9);
            var35 = (int)Math.floor(var29 / var9);
            var0.a(var34, var33, true);
            var10000 = var34;
            var10001 = var35;
            if(var36) {
               break label78;
            }

            if(var34 != var35) {
               var0.a(var35, var33, true);
            }

            var27 = var29;
            var29 += var31;
            ++var33;
            if(var36) {
               break;
            }
         }

         var33 = (int)Math.floor(var27 / var9);
         var0.a(var33, var22, true);
         var10000 = var33;
         var10001 = var21;
      }

      if(var10000 != var10001) {
         var0.a(var21, var22, true);
      }

   }

   static double a(n var0) {
      return var0.b;
   }

   static X b(n var0) {
      return var0.a;
   }

   static boolean c(n var0) {
      return var0.e();
   }

   static int d(n var0) {
      return var0.f;
   }
}
