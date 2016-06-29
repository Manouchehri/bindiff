package org.jfree.chart.encoders;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageOutputStream;
import org.jfree.chart.encoders.ImageEncoder;

public class SunJPEGEncoderAdapter implements ImageEncoder {
   private float quality = 0.95F;

   public float getQuality() {
      return this.quality;
   }

   public void setQuality(float var1) {
      if(var1 >= 0.0F && var1 <= 1.0F) {
         this.quality = var1;
      } else {
         throw new IllegalArgumentException("The \'quality\' must be in the range 0.0f to 1.0f");
      }
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
         Iterator var3 = ImageIO.getImageWritersByFormatName("jpeg");
         ImageWriter var4 = (ImageWriter)var3.next();
         ImageWriteParam var5 = var4.getDefaultWriteParam();
         var5.setCompressionMode(2);
         var5.setCompressionQuality(this.quality);
         ImageOutputStream var6 = ImageIO.createImageOutputStream(var2);
         var4.setOutput(var6);
         var4.write((IIOMetadata)null, new IIOImage(var1, (List)null, (IIOMetadata)null), var5);
         var6.flush();
         var4.dispose();
         var6.close();
      }
   }
}
