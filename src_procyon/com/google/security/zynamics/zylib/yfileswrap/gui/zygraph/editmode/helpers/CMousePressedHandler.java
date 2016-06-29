package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.awt.event.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import y.c.*;
import y.h.*;

public class CMousePressedHandler
{
    public static IMouseStateChange handleMousePressed(final CStateFactory cStateFactory, final IMouseState mouseState, final AbstractZyGraph abstractZyGraph, final MouseEvent mouseEvent) {
        final cW b = abstractZyGraph.getGraph().b(abstractZyGraph.getEditMode().translateX(mouseEvent.getX()), abstractZyGraph.getEditMode().translateY(mouseEvent.getY()));
        if (b.t()) {
            final q i = b.i();
            if (SwingUtilities.isLeftMouseButton(mouseEvent) && !mouseEvent.isAltDown()) {
                return new CStateChange(cStateFactory.createNodePressedLeftState(i, mouseEvent), true);
            }
            if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                return new CStateChange(cStateFactory.createNodePressedRightState(i, mouseEvent), true);
            }
            if (SwingUtilities.isMiddleMouseButton(mouseEvent) || (mouseEvent.isAltDown() && SwingUtilities.isLeftMouseButton(mouseEvent))) {
                return new CStateChange(cStateFactory.createNodePressedMiddleState(i, mouseEvent), false);
            }
            return new CStateChange(mouseState, true);
        }
        else {
            if (b.s()) {
                throw new IllegalStateException("yFiles Labels are not in use...");
            }
            if (b.u()) {
                final d k = b.k();
                if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
                    return new CStateChange(cStateFactory.createEdgePressedLeftState(k, mouseEvent), true);
                }
                if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                    return new CStateChange(cStateFactory.createEdgePressedRightState(k, mouseEvent), true);
                }
                return new CStateChange(mouseState, true);
            }
            else {
                if (b.r()) {
                    return new CStateChange(mouseState, true);
                }
                if (b.v()) {
                    final x j = b.j();
                    if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
                        return new CStateChange(cStateFactory.createBendPressedLeftState(j, mouseEvent), true);
                    }
                    return new CStateChange(mouseState, true);
                }
                else {
                    if (b.q()) {
                        return new CStateChange(cStateFactory.createDefaultState(), true);
                    }
                    if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
                        return new CStateChange(cStateFactory.createBackgroundPressedLeftState(mouseEvent), true);
                    }
                    if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                        return new CStateChange(cStateFactory.createBackgroundPressedRightState(mouseEvent), true);
                    }
                    return new CStateChange(cStateFactory.createDefaultState(), true);
                }
            }
        }
    }
}
