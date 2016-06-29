package y.f.d;

import java.awt.geom.Rectangle2D.Double;
import y.f.I;
import y.f.K;
import y.f.M;
import y.f.R;
import y.f.X;
import y.f.aj;
import y.f.al;
import y.f.am;
import y.f.d.a;
import y.f.d.v;
import y.f.d.w;
import y.f.d.x;
import y.f.d.y;
import y.f.d.z;

class u {
   private X a;
   private y.c.D b;
   private double c = 15.0D;
   private double d = 60.0D;
   private double e = 5.0D;
   private boolean f = true;
   private boolean g = true;
   private boolean h = true;
   private y.f.b.c i;

   public void a(boolean var1) {
      this.h = var1;
   }

   public void a(double var1) {
      this.e = var1;
   }

   public void b(boolean var1) {
      this.g = var1;
   }

   public void c(boolean var1) {
      this.f = var1;
   }

   public void b(double var1) {
      this.d = var1;
   }

   public void c(double var1) {
      this.c = var1;
   }

   public void a(X var1, y.c.c var2) {
      int var6 = a.f;
      this.a = var1;
      if(var1.c(y.f.b.f.d) != null) {
         this.i = new y.f.b.c(var1);
      }

      this.a(var2);
      y.c.D var3 = this.d(this.g);
      var3.sort(new v(this));
      y.c.C var4 = var3.m();

      while(true) {
         if(var4.f()) {
            z var5 = (z)var4.d();
            this.c(var5);
            var4.g();
            if(var6 != 0) {
               break;
            }

            if(var6 == 0) {
               continue;
            }
         }

         if(this.i != null) {
            this.i.c();
            this.i = null;
         }
         break;
      }

   }

   private boolean a(aj var1) {
      al var2 = var1.a();
      return var2 instanceof M;
   }

   private boolean a(y.f.C var1) {
      y.f.E var2 = var1.getLabelModel();
      return var2 instanceof K;
   }

   private boolean a(y.c.q var1, aj var2) {
      y.d.y var3 = this.a((R)var2, (Object)var1);
      return this.a.s(var1).b(var3) && !(var2 instanceof M);
   }

   private void a(y.c.c var1) {
      int var11 = a.f;
      this.b = new y.c.D();
      y.c.x var2 = this.a.o();

      u var10000;
      while(true) {
         if(var2.f()) {
            y.c.q var3 = var2.e();
            var10000 = this;
            if(var11 != 0) {
               break;
            }

            label114: {
               if(this.i == null || !this.i.d(var3)) {
                  this.b.add(new z(this, var3, var3, (byte)0, false));
                  aj[] var4 = this.a.a_(var3);
                  int var5 = 0;

                  while(var5 < var4.length) {
                     aj var6 = var4[var5];
                     if(var11 != 0) {
                        break label114;
                     }

                     boolean var7 = (var1 == null || var1.d(var6)) && this.a(var6) && !this.a(var3, var6);
                     this.b.add(new z(this, var6, var3, (byte)2, var7));
                     ++var5;
                     if(var11 != 0) {
                        break;
                     }
                  }
               }

               var2.g();
            }

            if(var11 == 0) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var12 = var10000.a.p();

      label70:
      while(var12.f()) {
         y.c.d var13 = var12.a();
         y.d.v var14 = this.a.l(var13);
         y.d.u var15 = var14.b();
         y.d.t var16 = var15.a();
         var15.g();

         while(var15.f()) {
            y.d.t var17 = var15.a();
            y.d.m var8 = new y.d.m(var16, var17);
            this.b.add(new z(this, var8, var13, (byte)1, false));
            var16 = var17;
            var15.g();
            if(var11 != 0) {
               continue label70;
            }

            if(var11 != 0) {
               break;
            }
         }

         y.f.C[] var18 = this.a.d(var13);
         int var19 = 0;

         while(true) {
            if(var19 < var18.length) {
               y.f.C var9 = var18[var19];
               if(var11 != 0) {
                  break;
               }

               boolean var10 = (var1 == null || var1.d(var9)) && this.a(var9);
               this.b.add(new z(this, var9, var13, (byte)3, var10));
               ++var19;
               if(var11 == 0) {
                  continue;
               }
            }

            var12.g();
            break;
         }

         if(var11 != 0) {
            break;
         }
      }

   }

   private double a(z var1) {
      y.d.y var2 = var1.h();
      double var3 = Math.sqrt(var2.a() * var2.a() + var2.b() * var2.b());
      return this.c + var3 * 0.5D;
   }

   private y.c.D a(y.d.n var1, z var2) {
      int var9 = a.f;
      y.c.D var3 = new y.c.D();
      double var4 = this.a(var2);
      y.c.C var6 = this.b.m();

      while(var6.f()) {
         z var7 = (z)var6.d();
         if(var7 != var2) {
            label23: {
               if(var7.c == 1) {
                  y.d.m var8 = (y.d.m)var7.a;
                  if(!y.d.n.a(var1, var8, var4)) {
                     break label23;
                  }

                  var3.add(var7);
                  if(var9 == 0) {
                     break label23;
                  }
               }

               if(y.d.n.a(var1, var7.h(), var4)) {
                  var3.add(var7);
               }
            }
         }

         var6.g();
         if(var9 != 0) {
            break;
         }
      }

      return var3;
   }

   private y.c.D d(boolean var1) {
      int var5 = a.f;
      y.d.f.a(this.b, new y(this));
      y.c.D var2 = new y.c.D();
      y.c.C var3 = this.b.m();

      while(var3.f()) {
         z var4 = (z)var3.d();
         if(var4.a() && var4.e && (!var1 || var4.d > 0)) {
            var2.add(var4);
         }

         var3.g();
         if(var5 != 0) {
            break;
         }
      }

      return var2;
   }

   private y.d.t b(z var1) {
      y.d.y var2 = var1.h();
      y.d.t var3 = new y.d.t(var2.c() + var2.a() * 0.5D, var2.d() + var2.b() * 0.5D);
      if(var1.c == 3) {
         y.c.d var7 = (y.c.d)var1.b;
         y.d.v var5 = this.a.l(var7);
         double[] var6 = w.a(var5, var3);
         return new y.d.t(var6[0], var6[1]);
      } else if(var1.c == 2) {
         y.c.q var4 = (y.c.q)var1.b;
         return this.a.l(var4);
      } else {
         return var3;
      }
   }

   private y.d.n a(y.d.t var1, y.d.t var2, R var3) {
      if(this.h && this.b(var3)) {
         return null;
      } else {
         y.d.n var4;
         if(var1.equals(var2)) {
            var4 = new y.d.n(var1.a() - this.d, var1.b() + this.d, 2.0D * this.d, 2.0D * this.d);
            if(a.f == 0) {
               return var4;
            }
         }

         y.d.z var5 = new y.d.z(var2, var1);
         double var6 = var5.d();
         double var8 = Math.max(this.d - var6, 0.0D);
         var5.c();
         y.d.z var10 = y.d.z.c(var5);
         y.d.t var11 = y.d.z.a(var1, new y.d.z(-var10.a() * this.d, -var10.b() * this.d));
         if(var8 > 0.0D) {
            var11 = y.d.z.a(var11, new y.d.z(-var5.a() * var8, -var5.b() * var8));
         }

         var4 = new y.d.n(var11, new y.d.q(this.d + var8, 2.0D * this.d), var5);
         if(this.h && this.d > var6 && this.a(var3)) {
            var4 = new y.d.n(var11, new y.d.q(var6 + var8, 2.0D * this.d), var5);
         }

         return var4;
      }
   }

   private boolean a(R var1) {
      if(!(var1 instanceof y.f.C)) {
         return false;
      } else {
         y.f.C var2 = (y.f.C)var1;
         byte var3 = var2.getPreferredPlacementDescriptor().b();
         return var3 == 16 || var3 == 32;
      }
   }

   private boolean b(R var1) {
      if(var1 instanceof y.f.C) {
         y.f.C var2 = (y.f.C)var1;
         byte var3 = var2.getPreferredPlacementDescriptor().b();
         return var3 == 8;
      } else {
         return false;
      }
   }

   private boolean c(z var1) {
      R var2 = (R)var1.a;
      y.d.y var3 = var1.h();
      y.d.t var4 = new y.d.t(var3.c() + var3.a() * 0.5D, var3.d() + var3.b() * 0.5D);
      y.d.t var5 = this.b(var1);
      y.d.n var6 = this.a(var4, var5, var2);
      if(var6 == null) {
         return false;
      } else {
         y.c.D var7 = this.a(var6, var1);
         x var8 = this.a(var7);
         x var9 = a(this.d(var1), this.c);
         var6 = new y.d.n(var6.b() / this.c, var6.c() / this.c, var6.e() / this.c, var6.f() / this.c, var6.g(), var6.i());
         int var10 = (int)Math.floor(var4.a / this.c);
         int var11 = (int)Math.floor(var4.b / this.c);
         int var12 = (int)Math.max(1.0D, Math.ceil(this.e / this.c));
         int var13 = (int)Math.floor(this.d / this.c);
         boolean var14 = var9.a(var8, var10, var11, var12, var13, var6, this.f);
         if(var14) {
            double var15 = var4.a() + (double)var9.a() * this.c;
            double var17 = var4.b() + (double)var9.b() * this.c;
            this.a(var2, var15, var17, var1.b);
         }

         return var14;
      }
   }

   private void a(R var1, double var2, double var4, Object var6) {
      if(var1 instanceof y.f.C) {
         y.f.C var7 = (y.f.C)var1;
         y.f.E var8 = var7.getLabelModel();
         y.c.d var9 = (y.c.d)var6;
         I var10 = this.a.b(var9);
         am var11 = this.a.a((Object)var9.c());
         am var12 = this.a.a((Object)var9.d());
         y.d.n var13 = new y.d.n(var1.getOrientedBox());
         var13.e(var2, var4);
         Object var14 = var8.a(var13, var10, var11, var12);
         var7.setModelParameter(var14);
         if(a.f == 0) {
            return;
         }
      }

      if(var1 instanceof aj) {
         aj var16 = (aj)var1;
         y.d.n var17 = new y.d.n(var1.getOrientedBox());
         var17.e(var2, var4);
         al var18 = var16.a();
         Object var15 = var18.a(var17, this.a.a(var6));
         var16.setModelParameter(var15);
      }

   }

   private y.d.y a(R var1, Object var2) {
      y.d.n var5;
      if(var1 instanceof y.f.C) {
         y.f.C var6 = (y.f.C)var1;
         y.c.d var7 = (y.c.d)var2;
         var5 = var6.getLabelModel().a(var6.getOrientedBox().d(), this.a.b(var7), this.a.a((Object)var7.c()), this.a.a((Object)var7.d()), var6.getModelParameter());
         return var5.h();
      } else if(var1 instanceof aj) {
         aj var3 = (aj)var1;
         y.c.q var4 = (y.c.q)var2;
         var5 = var3.a().a(var3.getOrientedBox().d(), this.a.a((Object)var4), var3.getModelParameter());
         return var5.h();
      } else {
         return null;
      }
   }

   private y.d.n d(z var1) {
      if(!var1.a()) {
         return null;
      } else {
         y.d.q var4;
         y.d.n var5;
         if(var1.a instanceof y.f.C) {
            y.f.C var6 = (y.f.C)var1.a;
            y.c.d var7 = (y.c.d)var1.b;
            var4 = var6.getOrientedBox().d();
            var5 = var6.getLabelModel().a(var4, this.a.b(var7), this.a.a((Object)var7.c()), this.a.a((Object)var7.d()), var6.getModelParameter());
            return var5;
         } else if(var1.a instanceof aj) {
            aj var2 = (aj)var1.a;
            y.c.q var3 = (y.c.q)var1.b;
            var4 = var2.getOrientedBox().d();
            var5 = var2.a().a(var4, this.a.a((Object)var3), var2.getModelParameter());
            return var5;
         } else {
            return null;
         }
      }
   }

   private x a(y.c.D var1) {
      int var11 = a.f;
      int var2 = Integer.MAX_VALUE;
      int var3 = Integer.MIN_VALUE;
      int var4 = Integer.MAX_VALUE;
      int var5 = Integer.MIN_VALUE;
      Double var6 = new Double();
      y.c.C var7 = var1.m();

      while(true) {
         if(var7.f()) {
            z var8 = (z)var7.d();
            y.d.y var9 = var8.h();
            var6.setFrame(var9.c(), var9.d(), var9.a(), var9.b());
            var2 = Math.min((int)Math.floor(var6.x / this.c), var2);
            var4 = Math.min((int)Math.floor(var6.y / this.c), var4);
            var3 = Math.max((int)Math.floor((var6.x + var6.width) / this.c), var3);
            var5 = Math.max((int)Math.floor((var6.y + var6.height) / this.c), var5);
            var7.g();
            if(var11 != 0) {
               break;
            }

            if(var11 == 0) {
               continue;
            }
         }

         var2 -= 2;
         var4 -= 2;
         var3 += 2;
         var5 += 2;
         break;
      }

      x var12 = new x(var2, var4, var3 - var2, var5 - var4);
      y.c.C var13 = var1.m();

      while(var13.f()) {
         label45: {
            z var14 = (z)var13.d();
            if(var14.c == 1) {
               y.d.m var10 = (y.d.m)var14.a;
               a(var12, var10, this.c);
               if(var11 == 0) {
                  break label45;
               }
            }

            if(var14.c == 0) {
               y.d.y var15 = var14.h();
               a(var12, var15, this.c);
               if(var11 == 0) {
                  break label45;
               }
            }

            a(var12, this.d(var14), this.c);
         }

         var13.g();
         if(var11 != 0) {
            break;
         }
      }

      return var12;
   }

   static void a(x var0, y.d.n var1, double var2) {
      var0.a(a(var1, var2));
   }

   static x a(y.d.n var0, double var1) {
      int var12 = a.f;
      y.d.y var3 = var0.h();
      int var6 = (int)(Math.floor(var3.c / var1) - 2.0D);
      int var7 = (int)(Math.floor(var3.d / var1) - 2.0D);
      int var8 = (int)(Math.floor((var3.c + var3.a) / var1) + 2.0D);
      int var9 = (int)(Math.floor((var3.d + var3.b) / var1) + 2.0D);
      x var10 = new x(var6, var7, var8 - var6, var9 - var7);
      y.d.t[] var11 = y.d.n.a(var0);
      a(var10, var11[0], var11[1], var1);
      a(var10, var11[1], var11[2], var1);
      a(var10, var11[2], var11[3], var1);
      a(var10, var11[3], var11[0], var1);
      var10.c();
      if(var12 != 0) {
         y.c.i.g = !y.c.i.g;
      }

      return var10;
   }

   static void a(x var0, y.d.y var1, double var2) {
      Double var4 = new Double();
      var4.setFrame(var1.c(), var1.d(), var1.a(), var1.b());
      var0.a((int)Math.floor(var4.x / var2), (int)Math.floor(var4.y / var2), 1 + (int)Math.floor((var4.x + var4.width) / var2), 1 + (int)Math.floor((var4.y + var4.height) / var2));
   }

   static void a(x var0, y.d.m var1, double var2) {
      a(var0, var1.c(), var1.d(), var2);
   }

   static void a(x var0, y.d.t var1, y.d.t var2, double var3) {
      double var5;
      double var7;
      double var9;
      double var11;
      double var13;
      double var15;
      double var17;
      int var38;
      label175: {
         var38 = a.f;
         var5 = var1.a;
         var7 = var1.b;
         var9 = var2.a;
         var11 = var2.b;
         var13 = var9 - var5;
         var15 = var11 - var7;
         var17 = 0.1D;
         if(var3 > 1.0D) {
            int var19 = 1 + (int)Math.rint(var3);

            while(var19 > 0) {
               var17 /= 10.0D;
               var19 /= 10;
               if(var38 != 0) {
                  break label175;
               }

               if(var38 != 0) {
                  break;
               }
            }
         }

         var17 = Math.min(var17, 1.0E-5D);
      }

      int var21;
      double var39;
      label163: {
         var39 = 0.1D;
         if(var3 > 1.0D) {
            var21 = 1 + (int)Math.rint(var3);

            while(var21 > 0) {
               var39 /= 10.0D;
               var21 /= 10;
               if(var38 != 0) {
                  break label163;
               }

               if(var38 != 0) {
                  break;
               }
            }
         }

         var39 = Math.min(var39, 1.0E-5D);
         var21 = (int)Math.floor(var5 / var3);
      }

      label190: {
         int var22 = (int)Math.floor(var7 / var3);
         int var23 = (int)Math.floor(var9 / var3);
         int var24 = (int)Math.floor(var11 / var3);
         int var25 = var23 - var21;
         int var26 = var24 - var22;
         if(var25 == 0 || Math.abs(var13) < var17) {
            var0.a(var21, Math.min(var22, var24), var21 + 1, Math.max(var22, var24) + 1);
            if(var38 == 0) {
               break label190;
            }
         }

         if(var26 == 0 || Math.abs(var15) < var39) {
            var0.a(Math.min(var21, var23), var22, Math.max(var21, var23) + 1, var22 + 1);
            if(var38 == 0) {
               break label190;
            }
         }

         int var10000;
         int var10001;
         double var27;
         double var29;
         double var31;
         double var33;
         int var35;
         int var36;
         int var37;
         if(Math.abs(var13) > Math.abs(var15)) {
            if(var21 > var23) {
               var27 = var15 / var13;
               var29 = var11;
               var31 = (Math.floor(var9 / var3) + 1.0D - (double)var23) * var27 + var11;
               var33 = var3 * var27;
               var35 = var23;

               while(true) {
                  if(var35 < var21) {
                     var36 = (int)Math.floor(var29 / var3);
                     var37 = (int)Math.floor(var31 / var3);
                     var0.a(var35, var36, true);
                     var10000 = var36;
                     var10001 = var37;
                     if(var38 != 0) {
                        break;
                     }

                     if(var36 != var37 && var35 < var21) {
                        var0.a(var35, var37, true);
                     }

                     var29 = var31;
                     var31 += var33;
                     ++var35;
                     if(var38 == 0) {
                        continue;
                     }
                  }

                  var35 = (int)Math.floor(var29 / var3);
                  var0.a(var21, var35, true);
                  var10000 = var35;
                  var10001 = var22;
                  break;
               }

               if(var10000 == var10001) {
                  break label190;
               }

               var0.a(var21, var22, true);
               if(var38 == 0) {
                  break label190;
               }
            }

            var27 = var15 / var13;
            var29 = var7;
            var31 = (Math.floor(var5 / var3) + 1.0D - (double)var21) * var27 + var7;
            var33 = var3 * var27;
            var35 = var21;

            label119: {
               while(var35 < var23) {
                  var36 = (int)Math.floor(var29 / var3);
                  var37 = (int)Math.floor(var31 / var3);
                  var0.a(var35, var36, true);
                  var10000 = var36;
                  var10001 = var37;
                  if(var38 != 0) {
                     break label119;
                  }

                  if(var36 != var37) {
                     var0.a(var35, var37, true);
                  }

                  var29 = var31;
                  var31 += var33;
                  ++var35;
                  if(var38 != 0) {
                     break;
                  }
               }

               var35 = (int)Math.floor(var29 / var3);
               var0.a(var23, var35, true);
               var10000 = var35;
               var10001 = var24;
            }

            if(var10000 == var10001) {
               break label190;
            }

            var0.a(var23, var24, true);
            if(var38 == 0) {
               break label190;
            }
         }

         if(var22 > var24) {
            var27 = var13 / var15;
            var29 = var9;
            var31 = (Math.floor(var11 / var3) + 1.0D - (double)var24) * var27 + var9;
            var33 = var3 * var27;
            var35 = var24;

            label98: {
               while(var35 < var22) {
                  var36 = (int)Math.floor(var29 / var3);
                  var37 = (int)Math.floor(var31 / var3);
                  var0.a(var36, var35, true);
                  var10000 = var36;
                  var10001 = var37;
                  if(var38 != 0) {
                     break label98;
                  }

                  if(var36 != var37) {
                     var0.a(var37, var35, true);
                  }

                  var29 = var31;
                  var31 += var33;
                  ++var35;
                  if(var38 != 0) {
                     break;
                  }
               }

               var35 = (int)Math.floor(var29 / var3);
               var0.a(var35, var22, true);
               var10000 = var35;
               var10001 = var21;
            }

            if(var10000 == var10001) {
               break label190;
            }

            var0.a(var21, var22, true);
            if(var38 == 0) {
               break label190;
            }
         }

         var27 = var13 / var15;
         var29 = var5;
         var31 = (Math.floor(var7 / var3) + 1.0D - (double)var22) * var27 + var5;
         var33 = var3 * var27;
         var35 = var22;

         label82: {
            while(var35 < var24) {
               var36 = (int)Math.floor(var29 / var3);
               var37 = (int)Math.floor(var31 / var3);
               var0.a(var36, var35, true);
               var10000 = var36;
               var10001 = var37;
               if(var38 != 0) {
                  break label82;
               }

               if(var36 != var37) {
                  var0.a(var37, var35, true);
               }

               var29 = var31;
               var31 += var33;
               ++var35;
               if(var38 != 0) {
                  break;
               }
            }

            var35 = (int)Math.floor(var29 / var3);
            var0.a(var35, var24, true);
            var10000 = var35;
            var10001 = var23;
         }

         if(var10000 != var10001) {
            var0.a(var23, var24, true);
         }
      }

      if(y.c.i.g) {
         ++var38;
         a.f = var38;
      }

   }

   static y.d.y a(u var0, R var1, Object var2) {
      return var0.a(var1, var2);
   }

   static X a(u var0) {
      return var0.a;
   }
}
