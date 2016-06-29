package y.f.d;

import java.util.ArrayList;
import y.f.I;
import y.f.K;
import y.f.X;
import y.f.aG;
import y.f.ae;
import y.f.am;
import y.f.d.a;
import y.f.d.m;
import y.f.d.o;
import y.f.d.p;

class n {
   private static final y.d.n[] a = new y.d.n[]{new y.d.n(15.0D, 5.0D, 30.0D, 10.0D, 1.0D, 0.0D), new y.d.n(-15.0D, -15.0D, 100.0D, 30.0D, 0.5D, 0.5D), new y.d.n(50.0D, 90.0D, 40.0D, 15.0D, 0.0D, -1.0D)};
   private static final y.d.z b = new y.d.z(0.0D, -1.0D);
   private static final y.d.t c = new y.d.t(0.0D, 0.0D);

   private static boolean a(y.f.E var0, I var1, am var2, am var3) {
      int var7 = a.f;
      if(var0 instanceof K) {
         return true;
      } else {
         boolean var10000;
         try {
            int var4 = 0;

            while(var4 < a.length) {
               Object var5 = var0.a(a[var4], var1, var2, var3);
               y.d.n var6 = var0.a(a[var4].d(), var1, var2, var3, var5);
               var10000 = y.d.n.a(a[var4], var6, 1.0D);
               if(var7 != 0) {
                  return var10000;
               }

               if(!var10000) {
                  return false;
               }

               ++var4;
               if(var7 != 0) {
                  break;
               }
            }
         } catch (UnsupportedOperationException var8) {
            return false;
         }

         var10000 = true;
         return var10000;
      }
   }

   static y.c.D a(X var0, y.c.d var1, y.f.C var2, y.f.E var3, boolean var4, boolean var5, boolean var6) {
      y.c.D var7;
      y.c.D var10000;
      label45: {
         int var19 = a.f;
         var7 = new y.c.D();
         I var8 = var0.b(var1);
         am var9 = var0.a((Object)var1.c());
         am var10 = var0.a((Object)var1.d());
         y.f.E var11 = var2.getLabelModel();
         Object var12 = var2.getModelParameter() == null?var11.c():var2.getModelParameter();
         y.d.n var13 = var11 == null?var2.getOrientedBox():var11.a(var2.getOrientedBox().d(), var8, var9, var10, var12);
         if(var4) {
            var7.add(new y.f.B(var13, var12, var2, false));
            if(var19 == 0) {
               break label45;
            }
         }

         if(var3 != null && var3 != var11) {
            Object var14 = var3.a(var13, var8, var9, var10);
            y.f.C var15 = a(var2.getOrientedBox(), var3, var14, var2.getPreferredPlacementDescriptor());
            y.c.D var16 = a(var0, var1, var15, var3, var5, var6);
            y.c.C var17 = var16.m();

            do {
               if(!var17.f()) {
                  break label45;
               }

               y.f.B var18 = (y.f.B)var17.d();
               var10000 = var7;
               if(var19 != 0) {
                  return var10000;
               }

               var7.add(a(var18, var2, var11, var8, var9, var10));
               var17.g();
            } while(var19 == 0);
         }

         var7.addAll(a(var0, var1, var2, var11, var5, var6));
      }

      var10000 = var7;
      return var10000;
   }

   private static y.f.B a(y.f.B var0, y.f.C var1, y.f.E var2, I var3, am var4, am var5) {
      Object var6 = var2.a(var0.d(), var3, var4, var5);
      y.d.n var7 = var2.a(var0.d().d(), var3, var4, var5, var6);
      return new y.f.B(var7, var6, var1);
   }

   private static y.f.C a(y.d.n var0, y.f.E var1, Object var2, aG var3) {
      y.f.D var4 = new y.f.D();
      var4.a(var1);
      var4.setModelParameter(var2);
      var4.a(var3);
      var4.a((y.d.n)var0);
      return var4;
   }

   private static y.c.D a(X var0, y.c.d var1, y.f.C var2, y.f.E var3, boolean var4, boolean var5) {
      I var6 = var0.b(var1);
      am var7 = var0.a((Object)var1.c());
      am var8 = var0.a((Object)var1.d());
      return var3 != null && !a(var3, var6, var7, var8)?var3.a(var2, var6, var7, var8):a(var0, var1, var2, var4, var5);
   }

   private static y.c.D a(X var0, y.c.d var1, y.f.C var2, boolean var3, boolean var4) {
      int var37 = a.f;
      y.d.y var5 = var0.s(var1.c());
      y.d.y var6 = var0.s(var1.d());
      am var7 = var0.a((Object)var1.c());
      am var8 = var0.a((Object)var1.d());
      I var9 = var0.b(var1);
      y.d.v var10 = ae.a(var9, var7, var8, 0.0D);
      y.c.D var11 = new y.c.D();
      if(var10.h() == 0) {
         return var11;
      } else {
         aG var12 = var2.getPreferredPlacementDescriptor();
         double var13 = a(var10);
         int var15 = a(var0, var10);
         int var16 = 0;
         int var17 = var10.h() - 1;

         do {
            int var10000 = var16;

            label88:
            while(true) {
               if(var10000 >= var17) {
                  return var11;
               }

               y.d.m var18 = var10.a(var16);
               if(var18.g() <= 0.0D) {
                  break;
               }

               p[] var19 = a(var12, var18, var3);
               int var20 = 0;

               while(true) {
                  var10000 = var20;

                  label83:
                  while(true) {
                     if(var10000 >= var19.length) {
                        break label88;
                     }

                     p var21 = var19[var20];
                     y.d.n[] var22 = a(var2, var18, var21);
                     var10000 = 0;
                     if(var37 != 0) {
                        continue label88;
                     }

                     int var23 = 0;

                     while(true) {
                        var10000 = var23;

                        label78:
                        while(true) {
                           if(var10000 >= var22.length) {
                              break label83;
                           }

                           y.d.n var24 = var22[var23];
                           double[] var25 = a(var24, var18, var21, var15);
                           var10000 = 0;
                           if(var37 != 0) {
                              continue label83;
                           }

                           int var26 = 0;

                           while(true) {
                              if(var26 >= var25.length) {
                                 break label78;
                              }

                              y.d.n var27 = new y.d.n(var24);
                              y.d.z var28 = var18.i();
                              var28.b(var25[var26]);
                              y.d.t var29 = y.d.z.a(var18.c(), var28);
                              a(var27, var18, var29, var21);
                              var10000 = var4;
                              if(var37 != 0) {
                                 break;
                              }

                              if(var4 != 0) {
                                 ae.b(var27);
                              }

                              double var30 = var13;
                              boolean var32 = true;
                              if(var12.i()) {
                                 var32 = false;
                                 var30 = Math.min(var13, a(var5, var27));
                              }

                              if(var12.k()) {
                                 var32 = false;
                                 var30 = Math.min(var30, a(var6, var27));
                              }

                              if(var32 || var30 < 100.0D) {
                                 Object var33 = var2.getLabelModel().a(var27, var9, var7, var8);
                                 y.f.B var34 = new y.f.B(var27, var33, var2, false);
                                 double var35 = a(var34, var12, var21);
                                 var34.a(var35);
                                 var11.add(var34);
                              }

                              ++var26;
                              if(var37 != 0) {
                                 break label78;
                              }
                           }
                        }

                        ++var23;
                        if(var37 != 0) {
                           break label83;
                        }
                     }
                  }

                  ++var20;
                  if(var37 != 0) {
                     break label88;
                  }
               }
            }

            ++var16;
         } while(var37 == 0);

         return var11;
      }
   }

   private static int a(X var0, y.d.v var1) {
      int var2;
      label13: {
         var2 = (int)Math.floor(30.0D / (double)(var1.h() - 1));
         if(var0.h() > 100) {
            var2 = (int)Math.floor(15.0D / (double)(var1.h() - 1));
            if(a.f == 0) {
               break label13;
            }
         }

         if(var0.h() > 500) {
            var2 = (int)Math.floor(10.0D / (double)(var1.h() - 1));
         }
      }

      var2 = Math.max(var2, 5);
      return var2;
   }

   private static double a(y.d.v var0) {
      double var1 = var0.k();
      return Math.max(100.0D, var1 * 0.2D);
   }

   private static p[] a(aG var0, y.d.m var1, boolean var2) {
      p[] var3 = b(var0, var1, var2);
      a(var3);
      b(var3);
      a(var3, var0);
      return var3;
   }

   private static p[] b(aG var0, y.d.m var1, boolean var2) {
      int var18 = a.f;
      boolean var3 = var1.j() < 0.0D;
      boolean var4 = var1.j() > 0.0D;
      boolean var5 = var1.k() < -0.001D;
      boolean var6 = var1.k() > 0.001D;
      boolean var7 = !var5 && !var6;
      boolean var8 = var0.l();
      boolean var9 = var0.n();
      boolean var10 = var0.m();
      boolean var11 = var0.u();
      boolean var12 = var0.v();
      boolean var13 = var0.w();
      p[] var14 = new p[5];
      int var15 = 0;
      if(var10) {
         var14[var15++] = new p((byte)1, false, (o)null);
      }

      label227: {
         if(var9 && (var2 && (var6 || var7) || !var2 && (var6 && (var12 || var13) || var4 && var7 && var13 || var3 && var7 && var12))) {
            var14[var15++] = new p((byte)0, true, (o)null);
            var14[var15++] = new p((byte)0, true, (o)null);
            if(var18 == 0) {
               break label227;
            }
         }

         if(var8 && (var2 && var5 || !var2 && (var11 || var5 && (var12 || var13) || var4 && var7 && var12 || var3 && var7 && var13))) {
            var14[var15++] = new p((byte)0, false, (o)null);
            var14[var15++] = new p((byte)0, false, (o)null);
         }
      }

      label170: {
         if(var9 && (var2 && var5 || !var2 && (var11 || var5 && (var12 || var13) || var4 && var7 && var12 || var3 && var7 && var13))) {
            var14[var15++] = new p((byte)2, false, (o)null);
            var14[var15++] = new p((byte)2, false, (o)null);
            if(var18 == 0) {
               break label170;
            }
         }

         if(var8 && (var2 && (var6 || var7) || !var2 && (var6 && (var12 || var13) || var4 && var7 && var13 || var3 && var7 && var12))) {
            var14[var15++] = new p((byte)2, true, (o)null);
            var14[var15++] = new p((byte)2, true, (o)null);
         }
      }

      if(var15 == 0) {
         var14[var15++] = new p((byte)1, false, (o)null);
         var14[var15++] = new p((byte)0, false, (o)null);
         var14[var15++] = new p((byte)0, false, (o)null);
         var14[var15++] = new p((byte)2, false, (o)null);
         var14[var15++] = new p((byte)2, false, (o)null);
         if(var18 == 0) {
            return var14;
         }
      }

      if(var15 < 5) {
         p[] var16 = new p[var15];
         int var17 = 0;

         while(var17 < var15) {
            var16[var17] = var14[var17];
            ++var17;
            if(var18 != 0) {
               return var14;
            }

            if(var18 != 0) {
               break;
            }
         }

         var14 = var16;
      }

      return var14;
   }

   private static void a(p[] var0, aG var1) {
      int var3 = a.f;
      int var2 = var1.h() <= 0.0D?40:(int)Math.ceil(var1.h());
      if(var0.length == 1) {
         p.a(var0[0], 0);
         if(var3 == 0) {
            return;
         }
      }

      if(var0.length == 2) {
         p.a(var0[0], 0);
         p.a(var0[1], var2);
         if(var3 == 0) {
            return;
         }
      }

      if(var0.length == 3) {
         p.a(var0[0], 0);
         p.a(var0[1], 0);
         p.a(var0[2], var2);
         if(var3 == 0) {
            return;
         }
      }

      if(var0.length == 4) {
         p.a(var0[0], 0);
         p.a(var0[1], var2);
         p.a(var0[2], 0);
         p.a(var0[3], var2);
         if(var3 == 0) {
            return;
         }
      }

      if(var0.length == 5) {
         p.a(var0[0], 0);
         p.a(var0[1], 0);
         p.a(var0[2], var2);
         p.a(var0[3], 0);
         p.a(var0[4], var2);
      }

   }

   private static void a(p[] var0) {
      int var2 = a.f;
      if(var0.length < 5) {
         int var1 = 0;

         do {
            if(var1 >= var0.length) {
               return;
            }

            p.a(var0[var1], 1.0D);
            ++var1;
         } while(var2 == 0);
      }

      if(var0.length == 5) {
         p.a(var0[0], 1.0D);
         p.a(var0[1], 1.0D);
         p.a(var0[2], 2.0D);
         p.a(var0[3], 1.0D);
         p.a(var0[4], 2.0D);
      }

   }

   private static void b(p[] var0) {
      int var2 = a.f;
      if(var0.length < 5) {
         int var1 = 0;

         do {
            if(var1 >= var0.length) {
               return;
            }

            p.b(var0[var1], 0);
            ++var1;
         } while(var2 == 0);
      }

      if(var0.length == 5) {
         p.b(var0[0], 0);
         p.b(var0[1], 1);
         p.b(var0[2], 0);
         p.b(var0[3], 1);
         p.b(var0[4], 0);
      }

   }

   private static double a(y.d.y var0, y.d.n var1) {
      return m.a(var0, var1);
   }

   private static double a(y.f.B var0, aG var1, p var2) {
      double var3 = 0.0D;
      double var5 = var1.m()?0.0D:var1.h();
      if(var5 < 0.0D || Math.abs(var5 - (double)p.a(var2)) < 0.001D) {
         var3 = 1.0D;
      }

      return var3;
   }

   private static y.d.n a(y.d.q var0, y.d.z var1, double var2) {
      y.d.z var4 = var2 != 0.0D?var1.a(var2):var1;
      return new y.d.n(c, var0, var4);
   }

   private static y.d.n[] a(y.f.C var0, y.d.m var1, p var2) {
      ArrayList var3 = new ArrayList();
      y.d.q var4 = var0.getOrientedBox().d();
      y.d.z var5 = var1.i();
      aG var6 = var0.getPreferredPlacementDescriptor();
      double var7 = var6.d();
      y.d.z var9 = var5.a(-1.5707963267948966D);
      var9.c();
      byte var10 = p.b(var2);
      if(var10 == 1 || var10 == 0 && !p.c(var2) || var10 == 2 && p.c(var2)) {
         if(var6.o()) {
            var3.add(a(var4, b, var7));
         }

         if(!var6.p()) {
            return var3.size() == 0?new y.d.n[]{a(var4, b, var7)}:(y.d.n[])var3.toArray(new y.d.n[var3.size()]);
         }

         var3.add(a(var4, var9, var7));
         if(a.f == 0) {
            return var3.size() == 0?new y.d.n[]{a(var4, b, var7)}:(y.d.n[])var3.toArray(new y.d.n[var3.size()]);
         }
      }

      if(var6.o()) {
         if(var6.q()) {
            if(var6.s()) {
               var3.add(a(var4, b, var7));
            }

            if(var6.t()) {
               var3.add(a(var4, b, var7 + 3.141592653589793D));
            }
         }

         if(var6.r()) {
            if(var6.s()) {
               var3.add(a(var4, b, -var7));
            }

            if(var6.t()) {
               var3.add(a(var4, b, -var7 + 3.141592653589793D));
            }
         }
      }

      if(var6.p()) {
         if(var6.q()) {
            if(var6.s()) {
               var3.add(a(var4, var9, var7));
            }

            if(var6.t()) {
               var3.add(a(var4, var9, var7 + 3.141592653589793D));
            }
         }

         if(var6.r()) {
            if(var6.s()) {
               var3.add(a(var4, var9, -var7));
            }

            if(var6.t()) {
               var3.add(a(var4, var9, -var7 + 3.141592653589793D));
            }
         }
      }

      return var3.size() == 0?new y.d.n[]{a(var4, b, var7)}:(y.d.n[])var3.toArray(new y.d.n[var3.size()]);
   }

   private static void a(y.d.n var0, y.d.m var1, y.d.t var2, p var3) {
      if(p.b(var3) == 1) {
         var0.e(var2.a, var2.b);
         if(a.f == 0) {
            return;
         }
      }

      y.d.z var4 = y.d.z.c(var1.i());
      if(p.b(var3) == 0) {
         var4 = new y.d.z(-var4.a(), -var4.b());
      }

      var4.b((double)p.a(var3) + var0.e() + var0.f());
      y.d.t var5 = y.d.z.a(var2, var4);
      var0.e(var5.a, var5.b);
      y.d.t[] var6 = y.d.n.a(var0);
      double var7 = a(var1, var6);
      y.d.z var9 = new y.d.z(-var4.a(), -var4.b());
      var9.c();
      var9.b(var7 - (double)Math.abs(p.a(var3)));
      var5 = y.d.z.a(var5, var9);
      var0.e(var5.a, var5.b);
   }

   private static double a(y.d.m var0, y.d.t[] var1) {
      int var7 = a.f;
      double var2 = Double.MAX_VALUE;
      int var4 = 0;

      double var10000;
      while(true) {
         if(var4 < var1.length) {
            double var5 = a(var0, var1[var4]);
            var10000 = var5;
            if(var7 != 0) {
               break;
            }

            if(var5 < var2) {
               var2 = var5;
            }

            ++var4;
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private static double[] a(y.d.n var0, y.d.m var1, p var2, int var3) {
      int var17 = a.f;
      y.d.t var4 = var0.k();
      y.d.z var5 = var1.i();
      var5.c();
      var5.b(Math.max(var0.e(), var0.f()));
      y.d.t var6 = y.d.z.a(var4, var5);
      y.d.m var7 = new y.d.m(var4, var6);
      y.d.t var8 = y.d.n.b(var0, var7, 0.0D);
      double var9 = 2.0D * y.d.t.a(var4, var8);
      int var11 = (int)Math.floor(var1.g() / (var9 * p.d(var2)));
      var11 = Math.max(var11, 3);
      var11 = Math.min(var11, var3);
      if(var11 % 2 == 0) {
         ++var11;
      }

      double var12 = 1.0D / (double)(var11 - 1 + 2 * p.e(var2));
      double[] var14 = new double[var11];
      int var15 = 0;
      int var16 = p.e(var2);

      while(true) {
         if(var16 < var11 + p.e(var2)) {
            var14[var15++] = var12 * (double)var16;
            ++var16;
            if(var17 != 0) {
               break;
            }

            if(var17 == 0) {
               continue;
            }
         }

         if(p.e(var2) == 0) {
            var14[var11 - 1] = 1.0D;
         }
         break;
      }

      return var14;
   }

   private static double a(y.d.m var0, y.d.t var1) {
      y.d.t var2 = var0.c();
      y.d.t var3 = var0.d();
      double var4 = var3.a - var2.a;
      double var6 = var3.b - var2.b;
      double var8 = var1.a - var2.a;
      double var10 = var1.b - var2.b;
      double var12 = var8 * var4 + var10 * var6;
      double var14 = var12 * var12 / (var4 * var4 + var6 * var6);
      double var16 = var8 * var8 + var10 * var10 - var14;
      if(var16 < 0.0D) {
         var16 = 0.0D;
      }

      return Math.sqrt(var16);
   }
}
