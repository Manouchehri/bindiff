package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;

public final class CTooltipUpdater
{
    public static boolean isProximityNode(final AbstractZyGraph abstractZyGraph, final q q) {
        Preconditions.checkNotNull(abstractZyGraph, (Object)"Graph argument can not be null");
        Preconditions.checkNotNull(q, (Object)"Node argument can not be null");
        return abstractZyGraph.getGraph().t(q) instanceof ZyProximityNodeRealizer;
    }
    
    public static String updateEdgeTooltip(final AbstractZyGraph abstractZyGraph, final d d) {
        Preconditions.checkNotNull(abstractZyGraph, (Object)"Graph argument can not be null");
        Preconditions.checkNotNull(d, (Object)"Edge argument can not be null");
        if (abstractZyGraph.getView() instanceof ZyGraph2DView && ((ZyGraph2DView)abstractZyGraph.getView()).isEdgeSloppyPaintMode()) {
            final String tooltip = TooltipGenerator.createTooltip(abstractZyGraph, d);
            abstractZyGraph.getView().setToolTipText(tooltip);
            return tooltip;
        }
        return null;
    }
    
    public static String updateNodeTooltip(final AbstractZyGraph abstractZyGraph, final q q) {
        Preconditions.checkNotNull(abstractZyGraph, (Object)"Graph argument can not be null");
        Preconditions.checkNotNull(q, (Object)"Node argument can not be null");
        if (isProximityNode(abstractZyGraph, q)) {
            return TooltipGenerator.createTooltip(abstractZyGraph, q);
        }
        if (abstractZyGraph.getView() instanceof ZyGraph2DView && ((ZyGraph2DView)abstractZyGraph.getView()).isNodeSloppyPaintMode()) {
            return TooltipGenerator.createTooltip(abstractZyGraph, q);
        }
        return null;
    }
}
