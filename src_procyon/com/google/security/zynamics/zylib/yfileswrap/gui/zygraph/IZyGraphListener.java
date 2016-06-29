package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import java.awt.event.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;

public interface IZyGraphListener
{
    void edgeClicked(final Object p0, final MouseEvent p1, final double p2, final double p3);
    
    void edgeLabelEntered(final aA p0, final MouseEvent p1);
    
    void edgeLabelExited(final aA p0);
    
    void nodeClicked(final Object p0, final MouseEvent p1, final double p2, final double p3);
    
    void nodeEntered(final Object p0, final MouseEvent p1);
    
    void nodeHovered(final Object p0, final double p1, final double p2);
    
    void nodeLeft(final Object p0);
    
    void proximityBrowserNodeClicked(final ZyProximityNode p0, final MouseEvent p1, final double p2, final double p3);
}
