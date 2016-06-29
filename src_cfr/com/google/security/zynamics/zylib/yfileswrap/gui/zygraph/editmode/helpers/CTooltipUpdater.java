/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.TooltipGenerator;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyProximityNodeRealizer;
import y.c.d;
import y.c.q;
import y.h.bu;
import y.h.ch;
import y.h.fj;

public final class CTooltipUpdater {
    public static boolean isProximityNode(AbstractZyGraph abstractZyGraph, q q2) {
        Preconditions.checkNotNull(abstractZyGraph, "Graph argument can not be null");
        Preconditions.checkNotNull(q2, "Node argument can not be null");
        return abstractZyGraph.getGraph().t(q2) instanceof ZyProximityNodeRealizer;
    }

    public static String updateEdgeTooltip(AbstractZyGraph abstractZyGraph, d d2) {
        Preconditions.checkNotNull(abstractZyGraph, "Graph argument can not be null");
        Preconditions.checkNotNull(d2, "Edge argument can not be null");
        if (!(abstractZyGraph.getView() instanceof ZyGraph2DView)) return null;
        if (!((ZyGraph2DView)abstractZyGraph.getView()).isEdgeSloppyPaintMode()) return null;
        String string = TooltipGenerator.createTooltip(abstractZyGraph, d2);
        abstractZyGraph.getView().setToolTipText(string);
        return string;
    }

    public static String updateNodeTooltip(AbstractZyGraph abstractZyGraph, q q2) {
        Preconditions.checkNotNull(abstractZyGraph, "Graph argument can not be null");
        Preconditions.checkNotNull(q2, "Node argument can not be null");
        if (CTooltipUpdater.isProximityNode(abstractZyGraph, q2)) {
            return TooltipGenerator.createTooltip(abstractZyGraph, q2);
        }
        if (!(abstractZyGraph.getView() instanceof ZyGraph2DView)) return null;
        if (!((ZyGraph2DView)abstractZyGraph.getView()).isNodeSloppyPaintMode()) return null;
        return TooltipGenerator.createTooltip(abstractZyGraph, q2);
    }
}

