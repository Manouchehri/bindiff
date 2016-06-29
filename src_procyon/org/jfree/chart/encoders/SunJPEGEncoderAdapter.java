package org.jfree.chart.encoders;

import java.io.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.metadata.*;
import javax.imageio.*;
import javax.imageio.stream.*;

public class SunJPEGEncoderAdapter implements ImageEncoder
{
    private float quality;
    
    public SunJPEGEncoderAdapter() {
        this.quality = 0.95f;
    }
    
    public float getQuality() {
        return this.quality;
    }
    
    public void setQuality(final float quality) {
        if (quality < 0.0f || quality > 1.0f) {
            throw new IllegalArgumentException("The 'quality' must be in the range 0.0f to 1.0f");
        }
        this.quality = quality;
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
        final ImageWriter imageWriter = ImageIO.getImageWritersByFormatName("jpeg").next();
        final ImageWriteParam defaultWriteParam = imageWriter.getDefaultWriteParam();
        defaultWriteParam.setCompressionMode(2);
        defaultWriteParam.setCompressionQuality(this.quality);
        final ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
        imageWriter.setOutput(imageOutputStream);
        imageWriter.write(null, new IIOImage(bufferedImage, null, null), defaultWriteParam);
        imageOutputStream.flush();
        imageWriter.dispose();
        imageOutputStream.close();
    }
}
