package y.h;

import java.util.ArrayList;
import java.util.Iterator;
import y.h.am;
import y.h.as;
import y.h.au;
import y.h.aw;
import y.h.fj;

final class av implements am {
   private final Iterator a;
   private ArrayList b;
   private final as c;

   av(as var1) {
      this.c = var1;
      this.a = var1.a.h(var1.a.e((y.c.i)var1.d));
      this.b = new ArrayList();
   }

   public boolean a() {
      boolean var7 = fj.z;
      boolean var1 = false;

      boolean var10000;
      while(true) {
         if(this.a.hasNext() && this.c.f.isEmpty()) {
            y.c.q var2 = (y.c.q)this.a.next();
            au var3 = new au(this.c, var2);
            int var4 = this.c.c.size();
            this.c.c.add(var3);
            if(this.c.a.k(var2) && !this.b.isEmpty()) {
               aw var5 = new aw(this.c, this.b);
               int var6 = this.c.c.size();
               this.c.c.add(var5);
               var1 = true;
               if(var5.a()) {
                  this.c.c.remove(var6);
                  var1 = false;
               }

               this.b = new ArrayList();
            }

            this.b.add(var2);
            if(var1) {
               continue;
            }

            var10000 = var3.a();
            if(var7) {
               break;
            }

            if(!var10000) {
               continue;
            }

            this.c.c.remove(var4);
            if(!var7) {
               continue;
            }
         }

         var10000 = this.a.hasNext();
         break;
      }

      if(!var10000 && !this.b.isEmpty()) {
         aw var8 = new aw(this.c, this.b);
         int var9 = this.c.c.size();
         this.c.c.add(var8);
         var1 = true;
         if(var8.a()) {
            this.c.c.remove(var9);
            var1 = false;
         }

         this.b = new ArrayList();
      }

      return !this.a.hasNext() && !var1;
   }
}
