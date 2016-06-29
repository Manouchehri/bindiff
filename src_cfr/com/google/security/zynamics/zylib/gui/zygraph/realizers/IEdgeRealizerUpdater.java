/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;

public interface IEdgeRealizerUpdater {
    public ZyLabelContent generateContent(ZyEdgeRealizer var1);

    public void setRealizer(ZyEdgeRealizer var1);
}

