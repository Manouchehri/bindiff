/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
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
    public static void writeChartAsPNG(OutputStream outputStream, JFreeChart jFreeChart, int n2, int n3) {
        ChartUtilities.writeChartAsPNG(outputStream, jFreeChart, n2, n3, null);
    }

    public static void writeChartAsPNG(OutputStream outputStream, JFreeChart jFreeChart, int n2, int n3, boolean bl2, int n4) {
        ChartUtilities.writeChartAsPNG(outputStream, jFreeChart, n2, n3, null, bl2, n4);
    }

    public static void writeChartAsPNG(OutputStream outputStream, JFreeChart jFreeChart, int n2, int n3, ChartRenderingInfo chartRenderingInfo) {
        if (jFreeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        BufferedImage bufferedImage = jFreeChart.createBufferedImage(n2, n3, chartRenderingInfo);
        EncoderUtil.writeBufferedImage(bufferedImage, "png", outputStream);
    }

    public static void writeChartAsPNG(OutputStream outputStream, JFreeChart jFreeChart, int n2, int n3, ChartRenderingInfo chartRenderingInfo, boolean bl2, int n4) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Null 'out' argument.");
        }
        if (jFreeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        BufferedImage bufferedImage = jFreeChart.createBufferedImage(n2, n3, 2, chartRenderingInfo);
        ChartUtilities.writeBufferedImageAsPNG(outputStream, bufferedImage, bl2, n4);
    }

    public static void writeScaledChartAsPNG(OutputStream outputStream, JFreeChart jFreeChart, int n2, int n3, int n4, int n5) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Null 'out' argument.");
        }
        if (jFreeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        double d2 = n2 * n4;
        double d3 = n3 * n5;
        double d4 = n2;
        double d5 = n3;
        boolean bl2 = false;
        if (n4 != 1 || n5 != 1) {
            bl2 = true;
        }
        double d6 = d2 / d4;
        double d7 = d3 / d5;
        BufferedImage bufferedImage = new BufferedImage((int)d2, (int)d3, 2);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        if (bl2) {
            AffineTransform affineTransform = graphics2D.getTransform();
            graphics2D.transform(AffineTransform.getScaleInstance(d6, d7));
            jFreeChart.draw(graphics2D, new Rectangle2D.Double(0.0, 0.0, d4, d5), null, null);
            graphics2D.setTransform(affineTransform);
            graphics2D.dispose();
        } else {
            jFreeChart.draw(graphics2D, new Rectangle2D.Double(0.0, 0.0, d4, d5), null, null);
        }
        outputStream.write(ChartUtilities.encodeAsPNG(bufferedImage));
    }

    public static void saveChartAsPNG(File file, JFreeChart jFreeChart, int n2, int n3) {
        ChartUtilities.saveChartAsPNG(file, jFreeChart, n2, n3, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void saveChartAsPNG(File file, JFreeChart jFreeChart, int n2, int n3, ChartRenderingInfo chartRenderingInfo) {
        if (file == null) {
            throw new IllegalArgumentException("Null 'file' argument.");
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            ChartUtilities.writeChartAsPNG(bufferedOutputStream, jFreeChart, n2, n3, chartRenderingInfo);
            return;
        }
        finally {
            bufferedOutputStream.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void saveChartAsPNG(File file, JFreeChart jFreeChart, int n2, int n3, ChartRenderingInfo chartRenderingInfo, boolean bl2, int n4) {
        if (file == null) {
            throw new IllegalArgumentException("Null 'file' argument.");
        }
        if (jFreeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            ChartUtilities.writeChartAsPNG(bufferedOutputStream, jFreeChart, n2, n3, chartRenderingInfo, bl2, n4);
            return;
        }
        finally {
            bufferedOutputStream.close();
        }
    }

    public static void writeChartAsJPEG(OutputStream outputStream, JFreeChart jFreeChart, int n2, int n3) {
        ChartUtilities.writeChartAsJPEG(outputStream, jFreeChart, n2, n3, null);
    }

    public static void writeChartAsJPEG(OutputStream outputStream, float f2, JFreeChart jFreeChart, int n2, int n3) {
        ChartUtilities.writeChartAsJPEG(outputStream, f2, jFreeChart, n2, n3, null);
    }

    public static void writeChartAsJPEG(OutputStream outputStream, JFreeChart jFreeChart, int n2, int n3, ChartRenderingInfo chartRenderingInfo) {
        if (jFreeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        BufferedImage bufferedImage = jFreeChart.createBufferedImage(n2, n3, chartRenderingInfo);
        EncoderUtil.writeBufferedImage(bufferedImage, "jpeg", outputStream);
    }

    public static void writeChartAsJPEG(OutputStream outputStream, float f2, JFreeChart jFreeChart, int n2, int n3, ChartRenderingInfo chartRenderingInfo) {
        if (jFreeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        BufferedImage bufferedImage = jFreeChart.createBufferedImage(n2, n3, chartRenderingInfo);
        EncoderUtil.writeBufferedImage(bufferedImage, "jpeg", outputStream, f2);
    }

    public static void saveChartAsJPEG(File file, JFreeChart jFreeChart, int n2, int n3) {
        ChartUtilities.saveChartAsJPEG(file, jFreeChart, n2, n3, null);
    }

    public static void saveChartAsJPEG(File file, float f2, JFreeChart jFreeChart, int n2, int n3) {
        ChartUtilities.saveChartAsJPEG(file, f2, jFreeChart, n2, n3, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void saveChartAsJPEG(File file, JFreeChart jFreeChart, int n2, int n3, ChartRenderingInfo chartRenderingInfo) {
        if (file == null) {
            throw new IllegalArgumentException("Null 'file' argument.");
        }
        if (jFreeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            ChartUtilities.writeChartAsJPEG((OutputStream)bufferedOutputStream, jFreeChart, n2, n3, chartRenderingInfo);
            return;
        }
        finally {
            bufferedOutputStream.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void saveChartAsJPEG(File file, float f2, JFreeChart jFreeChart, int n2, int n3, ChartRenderingInfo chartRenderingInfo) {
        if (file == null) {
            throw new IllegalArgumentException("Null 'file' argument.");
        }
        if (jFreeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            ChartUtilities.writeChartAsJPEG(bufferedOutputStream, f2, jFreeChart, n2, n3, chartRenderingInfo);
            return;
        }
        finally {
            bufferedOutputStream.close();
        }
    }

    public static void writeBufferedImageAsJPEG(OutputStream outputStream, BufferedImage bufferedImage) {
        ChartUtilities.writeBufferedImageAsJPEG(outputStream, 0.75f, bufferedImage);
    }

    public static void writeBufferedImageAsJPEG(OutputStream outputStream, float f2, BufferedImage bufferedImage) {
        EncoderUtil.writeBufferedImage(bufferedImage, "jpeg", outputStream, f2);
    }

    public static void writeBufferedImageAsPNG(OutputStream outputStream, BufferedImage bufferedImage) {
        EncoderUtil.writeBufferedImage(bufferedImage, "png", outputStream);
    }

    public static void writeBufferedImageAsPNG(OutputStream outputStream, BufferedImage bufferedImage, boolean bl2, int n2) {
        EncoderUtil.writeBufferedImage(bufferedImage, "png", outputStream, n2, bl2);
    }

    public static byte[] encodeAsPNG(BufferedImage bufferedImage) {
        return EncoderUtil.encode(bufferedImage, "png");
    }

    public static byte[] encodeAsPNG(BufferedImage bufferedImage, boolean bl2, int n2) {
        return EncoderUtil.encode(bufferedImage, "png", n2, bl2);
    }

    public static void writeImageMap(PrintWriter printWriter, String string, ChartRenderingInfo chartRenderingInfo, boolean bl2) {
        ToolTipTagFragmentGenerator toolTipTagFragmentGenerator = null;
        toolTipTagFragmentGenerator = bl2 ? new OverLIBToolTipTagFragmentGenerator() : new StandardToolTipTagFragmentGenerator();
        ImageMapUtilities.writeImageMap(printWriter, string, chartRenderingInfo, toolTipTagFragmentGenerator, new StandardURLTagFragmentGenerator());
    }

    public static void writeImageMap(PrintWriter printWriter, String string, ChartRenderingInfo chartRenderingInfo, ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, URLTagFragmentGenerator uRLTagFragmentGenerator) {
        printWriter.println(ImageMapUtilities.getImageMap(string, chartRenderingInfo, toolTipTagFragmentGenerator, uRLTagFragmentGenerator));
    }

    public static String getImageMap(String string, ChartRenderingInfo chartRenderingInfo) {
        return ImageMapUtilities.getImageMap(string, chartRenderingInfo, new StandardToolTipTagFragmentGenerator(), new StandardURLTagFragmentGenerator());
    }

    public static String getImageMap(String string, ChartRenderingInfo chartRenderingInfo, ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, URLTagFragmentGenerator uRLTagFragmentGenerator) {
        return ImageMapUtilities.getImageMap(string, chartRenderingInfo, toolTipTagFragmentGenerator, uRLTagFragmentGenerator);
    }
}

