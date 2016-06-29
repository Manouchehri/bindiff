/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;

class ZyDefaultProximityBrowser$4
implements IEdgeCallback {
    final /* synthetic */ ZyDefaultProximityBrowser this$0;

    ZyDefaultProximityBrowser$4(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        this.this$0 = zyDefaultProximityBrowser;
    }

    public IterationMode nextEdge(ZyGraphEdge zyGraphEdge) {
        zyGraphEdge.getRawEdge().setVisible(true);
        return IterationMode.CONTINUE;
    }
}

