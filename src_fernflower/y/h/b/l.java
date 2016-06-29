package y.h.b;

import java.util.ArrayList;
import java.util.Collection;
import y.f.ai;
import y.f.aj;
import y.f.al;
import y.f.am;
import y.h.b.a;
import y.h.b.i;
import y.h.b.n;
import y.h.b.q;

abstract class l implements al {
   static final Object a = new Object();
   private static final double[] b = new double[]{0.0D, 1.0D};
   private static final double[] c = new double[]{0.0D, 0.25D, 0.5D, 0.75D, 1.0D};
   private final double d;

   l(double var1) {
      this.d = var1;
   }

   public double a() {
      return this.d;
   }

   public Object c() {
      return new n(a, true, 0.5D);
   }

   public y.d.n a(y.d.q var1, am var2, Object var3) {
      y.d.t var4 = this.b(var1, var2, var3);
      return new y.d.n(new y.d.t(var4.a(), var4.b() + var1.b()), var1);
   }

   private y.d.t b(y.d.q var1, am var2, Object var3) {
      int var9 = a.H;
      if(var2 instanceof a) {
         n var4 = a(var3);
         a var5 = (a)var2;
         i var6 = var5.l();
         ArrayList var7 = new ArrayList();
         var7.addAll(this.a(var6));

         while(!var7.isEmpty()) {
            q var8 = (q)var7.remove(var7.size() - 1);
            if(var8.a == var4.a) {
               return this.a(var1, var8, var4);
            }

            var7.addAll(var8.b);
            if(var9 != 0) {
               break;
            }
         }
      }

      return new y.d.t(var2.getX() + (var2.getWidth() - var1.a) * 0.5D, var2.getY() + (var2.getHeight() - var1.b) * 0.5D);
   }

   public y.c.D a(aj var1, am var2) {
      int var14 = a.H;
      y.d.y var3 = var1.getBox();
      y.c.D var4 = new y.c.D();
      if(var2 instanceof a) {
         a var5 = (a)var2;
         i var6 = var5.l();
         ArrayList var7 = new ArrayList();
         var7.addAll(this.a(var6));

         while(!var7.isEmpty()) {
            q var8 = (q)var7.remove(var7.size() - 1);
            int var9 = 0;

            label50: {
               while(var9 < 2) {
                  int var10000 = var9 % 2;
                  if(var14 != 0) {
                     break label50;
                  }

                  boolean var10 = var10000 == 0;
                  double[] var11 = var10?c:b;
                  int var12 = 0;

                  while(true) {
                     if(var12 < var11.length) {
                        n var13 = new n(var8.a, var10, var11[var12]);
                        var4.add(new ai(this.a((y.d.q)var3, (q)var8, (n)var13), var3, var13, var1, true));
                        ++var12;
                        if(var14 != 0) {
                           break;
                        }

                        if(var14 == 0) {
                           continue;
                        }
                     }

                     ++var9;
                     break;
                  }

                  if(var14 != 0) {
                     break;
                  }
               }

               var7.addAll(var8.b);
            }

            if(var14 != 0) {
               break;
            }
         }
      }

      return var4;
   }

   public Object a(y.d.n var1, am var2) {
      if(a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         y.d.t var3 = var1.k();
         y.d.q var4 = var1.d();
         return this.a(new y.d.y(var3.a() - var4.a() * 0.5D, var3.b() - var4.b() * 0.5D, var4.a(), var4.b()), var2);
      }
   }

   private Object a(y.d.y var1, am var2) {
      int var14 = a.H;
      n var3 = null;
      if(var2 instanceof a) {
         a var4 = (a)var2;
         i var5 = var4.l();
         double var6 = Double.POSITIVE_INFINITY;
         ArrayList var8 = new ArrayList();
         var8.addAll(this.a(var5));

         while(!var8.isEmpty()) {
            q var9 = (q)var8.remove(var8.size() - 1);
            n var10 = this.a(var1, var9);
            y.d.t var11 = this.a((y.d.q)var1, (q)var9, (n)var10);
            double var12 = y.d.t.a(var1.e(), var11);
            if(var14 != 0) {
               return var3;
            }

            if(var6 > var12) {
               var6 = var12;
               var3 = var10;
            }

            var8.addAll(var9.b);
            if(var14 != 0) {
               break;
            }
         }
      }

      if(var3 == null) {
         return this.c();
      } else {
         return var3;
      }
   }

   static q a(a var0, l var1, n var2) {
      int var6 = a.H;
      if(var0 != null && var1 != null && var2 != null) {
         i var3 = var0.l();
         ArrayList var4 = new ArrayList();
         var4.addAll(var1.a(var3));

         while(!var4.isEmpty()) {
            q var5 = (q)var4.remove(var4.size() - 1);
            if(var5.a == var2.a) {
               return var5;
            }

            var4.addAll(var5.b);
            if(var6 != 0) {
               break;
            }
         }
      }

      return null;
   }

   static n a(Object var0) {
      try {
         return (n)var0;
      } catch (ClassCastException var2) {
         throw new IllegalArgumentException("Invalid model parameter type.");
      }
   }

   static boolean a(y.d.n var0) {
      return Double.isNaN(var0.b()) || Double.isNaN(var0.c()) || Double.isNaN(var0.e()) || Double.isNaN(var0.f()) || Double.isNaN(var0.g()) || Double.isNaN(var0.i());
   }

   abstract n a(y.d.y var1, q var2);

   abstract y.d.t a(y.d.q var1, q var2, n var3);

   abstract Collection a(i var1);
}
