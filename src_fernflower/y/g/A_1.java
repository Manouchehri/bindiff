package y.g;

import java.util.Iterator;
import java.util.NoSuchElementException;
import y.g.p;
import y.g.z;

public final class A implements Iterator {
   private final Iterator a;
   private z b;
   private boolean c;
   private Object d;

   public A(Iterator var1, z var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean hasNext() {
      if(!this.c) {
         this.a();
      }

      return this.c;
   }

   public Object next() {
      if(!this.c) {
         this.a();
      }

      if(this.c) {
         this.c = false;
         return this.d;
      } else {
         throw new NoSuchElementException();
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   private void a() {
      boolean var2 = p.c;

      while(this.a.hasNext() && !this.c) {
         Object var1 = this.a.next();
         if(this.b == null || this.b.a(var1)) {
            this.d = var1;
            this.c = true;
            if(var2) {
               break;
            }
         }
      }

   }
}
