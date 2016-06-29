package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;

public interface ISnapshotListener
{
    void addedNode(final ZyGraphNode p0);
    
    void finished();
    
    void removedNode(final ZyGraphNode p0);
}
