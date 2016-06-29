package org.jfree.chart.encoders;

import java.awt.image.*;
import java.io.*;

public interface ImageEncoder
{
    byte[] encode(final BufferedImage p0);
    
    void encode(final BufferedImage p0, final OutputStream p1);
    
    float getQuality();
    
    void setQuality(final float p0);
    
    boolean isEncodingAlpha();
    
    void setEncodingAlpha(final boolean p0);
}
