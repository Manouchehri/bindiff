package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.jfree.chart.JFreeChart;

public class ChartPngCreator {
   private static BufferedImage draw(JFreeChart var0, int var1, int var2) {
      BufferedImage var3 = new BufferedImage(var1, var2, 1);
      Graphics2D var4 = var3.createGraphics();

      try {
         var0.draw(var4, new Double(0.0D, 0.0D, (double)var1, (double)var2));
      } finally {
         var4.dispose();
      }

      return var3;
   }

   public static void saveToFile(JFreeChart var0, String var1, int var2, int var3, double var4) {
      BufferedImage var6 = draw(var0, var2, var3);
      ImageIO.write(var6, "png", new File(var1));
   }
}
