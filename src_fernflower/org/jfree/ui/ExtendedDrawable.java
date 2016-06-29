package org.jfree.ui;

import java.awt.Dimension;
import org.jfree.ui.Drawable;

public interface ExtendedDrawable extends Drawable {
   Dimension getPreferredSize();

   boolean isPreserveAspectRatio();
}
