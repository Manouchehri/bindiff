package y.b;

import java.util.Iterator;
import y.b.d;
import y.b.e;
import y.b.p;

abstract class s extends p {
   long f = 0L;

   public void disposeAnimation() {
      int var2 = e.a;
      if(this.a.isEmpty()) {
         this.b = false;
      } else {
         int var1 = this.a.size() - 1;

         while(true) {
            if(var1 > -1) {
               ((d)this.a.get(var1)).disposeAnimation();
               --var1;
               if(var2 != 0) {
                  break;
               }

               if(var2 == 0) {
                  continue;
               }
            }

            this.b = false;
            break;
         }

      }
   }

   public long preferredDuration() {
      int var3 = e.a;
      if(this.c) {
         this.f = 0L;
         Iterator var1 = this.a.iterator();

         while(var1.hasNext()) {
            d var2 = (d)var1.next();
            if(var2.preferredDuration() > this.f) {
               this.f = var2.preferredDuration();
               if(var3 != 0) {
                  return this.f;
               }

               if(var3 != 0) {
                  break;
               }
            }
         }

         this.c = false;
      }

      return this.f;
   }
}
