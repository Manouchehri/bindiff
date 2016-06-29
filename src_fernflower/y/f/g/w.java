package y.f.g;

import y.f.g.d;
import y.f.g.n;
import y.f.g.t;
import y.g.M;

class w {
   private y.c.y a;
   private y.c.D b;
   private boolean c;
   private Object d;
   private final n e;

   w(n var1, Object var2, y.c.y var3, boolean var4, y.c.c var5) {
      boolean var9 = d.d;
      super();
      this.e = var1;
      this.d = var2;
      this.a = var3;
      this.c = var4;
      y.c.A var6 = M.a();
      y.c.x var7 = var3.a();

      while(true) {
         if(var7.f()) {
            y.c.q var8 = var7.e();
            var6.a(var8, true);
            var7.g();
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         this.a(var6, var5);
         break;
      }

   }

   private void a(y.c.c var1, y.c.c var2) {
      boolean var12 = d.d;
      this.b = new y.c.D();
      y.c.f var3 = new y.c.f();
      y.c.h var4 = M.b();
      y.c.x var5 = this.a.a();

      t var15;
      y.c.e var17;
      label74:
      while(true) {
         boolean var10000 = var5.f();

         label71:
         while(var10000) {
            y.c.q var6 = var5.e();
            var17 = var6.j();
            if(var12) {
               break label74;
            }

            y.c.e var7 = var17;

            while(var7.f()) {
               y.c.d var8 = var7.a();
               var10000 = var4.d(var8);
               if(var12) {
                  continue label71;
               }

               if(!var10000) {
                  var3.add(var8);
                  var4.a(var8, true);
               }

               var7.g();
               if(var12) {
                  break;
               }
            }

            var15 = new t(this.e, var6, var6, (byte)0);
            this.b.add(var15);
            var5.g();
            if(!var12) {
               continue label74;
            }
            break;
         }

         var17 = var3.a();
         break;
      }

      y.c.e var13 = var17;

      while(var13.f()) {
         label83: {
            y.c.d var14 = var13.a();
            if((var2 == null || var2.d(var14)) && var1.d(var14.c()) && var1.d(var14.d())) {
               var15 = new t(this.e, var14, var14, (byte)1);
               this.b.add(var15);
               y.f.C[] var16 = n.b(this.e).d(var14);
               int var9 = 0;

               while(var9 < var16.length) {
                  y.f.C var10 = var16[var9];
                  t var11 = new t(this.e, var10, var14, (byte)3);
                  this.b.add(var11);
                  ++var9;
                  if(var12) {
                     break label83;
                  }

                  if(var12) {
                     break;
                  }
               }
            }

            var13.g();
         }

         if(var12) {
            break;
         }
      }

   }

   public void a(double var1, double var3) {
      boolean var7 = d.d;
      if(var1 != 0.0D || var3 != 0.0D) {
         y.c.C var5 = this.b.m();

         while(var5.f()) {
            t var6 = (t)var5.d();
            var6.a(var1, var3);
            var5.g();
            if(var7) {
               break;
            }
         }

      }
   }

   public y.d.y a() {
      boolean var12 = d.d;
      double var1 = Double.MAX_VALUE;
      double var3 = Double.MAX_VALUE;
      double var5 = -1.7976931348623157E308D;
      double var7 = -1.7976931348623157E308D;
      y.c.C var9 = this.b.m();

      y.d.y var10000;
      while(true) {
         if(var9.f()) {
            t var10 = (t)var9.d();
            var10000 = var10.h();
            if(var12) {
               break;
            }

            y.d.y var11 = var10000;
            var1 = Math.min(var1, var11.c);
            var3 = Math.min(var3, var11.d);
            var5 = Math.max(var5, var11.c + var11.a);
            var7 = Math.max(var7, var11.d + var11.b);
            var9.g();
            if(!var12) {
               continue;
            }
         }

         var10000 = new y.d.y(var1, var3, var5 - var1, var7 - var3);
         break;
      }

      return var10000;
   }

   public boolean b() {
      return this.c;
   }

   public y.c.D c() {
      return this.b;
   }
}
