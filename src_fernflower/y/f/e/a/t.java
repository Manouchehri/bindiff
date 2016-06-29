package y.f.e.a;

import java.util.ArrayList;
import y.f.e.a.J;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.ai;
import y.f.e.a.am;
import y.f.e.a.as;
import y.f.e.a.ax;
import y.f.e.a.ay;
import y.f.e.a.l;
import y.f.e.a.u;
import y.f.e.a.v;

class t implements am {
   private final ay a;
   private y.c.A b;
   private u c;

   t(ay var1) {
      this.a = var1;
   }

   private y.c.c a(y.f.X var1) {
      y.c.c var2 = var1.c(as.a);
      if(var2 == null) {
         var2 = y.g.q.a((Object)Boolean.TRUE);
      }

      return var2;
   }

   public void a(l var1, af var2) {
      boolean var30 = af.b;
      y.f.X var3 = var2.f();
      if(!y.f.b.c.c((y.c.i)var3)) {
         y.c.c var4 = var3.c(y.f.b.f.e);
         this.b = var3.t();
         y.f.b.c var5 = new y.f.b.c(var3);
         y.c.A var6 = var3.t();
         y.c.A var7 = var3.t();
         ArrayList var8 = new ArrayList();
         y.d.r var9 = new y.d.r(5.0D, 5.0D, 5.0D, 5.0D);
         y.c.c var10 = this.a(var3);
         int var11 = 0;
         y.c.x var12 = var3.o();

         y.c.q var13;
         int var10000;
         while(true) {
            if(var12.f()) {
               var13 = var12.e();
               var10000 = var5.d(var13);
               if(var30) {
                  break;
               }

               if(var10000 != 0 && var10.d(var13)) {
                  ++var11;
                  y.d.r var14 = var9;
                  if(var4 != null) {
                     y.d.r var15 = y.d.r.a(var4.b(var13));
                     if(var15 != null) {
                        var14 = var15;
                     }
                  }

                  double var34 = var3.m(var13) + var14.b;
                  double var17 = var3.n(var13) + var14.a;
                  double var19 = var3.p(var13) - var14.b - var14.d;
                  double var21 = var3.q(var13) - var14.a - var14.c;
                  double var23 = Math.min(var19, var21) / 10.0D;
                  J var25 = new J(new ai(var34, var17, var19, var21, var23), J.d, 0.0D, 1.0D);
                  var25.c(10.0D);
                  ArrayList var26 = new ArrayList(1);
                  var26.add(var25);
                  var6.a(var13, var26);
                  J var27 = new J(new v(var3.m(var13) - var23, var3.n(var13) - var23, var3.p(var13) + 2.0D * var23, var3.q(var13) + 2.0D * var23, var23), J.a, 0.0D, 1.0D);
                  var27.a(J.j);
                  var27.c(10.0D);
                  if(var5.a(var13) == var5.b()) {
                     var8.add(var27);
                  }

                  var7.a(var13, var27);
                  var2.c(var13).d(1.0D);
                  var2.c(var13).a(true);
               }

               var12.g();
               if(!var30) {
                  continue;
               }
            }

            var10000 = var11;
            break;
         }

         y.c.q var33;
         boolean var37;
         label187: {
            if(var10000 > 0) {
               var12 = var3.o();

               label184:
               do {
                  var37 = var12.f();

                  label181: {
                     label180:
                     while(true) {
                        if(!var37) {
                           break label184;
                        }

                        var13 = var12.e();
                        var10000 = var5.d(var13);
                        if(var30) {
                           break label187;
                        }

                        if(var10000 == 0 || !var10.d(var13)) {
                           break label181;
                        }

                        var33 = var5.a(var13);

                        while(true) {
                           if(var33 == var5.b()) {
                              break label180;
                           }

                           var37 = var10.d(var33);
                           if(var30) {
                              break;
                           }

                           if(var37) {
                              break label180;
                           }

                           var33 = var5.a(var33);
                           if(var30) {
                              break label180;
                           }
                        }
                     }

                     if(var33 != var5.b()) {
                        ((ArrayList)var6.b(var33)).add(var7.b(var13));
                     }
                  }

                  var12.g();
               } while(!var30);
            }

            var10000 = var11;
         }

         y.f.b.c var39;
         label155: {
            if(var10000 > 0) {
               var12 = var3.o();

               y.c.q var35;
               label151:
               do {
                  var37 = var12.f();

                  label207: {
                     label147:
                     while(true) {
                        if(!var37) {
                           break label151;
                        }

                        var13 = var12.e();
                        ag var36 = var2.c(var13);
                        if(var30) {
                           return;
                        }

                        if(var36.k() && var10.d(var13)) {
                           break label207;
                        }

                        var35 = var5.a(var13);

                        while(true) {
                           if(var35 == var5.b()) {
                              break label147;
                           }

                           var37 = var10.d(var35);
                           if(var30) {
                              break;
                           }

                           if(var37) {
                              break label147;
                           }

                           var35 = var5.a(var35);
                           if(var30) {
                              break label147;
                           }
                        }
                     }

                     if(var35 != var5.b()) {
                        this.b.a(var13, var6.b(var35));
                        if(!var30) {
                           break label207;
                        }
                     }

                     this.b.a(var13, var8);
                  }

                  var12.g();
               } while(!var30);

               y.c.e var31 = var3.p();

               while(var31.f()) {
                  y.c.d var32 = var31.a();
                  var39 = var5;
                  if(var30) {
                     break label155;
                  }

                  if(!var5.a(var32)) {
                     label218: {
                        var33 = var32.c();
                        var35 = var32.d();
                        y.c.q var16 = var5.a(var33);
                        y.c.q var38 = var5.a(var35);
                        boolean var18 = var16 != var5.b() && var10.d(var16);
                        boolean var40 = var38 != var5.b() && var10.d(var38);
                        double var20;
                        double var22;
                        double var24;
                        if(var18 && var40 && var38 != var16) {
                           var20 = var3.j(var16);
                           var22 = var3.k(var16);
                           var24 = var3.j(var38);
                           double var41 = var3.k(var38);
                           double var28 = Math.sqrt((var24 - var20) * (var24 - var20) + (var41 - var22) * (var41 - var22));
                           var2.b(var32).a(var28);
                           if(!var30) {
                              break label218;
                           }
                        }

                        if(var40 && var16 == var5.b()) {
                           var20 = var3.p(var38) / 2.0D;
                           var22 = var3.q(var38) / 2.0D;
                           var24 = Math.sqrt(var20 * var20 + var22 * var22);
                           var2.b(var32).a(var24 * 0.3D);
                           if(!var30) {
                              break label218;
                           }
                        }

                        if(var38 == var5.b() && var18) {
                           var20 = var3.p(var16) / 2.0D;
                           var22 = var3.q(var16) / 2.0D;
                           var24 = Math.sqrt(var20 * var20 + var22 * var22);
                           var2.b(var32).a(var24 * 0.3D);
                        }
                     }
                  }

                  var31.g();
                  if(var30) {
                     break;
                  }
               }

               this.c = new u(this.b);
               this.a.a((ax)this.c);
            }

            var3.a((y.c.A)var6);
            var3.a((y.c.A)var7);
            var39 = var5;
         }

         var39.c();
      }
   }

   void a(af var1) {
      if(this.b != null) {
         var1.f().a((y.c.A)this.b);
         this.b = null;
      }

      if(this.c != null) {
         this.a.b((ax)this.c);
         this.c = null;
      }

   }
}
