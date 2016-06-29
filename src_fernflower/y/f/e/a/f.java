package y.f.e.a;

import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;
import y.f.e.a.l;

class f implements am {
   public void a(l var1, af var2) {
      boolean var9 = af.b;
      y.f.X var3 = var2.f();
      if(!y.f.b.c.c((y.c.i)var3)) {
         y.f.b.c var4 = new y.f.b.c(var3);
         boolean var11 = false;

         y.f.b.c var10000;
         label82: {
            try {
               var11 = true;
               y.c.x var5 = var3.o();

               while(true) {
                  if(var5.f()) {
                     y.c.q var6 = var5.e();
                     ag var7 = var2.c(var6);
                     var10000 = var4;
                     if(var9) {
                        var11 = false;
                        break label82;
                     }

                     if(var4.d(var6) && var4.b(var6).size() > 0) {
                        var7.b(true);
                     }

                     if(var4.a(var6) != var4.b()) {
                        var7.a(var2.a(var4.a(var6)));
                     }

                     var5.g();
                     if(!var9) {
                        continue;
                     }

                     var11 = false;
                     break;
                  }

                  var11 = false;
                  break;
               }
            } finally {
               if(var11) {
                  var4.c();
               }
            }

            var10000 = var4;
         }

         var10000.c();
      }
   }
}
