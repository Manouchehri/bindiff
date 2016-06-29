package com.google.security.zynamics.zylib.gui.zygraph.edges;

import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import java.util.*;
import java.awt.*;

public interface IViewEdge extends ICodeEdge, IGraphEdge
{
    void addBend(final double p0, final double p1);
    
    void addListener(final IViewEdgeListener p0);
    
    void clearBends();
    
    int getBendCount();
    
    List getBends();
    
    Color getColor();
    
    int getId();
    
    EdgeType getType();
    
    double getX1();
    
    double getX2();
    
    double getY1();
    
    double getY2();
    
    void insertBend(final int p0, final double p1, final double p2);
    
    boolean isSelected();
    
    boolean isVisible();
    
    void removeBend(final int p0);
    
    void removeListener(final IViewEdgeListener p0);
    
    void setColor(final Color p0);
    
    void setEdgeType(final EdgeType p0);
    
    void setId(final int p0);
    
    void setSelected(final boolean p0);
    
    void setVisible(final boolean p0);
    
    void setX1(final double p0);
    
    void setX2(final double p0);
    
    void setY1(final double p0);
    
    void setY2(final double p0);
}
