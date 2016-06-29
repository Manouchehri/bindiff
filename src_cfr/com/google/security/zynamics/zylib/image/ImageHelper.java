/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.image;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;

public class ImageHelper {
    public static Image filterImage(Image image, ImageFilter imageFilter) {
        FilteredImageSource filteredImageSource = new FilteredImageSource(image.getSource(), imageFilter);
        return Toolkit.getDefaultToolkit().createImage(filteredImageSource);
    }
}

