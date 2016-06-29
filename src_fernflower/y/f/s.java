package y.f;

import y.f.l;
import y.f.q;

class s extends q implements y.c.a {
   y.c.a b;
   private final l c;

   s(l var1, y.c.c var2) {
      super(var1, var2);
      this.c = var1;
      this.b = (y.c.a)var2;
   }

   public void a(Object var1, Object var2) {
      Object var3 = this.e(var1);
      if(var3 != null) {
         this.b.a(var3, var2);
      }

   }

   public void a(Object var1, int var2) {
      Object var3 = this.e(var1);
      if(var3 != null) {
         this.b.a(var3, var2);
      }

   }

   public void a(Object var1, double var2) {
      Object var4 = this.e(var1);
      if(var4 != null) {
         this.b.a(var4, var2);
      }

   }

   public void a(Object var1, boolean var2) {
      Object var3 = this.e(var1);
      if(var3 != null) {
         this.b.a(var3, var2);
      }

   }
}
