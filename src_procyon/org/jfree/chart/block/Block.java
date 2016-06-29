package org.jfree.chart.block;

import java.awt.*;
import org.jfree.ui.*;
import java.awt.geom.*;

public interface Block extends Drawable
{
    String getID();
    
    void setID(final String p0);
    
    Size2D arrange(final Graphics2D p0);
    
    Size2D arrange(final Graphics2D p0, final RectangleConstraint p1);
    
    Rectangle2D getBounds();
    
    void setBounds(final Rectangle2D p0);
    
    Object draw(final Graphics2D p0, final Rectangle2D p1, final Object p2);
}
