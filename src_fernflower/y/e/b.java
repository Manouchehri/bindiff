package y.e;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import y.e.c;
import y.e.d;
import y.e.e;
import y.h.M;
import y.h.bu;
import y.h.ch;

public class b extends e {
   protected void a(BufferedImage var1, OutputStream var2) {
      ImageWriter var3 = d.a("gif");
      if(var3 != null) {
         d.a(var3, var1, var2, (ImageWriteParam)null);
         if(c.a == 0) {
            return;
         }
      }

      throw new IOException(d.b("gif"));
   }

   protected BufferedImage a(int var1, int var2) {
      return new BufferedImage(var1, var2, 2);
   }

   public ch a(bu var1) {
      ch var2 = super.a(var1);
      M var3 = new M(var2);
      var3.setColor(new Color(255, 255, 255, 0));
      var2.setBackgroundRenderer(var3);
      return var2;
   }
}
