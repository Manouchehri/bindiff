package org.jfree.ui;

import java.awt.*;

public interface ExtendedDrawable extends Drawable
{
    Dimension getPreferredSize();
    
    boolean isPreserveAspectRatio();
}
