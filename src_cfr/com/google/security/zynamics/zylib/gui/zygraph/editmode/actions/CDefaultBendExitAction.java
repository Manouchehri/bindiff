/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CBendExitState;
import java.awt.event.MouseEvent;

public class CDefaultBendExitAction
implements IStateAction {
    public void execute(CBendExitState cBendExitState, MouseEvent mouseEvent) {
        CMouseCursorHelper.setDefaultCursor(cBendExitState.getGraph());
    }
}

