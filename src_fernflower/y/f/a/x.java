package y.f.a;

import java.util.Comparator;
import y.f.a.f;
import y.f.a.y;

class x extends y.f.k.o {
   y.c.A n;
   y.c.h o;
   y.c.h p;
   boolean q = false;
   double r = 90.0D;
   private boolean t = false;

   public void a(y.c.h var1) {
      this.p = var1;
   }

   protected void a(y.c.q var1) {
      if(!this.t) {
         if(this.n()) {
            y var2 = new y(this);
            var1.b((Comparator)var2);
            if(f.u == 0) {
               return;
            }
         }

         super.a(var1);
      }
   }

   void a(y.c.h var1, y.c.A var2) {
      this.n = var2;
      this.o = var1;
      this.q = true;
   }

   protected void b(y.c.q var1) {
      int var27 = f.u;
      if(!this.d(var1)) {
         super.b(var1);
      } else {
         double var2 = this.q();
         double var4 = this.c(var1);
         double var6 = this.r;
         y.c.f var8 = new y.c.f(var1.l());

         while(true) {
            double var9 = (360.0D - var4) / 2.0D + var4;
            double var10000 = var9 - var4;
            this.f(var1);
            double var13 = (360.0D - var4) / 2.0D;
            y.c.p var15 = null;
            y.f.k.q var16 = null;
            y.c.p var17 = var8.k();

            y.c.q var19;
            int var28;
            label105: {
               while(var17 != null) {
                  y.c.d var18 = (y.c.d)var17.c();
                  var19 = var18.d();
                  y.f.k.q var20 = this.e(var19);
                  double var21 = this.o.c(var18);
                  double var23 = var21 - (var13 + var20.c);
                  double var37;
                  var28 = (var37 = var23 - 0.0D) == 0.0D?0:(var37 < 0.0D?-1:1);
                  if(var27 != 0) {
                     break label105;
                  }

                  if(var28 >= 0 && var21 + var20.b >= var9) {
                     label99: {
                        if(var13 + var20.a() <= var9) {
                           var23 = var9 - var13 - var20.a();
                           if(var27 == 0) {
                              break label99;
                           }
                        }

                        var23 = 2.0D * (var9 - (var21 + var20.b));
                     }
                  }

                  label146: {
                     var20.d = 0.0D;
                     if(var23 >= 0.0D) {
                        var20.d = var23;
                        var15 = var17;
                        var16 = var20;
                        if(var27 == 0) {
                           break label146;
                        }
                     }

                     label89: {
                        if(-var23 > var20.b + var20.c) {
                           var23 = (var20.b + var20.c) / 2.0D;
                           if(var27 == 0) {
                              break label89;
                           }
                        }

                        var23 /= -2.0D;
                     }

                     var13 -= var23;
                     if(var13 <= var9 && var13 + var20.a() > var9) {
                        var13 += var23;
                        var23 = var13 + var20.a() - var9;
                        var13 -= var23;
                     }

                     while(var15 != null) {
                        double var38;
                        var28 = (var38 = var23 - var16.d) == 0.0D?0:(var38 < 0.0D?-1:1);
                        if(var27 != 0) {
                           break label105;
                        }

                        if(var28 <= 0) {
                           break;
                        }

                        var23 -= var16.d;
                        var16.d = 0.0D;
                        var15 = var15.b();
                        if(var15 == null) {
                           var16 = null;
                           break;
                        }

                        var16 = this.e(((y.c.d)var15.c()).d());
                        if(var27 != 0) {
                           break;
                        }
                     }

                     if(var15 != null) {
                        var16.d -= var23;
                        if(var27 == 0) {
                           break label146;
                        }
                     }

                     var13 += var23;
                  }

                  var13 += var20.a();
                  var17 = var17.a();
                  if(var27 != 0) {
                     break;
                  }
               }

               double var39;
               var28 = (var39 = var13 - var9) == 0.0D?0:(var39 < 0.0D?-1:1);
            }

            if(var28 <= 0) {
               double var29 = 0.0D;
               var13 = (360.0D - var4) / 2.0D;
               y.c.e var33 = var1.l();

               while(true) {
                  if(var33.f()) {
                     y.c.d var34 = var33.a();
                     y.c.q var36 = var34.d();
                     double var22 = this.o.c(var34);
                     y.f.k.q var24 = this.e(var36);
                     double var25 = var13 + var24.d + var24.c;
                     double var40;
                     var28 = (var40 = var29 - Math.abs(var25 - var22)) == 0.0D?0:(var40 < 0.0D?-1:1);
                     if(var27 != 0) {
                        break;
                     }

                     if(var28 < 0) {
                        var29 = Math.abs(var25 - var22);
                     }

                     var13 += var24.a();
                     var33.g();
                     if(var27 == 0) {
                        continue;
                     }
                  }

                  double var41;
                  var28 = (var41 = var29 - this.r) == 0.0D?0:(var41 < 0.0D?-1:1);
                  break;
               }

               if(var28 <= 0) {
                  return;
               }
            }

            boolean var31 = false;

            while(true) {
               y.c.x var30 = var1.o();

               boolean var32;
               label135: {
                  while(var30.f()) {
                     var19 = var30.e();
                     double var35 = this.e(var19).e;
                     var35 *= 1.0D + var2;
                     var32 = Double.isInfinite(var35);
                     if(var27 != 0) {
                        break label135;
                     }

                     if(var32) {
                        var35 = (double)this.r();
                        var31 = true;
                     }

                     this.e(var19).e = var35;
                     var30.g();
                     if(var27 != 0) {
                        break;
                     }
                  }

                  var32 = var31;
               }

               if(!var32) {
                  break;
               }

               this.r += 10.0D;
               if(var27 == 0) {
                  break;
               }
            }
         }
      }
   }

   protected double c(y.c.q var1) {
      return !this.d(var1)?super.c(var1):(var1.b() == 0?(double)this.o():(double)this.p());
   }

   boolean d(y.c.q var1) {
      return this.q && var1.c() != 0?this.o.b(var1.f()) != null:false;
   }
}
