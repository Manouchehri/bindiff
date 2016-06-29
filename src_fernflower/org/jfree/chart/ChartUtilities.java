package org.jfree.chart;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.chart.imagemap.ImageMapUtilities;
import org.jfree.chart.imagemap.OverLIBToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.StandardURLTagFragmentGenerator;
import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.URLTagFragmentGenerator;

public abstract class ChartUtilities {
   public static void writeChartAsPNG(OutputStream var0, JFreeChart var1, int var2, int var3) {
      writeChartAsPNG(var0, var1, var2, var3, (ChartRenderingInfo)null);
   }

   public static void writeChartAsPNG(OutputStream var0, JFreeChart var1, int var2, int var3, boolean var4, int var5) {
      writeChartAsPNG(var0, var1, var2, var3, (ChartRenderingInfo)null, var4, var5);
   }

   public static void writeChartAsPNG(OutputStream var0, JFreeChart var1, int var2, int var3, ChartRenderingInfo var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'chart\' argument.");
      } else {
         BufferedImage var5 = var1.createBufferedImage(var2, var3, var4);
         EncoderUtil.writeBufferedImage(var5, "png", var0);
      }
   }

   public static void writeChartAsPNG(OutputStream var0, JFreeChart var1, int var2, int var3, ChartRenderingInfo var4, boolean var5, int var6) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'out\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'chart\' argument.");
      } else {
         BufferedImage var7 = var1.createBufferedImage(var2, var3, 2, var4);
         writeBufferedImageAsPNG(var0, var7, var5, var6);
      }
   }

   public static void writeScaledChartAsPNG(OutputStream var0, JFreeChart var1, int var2, int var3, int var4, int var5) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'out\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'chart\' argument.");
      } else {
         double var6 = (double)(var2 * var4);
         double var8 = (double)(var3 * var5);
         double var10 = (double)var2;
         double var12 = (double)var3;
         boolean var14 = false;
         if(var4 != 1 || var5 != 1) {
            var14 = true;
         }

         double var15 = var6 / var10;
         double var17 = var8 / var12;
         BufferedImage var19 = new BufferedImage((int)var6, (int)var8, 2);
         Graphics2D var20 = var19.createGraphics();
         if(var14) {
            AffineTransform var21 = var20.getTransform();
            var20.transform(AffineTransform.getScaleInstance(var15, var17));
            var1.draw(var20, new Double(0.0D, 0.0D, var10, var12), (Point2D)null, (ChartRenderingInfo)null);
            var20.setTransform(var21);
            var20.dispose();
         } else {
            var1.draw(var20, new Double(0.0D, 0.0D, var10, var12), (Point2D)null, (ChartRenderingInfo)null);
         }

         var0.write(encodeAsPNG(var19));
      }
   }

   public static void saveChartAsPNG(File var0, JFreeChart var1, int var2, int var3) {
      saveChartAsPNG(var0, var1, var2, var3, (ChartRenderingInfo)null);
   }

   public static void saveChartAsPNG(File var0, JFreeChart var1, int var2, int var3, ChartRenderingInfo var4) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'file\' argument.");
      } else {
         BufferedOutputStream var5 = new BufferedOutputStream(new FileOutputStream(var0));

         try {
            writeChartAsPNG(var5, var1, var2, var3, var4);
         } finally {
            var5.close();
         }

      }
   }

   public static void saveChartAsPNG(File var0, JFreeChart var1, int var2, int var3, ChartRenderingInfo var4, boolean var5, int var6) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'file\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'chart\' argument.");
      } else {
         BufferedOutputStream var7 = new BufferedOutputStream(new FileOutputStream(var0));

         try {
            writeChartAsPNG(var7, var1, var2, var3, var4, var5, var6);
         } finally {
            var7.close();
         }

      }
   }

   public static void writeChartAsJPEG(OutputStream var0, JFreeChart var1, int var2, int var3) {
      writeChartAsJPEG(var0, var1, var2, var3, (ChartRenderingInfo)null);
   }

   public static void writeChartAsJPEG(OutputStream var0, float var1, JFreeChart var2, int var3, int var4) {
      writeChartAsJPEG(var0, var1, var2, var3, var4, (ChartRenderingInfo)null);
   }

   public static void writeChartAsJPEG(OutputStream var0, JFreeChart var1, int var2, int var3, ChartRenderingInfo var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'chart\' argument.");
      } else {
         BufferedImage var5 = var1.createBufferedImage(var2, var3, var4);
         EncoderUtil.writeBufferedImage(var5, "jpeg", var0);
      }
   }

   public static void writeChartAsJPEG(OutputStream var0, float var1, JFreeChart var2, int var3, int var4, ChartRenderingInfo var5) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'chart\' argument.");
      } else {
         BufferedImage var6 = var2.createBufferedImage(var3, var4, var5);
         EncoderUtil.writeBufferedImage(var6, "jpeg", var0, var1);
      }
   }

   public static void saveChartAsJPEG(File var0, JFreeChart var1, int var2, int var3) {
      saveChartAsJPEG(var0, var1, var2, var3, (ChartRenderingInfo)null);
   }

   public static void saveChartAsJPEG(File var0, float var1, JFreeChart var2, int var3, int var4) {
      saveChartAsJPEG(var0, var1, var2, var3, var4, (ChartRenderingInfo)null);
   }

   public static void saveChartAsJPEG(File var0, JFreeChart var1, int var2, int var3, ChartRenderingInfo var4) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'file\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'chart\' argument.");
      } else {
         BufferedOutputStream var5 = new BufferedOutputStream(new FileOutputStream(var0));

         try {
            writeChartAsJPEG(var5, var1, var2, var3, var4);
         } finally {
            var5.close();
         }

      }
   }

   public static void saveChartAsJPEG(File var0, float var1, JFreeChart var2, int var3, int var4, ChartRenderingInfo var5) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'file\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'chart\' argument.");
      } else {
         BufferedOutputStream var6 = new BufferedOutputStream(new FileOutputStream(var0));

         try {
            writeChartAsJPEG(var6, var1, var2, var3, var4, var5);
         } finally {
            var6.close();
         }

      }
   }

   public static void writeBufferedImageAsJPEG(OutputStream var0, BufferedImage var1) {
      writeBufferedImageAsJPEG(var0, 0.75F, var1);
   }

   public static void writeBufferedImageAsJPEG(OutputStream var0, float var1, BufferedImage var2) {
      EncoderUtil.writeBufferedImage(var2, "jpeg", var0, var1);
   }

   public static void writeBufferedImageAsPNG(OutputStream var0, BufferedImage var1) {
      EncoderUtil.writeBufferedImage(var1, "png", var0);
   }

   public static void writeBufferedImageAsPNG(OutputStream var0, BufferedImage var1, boolean var2, int var3) {
      EncoderUtil.writeBufferedImage(var1, "png", var0, (float)var3, var2);
   }

   public static byte[] encodeAsPNG(BufferedImage var0) {
      return EncoderUtil.encode(var0, "png");
   }

   public static byte[] encodeAsPNG(BufferedImage var0, boolean var1, int var2) {
      return EncoderUtil.encode(var0, "png", (float)var2, var1);
   }

   public static void writeImageMap(PrintWriter var0, String var1, ChartRenderingInfo var2, boolean var3) {
      Object var4 = null;
      if(var3) {
         var4 = new OverLIBToolTipTagFragmentGenerator();
      } else {
         var4 = new StandardToolTipTagFragmentGenerator();
      }

      ImageMapUtilities.writeImageMap(var0, var1, var2, (ToolTipTagFragmentGenerator)var4, new StandardURLTagFragmentGenerator());
   }

   public static void writeImageMap(PrintWriter var0, String var1, ChartRenderingInfo var2, ToolTipTagFragmentGenerator var3, URLTagFragmentGenerator var4) {
      var0.println(ImageMapUtilities.getImageMap(var1, var2, var3, var4));
   }

   public static String getImageMap(String var0, ChartRenderingInfo var1) {
      return ImageMapUtilities.getImageMap(var0, var1, new StandardToolTipTagFragmentGenerator(), new StandardURLTagFragmentGenerator());
   }

   public static String getImageMap(String var0, ChartRenderingInfo var1, ToolTipTagFragmentGenerator var2, URLTagFragmentGenerator var3) {
      return ImageMapUtilities.getImageMap(var0, var1, var2, var3);
   }
}
