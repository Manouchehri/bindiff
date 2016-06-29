package y.f.f.a.b;

import y.f.f.a.b.a;
import y.f.f.a.b.i;
import y.f.h.R;
import y.g.I;

public class h extends R {
   private y.c.i j;
   private y.f.f.a.a.p k;

   public h(y.c.i var1, y.f.f.a.a.p var2) {
      this.j = var1;
      this.k = var2;
   }

   public void a(y.c.y var1) {
      boolean var8 = a.c;
      i var2 = new i(this.j, this.k);
      var2.h();
      var2.e();
      y.c.D var3 = new y.c.D();
      y.c.y var4 = new y.c.y();
      I var5 = new I(this.j);
      var2.f();
      var3.c((Object)this.k.a());

      while(true) {
         if(!var3.isEmpty()) {
            y.f.f.a.a.b var6 = (y.f.f.a.a.b)var3.g();
            if(var8) {
               break;
            }

            if(var6.d()) {
               var1.b(var6.b_());
               if(!var8) {
                  continue;
               }
            }

            var2.b(var6);
            var5.e();
            var4.clear();
            this.a(this.j);
            super.a(var4);
            y.c.x var7 = var4.a();
            var7.j();

            label32: {
               while(var7.f()) {
                  var3.c((Object)this.k.a(var7.e()));
                  var7.h();
                  if(var8) {
                     break label32;
                  }

                  if(var8) {
                     break;
                  }
               }

               var5.h();
               var2.a(var6);
            }

            if(!var8) {
               continue;
            }
         }

         var2.g();
         var2.i();
         var2.d();
         break;
      }

   }
}
