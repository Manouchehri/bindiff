package y.f;

import y.f.N;
import y.f.ae;
import y.f.ai;
import y.f.aj;
import y.f.al;
import y.f.am;

public class M implements al {
   public Object c() {
      return new N(-20.0D, -20.0D);
   }

   public y.d.n a(y.d.q var1, am var2, Object var3) {
      N var4 = (N)var3;
      double var5 = var1.b();
      return new y.d.n(var4.a - var5 * var4.c + var2.getX(), var4.b - var5 * var4.d + var2.getY(), var1.a(), var5, var4.c, var4.d);
   }

   public y.c.D a(aj var1, am var2) {
      y.c.D var3 = new y.c.D();
      var3.add(new ai(var1.getOrientedBox(), var1.getModelParameter(), var1, false));
      return var3;
   }

   public Object a(y.d.n var1, am var2) {
      if(ae.a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         double var3 = var1.g();
         double var5 = var1.i();
         double var7 = var1.f();
         return new N(var1.b() + var7 * var3 - var2.getX(), var1.c() + var7 * var5 - var2.getY(), var3, var5);
      }
   }
}
