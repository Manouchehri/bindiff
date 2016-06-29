package y.h;

import java.util.Iterator;
import java.util.NoSuchElementException;
import y.h.fj;

final class hN implements Iterator {
   private final Iterator[] a;
   private int b;

   hN(Iterator var1, Iterator var2, boolean var3) {
      label11: {
         super();
         if(var3) {
            this.a = new Iterator[]{var1, var2};
            if(!fj.z) {
               break label11;
            }
         }

         this.a = new Iterator[]{var2, var1};
      }

      this.b = 0;
   }

   public boolean hasNext() {
      boolean var1 = fj.z;

      boolean var10000;
      while(true) {
         if(this.b < this.a.length) {
            var10000 = this.a[this.b].hasNext();
            if(var1) {
               break;
            }

            if(var10000) {
               return true;
            }

            ++this.b;
            if(!var1) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   public Object next() {
      if(this.hasNext()) {
         return this.a[this.b].next();
      } else {
         throw new NoSuchElementException();
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
