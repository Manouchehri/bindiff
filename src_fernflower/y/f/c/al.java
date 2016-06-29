package y.f.c;

import java.util.Set;
import y.f.c.a;

final class al implements y.c.h {
   private final Set a;

   al(Set var1) {
      this.a = var1;
   }

   public Object b(Object var1) {
      throw new UnsupportedOperationException();
   }

   public void a(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public void a(Object var1, boolean var2) {
      if(var2) {
         this.a.add(var1);
         if(!a.i) {
            return;
         }
      }

      this.a.remove(var1);
   }

   public boolean d(Object var1) {
      return this.a.contains(var1);
   }

   public void a(Object var1, double var2) {
      throw new UnsupportedOperationException();
   }

   public double c(Object var1) {
      throw new UnsupportedOperationException();
   }

   public void a(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   public int a(Object var1) {
      throw new UnsupportedOperationException();
   }
}
