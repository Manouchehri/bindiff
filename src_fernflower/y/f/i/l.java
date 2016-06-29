package y.f.i;

import java.util.HashMap;
import y.f.i.v;

class l {
   y.f.X a;
   y.c.c b;
   y.c.c c;
   y.c.f d;
   y.c.h e;
   y.c.h f;

   l(y.f.X var1) {
      this.a = var1;
   }

   void a() {
      int var8 = v.f;
      this.d = new y.c.f();
      this.c = this.a.c(y.f.aF.d);
      this.b = this.a.c(y.f.aF.c);
      this.e = this.a.u();
      this.f = this.a.u();
      this.a.a((Object)y.f.aF.d, (y.c.c)this.e);
      this.a.a((Object)y.f.aF.c, (y.c.c)this.f);
      HashMap var1 = new HashMap();
      int var2 = 0;
      y.c.e var3 = this.a.p();

      while(var3.f()) {
         label38: {
            y.c.d var4 = var3.a();
            if(this.c != null && this.c.b(var4) != null) {
               this.e.a(var4, this.c.b(var4));
               if(var8 == 0) {
                  break label38;
               }
            }

            Object var5 = this.b == null?null:this.b.b(var4);
            if(var5 != null) {
               Object var6 = var1.get(var5);
               if(var6 == null) {
                  var6 = y.g.am.a(var5, "" + var2);
                  ++var2;
                  var1.put(var5, var6);
               }

               this.e.a(var4, var6);
               y.c.D var7 = this.a.m(var4);
               var7.n();
               this.a.c(var4);
               this.a.a(var4, var7);
               this.d.add(var4);
            }
         }

         var3.g();
         if(var8 != 0) {
            break;
         }
      }

   }

   void b() {
      int var4 = v.f;
      y.c.e var1 = this.d.a();

      while(true) {
         if(var1.f()) {
            y.c.d var2 = var1.a();
            y.c.D var3 = this.a.m(var2);
            var3.n();
            this.a.c(var2);
            this.a.a(var2, var3);
            var1.g();
            if(var4 != 0) {
               break;
            }

            if(var4 == 0) {
               continue;
            }
         }

         this.a.d_(y.f.aF.c);
         this.a.d_(y.f.aF.d);
         break;
      }

      if(this.b != null) {
         this.a.a((Object)y.f.aF.c, (y.c.c)this.b);
      }

      if(this.c != null) {
         this.a.a((Object)y.f.aF.d, (y.c.c)this.c);
      }

      this.a.a((y.c.h)this.f);
      this.a.a((y.c.h)this.e);
   }

   public void a(y.c.h var1, y.c.h var2) {
      int var6 = v.f;
      y.c.e var3 = this.d.a();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         Object var5 = var1.b(var4);
         var1.a(var4, var2.b(var4));
         var2.a(var4, var5);
         var3.g();
         if(var6 != 0) {
            break;
         }
      }

   }
}
