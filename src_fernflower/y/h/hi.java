package y.h;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

class hi {
   double a;
   float b;
   float c;
   String d;

   hi(String var1, Font var2, FontRenderContext var3) {
      this.d = var1;
      TextLayout var4 = new TextLayout(var1, var2, var3);
      Rectangle2D var5 = var2.getStringBounds(this.d, var3);
      this.a = var5.getWidth();
      this.b = var4.getAscent();
      this.c = var4.getDescent();
   }
}
