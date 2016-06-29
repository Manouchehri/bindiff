package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.common.base.*;
import y.g.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.*;
import y.f.a.*;
import y.f.*;
import y.h.*;

public class LayoutFunctions
{
    public static final int PREFERRED_ANIMATION_TIME_CONSTANT_FACTOR_MS = 100;
    
    public static O doLayout(final AbstractZyGraph abstractZyGraph, final c c) {
        Preconditions.checkNotNull(c, (Object)"Internal Error: Can not layout the graph without initializing the layouter first");
        final ILayoutSettings layoutSettings = abstractZyGraph.getSettings().getLayoutSettings();
        if (layoutSettings.getCurrentLayouter().h() == 0) {
            abstractZyGraph.getGraph().a(aF.a, q.a(aE.a((byte)2)));
            abstractZyGraph.getGraph().a(aF.b, q.a(aE.a((byte)1)));
        }
        if (layoutSettings.getCurrentLayouter().h() == 1) {
            abstractZyGraph.getGraph().a(aF.a, q.a(aE.a((byte)4)));
            abstractZyGraph.getGraph().a(aF.b, q.a(aE.a((byte)8)));
        }
        c.c(new V());
        c.c(true);
        O o;
        if (abstractZyGraph.getNodes().size() < layoutSettings.getAnimateLayoutNodeThreshold() && abstractZyGraph.getEdges().size() < layoutSettings.getAnimateLayoutEdgeThreshold()) {
            if (abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout()) {
                ((y.h.O)abstractZyGraph.getView().getGraph2DRenderer()).setDrawEdgesFirst(true);
                o = new b(c).b(abstractZyGraph.getGraph());
                final dj dj = new dj();
                dj.setSmoothViewTransform(true);
                dj.setPreferredDuration(100 * abstractZyGraph.getSettings().getDisplaySettings().getAnimationSpeed());
                new LayoutFunctions$1(dj, abstractZyGraph, o).invokeLater();
                recalculatePorts(c, abstractZyGraph.getGraph());
            }
            else {
                o = new b(c).b(abstractZyGraph.getGraph());
                ae.a(abstractZyGraph.getGraph(), o);
                recalculatePorts(c, abstractZyGraph.getGraph());
            }
        }
        else {
            o = new b(c).b(abstractZyGraph.getGraph());
            ae.a(abstractZyGraph.getGraph(), o);
            final dj dj2 = new dj();
            dj2.setPreferredDuration(100 * abstractZyGraph.getSettings().getDisplaySettings().getAnimationSpeed());
            dj2.execute(abstractZyGraph.getView(), o);
        }
        return o;
    }
    
    public static void recalculatePorts(final c c, final bu bu) {
        if (c instanceof a) {
            ae.d(bu);
            final aw aw = new aw();
            bu.a(P.a, new fk(bu, true));
            bu.a(P.b, new fk(bu, false));
            aw.c(bu);
        }
    }
}
