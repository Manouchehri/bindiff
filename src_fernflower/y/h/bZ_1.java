package y.h;

import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D.Double;
import java.awt.print.Paper;
import y.h.bY;
import y.h.fj;

public class bZ extends bY {
   void a() {
      boolean var8 = fj.z;
      this.f.setFrame(0.0D, 0.0D, 0.0D, 0.0D);
      if(this.a != null && !"".equals(this.a)) {
         Paper var3;
         label26: {
            this.e = new TextLayout(this.a, this.b, this.d.b.getFontRenderContext());
            double var1 = this.e.getBounds().getHeight() + 20.0D;
            var3 = this.d.a.getPaper();
            if(this.d.a.getOrientation() == 1) {
               this.f = new Double(var3.getImageableX(), var3.getImageableY(), var3.getImageableWidth(), var1);
               if(!var8) {
                  break label26;
               }
            }

            double var4;
            double var6;
            if(this.d.a.getOrientation() == 0) {
               var4 = var3.getHeight() - var3.getImageableY() - var3.getImageableHeight();
               var6 = var3.getImageableX();
               this.f = new Double(var4, var6, var3.getImageableHeight(), var1);
               if(!var8) {
                  break label26;
               }
            }

            if(this.d.a.getOrientation() == 2) {
               var4 = var3.getImageableY();
               var6 = var3.getWidth() - var3.getImageableX() - var3.getImageableWidth();
               this.f = new Double(var4, var6, var3.getImageableHeight(), var1);
            }
         }

         this.f.x -= (double)this.d.d * this.f.width;
         this.f.y -= (double)this.d.e * var3.getImageableHeight();
         this.f.width *= (double)this.d.g;
      }

   }
}
