package y.d.b;

import y.d.b.u;
import y.d.b.z;

public abstract class c implements u {
   public static int a;

   public int a(Object var1, Object var2) {
      return this.c(this.c(var1), this.d(var1), var2);
   }

   public boolean a(Object var1, Object var2, Object var3) {
      return this.c(var1, var2, var3) > 0;
   }

   public boolean b(Object var1, Object var2, Object var3) {
      return this.c(var1, var2, var3) == 0;
   }

   public boolean b(Object var1, Object var2) {
      return var2.equals(this.c(var1))?false:(var2.equals(this.d(var1))?false:this.e(var1, var2));
   }

   public boolean a(Object var1) {
      Object var2 = this.c(var1);
      Object var3 = this.d(var1);
      return var2.equals(var3);
   }

   public z b(Object var1) {
      Object var2 = this.c(var1);
      Object var3 = this.d(var1);
      z var4 = this.k(var2).b(this.k(var3));
      z var5 = this.l(var2).b(this.l(var3));
      return var4.c(var4).a(var5.c(var5));
   }
}
