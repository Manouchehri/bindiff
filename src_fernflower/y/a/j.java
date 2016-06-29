package y.a;

import java.util.HashMap;
import y.a.aa;
import y.a.ad;
import y.a.ag;
import y.a.g;
import y.a.h;

public class j {
   public static int a(y.c.i var0, y.c.A var1, boolean var2, int var3, int var4, y.c.c var5) {
      if(var0.i()) {
         return 0;
      } else if(var3 > var4) {
         throw new IllegalArgumentException("minGroupCount (" + var3 + ") must not be greater than maxGroupCount (" + var4 + ")");
      } else if(var3 > var0.e()) {
         throw new IllegalArgumentException("minGroupCount (" + var3 + ") must not be greater than graph.N() (" + var0.e() + ")");
      } else if(var4 <= 0) {
         throw new IllegalArgumentException("maxGroupCount (" + var4 + ") must be greater than 0");
      } else {
         aa var6 = new aa(var0);
         y.c.h var7 = null;
         if(var5 != null) {
            var7 = var6.u();
            var6.b(var6.p(), var5, var7);
         }

         y.c.A var8 = var6.t();
         var6.a(var6.o(), var1, var8);
         ad var9 = new ad();
         int var10 = var9.a(var6, var8, var3, var4, var2, var7);
         var6.c(var0.o(), var8, var1);
         return var10;
      }
   }

   public static int a(y.c.i var0, y.c.A var1, double var2, int var4, int var5, boolean var6) {
      boolean var12 = h.a;
      if(var0.i()) {
         return 0;
      } else if(var4 > var5) {
         throw new IllegalArgumentException("minGroupCount (" + var4 + ") must not be greater than maxGroupCount (" + var5 + ")");
      } else if(var4 > var0.e()) {
         throw new IllegalArgumentException("minGroupCount (" + var4 + ") must not be greater than graph.N() (" + var0.e() + ")");
      } else if(var5 <= 0) {
         throw new IllegalArgumentException("maxGroupCount (" + var5 + ") must be greater than 0");
      } else {
         aa var7 = new aa(var0);
         y.c.A var8 = var7.t();
         var7.a(var7.o(), var1, var8);
         y.g.I var9 = new y.g.I(var7);
         var9.d();
         if(var6) {
            y.c.e var10 = var7.p();

            while(var10.f()) {
               y.c.d var11 = var10.a();
               if(var8.a(var11.c()) != var8.a(var11.d())) {
                  var9.a(var11);
               }

               var10.g();
               if(var12) {
                  break;
               }
            }
         }

         ag var13 = new ag();
         var13.a(var2 >= 0.0D && var2 <= 1.0D?var2:0.5D);
         var13.c(var4);
         var13.b(var5);
         int var14 = var13.a(var7, var8);
         var7.c(var0.o(), var8, var1);
         return var14;
      }
   }

   public static int a(y.c.i var0, y.c.A var1) {
      boolean var14 = h.a;
      if(g.c(var0)) {
         return b(var0, var1);
      } else {
         aa var2 = new aa(var0);
         y.c.A var3 = var2.t();
         y.c.A var4 = var2.t();
         int var5 = h.a(var2, (y.c.A)var4);
         y.g.J var6 = new y.g.J(var2, var4);
         var6.a();
         int var7 = 0;
         int var8 = 0;
         int var9 = 0;

         int var10000;
         while(true) {
            if(var9 < var5) {
               Integer var10 = new Integer(var9);
               var6.c(var10);
               int var11 = b(var2, var3);
               var10000 = var11;
               if(var14) {
                  break;
               }

               if(var11 == 0) {
                  var11 = 1;
               }

               var7 += var11;
               y.c.x var12 = var2.o();

               label35: {
                  while(var12.f()) {
                     y.c.q var13 = var12.e();
                     var3.a(var13, var3.a(var13) + var8);
                     var12.g();
                     if(var14) {
                        break label35;
                     }

                     if(var14) {
                        break;
                     }
                  }

                  var8 = var7;
                  ++var9;
               }

               if(!var14) {
                  continue;
               }
            }

            var6.b();
            var2.c(var0.o(), var3, var1);
            var10000 = var7;
            break;
         }

         return var10000;
      }
   }

   private static int b(y.c.i var0, y.c.A var1) {
      boolean var14 = h.a;
      y.c.A var2 = y.g.M.a(new Object[var0.e()]);
      y.c.A var3 = y.g.M.a(new boolean[var0.e()]);
      y.c.h var4 = y.g.M.b(new int[var0.g()]);
      int var5 = h.a(var0, var4, var3);
      if(var5 < 1) {
         return 0;
      } else {
         y.c.f[] var6 = h.a(var0, var4, var5);
         y.c.h var7 = y.g.M.b(new Object[var0.g()]);
         int var8 = 0;

         y.c.f var10000;
         while(true) {
            if(var8 < var6.length) {
               y.c.f var9 = var6[var8];
               var10000 = var9;
               if(var14) {
                  break;
               }

               y.c.e var10 = var9.a();

               label50: {
                  while(var10.f()) {
                     var7.a(var10.a(), var9);
                     var10.g();
                     if(var14) {
                        break label50;
                     }

                     if(var14) {
                        break;
                     }
                  }

                  ++var8;
               }

               if(!var14) {
                  continue;
               }
            }

            var10000 = a(var3, var6);
            break;
         }

         y.c.f var15 = var10000;
         a(var15, var3, var7, new HashMap(), var2);
         HashMap var16 = new HashMap();
         int var17 = 0;
         y.c.x var11 = var0.o();

         while(var11.f()) {
            Object var12 = var2.b(var11.e());
            Integer var13 = var12 == null?new Integer(var17++):(Integer)var16.get(var12);
            if(var13 == null) {
               var13 = new Integer(var17++);
               var16.put(var12, var13);
            }

            var1.a(var11.e(), var13.intValue());
            var11.g();
            if(var14) {
               break;
            }
         }

         return var17;
      }
   }

   static y.c.f a(y.c.A var0, y.c.f[] var1) {
      boolean var6 = h.a;
      y.c.f var2 = null;
      int var3 = -1;
      int var4 = 0;

      y.c.f var10000;
      while(true) {
         if(var4 < var1.length) {
            y.c.f var5 = var1[var4];
            var10000 = var5;
            if(var6) {
               break;
            }

            if(var5.size() > var3) {
               var2 = var5;
               var3 = var5.size();
            }

            ++var4;
            if(!var6) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   static void a(y.c.f var0, y.c.A var1, y.c.h var2, HashMap var3, y.c.A var4) {
      boolean var13 = h.a;
      if(!var3.containsKey(var0)) {
         var3.put(var0, Boolean.TRUE);
         y.c.q[] var5 = new y.c.q[2];
         y.c.e var6 = var0.a();

         do {
            boolean var10000 = var6.f();

            label63:
            while(true) {
               if(!var10000) {
                  return;
               }

               y.c.d var7 = var6.a();
               var5[0] = var7.c();
               var5[1] = var7.d();
               int var8 = 0;

               while(true) {
                  int var14 = var8;

                  label58: {
                     y.c.q var9;
                     label57:
                     while(true) {
                        if(var14 >= 2) {
                           break label63;
                        }

                        var9 = var5[var8];
                        var10000 = var1.d(var9);
                        if(var13) {
                           continue label63;
                        }

                        if(!var10000) {
                           break;
                        }

                        if(var4.b(var9) != null) {
                           break label58;
                        }

                        if(var0.size() > 1) {
                           var4.a(var9, var0);
                        }

                        y.c.e var10 = var9.j();

                        while(true) {
                           if(!var10.f()) {
                              break label58;
                           }

                           y.c.d var11 = var10.a();
                           var14 = var11.e();
                           if(var13) {
                              break;
                           }

                           if(var14 == 0) {
                              y.c.f var12 = (y.c.f)var2.b(var11);
                              a(var12, var1, var2, var3, var4);
                           }

                           var10.g();
                           if(var13) {
                              break label57;
                           }
                        }
                     }

                     var4.a(var9, var0);
                  }

                  ++var8;
                  if(var13) {
                     break label63;
                  }
               }
            }

            var6.g();
         } while(!var13);

      }
   }
}
