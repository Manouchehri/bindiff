/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import y.c.d;
import y.c.q;
import y.h.bu;
import y.h.cW;
import y.h.x;

public class CMousePressedHandler {
    public static IMouseStateChange handleMousePressed(CStateFactory cStateFactory, IMouseState iMouseState, AbstractZyGraph abstractZyGraph, MouseEvent mouseEvent) {
        double d2 = abstractZyGraph.getEditMode().translateX(mouseEvent.getX());
        double d3 = abstractZyGraph.getEditMode().translateY(mouseEvent.getY());
        cW cW2 = abstractZyGraph.getGraph().b(d2, d3);
        if (cW2.t()) {
            q q2 = cW2.i();
            if (SwingUtilities.isLeftMouseButton(mouseEvent) && !mouseEvent.isAltDown()) {
                return new CStateChange(cStateFactory.createNodePressedLeftState(q2, mouseEvent), true);
            }
            if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                return new CStateChange(cStateFactory.createNodePressedRightState(q2, mouseEvent), true);
            }
            if (SwingUtilities.isMiddleMouseButton(mouseEvent)) return new CStateChange(cStateFactory.createNodePressedMiddleState(q2, mouseEvent), false);
            if (!mouseEvent.isAltDown()) return new CStateChange(iMouseState, true);
            if (!SwingUtilities.isLeftMouseButton(mouseEvent)) return new CStateChange(iMouseState, true);
            return new CStateChange(cStateFactory.createNodePressedMiddleState(q2, mouseEvent), false);
        }
        if (cW2.s()) {
            throw new IllegalStateException("yFiles Labels are not in use...");
        }
        if (cW2.u()) {
            d d4 = cW2.k();
            if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
                return new CStateChange(cStateFactory.createEdgePressedLeftState(d4, mouseEvent), true);
            }
            if (!SwingUtilities.isRightMouseButton(mouseEvent)) return new CStateChange(iMouseState, true);
            return new CStateChange(cStateFactory.createEdgePressedRightState(d4, mouseEvent), true);
        }
        if (cW2.r()) {
            return new CStateChange(iMouseState, true);
        }
        if (cW2.v()) {
            x x2 = cW2.j();
            if (!SwingUtilities.isLeftMouseButton(mouseEvent)) return new CStateChange(iMouseState, true);
            return new CStateChange(cStateFactory.createBendPressedLeftState(x2, mouseEvent), true);
        }
        if (cW2.q()) {
            return new CStateChange(cStateFactory.createDefaultState(), true);
        }
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            return new CStateChange(cStateFactory.createBackgroundPressedLeftState(mouseEvent), true);
        }
        if (!SwingUtilities.isRightMouseButton(mouseEvent)) return new CStateChange(cStateFactory.createDefaultState(), true);
        return new CStateChange(cStateFactory.createBackgroundPressedRightState(mouseEvent), true);
    }
}

