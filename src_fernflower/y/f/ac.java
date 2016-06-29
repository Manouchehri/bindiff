package y.f;

import y.f.X;
import y.f.a;
import y.f.ah;

public class ac extends a {
   public static final Object a = "y.layout.LayoutMultiplexer.LAYOUTER_DPKEY";

   public void c(X var1) {
      ah var2 = this.b(var1);
      if(var2 != null) {
         var2.c(var1);
      }

   }

   protected ah b(X var1) {
      boolean var5 = X.j;
      ah var2 = null;
      y.c.c var3 = var1.c(a);
      ah var10000;
      if(var3 != null) {
         y.c.x var4 = var1.o();

         while(var4.f()) {
            var2 = (ah)var3.b(var4.e());
            var10000 = var2;
            if(var5) {
               return var10000;
            }

            if(var2 != null) {
               return var2;
            }

            var4.g();
            if(var5) {
               break;
            }
         }
      }

      var10000 = this.a();
      return var10000;
   }
}
