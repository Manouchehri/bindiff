package y.f.i.a;

import java.util.Iterator;
import y.f.i.a.ab;
import y.f.i.a.bu;
import y.f.i.a.bv;

class bx {
   boolean a;
   int b;
   int c;
   final y.c.D d;
   final bv[] e;

   bx(bv[] var1, int var2, int var3, boolean var4, y.c.D var5) {
      this.e = var1;
      this.b = var3;
      this.a = var4;
      this.d = var5;
      this.c = var2;
   }

   public boolean a(bx var1) {
      return this.c > var1.c?true:(this.c < var1.c?false:(this.b > var1.b?true:(this.b < var1.b?false:this.d.size() < var1.d.size())));
   }

   public boolean a() {
      int var3 = ab.a;
      Iterator var1 = this.d.iterator();

      boolean var10000;
      while(true) {
         if(var1.hasNext()) {
            bu var2 = (bu)var1.next();
            if(!var2.a()) {
               continue;
            }

            var10000 = true;
            if(var3 == 0) {
               return true;
            }
            break;
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   public boolean b() {
      return this.a;
   }
}
