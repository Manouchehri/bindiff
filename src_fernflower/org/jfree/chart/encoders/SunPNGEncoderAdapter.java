package org.jfree.chart.encoders;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import org.jfree.chart.encoders.ImageEncoder;

public class SunPNGEncoderAdapter implements ImageEncoder {
   public float getQuality() {
      return 0.0F;
   }

   public void setQuality(float var1) {
   }

   public boolean isEncodingAlpha() {
      return false;
   }

   public void setEncodingAlpha(boolean var1) {
   }

   public byte[] encode(BufferedImage var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      this.encode(var1, var2);
      return var2.toByteArray();
   }

   public void encode(BufferedImage var1, OutputStream var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'image\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'outputStream\' argument.");
      } else {
         ImageIO.write(var1, "png", var2);
      }
   }
}
