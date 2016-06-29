package y.f.k;

import y.f.k.A;
import y.f.k.B;
import y.f.k.C;
import y.f.k.E;
import y.f.k.F;
import y.f.k.K;
import y.f.k.P;
import y.f.k.d;
import y.f.k.x;

class D implements K {
   private x a;
   private y.f.X b;
   private y.c.q c;
   private y.c.q d;
   private y.c.A e;
   private int f;
   private int g;
   private double h;
   private final B i;

   D(B var1, x var2, y.f.X var3, y.c.q var4) {
      this.i = var1;
      this.a = var2;
      this.b = var3;
      this.d = var4;
      y.c.A var5 = var3.t();
      this.c = y.a.A.d(var3);
      y.a.A.b(var3, var5);
      this.f = var5.a(this.c);
      this.g = var5.a(var4);
   }

   public void a(y.c.b var1, y.c.b var2, y.c.b var3) {
      if(this.b.c(B.h) == null) {
         this.e = this.b.t();
         this.b.a((Object)B.h, (y.c.c)this.e);
      }

      this.a((y.c.A)this.b.c(B.h), var1);
   }

   E a(y.c.A var1, y.c.b var2) {
      int var13 = d.g;
      E var3 = new E(this.i, this.b);
      var3.a(this.h);
      F[] var4 = new F[this.f];
      int var5 = 0;

      while(var5 < this.f) {
         var4[var5] = var3.a(var5);
         ++var5;
         if(var13 != 0) {
            break;
         }
      }

      y.c.x var10000;
      label74: {
         y.c.y var14 = new y.c.y();
         if(!this.b.i()) {
            y.c.q var6 = this.b.k();
            y.c.x var7 = this.b.o();

            while(var7.f()) {
               var10000 = var7;
               if(var13 != 0) {
                  break label74;
               }

               if(var7.e().b() == 0) {
                  var6 = var7.e();
                  if(var13 == 0) {
                     break;
                  }
               }

               var7.g();
               if(var13 != 0) {
                  break;
               }
            }

            C var16 = new C(this, var14);
            var16.a(true);
            var16.a((y.c.i)this.b, var6);
         }

         var14.n();
         var10000 = var14.a();
      }

      y.c.x var15 = var10000;

      do {
         int var22 = var15.f();

         label54:
         while(true) {
            if(var22 == 0) {
               return var3;
            }

            y.c.q var17 = var15.e();
            F var8;
            A var9;
            P var10;
            if(var17.c() == 0) {
               var8 = var4[this.f - 1];
               var9 = this.a.f(var17);
               var10 = new P(this.i.c, var9);
               var8.a(var17, var10, this.i.c);
               var1.a(var17, var8);
               if(var13 == 0) {
                  break;
               }
            }

            if(var17 == this.c) {
               var8 = var4[0];
               var9 = this.a.f(var17);
               var10 = new P(this.i.c, var9);
               var8.a(var17, var10, this.i.c);
               var1.a(var17, var8);
               if(var13 == 0) {
                  break;
               }
            }

            int var18 = Integer.MAX_VALUE;
            y.c.x var19 = var17.o();

            while(var19.f()) {
               y.c.q var11 = var19.e();
               F var12 = (F)var1.b(var11);
               var22 = var12.c();
               if(var13 != 0) {
                  continue label54;
               }

               if(var22 < var18) {
                  var18 = var12.c();
               }

               var19.g();
               if(var13 != 0) {
                  break;
               }
            }

            var8 = var4[var18 - 1];
            A var20 = this.a.f(var17);
            P var21 = new P(this.i.c, var20);
            var8.a(var17, var21, this.i.c);
            var1.a(var17, var8);
            break;
         }

         var15.g();
      } while(var13 == 0);

      return var3;
   }

   public void a() {
   }

   public void a(double var1) {
      this.h = var1;
   }
}
