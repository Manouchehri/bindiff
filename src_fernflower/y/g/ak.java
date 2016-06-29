package y.g;

import java.util.Iterator;
import y.g.ai;
import y.g.aj;

class ak implements Iterator {
   private aj a;
   private final ai b;

   public ak(ai var1, aj var2) {
      this.b = var1;
      this.a = var1.b(var2);
   }

   public boolean hasNext() {
      return this.a != null;
   }

   public Object next() {
      Object var1 = this.a.e;
      this.a = this.b.b(this.a);
      return var1;
   }

   public void remove() {
      this.b.a(this.b.c(this.a));
   }
}
