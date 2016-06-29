package y.f.e.a;

import java.util.HashMap;
import java.util.Map;
import y.f.e.a.al;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.s;

class ak implements s {
   double a;
   double b;
   double c;
   double d;
   private Map e;

   ak() {
      this(0.01D, 0.04D, 0.01D, 0.04D);
   }

   ak(double var1, double var3, double var5, double var7) {
      this.e = new HashMap();
      this.d = var5;
      this.a = var3;
      this.b = var1;
      this.c = var7;
   }

   public double a(m var1, l var2) {
      if(var1.g() == 1.0D) {
         return 0.0D;
      } else {
         double var3 = this.a(var1);
         double var5 = var1.e() + var3;
         return Math.max(0.0D, Math.min(var5, 1.0D));
      }
   }

   double a(m var1) {
      al var2 = this.b(var1);
      var2.a(var1.f());
      double var3 = var2.a();
      double var5 = var2.b();
      return var5 * var3 >= 0.0D?(var3 > 0.0D?this.a * var3:this.c * var3):(var3 > 0.0D?this.b * var3:this.d * var3);
   }

   al b(m var1) {
      al var2 = (al)this.e.get(var1);
      if(var2 == null) {
         var2 = new al();
         this.e.put(var1, var2);
      }

      return var2;
   }
}
