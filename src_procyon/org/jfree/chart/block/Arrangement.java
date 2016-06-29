package org.jfree.chart.block;

import java.awt.*;
import org.jfree.ui.*;

public interface Arrangement
{
    void add(final Block p0, final Object p1);
    
    Size2D arrange(final BlockContainer p0, final Graphics2D p1, final RectangleConstraint p2);
    
    void clear();
}
