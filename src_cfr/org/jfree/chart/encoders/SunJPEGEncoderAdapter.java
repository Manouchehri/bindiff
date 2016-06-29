/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.encoders;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageOutputStream;
import org.jfree.chart.encoders.ImageEncoder;

public class SunJPEGEncoderAdapter
implements ImageEncoder {
    private float quality = 0.95f;

    @Override
    public float getQuality() {
        return this.quality;
    }

    @Override
    public void setQuality(float f2) {
        if (f2 < 0.0f) throw new IllegalArgumentException("The 'quality' must be in the range 0.0f to 1.0f");
        if (f2 > 1.0f) {
            throw new IllegalArgumentException("The 'quality' must be in the range 0.0f to 1.0f");
        }
        this.quality = f2;
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
        Iterator<ImageWriter> iterator = ImageIO.getImageWritersByFormatName("jpeg");
        ImageWriter imageWriter = iterator.next();
        ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
        imageWriteParam.setCompressionMode(2);
        imageWriteParam.setCompressionQuality(this.quality);
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
        imageWriter.setOutput(imageOutputStream);
        imageWriter.write(null, new IIOImage(bufferedImage, null, null), imageWriteParam);
        imageOutputStream.flush();
        imageWriter.dispose();
        imageOutputStream.close();
    }
}

