package y.f.h.a;

import java.util.Iterator;
import y.f.h.D;
import y.f.h.a.b;
import y.f.h.a.d;
import y.f.h.a.j;

public class c extends j {
   y.c.q[] a;

   public c() {
      this.a = null;
   }

   public c(D var1) {
      boolean var8 = b.g;
      super(var1.g());
      this.a = null;
      int[] var2 = new int[this.b.f()];
      y.f.h.q var3 = var1.h();

      int var5;
      while(true) {
         if(var3.f()) {
            y.f.h.p var4 = var3.a();
            var5 = var4.a().k();
            if(var8) {
               break;
            }

            y.c.e var6 = var4.a();

            label78: {
               while(var6.f()) {
                  y.c.d var7 = var6.a();
                  var2[var7.c().d()] = Math.max(var2[var7.c().d()], var5);
                  var6.g();
                  if(var8) {
                     break label78;
                  }

                  if(var8) {
                     break;
                  }
               }

               var3.g();
            }

            if(!var8) {
               continue;
            }
         }

         this.a = this.b.m();
         break;
      }

      y.c.D[] var9 = new y.c.D[this.b.h() * 2];
      int var10 = 0;

      while(var10 < var2.length) {
         if(var9[var2[var10]] == null) {
            var9[var2[var10]] = new y.c.D();
         }

         var9[var2[var10]].add(this.a[var10]);
         ++var10;
         if(var8) {
            break;
         }
      }

      var10 = this.a.length - 1;
      var5 = 0;

      while(var5 < var9.length) {
         label52: {
            if(var9[var5] != null) {
               Iterator var11 = var9[var5].iterator();

               while(var11.hasNext()) {
                  this.a[var10] = (y.c.q)var11.next();
                  --var10;
                  if(var8) {
                     break label52;
                  }

                  if(var8) {
                     break;
                  }
               }
            }

            ++var5;
         }

         if(var8) {
            break;
         }
      }

      if(y.c.i.g) {
         b.g = !var8;
      }

   }

   protected void a() {
   }

   Iterator b() {
      return (Iterator)(this.a == null?super.b():new d(this));
   }
}
