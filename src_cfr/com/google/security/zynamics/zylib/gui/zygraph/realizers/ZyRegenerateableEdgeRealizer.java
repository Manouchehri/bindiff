/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEdgeRealizer;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyRegenerateableRealizer;

public class ZyRegenerateableEdgeRealizer
implements IZyRegenerateableRealizer {
    private final IZyEdgeRealizer m_realizer;

    public ZyRegenerateableEdgeRealizer(IZyEdgeRealizer iZyEdgeRealizer) {
        Preconditions.checkNotNull(iZyEdgeRealizer, "Error: Edge realizer can't be null.");
        this.m_realizer = iZyEdgeRealizer;
    }

    @Override
    public void regenerate() {
        this.m_realizer.regenerate();
    }

    @Override
    public void repaint() {
        this.m_realizer.repaint();
    }
}

