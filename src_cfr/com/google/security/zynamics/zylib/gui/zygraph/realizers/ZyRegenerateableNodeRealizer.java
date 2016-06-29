/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyRegenerateableRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;

public class ZyRegenerateableNodeRealizer
implements IZyRegenerateableRealizer {
    private final IZyNodeRealizer realizer;

    public ZyRegenerateableNodeRealizer(IZyNodeRealizer iZyNodeRealizer) {
        this.realizer = (IZyNodeRealizer)Preconditions.checkNotNull(iZyNodeRealizer, "Error: Node realizer can't be null.");
    }

    @Override
    public void regenerate() {
        this.realizer.regenerate();
    }

    @Override
    public void repaint() {
        this.realizer.repaint();
    }
}

