package org.jfree.chart.encoders;

import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class SunPNGEncoderAdapter implements ImageEncoder
{
    public float getQuality() {
        return 0.0f;
    }
    
    public void setQuality(final float n) {
    }
    
    public boolean isEncodingAlpha() {
        return false;
    }
    
    public void setEncodingAlpha(final boolean b) {
    }
    
    public byte[] encode(final BufferedImage bufferedImage) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.encode(bufferedImage, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    
    public void encode(final BufferedImage bufferedImage, final OutputStream outputStream) {
        if (bufferedImage == null) {
            throw new IllegalArgumentException("Null 'image' argument.");
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("Null 'outputStream' argument.");
        }
        ImageIO.write(bufferedImage, "png", outputStream);
    }
}
