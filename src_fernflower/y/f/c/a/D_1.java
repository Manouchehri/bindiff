package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.bx;

public class D implements bx {
   private Comparator a;

   public D() {
      this((Comparator)null);
   }

   public D(Comparator var1) {
      this.a(var1);
   }

   public void a(Comparator var1) {
      this.a = var1;
   }

   public void a(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var7 = N.x;
      int var5 = 0;

      while(var5 < var2.b()) {
         y.c.D var6 = new y.c.D(var2.a(var5).d().m());
         var6.sort(this.a);
         var2.a(var5).a(var6);
         ++var5;
         if(var7) {
            break;
         }
      }

   }
}
