package y.h;

import java.awt.geom.Point2D.Double;
import y.h.fA;
import y.h.fC;
import y.h.fj;
import y.h.fu;
import y.h.gz;

class fy extends gz {
   private final fA a;
   private final byte c;
   private final fu d;

   fy(fu var1, double var2, fA var4, byte var5) {
      super(var2);
      this.d = var1;
      this.a = var4;
      this.c = var5;
   }

   public boolean a(y.d.t var1, y.d.t var2, byte var3) {
      return false;
   }

   public byte a(y.d.t var1, Double var2, byte var3) {
      double var4 = var2.x;
      double var6 = var2.y;
      double var8 = var4 - fu.e(this.d).a;
      double var10 = var6 - fu.e(this.d).b;
      y.d.t var12 = this.a.c(var8, var10);
      fC var13 = new fC(fu.e(this.d), var4, var6);
      y.d.t var14 = this.a.b();
      switch(this.c) {
      case 0:
         var2.setLocation(var4, var13.b.a(var12.b() - var14.b()));
         if(!fj.z) {
            break;
         }
      case 1:
         var2.setLocation(var13.a.a(var12.a() - var14.a()), var6);
      }

      return (byte)(var8 != var12.a()?(var10 != var12.b()?3:1):(var10 != var12.b()?2:0));
   }
}
