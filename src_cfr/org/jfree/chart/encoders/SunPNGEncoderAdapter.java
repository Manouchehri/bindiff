/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.encoders;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import org.jfree.chart.encoders.ImageEncoder;

public class SunPNGEncoderAdapter
implements ImageEncoder {
    @Override
    public float getQuality() {
        return 0.0f;
    }

    @Override
    public void setQuality(float f2) {
    }

    @Override
    public boolean isEncodingAlpha() {
        return false;
    }

    @Override
    public void setEncodingAlpha(boolean bl2) {
    }

    @Override
    public byte[] encode(BufferedImage bufferedImage) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.encode(bufferedImage, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public void encode(BufferedImage bufferedImage, OutputStream outputStream) {
        if (bufferedImage == null) {
            throw new IllegalArgumentException("Null 'image' argument.");
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("Null 'outputStream' argument.");
        }
        ImageIO.write((RenderedImage)bufferedImage, "png", outputStream);
    }
}

