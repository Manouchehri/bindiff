package y.a;

import java.util.HashMap;
import java.util.Map;
import y.a.h;

class aa extends y.c.i {
   Map a;
   Map b;

   public aa(y.c.i var1) {
      boolean var5 = h.a;
      super();
      this.b = new HashMap();
      this.a = new HashMap();
      y.c.x var2 = var1.o();

      Object var10000;
      while(true) {
         if(var2.f()) {
            y.c.q var3 = this.d();
            this.b.put(var3, var2.e());
            var10000 = this;
            if(var5) {
               break;
            }

            this.a.put(var2.e(), var3);
            var2.g();
            if(!var5) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      y.c.e var6 = ((y.c.i)var10000).p();

      while(var6.f()) {
         y.c.d var7 = var6.a();
         y.c.d var4 = this.a((y.c.q)this.a.get(var7.c()), (y.c.q)this.a.get(var7.d()));
         this.b.put(var4, var7);
         this.a.put(var7, var4);
         var6.g();
         if(var5) {
            break;
         }
      }

   }

   public void a(y.c.C var1, y.c.c var2, y.c.b var3) {
      boolean var5 = h.a;

      while(var1.f()) {
         Object var4 = var1.d();
         var3.a(var4, var2.a(this.b.get(var4)));
         var1.g();
         if(var5) {
            break;
         }
      }

   }

   public void b(y.c.C var1, y.c.c var2, y.c.b var3) {
      boolean var5 = h.a;

      while(var1.f()) {
         Object var4 = var1.d();
         var3.a(var4, var2.c(this.b.get(var4)));
         var1.g();
         if(var5) {
            break;
         }
      }

   }

   public void c(y.c.C var1, y.c.c var2, y.c.b var3) {
      boolean var5 = h.a;

      while(var1.f()) {
         Object var4 = var1.d();
         var3.a(var4, var2.a(this.a.get(var4)));
         var1.g();
         if(var5) {
            break;
         }
      }

   }
}
