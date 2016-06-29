/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;

public interface IZyEdgeRealizerListener {
    public void addedBend(double var1, double var3);

    public void bendChanged(int var1, double var2, double var4);

    public void changedLocation(ZyEdgeRealizer var1);

    public void changedVisibility(ZyEdgeRealizer var1);

    public void clearedBends();

    public void insertedBend(int var1, double var2, double var4);

    public void regenerated(ZyEdgeRealizer var1);

    public void removedBend(ZyEdgeRealizer var1, int var2);
}

