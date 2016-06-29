package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.grouping;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import y.h.*;
import y.c.*;

public class GroupHelpers
{
    public static void expandParents(final IViewNode viewNode) {
        if (viewNode.getParentGroup() != null) {
            expandParents(viewNode.getParentGroup());
        }
        if (viewNode instanceof IGroupNode) {
            final IGroupNode groupNode = (IGroupNode)viewNode;
            if (groupNode.isCollapsed()) {
                groupNode.setCollapsed(false);
            }
        }
    }
    
    public static void extractFolder(final bu bu, final q q) {
        final i m = bu.C().m(q);
        bu.C().a(m, new y(m.o()));
    }
    
    public static void extractGroup(final bu bu, final q q) {
        final x p2 = bu.C().p(q);
        while (p2.f()) {
            bu.C().c(p2.e(), bu.C().n(q));
            p2.g();
        }
    }
    
    public static boolean isExpanded(final IGroupNode groupNode) {
        return !groupNode.isCollapsed() && (groupNode.getParentGroup() == null || isExpanded(groupNode.getParentGroup()));
    }
}
