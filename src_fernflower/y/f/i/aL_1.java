package y.f.i;

import y.f.i.aK;
import y.f.i.aM;
import y.f.i.aN;
import y.f.i.v;

class aL {
   private y.c.D a;
   private final aK b;

   public aL(aK var1) {
      this.b = var1;
      this.a = new y.c.D();
   }

   public void a(y.c.q var1) {
      int var4 = v.f;
      aM var2 = (aM)aK.b(this.b).b(var1);
      if(!var2.a) {
         boolean var3 = false;

         while(!var3) {
            var1 = (y.c.q)var2.b();
            if(var1 != null) {
               var2 = (aM)aK.b(this.b).b(var1);
               if(aK.c(this.b).d(var1)) {
                  continue;
               }

               aK.a(this.b, this.a, aM.a(var2));
               if(var4 == 0) {
                  continue;
               }
            }

            var3 = true;
            if(var4 != 0) {
               break;
            }
         }

      }
   }

   public boolean b(y.c.q var1) {
      int var4 = v.f;
      aM var2 = (aM)aK.b(this.b).b(var1);
      if(!var2.a) {
         return false;
      } else {
         boolean var3 = false;

         while(!var3) {
            var1 = (y.c.q)var2.b();
            if(var1 != null) {
               var2 = (aM)aK.b(this.b).b(var1);
               if(aK.c(this.b).d(var1)) {
                  continue;
               }

               aK.b(this.b, this.a, aM.a(var2));
               if(var4 == 0) {
                  continue;
               }
            }

            var3 = true;
            if(var4 != 0) {
               break;
            }
         }

         return this.a();
      }
   }

   private boolean a() {
      int var5 = v.f;
      boolean var1 = true;
      int var2 = 0;
      y.c.C var3 = this.a.m();
      var3.j();

      boolean var10000;
      while(true) {
         if(var3.f()) {
            var10000 = var1;
            if(var5 != 0) {
               break;
            }

            if(var1) {
               aN var4 = (aN)var3.d();
               var2 += var4.c;
               if(var4.c > 0 && var4.b < var2) {
                  var1 = false;
               }

               if(var4.b < var4.c) {
                  var1 = false;
               }

               var3.h();
               if(var5 == 0) {
                  continue;
               }
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }
}
