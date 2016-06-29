package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.util.Comparator;
import y.h.cm;
import y.h.fj;

class cr implements Comparator {
   private final AffineTransform a;
   private final double[] b;
   private final double[] c;
   private final y.d.t d;
   private final cm e;

   cr(cm var1, AffineTransform var2, double[] var3, double[] var4, y.d.t var5) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
   }

   public int compare(Object var1, Object var2) {
      boolean var11 = fj.z;
      GeneralPath var3 = (GeneralPath)var1;
      GeneralPath var4 = (GeneralPath)var2;
      PathIterator var5 = var3.getPathIterator(this.a, 1.0D);
      PathIterator var6 = var4.getPathIterator(this.a, 1.0D);

      boolean var10000;
      while(true) {
         if(!var5.isDone()) {
            var10000 = var6.isDone();
            if(var11) {
               break;
            }

            if(var10000) {
               return -1;
            }

            var5.currentSegment(this.b);
            var6.currentSegment(this.c);
            double var7 = cm.a(this.e, this.b[0], this.b[1], this.d.a, this.d.b);
            double var9 = cm.a(this.e, this.c[0], this.c[1], this.d.a, this.d.b);
            if(var7 < var9) {
               return -1;
            }

            if(var7 > var9) {
               return 1;
            }

            var5.next();
            var6.next();
            if(!var11) {
               continue;
            }
         }

         var10000 = var6.isDone();
         break;
      }

      return !var10000?1:0;
   }
}
