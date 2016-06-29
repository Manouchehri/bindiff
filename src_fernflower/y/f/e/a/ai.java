package y.f.e.a;

import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

public class ai implements am, ax {
   private double a = 0.5D;
   private double b = 50.0D;
   private double c;
   private double d;
   private double e;
   private double f;
   private double g;
   private double h;

   public void a(double var1, double var3, double var5, double var7) {
      this.e = var1;
      this.f = var3;
      this.c = var5;
      this.d = var7;
      this.g = this.e + this.c / 2.0D;
      this.h = this.f + this.d / 2.0D;
   }

   public ai() {
      this.g = this.e + this.c / 2.0D;
      this.h = this.f + this.d / 2.0D;
   }

   public ai(double var1, double var3, double var5, double var7, double var9) {
      this.g = this.e + this.c / 2.0D;
      this.h = this.f + this.d / 2.0D;
      this.a(var1, var3, var5, var7);
      this.b = var9;
   }

   public k a(m var1, l var2, a var3) {
      boolean var13 = af.b;
      if(this.c > 0.0D && this.d > 0.0D) {
         k var4 = var1.a();
         double var5 = (this.c - 2.0D * this.b) / 2.0D;
         double var7 = (this.d - 2.0D * this.b) / 2.0D;
         double var9 = this.g - var4.d();
         double var11 = this.h - var4.e();
         if(-var9 > var5 && -var11 > var7) {
            this.a(var4.d() - (this.g + var5), var4.e() - (this.h + var7), var3);
            return var3;
         } else if(var9 > var5 && -var11 > var7) {
            this.a(-var4.d() + (this.g - var5), var4.e() - (this.h + var7), var3);
            var3.a(-var3.d());
            return var3;
         } else if(var9 > var5 && var11 > var7) {
            this.a(-var4.d() + (this.g - var5), -var4.e() + (this.h - var7), var3);
            var3.a(-var3.d());
            var3.b(-var3.e());
            return var3;
         } else if(-var9 > var5 && var11 > var7) {
            this.a(var4.d() - (this.g + var5), -var4.e() + (this.h - var7), var3);
            var3.b(-var3.e());
            return var3;
         } else {
            label68: {
               if(var9 > 0.0D) {
                  if(var9 > var5) {
                     var3.a((var9 - var5) / this.b);
                     return var3;
                  }

                  var3.a(0.0D);
                  if(!var13) {
                     break label68;
                  }
               }

               if(-var9 > var5) {
                  var3.a((var9 + var5) / this.b);
                  return var3;
               }

               var3.a(0.0D);
            }

            if(var11 > 0.0D) {
               if(var11 > var7) {
                  var3.b((var11 - var7) / this.b);
                  return var3;
               }

               var3.b(0.0D);
               if(!var13) {
                  return var3;
               }
            }

            if(-var11 > var7) {
               var3.b((var11 + var7) / this.b);
               return var3;
            } else {
               var3.b(0.0D);
               return var3;
            }
         }
      } else {
         return var3;
      }
   }

   private void a(double var1, double var3, a var5) {
      double var6;
      double var8;
      label29: {
         boolean var18 = af.b;
         var6 = 0.0D;
         var8 = 0.0D;
         double var10 = this.b * this.a;
         if(var1 - var10 >= var3) {
            var6 = -var1 / this.b;
            if(!var18) {
               break label29;
            }
         }

         if(var3 - var10 >= var1) {
            var8 = -var3 / this.b;
            if(!var18) {
               break label29;
            }
         }

         if(var1 < var10 && var3 < var10 && Math.sqrt(var1 * var1 + var3 * var3) <= var10) {
            var6 = -var1 / this.b;
            var8 = -var3 / this.b;
            if(!var18) {
               break label29;
            }
         }

         double var12 = Math.sqrt(var10 * var10 - (var1 - var3) * (var1 - var3) / 2.0D);
         double var14 = (var1 + var3) / 2.0D - var12 * 0.7071067811865476D;
         double var16 = (var14 + var10) / (this.b * var10);
         var6 = (var14 - var1) * var16;
         var8 = (var14 - var3) * var16;
      }

      var5.a(var6);
      var5.b(var8);
   }

   public void a(l var1, af var2) {
      boolean var9 = af.b;
      double var3 = this.g - var2.h();
      double var5 = this.h - var2.i();
      y.c.x var7 = var2.f().o();

      while(var7.f()) {
         ag var8 = var2.c(var7.e());
         var8.a(var8.b() + var3);
         var8.b(var8.c() + var5);
         var7.g();
         if(var9) {
            break;
         }
      }

   }
}
