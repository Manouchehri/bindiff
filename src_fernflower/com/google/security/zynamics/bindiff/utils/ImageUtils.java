package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.bindiff.Launcher;
import com.google.security.zynamics.bindiff.log.Logger;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

public class ImageUtils {
   public static Image getImage(String var0) {
      URL var1 = Launcher.class.getResource(var0);
      if(var1 == null) {
         Logger.logWarning((new StringBuilder(28 + String.valueOf(var0).length())).append("Image resource not found: \"").append(var0).append("\"").toString(), new Object[0]);
         return null;
      } else {
         return Toolkit.getDefaultToolkit().getImage(var1);
      }
   }

   public static ImageIcon getImageIcon(String var0) {
      return new ImageIcon(getImage(var0));
   }
}
