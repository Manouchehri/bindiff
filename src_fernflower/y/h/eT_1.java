package y.h;

import java.awt.font.FontRenderContext;
import y.h.eR;
import y.h.fj;
import y.h.gZ;
import y.h.hc;
import y.h.hj;

final class eT implements hc {
   public void a(gZ var1, FontRenderContext var2) {
      boolean var9 = fj.z;
      if(var1 instanceof eR) {
         eR var3 = (eR)var1;
         var3.sizeDirty = false;
         hj.d.a(var1, var2, var3.v);
         double var4 = var3.contentHeight;
         double var6 = var3.contentWidth;
         fj var8;
         switch(var3.v) {
         case 4:
            if(!var9) {
               break;
            }
         case 2:
            var8 = var3.g();
            if(var8 == null) {
               break;
            }

            var4 = var8.getHeight();
            if(!var9) {
               break;
            }
         case 3:
            var8 = var3.g();
            if(var8 == null) {
               break;
            }

            var6 = var8.getWidth();
            var4 = var8.getHeight();
            if(!var9) {
               break;
            }
         case 1:
            var8 = var3.g();
            if(var8 != null) {
               var6 = var8.getWidth();
            }
         }

         var3.setContentSize(var6, var4);
      }

   }

   public boolean a(gZ var1, double var2, double var4) {
      return var1.getContentBox().a(var2, var4, true);
   }
}
