package y.f.f.a.a;

import y.c.C;
import y.c.D;
import y.f.f.a.a.e;

public class f implements e {
   protected f b;
   protected D c;
   protected int d;
   public static boolean e;

   public f() {
      this((f)null);
   }

   public f(f var1) {
      this(var1, (D)null);
   }

   public f(f var1, D var2) {
      this.b = var1;
      this.c = var2;
      if(this.e()) {
         this.d = 0;
         if(!e) {
            return;
         }
      }

      this.d = this.b.d + 1;
   }

   public C a() {
      if(this.d()) {
         this.c = new D();
      }

      return this.c.m();
   }

   public int b() {
      return this.d;
   }

   public e c() {
      return this.b;
   }

   public boolean d() {
      return this.c == null?true:this.c.size() == 0;
   }

   public boolean e() {
      return this.b == null;
   }

   public void a(f var1) {
      if(this.c == null) {
         this.c = new D();
      }

      this.c.add(var1);
   }

   public void f() {
      if(!this.e()) {
         f var1 = (f)this.c();
         var1.c.remove(this);
      }

   }
}
