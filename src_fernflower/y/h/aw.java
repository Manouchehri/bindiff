package y.h;

import java.util.ArrayList;
import y.h.am;
import y.h.as;
import y.h.at;
import y.h.ax;
import y.h.fj;

final class aw implements am {
   private final ArrayList a;
   private int b;
   private final as c;

   aw(as var1, ArrayList var2) {
      this.c = var1;
      this.a = var2;
   }

   public boolean a() {
      boolean var7 = fj.z;
      boolean var1 = false;
      int var2 = this.a.size();

      int var10000;
      while(true) {
         if(this.b < var2) {
            var10000 = this.c.f.isEmpty();
            if(var7) {
               break;
            }

            if(var10000 != 0) {
               y.c.q var3 = (y.c.q)this.a.get(this.b);
               at var4 = new at(this.c, var3);
               this.c.c.add(var4);
               var1 = true;
               ax var5 = new ax(this.c, var3);
               int var6 = this.c.c.size();
               this.c.c.add(var5);
               if(var5.a()) {
                  this.c.c.remove(var6);
                  if(this.c.f.isEmpty() && var4.a()) {
                     this.c.c.remove(this.c.c.size() - 1);
                     var1 = false;
                  }
               }

               ++this.b;
               if(!var7) {
                  continue;
               }
            }
         }

         var10000 = this.b;
         break;
      }

      return var10000 > var2 - 1 && !var1;
   }
}
