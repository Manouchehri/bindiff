/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.encoders;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

public interface ImageEncoder {
    public byte[] encode(BufferedImage var1);

    public void encode(BufferedImage var1, OutputStream var2);

    public float getQuality();

    public void setQuality(float var1);

    public boolean isEncodingAlpha();

    public void setEncodingAlpha(boolean var1);
}

