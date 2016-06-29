package y.c;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import y.c.D;
import y.c.p;

final class F implements Iterator {
   private p a;
   private final D b;
   private int c;

   F(D var1, p var2) {
      this.a = var2;
      this.b = var1;
      this.c = var1.d;
   }

   private final void a() {
      if(this.c != this.b.d) {
         throw new ConcurrentModificationException();
      }
   }

   public final boolean hasNext() {
      this.a();
      return this.a != null;
   }

   public final void remove() {
      boolean var1 = D.e;
      this.a();
      if(this.a == null) {
         if(this.b.c == null) {
            throw new IllegalStateException();
         }

         this.b.h(this.b.c);
         if(var1) {
            throw new IllegalStateException();
         }

         this.c = this.b.d;
         if(!var1) {
            return;
         }
      }

      if(this.a.b == null) {
         throw new IllegalStateException();
      } else {
         this.b.h(this.a.b);
         this.c = this.b.d;
         if(var1) {
            throw new IllegalStateException();
         }
      }
   }

   public final Object next() {
      this.a();
      if(this.a != null) {
         Object var1 = this.a.c();
         this.a = this.a.a();
         return var1;
      } else {
         throw new NoSuchElementException();
      }
   }
}
