package y.a;

import y.a.i;

public class h {
   public static boolean a;

   public static y.c.y[] a(y.c.i var0) {
      y.c.A var1 = y.g.M.a(new int[var0.e()]);
      return a(var0, var1, a(var0, var1));
   }

   public static int a(y.c.i var0, y.c.A var1) {
      boolean var6 = a;
      y.c.x var2 = var0.o();

      while(var2.f()) {
         var1.a(var2.e(), -1);
         var2.g();
         if(var6) {
            break;
         }
      }

      int var7 = 0;
      y.g.d var3 = new y.g.d(var0.e());
      y.c.x var4 = var0.o();

      int var10000;
      while(true) {
         if(var4.f()) {
            y.c.q var5 = var4.e();
            var10000 = var1.a(var5);
            if(var6) {
               break;
            }

            if(var10000 == -1) {
               a(var5, var3, var1, var7++);
            }

            var4.g();
            if(!var6) {
               continue;
            }
         }

         var10000 = var7;
         break;
      }

      return var10000;
   }

   public static y.c.f b(y.c.i var0) {
      boolean var5 = a;
      y.c.f var1 = new y.c.f();
      y.c.y[] var2 = a(var0);
      int var3 = 0;

      y.c.f var10000;
      while(true) {
         if(var3 < var2.length - 1) {
            y.c.d var4 = var0.a(var2[var3].b(), var2[var3 + 1].c());
            var10000 = var1;
            if(var5) {
               break;
            }

            var1.add(var4);
            ++var3;
            if(!var5) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public static y.c.y[] a(y.c.i var0, y.c.A var1, int var2) {
      boolean var5 = a;
      y.c.y[] var3 = new y.c.y[var2];
      int var4 = 0;

      while(var4 < var2) {
         var3[var4] = new y.c.y();
         ++var4;
         if(var5) {
            break;
         }
      }

      y.c.x var6 = var0.o();

      y.c.y[] var10000;
      while(true) {
         if(var6.f()) {
            var10000 = var3;
            if(var5) {
               break;
            }

            var3[var1.a(var6.e())].b(var6.e());
            var6.g();
            if(!var5) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   public static boolean c(y.c.i var0) {
      return var0.i()?true:(var0.g() < var0.e() - 1?false:a(var0, y.g.M.a(new int[var0.e()])) <= 1);
   }

   private static void a(y.c.q var0, y.g.d var1, y.c.A var2, int var3) {
      boolean var6 = a;
      var1.a(var0);
      var2.a(var0, var3);

      label69:
      while(!var1.c()) {
         var0 = (y.c.q)var1.b();
         y.c.d var4 = var0.f();

         while(true) {
            int var10000;
            byte var10001;
            y.c.q var5;
            if(var4 != null) {
               var5 = var4.d();
               var10000 = var2.a(var5);
               var10001 = -1;
               if(!var6) {
                  if(var10000 == -1) {
                     var2.a(var5, var3);
                     var1.a(var5);
                  }

                  var4 = var4.g();
                  if(!var6) {
                     continue;
                  }

                  var4 = var0.g();
                  if(var4 == null) {
                     break;
                  }

                  var5 = var4.c();
                  var10000 = var2.a(var5);
                  var10001 = -1;
               }
            } else {
               var4 = var0.g();
               if(var4 == null) {
                  break;
               }

               var5 = var4.c();
               var10000 = var2.a(var5);
               var10001 = -1;
            }

            while(true) {
               if(!var6) {
                  if(var10000 == var10001) {
                     var2.a(var5, var3);
                     var1.a(var5);
                  }

                  var4 = var4.h();
                  if(var6) {
                     return;
                  }
               } else {
                  if(var10000 == var10001) {
                     var2.a(var5, var3);
                     var1.a(var5);
                  }

                  var4 = var4.g();
                  if(!var6) {
                     break;
                  }

                  var4 = var0.g();
               }

               if(var4 == null) {
                  continue label69;
               }

               var5 = var4.c();
               var10000 = var2.a(var5);
               var10001 = -1;
            }
         }
      }

   }

   public static y.c.f[] d(y.c.i var0) {
      y.c.h var1 = y.g.M.b(new int[var0.g()]);
      int var2 = a(var0, var1);
      return a(var0, var1, var2);
   }

   public static int a(y.c.i var0, y.c.h var1) {
      return a(var0, var1, y.g.M.a(new boolean[var0.e()]));
   }

   public static int a(y.c.i var0, y.c.h var1, y.c.A var2) {
      i var3 = new i(var1, var2);
      var3.a(var0);
      return var3.k;
   }

   public static y.c.f[] a(y.c.i var0, y.c.h var1, int var2) {
      boolean var6 = a;
      y.c.f[] var3 = new y.c.f[var2];
      int var4 = 0;

      while(var4 < var2) {
         var3[var4] = new y.c.f();
         ++var4;
         if(var6) {
            break;
         }
      }

      y.c.e var7 = var0.p();

      while(var7.f()) {
         int var5 = var1.a(var7.a());
         if(var5 > -1) {
            var3[var5].add(var7.a());
         }

         var7.g();
         if(var6) {
            break;
         }
      }

      return var3;
   }

   public static y.c.f e(y.c.i var0) {
      boolean var12 = a;
      y.c.f var1 = new y.c.f();
      y.c.A var2 = y.g.M.a(new boolean[var0.e()]);
      y.c.h var3 = y.g.M.b(new int[var0.g()]);
      int var4 = a(var0, var3, var2);
      y.c.f[] var5 = a(var0, var3, var4);
      y.c.f var15;
      if(var5.length > 1) {
         y.c.y var6 = new y.c.y();
         int var7 = 0;

         label96:
         do {
            int var10000 = var7;

            y.c.q var10;
            label104: {
               y.c.f var8;
               y.c.d var9;
               label92:
               while(true) {
                  if(var10000 >= var5.length) {
                     break label96;
                  }

                  var8 = var5[var7];
                  var10 = null;
                  var15 = var8;
                  if(var12) {
                     return var15;
                  }

                  if(var8.size() == 1) {
                     var9 = var8.b();
                     if(var9.c().a() == 1) {
                        var10 = var9.c();
                     } else if(var9.d().a() == 1) {
                        var10 = var9.d();
                     }
                     break label104;
                  }

                  y.c.e var11 = var8.a();

                  while(true) {
                     if(!var11.f()) {
                        break label92;
                     }

                     var9 = var11.a();
                     var10000 = var2.d(var9.c());
                     if(var12) {
                        break;
                     }

                     if(var10000 != 0) {
                        label110: {
                           if(var10 == null) {
                              var10 = var9.c();
                              if(!var12) {
                                 break label110;
                              }
                           }

                           if(var10 != var9.c()) {
                              var10 = null;
                              break label92;
                           }
                        }
                     }

                     if(var2.d(var9.d())) {
                        label111: {
                           if(var10 == null) {
                              var10 = var9.d();
                              if(!var12) {
                                 break label111;
                              }
                           }

                           if(var10 != var9.d()) {
                              var10 = null;
                              break label92;
                           }
                        }
                     }

                     var11.g();
                     if(var12) {
                        break label92;
                     }
                  }
               }

               if(var10 != null) {
                  label112: {
                     var9 = var8.b();
                     if(var9.c() != var10) {
                        var10 = var9.c();
                        if(!var12) {
                           break label112;
                        }
                     }

                     var10 = var9.d();
                  }
               }
            }

            if(var10 != null) {
               var6.add(var10);
            }

            ++var7;
         } while(!var12);

         y.c.q var13 = var6.d();

         while(!var6.isEmpty()) {
            y.c.q var14 = var6.d();
            var15 = var1;
            if(var12) {
               return var15;
            }

            var1.c(var0.a(var13, var14));
            var13 = var14;
            if(var12) {
               break;
            }
         }
      }

      var15 = var1;
      return var15;
   }

   public static void a(y.c.i var0, y.c.q var1, boolean var2, boolean[] var3) {
      boolean var5 = a;
      int var4 = 0;

      while(true) {
         if(var4 < var3.length) {
            var3[var4] = false;
            ++var4;
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         a(var1, var2, var3);
         break;
      }

   }

   public static void a(y.c.i var0, y.c.q var1, boolean var2, boolean[] var3, boolean[] var4) {
      boolean var6 = a;
      int var5 = 0;

      while(true) {
         if(var5 < var4.length) {
            var4[var5] = false;
            ++var5;
            if(var6) {
               break;
            }

            if(!var6) {
               continue;
            }
         }

         a(var1, var2, var3, var4);
         break;
      }

   }

   private static void a(y.c.q var0, boolean var1, boolean[] var2, boolean[] var3) {
      boolean var8 = a;
      var3[var0.d()] = true;
      y.c.e var4 = var1?var0.l():var0.j();

      while(var4.f()) {
         y.c.d var5 = var4.a();
         if(!var2[var5.b()]) {
            y.c.q var6 = var5.a(var0);
            int var7 = var6.d();
            if(!var3[var7]) {
               a(var6, var1, var2, var3);
            }
         }

         var4.g();
         if(var8) {
            break;
         }
      }

   }

   private static void a(y.c.q var0, boolean var1, boolean[] var2) {
      boolean var6 = a;
      var2[var0.d()] = true;
      y.c.x var3 = var1?var0.o():var0.m();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         int var5 = var4.d();
         if(!var2[var5]) {
            a(var4, var1, var2);
         }

         var3.g();
         if(var6) {
            break;
         }
      }

   }
}
