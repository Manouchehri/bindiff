/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import y.c.d;
import y.c.q;
import y.h.bu;
import y.h.fj;

public class ProximityHelper {
    public static ZyProximityNode getProximityNode(bu bu2, q q2) {
        IZyNodeRealizer iZyNodeRealizer = (IZyNodeRealizer)((Object)bu2.t(q2));
        return (ZyProximityNode)iZyNodeRealizer.getUserData().getNode();
    }

    public static boolean isProximityEdge(bu bu2, d d2) {
        if (ProximityHelper.isProximityNode(bu2, d2.c())) return true;
        if (ProximityHelper.isProximityNode(bu2, d2.d())) return true;
        return false;
    }

    public static boolean isProximityNode(bu bu2, q q2) {
        IZyNodeRealizer iZyNodeRealizer = (IZyNodeRealizer)((Object)bu2.t(q2));
        return iZyNodeRealizer.getUserData().getNode() instanceof ZyProximityNode;
    }
}

