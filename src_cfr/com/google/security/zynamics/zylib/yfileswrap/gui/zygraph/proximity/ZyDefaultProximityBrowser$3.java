/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;

class ZyDefaultProximityBrowser$3
implements INodeCallback {
    final /* synthetic */ ZyDefaultProximityBrowser this$0;

    ZyDefaultProximityBrowser$3(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        this.this$0 = zyDefaultProximityBrowser;
    }

    public IterationMode next(ZyGraphNode zyGraphNode) {
        zyGraphNode.getRawNode().setVisible(true);
        return IterationMode.CONTINUE;
    }
}

