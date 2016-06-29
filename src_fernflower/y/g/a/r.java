package y.g.a;

import java.util.Comparator;
import y.g.a.d;
import y.g.a.l;

abstract class r {
   private Comparator c;
   protected l a;
   protected int b;

   public r(Comparator var1) {
      this.c = var1;
   }

   public void a() {
      this.a = null;
   }

   public boolean b() {
      return this.a == null;
   }

   public Object c() {
      return !this.b()?this.h(this.a).d:null;
   }

   public boolean c(Object var1) {
      return this.d(var1) != null;
   }

   protected int a(Object var1, Object var2) {
      return this.c.compare(var1, var2);
   }

   protected l d(Object var1) {
      boolean var3 = d.a;
      l var2 = this.a;

      do {
         do {
            if(var2 == null) {
               return var2;
            }

            if(this.a(var1, var2.d) >= 0) {
               break;
            }

            var2 = var2.b;
         } while(!var3);

         if(this.a(var1, var2.d) <= 0) {
            break;
         }

         var2 = var2.c;
      } while(!var3);

      return var2;
   }

   protected static void a(l var0, l var1) {
      Object var2 = var0.d;
      var0.d = var1.d;
      var1.d = var2;
   }

   protected l h(l var1) {
      boolean var2 = d.a;

      l var10000;
      while(true) {
         if(var1.b != null) {
            var10000 = var1.b;
            if(var2) {
               break;
            }

            var1 = var10000;
            if(!var2) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }
}
