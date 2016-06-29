package y.h.b;

import java.awt.geom.Rectangle2D;
import y.h.br;
import y.h.fj;
import y.h.b.a;

class b implements br {
   public void a(fj var1, Rectangle2D var2) {
      int var16 = a.H;
      double var3 = var1.getX();
      double var5 = var1.getY();
      double var7 = var1.getWidth();
      double var9 = var1.getHeight();
      if(var1 instanceof a) {
         a var11 = (a)var1;
         double var12 = a.a(var11);
         if(var7 < var12) {
            var7 = var12;
         }

         double var14 = a.b(var11);
         if(var9 < var14) {
            var9 = var14;
         }
      }

      if(var2.getWidth() > 0.0D && var2.getHeight() > 0.0D) {
         double var17 = var3 + var7;
         double var13 = var5 + var9;
         var3 = Math.min(var3, var2.getX());
         var5 = Math.min(var5, var2.getY());
         var7 = Math.max(var17, var2.getMaxX()) - var3;
         var9 = Math.max(var13, var2.getMaxY()) - var5;
      }

      var2.setFrame(var3, var5, var7, var9);
      int var18;
      int var19;
      if(var1.labelCount() > 0) {
         var18 = 0;
         var19 = var1.labelCount();

         while(var18 < var19) {
            var1.getLabel(var18).calcUnionRect(var2);
            ++var18;
            if(var16 != 0) {
               return;
            }

            if(var16 != 0) {
               break;
            }
         }
      }

      if(var1.portCount() > 0) {
         var18 = 0;
         var19 = var1.portCount();

         while(var18 < var19) {
            var1.getPort(var18).a(var2);
            ++var18;
            if(var16 != 0) {
               break;
            }
         }
      }

   }
}
