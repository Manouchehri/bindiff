package org.jfree.chart.encoders;

import com.keypoint.PngEncoder;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import org.jfree.chart.encoders.ImageEncoder;

public class KeypointPNGEncoderAdapter implements ImageEncoder {
   private int quality = 9;
   private boolean encodingAlpha = false;

   public float getQuality() {
      return (float)this.quality;
   }

   public void setQuality(float var1) {
      this.quality = (int)var1;
   }

   public boolean isEncodingAlpha() {
      return this.encodingAlpha;
   }

   public void setEncodingAlpha(boolean var1) {
      this.encodingAlpha = var1;
   }

   public byte[] encode(BufferedImage var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'image\' argument.");
      } else {
         PngEncoder var2 = new PngEncoder(var1, this.encodingAlpha, 0, this.quality);
         return var2.pngEncode();
      }
   }

   public void encode(BufferedImage var1, OutputStream var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'image\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'outputStream\' argument.");
      } else {
         PngEncoder var3 = new PngEncoder(var1, this.encodingAlpha, 0, this.quality);
         var2.write(var3.pngEncode());
      }
   }
}
