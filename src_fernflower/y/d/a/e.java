package y.d.a;

import y.c.p;
import y.c.q;
import y.d.a.b;

public class e {
   q a;
   p b;
   Object c;
   Object d;
   Object e;
   int f;
   Object g;
   e h;
   private final b i;

   public e(b var1, Object var2, Object var3, Object var4, int var5) {
      this.i = var1;
      this.c = var2;
      this.d = var3;
      this.f = var5;
      this.e = var4;
      this.g = b.a(var1).c(this.c, this.d);
      this.h = null;
   }

   public void a(e var1) {
      this.h = var1;
   }

   public void a(p var1) {
      this.b = var1;
   }

   public String toString() {
      return this.c + " " + this.d;
   }

   public boolean a() {
      return this.c.equals(b.a(this.i).c(this.e));
   }

   public int b() {
      return this.f;
   }
}
