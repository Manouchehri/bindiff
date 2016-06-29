/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.wrappers.ViewableGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$1;
import java.util.Set;

class ZyDefaultProximityBrowser$InternalVisibilityListener
implements IZyGraphVisibilityListener {
    final /* synthetic */ ZyDefaultProximityBrowser this$0;

    private ZyDefaultProximityBrowser$InternalVisibilityListener(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        this.this$0 = zyDefaultProximityBrowser;
    }

    @Override
    public void nodeDeleted() {
        ZyDefaultProximityBrowser.access$700(this.this$0).clear();
        Set set = GraphHelpers.getVisibleNodes(ViewableGraph.wrap(ZyDefaultProximityBrowser.access$500(this.this$0)));
        ZyDefaultProximityBrowser.access$800(this.this$0, set);
    }

    @Override
    public void visibilityChanged() {
        if (ZyDefaultProximityBrowser.access$300(this.this$0)) {
            ZyDefaultProximityBrowser.access$902(this.this$0, false);
        }
        Set set = GraphHelpers.getVisibleNodes(ViewableGraph.wrap(ZyDefaultProximityBrowser.access$500(this.this$0)));
        ZyDefaultProximityBrowser.access$800(this.this$0, set);
        ZyDefaultProximityBrowser.access$902(this.this$0, true);
    }

    /* synthetic */ ZyDefaultProximityBrowser$InternalVisibilityListener(ZyDefaultProximityBrowser zyDefaultProximityBrowser, ZyDefaultProximityBrowser$1 zyDefaultProximityBrowser$1) {
        this(zyDefaultProximityBrowser);
    }
}

