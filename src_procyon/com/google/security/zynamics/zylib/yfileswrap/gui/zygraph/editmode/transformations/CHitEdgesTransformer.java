package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import java.awt.event.*;
import y.h.*;
import y.c.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;

public class CHitEdgesTransformer
{
    public static IMouseStateChange changeEdge(final CStateFactory cStateFactory, final MouseEvent mouseEvent, final cW cw, final d d) {
        final d k = cw.k();
        if (k == d) {
            return new CStateChange(cStateFactory.createEdgeHoverState(k, mouseEvent), true);
        }
        cStateFactory.createEdgeExitState(d, mouseEvent);
        return new CStateChange(cStateFactory.createEdgeEnterState(k, mouseEvent), true);
    }
    
    public static IMouseStateChange enterEdge(final CStateFactory cStateFactory, final MouseEvent mouseEvent, final cW cw) {
        return new CStateChange(cStateFactory.createEdgeEnterState(cw.k(), mouseEvent), true);
    }
    
    public static IMouseStateChange exitEdge(final CStateFactory cStateFactory, final MouseEvent mouseEvent, final cW cw, final IMouseState mouseState) {
        if (cw.t()) {
            return CHitNodesTransformer.enterNode(cStateFactory, mouseEvent, cw);
        }
        if (cw.s()) {
            throw new IllegalStateException();
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
        return new CStateChange(cStateFactory.createDefaultState(), true);
    }
}
