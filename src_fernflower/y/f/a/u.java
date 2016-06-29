package y.f.a;

import y.f.a.f;
import y.f.a.v;
import y.f.a.w;
import y.g.I;

class u implements y.a.p {
   y.c.i a;
   boolean b = false;
   boolean c = false;

   public y.c.x a(y.c.i var1) {
      int var4 = f.u;
      this.a = var1;
      y.c.f var2 = new y.c.f();
      if(!this.a()) {
         var2 = y.a.h.b(var1);
      }

      if(!this.b()) {
         var2.a(y.a.h.e(var1));
      }

      y.c.y var3 = this.c();

      while(!var2.isEmpty()) {
         var1.a(var2.d());
         if(var4 != 0) {
            break;
         }
      }

      return var3.a();
   }

   public boolean a() {
      return this.b;
   }

   public boolean b() {
      return this.b;
   }

   y.c.y c() {
      int var17 = f.u;
      if(this.a.f() < 3) {
         return new y.c.y(this.a.o());
      } else {
         y.c.A var1 = this.a.t();
         y.c.A var2 = this.a.t();
         y.c.h var3 = this.a.u();
         y.g.a.h var4 = new y.g.a.h(this.a, new w(), 0, this.b(this.a));
         int var5 = this.a.f();
         y.c.f var6 = new y.c.f();
         y.c.f var7 = new y.c.f();
         I var8 = new I(this.a);

         y.c.e var13;
         y.c.q var25;
         y.c.d var27;
         label267:
         while(true) {
            int var10000 = var5;

            label264:
            while(true) {
               int var10001 = 3;

               y.c.q var9;
               y.c.e var32;
               label261:
               while(true) {
                  if(var10000 <= var10001) {
                     break label264;
                  }

                  var9 = var4.e();
                  Integer var10 = new Integer(var5);
                  if(var17 != 0) {
                     break label267;
                  }

                  y.c.x var11 = var9.m();

                  label180: {
                     while(var11.f()) {
                        var1.a(var11.e(), var10);
                        var2.a(var11.e(), false);
                        var11.g();
                        if(var17 != 0) {
                           break label180;
                        }

                        if(var17 != 0) {
                           break;
                        }
                     }

                     var11 = var9.m();
                  }

                  y.c.q var12;
                  y.c.d var14;
                  label258:
                  while(true) {
                     if(var11.f()) {
                        var12 = var11.e();
                        var32 = var12.l();
                        if(var17 != 0) {
                           break label261;
                        }

                        var13 = var32;

                        while(var13.f()) {
                           var14 = var13.a();
                           var10000 = var1.a(var14.d());
                           var10001 = var5;
                           if(var17 != 0) {
                              break label258;
                           }

                           if(var10000 == var5) {
                              var7.add(var14);
                              var2.a(var14.c(), true);
                              var2.a(var14.d(), true);
                           }

                           var13.g();
                           if(var17 != 0) {
                              break;
                           }
                        }

                        var11.g();
                        if(var17 == 0) {
                           continue;
                        }
                     }

                     var10000 = var7.size();
                     var10001 = var9.a() - 1;
                     break;
                  }

                  y.c.q var33;
                  label242: {
                     if(var10000 < var10001) {
                        y.c.q var22 = null;
                        y.c.x var23 = var9.m();

                        label278: {
                           while(var23.f()) {
                              var25 = var23.e();
                              var10000 = var1.a(var25);
                              var10001 = var5;
                              if(var17 != 0) {
                                 break label278;
                              }

                              if(var10000 == var5 && !var2.d(var25)) {
                                 label232: {
                                    if(var22 == null) {
                                       var22 = var25;
                                       if(var17 == 0) {
                                          break label232;
                                       }
                                    }

                                    var14 = this.a.a(var22, var25);
                                    var3.a(var14, true);
                                    var7.add(var14);
                                    var22 = null;
                                 }
                              }

                              var23.g();
                              if(var17 != 0) {
                                 break;
                              }
                           }

                           if(var22 != null) {
                              var23 = var9.m();

                              while(var23.f()) {
                                 var25 = var23.e();
                                 var33 = var25;
                                 if(var17 != 0) {
                                    break label242;
                                 }

                                 if(var25 != var22 && var25.c(var22) == null) {
                                    var14 = this.a.a(var22, var25);
                                    var3.a(var14, true);
                                    var7.add(var14);
                                    if(var17 == 0) {
                                       break;
                                    }
                                 }

                                 var23.g();
                                 if(var17 != 0) {
                                    break;
                                 }
                              }
                           }

                           var10000 = var7.size();
                           var10001 = var9.a() - 1;
                        }

                        if(var10000 < var10001) {
                           int var24 = Integer.MAX_VALUE;
                           var25 = null;
                           y.c.x var29 = var9.m();

                           y.c.q var15;
                           while(var29.f()) {
                              var15 = var29.e();
                              var10000 = var15.a();
                              var10001 = var24;
                              if(var17 != 0) {
                                 continue label261;
                              }

                              if(var10000 < var24) {
                                 var25 = var15;
                                 var24 = var15.a();
                              }

                              var29.g();
                              if(var17 != 0) {
                                 break;
                              }
                           }

                           var29 = var9.m();

                           while(var29.f()) {
                              var15 = var29.e();
                              var33 = var25;
                              if(var17 != 0) {
                                 break label242;
                              }

                              if(var25.c(var15) == null && var25 != var15) {
                                 y.c.d var16 = this.a.a(var25, var15);
                                 var3.a(var16, true);
                                 var7.add(var16);
                                 if(var7.size() >= var9.a() - 1) {
                                    break;
                                 }
                              }

                              var29.g();
                              if(var17 != 0) {
                                 break;
                              }
                           }
                        }
                     }

                     var33 = var9;
                  }

                  var11 = var33.m();

                  while(var11.f()) {
                     var12 = var11.e();
                     var4.d(var12);
                     var11.g();
                     if(var17 != 0) {
                        continue label267;
                     }

                     if(var17 != 0) {
                        break;
                     }
                  }

                  var32 = var7.a();
                  break;
               }

               y.c.e var26 = var32;

               while(var26.f()) {
                  var27 = var26.a();
                  var10000 = var3.d(var27);
                  if(var17 != 0) {
                     continue label264;
                  }

                  if(var10000 != 0) {
                     var4.c(var27.c());
                     var4.c(var27.d());
                  }

                  var26.g();
                  if(var17 != 0) {
                     break;
                  }
               }

               var6.a(var7);
               var8.a(var9);
               --var5;
               if(var17 == 0) {
                  continue label267;
               }
               break;
            }

            var8.f();
            var4.b();
            break;
         }

         y.c.e var18 = var6.a();

         y.c.i var34;
         while(true) {
            if(var18.f()) {
               y.c.d var20 = var18.a();
               var34 = var20.a();
               if(var17 != 0) {
                  break;
               }

               if(var34 != null) {
                  label290: {
                     if(var3.d(var20)) {
                        this.a.a(var20);
                        if(var17 == 0) {
                           break label290;
                        }
                     }

                     this.a.d(var20);
                  }
               }

               var18.g();
               if(var17 == 0) {
                  continue;
               }
            }

            var34 = this.a;
            break;
         }

         y.c.f var19 = y.a.q.a(var34);
         y.c.y var21 = new y.c.y();
         y.c.d var28 = (y.c.d)var19.a(0);
         var27 = (y.c.d)var19.a(1);
         var13 = null;
         if(var28.c() != var27.c() && var28.c() != var27.d()) {
            var25 = var28.c();
         } else {
            var25 = var28.d();
         }

         var21.add(var25);
         y.c.e var30 = var19.a();

         y.c.d var31;
         while(true) {
            if(var30.f()) {
               var31 = var30.a();
               var25 = var31.a(var25);
               var21.add(var25);
               var30.g();
               if(var17 != 0) {
                  break;
               }

               if(var17 == 0) {
                  continue;
               }
            }

            var30 = var6.a();
            break;
         }

         while(true) {
            if(var30.f()) {
               var31 = var30.a();
               if(var17 != 0) {
                  break;
               }

               if(!var3.d(var31) && var31.a() == null) {
                  this.a.e(var31);
               }

               var30.g();
               if(var17 == 0) {
                  continue;
               }
            }

            this.a.a(var2);
            this.a.a(var3);
            this.a.a(var1);
            this.a(var21);
            break;
         }

         return var21;
      }
   }

   void a(y.c.y var1) {
      int var10 = f.u;
      if(var1.size() < this.a.f()) {
         y.c.A var2 = this.a.t();
         y.c.p var3 = var1.k();

         y.c.q var4;
         while(var3 != null) {
            var4 = (y.c.q)var3.c();
            var2.a(var4, var3);
            var3 = var3.a();
            if(var10 != 0) {
               return;
            }

            if(var10 != 0) {
               break;
            }
         }

         y.g.a.h var11 = new y.g.a.h(this.a, new v(var2), 0, var1.size(), new v(var2));

         label123: {
            label122:
            while(!var11.a()) {
               var4 = var11.f();
               y.c.x var5 = var4.m();

               label120:
               while(true) {
                  y.c.q var6;
                  y.c.p var7;
                  y.c.q var8;
                  y.c.p var9;
                  Object var10000;
                  if(var5.f()) {
                     var6 = var5.e();
                     var10000 = var2.b(var6);
                     if(var10 == 0) {
                        if(var10000 != null) {
                           var7 = (y.c.p)var2.b(var6);
                           var8 = (y.c.q)var1.f(var7).c();
                           var9 = null;
                           if(var4.c(var8) != null) {
                              var9 = var1.a(var4, var7);
                           } else {
                              var9 = var1.b(var4, var7);
                           }

                           var2.a(var4, var9);
                           if(var10 != 0) {
                              var5.g();
                              if(var10 == 0) {
                                 continue;
                              }
                           }
                        } else {
                           var5.g();
                           if(var10 == 0) {
                              continue;
                           }
                        }

                        var5 = var4.m();
                        if(!var5.f()) {
                           break;
                        }

                        var6 = var5.e();
                        if(var10 != 0) {
                           break label123;
                        }

                        var10000 = var2.b(var6);
                     }
                  } else {
                     var5 = var4.m();
                     if(!var5.f()) {
                        break;
                     }

                     var6 = var5.e();
                     if(var10 != 0) {
                        break label123;
                     }

                     var10000 = var2.b(var6);
                  }

                  while(true) {
                     while(var10 != 0) {
                        if(var10000 != null) {
                           var7 = (y.c.p)var2.b(var6);
                           var8 = (y.c.q)var1.f(var7).c();
                           var9 = null;
                           if(var4.c(var8) != null) {
                              var9 = var1.a(var4, var7);
                           } else {
                              var9 = var1.b(var4, var7);
                           }

                           var2.a(var4, var9);
                           if(var10 != 0) {
                              var5.g();
                              if(var10 == 0) {
                                 continue label120;
                              }
                           }
                        } else {
                           var5.g();
                           if(var10 == 0) {
                              continue label120;
                           }
                        }

                        var5 = var4.m();
                        if(!var5.f()) {
                           continue label122;
                        }

                        var6 = var5.e();
                        if(var10 != 0) {
                           break label123;
                        }

                        var10000 = var2.b(var6);
                     }

                     if(var10000 == null) {
                        var11.c(var6);
                     }

                     var5.g();
                     if(var10 != 0) {
                        break label122;
                     }

                     if(!var5.f()) {
                        continue label122;
                     }

                     var6 = var5.e();
                     if(var10 != 0) {
                        break label123;
                     }

                     var10000 = var2.b(var6);
                  }
               }
            }

            this.a.a(var2);
         }

         var11.b();
      }

   }

   int b(y.c.i var1) {
      int var4 = f.u;
      int var2 = 0;
      y.c.x var3 = var1.o();

      int var10000;
      while(true) {
         if(var3.f()) {
            var10000 = Math.max(var2, var3.e().a());
            if(var4 != 0) {
               break;
            }

            var2 = var10000;
            var3.g();
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }
}
