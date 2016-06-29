package y.f.e;

import y.f.X;
import y.f.ad;
import y.f.ah;
import y.f.am;
import y.f.e.i;
import y.f.e.l;
import y.g.ar;

public class k implements ad {
   private ah h;
   protected X a;
   protected ar b;
   protected double[] c;
   protected double[] d;
   protected double[] e;
   protected double[] f;
   protected y.c.q[] g;
   private int i = 0;
   private double n;

   public k(ar var1, double var2) {
      if(var1 == null) {
         var1 = new ar();
      }

      this.b = var1;
      this.n = var2;
   }

   public void c(X var1) {
      boolean var34 = i.b;
      if(this.h != null) {
         this.h.c(var1);
      }

      if(var1.e() >= 1) {
         this.a = var1;
         this.g = var1.m();
         this.c = new double[this.g.length];
         this.d = new double[this.g.length];
         this.e = new double[this.g.length];
         this.f = new double[this.g.length];
         double var2 = 0.0D;
         double var4 = 0.0D;
         double var8 = Double.MAX_VALUE;
         double var6 = Double.MAX_VALUE;
         double var12 = -1.7976931348623157E308D;
         double var10 = -1.7976931348623157E308D;
         double var14 = this.n * 2.0D;
         int var16 = this.g.length - 1;

         double var10000;
         double var10001;
         while(true) {
            if(var16 >= 0) {
               am var17 = var1.a((Object)this.g[var16]);
               var10000 = this.n;
               var10001 = 0.0D;
               if(var34) {
                  break;
               }

               label95: {
                  if(var10000 > 0.0D) {
                     this.e[var16] = var17.getWidth() + this.n;
                     this.f[var16] = var17.getHeight() + this.n;
                     if(!var34) {
                        break label95;
                     }
                  }

                  this.e[var16] = var17.getWidth();
                  this.f[var16] = var17.getHeight();
               }

               double var18 = var17.getX() + var17.getWidth() / 2.0D;
               double var20 = var17.getY() + var17.getHeight() / 2.0D;
               var2 += this.c[var16] = var18;
               var4 += this.d[var16] = var20;
               double var22 = 0.5D * var17.getWidth();
               double var24 = 0.5D * var17.getHeight();
               if(var18 + var22 > var10) {
                  var10 = var18 + var22;
               }

               if(var20 + var24 > var12) {
                  var12 = var20 + var24;
               }

               if(var18 - var22 < var6) {
                  var6 = var18 - var22;
               }

               if(var20 - var24 < var8) {
                  var8 = var20 - var24;
               }

               --var16;
               if(!var34) {
                  continue;
               }
            }

            var10000 = (var10 - var6) * (var12 - var8);
            var10001 = 1.0D;
            break;
         }

         double var35 = Math.max(var10000, var10001);
         l var38 = new l();
         var38.a(this.n);
         var38.a(false);
         var38.b(true);
         var38.a((byte)2);
         int var39 = 10;

         boolean var19;
         label81:
         do {
            var38.c(var1);
            double var21 = 0.0D;
            double var23 = 0.0D;

            while(true) {
               int var25 = this.g.length - 1;

               label63: {
                  while(var25 >= 0) {
                     double var26 = this.c[var25] - var1.j(this.g[var25]);
                     double var28 = this.d[var25] - var1.k(this.g[var25]);
                     var21 += var26 * var26 + var28 * var28;
                     var23 = Math.max(var23, var26 * var26 + var28 * var28);
                     --var25;
                     if(var34) {
                        break label63;
                     }

                     if(var34) {
                        break;
                     }
                  }

                  var21 /= (double)this.g.length;
               }

               double var40 = Math.sqrt(var21) / (Math.sqrt(var35) * 0.025D);
               var19 = var40 > 1.01D && var39-- > 0 && Math.sqrt(var23) >= this.n;
               if(!var19) {
                  break;
               }

               double var27 = var2 / (double)this.g.length;
               double var29 = var4 / (double)this.g.length;
               var4 = 0.0D;
               var2 = 0.0D;
               double var31 = Math.min(2.0D, 1.05D + Math.sqrt(var40) * 0.05D);
               var35 *= var31 * var31;
               int var33 = this.g.length - 1;

               while(true) {
                  if(var33 < 0) {
                     continue label81;
                  }

                  var2 += this.c[var33] = var27 + (this.c[var33] - var27) * var31;
                  var4 += this.d[var33] = var27 + (this.d[var33] - var29) * var31;
                  var1.a(this.g[var33], this.c[var33], this.d[var33]);
                  --var33;
                  if(var34) {
                     break;
                  }

                  if(var34) {
                     continue label81;
                  }
               }
            }
         } while(var19);

      }
   }

   public ah a() {
      return this.h;
   }

   public void a(ah var1) {
      this.h = var1;
   }
}
