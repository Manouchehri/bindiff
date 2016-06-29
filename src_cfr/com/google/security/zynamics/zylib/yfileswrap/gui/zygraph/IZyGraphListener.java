/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;
import y.h.aA;

public interface IZyGraphListener {
    public void edgeClicked(Object var1, MouseEvent var2, double var3, double var5);

    public void edgeLabelEntered(aA var1, MouseEvent var2);

    public void edgeLabelExited(aA var1);

    public void nodeClicked(Object var1, MouseEvent var2, double var3, double var5);

    public void nodeEntered(Object var1, MouseEvent var2);

    public void nodeHovered(Object var1, double var2, double var4);

    public void nodeLeft(Object var1);

    public void proximityBrowserNodeClicked(ZyProximityNode var1, MouseEvent var2, double var3, double var5);
}

