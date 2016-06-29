/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Comparator;

class AbstractZyGraph$1
implements Comparator {
    final /* synthetic */ AbstractZyGraph this$0;

    AbstractZyGraph$1(AbstractZyGraph abstractZyGraph) {
        this.this$0 = abstractZyGraph;
    }

    private boolean isInsideGroup(IViewNode iViewNode, IGroupNode iGroupNode) {
        IGroupNode iGroupNode2 = iViewNode.getParentGroup();
        if (iGroupNode2 == null) {
            return false;
        }
        if (iGroupNode2 != iGroupNode) return this.isInsideGroup(iViewNode, iGroupNode.getParentGroup());
        return true;
    }

    public int compare(ZyGraphNode zyGraphNode, ZyGraphNode zyGraphNode2) {
        IViewNode iViewNode = zyGraphNode.getRawNode();
        IViewNode iViewNode2 = zyGraphNode2.getRawNode();
        if (iViewNode instanceof IGroupNode && iViewNode2 instanceof IGroupNode) {
            if (this.isInsideGroup(iViewNode2, (IGroupNode)iViewNode)) {
                return 1;
            }
            if (!this.isInsideGroup(iViewNode, (IGroupNode)iViewNode2)) return 0;
            return -1;
        }
        if (iViewNode instanceof IGroupNode) {
            if (!this.isInsideGroup(iViewNode2, (IGroupNode)iViewNode)) return 0;
            return 1;
        }
        if (!(zyGraphNode2 instanceof IGroupNode)) return 0;
        if (!this.isInsideGroup(iViewNode, (IGroupNode)iViewNode2)) return 0;
        return 1;
    }
}

