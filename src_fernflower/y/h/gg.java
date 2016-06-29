package y.h;

import y.h.aB;
import y.h.bu;
import y.h.eU;
import y.h.fj;
import y.h.gZ;
import y.h.gh;
import y.h.gi;
import y.h.gk;
import y.h.gl;
import y.h.x;
import y.h.y;
import y.h.z;

public abstract class gg {
   public static boolean a(bu var0, Object var1) {
      return var1 instanceof y.c.q && var0.v((y.c.q)var1) || var1 instanceof y.c.d && var0.r((y.c.d)var1) || var1 instanceof x && var0.a((x)var1) || var1 instanceof gZ && var0.a((gZ)var1) || var1 instanceof eU && var0.a((eU)var1);
   }

   public static void a(bu var0, y.c.q var1) {
      boolean var5 = fj.z;
      var0.a(var1, true);
      y.c.e var2 = var1.l();

      while(var2.f()) {
         label27: {
            y.c.d var3 = var2.a();
            if(var3.e()) {
               y var4 = var0.i(var3).bends();

               while(var4.f()) {
                  var0.a(var4.a(), true);
                  var4.g();
                  if(var5) {
                     break label27;
                  }

                  if(var5) {
                     break;
                  }
               }
            }

            var2.g();
         }

         if(var5) {
            break;
         }
      }

   }

   public static void b(bu var0, y.c.q var1) {
      boolean var5 = fj.z;
      var0.a(var1, false);
      y.c.e var2 = var1.l();

      while(var2.f()) {
         label27: {
            y.c.d var3 = var2.a();
            if(var3.e()) {
               y var4 = var0.i(var3).bends();

               while(var4.f()) {
                  var0.a(var4.a(), false);
                  var4.g();
                  if(var5) {
                     break label27;
                  }

                  if(var5) {
                     break;
                  }
               }
            }

            var2.g();
         }

         if(var5) {
            break;
         }
      }

   }

   public static y.c.A a(bu var0) {
      return new gl(var0);
   }

   public static y.c.h b(bu var0) {
      return new gk(var0);
   }

   public static void a(bu var0, y.c.y var1, y.c.y var2, z var3) {
      a(var0, new gh(var0), new gi(var0), var1, var2, var3);
   }

   static void a(bu var0, y.g.z var1, y.g.z var2, y.c.y var3, y.c.y var4, z var5) {
      boolean var11 = fj.z;
      y.h.a.v var6 = y.h.a.v.a((y.c.i)var0);
      if(var6 != null) {
         boolean[] var7 = new boolean[var0.e()];
         y.c.x var8 = var0.o();

         while(var8.f()) {
            y.c.q var10000 = var8.e();

            label52:
            while(true) {
               y.c.q var9 = var10000;
               if(!var1.a(var9)) {
                  break;
               }

               if(var6.k(var9) && !var7[var9.d()]) {
                  a(var6, var0, var1, var2, var9, var9, var3, var5, var7);
               }

               y.c.q var10 = var6.n(var9);

               while(true) {
                  if(!var6.k(var10)) {
                     break label52;
                  }

                  var10000 = var10;
                  if(var11) {
                     break;
                  }

                  if(var10.e() != var0 || var7[var10.d()]) {
                     break label52;
                  }

                  label47: {
                     if(var1.a(var10)) {
                        a(var6, var0, var1, var2, var10, var10, var3, var5, var7);
                        if(!var11) {
                           break label47;
                        }
                     }

                     var4.add(var10);
                  }

                  var7[var10.d()] = true;
                  var10 = var6.n(var10);
                  if(var11) {
                     break label52;
                  }
               }
            }

            var8.g();
            if(var11) {
               break;
            }
         }

      }
   }

   private static void a(y.h.a.v var0, bu var1, y.g.z var2, y.g.z var3, y.c.q var4, y.c.q var5, y.c.y var6, z var7, boolean[] var8) {
      boolean var14 = fj.z;
      y.c.x var9 = var0.p(var5);

      do {
         int var10000 = var9.f();

         label65:
         while(true) {
            if(var10000 == 0) {
               return;
            }

            y.c.q var10 = var9.e();
            if(var6 != null && !var8[var10.d()] && !var2.a(var10)) {
               var6.add(var10);
               var8[var10.d()] = true;
            }

            if(var0.k(var10)) {
               a(var0, var1, var2, var3, var4, var10, var6, var7, var8);
            }

            if(var7 == null) {
               break;
            }

            y.c.d var11 = var10.f();

            while(true) {
               if(var11 == null) {
                  break label65;
               }

               aB var12 = var1.i(var11);
               var10000 = var12.bendCount();
               if(var14) {
                  break;
               }

               if(var10000 > 0 && var0.b(var4, var11.d())) {
                  y var13 = var12.bends();

                  while(var13.f()) {
                     var10000 = var3.a(var13.a());
                     if(var14) {
                        continue label65;
                     }

                     if(var10000 == 0) {
                        var7.add(var13.a());
                     }

                     var13.g();
                     if(var14) {
                        break;
                     }
                  }
               }

               var11 = var11.g();
               if(var14) {
                  break label65;
               }
            }
         }

         var9.g();
      } while(!var14);

   }
}
