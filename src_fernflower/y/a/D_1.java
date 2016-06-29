package y.a;

import java.util.ArrayList;
import java.util.Random;
import y.a.E;
import y.a.h;

class D {
   private int a;
   private y.c.A b;
   private int c;
   private boolean d;

   D() {
      this.a(0);
      this.b(10);
      this.a(false);
   }

   private void b(y.c.i var1, y.c.y var2, y.c.h var3) {
      boolean var8 = h.a;
      Random var4 = new Random(1234L);
      y.c.A var5 = y.g.M.a(new boolean[var1.e()]);
      y.c.x var6 = var2.a();

      while(true) {
         if(var6.f()) {
            var5.a(var6.e(), true);
            var6.g();
            if(var8) {
               break;
            }

            if(!var8) {
               continue;
            }
         }

         var6 = var2.a();
         break;
      }

      do {
         boolean var10000 = var6.f();

         label51:
         while(true) {
            y.c.d var7;
            label40:
            while(true) {
               if(!var10000) {
                  return;
               }

               var7 = var6.e().g();

               while(true) {
                  if(var7 == null) {
                     break label40;
                  }

                  var10000 = var5.d(var7.c());
                  if(var8) {
                     break;
                  }

                  if(var10000) {
                     var3.a(var7, var4.nextDouble());
                  }

                  var7 = var7.h();
                  if(var8) {
                     break label40;
                  }
               }
            }

            var7 = var6.e().f();

            while(true) {
               if(var7 == null) {
                  break label51;
               }

               var10000 = var5.d(var7.d());
               if(var8) {
                  break;
               }

               if(var10000) {
                  var3.a(var7, var4.nextDouble());
               }

               var7 = var7.g();
               if(var8) {
                  break label51;
               }
            }
         }

         var6.g();
      } while(!var8);

   }

   private void c(y.c.i var1, y.c.y var2, y.c.h var3) {
      boolean var17 = h.a;
      E[] var4 = new E[var1.e()];
      this.a(var2, var3, 0.0D);
      y.c.x var5 = this.a(var2).a();

      label129:
      do {
         boolean var10000 = var5.f();

         label126:
         while(var10000) {
            y.c.q var6 = var5.e();
            if(this.a(var6)) {
               y.c.y var7 = new y.c.y();
               y.c.x var8 = var2.a();

               while(var8.f()) {
                  y.c.q var9 = var8.e();
                  var4[var9.d()] = new E(var9);
                  var8.g();
                  if(var17) {
                     continue label129;
                  }

                  if(var17) {
                     break;
                  }
               }

               y.c.y var18 = new y.c.y();
               var18.add(var6);
               E var19 = var4[var6.d()];
               E.a(var19, 1.0D);
               E.a(var19, 0);

               label113:
               while(true) {
                  var10000 = var18.isEmpty();

                  label111:
                  while(true) {
                     y.c.q var10;
                     E var11;
                     y.c.e var12;
                     y.c.d var13;
                     if(!var10000) {
                        var10 = var18.d();
                        var7.a(var10);
                        var11 = var4[var10.d()];
                        var12 = var10.j();
                        if(!var12.f()) {
                           break;
                        }

                        while(true) {
                           var13 = var12.a();
                           y.c.q var14 = var13.a(var10);
                           var10000 = this.a(var14);
                           if(var17) {
                              break;
                           }

                           if(var17) {
                              continue label111;
                           }

                           if(var10000) {
                              E var15 = var4[var14.d()];
                              if(E.a(var15) < 0) {
                                 E.a(var15, E.a(var11) + 1);
                                 if(this.a() != 2 || E.a(var15) <= this.b()) {
                                    var18.add(var15.a());
                                 }
                              }

                              if(E.a(var15) == E.a(var11) + 1) {
                                 E.b(var15, E.b(var11));
                                 E.c(var15).add(var13);
                              }
                           }

                           var12.g();
                           if(var17) {
                              var10000 = var7.isEmpty();
                              break;
                           }

                           if(!var12.f()) {
                              continue label113;
                           }
                        }
                     } else {
                        var10000 = var7.isEmpty();
                     }

                     while(true) {
                        label88:
                        while(true) {
                           if(var10000) {
                              break label113;
                           }

                           var10 = var7.d();
                           var11 = var4[var10.d()];
                           var12 = E.c(var11).a();

                           while(true) {
                              while(var12.f()) {
                                 var13 = var12.a();
                                 E var20 = var4[var13.a(var10).d()];
                                 var10000 = this.c();
                                 if(var17) {
                                    continue label126;
                                 }

                                 if(var17) {
                                    continue label88;
                                 }

                                 double var21;
                                 if(var10000) {
                                    var21 = E.d(var11) + 1.0D;
                                    E.c(var20, var21);
                                    var3.a(var13, var3.c(var13) + var21 * E.b(var20));
                                    if(!var17) {
                                       var12.g();
                                       if(var17) {
                                          break label113;
                                       }
                                       continue;
                                    }
                                 }

                                 var21 = E.b(var11) > 0.0D?(E.d(var11) + 1.0D) * E.b(var20) / E.b(var11):0.0D;
                                 E.c(var20, var21);
                                 var3.a(var13, var3.c(var13) + var21);
                                 var12.g();
                                 if(var17) {
                                    break label113;
                                 }
                              }

                              var10000 = var7.isEmpty();
                              break;
                           }
                        }
                     }
                  }
               }
            }

            var5.g();
            continue label129;
         }

         return;
      } while(!var17);

   }

   protected boolean a(y.c.q var1) {
      return this.b == null || this.b.a(var1) > 0;
   }

   protected y.c.y a(y.c.y var1) {
      boolean var8 = h.a;
      if(this.a() != 1) {
         return var1;
      } else {
         Random var2 = new Random(1234L);
         y.c.y var3 = new y.c.y();
         ArrayList var4 = new ArrayList(var1);
         int var5 = Math.min(var1.size(), (int)Math.round(Math.log((double)var1.size()) / Math.log(2.0D) * 10.0D));
         int var6 = 0;

         y.c.y var10000;
         while(true) {
            if(var6 < var5) {
               int var7 = var2.nextInt(var4.size());
               var10000 = var3;
               if(var8) {
                  break;
               }

               label23: {
                  var3.add(var4.get(var7));
                  if(var7 == var4.size() - 1) {
                     var4.remove(var4.size() - 1);
                     if(!var8) {
                        break label23;
                     }
                  }

                  var4.set(var7, var4.remove(var4.size() - 1));
               }

               ++var6;
               if(!var8) {
                  continue;
               }
            }

            var10000 = var3;
            break;
         }

         return var10000;
      }
   }

   void a(y.c.i var1, y.c.y var2, y.c.h var3) {
      if(var1.h() != 0 && !var2.isEmpty()) {
         if(this.a() == 3) {
            this.b(var1, var2, var3);
            if(!h.a) {
               return;
            }
         }

         this.c(var1, var2, var3);
      }
   }

   void a(y.c.i var1, y.c.y var2, y.c.A var3, y.c.h var4) {
      if(var1.g() != 0 && !var2.isEmpty()) {
         this.b = var3;
         this.a(var1, var2, var4);
         this.b = null;
      }
   }

   void a(int var1) {
      boolean var2 = h.a;
      this.c = var1;
      switch(var1) {
      case 0:
      default:
         if(!var2) {
            break;
         }
      case 1:
         if(var2) {
            ;
         }
      case 2:
      case 3:
      }

   }

   int a() {
      return this.c;
   }

   int b() {
      return this.a;
   }

   void b(int var1) {
      if(var1 > 1) {
         this.a = var1;
         if(!h.a) {
            return;
         }
      }

      throw new IllegalArgumentException("Maximum path length must be greater than 1.");
   }

   boolean c() {
      return this.d;
   }

   void a(boolean var1) {
      this.d = var1;
   }

   protected void a(y.c.y var1, y.c.h var2, double var3) {
      boolean var8 = h.a;
      y.c.x var5 = var1.a();

      do {
         boolean var10000 = var5.f();

         label50:
         while(true) {
            if(!var10000) {
               return;
            }

            y.c.q var6 = var5.e();
            if(!this.a(var6)) {
               break;
            }

            y.c.d var7 = var6.f();

            while(var7 != null) {
               var10000 = this.a(var7.a(var6));
               if(var8) {
                  continue label50;
               }

               if(var10000) {
                  var2.a(var7, var3);
               }

               var7 = var7.g();
               if(var8) {
                  break;
               }
            }

            var7 = var6.g();

            while(true) {
               if(var7 == null) {
                  break label50;
               }

               var10000 = this.a(var7.a(var6));
               if(var8) {
                  break;
               }

               if(var10000) {
                  var2.a(var7, var3);
               }

               var7 = var7.h();
               if(var8) {
                  break label50;
               }
            }
         }

         var5.g();
      } while(!var8);

   }
}
