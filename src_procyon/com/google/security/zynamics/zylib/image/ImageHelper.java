package com.google.security.zynamics.zylib.image;

import java.awt.*;
import java.awt.image.*;

public class ImageHelper
{
    public static Image filterImage(final Image image, final ImageFilter imageFilter) {
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), imageFilter));
    }
}
