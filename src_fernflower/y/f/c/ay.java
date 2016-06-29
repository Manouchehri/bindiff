package y.f.c;

import java.util.Collection;
import y.f.c.a;

class ay extends y.f.a {
   private byte a = 0;

   public void c(y.f.X var1) {
      boolean var10 = a.i;
      if(this.a() instanceof y.f.c) {
         this.a = ((y.f.c)this.a()).h();
      }

      y.c.c var2 = var1.c(y.f.ax.a);
      y.c.c var3 = var1.c(y.f.ax.b);
      if(var2 == null && var3 == null) {
         this.a().c(var1);
         if(!var10) {
            return;
         }
      }

      y.c.c var4 = var1.c(y.f.aF.a);
      y.c.c var5 = var1.c(y.f.aF.b);
      y.c.h var6 = var1.u();
      var1.a((Object)y.f.aF.a, (y.c.c)var6);
      y.c.h var7 = var1.u();
      var1.a((Object)y.f.aF.b, (y.c.c)var7);
      y.c.e var8 = var1.p();

      label41: {
         while(var8.f()) {
            y.c.d var9 = var8.a();
            var6.a(var9, this.a(var9, true, var4, var7, var2, var3, var1));
            var7.a(var9, this.a(var9, false, var4, var7, var2, var3, var1));
            var8.g();
            if(var10) {
               break label41;
            }

            if(var10) {
               break;
            }
         }

         this.a().c(var1);
      }

      label31: {
         if(var4 != null) {
            var1.a((Object)y.f.aF.a, (y.c.c)var4);
            if(!var10) {
               break label31;
            }
         }

         var1.d_(y.f.aF.a);
      }

      label26: {
         var1.a((y.c.h)var6);
         if(var5 != null) {
            var1.a((Object)y.f.aF.b, (y.c.c)var5);
            if(!var10) {
               break label26;
            }
         }

         var1.d_(y.f.aF.b);
      }

      var1.a((y.c.h)var7);
   }

   private y.f.aE a(y.c.d var1, boolean var2, y.c.c var3, y.c.c var4, y.c.c var5, y.c.c var6, y.f.X var7) {
      y.f.aE var8 = null;
      if(var2 && var3 != null) {
         var8 = (y.f.aE)var3.b(var1);
      } else if(!var2 && var4 != null) {
         var8 = (y.f.aE)var4.b(var1);
      }

      if(var8 == null) {
         Collection var9;
         y.f.ax var10;
         double var11;
         double var13;
         if(var2 && var5 != null) {
            var9 = (Collection)var5.b(var1);
            if(var9 == null || var9.size() != 1) {
               return var8;
            }

            var10 = (y.f.ax)var9.iterator().next();
            if(var10.b()) {
               var11 = var10.c(this.a);
               var13 = var10.d(this.a);
               var7.a(var1, new y.d.t(var11, var13));
            }

            var8 = var10.a(this.a);
            if(!a.i) {
               return var8;
            }
         }

         if(!var2 && var6 != null) {
            var9 = (Collection)var6.b(var1);
            if(var9 != null && var9.size() == 1) {
               var10 = (y.f.ax)var9.iterator().next();
               if(var10.b()) {
                  var11 = var10.c(this.a);
                  var13 = var10.d(this.a);
                  var7.b(var1, new y.d.t(var11, var13));
               }

               var8 = var10.a(this.a);
            }
         }
      }

      return var8;
   }
}
