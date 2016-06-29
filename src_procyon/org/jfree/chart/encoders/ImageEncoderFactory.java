package org.jfree.chart.encoders;

import java.util.*;

public class ImageEncoderFactory
{
    private static Hashtable encoders;
    
    private static void init() {
        (ImageEncoderFactory.encoders = new Hashtable()).put("jpeg", "org.jfree.chart.encoders.SunJPEGEncoderAdapter");
        try {
            Class.forName("javax.imageio.ImageIO");
            Class.forName("org.jfree.chart.encoders.SunPNGEncoderAdapter");
            ImageEncoderFactory.encoders.put("png", "org.jfree.chart.encoders.SunPNGEncoderAdapter");
            ImageEncoderFactory.encoders.put("jpeg", "org.jfree.chart.encoders.SunJPEGEncoderAdapter");
        }
        catch (ClassNotFoundException ex) {
            ImageEncoderFactory.encoders.put("png", "org.jfree.chart.encoders.KeypointPNGEncoderAdapter");
        }
    }
    
    public static void setImageEncoder(final String s, final String s2) {
        ImageEncoderFactory.encoders.put(s, s2);
    }
    
    public static ImageEncoder newInstance(final String s) {
        final String s2 = ImageEncoderFactory.encoders.get(s);
        if (s2 == null) {
            throw new IllegalArgumentException("Unsupported image format - " + s);
        }
        ImageEncoder imageEncoder;
        try {
            imageEncoder = (ImageEncoder)Class.forName(s2).newInstance();
        }
        catch (Exception ex) {
            throw new IllegalArgumentException(ex.toString());
        }
        return imageEncoder;
    }
    
    public static ImageEncoder newInstance(final String s, final float quality) {
        final ImageEncoder instance = newInstance(s);
        instance.setQuality(quality);
        return instance;
    }
    
    public static ImageEncoder newInstance(final String s, final boolean encodingAlpha) {
        final ImageEncoder instance = newInstance(s);
        instance.setEncodingAlpha(encodingAlpha);
        return instance;
    }
    
    public static ImageEncoder newInstance(final String s, final float quality, final boolean encodingAlpha) {
        final ImageEncoder instance = newInstance(s);
        instance.setQuality(quality);
        instance.setEncodingAlpha(encodingAlpha);
        return instance;
    }
    
    static {
        ImageEncoderFactory.encoders = null;
        init();
    }
}
