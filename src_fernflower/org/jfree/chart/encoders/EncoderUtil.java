package org.jfree.chart.encoders;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import org.jfree.chart.encoders.ImageEncoder;
import org.jfree.chart.encoders.ImageEncoderFactory;

public class EncoderUtil {
   public static byte[] encode(BufferedImage var0, String var1) {
      ImageEncoder var2 = ImageEncoderFactory.newInstance(var1);
      return var2.encode(var0);
   }

   public static byte[] encode(BufferedImage var0, String var1, boolean var2) {
      ImageEncoder var3 = ImageEncoderFactory.newInstance(var1, var2);
      return var3.encode(var0);
   }

   public static byte[] encode(BufferedImage var0, String var1, float var2) {
      ImageEncoder var3 = ImageEncoderFactory.newInstance(var1, var2);
      return var3.encode(var0);
   }

   public static byte[] encode(BufferedImage var0, String var1, float var2, boolean var3) {
      ImageEncoder var4 = ImageEncoderFactory.newInstance(var1, var2, var3);
      return var4.encode(var0);
   }

   public static void writeBufferedImage(BufferedImage var0, String var1, OutputStream var2) {
      ImageEncoder var3 = ImageEncoderFactory.newInstance(var1);
      var3.encode(var0, var2);
   }

   public static void writeBufferedImage(BufferedImage var0, String var1, OutputStream var2, float var3) {
      ImageEncoder var4 = ImageEncoderFactory.newInstance(var1, var3);
      var4.encode(var0, var2);
   }

   public static void writeBufferedImage(BufferedImage var0, String var1, OutputStream var2, boolean var3) {
      ImageEncoder var4 = ImageEncoderFactory.newInstance(var1, var3);
      var4.encode(var0, var2);
   }

   public static void writeBufferedImage(BufferedImage var0, String var1, OutputStream var2, float var3, boolean var4) {
      ImageEncoder var5 = ImageEncoderFactory.newInstance(var1, var3, var4);
      var5.encode(var0, var2);
   }
}
