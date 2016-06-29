package y.f.i.a;

import java.util.Iterator;
import java.util.List;
import y.f.i.a.ab;
import y.f.i.a.bA;
import y.f.i.a.bB;
import y.f.i.a.d;
import y.f.i.a.e;
import y.f.i.a.f;

class bz {
   private d a = new d(4096, new bA(this));
   private int b;

   public void a(f var1, double var2) {
      e var4 = this.a.a((Object)(new bB(var2, this.b++, (bA)null)), var1);
      var1.b = var4;
   }

   public boolean a() {
      return this.a.d();
   }

   public boolean a(f var1) {
      return var1.b != null;
   }

   public void b(f var1) {
      this.a.a(var1.b);
      var1.b = null;
   }

   public f b() {
      e var1 = this.a.c();
      this.a.a(var1);
      f var2 = (f)var1.a;
      var2.b = null;
      return var2;
   }

   public void b(f var1, double var2) {
      this.a.b(var1.b, new bB(var2, this.b++, (bA)null));
   }

   public void c() {
      int var3 = ab.a;
      Iterator var1 = this.d().iterator();

      while(true) {
         if(var1.hasNext()) {
            f var2 = (f)var1.next();
            var2.b = null;
            var2.a(false);
            if(var3 != 0) {
               break;
            }

            if(var3 == 0) {
               continue;
            }
         }

         this.a.b();
         break;
      }

   }

   public List d() {
      return this.a.a();
   }
}
