package org.jfree.chart.encoders;

import java.util.Hashtable;
import org.jfree.chart.encoders.ImageEncoder;

public class ImageEncoderFactory {
   private static Hashtable encoders = null;

   private static void init() {
      encoders = new Hashtable();
      encoders.put("jpeg", "org.jfree.chart.encoders.SunJPEGEncoderAdapter");

      try {
         Class.forName("javax.imageio.ImageIO");
         Class.forName("org.jfree.chart.encoders.SunPNGEncoderAdapter");
         encoders.put("png", "org.jfree.chart.encoders.SunPNGEncoderAdapter");
         encoders.put("jpeg", "org.jfree.chart.encoders.SunJPEGEncoderAdapter");
      } catch (ClassNotFoundException var1) {
         encoders.put("png", "org.jfree.chart.encoders.KeypointPNGEncoderAdapter");
      }

   }

   public static void setImageEncoder(String var0, String var1) {
      encoders.put(var0, var1);
   }

   public static ImageEncoder newInstance(String var0) {
      ImageEncoder var1 = null;
      String var2 = (String)encoders.get(var0);
      if(var2 == null) {
         throw new IllegalArgumentException("Unsupported image format - " + var0);
      } else {
         try {
            Class var3 = Class.forName(var2);
            var1 = (ImageEncoder)var3.newInstance();
            return var1;
         } catch (Exception var4) {
            throw new IllegalArgumentException(var4.toString());
         }
      }
   }

   public static ImageEncoder newInstance(String var0, float var1) {
      ImageEncoder var2 = newInstance(var0);
      var2.setQuality(var1);
      return var2;
   }

   public static ImageEncoder newInstance(String var0, boolean var1) {
      ImageEncoder var2 = newInstance(var0);
      var2.setEncodingAlpha(var1);
      return var2;
   }

   public static ImageEncoder newInstance(String var0, float var1, boolean var2) {
      ImageEncoder var3 = newInstance(var0);
      var3.setQuality(var1);
      var3.setEncodingAlpha(var2);
      return var3;
   }

   static {
      init();
   }
}
