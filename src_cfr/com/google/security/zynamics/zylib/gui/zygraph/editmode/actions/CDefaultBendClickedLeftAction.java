/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CBendClickedLeftState;
import java.awt.event.MouseEvent;

public class CDefaultBendClickedLeftAction
implements IStateAction {
    public void execute(CBendClickedLeftState cBendClickedLeftState, MouseEvent mouseEvent) {
        CMouseCursorHelper.setDefaultCursor(cBendClickedLeftState.getGraph());
    }
}

