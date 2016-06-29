/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitBendsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgeLabelsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgesTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.h.bu;
import y.h.cW;

public class CHitBackgroundTransformer {
    public static IMouseStateChange exitBackground(CStateFactory cStateFactory, MouseEvent mouseEvent, AbstractZyGraph abstractZyGraph, IMouseState iMouseState) {
        double d2 = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        double d3 = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        cW cW2 = abstractZyGraph.getGraph().b(d2, d3);
        if (cW2.t()) {
            return CHitNodesTransformer.enterNode(cStateFactory, mouseEvent, cW2);
        }
        if (cW2.s()) {
            throw new IllegalStateException();
        }
        if (cW2.u()) {
            return CHitEdgesTransformer.enterEdge(cStateFactory, mouseEvent, cW2);
        }
        if (cW2.r()) {
            return CHitEdgeLabelsTransformer.enterEdgeLabel(cStateFactory, mouseEvent, cW2);
        }
        if (cW2.v()) {
            return CHitBendsTransformer.enterBend(cStateFactory, mouseEvent, cW2);
        }
        if (!cW2.q()) return new CStateChange(cStateFactory.createDefaultState(), true);
        return new CStateChange(iMouseState, true);
    }
}

