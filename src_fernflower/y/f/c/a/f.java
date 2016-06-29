package y.f.c.a;

import java.util.Arrays;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.g;
import y.f.c.a.h;
import y.f.c.a.i;
import y.f.c.a.j;
import y.f.c.a.k;

public class f implements aT {
   private static final y.d.r a = new y.d.r(0.0D, 0.0D, 0.0D, 0.0D);
   private y.f.X b;
   private double c = 1.0D;
   private boolean d = true;
   private aT e;

   public f(aT var1) {
      this.e = var1;
   }

   public aT a() {
      return this.e;
   }

   private boolean a(y.f.X var1) {
      y.c.c var2 = var1.c("AspectRatioComponentLayerer.GROUPING_SUPPORT");
      if(var2 == null) {
         return false;
      } else {
         E var3 = (E)var2.b(var1);
         return var3 != null && var3.k();
      }
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      boolean var24 = N.x;
      this.b = var1;
      boolean var4 = this.a(var1);
      aT var5 = this.a();
      y.c.A var6 = var1.t();
      int var7 = y.a.h.a(var1, (y.c.A)var6);
      if(var7 == 1) {
         var5.a(var1, var2, var3);
         if(!var24) {
            return;
         }
      }

      i[] var8 = new i[var7];
      y.c.x var9 = var1.o();

      while(var9.f()) {
         y.c.q var10 = var9.e();
         int var11 = var6.a(var10);
         if(var24) {
            return;
         }

         label172: {
            if(var8[var11] == null) {
               var8[var11] = new i(this, var10, var11);
               if(!var24) {
                  break label172;
               }
            }

            var8[var11].a(var10);
         }

         var9.g();
         if(var24) {
            break;
         }
      }

      y.g.J var25 = new y.g.J(var1, var6);
      int var26 = 0;

      label160: {
         while(var26 < var7) {
            i var28 = var8[var26];
            var25.c(var28.a());
            var28.a(var2.a());
            var5.a(var1, var28.b(), var3);
            ++var26;
            if(var24) {
               break label160;
            }

            if(var24) {
               break;
            }
         }

         var25.b();
         Arrays.sort(var8, new j(this, (g)null));
      }

      h var27 = new h(this);
      aU var29 = var4?var2.a():var2;
      int var12 = 0;

      while(var12 < var7) {
         i var13 = var8[var12];
         var27.a(var13, var29);
         ++var12;
         if(var24) {
            return;
         }

         if(var24) {
            break;
         }
      }

      if(var4) {
         y.c.A var30 = y.g.M.a();
         int var31 = 0;

         y.c.y var10000;
         label138: {
            while(var31 < var29.b()) {
               var10000 = var29.a(var31).d();
               if(var24) {
                  break label138;
               }

               y.c.x var14 = var10000.a();

               while(true) {
                  if(var14.f()) {
                     var30.a(var14.e(), var31);
                     var14.g();
                     if(var24) {
                        break;
                     }

                     if(!var24) {
                        continue;
                     }
                  }

                  ++var31;
                  break;
               }

               if(var24) {
                  break;
               }
            }

            var10000 = new y.c.y(var1.o());
         }

         y.c.y var32 = var10000;
         E var33 = (E)var1.c("AspectRatioComponentLayerer.GROUPING_SUPPORT").b(var1);
         var33.c();
         y.f.b.c var15 = new y.f.b.c(var1);
         y.c.y var16 = this.a(var15);
         y.c.A var17 = y.g.M.a();
         y.c.x var18 = var16.a();

         while(var18.f()) {
            y.c.q var19 = var18.e();
            var17.a(var19, new k(this, var19, var15));
            var18.g();
            if(var24) {
               return;
            }

            if(var24) {
               break;
            }
         }

         k var35 = new k(this, var15.b(), var15);
         this.a(var8, var15, var35, var17);
         y.c.x var36 = var16.a();

         label108: {
            while(var36.f()) {
               y.c.q var20 = var36.e();
               k var21 = (k)var17.b(var20);
               var21.a(var30, var17);
               var36.g();
               if(var24) {
                  break label108;
               }

               if(var24) {
                  break;
               }
            }

            var35.a(var30, var17);
            var32.sort(new g(this, var30));
         }

         int var37 = 0;
         int var38 = var30.a(var32.b());
         y.c.x var39 = var32.a();

         y.c.q var22;
         int var23;
         int var34;
         label97: {
            while(var39.f()) {
               var22 = var39.e();
               var23 = var30.a(var22);
               var34 = var23;
               if(var24) {
                  break label97;
               }

               if(var23 != var38) {
                  ++var37;
                  var38 = var23;
               }

               var30.a(var22, var37);
               var39.g();
               if(var24) {
                  break;
               }
            }

            var34 = 0;
         }

         int var40 = var34;

         while(var40 <= var37) {
            byte var41 = var40 < var29.b()?var29.a(var40).e():0;
            var2.a(var41, var40);
            ++var40;
            if(var24) {
               break;
            }
         }

         var39 = var32.a();

         label77: {
            while(var39.f()) {
               var22 = var39.e();
               var23 = var30.a(var22);
               var2.a(var23).a(var22);
               var39.g();
               if(var24) {
                  break label77;
               }

               if(var24) {
                  break;
               }
            }

            var15.c();
         }

         var33.b();
      }

   }

   private y.d.r a(y.c.q var1) {
      if(var1 == null) {
         return a;
      } else {
         y.c.c var2 = this.b.c(y.f.b.f.e);
         y.d.r var3 = var2 == null?null:y.d.r.a(var2.b(var1));
         return var3 == null?a:var3;
      }
   }

   private y.c.y a(y.f.b.c var1) {
      boolean var6 = N.x;
      y.c.y var2 = new y.c.y();
      y.c.y var3 = var1.c(var1.b());
      var3.n();
      y.c.x var4 = var3.a();

      while(var4.f()) {
         y.c.q var5 = var4.e();
         if(var1.d(var5)) {
            var2.add(var5);
         }

         var4.g();
         if(var6) {
            break;
         }
      }

      return var2;
   }

   private void a(i[] var1, y.f.b.c var2, k var3, y.c.A var4) {
      boolean var12 = N.x;
      int var5 = 0;

      while(var5 < var1.length) {
         i var6 = var1[var5];
         y.c.y var7 = var6.c();
         y.c.q var10000 = var2.a(var7.b());

         y.c.q var8;
         boolean var9;
         label51:
         while(true) {
            var8 = var10000;
            var9 = true;
            y.c.x var10 = var7.a();

            while(true) {
               if(!var10.f()) {
                  break label51;
               }

               y.c.q var11 = var2.a(var10.e());
               var10000 = var8;
               if(var12) {
                  break;
               }

               if(var8 == null && var11 != null || var8 != null && !var8.equals(var11)) {
                  var9 = false;
                  if(!var12) {
                     break label51;
                  }
               }

               var10.g();
               if(var12) {
                  break label51;
               }
            }
         }

         if(var9) {
            label29: {
               if(var8 == var2.b()) {
                  var3.a(var6);
                  if(!var12) {
                     break label29;
                  }
               }

               k var13 = (k)var4.b(var8);
               var13.a(var6);
            }
         }

         ++var5;
         if(var12) {
            break;
         }
      }

   }

   private double b(y.c.q var1) {
      return !this.d?1.0D:this.b.p(var1);
   }

   private double c(y.c.q var1) {
      return !this.d?1.0D:this.b.q(var1);
   }

   private boolean a(double var1, double var3) {
      double var5 = var1 > this.c?var1 / this.c:this.c / var1;
      double var7 = var3 > this.c?var3 / this.c:this.c / var3;
      return var5 < var7;
   }

   static y.f.X a(f var0) {
      return var0.b;
   }

   static double a(f var0, y.c.q var1) {
      return var0.c(var1);
   }

   static double b(f var0, y.c.q var1) {
      return var0.b(var1);
   }

   static boolean a(f var0, double var1, double var3) {
      return var0.a(var1, var3);
   }

   static y.d.r c(f var0, y.c.q var1) {
      return var0.a(var1);
   }
}
