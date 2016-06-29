package y.h;

import y.h.aB;
import y.h.el;
import y.h.fL;
import y.h.fj;

public class em extends el {
   private fL c;

   public em(fL var1, y.d.t var2, byte var3) {
      super(var2, var3);
      this.c = var1;
   }

   public fL a() {
      return this.c;
   }

   public void a(double var1, double var3) {
      fj var6;
      label11: {
         aB var5 = this.c.d();
         if(var5.getSourcePort() == this.c) {
            var6 = var5.getSourceRealizer();
            if(!fj.z) {
               break label11;
            }
         }

         var6 = var5.getTargetRealizer();
      }

      double var7 = var6.getCenterX();
      double var9 = var6.getCenterY();
      this.c.b(this.a(var1) - var7, this.b(var3) - var9);
   }
}
