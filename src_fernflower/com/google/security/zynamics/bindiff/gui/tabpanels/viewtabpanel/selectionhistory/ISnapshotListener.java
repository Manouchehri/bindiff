package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

public interface ISnapshotListener {
   void addedNode(ZyGraphNode var1);

   void finished();

   void removedNode(ZyGraphNode var1);
}
