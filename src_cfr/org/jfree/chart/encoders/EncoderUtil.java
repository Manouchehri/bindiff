/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.encoders;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import org.jfree.chart.encoders.ImageEncoder;
import org.jfree.chart.encoders.ImageEncoderFactory;

public class EncoderUtil {
    public static byte[] encode(BufferedImage bufferedImage, String string) {
        ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(string);
        return imageEncoder.encode(bufferedImage);
    }

    public static byte[] encode(BufferedImage bufferedImage, String string, boolean bl2) {
        ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(string, bl2);
        return imageEncoder.encode(bufferedImage);
    }

    public static byte[] encode(BufferedImage bufferedImage, String string, float f2) {
        ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(string, f2);
        return imageEncoder.encode(bufferedImage);
    }

    public static byte[] encode(BufferedImage bufferedImage, String string, float f2, boolean bl2) {
        ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(string, f2, bl2);
        return imageEncoder.encode(bufferedImage);
    }

    public static void writeBufferedImage(BufferedImage bufferedImage, String string, OutputStream outputStream) {
        ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(string);
        imageEncoder.encode(bufferedImage, outputStream);
    }

    public static void writeBufferedImage(BufferedImage bufferedImage, String string, OutputStream outputStream, float f2) {
        ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(string, f2);
        imageEncoder.encode(bufferedImage, outputStream);
    }

    public static void writeBufferedImage(BufferedImage bufferedImage, String string, OutputStream outputStream, boolean bl2) {
        ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(string, bl2);
        imageEncoder.encode(bufferedImage, outputStream);
    }

    public static void writeBufferedImage(BufferedImage bufferedImage, String string, OutputStream outputStream, float f2, boolean bl2) {
        ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(string, f2, bl2);
        imageEncoder.encode(bufferedImage, outputStream);
    }
}

