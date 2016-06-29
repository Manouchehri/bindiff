package y.d.a;

import java.util.Comparator;
import y.d.a.b;
import y.d.a.e;
import y.d.a.f;

class g implements Comparator, y.g.g {
   private y.c.h a;
   private f b;
   private final b c;

   public g(b var1, y.c.h var2) {
      this.c = var1;
      this.a = var2;
      this.b = new f(var1);
   }

   public int compare(Object var1, Object var2) {
      if(var1 == var2) {
         return 0;
      } else {
         int var3 = this.b.compare(this.a.b(var1), this.a.b(var2));
         if(var3 != 0) {
            return var3;
         } else {
            e var4 = (e)this.a.b(var1);
            e var5 = (e)this.a.b(var2);
            return y.g.e.a(var5.b(), var4.b());
         }
      }
   }
}
