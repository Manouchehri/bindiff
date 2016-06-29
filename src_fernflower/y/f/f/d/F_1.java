package y.f.f.d;

import java.util.ArrayList;
import y.f.f.d.o;

public class F extends y.f.f.b.e {
   public void b() {
      this.d();
      super.b();
      this.i = false;
   }

   protected void d() {
      boolean var7 = o.p;
      boolean[] var1 = this.b.p();
      y.c.e var2 = this.d.p();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         if(var1[var3.b()]) {
            label50: {
               y.c.d var4 = this.c.j(this.b.a(var3));
               if(this.b.c(var4)) {
                  var4 = this.b.a(var4);
               }

               if(this.b.c(var3)) {
                  var3 = this.b.a(var3);
               }

               ArrayList var5 = (ArrayList)this.e.b(var3);
               ArrayList var6 = (ArrayList)this.e.b(var4);
               this.e.a(var3, (Object)null);
               if(var6 != null && var5 != null) {
                  if(this.b.c(var2.a())) {
                     var6.addAll(var5);
                     this.e.a(var4, var6);
                     if(!var7) {
                        break label50;
                     }
                  }

                  var5.addAll(var6);
                  this.e.a(var4, var5);
                  if(!var7) {
                     break label50;
                  }
               }

               if(var6 != null) {
                  this.e.a(var4, var6);
                  if(!var7) {
                     break label50;
                  }
               }

               if(var5 != null) {
                  this.e.a(var4, var5);
               }
            }
         }

         var2.g();
         if(var7) {
            break;
         }
      }

   }
}
