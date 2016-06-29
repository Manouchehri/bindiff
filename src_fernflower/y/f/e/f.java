package y.f.e;

import y.f.X;
import y.f.e.A;
import y.f.e.d;
import y.f.e.e;
import y.f.e.i;

final class f extends y.f.a {
   private final d a;

   private f(d var1) {
      this.a = var1;
   }

   public void c(X var1) {
      boolean var7 = i.b;
      if(this.a() != null) {
         if(y.f.b.c.b((y.c.i)var1)) {
            label51: {
               Object var2 = null;
               switch(this.a.o()) {
               case 0:
               default:
                  this.a().c(var1);
                  if(!var7) {
                     return;
                  }
               case 1:
                  break;
               case 2:
                  break label51;
               }

               y.c.A var3;
               label43: {
                  var3 = null;
                  if(var1.c(d.o) == null) {
                     var3 = var1.t();
                     var1.a((Object)d.o, (y.c.c)var3);
                     y.f.b.c var4 = new y.f.b.c(var1);
                     y.c.p var5 = var4.b(var4.b()).k();

                     while(var5 != null) {
                        y.c.q var6 = (y.c.q)var5.c();
                        var3.a(var6, var4.d(var6));
                        var5 = var5.a();
                        if(var7) {
                           break label43;
                        }

                        if(var7) {
                           break;
                        }
                     }

                     var4.c();
                  }

                  this.a().c(var1);
               }

               if(var3 == null) {
                  return;
               }

               var1.d_(d.o);
               var1.a((y.c.A)var3);
               var3 = null;
               if(!var7) {
                  return;
               }
            }

            y.f.b.b var8 = new y.f.b.b(this.a());
            var8.a((y.f.b.a)(new A(this.a.a())));
            var8.c(var1);
            if(!var7) {
               return;
            }
         }

         this.a().c(var1);
      }

   }

   f(d var1, e var2) {
      this(var1);
   }
}
