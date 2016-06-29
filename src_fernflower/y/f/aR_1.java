package y.f;

import java.util.HashMap;
import java.util.Map;
import y.f.X;
import y.f.aS;
import y.f.aT;

public class aR {
   public static void a(y.c.i var0, y.c.c var1, int var2, int var3) {
      boolean var28 = X.j;
      if(var0 != null && var1 != null) {
         y.c.i var4 = new y.c.i();
         y.c.h var5 = var4.u();
         y.c.A var6 = var4.t();
         a(var4, var5, var0, var1, var6, var3);
         int[] var7 = new int[var4.f()];
         int[] var8 = new int[var4.f()];
         double var9 = Double.MAX_VALUE;
         y.g.ar var11 = new y.g.ar(7L);
         y.c.A var12 = y.g.M.a(new boolean[var4.f()]);
         y.c.y var13 = new y.c.y();
         y.c.y var14 = new y.c.y();
         y.c.x var15 = var4.o();

         while(var15.f()) {
            label114: {
               y.c.q var16 = var15.e();
               aT var17 = (aT)var6.b(var16);
               if(var17.b()) {
                  var13.add(var16);
                  var12.a(var16, false);
                  if(!var28) {
                     break label114;
                  }
               }

               var14.add(var16);
               var12.a(var16, true);
            }

            var15.g();
            if(var28) {
               break;
            }
         }

         y.c.q[] var29 = var13.e();
         y.c.q[] var30 = var14.e();
         aS var18 = new aS(var6);
         y.g.e.a((Object[])var30, var18);
         y.c.q[] var19 = a(var29, var30, var11);
         int var20 = 0;

         label105:
         while(var20 < var2) {
            int var21 = 0;

            while(var21 < var19.length) {
               var7[var19[var21].d()] = var21++;
               if(var28) {
                  continue label105;
               }

               if(var28) {
                  break;
               }
            }

            double var33 = a((y.c.i)var4, (y.c.c)var5, (int[])var7);

            label95:
            while(true) {
               boolean var23 = false;
               int var24 = 1;

               label93:
               while(true) {
                  int var10000 = var24;

                  do {
                     boolean var31;
                     label89: {
                        if(var10000 < var19.length) {
                           var31 = var12.d(var19[var24 - 1]);
                           if(var28) {
                              break label89;
                           }

                           if(!var31 || !var12.d(var19[var24])) {
                              double var25 = a(var19[var24 - 1], var19[var24], var7, var5);
                              if(var25 < 0.0D) {
                                 ++var7[var19[var24 - 1].d()];
                                 --var7[var19[var24].d()];
                                 y.c.q var27 = var19[var24 - 1];
                                 var19[var24 - 1] = var19[var24];
                                 var19[var24] = var27;
                                 var33 += var25;
                                 var23 = true;
                              }
                           }

                           ++var24;
                           if(!var28) {
                              continue label93;
                           }
                        }

                        var31 = var23;
                     }

                     if(var31) {
                        continue label95;
                     }

                     double var35;
                     var10000 = (var35 = var9 - var33) == 0.0D?0:(var35 < 0.0D?-1:1);
                  } while(var28);

                  label72: {
                     if(var10000 > 0) {
                        var24 = 0;

                        while(var24 < var7.length) {
                           var8[var24] = var7[var24];
                           ++var24;
                           if(var28) {
                              break label72;
                           }

                           if(var28) {
                              break;
                           }
                        }

                        var9 = var33;
                     }

                     var19 = a(var29, var30, var11);
                     ++var20;
                  }

                  if(var28) {
                     break label105;
                  }
                  continue label105;
               }
            }
         }

         y.c.x var32 = var4.o();

         while(true) {
            if(var32.f()) {
               y.c.q var34 = var32.e();
               aT var22 = (aT)var6.b(var34);
               var22.a(var8[var34.d()]);
               var32.g();
               if(var28) {
                  break;
               }

               if(!var28) {
                  continue;
               }
            }

            var4.a(var6);
            var4.a(var5);
            var4.j();
            break;
         }

      }
   }

   private static y.c.q[] a(y.c.q[] var0, y.c.q[] var1, y.g.ar var2) {
      boolean var8 = X.j;
      var2.a(var0);
      y.c.q[] var3 = new y.c.q[var0.length + var1.length];
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;

      y.c.q[] var10000;
      while(true) {
         if(var6 < var3.length) {
            var10000 = var0;
            if(var8) {
               break;
            }

            label19: {
               int var7 = var0.length - var4 + var1.length - var5;
               if(var2.nextInt(var7) < var0.length - var4) {
                  var3[var6] = var0[var4++];
                  if(!var8) {
                     break label19;
                  }
               }

               var3[var6] = var1[var5++];
            }

            ++var6;
            if(!var8) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   private static void a(y.c.i var0, y.c.h var1, y.c.i var2, y.c.c var3, y.c.A var4, int var5) {
      boolean var11 = X.j;
      HashMap var6 = new HashMap();
      y.c.x var7 = var2.o();

      while(var7.f()) {
         y.c.q var8 = var7.e();
         Object var9 = var3.b(var8);
         if(var9 != null && !var6.containsKey(var9)) {
            y.c.q var10 = var0.d();
            var6.put(var9, var10);
            var4.a(var10, var9);
         }

         var7.g();
         if(var11) {
            break;
         }
      }

      y.c.d[][] var12 = new y.c.d[var0.f()][var0.f()];
      if(var5 == 1 || var5 == 2) {
         b(var2, var0, var3, var6, var1, var12);
      }

      if(var5 == 0 || var5 == 2) {
         a(var2, var0, var3, var6, var1, var12);
      }

   }

   private static void a(y.c.i var0, y.c.i var1, y.c.c var2, Map var3, y.c.h var4, y.c.d[][] var5) {
      boolean var17 = X.j;
      y.c.q[] var6 = var1.m();
      y.c.e var7 = var0.p();

      while(var7.f()) {
         y.c.d var8 = var7.a();
         Object var9 = var2.b(var8.c());
         Object var10 = var2.b(var8.d());
         if(var9 != null && var10 != null) {
            y.c.q var11 = (y.c.q)var3.get(var9);
            y.c.q var12 = (y.c.q)var3.get(var10);
            if(var11 != var12) {
               label20: {
                  int var13 = Math.min(var11.d(), var12.d());
                  int var14 = Math.max(var11.d(), var12.d());
                  y.c.d var15;
                  if(var5[var13][var14] == null) {
                     var15 = var1.a(var6[var13], var6[var14]);
                     var5[var13][var14] = var15;
                     var4.a(var15, 1);
                     if(!var17) {
                        break label20;
                     }
                  }

                  var15 = var5[var13][var14];
                  int var16 = var4.a(var15);
                  var4.a(var15, var16 + 1);
               }
            }
         }

         var7.g();
         if(var17) {
            break;
         }
      }

   }

   private static void b(y.c.i var0, y.c.i var1, y.c.c var2, Map var3, y.c.h var4, y.c.d[][] var5) {
      boolean var20 = X.j;
      if(y.f.b.c.b(var0)) {
         y.f.b.c var6 = new y.f.b.c(var0);
         y.c.A var7 = var1.t();
         y.c.x var8 = var0.o();

         label112:
         while(true) {
            int var10000 = var8.f();

            label109:
            while(var10000 != 0) {
               y.c.q var9 = var8.e();
               if(var20) {
                  return;
               }

               label106: {
                  if(var6.d(var9)) {
                     y.c.y var10 = new y.c.y();
                     y.c.x var11 = var6.c(var9).a();

                     while(var11.f()) {
                        y.c.q var12 = var11.e();
                        var10000 = var6.d(var12);
                        if(var20) {
                           continue label109;
                        }

                        if(var10000 == 0) {
                           Object var13 = var2.b(var12);
                           if(var13 != null) {
                              y.c.q var14 = (y.c.q)var3.get(var13);
                              if(!var7.d(var14)) {
                                 var10.add(var14);
                                 var7.a(var14, true);
                              }
                           }
                        }

                        var11.g();
                        if(var20) {
                           break;
                        }
                     }

                     y.c.q[] var21 = var10.e();
                     int var22 = 0;

                     label94:
                     do {
                        var10000 = var22;
                        int var10001 = var21.length - 1;

                        label91:
                        while(true) {
                           if(var10000 >= var10001) {
                              break label94;
                           }

                           y.c.q var24 = var21[var22];
                           var10000 = var22 + 1;
                           if(var20) {
                              continue label109;
                           }

                           int var25 = var10000;

                           while(true) {
                              if(var25 >= var21.length) {
                                 break label91;
                              }

                              y.c.q var15 = var21[var25];
                              var10000 = var24.d();
                              var10001 = var15.d();
                              if(var20) {
                                 break;
                              }

                              label86: {
                                 y.c.q var16 = var10000 < var10001?var24:var15;
                                 y.c.q var17 = var24.d() < var15.d()?var15:var24;
                                 y.c.d var18;
                                 if(var5[var16.d()][var17.d()] == null) {
                                    var18 = var1.a(var16, var17);
                                    var5[var16.d()][var17.d()] = var18;
                                    var4.a(var18, 10);
                                    if(!var20) {
                                       break label86;
                                    }
                                 }

                                 var18 = var5[var16.d()][var17.d()];
                                 int var19 = var4.a(var18);
                                 var4.a(var18, var19 + 10);
                              }

                              ++var25;
                              if(var20) {
                                 break label91;
                              }
                           }
                        }

                        ++var22;
                     } while(!var20);

                     y.c.x var23 = var10.a();

                     while(var23.f()) {
                        var7.a(var23.e(), false);
                        var23.g();
                        if(var20) {
                           break label106;
                        }

                        if(var20) {
                           break;
                        }
                     }
                  }

                  var8.g();
               }

               if(!var20) {
                  continue label112;
               }
               break;
            }

            var1.a(var7);
            return;
         }
      }
   }

   private static double a(y.c.q var0, y.c.q var1, int[] var2, y.c.c var3) {
      boolean var10 = X.j;
      int var4 = 0;
      int var5 = var2[var0.d()];
      int var6 = var2[var1.d()];
      y.c.e var7 = var0.j();

      int var10000;
      label48:
      while(true) {
         y.c.d var8;
         int var9;
         if(var7.f()) {
            var8 = var7.a();
            var9 = var2[var8.a(var0).d()];
            if(!var10) {
               if(var9 != var6) {
                  var4 = (int)((double)var4 + (double)var3.a(var8) * (a(var5 + 1, var9) - a(var5, var9)));
               }

               var7.g();
               if(!var10) {
                  continue;
               }

               var7 = var1.j();
            } else {
               if(var9 != var6) {
                  var4 = (int)((double)var4 + (double)var3.a(var8) * (a(var6 - 1, var9) - a(var6, var9)));
               }

               var7.g();
               if(var10) {
                  break;
               }
            }
         } else {
            var7 = var1.j();
         }

         while(true) {
            if(!var7.f()) {
               break label48;
            }

            var8 = var7.a();
            var9 = var2[var8.a(var1).d()];
            var10000 = var9;
            if(var10) {
               return (double)var10000;
            }

            if(var9 != var5) {
               var4 = (int)((double)var4 + (double)var3.a(var8) * (a(var6 - 1, var9) - a(var6, var9)));
            }

            var7.g();
            if(var10) {
               break label48;
            }
         }
      }

      var10000 = var4;
      return (double)var10000;
   }

   private static double a(y.c.i var0, y.c.c var1, int[] var2) {
      boolean var11 = X.j;
      double var3 = 0.0D;
      y.c.x var5 = var0.o();

      while(var5.f()) {
         y.c.q var6 = var5.e();
         int var7 = var2[var6.d()];
         y.c.e var8 = var6.l();

         while(true) {
            if(var8.f()) {
               y.c.d var9 = var8.a();
               int var10 = var2[var9.d().d()];
               var3 += (double)var1.a(var9) * a(var7, var10);
               var8.g();
               if(var11) {
                  break;
               }

               if(!var11) {
                  continue;
               }
            }

            var5.g();
            break;
         }

         if(var11) {
            break;
         }
      }

      return var3;
   }

   private static double a(int var0, int var1) {
      return Math.pow((double)Math.abs(var0 - var1), 2.0D);
   }
}
