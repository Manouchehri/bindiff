package y.h;

import java.util.ArrayList;
import java.util.BitSet;
import y.h.am;
import y.h.bu;
import y.h.fj;
import y.h.hO;

abstract class af extends hO {
   final y.h.a.v a;
   BitSet b;
   ArrayList c;

   af(bu var1, y.h.a.v var2, int var3) {
      super(var1, var3);
      this.a = var2;
   }

   void c() {
      this.f = new ArrayList();
      this.c = new ArrayList();
      this.b = new BitSet(this.d.f());
      this.b();
   }

   void a() {
      boolean var3 = fj.z;

      while(this.f.isEmpty() && !this.c.isEmpty()) {
         int var1 = this.c.size() - 1;
         am var2 = (am)this.c.get(var1);
         if(var2.a()) {
            this.c.remove(var1);
            if(var3) {
               break;
            }
         }
      }

   }

   abstract void b();
}
