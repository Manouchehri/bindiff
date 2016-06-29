package y.f.k;

import y.f.aE;
import y.f.am;
import y.f.k.J;
import y.f.k.d;

public class v implements J {
   private byte a;
   private double b;
   private boolean c;

   public v() {
      this((byte)0, 0.5D);
   }

   public v(byte var1, double var2) {
      this.a = var1;
      this.b = var2;
      this.c = false;
   }

   public void a(y.f.X var1, y.c.q var2) {
      int var5 = d.g;
      if(var2.g() != null) {
         this.a(var1, var2, var2.g());
      }

      int var3 = 0;
      y.c.d var4 = var2.f();

      while(var4 != null) {
         this.a(var1, var2, var4, var3);
         var4 = var4.g();
         ++var3;
         if(var5 != 0) {
            break;
         }
      }

   }

   protected void a(y.f.X var1, y.c.q var2, y.c.d var3) {
      int var7 = d.g;
      y.f.I var4 = var1.b(var3);
      switch(this.a) {
      case 0:
      default:
         var4.setTargetPoint(y.d.t.c);
         if(var7 == 0) {
            break;
         }
      case 1:
         aE var5 = this.a(var1, var3);
         if(var5 == null || !var5.a()) {
            if(var5 == null || var5.g()) {
               var4.setTargetPoint(y.d.t.c);
               if(var7 == 0) {
                  return;
               }
            }

            am var6 = var1.a((Object)var2);
            if(var5.c()) {
               var4.setTargetPoint(new y.d.t(0.0D, -var6.getHeight() * 0.5D));
               if(var7 == 0) {
                  return;
               }
            }

            if(var5.e()) {
               var4.setTargetPoint(new y.d.t(var6.getWidth() * 0.5D, 0.0D));
               if(var7 == 0) {
                  return;
               }
            }

            if(var5.d()) {
               var4.setTargetPoint(new y.d.t(0.0D, var6.getHeight() * 0.5D));
               if(var7 == 0) {
                  return;
               }
            }

            var4.setTargetPoint(new y.d.t(-var6.getWidth() * 0.5D, 0.0D));
         }
      }

   }

   protected void a(y.f.X var1, y.c.q var2, y.c.d var3, int var4) {
      int var17 = d.g;
      y.f.I var5 = var1.b(var3);
      am var6 = var1.a((Object)var2);
      double var7 = var6.getWidth();
      double var9 = var6.getHeight();
      int var11 = var2.c();
      int var12 = this.c?-1:1;
      double var13;
      double var15;
      switch(this.a) {
      case 0:
         var5.setSourcePoint(y.d.t.c);
         return;
      case 1:
         aE var18 = this.a(var1, var3, var4);
         if(var18 == null || !var18.a()) {
            if(var18 == null || var18.g()) {
               var5.setSourcePoint(y.d.t.c);
               if(var17 == 0) {
                  return;
               }
            }

            if(var18.c()) {
               var5.setSourcePoint(new y.d.t(0.0D, -var6.getHeight() * 0.5D));
               if(var17 == 0) {
                  return;
               }
            }

            if(var18.e()) {
               var5.setSourcePoint(new y.d.t(var6.getWidth() * 0.5D, 0.0D));
               if(var17 == 0) {
                  return;
               }
            }

            if(var18.d()) {
               var5.setSourcePoint(new y.d.t(0.0D, var6.getHeight() * 0.5D));
               if(var17 == 0) {
                  return;
               }
            }

            var5.setSourcePoint(new y.d.t(-var6.getWidth() * 0.5D, 0.0D));
            return;
         }
      default:
         return;
      case 2:
         var13 = this.a(var7, var11);
         var15 = this.a(var7, var11, var13);
         var5.setSourcePoint(new y.d.t((double)var12 * (var13 + (double)var4 * var15 - var7 / 2.0D), -var9 / 2.0D));
         return;
      case 3:
         var13 = this.a(var7, var11);
         var15 = this.a(var7, var11, var13);
         var5.setSourcePoint(new y.d.t((double)var12 * (var13 + (double)var4 * var15 - var7 / 2.0D), var9 / 2.0D));
         return;
      case 4:
         var13 = this.a(var9, var11);
         var15 = this.a(var9, var11, var13);
         var5.setSourcePoint(new y.d.t(var7 / 2.0D, (double)var12 * (var13 + (double)var4 * var15 - var9 / 2.0D)));
         return;
      case 5:
         var13 = this.a(var9, var11);
         var15 = this.a(var9, var11, var13);
         var5.setSourcePoint(new y.d.t(-var7 / 2.0D, (double)var12 * (var13 + (double)var4 * var15 - var9 / 2.0D)));
      }
   }

   protected double a(double var1, int var3) {
      return var3 <= 1?var1 * 0.5D:this.b * (var1 / ((double)(var3 - 1) + 2.0D * this.b));
   }

   protected double a(double var1, int var3, double var4) {
      return var3 <= 1?0.0D:(var1 - 2.0D * var4) / (double)(var3 - 1);
   }

   protected aE a(y.f.X var1, y.c.d var2, int var3) {
      return aE.d(var1, var2);
   }

   protected aE a(y.f.X var1, y.c.d var2) {
      return aE.e(var1, var2);
   }
}
