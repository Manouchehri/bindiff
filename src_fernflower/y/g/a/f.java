package y.g.a;

import y.g.a.n;
import y.g.a.o;

public class f {
   private n a;
   private y.c.c b;
   private y.c.a c;

   public f(int var1, y.c.c var2, y.c.a var3) {
      this.b = var2;
      this.c = var3;
      this.a = new n(var1);
   }

   public void a(Object var1, double var2) {
      o var4 = this.a.a(var2, var1);
      this.c.a(var1, var4);
   }

   public void b(Object var1, double var2) {
      o var4 = (o)this.b.b(var1);
      this.a.a(var4, var2);
   }

   public void c(Object var1, double var2) {
      o var4 = (o)this.b.b(var1);
      this.a.c(var4, var2);
   }

   public Object a() {
      o var1 = this.a.b();
      this.a.a(var1);
      Object var2 = var1.b;
      this.c.a(var2, (Object)null);
      return var2;
   }

   public double b() {
      return this.a.b().a;
   }

   public boolean c() {
      return this.a.c();
   }

   public double a(Object var1) {
      o var2 = (o)this.b.b(var1);
      return var2.a;
   }

   public void b(Object var1) {
      o var2 = (o)this.b.b(var1);
      this.a.a(var2);
      this.c.a(var1, (Object)null);
   }

   public void d() {
      this.b = null;
      this.c = null;
      this.a = null;
   }
}
