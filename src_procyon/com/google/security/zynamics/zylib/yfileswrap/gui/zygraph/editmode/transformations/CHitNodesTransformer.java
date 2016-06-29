package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import java.awt.event.*;
import y.h.*;
import y.c.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;

public final class CHitNodesTransformer
{
    public static CStateChange changeNode(final CStateFactory cStateFactory, final MouseEvent mouseEvent, final cW cw, final q q) {
        final q i = cw.i();
        if (i == q) {
            return new CStateChange(cStateFactory.createNodeHoverState(i, mouseEvent), false);
        }
        cStateFactory.createNodeExitState(q, mouseEvent);
        return new CStateChange(cStateFactory.createNodeEnterState(i, mouseEvent), true);
    }
    
    public static IMouseStateChange enterNode(final CStateFactory cStateFactory, final MouseEvent mouseEvent, final cW cw) {
        return new CStateChange(cStateFactory.createNodeEnterState(cw.i(), mouseEvent), true);
    }
    
    public static IMouseStateChange exitNode(final CStateFactory cStateFactory, final MouseEvent mouseEvent, final cW cw, final IMouseState mouseState) {
        if (cw.s()) {
            throw new IllegalStateException();
        }
        if (cw.u()) {
            return CHitEdgesTransformer.enterEdge(cStateFactory, mouseEvent, cw);
        }
        if (cw.r()) {
            return CHitEdgeLabelsTransformer.enterEdgeLabel(cStateFactory, mouseEvent, cw);
        }
        if (cw.v()) {
            return CHitBendsTransformer.enterBend(cStateFactory, mouseEvent, cw);
        }
        if (cw.q()) {
            return new CStateChange(mouseState, true);
        }
        return new CStateChange(cStateFactory.createDefaultState(), false);
    }
}
