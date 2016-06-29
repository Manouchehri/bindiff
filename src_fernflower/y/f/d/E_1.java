package y.f.d;

import java.util.Comparator;
import y.f.d.D;
import y.f.d.a;

class E implements Comparator {
   private y.d.t a;
   private static final y.d.z b = new y.d.z(0.0D, -1.0D);

   private E(y.d.t[] var1) {
      int var7 = a.f;
      super();
      double var2 = 0.0D;
      double var4 = 0.0D;
      int var6 = 0;

      while(true) {
         if(var6 < var1.length) {
            var2 += var1[var6].a;
            var4 += var1[var6].b;
            ++var6;
            if(var7 != 0) {
               break;
            }

            if(var7 == 0) {
               continue;
            }
         }

         this.a = new y.d.t(var2 / (double)var1.length, var4 / (double)var1.length);
         break;
      }

   }

   public int compare(Object var1, Object var2) {
      y.d.z var3 = new y.d.z(this.a, (y.d.t)var1);
      y.d.z var4 = new y.d.z(this.a, (y.d.t)var2);
      double var5 = y.d.z.d(b, var3);
      double var7 = y.d.z.d(b, var4);
      return var5 < var7?-1:(var5 > var7?1:0);
   }

   E(y.d.t[] var1, D var2) {
      this(var1);
   }
}
