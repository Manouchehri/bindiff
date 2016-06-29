package org.jfree.chart.encoders;

import java.awt.image.*;
import com.keypoint.*;
import java.awt.*;
import java.io.*;

public class KeypointPNGEncoderAdapter implements ImageEncoder
{
    private int quality;
    private boolean encodingAlpha;
    
    public KeypointPNGEncoderAdapter() {
        this.quality = 9;
        this.encodingAlpha = false;
    }
    
    public float getQuality() {
        return this.quality;
    }
    
    public void setQuality(final float n) {
        this.quality = (int)n;
    }
    
    public boolean isEncodingAlpha() {
        return this.encodingAlpha;
    }
    
    public void setEncodingAlpha(final boolean encodingAlpha) {
        this.encodingAlpha = encodingAlpha;
    }
    
    public byte[] encode(final BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            throw new IllegalArgumentException("Null 'image' argument.");
        }
        return new PngEncoder(bufferedImage, this.encodingAlpha, 0, this.quality).pngEncode();
    }
    
    public void encode(final BufferedImage bufferedImage, final OutputStream outputStream) {
        if (bufferedImage == null) {
            throw new IllegalArgumentException("Null 'image' argument.");
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("Null 'outputStream' argument.");
        }
        outputStream.write(new PngEncoder(bufferedImage, this.encodingAlpha, 0, this.quality).pngEncode());
    }
}
