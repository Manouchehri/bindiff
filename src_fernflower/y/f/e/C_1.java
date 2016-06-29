package y.f.e;

import java.awt.Rectangle;
import y.f.X;
import y.f.e.i;
import y.g.I;

class C {
   X a;
   y.c.A b;
   y.c.f[] c;
   y.c.y[] d;
   I e;
   boolean f = false;

   C(X var1) {
      this.a = var1;
   }

   void a() {
      y.f.k.o var1;
      boolean var7;
      label71: {
         var7 = i.b;
         this.b = this.a.t();
         this.e = new I(this.a);
         this.d = y.a.A.a(this.a);
         this.c = y.a.A.a((y.c.i)this.a, (y.c.y[])this.d);
         var1 = new y.f.k.o();
         if(this.d.length == 1 && this.d[0].size() == this.a.f()) {
            var1.a(360);
            if(!var7) {
               break label71;
            }
         }

         var1.a(360);
      }

      this.e.a();
      int var2 = 0;

      C var10000;
      while(true) {
         if(var2 < this.c.length) {
            y.c.f var3 = this.c[var2];
            this.a(var3.a());
            var1.a(this.a);
            y.c.q var4 = this.d[var2].b();
            y.d.q var5 = this.a.r(var4);
            Rectangle var6 = this.a.a();
            this.a.b(var4, (double)var6.width, (double)var6.height);
            var6.setSize((int)var5.a(), (int)var5.b());
            var10000 = this;
            if(var7) {
               break;
            }

            this.b.a(var4, var6);

            label59: {
               while(!this.a.i()) {
                  this.a.c(this.a.k());
                  if(var7) {
                     break label59;
                  }

                  if(var7) {
                     break;
                  }
               }

               ++var2;
            }

            if(!var7) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      var10000.e.f();
      var2 = 0;

      while(var2 < this.d.length) {
         label41: {
            y.c.y var8 = this.d[var2];
            y.c.x var9 = var8.a();
            if(var9.f()) {
               y.c.q var10 = var9.e();
               var9.g();

               while(var9.f()) {
                  this.e.a(var9.e());
                  var9.g();
                  if(var7) {
                     break label41;
                  }

                  if(var7) {
                     break;
                  }
               }
            }

            ++var2;
         }

         if(var7) {
            break;
         }
      }

   }

   void b() {
      boolean var34 = i.b;
      this.e.f();
      int[] var1 = new int[this.a.f()];
      int var2 = 0;

      label136:
      while(true) {
         y.c.y var3;
         y.c.y var10000;
         if(var2 < this.d.length) {
            var3 = this.d[var2];
            var10000 = var3;
            if(!var34) {
               y.c.x var4 = var3.a();

               while(true) {
                  if(!var4.f()) {
                     ++var2;
                     break;
                  }

                  y.c.q var5 = var4.e();
                  var1[var5.d()] = var2 + 1;
                  var4.g();
                  if(var34) {
                     break;
                  }

                  if(var34) {
                     ++var2;
                     break;
                  }
               }

               if(!var34) {
                  continue;
               }

               var2 = 0;
               if(var2 >= this.d.length) {
                  break;
               }

               var3 = this.d[var2];
               var10000 = var3;
            }
         } else {
            var2 = 0;
            if(var2 >= this.d.length) {
               break;
            }

            var3 = this.d[var2];
            var10000 = var3;
         }

         while(true) {
            label132:
            while(true) {
               y.c.q var35 = var10000.b();
               y.d.t var36 = this.a.l(var35);
               Rectangle var6 = (Rectangle)this.b.b(var35);
               y.d.q var7 = this.a.r(var35);
               double var8 = var36.a() - var7.a() / 2.0D;
               double var10 = var36.b() - var7.b() / 2.0D;
               double var12 = (double)var6.x;
               double var14 = (double)var6.y;
               double var16 = var8 - var12;
               double var18 = var10 - var14;
               this.a.b(var35, (double)var6.width, (double)var6.height);
               this.a.a(var35, 0.0D, 0.0D);
               int var20 = var1[var35.d()];
               double var21 = 0.0D;
               double var23 = 0.0D;
               if(var34) {
                  return;
               }

               y.c.e var27 = var35.j();

               y.c.x var38;
               while(true) {
                  double var25;
                  if(var27.f()) {
                     y.c.d var28 = var27.a();
                     y.c.q var29 = var28.a(var35);
                     int var37 = var1[var29.d()];
                     if(var34) {
                        if(var37 >= var20) {
                           break label136;
                        }

                        var3 = this.d[var2];
                        var10000 = var3;
                        continue label132;
                     }

                     if(var37 != var20) {
                        double var30 = var36.a() - this.a.j(var29);
                        double var32 = var36.b() - this.a.k(var29);
                        var25 = Math.sqrt(var30 * var30 + var32 * var32);
                        var30 /= var25;
                        var32 /= var25;
                        var21 += var30;
                        var23 += var32;
                     }

                     var27.g();
                     if(!var34) {
                        continue;
                     }

                     if(var21 != 0.0D && var23 != 0.0D) {
                        var25 = Math.sqrt(var21 * var21 + var23 * var23);
                        var21 /= var25;
                        var23 /= var25;
                        this.a(var3.a(), var21, var23);
                     }

                     var38 = var3.a();
                     break;
                  }

                  if(var21 != 0.0D && var23 != 0.0D) {
                     var25 = Math.sqrt(var21 * var21 + var23 * var23);
                     var21 /= var25;
                     var23 /= var25;
                     this.a(var3.a(), var21, var23);
                  }

                  var38 = var3.a();
                  break;
               }

               while(true) {
                  if(var38.f()) {
                     y.c.q var39 = var38.e();
                     this.a.d(var39, var16, var18);
                     var38.g();
                     if(!var34) {
                        if(!var34) {
                           continue;
                        }

                        ++var2;
                        if(var34) {
                           break label136;
                        }
                        break;
                     }

                     if(var34) {
                        break label136;
                     }
                     break;
                  }

                  ++var2;
                  if(var34) {
                     break label136;
                  }
                  break;
               }

               if(var2 >= this.d.length) {
                  break label136;
               }

               var3 = this.d[var2];
               var10000 = var3;
            }
         }
      }

      this.a.a((y.c.A)this.b);
      this.c = null;
      this.d = null;
      this.e = null;
   }

   void a(y.c.x var1, double var2, double var4) {
      boolean var11 = i.b;
      var1.i();

      while(var1.f()) {
         y.c.q var6 = var1.e();
         double var7 = this.a.j(var6);
         double var9 = this.a.k(var6);
         this.a.a(var1.e(), var7 * var2 - var4 * var9, var7 * var4 + var2 * var9);
         var1.g();
         if(var11) {
            break;
         }
      }

   }

   void a(y.c.e var1) {
      boolean var3 = i.b;
      var1.i();

      while(var1.f()) {
         y.c.d var2 = var1.a();
         if(!this.a.f(var2.c())) {
            this.a.d(var2.c());
         }

         if(!this.a.f(var2.d())) {
            this.a.d(var2.d());
         }

         if(!this.a.f(var2)) {
            this.a.e(var2);
         }

         var1.g();
         if(var3) {
            break;
         }
      }

   }
}
