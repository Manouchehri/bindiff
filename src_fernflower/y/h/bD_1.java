package y.h;

import java.util.Map;
import y.h.aB;
import y.h.bu;
import y.h.fj;

public class bD implements y.c.m, y.g.C {
   private static final y.g.C a = new y.f.Y();

   public y.c.i a(Object var1) {
      return var1 instanceof bu?new bu((bu)var1):new bu();
   }

   public y.c.q a(y.c.i var1, Object var2) {
      if(var2 instanceof y.c.q) {
         y.c.q var3 = (y.c.q)var2;
         if(var3.e() instanceof bu) {
            bu var4 = (bu)var3.e();
            return ((bu)var1).a(this.a(var4.t(var3)));
         }
      }

      return var1.d();
   }

   protected aB a(aB var1) {
      return var1.createCopy();
   }

   public y.c.q a(y.c.i var1, y.c.q var2) {
      y.c.i var3 = var2.e();
      if(var3 instanceof bu) {
         bu var4 = (bu)var1;
         return var4.a(this.a(((bu)var3).t(var2)));
      } else {
         return a.a(var1, var2);
      }
   }

   protected fj a(fj var1) {
      return var1.createCopy();
   }

   public y.c.d a(y.c.i var1, y.c.q var2, y.c.q var3, y.c.d var4) {
      y.c.i var5 = var4.a();
      return var5 instanceof bu?((bu)var1).a(var2, var3, this.a(((bu)var5).i(var4))):a.a(var1, var2, var3, var4);
   }

   public void a(y.c.i var1, y.c.i var2) {
   }

   public void a(y.c.i var1, y.c.i var2, Map var3, Map var4) {
   }
}
