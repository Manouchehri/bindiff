package y.h;

import y.h.eU;
import y.h.fO;
import y.h.fP;
import y.h.fj;
import y.h.fn;

public class fm implements fO {
   private static final fm j = new fm();
   public static final fP a;
   public static final fP b;
   public static final fP c;
   public static final fP d;
   public static final fP e;
   public static final fP f;
   public static final fP g;
   public static final fP h;
   public static final fP i;
   private byte k = 5;

   public byte a() {
      return this.k;
   }

   public y.d.t a(eU var1, fP var2) {
      fn var3 = a(var2);
      fj var4 = var1.b();
      return new y.d.t(var4.getCenterX() + var3.b * var4.getWidth(), var4.getCenterY() + var3.c * var4.getHeight());
   }

   public fP a(fj var1, y.d.t var2) {
      switch(this.a()) {
      case 1:
         return this.e(var1, var2);
      case 2:
         return this.b(var1, var2);
      case 3:
         return this.c(var1, var2);
      case 4:
         return this.d(var1, var2);
      case 5:
         return this.f(var1, var2);
      default:
         throw new IllegalStateException("Invalid policy: " + this.a());
      }
   }

   private fP b(fj var1, y.d.t var2) {
      return (fP)(var1 == null?this.b(f):this.f(var1, a(var1, var2, false)));
   }

   private fP c(fj var1, y.d.t var2) {
      if(var1 == null) {
         return this.b(a);
      } else {
         y.d.t var3 = a(var1, var2, false);
         return (fP)(a(var2, var3) > a(var2, new y.d.t(var1.getCenterX(), var1.getCenterY()))?this.b(a):this.f(var1, var3));
      }
   }

   private fP d(fj var1, y.d.t var2) {
      return (fP)(var1 == null?this.b(a):this.f(var1, a(var1, var2, true)));
   }

   private static y.d.t a(fj var0, y.d.t var1, boolean var2) {
      double var3;
      double var5;
      double var7;
      double var9;
      double var11;
      boolean var25;
      label67: {
         var25 = fj.z;
         var3 = var0.getX();
         var5 = var0.getY();
         var7 = var0.getWidth();
         var9 = var0.getHeight();
         var11 = var1.a();
         if(var11 < var3) {
            var11 = var3;
            if(!var25) {
               break label67;
            }
         }

         if(var11 > var3 + var7) {
            var11 = var3 + var7;
         }
      }

      double var13;
      label62: {
         var13 = var1.b();
         if(var13 < var5) {
            var13 = var5;
            if(!var25) {
               break label62;
            }
         }

         if(var13 > var5 + var9) {
            var13 = var5 + var9;
         }
      }

      if(var2) {
         return new y.d.t(var11, var13);
      } else {
         double var15 = var11 - var0.getCenterX();
         double var17 = var13 - var0.getCenterY();
         boolean var19 = Math.abs(Math.abs(var15) - var7 * 0.5D) < 1.0E-8D;
         boolean var20 = Math.abs(Math.abs(var17) - var9 * 0.5D) < 1.0E-8D;
         double var21 = var15 > 0.0D?var3 + var7:var3;
         double var23 = var17 > 0.0D?var5 + var9:var5;
         return !var19 && !var20?(var7 - 2.0D * Math.abs(var15) < var9 - 2.0D * Math.abs(var17)?new y.d.t(var21, var13):new y.d.t(var11, var23)):(var19 && var20?new y.d.t(var21, var23):(var19?new y.d.t(var21, var13):new y.d.t(var11, var23)));
      }
   }

   private fP e(fj var1, y.d.t var2) {
      boolean var20 = fj.z;
      if(var1 == null) {
         return this.b(a);
      } else {
         double var3 = var1.getCenterX();
         double var5 = var1.getWidth();
         double var7 = var1.getCenterY();
         double var9 = var1.getHeight();
         fn[] var11 = new fn[]{a(a), a(b), a(c), a(d), a(e), a(f), a(g), a(h), a(i)};
         double var12 = Double.POSITIVE_INFINITY;
         int var14 = -1;
         int var15 = 0;

         fn var10000;
         while(true) {
            if(var15 < var11.length) {
               var10000 = var11[var15];
               if(var20) {
                  break;
               }

               fn var16 = var10000;
               y.d.t var17 = new y.d.t(var3 + var16.b * var5, var7 + var16.c * var9);
               double var18 = a(var17, var2);
               if(var12 > var18) {
                  var12 = var18;
                  var14 = var15;
               }

               ++var15;
               if(!var20) {
                  continue;
               }
            }

            var10000 = new fn(this, var11[var14].b, var11[var14].c);
            break;
         }

         return var10000;
      }
   }

   private static double a(y.d.t var0, y.d.t var1) {
      double var2 = var0.a() - var1.a();
      double var4 = var0.b() - var1.b();
      return var2 * var2 + var4 * var4;
   }

   private fP f(fj var1, y.d.t var2) {
      boolean var15 = fj.z;
      if(var1 == null) {
         return this.b(a);
      } else {
         double var7;
         double var9;
         double var11;
         label28: {
            double var3 = var1.getX();
            double var5 = var1.getWidth();
            var7 = var1.getY();
            var9 = var1.getHeight();
            if(var5 > 0.0D) {
               var11 = (var2.a() - var3 - var5 * 0.5D) / var5;
               if(!var15) {
                  break label28;
               }
            }

            var11 = 0.0D;
         }

         double var13;
         if(var9 > 0.0D) {
            var13 = (var2.b() - var7 - var9 * 0.5D) / var9;
            if(!var15) {
               return var11 == 0.0D && var13 == 0.0D?this.b(a):new fn(this, var11, var13);
            }
         }

         var13 = 0.0D;
         return var11 == 0.0D && var13 == 0.0D?this.b(a):new fn(this, var11, var13);
      }
   }

   public fP a(y.d.t var1) {
      return new fn(this, var1.a(), var1.b());
   }

   private fn b(fP var1) {
      fn var2 = a(var1);
      return new fn(this, var2.b, var2.c);
   }

   static fn a(fP var0) {
      try {
         return (fn)var0;
      } catch (ClassCastException var2) {
         throw new IllegalArgumentException("Invalid model parameter type.");
      }
   }

   static {
      a = j.a(new y.d.t(0.0D, 0.0D));
      b = j.a(new y.d.t(-0.5D, 0.0D));
      c = j.a(new y.d.t(0.5D, 0.0D));
      d = j.a(new y.d.t(0.0D, -0.5D));
      e = j.a(new y.d.t(0.0D, 0.5D));
      f = j.a(new y.d.t(-0.5D, -0.5D));
      g = j.a(new y.d.t(0.5D, -0.5D));
      h = j.a(new y.d.t(0.5D, 0.5D));
      i = j.a(new y.d.t(-0.5D, 0.5D));
   }
}
