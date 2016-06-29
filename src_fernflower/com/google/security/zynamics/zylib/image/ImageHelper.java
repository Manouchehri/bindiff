package com.google.security.zynamics.zylib.image;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;

public class ImageHelper {
   public static Image filterImage(Image var0, ImageFilter var1) {
      FilteredImageSource var2 = new FilteredImageSource(var0.getSource(), var1);
      return Toolkit.getDefaultToolkit().createImage(var2);
   }
}
