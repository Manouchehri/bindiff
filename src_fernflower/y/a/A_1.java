package y.a;

import java.util.Arrays;
import y.a.B;
import y.a.C;
import y.a.b;
import y.a.h;

public class A {
   public static y.c.f[] a(y.c.i var0, y.c.y[] var1) {
      boolean var12 = h.a;
      y.c.f[] var2 = new y.c.f[var1.length];
      int[] var3 = new int[var0.f()];
      int var4 = 1;
      int var5 = 0;

      label64:
      do {
         int var10000 = var5;
         int var10001 = var1.length;

         label61:
         while(var10000 < var10001) {
            y.c.y var6 = var1[var5];
            y.c.f var7 = new y.c.f();
            y.c.x var8 = var6.a();

            label39: {
               while(var8.f()) {
                  var3[var8.e().d()] = var4;
                  var8.g();
                  if(var12) {
                     break label39;
                  }

                  if(var12) {
                     break;
                  }
               }

               var8 = var6.a();
            }

            while(var8.f()) {
               y.c.q var9 = var8.e();
               if(var12) {
                  continue label64;
               }

               y.c.e var10 = var9.l();

               while(var10.f()) {
                  y.c.d var11 = var10.a();
                  var10000 = var3[var11.a(var9).d()];
                  var10001 = var4;
                  if(var12) {
                     continue label61;
                  }

                  if(var10000 == var4 && !var11.e()) {
                     var7.c(var11);
                  }

                  var10.g();
                  if(var12) {
                     break;
                  }
               }

               var8.g();
               if(var12) {
                  break;
               }
            }

            var2[var5] = var7;
            ++var5;
            ++var4;
            continue label64;
         }

         return var2;
      } while(!var12);

      return var2;
   }

   public static y.c.y[] a(y.c.i var0) {
      boolean var11 = h.a;
      int[] var1 = new int[var0.f()];
      y.c.D var2 = new y.c.D();
      y.c.y var3 = new y.c.y();
      boolean var5 = false;
      y.c.x var6 = var0.o();

      y.c.q var4;
      int var10000;
      label89:
      while(true) {
         if(var6.f()) {
            var4 = var6.e();
            var1[var4.d()] = var4.c();
            var10000 = var4.c();
            if(!var11) {
               if(var10000 == 0 && var4.b() == 1) {
                  var3.b(var4);
               }

               var6.g();
               if(!var11) {
                  continue;
               }

               var10000 = var3.isEmpty();
            }
         } else {
            var10000 = var3.isEmpty();
         }

         while(true) {
            if(var10000 != 0) {
               break label89;
            }

            var4 = var3.d();
            if(var4.b() > 0) {
               y.c.q var12 = var4.g().c();
               --var1[var12.d()];
               if(var12.b() <= 1 && var1[var12.d()] == 0) {
                  var3.b(var12);
                  if(var11) {
                     break label89;
                  }
               }
            }

            var10000 = var3.isEmpty();
         }
      }

      var6 = var0.o();

      do {
         var10000 = var6.f();

         label64:
         while(true) {
            if(var10000 == 0) {
               return (y.c.y[])var2.toArray(new y.c.y[var2.size()]);
            }

            var4 = var6.e();
            int var8 = var1[var4.d()];
            y.c.y var7;
            if(var8 == 0 && var4.b() != 1 && var4.c() > 0) {
               var7 = new y.c.y();
               var7.b(var4);
               a(var4, var7);
               var2.b((Object)var7);
               if(!var11) {
                  break;
               }
            }

            if(var8 <= 0 || var8 >= var4.c()) {
               break;
            }

            var7 = new y.c.y();
            var7.b(var4);
            y.c.x var9 = var4.o();

            while(var9.f()) {
               y.c.q var10 = var9.e();
               var10000 = var1[var10.d()];
               if(var11) {
                  continue label64;
               }

               if(var10000 == 0 && var10.b() == 1) {
                  var7.b(var10);
                  a(var10, var7);
               }

               var9.g();
               if(var11) {
                  break;
               }
            }

            var2.b((Object)var7);
            break;
         }

         var6.g();
      } while(!var11);

      return (y.c.y[])var2.toArray(new y.c.y[var2.size()]);
   }

   public static boolean b(y.c.i var0) {
      if(var0.i()) {
         return true;
      } else if(var0.e() != var0.g() + 1) {
         return false;
      } else {
         C var1 = new C();

         try {
            var1.a(var0);
            return true;
         } catch (y.c.B var3) {
            return false;
         }
      }
   }

   public static y.c.y a(y.c.i var0, boolean var1) {
      boolean var5 = h.a;
      y.c.y var2 = new y.c.y();
      y.c.x var3 = var0.o();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         if(var1 && var4.c() == 0 || !var1 && var4.a() == 1) {
            var2.add(var4);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

      return var2;
   }

   public static y.c.q c(y.c.i var0) {
      if(var0.e() == 1) {
         return var0.k();
      } else {
         y.c.y[] var1 = b.a(var0, a(var0, false));
         return var1[var1.length - 1].b();
      }
   }

   public static y.c.q d(y.c.i var0) {
      boolean var4 = h.a;
      y.c.x var1 = var0.o();
      y.c.q var2 = null;
      int var3 = 0;
      var1.i();

      int var10000;
      while(true) {
         if(var1.f()) {
            var10000 = var1.e().b();
            if(var4) {
               break;
            }

            if(var10000 == 0) {
               var2 = var1.e();
               ++var3;
            }

            var1.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      if(var10000 == 1) {
         return var2;
      } else {
         var3 = 0;
         var1.i();

         while(true) {
            if(var1.f()) {
               var10000 = var1.e().c();
               if(var4) {
                  break;
               }

               if(var10000 == 0) {
                  var2 = var1.e();
                  ++var3;
               }

               var1.g();
               if(!var4) {
                  continue;
               }
            }

            var10000 = var3;
            break;
         }

         return var10000 == 1?var2:f(var0);
      }
   }

   public static y.c.f e(y.c.i var0) {
      return a(var0, d(var0));
   }

   public static y.c.q f(y.c.i var0) {
      int[] var1 = new int[var0.f()];
      y.c.A var2 = y.g.M.a(var1);
      return a(var0, var2);
   }

   public static y.c.q a(y.c.i var0, y.c.A var1) {
      boolean var7 = h.a;
      y.c.q var2 = var0.k();
      y.c.q[] var3 = new y.c.q[1];
      int[] var4 = new int[var0.f()];
      Arrays.fill(var4, -1);
      y.c.f var5 = a(var0, var2);
      a(var2, var1, var3, var4, -1);
      y.c.e var6 = var5.a();

      while(var6.f()) {
         var0.c(var6.a());
         var6.g();
         if(var7) {
            break;
         }
      }

      return var3[0];
   }

   private static int a(y.c.q var0, y.c.A var1, y.c.q[] var2, int[] var3, int var4) {
      boolean var11 = h.a;
      int var5 = 0;
      y.c.d var6 = var0.f();

      int var10000;
      int var10001;
      while(true) {
         if(var6 != null) {
            y.c.q var7 = var6.d();
            int var8 = a(var7, var1, var2, var3, var4);
            var10000 = var8;
            var10001 = var4;
            if(var11) {
               break;
            }

            if(var8 > var4) {
               var4 = var8;
            }

            var5 += var3[var7.d()];
            var6 = var6.g();
            if(!var11) {
               continue;
            }
         }

         var10000 = var5;
         var10001 = var0.e().e() - 1 - var5;
         break;
      }

      int var12 = var10000 * var10001;
      y.c.d var13 = var0.f();

      while(true) {
         if(var13 != null) {
            y.c.q var14 = var13.d();
            if(var11) {
               break;
            }

            y.c.d var9 = var13.g();

            label39: {
               while(var9 != null) {
                  y.c.q var10 = var9.d();
                  var12 += var3[var14.d()] * var3[var10.d()];
                  var9 = var9.g();
                  if(var11) {
                     break label39;
                  }

                  if(var11) {
                     break;
                  }
               }

               var13 = var13.g();
            }

            if(!var11) {
               continue;
            }
         }

         var1.a(var0, var12);
         var3[var0.d()] = var5 + 1;
         break;
      }

      if(var12 > var4) {
         var4 = var12;
         var2[0] = var0;
      }

      return var4;
   }

   public static y.c.f a(y.c.i var0, y.c.q var1) {
      boolean var5 = h.a;
      y.c.f var2 = new y.c.f();
      B var3 = new B(var2);
      var3.a(false);
      var3.a(var0, var1);
      y.c.e var4 = var2.a();

      while(var4.f()) {
         var0.c(var4.a());
         var4.g();
         if(var5) {
            break;
         }
      }

      return var2;
   }

   private static void a(y.c.q var0, y.c.y var1) {
      boolean var4 = h.a;
      y.c.x var2 = var0.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         var1.b(var3);
         a(var3, var1);
         var2.g();
         if(var4) {
            break;
         }
      }

   }

   public static y.c.q a(y.c.i var0, y.c.q var1, boolean var2, y.c.y var3) {
      boolean var9 = h.a;
      if(var3.size() == 0) {
         return null;
      } else {
         int[] var4 = new int[var0.e()];
         y.c.x var5 = var3.a();
         y.c.q var6 = var5.e();
         if(var6 == var1) {
            return var1;
         } else {
            int var7 = 1;

            while(true) {
               if(var6 != var1) {
                  var4[var6.d()] = var7++;
                  var6 = a(var6, var2);
                  if(var9) {
                     break;
                  }

                  if(!var9) {
                     continue;
                  }
               }

               var4[var6.d()] = var7;
               break;
            }

            y.c.q var8 = a(var5.e(), var2);
            var5.g();

            while(var8 != var1 && var5.f()) {
               var6 = var5.e();
               if(var6 == var1) {
                  return var1;
               }

               label70: {
                  if(var4[var6.d()] >= var4[var8.d()]) {
                     var8 = a(var6, var2);
                     if(!var9) {
                        break label70;
                     }
                  }

                  while(true) {
                     if(var4[var6.d()] == 0) {
                        var4[var6.d()] = 1;
                        var6 = a(var6, var2);
                        if(var9) {
                           break;
                        }

                        if(!var9) {
                           continue;
                        }
                     }

                     if(var4[var6.d()] == 1) {
                        break label70;
                     }
                     break;
                  }

                  if(var4[var6.d()] > var4[var8.d()]) {
                     var8 = var6;
                  }
               }

               var5.g();
               if(var9) {
                  break;
               }
            }

            return var8;
         }
      }
   }

   private static y.c.q a(y.c.q var0, boolean var1) {
      return var1?var0.g().c():var0.f().d();
   }

   public static void b(y.c.i var0, y.c.A var1) {
      y.c.q var2 = d(var0);
      a(var2, var1);
   }

   private static int a(y.c.q var0, y.c.A var1) {
      boolean var5 = h.a;
      int var2 = 0;
      y.c.d var3 = var0.f();

      while(true) {
         if(var3 != null) {
            y.c.q var4 = var3.d();
            var2 = Math.max(var2, a(var4, var1));
            var3 = var3.g();
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         var1.a(var0, var2 + 1);
         break;
      }

      return var2 + 1;
   }
}
