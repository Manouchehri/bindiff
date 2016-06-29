package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.settings.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import java.util.*;
import y.c.*;

class ZyDefaultProximityBrowser$InternalSettingsListener implements IProximitySettingsListener
{
    final /* synthetic */ ZyDefaultProximityBrowser this$0;
    
    private ZyDefaultProximityBrowser$InternalSettingsListener(final ZyDefaultProximityBrowser this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void changedProximityBrowsing(final boolean b) {
        this.this$0.m_changedProximityBrowsing = true;
        this.this$0.setActive();
        this.this$0.m_changedProximityBrowsing = false;
        this.this$0.m_graph.updateViews();
    }
    
    @Override
    public void changedProximityBrowsingDepth(final int n, final int n2) {
        if (this.this$0.m_graph.getSettings().getProximitySettings().getProximityBrowsing()) {
            this.this$0.restartProximityBrowsing();
        }
    }
    
    @Override
    public void changedProximityBrowsingFrozen(final boolean b) {
    }
    
    @Override
    public void changedProximityBrowsingPreview(final boolean b) {
    }
}
