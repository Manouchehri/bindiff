package org.jfree.chart.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ChartDeleter;

public class ServletUtilities {
   private static String tempFilePrefix = "jfreechart-";
   private static String tempOneTimeFilePrefix = "jfreechart-onetime-";

   public static String getTempFilePrefix() {
      return tempFilePrefix;
   }

   public static void setTempFilePrefix(String var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'prefix\' argument.");
      } else {
         tempFilePrefix = var0;
      }
   }

   public static String getTempOneTimeFilePrefix() {
      return tempOneTimeFilePrefix;
   }

   public static void setTempOneTimeFilePrefix(String var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'prefix\' argument.");
      } else {
         tempOneTimeFilePrefix = var0;
      }
   }

   public static String saveChartAsPNG(JFreeChart var0, int var1, int var2, HttpSession var3) {
      return saveChartAsPNG(var0, var1, var2, (ChartRenderingInfo)null, var3);
   }

   public static String saveChartAsPNG(JFreeChart var0, int var1, int var2, ChartRenderingInfo var3, HttpSession var4) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'chart\' argument.");
      } else {
         createTempDir();
         String var5 = tempFilePrefix;
         if(var4 == null) {
            var5 = tempOneTimeFilePrefix;
         }

         File var6 = File.createTempFile(var5, ".png", new File(System.getProperty("java.io.tmpdir")));
         ChartUtilities.saveChartAsPNG(var6, var0, var1, var2, var3);
         if(var4 != null) {
            registerChartForDeletion(var6, var4);
         }

         return var6.getName();
      }
   }

   public static String saveChartAsJPEG(JFreeChart var0, int var1, int var2, HttpSession var3) {
      return saveChartAsJPEG(var0, var1, var2, (ChartRenderingInfo)null, var3);
   }

   public static String saveChartAsJPEG(JFreeChart var0, int var1, int var2, ChartRenderingInfo var3, HttpSession var4) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'chart\' argument.");
      } else {
         createTempDir();
         String var5 = tempFilePrefix;
         if(var4 == null) {
            var5 = tempOneTimeFilePrefix;
         }

         File var6 = File.createTempFile(var5, ".jpeg", new File(System.getProperty("java.io.tmpdir")));
         ChartUtilities.saveChartAsJPEG(var6, var0, var1, var2, var3);
         if(var4 != null) {
            registerChartForDeletion(var6, var4);
         }

         return var6.getName();
      }
   }

   protected static void createTempDir() {
      String var0 = System.getProperty("java.io.tmpdir");
      if(var0 == null) {
         throw new RuntimeException("Temporary directory system property (java.io.tmpdir) is null.");
      } else {
         File var1 = new File(var0);
         if(!var1.exists()) {
            var1.mkdirs();
         }

      }
   }

   protected static void registerChartForDeletion(File var0, HttpSession var1) {
      if(var1 != null) {
         ChartDeleter var2 = (ChartDeleter)var1.getAttribute("JFreeChart_Deleter");
         if(var2 == null) {
            var2 = new ChartDeleter();
            var1.setAttribute("JFreeChart_Deleter", var2);
         }

         var2.addChart(var0.getName());
      } else {
         System.out.println("Session is null - chart will not be deleted");
      }

   }

   public static void sendTempFile(String var0, HttpServletResponse var1) {
      File var2 = new File(System.getProperty("java.io.tmpdir"), var0);
      sendTempFile(var2, var1);
   }

   public static void sendTempFile(File var0, HttpServletResponse var1) {
      String var2 = null;
      String var3 = var0.getName();
      if(var3.length() > 5) {
         if(var3.substring(var3.length() - 5, var3.length()).equals(".jpeg")) {
            var2 = "image/jpeg";
         } else if(var3.substring(var3.length() - 4, var3.length()).equals(".png")) {
            var2 = "image/png";
         }
      }

      sendTempFile(var0, var1, var2);
   }

   public static void sendTempFile(File var0, HttpServletResponse var1, String var2) {
      if(var0.exists()) {
         BufferedInputStream var3 = new BufferedInputStream(new FileInputStream(var0));
         if(var2 != null) {
            var1.setHeader("Content-Type", var2);
         }

         var1.setHeader("Content-Length", String.valueOf(var0.length()));
         SimpleDateFormat var4 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
         var4.setTimeZone(TimeZone.getTimeZone("GMT"));
         var1.setHeader("Last-Modified", var4.format(new Date(var0.lastModified())));
         BufferedOutputStream var5 = new BufferedOutputStream(var1.getOutputStream());
         byte[] var6 = new byte[1024];
         boolean var7 = false;

         while(!var7) {
            int var8 = var3.read(var6);
            if(var8 == -1) {
               var7 = true;
            } else {
               var5.write(var6, 0, var8);
            }
         }

         var5.flush();
         var3.close();
         var5.close();
      } else {
         throw new FileNotFoundException(var0.getAbsolutePath());
      }
   }

   public static String searchReplace(String var0, String var1, String var2) {
      int var3 = var0.indexOf(var1);
      if(var3 == -1) {
         return var0;
      } else {
         String var4 = "";
         var4 = var4 + var0.substring(0, var3) + var2;
         if(var3 + var1.length() < var0.length()) {
            var4 = var4 + searchReplace(var0.substring(var3 + var1.length()), var1, var2);
         }

         return var4;
      }
   }
}
