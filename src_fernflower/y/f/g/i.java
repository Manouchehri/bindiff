package y.f.g;

import y.f.X;
import y.f.ae;
import y.f.ah;
import y.f.g.d;

public class i implements ah {
   Object a;

   public i() {
      this.a = ah.h_;
   }

   public Object a() {
      return this.a;
   }

   public void a(Object var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("null");
      } else {
         this.a = var1;
      }
   }

   public void c(X var1) {
      boolean var5 = d.d;
      y.c.c var2 = var1.c(this.a());
      y.c.e var3 = var1.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(var2 == null || var2.d(var4)) {
            ae.a(var1, var4);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

   }
}
