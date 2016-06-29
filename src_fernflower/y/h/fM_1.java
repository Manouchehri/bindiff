package y.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import y.h.eR;
import y.h.eU;
import y.h.fN;
import y.h.fj;

public class fM implements y.f.al {
   private static final byte[] a = new byte[]{(byte)0, (byte)1, (byte)2, (byte)3, (byte)4};
   private final double b;
   private final boolean c;

   public boolean a() {
      return this.c;
   }

   public Object a(y.d.n var1, y.f.am var2) {
      if(a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         y.d.t var3 = var1.k();
         y.d.q var4 = var1.d();
         return this.a(new y.d.y(var3.a() - var4.a() * 0.5D, var3.b() - var4.b() * 0.5D, var4.a(), var4.b()), var2);
      }
   }

   private Object a(y.d.y var1, y.f.am var2) {
      boolean var15 = fj.z;
      fN var3 = null;
      if(var2 instanceof fj) {
         fj var4 = (fj)var2;
         if(var4.portCount() > 0) {
            double var5 = Double.POSITIVE_INFINITY;
            y.d.t var7 = var1.e();
            Iterator var8 = var4.ports();

            label39:
            while(true) {
               int var10000 = var8.hasNext();

               while(true) {
                  if(var10000 == 0) {
                     break label39;
                  }

                  eU var9 = (eU)var8.next();
                  int var10 = 0;

                  while(true) {
                     if(var10 >= a.length) {
                        continue label39;
                     }

                     byte var11 = a[var10];
                     y.d.t var12 = this.a(var1, var9, var11);
                     double var13 = y.d.t.a(var7, var12);
                     if(var15) {
                        return var3;
                     }

                     double var16;
                     var10000 = (var16 = var5 - var13) == 0.0D?0:(var16 < 0.0D?-1:1);
                     if(var15) {
                        break;
                     }

                     if(var10000 > 0) {
                        var5 = var13;
                        var3 = new fN(var4.c(var9), var11);
                     }

                     ++var10;
                     if(var15) {
                        break label39;
                     }
                  }
               }
            }
         }
      }

      if(var3 == null) {
         return this.c();
      } else {
         return var3;
      }
   }

   public Object c() {
      return new fN((Object)null, (byte)0);
   }

   public y.d.n a(y.d.q var1, y.f.am var2, Object var3) {
      y.d.t var4 = this.b(var1, var2, var3);
      return new y.d.n(new y.d.t(var4.a(), var4.b() + var1.b()), var1);
   }

   private y.d.t b(y.d.q var1, y.f.am var2, Object var3) {
      if(var2 instanceof fj) {
         fN var4 = c(var3);
         eU var5 = a((fj)var2, var3);
         if(var5 != null) {
            return this.a(var1, var5, var4.b);
         }
      }

      return this.a(var1, var2);
   }

   private y.d.t a(y.d.q var1, y.f.am var2) {
      return new y.d.t(var2.getX() + (var2.getWidth() - var1.a) * 0.5D, var2.getY() + (var2.getHeight() - var1.b) * 0.5D);
   }

   public y.c.D a(y.f.aj var1, y.f.am var2) {
      boolean var10 = fj.z;
      y.c.D var3 = new y.c.D();
      if(var2 instanceof fj) {
         fj var4 = (fj)var2;
         Iterator var5 = this.a(var1, var4);
         if(var5.hasNext()) {
            y.d.y var6 = var1.getBox();

            label31:
            while(var5.hasNext()) {
               eU var7 = (eU)var5.next();
               Object var8 = var4.c(var7);
               int var9 = 0;

               while(var9 < a.length) {
                  var3.add(new y.f.ai(this.a(var6, var7, a[var9]), var6, new fN(var8, a[var9]), var1, true));
                  ++var9;
                  if(var10) {
                     break label31;
                  }

                  if(var10) {
                     return var3;
                  }

                  if(var10) {
                     break label31;
                  }
               }
            }
         }
      }

      if(var3.isEmpty()) {
         y.d.y var11 = var1.getBox();
         var3.add(new y.f.ai(this.a((y.d.q)var11, (y.f.am)var2), var11, this.c(), var1, true));
      }

      return var3;
   }

   private Iterator a(y.f.aj var1, fj var2) {
      if(var2.portCount() > 0) {
         if(!this.a()) {
            return var2.ports();
         }

         if(a(var1.getModelParameter())) {
            eU var3 = a(var2, var1.getModelParameter());
            if(var3 != null) {
               ArrayList var4 = new ArrayList(1);
               var4.add(var3);
               return var4.iterator();
            }
         }
      }

      return Collections.EMPTY_LIST.iterator();
   }

   private y.d.t a(y.d.q var1, eU var2, byte var3) {
      y.d.y var4 = var2.k();
      double var5 = var4.a();
      double var7 = var4.b();
      double var9 = var4.c() + 0.5D * var5;
      double var11 = var4.d() + 0.5D * var7;
      switch(var3) {
      case 0:
         return new y.d.t(var9 - var1.a() * 0.5D, var11 - var7 * 0.5D - this.b - var1.b());
      case 1:
         return new y.d.t(var9 - var1.a() * 0.5D, var11 + var7 * 0.5D + this.b);
      case 2:
         return new y.d.t(var9 + var5 * 0.5D + this.b, var11 - var1.b() * 0.5D);
      case 3:
         return new y.d.t(var9 - var5 * 0.5D - this.b - var1.a(), var11 - var1.b() * 0.5D);
      case 4:
         return new y.d.t(var9 - var1.a() * 0.5D, var11 - var1.b() * 0.5D);
      default:
         throw new IllegalArgumentException("Invalid position: " + var3);
      }
   }

   static boolean a(Object var0) {
      return var0 instanceof fN;
   }

   public static byte b(Object var0) {
      return c(var0).b;
   }

   public static eU a(eR var0) {
      if(a(var0.getModelParameter())) {
         fj var1 = var0.g();
         if(var1 != null) {
            return a(var1, var0.getModelParameter());
         }
      }

      return null;
   }

   public static eU a(fj var0, Object var1) {
      return var0.b(c(var1).a);
   }

   public static Collection a(eU var0) {
      ArrayList var1 = new ArrayList(1);
      fj var2 = var0.b();
      if(var2 != null && var2.labelCount() > 0) {
         Object var3 = var2.c(var0);
         int var4 = 0;

         for(int var5 = var2.labelCount(); var4 < var5; ++var4) {
            eR var6 = var2.getLabel(var4);
            if(a(var6.getModelParameter()) && var3 == c(var6.getModelParameter()).a) {
               var1.add(var6);
            }
         }
      }

      return var1;
   }

   static boolean a(y.d.n var0) {
      return Double.isNaN(var0.b()) || Double.isNaN(var0.c()) || Double.isNaN(var0.e()) || Double.isNaN(var0.f()) || Double.isNaN(var0.g()) || Double.isNaN(var0.i());
   }

   static fN c(Object var0) {
      try {
         return (fN)var0;
      } catch (ClassCastException var2) {
         throw new IllegalArgumentException("Invalid model parameter type.");
      }
   }
}
