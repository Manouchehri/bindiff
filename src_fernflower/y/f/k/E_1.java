package y.f.k;

import java.util.ArrayList;
import java.util.List;
import y.f.k.B;
import y.f.k.F;

class E {
   private List a;
   private y.f.X b;
   private double c;
   private final B d;

   E(B var1, y.f.X var2) {
      this.d = var1;
      this.a = new ArrayList();
      this.b = var2;
   }

   F a(int var1) {
      if(this.a.size() != var1) {
         throw new IllegalStateException("Cannot try to create layer with index " + var1 + ". First create layer " + this.a.size());
      } else {
         F var2 = new F(var1, this);
         var2.a(B.a(this.d));
         var2.b(B.b(this.d));
         this.a.add(var2);
         return var2;
      }
   }

   F b(int var1) {
      return this.a.size() > var1?(F)this.a.get(var1):null;
   }

   private F c(int var1) {
      return this.a.size() <= var1?this.a(var1):(F)this.a.get(var1);
   }

   y.f.X a() {
      return this.b;
   }

   void a(double var1) {
      this.c = var1;
   }

   static F a(E var0, int var1) {
      return var0.c(var1);
   }
}
