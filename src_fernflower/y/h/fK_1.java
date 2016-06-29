package y.h;

import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import y.h.aB;
import y.h.aT;
import y.h.fj;
import y.h.ij;
import y.h.z;

public class fK implements aT {
   public byte a(aB var1, z var2, GeneralPath var3, Point2D var4, Point2D var5) {
      boolean var6 = false;
      if(var1.getEdge().e()) {
         if(var2.isEmpty()) {
            fj var7 = var1.getSourceRealizer();
            var1.appendBend(var1.getSourcePort().a(var7), var1.getSourcePort().b(var7) - 10.0D - var7.getHeight());
         }

         var6 = var2.size() == 1;
      }

      return var6?ij.b(var1, var3, var4, var5):ij.a(var1, var3, var4, var5);
   }
}
