package y.h;

import java.awt.Graphics2D;
import java.awt.geom.Line2D.Double;
import y.h.fj;
import y.h.gy;

class di extends gy {
   di(byte var1, y.d.t var2, double var3, double var5) {
      super(var1, (byte)16, var2, var3, var5, (Object)null, 0.5D);
   }

   public void a(Graphics2D var1) {
      Double var3;
      double var4;
      double var6;
      label11: {
         y.d.t var2 = this.b();
         var4 = var2.a;
         var6 = var2.b;
         double var8 = this.e();
         double var10 = this.f();
         if(this.c() == 1) {
            var3 = new Double(var4, var8 - 10.0D, var4, var10 + 10.0D);
            if(!fj.z) {
               break label11;
            }
         }

         var3 = new Double(var8 - 10.0D, var6, var10 + 10.0D, var6);
      }

      var1.draw(var3);
      a(var1, var4, var6);
   }
}
