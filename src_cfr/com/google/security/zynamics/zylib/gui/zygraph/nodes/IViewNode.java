/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import java.awt.Color;
import java.util.List;

public interface IViewNode {
    public void addListener(IViewNodeListener var1);

    public Color getBorderColor();

    public Color getColor();

    public double getHeight();

    public int getId();

    public List getIncomingEdges();

    public List getOutgoingEdges();

    public IGroupNode getParentGroup();

    public double getWidth();

    public double getX();

    public double getY();

    public boolean isSelected();

    public boolean isVisible();

    public void removeListener(IViewNodeListener var1);

    public void setBorderColor(Color var1);

    public void setColor(Color var1);

    public void setHeight(double var1);

    public void setId(int var1);

    public void setSelected(boolean var1);

    public void setVisible(boolean var1);

    public void setWidth(double var1);

    public void setX(double var1);

    public void setY(double var1);
}

