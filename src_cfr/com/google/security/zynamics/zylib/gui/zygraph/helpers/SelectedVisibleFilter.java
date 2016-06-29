/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.grouping.GroupHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Collection;

public class SelectedVisibleFilter
implements ICollectionFilter {
    public static Collection filter(Collection collection) {
        return CollectionHelpers.filter(collection, new SelectedVisibleFilter());
    }

    public boolean qualifies(ZyGraphNode zyGraphNode) {
        IViewNode iViewNode = zyGraphNode.getRawNode();
        if (iViewNode.getParentGroup() == null) return true;
        if (GroupHelpers.isExpanded(iViewNode.getParentGroup())) return true;
        return false;
    }
}

