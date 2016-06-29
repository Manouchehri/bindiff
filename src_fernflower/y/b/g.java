package y.b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import y.b.e;
import y.b.f;
import y.b.h;

final class g implements ActionListener {
   private final e a;

   private g(e var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      boolean var10000;
      int var7;
      label56: {
         var7 = e.a;
         boolean var2 = true;
         synchronized(e.b(this.a)) {
            if(e.b(this.a) == null) {
               return;
            }

            var2 = !e.b(this.a).isEmpty();
            if(var2) {
               y.c.p var4 = e.b(this.a).k();

               while(var4 != null) {
                  h var5 = (h)var4.c();
                  var10000 = var5.a();
                  if(var7 != 0) {
                     break label56;
                  }

                  if(var10000) {
                     e.b(this.a).h(var4);
                  }

                  var4 = var4.a();
                  if(var7 != 0) {
                     break;
                  }
               }
            }
         }

         var10000 = var2;
      }

      if(var10000) {
         e.a(this.a, e.c(this.a));
         if(var7 == 0) {
            return;
         }
      }

      e.d(this.a);
   }

   g(e var1, f var2) {
      this(var1);
   }
}
