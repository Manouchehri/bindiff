package y.f.g;

import java.util.ArrayList;
import java.util.List;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.g.G;
import y.f.g.d;

final class F implements aU {
   final List a = new ArrayList();
   final aV b;
   boolean c;

   F(aV var1) {
      this.b = var1;
   }

   public aU a() {
      return new F(this.b);
   }

   public aQ a(int var1) {
      return (aQ)this.a.get(var1);
   }

   public aQ a(byte var1, int var2) {
      G var3;
      if(this.a.size() > var2) {
         var3 = new G(this, var1, var2);
         this.a.add(var2, var3);
         this.c = true;
         return var3;
      } else if(this.a.size() == var2) {
         var3 = new G(this, var1, var2);
         this.a.add(var3);
         return var3;
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public void b(int var1) {
      if(var1 < this.a.size() - 1) {
         this.c = true;
      }

      G var2 = (G)this.a.remove(var1);
      var2.a = -1;
   }

   public int b() {
      return this.a.size();
   }

   void c() {
      boolean var3 = d.d;
      if(this.c) {
         int var1 = 0;

         while(var1 < this.a.size()) {
            G var2 = (G)this.a.get(var1);
            var2.a = var1++;
            if(var3) {
               return;
            }

            if(var3) {
               break;
            }
         }

         this.c = false;
      }

   }
}
