package y.f.i.a;

import java.util.Collections;
import java.util.List;
import y.f.i.a.ab;
import y.f.i.a.bs;

class bw {
   private final bs a;

   bw(bs var1) {
      this.a = var1;
   }

   public int a(int var1) {
      return var1;
   }

   public int b(int var1) {
      return var1;
   }

   public List c(int var1) {
      return this.a(var1, true);
   }

   public List d(int var1) {
      return this.a(var1, false);
   }

   private List a(int var1, boolean var2) {
      int var11 = ab.a;
      y.c.D var3 = null;
      int var4 = this.a(var1);
      y.c.q var5 = bs.a(this.a)[var4];
      y.c.e var6 = var5.j();

      while(true) {
         if(var6.f()) {
            y.c.d var7 = (y.c.d)var6.d();
            if(var11 != 0) {
               break;
            }

            y.c.q var8 = var7.c() != var5?var7.c():var7.d();
            int var9 = bs.b(this.a).a(var8);
            int var10 = this.b(var9);
            if(var2 && var10 < var1 || !var2 && var10 > var1) {
               if(var3 == null) {
                  var3 = new y.c.D();
               }

               var3.add(new Integer(var9));
            }

            var6.g();
            if(var11 == 0) {
               continue;
            }
         }

         if(var3 == null) {
            return Collections.EMPTY_LIST;
         }
         break;
      }

      return var3;
   }
}
