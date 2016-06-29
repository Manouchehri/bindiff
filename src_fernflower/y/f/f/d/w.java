package y.f.f.d;

import y.f.X;
import y.f.f.d.D;
import y.f.f.d.G;
import y.f.f.d.o;
import y.f.f.d.x;

public class w implements y.f.f.b.b {
   private static boolean d = false;
   protected y.c.i a;
   protected y.f.f.b.h b;
   protected y.c.c c = new x(this);
   private int e = 0;
   private int f = 10;
   private int g = 5;
   private int h = 2;

   public void a(y.f.f.b.h var1) {
      this.b = var1;
      this.a = var1.a();
   }

   public int b() {
      return this.e;
   }

   public void a(y.c.h var1) {
      this.c = var1;
   }

   public void a() {
      boolean var9 = o.p;
      X var1 = (X)this.a;
      y.c.A var2 = this.a.t();
      y.c.h var3 = this.a.u();
      this.a(var1, var3, this.c, var2);
      y.c.h var4 = this.a.u();
      this.b(var4);
      int var5 = 2 * (this.g + this.h);
      y.c.h var6 = var1.u();
      y.c.e var7 = var1.p();

      while(var7.f()) {
         var6.a(var7.a(), var5);
         var7.g();
         if(var9) {
            break;
         }
      }

      G var10 = new G();
      var10.a((y.f.f.b.h)this.b);
      var10.a(var2);
      var10.c(var4);
      var10.a((y.c.c)var6);
      var10.b(d);
      y.c.h var8 = this.a.u();
      var10.b(var8);
      var10.a();
      this.a(var8, var3);
      this.b.j();
      this.a.a(var8);
      this.a.a(var3);
      this.a.a(var2);
      this.a.a(var4);
      this.e = var10.b();
      var1.a((y.c.h)var6);
   }

   private void b(y.c.h var1) {
      boolean var6 = o.p;
      y.c.x var2 = this.a.o();

      do {
         boolean var10000 = var2.f();

         label32:
         while(true) {
            if(!var10000) {
               return;
            }

            y.c.q var3 = var2.e();
            if(!this.b.g(var3)) {
               break;
            }

            y.c.e var4 = var3.l();

            while(true) {
               if(!var4.f()) {
                  break label32;
               }

               y.c.d var5 = var4.a();
               var10000 = this.a(var5.d());
               if(var6) {
                  break;
               }

               if(!var10000) {
                  var1.a(this.b.a(var5), true);
               }

               var4.g();
               if(var6) {
                  break label32;
               }
            }
         }

         var2.g();
      } while(!var6);

   }

   private void a(y.c.h var1, y.c.h var2) {
      boolean var20 = o.p;
      y.f.f.b.o var3 = null;
      double var4 = Double.MAX_VALUE;
      y.c.d var6 = this.a.p().a();
      int var7 = 0;

      w var10000;
      while(true) {
         if(var7 < 4) {
            y.f.f.b.o var8 = y.f.f.b.o.a(var7);
            this.b.a(var1, var6, var8);
            double var9 = 0.0D;
            var10000 = this;
            if(var20) {
               break;
            }

            y.c.e var11 = this.a.p();

            int var21;
            label45: {
               while(var11.f()) {
                  y.c.d var12 = var11.a();
                  var21 = this.c.d(var12);
                  if(var20) {
                     break label45;
                  }

                  if(var21 == 0 && !this.c.d(this.b.a(var12))) {
                     int var13 = this.b.h(var12).b(2).g();
                     double var14 = (double)var13 * 3.141592653589793D / 2.0D;
                     double var16 = var2.c(var12);
                     if(!Double.isNaN(var16)) {
                        double var18 = y.d.b.a(var14, -var16);
                        if(var18 > 3.141592653589793D) {
                           var18 = 6.283185307179586D - var18;
                        }

                        var9 += var18;
                     }
                  }

                  var11.g();
                  if(var20) {
                     break;
                  }
               }

               double var22;
               var21 = (var22 = var9 - var4) == 0.0D?0:(var22 < 0.0D?-1:1);
            }

            if(var21 < 0) {
               var4 = var9;
               var3 = var8;
            }

            ++var7;
            if(!var20) {
               continue;
            }
         }

         this.b.a(var1, var6, var3);
         var10000 = this;
         break;
      }

      var10000.b.l();
   }

   private boolean a(y.c.q var1) {
      return this.b.b(var1) || this.b.g(var1);
   }

   private void a(X var1, y.c.h var2, y.c.c var3, y.c.A var4) {
      boolean var20 = o.p;
      double[] var5 = new double[var1.h()];
      y.d.z var6 = new y.d.z(0.0D, 1.0D);
      y.c.e var7 = var1.p();

      while(var7.f()) {
         y.c.d var8 = var7.a();
         if(!var3.d(var8)) {
            y.d.z var9 = new y.d.z(var1.q(var8), var1.p(var8));
            double var10 = y.d.z.d(var6, var9);
            var5[var8.b()] = var10;
            var2.a(var8, var10);
         }

         var7.g();
         if(var20) {
            break;
         }
      }

      y.c.x var21 = var1.o();

      label110:
      do {
         boolean var10000 = var21.f();

         label107:
         while(var10000) {
            y.c.q var22 = var21.e();
            y.c.D var23 = new y.c.D();
            int var24 = 0;
            y.c.e var11 = var22.l();

            int var26;
            label61: {
               while(var11.f()) {
                  var26 = var3.d(var11.a());
                  if(var20) {
                     break label61;
                  }

                  if(var26 == 0) {
                     ++var24;
                  }

                  var11.g();
                  if(var20) {
                     break;
                  }
               }

               var26 = var24;
            }

            if(var26 >= 2) {
               y.c.e var12 = var22.l();

               while(var3.d(var12.a())) {
                  var12.g();
                  if(var20) {
                     continue label110;
                  }

                  if(var20) {
                     break;
                  }
               }

               D var13 = new D();
               var13.a(var12.a());
               y.c.d[] var14 = new y.c.d[]{var12.a(), null};
               var12.g();
               int var15 = 0;

               while(var15 < var22.c()) {
                  var14[1] = var12.a();
                  var13.a(var14[1]);
                  var10000 = var3.d(var14[1]);
                  if(var20) {
                     continue label107;
                  }

                  if(!var10000) {
                     int var25;
                     label90: {
                        double var16 = y.d.b.a(var5[var14[1].b()], -var5[var14[0].b()]);
                        if(var16 == 0.0D) {
                           y.d.z var18 = new y.d.z(var1.n(var14[0]));
                           y.d.z var19 = new y.d.z(var1.n(var14[1]));
                           if(y.d.z.b(var18, var19)) {
                              var25 = -1;
                              if(!var20) {
                                 break label90;
                              }
                           }

                           var25 = 3;
                           if(!var20) {
                              break label90;
                           }
                        }

                        int var27 = (int)Math.floor(2.0D * var16 / 3.141592653589793D + 0.5D);
                        var25 = var27 - 1;
                     }

                     label82: {
                        var13.a(var25);
                        if(this.b.g(var22)) {
                           if(var25 == 0) {
                              var13.a(new Integer(Math.max(0, 2 * (this.g - this.h))));
                              if(!var20) {
                                 break label82;
                              }
                           }

                           if(var25 == 2) {
                              var13.a(new Integer(Math.max(0, 2 * (this.h - this.g))));
                              if(!var20) {
                                 break label82;
                              }
                           }

                           var13.a(new Integer(this.f));
                           if(!var20) {
                              break label82;
                           }
                        }

                        var13.a(new Integer(this.f));
                     }

                     var23.add(var13);
                     var13 = new D();
                     var13.a(var14[1]);
                     var14[0] = var14[1];
                  }

                  ++var15;
                  var12.b();
                  if(var20) {
                     break;
                  }
               }
            }

            var4.a(var22, var23);
            var21.g();
            continue label110;
         }

         return;
      } while(!var20);

   }
}
