package com.google.security.zynamics.zylib.gui.JHexPanel;

import java.awt.*;

public interface IColormap
{
    boolean colorize(final byte[] p0, final long p1);
    
    Color getBackgroundColor(final byte[] p0, final long p1);
    
    Color getForegroundColor(final byte[] p0, final long p1);
}
