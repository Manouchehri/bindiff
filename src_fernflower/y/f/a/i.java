package y.f.a;

import y.f.X;
import y.f.ah;
import y.f.a.f;
import y.f.a.h;

class i extends y.f.a {
   private final y.c.h a;
   private final ah b;
   private final h c;

   i(h var1, y.c.h var2, ah var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void c(X var1) {
      boolean var10000;
      y.c.f var2;
      y.c.e var3;
      y.c.d var4;
      int var5;
      label37: {
         var5 = f.u;
         var2 = new y.c.f();
         if(h.a(this.c)) {
            var3 = var1.p();

            while(var3.f()) {
               var4 = var3.a();
               var10000 = this.a.d(var4);
               if(var5 != 0) {
                  break label37;
               }

               if(var10000) {
                  var2.add(var4);
                  var1.d(var4);
               }

               var3.g();
               if(var5 != 0) {
                  break;
               }
            }
         }

         this.b.c(var1);
         var10000 = h.a(this.c);
      }

      if(var10000) {
         var3 = var2.a();

         while(var3.f()) {
            var4 = var3.a();
            var1.e(var4);
            var3.g();
            if(var5 != 0) {
               break;
            }
         }
      }

   }
}
