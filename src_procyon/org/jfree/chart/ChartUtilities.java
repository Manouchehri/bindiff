package org.jfree.chart;

import org.jfree.chart.encoders.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;
import java.io.*;
import org.jfree.chart.imagemap.*;

public abstract class ChartUtilities
{
    public static void writeChartAsPNG(final OutputStream outputStream, final JFreeChart freeChart, final int n, final int n2) {
        writeChartAsPNG(outputStream, freeChart, n, n2, null);
    }
    
    public static void writeChartAsPNG(final OutputStream outputStream, final JFreeChart freeChart, final int n, final int n2, final boolean b, final int n3) {
        writeChartAsPNG(outputStream, freeChart, n, n2, null, b, n3);
    }
    
    public static void writeChartAsPNG(final OutputStream outputStream, final JFreeChart freeChart, final int n, final int n2, final ChartRenderingInfo chartRenderingInfo) {
        if (freeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        EncoderUtil.writeBufferedImage(freeChart.createBufferedImage(n, n2, chartRenderingInfo), "png", outputStream);
    }
    
    public static void writeChartAsPNG(final OutputStream outputStream, final JFreeChart freeChart, final int n, final int n2, final ChartRenderingInfo chartRenderingInfo, final boolean b, final int n3) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Null 'out' argument.");
        }
        if (freeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        writeBufferedImageAsPNG(outputStream, freeChart.createBufferedImage(n, n2, 2, chartRenderingInfo), b, n3);
    }
    
    public static void writeScaledChartAsPNG(final OutputStream outputStream, final JFreeChart freeChart, final int n, final int n2, final int n3, final int n4) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Null 'out' argument.");
        }
        if (freeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        final double n5 = n * n3;
        final double n6 = n2 * n4;
        final double n7 = n;
        final double n8 = n2;
        boolean b = false;
        if (n3 != 1 || n4 != 1) {
            b = true;
        }
        final double n9 = n5 / n7;
        final double n10 = n6 / n8;
        final BufferedImage bufferedImage = new BufferedImage((int)n5, (int)n6, 2);
        final Graphics2D graphics = bufferedImage.createGraphics();
        if (b) {
            final AffineTransform transform = graphics.getTransform();
            graphics.transform(AffineTransform.getScaleInstance(n9, n10));
            freeChart.draw(graphics, new Rectangle2D.Double(0.0, 0.0, n7, n8), null, null);
            graphics.setTransform(transform);
            graphics.dispose();
        }
        else {
            freeChart.draw(graphics, new Rectangle2D.Double(0.0, 0.0, n7, n8), null, null);
        }
        outputStream.write(encodeAsPNG(bufferedImage));
    }
    
    public static void saveChartAsPNG(final File file, final JFreeChart freeChart, final int n, final int n2) {
        saveChartAsPNG(file, freeChart, n, n2, null);
    }
    
    public static void saveChartAsPNG(final File file, final JFreeChart freeChart, final int n, final int n2, final ChartRenderingInfo chartRenderingInfo) {
        if (file == null) {
            throw new IllegalArgumentException("Null 'file' argument.");
        }
        final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            writeChartAsPNG(bufferedOutputStream, freeChart, n, n2, chartRenderingInfo);
        }
        finally {
            bufferedOutputStream.close();
        }
    }
    
    public static void saveChartAsPNG(final File file, final JFreeChart freeChart, final int n, final int n2, final ChartRenderingInfo chartRenderingInfo, final boolean b, final int n3) {
        if (file == null) {
            throw new IllegalArgumentException("Null 'file' argument.");
        }
        if (freeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            writeChartAsPNG(bufferedOutputStream, freeChart, n, n2, chartRenderingInfo, b, n3);
        }
        finally {
            bufferedOutputStream.close();
        }
    }
    
    public static void writeChartAsJPEG(final OutputStream outputStream, final JFreeChart freeChart, final int n, final int n2) {
        writeChartAsJPEG(outputStream, freeChart, n, n2, null);
    }
    
    public static void writeChartAsJPEG(final OutputStream outputStream, final float n, final JFreeChart freeChart, final int n2, final int n3) {
        writeChartAsJPEG(outputStream, n, freeChart, n2, n3, null);
    }
    
    public static void writeChartAsJPEG(final OutputStream outputStream, final JFreeChart freeChart, final int n, final int n2, final ChartRenderingInfo chartRenderingInfo) {
        if (freeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        EncoderUtil.writeBufferedImage(freeChart.createBufferedImage(n, n2, chartRenderingInfo), "jpeg", outputStream);
    }
    
    public static void writeChartAsJPEG(final OutputStream outputStream, final float n, final JFreeChart freeChart, final int n2, final int n3, final ChartRenderingInfo chartRenderingInfo) {
        if (freeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        EncoderUtil.writeBufferedImage(freeChart.createBufferedImage(n2, n3, chartRenderingInfo), "jpeg", outputStream, n);
    }
    
    public static void saveChartAsJPEG(final File file, final JFreeChart freeChart, final int n, final int n2) {
        saveChartAsJPEG(file, freeChart, n, n2, null);
    }
    
    public static void saveChartAsJPEG(final File file, final float n, final JFreeChart freeChart, final int n2, final int n3) {
        saveChartAsJPEG(file, n, freeChart, n2, n3, null);
    }
    
    public static void saveChartAsJPEG(final File file, final JFreeChart freeChart, final int n, final int n2, final ChartRenderingInfo chartRenderingInfo) {
        if (file == null) {
            throw new IllegalArgumentException("Null 'file' argument.");
        }
        if (freeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            writeChartAsJPEG(bufferedOutputStream, freeChart, n, n2, chartRenderingInfo);
        }
        finally {
            bufferedOutputStream.close();
        }
    }
    
    public static void saveChartAsJPEG(final File file, final float n, final JFreeChart freeChart, final int n2, final int n3, final ChartRenderingInfo chartRenderingInfo) {
        if (file == null) {
            throw new IllegalArgumentException("Null 'file' argument.");
        }
        if (freeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            writeChartAsJPEG(bufferedOutputStream, n, freeChart, n2, n3, chartRenderingInfo);
        }
        finally {
            bufferedOutputStream.close();
        }
    }
    
    public static void writeBufferedImageAsJPEG(final OutputStream outputStream, final BufferedImage bufferedImage) {
        writeBufferedImageAsJPEG(outputStream, 0.75f, bufferedImage);
    }
    
    public static void writeBufferedImageAsJPEG(final OutputStream outputStream, final float n, final BufferedImage bufferedImage) {
        EncoderUtil.writeBufferedImage(bufferedImage, "jpeg", outputStream, n);
    }
    
    public static void writeBufferedImageAsPNG(final OutputStream outputStream, final BufferedImage bufferedImage) {
        EncoderUtil.writeBufferedImage(bufferedImage, "png", outputStream);
    }
    
    public static void writeBufferedImageAsPNG(final OutputStream outputStream, final BufferedImage bufferedImage, final boolean b, final int n) {
        EncoderUtil.writeBufferedImage(bufferedImage, "png", outputStream, n, b);
    }
    
    public static byte[] encodeAsPNG(final BufferedImage bufferedImage) {
        return EncoderUtil.encode(bufferedImage, "png");
    }
    
    public static byte[] encodeAsPNG(final BufferedImage bufferedImage, final boolean b, final int n) {
        return EncoderUtil.encode(bufferedImage, "png", n, b);
    }
    
    public static void writeImageMap(final PrintWriter printWriter, final String s, final ChartRenderingInfo chartRenderingInfo, final boolean b) {
        ToolTipTagFragmentGenerator toolTipTagFragmentGenerator;
        if (b) {
            toolTipTagFragmentGenerator = new OverLIBToolTipTagFragmentGenerator();
        }
        else {
            toolTipTagFragmentGenerator = new StandardToolTipTagFragmentGenerator();
        }
        ImageMapUtilities.writeImageMap(printWriter, s, chartRenderingInfo, toolTipTagFragmentGenerator, new StandardURLTagFragmentGenerator());
    }
    
    public static void writeImageMap(final PrintWriter printWriter, final String s, final ChartRenderingInfo chartRenderingInfo, final ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, final URLTagFragmentGenerator urlTagFragmentGenerator) {
        printWriter.println(ImageMapUtilities.getImageMap(s, chartRenderingInfo, toolTipTagFragmentGenerator, urlTagFragmentGenerator));
    }
    
    public static String getImageMap(final String s, final ChartRenderingInfo chartRenderingInfo) {
        return ImageMapUtilities.getImageMap(s, chartRenderingInfo, new StandardToolTipTagFragmentGenerator(), new StandardURLTagFragmentGenerator());
    }
    
    public static String getImageMap(final String s, final ChartRenderingInfo chartRenderingInfo, final ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, final URLTagFragmentGenerator urlTagFragmentGenerator) {
        return ImageMapUtilities.getImageMap(s, chartRenderingInfo, toolTipTagFragmentGenerator, urlTagFragmentGenerator);
    }
}
