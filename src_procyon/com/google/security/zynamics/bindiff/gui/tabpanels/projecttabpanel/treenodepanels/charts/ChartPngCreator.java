package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import org.jfree.chart.*;
import java.awt.geom.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class ChartPngCreator
{
    private static BufferedImage draw(final JFreeChart freeChart, final int n, final int n2) {
        final BufferedImage bufferedImage = new BufferedImage(n, n2, 1);
        final Graphics2D graphics = bufferedImage.createGraphics();
        try {
            freeChart.draw(graphics, new Rectangle2D.Double(0.0, 0.0, n, n2));
        }
        finally {
            graphics.dispose();
        }
        return bufferedImage;
    }
    
    public static void saveToFile(final JFreeChart freeChart, final String s, final int n, final int n2, final double n3) {
        ImageIO.write(draw(freeChart, n, n2), "png", new File(s));
    }
}
