package y.c;

import java.util.Iterator;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.q;
import y.c.x;
import y.c.z;

public class y extends D {
   public y() {
   }

   public y(x var1) {
      super((C)var1);
   }

   public y(x var1, c var2) {
      super(var1, var2);
   }

   public y(Iterator var1) {
      super(var1);
   }

   public y(q[] var1) {
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

   public y(q var1) {
      this.b(var1);
   }

   public y(y var1) {
      this(var1.a());
   }

   public x a() {
      return new z(this);
   }

   public q b() {
      return (q)this.f();
   }

   public q c() {
      return (q)this.i();
   }

   public q d() {
      return (q)this.g();
   }

   public q[] e() {
      return (q[])this.toArray(new q[this.size()]);
   }
}
