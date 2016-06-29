package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import java.awt.geom.*;
import java.awt.*;
import y.h.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;

public interface IZyNodeRealizer
{
    void addListener(final IZyNodeRealizerListener p0);
    
    void calcUnionRect(final Rectangle2D p0);
    
    Rectangle2D.Double getBoundingBox();
    
    double getCenterX();
    
    double getCenterY();
    
    Color getFillColor();
    
    double getHeight();
    
    ZyLabelContent getNodeContent();
    
    fj getRealizer();
    
    IRealizerUpdater getUpdater();
    
    ZyNodeData getUserData();
    
    double getWidth();
    
    double getX();
    
    double getY();
    
    boolean isSelected();
    
    boolean isVisible();
    
    int positionToRow(final double p0);
    
    void regenerate();
    
    void removeListener(final IZyNodeRealizerListener p0);
    
    void repaint();
    
    double rowToPosition(final int p0);
    
    void setFillColor(final Color p0);
    
    void setHeight(final double p0);
    
    void setLineColor(final Color p0);
    
    void setSelected(final boolean p0);
    
    void setUpdater(final IRealizerUpdater p0);
    
    void setUserData(final ZyNodeData p0);
    
    void setWidth(final double p0);
    
    void setX(final double p0);
    
    void setY(final double p0);
    
    void updateContentSelectionColor();
}
