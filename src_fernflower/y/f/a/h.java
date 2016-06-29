package y.f.a;

import java.util.HashMap;
import y.f.X;
import y.f.ad;
import y.f.ah;
import y.f.a.a;
import y.f.a.f;
import y.f.a.i;

class h extends y.f.a {
   ad a;
   private boolean b = false;

   void a(boolean var1) {
      this.b = var1;
   }

   public h(ad var1) {
      this.a = var1;
   }

   public void c(X var1) {
      int var11 = f.u;
      y.c.h var2 = var1.u();
      y.c.f var3 = new y.c.f();
      y.c.c var4 = var1.c(a.o);
      if(var4 != null) {
         HashMap var5 = new HashMap();
         y.c.x var6 = var1.o();

         while(var6.f()) {
            y.c.q var7 = var6.e();
            Object var8 = var4.b(var7);
            if(var8 != null) {
               label49: {
                  if(var5.containsKey(var8)) {
                     y.c.q var9 = (y.c.q)var5.get(var8);
                     if(var7.c(var9) != null) {
                        break label49;
                     }

                     y.c.d var10 = var1.a((y.c.q)var7, (y.c.q)var9);
                     var2.a(var10, true);
                     var3.add(var10);
                     if(var11 == 0) {
                        break label49;
                     }
                  }

                  var5.put(var8, var7);
               }
            }

            var6.g();
            if(var11 != 0) {
               break;
            }
         }
      }

      ah var12 = this.a();
      i var13 = new i(this, var2, var12);
      this.a.a(var13);
      this.a.c(var1);
      y.c.e var14 = var3.a();

      while(true) {
         if(var14.f()) {
            y.c.d var15 = var14.a();
            var1.a((y.c.d)var15);
            var14.g();
            if(var11 != 0) {
               break;
            }

            if(var11 == 0) {
               continue;
            }
         }

         var1.a((y.c.h)var2);
         this.a.a(var12);
         break;
      }

   }

   static boolean a(h var0) {
      return var0.b;
   }
}
