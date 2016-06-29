package y.d.a;

import java.util.Comparator;
import y.d.a.b;
import y.d.a.e;
import y.d.a.f;

class d implements Comparator, y.g.g {
   Object a;
   Comparator b;
   private final b c;

   d(b var1) {
      this.c = var1;
      this.b = new f(var1);
   }

   void a(Object var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      e var3 = (e)var1;
      e var4 = (e)var2;
      int var5 = b.a(this.c).c(var4.c, var4.d, this.a);
      return var5 != 0?-var5:this.b.compare(var3, var4);
   }
}
