package y.f;

import y.f.B;
import y.f.C;
import y.f.D;
import y.f.E;
import y.f.I;
import y.f.X;
import y.f.aO;
import y.f.aP;
import y.f.aW;
import y.f.ae;
import y.f.am;

public class z implements E {
   static final Integer[] a = new Integer[]{new Integer(1), new Integer(2), new Integer(4), new Integer(8), new Integer(16), new Integer(32), new Integer(64), new Integer(128), new Integer(256)};
   private static final Object b = new Integer(128);
   private static final Object c = new Integer(64);
   private static final Object d = new Integer(16);
   private static final Object e = new Integer(8);
   private int f;
   private aO g;
   private double h;

   public z() {
      this(63);
   }

   public z(int var1) {
      this.f = 63;
      this.h = 2.0D;
      this.f = var1;
      if(var1 == 128 || var1 == 448) {
         this.g = new aO((byte)0);
         if(!X.j) {
            return;
         }
      }

      this.g = new aO((byte)1);
   }

   public int a() {
      return this.f;
   }

   public double b() {
      return this.h;
   }

   public void a(double var1) {
      this.h = var1;
   }

   public Object c() {
      return (this.f & 128) != 0?b:((this.f & 64) != 0?c:((this.f & 16) != 0?d:((this.f & 8) != 0?e:b)));
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
         return new Integer(var0);
      default:
         throw new IllegalArgumentException("Invalid position: " + var0);
      }
   }

   public boolean a(Object var1) {
      if(var1 instanceof Integer) {
         int var2 = ((Integer)var1).intValue();
         return (this.f & var2) != 0;
      } else {
         return false;
      }
   }

   public y.d.n a(y.d.q var1, I var2, am var3, am var4, Object var5) {
      int var6 = var5 != null?((Number)var5).intValue():((Number)this.c()).intValue();
      return this.a(var1, var2, var3, var4, var6);
   }

   public y.c.D a(C var1, I var2, am var3, am var4) {
      boolean var11 = X.j;
      y.c.D var5 = new y.c.D();
      y.d.q var6 = var1.getOrientedBox().d();
      int var7 = 0;

      while(var7 < a.length) {
         int var8 = a[var7].intValue();
         if((this.f & var8) != 0) {
            boolean var9;
            label36: {
               var9 = false;
               if(var8 == 128) {
                  var9 = true;
                  if(!var11) {
                     break label36;
                  }
               }

               if(var8 == 64) {
                  var9 = true;
                  if(!var11) {
                     break label36;
                  }
               }

               if(var8 == 256) {
                  var9 = true;
               }
            }

            y.d.n var10 = this.a(var6, var2, var3, var4, var8);
            var5.add(new B(var10, a[var7], var1, var9));
         }

         ++var7;
         if(var11) {
            break;
         }
      }

      return var5;
   }

   protected y.d.n a(y.d.q var1, I var2, am var3, am var4, int var5) {
      boolean var27 = X.j;
      y.d.v var6 = ae.a(var2, var3, var4, 0.0D);
      boolean var7 = false;
      int var8 = 0;
      double var9 = 0.0D;
      int var11 = -1;
      y.d.s var12 = var6.j();

      double var14;
      int var10000;
      while(true) {
         if(var12.f()) {
            ++var11;
            y.d.m var13 = var12.a();
            var14 = var13.g();
            double var30;
            var10000 = (var30 = var14 - var9) == 0.0D?0:(var30 < 0.0D?-1:1);
            if(var27) {
               break;
            }

            if(var10000 > 0) {
               var9 = var14;
               var8 = var11;
            }

            var12.g();
            if(!var27) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      int var28 = var10000;
      byte var29 = 3;
      var14 = 0.0D;
      switch(var5) {
      case 1:
         var29 = 2;
         var28 = 0;
         var14 = 0.0D;
         if(!var27) {
            break;
         }
      case 2:
         var29 = 2;
         var28 = var8;
         var14 = 0.5D;
         if(!var27) {
            break;
         }
      case 4:
         var29 = 2;
         var28 = var11;
         var14 = 1.0D;
         if(!var27) {
            break;
         }
      case 64:
         var29 = 0;
         var28 = 0;
         var14 = 0.0D;
         if(!var27) {
            break;
         }
      case 128:
         var29 = 0;
         var28 = var8;
         var14 = 0.5D;
         if(!var27) {
            break;
         }
      case 256:
         var29 = 0;
         var28 = var11;
         var14 = 1.0D;
         if(!var27) {
            break;
         }
      case 8:
         var29 = 1;
         var28 = 0;
         var14 = 0.0D;
         if(!var27) {
            break;
         }
      case 16:
         var29 = 1;
         var28 = var8;
         var14 = 0.5D;
         if(!var27) {
            break;
         }
      case 32:
         var29 = 1;
         var28 = var11;
         var14 = 1.0D;
      }

      y.d.m var16 = var6.a(var28);
      y.d.n var17 = new y.d.n(new y.d.t(0.0D, 0.0D), var1);
      y.d.y var18 = var17.h();
      if(var16 == null) {
         var17.e(var3.getX() + var18.a * 0.5D, var3.getY() - var18.b * 0.5D);
         return var17;
      } else {
         y.d.t var19 = var16.c();
         y.d.t var20 = var16.d();
         double var21 = var20.a() - var19.a();
         double var23 = var20.b() - var19.b();
         if(var21 == 0.0D && var23 == 0.0D) {
            var21 = var3.getX() + var3.getWidth() * 0.5D + var2.getSourcePoint().a - (var4.getX() + var4.getWidth() * 0.5D + var2.getTargetPoint().a);
            var23 = var3.getY() + var3.getHeight() * 0.5D + var2.getSourcePoint().b - (var4.getY() + var4.getHeight() * 0.5D + var2.getTargetPoint().b);
            if(var21 == 0.0D && var23 == 0.0D) {
               var21 = 1.0E-6D;
            }
         }

         y.d.z var25 = this.g.a(var21, var23, var18.a(), var18.b(), var29);
         var25.c();
         var25.b(this.h);
         aP var26 = new aP(var28, var14, var25, var29, var14);
         return this.g.a(var1, var2, var3, var4, var26);
      }
   }
}
