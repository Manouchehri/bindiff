/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import java.awt.Color;

public interface IViewNodeListener {
    public void changedBorderColor(IViewNode var1, Color var2);

    public void changedColor(IViewNode var1, Color var2);

    public void changedSelection(IViewNode var1, boolean var2);

    public void changedVisibility(IViewNode var1, boolean var2);

    public void heightChanged(IViewNode var1, double var2);

    public void widthChanged(IViewNode var1, double var2);

    public void xposChanged(IViewNode var1, double var2);

    public void yposChanged(IViewNode var1, double var2);
}

