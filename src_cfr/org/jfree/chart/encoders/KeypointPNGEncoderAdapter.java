/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.encoders;

import com.keypoint.PngEncoder;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import org.jfree.chart.encoders.ImageEncoder;

public class KeypointPNGEncoderAdapter
implements ImageEncoder {
    private int quality = 9;
    private boolean encodingAlpha = false;

    @Override
    public float getQuality() {
        return this.quality;
    }

    @Override
    public void setQuality(float f2) {
        this.quality = (int)f2;
    }

    @Override
    public boolean isEncodingAlpha() {
        return this.encodingAlpha;
    }

    @Override
    public void setEncodingAlpha(boolean bl2) {
        this.encodingAlpha = bl2;
    }

    @Override
    public byte[] encode(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            throw new IllegalArgumentException("Null 'image' argument.");
        }
        PngEncoder pngEncoder = new PngEncoder(bufferedImage, this.encodingAlpha, 0, this.quality);
        return pngEncoder.pngEncode();
    }

    @Override
    public void encode(BufferedImage bufferedImage, OutputStream outputStream) {
        if (bufferedImage == null) {
            throw new IllegalArgumentException("Null 'image' argument.");
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("Null 'outputStream' argument.");
        }
        PngEncoder pngEncoder = new PngEncoder(bufferedImage, this.encodingAlpha, 0, this.quality);
        outputStream.write(pngEncoder.pngEncode());
    }
}

