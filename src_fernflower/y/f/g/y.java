package y.f.g;

import y.f.g.d;

class y {
   public y.d.y a = null;
   public y.c.D b = new y.c.D();
   public boolean c = false;
   private y.c.D d = new y.c.D();
   private y.d.y e = null;
   private boolean f = true;

   public boolean a() {
      return this.f;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   void a(y.d.y var1, double var2) {
      boolean var11 = d.d;
      double var4 = var1.a() / 2.0D;
      double var6 = var1.b() / 2.0D;
      if(this.a != null) {
         label42: {
            y.d.y var8;
            if(var1.a() <= this.a.a() && var1.b() <= this.a.b()) {
               var8 = new y.d.y(this.a.c() + var4, this.a.d() + var6, this.a.a() - var1.a(), this.a.b() - var1.b());
               this.e = a(var8, var2, false);
               if(!var11) {
                  break label42;
               }
            }

            if(var1.a() <= this.a.a()) {
               var8 = new y.d.y(this.a.c() + var4, this.a.d() + this.a.b(), this.a.a() - var1.a(), 0.0D);
               this.e = a(var8, var2, false);
               if(!var11) {
                  break label42;
               }
            }

            if(var1.b() <= this.a.b()) {
               var8 = new y.d.y(this.a.c() + this.a.a() / 2.0D, this.a.d() + var6, 0.0D, this.a.b() - var1.b());
               this.e = a(var8, var2, false);
               if(!var11) {
                  break label42;
               }
            }

            this.e = null;
         }
      }

      if(this.b != null) {
         y.c.C var12 = this.b.m();

         while(var12.f()) {
            y.d.y var9 = (y.d.y)var12.d();
            y.d.y var10 = new y.d.y(var9.c() - var4, var9.d() - var6, var9.a() + var1.a(), var9.b() + var1.b());
            this.d.add(a(var10, var2, true));
            var12.g();
            if(var11) {
               break;
            }
         }
      }

   }

   static y.d.y a(y.d.y var0, double var1, boolean var3) {
      return var0 == null?null:(var3?new y.d.y((double)((int)Math.floor(var0.c / var1)), (double)((int)Math.floor(var0.d / var1)), (double)((int)Math.ceil(var0.a / var1) + 1), (double)((int)Math.ceil(var0.b / var1) + 1)):new y.d.y((double)((int)Math.ceil(var0.c / var1)), (double)((int)Math.ceil(var0.d / var1)), (double)Math.max(1, (int)Math.floor(var0.a / var1) - 1), (double)Math.max(1, (int)Math.floor(var0.b / var1) - 1)));
   }

   boolean b() {
      return this.a != null && this.e == null;
   }

   int c() {
      return this.e != null?(int)Math.ceil(Math.sqrt(this.e.a() * this.e.a() + this.e.b() * this.e.b())):Integer.MAX_VALUE;
   }

   boolean a(y.d.t var1) {
      boolean var4 = d.d;
      boolean var10000;
      if(this.d != null) {
         y.c.C var2 = this.d.m();

         while(var2.f()) {
            y.d.y var3 = (y.d.y)var2.d();
            var10000 = a(var3, var1);
            if(var4) {
               return var10000 && this.e != null?a(this.e, var1):true;
            }

            if(var10000) {
               return false;
            }

            var2.g();
            if(var4) {
               break;
            }
         }
      }

      var10000 = this.a();
      return var10000 && this.e != null?a(this.e, var1):true;
   }

   private static boolean a(y.d.y var0, y.d.t var1) {
      return var1.a >= var0.c && var1.a - var0.c <= var0.a && var1.b >= var0.d && var1.b - var0.d <= var0.b;
   }
}
