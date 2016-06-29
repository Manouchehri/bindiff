package y.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

final class fh {
   private final Collection a = new ArrayList(1);
   private final Collection b = new ArrayList(1);
   private y.d.t c;
   private boolean d;

   fh() {
      this.c = y.d.t.c;
      this.d = true;
   }

   void a(y.c.d var1) {
      this.a.add(var1);
      this.d &= var1.e();
   }

   Iterator a() {
      return this.a.iterator();
   }

   void b(y.c.d var1) {
      this.b.add(var1);
      this.d &= var1.e();
   }

   Iterator b() {
      return this.b.iterator();
   }

   boolean c() {
      return this.a.isEmpty() && this.b.isEmpty();
   }

   boolean d() {
      return this.d;
   }

   y.d.t e() {
      return this.c;
   }

   void a(y.d.t var1) {
      this.c = var1;
   }
}
