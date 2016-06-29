/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.edges;

import com.google.security.zynamics.zylib.disassembly.ICodeEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdgeListener;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import java.awt.Color;
import java.util.List;

public interface IViewEdge
extends ICodeEdge,
IGraphEdge {
    public void addBend(double var1, double var3);

    public void addListener(IViewEdgeListener var1);

    public void clearBends();

    public int getBendCount();

    public List getBends();

    public Color getColor();

    public int getId();

    @Override
    public EdgeType getType();

    public double getX1();

    public double getX2();

    public double getY1();

    public double getY2();

    public void insertBend(int var1, double var2, double var4);

    public boolean isSelected();

    public boolean isVisible();

    public void removeBend(int var1);

    public void removeListener(IViewEdgeListener var1);

    public void setColor(Color var1);

    public void setEdgeType(EdgeType var1);

    public void setId(int var1);

    public void setSelected(boolean var1);

    public void setVisible(boolean var1);

    public void setX1(double var1);

    public void setX2(double var1);

    public void setY1(double var1);

    public void setY2(double var1);
}

