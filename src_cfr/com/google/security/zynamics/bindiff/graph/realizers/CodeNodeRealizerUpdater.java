/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;

public final class CodeNodeRealizerUpdater
implements IRealizerUpdater {
    @Override
    public void dispose() {
    }

    @Override
    public void generateContent(IZyNodeRealizer iZyNodeRealizer, ZyLabelContent zyLabelContent) {
        zyLabelContent = iZyNodeRealizer.getNodeContent();
    }

    @Override
    public void setRealizer(IZyNodeRealizer iZyNodeRealizer) {
    }
}

