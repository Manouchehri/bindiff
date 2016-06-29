package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.awt.geom.*;

public interface IViewableNode
{
    void calcUnionRect(final Rectangle2D p0);
    
    Rectangle2D.Double getBoundingBox();
}
