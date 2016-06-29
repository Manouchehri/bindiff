package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.wrappers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.settings.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import java.util.*;
import y.c.*;

class ZyDefaultProximityBrowser$InternalVisibilityListener implements IZyGraphVisibilityListener
{
    final /* synthetic */ ZyDefaultProximityBrowser this$0;
    
    private ZyDefaultProximityBrowser$InternalVisibilityListener(final ZyDefaultProximityBrowser this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void nodeDeleted() {
        this.this$0.m_lastShown.clear();
        this.this$0.updateProximityBrowsing(GraphHelpers.getVisibleNodes(ViewableGraph.wrap(this.this$0.m_graph)));
    }
    
    @Override
    public void visibilityChanged() {
        if (this.this$0.m_changedProximityBrowsing) {
            this.this$0.m_doLayout = false;
        }
        this.this$0.updateProximityBrowsing(GraphHelpers.getVisibleNodes(ViewableGraph.wrap(this.this$0.m_graph)));
        this.this$0.m_doLayout = true;
    }
}
