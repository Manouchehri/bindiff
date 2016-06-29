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
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgesTransformer;
import java.awt.event.MouseEvent;
import y.c.q;
import y.h.cW;

public final class CHitNodesTransformer {
    public static CStateChange changeNode(CStateFactory cStateFactory, MouseEvent mouseEvent, cW cW2, q q2) {
        q q3 = cW2.i();
        if (q3 == q2) {
            return new CStateChange(cStateFactory.createNodeHoverState(q3, mouseEvent), false);
        }
        cStateFactory.createNodeExitState(q2, mouseEvent);
        return new CStateChange(cStateFactory.createNodeEnterState(q3, mouseEvent), true);
    }

    public static IMouseStateChange enterNode(CStateFactory cStateFactory, MouseEvent mouseEvent, cW cW2) {
        q q2 = cW2.i();
        return new CStateChange(cStateFactory.createNodeEnterState(q2, mouseEvent), true);
    }

    public static IMouseStateChange exitNode(CStateFactory cStateFactory, MouseEvent mouseEvent, cW cW2, IMouseState iMouseState) {
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
        if (!cW2.q()) return new CStateChange(cStateFactory.createDefaultState(), false);
        return new CStateChange(iMouseState, true);
    }
}

