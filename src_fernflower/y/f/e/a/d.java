package y.f.e.a;

import java.util.List;
import y.f.e.a.af;
import y.f.e.a.ay;
import y.f.e.a.p;

abstract class d implements p {
   public void a(ay var1) {
      this.c(var1);
      this.b(var1);
   }

   protected void b(ay var1) {
   }

   protected void c(ay var1) {
      boolean var5 = af.b;
      List var2 = var1.o();
      int var3 = 0;

      while(var3 < var2.size()) {
         p var4 = (p)var2.get(var3);
         if(var4.getClass() == this.getClass()) {
            throw new IllegalStateException("This feature has already been added: " + this.getClass().getName());
         }

         ++var3;
         if(var5) {
            break;
         }
      }

   }

   protected void a(ay var1, Class var2) {
      boolean var6 = af.b;
      List var3 = var1.o();
      int var4 = 0;

      while(var4 < var3.size()) {
         p var5 = (p)var3.get(var4);
         if(var5.getClass() == var2) {
            return;
         }

         ++var4;
         if(var6) {
            break;
         }
      }

      throw new IllegalStateException("The feature " + var2.getName() + " must be added to the layouter before adding " + this.getClass().getName());
   }
}
