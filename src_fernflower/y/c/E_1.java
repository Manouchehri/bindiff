package y.c;

import y.c.C;
import y.c.D;
import y.c.p;

public class E implements C {
   p a;
   private final D b;

   protected E(D var1) {
      this.b = var1;
      this.i();
   }

   public boolean f() {
      return this.a != null;
   }

   public void g() {
      this.a = this.a.a;
   }

   public void h() {
      this.a = this.a.b;
   }

   public void i() {
      this.a = this.b.b;
   }

   public void j() {
      this.a = this.b.c;
   }

   public int k() {
      return this.b.a;
   }

   public Object d() {
      return this.a.c;
   }
}
