package org.jfree.chart.encoders;

import java.awt.image.*;
import java.io.*;

public class EncoderUtil
{
    public static byte[] encode(final BufferedImage bufferedImage, final String s) {
        return ImageEncoderFactory.newInstance(s).encode(bufferedImage);
    }
    
    public static byte[] encode(final BufferedImage bufferedImage, final String s, final boolean b) {
        return ImageEncoderFactory.newInstance(s, b).encode(bufferedImage);
    }
    
    public static byte[] encode(final BufferedImage bufferedImage, final String s, final float n) {
        return ImageEncoderFactory.newInstance(s, n).encode(bufferedImage);
    }
    
    public static byte[] encode(final BufferedImage bufferedImage, final String s, final float n, final boolean b) {
        return ImageEncoderFactory.newInstance(s, n, b).encode(bufferedImage);
    }
    
    public static void writeBufferedImage(final BufferedImage bufferedImage, final String s, final OutputStream outputStream) {
        ImageEncoderFactory.newInstance(s).encode(bufferedImage, outputStream);
    }
    
    public static void writeBufferedImage(final BufferedImage bufferedImage, final String s, final OutputStream outputStream, final float n) {
        ImageEncoderFactory.newInstance(s, n).encode(bufferedImage, outputStream);
    }
    
    public static void writeBufferedImage(final BufferedImage bufferedImage, final String s, final OutputStream outputStream, final boolean b) {
        ImageEncoderFactory.newInstance(s, b).encode(bufferedImage, outputStream);
    }
    
    public static void writeBufferedImage(final BufferedImage bufferedImage, final String s, final OutputStream outputStream, final float n, final boolean b) {
        ImageEncoderFactory.newInstance(s, n, b).encode(bufferedImage, outputStream);
    }
}
