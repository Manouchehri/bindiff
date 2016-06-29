/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.encoders;

import java.util.Hashtable;
import org.jfree.chart.encoders.ImageEncoder;

public class ImageEncoderFactory {
    private static Hashtable encoders = null;

    private static void init() {
        encoders = new Hashtable();
        encoders.put("jpeg", "org.jfree.chart.encoders.SunJPEGEncoderAdapter");
        try {
            Class.forName("javax.imageio.ImageIO");
            Class.forName("org.jfree.chart.encoders.SunPNGEncoderAdapter");
            encoders.put("png", "org.jfree.chart.encoders.SunPNGEncoderAdapter");
            encoders.put("jpeg", "org.jfree.chart.encoders.SunJPEGEncoderAdapter");
            return;
        }
        catch (ClassNotFoundException var0) {
            encoders.put("png", "org.jfree.chart.encoders.KeypointPNGEncoderAdapter");
        }
    }

    public static void setImageEncoder(String string, String string2) {
        encoders.put(string, string2);
    }

    public static ImageEncoder newInstance(String string) {
        ImageEncoder imageEncoder = null;
        String string2 = (String)encoders.get(string);
        if (string2 == null) {
            throw new IllegalArgumentException(new StringBuffer().append("Unsupported image format - ").append(string).toString());
        }
        try {
            Class class_ = Class.forName(string2);
            return (ImageEncoder)class_.newInstance();
        }
        catch (Exception var3_4) {
            throw new IllegalArgumentException(var3_4.toString());
        }
    }

    public static ImageEncoder newInstance(String string, float f2) {
        ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(string);
        imageEncoder.setQuality(f2);
        return imageEncoder;
    }

    public static ImageEncoder newInstance(String string, boolean bl2) {
        ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(string);
        imageEncoder.setEncodingAlpha(bl2);
        return imageEncoder;
    }

    public static ImageEncoder newInstance(String string, float f2, boolean bl2) {
        ImageEncoder imageEncoder = ImageEncoderFactory.newInstance(string);
        imageEncoder.setQuality(f2);
        imageEncoder.setEncodingAlpha(bl2);
        return imageEncoder;
    }

    static {
        ImageEncoderFactory.init();
    }
}

