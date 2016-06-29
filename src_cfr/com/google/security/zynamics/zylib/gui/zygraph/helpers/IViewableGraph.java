/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;

public interface IViewableGraph {
    public void iterateInvisible(INodeCallback var1);

    public void iterateVisible(INodeCallback var1);
}

