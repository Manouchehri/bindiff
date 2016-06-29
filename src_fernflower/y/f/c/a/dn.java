package y.f.c.a;

import java.util.ArrayList;
import java.util.List;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.do;

final class dn implements aU {
   final List a = new ArrayList();
   final aV b;
   boolean c;

   dn(aV var1) {
      this.b = var1;
   }

   public aU a() {
      return new dn(this.b);
   }

   public aQ a(int var1) {
      return (aQ)this.a.get(var1);
   }

   public aQ a(byte var1, int var2) {
      do var3;
      if(this.a.size() > var2) {
         var3 = new do(this, var1, var2);
         this.a.add(var2, var3);
         this.c = true;
         return var3;
      } else if(this.a.size() == var2) {
         var3 = new do(this, var1, var2);
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

      do var2 = (do)this.a.remove(var1);
      var2.a = -1;
   }

   public int b() {
      return this.a.size();
   }

   void c() {
      boolean var3 = N.x;
      if(this.c) {
         int var1 = 0;

         while(var1 < this.a.size()) {
            do var2 = (do)this.a.get(var1);
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
