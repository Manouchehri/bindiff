package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;

public interface ISearchableTreeNode
{
    ZyGraphNode getGraphNode();
    
    ZyGraphNode getGraphNode(final ESide p0);
}
