package y.f.c.a;

import java.util.HashSet;
import java.util.Map;
import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.bs;
import y.f.c.a.db;
import y.f.c.a.dq;
import y.f.c.a.dr;
import y.f.c.a.ds;

class dp {
   private static final double a = Math.sqrt(2.0D);
   private y.c.D b;
   private y.c.D c;
   private Map d;
   private Map e;
   private db f;

   void a(db var1) {
      this.f = var1;
   }

   public void a(y.f.X param1, aU param2, aV param3, aP param4, y.c.h param5, y.g.ap param6) {
      // $FF: Couldn't be decompiled
   }

   private static boolean a(aV var0, y.c.d var1) {
      if(var0 != null && var0.a(var1) != null && var0.a(var1).k() != null) {
         bs var2 = var0.a(var1).k().h();
         return var2.b() == 1;
      } else {
         return false;
      }
   }

   private static double b(aV var0, y.c.d var1) {
      return var0 != null && var0.a(var1) != null && var0.a(var1).k() != null?var0.a(var1).k().i():0.0D;
   }

   public void a(y.f.X param1, aU param2, aV param3, HashSet param4) {
      // $FF: Couldn't be decompiled
   }

   private static boolean a(y.d.t var0, y.d.t var1) {
      return Math.abs(var0.a - var1.a) < 0.001D && var0.b < var1.b;
   }

   private static boolean b(y.d.t var0, y.d.t var1) {
      return Math.abs(var0.b - var1.b) < 0.001D;
   }

   public void a(y.f.X var1, aV var2, HashSet var3) {
      boolean var7 = N.x;
      y.c.e var4 = var1.p();

      while(var4.f()) {
         y.c.d var5 = var4.a();
         A var6 = var2.a(var5);
         if(!var5.e() && !a(var5, var2) && (var6.g() != null || var6.h() != null) && a(var2, var5)) {
            a(var5, var1, var2, var3);
         }

         var4.g();
         if(var7) {
            break;
         }
      }

   }

   private static boolean a(y.c.d var0, aV var1) {
      return var1.a(var0.c()).j() == var1.a(var0.d()).j();
   }

   private static void a(y.c.D var0, y.d.t var1) {
      if(var0.isEmpty() || !var0.i().equals(var1)) {
         var0.add(var1);
      }

   }

   private static void a(y.c.D var0, double var1, double var3) {
      y.d.t var5 = (y.d.t)var0.i();
      if(var5 == null || var5.a != var1 || var5.b != var3) {
         var0.add(new y.d.t(var1, var3));
      }

   }

   private static boolean b(y.c.d var0, aV var1) {
      if(var1 != null && var1.a(var0) != null && var1.a(var0).k() != null) {
         bs var2 = var1.a(var0).k().h();
         return var2.c() == 1;
      } else {
         return false;
      }
   }

   private static void a(y.c.d var0, y.f.X var1, aV var2, HashSet var3) {
      boolean var21 = N.x;
      y.c.D var4 = var1.m(var0);
      if(var4.size() >= 4) {
         y.d.t[] var5 = (y.d.t[])var4.toArray(new y.d.t[var4.size()]);
         boolean var6 = b(var0, var2);
         double var7 = b(var2, var0);
         double var9 = var7 / a;
         y.c.D var11 = new y.c.D();
         y.d.t var12 = var5[0];
         y.d.t var13 = var5[1];
         int var14 = 2;

         while(true) {
            if(var14 + 1 < var5.length) {
               y.d.t var15 = var5[var14];
               y.d.t var16 = var5[var14 + 1];
               if(var21) {
                  break;
               }

               label70: {
                  if((var6 || var3.contains(new dr(var0, var13, (dq)null)) || var3.contains(new dr(var0, var15, (dq)null))) && a(var12, var13) && b(var13, var15) && a(var15, var16)) {
                     double var17 = Math.abs(var13.a - var15.a);
                     if(var17 > 2.0D * var9) {
                        label44: {
                           a(var11, var12);
                           a(var11, var13.a, var13.b - var9);
                           if(var13.a < var15.a) {
                              a(var11, var13.a + var9, var13.b);
                              a(var11, var15.a - var9, var15.b);
                              if(!var21) {
                                 break label44;
                              }
                           }

                           a(var11, var13.a - var9, var13.b);
                           a(var11, var15.a + var9, var15.b);
                        }

                        var12 = new y.d.t(var15.a, var15.b + var9);
                        a(var11, var12);
                        if(!var21) {
                           break label70;
                        }
                     }

                     double var19 = var17 / 2.0D;
                     a(var11, var12);
                     a(var11, var13.a, var13.b - var19);
                     var12 = new y.d.t(var15.a, var15.b + var19);
                     a(var11, var12);
                     if(!var21) {
                        break label70;
                     }
                  }

                  a(var11, var12);
                  a(var11, var13);
                  var12 = var15;
               }

               var13 = var16;
               if(var14 + 3 >= var5.length) {
                  a(var11, var12);
                  a(var11, var16);
                  if(var14 + 2 < var5.length) {
                     a(var11, var5[var14 + 2]);
                  }
               }

               var14 += 2;
               if(!var21) {
                  continue;
               }
            }

            var1.a(var0, a(var11));
            break;
         }

      }
   }

   private static y.c.D a(y.c.D var0) {
      boolean var21 = N.x;
      if(var0.size() < 3) {
         return var0;
      } else {
         y.c.D var3 = new y.c.D();
         y.c.C var4 = var0.m();
         y.d.t var5 = (y.d.t)var4.d();
         var3.add(var5);
         var4.g();
         double var6 = var5.a();
         double var8 = var5.b();
         if(var4.f()) {
            var5 = (y.d.t)var4.d();
            double var10 = var5.a();
            double var12 = var5.b();
            var4.g();

            while(var4.f()) {
               y.d.t var20 = (y.d.t)var4.d();
               double var16 = var20.a();
               double var14 = var20.b();
               double var18 = (var6 - var16) * (var12 - var14) / (var8 - var14) + var16;
               double var22;
               int var10000 = (var22 = Math.abs(var18 - var10) - 0.5D) == 0.0D?0:(var22 < 0.0D?-1:1);
               if(var21) {
                  return var3;
               }

               if(var10000 > 0) {
                  var3.add(var5);
                  var6 = var10;
                  var8 = var12;
               }

               var5 = var20;
               var10 = var16;
               var12 = var14;
               var4.g();
               if(var21) {
                  break;
               }
            }

            var3.add(var5);
         }

         return var3;
      }
   }

   private y.c.d a(y.c.q var1, y.c.d var2) {
      if(var1 == var2.d()) {
         return null;
      } else {
         ds var3 = (ds)this.d.get(var1);
         if(var3 == null) {
            return null;
         } else {
            y.c.d var4 = (y.c.d)var3.i.get(var2);
            if(var4 == null) {
               var4 = var3.e;
            }

            return var4;
         }
      }
   }

   private y.c.d b(y.c.q var1, y.c.d var2) {
      if(var1 == var2.c()) {
         return null;
      } else {
         ds var3 = (ds)this.e.get(var1);
         if(var3 == null) {
            return null;
         } else {
            y.c.d var4 = (y.c.d)var3.i.get(var2);
            if(var4 == null) {
               var4 = var3.f;
            }

            return var4 != null && this.d.containsKey(var4.c())?null:var4;
         }
      }
   }

   public void a(y.f.X var1) {
      this.d = null;
      this.e = null;
      this.b = null;
      this.c = null;
   }
}
