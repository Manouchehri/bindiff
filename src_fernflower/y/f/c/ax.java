package y.f.c;

import y.f.c.a;

class ax {
   double a;
   double b;

   public void a(double var1) {
      this.a = var1;
   }

   public void b(double var1) {
      this.b = var1;
   }

   public void a(y.f.X var1, y.c.y[] var2, y.c.A var3) {
      boolean var12 = a.i;
      int var4 = 0;

      do {
         int var10000 = var4;

         label59:
         while(true) {
            if(var10000 >= var2.length) {
               return;
            }

            y.c.x var5 = var2[var4].a();
            if(!var5.f()) {
               break;
            }

            y.c.q var6 = var5.e();
            double var7 = var1.q(var6);
            var5.g();

            while(true) {
               if(!var5.f()) {
                  break label59;
               }

               y.c.q var9 = var5.e();
               double var10 = var1.q(var9);
               double var13;
               var10000 = (var13 = var10 - 1.0D) == 0.0D?0:(var13 < 0.0D?-1:1);
               if(var12) {
                  break;
               }

               label69: {
                  if(var10000 > 0 && var7 > 1.0D) {
                     var3.a(var6, this.a);
                     if(!var12) {
                        break label69;
                     }
                  }

                  if(var10 < 1.0D && var7 < 1.0D) {
                     var3.a(var6, this.b);
                     if(!var12) {
                        break label69;
                     }
                  }

                  if(var7 < 1.0D && var6.a() == 0) {
                     var3.a(var6, 0.0D);
                     if(!var12) {
                        break label69;
                     }
                  }

                  if(var10 < 1.0D && var9.a() == 0) {
                     var3.a(var6, 0.0D);
                     if(!var12) {
                        break label69;
                     }
                  }

                  var3.a(var6, this.b);
               }

               var6 = var9;
               var7 = var10;
               var5.g();
               if(var12) {
                  break label59;
               }
            }
         }

         ++var4;
      } while(!var12);

   }

   public void a(y.f.X var1, y.c.y[] var2, y.c.c var3, y.c.A var4) {
      boolean var22 = a.i;
      this.a(var1, var2, var4);
      y.c.d[] var5 = new y.c.d[var1.g()];
      y.c.d[] var6 = new y.c.d[var1.g()];
      y.c.x var7 = var1.o();

      while(var7.f()) {
         y.c.q var8 = var7.e();
         Object var10000 = var3.b(var8);

         label145:
         while(var10000 == null) {
            y.c.d var9 = var8.g();

            y.c.d var10;
            y.c.q var28;
            while(true) {
               if(var9 != null) {
                  var10 = var9;
                  var28 = var9.c();
                  if(var22) {
                     break;
                  }

                  y.c.q var11 = var28;

                  label137: {
                     while(var3.b(var11) != null) {
                        var6[var10.b()] = var9;
                        var10 = var11.g();
                        var11 = var10.c();
                        if(var22) {
                           break label137;
                        }

                        if(var22) {
                           break;
                        }
                     }

                     var9 = var9.h();
                  }

                  if(!var22) {
                     continue;
                  }
               }

               var28 = var8;
               break;
            }

            var9 = var28.f();

            while(true) {
               if(var9 == null) {
                  break label145;
               }

               var10 = var9;
               var10000 = var9.d();
               if(var22) {
                  break;
               }

               Object var27 = var10000;

               label120: {
                  while(var3.b(var27) != null) {
                     var5[var10.b()] = var9;
                     var10 = ((y.c.q)var27).f();
                     var27 = var10.d();
                     if(var22) {
                        break label120;
                     }

                     if(var22) {
                        break;
                     }
                  }

                  var9 = var9.g();
               }

               if(var22) {
                  break label145;
               }
            }
         }

         var7.g();
         if(var22) {
            break;
         }
      }

      int var23 = 0;

      do {
         int var29 = var23;

         label94:
         while(true) {
            if(var29 >= var2.length) {
               return;
            }

            y.c.x var24 = var2[var23].a();
            if(!var24.f()) {
               break;
            }

            y.c.q var25 = var24.e();
            double var26 = var1.p(var25);
            var24.g();

            while(true) {
               if(!var24.f()) {
                  break label94;
               }

               y.c.q var12 = var24.e();
               double var13 = var1.p(var12);
               double var30;
               var29 = (var30 = var13 - 1.0D) == 0.0D?0:(var30 < 0.0D?-1:1);
               if(var22) {
                  break;
               }

               if(var29 <= 0 && var26 <= 1.0D) {
                  boolean var15 = false;
                  y.c.d var16;
                  y.c.d var17;
                  double var18;
                  if(var12.b() == 1 && var25.b() == 1) {
                     var16 = var25.g();
                     var17 = var12.g();
                     if(var3.b(var12) != null && var3.b(var25) != null) {
                        var16 = var5[var16.b()];
                        var17 = var5[var17.b()];
                     }

                     if(var16.c() == var17.c()) {
                        var18 = Math.abs(var1.n(var16).a - var1.n(var17).a) - 0.5D * (var13 + var26);
                        if(var4.c(var25) > var18) {
                           var4.a(var25, var18);
                        }

                        var15 = true;
                     }
                  }

                  if(var12.c() == 1 && var25.c() == 1) {
                     var16 = var25.f();
                     var17 = var12.f();
                     if(var3.b(var12) != null && var3.b(var25) != null) {
                        var16 = var6[var16.b()];
                        var17 = var6[var17.b()];
                     }

                     if(var16.d() == var17.d()) {
                        var18 = Math.abs(var1.o(var16).a - var1.o(var17).a) - 0.5D * (var13 + var26);
                        double var20 = var4.c(var25);
                        if(var15) {
                           var18 = Math.max(var18, var20);
                        }

                        if(var18 < var20) {
                           var4.a(var25, var18);
                        }
                     }
                  }
               }

               var25 = var12;
               var26 = var13;
               var24.g();
               if(var22) {
                  break label94;
               }
            }
         }

         ++var23;
      } while(!var22);

   }
}
