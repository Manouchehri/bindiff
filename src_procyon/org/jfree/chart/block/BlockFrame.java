package org.jfree.chart.block;

import org.jfree.ui.*;
import java.awt.*;
import java.awt.geom.*;

public interface BlockFrame
{
    RectangleInsets getInsets();
    
    void draw(final Graphics2D p0, final Rectangle2D p1);
}
