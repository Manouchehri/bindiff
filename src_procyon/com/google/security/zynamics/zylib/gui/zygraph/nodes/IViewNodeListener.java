package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import java.awt.*;

public interface IViewNodeListener
{
    void changedBorderColor(final IViewNode p0, final Color p1);
    
    void changedColor(final IViewNode p0, final Color p1);
    
    void changedSelection(final IViewNode p0, final boolean p1);
    
    void changedVisibility(final IViewNode p0, final boolean p1);
    
    void heightChanged(final IViewNode p0, final double p1);
    
    void widthChanged(final IViewNode p0, final double p1);
    
    void xposChanged(final IViewNode p0, final double p1);
    
    void yposChanged(final IViewNode p0, final double p1);
}
