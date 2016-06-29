/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;

public interface IZyNodeRealizerListener {
    public void changedLocation(IZyNodeRealizer var1, double var2, double var4);

    public void changedSelection(IZyNodeRealizer var1);

    public void changedSize(IZyNodeRealizer var1, double var2, double var4);

    public void changedVisibility(IZyNodeRealizer var1);

    public void regenerated(IZyNodeRealizer var1);
}

