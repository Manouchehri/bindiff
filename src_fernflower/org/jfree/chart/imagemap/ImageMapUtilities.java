package org.jfree.chart.imagemap;

import java.io.PrintWriter;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.imagemap.OverLIBToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.StandardURLTagFragmentGenerator;
import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.URLTagFragmentGenerator;
import org.jfree.util.StringUtils;

public class ImageMapUtilities {
   public static void writeImageMap(PrintWriter var0, String var1, ChartRenderingInfo var2) {
      writeImageMap(var0, var1, var2, new StandardToolTipTagFragmentGenerator(), new StandardURLTagFragmentGenerator());
   }

   public static void writeImageMap(PrintWriter var0, String var1, ChartRenderingInfo var2, boolean var3) {
      Object var4 = null;
      if(var3) {
         var4 = new OverLIBToolTipTagFragmentGenerator();
      } else {
         var4 = new StandardToolTipTagFragmentGenerator();
      }

      writeImageMap(var0, var1, var2, (ToolTipTagFragmentGenerator)var4, new StandardURLTagFragmentGenerator());
   }

   public static void writeImageMap(PrintWriter var0, String var1, ChartRenderingInfo var2, ToolTipTagFragmentGenerator var3, URLTagFragmentGenerator var4) {
      var0.println(getImageMap(var1, var2, var3, var4));
   }

   public static String getImageMap(String var0, ChartRenderingInfo var1) {
      return getImageMap(var0, var1, new StandardToolTipTagFragmentGenerator(), new StandardURLTagFragmentGenerator());
   }

   public static String getImageMap(String var0, ChartRenderingInfo var1, ToolTipTagFragmentGenerator var2, URLTagFragmentGenerator var3) {
      StringBuffer var4 = new StringBuffer();
      var4.append("<map id=\"" + var0 + "\" name=\"" + var0 + "\">");
      var4.append(StringUtils.getLineSeparator());
      EntityCollection var5 = var1.getEntityCollection();
      if(var5 != null) {
         int var6 = var5.getEntityCount();

         for(int var7 = var6 - 1; var7 >= 0; --var7) {
            ChartEntity var8 = var5.getEntity(var7);
            if(var8.getToolTipText() != null || var8.getURLText() != null) {
               String var9 = var8.getImageMapAreaTag(var2, var3);
               if(var9.length() > 0) {
                  var4.append(var9);
                  var4.append(StringUtils.getLineSeparator());
               }
            }
         }
      }

      var4.append("</map>");
      return var4.toString();
   }
}
