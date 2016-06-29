package y.h;

import java.util.ArrayList;
import java.util.Iterator;
import y.h.am;
import y.h.an;
import y.h.ao;
import y.h.ap;
import y.h.ar;
import y.h.fj;

final class aq implements am {
   private final Iterator a;
   private ArrayList b;
   private final an c;

   aq(an var1) {
      this.c = var1;
      this.a = var1.a.i(var1.a.e((y.c.i)var1.d));
      this.b = new ArrayList();
   }

   public boolean a() {
      boolean var8 = fj.z;
      int var1 = 0;

      boolean var10000;
      while(true) {
         if(this.a.hasNext() && this.c.f.isEmpty()) {
            y.c.q var2 = (y.c.q)this.a.next();
            this.c.b.set(var2.d());
            this.b.add(var2);
            if(this.c.a.k(var2) && !this.b.isEmpty()) {
               ap var3 = new ap(this.c, this.b);
               this.c.c.add(var3);
               ++var1;
               this.b = new ArrayList();
            }

            ar var10 = new ar(this.c, var2);
            int var4 = this.c.c.size();
            this.c.c.add(var10);
            ++var1;
            ao var5 = new ao(this.c, var2);
            int var6 = this.c.c.size();
            this.c.c.add(var5);
            ++var1;
            if(!var5.a()) {
               continue;
            }

            this.c.c.remove(var6);
            --var1;
            var10000 = this.c.f.isEmpty();
            if(var8) {
               break;
            }

            if(!var10000 || !var10.a()) {
               continue;
            }

            this.c.c.remove(var4);
            --var1;
            if(var1 <= 0 || !this.c.f.isEmpty()) {
               continue;
            }

            int var7 = this.c.c.size() - 1;
            if(!((am)this.c.c.get(var7)).a()) {
               continue;
            }

            this.c.c.remove(var7);
            --var1;
            if(!var8) {
               continue;
            }
         }

         var10000 = this.a.hasNext();
         break;
      }

      if(!var10000 && !this.b.isEmpty()) {
         ap var9 = new ap(this.c, this.b);
         int var11 = this.c.c.size();
         this.c.c.add(var9);
         ++var1;
         if(var9.a()) {
            this.c.c.remove(var11);
            --var1;
         }

         this.b = new ArrayList();
      }

      return !this.a.hasNext() && var1 == 0;
   }
}
