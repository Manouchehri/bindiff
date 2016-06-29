package y.h;

import java.util.Collection;
import y.h.bu;
import y.h.dU;
import y.h.er;
import y.h.et;
import y.h.ez;
import y.h.fj;
import y.h.gy;

class ee extends ez {
   private final bu a;
   private final Collection b;
   private final Collection c;
   private final dU d;

   ee(dU var1, bu var2, Collection var3, Collection var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   protected void a(y.c.q var1, y.c.q var2, boolean var3, double var4, double var6) {
      boolean var31 = fj.z;
      if(var6 - var4 >= 10.0D) {
         double var9;
         double var11;
         double var13;
         double var16;
         double var18;
         double var20;
         double var22;
         Object var24;
         Object var25;
         Object var26;
         label61: {
            fj var8 = this.a.t(var1);
            var9 = var8.getY();
            var11 = var9 + var8.getHeight();
            var13 = (var9 + var11) * 0.5D;
            fj var15 = this.a.t(var2);
            var16 = var15.getY();
            var18 = var16 + var15.getHeight();
            var4 = Math.min(var8.getX(), var15.getX());
            var6 = Math.max(var8.getX() + var8.getWidth(), var15.getX() + var15.getWidth());
            var4 -= dU.a(this.d);
            var6 += dU.a(this.d);
            var20 = Math.max(var8.getX(), var15.getX());
            var22 = Math.min(var8.getX() + var8.getWidth(), var15.getX() + var15.getWidth());
            var24 = y.g.am.a(var1, var3?Boolean.TRUE:Boolean.FALSE);
            var25 = y.g.am.a(var2, var3?Boolean.TRUE:Boolean.FALSE);
            if(var1.d() < var2.d()) {
               var26 = y.g.am.a(var1, var2, var3?Boolean.TRUE:Boolean.FALSE);
               if(!var31) {
                  break label61;
               }
            }

            var26 = y.g.am.a(var2, var1, var3?Boolean.TRUE:Boolean.FALSE);
         }

         double var27 = (var20 + var22) * 0.5D;
         double var32;
         er var29;
         if(var11 < var16) {
            if(dU.b(this.d)) {
               var29 = new er((byte)0, (byte)16, new y.d.t(var27, (var11 + var16) * 0.5D), var4, var6, var26, 1.0D, var11, var16);
               this.b.add(var29);
               this.c.add(var29);
               this.b.add(new et((byte)0, (byte)1, new y.d.t(var27, var18 + (var16 - var11)), var4, var6, var25, 0.5D, var16, var11, var18));
               this.b.add(new et((byte)0, (byte)2, new y.d.t(var27, var9 - (var16 - var11)), var4, var6, var24, 0.5D, var16, var11, var9));
            }

            if(!dU.c(this.d)) {
               return;
            }

            var32 = (var16 + var18) * 0.5D;
            this.b.add(new gy((byte)0, (byte)16, new y.d.t(var27, var32 + var32 - var13), var4, var6, var25, 0.1D));
            this.b.add(new gy((byte)0, (byte)16, new y.d.t(var27, var13 - (var32 - var13)), var4, var6, var24, 0.1D));
            this.b.add(new gy((byte)0, (byte)16, new y.d.t(var27, (var13 + var32) * 0.5D), var4, var6, var26, 0.25D));
            if(!var31) {
               return;
            }
         }

         if(var18 < var9) {
            if(dU.b(this.d)) {
               var29 = new er((byte)0, (byte)16, new y.d.t(var27, (var18 + var9) * 0.5D), var4, var6, var26, 1.0D, var18, var9);
               this.b.add(var29);
               this.c.add(var29);
               this.b.add(new et((byte)0, (byte)1, new y.d.t(var27, var11 + (var9 - var18)), var4, var6, var24, 0.5D, var9, var18, var11));
               this.b.add(new et((byte)0, (byte)2, new y.d.t(var27, var16 - (var9 - var18)), var4, var6, var25, 0.5D, var9, var18, var16));
            }

            if(dU.c(this.d)) {
               var32 = (var16 + var18) * 0.5D;
               this.b.add(new gy((byte)0, (byte)16, new y.d.t(var27, var13 + var13 - var32), var4, var6, var24, 0.1D));
               this.b.add(new gy((byte)0, (byte)16, new y.d.t(var27, var32 - (var13 - var32)), var4, var6, var25, 0.1D));
               this.b.add(new gy((byte)0, (byte)16, new y.d.t(var27, (var13 + var32) * 0.5D), var4, var6, var26, 0.25D));
            }
         }

      }
   }
}
