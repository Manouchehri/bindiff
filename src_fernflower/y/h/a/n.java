package y.h.a;

import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ActionMap;
import y.h.bu;
import y.h.ch;
import y.h.cm;
import y.h.dw;
import y.h.fj;
import y.h.a.v;

public abstract class n extends y.h.c {
   private final fj a;
   private final ch b;

   protected n(fj var1, ch var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean a(dw var1) {
      return this.a(this.a, var1.a(), var1.b());
   }

   public void b(dw var1) {
      if(!this.a(this.a, var1.a(), var1.b())) {
         this.e();
      } else {
         if(var1.c() == 500) {
            y.c.q var2 = this.a.getNode();
            if(var2 == null || var2.e() == null) {
               return;
            }

            v var3 = v.a((y.c.i)this.b.getGraph2D());
            if(var3 != null && var3.d(var2.e())) {
               boolean var4;
               label25: {
                  var4 = false;
                  if(var3.j(var2)) {
                     this.a(var2, var3);
                     var4 = true;
                     if(v.a == 0) {
                        break label25;
                     }
                  }

                  if(var3.k(var2)) {
                     this.b(var2, var3);
                     var4 = true;
                  }
               }

               if(var4) {
                  this.e();
               }
            }
         }

      }
   }

   protected abstract boolean a(fj var1, double var2, double var4);

   protected void a(y.c.q var1, v var2) {
      a(var1, cm.z, this.b);
   }

   protected void b(y.c.q var1, v var2) {
      a(var1, cm.A, this.b);
   }

   private static void a(y.c.q var0, Object var1, ch var2) {
      Action var3 = a(var1, var2);
      if(var3 != null) {
         if(var0 != null) {
            bu var4 = var2.getGraph2D();
            var4.N();
            var4.a(var0, true);
         }

         var3.actionPerformed(new ActionEvent(var2, 1001, ""));
      }

   }

   private static Action a(Object var0, ch var1) {
      ActionMap var2 = var1.getCanvasComponent().getActionMap();
      if(var2 != null) {
         Action var3 = var2.get(var0);
         if(var3 != null) {
            return var3;
         }
      }

      return (new cm(var1)).v().get(var0);
   }
}
