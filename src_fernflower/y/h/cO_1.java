package y.h;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.ref.WeakReference;
import y.h.aA;
import y.h.bu;
import y.h.cG;
import y.h.eR;
import y.h.fj;
import y.h.gZ;

class cO implements PropertyChangeListener {
   private final WeakReference a;
   private final WeakReference b;
   private final WeakReference c;

   cO(cG var1, bu var2, gZ var3) {
      this.a = new WeakReference(var1);
      this.b = new WeakReference(var2);
      this.c = new WeakReference(var3);
   }

   public void propertyChange(PropertyChangeEvent var1) {
      a((cG)this.a.get(), (bu)this.b.get(), (gZ)this.c.get(), (String)var1.getNewValue());
   }

   private static void a(cG var0, bu var1, gZ var2, String var3) {
      boolean var5 = fj.z;
      if(var1 != null && var2 != null) {
         var1.r();

         try {
            label61: {
               if(var2 instanceof eR) {
                  var1.a((new y.c.y(((eR)var2).f())).a());
                  if(!var5) {
                     break label61;
                  }
               }

               if(var2 instanceof aA) {
                  var1.a((new y.c.f(((aA)var2).getEdge())).a());
               }
            }

            if(var0 == null) {
               var2.setText(var3);
               if(!var5) {
                  return;
               }
            }

            var0.a(var2, var3);
         } finally {
            var1.s();
         }
      }

   }
}
