package y.c;

import java.util.Iterator;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.g;

public class f extends D {
   public f() {
   }

   public f(d[] var1) {
      boolean var3 = D.e;
      super();
      int var2 = 0;

      while(var2 < var1.length) {
         this.b(var1[var2]);
         ++var2;
         if(var3) {
            break;
         }
      }

   }

   public f(e var1) {
      super((C)var1);
   }

   public f(Iterator var1) {
      super(var1);
   }

   public f(d var1) {
      this.b(var1);
   }

   public f(f var1) {
      this(var1.a());
   }

   public e a() {
      return new g(this);
   }

   public d b() {
      return (d)this.f();
   }

   public d c() {
      return (d)this.i();
   }

   public d d() {
      return (d)this.g();
   }

   public d[] e() {
      return (d[])this.toArray(new d[this.size()]);
   }
}
