package y.c;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import y.c.D;
import y.c.p;

final class G implements ListIterator {
   final D a;
   private int b;
   private int c;
   private p d;
   private p e;

   G(D var1, int var2, p var3) {
      this.a = var1;
      this.b = var2;
      this.e = var3;
      this.c = var1.d;
   }

   private final void a() {
      if(this.c != this.a.d) {
         throw new ConcurrentModificationException();
      }
   }

   public void set(Object var1) {
      this.a();
      if(this.d != null) {
         this.d.a(var1);
         if(!D.e) {
            return;
         }
      }

      throw new IllegalStateException();
   }

   public void add(Object var1) {
      label11: {
         this.a();
         if(this.e != null) {
            this.a.a(var1, this.e);
            if(!D.e) {
               break label11;
            }
         }

         this.a.add(var1);
      }

      this.c = this.a.d;
      ++this.b;
      this.d = null;
   }

   public void remove() {
      this.a();
      if(this.d != null) {
         if(this.d.a == this.e) {
            --this.b;
         }

         this.a.h(this.d);
         this.d = null;
         this.c = this.a.d;
         if(!D.e) {
            return;
         }
      }

      throw new IllegalStateException();
   }

   public int previousIndex() {
      this.a();
      return this.b - 1;
   }

   public Object previous() {
      this.a();
      if(this.e != null) {
         if(this.e.b != null) {
            this.e = this.e.b;
            this.d = this.e;
            --this.b;
            return this.e.c;
         } else {
            throw new NoSuchElementException();
         }
      } else {
         this.e = this.a.c;
         if(this.e != null) {
            --this.b;
            return this.e.c;
         } else {
            throw new NoSuchElementException();
         }
      }
   }

   public int nextIndex() {
      this.a();
      return this.b;
   }

   public Object next() {
      this.a();
      if(this.e != null) {
         Object var1 = this.e.c();
         this.d = this.e;
         ++this.b;
         this.e = this.e.a();
         return var1;
      } else {
         throw new NoSuchElementException();
      }
   }

   public boolean hasPrevious() {
      this.a();
      return this.e == null && this.a.c != null || this.e.b != null;
   }

   public boolean hasNext() {
      this.a();
      return this.e != null;
   }
}
