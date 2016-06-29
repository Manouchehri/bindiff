package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import java.awt.*;
import java.util.*;

public interface IViewNode
{
    void addListener(final IViewNodeListener p0);
    
    Color getBorderColor();
    
    Color getColor();
    
    double getHeight();
    
    int getId();
    
    List getIncomingEdges();
    
    List getOutgoingEdges();
    
    IGroupNode getParentGroup();
    
    double getWidth();
    
    double getX();
    
    double getY();
    
    boolean isSelected();
    
    boolean isVisible();
    
    void removeListener(final IViewNodeListener p0);
    
    void setBorderColor(final Color p0);
    
    void setColor(final Color p0);
    
    void setHeight(final double p0);
    
    void setId(final int p0);
    
    void setSelected(final boolean p0);
    
    void setVisible(final boolean p0);
    
    void setWidth(final double p0);
    
    void setX(final double p0);
    
    void setY(final double p0);
}
