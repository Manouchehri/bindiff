package y.f.c;

import y.f.c.E;
import y.f.c.Q;
import y.f.c.R;
import y.f.c.a;
import y.f.c.e;
import y.f.c.v;

class J implements Q, R, v {
   R c;
   Q d;
   v e;
   y.c.y f;
   y.c.y g;
   private final E a;

   J(E var1) {
      this.a = var1;
   }

   void a(y.c.y var1) {
      this.f = var1;
   }

   void b(y.c.y var1) {
      this.g = var1;
   }

   public int a(y.f.X var1, y.c.A var2, y.c.f var3) {
      y.g.I var4;
      boolean var5;
      boolean var6;
      boolean var14;
      boolean var10000;
      label175: {
         var14 = a.i;
         var4 = new y.g.I(var1);
         var5 = false;
         var6 = false;
         boolean var7 = false;
         y.c.p var8;
         y.c.q var9;
         if(this.f != null && this.f.size() > 0) {
            var8 = this.f.k();

            while(var8 != null) {
               var9 = (y.c.q)var8.c();
               var10000 = var1.f(var9);
               if(var14) {
                  break label175;
               }

               if(var10000) {
                  var2.a(var9, 0);
                  var4.a(var9);
                  var5 = true;
               }

               var8 = var8.a();
               if(var14) {
                  break;
               }
            }
         }

         if(this.g != null && this.g.size() > 0) {
            var8 = this.g.k();

            while(var8 != null) {
               var9 = (y.c.q)var8.c();
               var10000 = var1.f(var9);
               if(var14) {
                  break label175;
               }

               if(var10000) {
                  var4.a(var9);
                  var6 = true;
               }

               var8 = var8.a();
               if(var14) {
                  break;
               }
            }
         }

         var10000 = var5;
      }

      int var15;
      int var17;
      label144: {
         var15 = (var10000?1:0) + (var6?1:0);
         if(this.c instanceof e) {
            var17 = 1;
            if(!var14) {
               break label144;
            }
         }

         var17 = y.a.h.a(var1, (y.c.A)this.a.n);
      }

      int var16;
      y.c.q var20;
      int var22;
      label139: {
         label178: {
            y.c.x var21;
            label179: {
               label136: {
                  if(var17 > 1) {
                     var16 = 0;
                     y.g.I var10 = new y.g.I(var1);
                     int var11 = var17 - 1;

                     do {
                        if(var11 < 0) {
                           break label136;
                        }

                        var21 = var1.o();
                        if(var14) {
                           break label179;
                        }

                        y.c.x var12 = var21;

                        int var10001;
                        label130: {
                           while(var12.f()) {
                              y.c.q var13 = var12.e();
                              var22 = this.a.n.a(var13);
                              var10001 = var11;
                              if(var14) {
                                 break label130;
                              }

                              if(var22 != var11) {
                                 var10.a(var13);
                              }

                              var12.g();
                              if(var14) {
                                 break;
                              }
                           }

                           var22 = var16;
                           var10001 = this.c.a(var1, var2, var3);
                        }

                        var16 = Math.max(var22, var10001);
                        var10.f();
                        --var11;
                     } while(!var14);
                  }

                  var16 = this.c.a(var1, var2, var3);
               }

               if(!var5) {
                  break label178;
               }

               var21 = var1.o();
            }

            y.c.x var18 = var21;

            while(var18.f()) {
               var20 = var18.e();
               var2.a(var20, var2.a(var20) + 1);
               var18.g();
               if(var14) {
                  break label139;
               }

               if(var14) {
                  break;
               }
            }
         }

         var4.f();
      }

      y.c.p var19;
      label99: {
         if(var5) {
            var19 = this.f.k();

            while(var19 != null) {
               var20 = (y.c.q)var19.c();
               var10000 = var1.f(var20);
               if(var14) {
                  break label99;
               }

               if(var10000) {
                  var2.a(var20, 0);
               }

               var19 = var19.a();
               if(var14) {
                  break;
               }
            }
         }

         var10000 = var6;
      }

      if(var10000) {
         var19 = this.g.k();

         while(var19 != null) {
            var20 = (y.c.q)var19.c();
            var22 = var1.f(var20);
            if(var14) {
               return var22;
            }

            if(var22 != 0) {
               var2.a(var20, var16 + var15 - 1);
            }

            var19 = var19.a();
            if(var14) {
               break;
            }
         }
      }

      var22 = var16 + var15;
      return var22;
   }

   public y.c.y[] a(y.f.X var1, y.c.A var2, int var3) {
      y.c.y[] var4 = this.d.a(var1, var2, var3);
      return var4;
   }

   public void a(y.f.X var1, y.c.y[] var2, y.c.c var3) {
      this.e.a(var1, var2, var3);
   }

   public void a(y.c.A var1) {
      this.e.a(var1);
   }

   public void a(double var1) {
      this.e.a(var1);
   }

   public void d(double var1) {
      this.e.d(var1);
   }

   public void b(double var1) {
      this.e.b(var1);
   }

   public void c(double var1) {
      this.e.c(var1);
   }
}
