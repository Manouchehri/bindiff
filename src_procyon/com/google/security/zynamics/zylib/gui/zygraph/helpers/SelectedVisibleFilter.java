package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.util.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.grouping.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;

public class SelectedVisibleFilter implements ICollectionFilter
{
    public static Collection filter(final Collection collection) {
        return CollectionHelpers.filter(collection, new SelectedVisibleFilter());
    }
    
    public boolean qualifies(final ZyGraphNode zyGraphNode) {
        final IViewNode rawNode = zyGraphNode.getRawNode();
        return rawNode.getParentGroup() == null || GroupHelpers.isExpanded(rawNode.getParentGroup());
    }
}
