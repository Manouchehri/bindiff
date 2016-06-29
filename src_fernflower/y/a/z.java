package y.a;

import java.util.Comparator;
import y.a.h;
import y.a.m;

public class z {
   public static void a(y.c.i var0) {
      a((y.c.i)var0, (y.c.f)null);
   }

   public static void a(y.c.i var0, y.c.f var1) {
      boolean var14 = h.a;
      int[] var2 = b(var0);
      y.c.y var3 = m.c(var0, var2);
      y.c.D var4 = new y.c.D();
      a(var3, var4);
      y.c.y[] var5 = new y.c.y[var4.size()];
      var4.toArray(var5);
      int[][] var6 = a(var5, m.c(var0, var2), var2);
      y.c.x var9 = var0.o();

      while(var9.f()) {
         y.c.q var7 = var9.e();
         int var10 = var2[var7.d()];
         int var11 = 0;

         y.c.x var15;
         label51:
         while(true) {
            int var10000 = var11;
            int var10001 = var5.length;

            label48:
            while(var10000 < var10001) {
               var15 = var5[var11].a();
               if(var14) {
                  break label51;
               }

               y.c.x var12 = var15;

               while(var12.f()) {
                  y.c.q var8 = var12.e();
                  var10000 = var6[var11][var10];
                  var10001 = var2[var8.d()];
                  if(var14) {
                     continue label48;
                  }

                  if(var10000 <= var10001 && var7 != var8 && !var0.b(var7, var8)) {
                     y.c.d var13 = var0.a(var7, var8);
                     if(var1 != null) {
                        var1.add(var13);
                     }
                  }

                  var12.g();
                  if(var14) {
                     break;
                  }
               }

               ++var11;
               if(!var14) {
                  continue label51;
               }
               break;
            }

            var15 = var9;
            break;
         }

         var15.g();
         if(var14) {
            break;
         }
      }

   }

   private static void a(y.c.y var0, y.c.D var1) {
      boolean var6 = h.a;

      while(!var0.isEmpty()) {
         y.c.y var2 = new y.c.y();
         y.c.q var10000 = var0.b();

         label29:
         while(true) {
            y.c.q var3 = var10000;
            var0.remove(var3);
            var2.add(var3);
            y.c.x var5 = var0.a();

            while(true) {
               if(!var5.f()) {
                  break label29;
               }

               y.c.q var4 = var5.e();
               var10000 = var3;
               if(var6) {
                  break;
               }

               if(var3.a(var4) != null) {
                  var0.remove(var4);
                  var2.add(var4);
                  var3 = var4;
               }

               var5.g();
               if(var6) {
                  break label29;
               }
            }
         }

         var1.add(var2);
         if(var6) {
            break;
         }
      }

   }

   private static int[][] a(y.c.y[] var0, y.c.y var1, int[] var2) {
      boolean var10 = h.a;
      int[] var3 = new int[var2.length];
      int var4 = 0;

      y.c.x var5;
      y.c.y[] var10000;
      while(true) {
         if(var4 < var0.length) {
            var10000 = var0;
            if(var10) {
               break;
            }

            var5 = var0[var4].a();

            label95: {
               while(var5.f()) {
                  var3[var2[var5.e().d()]] = var4;
                  var5.g();
                  if(var10) {
                     break label95;
                  }

                  if(var10) {
                     break;
                  }
               }

               ++var4;
            }

            if(!var10) {
               continue;
            }
         }

         var10000 = var0;
         break;
      }

      int[][] var11 = new int[var10000.length][var3.length];
      int var12 = 0;

      int var6;
      while(var12 < var0.length) {
         var6 = 0;

         while(true) {
            if(var6 < var3.length) {
               var11[var12][var6] = Integer.MAX_VALUE;
               ++var6;
               if(var10) {
                  break;
               }

               if(!var10) {
                  continue;
               }
            }

            ++var12;
            break;
         }

         if(var10) {
            break;
         }
      }

      var5 = var1.a();
      var5.j();

      do {
         int var13 = var5.f();

         label61:
         while(true) {
            if(var13 == 0) {
               return var11;
            }

            var6 = var2[var5.e().d()];
            y.c.e var7 = var5.e().l();

            while(true) {
               if(!var7.f()) {
                  break label61;
               }

               int var8 = var2[var7.a().d().d()];
               var13 = var8;
               if(var10) {
                  break;
               }

               label56: {
                  if(var8 <= var11[var3[var8]][var8]) {
                     int var9 = 0;

                     while(var9 < var0.length) {
                        var11[var9][var6] = Math.min(var11[var9][var6], var11[var9][var8]);
                        ++var9;
                        if(var10) {
                           break label56;
                        }

                        if(var10) {
                           break;
                        }
                     }
                  }

                  var7.g();
               }

               if(var10) {
                  break label61;
               }
            }
         }

         var11[var3[var6]][var6] = var6;
         var5.h();
      } while(!var10);

      return var11;
   }

   private static int[] b(y.c.i var0) {
      int[] var1 = new int[var0.f()];
      boolean var2 = m.a(var0, var1);
      if(!var2) {
         throw new y.c.B("Graph must be acyclic for this operation");
      } else {
         var0.a((Comparator)null, (Comparator)y.g.e.a(y.g.M.a(var1)));
         return var1;
      }
   }
}
