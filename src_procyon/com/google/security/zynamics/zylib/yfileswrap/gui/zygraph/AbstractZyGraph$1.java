package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import java.util.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;

class AbstractZyGraph$1 implements Comparator
{
    final /* synthetic */ AbstractZyGraph this$0;
    
    AbstractZyGraph$1(final AbstractZyGraph this$0) {
        this.this$0 = this$0;
    }
    
    private boolean isInsideGroup(final IViewNode viewNode, final IGroupNode groupNode) {
        final IGroupNode parentGroup = viewNode.getParentGroup();
        return parentGroup != null && (parentGroup == groupNode || this.isInsideGroup(viewNode, groupNode.getParentGroup()));
    }
    
    public int compare(final ZyGraphNode zyGraphNode, final ZyGraphNode zyGraphNode2) {
        final IViewNode rawNode = zyGraphNode.getRawNode();
        final IViewNode rawNode2 = zyGraphNode2.getRawNode();
        if (rawNode instanceof IGroupNode && rawNode2 instanceof IGroupNode) {
            if (this.isInsideGroup(rawNode2, (IGroupNode)rawNode)) {
                return 1;
            }
            if (this.isInsideGroup(rawNode, (IGroupNode)rawNode2)) {
                return -1;
            }
            return 0;
        }
        else {
            if (rawNode instanceof IGroupNode) {
                return this.isInsideGroup(rawNode2, (IGroupNode)rawNode) ? 1 : 0;
            }
            return (zyGraphNode2 instanceof IGroupNode && this.isInsideGroup(rawNode, (IGroupNode)rawNode2)) ? 1 : 0;
        }
    }
}
