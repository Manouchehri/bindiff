/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.jfree.chart.JFreeChart;

public class ChartPngCreator {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static BufferedImage draw(JFreeChart jFreeChart, int n2, int n3) {
        BufferedImage bufferedImage = new BufferedImage(n2, n3, 1);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        try {
            jFreeChart.draw(graphics2D, new Rectangle2D.Double(0.0, 0.0, n2, n3));
            return bufferedImage;
        }
        finally {
            graphics2D.dispose();
        }
    }

    public static void saveToFile(JFreeChart jFreeChart, String string, int n2, int n3, double d2) {
        BufferedImage bufferedImage = ChartPngCreator.draw(jFreeChart, n2, n3);
        ImageIO.write((RenderedImage)bufferedImage, "png", new File(string));
    }
}

