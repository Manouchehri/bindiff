/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;

public interface IRealizerUpdater {
    public void dispose();

    public void generateContent(IZyNodeRealizer var1, ZyLabelContent var2);

    public void setRealizer(IZyNodeRealizer var1);
}

