package y.f.c;

import java.awt.geom.Rectangle2D;
import y.f.c.a;

public class ai extends y.f.k.c {
   private final double b;

   public ai(double var1) {
      this.b = var1;
   }

   protected byte a(y.c.q var1) {
      return (byte)-2;
   }

   protected y.f.k.A a(y.c.q var1, byte var2) {
      boolean var18 = a.i;
      y.f.k.A var3;
      if(var1.c() == 0) {
         var3 = this.c(var1);
         if(!var18) {
            return var3;
         }
      }

      y.f.k.A var4 = null;
      var3 = this.c(var1);
      Rectangle2D var5 = var3.a();
      double var6 = Double.MAX_VALUE;
      double var8 = -1.7976931348623157E308D;
      y.d.c var10 = null;
      double var11 = 0.0D;
      int var13 = 0;
      y.c.d var14 = var1.f();

      label65: {
         while(var14 != null) {
            y.f.k.A var15 = this.b(var14.d());
            var15.a(var15.b(), var15.c(), var15.b(), 0.0D);
            if(var18) {
               break label65;
            }

            label61: {
               if(var10 == null) {
                  var10 = var15.a(1);
                  if(!var18) {
                     break label61;
                  }
               }

               var15.b(-var10.c(var15.a(3)) + this.b, 0.0D);
               var10.a(var15.a(1));
            }

            label56: {
               var6 = Math.min(var6, var15.b());
               var8 = Math.max(var8, var15.b());
               if(var4 == null) {
                  var4 = var15;
                  if(!var18) {
                     break label56;
                  }
               }

               var4.a(var15);
            }

            label50: {
               boolean var16 = var1.c() % 2 == 0;
               int var17 = var1.c() % 2 == 1?(var1.c() - 1) / 2:var1.c() / 2 - 1;
               if(var16) {
                  if(var13 == var17) {
                     var11 = var15.b();
                     if(!var18) {
                        break label50;
                     }
                  }

                  if(var13 != var17 + 1) {
                     break label50;
                  }

                  var11 += var15.b();
                  var11 *= 0.5D;
                  if(!var18) {
                     break label50;
                  }
               }

               if(var13 == var17) {
                  var11 = var15.b();
               }
            }

            var14 = var14.g();
            ++var13;
            if(var18) {
               break;
            }
         }

         var3.b(var11 - var5.getCenterX(), 0.0D);
      }

      var3.a(var4);
      return var3;
   }
}
