package y.f.b;

import java.util.ArrayList;
import java.util.HashMap;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.ah;
import y.f.b.c;
import y.f.b.f;

public class i extends y.f.a {
   public void c(X var1) {
      int var11 = c.a;
      ah var2;
      if(c.b((y.c.i)var1)) {
         var2 = this.a();
         if(var2 == null) {
            return;
         }

         y.c.c var3 = var1.c(f.b);
         y.c.c var4 = var1.c(f.c);
         HashMap var5 = new HashMap();
         x var6 = var1.o();

         while(var6.f()) {
            var5.put(var3.b(var6.e()), var6.e());
            var6.g();
            if(var11 != 0) {
               return;
            }

            if(var11 != 0) {
               break;
            }
         }

         ArrayList var12 = new ArrayList(var1.e());
         x var7 = var1.o();

         label46: {
            while(var7.f()) {
               q var8 = var7.e();
               Object var9 = var4.b(var8);
               if(var11 != 0) {
                  break label46;
               }

               if(var9 != null) {
                  q var10 = (q)var5.get(var9);
                  if(var10 != null) {
                     var12.add(var1.a((q)var8, (q)var10));
                  }
               }

               var7.g();
               if(var11 != 0) {
                  break;
               }
            }

            var2.c(var1);
         }

         int var13 = 0;

         do {
            if(var13 >= var12.size()) {
               return;
            }

            var1.a((y.c.d)((y.c.d)var12.get(var13)));
            ++var13;
         } while(var11 == 0);
      }

      var2 = this.a();
      if(var2 != null) {
         var2.c(var1);
      }

   }
}
