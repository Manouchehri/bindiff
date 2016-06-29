package y.f.f.a.a;

import y.c.C;
import y.f.f.a.a.d;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.a.j;

public abstract class c implements e {
   protected f a;
   protected j b;

   public void a(f var1) {
      this.a = var1;
   }

   public void a(j var1) {
      this.b = var1;
   }

   public C a() {
      C var1 = this.a.a();
      return new d(this, var1);
   }

   public int b() {
      return this.a.b();
   }

   public e c() {
      f var1 = (f)this.a.c();
      return (e)this.b.a(var1);
   }

   public boolean d() {
      return this.a.d();
   }

   public boolean e() {
      return this.a.e();
   }
}
