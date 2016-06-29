/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedMiddleState;
import java.awt.event.MouseEvent;
import y.c.q;

public class CDefaultNodeClickedMiddleAction
implements IStateAction {
    public void execute(CNodeClickedMiddleState cNodeClickedMiddleState, MouseEvent mouseEvent) {
        CEditNodeHelper.setCaretStart(cNodeClickedMiddleState.getGraph(), cNodeClickedMiddleState.getNode(), mouseEvent);
        CEditNodeHelper.setCaretEnd(cNodeClickedMiddleState.getGraph(), cNodeClickedMiddleState.getNode(), mouseEvent);
    }
}

