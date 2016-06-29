package y.a;

import y.a.h;

public class v {
   public static void a(y.c.i var0, y.c.q var1, boolean var2, double[] var3, double[] var4, y.c.d[] var5) {
      boolean var17 = h.a;
      y.g.a.c var6 = new y.g.a.c(var0);
      int var7 = var0.e();
      int var8 = 0;

      while(true) {
         if(var8 < var7) {
            var5[var8] = null;
            var4[var8] = Double.POSITIVE_INFINITY;
            ++var8;
            if(var17) {
               break;
            }

            if(!var17) {
               continue;
            }
         }

         var4[var1.d()] = 0.0D;
         break;
      }

      var6.a(var1, 0.0D);

      label79:
      while(!var6.b()) {
         y.c.q var18 = var6.a();
         int var9 = var18.d();
         double var10 = var4[var9];
         y.c.d var10000 = var18.f();

         label77:
         while(true) {
            y.c.d var12;
            y.c.q var13;
            int var14;
            double var15;
            label59:
            while(true) {
               var12 = var10000;

               while(true) {
                  if(var12 == null) {
                     break label59;
                  }

                  var13 = var12.d();
                  var14 = var13.d();
                  var15 = var10 + var3[var12.b()];
                  var10000 = var5[var14];
                  if(var17) {
                     break;
                  }

                  label54: {
                     label95: {
                        if(var10000 == null && var13 != var1) {
                           var4[var14] = var15;
                           var6.a(var13, var15);
                           if(!var17) {
                              break label95;
                           }
                        }

                        if(var15 >= var4[var14]) {
                           break label54;
                        }

                        var4[var14] = var15;
                        var6.b(var13, var15);
                     }

                     var5[var14] = var12;
                  }

                  var12 = var12.g();
                  if(var17) {
                     break label59;
                  }
               }
            }

            if(var2) {
               break;
            }

            var12 = var18.g();

            do {
               if(var12 == null) {
                  continue label79;
               }

               var13 = var12.c();
               var14 = var13.d();
               var15 = var10 + var3[var12.b()];
               var10000 = var5[var14];
               if(var17) {
                  continue label77;
               }

               label72: {
                  label97: {
                     if(var10000 == null && var13 != var1) {
                        var4[var14] = var15;
                        var6.a(var13, var15);
                        if(!var17) {
                           break label97;
                        }
                     }

                     if(var15 >= var4[var14]) {
                        break label72;
                     }

                     var4[var14] = var15;
                     var6.b(var13, var15);
                  }

                  var5[var14] = var12;
               }

               var12 = var12.h();
            } while(!var17);

            return;
         }
      }

   }

   public static double a(y.c.i var0, y.c.q var1, y.c.q var2, boolean var3, double[] var4, y.c.d[] var5) {
      return b(var0, var1, var2, var3, var4, var5);
   }

   public static y.c.f a(y.c.i var0, y.c.q var1, y.c.q var2, boolean var3, double[] var4) {
      y.c.d[] var5 = new y.c.d[var0.e()];
      return a(var0, var1, var2, var3, var4, var5) != Double.POSITIVE_INFINITY?a(var1, var2, var5):new y.c.f();
   }

   private static double b(y.c.i var0, y.c.q var1, y.c.q var2, boolean var3, double[] var4, y.c.d[] var5) {
      boolean var23 = h.a;
      y.c.q[] var6 = new y.c.q[]{var1, var2};
      double[][] var7 = new double[2][var0.e()];
      y.c.d[][] var8 = new y.c.d[2][var0.e()];
      y.g.a.e[] var9 = new y.g.a.e[]{new y.g.a.c(var0), new y.g.a.c(var0)};
      var9[0].a(var6[0], 0.0D);
      var9[1].a(var6[1], 0.0D);
      boolean var10 = var1 != var2;
      double var11 = 0.0D;

      label165:
      while(true) {
         byte var10000 = var9[0].b();

         label163:
         while(true) {
            if(var10000 != 0 && var9[1].b()) {
               break label165;
            }

            var10000 = 0;

            label161:
            while(true) {
               int var13 = var10000;

               while(true) {
                  int var24 = var13;

                  label156:
                  while(true) {
                     if(var24 >= 2) {
                        continue label165;
                     }

                     var10000 = var9[var13].b();
                     if(var23) {
                        continue label163;
                     }

                     if(var23) {
                        continue label161;
                     }

                     if(var10000 != 0) {
                        break;
                     }

                     y.c.q var14 = var9[var13].a();
                     int var15 = var14.d();
                     if((var14 == var6[1 - var13] || var8[1 - var13][var15] != null) && !var9[1 - var13].a(var14) && var7[0][var15] + var7[1][var15] == var11) {
                        y.c.q var26 = var14;
                        int var27 = var14.d();

                        while(true) {
                           if(var26 != var1) {
                              var5[var27] = var8[0][var27];
                              var26 = var5[var27].a(var26);
                              var27 = var26.d();
                              if(var23) {
                                 break;
                              }

                              if(!var23) {
                                 continue;
                              }
                           }

                           var26 = var14;
                           break;
                        }

                        var27 = var26.d();

                        y.c.d var25;
                        while((var25 = var8[1][var27]) != null) {
                           var26 = var25.a(var26);
                           var27 = var26.d();
                           var5[var27] = var25;
                           if(var23) {
                              break;
                           }
                        }

                        return var11;
                     }

                     y.c.d var16;
                     boolean var17;
                     label173: {
                        var17 = false;
                        if(var3 == 0) {
                           var16 = var14.f();
                           if(var16 != null) {
                              break label173;
                           }

                           var16 = var14.g();
                           var17 = true;
                           if(!var23) {
                              break label173;
                           }
                        }

                        if(var13 == 0) {
                           var16 = var14.f();
                           if(!var23) {
                              break label173;
                           }
                        }

                        var16 = var14.g();
                        var17 = true;
                     }

                     while(true) {
                        y.c.q var19;
                        int var20;
                        while(true) {
                           if(var16 == null) {
                              break label156;
                           }

                           int var18 = var16.b();
                           var19 = var16.a(var14);
                           var20 = var19.d();
                           double var21 = var7[var13][var15] + var4[var18];
                           if(var8[var13][var20] == null && var19 != var6[var13]) {
                              var7[var13][var20] = var21;
                              var9[var13].a(var19, var21);
                              if(!var23) {
                                 break;
                              }
                           }

                           if(var21 < var7[var13][var20]) {
                              var9[var13].b(var19, var21);
                              var7[var13][var20] = var21;
                              if(!var23) {
                                 break;
                              }
                           }

                           var16 = var17?var16.h():var16.g();
                           if(var16 == null) {
                              var24 = var3;
                              if(var23) {
                                 continue label156;
                              }

                              if(var3 == 0 && !var17) {
                                 var16 = var14.g();
                                 var17 = true;
                                 if(var23) {
                                    break;
                                 }
                              }
                           }
                        }

                        var8[var13][var20] = var16;
                        if((var19 == var6[1 - var13] || var8[1 - var13][var20] != null) && (var10 || var7[0][var20] + var7[1][var20] < var11)) {
                           var10 = false;
                           var11 = var7[0][var20] + var7[1][var20];
                        }

                        var16 = var17?var16.h():var16.g();
                        if(var16 == null && var3 == 0 && !var17) {
                           var16 = var14.g();
                           var17 = true;
                           if(var23) {
                              break label156;
                           }
                        }
                     }
                  }

                  ++var13;
                  if(var23) {
                     break label165;
                  }
               }
            }
         }
      }

      var5[var2.d()] = null;
      return Double.POSITIVE_INFINITY;
   }

   public static boolean b(y.c.i var0, y.c.q var1, boolean var2, double[] var3, double[] var4, y.c.d[] var5) {
      boolean var19 = h.a;
      int var6 = var0.e();
      int var7 = 0;
      y.g.c var8 = new y.g.c(var6 + 1);
      boolean[] var9 = new boolean[var6];
      int var15 = 0;

      while(true) {
         if(var15 < var6) {
            var5[var15] = null;
            var4[var15] = Double.POSITIVE_INFINITY;
            ++var15;
            if(var19) {
               break;
            }

            if(!var19) {
               continue;
            }
         }

         var4[var1.d()] = 0.0D;
         var8.b(var1);
         var9[var1.d()] = true;
         break;
      }

      var8.b((Object)null);

      y.c.q var11;
      int var13;
      y.c.d var14;
      y.c.d var10000;
      label166:
      while(true) {
         if(var7 < var6) {
            y.c.q var10 = (y.c.q)var8.b();
            if(var10 == null) {
               ++var7;
               if(var8.e()) {
                  return true;
               }

               var8.b((Object)null);
               if(!var19) {
                  continue;
               }
            }

            int var12 = var10.d();
            var9[var12] = false;
            double var20 = var4[var12];
            var14 = var10.f();

            double var17;
            label180: {
               while(var14 != null) {
                  var11 = var14.d();
                  var13 = var11.d();
                  var17 = var20 + var3[var14.b()];
                  var10000 = var5[var13];
                  if(var19) {
                     break label180;
                  }

                  if(var10000 == null && var11 != var1 || var17 < var4[var13]) {
                     var4[var13] = var17;
                     var5[var13] = var14;
                     if(!var9[var13]) {
                        var8.b(var11);
                        var9[var13] = true;
                     }
                  }

                  var14 = var14.g();
                  if(var19) {
                     break;
                  }
               }

               if(var2) {
                  continue;
               }

               var10000 = var10.g();
            }

            var14 = var10000;

            do {
               if(var14 == null) {
                  continue label166;
               }

               var11 = var14.c();
               var13 = var11.d();
               var17 = var20 + var3[var14.b()];
               var10000 = var5[var13];
               if(var19 || var19) {
                  break label166;
               }

               if(var10000 == null && var11 != var1 || var17 < var4[var13]) {
                  var4[var13] = var17;
                  var5[var13] = var14;
                  if(!var9[var13]) {
                     var8.b(var11);
                     var9[var13] = true;
                  }
               }

               var14 = var14.h();
            } while(!var19);
         }

         var10000 = var5[var1.d()];
         break;
      }

      if(var10000 != null) {
         return false;
      } else {
         boolean[] var21 = new boolean[var0.e()];
         boolean[] var16 = new boolean[var0.g()];
         y.c.e var22 = var0.p();

         label117: {
            label116:
            while(true) {
               if(var22.f()) {
                  var14 = var22.a();
                  y.c.d var10001 = var5[var14.d().d()];
                  if(!var19) {
                     if(var14 != var10001) {
                        var16[var14.b()] = true;
                     }

                     var22.g();
                     if(!var19) {
                        continue;
                     }

                     if(var2) {
                        break;
                     }

                     var22 = var0.p();
                  } else {
                     if(var14 != var10001) {
                        var16[var14.b()] = true;
                     }

                     var22.g();
                     if(var19) {
                        break;
                     }
                  }
               } else {
                  if(var2) {
                     break;
                  }

                  var22 = var0.p();
               }

               while(true) {
                  if(!var22.f()) {
                     break label116;
                  }

                  var14 = var22.a();
                  if(var19) {
                     break label117;
                  }

                  if(var14 != var5[var14.c().d()]) {
                     var16[var14.b()] = true;
                  }

                  var22.g();
                  if(var19) {
                     break label116;
                  }
               }
            }

            h.a(var0, var1, var2, var16, var21);
         }

         boolean[] var24 = new boolean[var0.e()];
         y.c.x var18 = var0.o();

         boolean var23;
         while(true) {
            if(var18.f()) {
               var11 = var18.e();
               var13 = var11.d();
               var23 = var9[var13];
               if(var19) {
                  break;
               }

               if(var23 && !var24[var13]) {
                  a(var0, var11, var2, var21, var24, var5);
               }

               var18.g();
               if(!var19) {
                  continue;
               }
            }

            var23 = false;
            break;
         }

         return var23;
      }
   }

   private static void a(y.c.i var0, y.c.q var1, boolean var2, boolean[] var3, boolean[] var4, y.c.d[] var5) {
      boolean var9 = h.a;
      var4[var1.d()] = true;
      y.c.d var6 = var1.f();

      boolean var10000;
      y.c.q var7;
      int var8;
      while(true) {
         if(var6 != null) {
            var7 = var6.d();
            var8 = var7.d();
            var10000 = var4[var8];
            if(var9) {
               break;
            }

            if(!var10000) {
               if(var3[var8]) {
                  var5[var8] = var6;
               }

               a(var0, var7, var2, var3, var4, var5);
            }

            var6 = var6.g();
            if(!var9) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      if(!var10000) {
         var6 = var1.g();

         while(var6 != null) {
            var7 = var6.c();
            var8 = var7.d();
            if(!var4[var8]) {
               if(var3[var8]) {
                  var5[var8] = var6;
               }

               a(var0, var7, var2, var3, var4, var5);
            }

            var6 = var6.h();
            if(var9) {
               break;
            }
         }
      }

   }

   public static boolean a(y.c.i var0, boolean var1, double[] var2, double[][] var3) {
      boolean var17 = h.a;
      int var4 = var0.g();
      y.c.q var5 = var0.d();
      y.c.f var6 = new y.c.f();
      y.c.x var7 = var0.o();

      while(var7.f()) {
         y.c.q var8 = var7.e();
         if(var8 != var5) {
            var6.c(var0.a(var5, var8));
         }

         var7.g();
         if(var17) {
            break;
         }
      }

      double[] var18 = new double[var0.g()];
      double[] var19 = new double[var0.e()];
      y.c.d[] var9 = new y.c.d[var0.e()];
      System.arraycopy(var2, 0, var18, 0, var4);
      boolean var10 = !b(var0, var5, var1, var18, var19, var9);

      while(true) {
         if(!var6.isEmpty()) {
            var0.a(var6.d());
            if(var17) {
               break;
            }

            if(!var17) {
               continue;
            }
         }

         var0.a(var5);
         break;
      }

      if(var10) {
         return false;
      } else {
         y.c.e var11 = var0.p();

         while(var11.f()) {
            y.c.d var12 = var11.a();
            int var13 = var12.b();
            var18[var13] = var19[var12.c().d()] + var2[var13] - var19[var12.d().d()];
            var11.g();
            if(var17) {
               break;
            }
         }

         y.c.x var20 = var0.o();

         y.c.i var10000;
         while(true) {
            if(var20.f()) {
               var10000 = var0;
               if(var17) {
                  break;
               }

               a(var0, var20.e(), var1, var18, var3[var20.e().d()], var9);
               var20.g();
               if(!var17) {
                  continue;
               }
            }

            var10000 = var0;
            break;
         }

         int var21 = Math.min(var10000.e(), var3.length);
         int var22 = 0;

         boolean var24;
         while(true) {
            if(var22 < var21) {
               double var23 = var19[var22];
               int var15 = Math.min(var0.e(), var19.length);
               var24 = false;
               if(var17) {
                  break;
               }

               int var16 = 0;

               label56: {
                  while(var16 < var15) {
                     var3[var22][var16] += var19[var16] - var23;
                     ++var16;
                     if(var17) {
                        break label56;
                     }

                     if(var17) {
                        break;
                     }
                  }

                  ++var22;
               }

               if(!var17) {
                  continue;
               }
            }

            var24 = true;
            break;
         }

         return var24;
      }
   }

   public static double[] a(y.c.i var0) {
      boolean var3 = h.a;
      double[] var1 = new double[var0.g()];
      int var2 = 0;

      double[] var10000;
      while(true) {
         if(var2 < var0.g()) {
            var10000 = var1;
            if(var3) {
               break;
            }

            var1[var2] = 1.0D;
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

   public static y.c.f a(y.c.q var0, y.c.q var1, y.c.d[] var2) {
      return a(var0, var1, y.g.q.a((Object[])var2));
   }

   public static y.c.f a(y.c.q var0, y.c.q var1, y.c.c var2) {
      boolean var5 = h.a;
      y.c.f var3 = new y.c.f();
      y.c.d var4 = (y.c.d)var2.b(var1);

      y.c.f var10000;
      while(true) {
         if(var4 != null) {
            var10000 = var3;
            if(var5) {
               break;
            }

            var3.c(var4);
            var1 = var4.a(var1);
            var4 = (y.c.d)var2.b(var1);
            if(!var5) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }
}
