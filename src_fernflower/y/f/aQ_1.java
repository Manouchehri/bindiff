package y.f;

import y.f.X;
import y.f.a;
import y.f.ah;

public class aQ extends a {
   Object a;
   y.c.f b;
   y.c.y c;

   public aQ() {
      this.a = ah.g_;
      this.b = new y.c.f();
      this.c = new y.c.y();
   }

   public Object b() {
      return this.a;
   }

   public void c(X var1) {
      if(this.a() != null) {
         this.a(var1);
         this.a(var1);
         this.b(var1);
      }

   }

   private void a(y.c.i var1) {
      boolean var5 = X.j;
      y.c.c var2 = var1.c(this.b());
      if(var2 != null) {
         y.c.e var3 = var1.p();

         while(var3.f()) {
            y.c.d var4 = var3.a();
            if(var5) {
               return;
            }

            if(!var2.d(var4.c()) || !var2.d(var4.d())) {
               this.b.c(var4);
               var1.d(var4);
            }

            var3.g();
            if(var5) {
               break;
            }
         }

         y.c.x var6 = var1.o();

         while(var6.f()) {
            if(!var2.d(var6.e())) {
               this.c.c(var6.e());
               var1.c(var6.e());
            }

            var6.g();
            if(var5) {
               break;
            }
         }
      }

   }

   private void b(y.c.i var1) {
      boolean var2 = X.j;

      while(true) {
         if(!this.c.isEmpty()) {
            var1.d(this.c.d());
            if(var2) {
               return;
            }

            if(!var2) {
               continue;
            }
         }

         do {
            if(this.b.isEmpty()) {
               return;
            }

            var1.e(this.b.d());
         } while(!var2);

         return;
      }
   }
}
