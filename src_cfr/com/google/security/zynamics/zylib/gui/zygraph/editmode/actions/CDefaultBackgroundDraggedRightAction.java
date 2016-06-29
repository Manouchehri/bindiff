/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.CBackgroundDraggedRightState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.awt.event.MouseEvent;

public class CDefaultBackgroundDraggedRightAction
implements IStateAction {
    public void execute(CBackgroundDraggedRightState cBackgroundDraggedRightState, MouseEvent mouseEvent) {
        CMouseCursorHelper.setMoveCursor(cBackgroundDraggedRightState.getGraph());
    }
}

