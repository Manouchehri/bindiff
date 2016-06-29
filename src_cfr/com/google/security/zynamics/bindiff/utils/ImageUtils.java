/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.bindiff.Launcher;
import com.google.security.zynamics.bindiff.log.Logger;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

public class ImageUtils {
    public static Image getImage(String string) {
        URL uRL = Launcher.class.getResource(string);
        if (uRL != null) return Toolkit.getDefaultToolkit().getImage(uRL);
        Logger.logWarning(new StringBuilder(28 + String.valueOf(string).length()).append("Image resource not found: \"").append(string).append("\"").toString(), new Object[0]);
        return null;
    }

    public static ImageIcon getImageIcon(String string) {
        return new ImageIcon(ImageUtils.getImage(string));
    }
}

