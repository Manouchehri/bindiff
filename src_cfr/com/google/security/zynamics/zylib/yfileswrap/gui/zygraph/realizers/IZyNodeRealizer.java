/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import y.h.fj;

public interface IZyNodeRealizer {
    public void addListener(IZyNodeRealizerListener var1);

    public void calcUnionRect(Rectangle2D var1);

    public Rectangle2D.Double getBoundingBox();

    public double getCenterX();

    public double getCenterY();

    public Color getFillColor();

    public double getHeight();

    public ZyLabelContent getNodeContent();

    public fj getRealizer();

    public IRealizerUpdater getUpdater();

    public ZyNodeData getUserData();

    public double getWidth();

    public double getX();

    public double getY();

    public boolean isSelected();

    public boolean isVisible();

    public int positionToRow(double var1);

    public void regenerate();

    public void removeListener(IZyNodeRealizerListener var1);

    public void repaint();

    public double rowToPosition(int var1);

    public void setFillColor(Color var1);

    public void setHeight(double var1);

    public void setLineColor(Color var1);

    public void setSelected(boolean var1);

    public void setUpdater(IRealizerUpdater var1);

    public void setUserData(ZyNodeData var1);

    public void setWidth(double var1);

    public void setX(double var1);

    public void setY(double var1);

    public void updateContentSelectionColor();
}

