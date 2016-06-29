package y.f.c;

import y.f.c.R;
import y.f.c.a;
import y.f.c.f;
import y.f.c.w;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.ba;

public class e implements R, aT {
   private double a = 1.0D;
   private double b = 0.0D;
   private double c = Double.MAX_VALUE;
   private double d = 0.0D;

   public void a(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException();
      } else {
         this.c = var1;
      }
   }

   public int a(y.f.X var1, y.c.A var2, y.c.f var3) {
      boolean var15 = a.i;
      if(var1.i()) {
         return 0;
      } else {
         y.c.q[] var4 = var1.m();
         y.g.e.a((Object[])var4, new f(this, var1));
         int var6 = 0;
         double var7 = this.b(var1, var4[0]);
         var2.a(var4[0], var6);
         int var9 = 1;

         int var10000;
         while(true) {
            if(var9 < var4.length) {
               y.c.q var10 = var4[var9];
               double var11 = this.a(var1, var10);
               double var13 = this.b(var1, var10);
               double var16;
               var10000 = (var16 = var11 - var7) == 0.0D?0:(var16 < 0.0D?-1:1);
               if(var15) {
                  break;
               }

               label25: {
                  if(var10000 > 0) {
                     ++var6;
                     var7 = var13;
                     if(!var15) {
                        break label25;
                     }
                  }

                  if(var13 > var7) {
                     var7 = var13;
                  }
               }

               var2.a(var10, var6);
               ++var9;
               if(!var15) {
                  continue;
               }
            }

            var3.a(w.a(var1, var2));
            var10000 = var6 + 1;
            break;
         }

         return var10000;
      }
   }

   protected double a(y.f.X var1, y.c.q var2) {
      y.f.am var3 = var1.a((Object)var2);
      double var4 = Math.max(this.b, Math.min(this.c, this.d * 2.0D + var3.getHeight() * this.a));
      return var3.getY() + 0.5D * (var3.getHeight() - var4);
   }

   protected double b(y.f.X var1, y.c.q var2) {
      y.f.am var3 = var1.a((Object)var2);
      double var4 = Math.max(this.b, Math.min(this.c, this.d * 2.0D + var3.getHeight() * this.a));
      return var3.getY() + 0.5D * (var3.getHeight() + var4);
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      (new ba(this)).a(var1, var2, var3);
   }
}
