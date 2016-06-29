/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.LayoutFunctions$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.ILayoutSettings;
import java.util.Collection;
import y.f.P;
import y.f.V;
import y.f.X;
import y.f.a.a;
import y.f.aE;
import y.f.aF;
import y.f.ad;
import y.f.ae;
import y.f.ah;
import y.f.aw;
import y.f.b;
import y.f.c;
import y.g.q;
import y.h.O;
import y.h.bu;
import y.h.cd;
import y.h.ch;
import y.h.dj;
import y.h.fk;

public class LayoutFunctions {
    public static final int PREFERRED_ANIMATION_TIME_CONSTANT_FACTOR_MS = 100;

    public static y.f.O doLayout(AbstractZyGraph abstractZyGraph, c c2) {
        Preconditions.checkNotNull(c2, "Internal Error: Can not layout the graph without initializing the layouter first");
        y.f.O o2 = null;
        ILayoutSettings iLayoutSettings = abstractZyGraph.getSettings().getLayoutSettings();
        if (iLayoutSettings.getCurrentLayouter().h() == 0) {
            abstractZyGraph.getGraph().a(aF.a, q.a(aE.a(2)));
            abstractZyGraph.getGraph().a(aF.b, q.a(aE.a(1)));
        }
        if (iLayoutSettings.getCurrentLayouter().h() == 1) {
            abstractZyGraph.getGraph().a(aF.a, q.a(aE.a(4)));
            abstractZyGraph.getGraph().a(aF.b, q.a(aE.a(8)));
        }
        c2.c(new V());
        c2.c(true);
        if (abstractZyGraph.getNodes().size() < iLayoutSettings.getAnimateLayoutNodeThreshold() && abstractZyGraph.getEdges().size() < iLayoutSettings.getAnimateLayoutEdgeThreshold()) {
            if (abstractZyGraph.getSettings().getLayoutSettings().getAnimateLayout()) {
                ((O)abstractZyGraph.getView().getGraph2DRenderer()).setDrawEdgesFirst(true);
                o2 = new b(c2).b(abstractZyGraph.getGraph());
                dj dj2 = new dj();
                dj2.setSmoothViewTransform(true);
                dj2.setPreferredDuration(100 * abstractZyGraph.getSettings().getDisplaySettings().getAnimationSpeed());
                y.f.O o3 = o2;
                new LayoutFunctions$1(dj2, abstractZyGraph, o3).invokeLater();
                LayoutFunctions.recalculatePorts(c2, abstractZyGraph.getGraph());
                return o2;
            }
            o2 = new b(c2).b(abstractZyGraph.getGraph());
            ae.a((X)abstractZyGraph.getGraph(), o2);
            LayoutFunctions.recalculatePorts(c2, abstractZyGraph.getGraph());
            return o2;
        }
        o2 = new b(c2).b(abstractZyGraph.getGraph());
        ae.a((X)abstractZyGraph.getGraph(), o2);
        dj dj3 = new dj();
        dj3.setPreferredDuration(100 * abstractZyGraph.getSettings().getDisplaySettings().getAnimationSpeed());
        dj3.execute(abstractZyGraph.getView(), o2);
        return o2;
    }

    public static void recalculatePorts(c c2, bu bu2) {
        if (!(c2 instanceof a)) return;
        ae.d(bu2);
        aw aw2 = new aw();
        fk fk2 = new fk(bu2, true);
        bu2.a(P.a, fk2);
        fk fk3 = new fk(bu2, false);
        bu2.a(P.b, fk3);
        aw2.c(bu2);
    }
}

