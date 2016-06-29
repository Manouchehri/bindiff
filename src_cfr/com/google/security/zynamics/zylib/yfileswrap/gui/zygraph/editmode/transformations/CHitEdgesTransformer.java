/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitBendsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgeLabelsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.c.d;
import y.h.cW;

public class CHitEdgesTransformer {
    public static IMouseStateChange changeEdge(CStateFactory cStateFactory, MouseEvent mouseEvent, cW cW2, d d2) {
        d d3 = cW2.k();
        if (d3 == d2) {
            return new CStateChange(cStateFactory.createEdgeHoverState(d3, mouseEvent), true);
        }
        cStateFactory.createEdgeExitState(d2, mouseEvent);
        return new CStateChange(cStateFactory.createEdgeEnterState(d3, mouseEvent), true);
    }

    public static IMouseStateChange enterEdge(CStateFactory cStateFactory, MouseEvent mouseEvent, cW cW2) {
        d d2 = cW2.k();
        return new CStateChange(cStateFactory.createEdgeEnterState(d2, mouseEvent), true);
    }

    public static IMouseStateChange exitEdge(CStateFactory cStateFactory, MouseEvent mouseEvent, cW cW2, IMouseState iMouseState) {
        if (cW2.t()) {
            return CHitNodesTransformer.enterNode(cStateFactory, mouseEvent, cW2);
        }
        if (cW2.s()) {
            throw new IllegalStateException();
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

