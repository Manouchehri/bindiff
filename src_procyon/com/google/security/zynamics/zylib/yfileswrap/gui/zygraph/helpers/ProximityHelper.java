package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import y.c.*;

public class ProximityHelper
{
    public static ZyProximityNode getProximityNode(final bu bu, final q q) {
        return (ZyProximityNode)((IZyNodeRealizer)bu.t(q)).getUserData().getNode();
    }
    
    public static boolean isProximityEdge(final bu bu, final d d) {
        return isProximityNode(bu, d.c()) || isProximityNode(bu, d.d());
    }
    
    public static boolean isProximityNode(final bu bu, final q q) {
        return ((IZyNodeRealizer)bu.t(q)).getUserData().getNode() instanceof ZyProximityNode;
    }
}
