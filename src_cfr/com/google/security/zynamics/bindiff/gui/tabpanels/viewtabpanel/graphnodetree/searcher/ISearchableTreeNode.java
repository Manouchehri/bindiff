/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

public interface ISearchableTreeNode {
    public ZyGraphNode getGraphNode();

    public ZyGraphNode getGraphNode(ESide var1);
}

