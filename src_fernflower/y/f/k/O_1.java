package y.f.k;

import y.f.am;
import y.f.k.A;
import y.f.k.I;
import y.f.k.K;
import y.f.k.d;
import y.f.k.x;

class O implements I {
   private I a;
   private y.d.r b;
   private y.c.q c;
   private y.c.y d;
   private y.c.A e;
   private y.c.A f;
   private I g;

   public O(I var1, y.c.q var2, y.c.y var3, y.c.A var4, y.c.A var5, y.d.r var6) {
      int var7;
      label19: {
         var7 = d.g;
         super();
         this.a = var1;
         this.c = var2;
         this.e = var4;
         this.d = var3;
         this.f = var5;
         if(var1 instanceof O) {
            this.g = ((O)var1).a();
            if(var7 == 0) {
               break label19;
            }
         }

         this.g = var1;
      }

      if(var6 == null) {
         this.b = new y.d.r(0.0D, 0.0D, 0.0D, 0.0D);
         if(var7 == 0) {
            return;
         }
      }

      this.b = var6;
   }

   public I a() {
      return this.g;
   }

   public void a(y.c.q var1, y.c.b var2) {
      this.a.a(var1, var2);
   }

   public A a(y.c.c var1, y.c.c var2, y.f.X var3, y.c.q var4, byte var5) {
      A var6 = this.a.a(var1, var2, var3, var4, var5);
      y.d.y var7 = this.a(var3, var4, var6);
      var6.b(var7.c(), var7.d(), var7.a(), var7.b());
      this.f.a(this.c, var4);
      var3.b(this.c, var7.a, var7.b);
      var3.c(this.c, var7.c - var6.i(), var7.d - var6.j());
      return var6;
   }

   private y.d.y a(y.f.X var1, y.c.q var2, A var3) {
      int var12 = d.g;
      y.d.y var4 = null;
      y.c.x var5 = this.d.a();

      while(true) {
         if(var5.f()) {
            y.c.q var6 = var5.e();
            if(var12 != 0) {
               break;
            }

            if(var6 != this.c) {
               y.d.t var8;
               label28: {
                  boolean var7 = var6.e() == null;
                  if(var7) {
                     y.c.q var9 = (y.c.q)this.f.b(var6);
                     y.d.t var10 = this.a(var9, var2, var1, var3);
                     y.d.t var11 = var1.o(var6);
                     var8 = y.d.t.b(var10, var11);
                     if(var12 == 0) {
                        break label28;
                     }
                  }

                  var8 = this.a(var6, var2, var1, var3);
               }

               var4 = this.a(var4, new y.d.y(var8, var1.r(var6)));
            }

            var5.g();
            if(var12 == 0) {
               continue;
            }
         }

         var4 = new y.d.y(var4.c() - this.b.b, var4.d() - this.b.a, var4.a() + this.b.b + this.b.d, var4.b() + this.b.a + this.b.c);
         break;
      }

      return var4;
   }

   private y.d.t a(y.c.q var1, y.c.q var2, y.f.X var3, A var4) {
      int var13 = d.g;
      y.d.t var5;
      if(var1 == var2) {
         var5 = new y.d.t(var4.i(), var4.j());
         if(var13 == 0) {
            return var5;
         }
      }

      double var6 = 0.0D;
      double var8 = 0.0D;
      y.c.q var10 = var1.g().c();

      while(var10 != var2) {
         y.c.q var11;
         label20: {
            var11 = var10.g().c();
            A var12 = this.a(var10);
            if(var11 == var2) {
               var6 += var12.i() - var12.a;
               var8 += var12.j() - var12.b;
               if(var13 == 0) {
                  break label20;
               }
            }

            var6 += var12.a;
            var8 += var12.b;
         }

         var10 = var11;
         if(var13 != 0) {
            break;
         }
      }

      am var14 = var3.a((Object)var1);
      var5 = new y.d.t(var14.getX() + var6, var14.getY() + var8);
      return var5;
   }

   private A a(y.c.q var1) {
      return (A)this.e.b(var1);
   }

   private y.d.y a(y.d.y var1, y.d.y var2) {
      if(var1 == null) {
         return var2;
      } else if(var2 == null) {
         return var1;
      } else {
         double var3 = Math.min(var1.c(), var2.c());
         double var5 = Math.max(var1.c() + var1.a(), var2.c() + var2.a());
         double var7 = Math.min(var1.d(), var2.d());
         double var9 = Math.max(var1.d() + var1.b(), var2.d() + var2.b());
         return new y.d.y(var3, var7, var5 - var3, var9 - var7);
      }
   }

   public K a(x var1, y.f.X var2, y.c.q var3) {
      return this.a.a(var1, var2, var3);
   }
}
