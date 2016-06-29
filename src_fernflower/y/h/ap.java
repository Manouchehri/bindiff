package y.h;

import java.util.ArrayList;
import y.h.am;
import y.h.an;
import y.h.fj;

final class ap implements am {
   private final ArrayList a;
   private int b;
   private final an c;

   ap(an var1, ArrayList var2) {
      this.c = var1;
      this.a = var2;
   }

   public boolean a() {
      boolean var3 = fj.z;
      int var1 = this.a.size();

      int var10000;
      while(true) {
         if(this.b < var1) {
            var10000 = this.c.f.isEmpty();
            if(var3) {
               break;
            }

            if(var10000 != 0) {
               y.c.q var2 = (y.c.q)this.a.get(this.b);
               this.c.b(var2);
               ++this.b;
               if(!var3) {
                  continue;
               }
            }
         }

         var10000 = this.b;
         break;
      }

      return var10000 > var1 - 1;
   }
}
