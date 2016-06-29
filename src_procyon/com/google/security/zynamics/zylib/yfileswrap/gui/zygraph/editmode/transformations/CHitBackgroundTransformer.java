package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import y.h.*;

public class CHitBackgroundTransformer
{
    public static IMouseStateChange exitBackground(final CStateFactory cStateFactory, final MouseEvent mouseEvent, final AbstractZyGraph abstractZyGraph, final IMouseState mouseState) {
        final cW b = abstractZyGraph.getGraph().b(abstractZyGraph.getEditMode().translateX(mouseEvent.getX()), abstractZyGraph.getEditMode().translateY(mouseEvent.getY()));
        if (b.t()) {
            return CHitNodesTransformer.enterNode(cStateFactory, mouseEvent, b);
        }
        if (b.s()) {
            throw new IllegalStateException();
        }
        if (b.u()) {
            return CHitEdgesTransformer.enterEdge(cStateFactory, mouseEvent, b);
        }
        if (b.r()) {
            return CHitEdgeLabelsTransformer.enterEdgeLabel(cStateFactory, mouseEvent, b);
        }
        if (b.v()) {
            return CHitBendsTransformer.enterBend(cStateFactory, mouseEvent, b);
        }
        if (b.q()) {
            return new CStateChange(mouseState, true);
        }
        return new CStateChange(cStateFactory.createDefaultState(), true);
    }
}
