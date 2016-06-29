/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeEditExitState;
import java.awt.event.MouseEvent;

public class CDefaultNodeEditExitAction
implements IStateAction {
    public void execute(CNodeEditExitState cNodeEditExitState, MouseEvent mouseEvent) {
        CEditNodeHelper.removeCaret(cNodeEditExitState.getGraph());
    }
}

