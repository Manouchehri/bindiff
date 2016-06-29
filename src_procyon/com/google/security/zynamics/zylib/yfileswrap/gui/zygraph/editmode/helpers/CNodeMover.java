package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import y.c.*;
import y.h.*;

public class CNodeMover
{
    public static boolean isDraggedFar(final double n, final double n2, final double n3, final double n4) {
        final double n5 = n - n3;
        final double n6 = n2 - n4;
        return Math.abs(n5) > 15.0 || Math.abs(n6) > 15.0;
    }
    
    public static void moveNode(final AbstractZyGraph abstractZyGraph, final ZyGraphNode zyGraphNode, final double n, final double n2, final Set set) {
        abstractZyGraph.getGraph().t(zyGraphNode.getNode()).moveBy(n, n2);
        final e j = zyGraphNode.getNode().j();
        while (j.f()) {
            final y bends = abstractZyGraph.getGraph().i(j.a()).bends();
            while (bends.f()) {
                final x a = bends.a();
                if (!set.contains(a)) {
                    a.b(n, n2);
                    set.add(a);
                }
                bends.g();
            }
            j.g();
        }
    }
}
