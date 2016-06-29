/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.grouping;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.a.v;
import y.h.bu;

public class GroupHelpers {
    public static void expandParents(IViewNode iViewNode) {
        if (iViewNode.getParentGroup() != null) {
            GroupHelpers.expandParents(iViewNode.getParentGroup());
        }
        if (!(iViewNode instanceof IGroupNode)) return;
        IGroupNode iGroupNode = (IGroupNode)iViewNode;
        if (!iGroupNode.isCollapsed()) return;
        iGroupNode.setCollapsed(false);
    }

    public static void extractFolder(bu bu2, q q2) {
        i i2 = bu2.C().m(q2);
        y y2 = new y(i2.o());
        bu2.C().a(i2, y2);
    }

    public static void extractGroup(bu bu2, q q2) {
        x x2 = bu2.C().p(q2);
        while (x2.f()) {
            bu2.C().c(x2.e(), bu2.C().n(q2));
            x2.g();
        }
    }

    public static boolean isExpanded(IGroupNode iGroupNode) {
        if (iGroupNode.isCollapsed()) return false;
        if (iGroupNode.getParentGroup() == null) return true;
        if (!GroupHelpers.isExpanded(iGroupNode.getParentGroup())) return false;
        return true;
    }
}

