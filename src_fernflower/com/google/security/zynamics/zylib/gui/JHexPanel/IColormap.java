package com.google.security.zynamics.zylib.gui.JHexPanel;

import java.awt.Color;

public interface IColormap {
   boolean colorize(byte[] var1, long var2);

   Color getBackgroundColor(byte[] var1, long var2);

   Color getForegroundColor(byte[] var1, long var2);
}
