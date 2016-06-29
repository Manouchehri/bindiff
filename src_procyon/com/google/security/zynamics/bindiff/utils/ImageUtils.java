package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.bindiff.*;
import com.google.security.zynamics.bindiff.log.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;

public class ImageUtils
{
    public static Image getImage(final String s) {
        final URL resource = Launcher.class.getResource(s);
        if (resource == null) {
            Logger.logWarning(new StringBuilder(28 + String.valueOf(s).length()).append("Image resource not found: \"").append(s).append("\"").toString(), new Object[0]);
            return null;
        }
        return Toolkit.getDefaultToolkit().getImage(resource);
    }
    
    public static ImageIcon getImageIcon(final String s) {
        return new ImageIcon(getImage(s));
    }
}
