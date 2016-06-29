package y.h;

import java.awt.event.ActionEvent;
import y.h.bu;
import y.h.cA;
import y.h.ch;
import y.h.cm;
import y.h.fj;

public class cM extends cA {
   public cM() {
      this((ch)null);
   }

   public cM(ch var1) {
      super(cm.x.toString(), var1);
   }

   public void actionPerformed(ActionEvent var1) {
      ch var2 = this.a(var1);
      if(var2 != null) {
         this.a(var2);
         var2.getGraph2D().T();
      }

   }

   public void a(ch var1) {
      boolean var8 = fj.z;
      bu var2 = var1.getGraph2D();
      y.h.a.v var3 = this.a(var2);
      if(var3 != null) {
         y.c.y var4 = new y.c.y();
         y.c.x var5 = var2.o();

         while(var5.f()) {
            y.c.q var6 = var5.e();
            if(var8) {
               return;
            }

            if(this.a(var2, var6)) {
               var4.add(var6);
            }

            var5.g();
            if(var8) {
               break;
            }
         }

         y.c.y var11 = new y.c.y(var2.J());
         if(!var4.isEmpty()) {
            var2.r();

            try {
               y.c.f var12 = this.a(var4, var2);
               var3.b(var4);
               this.a(var12, var2);
            } finally {
               var2.s();
            }
         }

         y.c.x var13 = var11.a();

         while(var13.f()) {
            y.c.q var7 = var13.e();
            if(this.b()) {
               var2.a(var7, true);
            }

            var13.g();
            if(var8) {
               break;
            }
         }
      }

   }

   protected boolean a(bu var1, y.c.q var2) {
      return var1.v(var2);
   }

   protected y.c.f a(y.c.y var1, bu var2) {
      return new y.c.f();
   }

   protected void a(y.c.f var1, bu var2) {
   }
}
