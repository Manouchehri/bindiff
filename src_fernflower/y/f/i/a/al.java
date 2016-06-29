package y.f.i.a;

import java.util.List;
import y.f.i.a.ab;
import y.f.i.a.ai;

public final class al {
   private List a = new y.c.D();
   private byte b;
   private ai c;

   public al(ai var1) {
      this.a.add(var1);
      this.b = 0;
      this.c = var1;
   }

   public void a(ai var1) {
      label15: {
         if(this.c.h() == var1.h()) {
            this.b = 1;
            if(ab.a == 0) {
               break label15;
            }
         }

         this.b = 2;
      }

      if(var1.j() < this.c.j()) {
         this.c = var1;
      }

      this.a.add(var1);
   }

   static byte a(al var0) {
      return var0.b;
   }

   static ai b(al var0) {
      return var0.c;
   }
}
