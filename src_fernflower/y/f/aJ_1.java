package y.f;

import java.util.ArrayList;
import y.f.B;
import y.f.C;
import y.f.D;
import y.f.E;
import y.f.I;
import y.f.X;
import y.f.aK;
import y.f.aV;
import y.f.aW;
import y.f.ae;
import y.f.am;

public class aJ implements E {
   private int a;
   private double b;
   private double c;
   private boolean d;
   private boolean e;
   private boolean f;
   private static final y.d.z g = new y.d.z(1.0D, 0.0D);

   public aJ() {
      this(63);
   }

   public aJ(int var1) {
      this.a = 63;
      this.b = 2.0D;
      this.d = true;
      this.e = false;
      this.f = false;
      this.a = var1;
   }

   public int a() {
      return this.a;
   }

   public boolean b() {
      return this.e;
   }

   public void a(double var1) {
      this.b = Math.abs(var1);
   }

   public Object c() {
      return (this.a & 128) != 0?new aK(128):((this.a & 64) != 0?new aK(64):((this.a & 16) != 0?new aK(16):((this.a & 8) != 0?new aK(8):new aK(128))));
   }

   private Object[] d() {
      ArrayList var1 = new ArrayList();
      var1.add(new aK(1));
      var1.add(new aK(2));
      var1.add(new aK(4));
      var1.add(new aK(8));
      var1.add(new aK(16));
      var1.add(new aK(32));
      var1.add(new aK(64));
      var1.add(new aK(128));
      var1.add(new aK(256));
      return var1.toArray();
   }

   public Object a(y.d.n var1, I var2, am var3, am var4) {
      if(ae.a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         D var5 = new D();
         var5.a((y.d.n)var1);
         y.c.D var6 = this.a((C)var5, var2, var3, var4);
         return var6.isEmpty()?this.c():aW.a(var6, var1.k()).b();
      }
   }

   public static Object a(int var0) {
      switch(var0) {
      case 1:
      case 2:
      case 4:
      case 8:
      case 16:
      case 32:
      case 64:
      case 128:
      case 256:
         return new aK(var0);
      default:
         throw new IllegalArgumentException("Invalid position: " + var0);
      }
   }

   public static int a(Object var0) {
      try {
         return ((aK)var0).a();
      } catch (ClassCastException var2) {
         throw new IllegalArgumentException("Invalid model parameter type.");
      }
   }

   public boolean b(Object var1) {
      if(var1 instanceof aK) {
         int var2 = ((aK)var1).a();
         return (this.a() & var2) != 0;
      } else {
         return false;
      }
   }

   public y.d.n a(y.d.q var1, I var2, am var3, am var4, Object var5) {
      aK var6 = (aK)(var5 instanceof aK?var5:this.c());
      return this.a(var1, var2, var3, var4, aK.a(var6));
   }

   public y.c.D a(C var1, I var2, am var3, am var4) {
      boolean var12 = X.j;
      y.c.D var5 = new y.c.D();
      Object[] var6 = this.d();
      int var7 = 0;

      while(var7 < var6.length) {
         int var8 = aK.a((aK)var6[var7]);
         if((this.a & var8) != 0) {
            boolean var9;
            label36: {
               var9 = false;
               if(var8 == 128) {
                  var9 = true;
                  if(!var12) {
                     break label36;
                  }
               }

               if(var8 == 64) {
                  var9 = true;
                  if(!var12) {
                     break label36;
                  }
               }

               if(var8 == 256) {
                  var9 = true;
               }
            }

            y.d.q var10 = var1.getOrientedBox().d();
            y.d.n var11 = this.a(var10, var2, var3, var4, var8);
            var5.add(new B(var11, var6[var7], var1, var9));
         }

         ++var7;
         if(var12) {
            break;
         }
      }

      return var5;
   }

   protected y.d.n a(y.d.q var1, I var2, am var3, am var4, int var5) {
      boolean var22 = X.j;
      y.d.n var6 = new y.d.n(new y.d.t(0.0D, 0.0D), var1);
      var6.a(6.283185307179586D - this.c);
      y.d.t[] var7 = ae.a(var2, var3, var4, 0.0D).f();
      if(var7.length < 2) {
         y.d.y var23 = var6.h();
         var6.e(var3.getX() + var23.a * 0.5D, var3.getY() - var23.b * 0.5D);
         if(this.b()) {
            ae.b(var6);
         }

         return var6;
      } else if(var7.length == 2 && y.d.t.a(var7[0], var7[1]) < 1.0E-4D) {
         var6.e(var7[0].a, var7[0].b);
         if(this.b()) {
            ae.b(var6);
         }

         return var6;
      } else {
         int var8 = 0;
         double var9 = 0.0D;
         int var11 = 0;

         double var10000;
         while(true) {
            if(var11 < var7.length - 1) {
               var10000 = var9 + y.d.t.a(var7[var11], var7[var11 + 1]);
               if(var22) {
                  break;
               }

               var9 = var10000;
               ++var11;
               if(!var22) {
                  continue;
               }
            }

            var10000 = var9 / 2.0D;
            break;
         }

         double var24 = var10000;
         var9 = 0.0D;
         int var13 = 0;

         int var26;
         while(true) {
            if(var13 < var7.length - 1) {
               label146: {
                  var9 += y.d.t.a(var7[var13], var7[var13 + 1]);
                  double var27;
                  var26 = (var27 = var9 - var24) == 0.0D?0:(var27 < 0.0D?-1:1);
                  if(var22) {
                     break;
                  }

                  if(var26 > 0) {
                     var8 = var13;
                     if(!var22) {
                        break label146;
                     }
                  }

                  ++var13;
                  if(!var22) {
                     continue;
                  }
               }
            }

            var13 = 0;
            var26 = var5;
            break;
         }

         label158: {
            if(var26 == 2 || var5 == 128 || var5 == 16) {
               var13 = var8;
               if(!var22) {
                  break label158;
               }
            }

            if(var5 == 4 || var5 == 256 || var5 == 32) {
               var13 = var7.length - 2;
            }
         }

         y.d.t var14 = var7[var13];
         y.d.t var15 = var7[var13 + 1];
         double var16;
         if(var14.equals(var15)) {
            label106: {
               var16 = var3.getX() + var3.getWidth() * 0.5D + var2.getSourcePoint().a - (var4.getX() + var4.getWidth() * 0.5D + var2.getTargetPoint().a);
               double var18 = var3.getY() + var3.getHeight() * 0.5D + var2.getSourcePoint().b - (var4.getY() + var4.getHeight() * 0.5D + var2.getTargetPoint().b);
               if(var16 == 0.0D && var18 == 0.0D) {
                  var15 = new y.d.t(var14.a + 1.0E-4D, var14.b);
                  if(!var22) {
                     break label106;
                  }
               }

               double var20 = Math.sqrt(var16 * var16 + var18 * var18);
               var15 = new y.d.t(var14.a + 1.0E-4D * var16 / var20, var14.b + 1.0E-4D * var18 / var20);
            }
         }

         if(this.d) {
            var16 = y.d.z.d(new y.d.z(var15, var14), new y.d.z(1.0D, 0.0D)) - this.c;
            var6.a(b(var16));
         }

         label159: {
            y.d.m var25 = new y.d.m(var14, var15);
            if(var5 == 1 || var5 == 64 || var5 == 8) {
               if(a(var3, var14, 5.0D)) {
                  this.b(var6, var25, var3, var5, var13 == var8);
                  if(!var22) {
                     break label159;
                  }
               }

               this.a(var6, var25, var14, var5);
               if(!var22) {
                  break label159;
               }
            }

            if(var5 == 4 || var5 == 256 || var5 == 32) {
               if(a(var4, var15, 5.0D)) {
                  this.a(var6, var25, var4, var5, var13 == var8);
                  if(!var22) {
                     break label159;
                  }
               }

               this.a(var6, var25, var15, var5);
               if(!var22) {
                  break label159;
               }
            }

            y.d.t var17 = new y.d.t((var14.a + var15.a) / 2.0D, (var14.b + var15.b) / 2.0D);
            this.a(var6, var25, var17, var5);
         }

         if(this.b()) {
            ae.b(var6);
         }

         return var6;
      }
   }

   private static boolean a(am var0, y.d.t var1, double var2) {
      return var0.getX() - var2 < var1.a && var0.getX() + var0.getWidth() + var2 > var1.a && var0.getY() - var2 < var1.b && var0.getY() + var0.getHeight() + var2 > var1.b;
   }

   private static double b(double var0) {
      boolean var2 = X.j;
      if(var0 < 0.0D) {
         var0 += 6.283185307179586D;
      }

      double var10000;
      while(true) {
         if(var0 > 6.283185307179586D) {
            var10000 = var0 - 6.283185307179586D;
            if(var2) {
               break;
            }

            var0 = var10000;
            if(!var2) {
               continue;
            }
         }

         var10000 = var0;
         break;
      }

      return var10000;
   }

   private static byte a(y.d.m var0) {
      double var1 = y.d.z.d(var0.i(), g);
      return (byte)(var1 >= 0.7853981633974483D && var1 < 2.356194490192345D?0:(var1 >= 2.356194490192345D && var1 < 3.9269908169872414D?2:(var1 >= 3.9269908169872414D && var1 < 5.497787143782138D?1:3)));
   }

   private static byte b(y.d.m var0) {
      double var1 = y.d.z.d(var0.i(), g);
      return (byte)(var1 >= 0.7853981633974483D && var1 < 2.356194490192345D?(var1 <= 1.5707963267948966D?3:2):(var1 >= 2.356194490192345D && var1 < 3.9269908169872414D?(var1 <= 3.141592653589793D?0:1):(var1 >= 3.9269908169872414D && var1 < 5.497787143782138D?(var1 <= 4.71238898038469D?2:3):(var1 <= 3.141592653589793D?0:1))));
   }

   private void a(y.d.n var1, y.d.m var2, y.d.t var3, int var4) {
      boolean var11 = X.j;
      if(var4 == 128 || var4 == 256 || var4 == 64) {
         var1.e(var3.a, var3.b);
         if(!var11) {
            return;
         }
      }

      y.d.z var5;
      label76: {
         var5 = y.d.z.c(var2.i());
         if(this.f) {
            if(var4 != 16 && var4 != 8 && var4 != 32) {
               break label76;
            }

            var5 = new y.d.z(-var5.a(), -var5.b());
            if(!var11) {
               break label76;
            }
         }

         double var6 = y.d.z.d(g, var5);
         if(var6 >= 3.141592653589793D && (var4 == 16 || var4 == 32 || var4 == 8) || var6 < 3.141592653589793D && (var4 == 2 || var4 == 1 || var4 == 4)) {
            var5 = new y.d.z(-var5.a(), -var5.b());
         }
      }

      var5.b(this.b + var1.e() + var1.f());
      y.d.t var12 = y.d.z.a(var3, var5);
      var1.e(var12.a, var12.b);
      y.d.t[] var7 = y.d.n.a(var1);
      double var8 = Double.MAX_VALUE;
      int var10 = 0;

      while(var10 < var7.length) {
         var8 = Math.min(var8, a(var2, var7[var10]));
         ++var10;
         if(var11) {
            return;
         }

         if(var11) {
            break;
         }
      }

      y.d.z var13 = new y.d.z(-var5.a(), -var5.b());
      var13.c();
      var13.b(var8 - this.b);
      var12 = y.d.z.a(var12, var13);
      var1.e(var12.a, var12.b);
   }

   private void a(y.d.n var1, y.d.m var2, am var3, int var4, boolean var5) {
      this.a(var1, var2.d(), var2.c(), var3, var4, false, var5);
   }

   private void b(y.d.n var1, y.d.m var2, am var3, int var4, boolean var5) {
      this.a(var1, var2.c(), var2.d(), var3, var4, true, var5);
   }

   private void a(y.d.n var1, y.d.t var2, y.d.t var3, am var4, int var5, boolean var6, boolean var7) {
      y.d.y var8 = new y.d.y(var4.getX(), var4.getY(), var4.getWidth(), var4.getHeight());
      y.d.m var9 = new y.d.m(var2, var3);
      byte var10 = a(var9);
      y.d.t var11 = this.a(var10, var9, var1, var4, var5, var6, var7);
      var1.a(var11);
      double var12 = aV.a(var8, var1);
      y.d.y var14 = var1.h();
      boolean var10000;
      if(Math.abs(var2.a - var3.a) <= 1.0E-4D || Math.abs(var2.b - var3.b) <= 1.0E-4D || var12 >= 2.5D && var12 <= 6.0D || (var10 != 0 && var10 != 1 || var3.a >= var8.c() - 5.0D - var14.a * 0.5D && var3.a <= var8.c() + var8.a() + 5.0D + var14.a * 0.5D) && (var10 != 2 && var10 != 3 || var3.b >= var8.d() - 5.0D - var14.b * 0.5D && var3.b <= var8.d() + var8.b() + 5.0D + var14.b * 0.5D)) {
         var10000 = false;
      } else {
         var10000 = true;
      }

      boolean var15 = var10000;
      if(var15) {
         byte var16 = b(var9);
         y.d.t var17 = this.a(var16, var9, var1, var4, var5, var6, var7);
         var1.a(var17);
         double var18 = aV.a(var8, var1);
         if(var18 < 2.5D || var18 > var12 && var12 > 2.5D) {
            var1.a(var11);
         }
      }

   }

   private y.d.t a(byte var1, y.d.m var2, y.d.n var3, am var4, int var5, boolean var6, boolean var7) {
      y.d.n var8;
      y.d.t var9;
      y.d.t var10;
      boolean var23;
      label320: {
         var23 = X.j;
         var8 = new y.d.n(var3);
         var9 = var2.c();
         var10 = var2.d();
         double var11 = y.d.z.d(var2.i(), g);
         y.d.y var13 = var8.h();
         boolean var14;
         double var15;
         double var17;
         y.d.t var19;
         y.d.t var20;
         double var21;
         if(var1 == 0) {
            label399: {
               if(this.f) {
                  var14 = var6 && var5 == 1 || !var6 && var5 == 4;
                  if(!var23) {
                     break label399;
                  }
               }

               var14 = (var5 == 1 || var5 == 4) && var11 <= 1.5707963267948966D || (var5 == 8 || var5 == 32) && var11 > 1.5707963267948966D;
            }

            var15 = var4.getY() - 5.0D - var13.b() * 0.5D;
            if(var15 < var10.b) {
               var15 = var10.b;
            }

            var17 = var14?Math.min(var9.a, var10.a) - var13.a:Math.max(var9.a, var10.a) + var13.a;
            var8.e(var17, var15);
            var19 = var5 != 64 && var5 != 256?a(y.d.n.a(var8), var2):var8.k();
            var20 = a(var2, var19, 1.0D, 0.0D);
            var8.d(var20.a - var19.a, 0.0D);
            if(var5 == 64 || var5 == 256) {
               break label320;
            }

            var21 = var14?-this.b:this.b;
            var8.d(var21, 0.0D);
            if(!var23) {
               break label320;
            }
         }

         if(var1 == 1) {
            label400: {
               if(this.f) {
                  var14 = var6 && var5 == 8 || !var6 && var5 == 32;
                  if(!var23) {
                     break label400;
                  }
               }

               var14 = (var5 == 8 || var5 == 32) && var11 > 4.71238898038469D || (var5 == 1 || var5 == 4) && var11 <= 4.71238898038469D;
            }

            var15 = var4.getY() + var4.getHeight() + 5.0D + var13.b() * 0.5D;
            if(var15 > var10.b) {
               var15 = var10.b;
            }

            var17 = var14?Math.min(var9.a, var10.a) - var13.a:Math.max(var9.a, var10.a) + var13.a;
            var8.e(var17, var15);
            var19 = var5 != 64 && var5 != 256?a(y.d.n.a(var8), var2):var8.k();
            var20 = a(var2, var19, 1.0D, 0.0D);
            var8.d(var20.a - var19.a, 0.0D);
            if(var5 == 64 || var5 == 256) {
               break label320;
            }

            var21 = var14?-this.b:this.b;
            var8.d(var21, 0.0D);
            if(!var23) {
               break label320;
            }
         }

         if(var1 == 2) {
            label358: {
               if(this.f) {
                  var14 = var6 && var5 == 1 || !var6 && var5 == 4;
                  if(!var23) {
                     break label358;
                  }
               }

               var14 = var5 == 8 || var5 == 32;
            }

            var15 = var4.getX() - 5.0D - var13.a() * 0.5D;
            if(var15 < var10.a) {
               var15 = var10.a;
            }

            var17 = var14?Math.max(var9.b, var10.b) + var13.b:Math.min(var9.b, var10.b) - var13.b;
            var8.e(var15, var17);
            var19 = var5 != 64 && var5 != 256?a(y.d.n.a(var8), var2):var8.k();
            var20 = a(var2, var19, 0.0D, 1.0D);
            var8.d(0.0D, var20.b - var19.b);
            if(var5 == 64 || var5 == 256) {
               break label320;
            }

            var21 = var14?this.b:-this.b;
            var8.d(0.0D, var21);
            if(!var23) {
               break label320;
            }
         }

         if(var1 == 3) {
            label361: {
               if(this.f) {
                  var14 = var6 && var5 == 8 || !var6 && var5 == 32;
                  if(!var23) {
                     break label361;
                  }
               }

               var14 = var5 == 8 || var5 == 32;
            }

            var15 = var4.getX() + var4.getWidth() + 5.0D + var13.a() * 0.5D;
            if(var15 > var10.a) {
               var15 = var10.a;
            }

            var17 = var14?Math.max(var9.b, var10.b) + var13.b:Math.min(var9.b, var10.b) - var13.b;
            var8.e(var15, var17);
            var19 = var5 != 64 && var5 != 256?a(y.d.n.a(var8), var2):var8.k();
            var20 = a(var2, var19, 0.0D, 1.0D);
            var8.d(0.0D, var20.b - var19.b);
            if(var5 != 64 && var5 != 256) {
               var21 = var14?this.b:-this.b;
               var8.d(0.0D, var21);
            }
         }
      }

      if(var7 && y.d.t.a(var8.k(), var9) > y.d.t.a(var8.k(), var10)) {
         short var24;
         label151: {
            var24 = 128;
            if(var5 <= 4) {
               var24 = 2;
               if(!var23) {
                  break label151;
               }
            }

            if(var5 <= 32) {
               var24 = 16;
            }
         }

         y.d.t var25 = new y.d.t((var9.a + var10.a) / 2.0D, (var9.b + var10.b) / 2.0D);
         this.a(var8, var2, var25, var24);
      }

      return var8.a();
   }

   private static y.d.t a(y.d.t[] var0, y.d.m var1) {
      boolean var8 = X.j;
      double var2 = Double.MAX_VALUE;
      y.d.t var4 = null;
      int var5 = 0;

      while(var5 < var0.length) {
         double var6 = a(var1, var0[var5]);
         if(var6 < var2) {
            var4 = var0[var5];
            var2 = var6;
         }

         ++var5;
         if(var8) {
            break;
         }
      }

      return var4;
   }

   private static double a(y.d.m var0, y.d.t var1) {
      y.d.t var2 = var0.c();
      y.d.t var3 = var0.d();
      double var4 = var3.a - var2.a;
      double var6 = var3.b - var2.b;
      double var8 = var1.a - var2.a;
      double var10 = var1.b - var2.b;
      double var12 = var8 * var4 + var10 * var6;
      double var14 = var12 * var12 / (var4 * var4 + var6 * var6);
      double var16 = var8 * var8 + var10 * var10 - var14;
      if(var16 < 0.0D) {
         var16 = 0.0D;
      }

      return Math.sqrt(var16);
   }

   private static y.d.t a(y.d.m var0, y.d.t var1, double var2, double var4) {
      y.d.t var6 = var0.d();
      y.d.t var7 = var0.c();
      double var8 = var1.a();
      double var10 = var1.b();
      return y.d.e.a(var6.a(), var6.b(), var7.a(), var7.b(), var8, var10, var8 + var2, var10 + var4);
   }
}
