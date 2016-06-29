package y.f;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import y.f.C;
import y.f.E;
import y.f.I;
import y.f.O;
import y.f.X;
import y.f.af;
import y.f.ag;
import y.f.aj;
import y.f.al;
import y.f.am;

public class ae {
   private static final y.d.v a = new y.d.v();
   private static final y.d.t b;

   public static byte a(X var0, y.c.c var1) {
      boolean var9 = X.j;
      int var2 = 0;
      int[] var3 = new int[4];
      y.c.e var4 = var0.p();

      while(var4.f()) {
         label42: {
            y.c.d var5 = var4.a();
            if(var1 == null || var1.d(var5)) {
               y.d.v var6 = var0.l(var5);
               var2 += var6.h() - 1;
               y.d.s var7 = var6.j();

               while(var7.f()) {
                  y.d.m var8 = var7.a();
                  a(var8, var3);
                  var7.g();
                  if(var9) {
                     break label42;
                  }

                  if(var9) {
                     break;
                  }
               }
            }

            var4.g();
         }

         if(var9) {
            break;
         }
      }

      return a(var3, var2);
   }

   public static boolean b(X var0, y.c.c var1) {
      return a(var0, var1, (byte)1);
   }

   private static boolean a(X var0, y.c.c var1, byte var2) {
      boolean var16 = X.j;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      y.c.e var6 = var0.p();

      while(true) {
         if(var6.f()) {
            y.c.d var7 = var6.a();
            if(var16) {
               break;
            }

            if(var1 == null || var1.d(var7)) {
               ++var3;
               y.d.v var8 = var0.l(var7);
               if(var8.h() == 2) {
                  ++var5;
               }

               byte var9 = 1;
               y.d.s var10 = var8.j();

               int var10000;
               label58: {
                  while(var10.f()) {
                     y.d.m var11 = var10.a();
                     double var12 = Math.abs(var11.j());
                     double var14 = Math.abs(var11.k());
                     double var17;
                     var10000 = (var17 = var12 - 1.0E-4D) == 0.0D?0:(var17 < 0.0D?-1:1);
                     if(var16) {
                        break label58;
                     }

                     if(var10000 > 0 && var14 > 1.0E-4D && (var2 == 1 || Math.abs(var12 - var14) > 1.0E-4D)) {
                        var9 = 0;
                        if(!var16) {
                           break;
                        }
                     }

                     var10.g();
                     if(var16) {
                        break;
                     }
                  }

                  var10000 = var9;
               }

               if(var10000 != 0) {
                  ++var4;
               }
            }

            var6.g();
            if(!var16) {
               continue;
            }
         }

         if(var4 == var3 || var4 > var5 && (double)var4 > 0.5D * (double)var3) {
            break;
         }

         return false;
      }

      return true;
   }

   private static byte a(int[] var0, int var1) {
      byte var2 = 2;
      byte var3 = 0;
      if(var0[var2] > var0[0]) {
         var2 = 0;
         var3 = 2;
      }

      if(var0[var2] > var0[3]) {
         var2 = 3;
         var3 = 1;
      }

      if(var0[var2] > var0[1]) {
         var2 = 1;
         var3 = 3;
      }

      return (double)var0[var3] > 0.3D * (double)var1 && var0[var3] > 5 * var0[var2]?var3:-1;
   }

   private static void a(y.d.m var0, int[] var1) {
      y.d.t var2;
      y.d.t var3;
      boolean var4;
      label23: {
         var4 = X.j;
         var2 = var0.c();
         var3 = var0.d();
         if(var2.a < var3.a) {
            ++var1[1];
            if(!var4) {
               break label23;
            }
         }

         if(var2.a > var3.a) {
            ++var1[3];
         }
      }

      if(var2.b < var3.b) {
         ++var1[0];
         if(!var4) {
            return;
         }
      }

      if(var2.b > var3.b) {
         ++var1[2];
      }

   }

   public static double a(X var0, y.c.q var1, y.c.q var2) {
      double var3 = var0.j(var1);
      double var5 = var0.k(var1);
      double var7 = var0.j(var2);
      double var9 = var0.k(var2);
      return y.d.t.a(var3, var5, var7, var9);
   }

   public static void a(I var0) {
      I var10000;
      label37: {
         boolean var4 = X.j;
         if(var0.pointCount() > 0) {
            ArrayList var1 = new ArrayList(var0.pointCount());
            int var2 = var0.pointCount() - 1;

            label33: {
               while(var2 >= 0) {
                  var1.add(var0.getPoint(var2));
                  --var2;
                  if(var4) {
                     break label33;
                  }

                  if(var4) {
                     break;
                  }
               }

               var0.clearPoints();
            }

            var2 = 0;

            while(var2 < var1.size()) {
               y.d.t var3 = (y.d.t)var1.get(var2);
               var10000 = var0;
               if(var4) {
                  break label37;
               }

               var0.addPoint(var3.a(), var3.b());
               ++var2;
               if(var4) {
                  break;
               }
            }
         }

         var10000 = var0;
      }

      y.d.t var5 = var10000.getSourcePoint();
      var0.setSourcePoint(var0.getTargetPoint());
      var0.setTargetPoint(var5);
   }

   public static void a(X var0) {
      a(var0, true);
   }

   public static void a(X var0, boolean var1) {
      boolean var4 = X.j;
      y.c.e var2;
      if(var1) {
         var2 = var0.p();

         do {
            if(!var2.f()) {
               return;
            }

            y.c.d var3 = var2.a();
            var0.a(var3, b);
            var0.b(var3, b);
            var0.b(var3, a);
            var2.g();
         } while(!var4);
      }

      var2 = var0.p();

      while(var2.f()) {
         var0.b(var2.a(), a);
         var2.g();
         if(var4) {
            break;
         }
      }

   }

   public static void a(X var0, y.c.d var1) {
      a(var0, var1, true);
   }

   public static void a(X var0, y.c.d var1, boolean var2) {
      if(var2) {
         var0.a(var1, b);
         var0.b(var1, b);
      }

      var0.b(var1, a);
   }

   public static void b(X var0) {
      boolean var2 = X.j;
      y.c.e var1 = var0.p();

      while(var1.f()) {
         b(var0, var1.a());
         var1.g();
         if(var2) {
            break;
         }
      }

   }

   public static void b(X var0, y.c.d var1) {
      boolean var8 = X.j;
      I var2 = var0.b(var1);
      boolean var3 = false;
      y.d.t var4 = var0.p(var1);
      if(var2.pointCount() > 0) {
         int var5 = 0;

         boolean var10000;
         y.d.t var6;
         label45: {
            while(var5 < var2.pointCount()) {
               var6 = var2.getPoint(var5);
               var10000 = var4.equals(var6);
               if(var8) {
                  break label45;
               }

               if(var10000) {
                  var3 = true;
                  if(!var8) {
                     break;
                  }
               }

               var4 = var6;
               ++var5;
               if(var8) {
                  break;
               }
            }

            var10000 = var3;
         }

         if(var10000 || var4.equals(var0.q(var1))) {
            y.c.D var9 = var0.m(var1);
            var6 = (y.d.t)var9.k().c();
            y.c.p var7 = var9.k().a();

            while(var7 != var9.l()) {
               if(var7.c().equals(var6)) {
                  var9.h(var7);
               }

               var6 = (y.d.t)var7.c();
               var7 = var7.a();
               if(var8) {
                  break;
               }
            }

            var0.a(var1, var9);
         }
      }

   }

   public static void a(X var0, y.c.d var1, double var2, double var4) {
      boolean var9 = X.j;
      I var6 = var0.b(var1);
      int var7 = var6.pointCount() - 1;

      while(var7 >= 0) {
         y.d.t var8 = var6.getPoint(var7);
         var6.setPoint(var7, var8.a + var2, var8.b + var4);
         --var7;
         if(var9) {
            break;
         }
      }

   }

   public static void a(X var0, y.c.q var1, double var2, double var4) {
      am var6 = var0.a((Object)var1);
      var6.setLocation(var6.getX() + var2, var6.getY() + var4);
   }

   public static void a(X var0, y.c.x var1, double var2, double var4) {
      boolean var9 = X.j;
      HashSet var6 = new HashSet();

      X var10000;
      while(true) {
         if(var1.f()) {
            var10000 = var0;
            if(var9) {
               break;
            }

            a(var0, var1.e(), var2, var4);
            var6.add(var1.e());
            var1.g();
            if(!var9) {
               continue;
            }
         }

         var10000 = var0;
         break;
      }

      y.c.e var7 = var10000.p();

      while(var7.f()) {
         y.c.d var8 = var7.a();
         if(var6.contains(var8.c()) && var6.contains(var8.d())) {
            a(var0, var8, var2, var4);
         }

         var7.g();
         if(var9) {
            break;
         }
      }

   }

   public static Rectangle2D a(X var0, y.c.x var1, y.c.e var2) {
      Rectangle2D var3 = a(var0, var1);
      Rectangle2D var4 = a(var0, var2);
      if(var3.getWidth() < 0.0D) {
         return var4;
      } else if(var4.getWidth() < 0.0D) {
         return var3;
      } else {
         var3.add(var4);
         return var3;
      }
   }

   public static Rectangle2D a(X var0, y.c.x var1) {
      boolean var11 = X.j;
      if(!var1.f()) {
         return new Double(0.0D, 0.0D, -1.0D, -1.0D);
      } else {
         double var2 = java.lang.Double.MAX_VALUE;
         double var4 = java.lang.Double.MAX_VALUE;
         double var6 = -1.7976931348623157E308D;
         double var8 = -1.7976931348623157E308D;

         while(var1.f()) {
            am var10 = var0.h(var1.e());
            var2 = Math.min(var2, var10.getX());
            var4 = Math.min(var4, var10.getY());
            var6 = Math.max(var6, var10.getX() + var10.getWidth());
            var8 = Math.max(var8, var10.getY() + var10.getHeight());
            var1.g();
            if(var11) {
               break;
            }
         }

         return new Double(var2, var4, var6 - var2, var8 - var4);
      }
   }

   public static Rectangle2D a(X var0, y.c.e var1) {
      boolean var14 = X.j;
      if(!var1.f()) {
         return new Double(0.0D, 0.0D, -1.0D, -1.0D);
      } else {
         y.d.t var2 = var0.p(var1.a());
         double var3 = var2.a;
         double var5 = var2.a;
         double var7 = var2.b;
         double var9 = var2.b;

         while(var1.f()) {
            y.c.d var11 = var1.a();
            I var12 = var0.g(var11);
            int var13 = var12.pointCount() - 1;

            while(true) {
               if(var13 >= 0) {
                  var2 = var12.getPoint(var13);
                  var3 = Math.min(var3, var2.a);
                  var5 = Math.max(var5, var2.a);
                  var7 = Math.min(var7, var2.b);
                  var9 = Math.max(var9, var2.b);
                  --var13;
                  if(var14) {
                     break;
                  }

                  if(!var14) {
                     continue;
                  }
               }

               var2 = var0.p(var11);
               var3 = Math.min(var3, var2.a);
               var5 = Math.max(var5, var2.a);
               var7 = Math.min(var7, var2.b);
               var9 = Math.max(var9, var2.b);
               var2 = var0.q(var11);
               var3 = Math.min(var3, var2.a);
               var5 = Math.max(var5, var2.a);
               var7 = Math.min(var7, var2.b);
               var9 = Math.max(var9, var2.b);
               var1.g();
               break;
            }

            if(var14) {
               break;
            }
         }

         return new Double(var3, var7, var5 - var3, var9 - var7);
      }
   }

   public static Rectangle2D a(X var0, y.c.x var1, y.c.e var2, boolean var3) {
      boolean var12 = X.j;
      Rectangle2D var4 = a(var0, var1, var2);
      if(var3) {
         var1.i();

         label48: {
            while(var1.f()) {
               aj[] var5 = var0.a_(var1.e());
               am var6 = var0.h(var1.e());
               if(var12) {
                  break label48;
               }

               label44: {
                  if(var5 != null && var5.length > 0) {
                     int var7 = 0;

                     while(var7 < var5.length) {
                        al var8 = var5[var7].a();
                        y.d.y var9 = var8.a(var5[var7].getOrientedBox().d(), var6, var5[var7].getModelParameter()).h();
                        var4.add(var9.c, var9.d);
                        var4.add(var9.c + var9.a, var9.d + var9.b);
                        ++var7;
                        if(var12) {
                           break label44;
                        }

                        if(var12) {
                           break;
                        }
                     }
                  }

                  var1.g();
               }

               if(var12) {
                  break;
               }
            }

            var2.i();
         }

         while(var2.f()) {
            label64: {
               C[] var13 = var0.d(var2.a());
               I var14 = var0.b(var2.a());
               am var15 = var0.a((Object)var2.a().c());
               am var16 = var0.a((Object)var2.a().d());
               if(var13 != null && var13.length > 0) {
                  int var17 = 0;

                  while(var17 < var13.length) {
                     E var10 = var13[var17].getLabelModel();
                     y.d.y var11 = var10.a(var13[var17].getOrientedBox().d(), var14, var15, var16, var13[var17].getModelParameter()).h();
                     var4.add(var11.c, var11.d);
                     var4.add(var11.c + var11.a, var11.d + var11.b);
                     ++var17;
                     if(var12) {
                        break label64;
                     }

                     if(var12) {
                        break;
                     }
                  }
               }

               var2.g();
            }

            if(var12) {
               break;
            }
         }
      }

      return var4;
   }

   public static void c(X var0) {
      boolean var4 = X.j;
      y.d.t var1 = y.d.t.c;
      y.c.e var2 = var0.p();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         var0.a(var3, var1);
         var0.b(var3, var1);
         var2.g();
         if(var4) {
            break;
         }
      }

   }

   public static y.d.v a(I var0, am var1, am var2) {
      return a(var0, var1, var2, 0.0D);
   }

   public static y.d.v c(X var0, y.c.d var1) {
      return a(var0.g(var1), var0.h(var1.c()), var0.h(var1.d()));
   }

   public static y.d.v a(I var0, am var1, am var2, double var3) {
      boolean var18 = X.j;
      y.d.t var5 = new y.d.t(var1.getX() - var3, var1.getY() - var3);
      y.d.q var6 = new y.d.q(var1.getWidth() + 2.0D * var3, var1.getHeight() + 2.0D * var3);
      y.d.t var7 = new y.d.t(var2.getX() - var3, var2.getY() - var3);
      y.d.q var8 = new y.d.q(var2.getWidth() + 2.0D * var3, var2.getHeight() + 2.0D * var3);
      ArrayList var9 = new ArrayList(var0.pointCount() + 2);
      y.d.t var10 = new y.d.t(var0.getSourcePoint().a() + var5.a() + var6.a() / 2.0D, var0.getSourcePoint().b() + var5.b() + var6.b() / 2.0D);
      var9.add(var10);
      int var11 = 0;

      while(var11 < var0.pointCount()) {
         var9.add(var0.getPoint(var11));
         ++var11;
         if(var18) {
            break;
         }
      }

      y.d.t var19 = new y.d.t(var0.getTargetPoint().a() + var7.a() + var8.a() / 2.0D, var0.getTargetPoint().b() + var7.b() + var8.b() / 2.0D);
      var9.add(var19);
      y.d.t var12 = (y.d.t)var9.get(0);
      y.d.t var13 = (y.d.t)var9.get(var9.size() - 1);
      ArrayList var14 = new ArrayList();
      int var15 = 0;

      while(a(var5, var6, (y.d.t)var9.get(var15))) {
         ++var15;
         if(var15 == var9.size()) {
            return new y.d.v();
         }
      }

      if(var15 > 0) {
         var14.add(a(var5, var6, (y.d.t)var9.get(var15 - 1), (y.d.t)var9.get(var15)));
      }

      int var16 = var9.size() - 1;

      int var10000;
      while(true) {
         if(var16 >= var15) {
            var10000 = a(var7, var8, (y.d.t)var9.get(var16));
            if(var18) {
               break;
            }

            if(var10000 != 0) {
               --var16;
               if(!var18) {
                  continue;
               }
            }
         }

         var10000 = var15;
         break;
      }

      int var17 = var10000;

      while(true) {
         if(var17 <= var16) {
            var14.add(var9.get(var17));
            ++var17;
            if(var18) {
               break;
            }

            if(!var18) {
               continue;
            }
         }

         if(var16 == var9.size() - 1) {
            return new y.d.v(var14);
         }
         break;
      }

      label45: {
         if(!var14.isEmpty()) {
            var14.add(a(var7, var8, (y.d.t)var9.get(var16 + 1), (y.d.t)var14.get(var14.size() - 1)));
            if(!var18) {
               break label45;
            }
         }

         var14 = var9;
      }

      y.d.v var20 = new y.d.v(var14);
      if(y.c.i.g) {
         X.j = !var18;
      }

      return var20;
   }

   public static void d(X var0) {
      boolean var3 = X.j;
      y.c.e var1 = var0.p();

      while(var1.f()) {
         y.c.d var2 = var1.a();
         d(var0, var2);
         var1.g();
         if(var3) {
            break;
         }
      }

   }

   public static void d(X var0, y.c.d var1) {
      y.d.v var2 = c(var0, var1);
      List var3 = var2.e();
      if(!var3.isEmpty()) {
         var0.c(var1, (y.d.t)var3.get(0));
         var0.d(var1, (y.d.t)var3.get(var3.size() - 1));
         var3.remove(var3.size() - 1);
         var3.remove(0);
         var0.b(var1, new y.d.v(var3));
      }

   }

   public static void a(X var0, y.c.d var1, y.c.d var2, double var3, boolean var5, double var6, double var8) {
      boolean var33 = X.j;
      int var10 = var0.l(var1).h();
      y.d.t[] var11 = new y.d.t[var10];
      int var14 = 0;
      y.c.C var15 = var0.l(var1).a();

      int var10000;
      while(true) {
         if(var15.f()) {
            y.d.t var16 = (y.d.t)var15.d();
            var10000 = var14;
            if(var33) {
               break;
            }

            if(var14 <= 0 || !var16.equals(var11[var14 - 1])) {
               label124: {
                  if(var14 > 1 && y.d.e.d(var11[var14 - 2], var11[var14 - 1], var16)) {
                     var11[var14 - 1] = new y.d.t(var16.a(), var16.b());
                     if(!var33) {
                        break label124;
                     }
                  }

                  var11[var14] = new y.d.t(var16.a(), var16.b());
                  ++var14;
               }
            }

            var15.g();
            if(!var33) {
               continue;
            }
         }

         var10 = var14;
         var10000 = var14;
         break;
      }

      if(var10000 >= 2) {
         y.d.t var12;
         y.d.t var18;
         y.c.D var34;
         label96: {
            var34 = new y.c.D();
            y.d.z var35 = new y.d.z(var11[1], var11[0]);
            y.d.z var17 = y.d.z.c(var35);
            var17.b(var3);
            var18 = y.d.z.a(var11[1], var17);
            if(var5) {
               y.d.z var19 = new y.d.z(var35);
               boolean var20 = true;
               double var21 = var19.d();
               double var23 = (var8 * var21 + var6) / var21;
               if(var10 == 2 && var23 > 0.5D) {
                  var23 = 0.5D;
               }

               var19.b(var23);
               var19.a(var17);
               if(var10 > 2) {
                  y.d.a var25 = new y.d.a(y.d.z.a(var11[1], var17), y.d.z.a(var11[0], var17));
                  y.d.z var26 = y.d.z.c(new y.d.z(var11[2], var11[1]));
                  var26.b(var3);
                  y.d.a var27 = new y.d.a(y.d.z.a(var11[2], var26), y.d.z.a(var11[1], var26));
                  y.d.t var28 = y.d.a.a(var25, var27);
                  if(var28 != null) {
                     y.d.z var29 = new y.d.z(var28, var11[0]);
                     if(var19.d() > var29.d()) {
                        var20 = false;
                        var18 = var28;
                     }
                  }
               }

               if(var20) {
                  var34.add(y.d.z.a(var11[0], var19));
               }

               var12 = var11[0];
               if(!var33) {
                  break label96;
               }
            }

            var12 = y.d.z.a(var11[0], var17);
         }

         y.d.a var37 = new y.d.a(var12, var18);
         int var38 = 1;

         y.d.z var22;
         y.d.z var36;
         while(true) {
            if(var38 < var10 - 1) {
               y.d.a var39 = var37;
               var22 = y.d.z.c(new y.d.z(var11[var38 + 1], var11[var38]));
               var36 = var22;
               if(var33) {
                  break;
               }

               var22.b(var3);
               y.d.t var42 = y.d.z.a(var11[var38], var22);
               y.d.t var24 = y.d.z.a(var11[var38 + 1], var22);
               var37 = new y.d.a(var42, var24);
               y.d.t var45 = y.d.a.a(var39, var37);
               if(var45 != null) {
                  var34.add(var45);
               }

               ++var38;
               if(!var33) {
                  continue;
               }
            }

            var36 = new y.d.z(var11[var10 - 1], var11[var10 - 2]);
            break;
         }

         y.d.t var13;
         label77: {
            y.d.z var40 = var36;
            y.d.z var41 = y.d.z.c(var40);
            var41.b(var3);
            if(var5) {
               var22 = new y.d.z(var40);
               boolean var43 = true;
               double var44 = var22.d();
               double var46 = (var8 * var44 + var6) / var44;
               if(var10 == 2 && var46 > 0.5D) {
                  var46 = 0.5D;
                  var43 = false;
               }

               var22.b(-var46);
               var22.a(var41);
               if(var10 > 2) {
                  y.d.z var47 = y.d.z.c(new y.d.z(var11[var10 - 2], var11[var10 - 3]));
                  var47.b(var3);
                  y.d.a var48 = new y.d.a(y.d.z.a(var11[var10 - 2], var47), y.d.z.a(var11[var10 - 3], var47));
                  y.d.a var30 = new y.d.a(y.d.z.a(var11[var10 - 1], var41), y.d.z.a(var11[var10 - 2], var41));
                  y.d.t var31 = y.d.a.a(var48, var30);
                  if(var31 != null) {
                     y.d.z var32 = new y.d.z(var31, var11[var10 - 1]);
                     if(var22.d() > var32.d()) {
                        var43 = false;
                     }
                  }
               }

               if(var43) {
                  var34.add(y.d.z.a(var11[var10 - 1], var22));
               }

               var13 = var11[var10 - 1];
               if(!var33) {
                  break label77;
               }
            }

            var13 = y.d.z.a(var11[var10 - 1], var41);
         }

         if(var1.c().equals(var2.c())) {
            var0.b(var2, var34);
            var0.a(var2, var12, var13);
            if(!var33) {
               return;
            }
         }

         var34.n();
         var0.b(var2, var34);
         var0.a(var2, var13, var12);
      }
   }

   public static void a(X var0, y.c.d var1, y.c.f var2, double var3, boolean var5, boolean var6, double var7, double var9) {
      boolean var17 = X.j;
      double var11 = var3;
      double var13 = 0.0D;
      if(var5 != 0 && var2.size() % 2 == 1) {
         var13 -= var3 * 0.5D;
      }

      y.c.e var15 = var2.a();

      int var10000;
      while(true) {
         if(var15.f()) {
            y.c.d var16 = var15.a();
            a(var0, var1, var16, var11 + var13, var6, var7, var9);
            double var18;
            var10000 = (var18 = var11 - 0.0D) == 0.0D?0:(var18 < 0.0D?-1:1);
            if(var17) {
               break;
            }

            if(var10000 < 0) {
               var11 -= var3;
            }

            var11 = -var11;
            var15.g();
            if(!var17) {
               continue;
            }
         }

         var10000 = var5;
         break;
      }

      if(var10000 != 0 && var2.size() % 2 == 1) {
         a(var0, var1, var1, -var3 * 0.5D, var6, var7, var9);
      }

   }

   public static void a(X var0, y.c.d var1, y.c.d var2) {
      var0.c(var1, var0.q(var2));
      var0.d(var1, var0.p(var2));
      var0.b(var1, var0.j(var2).g());
   }

   private static boolean a(y.d.t var0, y.d.q var1, y.d.t var2) {
      return var2.a >= var0.a && var2.b >= var0.b && var2.a <= var0.a + var1.a() && var2.b <= var0.b + var1.b();
   }

   private static y.d.t a(y.d.t var0, y.d.q var1, y.d.t var2, y.d.t var3) {
      java.awt.geom.Point2D.Double var4 = a(var0.a, var0.b, var1.a(), var1.b(), var2.a, var2.b, var3.a, var3.b, (java.awt.geom.Point2D.Double)null);
      return new y.d.t(var4.x, var4.y);
   }

   private static java.awt.geom.Point2D.Double a(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, java.awt.geom.Point2D.Double var16) {
      if(var16 == null) {
         var16 = new java.awt.geom.Point2D.Double();
      }

      if(var8 >= var0 && var10 >= var2 && var8 <= var0 + var4 && var10 <= var2 + var6) {
         double var17 = var12 - var8;
         double var19 = var14 - var10;
         if(var17 == 0.0D) {
            if(var19 < 0.0D) {
               var16.x = var8;
               var16.y = var2;
               return var16;
            } else {
               var16.x = var8;
               var16.y = var2 + var6;
               return var16;
            }
         } else if(var19 == 0.0D) {
            if(var17 < 0.0D) {
               var16.x = var0;
               var16.y = var10;
               return var16;
            } else {
               var16.x = var0 + var4;
               var16.y = var10;
               return var16;
            }
         } else {
            double var21 = var19 / var17;
            double var23;
            if(var17 > 0.0D) {
               var23 = var10 + var21 * (var0 + var4 - var8);
               if(var23 < var2) {
                  var16.x = var8 + (var2 - var10) / var21;
                  var16.y = var2;
                  return var16;
               } else if(var23 <= var2 + var6) {
                  var16.x = var0 + var4;
                  var16.y = var23;
                  return var16;
               } else {
                  var16.x = var8 + (var2 + var6 - var10) / var21;
                  var16.y = var2 + var6;
                  return var16;
               }
            } else {
               var23 = var10 + var21 * (var0 - var8);
               if(var23 < var2) {
                  var16.x = var8 + (var2 - var10) / var21;
                  var16.y = var2;
                  return var16;
               } else if(var23 <= var2 + var6) {
                  var16.x = var0;
                  var16.y = var23;
                  return var16;
               } else {
                  var16.x = var8 + (var2 + var6 - var10) / var21;
                  var16.y = var2 + var6;
                  return var16;
               }
            }
         }
      } else {
         var16.x = var8;
         var16.y = var10;
         return var16;
      }
   }

   public static int a(Rectangle2D[] var0, Rectangle2D var1, double var2) {
      return a(var0, var1, var2, 1);
   }

   static void a(Rectangle2D[] var0, Rectangle2D var1, double var2, int[] var4) {
      boolean var28 = X.j;
      if(var0 == null || var0.length < 1) {
         if(var1 != null) {
            var1.setFrame(0.0D, 0.0D, 0.0D, 0.0D);
         }

         var4[0] = var4[1] = 0;
      }

      double var5 = 0.0D;
      double var7 = 0.0D;
      int var9 = 0;

      double var10000;
      while(true) {
         if(var9 < var0.length) {
            Rectangle2D var10 = var0[var9];
            var5 = Math.max(var5, var10.getWidth());
            var10000 = Math.max(var7, var10.getHeight());
            if(var28) {
               break;
            }

            var7 = var10000;
            ++var9;
            if(!var28) {
               continue;
            }
         }

         var10000 = var5 * var7 * (double)var0.length;
         break;
      }

      int var19;
      int var20;
      label67: {
         double var29 = var10000;
         double var11 = Math.sqrt(var29 / var2);
         double var13 = var29 / var11;
         int var15 = (int)Math.floor(var13 / var5);
         int var16 = (int)Math.ceil(var13 / var5);
         int var17 = (int)Math.ceil((double)var0.length / (double)var15);
         int var18 = (int)Math.ceil((double)var0.length / (double)var16);
         if(var15 * var17 < var16 * var18) {
            var19 = var15;
            var20 = var17;
            if(!var28) {
               break label67;
            }
         }

         var19 = var16;
         var20 = var18;
      }

      double var23;
      double var25;
      label86: {
         int var21 = 0;
         int var22 = 0;
         var23 = 0.0D;
         var25 = 0.0D;
         int var27;
         if(var5 > var7) {
            var27 = 0;

            do {
               if(var27 >= var0.length) {
                  break label86;
               }

               var0[var27].setFrame((double)var22 * var5, (double)var21 * var7, var0[var27].getWidth(), var0[var27].getHeight());
               var23 = Math.max(var23, var0[var27].getMaxX());
               var25 = Math.max(var25, var0[var27].getMaxY());
               ++var22;
               if(var28) {
                  return;
               }

               if(var22 >= var19) {
                  ++var21;
                  var22 = 0;
               }

               ++var27;
            } while(!var28);
         }

         var27 = 0;

         while(var27 < var0.length) {
            var0[var27].setFrame((double)var22 * var5, (double)var21 * var7, var0[var27].getWidth(), var0[var27].getHeight());
            var23 = Math.max(var23, var0[var27].getMaxX());
            var25 = Math.max(var25, var0[var27].getMaxY());
            ++var21;
            if(var28) {
               return;
            }

            if(var21 >= var20) {
               ++var22;
               var21 = 0;
            }

            ++var27;
            if(var28) {
               break;
            }
         }
      }

      if(var1 != null) {
         var1.setFrame(0.0D, 0.0D, var23, var25);
      }

      var4[0] = var20;
      var4[1] = var19;
   }

   public static int a(Rectangle2D[] var0, Rectangle2D var1, double var2, int var4) {
      boolean var50 = X.j;
      if(var0 != null && var0.length >= 1) {
         double var7;
         double var5 = var7 = var0[0].getWidth();
         double var11;
         double var9 = var11 = var0[0].getHeight();
         int var13 = 1;

         double var14;
         while(true) {
            if(var13 < var0.length) {
               var14 = var0[var13].getWidth();
               var5 = Math.min(var5, var14);
               var7 = Math.max(var7, var14);
               double var16 = var0[var13].getHeight();
               var9 = Math.min(var9, var16);
               var11 = Math.max(var11, var16);
               ++var13;
               if(var50) {
                  break;
               }

               if(!var50) {
                  continue;
               }
            }

            if(var9 / var11 > 0.95D && var5 / var7 > 0.95D) {
               int[] var51 = new int[2];
               a(var0, var1, var2, var51);
               return var51[0];
            }
            break;
         }

         y.c.D var52 = new y.c.D();
         var14 = 0.0D;
         boolean var53 = false;
         int var17 = 0;

         while(true) {
            if(var17 < var0.length) {
               Rectangle2D var18 = var0[var17];
               var52.add(var0[var17]);
               var14 += var18.getWidth() * var18.getHeight();
               ++var17;
               if(var50) {
                  break;
               }

               if(!var50) {
                  continue;
               }
            }

            var52.sort(new af());
            break;
         }

         double var56 = 0.0D;
         double var19 = 0.0D;
         double var22 = Math.max(var5, 0.9D * var2 * Math.sqrt(var14 / var2));
         double var24 = 0.0D;
         double var26 = 0.0D;
         double var28 = 0.0D;
         double var30 = 0.0D;
         double var32 = var22;
         double var34 = java.lang.Double.MAX_VALUE;
         y.c.D var36 = null;
         y.c.D var21 = new y.c.D();
         boolean var37 = false;
         int var38 = 0;
         boolean var39 = false;

         while(true) {
            ++var38;
            double var40 = java.lang.Double.MAX_VALUE;
            y.c.D var42 = new y.c.D();
            var21.add(var42);
            var26 = 0.0D;
            var24 = 0.0D;
            var30 = 0.0D;
            y.c.p var43 = var52.k();

            int var10000;
            label203: {
               while(var43 != null) {
                  Rectangle2D var44 = (Rectangle2D)var43.c();
                  double var65;
                  var10000 = (var65 = var30 + var44.getWidth() - var32) == 0.0D?0:(var65 < 0.0D?-1:1);
                  if(var50) {
                     break label203;
                  }

                  label199: {
                     if(var10000 > 0 && var42.size() > 0) {
                        var40 = Math.min(var30 + var44.getWidth(), var40);
                        var26 = Math.max(var26, var30);
                        var42 = new y.c.D();
                        var42.add(var44);
                        var21.add(var42);
                        var30 = var44.getWidth();
                        if(!var50) {
                           break label199;
                        }
                     }

                     var42.add(var44);
                     var30 += var44.getWidth();
                  }

                  if(var42.size() == 1) {
                     var24 += ((Rectangle2D)var42.f()).getHeight();
                  }

                  var26 = Math.max(var26, var30);
                  var43 = var43.a();
                  if(var50) {
                     break;
                  }
               }

               var10000 = var21.size();
            }

            int var57 = var10000;
            double var59 = var26 / var24;
            if(var59 > 0.0D) {
               double var45 = Math.max(var59, var2) / Math.min(var59, var2);
               if(var45 < var34) {
                  var34 = var45;
                  var36 = var21;
                  var21 = new y.c.D();
               }
            }

            var37 = true;
            if(var2 * var24 > var26 && var57 > 1) {
               var37 = false;
               var21.clear();
               if(var40 < java.lang.Double.MAX_VALUE) {
                  var32 = Math.max(1.1D * var32, var40);
                  if(var50) {
                     var32 *= 1.1D;
                  }
               } else {
                  var32 *= 1.1D;
               }
            }

            while(true) {
               if(var38 > 50) {
                  var37 = true;
               }

               if(!var37) {
                  break;
               }

               if(!var50) {
                  if(var36 != null) {
                     var21 = var36;
                  }

                  var40 = 0.0D;
                  y.c.C var58 = var21.m();

                  y.c.D var55;
                  label261: {
                     label262: {
                        Rectangle2D var47;
                        y.c.C var54;
                        double var60;
                        y.c.D var61;
                        y.c.p var63;
                        label181:
                        while(true) {
                           y.c.D var62;
                           if(var58.f()) {
                              var59 = 0.0D;
                              var62 = (y.c.D)var58.d();
                              var54 = var62.m();
                              if(var50) {
                                 break;
                              }

                              y.c.C var46 = var54;

                              label176: {
                                 while(var46.f()) {
                                    var47 = (Rectangle2D)var46.d();
                                    var47.setFrame(var59, var40, var47.getWidth(), var47.getHeight());
                                    var59 += var47.getWidth();
                                    var46.g();
                                    if(var50) {
                                       break label176;
                                    }

                                    if(var50) {
                                       break;
                                    }
                                 }

                                 var56 = Math.max(var56, var59);
                                 var40 += a(var62);
                                 var19 = Math.max(var19, var40);
                                 var58.g();
                              }

                              if(!var50) {
                                 continue;
                              }
                           }

                           switch(var4) {
                           case 2:
                              var54 = var21.m();
                              break label181;
                           case 3:
                              var58 = var21.m();

                              while(true) {
                                 if(!var58.f()) {
                                    break label262;
                                 }

                                 var59 = 0.0D;
                                 var62 = (y.c.D)var58.d();
                                 var10000 = var62.size();
                                 if(var50) {
                                    return var10000;
                                 }

                                 label126: {
                                    if(var10000 > 1) {
                                       double var64 = (var56 - b(var62)) / (double)(var62.size() - 1);
                                       y.c.p var48 = var62.k();

                                       while(var48 != null) {
                                          Rectangle2D var49 = (Rectangle2D)var48.c();
                                          var49.setFrame(var59, var49.getY(), var49.getWidth(), var49.getHeight());
                                          var59 += var49.getWidth() + var64;
                                          var48 = var48.a();
                                          if(var50) {
                                             break label126;
                                          }

                                          if(var50) {
                                             break;
                                          }
                                       }
                                    }

                                    var58.g();
                                 }

                                 if(var50) {
                                    break label262;
                                 }
                              }
                           case 4:
                              var58 = var21.m();

                              while(true) {
                                 label157:
                                 while(true) {
                                    if(!var58.f()) {
                                       break label262;
                                    }

                                    var61 = (y.c.D)var58.d();
                                    var60 = (var56 - b(var61)) / 2.0D;
                                    var55 = var61;
                                    if(var50) {
                                       break label261;
                                    }

                                    var63 = var61.k();

                                    while(true) {
                                       if(var63 == null) {
                                          break label157;
                                       }

                                       var47 = (Rectangle2D)var63.c();
                                       var47.setFrame(var47.getX() + var60, var47.getY(), var47.getWidth(), var47.getHeight());
                                       var63 = var63.a();
                                       if(var50) {
                                          break;
                                       }

                                       if(var50) {
                                          break label157;
                                       }
                                    }
                                 }

                                 var58.g();
                              }
                           default:
                              break label262;
                           }
                        }

                        var58 = var54;

                        label144:
                        while(true) {
                           label142:
                           while(true) {
                              if(!var58.f()) {
                                 break label144;
                              }

                              var61 = (y.c.D)var58.d();
                              var60 = var56 - b(var61);
                              var55 = var61;
                              if(var50) {
                                 break label261;
                              }

                              var63 = var61.k();

                              while(true) {
                                 if(var63 == null) {
                                    break label142;
                                 }

                                 var47 = (Rectangle2D)var63.c();
                                 var47.setFrame(var47.getX() + var60, var47.getY(), var47.getWidth(), var47.getHeight());
                                 var63 = var63.a();
                                 if(var50) {
                                    break;
                                 }

                                 if(var50) {
                                    break label142;
                                 }
                              }
                           }

                           var58.g();
                        }
                     }

                     if(var1 != null) {
                        var1.setFrame(0.0D, 0.0D, var56, var19);
                     }

                     var55 = var21;
                  }

                  var10000 = var55.size();
                  return var10000;
               }

               var36.clear();
               if(var40 < java.lang.Double.MAX_VALUE) {
                  var32 = Math.max(1.1D * var32, var40);
                  if(var50) {
                     var32 *= 1.1D;
                  }
               } else {
                  var32 *= 1.1D;
               }
            }
         }
      } else {
         if(var1 != null) {
            var1.setFrame(0.0D, 0.0D, 0.0D, 0.0D);
         }

         return 0;
      }
   }

   private static double a(y.c.D var0) {
      boolean var4 = X.j;
      double var1 = 0.0D;
      y.c.p var3 = var0.k();

      double var10000;
      while(true) {
         if(var3 != null) {
            var10000 = Math.max(((Rectangle2D)var3.c()).getHeight(), var1);
            if(var4) {
               break;
            }

            var1 = var10000;
            var3 = var3.a();
            if(!var4) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   private static double b(y.c.D var0) {
      boolean var4 = X.j;
      double var1 = 0.0D;
      y.c.p var3 = var0.k();

      double var10000;
      while(true) {
         if(var3 != null) {
            var10000 = var1 + ((Rectangle2D)var3.c()).getWidth();
            if(var4) {
               break;
            }

            var1 = var10000;
            var3 = var3.a();
            if(!var4) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public static boolean a(X var0, y.c.d var1, Rectangle2D var2) {
      boolean var6 = X.j;
      y.c.D var3 = var0.m(var1);
      y.d.t var4 = (y.d.t)var3.g();

      boolean var10000;
      while(true) {
         if(!var3.isEmpty()) {
            y.d.t var5 = (y.d.t)var3.g();
            var10000 = var2.intersectsLine(var4.a, var4.b, var5.a, var5.b);
            if(var6) {
               break;
            }

            if(var10000) {
               return true;
            }

            var4 = var5;
            if(!var6) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   public static void a(X var0, O var1) {
      boolean var8 = X.j;
      y.c.x var2 = var0.o();

      int var7;
      int var10000;
      int var10001;
      while(var2.f()) {
         y.c.q var3 = var2.e();
         am var4 = var1.a(var3);
         if(var4 != null) {
            var0.a((Object)var3);
            var0.b(var3, var4.getWidth(), var4.getHeight());
            var0.c(var3, var4.getX(), var4.getY());
         }

         aj[] var5 = var1.a_(var3);
         aj[] var6 = var0.a_(var3);
         if(var5 != null && var6 != null) {
            var7 = 0;

            label99:
            do {
               var10000 = var7;
               var10001 = var5.length;

               do {
                  if(var10000 >= var10001) {
                     break label99;
                  }

                  var10000 = var7;
                  var10001 = var6.length;
               } while(var8);

               if(var7 >= var10001) {
                  break;
               }

               var6[var7].setModelParameter(var5[var7].getModelParameter());
               ++var7;
            } while(!var8);
         }

         var2.g();
         if(var8) {
            break;
         }
      }

      y.c.e var9 = var0.p();

      label81:
      while(var9.f()) {
         y.c.d var10 = var9.a();
         I var11 = var1.b(var10);
         if(var11 != null) {
            label112: {
               I var12 = var0.b(var10);
               var12.setSourcePoint(var11.getSourcePoint());
               var12.setTargetPoint(var11.getTargetPoint());
               int var14;
               y.d.t var16;
               if(var12.pointCount() != var11.pointCount()) {
                  var12.clearPoints();
                  var14 = 0;

                  do {
                     if(var14 >= var11.pointCount()) {
                        break label112;
                     }

                     var16 = var11.getPoint(var14);
                     var12.addPoint(var16.a(), var16.b());
                     ++var14;
                     if(var8) {
                        continue label81;
                     }
                  } while(!var8);
               }

               var14 = 0;

               while(var14 < var11.pointCount()) {
                  var16 = var11.getPoint(var14);
                  var12.setPoint(var14, var16.a(), var16.b());
                  ++var14;
                  if(var8) {
                     continue label81;
                  }

                  if(var8) {
                     break;
                  }
               }
            }
         }

         C[] var13 = var1.d(var10);
         C[] var15 = var0.d(var10);
         if(var13 != null && var15 != null) {
            var7 = 0;

            label56:
            do {
               var10000 = var7;
               var10001 = var13.length;

               do {
                  if(var10000 >= var10001) {
                     break label56;
                  }

                  var10000 = var7;
                  var10001 = var15.length;
               } while(var8);

               if(var7 >= var10001) {
                  break;
               }

               var15[var7].setModelParameter(var13[var7].getModelParameter());
               ++var7;
            } while(!var8);
         }

         var9.g();
         if(var8) {
            break;
         }
      }

   }

   public static void a(X var0, y.c.y var1, y.c.q var2, boolean var3, byte var4) {
      boolean var21 = X.j;
      if(var1.size() > 1) {
         double var5 = java.lang.Double.MAX_VALUE;
         double var7 = -1.7976931348623157E308D;
         double var9 = 0.0D;
         y.c.x var11 = var1.a();

         am var10000;
         label169: {
            while(true) {
               if(var11.f()) {
                  y.c.q var12 = var11.e();
                  am var13 = var0.a((Object)var12);
                  if(var21) {
                     break;
                  }

                  label163: {
                     if(var3) {
                        var9 += var13.getHeight();
                        var5 = Math.min(var5, var13.getY());
                        var7 = Math.max(var7, var13.getY() + var13.getHeight());
                        if(!var21) {
                           break label163;
                        }
                     }

                     var9 += var13.getWidth();
                     var5 = Math.min(var5, var13.getX());
                     var7 = Math.max(var7, var13.getX() + var13.getWidth());
                  }

                  var11.g();
                  if(!var21) {
                     continue;
                  }
               }

               if(var2 != null) {
                  var10000 = var0.a((Object)var2);
                  break label169;
               }
               break;
            }

            var10000 = null;
         }

         double var23;
         label185: {
            am var22 = var10000;
            y.c.x var14;
            y.c.q var15;
            am var16;
            switch(var4) {
            case -1:
               if(var3) {
                  var23 = var22 != null?var22.getY():var5;
                  var14 = var1.a();

                  do {
                     if(!var14.f()) {
                        return;
                     }

                     var15 = var14.e();
                     var16 = var0.a((Object)var15);
                     var16.setLocation(var16.getX(), var23);
                     var14.g();
                  } while(!var21);
               }

               var23 = var22 != null?var22.getX():var5;
               var14 = var1.a();

               do {
                  if(!var14.f()) {
                     return;
                  }

                  var15 = var14.e();
                  var16 = var0.a((Object)var15);
                  var16.setLocation(var23, var16.getY());
                  var14.g();
               } while(!var21);
            case 0:
               if(var3) {
                  var23 = var22 != null?var22.getY() + var22.getHeight() * 0.5D:(var5 + var7) * 0.5D;
                  var14 = var1.a();

                  do {
                     if(!var14.f()) {
                        return;
                     }

                     var15 = var14.e();
                     var16 = var0.a((Object)var15);
                     var16.setLocation(var16.getX(), var23 - var16.getHeight() * 0.5D);
                     var14.g();
                  } while(!var21);
               }

               var23 = var22 != null?var22.getX() + var22.getWidth() * 0.5D:(var5 + var7) * 0.5D;
               var14 = var1.a();

               do {
                  if(!var14.f()) {
                     return;
                  }

                  var15 = var14.e();
                  var16 = var0.a((Object)var15);
                  var16.setLocation(var23 - var16.getWidth() * 0.5D, var16.getY());
                  var14.g();
               } while(!var21);
            case 1:
               break;
            case 2:
               break label185;
            default:
               return;
            }

            if(var3) {
               var23 = var22 != null?var22.getY() + var22.getHeight():var7;
               var14 = var1.a();

               do {
                  if(!var14.f()) {
                     return;
                  }

                  var15 = var14.e();
                  var16 = var0.a((Object)var15);
                  var16.setLocation(var16.getX(), var23 - var16.getHeight());
                  var14.g();
               } while(!var21);
            }

            var23 = var22 != null?var22.getX() + var22.getWidth():var7;
            var14 = var1.a();

            do {
               if(!var14.f()) {
                  return;
               }

               var15 = var14.e();
               var16 = var0.a((Object)var15);
               var16.setLocation(var23 - var16.getWidth(), var16.getY());
               var14.g();
            } while(!var21);
         }

         double var24;
         label96: {
            var1.sort(new ag(var0, var3));
            var23 = var7 - var5 - var9;
            if(var23 <= 0.0D) {
               var24 = 0.0D;
               if(!var21) {
                  break label96;
               }
            }

            var24 = var23 / (double)(var1.size() - 1);
         }

         y.c.x var18;
         y.c.q var19;
         am var20;
         double var25;
         if(var3) {
            var25 = var0.a((Object)var1.b()).getY();
            var18 = var1.a();

            do {
               if(!var18.f()) {
                  return;
               }

               var19 = var18.e();
               var20 = var0.a((Object)var19);
               var20.setLocation(var20.getX(), var25);
               var25 += var20.getHeight() + var24;
               var18.g();
            } while(!var21);
         }

         var25 = var0.a((Object)var1.b()).getX();
         var18 = var1.a();

         while(var18.f()) {
            var19 = var18.e();
            var20 = var0.a((Object)var19);
            var20.setLocation(var25, var20.getY());
            var25 += var20.getWidth() + var24;
            var18.g();
            if(var21) {
               break;
            }
         }
      }

   }

   static boolean a(y.d.n var0) {
      return java.lang.Double.isNaN(var0.b()) || java.lang.Double.isNaN(var0.c()) || java.lang.Double.isNaN(var0.e()) || java.lang.Double.isNaN(var0.f()) || java.lang.Double.isNaN(var0.g()) || java.lang.Double.isNaN(var0.i());
   }

   public static boolean b(y.d.n var0) {
      double var1 = var0.i();
      if(var1 > 0.0D) {
         y.d.t var3 = var0.k();
         var0.c(-var0.g(), -var1);
         var0.b(var3);
         return true;
      } else {
         return false;
      }
   }

   static {
      b = y.d.t.c;
   }
}
